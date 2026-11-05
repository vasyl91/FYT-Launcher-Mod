package com.syu.manger.module.vehicle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.module.main.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007¨\u0006("}, d2 = {"Lcom/syu/manger/module/vehicle/VehicleModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Landroidx/lifecycle/MutableLiveData;", "getMHood", "()Landroidx/lifecycle/MutableLiveData;", "mHood", "b", "getMDoorLf", "mDoorLf", "c", "getMDoorLr", "mDoorLr", "d", "getMDoorRf", "mDoorRf", "e", "getMDoorRr", "mDoorRr", "f", "getMTrunk", "mTrunk", FinalChip.BSP_PLATFORM_Null, "g", "getMBearing", "mBearing", FinalChip.BSP_PLATFORM_Null, "h", "getXAngle", "xAngle", "i", "getYAngle", "yAngle", "j", "getZAngle", "zAngle", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class VehicleModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MutableLiveData mHood;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData mDoorLf;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData mDoorLr;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MutableLiveData mDoorRf;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final MutableLiveData mDoorRr;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final MutableLiveData mTrunk;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final MutableLiveData mBearing;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final MutableLiveData xAngle;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final MutableLiveData yAngle;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final MutableLiveData zAngle;

    public VehicleModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        this.mHood = mutableLiveData;
        this.mDoorLf = a.a(bool);
        this.mDoorLr = a.a(bool);
        this.mDoorRf = a.a(bool);
        this.mDoorRr = a.a(bool);
        this.mTrunk = a.a(bool);
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        mutableLiveData2.setValue(0);
        this.mBearing = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        Float fValueOf = Float.valueOf(0.0f);
        mutableLiveData3.setValue(fValueOf);
        this.xAngle = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        mutableLiveData4.setValue(fValueOf);
        this.yAngle = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        mutableLiveData5.setValue(fValueOf);
        this.zAngle = mutableLiveData5;
    }

    public final MutableLiveData<Integer> getMBearing() {
        return this.mBearing;
    }

    public final MutableLiveData<Boolean> getMDoorLf() {
        return this.mDoorLf;
    }

    public final MutableLiveData<Boolean> getMDoorLr() {
        return this.mDoorLr;
    }

    public final MutableLiveData<Boolean> getMDoorRf() {
        return this.mDoorRf;
    }

    public final MutableLiveData<Boolean> getMDoorRr() {
        return this.mDoorRr;
    }

    public final MutableLiveData<Boolean> getMHood() {
        return this.mHood;
    }

    public final MutableLiveData<Boolean> getMTrunk() {
        return this.mTrunk;
    }

    public final MutableLiveData<Float> getXAngle() {
        return this.xAngle;
    }

    public final MutableLiveData<Float> getYAngle() {
        return this.yAngle;
    }

    public final MutableLiveData<Float> getZAngle() {
        return this.zAngle;
    }
}
