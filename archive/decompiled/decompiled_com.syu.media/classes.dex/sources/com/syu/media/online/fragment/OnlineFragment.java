package com.syu.media.online.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import bsp.FinalBsp;
import chip.FinalChip;
import com.google.gson.Gson;
import com.syu.media.ConstantsKt;
import com.syu.media.MainAct;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.base.BaseFragment;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.ext.ViewExtKt;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.view.fons.FaceMyingheiButton;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.databinding.OnlineFragmentBinding;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.PlayListWithRadios;
import com.syu.media.entities.RadioSource;
import com.syu.media.music.diff.DiffCallBack;
import com.syu.media.music.fragment.MediaBaseFragment;
import com.syu.media.music.fragment.MusicFragment;
import com.syu.media.music.widget.SpinLayoutManager;
import com.syu.media.music.widget.SpinRecyclerView;
import com.syu.media.music.widget.items.XGridLayoutManager;
import com.syu.media.online.OnlineRadioService;
import com.syu.media.online.item.OnlineItem;
import com.syu.media.online.item.OnlineSpinItem;
import com.syu.media.service.MediaPresenter;
import com.syu.utils.BitmapUtils;
import com.syu.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import qin.widgets.JRecyclerView;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: OnlineFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u001f\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001a\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\bH\u0002J\u0010\u00108\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/syu/media/online/fragment/OnlineFragment;", "Lcom/syu/media/music/fragment/MediaBaseFragment;", "Lcom/syu/media/databinding/OnlineFragmentBinding;", "Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", "()V", "blurJob", "Lkotlinx/coroutines/Job;", "fileWriteName", FinalChip.BSP_PLATFORM_Null, "job", "lastData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "lastPosition", FinalChip.BSP_PLATFORM_Null, "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mCountryName", "mSpinAdapter", "onlineLocals", "Lcom/syu/media/entities/RadioSource;", "getOnlineLocals", "()Ljava/util/List;", "onlinePresenter", "Lcom/syu/media/service/MediaPresenter;", "playSource", "playing", FinalChip.BSP_PLATFORM_Null, "spinData", "addCellToList", FinalChip.BSP_PLATFORM_Null, "countryName", "row", "Lorg/apache/poi/ss/usermodel/Row;", "albumChange", "bitmap", "Landroid/graphics/Bitmap;", "getRadiosByLocal", "initData", "initObserve", "initView", "view", "Landroid/view/View;", "moveTaskToBack", "notifyNodeAdapter", "radios", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onChanged", "isPlaying", "source", "Lcom/syu/media/entities/MediaSource;", "onDestroy", "onPaused", "onResumed", "onlinesByCounry", "name", "readXlxsFromRadioLogo", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineFragment extends MediaBaseFragment<OnlineFragmentBinding> implements MediaPresenter.OnPlayStateChangedListener {
    public static final String TAG = "OnlineFragment";
    private Job blurJob;
    private String fileWriteName;
    private Job job;
    private List<Node<?>> lastData;
    private int lastPosition;
    private NodeAdapter mAdapter;
    private String mCountryName;
    private NodeAdapter mSpinAdapter;
    private final List<RadioSource> onlineLocals;
    private MediaPresenter onlinePresenter;
    private RadioSource playSource;
    private boolean playing;
    private List<Node<?>> spinData;

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
    }

    public OnlineFragment() {
        super(R.layout.online_fragment);
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mSpinAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.lastPosition = -1;
        this.lastData = new ArrayList();
        this.spinData = new ArrayList();
        this.mCountryName = FinalChip.BSP_PLATFORM_Null;
        this.fileWriteName = "online.json";
        this.onlineLocals = new ArrayList();
    }

    public final List<RadioSource> getOnlineLocals() {
        return this.onlineLocals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String propForString = Utils.getPropForString(ConstantsKt.ONLINE_COUNTRY_SELECTION, getResources().getString(R.string.online_default_country_name));
        Intrinsics.checkNotNullExpressionValue(propForString, "getPropForString(\n      …ne_default_country_name))");
        this.mCountryName = propForString;
        getOnlineModel().getCountryName().setValue(this.mCountryName);
        ((OnlineFragmentBinding) getBinding()).onlineCountry.setText(this.mCountryName);
        getRadiosByLocal();
        bkChanged(R.id.online_frag_blur_img, getDrawable(R.drawable.btmusic_bk));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String name = OnlineRadioService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OnlineRadioService::class.java.name");
        MediaPresenter mediaPresenter = new MediaPresenter(contextRequireContext, name, ((OnlineFragmentBinding) getBinding()).onlinePlayerPlaypause, ((OnlineFragmentBinding) getBinding()).onlinePlayerNext, ((OnlineFragmentBinding) getBinding()).onlinePlayerPrev);
        this.onlinePresenter = mediaPresenter;
        mediaPresenter.registerOnPlayStateChangedListener(this);
        JRecyclerView jRecyclerView = ((OnlineFragmentBinding) getBinding()).onlinePlayListRecycler;
        XGridLayoutManager xGridLayoutManager = new XGridLayoutManager(requireContext(), 3);
        xGridLayoutManager.setOrientation(1);
        jRecyclerView.setLayoutManager(xGridLayoutManager);
        jRecyclerView.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) jRecyclerView.getResources().getDimension(R.dimen.music_item_space)), null, null, null, null, 30, null));
        jRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setMTag(this.onlinePresenter);
        RecyclerView.ItemAnimator itemAnimator = jRecyclerView.getItemAnimator();
        if (itemAnimator == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        jRecyclerView.setTag(this);
        SpinRecyclerView spinRecyclerView = ((OnlineFragmentBinding) getBinding()).onlineSpinListRecycler;
        spinRecyclerView.setLayoutManager(new SpinLayoutManager(1.0f, 0.88f));
        spinRecyclerView.setAdapter((RecyclerView.Adapter) this.mSpinAdapter);
        this.mSpinAdapter.setMTag(this.onlinePresenter);
        RecyclerView.ItemAnimator itemAnimator2 = spinRecyclerView.getItemAnimator();
        if (itemAnimator2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((SimpleItemAnimator) itemAnimator2).setSupportsChangeAnimations(false);
        spinRecyclerView.setTag(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initData() {
        ImageView imageView = ((OnlineFragmentBinding) getBinding()).onlineImportStep;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.onlineImportStep");
        ViewExtKt.onClick$default(imageView, 0L, new Function1<View, Unit>() { // from class: com.syu.media.online.fragment.OnlineFragment.initData.1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                HiLog.INSTANCE.e(OnlineFragment.TAG, "onlineImportStep onClick");
            }
        }, 1, null);
        FaceMyingheiButton faceMyingheiButton = ((OnlineFragmentBinding) getBinding()).onlineCountry;
        Intrinsics.checkNotNullExpressionValue(faceMyingheiButton, "binding.onlineCountry");
        ViewExtKt.onClick$default(faceMyingheiButton, 0L, new Function1<View, Unit>() { // from class: com.syu.media.online.fragment.OnlineFragment.initData.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                HiLog.INSTANCE.e(OnlineFragment.TAG, "onlineImportStep onClick");
                SelectorDialogFragment selectorDialogFragment = new SelectorDialogFragment();
                FragmentManager parentFragmentManager = OnlineFragment.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                selectorDialogFragment.show(parentFragmentManager);
            }
        }, 1, null);
        FaceMyingheiTextView faceMyingheiTextView = ((OnlineFragmentBinding) getBinding()).onlineList;
        Intrinsics.checkNotNullExpressionValue(faceMyingheiTextView, "binding.onlineList");
        ViewExtKt.onClick$default(faceMyingheiTextView, 0L, new Function1<View, Unit>() { // from class: com.syu.media.online.fragment.OnlineFragment.initData.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                OnlineFragment.this.onStartPage(ConstantsKt.ACTION_PAGE_ONLINE_DETATIL);
            }
        }, 1, null);
        ((OnlineFragmentBinding) getBinding()).onlineFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.online.fragment.OnlineFragment$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                OnlineFragment.m205initData$lambda4(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initData$lambda-4, reason: not valid java name */
    public static final void m205initData$lambda4(OnlineFragment onlineFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(onlineFragment, "this$0");
        RadioSource radioSource = onlineFragment.playSource;
        if (radioSource != null) {
            radioSource.setFavorite(z);
            onlineFragment.getMusicModel().getOnlineFavorite().setValue(radioSource);
        }
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        getOnlineModel().getCountryName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.online.fragment.OnlineFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OnlineFragment.m206initObserve$lambda5(this.f$0, (String) obj);
            }
        });
        getMusicModel().getOnlineFavorite().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.online.fragment.OnlineFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OnlineFragment.m207initObserve$lambda6(this.f$0, (RadioSource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-5, reason: not valid java name */
    public static final void m206initObserve$lambda5(OnlineFragment onlineFragment, String str) {
        Intrinsics.checkNotNullParameter(onlineFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "onlineModel " + onlineFragment.mCountryName + "--" + str);
        if (Intrinsics.areEqual(onlineFragment.mCountryName, str)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str, "it");
        onlineFragment.mCountryName = str;
        onlineFragment.onlinesByCounry(str);
        ((OnlineFragmentBinding) onlineFragment.getBinding()).onlineCountry.setText(str);
        Utils.writeSystemProperties(ConstantsKt.ONLINE_COUNTRY_SELECTION, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-6, reason: not valid java name */
    public static final void m207initObserve$lambda6(OnlineFragment onlineFragment, RadioSource radioSource) {
        Intrinsics.checkNotNullParameter(onlineFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "listFavoriteNotify:" + radioSource.getCom.syu.media.provider.Media.PATH java.lang.String() + " favorite:" + radioSource.getFavorite());
        if (Intrinsics.areEqual(onlineFragment.playSource, radioSource)) {
            ((OnlineFragmentBinding) onlineFragment.getBinding()).onlineFavorite.setChecked(radioSource.getFavorite());
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(onlineFragment), Dispatchers.getIO(), (CoroutineStart) null, new OnlineFragment$initObserve$2$1(radioSource, onlineFragment, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.OnlineFragment$onlinesByCounry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnlineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$onlinesByCounry$1", f = "OnlineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00671(String str, Continuation<? super C00671> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnlineFragment.this.new C00671(this.$name, continuation);
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
            List<RadioSource> radiosByCountry = OnlineFragment.this.getMediaDao().getRadiosByCountry(this.$name);
            HiLog.INSTANCE.d(OnlineFragment.TAG, "cs11:" + radiosByCountry.size());
            OnlineFragment.this.getMediaDao().updateRadioPlayList(radiosByCountry);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onlinesByCounry(String name) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new C00671(name, null), 2, (Object) null);
    }

    @Override // com.syu.media.base.BaseFragment
    public void moveTaskToBack() {
        if (onlineAudio()) {
            openAppId(0);
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        if (onlineAudio()) {
            return;
        }
        openAppId(7);
    }

    @Override // com.syu.media.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MediaPresenter mediaPresenter = this.onlinePresenter;
        if (mediaPresenter != null) {
            mediaPresenter.unregisterOnPlayStateChangedListener(this);
        }
    }

    private final void getRadiosByLocal() {
        HiLog.INSTANCE.d(TAG, "country:" + this.mCountryName);
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new C00641(null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.OnlineFragment$getRadiosByLocal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnlineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$getRadiosByLocal$1", f = "OnlineFragment.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    static final class C00641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00641(Continuation<? super C00641> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnlineFragment.this.new C00641(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(OnlineFragment.this.getMediaDao().getOnlinePlayListById(8), new C00211(OnlineFragment.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.syu.media.online.fragment.OnlineFragment$getRadiosByLocal$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: OnlineFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", "Lcom/syu/media/entities/PlayListWithRadios;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$getRadiosByLocal$1$1", f = "OnlineFragment.kt", i = {}, l = {FinalBsp.KEY_CODE_MENU}, m = "invokeSuspend", n = {}, s = {})
        static final class C00211 extends SuspendLambda implements Function2<PlayListWithRadios, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ OnlineFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00211(OnlineFragment onlineFragment, Continuation<? super C00211> continuation) {
                super(2, continuation);
                this.this$0 = onlineFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00211 = new C00211(this.this$0, continuation);
                c00211.L$0 = obj;
                return c00211;
            }

            public final Object invoke(PlayListWithRadios playListWithRadios, Continuation<? super Unit> continuation) {
                return create(playListWithRadios, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PlayListWithRadios playListWithRadios = (PlayListWithRadios) this.L$0;
                    if (playListWithRadios == null || playListWithRadios.getRadios().isEmpty()) {
                        OnlineFragment onlineFragment = this.this$0;
                        onlineFragment.onlinesByCounry(onlineFragment.mCountryName);
                    } else {
                        HiLog.INSTANCE.d(OnlineFragment.TAG, "it.radios:" + playListWithRadios.getRadios().size());
                        this.label = 1;
                        if (this.this$0.notifyNodeAdapter(playListWithRadios.getRadios(), (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object notifyNodeAdapter(List<RadioSource> list, Continuation<? super Unit> continuation) {
        HiLog.INSTANCE.d(TAG, "allRadios radioSize:" + list.size());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((RadioSource) next).getCom.syu.media.provider.Media.PATH java.lang.String().length() > 0) {
                arrayList.add(next);
            }
        }
        List mutableList = CollectionsKt.toMutableList(arrayList);
        List<RadioSource> list2 = this.onlineLocals;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list2) {
            if (Intrinsics.areEqual(((RadioSource) obj).getCom.syu.media.provider.Media.COUNTRY java.lang.String(), this.mCountryName)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        HiLog.INSTANCE.d(TAG, "locals" + arrayList3.size());
        mutableList.addAll(arrayList3);
        List listCreateNodes = Node.Companion.createNodes(mutableList, OnlineItem.class, this.mAdapter.getMData());
        List listCreateNodes2 = Node.Companion.createNodes(mutableList, OnlineSpinItem.class, this.mSpinAdapter.getMData());
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.lastData, listCreateNodes), false);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, newData), false)");
        DiffUtil.DiffResult diffResultCalculateDiff2 = DiffUtil.calculateDiff(new DiffCallBack(this.spinData, listCreateNodes2), false);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff2, "calculateDiff(DiffCallBa…ata, newSpinData), false)");
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C00662(listCreateNodes, diffResultCalculateDiff, listCreateNodes2, diffResultCalculateDiff2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.OnlineFragment$notifyNodeAdapter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnlineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$notifyNodeAdapter$2", f = "OnlineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Node<?>> $newData;
        final /* synthetic */ List<Node<?>> $newSpinData;
        final /* synthetic */ DiffUtil.DiffResult $result;
        final /* synthetic */ DiffUtil.DiffResult $spinResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00662(List<Node<?>> list, DiffUtil.DiffResult diffResult, List<Node<?>> list2, DiffUtil.DiffResult diffResult2, Continuation<? super C00662> continuation) {
            super(2, continuation);
            this.$newData = list;
            this.$result = diffResult;
            this.$newSpinData = list2;
            this.$spinResult = diffResult2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnlineFragment.this.new C00662(this.$newData, this.$result, this.$newSpinData, this.$spinResult, continuation);
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
            OnlineFragment.this.lastData = this.$newData;
            OnlineFragment.this.mAdapter.replaceWithoutNotify(OnlineFragment.this.lastData);
            this.$result.dispatchUpdatesTo((RecyclerView.Adapter) OnlineFragment.this.mAdapter);
            OnlineFragment.this.spinData = this.$newSpinData;
            OnlineFragment.this.mSpinAdapter.replaceWithoutNotify(OnlineFragment.this.spinData);
            this.$spinResult.dispatchUpdatesTo((RecyclerView.Adapter) OnlineFragment.this.mSpinAdapter);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayStateChangedListener
    public void onChanged(boolean isPlaying, MediaSource source) {
        boolean z = source instanceof RadioSource;
        HiLog.INSTANCE.d(TAG, "onChanged:" + isPlaying + " ,source:" + z);
        if (source == 0 || !z) {
            return;
        }
        RadioSource radioSource = (RadioSource) source;
        this.playSource = radioSource;
        this.playing = isPlaying;
        MediaProxy audioProxy = getAudioProxy();
        if (audioProxy != null) {
            audioProxy.setOnlinePath(source.getCom.syu.media.provider.Media.PATH java.lang.String());
        }
        ((OnlineFragmentBinding) getBinding()).onlineName.setText(source.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
        ((OnlineFragmentBinding) getBinding()).onlineType.setVisibility(toVisible(radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String().length() > 0));
        ((OnlineFragmentBinding) getBinding()).onlineArea.setVisibility(toVisible(radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String().length() > 0));
        ((OnlineFragmentBinding) getBinding()).onlineType.setText(radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String());
        ((OnlineFragmentBinding) getBinding()).onlineArea.setText(radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String());
        ((OnlineFragmentBinding) getBinding()).onlineFavorite.setChecked(source.getFavorite());
        ((OnlineFragmentBinding) getBinding()).onlinePlayerPlaypause.setImageResource(this.playing ? R.drawable.music_player_pause_swi : R.drawable.music_player_play_swi);
        int iPositionOf = this.mAdapter.getMData().positionOf(source);
        HiLog.INSTANCE.d(MusicFragment.TAG, "onChanged selected:" + iPositionOf + "  ,lastPosition:" + this.lastPosition);
        int i = this.lastPosition;
        if (i != iPositionOf) {
            if (i >= 0) {
                this.mAdapter.notifyItemChanged(i);
            }
            if (iPositionOf >= 0) {
                getOnlineModel().getOnlineDataChange().setValue(source);
                this.mAdapter.notifyItemChanged(iPositionOf);
                ((OnlineFragmentBinding) getBinding()).onlinePlayListRecycler.scrollToPosition(iPositionOf);
                if (Math.abs(this.lastPosition - iPositionOf) > 1) {
                    ((OnlineFragmentBinding) getBinding()).onlineSpinListRecycler.scrollToPosition(iPositionOf);
                } else {
                    ((OnlineFragmentBinding) getBinding()).onlineSpinListRecycler.smoothScrollToPosition(iPositionOf);
                }
            }
            this.lastPosition = iPositionOf;
        } else {
            this.mAdapter.notifyItemChanged(iPositionOf);
        }
        MediaPresenter mediaPresenter = this.onlinePresenter;
        if (mediaPresenter != null) {
            mediaPresenter.enablePlayProgress(isPlaying);
        }
        String str = radioSource.getCom.syu.media.provider.Media.ICON java.lang.String();
        HiLog.INSTANCE.e(TAG, "data cover: " + str + ", " + new File(str).exists());
        Bitmap bitmapDecodeBitmap = getApp().getResourcesLoader().decodeBitmap(str);
        if (bitmapDecodeBitmap == null) {
            bitmapDecodeBitmap = getApp().getIconCache().get(source.getCom.syu.media.provider.Media.PATH java.lang.String());
        }
        albumChange(bitmapDecodeBitmap);
    }

    private final void albumChange(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        HiLog.INSTANCE.d(TAG, "albumChange");
        Job job = this.blurJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(bitmap, this, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.OnlineFragment$albumChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$albumChange$1", f = "OnlineFragment.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        int label;
        final /* synthetic */ OnlineFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, OnlineFragment onlineFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.this$0 = onlineFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bitmap, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Bitmap bitmap = this.$bitmap;
            OnlineFragment onlineFragment = this.this$0;
            float fMax = Math.max(onlineFragment.displayWidth(), onlineFragment.displayHeight());
            Bitmap bitmapScaleBitmap = BitmapUtils.INSTANCE.scaleBitmap(onlineFragment.copyBitmap(bitmap), fMax, fMax, true);
            OnlineFragment onlineFragment2 = this.this$0;
            final OnlineFragment onlineFragment3 = this.this$0;
            onlineFragment2.blurTransformation(bitmapScaleBitmap, new Function1<Drawable, Unit>() { // from class: com.syu.media.online.fragment.OnlineFragment.albumChange.1.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Drawable) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Drawable drawable) {
                    BaseFragment baseFragmentFindFragmentByAction;
                    Intrinsics.checkNotNullParameter(drawable, "it");
                    onlineFragment3.bkChanged(R.id.online_frag_blur_img, drawable);
                    MainAct mainActRequireMainAct = onlineFragment3.requireMainAct();
                    if (mainActRequireMainAct == null || (baseFragmentFindFragmentByAction = mainActRequireMainAct.findFragmentByAction(ConstantsKt.ACTION_PAGE_ONLINE_DETATIL)) == null || !(baseFragmentFindFragmentByAction instanceof OnlineDetailFragment)) {
                        return;
                    }
                    ((OnlineDetailFragment) baseFragmentFindFragmentByAction).setBlurBk(drawable);
                }
            });
            return Unit.INSTANCE;
        }
    }

    private final void readXlxsFromRadioLogo(String countryName) {
        Sheet sheetAt;
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "radio_logo/online.xlsx");
        try {
            if (!file.exists() || (sheetAt = WorkbookFactory.create(new FileInputStream(file)).getSheetAt(0)) == null) {
                return;
            }
            int firstRowNum = sheetAt.getFirstRowNum();
            int lastRowNum = sheetAt.getLastRowNum();
            HiLog.INSTANCE.d(TAG, "firstRowNum:" + firstRowNum + " lastRowNum:" + lastRowNum);
            int i = firstRowNum + 1;
            if (i > lastRowNum) {
                return;
            }
            while (true) {
                Row row = sheetAt.getRow(i);
                if (row != null) {
                    Intrinsics.checkNotNullExpressionValue(row, "getRow(i)");
                    HiLog.INSTANCE.d(TAG, "firstCellNum:" + ((int) row.getFirstCellNum()) + " lastCellNum:" + ((int) row.getLastCellNum()));
                    String stringCellValue = row.getCell(2).getStringCellValue();
                    Intrinsics.checkNotNullExpressionValue(stringCellValue, "getCell(ONLINE_INDEX_URI).stringCellValue");
                    boolean z = StringsKt.startsWith$default(stringCellValue, "http", false, 2, (Object) null) || StringsKt.startsWith$default(stringCellValue, "https", false, 2, (Object) null);
                    if (row.getLastCellNum() == 6 && z) {
                        addCellToList(countryName, row);
                    }
                }
                if (i == lastRowNum) {
                    return;
                } else {
                    i++;
                }
            }
        } catch (Exception e) {
            HiLog.INSTANCE.d(TAG, "readXlxsFromRadioLogo" + e);
        }
    }

    private final void addCellToList(String countryName, Row row) {
        this.onlineLocals.clear();
        List<RadioSource> list = this.onlineLocals;
        RadioSource radioSource = new RadioSource();
        radioSource.setTitle(row.getCell(0).getStringCellValue());
        radioSource.setDisplayName(row.getCell(0).getStringCellValue());
        String stringCellValue = row.getCell(1).getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(stringCellValue, "row.getCell(ONLINE_INDEX_ICON).stringCellValue");
        radioSource.setIcon(stringCellValue);
        String stringCellValue2 = row.getCell(2).getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(stringCellValue2, "row.getCell(ONLINE_INDEX_URI).stringCellValue");
        radioSource.setPath(stringCellValue2);
        String stringCellValue3 = row.getCell(3).getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(stringCellValue3, "row.getCell(ONLINE_INDEX_TYPE).stringCellValue");
        radioSource.setType(stringCellValue3);
        String stringCellValue4 = row.getCell(5).getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(stringCellValue4, "row.getCell(ONLINE_INDEX_CITY).stringCellValue");
        radioSource.setLocal(stringCellValue4);
        String stringCellValue5 = row.getCell(4).getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(stringCellValue5, "row.getCell(ONLINE_INDEX_COUNTRY).stringCellValue");
        radioSource.setCountry(stringCellValue5);
        list.add(radioSource);
        if (!this.onlineLocals.isEmpty()) {
            new Gson().toJson(this.onlineLocals);
            requireActivity().getCacheDir();
            getRadiosByLocal();
        }
    }
}
