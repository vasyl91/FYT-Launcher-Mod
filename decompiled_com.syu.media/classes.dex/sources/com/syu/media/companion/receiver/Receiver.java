package com.syu.media.companion.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.PlayState;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.music.MusicStatic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Receiver.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/syu/media/companion/receiver/Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Receiver extends BroadcastReceiver {
    public static final String ACTION_SYSTEM_UI_REMOVE = "com.fyt.systemui.remove";
    public static final String ACTION_VIDEO_SCAN = "com.syu.video.scan";
    public static final String TAG = "Receiver";

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MediaProxy audioProxy;
        PlayState playState;
        String string;
        MediaProxy audioProxy2;
        PlayState playState2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.d(TAG, "action:" + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case 172491798:
                    if (!action.equals("android.intent.action.PACKAGE_CHANGED")) {
                        return;
                    }
                    break;
                case 468703733:
                    if (!action.equals(ACTION_SYSTEM_UI_REMOVE) || (audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy()) == null || (playState = audioProxy.getPlayState()) == null) {
                        return;
                    }
                    Bundle extras = intent.getExtras();
                    if (extras == null || (string = extras.getString("pkg")) == null) {
                        string = FinalChip.BSP_PLATFORM_Null;
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "bundle?.getString(\"pkg\") ?: \"\"");
                    if (Intrinsics.areEqual(string, context.getPackageName())) {
                        MusicStatic.INSTANCE.pushPlayStateForSharePref(context, playState);
                        Integer value = AutoManager.INSTANCE.requestInstance().getMainModel().getAppId().getValue();
                        HiLog.INSTANCE.d(TAG, "remove appId:" + value);
                        boolean z = true;
                        if (!((value != null && value.intValue() == 3) || (value != null && value.intValue() == 8)) && (value == null || value.intValue() != 1)) {
                            z = false;
                        }
                        if (z) {
                            AutoManager.INSTANCE.requestInstance().openAppId(0);
                            return;
                        }
                        return;
                    }
                    return;
                case 525384130:
                    if (!action.equals("android.intent.action.PACKAGE_REMOVED")) {
                        return;
                    }
                    break;
                case 1544582882:
                    if (!action.equals("android.intent.action.PACKAGE_ADDED")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            Uri data = intent.getData();
            if (!StringsKt.equals$default(data != null ? data.getSchemeSpecificPart() : null, context.getPackageName(), false, 2, (Object) null) || (audioProxy2 = MediaHelper.INSTANCE.getHelper().getAudioProxy()) == null || (playState2 = audioProxy2.getPlayState()) == null) {
                return;
            }
            MusicStatic.INSTANCE.pushPlayStateForSharePref(context, playState2);
        }
    }
}
