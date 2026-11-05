package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = USE_RESOLUTION;
    private int mMargin = 0;
    boolean resolved = false;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return USE_RESOLUTION;
    }

    public Barrier() {
    }

    public Barrier(String str) {
        setDebugName(str);
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    protected void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int i2 = this.mBarrierType;
            if (i2 == 0 || i2 == 1) {
                constraintWidget.setInBarrier(0, USE_RESOLUTION);
            } else if (i2 == 2 || i2 == 3) {
                constraintWidget.setInBarrier(1, USE_RESOLUTION);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        int i;
        int i2;
        int i3;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i4 = 0; i4 < this.mListAnchors.length; i4++) {
            this.mListAnchors[i4].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i4]);
        }
        int i5 = this.mBarrierType;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
        if (!this.resolved) {
            allSolved();
        }
        if (this.resolved) {
            this.resolved = false;
            int i6 = this.mBarrierType;
            if (i6 == 0 || i6 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else {
                if (i6 == 2 || i6 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                    return;
                }
                return;
            }
        }
        int i7 = 0;
        while (true) {
            if (i7 >= this.mWidgetsCount) {
                z2 = false;
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i7];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z2 = true;
                break;
            }
            i7++;
        }
        boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i8 = !(!z2 && (((i = this.mBarrierType) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        for (int i9 = 0; i9 < this.mWidgetsCount; i9++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i9];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = solverVariableCreateObjectVariable;
                int i10 = (constraintWidget2.mListAnchors[this.mBarrierType].mTarget == null || constraintWidget2.mListAnchors[this.mBarrierType].mTarget.mOwner != this) ? 0 : constraintWidget2.mListAnchors[this.mBarrierType].mMargin + 0;
                int i11 = this.mBarrierType;
                if (i11 == 0 || i11 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin - i10, z2);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i10, z2);
                }
                linearSystem.addEquality(constraintAnchor.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i10, i8);
            }
        }
        int i12 = this.mBarrierType;
        if (i12 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i12 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i12 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i12 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public void setMargin(int i) {
        this.mMargin = i;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    public boolean allSolved() {
        int i;
        int i2;
        boolean z = true;
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget = this.mWidgets[i3];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && !constraintWidget.isResolvedHorizontally()) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
        }
        if (!z || this.mWidgetsCount <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i4 = 0; i4 < this.mWidgetsCount; i4++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i4];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i5 = this.mBarrierType;
                    if (i5 == 0) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i5 == 1) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i5 == 2) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i5 == 3) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i6 = this.mBarrierType;
                if (i6 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i6 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i6 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i6 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i7 = iMax + this.mMargin;
        int i8 = this.mBarrierType;
        if (i8 == 0 || i8 == 1) {
            setFinalHorizontal(i7, i7);
        } else {
            setFinalVertical(i7, i7);
        }
        this.resolved = USE_RESOLUTION;
        return USE_RESOLUTION;
    }
}
