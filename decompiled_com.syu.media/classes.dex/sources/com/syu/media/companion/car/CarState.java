package com.syu.media.companion.car;

import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.syu.manger.module.main.MainModel;
import com.syu.media.MediaApp;
import com.syu.media.base.BaseAct;
import com.syu.media.companion.utils.HiLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CarState.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/syu/media/companion/car/CarState;", FinalChip.BSP_PLATFORM_Null, "act", "Lcom/syu/media/base/BaseAct;", "(Lcom/syu/media/base/BaseAct;)V", "accOn", FinalChip.BSP_PLATFORM_Null, "getAccOn", "()I", "setAccOn", "(I)V", "appId", "getAppId", "setAppId", "isLampOn", FinalChip.BSP_PLATFORM_Null, "()Z", "setLampOn", "(Z)V", "isRunning", "setRunning", "isWeak", "setWeak", "mcuOn", "getMcuOn", "setMcuOn", "screenOn", "getScreenOn", "setScreenOn", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarState {
    public static final String TAG = "CarState";
    private int accOn;
    private final BaseAct act;
    private int appId;
    private boolean isLampOn;
    private boolean isRunning;
    private int isWeak;
    private int mcuOn;
    private int screenOn;

    public CarState(BaseAct baseAct) {
        Intrinsics.checkNotNullParameter(baseAct, "act");
        this.act = baseAct;
        MainModel mainModel = MediaApp.INSTANCE.getMe().getMainModel();
        mainModel.getAppId().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m141lambda7$lambda0(this.f$0, (Integer) obj);
            }
        });
        mainModel.getAccOn().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m142lambda7$lambda1(this.f$0, (Integer) obj);
            }
        });
        mainModel.isLampOn().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m143lambda7$lambda2(this.f$0, (Boolean) obj);
            }
        });
        mainModel.isRunning().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m144lambda7$lambda3(this.f$0, (Boolean) obj);
            }
        });
        mainModel.getMcuOn().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m145lambda7$lambda4(this.f$0, (Integer) obj);
            }
        });
        mainModel.isWeak().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m146lambda7$lambda5(this.f$0, (Integer) obj);
            }
        });
        mainModel.getScreenOn().observe(baseAct, new Observer() { // from class: com.syu.media.companion.car.CarState$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarState.m147lambda7$lambda6(this.f$0, (Integer) obj);
            }
        });
    }

    public final int getAppId() {
        return this.appId;
    }

    public final void setAppId(int i) {
        this.appId = i;
    }

    public final int getAccOn() {
        return this.accOn;
    }

    public final void setAccOn(int i) {
        this.accOn = i;
    }

    public final int getMcuOn() {
        return this.mcuOn;
    }

    public final void setMcuOn(int i) {
        this.mcuOn = i;
    }

    /* JADX INFO: renamed from: isWeak, reason: from getter */
    public final int getIsWeak() {
        return this.isWeak;
    }

    public final void setWeak(int i) {
        this.isWeak = i;
    }

    public final int getScreenOn() {
        return this.screenOn;
    }

    public final void setScreenOn(int i) {
        this.screenOn = i;
    }

    /* JADX INFO: renamed from: isLampOn, reason: from getter */
    public final boolean getIsLampOn() {
        return this.isLampOn;
    }

    public final void setLampOn(boolean z) {
        this.isLampOn = z;
    }

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-0, reason: not valid java name */
    public static final void m141lambda7$lambda0(CarState carState, Integer num) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        HiLog.INSTANCE.d(TAG, "appId:" + num);
        Intrinsics.checkNotNullExpressionValue(num, "it");
        carState.appId = num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-1, reason: not valid java name */
    public static final void m142lambda7$lambda1(CarState carState, Integer num) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        HiLog.INSTANCE.d(TAG, "accOn:" + num);
        Intrinsics.checkNotNullExpressionValue(num, "it");
        carState.accOn = num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-2, reason: not valid java name */
    public static final void m143lambda7$lambda2(CarState carState, Boolean bool) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        carState.isLampOn = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-3, reason: not valid java name */
    public static final void m144lambda7$lambda3(CarState carState, Boolean bool) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        carState.isRunning = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-4, reason: not valid java name */
    public static final void m145lambda7$lambda4(CarState carState, Integer num) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        carState.mcuOn = num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-5, reason: not valid java name */
    public static final void m146lambda7$lambda5(CarState carState, Integer num) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        carState.isWeak = num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-7$lambda-6, reason: not valid java name */
    public static final void m147lambda7$lambda6(CarState carState, Integer num) {
        Intrinsics.checkNotNullParameter(carState, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        carState.screenOn = num.intValue();
    }
}
