package androidx.draganddrop;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class DropAffordanceHighlighter {
    private static final int DEFAULT_COLOR = -16738680;
    static final int DEFAULT_CORNER_RADIUS_DP = 16;
    private static final int DEFAULT_GRAVITY = 119;
    static final float FILL_OPACITY_ACTIVE = 0.65f;
    static final float FILL_OPACITY_INACTIVE = 0.2f;
    private static final int STROKE_OPACITY_ACTIVE = 1;
    private static final float STROKE_OPACITY_INACTIVE = 0.4f;
    private static final int STROKE_WIDTH_DP = 3;
    private final boolean mAcceptDragsWithLocalState;
    private final Predicate<ClipDescription> mEligibilityPredicate;
    private final Drawable mHighlightAffordance;
    private Drawable mOriginalForeground;
    BlendMode mOriginalForegroundTintBlendMode;
    private ColorStateList mOriginalForegroundTintList;
    private PorterDuff.Mode mOriginalForegroundTintMode;
    private final Drawable mSelectedAffordance;
    final View mViewToHighlight;
    private boolean mDragInProgress = false;
    private final Set<View> mViewsWithDragFocus = new HashSet();
    private int mOriginalForegroundGravity = DEFAULT_GRAVITY;

    private static int colorWithOpacity(int i, float f) {
        return (i & 16777215) | (((int) (f * 255.0f)) << 24);
    }

    DropAffordanceHighlighter(View view, Predicate<ClipDescription> predicate, boolean z, int i, int i2) {
        this.mViewToHighlight = view;
        this.mEligibilityPredicate = predicate;
        this.mAcceptDragsWithLocalState = z;
        int iColorWithOpacity = colorWithOpacity(i, 0.2f);
        int iColorWithOpacity2 = colorWithOpacity(i, FILL_OPACITY_ACTIVE);
        int iColorWithOpacity3 = colorWithOpacity(i, STROKE_OPACITY_INACTIVE);
        int iColorWithOpacity4 = colorWithOpacity(i, 1.0f);
        this.mHighlightAffordance = makeDrawable(view.getContext(), iColorWithOpacity, iColorWithOpacity3, i2);
        this.mSelectedAffordance = makeDrawable(view.getContext(), iColorWithOpacity2, iColorWithOpacity4, i2);
    }

    static Builder forView(View view, Predicate<ClipDescription> predicate) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(predicate);
        return new Builder(view, predicate);
    }

    boolean onDrag(View view, DragEvent dragEvent) {
        if (!this.mAcceptDragsWithLocalState && dragEvent.getLocalState() != null) {
            return false;
        }
        int action = dragEvent.getAction();
        if (action != 4 && !this.mEligibilityPredicate.test(dragEvent.getClipDescription())) {
            return false;
        }
        handleDragEvent(view, action);
        return action == 1;
    }

    private void handleDragEvent(View view, int i) {
        if (i != 1) {
            if (i != 4) {
                if (i == 5) {
                    this.mViewsWithDragFocus.add(view);
                } else if (i == 6) {
                    this.mViewsWithDragFocus.remove(view);
                }
            } else if (this.mDragInProgress) {
                this.mDragInProgress = false;
                restoreOriginalForeground();
                this.mViewsWithDragFocus.clear();
            }
        } else if (!this.mDragInProgress) {
            this.mDragInProgress = true;
            backUpOriginalForeground();
        }
        if (this.mDragInProgress) {
            if (!this.mViewsWithDragFocus.isEmpty()) {
                this.mViewToHighlight.setForeground(this.mSelectedAffordance);
            } else {
                this.mViewToHighlight.setForeground(this.mHighlightAffordance);
            }
        }
    }

    private static GradientDrawable makeDrawable(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(dpToPx(context, 3), i2);
        gradientDrawable.setCornerRadius(i3);
        return gradientDrawable;
    }

    static int dpToPx(Context context, int i) {
        return Math.round(Math.max(0, i) * context.getResources().getDisplayMetrics().density);
    }

    private void backUpOriginalForeground() {
        this.mOriginalForeground = this.mViewToHighlight.getForeground();
        this.mOriginalForegroundGravity = this.mViewToHighlight.getForegroundGravity();
        this.mOriginalForegroundTintList = this.mViewToHighlight.getForegroundTintList();
        this.mOriginalForegroundTintMode = this.mViewToHighlight.getForegroundTintMode();
        this.mViewToHighlight.setForegroundGravity(DEFAULT_GRAVITY);
        this.mViewToHighlight.setForegroundTintList(null);
        this.mViewToHighlight.setForegroundTintMode(null);
        if (Build.VERSION.SDK_INT >= 29) {
            Api29BackUpImpl.backUp(this);
        }
    }

    private void restoreOriginalForeground() {
        this.mViewToHighlight.setForeground(this.mOriginalForeground);
        this.mViewToHighlight.setForegroundGravity(this.mOriginalForegroundGravity);
        this.mViewToHighlight.setForegroundTintList(this.mOriginalForegroundTintList);
        this.mViewToHighlight.setForegroundTintMode(this.mOriginalForegroundTintMode);
        this.mOriginalForeground = null;
        this.mOriginalForegroundGravity = DEFAULT_GRAVITY;
        this.mOriginalForegroundTintList = null;
        this.mOriginalForegroundTintMode = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Api29RestoreImpl.restore(this);
        }
    }

    private static class Api29BackUpImpl {
        private Api29BackUpImpl() {
        }

        static void backUp(DropAffordanceHighlighter dropAffordanceHighlighter) {
            dropAffordanceHighlighter.mOriginalForegroundTintBlendMode = dropAffordanceHighlighter.mViewToHighlight.getForegroundTintBlendMode();
            dropAffordanceHighlighter.mViewToHighlight.setForegroundTintBlendMode(null);
        }
    }

    private static class Api29RestoreImpl {
        private Api29RestoreImpl() {
        }

        static void restore(DropAffordanceHighlighter dropAffordanceHighlighter) {
            dropAffordanceHighlighter.mViewToHighlight.setForegroundTintBlendMode(dropAffordanceHighlighter.mOriginalForegroundTintBlendMode);
            dropAffordanceHighlighter.mOriginalForegroundTintBlendMode = null;
        }
    }

    static final class Builder {
        private boolean mAcceptDragsWithLocalState;
        private int mCornerRadiusPx;
        private final Predicate<ClipDescription> mEligibilityPredicate;
        private int mHighlightColor;
        private boolean mHighlightColorHasBeenSupplied = false;
        private final View mViewToHighlight;

        Builder(View view, Predicate<ClipDescription> predicate) {
            this.mViewToHighlight = view;
            this.mEligibilityPredicate = predicate;
            this.mCornerRadiusPx = DropAffordanceHighlighter.dpToPx(view.getContext(), 16);
        }

        Builder setHighlightColor(int i) {
            this.mHighlightColor = i;
            this.mHighlightColorHasBeenSupplied = true;
            return this;
        }

        Builder setHighlightCornerRadiusPx(int i) {
            this.mCornerRadiusPx = i;
            return this;
        }

        Builder shouldAcceptDragsWithLocalState(boolean z) {
            this.mAcceptDragsWithLocalState = z;
            return this;
        }

        DropAffordanceHighlighter build() {
            return new DropAffordanceHighlighter(this.mViewToHighlight, this.mEligibilityPredicate, this.mAcceptDragsWithLocalState, getHighlightColor(), this.mCornerRadiusPx);
        }

        private int getHighlightColor() {
            if (this.mHighlightColorHasBeenSupplied) {
                return this.mHighlightColor;
            }
            TypedArray typedArrayObtainStyledAttributes = this.mViewToHighlight.getContext().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.colorAccent});
            try {
                return typedArrayObtainStyledAttributes.getColor(0, DropAffordanceHighlighter.DEFAULT_COLOR);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }
}
