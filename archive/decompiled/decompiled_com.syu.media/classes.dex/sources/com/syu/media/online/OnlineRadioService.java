package com.syu.media.online;

import android.media.AudioManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.event.EventManager;
import com.syu.manger.module.main.MainController;
import com.syu.manger.module.main.MainModel;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.entities.MediaSource;
import com.syu.media.provider.Media;
import com.syu.media.service.RadioService;
import com.syu.radio.Radio;
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

/* JADX INFO: compiled from: OnlineRadioService.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\u001e\u0010&\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0(2\u0006\u0010)\u001a\u00020$H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/syu/media/online/OnlineRadioService;", "Lcom/syu/media/service/RadioService;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "()V", "appIdChanged", "Landroidx/lifecycle/Observer;", FinalChip.BSP_PLATFORM_Null, "idAudio", "lastPlaying", FinalChip.BSP_PLATFORM_Null, "mainModel", "Lcom/syu/manger/module/main/MainModel;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel$delegate", "Lkotlin/Lazy;", "mediaManger", "Lsyu/utils/MediaManager;", "getMediaManger", "()Lsyu/utils/MediaManager;", "mediaManger$delegate", "runningChanged", "stream", "getStream", "()I", "onAudioFocusChange", FinalChip.BSP_PLATFORM_Null, "focusChange", "onCreate", "onDestroy", "onPlayModeChanged", "mode", "onPlayStatusChanged", "isPlaying", "onSongChanged", "meida", "Lcom/syu/media/entities/MediaSource;", "play", "playListWithSource", Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, "source", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineRadioService extends RadioService implements AudioManager.OnAudioFocusChangeListener {
    public static final String TAG = "OnlineRadioService";
    private boolean lastPlaying;
    private final int stream = 3;

    /* JADX INFO: renamed from: mainModel$delegate, reason: from kotlin metadata */
    private final Lazy mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.online.OnlineRadioService$mainModel$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MainModel m199invoke() {
            ViewModel viewModel = MediaApp.INSTANCE.getMe().getViewModelProvider().get(MainModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (MainModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: mediaManger$delegate, reason: from kotlin metadata */
    private final Lazy mediaManger = LazyKt.lazy(new Function0<MediaManager>() { // from class: com.syu.media.online.OnlineRadioService$mediaManger$2
        {
            super(0);
        }

        public final MediaManager invoke() {
            return MediaManager.Companion.createManager(this.this$0, Radio.ONLINE, true);
        }
    });
    private int idAudio = -1;
    private final Observer<Integer> appIdChanged = new Observer() { // from class: com.syu.media.online.OnlineRadioService$$ExternalSyntheticLambda0
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            OnlineRadioService.m197appIdChanged$lambda0(this.f$0, (Integer) obj);
        }
    };
    private final Observer<Boolean> runningChanged = new Observer() { // from class: com.syu.media.online.OnlineRadioService$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            OnlineRadioService.m198runningChanged$lambda1(this.f$0, (Boolean) obj);
        }
    };

    public final int getStream() {
        return this.stream;
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    public final MediaManager getMediaManger() {
        return (MediaManager) this.mediaManger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: appIdChanged$lambda-0, reason: not valid java name */
    public static final void m197appIdChanged$lambda0(OnlineRadioService onlineRadioService, Integer num) {
        Intrinsics.checkNotNullParameter(onlineRadioService, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "appId");
        onlineRadioService.idAudio = num.intValue();
        if (num.intValue() == 7) {
            if (!onlineRadioService.isPlaying() && onlineRadioService.lastPlaying) {
                onlineRadioService.play();
                onlineRadioService.lastPlaying = onlineRadioService.isPlaying();
            }
            MediaManager.Companion companion = MediaManager.Companion;
            MediaManager mediaManger = onlineRadioService.getMediaManger();
            Intrinsics.checkNotNull(mediaManger);
            companion.registerMediaButtonFor(mediaManger.getName());
            return;
        }
        HiLog.INSTANCE.d(TAG, "else appId:" + num + " ,lastPlaying:" + onlineRadioService.lastPlaying);
        if (onlineRadioService.isPlaying()) {
            onlineRadioService.lastPlaying = onlineRadioService.isPlaying();
            onlineRadioService.pause();
        }
        MediaManager.Companion companion2 = MediaManager.Companion;
        MediaManager mediaManger2 = onlineRadioService.getMediaManger();
        Intrinsics.checkNotNull(mediaManger2);
        companion2.unregisterMediaButtonFor(mediaManger2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runningChanged$lambda-1, reason: not valid java name */
    public static final void m198runningChanged$lambda1(OnlineRadioService onlineRadioService, Boolean bool) {
        Intrinsics.checkNotNullParameter(onlineRadioService, "this$0");
        if (bool.booleanValue() || !onlineRadioService.isPlaying()) {
            return;
        }
        onlineRadioService.pause();
    }

    /* JADX INFO: renamed from: com.syu.media.online.OnlineRadioService$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineRadioService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.OnlineRadioService$onCreate$1", f = "OnlineRadioService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnlineRadioService.this.new AnonymousClass1(continuation);
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
            OnlineRadioService.this.getMainModel().isRunning().observeForever(OnlineRadioService.this.runningChanged);
            OnlineRadioService.this.getMainModel().getAppId().observeForever(OnlineRadioService.this.appIdChanged);
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.service.PlaybackService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        MediaManager mediaManger = getMediaManger();
        if (mediaManger != null) {
            mediaManger.addMediaEvent(AutoKeyEvent.KEYCODE_MEDIA_PLAY, new MediaManager.Action() { // from class: com.syu.media.online.OnlineRadioService.onCreate.2
                public void onHandle() {
                    OnlineRadioService.this.play();
                }
            });
        }
        MediaManager mediaManger2 = getMediaManger();
        if (mediaManger2 != null) {
            mediaManger2.addMediaEvent(AutoKeyEvent.KEYCODE_MEDIA_PAUSE, new MediaManager.Action() { // from class: com.syu.media.online.OnlineRadioService.onCreate.3
                public void onHandle() {
                    OnlineRadioService.this.pause();
                }
            });
        }
        EventManager.INSTANCE.getMe().addOnPlayCtrlHandler(new EventManager.OnPlayCtrlHandler() { // from class: com.syu.media.online.OnlineRadioService.onCreate.4
            {
                super(7);
            }

            @Override // com.syu.manger.module.event.EventManager.OnPlayCtrlHandler
            public void onPlayCtrl(int cmdId) {
                if (cmdId == 0) {
                    OnlineRadioService.this.play();
                    return;
                }
                if (cmdId == 1) {
                    if (OnlineRadioService.this.isPlaying()) {
                        OnlineRadioService.this.pause();
                        return;
                    } else {
                        OnlineRadioService.this.play();
                        return;
                    }
                }
                if (cmdId == 2) {
                    OnlineRadioService.this.pause();
                } else if (cmdId == 4) {
                    OnlineRadioService.this.playLast();
                } else {
                    if (cmdId != 5) {
                        return;
                    }
                    OnlineRadioService.this.playNext();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.syu.media.online.OnlineRadioService$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnlineRadioService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.OnlineRadioService$onDestroy$1", f = "OnlineRadioService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00631(Continuation<? super C00631> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnlineRadioService.this.new C00631(continuation);
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
            OnlineRadioService.this.getMainModel().isRunning().removeObserver(OnlineRadioService.this.runningChanged);
            OnlineRadioService.this.getMainModel().getAppId().removeObserver(OnlineRadioService.this.appIdChanged);
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.service.PlaybackService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C00631(null), 3, (Object) null);
        MediaManager mediaManger = getMediaManger();
        if (mediaManger != null) {
            mediaManger.abandonAudioFocus();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == 1) {
            play();
        } else {
            pause();
        }
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean playListWithSource(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        HiLog.INSTANCE.d(TAG, "play playListWithSource:" + source);
        if (!Intrinsics.areEqual(getMainModel().isRunning().getValue(), true)) {
            return false;
        }
        MediaManager mediaManger = getMediaManger();
        if (!(mediaManger != null && mediaManger.requestAudioFocus(this.stream, 1, this))) {
            return false;
        }
        AutoManager.INSTANCE.requestInstance().openAppId(7);
        return super.playListWithSource(list, source);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer
    public boolean play() {
        HiLog.INSTANCE.d(TAG, "play");
        if (!Intrinsics.areEqual(getMainModel().isRunning().getValue(), true)) {
            return false;
        }
        MediaManager mediaManger = getMediaManger();
        if (!(mediaManger != null && mediaManger.requestAudioFocus(this.stream, 1, this))) {
            return false;
        }
        AutoManager.INSTANCE.requestInstance().openAppId(7);
        return super.play();
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onSongChanged(MediaSource meida) {
        Intrinsics.checkNotNullParameter(meida, "meida");
        HiLog.INSTANCE.d(TAG, "play onSongChanged:" + meida);
        super.onSongChanged(meida);
        MainController mainController = AutoManager.INSTANCE.requestInstance().getMainController();
        String title = meida.getTitle();
        String str = FinalChip.BSP_PLATFORM_Null;
        if (title == null) {
            title = FinalChip.BSP_PLATFORM_Null;
        }
        mainController.syncTitleOfId3(10, title);
        String str2 = meida.getCom.syu.media.provider.Media.ALBUM java.lang.String();
        if (str2 == null) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        mainController.syncAlbumOfId3(10, str2);
        String str3 = meida.getCom.syu.media.provider.Media.ARTIST java.lang.String();
        if (str3 != null) {
            str = str3;
        }
        mainController.syncArtistOfId3(10, str);
        mainController.syncMediaType(10, 1);
        int playingIndex = getPlayer().getPlayingIndex();
        List<MediaSource> playList = getPlayer().getPlayList();
        mainController.syncTrackInfo(7, playingIndex, playList != null ? playList.size() : 0);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onPlayModeChanged(int mode) {
        super.onPlayModeChanged(mode);
    }

    @Override // com.syu.media.service.PlaybackService, com.syu.media.player.IPlayer.Callback
    public void onPlayStatusChanged(boolean isPlaying) {
        HiLog.INSTANCE.d(TAG, "play onPlayStatusChanged playing:" + isPlaying);
        super.onPlayStatusChanged(isPlaying);
        AutoManager.INSTANCE.requestInstance().getMainController().syncPlayState(7, isPlaying);
    }
}
