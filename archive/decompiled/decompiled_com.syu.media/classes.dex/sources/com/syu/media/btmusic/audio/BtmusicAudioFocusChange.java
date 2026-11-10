package com.syu.media.btmusic.audio;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.bt.BluetoothController;
import com.syu.manger.module.bt.BluetoothModel;
import com.syu.manger.module.main.MainModel;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.HiLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import syu.utils.MediaManager;

/* JADX INFO: compiled from: BtmusicAudioFocusChange.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010'\u001a\u00020#J\r\u0010(\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0016J\r\u0010-\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010)J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\r\u00100\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010)J\u0006\u00101\u001a\u00020#J\r\u00102\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010)R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/syu/media/btmusic/audio/BtmusicAudioFocusChange;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appIdChanged", "Landroidx/lifecycle/Observer;", FinalChip.BSP_PLATFORM_Null, "autoManger", "Lcom/syu/manger/AutoManager;", "getAutoManger", "()Lcom/syu/manger/AutoManager;", "autoManger$delegate", "Lkotlin/Lazy;", "btControl", "Lcom/syu/manger/module/bt/BluetoothController;", "getBtControl", "()Lcom/syu/manger/module/bt/BluetoothController;", "btControl$delegate", "btMainModel", "Lcom/syu/manger/module/main/MainModel;", "getBtMainModel", "()Lcom/syu/manger/module/main/MainModel;", "btMainModel$delegate", "btModel", "Lcom/syu/manger/module/bt/BluetoothModel;", "getBtModel", "()Lcom/syu/manger/module/bt/BluetoothModel;", "btModel$delegate", "btMusicManger", "Lsyu/utils/MediaManager;", "getBtMusicManger", "()Lsyu/utils/MediaManager;", "btMusicManger$delegate", "lastPlaying", FinalChip.BSP_PLATFORM_Null, "playing", "playingChange", "stream", "isPlaying", "next", "()Ljava/lang/Boolean;", "onAudioFocusChange", FinalChip.BSP_PLATFORM_Null, "focusChange", "pause", "play", "playPause", "prev", "requestAudioFocus", "stop", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BtmusicAudioFocusChange implements AudioManager.OnAudioFocusChangeListener {
    public static final String TAG = "BtmusicAudioFocusChange";
    private final Observer<Integer> appIdChanged;

    /* JADX INFO: renamed from: autoManger$delegate, reason: from kotlin metadata */
    private final Lazy autoManger;

    /* JADX INFO: renamed from: btControl$delegate, reason: from kotlin metadata */
    private final Lazy btControl;

    /* JADX INFO: renamed from: btMainModel$delegate, reason: from kotlin metadata */
    private final Lazy btMainModel;

    /* JADX INFO: renamed from: btModel$delegate, reason: from kotlin metadata */
    private final Lazy btModel;

    /* JADX INFO: renamed from: btMusicManger$delegate, reason: from kotlin metadata */
    private final Lazy btMusicManger;
    private final Context context;
    private boolean lastPlaying;
    private boolean playing;
    private final Observer<Boolean> playingChange;
    private final int stream;

    public BtmusicAudioFocusChange(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.stream = 3;
        this.btMainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$btMainModel$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MainModel m111invoke() {
                ViewModel viewModel = MediaApp.INSTANCE.getMe().getViewModelProvider().get(MainModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
                return (MainModel) viewModel;
            }
        });
        this.btModel = LazyKt.lazy(new Function0<BluetoothModel>() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$btModel$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BluetoothModel m112invoke() {
                ViewModel viewModel = MediaApp.INSTANCE.getMe().getViewModelProvider().get(BluetoothModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
                return (BluetoothModel) viewModel;
            }
        });
        this.autoManger = LazyKt.lazy(new Function0<AutoManager>() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$autoManger$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AutoManager m109invoke() {
                return AutoManager.INSTANCE.requestInstance();
            }
        });
        this.btControl = LazyKt.lazy(new Function0<BluetoothController>() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$btControl$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BluetoothController m110invoke() {
                return this.this$0.getAutoManger().getBtController();
            }
        });
        this.btMusicManger = LazyKt.lazy(new Function0<MediaManager>() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$btMusicManger$2
            {
                super(0);
            }

            public final MediaManager invoke() {
                return MediaManager.Companion.createManager(this.this$0.context, "btmusic", true);
            }
        });
        Observer<Integer> observer = new Observer() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicAudioFocusChange.m107appIdChanged$lambda0(this.f$0, (Integer) obj);
            }
        };
        this.appIdChanged = observer;
        Observer<Boolean> observer2 = new Observer() { // from class: com.syu.media.btmusic.audio.BtmusicAudioFocusChange$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicAudioFocusChange.m108playingChange$lambda1(this.f$0, (Boolean) obj);
            }
        };
        this.playingChange = observer2;
        getBtMainModel().getAppId().observeForever(observer);
        getBtModel().isBtAvPlaying().observeForever(observer2);
    }

    private final MainModel getBtMainModel() {
        return (MainModel) this.btMainModel.getValue();
    }

    private final BluetoothModel getBtModel() {
        return (BluetoothModel) this.btModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AutoManager getAutoManger() {
        return (AutoManager) this.autoManger.getValue();
    }

    private final BluetoothController getBtControl() {
        return (BluetoothController) this.btControl.getValue();
    }

    private final MediaManager getBtMusicManger() {
        return (MediaManager) this.btMusicManger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: appIdChanged$lambda-0, reason: not valid java name */
    public static final void m107appIdChanged$lambda0(BtmusicAudioFocusChange btmusicAudioFocusChange, Integer num) {
        BluetoothController btControl;
        BluetoothController btControl2;
        Intrinsics.checkNotNullParameter(btmusicAudioFocusChange, "this$0");
        HiLog.INSTANCE.d(TAG, "appId:" + num + " ,isPlaying:" + btmusicAudioFocusChange.playing + " ,lastPlaying:" + btmusicAudioFocusChange.lastPlaying);
        if (num != null && num.intValue() == 3) {
            if (btmusicAudioFocusChange.playing && btmusicAudioFocusChange.lastPlaying && (btControl2 = btmusicAudioFocusChange.getBtControl()) != null) {
                btControl2.btAtPlay();
            }
            MediaManager.Companion companion = MediaManager.Companion;
            MediaManager btMusicManger = btmusicAudioFocusChange.getBtMusicManger();
            Intrinsics.checkNotNull(btMusicManger);
            companion.registerMediaButtonFor(btMusicManger.getName());
            return;
        }
        if (btmusicAudioFocusChange.playing && (btControl = btmusicAudioFocusChange.getBtControl()) != null) {
            btControl.btAtPause();
        }
        btmusicAudioFocusChange.lastPlaying = btmusicAudioFocusChange.playing;
        MediaManager.Companion companion2 = MediaManager.Companion;
        MediaManager btMusicManger2 = btmusicAudioFocusChange.getBtMusicManger();
        Intrinsics.checkNotNull(btMusicManger2);
        companion2.unregisterMediaButtonFor(btMusicManger2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: playingChange$lambda-1, reason: not valid java name */
    public static final void m108playingChange$lambda1(BtmusicAudioFocusChange btmusicAudioFocusChange, Boolean bool) {
        Intrinsics.checkNotNullParameter(btmusicAudioFocusChange, "this$0");
        HiLog.INSTANCE.d(TAG, "playingChange:" + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        btmusicAudioFocusChange.playing = bool.booleanValue();
    }

    public final void play() {
        Integer value = getAutoManger().getMainModel().getAppId().getValue();
        if (value == null || value.intValue() != 3) {
            requestAudioFocus();
            getAutoManger().openAppId(3);
        }
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            btControl.btAtPlay();
        }
    }

    public final void playPause() {
        Integer value = getAutoManger().getMainModel().getAppId().getValue();
        if ((value == null || value.intValue() != 3) && !this.playing) {
            requestAudioFocus();
            getAutoManger().openAppId(3);
        }
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            btControl.btAtPlayPause();
        }
    }

    public final Boolean prev() {
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            return Boolean.valueOf(btControl.btAtPrev());
        }
        return null;
    }

    public final Boolean next() {
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            return Boolean.valueOf(btControl.btAtNext());
        }
        return null;
    }

    public final Boolean pause() {
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            return Boolean.valueOf(btControl.btAtPause());
        }
        return null;
    }

    public final Boolean stop() {
        BluetoothController btControl = getBtControl();
        if (btControl != null) {
            return Boolean.valueOf(btControl.btAtStop());
        }
        return null;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getPlaying() {
        return this.playing;
    }

    public final boolean requestAudioFocus() {
        MediaManager btMusicManger = getBtMusicManger();
        return btMusicManger != null && btMusicManger.requestAudioFocus(this.stream, 1, this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == 1) {
            play();
        } else {
            playPause();
        }
    }
}
