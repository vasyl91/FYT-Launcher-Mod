package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0007"}, d2 = {"transform", FinalChip.BSP_PLATFORM_Null, "Landroid/graphics/Shader;", "block", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class ShaderKt {
    public static final void transform(Shader shader, Function1<? super Matrix, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(shader, "$this$transform");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
