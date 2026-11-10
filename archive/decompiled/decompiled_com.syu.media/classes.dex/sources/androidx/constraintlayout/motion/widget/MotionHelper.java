package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MotionHelper extends ConstraintHelper implements Animatable, MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    public void setProgress(View view, float f) {
    }

    public MotionHelper(Context context) {
        super(context);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(attributeSet);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.mUseOnShow = typedArrayObtainStyledAttributes.getBoolean(index, this.mUseOnShow);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.mUseOnHide = typedArrayObtainStyledAttributes.getBoolean(index, this.mUseOnHide);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float f) {
        this.mProgress = f;
        int i = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i < this.mCount) {
                setProgress(this.views[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f);
            }
            i++;
        }
    }
}
