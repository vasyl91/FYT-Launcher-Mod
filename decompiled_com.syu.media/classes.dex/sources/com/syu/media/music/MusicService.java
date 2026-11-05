package com.syu.media.music;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.event.EventManager;
import com.syu.manger.module.main.MainController;
import com.syu.manger.module.main.MainModel;
import com.syu.media.MediaApp;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.PlayState;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.entities.MediaSource;
import com.syu.media.provider.Media;
import com.syu.media.service.PlaybackService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.utils.MediaManager;

/* JADX INFO: compiled from: MusicService.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\u001e\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020$0)2\u0006\u0010*\u001a\u00020\bH\u0016J\u001e\u0010+\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020$0)2\u0006\u0010,\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/syu/media/music/MusicService;", "Lcom/syu/media/service/PlaybackService;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "()V", "accPlaying", FinalChip.BSP_PLATFORM_Null, "appIdChanged", "Landroidx/lifecycle/Observer;", FinalChip.BSP_PLATFORM_Null, "idAudio", "mainModel", "Lcom/syu/manger/module/main/MainModel;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel$delegate", "Lkotlin/Lazy;", "mediaManger", "Lsyu/utils/MediaManager;", "getMediaManger", "()Lsyu/utils/MediaManager;", "mediaManger$delegate", "runningChanged", "stream", "getStream", "()I", "onAudioFocusChange", FinalChip.BSP_PLATFORM_Null, "focusChange", "onCreate", "onDestroy", "onPlayModeChanged", "mode", "onPlayStatusChanged", "isPlaying", "onSongChanged", Media.SONG_TABLE, "Lcom/syu/media/entities/MediaSource;", "pause", "play", "playListWithIndex", Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, "startIndex", "playListWithSource", "source", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicService extends PlaybackService implements AudioManager.OnAudioFocusChangeListener {
    public static final String TAG = "MusicService";
    private boolean accPlaying;
    private final int stream = 3;

    /* JADX INFO: renamed from: mainModel$delegate, reason: from kotlin metadata */
    private final Lazy mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.music.MusicService$mainModel$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MainModel m155invoke() {
            ViewModel viewModel = MediaApp.INSTANCE.getMe().getViewModelProvider().get(MainModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (MainModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: mediaManger$delegate, reason: from kotlin metadata */
    private final Lazy mediaManger = LazyKt.lazy(new Function0<MediaManager>() { // from class: com.syu.media.music.MusicService$mediaManger$2
        {
            super(0);
        }

        public final MediaManager invoke() {
            return MediaManager.Companion.createManager(this.this$0, "music", true);
        }
    });
    private int idAudio = -1;
    private final Observer<Integer> appIdChanged = new Observer() { // from class: com.syu.media.music.MusicService$$ExternalSyntheticLambda0
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            MusicService.m153appIdChanged$lambda1(this.f$0, (Integer) obj);
        }
    };
    private final Observer<Boolean> runningChanged = new Observer() { // from class: com.syu.media.music.MusicService$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            MusicService.m154runningChanged$lambda2(this.f$0, (Boolean) obj);
        }
    };

    public final int getStream() {
        return this.stream;
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    private final MediaManager getMediaManger() {
        return (MediaManager) this.mediaManger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: appIdChanged$lambda-1, reason: not valid java name */
    public static final void m153appIdChanged$lambda1(MusicService musicService, Integer num) {
        Intrinsics.checkNotNullParameter(musicService, "this$0");
        MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
        if (audioProxy != null) {
            HiLog.INSTANCE.d(TAG, "appId:" + num + " ,isPlaying:" + musicService.isPlaying() + " ,lastPlaying:" + audioProxy.getLastPlaying());
            Intrinsics.checkNotNullExpressionValue(num, "appId");
            musicService.idAudio = num.intValue();
            if (num.intValue() == 8) {
                if (!musicService.isPlaying() && audioProxy.getLastPlaying()) {
                    musicService.play();
                    audioProxy.setLastPlaying(musicService.isPlaying());
                }
                MediaManager.Companion companion = MediaManager.Companion;
                MediaManager mediaManger = musicService.getMediaManger();
                Intrinsics.checkNotNull(mediaManger);
                companion.registerMediaButtonFor(mediaManger.getName());
                return;
            }
            HiLog.INSTANCE.d(TAG, "else appId:" + num + " ,lastPlaying:" + audioProxy.getLastPlaying());
            if (musicService.isPlaying()) {
                audioProxy.setLastPlaying(musicService.isPlaying());
                musicService.pause();
            }
            MediaManager.Companion companion2 = MediaManager.Companion;
            MediaManager mediaManger2 = musicService.getMediaManger();
            Intrinsics.checkNotNull(mediaManger2);
            companion2.unregisterMediaButtonFor(mediaManger2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runningChanged$lambda-2, reason: not valid java name */
    public static final void m154runningChanged$lambda2(MusicService musicService, Boolean bool) {
        Intrinsics.checkNotNullParameter(musicService, "this$0");
        HiLog.INSTANCE.d(TAG, "isRunning:" + bool + " ,idAudio:" + musicService.idAudio + " ,isPlaying:" + musicService.isPlaying() + " ,accPlaying:" + musicService.accPlaying);
        if (!bool.booleanValue() && musicService.isPlaying()) {
            musicService.accPlaying = musicService.isPlaying();
            musicService.pause();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(bool, "isRunning");
        if (bool.booleanValue() && musicService.accPlaying && !musicService.isPlaying() && musicService.idAudio == 8) {
            musicService.accPlaying = musicService.isPlaying();
            musicService.play();
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.MusicService$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MusicService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.MusicService$onCreate$1", f = "MusicService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicService.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MusicService.this.getMainModel().isRunning().observeForever(MusicService.this.runningChanged);
            MusicService.this.getMainModel().getAppId().observeForever(MusicService.this.appIdChanged);
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.service.PlaybackService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        EventManager.INSTANCE.getMe().addOnPlayCtrlHandler(new EventManager.OnPlayCtrlHandler() { // from class: com.syu.media.music.MusicService.onCreate.2
            {
                super(8);
            }

            @Override // com.syu.manger.module.event.EventManager.OnPlayCtrlHandler
            public void onPlayCtrl(int cmdId) {
                if (cmdId == 0) {
                    MusicService.this.play();
                    return;
                }
                if (cmdId == 1) {
                    if (MusicService.this.isPlaying()) {
                        MusicService.this.pause();
                        return;
                    } else {
                        MusicService.this.play();
                        return;
                    }
                }
                if (cmdId == 2) {
                    MusicService.this.pause();
                } else if (cmdId == 4) {
                    MusicService.this.playLast();
                } else {
                    if (cmdId != 5) {
                        return;
                    }
                    MusicService.this.playNext();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.syu.media.music.MusicService$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.MusicService$onDestroy$1", f = "MusicService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00501(Continuation<? super C00501> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicService.this.new C00501(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MusicService.this.getMainModel().isRunning().removeObserver(MusicService.this.runningChanged);
            MusicService.this.getMainModel().getAppId().removeObserver(MusicService.this.appIdChanged);
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.service.PlaybackService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C00501(null), 3, (Object) null);
        MediaManager mediaManger = getMediaManger();
        if (mediaManger != null) {
            mediaManger.abandonAudioFocus();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        HiLog.INSTANCE.d(TAG, "onAudioFocusChange");
        if (focusChange == 1) {
            play();
        } else {
            pause();
        }
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean playListWithIndex(List<MediaSource> list, int startIndex) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        if (!Intrinsics.areEqual(getMainModel().isRunning().getValue(), true)) {
            return false;
        }
        MediaManager mediaManger = getMediaManger();
        if (!(mediaManger != null && mediaManger.requestAudioFocus(this.stream, 1, this))) {
            return false;
        }
        HiLog.INSTANCE.d(TAG, "playListWithIndex");
        AutoManager.INSTANCE.requestInstance().openAppId(8);
        return super.playListWithIndex(list, startIndex);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean playListWithSource(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        if (!Intrinsics.areEqual(getMainModel().isRunning().getValue(), true)) {
            return false;
        }
        MediaManager mediaManger = getMediaManger();
        if (!(mediaManger != null && mediaManger.requestAudioFocus(this.stream, 1, this))) {
            return false;
        }
        HiLog.INSTANCE.d(TAG, "playListWithSource");
        AutoManager.INSTANCE.requestInstance().openAppId(8);
        return super.playListWithSource(list, source);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean pause() {
        PlayState playState;
        HiLog.INSTANCE.d(TAG, "pause");
        MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
        if (audioProxy != null && (playState = audioProxy.getPlayState()) != null) {
            MusicStatic musicStatic = MusicStatic.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            musicStatic.pushPlayStateForSharePref(applicationContext, playState);
        }
        return super.pause();
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean play() {
        HiLog.INSTANCE.d(TAG, "play111:" + getMainModel().isRunning().getValue());
        if (!Intrinsics.areEqual(getMainModel().isRunning().getValue(), true)) {
            return false;
        }
        MediaManager mediaManger = getMediaManger();
        if (!(mediaManger != null && mediaManger.requestAudioFocus(this.stream, 1, this))) {
            return false;
        }
        HiLog.INSTANCE.d(TAG, "play");
        AutoManager.INSTANCE.requestInstance().openAppId(8);
        return super.play();
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onSongChanged(MediaSource song) {
        MediaProxy audioProxy;
        Intrinsics.checkNotNullParameter(song, Media.SONG_TABLE);
        HiLog.INSTANCE.d(TAG, "onSongChanged: path:" + song.getCom.syu.media.provider.Media.PATH java.lang.String());
        if ((song.getCom.syu.media.provider.Media.PATH java.lang.String().length() > 0) && !Intrinsics.areEqual(song.getCom.syu.media.provider.Media.PATH java.lang.String(), "unknown") && (audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy()) != null) {
            audioProxy.setPlayingSource(song);
        }
        super.onSongChanged(song);
        MainController mainController = AutoManager.INSTANCE.requestInstance().getMainController();
        String title = song.getTitle();
        String str = FinalChip.BSP_PLATFORM_Null;
        if (title == null) {
            title = FinalChip.BSP_PLATFORM_Null;
        }
        mainController.syncTitleOfId3(8, title);
        String str2 = song.getCom.syu.media.provider.Media.ALBUM java.lang.String();
        if (str2 == null) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        mainController.syncAlbumOfId3(8, str2);
        String str3 = song.getCom.syu.media.provider.Media.ARTIST java.lang.String();
        if (str3 != null) {
            str = str3;
        }
        mainController.syncArtistOfId3(8, str);
        mainController.syncMediaType(8, 1);
        int playingIndex = getPlayer().getPlayingIndex();
        List<MediaSource> playList = getPlayer().getPlayList();
        mainController.syncTrackInfo(8, playingIndex, playList != null ? playList.size() : 0);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onPlayModeChanged(int mode) {
        super.onPlayModeChanged(mode);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onPlayStatusChanged(boolean isPlaying) {
        Integer value;
        super.onPlayStatusChanged(isPlaying);
        MainController mainController = AutoManager.INSTANCE.requestInstance().getMainController();
        HiLog.INSTANCE.d(TAG, "onPlayStatusChanged isPlaying:" + isPlaying + "  ,appId:" + AutoManager.INSTANCE.requestInstance().getMainModel().getAppId().getValue());
        if (isPlaying && ((value = AutoManager.INSTANCE.requestInstance().getMainModel().getAppId().getValue()) == null || value.intValue() != 8)) {
            AutoManager.INSTANCE.requestInstance().openAppId(8);
        }
        mainController.syncPlayState(8, isPlaying);
    }
}
