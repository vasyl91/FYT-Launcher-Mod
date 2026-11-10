package com.syu.launcher.media;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/syu/launcher/media/YandexNaviInfo;", "Lcom/syu/launcher/media/NaviInfo;", "()V", "findMessage", FinalChip.BSP_PLATFORM_Null, "group", "Landroid/view/ViewGroup;", "parse", "context", "Landroid/content/Context;", "notification", "Landroid/app/Notification;", "remoteViews", "Landroid/widget/RemoteViews;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class YandexNaviInfo extends NaviInfo {
    @Override // com.syu.launcher.media.NaviInfo
    public void findMessage(ViewGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        int childCount = group.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = group.getChildAt(i);
            String string = childAt.toString();
            Intrinsics.checkNotNullExpressionValue(string, "child.toString()");
            if (childAt instanceof ViewGroup) {
                findMessage((ViewGroup) childAt);
            } else if (childAt instanceof ImageView) {
                Drawable drawable = ((ImageView) childAt).getDrawable();
                if (drawable != null && StringsKt.contains$default(string, "app:id/nextManeuverViewTinted", false, 2, (Object) null)) {
                    setRouteSign(drawable);
                }
            } else if (childAt instanceof TextView) {
                if (StringsKt.contains$default(string, "app:id/titleView", false, 2, (Object) null)) {
                    setCrossing(((TextView) childAt).getText().toString());
                } else if (StringsKt.contains$default(string, "app:id/descriptionView", false, 2, (Object) null)) {
                    setLocation(((TextView) childAt).getText().toString());
                } else if (StringsKt.contains$default(string, "app:id/remainingDistanceView", false, 2, (Object) null)) {
                    setMileage(((TextView) childAt).getText().toString());
                } else if (StringsKt.contains$default(string, "app:id/remainingTimeView", false, 2, (Object) null)) {
                    setTime(((TextView) childAt).getText().toString());
                } else if (StringsKt.contains$default(string, "app:id/timeOfArrivalView", false, 2, (Object) null)) {
                    setArrival(((TextView) childAt).getText().toString());
                }
                setMessage(getMileage() + XmlConsts.CHAR_SPACE + getTime() + XmlConsts.CHAR_SPACE + getArrival());
            }
        }
    }

    @Override // com.syu.launcher.media.NaviInfo
    public void parse(Context context, Notification notification) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        RemoteViews remoteViews = notification.bigContentView;
        if (remoteViews != null) {
            Log.e(MediaManager.INSTANCE.getTAG(), "parse notification bigContentView");
            parse(context, remoteViews);
        }
    }

    public final void parse(Context context, RemoteViews remoteViews) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        View viewApply = remoteViews.apply(context, new LinearLayout(context));
        if (viewApply instanceof ViewGroup) {
            findMessage((ViewGroup) viewApply);
        }
    }
}
