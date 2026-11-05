package com.syu.launcher.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.util.Log;
import chip.FinalChip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/syu/launcher/media/GaodeNaviReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", FinalChip.BSP_PLATFORM_Null, "onReceive", "Lcom/syu/launcher/media/GaodeNaviInfo;", "a", "Lcom/syu/launcher/media/GaodeNaviInfo;", "getGaoDeNaviInfo", "()Lcom/syu/launcher/media/GaodeNaviInfo;", "gaoDeNaviInfo", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class GaodeNaviReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final GaodeNaviInfo gaoDeNaviInfo = new GaodeNaviInfo();

    public final GaodeNaviInfo getGaoDeNaviInfo() {
        return this.gaoDeNaviInfo;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        String stringExtra;
        Drawable badgedIcon;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        LauncherApps launcherApps = (LauncherApps) context.getSystemService(LauncherApps.class);
        if (launcherApps != null) {
            String packageName = this.gaoDeNaviInfo.getNaviApp().getPackageName();
            if (packageName == null || packageName.length() == 0) {
                List<LauncherActivityInfo> activityList = launcherApps.getActivityList("com.autonavi.amapauto", Process.myUserHandle());
                if ((activityList != null ? activityList.size() : 0) == 0) {
                    return;
                }
                LauncherActivityInfo launcherActivityInfo = activityList.get(0);
                if (launcherActivityInfo != null) {
                    CharSequence label = launcherActivityInfo.getLabel();
                    Intrinsics.checkNotNull(label, "null cannot be cast to non-null type kotlin.String");
                    str = (String) label;
                    badgedIcon = launcherActivityInfo.getBadgedIcon(0);
                } else {
                    badgedIcon = null;
                    str = null;
                }
                this.gaoDeNaviInfo.getNaviApp().setAppTitle(str);
                this.gaoDeNaviInfo.getNaviApp().setPackageName("com.autonavi.amapauto");
                this.gaoDeNaviInfo.getNaviApp().setAppIcon(badgedIcon);
            }
        }
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "AUTONAVI_STANDARD_BROADCAST_SEND")) {
            if (intent != null && (stringExtra = intent.getStringExtra(GaodeNaviInfo.CUR_ROAD_NAME)) != null) {
                z = stringExtra.length() > 0;
            }
            if (z) {
                this.gaoDeNaviInfo.parse(intent);
                MediaManager.Companion companion = MediaManager.INSTANCE;
                if (!Intrinsics.areEqual(companion.getNaviApp().getValue(), this.gaoDeNaviInfo.getNaviApp())) {
                    companion.getNaviApp().postValue(this.gaoDeNaviInfo.getNaviApp());
                }
                if (!Intrinsics.areEqual(this.gaoDeNaviInfo, companion.getNaviInfo().getValue())) {
                    companion.getNaviInfo().postValue(this.gaoDeNaviInfo);
                }
                if (companion.getDEBUG()) {
                    Log.e(companion.getTAG(), "------ " + this.gaoDeNaviInfo);
                }
            }
        }
    }
}
