package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ConstraintLayout.LayoutParams) layoutParams);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.alpha = typedArrayObtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.elevation = typedArrayObtainStyledAttributes.getFloat(index, this.elevation);
                    this.applyElevation = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.rotationX = typedArrayObtainStyledAttributes.getFloat(index, this.rotationX);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.rotationY = typedArrayObtainStyledAttributes.getFloat(index, this.rotationY);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.rotation = typedArrayObtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.scaleX = typedArrayObtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.scaleY = typedArrayObtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.transformPivotX = typedArrayObtainStyledAttributes.getFloat(index, this.transformPivotX);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.transformPivotY = typedArrayObtainStyledAttributes.getFloat(index, this.transformPivotY);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.translationX = typedArrayObtainStyledAttributes.getFloat(index, this.translationX);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.translationY = typedArrayObtainStyledAttributes.getFloat(index, this.translationY);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.translationZ = typedArrayObtainStyledAttributes.getFloat(index, this.translationZ);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    private void init(AttributeSet attributeSet) {
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new ConstraintSet();
        }
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }
}
