package com.syu.manger.module.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.radio.Radio;
import com.syu.utils.Utils;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0014\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\u0007R\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002060\u00028\u0006¢\u0006\f\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007¨\u0006<"}, d2 = {"Lcom/syu/manger/module/main/MainModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Landroidx/lifecycle/MutableLiveData;", "getAppId", "()Landroidx/lifecycle/MutableLiveData;", "appId", "b", "getMcuOn", "mcuOn", "c", "getAccOn", "accOn", "d", "getScreenOn", "screenOn", "e", "isWeak", "f", "getReversing", "reversing", FinalChip.BSP_PLATFORM_Null, "g", "isHandbrakeOn", FinalChip.BSP_PLATFORM_Null, "h", "getDefNavi", "defNavi", "i", "isStandby", "j", "isLampOn", "k", "isRunning", "l", "getCity", Radio.CITY, "m", "getSpeed", "speed", "n", "getUiMode", "uiMode", "o", "getMBrightness", "mBrightness", "p", "getTopApp", "topApp", "q", "getMobileLink", "mobileLink", FinalChip.BSP_PLATFORM_Null, "r", "getMLocation", "mLocation", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class MainModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MutableLiveData appId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData mcuOn;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData accOn;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MutableLiveData screenOn;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final MutableLiveData isWeak;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final MutableLiveData reversing;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final MutableLiveData isHandbrakeOn;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final MutableLiveData defNavi;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final MutableLiveData isStandby;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final MutableLiveData isLampOn;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MutableLiveData isRunning;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final MutableLiveData city;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final MutableLiveData speed;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final MutableLiveData uiMode;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final MutableLiveData mBrightness;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final MutableLiveData topApp;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final MutableLiveData mobileLink;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final MutableLiveData mLocation;

    public MainModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(0);
        this.appId = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        mutableLiveData2.setValue(0);
        this.mcuOn = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        mutableLiveData3.setValue(0);
        this.accOn = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        mutableLiveData4.setValue(0);
        this.screenOn = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        mutableLiveData5.setValue(0);
        this.isWeak = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        mutableLiveData6.setValue(0);
        this.reversing = mutableLiveData6;
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        mutableLiveData7.setValue(Boolean.TRUE);
        this.isHandbrakeOn = mutableLiveData7;
        MutableLiveData mutableLiveData8 = new MutableLiveData();
        mutableLiveData8.setValue(FinalChip.BSP_PLATFORM_Null);
        this.defNavi = mutableLiveData8;
        MutableLiveData mutableLiveData9 = new MutableLiveData();
        Boolean bool = Boolean.FALSE;
        mutableLiveData9.setValue(bool);
        this.isStandby = mutableLiveData9;
        this.isLampOn = new MutableLiveData();
        this.isRunning = a.a(bool);
        this.city = new MutableLiveData();
        MutableLiveData mutableLiveData10 = new MutableLiveData();
        mutableLiveData10.setValue(0);
        this.speed = mutableLiveData10;
        MutableLiveData mutableLiveData11 = new MutableLiveData();
        mutableLiveData11.setValue(-1);
        this.uiMode = mutableLiveData11;
        MutableLiveData mutableLiveData12 = new MutableLiveData();
        mutableLiveData12.setValue(-1);
        this.mBrightness = mutableLiveData12;
        MutableLiveData mutableLiveData13 = new MutableLiveData();
        mutableLiveData13.setValue(FinalChip.BSP_PLATFORM_Null);
        this.topApp = mutableLiveData13;
        MutableLiveData mutableLiveData14 = new MutableLiveData();
        mutableLiveData14.setValue(Integer.valueOf(Utils.make16Int(-1, 3)));
        this.mobileLink = mutableLiveData14;
        MutableLiveData mutableLiveData15 = new MutableLiveData();
        mutableLiveData15.setValue(new float[]{0.0f, 0.0f, 0.0f});
        this.mLocation = mutableLiveData15;
    }

    public final MutableLiveData<Integer> getAccOn() {
        return this.accOn;
    }

    public final MutableLiveData<Integer> getAppId() {
        return this.appId;
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    public final MutableLiveData<String> getDefNavi() {
        return this.defNavi;
    }

    public final MutableLiveData<Integer> getMBrightness() {
        return this.mBrightness;
    }

    public final MutableLiveData<float[]> getMLocation() {
        return this.mLocation;
    }

    public final MutableLiveData<Integer> getMcuOn() {
        return this.mcuOn;
    }

    public final MutableLiveData<Integer> getMobileLink() {
        return this.mobileLink;
    }

    public final MutableLiveData<Integer> getReversing() {
        return this.reversing;
    }

    public final MutableLiveData<Integer> getScreenOn() {
        return this.screenOn;
    }

    public final MutableLiveData<Integer> getSpeed() {
        return this.speed;
    }

    public final MutableLiveData<String> getTopApp() {
        return this.topApp;
    }

    public final MutableLiveData<Integer> getUiMode() {
        return this.uiMode;
    }

    public final MutableLiveData<Boolean> isHandbrakeOn() {
        return this.isHandbrakeOn;
    }

    public final MutableLiveData<Boolean> isLampOn() {
        return this.isLampOn;
    }

    public final MutableLiveData<Boolean> isRunning() {
        return this.isRunning;
    }

    public final MutableLiveData<Boolean> isStandby() {
        return this.isStandby;
    }

    public final MutableLiveData<Integer> isWeak() {
        return this.isWeak;
    }
}
