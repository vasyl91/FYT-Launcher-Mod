package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    private final ArrayList<DisableLayerRunnable> mPostedRunnables;
    private boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    private float mSlideOffset;
    private int mSlideRange;
    private View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static {
        int deviceVersion = Build.VERSION.SDK_INT;
        if (deviceVersion >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else if (deviceVersion >= 16) {
            IMPL = new SlidingPanelLayoutImplJB();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View panel, float slideOffset) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View panel) {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View panel) {
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float density = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * density) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mDragHelper = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper.setMinVelocity(400.0f * density);
    }

    public void setParallaxDistance(int parallaxBy) {
        this.mParallaxBy = parallaxBy;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public void setSliderFadeColor(int color) {
        this.mSliderFadeColor = color;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void setCoveredFadeColor(int color) {
        this.mCoveredFadeColor = color;
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public void setPanelSlideListener(PanelSlideListener listener) {
        this.mPanelSlideListener = listener;
    }

    void dispatchOnPanelSlide(View panel) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(panel, this.mSlideOffset);
        }
    }

    void dispatchOnPanelOpened(View panel) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(panel);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelClosed(View panel) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(panel);
        }
        sendAccessibilityEvent(32);
    }

    void updateObscuredViewsVisibility(View panel) {
        int bottom;
        int top;
        int right;
        int left;
        int vis;
        boolean isLayoutRtl = isLayoutRtlSupport();
        int startBound = isLayoutRtl ? getWidth() - getPaddingRight() : getPaddingLeft();
        int endBound = isLayoutRtl ? getPaddingLeft() : getWidth() - getPaddingRight();
        int topBound = getPaddingTop();
        int bottomBound = getHeight() - getPaddingBottom();
        if (panel != null && viewIsOpaque(panel)) {
            left = panel.getLeft();
            right = panel.getRight();
            top = panel.getTop();
            bottom = panel.getBottom();
        } else {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child != panel) {
                int clampedChildLeft = Math.max(isLayoutRtl ? endBound : startBound, child.getLeft());
                int clampedChildTop = Math.max(topBound, child.getTop());
                int clampedChildRight = Math.min(isLayoutRtl ? startBound : endBound, child.getRight());
                int clampedChildBottom = Math.min(bottomBound, child.getBottom());
                if (clampedChildLeft >= left && clampedChildTop >= top && clampedChildRight <= right && clampedChildBottom <= bottom) {
                    vis = 4;
                } else {
                    vis = 0;
                }
                child.setVisibility(vis);
            } else {
                return;
            }
        }
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }

    private static boolean viewIsOpaque(View v) {
        Drawable bg;
        if (ViewCompat.isOpaque(v)) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (bg = v.getBackground()) != null && bg.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int count = this.mPostedRunnables.size();
        for (int i = 0; i < count; i++) {
            DisableLayerRunnable dlr = this.mPostedRunnables.get(i);
            dlr.run();
        }
        this.mPostedRunnables.clear();
    }

    /* JADX WARN: Code duplicated, block: B:126:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00df A[PHI: r23
  0x00df: PHI (r23v2 'weightSum' float) = (r23v1 'weightSum' float), (r23v3 'weightSum' float) binds: [B:34:0x00cd, B:36:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:42:0x0111  */
    /* JADX WARN: Code duplicated, block: B:50:0x013a  */
    /* JADX WARN: Code duplicated, block: B:53:0x014c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0152  */
    /* JADX WARN: Code duplicated, block: B:56:0x0160  */
    /* JADX WARN: Code duplicated, block: B:57:0x0169  */
    /* JADX WARN: Code duplicated, block: B:58:0x0176  */
    /* JADX WARN: Code duplicated, block: B:60:0x0184  */
    /* JADX WARN: Code duplicated, block: B:61:0x018f  */
    /* JADX WARN: Code duplicated, block: B:62:0x019c  */
    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childHeightSpec;
        int childHeightSpec2;
        int horizontalMargin;
        int childWidthSpec;
        int childHeightSpec3;
        int childHeight;
        boolean z;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode != 1073741824) {
            if (isInEditMode()) {
                if (widthMode != Integer.MIN_VALUE && widthMode == 0) {
                    widthSize = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (heightMode == 0) {
            if (isInEditMode()) {
                if (heightMode == 0) {
                    heightMode = ExploreByTouchHelper.INVALID_ID;
                    heightSize = 300;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
        int layoutHeight = 0;
        int maxLayoutHeight = -1;
        switch (heightMode) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                maxLayoutHeight = (heightSize - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                maxLayoutHeight = (heightSize - getPaddingTop()) - getPaddingBottom();
                layoutHeight = maxLayoutHeight;
                break;
        }
        float weightSum = 0.0f;
        boolean canSlide = false;
        int widthAvailable = (widthSize - getPaddingLeft()) - getPaddingRight();
        int widthRemaining = widthAvailable;
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (child.getVisibility() == 8) {
                lp.dimWhenOffset = false;
            } else if (lp.weight > 0.0f) {
                weightSum += lp.weight;
                if (lp.width != 0) {
                    horizontalMargin = lp.leftMargin + lp.rightMargin;
                    if (lp.width == -2) {
                        childWidthSpec = View.MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, ExploreByTouchHelper.INVALID_ID);
                    } else if (lp.width == -1) {
                        childWidthSpec = View.MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, 1073741824);
                    } else {
                        childWidthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, 1073741824);
                    }
                    if (lp.height == -2) {
                        childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, ExploreByTouchHelper.INVALID_ID);
                    } else if (lp.height == -1) {
                        childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                    } else {
                        childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                    }
                    child.measure(childWidthSpec, childHeightSpec3);
                    int childWidth = child.getMeasuredWidth();
                    childHeight = child.getMeasuredHeight();
                    if (heightMode == Integer.MIN_VALUE && childHeight > layoutHeight) {
                        layoutHeight = Math.min(childHeight, maxLayoutHeight);
                    }
                    widthRemaining -= childWidth;
                    if (widthRemaining < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    lp.slideable = z;
                    canSlide |= z;
                    if (lp.slideable) {
                        this.mSlideableView = child;
                    }
                }
            } else {
                horizontalMargin = lp.leftMargin + lp.rightMargin;
                if (lp.width == -2) {
                    childWidthSpec = View.MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, ExploreByTouchHelper.INVALID_ID);
                } else if (lp.width == -1) {
                    childWidthSpec = View.MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, 1073741824);
                } else {
                    childWidthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, 1073741824);
                }
                if (lp.height == -2) {
                    childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, ExploreByTouchHelper.INVALID_ID);
                } else if (lp.height == -1) {
                    childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                } else {
                    childHeightSpec3 = View.MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                }
                child.measure(childWidthSpec, childHeightSpec3);
                int childWidth2 = child.getMeasuredWidth();
                childHeight = child.getMeasuredHeight();
                if (heightMode == Integer.MIN_VALUE) {
                    layoutHeight = Math.min(childHeight, maxLayoutHeight);
                }
                widthRemaining -= childWidth2;
                if (widthRemaining < 0) {
                    z = true;
                } else {
                    z = false;
                }
                lp.slideable = z;
                canSlide |= z;
                if (lp.slideable) {
                    this.mSlideableView = child;
                }
            }
        }
        if (canSlide || weightSum > 0.0f) {
            int fixedPanelWidthLimit = widthAvailable - this.mOverhangSize;
            for (int i2 = 0; i2 < childCount; i2++) {
                View child2 = getChildAt(i2);
                if (child2.getVisibility() != 8) {
                    LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                    if (child2.getVisibility() != 8) {
                        boolean skippedFirstPass = lp2.width == 0 && lp2.weight > 0.0f;
                        int measuredWidth = skippedFirstPass ? 0 : child2.getMeasuredWidth();
                        if (!canSlide || child2 == this.mSlideableView) {
                            if (lp2.weight > 0.0f) {
                                if (lp2.width == 0) {
                                    if (lp2.height == -2) {
                                        childHeightSpec = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, ExploreByTouchHelper.INVALID_ID);
                                    } else if (lp2.height == -1) {
                                        childHeightSpec = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                    } else {
                                        childHeightSpec = View.MeasureSpec.makeMeasureSpec(lp2.height, 1073741824);
                                    }
                                } else {
                                    childHeightSpec = View.MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                }
                                if (canSlide) {
                                    int newWidth = widthAvailable - (lp2.leftMargin + lp2.rightMargin);
                                    int childWidthSpec2 = View.MeasureSpec.makeMeasureSpec(newWidth, 1073741824);
                                    if (measuredWidth != newWidth) {
                                        child2.measure(childWidthSpec2, childHeightSpec);
                                    }
                                } else {
                                    int widthToDistribute = Math.max(0, widthRemaining);
                                    int addedWidth = (int) ((lp2.weight * widthToDistribute) / weightSum);
                                    int childWidthSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth + addedWidth, 1073741824);
                                    child2.measure(childWidthSpec3, childHeightSpec);
                                }
                            }
                        } else if (lp2.width < 0 && (measuredWidth > fixedPanelWidthLimit || lp2.weight > 0.0f)) {
                            if (skippedFirstPass) {
                                if (lp2.height == -2) {
                                    childHeightSpec2 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, ExploreByTouchHelper.INVALID_ID);
                                } else if (lp2.height == -1) {
                                    childHeightSpec2 = View.MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                } else {
                                    childHeightSpec2 = View.MeasureSpec.makeMeasureSpec(lp2.height, 1073741824);
                                }
                            } else {
                                childHeightSpec2 = View.MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                            }
                            int childWidthSpec4 = View.MeasureSpec.makeMeasureSpec(fixedPanelWidthLimit, 1073741824);
                            child2.measure(childWidthSpec4, childHeightSpec2);
                        }
                    }
                }
            }
        }
        int measuredHeight = getPaddingTop() + layoutHeight + getPaddingBottom();
        setMeasuredDimension(widthSize, measuredHeight);
        this.mCanSlide = canSlide;
        if (this.mDragHelper.getViewDragState() != 0 && !canSlide) {
            this.mDragHelper.abort();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft;
        int childRight;
        boolean isLayoutRtl = isLayoutRtlSupport();
        if (isLayoutRtl) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int width = r - l;
        int paddingStart = isLayoutRtl ? getPaddingRight() : getPaddingLeft();
        int paddingEnd = isLayoutRtl ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int xStart = paddingStart;
        int nextXStart = xStart;
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int childWidth = child.getMeasuredWidth();
                int offset = 0;
                if (lp.slideable) {
                    int margin = lp.leftMargin + lp.rightMargin;
                    int range = (Math.min(nextXStart, (width - paddingEnd) - this.mOverhangSize) - xStart) - margin;
                    this.mSlideRange = range;
                    int lpMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
                    lp.dimWhenOffset = ((xStart + lpMargin) + range) + (childWidth / 2) > width - paddingEnd;
                    int pos = (int) (range * this.mSlideOffset);
                    xStart += pos + lpMargin;
                    this.mSlideOffset = pos / this.mSlideRange;
                } else if (this.mCanSlide && this.mParallaxBy != 0) {
                    offset = (int) ((1.0f - this.mSlideOffset) * this.mParallaxBy);
                    xStart = nextXStart;
                } else {
                    xStart = nextXStart;
                }
                if (isLayoutRtl) {
                    childRight = (width - xStart) + offset;
                    childLeft = childRight - childWidth;
                } else {
                    childLeft = xStart - offset;
                    childRight = childLeft + childWidth;
                }
                int childBottom = paddingTop + child.getMeasuredHeight();
                child.layout(childLeft, paddingTop, childRight, childBottom);
                nextXStart += child.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i2 = 0; i2 < childCount; i2++) {
                    dimChildView(getChildAt(i2), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = child == this.mSlideableView;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        View secondChild;
        int action = MotionEventCompat.getActionMasked(ev);
        if (!this.mCanSlide && action == 0 && getChildCount() > 1 && (secondChild = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(secondChild, (int) ev.getX(), (int) ev.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && action != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(ev);
        }
        if (action == 3 || action == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        boolean interceptTap = false;
        switch (action) {
            case 0:
                this.mIsUnableToDrag = false;
                float x = ev.getX();
                float y = ev.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    interceptTap = true;
                }
                break;
            case 2:
                float x2 = ev.getX();
                float y2 = ev.getY();
                float adx = Math.abs(x2 - this.mInitialMotionX);
                float ady = Math.abs(y2 - this.mInitialMotionY);
                int slop = this.mDragHelper.getTouchSlop();
                if (adx > slop && ady > adx) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
                break;
        }
        boolean interceptForDrag = this.mDragHelper.shouldInterceptTouchEvent(ev);
        return interceptForDrag || interceptTap;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(ev);
        }
        this.mDragHelper.processTouchEvent(ev);
        int action = ev.getAction();
        switch (action & 255) {
            case 0:
                float x = ev.getX();
                float y = ev.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                return true;
            case 1:
                if (!isDimmed(this.mSlideableView)) {
                    return true;
                }
                float x2 = ev.getX();
                float y2 = ev.getY();
                float dx = x2 - this.mInitialMotionX;
                float dy = y2 - this.mInitialMotionY;
                int slop = this.mDragHelper.getTouchSlop();
                if ((dx * dx) + (dy * dy) >= slop * slop || !this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                    return true;
                }
                closePane(this.mSlideableView, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean closePane(View pane, int initialVelocity) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, initialVelocity)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private boolean openPane(View pane, int initialVelocity) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, initialVelocity)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPanelDragged(int newLeft) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtl = isLayoutRtlSupport();
        LayoutParams lp = (LayoutParams) this.mSlideableView.getLayoutParams();
        int childWidth = this.mSlideableView.getWidth();
        int newStart = isLayoutRtl ? (getWidth() - newLeft) - childWidth : newLeft;
        int paddingStart = isLayoutRtl ? getPaddingRight() : getPaddingLeft();
        int lpMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
        int startBound = paddingStart + lpMargin;
        this.mSlideOffset = (newStart - startBound) / this.mSlideRange;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (lp.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    private void dimChildView(View v, float mag, int fadeColor) {
        LayoutParams lp = (LayoutParams) v.getLayoutParams();
        if (mag > 0.0f && fadeColor != 0) {
            int baseAlpha = ((-16777216) & fadeColor) >>> 24;
            int imag = (int) (baseAlpha * mag);
            int color = (imag << 24) | (16777215 & fadeColor);
            if (lp.dimPaint == null) {
                lp.dimPaint = new Paint();
            }
            lp.dimPaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(v) != 2) {
                ViewCompat.setLayerType(v, 2, lp.dimPaint);
            }
            invalidateChildRegion(v);
            return;
        }
        if (ViewCompat.getLayerType(v) != 0) {
            if (lp.dimPaint != null) {
                lp.dimPaint.setColorFilter(null);
            }
            DisableLayerRunnable dlr = new DisableLayerRunnable(v);
            this.mPostedRunnables.add(dlr);
            ViewCompat.postOnAnimation(this, dlr);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean result;
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int save = canvas.save(2);
        if (this.mCanSlide && !lp.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            } else {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            result = super.drawChild(canvas, child, drawingTime);
        } else if (lp.dimWhenOffset && this.mSlideOffset > 0.0f) {
            if (!child.isDrawingCacheEnabled()) {
                child.setDrawingCacheEnabled(true);
            }
            Bitmap cache = child.getDrawingCache();
            if (cache != null) {
                canvas.drawBitmap(cache, child.getLeft(), child.getTop(), lp.dimPaint);
                result = false;
            } else {
                Log.e(TAG, "drawChild: child view " + child + " returned null drawing cache");
                result = super.drawChild(canvas, child, drawingTime);
            }
        } else {
            if (child.isDrawingCacheEnabled()) {
                child.setDrawingCacheEnabled(false);
            }
            result = super.drawChild(canvas, child, drawingTime);
        }
        canvas.restoreToCount(save);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateChildRegion(View v) {
        IMPL.invalidateChildRegion(this, v);
    }

    boolean smoothSlideTo(float slideOffset, int velocity) {
        int x;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtl = isLayoutRtlSupport();
        LayoutParams lp = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtl) {
            int startBound = getPaddingRight() + lp.rightMargin;
            int childWidth = this.mSlideableView.getWidth();
            x = (int) (getWidth() - ((startBound + (this.mSlideRange * slideOffset)) + childWidth));
        } else {
            int startBound2 = getPaddingLeft() + lp.leftMargin;
            x = (int) (startBound2 + (this.mSlideRange * slideOffset));
        }
        if (!this.mDragHelper.smoothSlideViewTo(this.mSlideableView, x, this.mSlideableView.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable d) {
        setShadowDrawableLeft(d);
    }

    public void setShadowDrawableLeft(Drawable d) {
        this.mShadowDrawableLeft = d;
    }

    public void setShadowDrawableRight(Drawable d) {
        this.mShadowDrawableRight = d;
    }

    @Deprecated
    public void setShadowResource(int resId) {
        setShadowDrawable(getResources().getDrawable(resId));
    }

    public void setShadowResourceLeft(int resId) {
        setShadowDrawableLeft(getResources().getDrawable(resId));
    }

    public void setShadowResourceRight(int resId) {
        setShadowDrawableRight(getResources().getDrawable(resId));
    }

    @Override // android.view.View
    public void draw(Canvas c) {
        Drawable shadowDrawable;
        int right;
        int left;
        super.draw(c);
        boolean isLayoutRtl = isLayoutRtlSupport();
        if (isLayoutRtl) {
            shadowDrawable = this.mShadowDrawableRight;
        } else {
            shadowDrawable = this.mShadowDrawableLeft;
        }
        View shadowView = getChildCount() > 1 ? getChildAt(1) : null;
        if (shadowView != null && shadowDrawable != null) {
            int top = shadowView.getTop();
            int bottom = shadowView.getBottom();
            int shadowWidth = shadowDrawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                left = shadowView.getRight();
                right = left + shadowWidth;
            } else {
                right = shadowView.getLeft();
                left = right - shadowWidth;
            }
            shadowDrawable.setBounds(left, top, right, bottom);
            shadowDrawable.draw(c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    private void parallaxOtherViews(float slideOffset) {
        boolean dimViews;
        boolean isLayoutRtl = isLayoutRtlSupport();
        LayoutParams slideLp = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (!slideLp.dimWhenOffset) {
            dimViews = false;
        } else if ((isLayoutRtl ? slideLp.rightMargin : slideLp.leftMargin) <= 0) {
            dimViews = true;
        } else {
            dimViews = false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v != this.mSlideableView) {
                int oldOffset = (int) ((1.0f - this.mParallaxOffset) * this.mParallaxBy);
                this.mParallaxOffset = slideOffset;
                int newOffset = (int) ((1.0f - slideOffset) * this.mParallaxBy);
                int dx = oldOffset - newOffset;
                if (isLayoutRtl) {
                    dx = -dx;
                }
                v.offsetLeftAndRight(dx);
                if (dimViews) {
                    dimChildView(v, isLayoutRtl ? this.mParallaxOffset - 1.0f : 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                }
            }
        }
    }

    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            int count = group.getChildCount();
            for (int i = count - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom() && canScroll(child, true, dx, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                    return true;
                }
            }
        }
        if (checkV) {
            if (!isLayoutRtlSupport()) {
                dx = -dx;
            }
            if (ViewCompat.canScrollHorizontally(v, dx)) {
                return true;
            }
        }
        return false;
    }

    boolean isDimmed(View child) {
        if (child == null) {
            return false;
        }
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        return this.mCanSlide && lp.dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) p) : new LayoutParams(p);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return (p instanceof LayoutParams) && super.checkLayoutParams(p);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return ss;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = ss.isOpen;
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) child.getLayoutParams()).slideable;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int state) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if (SlidingPaneLayout.this.mSlideOffset == 0.0f) {
                    SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                } else {
                    SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = true;
                }
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View capturedChild, int activePointerId) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            SlidingPaneLayout.this.onPanelDragged(left);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            int left;
            LayoutParams lp = (LayoutParams) releasedChild.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int startToRight = SlidingPaneLayout.this.getPaddingRight() + lp.rightMargin;
                if (xvel < 0.0f || (xvel == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    startToRight += SlidingPaneLayout.this.mSlideRange;
                }
                int childWidth = SlidingPaneLayout.this.mSlideableView.getWidth();
                left = (SlidingPaneLayout.this.getWidth() - startToRight) - childWidth;
            } else {
                left = SlidingPaneLayout.this.getPaddingLeft() + lp.leftMargin;
                if (xvel > 0.0f || (xvel == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    left += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(left, releasedChild.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View child) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            LayoutParams lp = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int startBound = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + lp.rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                int endBound = startBound - SlidingPaneLayout.this.mSlideRange;
                int newLeft = Math.max(Math.min(left, startBound), endBound);
                return newLeft;
            }
            int startBound2 = SlidingPaneLayout.this.getPaddingLeft() + lp.leftMargin;
            int endBound2 = startBound2 + SlidingPaneLayout.this.mSlideRange;
            int newLeft2 = Math.min(Math.max(left, startBound2), endBound2);
            return newLeft2;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View child, int top, int dy) {
            return child.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, pointerId);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {R.attr.layout_weight};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.weight = 0.0f;
            this.weight = source.weight;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.weight = 0.0f;
            TypedArray a = c.obtainStyledAttributes(attrs, ATTRS);
            this.weight = a.getFloat(0, 0.0f);
            a.recycle();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.widget.SlidingPaneLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        boolean isOpen;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.isOpen = in.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.isOpen ? 1 : 0);
        }
    }

    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            ViewCompat.postInvalidateOnAnimation(parent, child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            if (this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
                try {
                    this.mRecreateDisplayList.setBoolean(child, true);
                    this.mGetDisplayList.invoke(child, (Object[]) null);
                } catch (Exception e) {
                    Log.e(SlidingPaneLayout.TAG, "Error refreshing display list state", e);
                }
                super.invalidateChildRegion(parent, child);
                return;
            }
            child.invalidate();
        }
    }

    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            ViewCompat.setLayerPaint(child, ((LayoutParams) child.getLayoutParams()).dimPaint);
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            AccessibilityNodeInfoCompat superNode = AccessibilityNodeInfoCompat.obtain(info);
            super.onInitializeAccessibilityNodeInfo(host, superNode);
            copyNodeInfoNoChildren(info, superNode);
            superNode.recycle();
            info.setClassName(SlidingPaneLayout.class.getName());
            info.setSource(host);
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(host);
            if (parentForAccessibility instanceof View) {
                info.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(child) && child.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(child, 1);
                    info.addChild(child);
                }
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            if (filter(child)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(host, child, event);
        }

        public boolean filter(View child) {
            return SlidingPaneLayout.this.isDimmed(child);
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat dest, AccessibilityNodeInfoCompat src) {
            Rect rect = this.mTmpRect;
            src.getBoundsInParent(rect);
            dest.setBoundsInParent(rect);
            src.getBoundsInScreen(rect);
            dest.setBoundsInScreen(rect);
            dest.setVisibleToUser(src.isVisibleToUser());
            dest.setPackageName(src.getPackageName());
            dest.setClassName(src.getClassName());
            dest.setContentDescription(src.getContentDescription());
            dest.setEnabled(src.isEnabled());
            dest.setClickable(src.isClickable());
            dest.setFocusable(src.isFocusable());
            dest.setFocused(src.isFocused());
            dest.setAccessibilityFocused(src.isAccessibilityFocused());
            dest.setSelected(src.isSelected());
            dest.setLongClickable(src.isLongClickable());
            dest.addAction(src.getActions());
            dest.setMovementGranularities(src.getMovementGranularities());
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View childView) {
            this.mChildView = childView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }
}
