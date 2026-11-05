package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraintReferenceConstraints = this.mState.constraints(it.next());
            constraintReferenceConstraints.clearVertical();
            Object obj = this.mTopToTop;
            if (obj != null) {
                constraintReferenceConstraints.topToTop(obj);
            } else {
                Object obj2 = this.mTopToBottom;
                if (obj2 != null) {
                    constraintReferenceConstraints.topToBottom(obj2);
                } else {
                    constraintReferenceConstraints.topToTop(State.PARENT);
                }
            }
            Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraintReferenceConstraints.bottomToTop(obj3);
            } else {
                Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraintReferenceConstraints.bottomToBottom(obj4);
                } else {
                    constraintReferenceConstraints.bottomToBottom(State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraintReferenceConstraints.verticalBias(f);
            }
        }
    }

    public void topToTop(Object obj) {
        this.mTopToTop = obj;
    }

    public void topToBottom(Object obj) {
        this.mTopToBottom = obj;
    }

    public void bottomToTop(Object obj) {
        this.mBottomToTop = obj;
    }

    public void bottomToBottom(Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bias(float f) {
        this.mBias = f;
    }
}
