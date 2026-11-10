package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _OneToManyTitlecaseMappings.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c) {
        String upperCase = String.valueOf(c).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        String strSubstring = upperCase.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }
}
