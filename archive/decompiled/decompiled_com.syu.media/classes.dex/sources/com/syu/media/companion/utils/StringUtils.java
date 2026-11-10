package com.syu.media.companion.utils;

import chip.FinalChip;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/companion/utils/StringUtils;", FinalChip.BSP_PLATFORM_Null, "()V", "isChineseByReg", FinalChip.BSP_PLATFORM_Null, "str", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final boolean isChineseByReg(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String str2 = str;
        if (!(str2.length() > 0)) {
            return true;
        }
        Pattern patternCompile = Pattern.compile("[\\u4e00-\\u9fa5]");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(reg)");
        Matcher matcher = patternCompile.matcher(str2);
        Intrinsics.checkNotNullExpressionValue(matcher, "pattern.matcher(str)");
        return matcher.find();
    }
}
