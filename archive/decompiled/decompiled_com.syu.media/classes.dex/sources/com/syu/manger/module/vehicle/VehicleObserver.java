package com.syu.manger.module.vehicle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/vehicle/VehicleObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/vehicle/VehicleModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/vehicle/VehicleModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VehicleObserver extends BaseModuleObserver<VehicleModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VehicleObserver(ModuleManager moduleManager, VehicleModel vehicleModel) {
        super(moduleManager, vehicleModel, 7, 0, 1, 2, 3, 4, 5, 1033);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(vehicleModel, "model");
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b5 A[PHI: r0
  0x00b5: PHI (r0v22 androidx.lifecycle.LiveData) = 
  (r0v21 androidx.lifecycle.LiveData)
  (r0v28 androidx.lifecycle.LiveData)
  (r0v33 androidx.lifecycle.LiveData)
  (r0v38 androidx.lifecycle.LiveData)
  (r0v43 androidx.lifecycle.LiveData)
  (r0v48 androidx.lifecycle.LiveData)
 binds: [B:44:0x00b3, B:39:0x009a, B:34:0x0081, B:29:0x0068, B:24:0x004f, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    public void onReceiver(Message msg) {
        LiveData mBearing;
        Object objValueOf;
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        int i = msg.code;
        boolean z = false;
        if (i != 1033) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5 || !Utils.checkIndex(msg.ints, 0)) {
                                    return;
                                }
                                mBearing = getModel().getMTrunk();
                                if (msg.ints[0] == 1) {
                                    z = true;
                                }
                            } else {
                                if (!Utils.checkIndex(msg.ints, 0)) {
                                    return;
                                }
                                mBearing = getModel().getMDoorRr();
                                if (msg.ints[0] == 1) {
                                    z = true;
                                }
                            }
                        } else {
                            if (!Utils.checkIndex(msg.ints, 0)) {
                                return;
                            }
                            mBearing = getModel().getMDoorLr();
                            if (msg.ints[0] == 1) {
                                z = true;
                            }
                        }
                    } else {
                        if (!Utils.checkIndex(msg.ints, 0)) {
                            return;
                        }
                        mBearing = getModel().getMDoorRf();
                        if (msg.ints[0] == 1) {
                            z = true;
                        }
                    }
                } else {
                    if (!Utils.checkIndex(msg.ints, 0)) {
                        return;
                    }
                    mBearing = getModel().getMDoorLf();
                    if (msg.ints[0] == 1) {
                        z = true;
                    }
                }
            } else {
                if (!Utils.checkIndex(msg.ints, 0)) {
                    return;
                }
                mBearing = getModel().getMHood();
                if (msg.ints[0] == 1) {
                    z = true;
                }
            }
            objValueOf = Boolean.valueOf(z);
        } else {
            if (!Utils.checkIndex(msg.ints, 0) || msg.ints[0] <= 0) {
                return;
            }
            Integer value = AutoManager.INSTANCE.requestInstance().getMainModel().getSpeed().getValue();
            Intrinsics.checkNotNull(value);
            if (value.intValue() <= 0) {
                return;
            }
            mBearing = getModel().getMBearing();
            objValueOf = Integer.valueOf(msg.ints[0]);
        }
        mBearing.postValue(objValueOf);
    }
}
