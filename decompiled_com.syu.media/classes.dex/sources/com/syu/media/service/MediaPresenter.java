package com.syu.media.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.LauncherApps;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.ICallback;
import com.syu.media.ICallback2;
import com.syu.media.IPlayer;
import com.syu.media.entities.MediaSource;
import com.syu.media.ipc.PlaybackBinder;
import com.syu.media.player.PlayMode;
import com.syu.media.provider.Media;
import com.syu.media.provider.MediaConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004xyz{B=\u0012\u0006\u0010E\u001a\u00020@\u0012\b\b\u0002\u0010q\u001a\u000207\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010r\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010r\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010r¢\u0006\u0004\bv\u0010wJ\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020!J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020!J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u000e\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u0010\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(J\u0006\u0010+\u001a\u00020\bJ\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\bJ\u000e\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\bJ\u000e\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201J\u0014\u00106\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f04J\u000e\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000207J\u000e\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0014J\u001c\u0010=\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f042\u0006\u0010<\u001a\u00020\u0014J\u001c\u0010=\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010>\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014J\b\u0010?\u001a\u00020\bH\u0016R\u0017\u0010E\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\"\u0010L\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010O\u001a\u00020\f2\u0006\u0010M\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010G\u001a\u0004\bO\u0010I\"\u0004\bP\u0010KR\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010G\u001a\u0004\b\u0012\u0010I\"\u0004\bX\u0010KR$\u0010_\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010j\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010a\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR\u0017\u0010p\u001a\u00020k8\u0006¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o¨\u0006|"}, d2 = {"Lcom/syu/media/service/MediaPresenter;", "Landroid/content/ServiceConnection;", "Landroid/os/IBinder$DeathRecipient;", "Lcom/syu/media/ICallback$Stub;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, FinalChip.BSP_PLATFORM_Null, "onServiceConnected", "onServiceDisconnected", "unbind", FinalChip.BSP_PLATFORM_Null, "enable", "enablePlayProgress", "Lcom/syu/media/entities/MediaSource;", "source", "onSongChanged", "isPlaying", "onPlayStatusChanged", FinalChip.BSP_PLATFORM_Null, "mode", "onPlayModeChanged", "Lcom/syu/media/service/MediaPresenter$OnConnectionStateChangeListener;", "listener", "registerOnConnectionStateChangeListener", "unregisterOnConnectionStateChangeListener", "Lcom/syu/media/service/MediaPresenter$OnPlayModeChangedListener;", "registerOnPlayModeChangedListener", "unregisterOnPlayModeChangedListener", "Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", "registerOnPlayStateChangedListener", "unregisterOnPlayStateChangedListener", "Lcom/syu/media/service/MediaPresenter$OnPlayProgressChangedListener;", "registerOnPlayProgressChangedListener", "unregisterOnPlayProgressChangedListener", "Lcom/syu/media/player/IPlayer$Callback2;", "callback", "registerCallback2", "unregisterCallback2", "Landroid/view/Surface;", "surface", "setupSurface", "reset", "play", "pause", NotificationCompat.CATEGORY_PROGRESS, "seekTo", "nextPlayMode", "Lcom/syu/media/player/PlayMode;", "playMode", "postPlayMode", FinalChip.BSP_PLATFORM_Null, Media.LIST_TABLE, "setPlayList", FinalChip.BSP_PLATFORM_Null, Media.PATH, "playWithPath", "id", "playWithId", "index", "playPlayList", "playPlayListWithId", "binderDied", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "d", "Z", "getNeedInit", "()Z", "setNeedInit", "(Z)V", "needInit", "value", "e", "isBound", "setBound", "h", "Lcom/syu/media/player/PlayMode;", "getPlayMode", "()Lcom/syu/media/player/PlayMode;", "setPlayMode", "(Lcom/syu/media/player/PlayMode;)V", "i", "setPlaying", "j", "Lcom/syu/media/entities/MediaSource;", "getPlayingSong", "()Lcom/syu/media/entities/MediaSource;", "setPlayingSong", "(Lcom/syu/media/entities/MediaSource;)V", "playingSong", "m", "I", "getVideoWidth", "()I", "setVideoWidth", "(I)V", "videoWidth", "n", "getVideoHeight", "setVideoHeight", "videoHeight", "Ljava/lang/Runnable;", "u", "Ljava/lang/Runnable;", "getBindService", "()Ljava/lang/Runnable;", "bindService", "action", "Landroid/view/View;", "playCtrView", "nextCtrView", "prevCtrView", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "OnConnectionStateChangeListener", "OnPlayModeChangedListener", "OnPlayProgressChangedListener", "OnPlayStateChangedListener", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaPresenter extends ICallback.Stub implements ServiceConnection, IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;
    public final String b;
    public final LauncherApps c;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean needInit;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean isBound;
    public IPlayer f;
    public PlaybackService g;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public PlayMode playMode;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public boolean isPlaying;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public volatile MediaSource playingSong;
    public int k;
    public boolean l;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int videoWidth;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int videoHeight;
    public final Handler o;
    public final ArrayList p;
    public final ArrayList q;
    public final ArrayList r;
    public final ArrayList s;
    public final ArrayList t;
    public final MediaPresenter$bindService$1 u;
    public final MediaPresenter$callback$1 v;
    public final MediaPresenter$callback2$1 w;
    public final MediaPresenter$onProgressNotify$1 x;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/syu/media/service/MediaPresenter$OnConnectionStateChangeListener;", FinalChip.BSP_PLATFORM_Null, "onConnectionStateChanged", FinalChip.BSP_PLATFORM_Null, "connected", FinalChip.BSP_PLATFORM_Null, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnConnectionStateChangeListener {
        void onConnectionStateChanged(boolean connected);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/syu/media/service/MediaPresenter$OnPlayModeChangedListener;", FinalChip.BSP_PLATFORM_Null, "onChanged", FinalChip.BSP_PLATFORM_Null, "mode", "Lcom/syu/media/player/PlayMode;", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnPlayModeChangedListener {
        void onChanged(PlayMode mode);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/syu/media/service/MediaPresenter$OnPlayProgressChangedListener;", FinalChip.BSP_PLATFORM_Null, "onChanged", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_PROGRESS, FinalChip.BSP_PLATFORM_Null, Media.DURATION, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnPlayProgressChangedListener {
        void onChanged(int progress, int duration);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", FinalChip.BSP_PLATFORM_Null, "onChanged", FinalChip.BSP_PLATFORM_Null, "isPlaying", FinalChip.BSP_PLATFORM_Null, "source", "Lcom/syu/media/entities/MediaSource;", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnPlayStateChangedListener {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onChanged$default(OnPlayStateChangedListener onPlayStateChangedListener, boolean z, MediaSource mediaSource, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onChanged");
                }
                if ((i & 2) != 0) {
                    mediaSource = null;
                }
                onPlayStateChangedListener.onChanged(z, mediaSource);
            }
        }

        void onChanged(boolean isPlaying, MediaSource source);
    }

    /* JADX INFO: renamed from: com.syu.media.service.MediaPresenter$onPlayModeChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.media.service.MediaPresenter$onPlayModeChanged$1", f = "MediaPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaPresenter.this.new AnonymousClass1(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            List list = MediaPresenter.this.p;
            MediaPresenter mediaPresenter = MediaPresenter.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((OnPlayModeChangedListener) it.next()).onChanged(mediaPresenter.getPlayMode());
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.service.MediaPresenter$onPlayStatusChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.media.service.MediaPresenter$onPlayStatusChanged$1", f = "MediaPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00741(boolean z, Continuation continuation) {
            super(2, continuation);
            this.b = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaPresenter.this.new C00741(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            List list = MediaPresenter.this.q;
            boolean z = this.b;
            MediaPresenter mediaPresenter = MediaPresenter.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((OnPlayStateChangedListener) it.next()).onChanged(z, mediaPresenter.getPlayingSong());
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.service.MediaPresenter$onSongChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.media.service.MediaPresenter$onSongChanged$1", f = "MediaPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ MediaSource b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00751(MediaSource mediaSource, Continuation continuation) {
            super(2, continuation);
            this.b = mediaSource;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaPresenter.this.new C00751(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            List list = MediaPresenter.this.q;
            MediaPresenter mediaPresenter = MediaPresenter.this;
            MediaSource mediaSource = this.b;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((OnPlayStateChangedListener) it.next()).onChanged(mediaPresenter.getIsPlaying(), mediaSource);
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.syu.media.service.MediaPresenter$callback2$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.syu.media.service.MediaPresenter$onProgressNotify$1] */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.syu.media.service.MediaPresenter$bindService$1] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.content.pm.LauncherApps$Callback, com.syu.media.service.MediaPresenter$callback$1] */
    public MediaPresenter(Context context, String str, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "action");
        this.context = context;
        this.b = str;
        Object systemService = context.getApplicationContext().getSystemService("launcherapps");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.pm.LauncherApps");
        LauncherApps launcherApps = (LauncherApps) systemService;
        this.c = launcherApps;
        this.needInit = true;
        this.playMode = PlayMode.LIST;
        this.o = new Handler(Looper.getMainLooper());
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new Runnable() { // from class: com.syu.media.service.MediaPresenter$bindService$1
            @Override // java.lang.Runnable
            public void run() {
                this.a.o.removeCallbacks(this);
                if (this.a.getIsBound()) {
                    return;
                }
                this.a.a();
                this.a.o.postDelayed(this, 1000L);
            }
        };
        ?? r3 = new LauncherApps.Callback() { // from class: com.syu.media.service.MediaPresenter$callback$1
            @Override // android.content.pm.LauncherApps.Callback
            public void onPackageAdded(String packageName, UserHandle user) {
                if (packageName != null) {
                    MediaPresenter mediaPresenter = this.a;
                    if (Intrinsics.areEqual(packageName, MediaConstant.AUTHORITY) && mediaPresenter.f == null) {
                        mediaPresenter.o.removeCallbacks(mediaPresenter.getBindService());
                        mediaPresenter.o.postDelayed(mediaPresenter.getBindService(), 200L);
                    }
                }
            }

            @Override // android.content.pm.LauncherApps.Callback
            public void onPackageChanged(String packageName, UserHandle user) {
                if (packageName != null) {
                    MediaPresenter mediaPresenter = this.a;
                    if (Intrinsics.areEqual(packageName, MediaConstant.AUTHORITY) && mediaPresenter.f == null) {
                        mediaPresenter.o.removeCallbacks(mediaPresenter.getBindService());
                        mediaPresenter.o.postDelayed(mediaPresenter.getBindService(), 200L);
                    }
                }
            }

            @Override // android.content.pm.LauncherApps.Callback
            public void onPackageRemoved(String packageName, UserHandle user) {
            }

            @Override // android.content.pm.LauncherApps.Callback
            public void onPackagesAvailable(String[] packageNames, UserHandle user, boolean replacing) {
                if (packageNames != null) {
                    MediaPresenter mediaPresenter = this.a;
                    for (String str2 : packageNames) {
                        if (Intrinsics.areEqual(str2, MediaConstant.AUTHORITY) && mediaPresenter.f == null) {
                            mediaPresenter.o.removeCallbacks(mediaPresenter.getBindService());
                            mediaPresenter.o.postDelayed(mediaPresenter.getBindService(), 200L);
                        }
                    }
                }
            }

            @Override // android.content.pm.LauncherApps.Callback
            public void onPackagesUnavailable(String[] packageNames, UserHandle user, boolean replacing) {
            }
        };
        this.v = r3;
        this.w = new ICallback2.Stub() { // from class: com.syu.media.service.MediaPresenter$callback2$1
            @Override // com.syu.media.ICallback2
            public void onVideoSizeChanged(int videoWidth, int videoHeight) {
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new MediaPresenter$callback2$1$onVideoSizeChanged$1(this.a, videoWidth, videoHeight, null), 3, (Object) null);
            }
        };
        this.x = new Runnable() { // from class: com.syu.media.service.MediaPresenter$onProgressNotify$1
            @Override // java.lang.Runnable
            public void run() {
                this.a.o.removeCallbacks(this);
                try {
                    MediaPresenter mediaPresenter = this.a;
                    IPlayer iPlayer = mediaPresenter.f;
                    mediaPresenter.k = iPlayer != null ? iPlayer.getProgress() : 0;
                } catch (Exception unused) {
                }
                List<MediaPresenter.OnPlayProgressChangedListener> list = this.a.r;
                MediaPresenter mediaPresenter2 = this.a;
                for (MediaPresenter.OnPlayProgressChangedListener onPlayProgressChangedListener : list) {
                    int i = mediaPresenter2.k;
                    MediaSource playingSong = mediaPresenter2.getPlayingSong();
                    onPlayProgressChangedListener.onChanged(i, playingSong != null ? playingSong.getCom.syu.media.provider.Media.DURATION java.lang.String() : 0);
                }
                if (this.a.l) {
                    this.a.o.postDelayed(this, 500L);
                }
            }
        };
        a();
        launcherApps.registerCallback(r3);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.service.MediaPresenter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    MediaPresenter.a(this.f$0, view4);
                }
            });
        }
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.service.MediaPresenter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    MediaPresenter.b(this.f$0, view4);
                }
            });
        }
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.service.MediaPresenter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    MediaPresenter.c(this.f$0, view4);
                }
            });
        }
    }

    public static final void a(MediaPresenter mediaPresenter, View view) {
        Intrinsics.checkNotNullParameter(mediaPresenter, "this$0");
        IPlayer iPlayer = mediaPresenter.f;
        if (iPlayer != null) {
            if (iPlayer.isPlaying()) {
                iPlayer.pause();
            } else {
                iPlayer.play();
            }
        }
    }

    public static final void b(MediaPresenter mediaPresenter, View view) {
        Intrinsics.checkNotNullParameter(mediaPresenter, "this$0");
        IPlayer iPlayer = mediaPresenter.f;
        if (iPlayer != null) {
            iPlayer.playNext();
        }
    }

    public static final void c(MediaPresenter mediaPresenter, View view) {
        Intrinsics.checkNotNullParameter(mediaPresenter, "this$0");
        IPlayer iPlayer = mediaPresenter.f;
        if (iPlayer != null) {
            iPlayer.playLast();
        }
    }

    public static /* synthetic */ void playPlayListWithId$default(MediaPresenter mediaPresenter, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        mediaPresenter.playPlayListWithId(i, i2);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.asBinder().unlinkToDeath(this, 0);
        }
        setBound(false);
        setBound(false);
        this.f = null;
        this.playingSong = null;
        this.g = null;
        this.isPlaying = false;
        if (this.needInit) {
            this.o.removeCallbacks(this.u);
            this.o.postDelayed(this.u, 1200L);
        }
    }

    public final void enablePlayProgress(boolean enable) {
        if (this.l != enable) {
            this.l = enable;
            this.o.removeCallbacks(this.x);
        }
        if (this.l) {
            this.o.post(this.x);
        }
    }

    public final Runnable getBindService() {
        return this.u;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getNeedInit() {
        return this.needInit;
    }

    public final PlayMode getPlayMode() {
        return this.playMode;
    }

    public final MediaSource getPlayingSong() {
        return this.playingSong;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    /* JADX INFO: renamed from: isBound, reason: from getter */
    public final boolean getIsBound() {
        return this.isBound;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void nextPlayMode() {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.setPlayMode(PlayMode.INSTANCE.nextMode(this.playMode).getValue());
        }
    }

    @Override // com.syu.media.ICallback
    public void onPlayModeChanged(int mode) {
        this.playMode = PlayMode.INSTANCE.modeOfValue(mode);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    @Override // com.syu.media.ICallback
    public void onPlayStatusChanged(boolean isPlaying) {
        this.isPlaying = isPlaying;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C00741(isPlaying, null), 3, (Object) null);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("music", " 11 onServiceConnected " + name + "  " + service + XmlConsts.CHAR_SPACE);
        if (service != null) {
            try {
                service.linkToDeath(this, 0);
                IPlayer iPlayerAsInterface = IPlayer.Stub.asInterface(service);
                if (iPlayerAsInterface != null) {
                    this.f = iPlayerAsInterface;
                    Log.e("music", " onServiceConnected " + name + "  " + service + XmlConsts.CHAR_SPACE);
                    IPlayer iPlayer = this.f;
                    if (iPlayer != null) {
                        iPlayer.registerCallback(this);
                    }
                    IPlayer iPlayer2 = this.f;
                    if (iPlayer2 != null) {
                        iPlayer2.registerCallback2(this.w);
                    }
                    IPlayer iPlayer3 = this.f;
                    this.playingSong = iPlayer3 != null ? iPlayer3.getPlayingSong() : null;
                    Log.e("music", " 020202  onSongChanged --> " + this.playingSong + XmlConsts.CHAR_SPACE);
                    IPlayer iPlayer4 = this.f;
                    this.isPlaying = iPlayer4 != null ? iPlayer4.isPlaying() : false;
                    MediaSource mediaSource = this.playingSong;
                    if (mediaSource != null) {
                        onSongChanged(mediaSource);
                    }
                    onPlayStatusChanged(this.isPlaying);
                    IPlayer iPlayer5 = this.f;
                    if (iPlayer5 != null) {
                        onPlayModeChanged(iPlayer5.getPlayMode());
                    }
                }
                if (service instanceof PlaybackBinder) {
                    this.g = ((PlaybackBinder) service).getService();
                }
                setBound(true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        setBound(false);
        this.f = null;
        this.playingSong = null;
        this.g = null;
        this.isPlaying = false;
        if (this.needInit) {
            this.o.removeCallbacks(this.u);
            this.o.postDelayed(this.u, 1500L);
        }
    }

    @Override // com.syu.media.ICallback
    public void onSongChanged(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual(this.playingSong, source)) {
            return;
        }
        this.playingSong = source;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C00751(source, null), 3, (Object) null);
    }

    public final void pause() {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.pause();
        }
    }

    public final void play() {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.play();
        }
    }

    public final void playPlayList(List<MediaSource> list, int index) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.playListWithIndex(list, index);
        }
    }

    public final void playPlayListWithId(int list, int id) {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.playListWithId(list, id);
        }
    }

    public final void playWithId(int id) {
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.playListWithId(null, id);
        }
    }

    public final void playWithPath(String path) {
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        try {
            IPlayer iPlayer = this.f;
            if (iPlayer != null) {
                iPlayer.playWithPath(path);
            }
        } catch (Exception unused) {
        }
    }

    public final void postPlayMode(PlayMode playMode) {
        Intrinsics.checkNotNullParameter(playMode, "playMode");
        IPlayer iPlayer = this.f;
        if (iPlayer == null) {
            return;
        }
        iPlayer.setPlayMode(playMode.getValue());
    }

    public final void registerCallback2(com.syu.media.player.IPlayer.Callback2 callback) {
        int i;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.s.contains(callback)) {
            return;
        }
        this.s.add(callback);
        int i2 = this.videoWidth;
        if (i2 <= 0 || (i = this.videoHeight) <= 0) {
            return;
        }
        callback.onVideoSizeChanged(i2, i);
    }

    public final void registerOnConnectionStateChangeListener(OnConnectionStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.t.contains(listener)) {
            return;
        }
        this.t.add(listener);
        listener.onConnectionStateChanged(this.isBound);
    }

    public final void registerOnPlayModeChangedListener(OnPlayModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.p.contains(listener)) {
            return;
        }
        this.p.add(listener);
        listener.onChanged(this.playMode);
    }

    public final void registerOnPlayProgressChangedListener(OnPlayProgressChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.r.contains(listener)) {
            return;
        }
        this.r.add(listener);
        int i = this.k;
        MediaSource mediaSource = this.playingSong;
        listener.onChanged(i, mediaSource != null ? mediaSource.getCom.syu.media.provider.Media.DURATION java.lang.String() : 0);
    }

    public final void registerOnPlayStateChangedListener(OnPlayStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.q.contains(listener)) {
            return;
        }
        this.q.add(listener);
        listener.onChanged(this.isPlaying, this.playingSong);
    }

    public final void reset() {
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.reset();
        }
    }

    public final void seekTo(int progress) {
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.seekTo(progress);
        }
    }

    public final void setBound(boolean z) {
        if (this.isBound != z) {
            this.isBound = z;
            Iterator it = this.t.iterator();
            while (it.hasNext()) {
                ((OnConnectionStateChangeListener) it.next()).onConnectionStateChanged(z);
            }
        }
    }

    public final void setNeedInit(boolean z) {
        this.needInit = z;
    }

    public final void setPlayList(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.setPlayList(list);
        }
    }

    public final void setPlayMode(PlayMode playMode) {
        Intrinsics.checkNotNullParameter(playMode, "<set-?>");
        this.playMode = playMode;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public final void setPlayingSong(MediaSource mediaSource) {
        this.playingSong = mediaSource;
    }

    public final void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public final void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public final void setupSurface(Surface surface) {
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.setSurface(surface);
        }
    }

    public final void unbind() {
        this.needInit = false;
        this.c.unregisterCallback(this.v);
        IPlayer iPlayer = this.f;
        if (iPlayer != null) {
            iPlayer.unregisterCallback(this);
        }
        this.context.unbindService(this);
        this.f = null;
        this.playingSong = null;
        this.g = null;
        this.isPlaying = false;
    }

    public final void unregisterCallback2(com.syu.media.player.IPlayer.Callback2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.s.contains(callback)) {
            this.s.remove(callback);
        }
    }

    public final void unregisterOnConnectionStateChangeListener(OnConnectionStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.t.contains(listener)) {
            this.t.remove(listener);
        }
    }

    public final void unregisterOnPlayModeChangedListener(OnPlayModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.p.contains(listener)) {
            this.p.remove(listener);
        }
    }

    public final void unregisterOnPlayProgressChangedListener(OnPlayProgressChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.r.contains(listener)) {
            this.r.remove(listener);
        }
    }

    public final void unregisterOnPlayStateChangedListener(OnPlayStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.q.contains(listener)) {
            this.q.remove(listener);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MediaPresenter(Context context, String str, View view, View view2, View view3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str = PlaybackService.class.getName();
            Intrinsics.checkNotNullExpressionValue(str, "PlaybackService::class.java.name");
        }
        this(context, str, (i & 4) != 0 ? null : view, (i & 8) != 0 ? null : view2, (i & 16) != 0 ? null : view3);
    }

    public final void a() {
        if (this.isBound) {
            return;
        }
        Intent intent = new Intent(this.b);
        intent.setPackage(MediaConstant.AUTHORITY);
        Log.e("music", " bind " + this.b + "  " + intent + XmlConsts.CHAR_SPACE);
        this.needInit = true;
        this.context.bindService(intent, this, 1);
    }

    public final void playPlayList(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        PlaybackService playbackService = this.g;
        if (playbackService != null) {
            playbackService.playListWithSource(list, source);
        }
    }
}
