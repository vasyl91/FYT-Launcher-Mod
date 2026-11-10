package com.syu.media.music.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.syu.media.ConstantsKt;
import com.syu.media.ConstraintList;
import com.syu.media.ConstraintState;
import com.syu.media.MediaApp;
import com.syu.media.MediaFiles;
import com.syu.media.MediaProxy;
import com.syu.media.PlayState;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.utils.DebounceHelper;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.MediaToast;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.companion.utils.TimeUtils;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.databinding.MusicFragmentBinding;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.music.MusicModel;
import com.syu.media.music.MusicService;
import com.syu.media.music.diff.DiffCallBack;
import com.syu.media.music.items.MainListItem;
import com.syu.media.music.items.SpinItem;
import com.syu.media.music.widget.SpinLayoutManager;
import com.syu.media.music.widget.items.XGridLayoutManager;
import com.syu.media.player.PlayMode;
import com.syu.media.provider.Media;
import com.syu.media.service.MediaPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: MusicFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001iB\u0005¢\u0006\u0002\u0010\bJ\u001e\u0010A\u001a\u00020\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u0002050\u00102\u0006\u0010C\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\nH\u0002J\b\u0010G\u001a\u00020EH\u0016J\b\u0010H\u001a\u00020EH\u0016J\u0010\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020EH\u0002J\b\u0010M\u001a\u00020EH\u0016J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0016J\u001a\u0010N\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u00132\b\u0010R\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010N\u001a\u00020E2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0016J\u0016\u0010N\u001a\u00020E2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001e0VH\u0016J\u0010\u0010W\u001a\u00020E2\u0006\u0010X\u001a\u00020\u0013H\u0016J\u0012\u0010Y\u001a\u00020E2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020EH\u0016J\b\u0010]\u001a\u00020EH\u0016J\u0016\u0010^\u001a\u00020E2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00110VH\u0002J\b\u0010`\u001a\u00020EH\u0016J\u0010\u0010a\u001a\u00020E2\u0006\u0010b\u001a\u00020\u0011H\u0002J\u001e\u0010c\u001a\u00020\u00132\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00110V2\u0006\u0010e\u001a\u00020\u0011H\u0002J\u0010\u0010f\u001a\u00020E2\u0006\u0010g\u001a\u00020\u0013H\u0002J\u0016\u0010h\u001a\u00020E2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0VH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u0002050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/syu/media/music/fragment/MusicFragment;", "Lcom/syu/media/music/fragment/MediaBaseFragment;", "Lcom/syu/media/databinding/MusicFragmentBinding;", "Lcom/syu/media/service/MediaPresenter$OnPlayModeChangedListener;", "Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", "Lcom/syu/media/service/MediaPresenter$OnPlayProgressChangedListener;", "Lcom/syu/media/MediaProxy$OnPlayListListener;", "Lcom/syu/media/service/MediaPresenter$OnConnectionStateChangeListener;", "()V", "audiosCount", FinalChip.BSP_PLATFORM_Null, "blurJob", "Lkotlinx/coroutines/Job;", "constr", "Lcom/syu/media/ConstraintList;", "drivePaths", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "enablePlayMode", FinalChip.BSP_PLATFORM_Null, "first", "isCreate", "isTouching", "()Z", "setTouching", "(Z)V", "job", "lastData", "Lsyu/recyclerview/Node;", "lastSong", "Lcom/syu/media/entities/MediaSource;", "listEmptyRunnable", "Ljava/lang/Runnable;", "listJob", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mSpinAdapter", "mediaPresenter", "Lcom/syu/media/service/MediaPresenter;", "musicPlayListRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "musicSpinListRecycler", "needSeek", "value", FinalChip.BSP_PLATFORM_Null, "percentWidth", "getPercentWidth", "()F", "setPercentWidth", "(F)V", "playOn", "playPath", "playSong", "Lcom/syu/media/entities/AudioSource;", "playing", "restoreJob", "resumeHandler", "retryCount", "retryHandler", "songs", "spinData", "spinLayoutManager", "Lcom/syu/media/music/widget/SpinLayoutManager;", "storageCount", "storageJob", "containPath", "audios", Media.PATH, "ifListEmpty", FinalChip.BSP_PLATFORM_Null, "count", "initData", "initObserve", "initView", "view", "Landroid/view/View;", "isNeedSeekTo", "moveTaskToBack", "onChanged", "mode", "Lcom/syu/media/player/PlayMode;", "isPlaying", "source", NotificationCompat.CATEGORY_PROGRESS, Media.DURATION, Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, "onConnectionStateChanged", "connected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPaused", "onRestorePlay", "storagePaths", "onResumed", "playFromUriPath", "uriPath", "startsWith", "datas", "comparseStr", "unfoldTransform", "isUnfold", "updateList", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicFragment extends MediaBaseFragment<MusicFragmentBinding> implements MediaPresenter.OnPlayModeChangedListener, MediaPresenter.OnPlayStateChangedListener, MediaPresenter.OnPlayProgressChangedListener, MediaProxy.OnPlayListListener, MediaPresenter.OnConnectionStateChangeListener {
    public static final String TAG = "MusicFragment";
    public static final String UNKNOWN = "unknown";
    private int audiosCount;
    private Job blurJob;
    private ConstraintList constr;
    private List<String> drivePaths;
    private boolean enablePlayMode;
    private boolean first;
    private boolean isCreate;
    private boolean isTouching;
    private Job job;
    private List<Node<?>> lastData;
    private MediaSource lastSong;
    private Runnable listEmptyRunnable;
    private Job listJob;
    private NodeAdapter mAdapter;
    private NodeAdapter mSpinAdapter;
    private MediaPresenter mediaPresenter;
    private RecyclerView musicPlayListRecycler;
    private RecyclerView musicSpinListRecycler;
    private boolean needSeek;
    private float percentWidth;
    private boolean playOn;
    private String playPath;
    private AudioSource playSong;
    private boolean playing;
    private Job restoreJob;
    private final Runnable resumeHandler;
    private int retryCount;
    private final Runnable retryHandler;
    private List<AudioSource> songs;
    private List<Node<?>> spinData;
    private SpinLayoutManager spinLayoutManager;
    private int storageCount;
    private Job storageJob;

    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayMode.values().length];
            iArr[PlayMode.LOOP.ordinal()] = 1;
            iArr[PlayMode.SINGLE.ordinal()] = 2;
            iArr[PlayMode.SHUFFLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MusicFragment() {
        super(R.layout.music_fragment);
        this.audiosCount = -1;
        this.storageCount = 1;
        this.lastData = new ArrayList();
        this.spinData = new ArrayList();
        this.songs = new ArrayList();
        this.drivePaths = new ArrayList();
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mSpinAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.lastSong = new MediaSource();
        this.playOn = true;
        this.playPath = FinalChip.BSP_PLATFORM_Null;
        this.first = true;
        this.resumeHandler = new Runnable() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                MusicFragment.m171resumeHandler$lambda1(this.f$0);
            }
        };
        this.retryHandler = new Runnable() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                MusicFragment.m172retryHandler$lambda3(this.f$0);
            }
        };
        this.listEmptyRunnable = new Runnable() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MusicFragment.m170listEmptyRunnable$lambda28(this.f$0);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MusicFragmentBinding access$getBinding(MusicFragment musicFragment) {
        return (MusicFragmentBinding) musicFragment.getBinding();
    }

    /* JADX INFO: renamed from: isTouching, reason: from getter */
    public final boolean getIsTouching() {
        return this.isTouching;
    }

    public final void setTouching(boolean z) {
        this.isTouching = z;
    }

    public final float getPercentWidth() {
        return this.percentWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPercentWidth(float f) {
        HiLog.INSTANCE.d(TAG, "setPercentWidth:" + f);
        this.percentWidth = f;
        ViewGroup.LayoutParams layoutParams = ((MusicFragmentBinding) getBinding()).musicMainContain.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintPercentWidth = f;
        ((MusicFragmentBinding) getBinding()).musicMainContain.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resumeHandler$lambda-1, reason: not valid java name */
    public static final void m171resumeHandler$lambda1(MusicFragment musicFragment) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        int iPositionOf = musicFragment.mAdapter.getMData().positionOf(musicFragment.lastSong);
        RecyclerView recyclerView = musicFragment.musicPlayListRecycler;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(iPositionOf);
        }
        RecyclerView recyclerView2 = musicFragment.musicSpinListRecycler;
        if (recyclerView2 != null) {
            recyclerView2.scrollToPosition(iPositionOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: retryHandler$lambda-3, reason: not valid java name */
    public static final void m172retryHandler$lambda3(MusicFragment musicFragment) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        List<String> value = musicFragment.getMediaModel().getStorageDevices().getValue();
        if (value != null) {
            HiLog.INSTANCE.d(TAG, "list:" + value);
            musicFragment.getMediaModel().getStorageDevices().setValue(value);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HiLog.INSTANCE.d(TAG, "onCreate");
        openAppId(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HiLog.INSTANCE.d(TAG, "initView");
        bkChanged(((MusicFragmentBinding) getBinding()).musicFragBlurImg.getId(), getDrawable(R.drawable.btmusic_bk));
        this.musicPlayListRecycler = (RecyclerView) view.findViewById(R.id.music_play_list_recycler);
        this.musicSpinListRecycler = (RecyclerView) view.findViewById(R.id.music_spin_list_recycler);
        ((MusicFragmentBinding) getBinding()).musicPlaySeekbar.setOnSeekBarChangeListener(new AnonymousClass1());
        RecyclerView recyclerView = this.musicPlayListRecycler;
        if (recyclerView != null) {
            recyclerView.setTransitionName(Media.LIST_TABLE);
        }
        RecyclerView recyclerView2 = this.musicPlayListRecycler;
        if (recyclerView2 != null) {
            XGridLayoutManager xGridLayoutManager = new XGridLayoutManager(requireContext(), 3);
            xGridLayoutManager.setOrientation(1);
            recyclerView2.setLayoutManager(xGridLayoutManager);
            recyclerView2.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) recyclerView2.getResources().getDimension(R.dimen.music_item_space)), null, null, null, null, 30, null));
            recyclerView2.setAdapter((RecyclerView.Adapter) this.mAdapter);
            RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
            if (itemAnimator == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            }
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            recyclerView2.setTag(this);
        }
        RecyclerView recyclerView3 = this.musicSpinListRecycler;
        if (recyclerView3 != null) {
            SpinLayoutManager spinLayoutManager = new SpinLayoutManager(1.0f, 0.88f);
            this.spinLayoutManager = spinLayoutManager;
            recyclerView3.setLayoutManager(spinLayoutManager);
            recyclerView3.setAdapter((RecyclerView.Adapter) this.mSpinAdapter);
            RecyclerView.ItemAnimator itemAnimator2 = recyclerView3.getItemAnimator();
            if (itemAnimator2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            }
            ((SimpleItemAnimator) itemAnimator2).setSupportsChangeAnimations(false);
            recyclerView3.setTag(this);
        }
        ((MusicFragmentBinding) getBinding()).musicList.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicFragment.m167initView$lambda7(this.f$0, view2);
            }
        });
        ((MusicFragmentBinding) getBinding()).musicMode.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicFragment.m168initView$lambda8(this.f$0, view2);
            }
        });
        ((MusicFragmentBinding) getBinding()).musicListUnfoldTransform.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicFragment.m169initView$lambda9(this.f$0, view2);
            }
        });
        ((MusicFragmentBinding) getBinding()).musicListFoldTransform.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicFragment.m165initView$lambda10(this.f$0, view2);
            }
        });
        ((MusicFragmentBinding) getBinding()).musicFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MusicFragment.m166initView$lambda12(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$initView$1, reason: invalid class name */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"com/syu/media/music/fragment/MusicFragment$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "toProgress", FinalChip.BSP_PLATFORM_Null, "getToProgress", "()Ljava/lang/Integer;", "setToProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onProgressChanged", FinalChip.BSP_PLATFORM_Null, "seekBar", "Landroid/widget/SeekBar;", NotificationCompat.CATEGORY_PROGRESS, "fromUser", FinalChip.BSP_PLATFORM_Null, "onStartTrackingTouch", "onStopTrackingTouch", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements SeekBar.OnSeekBarChangeListener {
        private Integer toProgress;

        AnonymousClass1() {
        }

        public final Integer getToProgress() {
            return this.toProgress;
        }

        public final void setToProgress(Integer num) {
            this.toProgress = num;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                this.toProgress = Integer.valueOf(progress);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            MusicFragment.this.setTouching(true);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            HiLog.INSTANCE.d(MusicFragment.TAG, "onStopTrackingTouch");
            Integer num = this.toProgress;
            if (num != null) {
                MusicFragment musicFragment = MusicFragment.this;
                int iIntValue = num.intValue();
                MediaPresenter mediaPresenter = musicFragment.mediaPresenter;
                if (mediaPresenter != null) {
                    mediaPresenter.seekTo(iIntValue);
                }
            }
            Handler mh = MusicFragment.this.getMH();
            final MusicFragment musicFragment2 = MusicFragment.this;
            mh.postDelayed(new Runnable() { // from class: com.syu.media.music.fragment.MusicFragment$initView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MusicFragment.AnonymousClass1.m173onStopTrackingTouch$lambda1(this.f$0, musicFragment2);
                }
            }, 520L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onStopTrackingTouch$lambda-1, reason: not valid java name */
        public static final void m173onStopTrackingTouch$lambda1(AnonymousClass1 anonymousClass1, MusicFragment musicFragment) {
            Intrinsics.checkNotNullParameter(anonymousClass1, "this$0");
            Intrinsics.checkNotNullParameter(musicFragment, "this$1");
            anonymousClass1.toProgress = null;
            musicFragment.setTouching(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-7, reason: not valid java name */
    public static final void m167initView$lambda7(MusicFragment musicFragment, View view) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        musicFragment.onStartPage(ConstantsKt.ACTION_PAGE_MUSIC_MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-8, reason: not valid java name */
    public static final void m168initView$lambda8(MusicFragment musicFragment, View view) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        musicFragment.enablePlayMode = true;
        MediaPresenter mediaPresenter = musicFragment.mediaPresenter;
        if (mediaPresenter != null) {
            mediaPresenter.nextPlayMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-9, reason: not valid java name */
    public static final void m169initView$lambda9(MusicFragment musicFragment, View view) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        musicFragment.unfoldTransform(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-10, reason: not valid java name */
    public static final void m165initView$lambda10(MusicFragment musicFragment, View view) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        musicFragment.unfoldTransform(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-12, reason: not valid java name */
    public static final void m166initView$lambda12(MusicFragment musicFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        AudioSource audioSource = musicFragment.playSong;
        if (audioSource != null) {
            audioSource.setFavorite(z);
            musicFragment.getMusicModel().getMusicFavorite().setValue(audioSource);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e6  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initData() {
        String playPath;
        this.retryCount = 0;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String name = MusicService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MusicService::class.java.name");
        this.mediaPresenter = new MediaPresenter(contextRequireContext, name, ((MusicFragmentBinding) getBinding()).musicPlayerPlaypause, ((MusicFragmentBinding) getBinding()).musicPlayerNext, ((MusicFragmentBinding) getBinding()).musicPlayerPrev);
        SharedPrefUtils sharedPrefUtils = SharedPrefUtils.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        ConstraintState constraintState = (ConstraintState) sharedPrefUtils.getObject(contextRequireContext2, ConstantsKt.MUSIC_PLAY_LIST, ConstraintState.class);
        HiLog.INSTANCE.d(TAG, "onViewCreated constraintState:" + constraintState);
        ConstraintList constraintList = new ConstraintList();
        constraintList.setAlbum(constraintState != null ? constraintState.getAlbum() : null);
        constraintList.setArtist(constraintState != null ? constraintState.getArtist() : null);
        constraintList.setFolder(constraintState != null ? constraintState.getFolder() : null);
        constraintList.setFavorite(constraintState != null ? constraintState.getFavorite() : 0);
        constraintList.setRootFolder(constraintState != null ? constraintState.getRootFolder() : null);
        this.constr = constraintList;
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            if (audioProxy.getPlayingSource() != null) {
                MediaSource playingSource = audioProxy.getPlayingSource();
                Intrinsics.checkNotNull(playingSource);
                if (playingSource.getCom.syu.media.provider.Media.PATH java.lang.String().length() == 0) {
                    playPath = audioProxy.getPlayState().getPlayPath();
                } else {
                    MediaProxy audioProxy2 = getAudioProxy();
                    if (audioProxy2 != null) {
                        ConstraintList constraintList2 = this.constr;
                        Intrinsics.checkNotNull(constraintList2);
                        MediaProxy.setupPlayList$default(audioProxy2, constraintList2, null, 2, null);
                    }
                    MediaSource playingSource2 = audioProxy.getPlayingSource();
                    Intrinsics.checkNotNull(playingSource2);
                    playPath = playingSource2.getCom.syu.media.provider.Media.PATH java.lang.String();
                }
            } else {
                playPath = audioProxy.getPlayState().getPlayPath();
            }
            this.playPath = playPath;
        }
        MediaPresenter mediaPresenter = this.mediaPresenter;
        if (mediaPresenter != null) {
            mediaPresenter.registerOnPlayModeChangedListener(this);
            mediaPresenter.registerOnPlayStateChangedListener(this);
            mediaPresenter.registerOnPlayProgressChangedListener(this);
            mediaPresenter.registerOnConnectionStateChangeListener(this);
        }
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        getMediaModel().getStorageDevices().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicFragment.m162initObserve$lambda16(this.f$0, (List) obj);
            }
        });
        MusicModel musicModel = getMusicModel();
        musicModel.getMusicFavorite().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicFragment.m163initObserve$lambda19$lambda17(this.f$0, (AudioSource) obj);
            }
        });
        musicModel.getUriPath().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicFragment.m164initObserve$lambda19$lambda18(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-16, reason: not valid java name */
    public static final void m162initObserve$lambda16(MusicFragment musicFragment, List list) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "storageCount:" + musicFragment.storageCount + ", storagePaths:" + list.size());
        HiLog.INSTANCE.d(TAG, "musicAudio:" + musicFragment.musicAudio() + " ,first:" + musicFragment.first);
        Job job = musicFragment.storageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        musicFragment.storageJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(musicFragment), Dispatchers.getMain(), (CoroutineStart) null, new MusicFragment$initObserve$1$1(musicFragment, list, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-19$lambda-17, reason: not valid java name */
    public static final void m163initObserve$lambda19$lambda17(MusicFragment musicFragment, AudioSource audioSource) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "listFavoriteNotify:" + audioSource.getCom.syu.media.provider.Media.PATH java.lang.String() + " favorite:" + audioSource.getFavorite());
        if (Intrinsics.areEqual(musicFragment.playSong, audioSource)) {
            ((MusicFragmentBinding) musicFragment.getBinding()).musicFavorite.setChecked(audioSource.getFavorite());
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(musicFragment), Dispatchers.getIO(), (CoroutineStart) null, new MusicFragment$initObserve$2$1$1(audioSource, musicFragment, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-19$lambda-18, reason: not valid java name */
    public static final void m164initObserve$lambda19$lambda18(MusicFragment musicFragment, String str) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        DebounceHelper.debounce$default(DebounceHelper.INSTANCE, 0L, null, new MusicFragment$initObserve$2$2$1(musicFragment, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playFromUriPath(String uriPath) {
        PlayState playState;
        String str = uriPath;
        if (str.length() > 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = uriPath;
            if (StringsKt.contains$default(str, "/external", false, 2, (Object) null)) {
                objectRef.element = StringsKt.replace$default(uriPath, "/external", MediaApp.INSTANCE.getInternalPath(), false, 4, (Object) null);
            } else if (StringsKt.contains$default(str, "/root", false, 2, (Object) null)) {
                objectRef.element = StringsKt.replace$default(uriPath, "/root", FinalChip.BSP_PLATFORM_Null, false, 4, (Object) null);
            }
            HiLog.INSTANCE.d(TAG, "uriPath path:" + ((String) objectRef.element));
            File file = new File((String) objectRef.element);
            if (file.exists()) {
                HiLog.INSTANCE.d(TAG, "file.exists:" + ((String) objectRef.element));
                this.playOn = this.playing;
                MediaProxy audioProxy = getAudioProxy();
                if (audioProxy != null) {
                    audioProxy.setLastPlaying(false);
                }
                ConstraintList constraintList = new ConstraintList();
                constraintList.setFolder(file.getParent());
                this.constr = constraintList;
                MediaProxy audioProxy2 = getAudioProxy();
                if (audioProxy2 != null && (playState = audioProxy2.getPlayState()) != null) {
                    playState.setPlayPath((String) objectRef.element);
                    playState.setLastPlayTime(0);
                }
                HiLog.INSTANCE.d(TAG, "uriPath path parent:" + file.getParent());
                this.restoreJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(objectRef, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$playFromUriPath$3, reason: invalid class name */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$playFromUriPath$3", f = "MusicFragment.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $path;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$path = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = MusicFragment.this.new AnonymousClass3(this.$path, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                MediaProxy audioProxy = MusicFragment.this.getAudioProxy();
                if (audioProxy != null) {
                    ConstraintList constraintList = MusicFragment.this.constr;
                    Intrinsics.checkNotNull(constraintList);
                    MediaProxy.setupPlayList$default(audioProxy, constraintList, null, 2, null);
                }
                MusicFragment.this.getApp().getMediaFiles().InsertIfExist((String) this.$path.element);
                this.label = 1;
                if (FlowKt.collectLatest(MusicFragment.this.getMediaModel().getPlayListById(1), new AnonymousClass1(MusicFragment.this, this.$path, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$playFromUriPath$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "lists", "Lcom/syu/media/entities/PlayListWithAudios;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$playFromUriPath$3$1", f = "MusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PlayListWithAudios, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ Ref.ObjectRef<String> $path;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicFragment musicFragment, Ref.ObjectRef<String> objectRef, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicFragment;
                this.$path = objectRef;
                this.$$this$launch = coroutineScope;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$path, this.$$this$launch, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(PlayListWithAudios playListWithAudios, Continuation<? super Unit> continuation) {
                return create(playListWithAudios, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PlayListWithAudios playListWithAudios = (PlayListWithAudios) this.L$0;
                if (playListWithAudios != null) {
                    MusicFragment musicFragment = this.this$0;
                    Ref.ObjectRef<String> objectRef = this.$path;
                    CoroutineScope coroutineScope = this.$$this$launch;
                    HiLog.INSTANCE.d(MusicFragment.TAG, "playListById size:" + playListWithAudios.getAudios().size() + ", empty:" + playListWithAudios.isEmpty());
                    if (musicFragment.mAdapter.getItemCount() != 0 && musicFragment.containPath(playListWithAudios.getAudios(), (String) objectRef.element)) {
                        HiLog.INSTANCE.d(MusicFragment.TAG, "uriPath constraint:" + musicFragment.constr);
                        MediaPresenter mediaPresenter = musicFragment.mediaPresenter;
                        if (mediaPresenter != null) {
                            HiLog.INSTANCE.d(MusicFragment.TAG, "uriPath playWithPath:" + ((String) objectRef.element));
                            mediaPresenter.playWithPath((String) objectRef.element);
                        }
                        CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void unfoldTransform(boolean isUnfold) {
        HiLog.INSTANCE.d(TAG, "unfoldTransform isUnfold:" + isUnfold);
        if (isUnfold) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "percentWidth", 0.54f, 1.0f);
            objectAnimatorOfFloat.setDuration(100L);
            objectAnimatorOfFloat.start();
            ((MusicFragmentBinding) getBinding()).musicListUnfoldTransform.setEnabled(false);
            ((MusicFragmentBinding) getBinding()).musicListFoldTransform.setVisibility(0);
            ((MusicFragmentBinding) getBinding()).musicName.setGravity(1);
            ((MusicFragmentBinding) getBinding()).musicArtist.setGravity(1);
            ((MusicFragmentBinding) getBinding()).musicNameLeftMargin.setVisibility(0);
            ((MusicFragmentBinding) getBinding()).musicMainListContain.animate().alpha(0.0f).setDuration(100L).start();
            ((MusicFragmentBinding) getBinding()).musicListUnfoldTransform.animate().alpha(0.0f).setDuration(100L).start();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "percentWidth", 1.0f, 0.54f);
        objectAnimatorOfFloat2.setDuration(100L);
        objectAnimatorOfFloat2.start();
        ((MusicFragmentBinding) getBinding()).musicListUnfoldTransform.setEnabled(true);
        ((MusicFragmentBinding) getBinding()).musicListFoldTransform.setVisibility(8);
        ((MusicFragmentBinding) getBinding()).musicName.setGravity(GravityCompat.START);
        ((MusicFragmentBinding) getBinding()).musicArtist.setGravity(GravityCompat.START);
        ((MusicFragmentBinding) getBinding()).musicNameLeftMargin.setVisibility(8);
        ((MusicFragmentBinding) getBinding()).musicMainListContain.animate().alpha(1.0f).setDuration(100L).start();
        ((MusicFragmentBinding) getBinding()).musicListUnfoldTransform.animate().alpha(1.0f).setDuration(100L).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayModeChangedListener
    public void onChanged(PlayMode mode) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(mode, "mode");
        HiLog.INSTANCE.d(TAG, "onChanged mode:" + mode);
        int i3 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i3 == 1) {
            i = R.string.music_repeat_all;
            i2 = R.drawable.music_mode_loop_swi;
        } else if (i3 == 2) {
            i = R.string.music_repeat_track;
            i2 = R.drawable.music_mode_single_swi;
        } else if (i3 == 3) {
            i = R.string.music_repeat_random;
            i2 = R.drawable.music_mode_shuff_swi;
        } else {
            i = R.string.music_repeat_list;
            i2 = R.drawable.music_mode_list_swi;
        }
        int i4 = i;
        if (this.enablePlayMode) {
            MediaToast me = MediaToast.INSTANCE.getMe();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            MediaToast.makeText$default(me, contextRequireContext, i4, 0, 4, null);
            MediaProxy audioProxy = getAudioProxy();
            PlayState playState = audioProxy != null ? audioProxy.getPlayState() : null;
            if (playState != null) {
                playState.setPlayMode(mode.getValue());
            }
        }
        ((MusicFragmentBinding) getBinding()).musicMode.setImageResource(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayStateChangedListener
    public void onChanged(boolean isPlaying, MediaSource source) {
        HiLog.INSTANCE.d(TAG, "onChanged isPlaying:" + isPlaying);
        if (source != null) {
            this.playing = isPlaying;
            ((MusicFragmentBinding) getBinding()).musicName.setText(source.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
            if (isPlaying && source.getCom.syu.media.provider.Media.DURATION java.lang.String() > 0) {
                ((MusicFragmentBinding) getBinding()).musicPlaySeekbar.setMax(source.getCom.syu.media.provider.Media.DURATION java.lang.String());
                Job job = this.restoreJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                isNeedSeekTo();
            }
            if ((source.getCom.syu.media.provider.Media.PATH java.lang.String().length() > 0) && !Intrinsics.areEqual(source.getCom.syu.media.provider.Media.PATH java.lang.String(), "unknown")) {
                this.playSong = (AudioSource) source;
                ((MusicFragmentBinding) getBinding()).musicFavorite.setEnabled(true);
                ((MusicFragmentBinding) getBinding()).musicPlaySeekbar.setEnabled(true);
                MediaProxy audioProxy = getAudioProxy();
                if (audioProxy != null) {
                    audioProxy.getPlayState().setPlayPath(source.getCom.syu.media.provider.Media.PATH java.lang.String());
                    PlayState playState = audioProxy.getPlayState();
                    Integer id = source.getId();
                    Intrinsics.checkNotNull(id);
                    playState.setDataId(id.intValue());
                    audioProxy.getPlayState().setPlaying(isPlaying);
                }
                saveData(ConstantsKt.MUSIC_PLAY_PATH, source.getCom.syu.media.provider.Media.PATH java.lang.String());
            } else {
                ((MusicFragmentBinding) getBinding()).musicFavorite.setEnabled(false);
                ((MusicFragmentBinding) getBinding()).musicPlaySeekbar.setEnabled(false);
            }
            if (Intrinsics.areEqual(source.getCom.syu.media.provider.Media.ARTIST java.lang.String(), MediaFiles.INSTANCE.getUNKNOWN())) {
                ((MusicFragmentBinding) getBinding()).musicArtist.setText(getString(R.string.artist_unknown));
            } else {
                ((MusicFragmentBinding) getBinding()).musicArtist.setText(source.getCom.syu.media.provider.Media.ARTIST java.lang.String());
            }
            HiLog.INSTANCE.d(TAG, "onChanged songName:" + source.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
            ((MusicFragmentBinding) getBinding()).musicPlayerPlaypause.setImageResource(this.playing ? R.drawable.music_player_pause_swi : R.drawable.music_player_play_swi);
            int iPositionOf = this.mAdapter.getMData().positionOf(source);
            int iPositionOf2 = this.mAdapter.getMData().positionOf(this.lastSong);
            HiLog.INSTANCE.d(TAG, "onChanged selected:" + iPositionOf + "  ,priorSelected:" + iPositionOf2);
            if (iPositionOf != iPositionOf2) {
                if (iPositionOf2 >= 0) {
                    this.mAdapter.notifyItemChanged(iPositionOf2);
                }
                if (iPositionOf >= 0) {
                    this.mAdapter.notifyItemChanged(iPositionOf);
                    RecyclerView recyclerView = this.musicPlayListRecycler;
                    if (recyclerView != null) {
                        recyclerView.scrollToPosition(iPositionOf);
                    }
                    RecyclerView recyclerView2 = this.musicSpinListRecycler;
                    if (recyclerView2 != null) {
                        recyclerView2.scrollToPosition(iPositionOf);
                    }
                }
            } else {
                this.mAdapter.notifyItemChanged(iPositionOf);
            }
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MusicFragment$onChanged$1$2(this, source, isPlaying, null), 3, (Object) null);
        }
    }

    private final void isNeedSeekTo() {
        HiLog.INSTANCE.d(TAG, "isNeedSeekTo needSeek:" + this.needSeek);
        if (this.needSeek) {
            this.needSeek = false;
            MediaProxy audioProxy = getAudioProxy();
            if (audioProxy != null) {
                HiLog.INSTANCE.d(TAG, "isNeedSeekTo currentPlayTime:" + audioProxy.getPlayState().getCurrentPlayTime());
                HiLog.INSTANCE.d(TAG, "isNeedSeekTo lastPlayTime:" + audioProxy.getPlayState().getLastPlayTime());
                if (audioProxy.getPlayState().getCurrentPlayTime() <= audioProxy.getPlayState().getLastPlayTime()) {
                    audioProxy.getMPresenter().seekTo(audioProxy.getPlayState().getLastPlayTime());
                    PlayMode playModeModeOfValue = PlayMode.INSTANCE.modeOfValue(audioProxy.getPlayState().getPlayMode());
                    audioProxy.getMPresenter().postPlayMode(playModeModeOfValue);
                    HiLog.INSTANCE.d(TAG, "isNeedSeekTo mode:" + playModeModeOfValue);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayProgressChangedListener
    public void onChanged(int progress, int duration) {
        if (!this.isTouching && progress > 0) {
            ((MusicFragmentBinding) getBinding()).musicPlaySeekbar.setProgress(progress, false);
        }
        String string = getResources().getString(R.string.btmusic_play_time);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.btmusic_play_time)");
        String strMsecToMinutes = TimeUtils.INSTANCE.msecToMinutes(progress);
        CompasseTextView compasseTextView = ((MusicFragmentBinding) getBinding()).musicPlayTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{strMsecToMinutes}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        compasseTextView.setText(str);
        ((MusicFragmentBinding) getBinding()).musicTotalTime.setText(TimeUtils.INSTANCE.msecToMinutes(duration));
        MediaProxy audioProxy = getAudioProxy();
        PlayState playState = audioProxy != null ? audioProxy.getPlayState() : null;
        if (playState != null) {
            playState.setCurrentPlayTime(progress);
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(progress, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$onChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onChanged$2", f = "MusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progress = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicFragment.this.new AnonymousClass2(this.$progress, continuation);
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
            MusicFragment.this.saveData(ConstantsKt.LAST_PLAY_TIME, Boxing.boxInt(this.$progress));
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void moveTaskToBack() {
        if (musicAudio()) {
            openAppId(0);
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        HiLog.INSTANCE.d(TAG, "onResumed");
        if (!musicAudio()) {
            openAppId(8);
        }
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            audioProxy.addOnPlayListListener(this);
        }
        getMH().postDelayed(this.resumeHandler, 50L);
    }

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
        HiLog.INSTANCE.d(TAG, "onPaused");
        getMH().removeCallbacks(this.resumeHandler);
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            audioProxy.removeOnPlayListListener(this);
        }
    }

    @Override // com.syu.media.base.DataBindBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        HiLog.INSTANCE.d(TAG, "onDestroy");
        HiLog.INSTANCE.d(TAG, "onDestroy playOn:" + this.playOn);
        this.first = true;
        this.playOn = true;
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        Job job2 = this.blurJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = null;
        MediaPresenter mediaPresenter = this.mediaPresenter;
        if (mediaPresenter != null) {
            mediaPresenter.reset();
            mediaPresenter.unregisterOnPlayModeChangedListener(this);
            mediaPresenter.unregisterOnPlayStateChangedListener(this);
            mediaPresenter.unregisterOnPlayProgressChangedListener(this);
            mediaPresenter.unregisterOnConnectionStateChangeListener(this);
        }
        super.onDestroyView();
    }

    @Override // com.syu.media.MediaProxy.OnPlayListListener
    public void onChanged(List<? extends MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        HiLog.INSTANCE.d(TAG, "onChanged audiosCount:" + this.audiosCount + "  ,itemCount:" + this.mAdapter.getItemCount());
        updateList(list);
    }

    private final void updateList(List<? extends MediaSource> audios) {
        Job job = this.listJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.listJob = null;
        HiLog.INSTANCE.d(TAG, "updateList:" + audios.size());
        this.listJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00511(audios, this, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$updateList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$updateList$1", f = "MusicFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_IMAGE_CAPTURE}, m = "invokeSuspend", n = {}, s = {})
    static final class C00511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MediaSource> $audios;
        int label;
        final /* synthetic */ MusicFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00511(List<? extends MediaSource> list, MusicFragment musicFragment, Continuation<? super C00511> continuation) {
            super(2, continuation);
            this.$audios = list;
            this.this$0 = musicFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00511(this.$audios, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listCreateNodes = Node.Companion.createNodes(this.$audios, MainListItem.class, this.this$0.mAdapter.getMData());
                List listCreateNodes2 = Node.Companion.createNodes(this.$audios, SpinItem.class, this.this$0.mSpinAdapter.getMData());
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.this$0.lastData, listCreateNodes), false);
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, newData), false)");
                DiffUtil.DiffResult diffResultCalculateDiff2 = DiffUtil.calculateDiff(new DiffCallBack(this.this$0.spinData, listCreateNodes2), false);
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff2, "calculateDiff(DiffCallBa…ata, newSpinData), false)");
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00151(this.this$0, listCreateNodes, diffResultCalculateDiff, listCreateNodes2, diffResultCalculateDiff2, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$updateList$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MusicFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$updateList$1$1", f = "MusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Node<?>> $newData;
            final /* synthetic */ List<Node<?>> $newSpinData;
            final /* synthetic */ DiffUtil.DiffResult $result;
            final /* synthetic */ DiffUtil.DiffResult $spinResult;
            int label;
            final /* synthetic */ MusicFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(MusicFragment musicFragment, List<Node<?>> list, DiffUtil.DiffResult diffResult, List<Node<?>> list2, DiffUtil.DiffResult diffResult2, Continuation<? super C00151> continuation) {
                super(2, continuation);
                this.this$0 = musicFragment;
                this.$newData = list;
                this.$result = diffResult;
                this.$newSpinData = list2;
                this.$spinResult = diffResult2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00151(this.this$0, this.$newData, this.$result, this.$newSpinData, this.$spinResult, continuation);
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
                this.this$0.lastData = this.$newData;
                this.this$0.mAdapter.replaceWithoutNotify(this.this$0.lastData);
                this.$result.dispatchUpdatesTo((RecyclerView.Adapter) this.this$0.mAdapter);
                MusicFragment musicFragment = this.this$0;
                musicFragment.ifListEmpty(musicFragment.lastData.size());
                this.this$0.spinData = this.$newSpinData;
                this.this$0.mSpinAdapter.replaceWithoutNotify(this.this$0.spinData);
                this.$spinResult.dispatchUpdatesTo((RecyclerView.Adapter) this.this$0.mSpinAdapter);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.syu.media.service.MediaPresenter.OnConnectionStateChangeListener
    public void onConnectionStateChanged(boolean connected) {
        HiLog.INSTANCE.d(TAG, "onConnectionStateChanged:" + connected);
        if (!connected || this.isCreate) {
            return;
        }
        this.isCreate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ifListEmpty(int count) {
        HiLog.INSTANCE.d(MusicMainFragment.TAG, "ifListEmpty count:" + count);
        this.audiosCount = count;
        getMH().removeCallbacks(this.listEmptyRunnable);
        getMH().postDelayed(this.listEmptyRunnable, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: listEmptyRunnable$lambda-28, reason: not valid java name */
    public static final void m170listEmptyRunnable$lambda28(MusicFragment musicFragment) {
        Intrinsics.checkNotNullParameter(musicFragment, "this$0");
        ConstraintLayout constraintLayout = ((MusicFragmentBinding) musicFragment.getBinding()).musicMainListEmpty;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(musicFragment.audiosCount == 0 ? 0 : 8);
        }
        CardView cardView = ((MusicFragmentBinding) musicFragment.getBinding()).musicAudioEmptyAlbum;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(musicFragment.audiosCount != 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRestorePlay(List<String> storagePaths) {
        HiLog.INSTANCE.d(TAG, "restore playOn:" + this.playOn);
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            HiLog.INSTANCE.d(TAG, "restore playPath:" + this.playPath + ", playStatePath:" + audioProxy.getPlayState().getPlayPath());
            HiLog.INSTANCE.d(TAG, "restore storagePaths:" + storagePaths);
            boolean zStartsWith = startsWith(storagePaths, this.playPath);
            HiLog.INSTANCE.d(TAG, "restore isStartWith:" + zStartsWith);
            if (zStartsWith && !this.playing && this.playOn && Intrinsics.areEqual(this.playPath, audioProxy.getPlayState().getPlayPath())) {
                File file = new File(this.playPath);
                HiLog.INSTANCE.d(TAG, "file.exists():" + file.exists());
                if (file.exists()) {
                    getMH().removeCallbacks(this.retryHandler);
                    this.restoreJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MusicFragment$onRestorePlay$1$1(audioProxy, this, storagePaths, null), 3, (Object) null);
                } else if (this.retryCount <= 10) {
                    HiLog.INSTANCE.d(TAG, "restore retryCount:" + this.retryCount);
                    this.retryCount++;
                    getMH().removeCallbacks(this.retryHandler);
                    getMH().postDelayed(this.retryHandler, 500L);
                }
            } else if (!zStartsWith && this.playing) {
                HiLog.INSTANCE.d(TAG, "restore playing:" + this.playing);
                this.playPath = audioProxy.getPlayState().getPlayPath();
                this.playOn = this.playing;
            }
            this.drivePaths = CollectionsKt.toMutableList(storagePaths);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean startsWith(List<String> datas, String comparseStr) {
        int size = datas.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.startsWith$default(comparseStr, datas.get(i), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containPath(List<AudioSource> audios, String path) {
        int size = audios.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(audios.get(i).getCom.syu.media.provider.Media.PATH java.lang.String(), path)) {
                return true;
            }
        }
        return false;
    }
}
