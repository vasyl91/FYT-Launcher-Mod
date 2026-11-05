package com.syu.manger.module.record;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qin.x_core.client.java.DataObserver;
import qin.x_core.client.java.XCore;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/syu/manger/module/record/RecordObserver;", "Lqin/x_core/client/java/DataObserver;", "Landroid/os/Bundle;", "data", FinalChip.BSP_PLATFORM_Null, "onReceiver", "Lcom/syu/manger/module/record/RecordModel;", "b", "Lcom/syu/manger/module/record/RecordModel;", "getModel", "()Lcom/syu/manger/module/record/RecordModel;", "model", "<init>", "(Lcom/syu/manger/module/record/RecordModel;)V", "Companion", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class RecordObserver extends DataObserver {
    public static final String AppKey = "appid";
    public static final int CId_Altitude = 2;
    public static final int CId_AltitudeList = 11;
    public static final int CId_DrivingMileage = 3;
    public static final int CId_DrivingTime = 4;
    public static final int CId_InThis_AverageAltitude = 19;
    public static final int CId_InThis_AverageSpeed = 16;
    public static final int CId_InThis_MaxAltitude = 17;
    public static final int CId_InThis_MaxSpeed = 15;
    public static final int CId_InThis_MinAltitude = 18;
    public static final int CId_Latlng = 1;
    public static final int CId_Slope = 7;
    public static final int CId_Speed = 0;
    public static final int CId_SpeedList = 10;
    public static final int CId_TotalClimb = 5;
    public static final int CId_TotalDecline = 6;
    public static final int CId_Total_DrivingTime = 26;
    public static final int CId_Total_MaxAltitude = 30;
    public static final int CId_Total_MaxSpeed = 29;
    public static final int CId_Total_Mileage = 25;
    public static final int CId_Total_MinAltitude = 31;
    public static final int CId_Total_TotalClimb = 27;
    public static final int CId_Total_TotalDecline = 28;
    public static final int CId_UnitType = 40;
    public static final String ServiceAction = "com.syu.vehiclehistory.BackgroudService";
    public static final String ServicePkg = "com.syu.vehiclehistory";
    public static final int UnitType_China = 0;
    public static final int UnitType_English = 1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final RecordModel model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordObserver(RecordModel recordModel) {
        super(new int[]{0});
        Intrinsics.checkNotNullParameter(recordModel, "model");
        this.model = recordModel;
    }

    public final RecordModel getModel() {
        return this.model;
    }

    public void onReceiver(Bundle data) {
        LiveData mSpeed;
        int i;
        Object objValueOf;
        float f;
        long j;
        float f2;
        long[] jArrLongParamsOf;
        Intrinsics.checkNotNullParameter(data, "data");
        int iCmdIdOf = XCore.cmdIdOf(data);
        if (iCmdIdOf != 0) {
            if (iCmdIdOf == 7) {
                float[] fArrFloatParamsOf = XCore.floatParamsOf(data);
                if (fArrFloatParamsOf == null) {
                    return;
                }
                if (!(!(fArrFloatParamsOf.length == 0))) {
                    return;
                }
                mSpeed = this.model.getMSlope();
                f = fArrFloatParamsOf[0];
            } else if (iCmdIdOf == 40) {
                int[] iArrIntParamsOf = XCore.intParamsOf(data);
                if (iArrIntParamsOf == null) {
                    return;
                }
                if (!(!(iArrIntParamsOf.length == 0))) {
                    return;
                }
                mSpeed = this.model.getMUnit();
                i = iArrIntParamsOf[0];
            } else if (iCmdIdOf == 2) {
                float[] fArrFloatParamsOf2 = XCore.floatParamsOf(data);
                if (fArrFloatParamsOf2 == null) {
                    return;
                }
                if (!(!(fArrFloatParamsOf2.length == 0))) {
                    return;
                }
                mSpeed = this.model.getMAltitude();
                f = fArrFloatParamsOf2[0];
            } else {
                if (iCmdIdOf != 3) {
                    if (iCmdIdOf != 4) {
                        if (iCmdIdOf == 10) {
                            objValueOf = XCore.intArrayListOf(data);
                            if (objValueOf == null) {
                                return;
                            } else {
                                mSpeed = this.model.getMSpeedList();
                            }
                        } else if (iCmdIdOf != 11) {
                            if (iCmdIdOf == 15) {
                                float[] fArrFloatParamsOf3 = XCore.floatParamsOf(data);
                                if (fArrFloatParamsOf3 == null) {
                                    return;
                                }
                                if (!(!(fArrFloatParamsOf3.length == 0)) || fArrFloatParamsOf3.length <= 1) {
                                    return;
                                }
                                mSpeed = this.model.getMMaxSpeed();
                                f2 = fArrFloatParamsOf3[1];
                            } else if (iCmdIdOf == 16) {
                                float[] fArrFloatParamsOf4 = XCore.floatParamsOf(data);
                                if (fArrFloatParamsOf4 == null) {
                                    return;
                                }
                                if (!(!(fArrFloatParamsOf4.length == 0)) || fArrFloatParamsOf4.length <= 1) {
                                    return;
                                }
                                mSpeed = this.model.getMAverageSpeed();
                                f2 = fArrFloatParamsOf4[1];
                            } else if (iCmdIdOf == 25) {
                                float[] fArrFloatParamsOf5 = XCore.floatParamsOf(data);
                                if (fArrFloatParamsOf5 == null) {
                                    return;
                                }
                                if (!(!(fArrFloatParamsOf5.length == 0)) || fArrFloatParamsOf5.length <= 1) {
                                    return;
                                }
                                mSpeed = this.model.getMTotalMileage();
                                f = fArrFloatParamsOf5[1];
                            } else {
                                if (iCmdIdOf != 26 || (jArrLongParamsOf = XCore.longParamsOf(data)) == null) {
                                    return;
                                }
                                if (!(!(jArrLongParamsOf.length == 0))) {
                                    return;
                                }
                                mSpeed = this.model.getMTotalDrivingTime();
                                j = jArrLongParamsOf[0];
                            }
                            i = (int) f2;
                        } else {
                            objValueOf = XCore.intArrayListOf(data);
                            if (objValueOf == null) {
                                return;
                            } else {
                                mSpeed = this.model.getMAltitudeList();
                            }
                        }
                        mSpeed.postValue(objValueOf);
                    }
                    long[] jArrLongParamsOf2 = XCore.longParamsOf(data);
                    if (jArrLongParamsOf2 == null) {
                        return;
                    }
                    if (!(!(jArrLongParamsOf2.length == 0))) {
                        return;
                    }
                    mSpeed = this.model.getMDrivingTime();
                    j = jArrLongParamsOf2[0];
                    objValueOf = Long.valueOf(j);
                    mSpeed.postValue(objValueOf);
                }
                float[] fArrFloatParamsOf6 = XCore.floatParamsOf(data);
                if (fArrFloatParamsOf6 == null) {
                    return;
                }
                if (!(!(fArrFloatParamsOf6.length == 0)) || fArrFloatParamsOf6.length <= 1) {
                    return;
                }
                mSpeed = this.model.getMDrivingMileage();
                f = fArrFloatParamsOf6[1];
            }
            objValueOf = Float.valueOf(f);
            mSpeed.postValue(objValueOf);
        }
        int[] iArrIntParamsOf2 = XCore.intParamsOf(data);
        if (iArrIntParamsOf2 == null) {
            return;
        }
        if (!(!(iArrIntParamsOf2.length == 0)) || iArrIntParamsOf2.length <= 1) {
            return;
        }
        mSpeed = this.model.getMSpeed();
        i = iArrIntParamsOf2[1];
        objValueOf = Integer.valueOf(i);
        mSpeed.postValue(objValueOf);
    }
}
