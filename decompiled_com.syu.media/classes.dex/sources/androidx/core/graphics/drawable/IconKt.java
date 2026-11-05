package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toAdaptiveIcon");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    public static final Icon toIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toIcon");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithBitmap, "Icon.createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    public static final Icon toIcon(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toIcon");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithContentUri, "Icon.createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    public static final Icon toIcon(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toIcon");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithData, "Icon.createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
