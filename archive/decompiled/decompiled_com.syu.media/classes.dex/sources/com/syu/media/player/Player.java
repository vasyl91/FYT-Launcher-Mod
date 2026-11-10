package com.syu.media.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.MediaSync;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import syu.utils.FileUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001bB\u0019\u0012\u0006\u0010D\u001a\u00020?\u0012\b\b\u0002\u0010_\u001a\u00020\u0011¢\u0006\u0004\b`\u0010aJ\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J \u0010\u0010\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0015\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010'\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010'\u001a\u00020*H\u0016J\u0012\u0010/\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\tH\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\t2\u0006\u00105\u001a\u000204H\u0016J\"\u00109\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016J \u00109\u001a\u00020\t2\u0006\u0010;\u001a\u00020:2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016J\u000e\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0011J\u0012\u0010>\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104H\u0016R\u0017\u0010D\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010K\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010N\u001a\u0004\bT\u0010UR\"\u0010Z\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010F\u001a\u0004\bX\u0010H\"\u0004\bY\u0010JR\"\u0010^\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010F\u001a\u0004\b\\\u0010H\"\u0004\b]\u0010J¨\u0006c"}, d2 = {"Lcom/syu/media/player/Player;", "Lcom/syu/media/player/IPlayer;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "Landroid/media/MediaSync$OnErrorListener;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, "setPlayList", FinalChip.BSP_PLATFORM_Null, "play", "playList", FinalChip.BSP_PLATFORM_Null, Media.PATH, "playListWithPath", FinalChip.BSP_PLATFORM_Null, "id", "playListWithId", "startIndex", "playListWithIndex", "source", "playListWithSource", "playSource", "playLast", "playNext", "pause", "isPlaying", "getProgress", "getPlayingSong", "getPlayMode", "getPlayList", NotificationCompat.CATEGORY_PROGRESS, "seekTo", "playMode", "setPlayMode", "audioSessionId", "Lcom/syu/media/player/IPlayer$Callback;", "callback", "registerCallback", "unregisterCallback", "Lcom/syu/media/player/IPlayer$Callback2;", "registerCallback2", "unregisterCallback2", "Landroid/view/Surface;", "surface", "setSurface", "removeCallbacks", "removeCallback2s", "reset", "releasePlayer", "Landroid/media/MediaPlayer;", "mp", "onCompletion", "what", "extra", "onError", "Landroid/media/MediaSync;", "sync", Media.TYPE, "isPlayerType", "onPrepared", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "d", "I", "getPlayingIndex", "()I", "setPlayingIndex", "(I)V", "playingIndex", "Landroid/os/HandlerThread;", "l", "Lkotlin/Lazy;", "getPlayerThread", "()Landroid/os/HandlerThread;", "playerThread", "Landroid/os/Handler;", "m", "getMHandler", "()Landroid/os/Handler;", "mHandler", "n", "getDuration", "setDuration", Media.DURATION, "o", "getPlayProcess", "setPlayProcess", "playProcess", "playerType", "<init>", "(Landroid/content/Context;I)V", "Companion", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class Player implements IPlayer, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaSync.OnErrorListener {
    public static final int AUDIO_PLAYER = 0;
    public static final int ONLINE_RADIO = 2;
    public static final int VIDEO_PLAYER = 1;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;
    public final int b;
    public List c;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int playingIndex;
    public MediaPlayer e;
    public PlayMode f;
    public boolean g;
    public final ArrayList h;
    public final ArrayList i;
    public Surface j;
    public Size k;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy playerThread;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy mHandler;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int duration;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int playProcess;
    public Integer p;
    public final Player$mGetPlayProcess$1 q;
    public final int r;
    public int s;
    public MediaSource t;
    public final Player$mReStart$1 u;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final boolean v = true;
    public static final String w = "Player";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/syu/media/player/Player$Companion;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "DEBUG", "Z", "getDEBUG", "()Z", FinalChip.BSP_PLATFORM_Null, "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", FinalChip.BSP_PLATFORM_Null, "AUDIO_PLAYER", "I", "ONLINE_RADIO", "VIDEO_PLAYER", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getDEBUG() {
            return Player.v;
        }

        public final String getTAG() {
            return Player.w;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayMode.values().length];
            try {
                iArr[PlayMode.LOOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMode.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayMode.SINGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlayMode.SHUFFLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.syu.media.player.Player$mGetPlayProcess$1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.syu.media.player.Player$mReStart$1] */
    public Player(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.b = i;
        this.c = new ArrayList();
        this.e = new MediaPlayer();
        this.f = PlayMode.LIST;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = new Size(0, 0);
        this.playerThread = LazyKt.lazy(new Function0<HandlerThread>() { // from class: com.syu.media.player.Player$playerThread$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final HandlerThread m216invoke() {
                HandlerThread handlerThread = new HandlerThread("Player-" + this.a.b);
                handlerThread.start();
                return handlerThread;
            }
        });
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.media.player.Player$mHandler$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m215invoke() {
                return new Handler(this.a.getPlayerThread().getLooper());
            }
        });
        this.q = new Runnable() { // from class: com.syu.media.player.Player$mGetPlayProcess$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.a.isPlaying()) {
                    Player player = this.a;
                    MediaPlayer mediaPlayer = player.e;
                    player.setPlayProcess(mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0);
                    MediaPlayer mediaPlayer2 = this.a.e;
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.getDuration();
                    }
                }
                this.a.getMHandler().removeCallbacks(this);
                this.a.getMHandler().postDelayed(this, 600L);
            }
        };
        this.r = 3;
        this.u = new Runnable() { // from class: com.syu.media.player.Player$mReStart$1
            @Override // java.lang.Runnable
            public void run() {
                this.a.getMHandler().removeCallbacks(this);
                this.a.play();
            }
        };
        if (v) {
            Log.e(w, "----------->>  Player init");
        }
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
        }
        MediaPlayer mediaPlayer2 = this.e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnErrorListener(this);
        }
        MediaPlayer mediaPlayer3 = this.e;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(this);
        }
        MediaPlayer mediaPlayer4 = this.e;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnPreparedListener(this);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    public final void a(PlayMode playMode) throws NoWhenBranchMatchedException {
        if (this.c.isEmpty()) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[playMode.ordinal()];
        int iMax = 0;
        if (i != 1) {
            if (i == 2 || i == 3) {
                if (this.playingIndex == this.c.size() - 1) {
                    iMax = this.c.size() - 1;
                } else {
                    iMax = Math.max(0, Math.min(this.playingIndex + 1, this.c.size() - 1));
                }
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                iMax = RangesKt.random(RangesKt.until(0, this.c.size()), Random.Default);
            }
        } else if (this.playingIndex != this.c.size() - 1) {
            iMax = Math.max(0, Math.min(this.playingIndex + 1, this.c.size() - 1));
        }
        this.playingIndex = iMax;
    }

    @Override // com.syu.media.player.IPlayer
    public int audioSessionId() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            return mediaPlayer.getAudioSessionId();
        }
        return -1;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    @Override // com.syu.media.player.IPlayer
    public List<MediaSource> getPlayList() {
        return this.c;
    }

    @Override // com.syu.media.player.IPlayer
    public int getPlayMode() {
        return this.f.getValue();
    }

    public final int getPlayProcess() {
        return this.playProcess;
    }

    public final HandlerThread getPlayerThread() {
        return (HandlerThread) this.playerThread.getValue();
    }

    public final int getPlayingIndex() {
        return this.playingIndex;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.syu.media.player.IPlayer
    public MediaSource getPlayingSong() {
        MediaSource mediaSource;
        if (this.playingIndex >= 0) {
            int size = this.c.size();
            int i = this.playingIndex;
            if (size > i) {
                mediaSource = (MediaSource) this.c.get(i);
            } else {
                mediaSource = null;
            }
        } else {
            mediaSource = null;
        }
        if (v) {
            Log.e(w, "----------->>  getPlayingSong()    " + this.playingIndex + "  size: " + this.c.size() + "  exists: " + (mediaSource != null ? FileUtils.INSTANCE.exists(mediaSource.getCom.syu.media.provider.Media.PATH java.lang.String()) : false));
        }
        if (mediaSource != null && (isPlayerType(2) || FileUtils.INSTANCE.exists(mediaSource.getCom.syu.media.provider.Media.PATH java.lang.String()))) {
            return mediaSource;
        }
        AudioSource audioSource = new AudioSource();
        audioSource.setId(-1);
        audioSource.setTitle("unknown");
        audioSource.setArtist("unknown");
        audioSource.setDisplayName("unknown");
        audioSource.setAlbum("unknown");
        audioSource.setPath("unknown");
        return audioSource;
    }

    @Override // com.syu.media.player.IPlayer
    public int getProgress() {
        return this.playProcess;
    }

    public final boolean isPlayerType(int type) {
        return this.b == type;
    }

    @Override // com.syu.media.player.IPlayer
    public boolean isPlaying() {
        if (v) {
            String str = w;
            StringBuilder sb = new StringBuilder("----------->>  isPlaying() ");
            MediaPlayer mediaPlayer = this.e;
            Log.e(str, sb.append(mediaPlayer != null ? Boolean.valueOf(mediaPlayer.isPlaying()) : null).toString());
        }
        MediaPlayer mediaPlayer2 = this.e;
        if (mediaPlayer2 != null) {
            return mediaPlayer2.isPlaying();
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mp) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(mp, "mp");
        if (v) {
            Log.e(w, "----------->>  onCompletion");
        }
        if (this.f == PlayMode.LIST && this.playingIndex == this.c.size() - 1) {
            return;
        }
        playNext();
    }

    @Override // android.media.MediaSync.OnErrorListener
    public void onError(MediaSync sync, int what, int extra) {
        Intrinsics.checkNotNullParameter(sync, "sync");
        if (v) {
            Log.e(w, "----------->>  Sync onError: " + sync + "  what: " + what + " extra:" + extra);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mp) {
        if (isPlayerType(2)) {
            this.s = -1;
            this.t = null;
            getMHandler().removeCallbacks(this.u);
        }
        if (!isPlayerType(2)) {
            MediaPlayer mediaPlayer = this.e;
            if (mediaPlayer != null) {
                Integer num = this.p;
                mediaPlayer.seekTo(num != null ? num.intValue() : 0);
            }
            this.p = null;
        }
        if (mp != null) {
            mp.start();
        }
        if (isPlayerType(1)) {
            if (v) {
                Log.e(w, "----------->>  Sync onPrepared videoSize:" + (mp != null ? Integer.valueOf(mp.getVideoWidth()) : null) + " x " + (mp != null ? Integer.valueOf(mp.getVideoHeight()) : null));
            }
            if (mp != null) {
                this.k = new Size(mp.getVideoWidth(), mp.getVideoHeight());
            }
            if (isPlayerType(1) && this.k.getWidth() > 0 && this.k.getHeight() > 0) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((IPlayer.Callback2) it.next()).onVideoSizeChanged(this.k.getWidth(), this.k.getHeight());
                }
            }
        }
        getMHandler().removeCallbacks(this.q);
        getMHandler().post(this.q);
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            ((IPlayer.Callback) it2.next()).onPlayStatusChanged(true);
        }
    }

    @Override // com.syu.media.player.IPlayer
    public boolean pause() {
        boolean z = v;
        if (z) {
            Log.e(w, "----------->>  pause()");
        }
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return false;
        }
        Intrinsics.checkNotNull(mediaPlayer);
        if (!mediaPlayer.isPlaying()) {
            return false;
        }
        getMHandler().removeCallbacks(this.q);
        MediaPlayer mediaPlayer2 = this.e;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.pause();
        this.g = true;
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((IPlayer.Callback) it.next()).onPlayStatusChanged(false);
        }
        if (z) {
            String str = w;
            StringBuilder sb = new StringBuilder("----------->>  pause isPlaying() ");
            MediaPlayer mediaPlayer3 = this.e;
            Log.e(str, sb.append(mediaPlayer3 != null ? Boolean.valueOf(mediaPlayer3.isPlaying()) : null).toString());
        }
        return true;
    }

    @Override // com.syu.media.player.IPlayer
    public boolean play() {
        MediaSource playingSong;
        MediaPlayer mediaPlayer;
        boolean z = v;
        if (z) {
            Log.e(w, "----------->>  play() " + this.g + XmlConsts.CHAR_SPACE);
        }
        if (this.e == null) {
            return false;
        }
        if (this.g && !isPlaying()) {
            getMHandler().removeCallbacks(this.q);
            MediaPlayer mediaPlayer2 = this.e;
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.start();
            getMHandler().postDelayed(this.q, 200L);
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ((IPlayer.Callback) it.next()).onPlayStatusChanged(true);
            }
            return true;
        }
        if (!(!this.c.isEmpty()) || (playingSong = getPlayingSong()) == null) {
            return false;
        }
        getMHandler().removeCallbacks(this.q);
        if (z) {
            try {
                Log.e(w, "----------->> player type: " + this.b + "  play()  " + this.playingIndex + XmlConsts.CHAR_SPACE + playingSong);
            } catch (Exception unused) {
                Iterator it2 = this.h.iterator();
                while (it2.hasNext()) {
                    ((IPlayer.Callback) it2.next()).onPlayStatusChanged(false);
                }
                return false;
            }
        }
        MediaPlayer mediaPlayer3 = this.e;
        if ((mediaPlayer3 != null && mediaPlayer3.isPlaying()) && (mediaPlayer = this.e) != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer4 = this.e;
        if (mediaPlayer4 != null) {
            mediaPlayer4.reset();
        }
        if (isPlayerType(2)) {
            getMHandler().removeCallbacks(this.u);
            MediaPlayer mediaPlayer5 = this.e;
            if (mediaPlayer5 != null) {
                mediaPlayer5.setDataSource(this.context, Uri.parse(playingSong.getCom.syu.media.provider.Media.PATH java.lang.String()));
            }
            if (this.s == -1 || !Intrinsics.areEqual(playingSong, this.t)) {
                this.s = this.r;
                this.t = playingSong;
            }
            if (this.s > 0) {
                Handler mHandler = getMHandler();
                Player$mReStart$1 player$mReStart$1 = this.u;
                int i = this.r;
                mHandler.postDelayed(player$mReStart$1, (long) ((((i - this.s) / i) + 1) * 4000));
                this.s--;
            }
        } else {
            MediaPlayer mediaPlayer6 = this.e;
            Intrinsics.checkNotNull(mediaPlayer6);
            mediaPlayer6.setDataSource(playingSong.getCom.syu.media.provider.Media.PATH java.lang.String());
        }
        MediaPlayer mediaPlayer7 = this.e;
        if (mediaPlayer7 != null) {
            mediaPlayer7.prepareAsync();
        }
        MediaPlayer mediaPlayer8 = this.e;
        if (mediaPlayer8 != null) {
            mediaPlayer8.setLooping(this.f == PlayMode.SINGLE);
        }
        if (z) {
            Log.e(w, "----------->>  notifySong() source: " + playingSong + "  callbacks.size: " + this.h.size());
        }
        Iterator it3 = this.h.iterator();
        while (it3.hasNext()) {
            ((IPlayer.Callback) it3.next()).onSongChanged(playingSong);
        }
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:25:0x0054 A[PHI: r0
  0x0054: PHI (r0v9 int) = (r0v5 int), (r0v14 int) binds: [B:23:0x004a, B:20:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.syu.media.player.IPlayer
    public boolean playLast() throws NoWhenBranchMatchedException {
        int i;
        int size;
        if (v) {
            Log.e(w, "----------->>  playLast()");
        }
        PlayMode playMode = this.f;
        if (!this.c.isEmpty()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[playMode.ordinal()];
            if (i2 == 1) {
                i = this.playingIndex;
                if (i == 0) {
                    size = this.c.size() - 1;
                } else {
                    size = Math.max(0, Math.min(i - 1, this.c.size() - 1));
                }
            } else if (i2 == 2 || i2 == 3) {
                i = this.playingIndex;
                if (i == 0) {
                    size = 0;
                } else {
                    size = Math.max(0, Math.min(i - 1, this.c.size() - 1));
                }
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                size = RangesKt.random(RangesKt.until(0, this.c.size()), Random.Default);
            }
            this.playingIndex = size;
        }
        if (getPlayingSong() == null) {
            return false;
        }
        this.g = false;
        return play();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playList(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        if (v) {
            Log.e(w, "----------->>  play(list: MutableList<Song>) playList list.size: " + list.size());
        }
        if (!Intrinsics.areEqual(this.c, list)) {
            this.g = false;
            this.c = list;
        }
        return play();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    @Override // com.syu.media.player.IPlayer
    public boolean playListWithId(List<MediaSource> list, int id) {
        Object next;
        Integer id2;
        MediaSource mediaSource = null;
        if (v) {
            Log.e(w, "----------->>  playListWithId(list size : " + (list != null ? Integer.valueOf(list.size()) : null) + ", id: " + id + ") ");
        }
        if (list == null) {
            Iterator it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                Integer id3 = ((MediaSource) it.next()).getId();
                if (!(id3 != null && id3.intValue() == id)) {
                    i++;
                } else if (i >= 0) {
                    return playSource((MediaSource) this.c.get(i));
                }
            }
            i = -1;
            if (i >= 0) {
                return playSource((MediaSource) this.c.get(i));
            }
        } else {
            try {
                Iterator<T> it2 = list.iterator();
                do {
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    next = it2.next();
                    id2 = ((MediaSource) next).getId();
                } while (!(id2 != null && id2.intValue() == id));
                mediaSource = (MediaSource) next;
            } catch (Exception unused) {
            }
            if (mediaSource != null) {
                this.g = false;
                this.playingIndex = list.indexOf(mediaSource);
                return playList(new ArrayList(list));
            }
        }
        return false;
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playListWithIndex(List<MediaSource> list, int startIndex) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        if (v) {
            Log.e(w, "----------->>  play(list: MutableList<Song>, startIndex: Int)");
        }
        if (startIndex < 0 || list.size() <= startIndex) {
            return false;
        }
        if (!Intrinsics.areEqual(getPlayingSong(), list.get(startIndex))) {
            this.g = false;
        }
        this.playingIndex = startIndex;
        return playList(list);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    @Override // com.syu.media.player.IPlayer
    public boolean playListWithPath(List<MediaSource> list, String path) {
        Object next;
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        MediaSource mediaSource = null;
        if (v) {
            Log.e(w, "----------->>  playListWithPath(list size : " + (list != null ? Integer.valueOf(list.size()) : null) + ", path: " + path + ") ");
        }
        if (list == null) {
            Iterator it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!Intrinsics.areEqual(((MediaSource) it.next()).getCom.syu.media.provider.Media.PATH java.lang.String(), path)) {
                    i++;
                } else if (i >= 0) {
                    return playSource((MediaSource) this.c.get(i));
                }
            }
            i = -1;
            if (i >= 0) {
                return playSource((MediaSource) this.c.get(i));
            }
        } else {
            try {
                Iterator<T> it2 = list.iterator();
                do {
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    next = it2.next();
                } while (!Intrinsics.areEqual(((MediaSource) next).getCom.syu.media.provider.Media.PATH java.lang.String(), path));
                mediaSource = (MediaSource) next;
            } catch (Exception unused) {
            }
            if (mediaSource != null) {
                this.g = false;
                this.playingIndex = list.indexOf(mediaSource);
                return playList(new ArrayList(list));
            }
        }
        return false;
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playListWithSource(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        if (!Intrinsics.areEqual(this.c, list)) {
            this.g = false;
            this.c = list;
        }
        return playSource(source);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // com.syu.media.player.IPlayer
    public boolean playNext() throws NoWhenBranchMatchedException {
        if (v) {
            Log.e(w, "----------->>  playNext()");
        }
        a(this.f);
        if (getPlayingSong() == null) {
            return false;
        }
        this.g = false;
        return play();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playSource(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        boolean z = v;
        if (z) {
            Log.e(w, "----------->>  play(song: Song) : true   " + this.c.indexOf(source));
        }
        if (!this.c.contains(source)) {
            this.c.add(source);
            if (z) {
                Log.e(w, "----------->>  play(song: Song) to add source!!");
            }
        }
        Iterator it = this.c.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(((MediaSource) it.next()).getCom.syu.media.provider.Media.PATH java.lang.String(), source.getCom.syu.media.provider.Media.PATH java.lang.String())) {
                break;
            }
            i++;
        }
        this.playingIndex = i;
        this.g = false;
        if (v) {
            Log.e(w, "----------->>  play(song: Song) : " + this.playingIndex + "  " + this.c.get(this.playingIndex));
        }
        return play();
    }

    @Override // com.syu.media.player.IPlayer
    public void registerCallback(IPlayer.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.h.contains(callback)) {
            return;
        }
        this.h.add(callback);
        callback.onPlayModeChanged(this.f.getValue());
    }

    @Override // com.syu.media.player.IPlayer
    public void registerCallback2(IPlayer.Callback2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isPlayerType(1) && !this.i.contains(callback)) {
            this.i.add(callback);
            if (this.k.getWidth() <= 0 || this.k.getHeight() <= 0) {
                return;
            }
            callback.onVideoSizeChanged(this.k.getWidth(), this.k.getHeight());
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void releasePlayer() {
        MediaPlayer mediaPlayer;
        getMHandler().removeCallbacks(this.q);
        this.c = new ArrayList();
        if (isPlaying() && (mediaPlayer = this.e) != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.reset();
        }
        MediaPlayer mediaPlayer3 = this.e;
        if (mediaPlayer3 != null) {
            mediaPlayer3.release();
        }
        this.duration = 0;
        this.playProcess = 0;
        this.e = null;
    }

    @Override // com.syu.media.player.IPlayer
    public void removeCallback2s() {
        if (this.i.size() > 0) {
            this.i.clear();
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void removeCallbacks() {
        if (this.h.size() > 0) {
            this.h.clear();
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void reset() {
        getMHandler().removeCallbacks(this.q);
        this.g = true;
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.reset();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // com.syu.media.player.IPlayer
    public boolean seekTo(int progress) throws NoWhenBranchMatchedException {
        MediaSource playingSong;
        if (v) {
            Log.e(w, "----------->>  seekTo(progress: Int)");
        }
        if (this.e == null || this.c.isEmpty() || (playingSong = getPlayingSong()) == null) {
            return false;
        }
        Log.e(w, "----------->>  seekTo(progress: " + progress + ")  song.duration: " + playingSong.getCom.syu.media.provider.Media.DURATION java.lang.String());
        if (progress < 0) {
            return false;
        }
        if (playingSong.getCom.syu.media.provider.Media.DURATION java.lang.String() <= progress) {
            MediaPlayer mediaPlayer = this.e;
            Intrinsics.checkNotNull(mediaPlayer);
            onCompletion(mediaPlayer);
        } else if (isPlaying()) {
            MediaPlayer mediaPlayer2 = this.e;
            if (mediaPlayer2 != null) {
                mediaPlayer2.seekTo(progress);
            }
        } else {
            this.p = Integer.valueOf(progress);
        }
        return true;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    @Override // com.syu.media.player.IPlayer
    public void setPlayList(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        if (v) {
            Log.e(w, "----------->>  setPlayList() list.size: " + list.size() + " playingIndex:" + this.playingIndex);
        }
        MediaSource playingSong = getPlayingSong();
        this.c = list;
        if (playingSong != null) {
            int iIndexOf = list.indexOf(playingSong);
            this.playingIndex = iIndexOf;
            if (iIndexOf < 0) {
                this.playingIndex = 0;
            }
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void setPlayMode(int playMode) {
        MediaPlayer mediaPlayer;
        if (this.f.getValue() != playMode) {
            PlayMode playModeModeOfValue = PlayMode.INSTANCE.modeOfValue(playMode);
            this.f = playModeModeOfValue;
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ((IPlayer.Callback) it.next()).onPlayModeChanged(playModeModeOfValue.getValue());
            }
            if (!isPlaying() || (mediaPlayer = this.e) == null) {
                return;
            }
            mediaPlayer.setLooping(this.f == PlayMode.SINGLE);
        }
    }

    public final void setPlayProcess(int i) {
        this.playProcess = i;
    }

    public final void setPlayingIndex(int i) {
        this.playingIndex = i;
    }

    @Override // com.syu.media.player.IPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer;
        if (v) {
            Log.e(w, "----------->>  setSurface() surface: " + surface + " isVideoPlayer: " + isPlayerType(1));
        }
        if (isPlayerType(1)) {
            if (surface == null && this.j != null) {
                if (isPlaying()) {
                    pause();
                }
                surface = null;
                this.j = null;
                mediaPlayer = this.e;
                if (mediaPlayer == null) {
                    return;
                }
            } else {
                if (surface == null || Intrinsics.areEqual(this.j, surface)) {
                    return;
                }
                if (isPlaying()) {
                    pause();
                }
                this.j = surface;
                mediaPlayer = this.e;
                if (mediaPlayer == null) {
                    return;
                }
            }
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void unregisterCallback(IPlayer.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.h.contains(callback)) {
            this.h.remove(callback);
        }
    }

    @Override // com.syu.media.player.IPlayer
    public void unregisterCallback2(IPlayer.Callback2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isPlayerType(1) && this.i.contains(callback)) {
            this.i.remove(callback);
        }
    }

    public /* synthetic */ Player(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    public static final void a(Player player) {
        Intrinsics.checkNotNullParameter(player, "this$0");
        player.g = false;
        player.p = Integer.valueOf(player.playProcess);
        player.play();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mp, int what, int extra) throws NoWhenBranchMatchedException {
        MediaSource playingSong;
        boolean z = true;
        if (what != -38) {
            if (what == 1 || what != 100) {
                z = false;
            } else if (this.g || this.playProcess <= 0) {
                MediaPlayer mediaPlayer = this.e;
                if (mediaPlayer != null) {
                    mediaPlayer.reset();
                }
            } else {
                getMHandler().postDelayed(new Runnable() { // from class: com.syu.media.player.Player$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Player.a(this.f$0);
                    }
                }, 0L);
            }
        }
        boolean z2 = v;
        if (z2) {
            Log.e(w, "----------->>  MediaPlayer onError: " + mp + "  what: " + what + " extra:" + extra + " result:" + z + XmlConsts.CHAR_SPACE);
        }
        if (!z) {
            this.g = false;
            if (isPlayerType(2) || ((playingSong = getPlayingSong()) != null && !FileUtils.INSTANCE.exists(playingSong.getCom.syu.media.provider.Media.PATH java.lang.String()))) {
                a(this.f);
            }
        }
        MediaSource playingSong2 = getPlayingSong();
        if (playingSong2 != null) {
            if (z2) {
                Log.e(w, "----------->> onError song: " + playingSong2);
            }
            if (z2) {
                Log.e(w, "----------->>  notifySong() source: " + playingSong2 + "  callbacks.size: " + this.h.size());
            }
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ((IPlayer.Callback) it.next()).onSongChanged(playingSong2);
            }
        }
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            ((IPlayer.Callback) it2.next()).onPlayStatusChanged(false);
        }
        return z;
    }
}
