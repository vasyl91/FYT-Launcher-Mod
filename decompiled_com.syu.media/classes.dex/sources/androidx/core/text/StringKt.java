package androidx.core.text;

import android.text.TextUtils;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, d2 = {"htmlEncode", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class StringKt {
    public static final String htmlEncode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$htmlEncode");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkExpressionValueIsNotNull(strHtmlEncode, "TextUtils.htmlEncode(this)");
        return strHtmlEncode;
    }
}
