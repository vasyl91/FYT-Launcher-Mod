package com.sothree.slidinguppanel;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SlidingUpPanelLayout extends ViewGroup {
    private static final float DEFAULT_ANCHOR_POINT = 1.0f;
    private static final boolean DEFAULT_CLIP_PANEL_FLAG = true;
    private static final int DEFAULT_FADE_COLOR = -1728053248;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
    private static final boolean DEFAULT_OVERLAY_FLAG = false;
    private static final int DEFAULT_PANEL_HEIGHT = 68;
    private static final int DEFAULT_PARALLAX_OFFSET = 0;
    private static final int DEFAULT_SHADOW_HEIGHT = 4;
    public static final String SLIDING_STATE = "sliding_state";
    private static final String TAG = "SlidingUpPanelLayout";
    private float mAnchorPoint;
    private boolean mClipPanel;
    private int mCoveredFadeColor;
    private final Paint mCoveredFadePaint;
    private final ViewDragHelper mDragHelper;
    private View mDragView;
    private int mDragViewResId;
    private View.OnClickListener mFadeOnClickListener;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsScrollableViewHandlingTouch;
    private boolean mIsSlidingUp;
    private boolean mIsTouchEnabled;
    private boolean mIsUnableToDrag;
    private PanelState mLastNotDraggingSlideState;
    private View mMainView;
    private int mMinFlingVelocity;
    private boolean mOverlayContent;
    private int mPanelHeight;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxOffset;
    private float mPrevMotionX;
    private float mPrevMotionY;
    private View mScrollableView;
    private ScrollableViewHelper mScrollableViewHelper;
    private int mScrollableViewResId;
    private final Drawable mShadowDrawable;
    private int mShadowHeight;
    private float mSlideOffset;
    private int mSlideRange;
    private PanelState mSlideState;
    private View mSlideableView;
    private final Rect mTmpRect;
    private static PanelState DEFAULT_SLIDE_STATE = PanelState.COLLAPSED;
    private static final int[] DEFAULT_ATTRS = {R.attr.gravity};

    /* JADX INFO: renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState;

        static {
            int[] iArr = new int[PanelState.values().length];
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState = iArr;
            try {
                iArr[PanelState.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[PanelState.ANCHORED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[PanelState.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[PanelState.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int iComputePanelTopPosition = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
            int iComputePanelTopPosition2 = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            return SlidingUpPanelLayout.this.mIsSlidingUp ? Math.min(Math.max(i, iComputePanelTopPosition2), iComputePanelTopPosition) : Math.min(Math.max(i, iComputePanelTopPosition), iComputePanelTopPosition2);
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.mSlideRange;
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.setAllChildrenVisible();
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            SlidingUpPanelLayout slidingUpPanelLayout;
            PanelState panelState;
            if (SlidingUpPanelLayout.this.mDragHelper == null || SlidingUpPanelLayout.this.mDragHelper.getViewDragState() != 0) {
                return;
            }
            SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
            slidingUpPanelLayout2.mSlideOffset = slidingUpPanelLayout2.computeSlideOffset(slidingUpPanelLayout2.mSlideableView.getTop());
            SlidingUpPanelLayout.this.applyParallaxForCurrentSlideOffset();
            if (SlidingUpPanelLayout.this.mSlideOffset == 1.0f) {
                SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                slidingUpPanelLayout = SlidingUpPanelLayout.this;
                panelState = PanelState.EXPANDED;
            } else if (SlidingUpPanelLayout.this.mSlideOffset == 0.0f) {
                slidingUpPanelLayout = SlidingUpPanelLayout.this;
                panelState = PanelState.COLLAPSED;
            } else if (SlidingUpPanelLayout.this.mSlideOffset < 0.0f) {
                SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.HIDDEN);
                SlidingUpPanelLayout.this.mSlideableView.setVisibility(4);
                return;
            } else {
                SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                slidingUpPanelLayout = SlidingUpPanelLayout.this;
                panelState = PanelState.ANCHORED;
            }
            slidingUpPanelLayout.setPanelStateInternal(panelState);
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.onPanelDragged(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:29:0x0088  */
        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int iComputePanelTopPosition;
            if (SlidingUpPanelLayout.this.mIsSlidingUp) {
                f2 = -f2;
            }
            if (f2 > 0.0f && SlidingUpPanelLayout.this.mSlideOffset <= SlidingUpPanelLayout.this.mAnchorPoint) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                iComputePanelTopPosition = slidingUpPanelLayout.computePanelTopPosition(slidingUpPanelLayout.mAnchorPoint);
            } else if (f2 > 0.0f && SlidingUpPanelLayout.this.mSlideOffset > SlidingUpPanelLayout.this.mAnchorPoint) {
                iComputePanelTopPosition = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            } else if (f2 >= 0.0f || SlidingUpPanelLayout.this.mSlideOffset < SlidingUpPanelLayout.this.mAnchorPoint) {
                if (f2 >= 0.0f || SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint) {
                    if (SlidingUpPanelLayout.this.mSlideOffset >= (SlidingUpPanelLayout.this.mAnchorPoint + 1.0f) / 2.0f) {
                        iComputePanelTopPosition = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
                    } else if (SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint / 2.0f) {
                        SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                        iComputePanelTopPosition = slidingUpPanelLayout2.computePanelTopPosition(slidingUpPanelLayout2.mAnchorPoint);
                    }
                }
                iComputePanelTopPosition = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
            } else {
                SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                iComputePanelTopPosition = slidingUpPanelLayout3.computePanelTopPosition(slidingUpPanelLayout3.mAnchorPoint);
            }
            if (SlidingUpPanelLayout.this.mDragHelper != null) {
                SlidingUpPanelLayout.this.mDragHelper.settleCapturedViewAt(view.getLeft(), iComputePanelTopPosition);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingUpPanelLayout.this.mIsUnableToDrag || view != SlidingUpPanelLayout.this.mSlideableView) {
                return false;
            }
            return SlidingUpPanelLayout.DEFAULT_CLIP_PANEL_FLAG;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {R.attr.layout_weight};
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            if (typedArrayObtainStyledAttributes != null) {
                this.weight = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
        }
    }

    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyParallaxForCurrentSlideOffset() {
        if (this.mParallaxOffset > 0) {
            ViewCompat.setTranslationY(this.mMainView, getCurrentParallaxOffset());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int computePanelTopPosition(float f) {
        Log.e("float", "onLayout 0 ==========>> changed computePanelTopPosition slideOffset: " + f + " mIsSlidingUp : " + this.mIsSlidingUp);
        View view = this.mSlideableView;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i = (int) (f * this.mSlideRange);
        return this.mIsSlidingUp ? ((getMeasuredHeight() - getPaddingBottom()) - this.mPanelHeight) - i : (getPaddingTop() - measuredHeight) + this.mPanelHeight + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float computeSlideOffset(int i) {
        int iComputePanelTopPosition = computePanelTopPosition(0.0f);
        return (this.mIsSlidingUp ? iComputePanelTopPosition - i : i - iComputePanelTopPosition) / this.mSlideRange;
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return DEFAULT_CLIP_PANEL_FLAG;
    }

    private boolean isViewUnder(View view, int i, int i2) {
        int i3;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i;
        int i5 = iArr2[1] + i2;
        int i6 = iArr[0];
        if (i4 < i6 || i4 >= view.getWidth() + i6 || i5 < (i3 = iArr[1]) || i5 >= view.getHeight() + i3) {
            return false;
        }
        return DEFAULT_CLIP_PANEL_FLAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPanelDragged(int i) {
        PanelState panelState = this.mSlideState;
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            this.mLastNotDraggingSlideState = panelState;
        }
        setPanelStateInternal(panelState2);
        this.mSlideOffset = computeSlideOffset(i);
        applyParallaxForCurrentSlideOffset();
        dispatchOnPanelSlide(this.mSlideableView);
        LayoutParams layoutParams = (LayoutParams) this.mMainView.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.mPanelHeight;
        if (this.mSlideOffset <= 0.0f && !this.mOverlayContent) {
            int paddingBottom = this.mIsSlidingUp ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.mSlideableView.getMeasuredHeight()) - i;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = paddingBottom;
            if (paddingBottom == height) {
            }
            this.mMainView.requestLayout();
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1 || this.mOverlayContent) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        this.mMainView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.mSlideState;
        if (panelState2 == panelState) {
            return;
        }
        this.mSlideState = panelState;
        dispatchOnPanelStateChanged(this, panelState2, panelState);
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.add(panelSlideListener);
        }
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, DEFAULT_CLIP_PANEL_FLAG, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return DEFAULT_CLIP_PANEL_FLAG;
                }
            }
        }
        if (z && ViewCompat.canScrollHorizontally(view, -i)) {
            return DEFAULT_CLIP_PANEL_FLAG;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return DEFAULT_CLIP_PANEL_FLAG;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.mDragHelper;
        if (viewDragHelper == null || !viewDragHelper.continueSettling(DEFAULT_CLIP_PANEL_FLAG)) {
            return;
        }
        if (isEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            this.mDragHelper.abort();
        }
    }

    public void dispatchOnPanelSlide(View view) {
        synchronized (this.mPanelSlideListeners) {
            Iterator<PanelSlideListener> it = this.mPanelSlideListeners.iterator();
            while (it.hasNext()) {
                it.next().onPanelSlide(view, this.mSlideOffset);
            }
        }
    }

    public void dispatchOnPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.mPanelSlideListeners) {
            Iterator<PanelSlideListener> it = this.mPanelSlideListeners.iterator();
            while (it.hasNext()) {
                it.next().onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !isTouchEnabled() || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.abort();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.mIsScrollableViewHandlingTouch = false;
            this.mPrevMotionX = x;
            this.mPrevMotionY = y;
        } else {
            if (actionMasked == 2) {
                float f = x - this.mPrevMotionX;
                float f2 = y - this.mPrevMotionY;
                this.mPrevMotionX = x;
                this.mPrevMotionY = y;
                if (Math.abs(f) <= Math.abs(f2) && isViewUnder(this.mScrollableView, (int) this.mInitialMotionX, (int) this.mInitialMotionY)) {
                    boolean z = this.mIsSlidingUp;
                    if ((z ? 1 : -1) * f2 > 0.0f) {
                        if (this.mScrollableViewHelper.getScrollableViewScrollPosition(this.mScrollableView, z) > 0) {
                            this.mIsScrollableViewHandlingTouch = DEFAULT_CLIP_PANEL_FLAG;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        if (this.mIsScrollableViewHandlingTouch) {
                            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                            motionEventObtain.setAction(3);
                            super.dispatchTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                            motionEvent.setAction(0);
                        }
                        this.mIsScrollableViewHandlingTouch = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (f2 * (z ? 1 : -1) < 0.0f) {
                        if (this.mSlideOffset < 1.0f) {
                            this.mIsScrollableViewHandlingTouch = false;
                            return onTouchEvent(motionEvent);
                        }
                        if (!this.mIsScrollableViewHandlingTouch && this.mDragHelper.isDragging()) {
                            this.mDragHelper.cancel();
                            motionEvent.setAction(0);
                        }
                        this.mIsScrollableViewHandlingTouch = DEFAULT_CLIP_PANEL_FLAG;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (actionMasked == 1 && this.mIsScrollableViewHandlingTouch) {
                this.mDragHelper.setDragState(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view;
        int bottom;
        int bottom2;
        super.draw(canvas);
        if (this.mShadowDrawable == null || (view = this.mSlideableView) == null) {
            return;
        }
        int right = view.getRight();
        if (this.mIsSlidingUp) {
            bottom = this.mSlideableView.getTop() - this.mShadowHeight;
            bottom2 = this.mSlideableView.getTop();
        } else {
            bottom = this.mSlideableView.getBottom();
            bottom2 = this.mSlideableView.getBottom() + this.mShadowHeight;
        }
        this.mShadowDrawable.setBounds(this.mSlideableView.getLeft(), bottom, right, bottom2);
        this.mShadowDrawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild;
        int iSave = canvas.save();
        View view2 = this.mSlideableView;
        if (view2 == null || view2 == view) {
            zDrawChild = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.mTmpRect);
            if (!this.mOverlayContent) {
                if (this.mIsSlidingUp) {
                    Rect rect = this.mTmpRect;
                    rect.bottom = Math.min(rect.bottom, this.mSlideableView.getTop());
                } else {
                    Rect rect2 = this.mTmpRect;
                    rect2.top = Math.max(rect2.top, this.mSlideableView.getBottom());
                }
            }
            if (this.mClipPanel) {
                canvas.clipRect(this.mTmpRect);
            }
            zDrawChild = super.drawChild(canvas, view, j);
            int i = this.mCoveredFadeColor;
            if (i != 0) {
                float f = this.mSlideOffset;
                if (f > 0.0f) {
                    this.mCoveredFadePaint.setColor((i & 16777215) | (((int) ((((-16777216) & i) >>> 24) * f)) << 24));
                    canvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
                }
            }
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public float getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getCurrentParallaxOffset() {
        int iMax = (int) (Math.max(this.mSlideOffset, 0.0f) * this.mParallaxOffset);
        return this.mIsSlidingUp ? -iMax : iMax;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getPanelHeight() {
        return this.mPanelHeight;
    }

    public PanelState getPanelState() {
        return this.mSlideState;
    }

    public int getShadowHeight() {
        return this.mShadowHeight;
    }

    public boolean isClipPanel() {
        return this.mClipPanel;
    }

    public boolean isOverlayed() {
        return this.mOverlayContent;
    }

    public boolean isTouchEnabled() {
        if (!this.mIsTouchEnabled || this.mSlideableView == null || this.mSlideState == PanelState.HIDDEN) {
            return false;
        }
        return DEFAULT_CLIP_PANEL_FLAG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = DEFAULT_CLIP_PANEL_FLAG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = DEFAULT_CLIP_PANEL_FLAG;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mDragViewResId;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.mScrollableViewResId;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0054  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        if (this.mIsScrollableViewHandlingTouch || !isTouchEnabled()) {
            this.mDragHelper.abort();
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float fAbs = Math.abs(x - this.mInitialMotionX);
        float fAbs2 = Math.abs(y - this.mInitialMotionY);
        int touchSlop = this.mDragHelper.getTouchSlop();
        if (actionMasked == 0) {
            this.mIsUnableToDrag = false;
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (!isViewUnder(this.mDragView, (int) x, (int) y)) {
                this.mDragHelper.cancel();
                this.mIsUnableToDrag = DEFAULT_CLIP_PANEL_FLAG;
                return false;
            }
        } else if (actionMasked == 1) {
            if (this.mDragHelper.isDragging()) {
                this.mDragHelper.processTouchEvent(motionEvent);
                return DEFAULT_CLIP_PANEL_FLAG;
            }
            f = touchSlop;
            if (fAbs2 <= f && fAbs <= f && this.mSlideOffset > 0.0f && !isViewUnder(this.mSlideableView, (int) this.mInitialMotionX, (int) this.mInitialMotionY) && this.mFadeOnClickListener != null) {
                playSoundEffect(0);
                this.mFadeOnClickListener.onClick(this);
                return DEFAULT_CLIP_PANEL_FLAG;
            }
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragHelper.isDragging()) {
                    this.mDragHelper.processTouchEvent(motionEvent);
                    return DEFAULT_CLIP_PANEL_FLAG;
                }
                f = touchSlop;
                if (fAbs2 <= f) {
                    playSoundEffect(0);
                    this.mFadeOnClickListener.onClick(this);
                    return DEFAULT_CLIP_PANEL_FLAG;
                }
            }
        } else if (fAbs2 > touchSlop && fAbs > fAbs2) {
            this.mDragHelper.cancel();
            this.mIsUnableToDrag = DEFAULT_CLIP_PANEL_FLAG;
            return false;
        }
        return this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float fComputeSlideOffset;
        Log.e("float", "onLayout 0 ==========>> changed onPanelSlide " + String.format("%d, %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            int i5 = AnonymousClass2.$SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[this.mSlideState.ordinal()];
            if (i5 == 1) {
                fComputeSlideOffset = 1.0f;
            } else if (i5 != 2) {
                fComputeSlideOffset = 0.0f;
                if (i5 == 3) {
                    fComputeSlideOffset = computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight));
                }
            } else {
                fComputeSlideOffset = this.mAnchorPoint;
            }
            this.mSlideOffset = fComputeSlideOffset;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.mFirstLayout)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int iComputePanelTopPosition = childAt == this.mSlideableView ? computePanelTopPosition(this.mSlideOffset) : paddingTop;
                if (!this.mIsSlidingUp && childAt == this.mMainView && !this.mOverlayContent) {
                    iComputePanelTopPosition = computePanelTopPosition(this.mSlideOffset) + this.mSlideableView.getMeasuredHeight();
                }
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                childAt.layout(i7, iComputePanelTopPosition, childAt.getMeasuredWidth() + i7, measuredHeight + iComputePanelTopPosition);
            }
        }
        if (this.mFirstLayout) {
            updateObscuredViewVisibility();
        }
        applyParallaxForCurrentSlideOffset();
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824 && mode2 != Integer.MIN_VALUE) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        }
        this.mMainView = getChildAt(0);
        View childAt = getChildAt(1);
        this.mSlideableView = childAt;
        if (this.mDragView == null) {
            setDragView(childAt);
        }
        if (this.mSlideableView.getVisibility() != 0) {
            this.mSlideState = PanelState.HIDDEN;
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 || i5 != 0) {
                if (childAt2 == this.mMainView) {
                    i3 = (this.mOverlayContent || this.mSlideState == PanelState.HIDDEN) ? paddingTop : paddingTop - this.mPanelHeight;
                    i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                } else {
                    i3 = childAt2 == this.mSlideableView ? paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : paddingTop;
                    i4 = paddingLeft;
                }
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                int iMakeMeasureSpec2 = i6 == -2 ? View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE) : i6 == -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i7 == -2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                } else {
                    float f = layoutParams.weight;
                    if (f > 0.0f && f < 1.0f) {
                        i3 = (int) (i3 * f);
                    } else if (i7 != -1) {
                        i3 = i7;
                    }
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                }
                childAt2.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                View view = this.mSlideableView;
                if (childAt2 == view) {
                    this.mSlideRange = view.getMeasuredHeight() - this.mPanelHeight;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.mSlideState = panelState;
            if (panelState == null) {
                panelState = DEFAULT_SLIDE_STATE;
            }
            this.mSlideState = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        PanelState panelState = this.mSlideState;
        if (panelState == PanelState.DRAGGING) {
            panelState = this.mLastNotDraggingSlideState;
        }
        bundle.putSerializable(SLIDING_STATE, panelState);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.mFirstLayout = DEFAULT_CLIP_PANEL_FLAG;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.mDragHelper.processTouchEvent(motionEvent);
            return DEFAULT_CLIP_PANEL_FLAG;
        } catch (Exception unused) {
            return false;
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.remove(panelSlideListener);
        }
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setAnchorPoint(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return;
        }
        this.mAnchorPoint = f;
        this.mFirstLayout = DEFAULT_CLIP_PANEL_FLAG;
        requestLayout();
    }

    public void setClipPanel(boolean z) {
        this.mClipPanel = z;
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
        requestLayout();
    }

    public void setDragView(int i) {
        this.mDragViewResId = i;
        setDragView(findViewById(i));
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.mFadeOnClickListener = onClickListener;
    }

    public void setGravity(int i) {
        if (i != 48 && i != 80) {
            throw new IllegalArgumentException("gravity must be set to either top or bottom");
        }
        this.mIsSlidingUp = i == 80 ? DEFAULT_CLIP_PANEL_FLAG : false;
        if (this.mFirstLayout) {
            return;
        }
        requestLayout();
    }

    public void setMinFlingVelocity(int i) {
        this.mMinFlingVelocity = i;
    }

    public void setOverlayed(boolean z) {
        this.mOverlayContent = z;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() == i) {
            return;
        }
        this.mPanelHeight = i;
        if (!this.mFirstLayout) {
            requestLayout();
        }
        if (getPanelState() == PanelState.COLLAPSED) {
            smoothToBottom();
            invalidate();
        }
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        PanelState panelState3;
        float fComputeSlideOffset;
        if (this.mDragHelper.getViewDragState() == 2) {
            Log.d(TAG, "View is settling. Aborting animation.");
            this.mDragHelper.abort();
        }
        if (panelState == null || panelState == (panelState2 = PanelState.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        }
        if (isEnabled()) {
            boolean z = this.mFirstLayout;
            if ((!z && this.mSlideableView == null) || panelState == (panelState3 = this.mSlideState) || panelState3 == panelState2) {
                return;
            }
            if (z) {
                setPanelStateInternal(panelState);
                return;
            }
            if (panelState3 == PanelState.HIDDEN) {
                this.mSlideableView.setVisibility(0);
                requestLayout();
            }
            int i = AnonymousClass2.$SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[panelState.ordinal()];
            if (i == 1) {
                fComputeSlideOffset = 1.0f;
            } else if (i == 2) {
                fComputeSlideOffset = this.mAnchorPoint;
            } else {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    smoothSlideTo(0.0f, 0);
                    return;
                }
                fComputeSlideOffset = computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight));
            }
            smoothSlideTo(fComputeSlideOffset, 0);
        }
    }

    public void setParallaxOffset(int i) {
        this.mParallaxOffset = i;
        if (this.mFirstLayout) {
            return;
        }
        requestLayout();
    }

    public void setScrollableView(View view) {
        this.mScrollableView = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.mScrollableViewHelper = scrollableViewHelper;
    }

    public void setShadowHeight(int i) {
        this.mShadowHeight = i;
        if (this.mFirstLayout) {
            return;
        }
        invalidate();
    }

    public void setTouchEnabled(boolean z) {
        this.mIsTouchEnabled = z;
    }

    public boolean smoothSlideTo(float f, int i) {
        if (isEnabled() && this.mSlideableView != null) {
            int iComputePanelTopPosition = computePanelTopPosition(f);
            ViewDragHelper viewDragHelper = this.mDragHelper;
            View view = this.mSlideableView;
            if (viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iComputePanelTopPosition)) {
                setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation(this);
                return DEFAULT_CLIP_PANEL_FLAG;
            }
        }
        return false;
    }

    public void smoothToBottom() {
        smoothSlideTo(0.0f, 0);
    }

    public void updateObscuredViewVisibility() {
        int left;
        int right;
        int top;
        int bottom;
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View view = this.mSlideableView;
        int i = 0;
        if (view == null || !hasOpaqueBackground(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = this.mSlideableView.getLeft();
            right = this.mSlideableView.getRight();
            top = this.mSlideableView.getTop();
            bottom = this.mSlideableView.getBottom();
        }
        View childAt = getChildAt(0);
        int iMax = Math.max(paddingLeft, childAt.getLeft());
        int iMax2 = Math.max(paddingTop, childAt.getTop());
        int iMin = Math.min(width, childAt.getRight());
        int iMin2 = Math.min(height, childAt.getBottom());
        if (iMax >= left && iMax2 >= top && iMin <= right && iMin2 <= bottom) {
            i = 4;
        }
        childAt.setVisibility(i);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void setDragView(View view) {
        View view2 = this.mDragView;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.mDragView = view;
        if (view != null) {
            view.setClickable(DEFAULT_CLIP_PANEL_FLAG);
            this.mDragView.setFocusable(false);
            this.mDragView.setFocusableInTouchMode(false);
            this.mDragView.setOnClickListener(new View.OnClickListener() { // from class: com.sothree.slidinguppanel.SlidingUpPanelLayout.1
                /* JADX WARN: Code duplicated, block: B:15:0x003a  */
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    SlidingUpPanelLayout slidingUpPanelLayout;
                    if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.isTouchEnabled()) {
                        PanelState panelState = SlidingUpPanelLayout.this.mSlideState;
                        PanelState panelState2 = PanelState.EXPANDED;
                        if (panelState != panelState2) {
                            PanelState panelState3 = SlidingUpPanelLayout.this.mSlideState;
                            PanelState panelState4 = PanelState.ANCHORED;
                            if (panelState3 == panelState4) {
                                slidingUpPanelLayout = SlidingUpPanelLayout.this;
                                panelState2 = PanelState.COLLAPSED;
                            } else {
                                if (SlidingUpPanelLayout.this.mAnchorPoint < 1.0f) {
                                    SlidingUpPanelLayout.this.setPanelState(panelState4);
                                    return;
                                }
                                slidingUpPanelLayout = SlidingUpPanelLayout.this;
                            }
                        } else {
                            slidingUpPanelLayout = SlidingUpPanelLayout.this;
                            panelState2 = PanelState.COLLAPSED;
                        }
                        slidingUpPanelLayout.setPanelState(panelState2);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00e2  */
    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        Interpolator interpolatorLoadInterpolator;
        Resources resources;
        int i2;
        super(context, attributeSet, i);
        this.mMinFlingVelocity = 400;
        this.mCoveredFadeColor = DEFAULT_FADE_COLOR;
        this.mCoveredFadePaint = new Paint();
        this.mPanelHeight = -1;
        this.mShadowHeight = -1;
        this.mParallaxOffset = -1;
        this.mOverlayContent = false;
        this.mClipPanel = DEFAULT_CLIP_PANEL_FLAG;
        this.mDragViewResId = -1;
        this.mScrollableViewHelper = new ScrollableViewHelper();
        PanelState panelState = DEFAULT_SLIDE_STATE;
        this.mSlideState = panelState;
        this.mLastNotDraggingSlideState = panelState;
        this.mAnchorPoint = 1.0f;
        this.mIsScrollableViewHandlingTouch = false;
        this.mPanelSlideListeners = new CopyOnWriteArrayList();
        this.mFirstLayout = DEFAULT_CLIP_PANEL_FLAG;
        this.mTmpRect = new Rect();
        if (isInEditMode()) {
            this.mShadowDrawable = null;
            this.mDragHelper = null;
            return;
        }
        if (attributeSet == null) {
            interpolatorLoadInterpolator = null;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DEFAULT_ATTRS);
            if (typedArrayObtainStyledAttributes != null) {
                setGravity(typedArrayObtainStyledAttributes.getInt(0, 0));
                typedArrayObtainStyledAttributes.recycle();
            }
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, qin.widgets.R.styleable.SlidingUpPanelLayout);
            if (typedArrayObtainStyledAttributes2 != null) {
                this.mPanelHeight = typedArrayObtainStyledAttributes2.getDimensionPixelSize(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoPanelHeight, -1);
                this.mShadowHeight = typedArrayObtainStyledAttributes2.getDimensionPixelSize(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoShadowHeight, -1);
                this.mParallaxOffset = typedArrayObtainStyledAttributes2.getDimensionPixelSize(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoParallaxOffset, -1);
                this.mMinFlingVelocity = typedArrayObtainStyledAttributes2.getInt(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoFlingVelocity, 400);
                this.mCoveredFadeColor = typedArrayObtainStyledAttributes2.getColor(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoFadeColor, DEFAULT_FADE_COLOR);
                this.mDragViewResId = typedArrayObtainStyledAttributes2.getResourceId(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoDragView, -1);
                this.mScrollableViewResId = typedArrayObtainStyledAttributes2.getResourceId(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoScrollableView, -1);
                this.mOverlayContent = typedArrayObtainStyledAttributes2.getBoolean(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoOverlay, false);
                this.mClipPanel = typedArrayObtainStyledAttributes2.getBoolean(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoClipPanel, DEFAULT_CLIP_PANEL_FLAG);
                this.mAnchorPoint = typedArrayObtainStyledAttributes2.getFloat(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoAnchorPoint, 1.0f);
                this.mSlideState = PanelState.values()[typedArrayObtainStyledAttributes2.getInt(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoInitialState, DEFAULT_SLIDE_STATE.ordinal())];
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(qin.widgets.R.styleable.SlidingUpPanelLayout_umanoScrollInterpolator, -1);
                interpolatorLoadInterpolator = resourceId != -1 ? AnimationUtils.loadInterpolator(context, resourceId) : null;
                typedArrayObtainStyledAttributes2.recycle();
            } else {
                interpolatorLoadInterpolator = null;
            }
        }
        float f = context.getResources().getDisplayMetrics().density;
        if (this.mPanelHeight == -1) {
            this.mPanelHeight = (int) ((68.0f * f) + 0.5f);
        }
        if (this.mShadowHeight == -1) {
            this.mShadowHeight = (int) ((4.0f * f) + 0.5f);
        }
        if (this.mParallaxOffset == -1) {
            this.mParallaxOffset = (int) (0.0f * f);
        }
        if (this.mShadowHeight > 0) {
            if (this.mIsSlidingUp) {
                resources = getResources();
                i2 = qin.widgets.R.drawable.above_shadow;
            } else {
                resources = getResources();
                i2 = qin.widgets.R.drawable.below_shadow;
            }
            this.mShadowDrawable = resources.getDrawable(i2);
        } else {
            this.mShadowDrawable = null;
        }
        setWillNotDraw(false);
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(this, 0.5f, interpolatorLoadInterpolator, new DragHelperCallback());
        this.mDragHelper = viewDragHelperCreate;
        viewDragHelperCreate.setMinVelocity(this.mMinFlingVelocity * f);
        this.mIsTouchEnabled = DEFAULT_CLIP_PANEL_FLAG;
    }
}
