package com.syu.media.btmusic.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextClock;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.bt.BluetoothModel;
import com.syu.media.MainAct;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.base.DataBindBaseFragment;
import com.syu.media.btmusic.audio.BtmusicAudioFocusChange;
import com.syu.media.companion.ext.ViewExtKt;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.Random;
import com.syu.media.companion.utils.TimeUtils;
import com.syu.media.companion.utils.TypeFaceUtils;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.databinding.BtmusicFragmentBinding;
import com.syu.media.provider.Media;
import com.syu.utils.BitmapUtils;
import com.syu.utils.Utils;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BtmusicFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020%H\u0016J\b\u0010/\u001a\u00020%H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/syu/media/btmusic/fragment/BtmusicFragment;", "Lcom/syu/media/base/DataBindBaseFragment;", "Lcom/syu/media/databinding/BtmusicFragmentBinding;", "()V", "albumPath", FinalChip.BSP_PLATFORM_Null, "albumPrefix", "autoManger", "Lcom/syu/manger/AutoManager;", "getAutoManger", "()Lcom/syu/manger/AutoManager;", "autoManger$delegate", "Lkotlin/Lazy;", "bPlayTime", FinalChip.BSP_PLATFORM_Null, "bTotalTime", "blurJob", "Lkotlinx/coroutines/Job;", "btConnect", FinalChip.BSP_PLATFORM_Null, "btModel", "Lcom/syu/manger/module/bt/BluetoothModel;", "getBtModel", "()Lcom/syu/manger/module/bt/BluetoothModel;", "btModel$delegate", "btmusicAudio", "Lcom/syu/media/btmusic/audio/BtmusicAudioFocusChange;", "getBtmusicAudio", "()Lcom/syu/media/btmusic/audio/BtmusicAudioFocusChange;", "btmusicAudio$delegate", "job", "nonce", "phoneXBy", FinalChip.BSP_PLATFORM_Null, "progressBar", "Landroid/widget/ProgressBar;", "albumChange", FinalChip.BSP_PLATFORM_Null, "btConnectTransition", "isConnect", "initObserve", "initView", "view", "Landroid/view/View;", "moveTaskToBack", "onDestroy", "onPaused", "onResumed", "updateProgress", "playTime", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BtmusicFragment extends DataBindBaseFragment<BtmusicFragmentBinding> {
    public static final long ANIM_DURATION = 1000;
    public static final int PHONE_BATTERY_COUNT = 5;
    public static final String TAG = "BtmusicFragment";
    private int bPlayTime;
    private int bTotalTime;
    private Job blurJob;
    private boolean btConnect;
    private Job job;
    private ProgressBar progressBar;

    /* JADX INFO: renamed from: autoManger$delegate, reason: from kotlin metadata */
    private final Lazy autoManger = LazyKt.lazy(new Function0<AutoManager>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$autoManger$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AutoManager m134invoke() {
            return AutoManager.INSTANCE.requestInstance();
        }
    });

    /* JADX INFO: renamed from: btmusicAudio$delegate, reason: from kotlin metadata */
    private final Lazy btmusicAudio = LazyKt.lazy(new Function0<BtmusicAudioFocusChange>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$btmusicAudio$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BtmusicAudioFocusChange m136invoke() {
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            return new BtmusicAudioFocusChange(contextRequireContext);
        }
    });

    /* JADX INFO: renamed from: btModel$delegate, reason: from kotlin metadata */
    private final Lazy btModel = LazyKt.lazy(new Function0<BluetoothModel>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$btModel$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BluetoothModel m135invoke() {
            ViewModel viewModel = MediaApp.INSTANCE.getMe().getViewModelProvider().get(BluetoothModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (BluetoothModel) viewModel;
        }
    });
    private float phoneXBy = 725.0f;
    private final String albumPrefix = Media.ALBUM;
    private int nonce = -1;
    private String albumPath = FinalChip.BSP_PLATFORM_Null;

    public static final /* synthetic */ BtmusicFragmentBinding access$getBinding(BtmusicFragment btmusicFragment) {
        return btmusicFragment.getBinding();
    }

    private final AutoManager getAutoManger() {
        return (AutoManager) this.autoManger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BtmusicAudioFocusChange getBtmusicAudio() {
        return (BtmusicAudioFocusChange) this.btmusicAudio.getValue();
    }

    private final BluetoothModel getBtModel() {
        return (BluetoothModel) this.btModel.getValue();
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        HiLog.INSTANCE.d(TAG, "onResumed");
        getBtmusicAudio().play();
    }

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
        HiLog.INSTANCE.d(TAG, "onPaused");
    }

    @Override // com.syu.media.base.BaseFragment
    public void moveTaskToBack() {
        if (isAdded() && btavAudio()) {
            getBtmusicAudio().pause();
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
        this.phoneXBy = getResources().getDimension(R.dimen.btmusic_bt_move_x);
        this.progressBar = getBinding().btmusicPlayProgressbar;
        TextClock textClock = getBinding().btmusicClock;
        Context context = getContext();
        textClock.setTypeface(context != null ? TypeFaceUtils.INSTANCE.getTypeFaceCompasse(context) : null);
        bkChanged(R.id.btmusic_frag_blur_img, getDrawable(R.drawable.btmusic_bk));
        getBinding().btmusicCtrPrev.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BtmusicFragment.m133initView$lambda1(this.f$0, view2);
            }
        });
        ImageView imageView = getBinding().btmusicCtrNext;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.btmusicCtrNext");
        ViewExtKt.onClick$default(imageView, 0L, new Function1<View, Unit>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment.initView.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view2) {
                Intrinsics.checkNotNullParameter(view2, "it");
                BtmusicFragment.this.getBtmusicAudio().next();
            }
        }, 1, null);
        ImageView imageView2 = getBinding().btmusicCtrPlayPause;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.btmusicCtrPlayPause");
        ViewExtKt.onClick$default(imageView2, 0L, new Function1<View, Unit>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment.initView.4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view2) {
                Intrinsics.checkNotNullParameter(view2, "it");
                BtmusicFragment.this.getBtmusicAudio().playPause();
            }
        }, 1, null);
        FaceMyingheiTextView faceMyingheiTextView = getBinding().btmusicDevices;
        Intrinsics.checkNotNullExpressionValue(faceMyingheiTextView, "binding.btmusicDevices");
        ViewExtKt.onClick$default(faceMyingheiTextView, 0L, new Function1<View, Unit>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment.initView.5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view2) {
                Intrinsics.checkNotNullParameter(view2, "it");
                MainAct mainActRequireMainAct = BtmusicFragment.this.requireMainAct();
                if (mainActRequireMainAct != null) {
                    mainActRequireMainAct.start(view2, "com.syu.bt");
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-1, reason: not valid java name */
    public static final void m133initView$lambda1(BtmusicFragment btmusicFragment, View view) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        btmusicFragment.getBtmusicAudio().prev();
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        getMainModel().getAccOn().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m132initObserve$lambda2(this.f$0, (Integer) obj);
            }
        });
        BluetoothModel btModel = getBtModel();
        btModel.getAlbum().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m125initObserve$lambda14$lambda3((String) obj);
            }
        });
        btModel.getTitle().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m126initObserve$lambda14$lambda4(this.f$0, (String) obj);
            }
        });
        btModel.getTrackChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m127initObserve$lambda14$lambda5(this.f$0, (Long) obj);
            }
        });
        btModel.getIconPath().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m128initObserve$lambda14$lambda6(this.f$0, (String) obj);
            }
        });
        btModel.getArtist().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m129initObserve$lambda14$lambda7(this.f$0, (String) obj);
            }
        });
        btModel.getPlayTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m130initObserve$lambda14$lambda8(this.f$0, (Integer) obj);
            }
        });
        btModel.getTotalTime().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m131initObserve$lambda14$lambda9(this.f$0, (Integer) obj);
            }
        });
        btModel.getConnectedDevName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m121initObserve$lambda14$lambda10(this.f$0, (String) obj);
            }
        });
        btModel.getBluetoothState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m122initObserve$lambda14$lambda11(this.f$0, (Integer) obj);
            }
        });
        btModel.getPhoneBattery().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m123initObserve$lambda14$lambda12(this.f$0, (String) obj);
            }
        });
        btModel.isBtAvPlaying().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BtmusicFragment.m124initObserve$lambda14$lambda13(this.f$0, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-2, reason: not valid java name */
    public static final void m132initObserve$lambda2(BtmusicFragment btmusicFragment, Integer num) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        if (btmusicFragment.btavAudio()) {
            if (num != null && num.intValue() == 0) {
                btmusicFragment.getBtmusicAudio().playPause();
            } else {
                if (num == null || num.intValue() != 1 || btmusicFragment.getBtmusicAudio().getPlaying()) {
                    return;
                }
                btmusicFragment.getBtmusicAudio().play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-3, reason: not valid java name */
    public static final void m125initObserve$lambda14$lambda3(String str) {
        HiLog.INSTANCE.d(TAG, "album:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-4, reason: not valid java name */
    public static final void m126initObserve$lambda14$lambda4(BtmusicFragment btmusicFragment, String str) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        if (!Utils.isEmptyStr(str)) {
            String str2 = str;
            btmusicFragment.getBinding().btmusicName.setText(str2);
            btmusicFragment.getBinding().btmusicBtPhoneName.setText(str2);
        } else {
            if (!Utils.isEmptyStr(str) || btmusicFragment.btConnect) {
                return;
            }
            btmusicFragment.getBinding().btmusicName.setText(R.string.song);
            btmusicFragment.getBinding().btmusicBtPhoneName.setText(R.string.song);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-5, reason: not valid java name */
    public static final void m127initObserve$lambda14$lambda5(BtmusicFragment btmusicFragment, Long l) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        if (btmusicFragment.albumPath.length() > 0) {
            btmusicFragment.albumChange(btmusicFragment.albumPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-6, reason: not valid java name */
    public static final void m128initObserve$lambda14$lambda6(BtmusicFragment btmusicFragment, String str) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "it");
        btmusicFragment.albumPath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-7, reason: not valid java name */
    public static final void m129initObserve$lambda14$lambda7(BtmusicFragment btmusicFragment, String str) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "btModel artist:" + str);
        if (!Utils.isEmptyStr(str)) {
            String str2 = str;
            btmusicFragment.getBinding().btmusicArtist.setText(str2);
            btmusicFragment.getBinding().btmusicBtPhoneArtist.setText(str2);
        } else {
            if (!Utils.isEmptyStr(str) || btmusicFragment.btConnect) {
                return;
            }
            btmusicFragment.getBinding().btmusicArtist.setText(R.string.artist);
            btmusicFragment.getBinding().btmusicBtPhoneArtist.setText(R.string.artist);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-8, reason: not valid java name */
    public static final void m130initObserve$lambda14$lambda8(BtmusicFragment btmusicFragment, Integer num) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        int i = btmusicFragment.bTotalTime;
        Intrinsics.checkNotNullExpressionValue(num, "it");
        int iMax = Math.max(0, Math.min(i, num.intValue()));
        btmusicFragment.bPlayTime = iMax;
        int i2 = btmusicFragment.bTotalTime;
        if (i2 > 0 && iMax > 0) {
            int i3 = (iMax * 1000) / i2;
            ProgressBar progressBar = btmusicFragment.progressBar;
            if (progressBar != null) {
                progressBar.setProgress(i3);
            }
        }
        btmusicFragment.updateProgress(btmusicFragment.bPlayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-9, reason: not valid java name */
    public static final void m131initObserve$lambda14$lambda9(BtmusicFragment btmusicFragment, Integer num) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        btmusicFragment.bTotalTime = num.intValue();
        btmusicFragment.getBinding().btmusicTotalTime.setText(TimeUtils.INSTANCE.msecToMinutes(btmusicFragment.bTotalTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-10, reason: not valid java name */
    public static final void m121initObserve$lambda14$lambda10(BtmusicFragment btmusicFragment, String str) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        btmusicFragment.getBinding().btmusicBtName.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-11, reason: not valid java name */
    public static final void m122initObserve$lambda14$lambda11(BtmusicFragment btmusicFragment, Integer num) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "btModel bluetoothState:" + num);
        if (num != null && num.intValue() == 2) {
            btmusicFragment.btConnect = true;
            btmusicFragment.getBinding().btmusicBtConnect.setText(btmusicFragment.getString(R.string.btmusic_bt_connected));
            btmusicFragment.btConnectTransition(true);
        } else if (num != null && num.intValue() == 0) {
            btmusicFragment.btConnect = false;
            btmusicFragment.getBinding().btmusicBtConnect.setText(btmusicFragment.getString(R.string.btmusic_bt_disconnected));
            btmusicFragment.btConnectTransition(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-12, reason: not valid java name */
    public static final void m123initObserve$lambda14$lambda12(BtmusicFragment btmusicFragment, String str) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        if (Utils.isEmptyStr(str)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str, "it");
        int i = Integer.parseInt(str);
        HiLog.INSTANCE.d(TAG, "battery:" + i);
        if (i > 0) {
            int i2 = (i * 100) / 5;
            HiLog.INSTANCE.d(TAG, "percent:" + i2);
            btmusicFragment.getBinding().btmusicPhoneBattery.setProgress(i2);
            btmusicFragment.getBinding().btmusicPhoneMiniBattery.setProgress(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-14$lambda-13, reason: not valid java name */
    public static final void m124initObserve$lambda14$lambda13(BtmusicFragment btmusicFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(btmusicFragment, "this$0");
        HiLog.INSTANCE.d(BtmusicAudioFocusChange.TAG, "playingChange:" + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            Integer value = btmusicFragment.getAutoManger().getMainModel().getAppId().getValue();
            if ((value != null && value.intValue() == 3) || !btmusicFragment.getVisible()) {
                return;
            }
            btmusicFragment.getBtmusicAudio().requestAudioFocus();
            btmusicFragment.getAutoManger().openAppId(3);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: BtmusicFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1", f = "BtmusicFragment.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $albumPath;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$albumPath = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = BtmusicFragment.this.new AnonymousClass1(this.$albumPath, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmapScaleBitmap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fMax = Math.max(BtmusicFragment.this.displayWidth(), BtmusicFragment.this.displayHeight());
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.$albumPath);
                if (bitmapDecodeFile == null || (bitmapScaleBitmap = BitmapUtils.INSTANCE.scaleBitmap(bitmapDecodeFile, fMax, fMax, true)) == null) {
                    BtmusicFragment btmusicFragment = BtmusicFragment.this;
                    btmusicFragment.nonce = Random.INSTANCE.random(1, 10, btmusicFragment.nonce);
                    Resources resources = btmusicFragment.getResources();
                    String str = btmusicFragment.albumPrefix + btmusicFragment.nonce;
                    Context context = btmusicFragment.getContext();
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(btmusicFragment.getResources(), resources.getIdentifier(str, "drawable", context != null ? context.getPackageName() : null));
                    BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "scale");
                    bitmapScaleBitmap = bitmapUtils.scaleBitmap(bitmapDecodeResource, fMax, fMax, true);
                }
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00111(BtmusicFragment.this, bitmapScaleBitmap, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BtmusicFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1$1", f = "BtmusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Bitmap $bitmap;
            int label;
            final /* synthetic */ BtmusicFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00111(BtmusicFragment btmusicFragment, Bitmap bitmap, Continuation<? super C00111> continuation) {
                super(2, continuation);
                this.this$0 = btmusicFragment;
                this.$bitmap = bitmap;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00111(this.this$0, this.$bitmap, continuation);
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
                BtmusicFragment.access$getBinding(this.this$0).btmusicLogoIcon.setImageBitmap(this.$bitmap);
                Job job = this.this$0.blurJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                BtmusicFragment btmusicFragment = this.this$0;
                btmusicFragment.blurJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(btmusicFragment), Dispatchers.getIO(), (CoroutineStart) null, new C00121(this.this$0, this.$bitmap, null), 2, (Object) null);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BtmusicFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "com.syu.media.btmusic.fragment.BtmusicFragment$albumChange$1$1$1", f = "BtmusicFragment.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
            static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Bitmap $bitmap;
                int label;
                final /* synthetic */ BtmusicFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00121(BtmusicFragment btmusicFragment, Bitmap bitmap, Continuation<? super C00121> continuation) {
                    super(2, continuation);
                    this.this$0 = btmusicFragment;
                    this.$bitmap = bitmap;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00121(this.this$0, this.$bitmap, continuation);
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
                    BtmusicFragment btmusicFragment = this.this$0;
                    Bitmap bitmap = this.$bitmap;
                    final BtmusicFragment btmusicFragment2 = this.this$0;
                    btmusicFragment.blurTransformation(bitmap, new Function1<Drawable, Unit>() { // from class: com.syu.media.btmusic.fragment.BtmusicFragment.albumChange.1.1.1.1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((Drawable) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Drawable drawable) {
                            Intrinsics.checkNotNullParameter(drawable, "it");
                            btmusicFragment2.bkChanged(R.id.btmusic_frag_blur_img, drawable);
                        }
                    });
                    return Unit.INSTANCE;
                }
            }
        }
    }

    private final void albumChange(String albumPath) {
        HiLog.INSTANCE.d(TAG, "albumChange album:" + albumPath);
        this.job = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(albumPath, null), 3, (Object) null);
    }

    private final void updateProgress(int playTime) {
        String string = getResources().getString(R.string.btmusic_play_time);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.btmusic_play_time)");
        String strMsecToMinutes = TimeUtils.INSTANCE.msecToMinutes(playTime);
        CompasseTextView compasseTextView = getBinding().btmusicPlayTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{strMsecToMinutes}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        compasseTextView.setText(str);
    }

    private final void btConnectTransition(boolean isConnect) {
        float f;
        float f2;
        if (getBinding().btmusicConstraintPhone.getVisibility() != 0) {
            return;
        }
        getBinding().btmusicBtName.setVisibility(toVisible2(isConnect));
        getBinding().btmusicConstraintLeft.setVisibility(toVisible(isConnect));
        getBinding().btmusicConstraintMusicInfo.setVisibility(toVisible(isConnect));
        getBinding().btmusicConstraintBattery.setVisibility(toVisible(isConnect));
        if (isConnect) {
            f = this.phoneXBy;
            f2 = 1.0f;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        getBinding().btmusicConstraintPhone.animate().translationX(f).setDuration(1000L).start();
        getBinding().btmusicConstraintLeft.animate().alpha(f2).setDuration(1000L).start();
        getBinding().btmusicConstraintMusicInfo.animate().alpha(f2).setDuration(1000L).start();
        getBinding().btmusicConstraintBattery.animate().alpha(f2).setDuration(1000L).start();
    }
}
