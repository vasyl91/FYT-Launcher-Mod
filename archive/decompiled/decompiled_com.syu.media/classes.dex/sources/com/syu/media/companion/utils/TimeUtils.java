package com.syu.media.companion.utils;

import android.content.Context;
import android.text.format.DateFormat;
import chip.FinalChip;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/syu/media/companion/utils/TimeUtils;", FinalChip.BSP_PLATFORM_Null, "()V", "getCurTimeHour", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "msecToMinutes", "milliseconds", FinalChip.BSP_PLATFORM_Null, "format", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeUtils {
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public final String getCurTimeHour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SimpleDateFormat(DateFormat.is24HourFormat(context) ? "HHmm" : "hhmm").format(Calendar.getInstance().getTime());
    }

    public final String msecToMinutes(long milliseconds) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(milliseconds)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(milliseconds) % ((long) 60))}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public final String msecToMinutes(String format, long milliseconds) {
        Intrinsics.checkNotNullParameter(format, "format");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(format, Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MICROSECONDS.toMinutes(milliseconds))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
