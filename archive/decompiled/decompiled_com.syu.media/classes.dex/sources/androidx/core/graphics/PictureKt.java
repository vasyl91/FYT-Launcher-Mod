package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\b¨\u0006\n"}, d2 = {"record", "Landroid/graphics/Picture;", Media.VIDEO_WIDTH, FinalChip.BSP_PLATFORM_Null, Media.VIDEO_HEIGHT, "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", FinalChip.BSP_PLATFORM_Null, "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(picture, "$this$record");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        try {
            Intrinsics.checkExpressionValueIsNotNull(canvasBeginRecording, "c");
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            InlineMarker.finallyStart(1);
            picture.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
