package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    private Method mFireCross;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private Method mFirePositiveCross;
    private int mCurveFit = -1;
    private String mCross = null;
    private int mTriggerReceiver = UNSET;
    private String mNegativeCross = null;
    private String mPositiveCross = null;
    private int mTriggerID = UNSET;
    private int mTriggerCollisionId = UNSET;
    private View mTriggerCollisionView = null;
    float mTriggerSlack = 0.1f;
    private boolean mFireCrossReset = true;
    private boolean mFireNegativeReset = true;
    private boolean mFirePositiveReset = true;
    private float mFireThreshold = Float.NaN;
    private boolean mPostLayout = false;
    RectF mCollisionRect = new RectF();
    RectF mTargetRect = new RectF();

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }

    public KeyTrigger() {
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    private void setUpRect(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00af  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d7  */
    public void conditionallyFire(float f, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z4;
        boolean z5 = true;
        if (this.mTriggerCollisionId != UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mFireNegativeReset = true;
                z5 = z4;
                z3 = false;
            } else {
                if (this.mFireCrossReset) {
                    z = false;
                } else {
                    this.mFireCrossReset = true;
                    z = true;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mFirePositiveReset = true;
                z5 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f6 = this.mFireThreshold;
                if ((f - f6) * (this.mFireLastPos - f6) < 0.0f) {
                    this.mFireCrossReset = false;
                    z = true;
                }
                if (this.mFireNegativeReset) {
                    f4 = this.mFireThreshold;
                    f5 = f - f4;
                    if ((this.mFireLastPos - f4) * f5 >= 0.0f && f5 < 0.0f) {
                        this.mFireNegativeReset = false;
                        z2 = true;
                    }
                    if (this.mFirePositiveReset) {
                        f2 = this.mFireThreshold;
                        f3 = f - f2;
                        if ((this.mFireLastPos - f2) * f3 >= 0.0f && f3 > 0.0f) {
                            this.mFirePositiveReset = false;
                        }
                        z3 = z2;
                    } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFirePositiveReset = true;
                    }
                    z5 = false;
                    z3 = z2;
                } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFireNegativeReset = true;
                }
                z2 = false;
                if (this.mFirePositiveReset) {
                    f2 = this.mFireThreshold;
                    f3 = f - f2;
                    if ((this.mFireLastPos - f2) * f3 >= 0.0f) {
                    }
                    z3 = z2;
                } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFirePositiveReset = true;
                }
                z5 = false;
                z3 = z2;
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z = false;
            if (this.mFireNegativeReset) {
                f4 = this.mFireThreshold;
                f5 = f - f4;
                if ((this.mFireLastPos - f4) * f5 >= 0.0f) {
                }
                if (this.mFirePositiveReset) {
                    f2 = this.mFireThreshold;
                    f3 = f - f2;
                    if ((this.mFireLastPos - f2) * f3 >= 0.0f) {
                    }
                    z3 = z2;
                } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFirePositiveReset = true;
                }
                z5 = false;
                z3 = z2;
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireNegativeReset = true;
            }
            z2 = false;
            if (this.mFirePositiveReset) {
                f2 = this.mFireThreshold;
                f3 = f - f2;
                if ((this.mFireLastPos - f2) * f3 >= 0.0f) {
                }
                z3 = z2;
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFirePositiveReset = true;
            }
            z5 = false;
            z3 = z2;
        }
        this.mFireLastPos = f;
        if (z3 || z || z5) {
            ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f);
        }
        if (this.mTriggerReceiver != UNSET) {
            view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z3 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    Log.e("KeyTrigger", "Could not find method \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
        if (z5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    Log.e("KeyTrigger", "Could not find method \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new Object[0]);
            } catch (Exception unused4) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
        if (!z || this.mCross == null) {
            return;
        }
        if (this.mFireCross == null) {
            try {
                this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
            } catch (NoSuchMethodException unused5) {
                Log.e("KeyTrigger", "Could not find method \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
        try {
            this.mFireCross.invoke(view, new Object[0]);
        } catch (Exception unused6) {
            Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
        }
    }

    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                        break;
                    case 2:
                        keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                        break;
                    case 4:
                        keyTrigger.mCross = typedArray.getString(index);
                        continue;
                        break;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                        break;
                    case 6:
                        keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            if (keyTrigger.mTargetId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.mTargetString = typedArray.getString(index);
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                        }
                        break;
                    case 8:
                        keyTrigger.mFramePosition = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFireThreshold = (keyTrigger.mFramePosition + 0.5f) / 100.0f;
                        continue;
                        break;
                    case 9:
                        keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                        break;
                    case 10:
                        keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                        break;
                    case 11:
                        keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
            }
        }
    }
}
