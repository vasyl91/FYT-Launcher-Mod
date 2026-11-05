package androidx.core.util;

import chip.FinalChip;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: AtomicFile.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", FinalChip.BSP_PLATFORM_Null, "Landroid/util/AtomicFile;", "readText", FinalChip.BSP_PLATFORM_Null, "charset", "Ljava/nio/charset/Charset;", "tryWrite", FinalChip.BSP_PLATFORM_Null, "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class AtomicFileKt {
    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) throws IOException {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$tryWrite");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(fileOutputStreamStartWrite, "stream");
            function1.invoke(fileOutputStreamStartWrite);
            InlineMarker.finallyStart(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } finally {
            InlineMarker.finallyStart(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }

    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) throws IOException {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static final byte[] readBytes(android.util.AtomicFile atomicFile) throws IOException {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readBytes");
        byte[] fully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(fully, "readFully()");
        return fully;
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) throws IOException {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readText");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] fully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(fully, "readFully()");
        return new String(fully, charset);
    }

    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) throws IOException {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeBytes");
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }
}
