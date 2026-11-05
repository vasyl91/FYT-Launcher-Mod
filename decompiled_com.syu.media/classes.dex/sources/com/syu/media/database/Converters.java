package com.syu.media.database;

import chip.FinalChip;
import java.sql.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/syu/media/database/Converters;", FinalChip.BSP_PLATFORM_Null, "()V", "fromTime", "Ljava/sql/Date;", "time", FinalChip.BSP_PLATFORM_Null, "toTime", "date", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Converters {
    public final Date fromTime(long time) {
        return new Date(time);
    }

    public final long toTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return date.getTime();
    }
}
