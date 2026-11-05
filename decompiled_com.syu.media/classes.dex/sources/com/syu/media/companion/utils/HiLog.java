package com.syu.media.companion.utils;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiLog.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/syu/media/companion/utils/HiLog;", FinalChip.BSP_PLATFORM_Null, "()V", "DEBUG", FinalChip.BSP_PLATFORM_Null, "TAG", FinalChip.BSP_PLATFORM_Null, "d", FinalChip.BSP_PLATFORM_Null, "tag", NotificationCompat.CATEGORY_MESSAGE, "e", "i", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HiLog {
    private static final boolean DEBUG = true;
    public static final HiLog INSTANCE = new HiLog();
    private static final String TAG = "media";

    private HiLog() {
    }

    public final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(TAG, tag + ":    " + msg);
    }

    public final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.e(TAG, tag + ":    " + msg);
    }

    public final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(tag, msg);
    }
}
