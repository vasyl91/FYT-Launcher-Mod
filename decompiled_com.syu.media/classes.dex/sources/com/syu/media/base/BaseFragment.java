package com.syu.media.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import chip.FinalChip;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.syu.manger.AutoManager;
import com.syu.manger.module.main.MainModel;
import com.syu.media.MainAct;
import com.syu.media.MediaApp;
import com.syu.media.btmusic.fragment.BlurImgFragment;
import com.syu.media.companion.car.CarState;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.SharedPrefUtils;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\"\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\"J\u0006\u0010#\u001a\u00020\u0014J\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010&\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020 J\u000e\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u001cJ\u0012\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u001cJ;\u00100\u001a\u00020\u001a\"\u0004\b\u0000\u001012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002H12\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u00020\u001a0\"H\u0086\bø\u0001\u0000¢\u0006\u0002\u00106J\u0010\u00107\u001a\u0004\u0018\u00010\u001e2\u0006\u0010(\u001a\u00020\u001cJ\b\u00108\u001a\u00020\u001aH\u0016J\u0006\u00109\u001a\u00020\u0014J\b\u0010:\u001a\u00020\u001aH\u0016J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0014H\u0016J\b\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\u001aH\u0016J\b\u0010?\u001a\u00020\u001aH\u0016J\b\u0010@\u001a\u00020\u001aH\u0016J\u000e\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u000203J\u0006\u0010C\u001a\u00020\u0014J\u000e\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020\u0014J\b\u0010G\u001a\u0004\u0018\u00010HJ\u0016\u0010I\u001a\u00020\u001a2\u0006\u00102\u001a\u0002032\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u0014J\u000e\u0010N\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u0014R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006P"}, d2 = {"Lcom/syu/media/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "app", "Lcom/syu/media/MediaApp;", "getApp", "()Lcom/syu/media/MediaApp;", "app$delegate", "Lkotlin/Lazy;", "mH", "Landroid/os/Handler;", "getMH", "()Landroid/os/Handler;", "mH$delegate", "mainModel", "Lcom/syu/manger/module/main/MainModel;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel$delegate", "visible", FinalChip.BSP_PLATFORM_Null, "getVisible", "()Z", "setVisible", "(Z)V", "bkChanged", FinalChip.BSP_PLATFORM_Null, "resid", FinalChip.BSP_PLATFORM_Null, "b", "Landroid/graphics/drawable/Drawable;", "blurTransformation", "Landroid/graphics/Bitmap;", "callback", "Lkotlin/Function1;", "btavAudio", "carState", "Lcom/syu/media/companion/car/CarState;", "copyBitmap", "decodeResource", "resId", "dispatchResume", "show", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "displayHeight", "displayWidth", "getData", ExifInterface.GPS_DIRECTION_TRUE, "key", FinalChip.BSP_PLATFORM_Null, "defaultValue", "data", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getDrawable", "moveTaskToBack", "musicAudio", "onDestroy", "onHiddenChanged", "hidden", "onPause", "onPaused", "onResume", "onResumed", "onStartPage", "action", "onlineAudio", "openAppId", "appId", "radioAudio", "requireMainAct", "Lcom/syu/media/MainAct;", "saveData", "value", FinalChip.BSP_PLATFORM_Null, "toVisible", "enable", "toVisible2", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseFragment extends Fragment {
    public static final long BLUR_SHOW_DELAY = 1000;
    private static final String TAG = "BaseFragment";

    /* JADX INFO: renamed from: app$delegate, reason: from kotlin metadata */
    private final Lazy app = LazyKt.lazy(new Function0<MediaApp>() { // from class: com.syu.media.base.BaseFragment$app$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaApp m103invoke() {
            return MediaApp.INSTANCE.getMe();
        }
    });

    /* JADX INFO: renamed from: mainModel$delegate, reason: from kotlin metadata */
    private final Lazy mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.base.BaseFragment$mainModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MainModel m105invoke() {
            return this.this$0.getApp().getMainModel();
        }
    });
    private boolean visible = true;

    /* JADX INFO: renamed from: mH$delegate, reason: from kotlin metadata */
    private final Lazy mH = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.media.base.BaseFragment$mH$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m104invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return false;
    }

    public void moveTaskToBack() {
    }

    public void onPaused() {
    }

    public void onResumed() {
    }

    public final int toVisible(boolean enable) {
        return enable ? 0 : 4;
    }

    public final int toVisible2(boolean enable) {
        return enable ? 0 : 8;
    }

    public final MediaApp getApp() {
        return (MediaApp) this.app.getValue();
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }

    public final Handler getMH() {
        return (Handler) this.mH.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onResume " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "  ,visible:" + this.visible);
        dispatchResume(this.visible);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onHiddenChanged " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "  ,hidden:" + hidden);
        boolean z = !hidden;
        this.visible = z;
        dispatchResume(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onPause " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "  ,visible:" + this.visible);
        onPaused();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onDestroy " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "  ,visible:" + this.visible);
        this.visible = true;
        super.onDestroy();
    }

    public final MainAct requireMainAct() {
        if (isAdded()) {
            return (MainAct) requireActivity();
        }
        return null;
    }

    public final void onStartPage(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        MainAct mainActRequireMainAct = requireMainAct();
        if (mainActRequireMainAct != null) {
            mainActRequireMainAct.onStartPage(action);
        }
    }

    public final void openAppId(int appId) {
        AutoManager.INSTANCE.requestInstance().openAppId(appId);
    }

    public final void saveData(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPrefUtils sharedPrefUtils = SharedPrefUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        sharedPrefUtils.setParam(contextRequireContext, key, value);
    }

    public final <T> void getData(String key, T defaultValue, Function1<? super T, Unit> data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        SharedPrefUtils sharedPrefUtils = SharedPrefUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        data.invoke(sharedPrefUtils.getParam(contextRequireContext, key, defaultValue));
    }

    static /* synthetic */ void dispatchResume$default(BaseFragment baseFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchResume");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        baseFragment.dispatchResume(z);
    }

    private final void dispatchResume(boolean show) {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "dispatchResume " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "  ,show:" + show);
        if (show) {
            onResumed();
        } else {
            onPaused();
        }
    }

    public final void blurTransformation(Bitmap b, final Function1<? super Drawable, Unit> callback) {
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context context = getContext();
        if (context != null) {
            Glide.with(context).asDrawable().load(b).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new BlurTransformation(25, 5))).into(new CustomTarget<Drawable>() { // from class: com.syu.media.base.BaseFragment$blurTransformation$1$1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(Drawable r, Transition<? super Drawable> t) {
                    Intrinsics.checkNotNullParameter(r, "r");
                    r.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
                    callback.invoke(r);
                }
            });
        }
    }

    public final void bkChanged(int resid, Drawable b) {
        MainAct mainActRequireMainAct = requireMainAct();
        if (mainActRequireMainAct != null) {
            BaseAct.replaceFragment$default(mainActRequireMainAct, resid, new BlurImgFragment(b), null, 4, null);
        }
    }

    public final CarState carState() {
        MainAct mainActRequireMainAct = requireMainAct();
        if (mainActRequireMainAct != null) {
            return mainActRequireMainAct.getCarState();
        }
        return null;
    }

    public final boolean btavAudio() {
        Integer value = getMainModel().getAppId().getValue();
        return value != null && value.intValue() == 3;
    }

    public final boolean radioAudio() {
        Integer value = getMainModel().getAppId().getValue();
        return value != null && value.intValue() == 1;
    }

    public final boolean musicAudio() {
        Integer value = getMainModel().getAppId().getValue();
        return value != null && value.intValue() == 8;
    }

    public final boolean onlineAudio() {
        Integer value = getMainModel().getAppId().getValue();
        return value != null && value.intValue() == 7;
    }

    public final Bitmap decodeResource(int resId) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), resId);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(resources, resId)");
        return bitmapDecodeResource;
    }

    public final Drawable getDrawable(int resId) {
        return ResourcesCompat.getDrawable(getResources(), resId, null);
    }

    public final int displayWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public final int displayHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public final Bitmap copyBitmap(Bitmap b) {
        Intrinsics.checkNotNullParameter(b, "b");
        Bitmap bitmapCopy = b.copy(Bitmap.Config.RGB_565, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCopy, "b.copy(Bitmap.Config.RGB_565, true)");
        return bitmapCopy;
    }
}
