package com.syu.manger.module.record;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R-\u0010*\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`'0\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R-\u0010-\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`'0\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007¨\u00060"}, d2 = {"Lcom/syu/manger/module/record/RecordModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Landroidx/lifecycle/MutableLiveData;", "getMUnit", "()Landroidx/lifecycle/MutableLiveData;", "mUnit", "b", "getMSpeed", "mSpeed", FinalChip.BSP_PLATFORM_Null, "c", "getMAltitude", "mAltitude", "d", "getMSlope", "mSlope", "e", "getMDrivingMileage", "mDrivingMileage", FinalChip.BSP_PLATFORM_Null, "f", "getMDrivingTime", "mDrivingTime", "g", "getMTotalMileage", "mTotalMileage", "h", "getMTotalDrivingTime", "mTotalDrivingTime", "i", "getMMaxSpeed", "mMaxSpeed", "j", "getMAverageSpeed", "mAverageSpeed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "getMSpeedList", "mSpeedList", "l", "getMAltitudeList", "mAltitudeList", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class RecordModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MutableLiveData mUnit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData mSpeed;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData mAltitude;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MutableLiveData mSlope;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final MutableLiveData mDrivingMileage;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final MutableLiveData mDrivingTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final MutableLiveData mTotalMileage;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final MutableLiveData mTotalDrivingTime;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final MutableLiveData mMaxSpeed;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final MutableLiveData mAverageSpeed;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MutableLiveData mSpeedList;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final MutableLiveData mAltitudeList;

    public RecordModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(0);
        this.mUnit = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        mutableLiveData2.setValue(0);
        this.mSpeed = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        Float fValueOf = Float.valueOf(0.0f);
        mutableLiveData3.setValue(fValueOf);
        this.mAltitude = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        mutableLiveData4.setValue(fValueOf);
        this.mSlope = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        mutableLiveData5.setValue(fValueOf);
        this.mDrivingMileage = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        mutableLiveData6.setValue(0L);
        this.mDrivingTime = mutableLiveData6;
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        mutableLiveData7.setValue(fValueOf);
        this.mTotalMileage = mutableLiveData7;
        MutableLiveData mutableLiveData8 = new MutableLiveData();
        mutableLiveData8.setValue(0L);
        this.mTotalDrivingTime = mutableLiveData8;
        MutableLiveData mutableLiveData9 = new MutableLiveData();
        mutableLiveData9.setValue(0);
        this.mMaxSpeed = mutableLiveData9;
        MutableLiveData mutableLiveData10 = new MutableLiveData();
        mutableLiveData10.setValue(0);
        this.mAverageSpeed = mutableLiveData10;
        MutableLiveData mutableLiveData11 = new MutableLiveData();
        mutableLiveData11.setValue(CollectionsKt.arrayListOf(new Integer[]{0, 0}));
        this.mSpeedList = mutableLiveData11;
        MutableLiveData mutableLiveData12 = new MutableLiveData();
        mutableLiveData12.setValue(CollectionsKt.arrayListOf(new Integer[]{0, 0}));
        this.mAltitudeList = mutableLiveData12;
    }

    public final MutableLiveData<Float> getMAltitude() {
        return this.mAltitude;
    }

    public final MutableLiveData<ArrayList<Integer>> getMAltitudeList() {
        return this.mAltitudeList;
    }

    public final MutableLiveData<Integer> getMAverageSpeed() {
        return this.mAverageSpeed;
    }

    public final MutableLiveData<Float> getMDrivingMileage() {
        return this.mDrivingMileage;
    }

    public final MutableLiveData<Long> getMDrivingTime() {
        return this.mDrivingTime;
    }

    public final MutableLiveData<Integer> getMMaxSpeed() {
        return this.mMaxSpeed;
    }

    public final MutableLiveData<Float> getMSlope() {
        return this.mSlope;
    }

    public final MutableLiveData<Integer> getMSpeed() {
        return this.mSpeed;
    }

    public final MutableLiveData<ArrayList<Integer>> getMSpeedList() {
        return this.mSpeedList;
    }

    public final MutableLiveData<Long> getMTotalDrivingTime() {
        return this.mTotalDrivingTime;
    }

    public final MutableLiveData<Float> getMTotalMileage() {
        return this.mTotalMileage;
    }

    public final MutableLiveData<Integer> getMUnit() {
        return this.mUnit;
    }
}
