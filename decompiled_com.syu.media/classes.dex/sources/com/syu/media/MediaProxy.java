package com.syu.media;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.MutableLiveData;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.provider.Media;
import com.syu.media.service.MediaPresenter;
import com.syu.media.service.PlaybackService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001~B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020=J\u0006\u0010o\u001a\u00020mJ\u001c\u0010o\u001a\u00020m2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010q\u001a\u00020\fJ\u001c\u0010o\u001a\u00020m2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010r\u001a\u00020\u0012J\u001c\u0010s\u001a\u00020m2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010q\u001a\u00020\fJ\u000e\u0010t\u001a\u00020m2\u0006\u0010n\u001a\u00020=J\u0010\u0010u\u001a\u00020m2\b\u0010v\u001a\u0004\u0018\u00010wJ\"\u0010x\u001a\u00020m2\b\b\u0002\u0010y\u001a\u00020\u00182\u0010\b\u0002\u0010z\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010{J\u0016\u0010c\u001a\u00020m2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\f0}H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001f\u0010/\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00120\u001200¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001f\u00104\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00120\u001200¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u001b\u00106\u001a\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001b\u0010P\u001a\u00020Q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010;\u001a\u0004\bR\u0010SR\"\u0010U\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\u001c\u0010X\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010\u0010R\u001c\u0010`\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010Z\"\u0004\bb\u0010\\R\u0011\u0010c\u001a\u00020d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001b\u0010g\u001a\u00020h8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010;\u001a\u0004\bi\u0010j¨\u0006\u007f"}, d2 = {"Lcom/syu/media/MediaProxy;", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "clazz", "Ljava/lang/Class;", "Lcom/syu/media/service/PlaybackService;", "(Landroid/content/Context;Ljava/lang/Class;)V", "TAG", FinalChip.BSP_PLATFORM_Null, "all", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", "getAll", "()Ljava/util/List;", "setAll", "(Ljava/util/List;)V", "columns", FinalChip.BSP_PLATFORM_Null, "getColumns", "()I", "setColumns", "(I)V", "constraint", "Lcom/syu/media/ConstraintList;", "getConstraint", "()Lcom/syu/media/ConstraintList;", "setConstraint", "(Lcom/syu/media/ConstraintList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "job", "Lkotlinx/coroutines/Job;", "lastPlaying", FinalChip.BSP_PLATFORM_Null, "getLastPlaying", "()Z", "setLastPlaying", "(Z)V", "lastTime", FinalChip.BSP_PLATFORM_Null, "getLastTime", "()J", "setLastTime", "(J)V", "listCondition01", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getListCondition01", "()Landroidx/lifecycle/MutableLiveData;", "listCondition02", "getListCondition02", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "mOnPlayListListeners", "Lcom/syu/media/MediaProxy$OnPlayListListener;", "mPlayingList", "mPresenter", "Lcom/syu/media/service/MediaPresenter;", "getMPresenter", "()Lcom/syu/media/service/MediaPresenter;", "setMPresenter", "(Lcom/syu/media/service/MediaPresenter;)V", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "setMediaDao", "(Lcom/syu/media/dao/MediaDao;)V", "onlinePath", "getOnlinePath", "()Ljava/lang/String;", "setOnlinePath", "(Ljava/lang/String;)V", "playState", "Lcom/syu/media/PlayState;", "getPlayState", "()Lcom/syu/media/PlayState;", "playState$delegate", "playingList", "getPlayingList", "setPlayingList", "playingSource", "getPlayingSource", "()Lcom/syu/media/entities/MediaSource;", "setPlayingSource", "(Lcom/syu/media/entities/MediaSource;)V", "toPlayList", "getToPlayList", "setToPlayList", "toPlaySource", "getToPlaySource", "setToPlaySource", "updateList", "Ljava/lang/Runnable;", "getUpdateList", "()Ljava/lang/Runnable;", "workerThread", "Landroid/os/HandlerThread;", "getWorkerThread", "()Landroid/os/HandlerThread;", "workerThread$delegate", "addOnPlayListListener", FinalChip.BSP_PLATFORM_Null, "listener", "play", Media.LIST_TABLE, "source", "position", "readyToPlay", "removeOnPlayListListener", "setSurface", "surface", "Landroid/view/Surface;", "setupPlayList", "constraintList", "callback", "Lkotlin/Function0;", "audios", FinalChip.BSP_PLATFORM_Null, "OnPlayListListener", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaProxy {
    private final String TAG;
    private List<MediaSource> all;
    private int columns;
    private ConstraintList constraint;
    private Context context;
    private Job job;
    private boolean lastPlaying;
    private long lastTime;
    private final MutableLiveData<Integer> listCondition01;
    private final MutableLiveData<Integer> listCondition02;

    /* JADX INFO: renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;
    private final List<OnPlayListListener> mOnPlayListListeners;
    private List<MediaSource> mPlayingList;
    private MediaPresenter mPresenter;
    private MediaDao mediaDao;
    private String onlinePath;

    /* JADX INFO: renamed from: playState$delegate, reason: from kotlin metadata */
    private final Lazy playState;
    private List<MediaSource> playingList;
    private MediaSource playingSource;
    private List<MediaSource> toPlayList;
    private MediaSource toPlaySource;
    private final Runnable updateList;

    /* JADX INFO: renamed from: workerThread$delegate, reason: from kotlin metadata */
    private final Lazy workerThread;

    /* JADX INFO: compiled from: MediaProxy.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/syu/media/MediaProxy$OnPlayListListener;", FinalChip.BSP_PLATFORM_Null, "onChanged", FinalChip.BSP_PLATFORM_Null, Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPlayListListener {
        void onChanged(List<? extends MediaSource> list);
    }

    public MediaProxy(Context context, Class<? extends PlaybackService> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.context = context;
        Context context2 = this.context;
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        this.mPresenter = new MediaPresenter(context2, name, null, null, null, 28, null);
        this.columns = 6;
        this.onlinePath = FinalChip.BSP_PLATFORM_Null;
        this.mPlayingList = new ArrayList();
        this.mOnPlayListListeners = new ArrayList();
        this.playState = LazyKt.lazy(new Function0<PlayState>() { // from class: com.syu.media.MediaProxy$playState$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PlayState m100invoke() {
                return new PlayState(0, null, 0, 0, 0, 0, 0, false, 255, null);
            }
        });
        this.TAG = "MediaProxy";
        this.listCondition01 = new MutableLiveData<>(0);
        this.listCondition02 = new MutableLiveData<>(0);
        this.workerThread = LazyKt.lazy(new Function0<HandlerThread>() { // from class: com.syu.media.MediaProxy$workerThread$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final HandlerThread m102invoke() {
                HandlerThread handlerThread = new HandlerThread("media_proxy");
                handlerThread.start();
                return handlerThread;
            }
        });
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.media.MediaProxy$mHandler$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m99invoke() {
                return new Handler(this.this$0.getWorkerThread().getLooper());
            }
        });
        this.lastTime = -1L;
        this.updateList = new Runnable() { // from class: com.syu.media.MediaProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaProxy.m98updateList$lambda2(this.f$0);
            }
        };
        this.mPresenter.registerOnConnectionStateChangeListener(new MediaPresenter.OnConnectionStateChangeListener() { // from class: com.syu.media.MediaProxy.1
            @Override // com.syu.media.service.MediaPresenter.OnConnectionStateChangeListener
            public void onConnectionStateChanged(boolean connected) {
                if (connected) {
                    return;
                }
                Job job = MediaProxy.this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                MediaProxy.this.job = null;
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final MediaPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void setMPresenter(MediaPresenter mediaPresenter) {
        Intrinsics.checkNotNullParameter(mediaPresenter, "<set-?>");
        this.mPresenter = mediaPresenter;
    }

    public final MediaDao getMediaDao() {
        return this.mediaDao;
    }

    public final void setMediaDao(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    public final int getColumns() {
        return this.columns;
    }

    public final void setColumns(int i) {
        this.columns = i;
    }

    public final List<MediaSource> getToPlayList() {
        return this.toPlayList;
    }

    public final void setToPlayList(List<MediaSource> list) {
        this.toPlayList = list;
    }

    public final List<MediaSource> getPlayingList() {
        return this.playingList;
    }

    public final void setPlayingList(List<MediaSource> list) {
        this.playingList = list;
    }

    public final MediaSource getToPlaySource() {
        return this.toPlaySource;
    }

    public final void setToPlaySource(MediaSource mediaSource) {
        this.toPlaySource = mediaSource;
    }

    public final MediaSource getPlayingSource() {
        return this.playingSource;
    }

    public final void setPlayingSource(MediaSource mediaSource) {
        this.playingSource = mediaSource;
    }

    public final String getOnlinePath() {
        return this.onlinePath;
    }

    public final void setOnlinePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onlinePath = str;
    }

    public final List<MediaSource> getAll() {
        return this.all;
    }

    public final void setAll(List<MediaSource> list) {
        this.all = list;
    }

    public final ConstraintList getConstraint() {
        return this.constraint;
    }

    public final void setConstraint(ConstraintList constraintList) {
        this.constraint = constraintList;
    }

    public final PlayState getPlayState() {
        return (PlayState) this.playState.getValue();
    }

    public final boolean getLastPlaying() {
        return this.lastPlaying;
    }

    public final void setLastPlaying(boolean z) {
        this.lastPlaying = z;
    }

    public final MutableLiveData<Integer> getListCondition01() {
        return this.listCondition01;
    }

    public final MutableLiveData<Integer> getListCondition02() {
        return this.listCondition02;
    }

    public final HandlerThread getWorkerThread() {
        return (HandlerThread) this.workerThread.getValue();
    }

    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    public final long getLastTime() {
        return this.lastTime;
    }

    public final void setLastTime(long j) {
        this.lastTime = j;
    }

    public final Runnable getUpdateList() {
        return this.updateList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateList$lambda-2, reason: not valid java name */
    public static final void m98updateList$lambda2(MediaProxy mediaProxy) {
        Intrinsics.checkNotNullParameter(mediaProxy, "this$0");
        Log.d("music", "updateList");
        List<MediaSource> mutableList = CollectionsKt.toMutableList(mediaProxy.mPlayingList);
        ArrayList arrayList = new ArrayList();
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            AudioSource audioSource = (AudioSource) ((MediaSource) it.next());
            if (audioSource != null) {
                arrayList.add(audioSource);
            }
        }
        ArrayList arrayList2 = arrayList;
        Iterator<T> it2 = mediaProxy.mOnPlayListListeners.iterator();
        while (it2.hasNext()) {
            ((OnPlayListListener) it2.next()).onChanged(arrayList2);
        }
        mediaProxy.mPresenter.setPlayList(mutableList);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MediaProxy$updateList$1$2(mediaProxy, arrayList2, null), 3, (Object) null);
    }

    public final void setSurface(Surface surface) {
        if (this.mPresenter.getIsPlaying()) {
            this.mPresenter.pause();
            this.mPresenter.setupSurface(surface);
            this.mPresenter.play();
            return;
        }
        this.mPresenter.setupSurface(surface);
    }

    public final void play(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        this.mPresenter.playPlayList(list, source);
    }

    public final void play(List<MediaSource> list, int position) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        this.mPresenter.playPlayList(list, position);
    }

    public final void play() {
        List<MediaSource> list = this.toPlayList;
        if (list != null && this.toPlaySource != null) {
            Intrinsics.checkNotNull(list);
            MediaSource mediaSource = this.toPlaySource;
            Intrinsics.checkNotNull(mediaSource);
            play(list, mediaSource);
        } else {
            this.mPresenter.play();
        }
        this.toPlayList = null;
        this.toPlaySource = null;
    }

    public final void readyToPlay(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        this.toPlayList = list;
        this.toPlaySource = source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setupPlayList$default(MediaProxy mediaProxy, ConstraintList constraintList, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            constraintList = new ConstraintList();
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        mediaProxy.setupPlayList(constraintList, function0);
    }

    public final void setupPlayList(ConstraintList constraintList, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(constraintList, "constraintList");
        Log.e("music", "setupPlayList constraintList: " + constraintList + XmlConsts.CHAR_SPACE);
        if (Intrinsics.areEqual(this.constraint, constraintList)) {
            if (callback != null) {
                callback.invoke();
                return;
            }
            return;
        }
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mPlayingList.clear();
        this.lastTime = -1L;
        this.job = null;
        constraintList.setMediaDao(this.mediaDao);
        this.constraint = constraintList;
        ConstraintState constraintState = new ConstraintState(null, null, null, null, 0, 31, null);
        constraintState.setAlbum(constraintList.getAlbum());
        constraintState.setArtist(constraintList.getArtist());
        constraintState.setFolder(constraintList.getFolder());
        constraintState.setFavorite(constraintList.getFavorite());
        constraintState.setRootFolder(constraintList.getRootFolder());
        SharedPrefUtils.INSTANCE.setObject(this.context, ConstantsKt.MUSIC_PLAY_LIST, constraintState);
        this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00471(callback, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.MediaProxy$setupPlayList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaProxy.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.MediaProxy$setupPlayList$1", f = "MediaProxy.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
    static final class C00471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00471(Function0<Unit> function0, Continuation<? super C00471> continuation) {
            super(2, continuation);
            this.$callback = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaProxy.this.new C00471(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Flow<List<AudioSource>> flowValues;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                ConstraintList constraint = MediaProxy.this.getConstraint();
                if (constraint != null && (flowValues = constraint.values()) != null) {
                    Log.e("music", "setupPlayList =======  flow: " + flowValues + XmlConsts.CHAR_SPACE);
                    this.label = 1;
                    if (FlowKt.collectLatest(flowValues, new AnonymousClass2(MediaProxy.this, booleanRef, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.MediaProxy$setupPlayList$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: MediaProxy.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "audios", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.MediaProxy$setupPlayList$1$2", f = "MediaProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<List<AudioSource>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $callback;
            final /* synthetic */ Ref.BooleanRef $first;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MediaProxy this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MediaProxy mediaProxy, Ref.BooleanRef booleanRef, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = mediaProxy;
                this.$first = booleanRef;
                this.$callback = function0;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, this.$first, this.$callback, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(List<AudioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                this.this$0.updateList(list);
                if (this.$first.element) {
                    Log.e("music", "first setupPlayList =======  size: " + list.size());
                    this.$first.element = false;
                    Handler mHandler = this.this$0.getMHandler();
                    final Function0<Unit> function0 = this.$callback;
                    mHandler.postDelayed(new Runnable() { // from class: com.syu.media.MediaProxy$setupPlayList$1$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaProxy.C00471.AnonymousClass2.m101invokeSuspend$lambda0(function0);
                        }
                    }, 300L);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
            public static final void m101invokeSuspend$lambda0(Function0 function0) {
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateList(List<? extends MediaSource> audios) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List mutableList = CollectionsKt.toMutableList(this.mPlayingList);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MediaSource mediaSource = (MediaSource) next;
            MediaDao mediaDao = this.mediaDao;
            if ((mediaDao != null ? mediaDao.getAudioSourceId(mediaSource.getCom.syu.media.provider.Media.PATH java.lang.String()) : -1) < 0 || !audios.contains(mediaSource)) {
                arrayList3.add(next);
            }
        }
        arrayList2.addAll(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : audios) {
            MediaSource mediaSource2 = (MediaSource) obj;
            MediaDao mediaDao2 = this.mediaDao;
            if ((mediaDao2 != null ? mediaDao2.getAudioSourceId(mediaSource2.getCom.syu.media.provider.Media.PATH java.lang.String()) : -1) >= 0 && !mutableList.contains(mediaSource2)) {
                arrayList4.add(obj);
            }
        }
        arrayList.addAll(arrayList4);
        boolean z = arrayList2.size() > 0 || arrayList.size() > 0;
        mutableList.removeAll(arrayList2);
        mutableList.addAll(arrayList);
        if (z) {
            List list = mutableList;
            this.mPlayingList = CollectionsKt.toMutableList(list);
            getMHandler().removeCallbacks(this.updateList);
            if (this.lastTime == -1 || SystemClock.elapsedRealtime() - this.lastTime > CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
                ArrayList<MediaSource> arrayList5 = new ArrayList(list);
                ArrayList arrayList6 = new ArrayList();
                for (MediaSource mediaSource3 : arrayList5) {
                    if (mediaSource3 != null) {
                        AudioSource audioSource = (AudioSource) mediaSource3;
                        if (audioSource != null) {
                            arrayList6.add(audioSource);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.syu.media.entities.AudioSource");
                    }
                }
                ArrayList arrayList7 = arrayList6;
                Iterator<T> it2 = this.mOnPlayListListeners.iterator();
                while (it2.hasNext()) {
                    ((OnPlayListListener) it2.next()).onChanged(arrayList7);
                }
                this.mPresenter.setPlayList(arrayList5);
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass5(arrayList7, null), 3, (Object) null);
                this.lastTime = SystemClock.elapsedRealtime();
            }
            getMHandler().postDelayed(this.updateList, 200L);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.MediaProxy$updateList$5, reason: invalid class name */
    /* JADX INFO: compiled from: MediaProxy.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.MediaProxy$updateList$5", f = "MediaProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AudioSource> $songs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(List<AudioSource> list, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$songs = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaProxy.this.new AnonymousClass5(this.$songs, continuation);
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
            MediaDao mediaDao = MediaProxy.this.getMediaDao();
            if (mediaDao != null) {
                mediaDao.updateAudioPlayList(this.$songs);
            }
            Log.e("music", " updateList ----->> 22 size: " + MediaProxy.this.mPlayingList.size());
            return Unit.INSTANCE;
        }
    }

    public final void addOnPlayListListener(OnPlayListListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mOnPlayListListeners.contains(listener)) {
            return;
        }
        this.mOnPlayListListeners.add(listener);
        listener.onChanged(new ArrayList(this.mPlayingList));
    }

    public final void removeOnPlayListListener(OnPlayListListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mOnPlayListListeners.contains(listener)) {
            this.mOnPlayListListeners.remove(listener);
        }
    }
}
