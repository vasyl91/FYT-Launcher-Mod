package qin.widgets;

import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"qin/widgets/VernierRulerView$updateVernier$1", "Ljava/lang/Runnable;", "run", "", "Components_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VernierRulerView$updateVernier$1 implements Runnable {
    public final /* synthetic */ VernierRulerView a;

    public VernierRulerView$updateVernier$1(VernierRulerView vernierRulerView) {
        this.a = vernierRulerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Math.abs(this.a.getMDx()) > this.a.getMoveSpeed()) {
            float moveSpeed = this.a.getMDx() > 0.0f ? -this.a.getMoveSpeed() : this.a.getMoveSpeed();
            VernierRulerView vernierRulerView = this.a;
            vernierRulerView.setMDx(vernierRulerView.getMDx() + moveSpeed);
            VernierRulerView vernierRulerView2 = this.a;
            vernierRulerView2.setMoveSpeed(VernierRulerView.access$speed(vernierRulerView2, vernierRulerView2.getMDx()));
            this.a.getMHandler().postDelayed(this, 0L);
            VernierRulerView vernierRulerView3 = this.a;
            this.a.setTickPosition(vernierRulerView3.validPosition(vernierRulerView3.getTickPosition() - moveSpeed));
            return;
        }
        VernierRulerView vernierRulerView4 = this.a;
        vernierRulerView4.setMTick(VernierRulerView.access$tickAt(vernierRulerView4, this.a.getMDx() + vernierRulerView4.getTickPosition()));
        this.a.setMDx(0.0f);
        this.a.setMoveSpeed(0.0f);
        if (this.a.q) {
            VernierRulerView.OnTickChangedListener onTickChangedListener = this.a.getOnTickChangedListener();
            if (onTickChangedListener != null) {
                onTickChangedListener.onTickChanged(this.a.mTick);
            }
            VernierRulerView vernierRulerView5 = this.a;
            vernierRulerView5.q = vernierRulerView5.p;
        }
    }
}
