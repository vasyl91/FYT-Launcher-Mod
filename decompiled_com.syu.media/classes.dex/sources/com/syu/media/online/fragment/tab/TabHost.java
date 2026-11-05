package com.syu.media.online.fragment.tab;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.syu.media.Constraint;
import com.syu.media.ConstraintList;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.databinding.OnlineTabHostFragmentBinding;
import com.syu.media.entities.RadioSource;
import com.syu.media.music.diff.DiffCallBack;
import com.syu.media.music.fragment.MediaBaseFragment;
import com.syu.media.music.widget.items.XGridLayoutManager;
import com.syu.media.online.fragment.OnlineDetailFragment;
import com.syu.media.online.item.OnLineTypesItem;
import com.syu.media.online.item.OnlineDetailItem;
import com.syu.media.online.item.OnlineTypeOrLocal;
import com.syu.media.online.viewmodel.OnlineViewModel;
import com.syu.media.provider.Media;
import com.syu.media.service.MediaPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: TabHost.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001f\u0010\u001f\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J'\u0010\u001f\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010$\u001a\u00020\u001aH\u0082Hø\u0001\u0000¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/syu/media/online/fragment/tab/TabHost;", "Lcom/syu/media/music/fragment/MediaBaseFragment;", "Lcom/syu/media/databinding/OnlineTabHostFragmentBinding;", "tabType", "Lcom/syu/media/online/fragment/tab/TabType;", "onlinePresenter", "Lcom/syu/media/service/MediaPresenter;", "(Lcom/syu/media/online/fragment/tab/TabType;Lcom/syu/media/service/MediaPresenter;)V", "job", "Lkotlinx/coroutines/Job;", "lastData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "lastSong", "Lcom/syu/media/entities/RadioSource;", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "getMAdapter", "()Lsyu/recyclerview/NodeAdapter;", "setMAdapter", "(Lsyu/recyclerview/NodeAdapter;)V", "nationName", FinalChip.BSP_PLATFORM_Null, "ifListEmpty", FinalChip.BSP_PLATFORM_Null, "count", FinalChip.BSP_PLATFORM_Null, "initObserve", "initView", "view", "Landroid/view/View;", "notifyNodeAdapter", "radios", FinalChip.BSP_PLATFORM_Null, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "menus", Media.TYPE, "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateList", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TabHost extends MediaBaseFragment<OnlineTabHostFragmentBinding> {
    public static final String TAG = "MediaBaseFragment";
    private Job job;
    private List<Node<?>> lastData;
    private RadioSource lastSong;
    private NodeAdapter mAdapter;
    private String nationName;
    private final MediaPresenter onlinePresenter;
    private final TabType tabType;

    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabType.values().length];
            iArr[TabType.TAB_LIST_ALL.ordinal()] = 1;
            iArr[TabType.TAB_LIST_LOCAL.ordinal()] = 2;
            iArr[TabType.TAB_LIST_TYPE.ordinal()] = 3;
            iArr[TabType.TAB_LIST_FAVORITE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabHost(TabType tabType, MediaPresenter mediaPresenter) {
        super(R.layout.online_tab_host_fragment);
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        Intrinsics.checkNotNullParameter(mediaPresenter, "onlinePresenter");
        this.tabType = tabType;
        this.onlinePresenter = mediaPresenter;
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.lastData = new ArrayList();
        this.nationName = FinalChip.BSP_PLATFORM_Null;
        this.lastSong = new RadioSource();
    }

    public final NodeAdapter getMAdapter() {
        return this.mAdapter;
    }

    public final void setMAdapter(NodeAdapter nodeAdapter) {
        Intrinsics.checkNotNullParameter(nodeAdapter, "<set-?>");
        this.mAdapter = nodeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = ((OnlineTabHostFragmentBinding) getBinding()).onlineDetailRecyclerview;
        recyclerView.setLayoutManager(new XGridLayoutManager(requireContext(), 4));
        recyclerView.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) recyclerView.getResources().getDimension(R.dimen.online_detail_item_space)), null, null, null, null, 30, null));
        recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
        this.mAdapter.setMTag(this.onlinePresenter);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        recyclerView.setTag(this);
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        getMusicModel().getOnlineFavorite().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.online.fragment.tab.TabHost$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabHost.m210initObserve$lambda1(this.f$0, (RadioSource) obj);
            }
        });
        OnlineViewModel onlineModel = getOnlineModel();
        onlineModel.getCountryName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.online.fragment.tab.TabHost$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabHost.m211initObserve$lambda4$lambda2(this.f$0, (String) obj);
            }
        });
        onlineModel.getOnlineDataChange().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.online.fragment.tab.TabHost$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabHost.m212initObserve$lambda4$lambda3(this.f$0, (RadioSource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-1, reason: not valid java name */
    public static final void m210initObserve$lambda1(TabHost tabHost, RadioSource radioSource) {
        Intrinsics.checkNotNullParameter(tabHost, "this$0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(tabHost), Dispatchers.getIO(), (CoroutineStart) null, new TabHost$initObserve$1$1(radioSource, tabHost, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-4$lambda-2, reason: not valid java name */
    public static final void m211initObserve$lambda4$lambda2(TabHost tabHost, String str) {
        Intrinsics.checkNotNullParameter(tabHost, "this$0");
        HiLog.INSTANCE.d("MediaBaseFragment", "onlineModel countryName:" + str);
        if (Intrinsics.areEqual(tabHost.nationName, str)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str, "it");
        tabHost.nationName = str;
        tabHost.updateList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-4$lambda-3, reason: not valid java name */
    public static final void m212initObserve$lambda4$lambda3(TabHost tabHost, RadioSource radioSource) {
        Intrinsics.checkNotNullParameter(tabHost, "this$0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(tabHost), Dispatchers.getIO(), (CoroutineStart) null, new TabHost$initObserve$2$2$1(tabHost, radioSource, null), 2, (Object) null);
    }

    private final void updateList() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        int i = WhenMappings.$EnumSwitchMapping$0[this.tabType.ordinal()];
        if (i == 1) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
            return;
        }
        if (i == 2) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new C00692(null), 2, (Object) null);
        } else if (i == 3) {
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass3(null), 2, (Object) null);
        } else {
            if (i != 4) {
                return;
            }
            this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new C00704(null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$1, reason: invalid class name */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$1", f = "TabHost.kt", i = {}, l = {AutoKeyEvent.KEYCODE_MEDIA_NEXT}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TabHost.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/RadioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$1$1", f = "TabHost.kt", i = {}, l = {AutoKeyEvent.KEYCODE_MEDIA_PREVIOUS}, m = "invokeSuspend", n = {}, s = {})
        static final class C00231 extends SuspendLambda implements Function2<List<RadioSource>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TabHost this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00231(TabHost tabHost, Continuation<? super C00231> continuation) {
                super(2, continuation);
                this.this$0 = tabHost;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00231 = new C00231(this.this$0, continuation);
                c00231.L$0 = obj;
                return c00231;
            }

            public final Object invoke(List<RadioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    this.label = 1;
                    if (this.this$0.notifyNodeAdapter(list, (Continuation) this) == coroutine_suspended) {
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
                if (FlowKt.collectLatest(TabHost.this.getMediaDao().getRadiosByCountryFlow(TabHost.this.nationName), new C00231(TabHost.this, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$2", f = "TabHost.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C00692 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00692(Continuation<? super C00692> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new C00692(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TabHost.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$2$1", f = "TabHost.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TabHost this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TabHost tabHost, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = tabHost;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    TabHost tabHost = this.this$0;
                    HiLog.INSTANCE.d("MediaBaseFragment", "notifyNodeAdapter type:2");
                    List list2 = (List) list.stream().distinct().collect(Collectors.toList());
                    HiLog.INSTANCE.d("MediaBaseFragment", "datas:" + list2);
                    Intrinsics.checkNotNullExpressionValue(list2, "datas");
                    List<String> list3 = list2;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (String str : list3) {
                        OnlineTypeOrLocal onlineTypeOrLocal = new OnlineTypeOrLocal();
                        Intrinsics.checkNotNullExpressionValue(str, "it");
                        onlineTypeOrLocal.setTitle(str);
                        onlineTypeOrLocal.setItemType(2);
                        arrayList.add(onlineTypeOrLocal);
                    }
                    List listCreateNodes = Node.Companion.createNodes(arrayList, OnLineTypesItem.class, tabHost.getMAdapter().getMData());
                    DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(tabHost.lastData, listCreateNodes), false);
                    Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…tData , newData) , false)");
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), tabHost.new AnonymousClass2(listCreateNodes, diffResultCalculateDiff, null), (Continuation) this) == coroutine_suspended) {
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
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(TabHost.this.getMediaDao().localsByCountryFlow(TabHost.this.nationName)), new AnonymousClass1(TabHost.this, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$3, reason: invalid class name */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$3", f = "TabHost.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new AnonymousClass3(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: TabHost.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$3$1", f = "TabHost.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TabHost this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TabHost tabHost, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = tabHost;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    TabHost tabHost = this.this$0;
                    HiLog.INSTANCE.d("MediaBaseFragment", "notifyNodeAdapter type:1");
                    List list2 = (List) list.stream().distinct().collect(Collectors.toList());
                    HiLog.INSTANCE.d("MediaBaseFragment", "datas:" + list2);
                    Intrinsics.checkNotNullExpressionValue(list2, "datas");
                    List<String> list3 = list2;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (String str : list3) {
                        OnlineTypeOrLocal onlineTypeOrLocal = new OnlineTypeOrLocal();
                        Intrinsics.checkNotNullExpressionValue(str, "it");
                        onlineTypeOrLocal.setTitle(str);
                        onlineTypeOrLocal.setItemType(1);
                        arrayList.add(onlineTypeOrLocal);
                    }
                    List listCreateNodes = Node.Companion.createNodes(arrayList, OnLineTypesItem.class, tabHost.getMAdapter().getMData());
                    DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(tabHost.lastData, listCreateNodes), false);
                    Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…tData , newData) , false)");
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), tabHost.new AnonymousClass2(listCreateNodes, diffResultCalculateDiff, null), (Continuation) this) == coroutine_suspended) {
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
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(TabHost.this.getMediaDao().typesByCountryFlow(TabHost.this.nationName)), new AnonymousClass1(TabHost.this, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$4", f = "TabHost.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C00704 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00704(Continuation<? super C00704> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new C00704(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$updateList$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: TabHost.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/RadioSource;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$updateList$4$1", f = "TabHost.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<List<RadioSource>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TabHost this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TabHost tabHost, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = tabHost;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(List<RadioSource> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this.L$0;
                    this.label = 1;
                    if (this.this$0.notifyNodeAdapter(list, (Continuation) this) == coroutine_suspended) {
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
                if (FlowKt.collectLatest(TabHost.this.getMediaDao().getRadioFavorites(), new AnonymousClass1(TabHost.this, null), (Continuation) this) == coroutine_suspended) {
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

    private final Object notifyNodeAdapter(List<String> list, int i, Continuation<? super Unit> continuation) {
        OnlineTypeOrLocal onlineTypeOrLocal;
        Object obj;
        HiLog.INSTANCE.d("MediaBaseFragment", "notifyNodeAdapter type:" + i);
        List list2 = (List) list.stream().distinct().collect(Collectors.toList());
        HiLog.INSTANCE.d("MediaBaseFragment", "datas:" + list2);
        Intrinsics.checkNotNullExpressionValue(list2, "datas");
        List<String> list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (String str : list3) {
            if (i != 1) {
                if (i == 2) {
                    onlineTypeOrLocal = new OnlineTypeOrLocal();
                    Intrinsics.checkNotNullExpressionValue(str, "it");
                    onlineTypeOrLocal.setTitle(str);
                    onlineTypeOrLocal.setItemType(i);
                } else {
                    obj = new Object();
                }
                arrayList.add(obj);
            } else {
                onlineTypeOrLocal = new OnlineTypeOrLocal();
                Intrinsics.checkNotNullExpressionValue(str, "it");
                onlineTypeOrLocal.setTitle(str);
                onlineTypeOrLocal.setItemType(i);
            }
            obj = onlineTypeOrLocal;
            arrayList.add(obj);
        }
        List listCreateNodes = Node.Companion.createNodes(arrayList, OnLineTypesItem.class, getMAdapter().getMData());
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.lastData, listCreateNodes), false);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…tData , newData) , false)");
        CoroutineContext main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(listCreateNodes, diffResultCalculateDiff, null);
        InlineMarker.mark(0);
        BuildersKt.withContext(main, anonymousClass2, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$notifyNodeAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$notifyNodeAdapter$2", f = "TabHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Node<?>> $newData;
        final /* synthetic */ DiffUtil.DiffResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Node<?>> list, DiffUtil.DiffResult diffResult, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$newData = list;
            this.$result = diffResult;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new AnonymousClass2(this.$newData, this.$result, continuation);
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
            TabHost.this.lastData = this.$newData;
            TabHost.this.getMAdapter().replaceWithoutNotify(TabHost.this.lastData);
            this.$result.dispatchUpdatesTo((RecyclerView.Adapter) TabHost.this.getMAdapter());
            TabHost tabHost = TabHost.this;
            tabHost.ifListEmpty(tabHost.lastData.size());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object notifyNodeAdapter(List<RadioSource> list, Continuation<? super Unit> continuation) {
        List listCreateNodes = Node.Companion.createNodes(list, OnlineDetailItem.class, this.mAdapter.getMData());
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.lastData, listCreateNodes), false);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…tData , newData) , false)");
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(listCreateNodes, diffResultCalculateDiff, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.tab.TabHost$notifyNodeAdapter$4, reason: invalid class name */
    /* JADX INFO: compiled from: TabHost.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$notifyNodeAdapter$4", f = "TabHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Node<?>> $newData;
        final /* synthetic */ DiffUtil.DiffResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(List<Node<?>> list, DiffUtil.DiffResult diffResult, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$newData = list;
            this.$result = diffResult;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TabHost.this.new AnonymousClass4(this.$newData, this.$result, continuation);
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
            TabHost.this.lastData = this.$newData;
            TabHost.this.getMAdapter().replaceWithoutNotify(TabHost.this.lastData);
            this.$result.dispatchUpdatesTo((RecyclerView.Adapter) TabHost.this.getMAdapter());
            TabHost tabHost = TabHost.this;
            tabHost.ifListEmpty(tabHost.lastData.size());
            if (TabHost.this.lastData.size() == 0 && (audioProxy = TabHost.this.getAudioProxy()) != null) {
                MediaProxy.setupPlayList$default(audioProxy, new ConstraintList(null, new Constraint(), 1, null), null, 2, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void ifListEmpty(int count) {
        HiLog.INSTANCE.d(OnlineDetailFragment.TAG, "ifListEmpty count:" + count);
        ((OnlineTabHostFragmentBinding) getBinding()).onlineMainAudioEmpty.setVisibility(count == 0 ? 0 : 8);
    }
}
