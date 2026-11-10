package com.syu.media.radio.dialog;

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
import com.syu.media.databinding.RadioCitySelectorDialogFragBinding;
import com.syu.media.radio.items.RadioCitySelectorItem;
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
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: CitySelectorDialogFrag.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001f\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/syu/media/radio/dialog/CitySelectorDialogFrag;", "Lcom/syu/media/base/DataBindDialogBaseFragment;", "Lcom/syu/media/databinding/RadioCitySelectorDialogFragBinding;", "datas", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "(Ljava/util/List;)V", "job", "Lkotlinx/coroutines/Job;", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "mediaDao$delegate", "Lkotlin/Lazy;", "initData", FinalChip.BSP_PLATFORM_Null, "initObserve", "initView", "view", "Landroid/view/View;", "notifyNodeAdapter", "radios", FinalChip.BSP_PLATFORM_Null, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CitySelectorDialogFrag extends DataBindDialogBaseFragment<RadioCitySelectorDialogFragBinding> {
    public static final String TAG = "CountrySelectorDialogFragment";
    private final List<String> datas;
    private Job job;
    private final NodeAdapter mAdapter;

    /* JADX INFO: renamed from: mediaDao$delegate, reason: from kotlin metadata */
    private final Lazy mediaDao;

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initObserve() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CitySelectorDialogFrag(List<String> list) {
        super(R.layout.radio_city_selector_dialog_frag);
        Intrinsics.checkNotNullParameter(list, "datas");
        this.datas = list;
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mediaDao = LazyKt.lazy(new Function0<MediaDao>() { // from class: com.syu.media.radio.dialog.CitySelectorDialogFrag$mediaDao$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaDao m218invoke() {
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

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = getBinding().onlineDialogSelectorRecycler;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(requireContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(4);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
        this.mAdapter.setMTag(this);
        recyclerView.getResources().getDimension(R.dimen.online_seletordialog_item_space);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ConstraintLayout constraintLayout = getBinding().radioSelectorFrag;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.radioSelectorFrag");
        ViewExtKt.onClick$default(constraintLayout, 0L, new Function1<View, Unit>() { // from class: com.syu.media.radio.dialog.CitySelectorDialogFrag.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view2) {
                Intrinsics.checkNotNullParameter(view2, "it");
                CitySelectorDialogFrag.this.dismiss();
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: com.syu.media.radio.dialog.CitySelectorDialogFrag$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CitySelectorDialogFrag.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.dialog.CitySelectorDialogFrag$initData$1", f = "CitySelectorDialogFrag.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CitySelectorDialogFrag.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CitySelectorDialogFrag citySelectorDialogFrag = CitySelectorDialogFrag.this;
                this.label = 1;
                if (citySelectorDialogFrag.notifyNodeAdapter(citySelectorDialogFrag.datas, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HiLog.INSTANCE.d(CitySelectorDialogFrag.TAG, "localsFlow size:" + CitySelectorDialogFrag.this.datas.size());
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.base.DataBindDialogBaseFragment
    public void initData() {
        this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }

    @Override // com.syu.media.base.DataBindDialogBaseFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        super.onDestroyView();
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (isAdded()) {
            return;
        }
        show(manager, "onlineSelectorDialogFrag");
    }

    /* JADX INFO: renamed from: com.syu.media.radio.dialog.CitySelectorDialogFrag$notifyNodeAdapter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CitySelectorDialogFrag.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.dialog.CitySelectorDialogFrag$notifyNodeAdapter$2", f = "CitySelectorDialogFrag.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $radios;
        int label;
        final /* synthetic */ CitySelectorDialogFrag this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00722(List<String> list, CitySelectorDialogFrag citySelectorDialogFrag, Continuation<? super C00722> continuation) {
            super(2, continuation);
            this.$radios = list;
            this.this$0 = citySelectorDialogFrag;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00722(this.$radios, this.this$0, continuation);
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
            this.this$0.mAdapter.replace(Node.Companion.createNodes(this.$radios, RadioCitySelectorItem.class, this.this$0.mAdapter.getMData()));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object notifyNodeAdapter(List<String> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C00722(list, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
