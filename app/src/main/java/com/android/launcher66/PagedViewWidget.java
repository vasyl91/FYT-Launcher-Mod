package com.android.launcher66;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PagedViewWidget extends LinearLayout {
    static final String TAG = "PagedViewWidgetLayout";
    private static boolean sDeletePreviewsWhenDetachedFromWindow = true;
    private static boolean sRecyclePreviewsWhenDetachedFromWindow = true;
    static PagedViewWidget sShortpressTarget = null;
    private String mDimensionsFormatString;
    private Object mInfo;
    boolean mIsAppWidget;
    private final Rect mOriginalImagePadding;
    CheckForShortPress mPendingCheckForShortPress;
    ShortPressListener mShortPressListener;
    boolean mShortPressTriggered;
    private WidgetPreviewLoader mWidgetPreviewLoader;

    interface ShortPressListener {
        void cleanUpShortPress(View view);

        void onShortPress(View view);
    }

    public PagedViewWidget(Context context) {
        this(context, null);
    }

    public PagedViewWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedViewWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPendingCheckForShortPress = null;
        this.mShortPressListener = null;
        this.mShortPressTriggered = false;
        this.mOriginalImagePadding = new Rect();
        Resources r = context.getResources();
        this.mDimensionsFormatString = r.getString(R.string.widget_dims_format);
        setWillNotDraw(false);
        setClipToPadding(false);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView image = (ImageView) findViewById(R.id.widget_preview);
        this.mOriginalImagePadding.left = image.getPaddingLeft();
        this.mOriginalImagePadding.top = image.getPaddingTop();
        this.mOriginalImagePadding.right = image.getPaddingRight();
        this.mOriginalImagePadding.bottom = image.getPaddingBottom();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        TextView name = (TextView) findViewById(R.id.widget_name);
        if (name != null) {
            name.setTextSize(2, grid.iconTextSize);
        }
        TextView dims = (TextView) findViewById(R.id.widget_dims);
        if (dims != null) {
            dims.setTextSize(2, grid.iconTextSize);
        }
    }

    public static void setDeletePreviewsWhenDetachedFromWindow(boolean value) {
        sDeletePreviewsWhenDetachedFromWindow = value;
    }

    public static void setRecyclePreviewsWhenDetachedFromWindow(boolean value) {
        sRecyclePreviewsWhenDetachedFromWindow = value;
    }

    @Override
    protected void onDetachedFromWindow() {
        ImageView image;
        super.onDetachedFromWindow();
        if (sDeletePreviewsWhenDetachedFromWindow && (image = (ImageView) findViewById(R.id.widget_preview)) != null) {
            FastBitmapDrawable preview = (FastBitmapDrawable) image.getDrawable();
            if (sRecyclePreviewsWhenDetachedFromWindow && this.mInfo != null && preview != null && preview.getBitmap() != null) {
                this.mWidgetPreviewLoader.recycleBitmap(this.mInfo, preview.getBitmap());
            }
            image.setImageDrawable(null);
        }
    }

    public void applyFromAppWidgetProviderInfo(AppWidgetProviderInfo info, int maxWidth, int[] cellSpan, WidgetPreviewLoader loader) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        this.mIsAppWidget = true;
        this.mInfo = info;
        ImageView image = (ImageView) findViewById(R.id.widget_preview);
        if (maxWidth > -1) {
            image.setMaxWidth(maxWidth);
        }
        PackageManager mPackageManager = getContext().getPackageManager();
        TextView name = (TextView) findViewById(R.id.widget_name);
        name.setText(info.loadLabel(mPackageManager));
        TextView dims = (TextView) findViewById(R.id.widget_dims);
        if (dims != null) {
            int hSpan = Math.min(cellSpan[0], (int) grid.numColumns);
            int vSpan = Math.min(cellSpan[1], (int) grid.numRows);
            dims.setText(String.format(this.mDimensionsFormatString, Integer.valueOf(hSpan), Integer.valueOf(vSpan)));
        }
        this.mWidgetPreviewLoader = loader;
    }

    public void applyFromResolveInfo(PackageManager pm, ResolveInfo info, WidgetPreviewLoader loader) {
        this.mIsAppWidget = false;
        this.mInfo = info;
        CharSequence label = info.loadLabel(pm);
        TextView name = (TextView) findViewById(R.id.widget_name);
        name.setText(label);
        TextView dims = (TextView) findViewById(R.id.widget_dims);
        if (dims != null) {
            dims.setText(String.format(this.mDimensionsFormatString, 1, 1));
        }
        this.mWidgetPreviewLoader = loader;
    }

    public int[] getPreviewSize() {
        ImageView i = (ImageView) findViewById(R.id.widget_preview);
        int[] maxSize = {(i.getWidth() - this.mOriginalImagePadding.left) - this.mOriginalImagePadding.right, i.getHeight() - this.mOriginalImagePadding.top};
        return maxSize;
    }

    void applyPreview(FastBitmapDrawable preview, int index) {
        PagedViewWidgetImageView image = (PagedViewWidgetImageView) findViewById(R.id.widget_preview);
        if (preview != null) {
            image.mAllowRequestLayout = false;
            image.setImageDrawable(preview);
            if (this.mIsAppWidget) {
                int[] imageSize = getPreviewSize();
                int centerAmount = (imageSize[0] - preview.getIntrinsicWidth()) / 2;
                image.setPadding(this.mOriginalImagePadding.left + centerAmount, this.mOriginalImagePadding.top, this.mOriginalImagePadding.right, this.mOriginalImagePadding.bottom);
            }
            image.setAlpha(1.0f);
            image.mAllowRequestLayout = true;
        }
    }

    void setShortPressListener(ShortPressListener listener) {
        this.mShortPressListener = listener;
    }

    class CheckForShortPress implements Runnable {
        CheckForShortPress() {
        }

        @Override
        public void run() {
            if (PagedViewWidget.sShortpressTarget == null) {
                if (PagedViewWidget.this.mShortPressListener != null) {
                    PagedViewWidget.this.mShortPressListener.onShortPress(PagedViewWidget.this);
                    PagedViewWidget.sShortpressTarget = PagedViewWidget.this;
                }
                PagedViewWidget.this.mShortPressTriggered = true;
            }
        }
    }

    private void checkForShortPress() {
        if (sShortpressTarget == null) {
            if (this.mPendingCheckForShortPress == null) {
                this.mPendingCheckForShortPress = new CheckForShortPress();
            }
            postDelayed(this.mPendingCheckForShortPress, 120L);
        }
    }

    private void removeShortPressCallback() {
        if (this.mPendingCheckForShortPress != null) {
            removeCallbacks(this.mPendingCheckForShortPress);
        }
    }

    private void cleanUpShortPress() {
        removeShortPressCallback();
        if (this.mShortPressTriggered) {
            if (this.mShortPressListener != null) {
                this.mShortPressListener.cleanUpShortPress(this);
            }
            this.mShortPressTriggered = false;
        }
    }

    static void resetShortPressTarget() {
        sShortpressTarget = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case 0:
                checkForShortPress();
                break;
            case 1:
                cleanUpShortPress();
                break;
            case 3:
                cleanUpShortPress();
                break;
        }
        return true;
    }
}
