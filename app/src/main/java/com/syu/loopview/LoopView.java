package com.syu.loopview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoopView extends View {
    private static final float DEFAULT_LINE_SPACE = 1.0f;
    private static final int DEFAULT_VISIBLE_ITEMS = 9;
    public static final int SCROLL_STATE_DRAGGING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SCROLLING = 3;
    public static final int SCROLL_STATE_SETTING = 1;
    int centerTextColor;
    int change;
    private Context context;
    int currentScrollState;
    int dividerColor;
    HashMap<Integer, IndexString> drawingStrings;
    int firstLineY;
    private GestureDetector flingGestureDetector;
    int halfCircumference;
    Handler handler;
    int initPosition;
    private boolean isEnableCurve;
    boolean isLoop;
    int itemTextHeight;
    List<IndexString> items;
    int itemsVisibleCount;
    int lastScrollState;
    float lineSpacingMultiplier;
    ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mOffset;
    OnItemScrollListener mOnItemScrollListener;
    int measuredHeight;
    int measuredWidth;
    OnItemSelectedListener onItemSelectedListener;
    int outerTextColor;
    private int paddingLeft;
    private int paddingRight;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    int preCurrentIndex;
    private float previousY;
    int radius;
    private float scaleX;
    int secondLineY;
    long startTime;
    private Rect tempRect;
    int textHeight;
    int textSize;
    int totalScrollY;
    private Typeface typeface;
    private static final int DEFAULT_TEXT_SIZE = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
    private static boolean ENABLE_CURVE = true;

    public enum ACTION {
        CLICK,
        FLING,
        DRAG;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ACTION[] valuesCustom() {
            ACTION[] valuesCustom = values();
            int length = valuesCustom.length;
            ACTION[] actionArr = new ACTION[length];
            System.arraycopy(valuesCustom, 0, actionArr, 0, length);
            return actionArr;
        }
    }

    public void setLineSpacingMultiplier(float lineSpacingMultiplier) {
        if (lineSpacingMultiplier > DEFAULT_LINE_SPACE) {
            this.lineSpacingMultiplier = lineSpacingMultiplier;
        }
    }

    public void setCenterTextColor(int centerTextColor) {
        this.centerTextColor = centerTextColor;
        if (this.paintCenterText != null) {
            this.paintCenterText.setColor(centerTextColor);
        }
    }

    public void setOuterTextColor(int outerTextColor) {
        this.outerTextColor = outerTextColor;
        if (this.paintOuterText != null) {
            this.paintOuterText.setColor(outerTextColor);
        }
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        if (this.paintIndicator != null) {
            this.paintIndicator.setColor(dividerColor);
        }
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public LoopView(Context context) {
        super(context);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, null);
    }

    public LoopView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, attributeset);
    }

    public LoopView(Context context, AttributeSet attributeset, int defStyleAttr) {
        super(context, attributeset, defStyleAttr);
        this.scaleX = 1.05f;
        this.lastScrollState = 0;
        this.currentScrollState = 1;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mOffset = 0;
        this.startTime = 0L;
        this.tempRect = new Rect();
        this.typeface = Typeface.MONOSPACE;
        this.isEnableCurve = ENABLE_CURVE;
        initLoopView(context, attributeset);
    }

    private void initLoopView(Context context, AttributeSet attributeset) {
        this.context = context;
        this.handler = new MessageHandler(this);
        this.flingGestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.flingGestureDetector.setIsLongpressEnabled(false);
        TypedArray typedArray = context.obtainStyledAttributes(attributeset, R.styleable.LoopView);
        if (typedArray != null) {
            this.textSize = typedArray.getInteger(0, DEFAULT_TEXT_SIZE);
            this.textSize = (int) (Resources.getSystem().getDisplayMetrics().density * this.textSize);
            this.lineSpacingMultiplier = typedArray.getFloat(1, DEFAULT_LINE_SPACE);
            this.centerTextColor = typedArray.getInteger(2, -1);
            this.outerTextColor = typedArray.getInteger(3, -7500403);
            this.dividerColor = typedArray.getInteger(4, 0);
            this.itemsVisibleCount = typedArray.getInteger(5, 9);
            if (this.itemsVisibleCount % 2 == 0) {
                this.itemsVisibleCount = 9;
            }
            this.isLoop = typedArray.getBoolean(6, true);
            this.isEnableCurve = typedArray.getBoolean(7, ENABLE_CURVE);
            typedArray.recycle();
        }
        this.drawingStrings = new HashMap<>();
        this.totalScrollY = 0;
        this.initPosition = -1;
        initPaintsIfPossible();
    }

    public void setItemsVisibleCount(int visibleNumber) {
        if (visibleNumber % 2 != 0 && visibleNumber != this.itemsVisibleCount) {
            this.itemsVisibleCount = visibleNumber;
            this.drawingStrings = new HashMap<>();
        }
    }

    private void initPaintsIfPossible() {
        if (this.paintOuterText == null) {
            this.paintOuterText = new Paint();
            this.paintOuterText.setColor(this.outerTextColor);
            this.paintOuterText.setAntiAlias(true);
            this.paintOuterText.setTypeface(this.typeface);
            this.paintOuterText.setTextSize(this.textSize);
        }
        if (this.paintCenterText == null) {
            this.paintCenterText = new Paint();
            this.paintCenterText.setColor(this.centerTextColor);
            this.paintCenterText.setAntiAlias(true);
            this.paintCenterText.setTextScaleX(this.scaleX);
            this.paintCenterText.setTypeface(this.typeface);
            this.paintCenterText.setTextSize(this.textSize);
        }
        if (this.paintIndicator == null) {
            this.paintIndicator = new Paint();
            this.paintIndicator.setColor(this.dividerColor);
            this.paintIndicator.setAntiAlias(true);
        }
    }

    private void remeasure() {
        if (this.items != null && !this.items.isEmpty()) {
            this.measuredWidth = getMeasuredWidth();
            this.measuredHeight = getMeasuredHeight();
            if (this.measuredWidth != 0 && this.measuredHeight != 0) {
                this.paddingLeft = getPaddingLeft();
                this.paddingRight = getPaddingRight();
                this.measuredWidth -= this.paddingRight;
                this.paintCenterText.getTextBounds("星期", 0, 2, this.tempRect);
                this.textHeight = this.tempRect.height();
                this.halfCircumference = (int) ((this.measuredHeight * 3.141592653589793d) / 2.0d);
                if (this.isEnableCurve) {
                    this.itemTextHeight = (int) (this.halfCircumference / (this.lineSpacingMultiplier * (this.itemsVisibleCount - 1)));
                } else {
                    this.itemTextHeight = this.measuredHeight / this.itemsVisibleCount;
                }
                this.radius = this.measuredHeight / 2;
                this.firstLineY = (int) ((this.measuredHeight - (this.lineSpacingMultiplier * this.itemTextHeight)) / 2.0f);
                this.secondLineY = (int) ((this.measuredHeight + (this.lineSpacingMultiplier * this.itemTextHeight)) / 2.0f);
                if (this.initPosition == -1) {
                    if (this.isLoop) {
                        this.initPosition = (this.items.size() + 1) / 2;
                    } else {
                        this.initPosition = 0;
                    }
                }
                this.preCurrentIndex = this.initPosition;
            }
        }
    }

    void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DRAG) {
            float itemHeight = this.lineSpacingMultiplier * this.itemTextHeight;
            this.mOffset = (int) (((this.totalScrollY % itemHeight) + itemHeight) % itemHeight);
            if (this.mOffset > itemHeight / 2.0f) {
                this.mOffset = (int) (itemHeight - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
        changeScrollState(3);
    }

    protected final void scrollBy(float velocityY) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, velocityY), 0L, 10, TimeUnit.MILLISECONDS);
        changeScrollState(2);
    }

    public void cancelFuture() {
        if (this.mFuture != null && !this.mFuture.isCancelled()) {
            this.mFuture.cancel(true);
            this.mFuture = null;
            changeScrollState(0);
        }
    }

    private void printMethodStackTrace(String methodName) {
        StackTraceElement[] invokers = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("printMethodStackTrace ");
        sb.append(methodName);
        sb.append(" ");
        for (int i = invokers.length - 1; i >= 4; i--) {
            StackTraceElement invoker = invokers[i];
            sb.append(String.format("%s(%d).%s", invoker.getFileName(), Integer.valueOf(invoker.getLineNumber()), invoker.getMethodName()));
            if (i > 4) {
                sb.append("-->");
            }
        }
    }

    private void changeScrollState(int scrollState) {
        if (scrollState != this.currentScrollState && !this.handler.hasMessages(MessageHandler.WHAT_SMOOTH_SCROLL_INERTIA)) {
            this.lastScrollState = this.currentScrollState;
            this.currentScrollState = scrollState;
        }
    }

    public void setNotLoop() {
        this.isLoop = false;
    }

    public final void setCenterTextSize(float size) {
        if (size > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * size);
            if (this.paintCenterText != null) {
                this.paintCenterText.setTextSize(this.textSize);
            }
        }
    }

    public final void setOuterTextSize(float size) {
        if (size > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * size);
            if (this.paintOuterText != null) {
                this.paintOuterText.setTextSize(this.textSize);
            }
        }
    }

    public final void setInitPosition(int initPosition) {
        if (initPosition < 0) {
            this.initPosition = 0;
        } else if (this.items != null && this.items.size() > initPosition) {
            this.initPosition = initPosition;
        }
    }

    public final void setListener(OnItemSelectedListener OnItemSelectedListener) {
        this.onItemSelectedListener = OnItemSelectedListener;
    }

    public final void setOnItemScrollListener(OnItemScrollListener mOnItemScrollListener) {
        this.mOnItemScrollListener = mOnItemScrollListener;
    }

    public final void setItems(List<String> items) {
        this.items = convertData(items);
        remeasure();
        invalidate();
    }

    public List<IndexString> convertData(List<String> items) {
        List<IndexString> data = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            data.add(new IndexString(i, items.get(i)));
        }
        return data;
    }

    public final int getSelectedItem() {
        return this.preCurrentIndex;
    }

    protected final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new OnItemSelectedRunnable(this), 200L);
        }
    }

    @Override
    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public void setCurrentPosition(int position) {
        if (this.items != null && !this.items.isEmpty()) {
            int size = this.items.size();
            if (position >= 0 && position < size && position != getSelectedItem()) {
                this.initPosition = position;
                this.totalScrollY = 0;
                this.mOffset = 0;
                changeScrollState(1);
                remeasure();
                this.handler.sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
                invalidate();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int translateY;
        super.onDraw(canvas);
        if (this.items != null && !this.items.isEmpty()) {
            this.change = (int) (this.totalScrollY / (this.lineSpacingMultiplier * this.itemTextHeight));
            this.preCurrentIndex = this.initPosition + (this.change % this.items.size());
            if (!this.isLoop) {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = 0;
                }
                if (this.preCurrentIndex > this.items.size() - 1) {
                    this.preCurrentIndex = this.items.size() - 1;
                }
            } else {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = this.items.size() + this.preCurrentIndex;
                }
                if (this.preCurrentIndex > this.items.size() - 1) {
                    this.preCurrentIndex -= this.items.size();
                }
            }
            int j2 = this.totalScrollY % this.itemTextHeight;
            for (int k1 = 0; k1 < this.itemsVisibleCount; k1++) {
                int l1 = this.preCurrentIndex - ((this.itemsVisibleCount / 2) - k1);
                if (this.isLoop) {
                    while (l1 < 0) {
                        l1 += this.items.size();
                    }
                    while (l1 > this.items.size() - 1) {
                        l1 -= this.items.size();
                    }
                    this.drawingStrings.put(Integer.valueOf(k1), this.items.get(l1));
                } else if (l1 < 0) {
                    this.drawingStrings.put(Integer.valueOf(k1), new IndexString());
                } else if (l1 > this.items.size() - 1) {
                    this.drawingStrings.put(Integer.valueOf(k1), new IndexString());
                } else {
                    this.drawingStrings.put(Integer.valueOf(k1), this.items.get(l1));
                }
            }
            canvas.drawLine(this.paddingLeft, this.firstLineY, this.measuredWidth, this.firstLineY, this.paintIndicator);
            canvas.drawLine(this.paddingLeft, this.secondLineY, this.measuredWidth, this.secondLineY, this.paintIndicator);
            for (int i = 0; i < this.itemsVisibleCount; i++) {
                canvas.save();
                float itemHeight = this.itemTextHeight * this.lineSpacingMultiplier;
                double radian = (((i * itemHeight) - j2) * 3.141592653589793d) / this.halfCircumference;
                if ((radian >= 3.141592653589793d || radian <= 0.0d) && this.isEnableCurve) {
                    canvas.restore();
                } else {
                    if (this.isEnableCurve) {
                        translateY = (int) ((this.radius - (Math.cos(radian) * this.radius)) - ((Math.sin(radian) * this.itemTextHeight) / 2.0d));
                    } else {
                        translateY = (int) ((i * itemHeight) - j2);
                        Log.d("weigan", "translateY " + translateY + " pos " + i + " j2 " + j2);
                    }
                    canvas.translate(0.0f, translateY);
                    if (this.isEnableCurve) {
                        canvas.scale(DEFAULT_LINE_SPACE, (float) Math.sin(radian));
                    }
                    if (translateY <= this.firstLineY && this.itemTextHeight + translateY >= this.firstLineY) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, this.firstLineY - translateY);
                        drawOuterText(canvas, i);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.firstLineY - translateY, this.measuredWidth, (int) itemHeight);
                        drawCenterText(canvas, i);
                        canvas.restore();
                    } else if (translateY <= this.secondLineY && this.itemTextHeight + translateY >= this.secondLineY) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, this.secondLineY - translateY);
                        drawCenterText(canvas, i);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.secondLineY - translateY, this.measuredWidth, (int) itemHeight);
                        drawOuterText(canvas, i);
                        canvas.restore();
                    } else if (translateY >= this.firstLineY && this.itemTextHeight + translateY <= this.secondLineY) {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) itemHeight);
                        drawCenterText(canvas, i);
                    } else {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) itemHeight);
                        drawOuterText(canvas, i);
                    }
                    canvas.restore();
                }
            }
            if (this.currentScrollState != this.lastScrollState) {
                int oldScrollState = this.lastScrollState;
                this.lastScrollState = this.currentScrollState;
                if (this.mOnItemScrollListener != null) {
                    this.mOnItemScrollListener.onItemScrollStateChanged(this, getSelectedItem(), oldScrollState, this.currentScrollState, this.totalScrollY);
                }
            }
            if ((this.currentScrollState == 2 || this.currentScrollState == 3) && this.mOnItemScrollListener != null) {
                this.mOnItemScrollListener.onItemScrolling(this, getSelectedItem(), this.currentScrollState, this.totalScrollY);
            }
        }
    }

    private void drawOuterText(Canvas canvas, int position) {
        canvas.drawText(this.drawingStrings.get(Integer.valueOf(position)).string, getTextX(this.drawingStrings.get(Integer.valueOf(position)).string, this.paintOuterText, this.tempRect), getDrawingY(), this.paintOuterText);
    }

    private void drawCenterText(Canvas canvas, int position) {
        canvas.drawText(this.drawingStrings.get(Integer.valueOf(position)).string, getTextX(this.drawingStrings.get(Integer.valueOf(position)).string, this.paintOuterText, this.tempRect), getDrawingY(), this.paintCenterText);
    }

    private int getDrawingY() {
        return this.itemTextHeight > this.textHeight ? this.itemTextHeight - ((this.itemTextHeight - this.textHeight) / 2) : this.itemTextHeight;
    }

    private int getTextX(String a, Paint paint, Rect rect) {
        paint.getTextBounds(a, 0, a.length(), rect);
        int textWidth = rect.width();
        return (((this.measuredWidth - this.paddingLeft) - ((int) (textWidth * this.scaleX))) / 2) + this.paddingLeft;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        remeasure();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean eventConsumed = this.flingGestureDetector.onTouchEvent(event);
        float itemHeight = this.lineSpacingMultiplier * this.itemTextHeight;
        switch (event.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                cancelFuture();
                this.previousY = event.getRawY();
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
            case 1:
            default:
                if (!eventConsumed) {
                    float y = event.getY();
                    double l = Math.acos((this.radius - y) / this.radius) * this.radius;
                    int circlePosition = (int) (((itemHeight / 2.0f) + l) / itemHeight);
                    float extraOffset = ((this.totalScrollY % itemHeight) + itemHeight) % itemHeight;
                    this.mOffset = (int) (((circlePosition - (this.itemsVisibleCount / 2)) * itemHeight) - extraOffset);
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        smoothScroll(ACTION.DRAG);
                    } else {
                        smoothScroll(ACTION.CLICK);
                    }
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
            case 2:
                float dy = this.previousY - event.getRawY();
                this.previousY = event.getRawY();
                this.totalScrollY = (int) (this.totalScrollY + dy);
                if (!this.isLoop) {
                    float top = (-this.initPosition) * itemHeight;
                    float bottom = ((this.items.size() - 1) - this.initPosition) * itemHeight;
                    if (this.totalScrollY < top) {
                        this.totalScrollY = (int) top;
                    } else if (this.totalScrollY > bottom) {
                        this.totalScrollY = (int) bottom;
                    }
                }
                changeScrollState(2);
                break;
        }
        invalidate();
        return true;
    }

    class IndexString {
        private int index;
        private String string;

        public IndexString() {
            this.string = "";
        }

        public IndexString(int index, String str) {
            this.index = index;
            this.string = str;
        }
    }
}
