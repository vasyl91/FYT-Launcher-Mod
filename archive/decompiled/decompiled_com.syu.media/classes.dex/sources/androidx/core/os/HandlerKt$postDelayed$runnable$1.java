package androidx.core.os;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Handler.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "run"}, k = 3, mv = {1, 1, 15})
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ Function0 $action;

    public HandlerKt$postDelayed$runnable$1(Function0 function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
