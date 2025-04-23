package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

public class SearchDropTargetBar extends FrameLayout implements DragController.DragListener {
    private static final AccelerateInterpolator sAccelerateInterpolator = new AccelerateInterpolator();
    private static final int sTransitionInDuration = 200;
    private static final int sTransitionOutDuration = 175;
    private int mBarHeight;
    private boolean mDeferOnDragEnd;
    private ButtonDropTarget mDeleteDropTarget;
    private View mDropTargetBar;
    private ObjectAnimator mDropTargetBarAnim;
    private boolean mEnableDropDownDropTargets;
    private boolean mIsSearchBarHidden;
    private Drawable mPreviousBackground;
    private View mQSBSearchBar;
    private ObjectAnimator mQSBSearchBarAnim;

    public SearchDropTargetBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchDropTargetBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mDeferOnDragEnd = false;
    }

    public void setup(Launcher launcher, DragController dragController) {
        dragController.addDragListener(this);
        dragController.addDragListener(this.mDeleteDropTarget);
        dragController.addDropTarget(this.mDeleteDropTarget);
        dragController.setFlingToDeleteDropTarget(this.mDeleteDropTarget);
        this.mDeleteDropTarget.setLauncher(launcher);
        this.mQSBSearchBar = launcher.getQsbBar();
        if (this.mEnableDropDownDropTargets) {
            this.mQSBSearchBarAnim = LauncherAnimUtils.ofFloat(this.mQSBSearchBar, "translationY", 0.0f, -this.mBarHeight);
        } else {
            this.mQSBSearchBarAnim = LauncherAnimUtils.ofFloat(this.mQSBSearchBar, "alpha", 1.0f, 0.0f);
        }
        setupAnimation(this.mQSBSearchBarAnim, this.mQSBSearchBar);
    }

    private void prepareStartAnimation(View v) {
        v.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    private void setupAnimation(ObjectAnimator anim, final View v) {
        anim.setInterpolator(sAccelerateInterpolator);
        anim.setDuration(200L);
        anim.addListener(new AnimatorListenerAdapter() { 
            @Override
            public void onAnimationEnd(Animator animation) {
                v.setLayerType(View.LAYER_TYPE_NONE, null);
            }
        });
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mDropTargetBar = findViewById(R.id.drag_target_bar);
        this.mDeleteDropTarget = (ButtonDropTarget) this.mDropTargetBar.findViewById(R.id.delete_target_text);
        this.mQSBSearchBar = findViewById(R.id.qsb_search_bar);
        this.mDeleteDropTarget.setSearchDropTargetBar(this);
        this.mEnableDropDownDropTargets = getResources().getBoolean(R.bool.config_useDropTargetDownTransition);
        if (this.mEnableDropDownDropTargets) {
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            this.mBarHeight = grid.searchBarSpaceHeightPx;
            this.mDropTargetBar.setTranslationY(-this.mBarHeight);
            this.mDropTargetBarAnim = LauncherAnimUtils.ofFloat(this.mDropTargetBar, "translationY", -this.mBarHeight, 0.0f);
            this.mQSBSearchBarAnim = LauncherAnimUtils.ofFloat(this.mQSBSearchBar, "translationY", 0.0f, -this.mBarHeight);
        } else {
            this.mDropTargetBar.setAlpha(0.0f);
            this.mDropTargetBarAnim = LauncherAnimUtils.ofFloat(this.mDropTargetBar, "alpha", 0.0f, 1.0f);
            this.mQSBSearchBarAnim = LauncherAnimUtils.ofFloat(this.mQSBSearchBar, "alpha", 1.0f, 0.0f);
        }
        setupAnimation(this.mDropTargetBarAnim, this.mDropTargetBar);
        setupAnimation(this.mQSBSearchBarAnim, this.mQSBSearchBar);
    }

    public void finishAnimations() {
        prepareStartAnimation(this.mDropTargetBar);
        this.mDropTargetBarAnim.reverse();
        prepareStartAnimation(this.mQSBSearchBar);
        this.mQSBSearchBarAnim.reverse();
    }

    public void showSearchBar(boolean animated) {
        if (this.mQSBSearchBar == null && this.mIsSearchBarHidden) {
            if (animated) {
                prepareStartAnimation(this.mQSBSearchBar);
                this.mQSBSearchBarAnim.reverse();
            } else {
                this.mQSBSearchBarAnim.cancel();
                if (this.mEnableDropDownDropTargets) {
                    this.mQSBSearchBar.setTranslationY(0.0f);
                } else {
                    this.mQSBSearchBar.setAlpha(1.0f);
                }
            }
            this.mIsSearchBarHidden = false;
        }
    }

    public void hideSearchBar(boolean animated) {
        if (this.mQSBSearchBar != null && !this.mIsSearchBarHidden) {
            if (animated) {
                prepareStartAnimation(this.mQSBSearchBar);
                this.mQSBSearchBarAnim.start();
            } else {
                this.mQSBSearchBarAnim.cancel();
                if (this.mEnableDropDownDropTargets) {
                    this.mQSBSearchBar.setTranslationY(-this.mBarHeight);
                } else {
                    this.mQSBSearchBar.setAlpha(0.0f);
                }
            }
            this.mIsSearchBarHidden = true;
        }
    }

    public int getTransitionInDuration() {
        return 200;
    }

    public int getTransitionOutDuration() {
        return 175;
    }

    @Override
    public void onDragStart(DragSource source, Object info, int dragAction) {
        prepareStartAnimation(this.mDropTargetBar);
        this.mDropTargetBarAnim.start();
        if (DeleteDropTarget.willAcceptDrop(info) && Launcher.getLauncher().mAllAppsButton != null) {
            Launcher.getLauncher().mAllAppsButton.setVisibility(View.GONE);
        }
        if (this.mQSBSearchBar != null) {
            prepareStartAnimation(this.mQSBSearchBar);
            this.mQSBSearchBarAnim.start();
        }
    }

    public void deferOnDragEnd() {
        this.mDeferOnDragEnd = true;
    }

    @Override
    public void onDragEnd() {
        if (!this.mDeferOnDragEnd) {
            prepareStartAnimation(this.mDropTargetBar);
            this.mDropTargetBarAnim.reverse();
            if (Launcher.getLauncher().mAllAppsButton != null) {
                Launcher.getLauncher().mAllAppsButton.setVisibility(View.VISIBLE);
            }
            if (!this.mIsSearchBarHidden && this.mQSBSearchBar != null) {
                prepareStartAnimation(this.mQSBSearchBar);
                this.mQSBSearchBarAnim.reverse();
                return;
            }
            return;
        }
        this.mDeferOnDragEnd = false;
    }

    public void onSearchPackagesChanged(boolean searchVisible, boolean voiceVisible) {
        if (this.mQSBSearchBar != null) {
            Drawable bg = this.mQSBSearchBar.getBackground();
            if (bg != null && !searchVisible && !voiceVisible) {
                this.mPreviousBackground = bg;
                this.mQSBSearchBar.setBackgroundResource(0);
            } else if (this.mPreviousBackground != null) {
                if (searchVisible || voiceVisible) {
                    this.mQSBSearchBar.setBackground(this.mPreviousBackground);
                }
            }
        }
    }

    public Rect getSearchBarBounds() {
        if (this.mQSBSearchBar == null) {
            return null;
        }
        int[] pos = new int[2];
        this.mQSBSearchBar.getLocationOnScreen(pos);
        Rect rect = new Rect();
        rect.left = pos[0];
        rect.top = pos[1];
        rect.right = pos[0] + this.mQSBSearchBar.getWidth();
        rect.bottom = pos[1] + this.mQSBSearchBar.getHeight();
        return rect;
    }
}
