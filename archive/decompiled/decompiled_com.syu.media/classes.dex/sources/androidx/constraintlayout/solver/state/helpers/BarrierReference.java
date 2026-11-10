package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BarrierReference extends HelperReference {
    private Barrier mBarrierWidget;
    private State.Direction mDirection;
    private int mMargin;

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    public void setBarrierDirection(State.Direction direction) {
        this.mDirection = direction;
    }

    public void margin(Object obj) {
        margin(this.mState.convertDimension(obj));
    }

    public void margin(int i) {
        this.mMargin = i;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget == null) {
            this.mBarrierWidget = new Barrier();
        }
        return this.mBarrierWidget;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        getHelperWidget();
        int i = 0;
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()]) {
            case 3:
            case 4:
                i = 1;
                break;
            case 5:
                i = 2;
                break;
            case 6:
                i = 3;
                break;
        }
        this.mBarrierWidget.setBarrierType(i);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.BarrierReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;

        static {
            int[] iArr = new int[State.Direction.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = iArr;
            try {
                iArr[State.Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
