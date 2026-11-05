package syu.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import syu.utils.MediaManager.MediaButtonReceiver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 42\u00020\u0001:\u0003546J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001J\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00067"}, d2 = {"Lsyu/utils/MediaManager;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "", "focusChange", "", "onAudioFocusChange", "stream", "listener", "", "requestAudioFocus", "abandonAudioFocus", "keyCode", "Lsyu/utils/MediaManager$Action;", "action", "addMediaEvent", "removeMediaEvent", "playing", "", "position", "updatePlayState", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "c", "Z", "getButton", "()Z", "button", "Landroid/media/session/MediaSession;", "g", "Landroid/media/session/MediaSession;", "getMediaSession", "()Landroid/media/session/MediaSession;", "setMediaSession", "(Landroid/media/session/MediaSession;)V", "mediaSession", "j", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getFocusChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "setFocusChangeListener", "(Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "focusChangeListener", "Companion", "Action", "MediaButtonReceiver", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class MediaManager implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final LinkedHashMap l = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean button;
    public final AudioManager d;
    public final SparseArray e;
    public ComponentName f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public MediaSession mediaSession;
    public AudioFocusRequest h;
    public int i;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public AudioManager.OnAudioFocusChangeListener focusChangeListener;
    public final MediaManager$mediaCallback$1 k;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lsyu/utils/MediaManager$Action;", "", "onHandle", "", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Action {
        void onHandle();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lsyu/utils/MediaManager$Companion;", "", "Landroid/content/Context;", "context", "", "name", "", "button", "Lsyu/utils/MediaManager;", "createManager", "", "registerMediaButtonFor", "unregisterMediaButtonFor", "", "managers", "Ljava/util/Map;", "Library_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MediaManager createManager$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.createManager(context, str, z);
        }

        public final MediaManager createManager(Context context, String name, boolean button) {
            MediaManager mediaManager;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            synchronized (MediaManager.l) {
                if (MediaManager.l.containsKey(name)) {
                    MediaManager.l.remove(name);
                }
                MediaManager.l.put(name, new MediaManager(context, name, button, null));
                mediaManager = (MediaManager) MediaManager.l.get(name);
            }
            return mediaManager;
        }

        public final void registerMediaButtonFor(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            synchronized (MediaManager.l) {
                for (Map.Entry entry : MediaManager.l.entrySet()) {
                    String str = (String) entry.getKey();
                    MediaManager mediaManager = (MediaManager) entry.getValue();
                    if (!Intrinsics.areEqual(name, str)) {
                        MediaManager.access$unregisterMediaButton(mediaManager);
                    }
                }
                MediaManager mediaManager2 = (MediaManager) MediaManager.l.get(name);
                if (mediaManager2 != null) {
                    MediaManager.access$registerMediaButton(mediaManager2);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void unregisterMediaButtonFor(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            MediaManager mediaManager = (MediaManager) MediaManager.l.get(name);
            if (mediaManager != null) {
                MediaManager.access$unregisterMediaButton(mediaManager);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lsyu/utils/MediaManager$MediaButtonReceiver;", "Landroid/content/BroadcastReceiver;", "(Lsyu/utils/MediaManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Action action;
            Intrinsics.checkNotNullParameter(intent, "intent");
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            StringBuilder sbAppend = new StringBuilder("--------------- ").append(MediaManager.this.getName()).append(" MediaButtonReceiver : ").append(keyEvent).append(' ');
            MediaSession mediaSession = MediaManager.this.getMediaSession();
            Log.e("music", sbAppend.append(mediaSession != null ? mediaSession.getSessionToken() : null).toString());
            if (keyEvent != null) {
                MediaManager mediaManager = MediaManager.this;
                if (keyEvent.getAction() != 1 || (action = (Action) mediaManager.e.get(keyEvent.getKeyCode())) == null) {
                    return;
                }
                action.onHandle();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [syu.utils.MediaManager$mediaCallback$1] */
    public MediaManager(Context context, String str, boolean z) {
        this.context = context;
        this.name = str;
        this.button = z;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.d = (AudioManager) systemService;
        this.e = new SparseArray();
        this.i = -1;
        this.k = new MediaSession.Callback() { // from class: syu.utils.MediaManager$mediaCallback$1
            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
                Intrinsics.checkNotNullParameter(mediaButtonIntent, "mediaButtonIntent");
                this.a.new MediaButtonReceiver().onReceive(this.a.getContext(), mediaButtonIntent);
                return super.onMediaButtonEvent(mediaButtonIntent);
            }
        };
    }

    public static final void access$registerMediaButton(MediaManager mediaManager) {
        if (mediaManager.button) {
            Log.e("music", "--------------- " + mediaManager.name + " registerMediaButton()");
            MediaSession mediaSession = new MediaSession(mediaManager.context, mediaManager.name + "_MediaManager");
            mediaManager.mediaSession = mediaSession;
            mediaSession.setFlags(3);
            MediaSession mediaSession2 = mediaManager.mediaSession;
            if (mediaSession2 != null) {
                mediaSession2.setCallback(mediaManager.k);
            }
            MediaSession mediaSession3 = mediaManager.mediaSession;
            if (mediaSession3 == null) {
                return;
            }
            mediaSession3.setActive(true);
        }
    }

    public static final void access$unregisterMediaButton(MediaManager mediaManager) {
        if (mediaManager.button) {
            Log.e("music", "--------------- " + mediaManager.name + " unregisterMediaButton()");
            MediaSession mediaSession = mediaManager.mediaSession;
            if (mediaSession != null) {
                mediaSession.setActive(false);
            }
            MediaSession mediaSession2 = mediaManager.mediaSession;
            if (mediaSession2 != null) {
                mediaSession2.release();
            }
            mediaManager.mediaSession = null;
        }
    }

    public static /* synthetic */ void updatePlayState$default(MediaManager mediaManager, boolean z, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        mediaManager.updatePlayState(z, j);
    }

    public final void abandonAudioFocus() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            this.d.abandonAudioFocusRequest(audioFocusRequest);
        }
        this.i = -1;
        this.focusChangeListener = null;
    }

    public final void addMediaEvent(int keyCode, Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.e.put(keyCode, action);
    }

    public final boolean getButton() {
        return this.button;
    }

    public final Context getContext() {
        return this.context;
    }

    public final AudioManager.OnAudioFocusChangeListener getFocusChangeListener() {
        return this.focusChangeListener;
    }

    public final MediaSession getMediaSession() {
        return this.mediaSession;
    }

    public final String getName() {
        return this.name;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        this.i = focusChange;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.focusChangeListener;
        if (onAudioFocusChangeListener != null) {
            onAudioFocusChangeListener.onAudioFocusChange(focusChange);
        }
    }

    public final void removeMediaEvent(int keyCode) {
        if (this.e.indexOfKey(keyCode) >= 0) {
            this.e.remove(keyCode);
        }
    }

    public final boolean requestAudioFocus(int stream, int focusChange, AudioManager.OnAudioFocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.focusChangeListener = listener;
        if (this.i == focusChange) {
            return true;
        }
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(focusChange).setAudioAttributes(new AudioAttributes.Builder().setContentType(stream).build()).build();
        this.h = audioFocusRequestBuild;
        AudioManager audioManager = this.d;
        Intrinsics.checkNotNull(audioFocusRequestBuild);
        return audioManager.requestAudioFocus(audioFocusRequestBuild) == 1;
    }

    public final void setFocusChangeListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.focusChangeListener = onAudioFocusChangeListener;
    }

    public final void setMediaSession(MediaSession mediaSession) {
        this.mediaSession = mediaSession;
    }

    public final void updatePlayState(boolean playing, long position) {
        PlaybackState playbackStateBuild = new PlaybackState.Builder().setActions(playing ? 562L : 564L).setState(playing ? 3 : 2, position, 1.0f, SystemClock.elapsedRealtime()).build();
        MediaSession mediaSession = this.mediaSession;
        if (mediaSession != null) {
            mediaSession.setPlaybackState(playbackStateBuild);
        }
    }

    public /* synthetic */ MediaManager(Context context, String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, z);
    }
}
