package androidx.core.net;

import android.net.Uri;
import chip.FinalChip;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class UriKt {
    public static final Uri toUri(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUri");
        Uri uri = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        return uri;
    }

    public static final Uri toUri(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$toUri");
        Uri uriFromFile = Uri.fromFile(file);
        Intrinsics.checkExpressionValueIsNotNull(uriFromFile, "Uri.fromFile(this)");
        return uriFromFile;
    }

    public static final File toFile(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toFile");
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        return new File(uri.getPath());
    }
}
