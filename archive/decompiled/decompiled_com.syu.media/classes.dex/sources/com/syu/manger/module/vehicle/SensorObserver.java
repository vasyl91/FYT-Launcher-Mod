package com.syu.manger.module.vehicle;

import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/vehicle/SensorObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/vehicle/VehicleModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/vehicle/VehicleModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SensorObserver extends BaseModuleObserver<VehicleModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SensorObserver(ModuleManager moduleManager, VehicleModel vehicleModel) {
        super(moduleManager, vehicleModel, 19, 9);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(vehicleModel, "model");
    }

    public void onReceiver(Message msg) {
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        if (msg.code == 9 && Utils.checkIndex(msg.flts, 2)) {
            getModel().getXAngle().postValue(Float.valueOf(msg.flts[0]));
            getModel().getYAngle().postValue(Float.valueOf(msg.flts[2]));
            getModel().getZAngle().postValue(Float.valueOf(msg.flts[1]));
        }
    }
}
