package com.syu.manger.module.bt;

import chip.FinalChip;
import com.syu.remote.ModuleManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/syu/manger/module/bt/BluetoothObserver$updateIcon$1", "Ljava/lang/Runnable;", "run", FinalChip.BSP_PLATFORM_Null, "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BluetoothObserver$updateIcon$1 implements Runnable {
    public final /* synthetic */ BluetoothModel a;
    public final /* synthetic */ BluetoothObserver b;
    public final /* synthetic */ ModuleManager c;

    public BluetoothObserver$updateIcon$1(BluetoothModel bluetoothModel, BluetoothObserver bluetoothObserver, ModuleManager moduleManager) {
        this.a = bluetoothModel;
        this.b = bluetoothObserver;
        this.c = moduleManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Long value = this.a.getTrackChanged().getValue();
        if (value == null) {
            value = 0L;
        }
        this.a.getTrackChanged().postValue(Long.valueOf(value.longValue() + 1));
        if (this.b.b > 0) {
            if (this.b.b >= 4) {
                this.b.b = 0;
                j = -1;
            } else {
                j = 11000;
            }
            if (j > 0) {
                this.c.mHandler.postDelayed(this.b.d, j);
            }
        }
    }
}
