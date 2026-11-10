package com.syu.manger.module;

import chip.FinalChip;
import com.syu.remote.ModuleManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u00020\u0004\"\u00020\u0002J?\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/syu/manger/module/BaseController;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "cmd", FinalChip.BSP_PLATFORM_Null, "param", FinalChip.BSP_PLATFORM_Null, "sendCmd", "ints", FinalChip.BSP_PLATFORM_Null, "flts", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "strs", "(I[I[F[Ljava/lang/String;)Z", "Lcom/syu/remote/ModuleManager;", "a", "Lcom/syu/remote/ModuleManager;", "getManager", "()Lcom/syu/remote/ModuleManager;", "setManager", "(Lcom/syu/remote/ModuleManager;)V", "manager", "module", "<init>", "(Lcom/syu/remote/ModuleManager;I)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public class BaseController {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ModuleManager manager;
    public final int b;

    public BaseController(ModuleManager moduleManager, int i) {
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        this.manager = moduleManager;
        this.b = i;
    }

    public static /* synthetic */ boolean sendCmd$default(BaseController baseController, int i, int[] iArr, float[] fArr, String[] strArr, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCmd");
        }
        if ((i2 & 2) != 0) {
            iArr = null;
        }
        if ((i2 & 4) != 0) {
            fArr = null;
        }
        if ((i2 & 8) != 0) {
            strArr = null;
        }
        return baseController.sendCmd(i, iArr, fArr, strArr);
    }

    public final ModuleManager getManager() {
        return this.manager;
    }

    public final boolean sendCmd(int cmd, int... param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.manager.remote.command(this.b, cmd, Arrays.copyOf(param, param.length));
    }

    public final void setManager(ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter(moduleManager, "<set-?>");
        this.manager = moduleManager;
    }

    public final boolean sendCmd(int cmd, int[] ints, float[] flts, String[] strs) {
        return this.manager.remote.command(this.b, cmd, ints, flts, strs);
    }
}
