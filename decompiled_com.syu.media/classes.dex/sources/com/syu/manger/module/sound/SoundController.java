package com.syu.manger.module.sound;

import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseController;
import com.syu.remote.ModuleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/sound/SoundController;", "Lcom/syu/manger/module/BaseController;", "manager", "Lcom/syu/remote/ModuleManager;", "(Lcom/syu/remote/ModuleManager;)V", "volBarUi", FinalChip.BSP_PLATFORM_Null, "show", "volume", "vol", FinalChip.BSP_PLATFORM_Null, "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SoundController extends BaseController {
    /* JADX WARN: Illegal instructions before constructor call */
    public SoundController() {
        ModuleManager moduleManager = null;
        this(moduleManager, 1, moduleManager);
    }

    public final boolean volBarUi(boolean show) {
        int[] iArr = new int[1];
        iArr[0] = show ? -6 : -7;
        return sendCmd(0, iArr);
    }

    public final boolean volume(int vol) {
        return sendCmd(0, Math.max(0, Math.min(vol, 36)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoundController(ModuleManager moduleManager) {
        super(moduleManager, 4);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
    }

    public /* synthetic */ SoundController(ModuleManager moduleManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AutoManager.INSTANCE.requestInstance().getModuleManager() : moduleManager);
    }
}
