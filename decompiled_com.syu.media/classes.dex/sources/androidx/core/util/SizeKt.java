package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n¨\u0006\u0006"}, d2 = {"component1", FinalChip.BSP_PLATFORM_Null, "Landroid/util/Size;", FinalChip.BSP_PLATFORM_Null, "Landroid/util/SizeF;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class SizeKt {
    public static final int component1(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component1");
        return size.getWidth();
    }

    public static final int component2(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component2");
        return size.getHeight();
    }

    public static final float component1(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component1");
        return sizeF.getWidth();
    }

    public static final float component2(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component2");
        return sizeF.getHeight();
    }
}
