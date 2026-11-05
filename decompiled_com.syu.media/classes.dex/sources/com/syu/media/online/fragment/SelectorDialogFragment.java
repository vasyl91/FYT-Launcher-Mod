package com.syu.media.online.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.base.DataBindDialogBaseFragment;
import com.syu.media.companion.ext.ViewExtKt;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.dao.MediaDao;
import com.syu.media.databinding.OnlineSelectorDialogFragBinding;
import com.syu.media.online.item.OnlineSelectorItem;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: SelectorDialogFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001f\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/syu/media/online/fragment/SelectorDialogFragment;", "Lcom/syu/media/base/DataBindDialogBaseFragment;", "Lcom/syu/media/databinding/OnlineSelectorDialogFragBinding;", "()V", "job", "Lkotlinx/coroutines/Job;", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "mediaDao$delegate", "Lkotlin/Lazy;", "initData", FinalChip.BSP_PLATFORM_Null, "initObserve", "initView", "view", "Landroid/view/View;", "notifyNodeAdapter", "radios", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectorDialogFragment extends DataBindDialogBaseFragment<OnlineSelectorDialogFragBinding> {
    public static final String TAG = "SelectorFragment";
    private Job job;
    private final NodeAdapter mAdapter;

    /* JADX INFO: renamed from: mediaDao$delegate, reason: from kotlin metadata */
    private final Lazy mediaDao;

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initObserve() {
    }

    public SelectorDialogFragment() {
        super(R.layout.online_selector_dialog_frag);
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mediaDao = LazyKt.lazy(new Function0<MediaDao>() { // from class: com.syu.media.online.fragment.SelectorDialogFragment$mediaDao$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaDao m208invoke() {
                return MediaApp.INSTANCE.getMe().getMediaModel().getMediaDao();
            }
        });
    }

    public final MediaDao getMediaDao() {
        return (MediaDao) this.mediaDao.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        setStyle(2, R.style.RadioEditorDialog);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
        window.setWindowAnimations(R.style.RadioEditorDialog);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = getBinding().onlineDialogSelectorRecycler;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(requireContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setJustifyContent(4);
        flexboxLayoutManager.setAlignItems(3);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
        this.mAdapter.setMTag(this);
        recyclerView.getResources().getDimension(R.dimen.online_seletordialog_item_space);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ConstraintLayout constraintLayout = getBinding().onlineSelectorFrag;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.onlineSelectorFrag");
        ViewExtKt.onClick$default(constraintLayout, 0L, new Function1<View, Unit>() { // from class: com.syu.media.online.fragment.SelectorDialogFragment.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view2) {
                Intrinsics.checkNotNullParameter(view2, "it");
                SelectorDialogFragment.this.dismiss();
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.SelectorDialogFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectorDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.SelectorDialogFragment$initData$1", f = "SelectorDialogFragment.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SelectorDialogFragment.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.syu.media.online.fragment.SelectorDialogFragment$initData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SelectorDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.online.fragment.SelectorDialogFragment$initData$1$1", f = "SelectorDialogFragment.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
        static final class C00221 extends SuspendLambda implements Function2<List<String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SelectorDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00221(SelectorDialogFragment selectorDialogFragment, Continuation<? super C00221> continuation) {
                super(2, continuation);
                this.this$0 = selectorDialogFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00221 = new C00221(this.this$0, continuation);
                c00221.L$0 = obj;
                return c00221;
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
                    HiLog.INSTANCE.d(SelectorDialogFragment.TAG, "localsFlow size:" + list.size());
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
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(SelectorDialogFragment.this.getMediaDao().countriesFlow()), new C00221(SelectorDialogFragment.this, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initData() {
        this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        super.onDestroy();
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (isAdded()) {
            return;
        }
        show(manager, "onlineSelectorDialogFrag");
    }

    /* JADX INFO: renamed from: com.syu.media.online.fragment.SelectorDialogFragment$notifyNodeAdapter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectorDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.fragment.SelectorDialogFragment$notifyNodeAdapter$2", f = "SelectorDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00682 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $radios;
        int label;
        final /* synthetic */ SelectorDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00682(List<String> list, SelectorDialogFragment selectorDialogFragment, Continuation<? super C00682> continuation) {
            super(2, continuation);
            this.$radios = list;
            this.this$0 = selectorDialogFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00682(this.$radios, this.this$0, continuation);
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
            this.this$0.mAdapter.replace(Node.Companion.createNodes(this.$radios, OnlineSelectorItem.class, this.this$0.mAdapter.getMData()));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object notifyNodeAdapter(List<String> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C00682(list, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
