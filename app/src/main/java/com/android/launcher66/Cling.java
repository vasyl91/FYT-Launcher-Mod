package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class Cling extends FrameLayout implements Insettable, View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    static final String FIRST_RUN_CLING_DISMISSED_KEY = "cling_gel.first_run.dismissed";
    static final String FOLDER_CLING_DISMISSED_KEY = "cling_gel.folder.dismissed";
    static final String WORKSPACE_CLING_DISMISSED_KEY = "cling_gel.workspace.dismissed";
    private Drawable mBackground;
    private int mBackgroundColor;
    private Paint mBubblePaint;
    private Paint mDotPaint;
    private String mDrawIdentifier;
    private Paint mErasePaint;
    private Drawable mFocusedHotseatApp;
    private Rect mFocusedHotseatAppBounds;
    private ComponentName mFocusedHotseatAppComponent;
    private final Rect mInsets;
    private boolean mIsInitialized;
    private Launcher mLauncher;
    private View mScrimView;
    private int[] mTouchDownPt;
    private static String FIRST_RUN_PORTRAIT = "first_run_portrait";
    private static String FIRST_RUN_LANDSCAPE = "first_run_landscape";
    private static String WORKSPACE_PORTRAIT = "workspace_portrait";
    private static String WORKSPACE_LANDSCAPE = "workspace_landscape";
    private static String WORKSPACE_LARGE = "workspace_large";
    private static String WORKSPACE_CUSTOM = "workspace_custom";
    private static String FOLDER_PORTRAIT = "folder_portrait";
    private static String FOLDER_LANDSCAPE = "folder_landscape";
    private static String FOLDER_LARGE = "folder_large";
    private static float FIRST_RUN_CIRCLE_BUFFER_DPS = 60.0f;
    private static float WORKSPACE_INNER_CIRCLE_RADIUS_DPS = 50.0f;
    private static float WORKSPACE_OUTER_CIRCLE_RADIUS_DPS = 60.0f;
    private static float WORKSPACE_CIRCLE_Y_OFFSET_DPS = 30.0f;

    public Cling(Context context) {
        this(context, null, 0);
    }

    public Cling(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Cling(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mTouchDownPt = new int[2];
        this.mInsets = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Cling, defStyle, 0);
        this.mDrawIdentifier = a.getString(0);
        a.recycle();
        setClickable(true);
    }

    void init(Launcher l, View scrim) {
        if (!this.mIsInitialized) {
            this.mLauncher = l;
            this.mScrimView = scrim;
            this.mBackgroundColor = -587202560;
            setOnLongClickListener(this);
            setOnClickListener(this);
            setOnTouchListener(this);
            this.mErasePaint = new Paint();
            this.mErasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.mErasePaint.setColor(MEASURED_SIZE_MASK);
            this.mErasePaint.setAlpha(0);
            this.mErasePaint.setAntiAlias(true);
            int circleColor = ContextCompat.getColor(getContext(), R.color.first_run_cling_circle_background_color);
            this.mBubblePaint = new Paint();
            this.mBubblePaint.setColor(circleColor);
            this.mBubblePaint.setAntiAlias(true);
            this.mDotPaint = new Paint();
            this.mDotPaint.setColor(7519213);
            this.mDotPaint.setAntiAlias(true);
            this.mIsInitialized = true;
        }
    }

    void setFocusedHotseatApp(int drawableId, int appRank, ComponentName cn2, String title, String description) {
        getResources();
        Hotseat hotseat = null;
        if (0 != 0 && drawableId > -1 && appRank > -1 && !title.isEmpty() && !description.isEmpty()) {
            int x = hotseat.getCellXFromOrder(appRank);
            int y = hotseat.getCellYFromOrder(appRank);
            Rect pos = hotseat.getCellCoordinates(x, y);
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            this.mFocusedHotseatApp = ContextCompat.getDrawable(getContext(), drawableId);
            this.mFocusedHotseatAppComponent = cn2;
            this.mFocusedHotseatAppBounds = new Rect(pos.left, pos.top, pos.left + Utilities.sIconTextureWidth, pos.top + Utilities.sIconTextureHeight);
            Utilities.scaleRectAboutCenter(this.mFocusedHotseatAppBounds, grid.hotseatIconSize / grid.iconSize);
            TextView v = (TextView) findViewById(R.id.focused_hotseat_app_title);
            if (v != null) {
                v.setText(title);
            }
            TextView v2 = (TextView) findViewById(R.id.focused_hotseat_app_description);
            if (v2 != null) {
                v2.setText(description);
            }
            View bubble = findViewById(R.id.focused_hotseat_app_bubble);
            bubble.setVisibility(View.VISIBLE);
        }
    }

    void show(boolean animate, int duration) {
        setVisibility(View.VISIBLE);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
        if (this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) || this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) || this.mDrawIdentifier.equals(WORKSPACE_LARGE) || this.mDrawIdentifier.equals(WORKSPACE_CUSTOM)) {
            View content = getContent();
            content.setAlpha(0.0f);
            content.animate().alpha(1.0f).setDuration(duration).setListener(null).start();
            setAlpha(1.0f);
        } else if (animate) {
            buildLayer();
            setAlpha(0.0f);
            animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(duration).setListener(null).start();
        } else {
            setAlpha(1.0f);
        }
        if (this.mScrimView != null) {
            this.mScrimView.setVisibility(View.VISIBLE);
            this.mScrimView.setAlpha(0.0f);
            this.mScrimView.animate().alpha(1.0f).setDuration(duration).setListener(null).start();
        }
        setFocusableInTouchMode(true);
        post(new Runnable() { 
            @Override
            public void run() {
                Cling.this.setFocusable(true);
                Cling.this.requestFocus();
            }
        });
    }

    void hide(int duration, final Runnable postCb) {
        if (this.mDrawIdentifier.equals(FIRST_RUN_PORTRAIT) || this.mDrawIdentifier.equals(FIRST_RUN_LANDSCAPE)) {
            View content = getContent();
            content.animate().alpha(0.0f).setDuration(duration).setListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationEnd(Animator animation) {
                    Cling.this.setVisibility(View.GONE);
                    postCb.run();
                }
            }).start();
        } else {
            animate().alpha(0.0f).setDuration(duration).setListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationEnd(Animator animation) {
                    Cling.this.setVisibility(android.view.View.GONE);
                    postCb.run();
                }
            }).start();
        }
        if (this.mScrimView != null) {
            this.mScrimView.animate().alpha(0.0f).setDuration(duration).setListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationEnd(Animator animation) {
                    Cling.this.mScrimView.setVisibility(View.GONE);
                }
            }).start();
        }
    }

    void cleanup() {
        this.mBackground = null;
        this.mIsInitialized = false;
    }

    void bringScrimToFront() {
        if (this.mScrimView != null) {
            this.mScrimView.bringToFront();
        }
    }

    @Override
    public void setInsets(Rect insets) {
        this.mInsets.set(insets);
        setPadding(insets.left, insets.top, insets.right, insets.bottom);
    }

    View getContent() {
        return findViewById(R.id.content);
    }

    String getDrawIdentifier() {
        return this.mDrawIdentifier;
    }

    @Override
    public View focusSearch(int direction) {
        return focusSearch(this, direction);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        return FocusFinder.getInstance().findNextFocus(this, focused, direction);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) || this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) || this.mDrawIdentifier.equals(WORKSPACE_LARGE) || this.mDrawIdentifier.equals(WORKSPACE_CUSTOM);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Folder f;
        if ((this.mDrawIdentifier.equals(FOLDER_PORTRAIT) || this.mDrawIdentifier.equals(FOLDER_LANDSCAPE) || this.mDrawIdentifier.equals(FOLDER_LARGE)) && (f = this.mLauncher.getWorkspace().getOpenFolder()) != null) {
            Rect r = new Rect();
            f.getHitRect(r);
            if (r.contains((int) event.getX(), (int) event.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.mTouchDownPt[0] = (int) ev.getX();
            this.mTouchDownPt[1] = (int) ev.getY();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if ((this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) || this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) || this.mDrawIdentifier.equals(WORKSPACE_LARGE)) && this.mFocusedHotseatAppBounds != null && this.mFocusedHotseatAppBounds.contains(this.mTouchDownPt[0], this.mTouchDownPt[1])) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(this.mFocusedHotseatAppComponent);
            intent.addCategory("android.intent.category.LAUNCHER");
            this.mLauncher.startActivity(intent, null);
            this.mLauncher.dismissWorkspaceCling(this);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (!this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) && !this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) && !this.mDrawIdentifier.equals(WORKSPACE_LARGE)) {
            return false;
        }
        this.mLauncher.dismissWorkspaceCling(null);
        return true;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (this.mIsInitialized) {
            canvas.save();
            if (this.mBackground == null && this.mDrawIdentifier.equals(WORKSPACE_CUSTOM)) {
                this.mBackground = ContextCompat.getDrawable(getContext(), R.drawable.bg_cling5);
            }
            Bitmap eraseBg = null;
            Canvas eraseCanvas = null;
            if (this.mScrimView != null) {
                this.mScrimView.setBackgroundColor(this.mBackgroundColor);
            } else if (this.mBackground != null) {
                this.mBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.mBackground.draw(canvas);
            } else if (this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) || this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) || this.mDrawIdentifier.equals(WORKSPACE_LARGE)) {
                eraseBg = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                eraseCanvas = new Canvas(eraseBg);
                eraseCanvas.drawColor(this.mBackgroundColor);
            } else {
                canvas.drawColor(this.mBackgroundColor);
            }
            DisplayMetrics metrics = new DisplayMetrics();
            this.mLauncher.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            float alpha = getAlpha();
            View content = getContent();
            if (content != null) {
                alpha *= content.getAlpha();
            }
            if (this.mDrawIdentifier.equals(FIRST_RUN_PORTRAIT) || this.mDrawIdentifier.equals(FIRST_RUN_LANDSCAPE)) {
                View bubbleContent = findViewById(R.id.bubble_content);
                Rect bubbleRect = new Rect();
                bubbleContent.getGlobalVisibleRect(bubbleRect);
                this.mBubblePaint.setAlpha((int) (255.0f * alpha));
                float buffer = DynamicGrid.pxFromDp(FIRST_RUN_CIRCLE_BUFFER_DPS, metrics);
                canvas.drawCircle(metrics.widthPixels / 2, bubbleRect.centerY(), (bubbleContent.getMeasuredWidth() + buffer) / 2.0f, this.mBubblePaint);
            } else if (this.mDrawIdentifier.equals(WORKSPACE_PORTRAIT) || this.mDrawIdentifier.equals(WORKSPACE_LANDSCAPE) || this.mDrawIdentifier.equals(WORKSPACE_LARGE)) {
                int offset = DynamicGrid.pxFromDp(WORKSPACE_CIRCLE_Y_OFFSET_DPS, metrics);
                this.mErasePaint.setAlpha(128);
                eraseCanvas.drawCircle(metrics.widthPixels / 2, (metrics.heightPixels / 2) - offset, 0.0f, this.mErasePaint);
                this.mErasePaint.setAlpha(0);
                eraseCanvas.drawCircle(metrics.widthPixels / 2, (metrics.heightPixels / 2) - offset, 0.0f, this.mErasePaint);
                canvas.drawBitmap(eraseBg, 0.0f, 0.0f, (Paint) null);
                eraseCanvas.setBitmap(null);
                if (this.mFocusedHotseatAppBounds != null && this.mFocusedHotseatApp != null) {
                    this.mFocusedHotseatApp.setBounds(this.mFocusedHotseatAppBounds.left, this.mFocusedHotseatAppBounds.top, this.mFocusedHotseatAppBounds.right, this.mFocusedHotseatAppBounds.bottom);
                    this.mFocusedHotseatApp.setAlpha((int) (255.0f * alpha));
                    this.mFocusedHotseatApp.draw(canvas);
                }
            }
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }
}
