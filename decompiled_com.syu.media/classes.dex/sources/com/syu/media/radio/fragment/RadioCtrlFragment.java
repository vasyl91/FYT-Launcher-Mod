package com.syu.media.radio.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.manger.module.radio.Rang;
import com.syu.media.ConstantsKt;
import com.syu.media.MainAct;
import com.syu.media.R;
import com.syu.media.base.BaseFragment;
import com.syu.media.btmusic.fragment.BtmusicFragment;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.StringUtils;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.databinding.RadioCtrlFragmentBinding;
import com.syu.media.music.MusicModel;
import com.syu.media.provider.Media;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import com.syu.utils.BitmapUtils;
import com.syu.utils.Utils;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import qin.widgets.VernierRulerView;

/* JADX INFO: compiled from: RadioCtrlFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\fH\u0002J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/syu/media/radio/fragment/RadioCtrlFragment;", "Lcom/syu/media/radio/fragment/RadioBaseFragment;", "Lcom/syu/media/databinding/RadioCtrlFragmentBinding;", "()V", "albumPrefix", FinalChip.BSP_PLATFORM_Null, "blurJob", "Lkotlinx/coroutines/Job;", "iCity", "iFreq", FinalChip.BSP_PLATFORM_Null, "isFm", FinalChip.BSP_PLATFORM_Null, "isScan", "isSearch", "job", "loc", "nonce", "radioFragment", "Lcom/syu/media/radio/fragment/RadioFragment;", "scanDance", "Lcom/syu/media/radio/fragment/RadioCtrlFragment$ScanDance;", "stereo", "updateTitle", "Ljava/lang/Runnable;", "addClickListener", FinalChip.BSP_PLATFORM_Null, "view", "Landroid/view/View;", "albumChange", "bitmap", "Landroid/graphics/Bitmap;", "initObserve", "initView", "onDestroy", "scanUpdate", "flag", "updateFavorite", "favorite", "updateDb", "Companion", "ScanDance", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioCtrlFragment extends RadioBaseFragment<RadioCtrlFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String TAG;
    private static final Lazy<RadioCtrlFragment> me$delegate;
    private final String albumPrefix;
    private Job blurJob;
    private String iCity;
    private int iFreq;
    private boolean isFm;
    private boolean isScan;
    private boolean isSearch;
    private Job job;
    private boolean loc;
    private int nonce;
    private RadioFragment radioFragment;
    private ScanDance scanDance;
    private boolean stereo;
    private final Runnable updateTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RadioCtrlFragmentBinding access$getBinding(RadioCtrlFragment radioCtrlFragment) {
        return (RadioCtrlFragmentBinding) radioCtrlFragment.getBinding();
    }

    /* JADX INFO: compiled from: RadioCtrlFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/syu/media/radio/fragment/RadioCtrlFragment$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "getTAG", "()Ljava/lang/String;", "me", "Lcom/syu/media/radio/fragment/RadioCtrlFragment;", "getMe", "()Lcom/syu/media/radio/fragment/RadioCtrlFragment;", "me$delegate", "Lkotlin/Lazy;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RadioCtrlFragment getMe() {
            return (RadioCtrlFragment) RadioCtrlFragment.me$delegate.getValue();
        }

        public final String getTAG() {
            return RadioCtrlFragment.TAG;
        }
    }

    public RadioCtrlFragment() {
        super(R.layout.radio_ctrl_fragment);
        this.iCity = Radio.DEF_STR;
        this.updateTitle = new Runnable() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                RadioCtrlFragment.m289updateTitle$lambda0(this.f$0);
            }
        };
        this.nonce = -1;
        this.albumPrefix = Media.ONLINE_TABLE;
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        me$delegate = LazyKt.lazy(new Function0<RadioCtrlFragment>() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$Companion$me$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioCtrlFragment m290invoke() {
                return new RadioCtrlFragment();
            }
        });
        String simpleName = Reflection.getOrCreateKotlinClass(companion.getMe().getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TAG = simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateTitle$lambda-0, reason: not valid java name */
    public static final void m289updateTitle$lambda0(RadioCtrlFragment radioCtrlFragment) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        int i = radioCtrlFragment.iFreq;
        String str = radioCtrlFragment.iCity;
        HiLog.INSTANCE.d(TAG, "updateTitle city: " + str);
        radioCtrlFragment.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new RadioCtrlFragment$updateTitle$1$1(radioCtrlFragment, i, str, null), 3, (Object) null);
    }

    /* JADX INFO: compiled from: RadioCtrlFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/syu/media/radio/fragment/RadioCtrlFragment$ScanDance;", "Ljava/lang/Runnable;", "show", FinalChip.BSP_PLATFORM_Null, "(Lcom/syu/media/radio/fragment/RadioCtrlFragment;Z)V", "run", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ScanDance implements Runnable {
        private final boolean show;

        public ScanDance(boolean z) {
            this.show = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.show) {
                RadioCtrlFragment.access$getBinding(RadioCtrlFragment.this).radioCurrScan.setVisibility(0);
                RadioCtrlFragment.access$getBinding(RadioCtrlFragment.this).radioCurrScan.animate().alpha(1.0f).setDuration(300L).start();
                RadioCtrlFragment radioCtrlFragment = RadioCtrlFragment.this;
                radioCtrlFragment.scanDance = radioCtrlFragment.new ScanDance(false);
                Handler mh = RadioCtrlFragment.this.getMH();
                ScanDance scanDance = RadioCtrlFragment.this.scanDance;
                Intrinsics.checkNotNull(scanDance);
                mh.postDelayed(scanDance, 1100L);
                return;
            }
            RadioCtrlFragment.access$getBinding(RadioCtrlFragment.this).radioCurrScan.animate().alpha(0.0f).setDuration(300L).start();
            RadioCtrlFragment radioCtrlFragment2 = RadioCtrlFragment.this;
            radioCtrlFragment2.scanDance = radioCtrlFragment2.new ScanDance(true);
            Handler mh2 = RadioCtrlFragment.this.getMH();
            ScanDance scanDance2 = RadioCtrlFragment.this.scanDance;
            Intrinsics.checkNotNull(scanDance2);
            mh2.postDelayed(scanDance2, 1100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void albumChange(Bitmap bitmap) {
        HiLog.INSTANCE.d(BtmusicFragment.TAG, "albumChange");
        ((RadioCtrlFragmentBinding) getBinding()).radioAlbum.setImageBitmap(bitmap);
        Job job = this.blurJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(bitmap, this, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioCtrlFragment$albumChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: RadioCtrlFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.fragment.RadioCtrlFragment$albumChange$1", f = "RadioCtrlFragment.kt", i = {0}, l = {112}, m = "invokeSuspend", n = {"scaleBitmap"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        Object L$0;
        int label;
        final /* synthetic */ RadioCtrlFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, RadioCtrlFragment radioCtrlFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.this$0 = radioCtrlFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bitmap, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Bitmap bitmap2 = this.$bitmap;
                RadioCtrlFragment radioCtrlFragment = this.this$0;
                float fMax = Math.max(radioCtrlFragment.displayWidth(), radioCtrlFragment.displayHeight());
                Bitmap bitmapScaleBitmap = BitmapUtils.INSTANCE.scaleBitmap(radioCtrlFragment.copyBitmap(bitmap2), fMax, fMax, true);
                this.L$0 = bitmapScaleBitmap;
                this.label = 1;
                if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bitmap = bitmapScaleBitmap;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bitmap = (Bitmap) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            RadioCtrlFragment radioCtrlFragment2 = this.this$0;
            final RadioCtrlFragment radioCtrlFragment3 = this.this$0;
            radioCtrlFragment2.blurTransformation(bitmap, new Function1<Drawable, Unit>() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment.albumChange.1.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Drawable) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Drawable drawable) {
                    Intrinsics.checkNotNullParameter(drawable, "it");
                    MainAct mainActRequireMainAct = radioCtrlFragment3.requireMainAct();
                    if (mainActRequireMainAct != null) {
                        BaseFragment baseFragmentFindFragmentByAction = mainActRequireMainAct.findFragmentByAction("com.syu.radio");
                        if (baseFragmentFindFragmentByAction != null && (baseFragmentFindFragmentByAction instanceof RadioFragment)) {
                            ((RadioFragment) baseFragmentFindFragmentByAction).setBlurBk(drawable);
                        }
                        BaseFragment baseFragmentFindFragmentByAction2 = mainActRequireMainAct.findFragmentByAction(ConstantsKt.ACTION_PAGE_RADIO_SETTINGS);
                        if (baseFragmentFindFragmentByAction2 == null || !(baseFragmentFindFragmentByAction2 instanceof RadioSettingsFragment)) {
                            return;
                        }
                        ((RadioSettingsFragment) baseFragmentFindFragmentByAction2).setBlurBk(drawable);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
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
        super.onDestroy();
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            HiLog.INSTANCE.d(TAG, "parentFragment:" + parentFragment);
            if (parentFragment instanceof RadioFragment) {
                this.radioFragment = (RadioFragment) parentFragment;
            }
        }
        addClickListener(view);
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        RadioModel radioModel = getRadioModel();
        radioModel.getMRange().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m277initObserve$lambda18$lambda2(this.f$0, (Rang) obj);
            }
        });
        radioModel.getMArea().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m278initObserve$lambda18$lambda3((Integer) obj);
            }
        });
        radioModel.getMFreq().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m279initObserve$lambda18$lambda5(this.f$0, (Integer) obj);
            }
        });
        radioModel.getTaShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m281initObserve$lambda18$lambda6(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getAfShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m282initObserve$lambda18$lambda7(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getTpShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m283initObserve$lambda18$lambda8(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPsShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda25
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m284initObserve$lambda18$lambda9(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPsMsg().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda26
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m269initObserve$lambda18$lambda10(this.f$0, (String) obj);
            }
        });
        radioModel.getPtyShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda27
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m270initObserve$lambda18$lambda11(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPtyMsg().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda28
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m271initObserve$lambda18$lambda12(this.f$0, (String) obj);
            }
        });
        radioModel.getRdsShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m272initObserve$lambda18$lambda13(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getMLoc().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m273initObserve$lambda18$lambda14(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getMStereo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m274initObserve$lambda18$lambda15(this.f$0, (Integer) obj);
            }
        });
        radioModel.isSearching().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m275initObserve$lambda18$lambda16(this.f$0, (Boolean) obj);
            }
        });
        radioModel.isScanning().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m276initObserve$lambda18$lambda17(this.f$0, (Boolean) obj);
            }
        });
        MusicModel musicModel = getApp().getMusicModel();
        musicModel.getRadioFavorite().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m285initObserve$lambda21$lambda19(this.f$0, (Boolean) obj);
            }
        });
        musicModel.getRadioName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m286initObserve$lambda21$lambda20(this.f$0, (String) obj);
            }
        });
        getMainModel().getCity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m287initObserve$lambda22(this.f$0, (String) obj);
            }
        });
        getApp().getOnlineModel().getRadioCityName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioCtrlFragment.m288initObserve$lambda23(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-2, reason: not valid java name */
    public static final void m277initObserve$lambda18$lambda2(RadioCtrlFragment radioCtrlFragment, Rang rang) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "mRange min:" + rang.getMin() + " ,max:" + rang.getMax() + " ,step:" + rang.getStep());
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrRuler.setup(rang.getMin(), rang.getMax(), rang.getStep());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-3, reason: not valid java name */
    public static final void m278initObserve$lambda18$lambda3(Integer num) {
        HiLog.INSTANCE.e(TAG, "mArea area:" + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-5, reason: not valid java name */
    public static final void m279initObserve$lambda18$lambda5(final RadioCtrlFragment radioCtrlFragment, final Integer num) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "------------ >> freq : " + num);
        Intrinsics.checkNotNullExpressionValue(num, "it");
        radioCtrlFragment.iFreq = num.intValue();
        radioCtrlFragment.isFm = RadioUtils.INSTANCE.isFmFreq(radioCtrlFragment.iFreq);
        radioCtrlFragment.getMH().postDelayed(new Runnable() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RadioCtrlFragment.m280initObserve$lambda18$lambda5$lambda4(num, radioCtrlFragment);
            }
        }, 15L);
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrFreq.setText(RadioUtils.INSTANCE.freq2Text(radioCtrlFragment.iFreq));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrBand.setText(radioCtrlFragment.isFm ? "FM" : "AM");
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrUnit;
        if (faceMyingheiTextView != null) {
            faceMyingheiTextView.setText(radioCtrlFragment.isFm ? "MHz" : "KHz");
        }
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrSt.setVisibility(radioCtrlFragment.toVisible(radioCtrlFragment.isFm ? radioCtrlFragment.stereo : false));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrLoc.setVisibility(radioCtrlFragment.toVisible(radioCtrlFragment.isFm ? radioCtrlFragment.loc : false));
        radioCtrlFragment.getMH().removeCallbacks(radioCtrlFragment.updateTitle);
        radioCtrlFragment.getMH().postDelayed(radioCtrlFragment.updateTitle, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-5$lambda-4, reason: not valid java name */
    public static final void m280initObserve$lambda18$lambda5$lambda4(Integer num, RadioCtrlFragment radioCtrlFragment) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "------------ >> freq11 : " + num + " ," + ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrRuler);
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrRuler.updateTick(radioCtrlFragment.iFreq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-6, reason: not valid java name */
    public static final void m281initObserve$lambda18$lambda6(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "taShowing:" + bool);
        if (!radioCtrlFragment.radioAudio() && radioCtrlFragment.getRadioAudio().requestAudioFocus()) {
            radioCtrlFragment.openAppId(1);
        }
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrTa;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        faceMyingheiTextView.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-7, reason: not valid java name */
    public static final void m282initObserve$lambda18$lambda7(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "afShowing:" + bool);
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrAf;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        faceMyingheiTextView.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-8, reason: not valid java name */
    public static final void m283initObserve$lambda18$lambda8(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrTp;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        faceMyingheiTextView.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-9, reason: not valid java name */
    public static final void m284initObserve$lambda18$lambda9(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "psShowing:" + bool);
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrPs;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        faceMyingheiTextView.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-10, reason: not valid java name */
    public static final void m269initObserve$lambda18$lambda10(RadioCtrlFragment radioCtrlFragment, String str) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "psMsg:" + str);
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrPs.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-11, reason: not valid java name */
    public static final void m270initObserve$lambda18$lambda11(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        ImageView imageView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrPty;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        imageView.setVisibility(radioCtrlFragment.toVisible2(bool.booleanValue()));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrPty.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrRdsEnable.setSelected(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-12, reason: not valid java name */
    public static final void m271initObserve$lambda18$lambda12(RadioCtrlFragment radioCtrlFragment, String str) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrPty.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-13, reason: not valid java name */
    public static final void m272initObserve$lambda18$lambda13(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "rdsShowing: " + bool);
        FaceMyingheiTextView faceMyingheiTextView = ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrRds;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        faceMyingheiTextView.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrTa.setVisibility(radioCtrlFragment.toVisible2(bool.booleanValue()));
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCtrAf.setVisibility(radioCtrlFragment.toVisible2(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-14, reason: not valid java name */
    public static final void m273initObserve$lambda18$lambda14(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "mLoc: " + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        radioCtrlFragment.loc = bool.booleanValue();
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrLoc.setVisibility(radioCtrlFragment.toVisible(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-15, reason: not valid java name */
    public static final void m274initObserve$lambda18$lambda15(RadioCtrlFragment radioCtrlFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "mStereo: " + num);
        boolean z = true;
        if (num != null && num.intValue() == 1) {
            ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrSt.setText("ST");
        } else if (num != null && num.intValue() == 2) {
            ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrSt.setText("MONO");
        }
        if (num != null && num.intValue() == 0) {
            z = false;
        }
        radioCtrlFragment.stereo = z;
        ((RadioCtrlFragmentBinding) radioCtrlFragment.getBinding()).radioCurrSt.setVisibility(radioCtrlFragment.toVisible(radioCtrlFragment.stereo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-16, reason: not valid java name */
    public static final void m275initObserve$lambda18$lambda16(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "isSearching: " + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        radioCtrlFragment.isSearch = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18$lambda-17, reason: not valid java name */
    public static final void m276initObserve$lambda18$lambda17(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "isScanning: " + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        radioCtrlFragment.isScan = bool.booleanValue();
        radioCtrlFragment.scanUpdate(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-21$lambda-19, reason: not valid java name */
    public static final void m285initObserve$lambda21$lambda19(RadioCtrlFragment radioCtrlFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        updateFavorite$default(radioCtrlFragment, bool.booleanValue(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-21$lambda-20, reason: not valid java name */
    public static final void m286initObserve$lambda21$lambda20(RadioCtrlFragment radioCtrlFragment, String str) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioName: " + str);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        radioCtrlFragment.getMH().removeCallbacks(radioCtrlFragment.updateTitle);
        radioCtrlFragment.getMH().post(radioCtrlFragment.updateTitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-22, reason: not valid java name */
    public static final void m287initObserve$lambda22(RadioCtrlFragment radioCtrlFragment, String str) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "observe city: " + str);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
            StringUtils stringUtils = StringUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str, "it");
            boolean zIsChineseByReg = stringUtils.isChineseByReg(str);
            if (!propForBoolean || !zIsChineseByReg) {
                radioCtrlFragment.iCity = str;
            }
        }
        radioCtrlFragment.getMH().removeCallbacks(radioCtrlFragment.updateTitle);
        radioCtrlFragment.getMH().postDelayed(radioCtrlFragment.updateTitle, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-23, reason: not valid java name */
    public static final void m288initObserve$lambda23(RadioCtrlFragment radioCtrlFragment, String str) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        radioCtrlFragment.getMH().post(radioCtrlFragment.updateTitle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void scanUpdate(boolean flag) {
        ScanDance scanDance = this.scanDance;
        if (scanDance != null) {
            getMH().removeCallbacks(scanDance);
        }
        if (flag) {
            this.scanDance = new ScanDance(true);
            Handler mh = getMH();
            ScanDance scanDance2 = this.scanDance;
            Intrinsics.checkNotNull(scanDance2);
            mh.post(scanDance2);
            return;
        }
        ((RadioCtrlFragmentBinding) getBinding()).radioCurrScan.setVisibility(4);
    }

    static /* synthetic */ void updateFavorite$default(RadioCtrlFragment radioCtrlFragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        radioCtrlFragment.updateFavorite(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateFavorite(boolean favorite, boolean updateDb) {
        HiLog.INSTANCE.d(TAG, "updateFavorite: " + favorite);
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrFavorite.setChecked(favorite);
        if (updateDb) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00731(favorite, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioCtrlFragment$updateFavorite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RadioCtrlFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.fragment.RadioCtrlFragment$updateFavorite$1", f = "RadioCtrlFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $favorite;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00731(boolean z, Continuation<? super C00731> continuation) {
            super(2, continuation);
            this.$favorite = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RadioCtrlFragment.this.new C00731(this.$favorite, continuation);
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
            RadioStation radioStationFindStationByFreqAndCity = RadioCtrlFragment.this.getRadioDao().findStationByFreqAndCity(RadioCtrlFragment.this.iFreq, RadioCtrlFragment.this.iCity);
            if (radioStationFindStationByFreqAndCity == null) {
                radioStationFindStationByFreqAndCity = new RadioStation();
                RadioCtrlFragment radioCtrlFragment = RadioCtrlFragment.this;
                if (radioCtrlFragment.iCity.length() > 0) {
                    radioStationFindStationByFreqAndCity.setCity(radioCtrlFragment.iCity);
                }
                radioStationFindStationByFreqAndCity.setFreq(Boxing.boxInt(radioCtrlFragment.iFreq));
            }
            radioStationFindStationByFreqAndCity.setFavorite(this.$favorite);
            if (radioStationFindStationByFreqAndCity.getId() == null) {
                if (radioStationFindStationByFreqAndCity.getFavorite()) {
                    RadioCtrlFragment.this.getRadioDao().insert(radioStationFindStationByFreqAndCity);
                }
            } else if (!radioStationFindStationByFreqAndCity.getFavorite() && TextUtils.isEmpty(radioStationFindStationByFreqAndCity.getTitle())) {
                RadioCtrlFragment.this.getRadioDao().delete(radioStationFindStationByFreqAndCity);
            } else {
                RadioCtrlFragment.this.getRadioDao().update(radioStationFindStationByFreqAndCity);
            }
            HiLog.INSTANCE.d(RadioCtrlFragment.INSTANCE.getTAG(), "station: " + radioStationFindStationByFreqAndCity);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addClickListener(View view) {
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrScan.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m254addClickListener$lambda25(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrScan.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return RadioCtrlFragment.m255addClickListener$lambda26(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrBand.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m256addClickListener$lambda27(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrLoc.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m257addClickListener$lambda28(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrSt.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m258addClickListener$lambda29(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrTa.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m259addClickListener$lambda30(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrAf.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m260addClickListener$lambda31(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrSave.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m261addClickListener$lambda32(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RadioCtrlFragment.m262addClickListener$lambda33(this.f$0, compoundButton, z);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrSettings.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m263addClickListener$lambda34(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrPrev.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m264addClickListener$lambda35(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrPrev.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return RadioCtrlFragment.m265addClickListener$lambda36(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrNext.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return RadioCtrlFragment.m266addClickListener$lambda37(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrNext.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m267addClickListener$lambda38(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrPty.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RadioCtrlFragment.m268addClickListener$lambda39(this.f$0, view2);
            }
        });
        ((RadioCtrlFragmentBinding) getBinding()).radioCtrRuler.setOnTickChangedListener(new VernierRulerView.OnTickChangedListener() { // from class: com.syu.media.radio.fragment.RadioCtrlFragment.addClickListener.16
            public void onTickChanged(int tick) {
                RadioFragment radioFragment = RadioCtrlFragment.this.radioFragment;
                if (radioFragment != null) {
                    radioFragment.openRadioAudio();
                }
                HiLog.INSTANCE.e(RadioCtrlFragment.INSTANCE.getTAG(), "onTickChanged tick: " + tick);
                RadioController radioController = RadioCtrlFragment.this.getRadioController();
                if (radioController != null) {
                    radioController.toFreq(tick);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-25, reason: not valid java name */
    public static final void m254addClickListener$lambda25(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrScan onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        boolean z = false;
        if (radioFragment != null && radioFragment.getAllowScan()) {
            z = true;
        }
        if (z) {
            RadioFragment radioFragment2 = radioCtrlFragment.radioFragment;
            if (radioFragment2 != null) {
                radioFragment2.openRadioAudio();
            }
            RadioController radioController = radioCtrlFragment.getRadioController();
            if (radioController != null) {
                radioController.scanStation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-26, reason: not valid java name */
    public static final boolean m255addClickListener$lambda26(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrScan onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        boolean z = false;
        if (radioFragment != null && radioFragment.getAllowScan()) {
            z = true;
        }
        if (z) {
            RadioFragment radioFragment2 = radioCtrlFragment.radioFragment;
            if (radioFragment2 != null) {
                radioFragment2.openRadioAudio();
            }
            RadioController radioController = radioCtrlFragment.getRadioController();
            if (radioController != null) {
                radioController.searchStation();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-27, reason: not valid java name */
    public static final void m256addClickListener$lambda27(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrBand onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.switchFmOrAm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-28, reason: not valid java name */
    public static final void m257addClickListener$lambda28(RadioCtrlFragment radioCtrlFragment, View view) {
        RadioController radioController;
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrLoc onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        if (!radioCtrlFragment.isFm || (radioController = radioCtrlFragment.getRadioController()) == null) {
            return;
        }
        radioController.local(!Intrinsics.areEqual(radioCtrlFragment.getRadioModel().getMLoc().getValue(), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-29, reason: not valid java name */
    public static final void m258addClickListener$lambda29(RadioCtrlFragment radioCtrlFragment, View view) {
        RadioController radioController;
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrSt onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        if (!radioCtrlFragment.isFm || (radioController = radioCtrlFragment.getRadioController()) == null) {
            return;
        }
        Integer value = radioCtrlFragment.getRadioModel().getMStereo().getValue();
        radioController.stereo(value != null && value.intValue() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-30, reason: not valid java name */
    public static final void m259addClickListener$lambda30(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrTa onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.rdsTaEanble(!Intrinsics.areEqual(radioCtrlFragment.getRadioModel().getRdsTaEnable().getValue(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-31, reason: not valid java name */
    public static final void m260addClickListener$lambda31(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "rdsAfEnable:" + radioCtrlFragment.getRadioModel().getRdsAfEnable().getValue());
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.rdsAfEanble(!Intrinsics.areEqual(radioCtrlFragment.getRadioModel().getRdsAfEnable().getValue(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-32, reason: not valid java name */
    public static final void m261addClickListener$lambda32(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrSave onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-33, reason: not valid java name */
    public static final void m262addClickListener$lambda33(RadioCtrlFragment radioCtrlFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrFavorite isChecked: " + z);
        radioCtrlFragment.updateFavorite(z, true);
        if (radioCtrlFragment.isScan || radioCtrlFragment.isSearch) {
            return;
        }
        radioCtrlFragment.getApp().getMusicModel().getRadioFavoriteStation().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-34, reason: not valid java name */
    public static final void m263addClickListener$lambda34(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "onStartPage onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        radioCtrlFragment.onStartPage(ConstantsKt.ACTION_PAGE_RADIO_SETTINGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-35, reason: not valid java name */
    public static final void m264addClickListener$lambda35(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrPrev onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.freqDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-36, reason: not valid java name */
    public static final boolean m265addClickListener$lambda36(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrPrev onLongClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.seekPrevStation();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-37, reason: not valid java name */
    public static final boolean m266addClickListener$lambda37(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrNext onLongClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.seekNextStation();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-38, reason: not valid java name */
    public static final void m267addClickListener$lambda38(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioCtrNext onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        RadioController radioController = radioCtrlFragment.getRadioController();
        if (radioController != null) {
            radioController.freqUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-39, reason: not valid java name */
    public static final void m268addClickListener$lambda39(RadioCtrlFragment radioCtrlFragment, View view) {
        Intrinsics.checkNotNullParameter(radioCtrlFragment, "this$0");
        HiLog.INSTANCE.e(TAG, "radioCtrPty onClick");
        RadioFragment radioFragment = radioCtrlFragment.radioFragment;
        if (radioFragment != null) {
            radioFragment.openRadioAudio();
        }
        PtySelectFragment.INSTANCE.getMe().show(radioCtrlFragment.getParentFragmentManager(), "pty_dialog");
    }
}
