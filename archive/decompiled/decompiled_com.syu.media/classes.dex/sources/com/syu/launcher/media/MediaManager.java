package com.syu.launcher.media;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.RemoteController;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.MutableLiveData;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u0002:\u0004\u008f\u0001\u008e\u0001B\t¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\"\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0014\u0010\u001c\u001a\u00020\u00032\n\u0010\u001b\u001a\u00060\u0019R\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010'J \u0010-\u001a\u00020\"2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\"2\b\b\u0002\u0010,\u001a\u00020\"J\"\u00101\u001a\u0004\u0018\u0001002\u0006\u0010/\u001a\u00020.2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\"R\"\u00102\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010>\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010T\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0017\u0010Z\u001a\u00020U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR3\u0010b\u001a\u001e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\\0[j\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\\`]8\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR3\u0010e\u001a\u001e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020F0[j\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020F`]8\u0006¢\u0006\f\n\u0004\bc\u0010_\u001a\u0004\bd\u0010aR3\u0010i\u001a\u001e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020f0[j\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020f`]8\u0006¢\u0006\f\n\u0004\bg\u0010_\u001a\u0004\bh\u0010aR\"\u0010k\u001a\u00020j8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010~\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R*\u0010\u0085\u0001\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0006¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u0090\u0001"}, d2 = {"Lcom/syu/launcher/media/MediaManager;", "Landroid/service/notification/NotificationListenerService;", "Landroid/media/RemoteController$OnClientUpdateListener;", FinalChip.BSP_PLATFORM_Null, "onCreate", "Landroid/content/Intent;", "intent", FinalChip.BSP_PLATFORM_Null, "flags", "startId", "onStartCommand", "Landroid/os/IBinder;", "onBind", FinalChip.BSP_PLATFORM_Null, "clearing", "onClientChange", "state", "onClientPlaybackStateUpdate", FinalChip.BSP_PLATFORM_Null, "stateChangeTimeMs", "currentPosMs", FinalChip.BSP_PLATFORM_Null, "speed", "transportControlFlags", "onClientTransportControlUpdate", "Landroid/media/RemoteController$MetadataEditor;", "Landroid/media/RemoteController;", "metadataEditor", "onClientMetadataUpdate", "Landroid/service/notification/StatusBarNotification;", "sbn", "onNotificationPosted", "onListenerConnected", "onListenerDisconnected", FinalChip.BSP_PLATFORM_Null, "pkg", "Landroid/media/MediaMetadata;", "metadata", "handleMetaData", "Landroid/media/session/PlaybackState;", "handlePlaybackState", "Landroid/os/Bundle;", "extras", "key", "def", "stringOf", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "drawableOf", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "a", "Landroid/media/RemoteController;", "getMRemoteController", "()Landroid/media/RemoteController;", "setMRemoteController", "(Landroid/media/RemoteController;)V", "mRemoteController", "Landroid/media/session/MediaSessionManager;", "mMediaSessionManager", "Landroid/media/session/MediaSessionManager;", "getMMediaSessionManager", "()Landroid/media/session/MediaSessionManager;", "setMMediaSessionManager", "(Landroid/media/session/MediaSessionManager;)V", "Landroid/media/session/MediaController;", "b", "Landroid/media/session/MediaController;", "getMMediaController", "()Landroid/media/session/MediaController;", "setMMediaController", "(Landroid/media/session/MediaController;)V", "mMediaController", "c", "Landroid/media/session/PlaybackState;", "getPlaybackState", "()Landroid/media/session/PlaybackState;", "setPlaybackState", "(Landroid/media/session/PlaybackState;)V", "playbackState", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Ljava/util/HashMap;", "Lcom/syu/launcher/media/MediaInfo;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "getMediaInfos", "()Ljava/util/HashMap;", "mediaInfos", "f", "getMediaControllers", "mediaControllers", "Landroid/media/session/MediaController$Callback;", "g", "getMediaCallbacks", "mediaCallbacks", "Landroid/content/pm/LauncherApps;", "launcherApps", "Landroid/content/pm/LauncherApps;", "getLauncherApps", "()Landroid/content/pm/LauncherApps;", "setLauncherApps", "(Landroid/content/pm/LauncherApps;)V", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "h", "I", "getKuwoAtiveCnt", "()I", "setKuwoAtiveCnt", "(I)V", "kuwoAtiveCnt", "i", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", Media.ICON, "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "getCheckProgress", "()Ljava/lang/Runnable;", "checkProgress", "<init>", "()V", "Companion", "CheckMusicActive", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class MediaManager extends NotificationListenerService implements RemoteController.OnClientUpdateListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String m = "MediaManager";
    public static final boolean n = true;
    public static final Map o = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.google.android.apps.maps", GoogleMapInfo.class), TuplesKt.to("ru.yandex.yandexnavi", YandexNaviInfo.class)});
    public static final ArrayList p = CollectionsKt.arrayListOf(new String[]{"com.google.android.youtube"});
    public static final MutableLiveData q;
    public static final MutableLiveData r;
    public static final MutableLiveData s;
    public static final MutableLiveData t;
    public static final MutableLiveData u;
    public static final MutableLiveData v;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public RemoteController mRemoteController;
    public AudioManager audioManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public MediaController mMediaController;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public PlaybackState playbackState;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int kuwoAtiveCnt;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public Drawable icon;
    public CheckMusicActive l;
    public LauncherApps launcherApps;
    public Context mContext;
    public MediaSessionManager mMediaSessionManager;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final HashMap mediaInfos = new HashMap();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final HashMap mediaControllers = new HashMap();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final HashMap mediaCallbacks = new HashMap();
    public final MediaManager$checkProgress$1 j = new Runnable() { // from class: com.syu.launcher.media.MediaManager$checkProgress$1
        @Override // java.lang.Runnable
        public void run() {
            MediaController mMediaController = this.a.getMMediaController();
            if (mMediaController != null) {
                MediaManager mediaManager = this.a;
                RemoteController mRemoteController = mediaManager.getMRemoteController();
                long estimatedMediaPosition = mRemoteController != null ? mRemoteController.getEstimatedMediaPosition() : -1L;
                Log.e(MediaManager.INSTANCE.getTAG(), "00 ------  checkProgress postion : " + estimatedMediaPosition + XmlConsts.CHAR_SPACE);
                if (estimatedMediaPosition == -1 && mediaManager.l == null) {
                    String packageName = mMediaController.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    MediaController mMediaController2 = mediaManager.getMMediaController();
                    mediaManager.handlePlaybackState(packageName, mMediaController2 != null ? mMediaController2.getPlaybackState() : null);
                }
                if (estimatedMediaPosition > 0) {
                    MediaManager.a(mediaManager, null, null, null, 0L, null, estimatedMediaPosition, 0, null, 479);
                }
            }
            this.a.getMHandler().removeCallbacks(this);
            this.a.getMHandler().postDelayed(this, 800L);
        }
    };
    public final MediaSessionManager.OnActiveSessionsChangedListener k = new MediaSessionManager.OnActiveSessionsChangedListener() { // from class: com.syu.launcher.media.MediaManager$$ExternalSyntheticLambda1
        @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
        public final void onActiveSessionsChanged(List list) {
            MediaManager.a(this.f$0, list);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/syu/launcher/media/MediaManager$CheckMusicActive;", "Ljava/lang/Runnable;", FinalChip.BSP_PLATFORM_Null, "run", FinalChip.BSP_PLATFORM_Null, "a", "Ljava/lang/String;", "getPkg", "()Ljava/lang/String;", "pkg", "<init>", "(Lcom/syu/launcher/media/MediaManager;Ljava/lang/String;)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public final class CheckMusicActive implements Runnable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String pkg;
        public final /* synthetic */ MediaManager b;

        public CheckMusicActive(MediaManager mediaManager, String str) {
            Intrinsics.checkNotNullParameter(str, "pkg");
            this.b = mediaManager;
            this.pkg = str;
        }

        public final String getPkg() {
            return this.pkg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StringsKt.contains$default(this.pkg, ".kuwo.", false, 2, (Object) null)) {
                Log.e(MediaManager.INSTANCE.getTAG(), "00 ------  checkMusicActive playState : " + this.b.getAudioManager().isMusicActive() + XmlConsts.CHAR_SPACE);
                MediaManager mediaManager = this.b;
                mediaManager.a(this.pkg, mediaManager.getAudioManager().isMusicActive() ? 3 : 2, -1L);
            }
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR+\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00198\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00198\u0006¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001eR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198\u0006¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0006¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e¨\u0006,"}, d2 = {"Lcom/syu/launcher/media/MediaManager$Companion;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", FinalChip.BSP_PLATFORM_Null, "DEBUG", "Z", "getDEBUG", "()Z", FinalChip.BSP_PLATFORM_Null, "Ljava/lang/Class;", "Lcom/syu/launcher/media/NaviInfo;", "NAVI_APPS", "Ljava/util/Map;", "getNAVI_APPS", "()Ljava/util/Map;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ingnore", "Ljava/util/ArrayList;", "getIngnore", "()Ljava/util/ArrayList;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/syu/launcher/media/Id3;", "mId3", "Landroidx/lifecycle/MutableLiveData;", "getMId3", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/syu/launcher/media/MediaApp;", "mMediaApp", "getMMediaApp", "Lcom/syu/launcher/media/PlayTime;", "mPlayTime", "getMPlayTime", "Landroid/graphics/drawable/Drawable;", "mIcon", "getMIcon", "naviApp", "getNaviApp", "naviInfo", "getNaviInfo", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getDEBUG() {
            return MediaManager.n;
        }

        public final ArrayList<String> getIngnore() {
            return MediaManager.p;
        }

        public final MutableLiveData<Drawable> getMIcon() {
            return MediaManager.t;
        }

        public final MutableLiveData<Id3> getMId3() {
            return MediaManager.q;
        }

        public final MutableLiveData<MediaApp> getMMediaApp() {
            return MediaManager.r;
        }

        public final MutableLiveData<PlayTime> getMPlayTime() {
            return MediaManager.s;
        }

        public final Map<String, Class<? extends NaviInfo>> getNAVI_APPS() {
            return MediaManager.o;
        }

        public final MutableLiveData<MediaApp> getNaviApp() {
            return MediaManager.u;
        }

        public final MutableLiveData<NaviInfo> getNaviInfo() {
            return MediaManager.v;
        }

        public final String getTAG() {
            return MediaManager.m;
        }
    }

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(new Id3(null, null, null, 0, 7, null));
        q = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        mutableLiveData2.setValue(new MediaApp(null, null, null, 7, null));
        r = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        mutableLiveData3.setValue(new PlayTime(0L, 0L, 3, null));
        s = mutableLiveData3;
        t = new MutableLiveData();
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        mutableLiveData4.setValue(new MediaApp(null, null, null, 7, null));
        u = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        mutableLiveData5.setValue(new NaviInfo());
        v = mutableLiveData5;
    }

    public static /* synthetic */ Drawable drawableOf$default(MediaManager mediaManager, Context context, Bundle bundle, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = NotificationCompat.EXTRA_LARGE_ICON;
        }
        return mediaManager.drawableOf(context, bundle, str);
    }

    public static /* synthetic */ String stringOf$default(MediaManager mediaManager, Bundle bundle, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        return mediaManager.stringOf(bundle, str, str2);
    }

    public final void a(MediaController mediaController) {
        Drawable badgedIcon;
        String str;
        final String packageName = mediaController.getPackageName();
        boolean z = n;
        if (z) {
            Log.e(m, " ------  connectToSession " + packageName + " START");
        }
        MediaController.Callback callback = new MediaController.Callback(this) { // from class: com.syu.launcher.media.MediaManager$connectToController$callback$1
            public final /* synthetic */ MediaManager b;

            {
                this.b = this;
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata metadata) {
                super.onMetadataChanged(metadata);
                MediaManager.Companion companion = MediaManager.INSTANCE;
                if (companion.getDEBUG()) {
                    Log.e(companion.getTAG(), " ------  onMetadataChanged " + packageName);
                }
                MediaManager mediaManager = this.b;
                String str2 = packageName;
                Intrinsics.checkNotNullExpressionValue(str2, "pkg");
                mediaManager.handleMetaData(str2, metadata);
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0048  */
            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState state) {
                super.onPlaybackStateChanged(state);
                MediaManager.Companion companion = MediaManager.INSTANCE;
                if (companion.getDEBUG()) {
                    Log.e(companion.getTAG(), " ------  onPlaybackStateChanged " + packageName);
                }
                if (state != null && state.getState() == 3) {
                    this.b.getMHandler().removeCallbacks(this.b.getCheckProgress());
                } else {
                    MediaController mMediaController = this.b.getMMediaController();
                    if (Intrinsics.areEqual(mMediaController != null ? mMediaController.getPackageName() : null, packageName)) {
                        this.b.getMHandler().removeCallbacks(this.b.getCheckProgress());
                    }
                }
                MediaManager mediaManager = this.b;
                String str2 = packageName;
                Intrinsics.checkNotNullExpressionValue(str2, "pkg");
                mediaManager.handlePlaybackState(str2, state);
            }
        };
        List<LauncherActivityInfo> activityList = getLauncherApps().getActivityList(packageName, Process.myUserHandle());
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
        HashMap map = this.mediaInfos;
        String packageName2 = mediaController.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "controller.packageName");
        Intrinsics.checkNotNullExpressionValue(packageName, "pkg");
        map.put(packageName2, new MediaInfo(null, null, null, new MediaApp(packageName, badgedIcon, str), 7, null));
        HashMap map2 = this.mediaCallbacks;
        String packageName3 = mediaController.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName3, "controller.packageName");
        map2.put(packageName3, callback);
        HashMap map3 = this.mediaControllers;
        String packageName4 = mediaController.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName4, "controller.packageName");
        map3.put(packageName4, mediaController);
        mediaController.registerCallback(callback);
        handleMetaData(packageName, mediaController.getMetadata());
        if (!StringsKt.contains$default(packageName, ".kuwo.", false, 2, (Object) null)) {
            handlePlaybackState(packageName, mediaController.getPlaybackState());
        }
        if (z) {
            Log.e(m, " ------  connectToSession " + packageName + " END");
        }
    }

    public final Drawable drawableOf(Context context, Bundle extras, String key) {
        Icon icon;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!extras.containsKey(key) || (icon = (Icon) extras.getParcelable(NotificationCompat.EXTRA_LARGE_ICON)) == null) {
            return null;
        }
        return icon.loadDrawable(context);
    }

    public final AudioManager getAudioManager() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return audioManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        return null;
    }

    public final Runnable getCheckProgress() {
        return this.j;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final int getKuwoAtiveCnt() {
        return this.kuwoAtiveCnt;
    }

    public final LauncherApps getLauncherApps() {
        LauncherApps launcherApps = this.launcherApps;
        if (launcherApps != null) {
            return launcherApps;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launcherApps");
        return null;
    }

    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final MediaController getMMediaController() {
        return this.mMediaController;
    }

    public final MediaSessionManager getMMediaSessionManager() {
        MediaSessionManager mediaSessionManager = this.mMediaSessionManager;
        if (mediaSessionManager != null) {
            return mediaSessionManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMediaSessionManager");
        return null;
    }

    public final RemoteController getMRemoteController() {
        return this.mRemoteController;
    }

    public final HashMap<String, MediaController.Callback> getMediaCallbacks() {
        return this.mediaCallbacks;
    }

    public final HashMap<String, MediaController> getMediaControllers() {
        return this.mediaControllers;
    }

    public final HashMap<String, MediaInfo> getMediaInfos() {
        return this.mediaInfos;
    }

    public final PlaybackState getPlaybackState() {
        return this.playbackState;
    }

    public final void handleMetaData(String pkg, MediaMetadata metadata) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        if (metadata == null) {
            return;
        }
        String string = metadata.getString("android.media.metadata.TITLE");
        String string2 = metadata.getString("android.media.metadata.ARTIST");
        String string3 = metadata.getString("android.media.metadata.ALBUM");
        long j = metadata.getLong("android.media.metadata.DURATION");
        Bitmap bitmap = metadata.getBitmap("android.media.metadata.ART");
        String str = m;
        Log.e(str, " ------  handleMetaData 00 " + bitmap);
        if (bitmap == null) {
            bitmap = metadata.getBitmap("android.media.metadata.ALBUM_ART");
            Log.e(str, " ------  handleMetaData 01 " + bitmap);
        }
        if (bitmap == null) {
            bitmap = metadata.getBitmap("android.media.metadata.DISPLAY_ICON");
            Log.e(str, " ------  handleMetaData 02 " + bitmap);
        }
        a(this, string, string2, string3, j, bitmap != null ? new BitmapDrawable(bitmap) : null, 0L, 0, pkg, 352);
    }

    public final void handlePlaybackState(String pkg, PlaybackState state) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        if (state != null) {
            a(pkg, state.getState(), state.getPosition());
        }
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientChange(boolean clearing) {
        if (n) {
            Log.e(m, " ------  onClientChange(" + clearing + ") ");
        }
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientMetadataUpdate(RemoteController.MetadataEditor metadataEditor) {
        Intrinsics.checkNotNullParameter(metadataEditor, "metadataEditor");
        boolean z = n;
        if (z) {
            Log.e(m, " ------  onClientMetadataUpdate(metadataEditor) ");
        }
        if (metadataEditor == null) {
            return;
        }
        String string = metadataEditor.getString(7, FinalChip.BSP_PLATFORM_Null);
        String string2 = metadataEditor.getString(2, FinalChip.BSP_PLATFORM_Null);
        String string3 = metadataEditor.getString(1, FinalChip.BSP_PLATFORM_Null);
        long j = metadataEditor.getLong(9, -1L);
        Bitmap bitmap = metadataEditor.getBitmap(100, null);
        if (z) {
            Log.e(m, " ------  handleMetadataEditor(metadataEditor)\n            title : " + string + "\n            artist : " + string2 + "\n            duration : " + j + "\n            bitmap : " + bitmap);
        }
        a(this, string, string2, string3, j, bitmap != null ? new BitmapDrawable(bitmap) : null, 0L, 0, null, 480);
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientPlaybackStateUpdate(int state) {
        if (n) {
            Log.e(m, " ------  onClientPlaybackStateUpdate(" + state + ") ");
        }
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientTransportControlUpdate(int transportControlFlags) {
        if (n) {
            Log.e(m, " ------  onClientTransportControlUpdate(" + transportControlFlags + ") ");
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        setMContext(applicationContext);
        Object systemService = getSystemService(LauncherApps.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(LauncherApps::class.java)");
        setLauncherApps((LauncherApps) systemService);
        Object systemService2 = getSystemService(AudioManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService2, "getSystemService(AudioManager::class.java)");
        setAudioManager((AudioManager) systemService2);
        getMContext().registerReceiver(new GaodeNaviReceiver(), new IntentFilter("AUTONAVI_STANDARD_BROADCAST_SEND"));
        Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this);
        Intrinsics.checkNotNullExpressionValue(enabledListenerPackages, "getEnabledListenerPackages(this)");
        Iterator<T> it = enabledListenerPackages.iterator();
        while (it.hasNext()) {
            Log.e(m, "00 ------------------- " + ((String) it.next()));
        }
        if (n) {
            Log.e(m, " ------  onCreate ");
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        boolean zRegisterRemoteController;
        super.onListenerConnected();
        if (n) {
            Log.e(m, " ------  onListenerConnected ");
        }
        Object systemService = getSystemService("media_session");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        setMMediaSessionManager((MediaSessionManager) systemService);
        ComponentName componentName = new ComponentName(this, (Class<?>) MediaManager.class);
        getMMediaSessionManager().addOnActiveSessionsChangedListener(this.k, componentName);
        String str = m;
        Log.e(str, "initMediaBrowser ------------------->>>>>>>>>>");
        a(getMMediaSessionManager().getActiveSessions(componentName));
        Log.e(str, "initMediaBrowser -------------------<<<<<<<<<<");
        this.mRemoteController = new RemoteController(this, this);
        try {
            Object systemService2 = getSystemService("audio");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
            zRegisterRemoteController = ((AudioManager) systemService2).registerRemoteController(this.mRemoteController);
        } catch (NullPointerException unused) {
            zRegisterRemoteController = false;
        }
        if (zRegisterRemoteController) {
            try {
                RemoteController remoteController = this.mRemoteController;
                if (remoteController != null) {
                    remoteController.setArtworkConfiguration(160, 160);
                }
                RemoteController remoteController2 = this.mRemoteController;
                if (remoteController2 != null) {
                    remoteController2.setSynchronizationMode(1);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        if (n) {
            Log.e(m, " ------  onListenerConnected ");
        }
        super.onListenerDisconnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        super.onNotificationPosted(sbn);
        if (n) {
            Log.e(m, " ------>>>>>>>  onNotificationPosted ");
        }
        a(sbn);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!n) {
            return 1;
        }
        Log.e(m, " ------  onStartCommand ");
        return 1;
    }

    public final void setAudioManager(AudioManager audioManager) {
        Intrinsics.checkNotNullParameter(audioManager, "<set-?>");
        this.audioManager = audioManager;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final void setKuwoAtiveCnt(int i) {
        this.kuwoAtiveCnt = i;
    }

    public final void setLauncherApps(LauncherApps launcherApps) {
        Intrinsics.checkNotNullParameter(launcherApps, "<set-?>");
        this.launcherApps = launcherApps;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMMediaController(MediaController mediaController) {
        this.mMediaController = mediaController;
    }

    public final void setMMediaSessionManager(MediaSessionManager mediaSessionManager) {
        Intrinsics.checkNotNullParameter(mediaSessionManager, "<set-?>");
        this.mMediaSessionManager = mediaSessionManager;
    }

    public final void setMRemoteController(RemoteController remoteController) {
        this.mRemoteController = remoteController;
    }

    public final void setPlaybackState(PlaybackState playbackState) {
        this.playbackState = playbackState;
    }

    public final String stringOf(Bundle extras, String key, String def) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(def, "def");
        if (!extras.containsKey(key)) {
            return def;
        }
        String string = extras.getString(key, def);
        Intrinsics.checkNotNullExpressionValue(string, "extras.getString(key, def)");
        return string;
    }

    public final Drawable a(RemoteViews remoteViews) {
        if (remoteViews == null) {
            return null;
        }
        View viewApply = remoteViews.apply(getApplicationContext(), new LinearLayout(getApplicationContext()));
        if (viewApply instanceof ViewGroup) {
            return a((ViewGroup) viewApply);
        }
        return null;
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientPlaybackStateUpdate(int state, long stateChangeTimeMs, long currentPosMs, float speed) {
        MediaInfo mediaInfo;
        if (n) {
            Log.e(m, " ------  onClientPlaybackStateUpdate(" + state + ", " + stateChangeTimeMs + ", " + currentPosMs + ", " + speed + ") ");
        }
        MediaController mediaController = this.mMediaController;
        if (mediaController == null || (mediaInfo = (MediaInfo) this.mediaInfos.get(mediaController.getPackageName())) == null) {
            return;
        }
        mediaInfo.getId3().setPlayState(state);
        mediaInfo.getPlayTime().setCurrentTimeMs(currentPosMs);
    }

    public static Drawable a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                Drawable drawableA = a((ViewGroup) childAt);
                if (drawableA != null) {
                    return drawableA;
                }
            } else if (childAt instanceof ImageView) {
                Drawable drawable = ((ImageView) childAt).getDrawable();
                if (n) {
                    Log.e(m, " ------  updateMediaInfo " + childAt + " -- drawable info: " + (drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null) + " x " + (drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null));
                }
                if (drawable != null && drawable.getIntrinsicWidth() > 90 && drawable.getIntrinsicHeight() > 90) {
                    return drawable;
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public final void a(String str, int i, long j) {
        a(this, null, null, null, 0L, null, j, i, str, 287);
        if (StringsKt.contains$default(str, ".kuwo.", false, 2, (Object) null)) {
            this.mHandler.removeCallbacks(this.j);
        }
        if (i == 3) {
            a(str);
            this.mHandler.postDelayed(this.j, 500L);
        }
        Log.e(m, " ------  handlePlaybackState pkg : " + str + "  postion : " + j + " status: " + i);
    }

    public static final void a(MediaManager mediaManager, List list) {
        Intrinsics.checkNotNullParameter(mediaManager, "this$0");
        mediaManager.a(list);
    }

    public final void a(List list) {
        boolean z;
        MediaController.Callback callback;
        synchronized (this) {
            if (list != null) {
                try {
                    z = list.isEmpty();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                this.mHandler.removeCallbacks(this.j);
                MediaController mediaController = this.mMediaController;
                if (mediaController != null && (callback = (MediaController.Callback) this.mediaCallbacks.get(mediaController.getPackageName())) != null) {
                    mediaController.unregisterCallback(callback);
                }
                this.mMediaController = null;
                t.postValue(null);
                s.postValue(new PlayTime(0L, 0L, 3, null));
                this.mediaInfos.clear();
                this.mediaCallbacks.clear();
                this.mediaControllers.clear();
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    MediaController mediaController2 = (MediaController) it.next();
                    if (!this.mediaControllers.containsKey(mediaController2.getPackageName())) {
                        a(mediaController2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(String str) {
        PlaybackState playbackState;
        String packageName;
        MediaController mediaController = this.mMediaController;
        if (Intrinsics.areEqual(mediaController != null ? mediaController.getPackageName() : null, str)) {
            return;
        }
        MediaController mediaController2 = this.mMediaController;
        if ((mediaController2 == null || (packageName = mediaController2.getPackageName()) == null || !StringsKt.contains$default(packageName, ".kuwo.", false, 2, (Object) null)) ? false : true) {
            HashMap map = this.mediaInfos;
            MediaController mediaController3 = this.mMediaController;
            MediaInfo mediaInfo = (MediaInfo) map.get(mediaController3 != null ? mediaController3.getPackageName() : null);
            if (mediaInfo != null) {
                mediaInfo.getId3().setPlayState(0);
            }
        }
        MediaController mediaController4 = (MediaController) this.mediaControllers.get(str);
        if ((mediaController4 == null || (playbackState = mediaController4.getPlaybackState()) == null || playbackState.getState() != 3) ? false : true) {
            MediaController mediaController5 = (MediaController) this.mediaControllers.get(str);
            this.mMediaController = mediaController5;
            handleMetaData(str, mediaController5 != null ? mediaController5.getMetadata() : null);
            MediaController mediaController6 = this.mMediaController;
            handlePlaybackState(str, mediaController6 != null ? mediaController6.getPlaybackState() : null);
        }
    }

    public static void a(MediaManager mediaManager, String str, String str2, String str3, long j, Drawable drawable, long j2, int i, String str4, int i2) {
        MediaInfo mediaInfo;
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            j = -1;
        }
        if ((i2 & 16) != 0) {
            drawable = null;
        }
        if ((i2 & 32) != 0) {
            j2 = -1;
        }
        if ((i2 & 64) != 0) {
            i = -1;
        }
        if ((i2 & 128) != 0) {
            MediaController mediaController = mediaManager.mMediaController;
            str4 = mediaController != null ? mediaController.getPackageName() : null;
            if (str4 == null) {
                str4 = FinalChip.BSP_PLATFORM_Null;
            }
        }
        mediaManager.getClass();
        if (!(str4.length() > 0) || (mediaInfo = (MediaInfo) mediaManager.mediaInfos.get(str4)) == null) {
            return;
        }
        if (str != null) {
            if (str.length() > 0) {
                mediaInfo.getId3().setTitle(str);
            }
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                mediaInfo.getId3().setArtist(str2);
            }
        }
        if (str3 != null) {
            if (str3.length() > 0) {
                mediaInfo.getId3().setAlbum(str3);
            }
        }
        if (j > 0) {
            mediaInfo.getPlayTime().setDuration(j);
        }
        if (j2 > 0) {
            mediaInfo.getPlayTime().setCurrentTimeMs(j2);
        }
        if (i > 0) {
            mediaInfo.getId3().setPlayState(i);
        }
        if (drawable != null) {
            mediaInfo.setIcon(drawable);
        }
        if (n) {
            Log.e(m, " ------  updateMediaInfo " + str4 + " -- info: " + mediaInfo);
        }
        MediaController mediaController2 = mediaManager.mMediaController;
        if (Intrinsics.areEqual(mediaController2 != null ? mediaController2.getPackageName() : null, mediaInfo.getMediaApp().getPackageName())) {
            if (!Intrinsics.areEqual(mediaManager.icon, mediaInfo.getIcon())) {
                Drawable icon = mediaInfo.getIcon();
                mediaManager.icon = icon;
                t.postValue(icon);
            }
            q.postValue(mediaInfo.getId3());
            r.postValue(mediaInfo.getMediaApp());
            s.postValue(mediaInfo.getPlayTime());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(StatusBarNotification statusBarNotification) {
        String str;
        final Ref.ObjectRef objectRef;
        final String str2;
        MediaApp mediaApp;
        NaviInfo naviInfo;
        String packageName;
        String appTitle;
        Drawable badgedIcon;
        String str3;
        Intrinsics.checkNotNullExpressionValue(statusBarNotification.getNotification().extras, "sbn.notification.extras");
        Map map = o;
        if (map.containsKey(statusBarNotification.getPackageName())) {
            Class cls = (Class) map.get(statusBarNotification.getPackageName());
            MutableLiveData mutableLiveData = u;
            MediaApp mediaApp2 = (MediaApp) mutableLiveData.getValue();
            if (Intrinsics.areEqual(mediaApp2 != null ? mediaApp2.getPackageName() : null, statusBarNotification.getPackageName())) {
                mediaApp = null;
            } else {
                List<LauncherActivityInfo> activityList = getLauncherApps().getActivityList(statusBarNotification.getPackageName(), Process.myUserHandle());
                if ((activityList != null ? activityList.size() : 0) == 0) {
                    return;
                }
                LauncherActivityInfo launcherActivityInfo = activityList.get(0);
                if (launcherActivityInfo != null) {
                    CharSequence label = launcherActivityInfo.getLabel();
                    Intrinsics.checkNotNull(label, "null cannot be cast to non-null type kotlin.String");
                    str3 = (String) label;
                    badgedIcon = launcherActivityInfo.getBadgedIcon(0);
                } else {
                    badgedIcon = null;
                    str3 = null;
                }
                String packageName2 = statusBarNotification.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName2, "sbn.packageName");
                mediaApp = new MediaApp(packageName2, badgedIcon, str3);
                mutableLiveData.postValue(mediaApp);
            }
            if (cls == null || (naviInfo = (NaviInfo) cls.newInstance()) == null) {
                return;
            }
            Context mContext = getMContext();
            Notification notification = statusBarNotification.getNotification();
            Intrinsics.checkNotNullExpressionValue(notification, "sbn.notification");
            naviInfo.parse(mContext, notification);
            if (!Intrinsics.areEqual(naviInfo.getNaviApp(), mediaApp)) {
                MediaApp naviApp = naviInfo.getNaviApp();
                String str4 = FinalChip.BSP_PLATFORM_Null;
                if (mediaApp == null || (packageName = mediaApp.getPackageName()) == null) {
                    packageName = FinalChip.BSP_PLATFORM_Null;
                }
                naviApp.setPackageName(packageName);
                MediaApp naviApp2 = naviInfo.getNaviApp();
                if (mediaApp != null && (appTitle = mediaApp.getAppTitle()) != null) {
                    str4 = appTitle;
                }
                naviApp2.setAppTitle(str4);
                naviInfo.getNaviApp().setAppIcon(mediaApp != null ? mediaApp.getAppIcon() : null);
            }
            MutableLiveData mutableLiveData2 = v;
            if (!Intrinsics.areEqual(naviInfo, mutableLiveData2.getValue())) {
                mutableLiveData2.postValue(naviInfo);
            }
            if (n) {
                Log.e(m, "------ " + naviInfo);
                return;
            }
            return;
        }
        Bundle bundle = statusBarNotification.getNotification().extras;
        Intrinsics.checkNotNullExpressionValue(bundle, "sbn.notification.extras");
        String packageName3 = statusBarNotification.getPackageName();
        final String strStringOf$default = stringOf$default(this, bundle, NotificationCompat.EXTRA_TITLE, null, 4, null);
        final String strStringOf$default2 = stringOf$default(this, bundle, NotificationCompat.EXTRA_TEXT, null, 4, null);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = drawableOf$default(this, getMContext(), bundle, null, 4, null);
        String packageName4 = statusBarNotification.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName4, "sbn.packageName");
        if (StringsKt.contains$default(packageName4, ".kuwo.", false, 2, (Object) null)) {
            CheckMusicActive checkMusicActive = this.l;
            if (!Intrinsics.areEqual(checkMusicActive != null ? checkMusicActive.getPkg() : null, statusBarNotification.getPackageName())) {
                String packageName5 = statusBarNotification.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName5, "sbn.packageName");
                this.l = new CheckMusicActive(this, packageName5);
            }
            Handler handler = this.mHandler;
            CheckMusicActive checkMusicActive2 = this.l;
            Intrinsics.checkNotNull(checkMusicActive2);
            handler.removeCallbacks(checkMusicActive2);
            Handler handler2 = this.mHandler;
            CheckMusicActive checkMusicActive3 = this.l;
            Intrinsics.checkNotNull(checkMusicActive3);
            handler2.postDelayed(checkMusicActive3, 600L);
            Log.e(m, " ------  updateNotificationPost 111111");
            Drawable drawable = (Drawable) objectRef2.element;
            Intrinsics.checkNotNullExpressionValue(packageName3, "pkg");
            str = "pkg";
            objectRef = objectRef2;
            str2 = packageName3;
            a(this, strStringOf$default, strStringOf$default2, null, 0L, drawable, 0L, 0, packageName3, 364);
        } else {
            str = "pkg";
            objectRef = objectRef2;
            str2 = packageName3;
            this.mHandler.postDelayed(new Runnable() { // from class: com.syu.launcher.media.MediaManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaManager.a(this.f$0, str2, strStringOf$default, strStringOf$default2, objectRef);
                }
            }, 300L);
        }
        String packageName6 = statusBarNotification.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName6, "sbn.packageName");
        if (StringsKt.contains$default(packageName6, "kugou", false, 2, (Object) null)) {
            return;
        }
        Ref.ObjectRef objectRef3 = objectRef;
        if (objectRef3.element == null) {
            RemoteViews remoteViews = statusBarNotification.getNotification().bigContentView;
            Intrinsics.checkNotNullExpressionValue(statusBarNotification.getPackageName(), "sbn.packageName");
            objectRef3.element = a(remoteViews);
            if (n) {
                Log.e(m, " ------  updateNotificationPost bigContentView " + objectRef3.element);
            }
        }
        if (objectRef3.element == null) {
            RemoteViews remoteViews2 = statusBarNotification.getNotification().headsUpContentView;
            Intrinsics.checkNotNullExpressionValue(statusBarNotification.getPackageName(), "sbn.packageName");
            objectRef3.element = a(remoteViews2);
            if (n) {
                Log.e(m, " ------  updateNotificationPost headsUpContentView " + objectRef3.element);
            }
        }
        if (objectRef3.element == null) {
            RemoteViews remoteViews3 = statusBarNotification.getNotification().tickerView;
            Intrinsics.checkNotNullExpressionValue(statusBarNotification.getPackageName(), "sbn.packageName");
            objectRef3.element = a(remoteViews3);
            if (n) {
                Log.e(m, " ------  updateNotificationPost tickerView " + objectRef3.element);
            }
        }
        if (objectRef3.element == null) {
            RemoteViews remoteViews4 = statusBarNotification.getNotification().contentView;
            Intrinsics.checkNotNullExpressionValue(statusBarNotification.getPackageName(), "sbn.packageName");
            objectRef3.element = a(remoteViews4);
            if (n) {
                Log.e(m, " ------  updateNotificationPost contentView " + objectRef3.element);
            }
        }
        Object obj = objectRef3.element;
        if (obj != null) {
            String str5 = str2;
            Intrinsics.checkNotNullExpressionValue(str5, str);
            a(this, null, null, null, 0L, (Drawable) obj, 0L, 0, str5, 367);
        }
    }

    public static final void a(MediaManager mediaManager, String str, String str2, String str3, Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(mediaManager, "this$0");
        Intrinsics.checkNotNullParameter(str2, "$title");
        Intrinsics.checkNotNullParameter(str3, "$artist");
        Intrinsics.checkNotNullParameter(objectRef, "$icon");
        Intrinsics.checkNotNullExpressionValue(str, "pkg");
        mediaManager.a(str);
        a(mediaManager, str2, str3, null, 0L, (Drawable) objectRef.element, 0L, 0, str, 364);
    }
}
