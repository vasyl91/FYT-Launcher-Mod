package com.syu.media.radio.audio;

import android.content.Context;
import android.media.AudioManager;
import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import syu.utils.MediaManager;

/* JADX INFO: compiled from: RadioAudioFocusChange.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/syu/media/radio/audio/RadioAudioFocusChange;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "radioManger", "Lsyu/utils/MediaManager;", "getRadioManger", "()Lsyu/utils/MediaManager;", "radioManger$delegate", "Lkotlin/Lazy;", "stream", FinalChip.BSP_PLATFORM_Null, "onAudioFocusChange", FinalChip.BSP_PLATFORM_Null, "focusChange", "requestAudioFocus", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioAudioFocusChange implements AudioManager.OnAudioFocusChangeListener {
    public static final String TAG = "RadioAudioFocusChange";
    private final Context context;

    /* JADX INFO: renamed from: radioManger$delegate, reason: from kotlin metadata */
    private final Lazy radioManger;
    private final int stream;

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
    }

    public RadioAudioFocusChange(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.stream = 3;
        this.radioManger = LazyKt.lazy(new Function0<MediaManager>() { // from class: com.syu.media.radio.audio.RadioAudioFocusChange$radioManger$2
            {
                super(0);
            }

            public final MediaManager invoke() {
                return MediaManager.Companion.createManager(this.this$0.context, Media.ONLINE_TABLE, true);
            }
        });
    }

    private final MediaManager getRadioManger() {
        return (MediaManager) this.radioManger.getValue();
    }

    public final boolean requestAudioFocus() {
        MediaManager radioManger = getRadioManger();
        return radioManger != null && radioManger.requestAudioFocus(this.stream, 1, this);
    }
}
