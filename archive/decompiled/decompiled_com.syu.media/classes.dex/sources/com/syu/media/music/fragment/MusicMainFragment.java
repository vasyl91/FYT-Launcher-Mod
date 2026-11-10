package com.syu.media.music.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.BaseMediaApp;
import com.syu.media.ConstantsKt;
import com.syu.media.Constraint;
import com.syu.media.ConstraintList;
import com.syu.media.ListCondition01;
import com.syu.media.MainAct;
import com.syu.media.MediaFiles;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.TimeUtils;
import com.syu.media.companion.view.CircleImageView;
import com.syu.media.databinding.MusicMainFragmentBinding;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.music.MusicService;
import com.syu.media.music.diff.DiffCallBack;
import com.syu.media.music.items.AlbumItem;
import com.syu.media.music.items.ArtistItem;
import com.syu.media.music.items.AudioItem;
import com.syu.media.music.items.ConstraintAlbum;
import com.syu.media.music.items.ConstraintArtist;
import com.syu.media.music.items.ConstraintFolder;
import com.syu.media.music.items.FolderItem;
import com.syu.media.music.widget.items.XGridLayoutManager;
import com.syu.media.provider.Media;
import com.syu.media.service.MediaPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.regex.Pattern;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: MusicMainFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001{B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010G\u001a\u00020HH\u0002J \u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020,H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010\u00142\u0006\u0010L\u001a\u00020\u0014H\u0002J\u0010\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020,H\u0002J\b\u0010Q\u001a\u00020HH\u0016J\b\u0010R\u001a\u00020HH\u0016J\u0010\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020UH\u0016J\u0018\u0010V\u001a\u00020H2\u0006\u0010K\u001a\u00020,2\u0006\u0010W\u001a\u00020,H\u0002J\u001a\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010X\u001a\u00020H2\u0006\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020,H\u0016J\b\u0010^\u001a\u00020HH\u0016J\b\u0010_\u001a\u00020HH\u0016J\b\u0010`\u001a\u00020HH\u0016J\u0018\u0010a\u001a\u00020H2\u0006\u0010b\u001a\u00020Z2\u0006\u0010c\u001a\u00020\u0014H\u0016J\u000e\u0010d\u001a\u00020H2\u0006\u0010e\u001a\u00020\u001aJ\u0010\u0010f\u001a\u00020H2\u0006\u0010W\u001a\u00020,H\u0002J\u0010\u0010g\u001a\u00020H2\u0006\u0010W\u001a\u00020,H\u0002J\u0010\u0010h\u001a\u00020H2\u0006\u0010W\u001a\u00020,H\u0002J\u0018\u0010i\u001a\u00020H2\u0006\u0010W\u001a\u00020,2\u0006\u0010j\u001a\u00020\u0014H\u0002J\u0018\u0010k\u001a\u00020H2\u0006\u0010K\u001a\u00020,2\u0006\u0010W\u001a\u00020,H\u0002J\u0018\u0010l\u001a\u00020H2\u0006\u0010K\u001a\u00020,2\u0006\u0010W\u001a\u00020,H\u0002J\u001f\u0010m\u001a\u00020H2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020#0oH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010pJW\u0010m\u001a\u00020H\"\n\b\u0000\u0010q\u0018\u0001*\u00020r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00140o2\u0014\u0010t\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002Hq0!0u2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010v\u001a\u00020,H\u0082Hø\u0001\u0000¢\u0006\u0002\u0010wJ$\u0010x\u001a\u00020H2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00140o2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00140oH\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\n\"\u0004\b7\u0010\fR#\u00108\u001a\n :*\u0004\u0018\u000109098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010<R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R#\u0010D\u001a\n :*\u0004\u0018\u000109098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0018\u001a\u0004\bE\u0010<\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006|"}, d2 = {"Lcom/syu/media/music/fragment/MusicMainFragment;", "Lcom/syu/media/music/fragment/MediaBaseFragment;", "Lcom/syu/media/databinding/MusicMainFragmentBinding;", "Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", "Lcom/syu/media/service/MediaPresenter$OnPlayProgressChangedListener;", "Lcom/syu/media/BaseMediaApp$OnScanStateListener;", "()V", "albumView", "Landroid/widget/ImageView;", "getAlbumView", "()Landroid/widget/ImageView;", "setAlbumView", "(Landroid/widget/ImageView;)V", "artistView", "Landroid/widget/TextView;", "getArtistView", "()Landroid/widget/TextView;", "setArtistView", "(Landroid/widget/TextView;)V", "bias", FinalChip.BSP_PLATFORM_Null, "getBias", "()Ljava/lang/String;", "bias$delegate", "Lkotlin/Lazy;", "bk", "Landroid/graphics/drawable/Drawable;", "browserList", "Landroidx/recyclerview/widget/RecyclerView;", "job", "Lkotlinx/coroutines/Job;", "lastData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "lastSong", "Lcom/syu/media/entities/MediaSource;", "listJob", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "getMAdapter", "()Lsyu/recyclerview/NodeAdapter;", "setMAdapter", "(Lsyu/recyclerview/NodeAdapter;)V", "mListFlag", FinalChip.BSP_PLATFORM_Null, "getMListFlag", "()I", "setMListFlag", "(I)V", "mediaPresenter", "Lcom/syu/media/service/MediaPresenter;", "playStateHandler", "Ljava/lang/Runnable;", "playView", "getPlayView", "setPlayView", "sdcardRegex", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getSdcardRegex", "()Ljava/util/regex/Pattern;", "sdcardRegex$delegate", "storageInfos", "storageSdCards", "storageUsbs", "titleView", "getTitleView", "setTitleView", "usbRegex", "getUsbRegex", "usbRegex$delegate", "backPressed", FinalChip.BSP_PLATFORM_Null, "createRadioButton", "Landroid/widget/RadioButton;", "condition01", Media.PATH, "index", "getTitleFormPath", "ifListEmpty", "count", "initData", "initObserve", "initView", "view", "Landroid/view/View;", "notifyNodeAdapter", "condition02", "onChanged", "isPlaying", FinalChip.BSP_PLATFORM_Null, "source", NotificationCompat.CATEGORY_PROGRESS, Media.DURATION, "onDestroy", "onPaused", "onResumed", "onScanStateChanged", "scanning", "rootFolder", "setBlurBk", "d", "setupNodeAdapterWithAll", "setupNodeAdapterWithFavorite", "setupNodeAdapterWithHost", "setupNodeAdapterWithPath", "filter", "setupNodeAdapterWithSDCard", "setupNodeAdapterWithUsb", "updateList", "audios", FinalChip.BSP_PLATFORM_Null, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "tags", "clazz", "Ljava/lang/Class;", "favorite", "(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStorageGroup", "removed", "added", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicMainFragment extends MediaBaseFragment<MusicMainFragmentBinding> implements MediaPresenter.OnPlayStateChangedListener, MediaPresenter.OnPlayProgressChangedListener, BaseMediaApp.OnScanStateListener {
    public static final String TAG = "MusicMainFragment";
    private ImageView albumView;
    private TextView artistView;

    /* JADX INFO: renamed from: bias$delegate, reason: from kotlin metadata */
    private final Lazy bias;
    private Drawable bk;
    private RecyclerView browserList;
    private Job job;
    private List<Node<?>> lastData;
    private MediaSource lastSong;
    private Job listJob;
    private NodeAdapter mAdapter;
    private int mListFlag;
    private MediaPresenter mediaPresenter;
    private final Runnable playStateHandler;
    private ImageView playView;

    /* JADX INFO: renamed from: sdcardRegex$delegate, reason: from kotlin metadata */
    private final Lazy sdcardRegex;
    private final List<String> storageInfos;
    private final List<String> storageSdCards;
    private final List<String> storageUsbs;
    private TextView titleView;

    /* JADX INFO: renamed from: usbRegex$delegate, reason: from kotlin metadata */
    private final Lazy usbRegex;

    public MusicMainFragment() {
        super(R.layout.music_main_fragment);
        this.usbRegex = LazyKt.lazy(new Function0<Pattern>() { // from class: com.syu.media.music.fragment.MusicMainFragment$usbRegex$2
            public final Pattern invoke() {
                return Pattern.compile("(USB\\d+)$");
            }
        });
        this.sdcardRegex = LazyKt.lazy(new Function0<Pattern>() { // from class: com.syu.media.music.fragment.MusicMainFragment$sdcardRegex$2
            public final Pattern invoke() {
                return Pattern.compile("(SD\\d+)$");
            }
        });
        this.bias = LazyKt.lazy(new Function0<String>() { // from class: com.syu.media.music.fragment.MusicMainFragment$bias$2
            public final String invoke() {
                return "/";
            }
        });
        this.storageInfos = new ArrayList();
        this.storageUsbs = new ArrayList();
        this.storageSdCards = new ArrayList();
        this.lastData = new ArrayList();
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mListFlag = -1;
        this.lastSong = new MediaSource();
        this.playStateHandler = new Runnable() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MusicMainFragment.m183playStateHandler$lambda0(this.f$0);
            }
        };
    }

    public final ImageView getPlayView() {
        return this.playView;
    }

    public final void setPlayView(ImageView imageView) {
        this.playView = imageView;
    }

    public final ImageView getAlbumView() {
        return this.albumView;
    }

    public final void setAlbumView(ImageView imageView) {
        this.albumView = imageView;
    }

    public final TextView getTitleView() {
        return this.titleView;
    }

    public final void setTitleView(TextView textView) {
        this.titleView = textView;
    }

    public final TextView getArtistView() {
        return this.artistView;
    }

    public final void setArtistView(TextView textView) {
        this.artistView = textView;
    }

    private final Pattern getUsbRegex() {
        return (Pattern) this.usbRegex.getValue();
    }

    private final Pattern getSdcardRegex() {
        return (Pattern) this.sdcardRegex.getValue();
    }

    private final String getBias() {
        return (String) this.bias.getValue();
    }

    public final NodeAdapter getMAdapter() {
        return this.mAdapter;
    }

    public final void setMAdapter(NodeAdapter nodeAdapter) {
        Intrinsics.checkNotNullParameter(nodeAdapter, "<set-?>");
        this.mAdapter = nodeAdapter;
    }

    public final int getMListFlag() {
        return this.mListFlag;
    }

    public final void setMListFlag(int i) {
        this.mListFlag = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: playStateHandler$lambda-0, reason: not valid java name */
    public static final void m183playStateHandler$lambda0(MusicMainFragment musicMainFragment) {
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        musicMainFragment.getApp().addOnScanStateListener(musicMainFragment);
        MediaPresenter mediaPresenter = musicMainFragment.mediaPresenter;
        if (mediaPresenter != null) {
            mediaPresenter.registerOnPlayStateChangedListener(musicMainFragment);
        }
        MediaPresenter mediaPresenter2 = musicMainFragment.mediaPresenter;
        if (mediaPresenter2 != null) {
            mediaPresenter2.registerOnPlayProgressChangedListener(musicMainFragment);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        MediaSource playingSource;
        MediaPresenter mPresenter;
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable drawable = this.bk;
        if (drawable != null) {
            setBlurBk(drawable);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.browser_list);
        this.browserList = recyclerView;
        boolean z = false;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new XGridLayoutManager(requireContext(), 4));
            recyclerView.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) recyclerView.getResources().getDimension(R.dimen.music_main_item_space)), null, null, null, null, 30, null));
            recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            }
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            recyclerView.setTag(this);
        }
        ImageView imageView = ((MusicMainFragmentBinding) getBinding()).musicCtrPlay;
        this.playView = imageView;
        if (imageView != null) {
            imageView.setTransitionName("play");
        }
        this.titleView = ((MusicMainFragmentBinding) getBinding()).musicCtrTitle;
        this.artistView = ((MusicMainFragmentBinding) getBinding()).musicCtrArtist;
        CircleImageView circleImageView = ((MusicMainFragmentBinding) getBinding()).musicCtrAlbum;
        this.albumView = circleImageView;
        if (circleImageView != null) {
            circleImageView.setTransitionName("cover");
        }
        RecyclerView recyclerView2 = this.browserList;
        if (recyclerView2 != null) {
            recyclerView2.setTransitionName(Media.LIST_TABLE);
        }
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null && (playingSource = audioProxy.getPlayingSource()) != null) {
            TextView textView = this.titleView;
            if (textView != null) {
                textView.setText(playingSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
            }
            TextView textView2 = this.artistView;
            if (textView2 != null) {
                textView2.setText(playingSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
            }
            ImageView imageView2 = this.playView;
            if (imageView2 != null) {
                MediaProxy audioProxy2 = getAudioProxy();
                if (audioProxy2 != null && (mPresenter = audioProxy2.getMPresenter()) != null && mPresenter.getIsPlaying()) {
                    z = true;
                }
                imageView2.setImageResource(!z ? R.drawable.music_player_play_swi : R.drawable.music_player_pause_swi);
            }
            Bitmap bitmap = getApp().getIconCache().get(playingSource.getCom.syu.media.provider.Media.PATH java.lang.String());
            if (bitmap != null) {
                ImageView imageView3 = this.albumView;
                if (imageView3 != null) {
                    imageView3.setImageBitmap(bitmap);
                }
            } else {
                ImageView imageView4 = this.albumView;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.album1);
                }
            }
        }
        getMusicModel().getMusicFavorite().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicMainFragment.m180initView$lambda4(this.f$0, (AudioSource) obj);
            }
        });
        ((MusicMainFragmentBinding) getBinding()).fragmentContainerView2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MusicMainFragment.m181initView$lambda5(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-4, reason: not valid java name */
    public static final void m180initView$lambda4(MusicMainFragment musicMainFragment, AudioSource audioSource) {
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(musicMainFragment), Dispatchers.getIO(), (CoroutineStart) null, new MusicMainFragment$initView$4$1(audioSource, musicMainFragment, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-5, reason: not valid java name */
    public static final void m181initView$lambda5(MusicMainFragment musicMainFragment, View view) {
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        musicMainFragment.backPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initData() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String name = MusicService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MusicService::class.java.name");
        ImageView imageView = ((MusicMainFragmentBinding) getBinding()).musicCtrPlay;
        ImageView imageView2 = ((MusicMainFragmentBinding) getBinding()).musicCtrNext;
        imageView2.setTransitionName("next");
        Unit unit = Unit.INSTANCE;
        ImageView imageView3 = imageView2;
        ImageView imageView4 = ((MusicMainFragmentBinding) getBinding()).musicCtrPrev;
        imageView4.setTransitionName("prev");
        Unit unit2 = Unit.INSTANCE;
        this.mediaPresenter = new MediaPresenter(contextRequireContext, name, imageView, imageView3, imageView4);
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        HiLog.INSTANCE.d(TAG, "initObserve");
        this.storageUsbs.clear();
        this.storageSdCards.clear();
        this.storageInfos.clear();
        getMediaModel().getStorageDevices().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicMainFragment.m174initObserve$lambda12(this.f$0, (List) obj);
            }
        });
        if (getAudioProxy() == null) {
            HiLog.INSTANCE.d(TAG, "audioProxy is null");
        }
        final MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            getMH().postDelayed(new Runnable() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    MusicMainFragment.m175initObserve$lambda18$lambda15(audioProxy, this);
                }
            }, 500L);
            audioProxy.getListCondition01().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MusicMainFragment.m178initObserve$lambda18$lambda16(audioProxy, this, (Integer) obj);
                }
            });
            audioProxy.getListCondition02().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MusicMainFragment.m179initObserve$lambda18$lambda17(audioProxy, this, (Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12, reason: not valid java name */
    public static final void m174initObserve$lambda12(MusicMainFragment musicMainFragment, List list) {
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(list, "storagePaths");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!musicMainFragment.storageInfos.contains(str)) {
                arrayList.add(str);
                String str2 = str;
                if (musicMainFragment.getUsbRegex().matcher(str2).find()) {
                    if (!musicMainFragment.storageUsbs.contains(str)) {
                        musicMainFragment.storageUsbs.add(str);
                    }
                } else if (musicMainFragment.getSdcardRegex().matcher(str2).find() && !musicMainFragment.storageSdCards.contains(str)) {
                    musicMainFragment.storageSdCards.add(str);
                }
            }
        }
        for (String str3 : musicMainFragment.storageInfos) {
            if (!list.contains(str3)) {
                arrayList2.add(str3);
                String str4 = str3;
                if (musicMainFragment.getUsbRegex().matcher(str4).find()) {
                    if (musicMainFragment.storageUsbs.contains(str3)) {
                        musicMainFragment.storageUsbs.remove(str3);
                    }
                } else if (musicMainFragment.getSdcardRegex().matcher(str4).find() && musicMainFragment.storageSdCards.contains(str3)) {
                    musicMainFragment.storageSdCards.remove(str3);
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            musicMainFragment.storageInfos.remove((String) it2.next());
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            musicMainFragment.storageInfos.add((String) it3.next());
        }
        musicMainFragment.updateStorageGroup(arrayList2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-15, reason: not valid java name */
    public static final void m175initObserve$lambda18$lambda15(MediaProxy mediaProxy, final MusicMainFragment musicMainFragment) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(mediaProxy, "$proxy");
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        Integer value = mediaProxy.getListCondition01().getValue();
        Integer num = 0;
        if (value == null) {
            value = num;
        }
        int iIntValue = value.intValue();
        Integer value2 = mediaProxy.getListCondition02().getValue();
        int iIntValue2 = (value2 != null ? value2 : 0).intValue();
        if (iIntValue == 64) {
            i = R.id.music_storage_favorite;
        } else if (iIntValue == 128) {
            i = R.id.music_storage_host;
        } else {
            int i3 = iIntValue & 448;
            i = (i3 == 192 || i3 == 256) ? iIntValue : R.id.music_storage_all;
        }
        ((MusicMainFragmentBinding) musicMainFragment.getBinding()).musicStorageGroup.check(i);
        HiLog.INSTANCE.d(TAG, "01 " + (iIntValue & 448) + "  condition01: " + iIntValue + " storage: " + i + "  " + musicMainFragment.requireView().findViewById(i));
        RadioGroup radioGroup = ((MusicMainFragmentBinding) musicMainFragment.getBinding()).musicListStyleGroup;
        if (iIntValue2 == 1) {
            i2 = R.id.music_list_style_album;
        } else if (iIntValue2 == 2) {
            i2 = R.id.music_list_style_artist;
        } else if (iIntValue2 == 3) {
            i2 = R.id.music_list_style_folder;
        } else {
            i2 = R.id.music_list_style_track;
        }
        radioGroup.check(i2);
        ((MusicMainFragmentBinding) musicMainFragment.getBinding()).musicStorageGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i4) {
                MusicMainFragment.m176initObserve$lambda18$lambda15$lambda13(this.f$0, radioGroup2, i4);
            }
        });
        ((MusicMainFragmentBinding) musicMainFragment.getBinding()).musicListStyleGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda9
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i4) {
                MusicMainFragment.m177initObserve$lambda18$lambda15$lambda14(this.f$0, radioGroup2, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-15$lambda-13, reason: not valid java name */
    public static final void m176initObserve$lambda18$lambda15$lambda13(MusicMainFragment musicMainFragment, RadioGroup radioGroup, int i) {
        MutableLiveData<Integer> listCondition01;
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        RecyclerView recyclerView = musicMainFragment.browserList;
        if (recyclerView != null) {
            recyclerView.stopScroll();
        }
        MediaProxy audioProxy = musicMainFragment.getAudioProxy();
        if (audioProxy == null || (listCondition01 = audioProxy.getListCondition01()) == null) {
            return;
        }
        if (i == R.id.music_storage_all) {
            i = 0;
        } else if (i == R.id.music_storage_favorite) {
            i = 64;
        } else if (i == R.id.music_storage_host) {
            i = 128;
        }
        listCondition01.postValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-15$lambda-14, reason: not valid java name */
    public static final void m177initObserve$lambda18$lambda15$lambda14(MusicMainFragment musicMainFragment, RadioGroup radioGroup, int i) {
        MutableLiveData<Integer> listCondition02;
        int i2;
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        RecyclerView recyclerView = musicMainFragment.browserList;
        if (recyclerView != null) {
            recyclerView.stopScroll();
        }
        MediaProxy audioProxy = musicMainFragment.getAudioProxy();
        if (audioProxy == null || (listCondition02 = audioProxy.getListCondition02()) == null) {
            return;
        }
        if (i == R.id.music_list_style_album) {
            i2 = 1;
        } else if (i == R.id.music_list_style_artist) {
            i2 = 2;
        } else {
            i2 = i == R.id.music_list_style_folder ? 3 : 0;
        }
        listCondition02.postValue(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-16, reason: not valid java name */
    public static final void m178initObserve$lambda18$lambda16(MediaProxy mediaProxy, MusicMainFragment musicMainFragment, Integer num) {
        Intrinsics.checkNotNullParameter(mediaProxy, "$proxy");
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        Integer value = mediaProxy.getListCondition02().getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        int iIntValue2 = (num.intValue() << 3) | iIntValue;
        if (iIntValue2 != musicMainFragment.mListFlag) {
            musicMainFragment.mListFlag = iIntValue2;
            Intrinsics.checkNotNullExpressionValue(num, "condition");
            musicMainFragment.notifyNodeAdapter(num.intValue(), iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-17, reason: not valid java name */
    public static final void m179initObserve$lambda18$lambda17(MediaProxy mediaProxy, MusicMainFragment musicMainFragment, Integer num) {
        Intrinsics.checkNotNullParameter(mediaProxy, "$proxy");
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        Integer value = mediaProxy.getListCondition01().getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        Intrinsics.checkNotNullExpressionValue(num, "condition");
        int iIntValue2 = (iIntValue << 3) | num.intValue();
        if (iIntValue2 != musicMainFragment.mListFlag) {
            musicMainFragment.mListFlag = iIntValue2;
            musicMainFragment.notifyNodeAdapter(iIntValue, num.intValue());
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        HiLog.INSTANCE.d(TAG, "onResumed");
        getMH().postDelayed(this.playStateHandler, 350L);
        int iPositionOf = this.mAdapter.getMData().positionOf(this.lastSong);
        RecyclerView recyclerView = this.browserList;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(iPositionOf);
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
        HiLog.INSTANCE.d(TAG, "onPaused");
        getMH().removeCallbacks(this.playStateHandler);
        getApp().removeOnScanStateListener(this);
        MediaPresenter mediaPresenter = this.mediaPresenter;
        if (mediaPresenter != null) {
            mediaPresenter.unregisterOnPlayStateChangedListener(this);
        }
        MediaPresenter mediaPresenter2 = this.mediaPresenter;
        if (mediaPresenter2 != null) {
            mediaPresenter2.unregisterOnPlayProgressChangedListener(this);
        }
    }

    @Override // com.syu.media.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HiLog.INSTANCE.d(TAG, "onDestroy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayStateChangedListener
    public void onChanged(boolean isPlaying, MediaSource source) {
        HiLog.INSTANCE.d(TAG, "onChanged isPlaying: " + isPlaying);
        if (isAdded() && source != null) {
            ((MusicMainFragmentBinding) getBinding()).musicListPlayProgressbar.setMax(source.getCom.syu.media.provider.Media.DURATION java.lang.String());
            TextView textView = this.titleView;
            if (textView != null) {
                textView.setText(source.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
            }
            ImageView imageView = this.playView;
            if (imageView != null) {
                imageView.setImageResource(isPlaying ? R.drawable.music_player_pause_swi : R.drawable.music_player_play_swi);
            }
            if (Intrinsics.areEqual(source.getCom.syu.media.provider.Media.ARTIST java.lang.String(), MediaFiles.INSTANCE.getUNKNOWN())) {
                TextView textView2 = this.artistView;
                if (textView2 != null) {
                    textView2.setText(getString(R.string.artist_unknown));
                }
            } else {
                TextView textView3 = this.artistView;
                if (textView3 != null) {
                    textView3.setText(source.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
            }
            int iPositionOf = this.mAdapter.getMData().positionOf(source);
            int iPositionOf2 = this.mAdapter.getMData().positionOf(this.lastSong);
            HiLog.INSTANCE.d(TAG, "selected: " + iPositionOf + " ,lastPosition:" + iPositionOf2);
            if (iPositionOf != iPositionOf2) {
                if (iPositionOf2 >= 0) {
                    this.mAdapter.notifyItemChanged(iPositionOf2);
                }
                if (iPositionOf >= 0) {
                    this.mAdapter.notifyItemChanged(iPositionOf);
                    RecyclerView recyclerView = this.browserList;
                    if (recyclerView != null) {
                        recyclerView.scrollToPosition(iPositionOf);
                    }
                }
            } else {
                this.mAdapter.notifyItemChanged(iPositionOf);
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MusicMainFragment$onChanged$1$1(this, source, isPlaying, null), 3, (Object) null);
        }
    }

    public final void setBlurBk(Drawable d) {
        Intrinsics.checkNotNullParameter(d, "d");
        if (isAdded()) {
            bkChanged(R.id.music_main_frag_blur_img, d);
        } else {
            this.bk = d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayProgressChangedListener
    public void onChanged(int progress, int duration) {
        if (progress < 0) {
            return;
        }
        ((MusicMainFragmentBinding) getBinding()).musicListPlayProgressbar.setProgress(progress);
        ((MusicMainFragmentBinding) getBinding()).musicListTotalTime.setText(getBias() + TimeUtils.INSTANCE.msecToMinutes(duration));
        ((MusicMainFragmentBinding) getBinding()).musicListPlayTime.setText(TimeUtils.INSTANCE.msecToMinutes(progress));
    }

    private final void backPressed() {
        HiLog.INSTANCE.d(TAG, "backPressed");
        onStartPage(ConstantsKt.ACTION_PAGE_MUSIC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateStorageGroup(List<String> removed, List<String> added) {
        RadioButton radioButtonCreateRadioButton;
        ArrayList<RadioButton> arrayList = new ArrayList();
        RadioGroup radioGroup = ((MusicMainFragmentBinding) getBinding()).musicStorageGroup;
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = radioGroup.getChildAt(i);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioButton");
            }
            arrayList.add((RadioButton) childAt);
        }
        for (RadioButton radioButton : arrayList) {
            if (CollectionsKt.contains(removed, radioButton.getTag())) {
                RadioGroup radioGroup2 = ((MusicMainFragmentBinding) getBinding()).musicStorageGroup;
                radioGroup2.removeView(radioButton);
                if (radioButton.getId() == radioGroup2.getCheckedRadioButtonId()) {
                    ((MusicMainFragmentBinding) getBinding()).musicStorageGroup.check(R.id.music_storage_all);
                    ((MusicMainFragmentBinding) getBinding()).musicListStyleGroup.check(R.id.music_list_style_track);
                }
            }
        }
        for (String str : added) {
            if (this.storageUsbs.contains(str)) {
                String strReplaceAll = Pattern.compile("[^0-9]").matcher(str).replaceAll(",");
                Intrinsics.checkNotNullExpressionValue(strReplaceAll, "compile(\"[^0-9]\").matcher(it).replaceAll(\",\")");
                String string = StringsKt.trim(strReplaceAll).toString();
                Log.e(TAG, "------- " + string);
                Integer numValueOf = Integer.valueOf((String) CollectionsKt.last(StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null)));
                Intrinsics.checkNotNullExpressionValue(numValueOf, "index");
                radioButtonCreateRadioButton = createRadioButton(ListCondition01.USB, str, numValueOf.intValue());
            } else if (this.storageSdCards.contains(str)) {
                String strReplaceAll2 = Pattern.compile("[^0-9]").matcher(str).replaceAll(",");
                Intrinsics.checkNotNullExpressionValue(strReplaceAll2, "compile(\"[^0-9]\").matcher(it).replaceAll(\",\")");
                Integer numValueOf2 = Integer.valueOf((String) CollectionsKt.last(StringsKt.split$default(StringsKt.trim(strReplaceAll2).toString(), new String[]{","}, false, 0, 6, (Object) null)));
                Intrinsics.checkNotNullExpressionValue(numValueOf2, "index");
                radioButtonCreateRadioButton = createRadioButton(256, str, numValueOf2.intValue());
            } else {
                radioButtonCreateRadioButton = null;
            }
            if (radioButtonCreateRadioButton != null) {
                radioGroup.addView(radioButtonCreateRadioButton, new RadioGroup.LayoutParams(-2, -2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RadioButton createRadioButton(int condition01, String path, int index) {
        RadioButton radioButton = new RadioButton(requireContext());
        radioButton.setTextColor(requireContext().getColor(R.color.music_content_label_color));
        radioButton.setGravity(1);
        radioButton.setClickable(true);
        radioButton.setButtonDrawable((Drawable) null);
        radioButton.setBackground(null);
        radioButton.setId(index | condition01);
        String string = ((MusicMainFragmentBinding) getBinding()).musicStorageAll.getText().toString();
        if (string.length() > 0) {
            string = getTitleFormPath(path);
        }
        radioButton.setText(string);
        radioButton.setTag(path);
        radioButton.setTextSize(0, radioButton.getResources().getDimension(R.dimen.music_artist_text_size));
        if (condition01 == 192) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.music_list_menu_usb_swi, 0, 0);
        } else if (condition01 == 256) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.music_list_menu_sdcard_swi, 0, 0);
        }
        return radioButton;
    }

    private final void notifyNodeAdapter(int condition01, int condition02) {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.mAdapter.getMData().clear();
        HiLog hiLog = HiLog.INSTANCE;
        StringBuilder sbAppend = new StringBuilder("listCondition02 -------------- condition01:").append(condition01).append(" condition02: ").append(condition02).append("   flag : ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(condition01 & 63)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        hiLog.d(TAG, sbAppend.append(str).toString());
        int i = condition01 & 448;
        if (i == 0) {
            setupNodeAdapterWithAll(condition02);
            return;
        }
        if (i == 64) {
            setupNodeAdapterWithFavorite(condition02);
            return;
        }
        if (i == 128) {
            setupNodeAdapterWithHost(condition02);
        } else if (i == 192) {
            setupNodeAdapterWithUsb(condition01, condition02);
        } else {
            if (i != 256) {
                return;
            }
            setupNodeAdapterWithSDCard(condition01, condition02);
        }
    }

    private final void setupNodeAdapterWithAll(int condition02) {
        Log.e(TAG, "setupNodeAdapterWithAll -------------- condition02: " + condition02 + "  ");
        if (condition02 == 0) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
            return;
        }
        if (condition02 == 1) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass2(null), 2, (Object) null);
        } else if (condition02 == 2) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass3(null), 2, (Object) null);
        } else {
            if (condition02 != 3) {
                return;
            }
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass4(null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$1", f = "MusicMainFragment.kt", i = {}, l = {449}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "audios", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$1$1", f = "MusicMainFragment.kt", i = {}, l = {452}, m = "invokeSuspend", n = {}, s = {})
        static final class C00161 extends SuspendLambda implements Function2<List<AudioSource>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00161(MusicMainFragment musicMainFragment, Continuation<? super C00161> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00161 = new C00161(this.this$0, continuation);
                c00161.L$0 = obj;
                return c00161;
            }

            public final Object invoke(List<AudioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    Constraint constraint = new Constraint();
                    if (!Intrinsics.areEqual(this.this$0.getMAdapter().getMData().getMTag(), constraint)) {
                        this.this$0.getMAdapter().getMData().setMTag(constraint);
                    }
                    this.label = 1;
                    if (this.this$0.updateList(list, (Continuation) this) == coroutine_suspended) {
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
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<AudioSource>> allSongs = MusicMainFragment.this.getMediaModel().getAllSongs();
                if (allSongs != null) {
                    this.label = 1;
                    if (FlowKt.collectLatest(allSongs, new C00161(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$2", f = "MusicMainFragment.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "albums", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$2$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, AlbumItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getAlbums(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$3, reason: invalid class name */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$3", f = "MusicMainFragment.kt", i = {}, l = {467}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new AnonymousClass3(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "artists", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$3$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, ArtistItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getArtists(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$4, reason: invalid class name */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$4", f = "MusicMainFragment.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new AnonymousClass4(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "folders", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithAll$4$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, FolderItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getFolders(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    private final void setupNodeAdapterWithFavorite(int condition02) {
        Log.e(TAG, "setupNodeAdapterWithFavorite -------------- condition02: " + condition02 + "  ");
        if (condition02 == 0) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00521(null), 3, (Object) null);
            return;
        }
        if (condition02 == 1) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00532(null), 3, (Object) null);
        } else if (condition02 == 2) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00543(null), 3, (Object) null);
        } else {
            if (condition02 != 3) {
                return;
            }
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00554(null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$1", f = "MusicMainFragment.kt", i = {}, l = {489}, m = "invokeSuspend", n = {}, s = {})
    static final class C00521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00521(Continuation<? super C00521> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00521(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "audios", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$1$1", f = "MusicMainFragment.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, s = {})
        static final class C00171 extends SuspendLambda implements Function2<List<AudioSource>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00171(MusicMainFragment musicMainFragment, Continuation<? super C00171> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00171 = new C00171(this.this$0, continuation);
                c00171.L$0 = obj;
                return c00171;
            }

            public final Object invoke(List<AudioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    Constraint constraint = new Constraint();
                    constraint.setFavorite(1);
                    if (!Intrinsics.areEqual(this.this$0.getMAdapter().getMData().getMTag(), constraint)) {
                        this.this$0.getMAdapter().getMData().setMTag(constraint);
                    }
                    this.label = 1;
                    if (this.this$0.updateList(list, (Continuation) this) == coroutine_suspended) {
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
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getFavorites(), new C00171(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$2", f = "MusicMainFragment.kt", i = {}, l = {501}, m = "invokeSuspend", n = {}, s = {})
    static final class C00532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00532(Continuation<? super C00532> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00532(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "albums", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$2$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(1);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(1);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(1);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, AlbumItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getAlbumsWithFavorite(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$3", f = "MusicMainFragment.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    static final class C00543 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00543(Continuation<? super C00543> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00543(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "artists", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$3$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(1);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(1);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(1);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, ArtistItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getArtistsWithFavorite(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$4", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_TV}, m = "invokeSuspend", n = {}, s = {})
    static final class C00554 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00554(Continuation<? super C00554> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00554(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "folders", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithFavorite$4$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v5, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str : list2) {
                        if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(1);
                            constraint.setRootFolder(null);
                            constraint.setAlbum(str);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(1);
                            constraint2.setRootFolder(null);
                            constraint2.setArtist(str);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(1);
                            constraint3.setRootFolder(null);
                            constraint3.setFolder(str);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str);
                            obj2.setFilterOfPath("/");
                            obj2.setFavorite(true);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, FolderItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getFoldersWithFavorite(), new AnonymousClass1(MusicMainFragment.this, null), (Continuation) this) == coroutine_suspended) {
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
    }

    private final void setupNodeAdapterWithHost(int condition02) {
        HiLog.INSTANCE.d(TAG, "setupNodeAdapterWithHost -------------- condition02: " + condition02 + "  ");
        setupNodeAdapterWithPath(condition02, "/storage/emulated/0");
    }

    private final void setupNodeAdapterWithUsb(int condition01, int condition02) {
        int i = condition01 & 63;
        HiLog.INSTANCE.d(TAG, "setupNodeAdapterWithHost condition02: " + condition02 + " usbIndex: " + i + XmlConsts.CHAR_SPACE);
        for (String str : this.storageUsbs) {
            if (StringsKt.contains$default(str, "USB" + i, false, 2, (Object) null)) {
                setupNodeAdapterWithPath(condition02, str);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void setupNodeAdapterWithSDCard(int condition01, int condition02) {
        int i = condition01 & 63;
        Log.e(TAG, "setupNodeAdapterWithSDCard -------------- condition02: " + condition02 + " sdcard index: " + i + XmlConsts.CHAR_SPACE);
        for (String str : this.storageSdCards) {
            if (StringsKt.contains$default(str, "SD" + i, false, 2, (Object) null)) {
                setupNodeAdapterWithPath(condition02, str);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void setupNodeAdapterWithPath(int condition02, String filter) {
        HiLog.INSTANCE.e(TAG, "setupNodeAdapterWithPath111 -------------- condition02: " + condition02 + "  filter: " + filter + XmlConsts.CHAR_SPACE);
        if (condition02 == 0) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00561(filter, null), 3, (Object) null);
            return;
        }
        if (condition02 == 1) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00572(filter, null), 3, (Object) null);
        } else if (condition02 == 2) {
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00583(filter, null), 3, (Object) null);
        } else {
            if (condition02 != 3) {
                return;
            }
            this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00594(filter, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$1", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_POWER}, m = "invokeSuspend", n = {}, s = {})
    static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00561(String str, Continuation<? super C00561> continuation) {
            super(2, continuation);
            this.$filter = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00561(this.$filter, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "audios", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$1$1", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_SEEKUP}, m = "invokeSuspend", n = {}, s = {})
        static final class C00181 extends SuspendLambda implements Function2<List<AudioSource>, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $filter;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00181(MusicMainFragment musicMainFragment, String str, Continuation<? super C00181> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$filter = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00181 = new C00181(this.this$0, this.$filter, continuation);
                c00181.L$0 = obj;
                return c00181;
            }

            public final Object invoke(List<AudioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    Constraint constraint = new Constraint();
                    constraint.setRootFolder(this.$filter);
                    HiLog.INSTANCE.e(MusicMainFragment.TAG, "mAdapter.mData.mTag:" + this.this$0.getMAdapter().getMData().getMTag() + ", constraint:" + constraint);
                    if (!Intrinsics.areEqual(this.this$0.getMAdapter().getMData().getMTag(), constraint)) {
                        this.this$0.getMAdapter().getMData().setMTag(constraint);
                    }
                    this.label = 1;
                    if (this.this$0.updateList(list, (Continuation) this) == coroutine_suspended) {
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
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getAudiosByPath(this.$filter), new C00181(MusicMainFragment.this, this.$filter, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$2", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_FONT_SCALE}, m = "invokeSuspend", n = {}, s = {})
    static final class C00572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00572(String str, Continuation<? super C00572> continuation) {
            super(2, continuation);
            this.$filter = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00572(this.$filter, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "albums", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$2$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $filter;
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$filter = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$filter, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v6, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r11v7, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v9, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    String str = this.$filter;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str2 : list2) {
                        if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(str);
                            constraint.setAlbum(str2);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(str);
                            constraint2.setArtist(str2);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintAlbum.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(str);
                            constraint3.setFolder(str2);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str2);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, AlbumItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getAlbumsWithFolder(this.$filter), new AnonymousClass1(MusicMainFragment.this, this.$filter, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$3", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_2CUSTER_DOWN}, m = "invokeSuspend", n = {}, s = {})
    static final class C00583 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00583(String str, Continuation<? super C00583> continuation) {
            super(2, continuation);
            this.$filter = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00583(this.$filter, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "artists", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$3$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $filter;
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$filter = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$filter, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v6, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r11v7, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v9, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    String str = this.$filter;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str2 : list2) {
                        if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(str);
                            constraint.setAlbum(str2);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(str);
                            constraint2.setArtist(str2);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintArtist.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(str);
                            constraint3.setFolder(str2);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str2);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, ArtistItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getArtistsWithFolder(this.$filter), new AnonymousClass1(MusicMainFragment.this, this.$filter, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$4", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_HANG_OR_MEDIA_PREV}, m = "invokeSuspend", n = {}, s = {})
    static final class C00594 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00594(String str, Continuation<? super C00594> continuation) {
            super(2, continuation);
            this.$filter = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicMainFragment.this.new C00594(this.$filter, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "folders", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$setupNodeAdapterWithPath$4$1", f = "MusicMainFragment.kt", i = {0}, l = {818}, m = "invokeSuspend", n = {"currTime$iv"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $filter;
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$filter = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$filter, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v6, types: [com.syu.media.music.items.ConstraintFolder] */
            /* JADX WARN: Type inference failed for: r11v7, types: [com.syu.media.music.items.ConstraintArtist] */
            /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v9, types: [com.syu.media.music.items.ConstraintAlbum] */
            public final Object invokeSuspend(Object obj) {
                long j;
                ?? obj2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    MusicMainFragment musicMainFragment = this.this$0;
                    String str = this.$filter;
                    HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (String str2 : list2) {
                        if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintAlbum.class)) {
                            Constraint constraint = new Constraint();
                            constraint.setFavorite(0);
                            constraint.setRootFolder(str);
                            constraint.setAlbum(str2);
                            obj2 = new ConstraintAlbum(constraint);
                            obj2.setAlbum(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintArtist.class)) {
                            Constraint constraint2 = new Constraint();
                            constraint2.setFavorite(0);
                            constraint2.setRootFolder(str);
                            constraint2.setArtist(str2);
                            obj2 = new ConstraintArtist(constraint2);
                            obj2.setName(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else if (Intrinsics.areEqual(ConstraintFolder.class, ConstraintFolder.class)) {
                            Constraint constraint3 = new Constraint();
                            constraint3.setFavorite(0);
                            constraint3.setRootFolder(str);
                            constraint3.setFolder(str2);
                            obj2 = new ConstraintFolder(constraint3);
                            String titleFormPath = musicMainFragment.getTitleFormPath(str2);
                            if (titleFormPath == null) {
                                titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                            }
                            obj2.setTitle(titleFormPath);
                            obj2.setPath(str2);
                            obj2.setFilterOfPath(str != null ? str : "/");
                            obj2.setFavorite(false);
                        } else {
                            obj2 = new Object();
                        }
                        arrayList.add(obj2);
                    }
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00614(arrayList, FolderItem.class, musicMainFragment, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "totalTime:" + (System.currentTimeMillis() - j));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MusicMainFragment.this.getMediaModel().getFoldersWithFolder(this.$filter), new AnonymousClass1(MusicMainFragment.this, this.$filter, null), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTitleFormPath(String path) {
        String str = path;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(str, File.separatorChar, 0, false, 6, (Object) null) + 1;
        if (iLastIndexOf$default < path.length()) {
            if (!(str.length() > 0)) {
                return null;
            }
            String strSubstring = path.substring(iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        String strSubstring2 = path.substring(iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        return strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateList(List<? extends MediaSource> list, Continuation<? super Unit> continuation) {
        Job job = this.listJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.listJob = null;
        HiLog.INSTANCE.d(TAG, "mAdapter.itemCount:" + this.mAdapter.getItemCount());
        this.listJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00602(list, this, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$updateList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$updateList$2", f = "MusicMainFragment.kt", i = {}, l = {AutoKeyEvent.KEYCODE_360_BOOT_3D_ROTATION}, m = "invokeSuspend", n = {}, s = {})
    static final class C00602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MediaSource> $audios;
        int label;
        final /* synthetic */ MusicMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00602(List<? extends MediaSource> list, MusicMainFragment musicMainFragment, Continuation<? super C00602> continuation) {
            super(2, continuation);
            this.$audios = list;
            this.this$0 = musicMainFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00602(this.$audios, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HiLog.INSTANCE.d(MusicMainFragment.TAG, "currentThread:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
                List listCreateNodes = Node.Companion.createNodes(this.$audios, AudioItem.class, this.this$0.getMAdapter().getMData());
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.this$0.lastData, listCreateNodes), false);
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, newData), false)");
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, listCreateNodes, diffResultCalculateDiff, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$updateList$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$updateList$2$1", f = "MusicMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Node<?>> $newData;
            final /* synthetic */ DiffUtil.DiffResult $result;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicMainFragment musicMainFragment, List<Node<?>> list, DiffUtil.DiffResult diffResult, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$newData = list;
                this.$result = diffResult;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$newData, this.$result, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MediaProxy audioProxy;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.lastData = this.$newData;
                this.this$0.getMAdapter().replaceWithoutNotify(this.this$0.lastData);
                this.$result.dispatchUpdatesTo((RecyclerView.Adapter) this.this$0.getMAdapter());
                MusicMainFragment musicMainFragment = this.this$0;
                musicMainFragment.ifListEmpty(musicMainFragment.lastData.size());
                if (this.this$0.lastData.size() == 0 && (audioProxy = this.this$0.getAudioProxy()) != null) {
                    MediaProxy.setupPlayList$default(audioProxy, new ConstraintList(null, new Constraint(), 1, null), null, 2, null);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.syu.media.music.items.ConstraintFolder] */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.syu.media.music.items.ConstraintArtist] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v21, types: [com.syu.media.music.items.ConstraintAlbum] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
    private final /* synthetic */ <T> Object updateList(List<String> list, Class<? extends Node<T>> cls, String str, int i, Continuation<? super Unit> continuation) {
        ?? obj;
        HiLog.INSTANCE.d(TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                CoroutineContext main = Dispatchers.getMain();
                C00614 c00614 = new C00614(arrayList, cls, this, null);
                InlineMarker.mark(0);
                BuildersKt.withContext(main, c00614, continuation);
                InlineMarker.mark(1);
                HiLog.INSTANCE.d(TAG, "totalTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return Unit.INSTANCE;
            }
            String str2 = (String) it.next();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            if (Intrinsics.areEqual(Object.class, ConstraintAlbum.class)) {
                Constraint constraint = new Constraint();
                constraint.setFavorite(i);
                constraint.setRootFolder(str);
                constraint.setAlbum(str2);
                Unit unit = Unit.INSTANCE;
                obj = new ConstraintAlbum(constraint);
                obj.setAlbum(str2);
                obj.setFilterOfPath(str != null ? str : "/");
                obj.setFavorite(i == 1);
            } else if (Intrinsics.areEqual(Object.class, ConstraintArtist.class)) {
                Constraint constraint2 = new Constraint();
                constraint2.setFavorite(i);
                constraint2.setRootFolder(str);
                constraint2.setArtist(str2);
                Unit unit2 = Unit.INSTANCE;
                obj = new ConstraintArtist(constraint2);
                obj.setName(str2);
                obj.setFilterOfPath(str != null ? str : "/");
                obj.setFavorite(i == 1);
            } else if (Intrinsics.areEqual(Object.class, ConstraintFolder.class)) {
                Constraint constraint3 = new Constraint();
                constraint3.setFavorite(i);
                constraint3.setRootFolder(str);
                constraint3.setFolder(str2);
                Unit unit3 = Unit.INSTANCE;
                obj = new ConstraintFolder(constraint3);
                String titleFormPath = getTitleFormPath(str2);
                if (titleFormPath == null) {
                    titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                }
                obj.setTitle(titleFormPath);
                obj.setPath(str2);
                obj.setFilterOfPath(str != null ? str : "/");
                obj.setFavorite(i == 1);
            } else {
                obj = new Object();
            }
            arrayList.add(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12, types: [com.syu.media.music.items.ConstraintFolder] */
    /* JADX WARN: Type inference failed for: r13v16, types: [com.syu.media.music.items.ConstraintArtist] */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v21, types: [com.syu.media.music.items.ConstraintAlbum] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    static /* synthetic */ Object updateList$default(MusicMainFragment musicMainFragment, List list, Class cls, String str, int i, Continuation continuation, int i2, Object obj) {
        ?? obj2;
        String str2 = (i2 & 4) != 0 ? null : str;
        int i3 = (i2 & 8) != 0 ? 0 : i;
        HiLog.INSTANCE.d(TAG, "currentThread11:" + Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                CoroutineContext main = Dispatchers.getMain();
                C00614 c00614 = new C00614(arrayList, cls, musicMainFragment, null);
                InlineMarker.mark(0);
                BuildersKt.withContext(main, c00614, continuation);
                InlineMarker.mark(1);
                HiLog.INSTANCE.d(TAG, "totalTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return Unit.INSTANCE;
            }
            String str3 = (String) it.next();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            if (Intrinsics.areEqual(Object.class, ConstraintAlbum.class)) {
                Constraint constraint = new Constraint();
                constraint.setFavorite(i3);
                constraint.setRootFolder(str2);
                constraint.setAlbum(str3);
                Unit unit = Unit.INSTANCE;
                obj2 = new ConstraintAlbum(constraint);
                obj2.setAlbum(str3);
                obj2.setFilterOfPath(str2 != null ? str2 : "/");
                obj2.setFavorite(i3 == 1);
            } else if (Intrinsics.areEqual(Object.class, ConstraintArtist.class)) {
                Constraint constraint2 = new Constraint();
                constraint2.setFavorite(i3);
                constraint2.setRootFolder(str2);
                constraint2.setArtist(str3);
                Unit unit2 = Unit.INSTANCE;
                obj2 = new ConstraintArtist(constraint2);
                obj2.setName(str3);
                obj2.setFilterOfPath(str2 != null ? str2 : "/");
                obj2.setFavorite(i3 == 1);
            } else if (Intrinsics.areEqual(Object.class, ConstraintFolder.class)) {
                Constraint constraint3 = new Constraint();
                constraint3.setFavorite(i3);
                constraint3.setRootFolder(str2);
                constraint3.setFolder(str3);
                Unit unit3 = Unit.INSTANCE;
                obj2 = new ConstraintFolder(constraint3);
                String titleFormPath = musicMainFragment.getTitleFormPath(str3);
                if (titleFormPath == null) {
                    titleFormPath = MediaFiles.INSTANCE.getUNKNOWN();
                }
                obj2.setTitle(titleFormPath);
                obj2.setPath(str3);
                obj2.setFilterOfPath(str2 != null ? str2 : "/");
                obj2.setFavorite(i3 == 1);
            } else {
                obj2 = new Object();
            }
            arrayList.add(obj2);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$updateList$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$updateList$4", f = "MusicMainFragment.kt", i = {}, l = {710}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00614 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Class<? extends Node<T>> $clazz;
        final /* synthetic */ List<Object> $objects;
        int label;
        final /* synthetic */ MusicMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00614(List<? extends Object> list, Class<? extends Node<T>> cls, MusicMainFragment musicMainFragment, Continuation<? super C00614> continuation) {
            super(2, continuation);
            this.$objects = list;
            this.$clazz = cls;
            this.this$0 = musicMainFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00614(this.$objects, this.$clazz, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listCreateNodes = Node.Companion.createNodes(this.$objects, this.$clazz, this.this$0.getMAdapter().getMData());
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.this$0.lastData, listCreateNodes), false);
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, newData), false)");
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, listCreateNodes, diffResultCalculateDiff, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$updateList$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicMainFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$updateList$4$1", f = "MusicMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Node<?>> $newData;
            final /* synthetic */ DiffUtil.DiffResult $result;
            int label;
            final /* synthetic */ MusicMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MusicMainFragment musicMainFragment, List<Node<?>> list, DiffUtil.DiffResult diffResult, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicMainFragment;
                this.$newData = list;
                this.$result = diffResult;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$newData, this.$result, continuation);
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
                this.this$0.getMAdapter().replaceWithoutNotify(this.this$0.lastData);
                this.$result.dispatchUpdatesTo((RecyclerView.Adapter) this.this$0.getMAdapter());
                MusicMainFragment musicMainFragment = this.this$0;
                musicMainFragment.ifListEmpty(musicMainFragment.lastData.size());
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.syu.media.BaseMediaApp.OnScanStateListener
    public void onScanStateChanged(boolean scanning, String rootFolder) {
        MediaProxy audioProxy;
        MainAct mainActRequireMainAct;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(rootFolder, "rootFolder");
        Log.d(TAG, "onScanStateChanged scanning:" + scanning + ", rootFolder:" + rootFolder);
        if (scanning || (audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy()) == null) {
            return;
        }
        Integer value = audioProxy.getListCondition01().getValue();
        boolean z = false;
        if (value == null) {
            value = 0;
        }
        Intrinsics.checkNotNullExpressionValue(value, "proxy.listCondition01.value ?: ListCondition01.ALL");
        final int iIntValue = value.intValue();
        Integer value2 = audioProxy.getListCondition02().getValue();
        if (value2 == null) {
            value2 = 0;
        }
        Intrinsics.checkNotNullExpressionValue(value2, "proxy.listCondition02.va… ?: ListCondition02.TRACK");
        final int iIntValue2 = value2.intValue();
        if (iIntValue2 != 0 && ((iIntValue << 3) | iIntValue2) == this.mListFlag) {
            int i3 = iIntValue & 448;
            if (i3 == 0 || i3 == 64 || (i3 == 128 ? Intrinsics.areEqual(rootFolder, "/storage/emulated/0") : !(i3 == 192 ? (i = iIntValue & 63) >= this.storageUsbs.size() || !Intrinsics.areEqual(rootFolder, this.storageUsbs.get(i)) : i3 != 256 || (i2 = iIntValue & 63) >= this.storageUsbs.size() || !Intrinsics.areEqual(rootFolder, this.storageSdCards.get(i2))))) {
                z = true;
            }
            if (!z || (mainActRequireMainAct = requireMainAct()) == null) {
                return;
            }
            mainActRequireMainAct.runOnUiThread(new Runnable() { // from class: com.syu.media.music.fragment.MusicMainFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MusicMainFragment.m182onScanStateChanged$lambda38$lambda37(this.f$0, iIntValue, iIntValue2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onScanStateChanged$lambda-38$lambda-37, reason: not valid java name */
    public static final void m182onScanStateChanged$lambda38$lambda37(MusicMainFragment musicMainFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(musicMainFragment, "this$0");
        musicMainFragment.notifyNodeAdapter(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void ifListEmpty(int count) {
        HiLog.INSTANCE.d(TAG, "ifListEmpty count:" + count);
        ((MusicMainFragmentBinding) getBinding()).musicMainAudioEmpty.setVisibility(count == 0 ? 0 : 8);
    }
}
