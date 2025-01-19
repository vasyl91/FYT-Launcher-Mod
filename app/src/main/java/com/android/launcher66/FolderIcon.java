package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;

import java.util.ArrayList;

public class FolderIcon extends LinearLayout implements FolderInfo.FolderListener {
    private static final int CONSUMPTION_ANIMATION_DURATION = 100;
    private static final int DROP_IN_ANIMATION_DURATION = 400;
    private static final int FINAL_ITEM_ANIMATION_DURATION = 200;
    public static final boolean HAS_OUTER_RING = true;
    private static final int INITIAL_ITEM_ANIMATION_DURATION = 350;
    private static final float INNER_RING_GROWTH_FACTOR = 0.15f;
    private static final int NUM_ITEMS_IN_PREVIEW = 3;
    private static final float OUTER_RING_GROWTH_FACTOR = 0.3f;
    private static final float PERSPECTIVE_SCALE_FACTOR = 0.35f;
    private static final float PERSPECTIVE_SHIFT_FACTOR = 0.24f;
    private PreviewItemDrawingParams mAnimParams;
    boolean mAnimating;
    private int mAvailableSpaceInPreview;
    private float mBaselineIconScale;
    private int mBaselineIconSize;
    private Folder mFolder;
    private BubbleTextView mFolderName;
    FolderRingAnimator mFolderRingAnimator;
    private ArrayList<ShortcutInfo> mHiddenItems;
    private FolderInfo mInfo;
    private int mIntrinsicIconSize;
    private Launcher mLauncher;
    private CheckLongPressHelper mLongPressHelper;
    private float mMaxPerspectiveShift;
    private Rect mOldBounds;
    private PreviewItemDrawingParams mParams;
    private ImageView mPreviewBackground;
    private int mPreviewOffsetX;
    private int mPreviewOffsetY;
    private int mTotalWidth;
    private static boolean sStaticValuesDirty = true;
    public static Drawable sSharedFolderLeaveBehind = null;
    private Context mContext;

    public FolderIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mFolderRingAnimator = null;
        this.mTotalWidth = -1;
        this.mAnimating = false;
        this.mOldBounds = new Rect();
        this.mParams = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f, 0);
        this.mAnimParams = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f, 0);
        this.mHiddenItems = new ArrayList<>();
        init();
    }

    public FolderIcon(Context context) {
        super(context);
        this.mContext = context;
        this.mFolderRingAnimator = null;
        this.mTotalWidth = -1;
        this.mAnimating = false;
        this.mOldBounds = new Rect();
        this.mParams = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f, 0);
        this.mAnimParams = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f, 0);
        this.mHiddenItems = new ArrayList<>();
        init();
    }

    private void init() {
        this.mLongPressHelper = new CheckLongPressHelper(this);
    }

    public boolean isDropEnabled() {
        ViewGroup cellLayoutChildren = (ViewGroup) getParent();
        ViewGroup cellLayout = (ViewGroup) cellLayoutChildren.getParent();
        Workspace workspace = (Workspace) cellLayout.getParent();
        return !workspace.isSmall();
    }

    static FolderIcon fromXml(int resId, Launcher launcher, ViewGroup group, FolderInfo folderInfo, IconCache iconCache) {
        FolderIcon icon = (FolderIcon) LayoutInflater.from(launcher).inflate(resId, group, false);
        icon.setClipToPadding(false);
        icon.mFolderName = (BubbleTextView) icon.findViewById(R.id.folder_icon_name);
        icon.mFolderName.setText(folderInfo.title);
        icon.mPreviewBackground = (ImageView) icon.findViewById(R.id.preview_background);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) icon.mPreviewBackground.getLayoutParams();
        lp.topMargin = grid.folderBackgroundOffset;
        lp.width = grid.folderIconSizePx;
        lp.height = grid.folderIconSizePx;
        icon.setTag(folderInfo);
        icon.setOnClickListener(launcher);
        icon.mInfo = folderInfo;
        icon.mLauncher = launcher;
        icon.setContentDescription(String.format(launcher.getString(R.string.folder_name_format), folderInfo.title));
        Folder folder = Folder.fromXml(launcher);
        folder.setDragController(launcher.getDragController());
        folder.setFolderIcon(icon);
        folder.bind(folderInfo);
        icon.mFolder = folder;
        icon.mFolderRingAnimator = new FolderRingAnimator(launcher, icon);
        folderInfo.addListener(icon);
        return icon;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        sStaticValuesDirty = true;
        return super.onSaveInstanceState();
    }

    public static class FolderRingAnimator {
        private ValueAnimator mAcceptAnimator;
        private CellLayout mCellLayout;
        public int mCellX;
        public int mCellY;
        public FolderIcon mFolderIcon;
        public float mInnerRingSize;
        private ValueAnimator mNeutralAnimator;
        public float mOuterRingSize;
        public static Drawable sSharedOuterRingDrawable = null;
        public static Drawable sSharedInnerRingDrawable = null;
        public static int sPreviewSize = -1;
        public static int sPreviewPadding = -1;

        public FolderRingAnimator(Launcher launcher, FolderIcon folderIcon) {
            this.mFolderIcon = null;
            this.mFolderIcon = folderIcon;
            Resources res = launcher.getResources();
            if (FolderIcon.sStaticValuesDirty) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new RuntimeException("FolderRingAnimator loading drawables on non-UI thread " + Thread.currentThread());
                }
                LauncherAppState app = LauncherAppState.getInstance();
                DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
                sPreviewSize = grid.folderIconSizePx;
                sPreviewPadding = res.getDimensionPixelSize(R.dimen.folder_preview_padding);
                sSharedOuterRingDrawable = ContextCompat.getDrawable(launcher, R.drawable.portal_ring_outer_holo);
                sSharedInnerRingDrawable = ContextCompat.getDrawable(launcher, R.drawable.portal_ring_inner_nolip_holo);
                FolderIcon.sSharedFolderLeaveBehind = ContextCompat.getDrawable(launcher, R.drawable.portal_ring_rest);
                FolderIcon.sStaticValuesDirty = false;
            }
        }

        public void animateToAcceptState() {
            if (this.mNeutralAnimator != null) {
                this.mNeutralAnimator.cancel();
            }
            this.mAcceptAnimator = LauncherAnimUtils.ofFloat(this.mCellLayout, 0.0f, 1.0f);
            this.mAcceptAnimator.setDuration(100L);
            final int previewSize = sPreviewSize;
            this.mAcceptAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float percent = ((Float) animation.getAnimatedValue()).floatValue();
                    FolderRingAnimator.this.mOuterRingSize = ((FolderIcon.OUTER_RING_GROWTH_FACTOR * percent) + 1.0f) * previewSize;
                    FolderRingAnimator.this.mInnerRingSize = ((FolderIcon.INNER_RING_GROWTH_FACTOR * percent) + 1.0f) * previewSize;
                    if (FolderRingAnimator.this.mCellLayout != null) {
                        FolderRingAnimator.this.mCellLayout.invalidate();
                    }
                }
            });
            this.mAcceptAnimator.addListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationStart(Animator animation) {
                    if (FolderRingAnimator.this.mFolderIcon != null) {
                        FolderRingAnimator.this.mFolderIcon.mPreviewBackground.setVisibility(View.INVISIBLE);
                    }
                }
            });
            this.mAcceptAnimator.start();
        }

        public void animateToNaturalState() {
            if (this.mAcceptAnimator != null) {
                this.mAcceptAnimator.cancel();
            }
            this.mNeutralAnimator = LauncherAnimUtils.ofFloat(this.mCellLayout, 0.0f, 1.0f);
            this.mNeutralAnimator.setDuration(100L);
            final int previewSize = sPreviewSize;
            this.mNeutralAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float percent = ((Float) animation.getAnimatedValue()).floatValue();
                    FolderRingAnimator.this.mOuterRingSize = (((1.0f - percent) * FolderIcon.OUTER_RING_GROWTH_FACTOR) + 1.0f) * previewSize;
                    FolderRingAnimator.this.mInnerRingSize = (((1.0f - percent) * FolderIcon.INNER_RING_GROWTH_FACTOR) + 1.0f) * previewSize;
                    if (FolderRingAnimator.this.mCellLayout != null) {
                        FolderRingAnimator.this.mCellLayout.invalidate();
                    }
                }
            });
            this.mNeutralAnimator.addListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationEnd(Animator animation) {
                    if (FolderRingAnimator.this.mCellLayout != null) {
                        FolderRingAnimator.this.mCellLayout.hideFolderAccept(FolderRingAnimator.this);
                    }
                    if (FolderRingAnimator.this.mFolderIcon != null) {
                        FolderRingAnimator.this.mFolderIcon.mPreviewBackground.setVisibility(android.view.View.VISIBLE);
                    }
                }
            });
            this.mNeutralAnimator.start();
        }

        public void getCell(int[] loc) {
            loc[0] = this.mCellX;
            loc[1] = this.mCellY;
        }

        public void setCell(int x, int y) {
            this.mCellX = x;
            this.mCellY = y;
        }

        public void setCellLayout(CellLayout layout) {
            this.mCellLayout = layout;
        }

        public float getOuterRingSize() {
            return this.mOuterRingSize;
        }

        public float getInnerRingSize() {
            return this.mInnerRingSize;
        }
    }

    Folder getFolder() {
        return this.mFolder;
    }

    FolderInfo getFolderInfo() {
        return this.mInfo;
    }

    private boolean willAcceptItem(ItemInfo item) {
        int itemType = item.itemType;
        return ((itemType != 0 && itemType != 1) || this.mFolder.isFull() || item == this.mInfo || this.mInfo.opened) ? false : true;
    }

    public boolean acceptDrop(Object dragInfo) {
        ItemInfo item = (ItemInfo) dragInfo;
        return !this.mFolder.isDestroyed() && willAcceptItem(item);
    }

    public void addItem(ShortcutInfo item) {
        this.mInfo.add(item);
    }

    public void onDragEnter(Object dragInfo) {
        if (!this.mFolder.isDestroyed() && willAcceptItem((ItemInfo) dragInfo)) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) getLayoutParams();
            CellLayout layout = (CellLayout) getParent().getParent();
            this.mFolderRingAnimator.setCell(lp.cellX, lp.cellY);
            this.mFolderRingAnimator.setCellLayout(layout);
            this.mFolderRingAnimator.animateToAcceptState();
            layout.showFolderAccept(this.mFolderRingAnimator);
        }
    }

    public void onDragOver(Object dragInfo) {
    }

    public void performCreateAnimation(ShortcutInfo destInfo, View destView, ShortcutInfo srcInfo, DragView srcView, Rect dstRect, float scaleRelativeToDragLayer, Runnable postAnimationRunnable) {
        int index = LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign);
        Drawable animateDrawable = ((TextView) destView).getCompoundDrawables()[index];
        computePreviewDrawingParams(animateDrawable.getIntrinsicWidth(), destView.getMeasuredWidth());
        animateFirstItem(animateDrawable, 350, false, null);
        addItem(destInfo);
        onDrop(srcInfo, srcView, dstRect, scaleRelativeToDragLayer, 1, postAnimationRunnable, null);
    }

    public void performDestroyAnimation(View finalView, Runnable onCompleteRunnable) {
        Drawable animateDrawable = ((TextView) finalView).getCompoundDrawables()[1];
        computePreviewDrawingParams(animateDrawable.getIntrinsicWidth(), finalView.getMeasuredWidth());
        animateFirstItem(animateDrawable, 200, true, onCompleteRunnable);
    }

    public void onDragExit(Object dragInfo) {
        onDragExit();
    }

    public void onDragExit() {
        this.mFolderRingAnimator.animateToNaturalState();
    }

    private void onDrop(final ShortcutInfo item, DragView animateView, Rect finalRect, float scaleRelativeToDragLayer, int index, Runnable postAnimationRunnable, DropTarget.DragObject d) {
        item.cellX = -1;
        item.cellY = -1;
        if (animateView != null) {
            DragLayer dragLayer = this.mLauncher.getDragLayer();
            Rect from = new Rect();
            dragLayer.getViewRectRelativeToSelf(animateView, from);
            Rect to = finalRect;
            if (to == null) {
                to = new Rect();
                Workspace workspace = this.mLauncher.getWorkspace();
                workspace.setFinalTransitionTransform((CellLayout) getParent().getParent());
                float scaleX = getScaleX();
                float scaleY = getScaleY();
                setScaleX(1.0f);
                setScaleY(1.0f);
                scaleRelativeToDragLayer = dragLayer.getDescendantRectRelativeToSelf(this, to);
                setScaleX(scaleX);
                setScaleY(scaleY);
                workspace.resetTransitionTransform((CellLayout) getParent().getParent());
            }
            int[] center = new int[2];
            float scale = getLocalCenterForIndex(index, center);
            center[0] = Math.round(scaleRelativeToDragLayer * center[0]);
            center[1] = Math.round(scaleRelativeToDragLayer * center[1]);
            to.offset(center[0] - (animateView.getMeasuredWidth() / 2), center[1] - (animateView.getMeasuredHeight() / 2));
            float finalAlpha = index < 3 ? 0.5f : 0.0f;
            float finalScale = scale * scaleRelativeToDragLayer;
            dragLayer.animateView(animateView, from, to, finalAlpha, 1.0f, 1.0f, finalScale, finalScale, 400, new DecelerateInterpolator(2.0f), new AccelerateInterpolator(2.0f), postAnimationRunnable, 0, null);
            addItem(item);
            this.mHiddenItems.add(item);
            this.mFolder.hideItem(item);
            postDelayed(new Runnable() { 
                @Override
                public void run() {
                    FolderIcon.this.mHiddenItems.remove(item);
                    FolderIcon.this.mFolder.showItem(item);
                    FolderIcon.this.invalidate();
                }
            }, 400L);
            return;
        }
        addItem(item);
    }

    public void onDrop(DropTarget.DragObject d) {
        ShortcutInfo item;
        if (d.dragInfo instanceof AppInfo) {
            item = ((AppInfo) d.dragInfo).makeShortcut();
        } else {
            item = (ShortcutInfo) d.dragInfo;
        }
        this.mFolder.notifyDrop();
        onDrop(item, d.dragView, null, 1.0f, this.mInfo.contents.size(), d.postAnimationRunnable, d);
    }

    private void computePreviewDrawingParams(int drawableSize, int totalSize) {
        if (this.mIntrinsicIconSize != drawableSize || this.mTotalWidth != totalSize) {
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            this.mIntrinsicIconSize = drawableSize;
            this.mTotalWidth = totalSize;
            int previewSize = this.mPreviewBackground.getLayoutParams().height;
            int previewPadding = FolderRingAnimator.sPreviewPadding;
            this.mAvailableSpaceInPreview = previewSize - (previewPadding * 2);
            int adjustedAvailableSpace = (int) ((this.mAvailableSpaceInPreview / 2) * 1.8f);
            int unscaledHeight = (int) (this.mIntrinsicIconSize * 1.24f);
            this.mBaselineIconScale = (1.0f * adjustedAvailableSpace) / unscaledHeight;
            this.mBaselineIconSize = (int) (this.mIntrinsicIconSize * this.mBaselineIconScale);
            this.mMaxPerspectiveShift = this.mBaselineIconSize * PERSPECTIVE_SHIFT_FACTOR;
            this.mPreviewOffsetX = (this.mTotalWidth - this.mAvailableSpaceInPreview) / 2;
            this.mPreviewOffsetY = grid.folderBackgroundOffset + previewPadding;
        }
    }

    private void computePreviewDrawingParams(Drawable d) {
        computePreviewDrawingParams(d.getIntrinsicWidth(), getMeasuredWidth());
    }

    class PreviewItemDrawingParams {
        Drawable drawable;
        int overlayAlpha;
        float scale;
        float transX;
        float transY;

        PreviewItemDrawingParams(float transX, float transY, float scale, int overlayAlpha) {
            this.transX = transX;
            this.transY = transY;
            this.scale = scale;
            this.overlayAlpha = overlayAlpha;
        }
    }

    private float getLocalCenterForIndex(int index, int[] center) {
        this.mParams = computePreviewItemDrawingParams(Math.min(3, index), this.mParams);
        this.mParams.transX += this.mPreviewOffsetX;
        this.mParams.transY += this.mPreviewOffsetY;
        float offsetX = this.mParams.transX + ((this.mParams.scale * this.mIntrinsicIconSize) / 2.0f);
        float offsetY = this.mParams.transY + ((this.mParams.scale * this.mIntrinsicIconSize) / 2.0f);
        center[0] = Math.round(offsetX);
        center[1] = Math.round(offsetY);
        return this.mParams.scale;
    }

    private PreviewItemDrawingParams computePreviewItemDrawingParams(int index, PreviewItemDrawingParams params) {
        float r = (((3 - index) - 1) * 1.0f) / 2.0f;
        float scale = 1.0f - (PERSPECTIVE_SCALE_FACTOR * (1.0f - r));
        float offset = (1.0f - r) * this.mMaxPerspectiveShift;
        float scaledSize = scale * this.mBaselineIconSize;
        float scaleOffsetCorrection = (1.0f - scale) * this.mBaselineIconSize;
        float transY = (this.mAvailableSpaceInPreview - ((offset + scaledSize) + scaleOffsetCorrection)) + getPaddingTop();
        float transX = offset + scaleOffsetCorrection;
        float totalScale = this.mBaselineIconScale * scale;
        int overlayAlpha = (int) (80.0f * (1.0f - r));
        if (params == null) {
            return new PreviewItemDrawingParams(transX, transY, totalScale, overlayAlpha);
        }
        params.transX = transX;
        params.transY = transY;
        params.scale = totalScale;
        params.overlayAlpha = overlayAlpha;
        return params;
    }

    private void drawPreviewItem(Canvas canvas, PreviewItemDrawingParams params) {
        canvas.save();
        canvas.translate(params.transX + this.mPreviewOffsetX, params.transY + this.mPreviewOffsetY);
        canvas.scale(params.scale, params.scale);
        Drawable d = params.drawable;
        if (d != null) {
            this.mOldBounds.set(d.getBounds());
            d.setBounds(0, 0, this.mIntrinsicIconSize, this.mIntrinsicIconSize);
            d.setFilterBitmap(true);
            d.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.argb(params.overlayAlpha, 255, 255, 255), BlendModeCompat.SRC_ATOP));
            d.draw(canvas);
            d.clearColorFilter();
            d.setFilterBitmap(false);
            d.setBounds(this.mOldBounds);
        }
        canvas.restore();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mFolder != null) {
            if (this.mFolder.getItemCount() != 0 || this.mAnimating) {
                ArrayList<View> items = this.mFolder.getItemsInReadingOrder();
                if (this.mAnimating) {
                    computePreviewDrawingParams(this.mAnimParams.drawable);
                } else {
                    Drawable d = ((TextView) items.get(0)).getCompoundDrawables()[1];
                    computePreviewDrawingParams(d);
                }
                int nItemsInPreview = Math.min(items.size(), 3);
                if (!this.mAnimating) {
                    for (int i = nItemsInPreview - 1; i >= 0; i--) {
                        TextView v = (TextView) items.get(i);
                        if (!this.mHiddenItems.contains(v.getTag())) {
                            Drawable d2 = v.getCompoundDrawables()[1];
                            this.mParams = computePreviewItemDrawingParams(i, this.mParams);
                            this.mParams.drawable = d2;
                            drawPreviewItem(canvas, this.mParams);
                        }
                    }
                    return;
                }
                drawPreviewItem(canvas, this.mAnimParams);
            }
        }
    }

    private void animateFirstItem(Drawable d, int duration, final boolean reverse, final Runnable onCompleteRunnable) {
        final PreviewItemDrawingParams finalParams = computePreviewItemDrawingParams(0, null);
        final float transX0 = (this.mAvailableSpaceInPreview - d.getIntrinsicWidth()) / 2;
        final float transY0 = ((this.mAvailableSpaceInPreview - d.getIntrinsicHeight()) / 2) + getPaddingTop();
        this.mAnimParams.drawable = d;
        ValueAnimator va = LauncherAnimUtils.ofFloat(this, 0.0f, 1.0f);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = ((Float) animation.getAnimatedValue()).floatValue();
                if (reverse) {
                    progress = 1.0f - progress;
                    FolderIcon.this.mPreviewBackground.setAlpha(progress);
                }
                FolderIcon.this.mAnimParams.transX = transX0 + ((finalParams.transX - transX0) * progress);
                FolderIcon.this.mAnimParams.transY = transY0 + ((finalParams.transY - transY0) * progress);
                FolderIcon.this.mAnimParams.scale = ((finalParams.scale - 1.0f) * progress) + 1.0f;
                FolderIcon.this.invalidate();
            }
        });
        va.addListener(new AnimatorListenerAdapter() { 
            @Override
            public void onAnimationStart(Animator animation) {
                FolderIcon.this.mAnimating = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                FolderIcon.this.mAnimating = false;
                if (onCompleteRunnable != null) {
                    onCompleteRunnable.run();
                }
            }
        });
        va.setDuration(duration);
        va.start();
    }

    public void setTextVisible(boolean visible) {
        if (visible) {
            this.mFolderName.setVisibility(View.VISIBLE);
        } else {
            this.mFolderName.setVisibility(View.INVISIBLE);
        }
    }

    public boolean getTextVisible() {
        return this.mFolderName.getVisibility() == View.VISIBLE;
    }

    @Override
    public void onItemsChanged() {
        invalidate();
        requestLayout();
    }

    @Override
    public void onAdd(ShortcutInfo item) {
        invalidate();
        requestLayout();
    }

    @Override
    public void onRemove(ShortcutInfo item) {
        invalidate();
        requestLayout();
    }

    @Override
    public void onTitleChanged(CharSequence title) {
        this.mFolderName.setText(title.toString());
        setContentDescription(String.format(getContext().getString(R.string.folder_name_format), title));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        switch (event.getAction()) {
            case 0:
                this.mLongPressHelper.postCheckForLongPress();
                break;
            case 1:
            case 3:
                this.mLongPressHelper.cancelLongPress();
                break;
        }
        return result;
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        this.mLongPressHelper.cancelLongPress();
    }
}
