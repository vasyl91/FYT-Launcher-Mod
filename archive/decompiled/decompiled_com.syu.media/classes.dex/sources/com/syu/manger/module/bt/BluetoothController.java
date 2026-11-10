package com.syu.manger.module.bt;

import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseController;
import com.syu.remote.ModuleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/syu/manger/module/bt/BluetoothController;", "Lcom/syu/manger/module/BaseController;", "manager", "Lcom/syu/remote/ModuleManager;", "(Lcom/syu/remote/ModuleManager;)V", "btAtNext", FinalChip.BSP_PLATFORM_Null, "btAtPause", "btAtPlay", "btAtPlayPause", "btAtPrev", "btAtStop", "onClick", "keycode", FinalChip.BSP_PLATFORM_Null, "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BluetoothController extends BaseController {
    /* JADX WARN: Illegal instructions before constructor call */
    public BluetoothController() {
        ModuleManager moduleManager = null;
        this(moduleManager, 1, moduleManager);
    }

    public final boolean btAtNext() {
        return BaseController.sendCmd$default(this, 1, null, null, null, 14, null);
    }

    public final boolean btAtPause() {
        return BaseController.sendCmd$default(this, 3, null, null, null, 14, null);
    }

    public final boolean btAtPlay() {
        return BaseController.sendCmd$default(this, 27, null, null, null, 14, null);
    }

    public final boolean btAtPlayPause() {
        return BaseController.sendCmd$default(this, 2, null, null, null, 14, null);
    }

    public final boolean btAtPrev() {
        return BaseController.sendCmd$default(this, 0, null, null, null, 14, null);
    }

    public final boolean btAtStop() {
        return BaseController.sendCmd$default(this, 4, null, null, null, 14, null);
    }

    public final boolean onClick(int keycode) {
        return sendCmd(6, keycode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothController(ModuleManager moduleManager) {
        super(moduleManager, 2);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
    }

    public /* synthetic */ BluetoothController(ModuleManager moduleManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AutoManager.INSTANCE.requestInstance().getModuleManager() : moduleManager);
    }
}
