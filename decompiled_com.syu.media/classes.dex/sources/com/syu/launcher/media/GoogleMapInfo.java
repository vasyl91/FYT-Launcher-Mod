package com.syu.launcher.media;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/syu/launcher/media/GoogleMapInfo;", "Lcom/syu/launcher/media/NaviInfo;", "()V", "parse", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "notification", "Landroid/app/Notification;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GoogleMapInfo extends NaviInfo {
    @Override // com.syu.launcher.media.NaviInfo
    public void parse(Context context, Notification notification) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Bundle bundle = notification.extras;
        Intrinsics.checkNotNullExpressionValue(bundle, "extras");
        setRouteSign(NaviInfo.drawableOf$default(this, context, bundle, null, 4, null));
        setCrossing(NaviInfo.charSequenceOf$default(this, bundle, NotificationCompat.EXTRA_TITLE, null, 4, null));
        setLocation(NaviInfo.charSequenceOf$default(this, bundle, NotificationCompat.EXTRA_TEXT, null, 4, null));
        setMessage(NaviInfo.stringOf$default(this, bundle, NotificationCompat.EXTRA_SUB_TEXT, null, 4, null));
        String message = getMessage();
        if (message == null || message.length() == 0) {
            return;
        }
        List listSplit$default = StringsKt.split$default(getMessage(), new String[]{"·"}, false, 0, 6, (Object) null);
        if (listSplit$default.size() == 3) {
            setTime((String) listSplit$default.get(0));
            setMileage((String) listSplit$default.get(1));
            setArrival((String) listSplit$default.get(2));
        }
    }
}
