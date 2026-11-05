package com.syu.manger.module;

import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.remote.MessageObserver;
import com.syu.remote.ModuleManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B+\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\u0010\u0010\u001a\u00020\u000f\"\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\n\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/syu/manger/module/BaseModuleObserver;", "Landroidx/lifecycle/ViewModel;", "VM", "Lcom/syu/remote/MessageObserver$ModuleObserver;", "a", "Landroidx/lifecycle/ViewModel;", "getModel", "()Landroidx/lifecycle/ViewModel;", "setModel", "(Landroidx/lifecycle/ViewModel;)V", "model", "Lcom/syu/remote/ModuleManager;", "manager", FinalChip.BSP_PLATFORM_Null, "module", FinalChip.BSP_PLATFORM_Null, "codes", "<init>", "(Lcom/syu/remote/ModuleManager;Landroidx/lifecycle/ViewModel;I[I)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseModuleObserver<VM extends ViewModel> extends MessageObserver.ModuleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ViewModel model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseModuleObserver(ModuleManager moduleManager, VM vm, int i, int... iArr) {
        super(moduleManager, i, Arrays.copyOf(iArr, iArr.length));
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(vm, "model");
        Intrinsics.checkNotNullParameter(iArr, "codes");
        this.model = vm;
    }

    public final VM getModel() {
        return (VM) this.model;
    }

    public final void setModel(VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.model = vm;
    }
}
