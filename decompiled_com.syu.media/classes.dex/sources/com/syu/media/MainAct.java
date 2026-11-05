package com.syu.media;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.base.BaseAct;
import com.syu.media.base.BaseFragment;
import com.syu.media.base.DataBindBaseFragment;
import com.syu.media.btmusic.fragment.BtmusicFragment;
import com.syu.media.companion.car.CarState;
import com.syu.media.companion.receiver.Receiver;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.MediaToast;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.databinding.ActMainBinding;
import com.syu.media.music.MusicStatic;
import com.syu.media.music.fragment.MusicFragment;
import com.syu.media.music.fragment.MusicMainFragment;
import com.syu.media.online.fragment.OnlineDetailFragment;
import com.syu.media.online.fragment.OnlineFragment;
import com.syu.media.radio.fragment.RadioFragment;
import com.syu.media.radio.fragment.RadioSettingsFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainAct.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u0004\u0018\u00010\u00182\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0004\u0018\u00010\u00192\u0006\u0010-\u001a\u00020\u0018J\b\u00103\u001a\u00020,H\u0002J\b\u00104\u001a\u00020,H\u0002J\u0006\u00105\u001a\u00020,J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000201H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0012H\u0016J\u0012\u0010;\u001a\u00020,2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020,H\u0014J\u001c\u0010?\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00182\n\b\u0002\u0010@\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u0019H\u0002J\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010.H\u0014J\b\u0010E\u001a\u00020,H\u0014J\u0010\u0010F\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0014J\b\u0010G\u001a\u00020,H\u0014J\u0018\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0018J\u000e\u0010M\u001a\u00020,2\u0006\u0010@\u001a\u00020*J\b\u0010N\u001a\u00020,H\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u000201H\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/syu/media/MainAct;", "Lcom/syu/media/base/BaseAct;", "()V", "audioProxy", "Lcom/syu/media/MediaProxy;", "getAudioProxy", "()Lcom/syu/media/MediaProxy;", "audioProxy$delegate", "Lkotlin/Lazy;", "binding", "Lcom/syu/media/databinding/ActMainBinding;", "carState", "Lcom/syu/media/companion/car/CarState;", "getCarState", "()Lcom/syu/media/companion/car/CarState;", "setCarState", "(Lcom/syu/media/companion/car/CarState;)V", "config", "Landroid/content/res/Configuration;", "getConfig", "()Landroid/content/res/Configuration;", "config$delegate", "fragments", "Ljava/util/HashMap;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/base/BaseFragment;", "Lkotlin/collections/HashMap;", "latestFragment", "latestMsec", FinalChip.BSP_PLATFORM_Null, "mBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getMBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "mBackPressedCallback$delegate", "mH", "Landroid/os/Handler;", "getMH", "()Landroid/os/Handler;", "mH$delegate", "tabs", FinalChip.BSP_PLATFORM_Null, "Landroid/view/View;", "actionToTab", FinalChip.BSP_PLATFORM_Null, "action", "Landroid/content/Intent;", "configurationDiffToString", "diff", FinalChip.BSP_PLATFORM_Null, "findFragmentByAction", "initData", "initViews", "moveTaskToBack", "neeedRestart", FinalChip.BSP_PLATFORM_Null, "state", "onConfigurationChanged", "newConfig", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFragmentDispatcher", "v", "onFragmentStart", "fragment", "onNewIntent", "intent", "onPause", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "onStartPage", "onTabClick", "restoreFragment", "setMetricsToDefaults", "metrics", "Landroid/util/DisplayMetrics;", "tabVisibility", "visible", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainAct extends BaseAct {
    private static final String TAG = "MainAct";
    private ActMainBinding binding;
    public CarState carState;
    private BaseFragment latestFragment;
    private List<View> tabs = new ArrayList();
    private HashMap<String, BaseFragment> fragments = new HashMap<>();

    /* JADX INFO: renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config = LazyKt.lazy(new Function0<Configuration>() { // from class: com.syu.media.MainAct$config$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m82invoke() {
            return new Configuration();
        }
    });

    /* JADX INFO: renamed from: audioProxy$delegate, reason: from kotlin metadata */
    private final Lazy audioProxy = LazyKt.lazy(new Function0<MediaProxy>() { // from class: com.syu.media.MainAct$audioProxy$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaProxy m81invoke() {
            return MediaHelper.INSTANCE.getHelper().getAudioProxy();
        }
    });

    /* JADX INFO: renamed from: mH$delegate, reason: from kotlin metadata */
    private final Lazy mH = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.media.MainAct$mH$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m84invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private long latestMsec = -1;

    /* JADX INFO: renamed from: mBackPressedCallback$delegate, reason: from kotlin metadata */
    private final Lazy mBackPressedCallback = LazyKt.lazy(new Function0<MainAct$mBackPressedCallback$2.AnonymousClass1>() { // from class: com.syu.media.MainAct$mBackPressedCallback$2
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.syu.media.MainAct$mBackPressedCallback$2$1] */
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnonymousClass1 m83invoke() {
            final MainAct mainAct = this.this$0;
            return new OnBackPressedCallback() { // from class: com.syu.media.MainAct$mBackPressedCallback$2.1
                {
                    super(true);
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    HiLog hiLog = HiLog.INSTANCE;
                    String str = MainAct.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "TAG");
                    hiLog.d(str, "handleOnBackPressed:" + mainAct.latestFragment);
                    BaseFragment baseFragment = mainAct.latestFragment;
                    ActMainBinding actMainBinding = null;
                    if (baseFragment instanceof MusicMainFragment) {
                        MainAct mainAct2 = mainAct;
                        ActMainBinding actMainBinding2 = mainAct2.binding;
                        if (actMainBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            actMainBinding = actMainBinding2;
                        }
                        ImageView imageView = actMainBinding.ivTabMusic;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTabMusic");
                        mainAct2.onTabClick(imageView);
                        return;
                    }
                    if (baseFragment instanceof RadioSettingsFragment) {
                        MainAct mainAct3 = mainAct;
                        ActMainBinding actMainBinding3 = mainAct3.binding;
                        if (actMainBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            actMainBinding = actMainBinding3;
                        }
                        ImageView imageView2 = actMainBinding.ivTabRadio;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTabRadio");
                        mainAct3.onTabClick(imageView2);
                        return;
                    }
                    if (baseFragment instanceof OnlineDetailFragment) {
                        MainAct mainAct4 = mainAct;
                        ActMainBinding actMainBinding4 = mainAct4.binding;
                        if (actMainBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            actMainBinding = actMainBinding4;
                        }
                        ImageView imageView3 = actMainBinding.ivTabFm;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivTabFm");
                        mainAct4.onTabClick(imageView3);
                        return;
                    }
                    mainAct.moveTaskToBack();
                }
            };
        }
    });

    private final boolean neeedRestart(int state) {
        return (state & 4) == 4 || (state & 256) == 256;
    }

    private final Configuration getConfig() {
        return (Configuration) this.config.getValue();
    }

    public final MediaProxy getAudioProxy() {
        return (MediaProxy) this.audioProxy.getValue();
    }

    public final Handler getMH() {
        return (Handler) this.mH.getValue();
    }

    public final CarState getCarState() {
        CarState carState = this.carState;
        if (carState != null) {
            return carState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("carState");
        return null;
    }

    public final void setCarState(CarState carState) {
        Intrinsics.checkNotNullParameter(carState, "<set-?>");
        this.carState = carState;
    }

    private final OnBackPressedCallback getMBackPressedCallback() {
        return (OnBackPressedCallback) this.mBackPressedCallback.getValue();
    }

    public final void moveTaskToBack() {
        BaseFragment baseFragment = this.latestFragment;
        if (baseFragment != null) {
            baseFragment.moveTaskToBack();
        }
        moveTaskToBack(true);
    }

    @Override // com.syu.media.base.BaseAct, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCarState(new CarState(this));
        getOnBackPressedDispatcher().addCallback(this, getMBackPressedCallback());
        ActMainBinding actMainBindingInflate = ActMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(actMainBindingInflate, "inflate(layoutInflater)");
        this.binding = actMainBindingInflate;
        MediaToast.INSTANCE.getMe().create(this);
        ActMainBinding actMainBinding = this.binding;
        if (actMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            actMainBinding = null;
        }
        setContentView(actMainBinding.getRoot());
        initViews();
        initData();
    }

    @Override // com.syu.media.base.BaseAct, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        StringBuilder sb = new StringBuilder("onResume action:");
        Intent intent = getIntent();
        hiLog.d(str, sb.append(intent != null ? intent.getAction() : null).toString());
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onSaveInstanceState");
        restoreFragment();
        getMH().postDelayed(new Runnable() { // from class: com.syu.media.MainAct$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainAct.m80onSaveInstanceState$lambda0(this.f$0);
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSaveInstanceState$lambda-0, reason: not valid java name */
    public static final void m80onSaveInstanceState$lambda0(MainAct mainAct) {
        Intrinsics.checkNotNullParameter(mainAct, "this$0");
        mainAct.actionToTab(mainAct.getIntent());
    }

    private final void restoreFragment() {
        this.latestFragment = null;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            fragmentTransactionBeginTransaction.remove((Fragment) it.next());
        }
        Iterator<Map.Entry<String, BaseFragment>> it2 = this.fragments.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().setVisible(true);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onRestoreInstanceState");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Uri data;
        super.onNewIntent(intent);
        setIntent(intent);
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onNewIntent action:" + (intent != null ? intent.getAction() : null));
        HiLog hiLog2 = HiLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog2.d(str, "onNewIntent data :" + ((intent == null || (data = intent.getData()) == null) ? null : data.getPath()));
        if (StringsKt.equals$default(intent != null ? intent.getAction() : null, "android.intent.action.MAIN", false, 2, (Object) null) || intent == null) {
            return;
        }
        actionToTab(intent);
    }

    private final void initViews() {
        this.tabs.clear();
        List<View> list = this.tabs;
        ActMainBinding actMainBinding = this.binding;
        ActMainBinding actMainBinding2 = null;
        if (actMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            actMainBinding = null;
        }
        ImageView imageView = actMainBinding.ivTabEq;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTabEq");
        list.add(imageView);
        List<View> list2 = this.tabs;
        ActMainBinding actMainBinding3 = this.binding;
        if (actMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            actMainBinding3 = null;
        }
        ImageView imageView2 = actMainBinding3.ivTabMusic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTabMusic");
        list2.add(imageView2);
        List<View> list3 = this.tabs;
        ActMainBinding actMainBinding4 = this.binding;
        if (actMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            actMainBinding4 = null;
        }
        ImageView imageView3 = actMainBinding4.ivTabBtmusic;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivTabBtmusic");
        list3.add(imageView3);
        List<View> list4 = this.tabs;
        ActMainBinding actMainBinding5 = this.binding;
        if (actMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            actMainBinding5 = null;
        }
        ImageView imageView4 = actMainBinding5.ivTabRadio;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivTabRadio");
        list4.add(imageView4);
        List<View> list5 = this.tabs;
        ActMainBinding actMainBinding6 = this.binding;
        if (actMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            actMainBinding2 = actMainBinding6;
        }
        ImageView imageView5 = actMainBinding2.ivTabFm;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivTabFm");
        list5.add(imageView5);
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "initViews action: " + getIntent().getAction());
        restoreFragment();
        getMH().postDelayed(new Runnable() { // from class: com.syu.media.MainAct$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MainAct.m78initViews$lambda6(this.f$0);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initViews$lambda-6, reason: not valid java name */
    public static final void m78initViews$lambda6(MainAct mainAct) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(mainAct, "this$0");
        MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
        if (audioProxy != null && (playState = audioProxy.getPlayState()) != null) {
            MusicStatic.INSTANCE.pullPlayStateForSharePref(mainAct, playState);
        }
        mainAct.actionToTab(mainAct.getIntent());
    }

    private final void initData() {
        getConfig().setTo(getResources().getConfiguration());
        IntentFilter intentFilter = new IntentFilter(Receiver.ACTION_SYSTEM_UI_REMOVE);
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        registerReceiver(new Receiver(), intentFilter);
    }

    public final void onTabClick(View v) {
        String str;
        Intrinsics.checkNotNullParameter(v, "v");
        HiLog hiLog = HiLog.INSTANCE;
        String str2 = TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
        hiLog.d(str2, "onTabClick:" + this.tabs.indexOf(v));
        if (v.getId() == R.id.iv_tab_eq) {
            start(v, ConstantsKt.ACTION_PAGE_EQ);
        }
        int id = v.getId();
        if (id == R.id.iv_tab_music) {
            str = ConstantsKt.ACTION_PAGE_MUSIC;
        } else if (id == R.id.iv_tab_radio) {
            str = "com.syu.radio";
        } else if (id == R.id.iv_tab_btmusic) {
            str = ConstantsKt.ACTION_PAGE_BTMUSIC;
        } else {
            str = id == R.id.iv_tab_fm ? ConstantsKt.ACTION_PAGE_ONLINE : null;
        }
        if (str != null) {
            onFragmentDispatcher(str, v);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void onStartPage(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onStartPage:" + action);
        ImageView imageView = null;
        ActMainBinding actMainBinding = null;
        imageView = null;
        ActMainBinding actMainBinding2 = null;
        imageView = null;
        ActMainBinding actMainBinding3 = null;
        imageView = null;
        ActMainBinding actMainBinding4 = null;
        imageView = null;
        switch (action.hashCode()) {
            case 325036569:
                if (action.equals(ConstantsKt.ACTION_PAGE_MUSIC)) {
                    ActMainBinding actMainBinding5 = this.binding;
                    if (actMainBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        actMainBinding4 = actMainBinding5;
                    }
                    imageView = actMainBinding4.ivTabMusic;
                }
                break;
            case 329043951:
                if (action.equals("com.syu.radio")) {
                    ActMainBinding actMainBinding6 = this.binding;
                    if (actMainBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        actMainBinding3 = actMainBinding6;
                    }
                    imageView = actMainBinding3.ivTabRadio;
                }
                break;
            case 1536784607:
                if (action.equals(ConstantsKt.ACTION_PAGE_ONLINE)) {
                    ActMainBinding actMainBinding7 = this.binding;
                    if (actMainBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        actMainBinding2 = actMainBinding7;
                    }
                    imageView = actMainBinding2.ivTabFm;
                }
                break;
            case 1916097543:
                if (action.equals(ConstantsKt.ACTION_PAGE_BTMUSIC)) {
                    ActMainBinding actMainBinding8 = this.binding;
                    if (actMainBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        actMainBinding = actMainBinding8;
                    }
                    imageView = actMainBinding.ivTabBtmusic;
                }
                break;
        }
        onFragmentDispatcher(action, imageView);
    }

    static /* synthetic */ void onFragmentDispatcher$default(MainAct mainAct, String str, View view, int i, Object obj) {
        if ((i & 2) != 0) {
            view = null;
        }
        mainAct.onFragmentDispatcher(str, view);
    }

    private final void onFragmentDispatcher(String action, View v) {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onFragmentDispatcher action:" + action);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.latestMsec > 100) {
            HiLog hiLog2 = HiLog.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            hiLog2.d(str, "onFragmentDispatcher action11:" + action);
            tabVisibility(v != null ? 0 : 4);
            if (v != null) {
                int size = this.tabs.size();
                for (int i = 0; i < size; i++) {
                    this.tabs.get(i).setSelected(Intrinsics.areEqual(this.tabs.get(i), v));
                }
                HiLog hiLog3 = HiLog.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                hiLog3.d(str2, "onFragmentDispatcher indexOf:" + this.tabs.indexOf(v));
                SharedPrefUtils.INSTANCE.setParam(this, ConstantsKt.FRAG_CURRENT_PAGE, Integer.valueOf(this.tabs.indexOf(v)));
            }
            HiLog hiLog4 = HiLog.INSTANCE;
            String str3 = TAG;
            Intrinsics.checkNotNullExpressionValue(str3, "TAG");
            hiLog4.d(str3, "onFragmentDispatcher action22:" + this.fragments.get(action));
            BaseFragment baseFragmentFindFragmentByAction = findFragmentByAction(action);
            if (baseFragmentFindFragmentByAction != null) {
                onFragmentStart(baseFragmentFindFragmentByAction);
            }
            this.latestMsec = jCurrentTimeMillis;
        }
    }

    public final BaseFragment findFragmentByAction(String action) {
        RadioSettingsFragment radioSettingsFragment;
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.fragments.containsKey(action)) {
            return this.fragments.get(action);
        }
        DataBindBaseFragment dataBindBaseFragment = null;
        switch (action) {
            case "com.syu.radio.settings":
                radioSettingsFragment = new RadioSettingsFragment();
                break;
            case "com.syu.music":
                radioSettingsFragment = new MusicFragment();
                break;
            case "com.syu.radio":
                radioSettingsFragment = new RadioFragment();
                break;
            case "com.syu.online.detail":
                radioSettingsFragment = new OnlineDetailFragment();
                break;
            case "com.syu.online":
                radioSettingsFragment = new OnlineFragment();
                break;
            case "com.syu.btmusic":
                radioSettingsFragment = new BtmusicFragment();
                break;
            case "com.syu.music.main":
                radioSettingsFragment = new MusicMainFragment();
                break;
            default:
                radioSettingsFragment = null;
                break;
        }
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "FragByAction:" + radioSettingsFragment);
        if (radioSettingsFragment != null) {
            this.fragments.put(action, radioSettingsFragment);
            dataBindBaseFragment = radioSettingsFragment;
        }
        return dataBindBaseFragment;
    }

    private final void tabVisibility(int visible) {
        ActMainBinding actMainBinding = null;
        if (visible == 4) {
            ActMainBinding actMainBinding2 = this.binding;
            if (actMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                actMainBinding2 = null;
            }
            actMainBinding2.actMainTats.setAlpha(0.0f);
        } else {
            ActMainBinding actMainBinding3 = this.binding;
            if (actMainBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                actMainBinding3 = null;
            }
            actMainBinding3.actMainTats.animate().alpha(1.0f).setDuration(300L).start();
        }
        ActMainBinding actMainBinding4 = this.binding;
        if (actMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            actMainBinding = actMainBinding4;
        }
        actMainBinding.actMainTats.setVisibility(visible);
    }

    private final synchronized void onFragmentStart(BaseFragment fragment) {
        boolean zAreEqual = Intrinsics.areEqual(fragment, this.latestFragment);
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onFragmentStart fragmentDiff:" + zAreEqual);
        if (zAreEqual) {
            return;
        }
        String name = fragment.getClass().getName();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(name);
        HiLog hiLog2 = HiLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog2.d(str, "tag: " + name + " ,showFrag: " + fragmentFindFragmentByTag + XmlConsts.CHAR_SPACE);
        HiLog hiLog3 = HiLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog3.d(str, "onFragmentStart latestFragment: " + this.latestFragment + XmlConsts.CHAR_SPACE);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.frag_fade_enter, R.anim.frag_fade_exit);
        HiLog.INSTANCE.d("FragmentManager", "fragments size:" + getSupportFragmentManager().getFragments().size());
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (Fragment fragment2 : fragments) {
            HiLog.INSTANCE.d("FragmentManager", "tag:" + fragment2.getTag() + " ,fragment:" + fragment2 + XmlConsts.CHAR_SPACE);
        }
        BaseFragment baseFragment = this.latestFragment;
        if (baseFragment != null) {
            Fragment fragmentFindFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(baseFragment.getClass().getName());
            if (fragmentFindFragmentByTag2 != null) {
                fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
            }
        }
        if (fragmentFindFragmentByTag == null && !fragment.isAdded()) {
            HiLog hiLog4 = HiLog.INSTANCE;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            hiLog4.d(str2, name + " showFrag is null ");
            fragmentTransactionBeginTransaction.add(R.id.main_frag, fragment, name);
        } else {
            fragmentTransactionBeginTransaction.show(fragment);
        }
        this.latestFragment = fragment;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r0.equals(com.syu.media.ConstantsKt.ACTION_PAGE_BTMUSIC) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b0, code lost:
    
        if (r0.equals(com.syu.media.ConstantsKt.ACTION_PAGE_BTAV) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b3, code lost:
    
        r12 = r11.binding;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b5, code lost:
    
        if (r12 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b7, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bb, code lost:
    
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01bc, code lost:
    
        r12 = r4.ivTabBtmusic;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "binding.ivTabBtmusic");
        onTabClick(r12);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void actionToTab(android.content.Intent r12) {
        /*
            Method dump skipped, instruction units count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.media.MainAct.actionToTab(android.content.Intent):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        int iDiff = getConfig().diff(newConfig);
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onConfigurationChanged diff: " + iDiff);
        if (neeedRestart(iDiff)) {
            HiLog hiLog2 = HiLog.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            hiLog2.d(str, "diffChanged:" + iDiff);
            restoreFragment();
            getMH().postDelayed(new Runnable() { // from class: com.syu.media.MainAct$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MainAct.m79onConfigurationChanged$lambda17(this.f$0);
                }
            }, 20L);
        }
        getConfig().setTo(getResources().getConfiguration());
        super.onConfigurationChanged(newConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onConfigurationChanged$lambda-17, reason: not valid java name */
    public static final void m79onConfigurationChanged$lambda17(MainAct mainAct) {
        Intrinsics.checkNotNullParameter(mainAct, "this$0");
        mainAct.actionToTab(mainAct.getIntent());
    }

    private final void setMetricsToDefaults(DisplayMetrics metrics) {
        metrics.densityDpi = 160;
        metrics.density = 1.0f;
        metrics.scaledDensity = metrics.density + 0.25f;
    }

    @Override // com.syu.media.base.BaseAct, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onPause");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        hiLog.d(str, "onDestroy");
        super.onDestroy();
    }

    public final String configurationDiffToString(int diff) {
        ArrayList arrayList = new ArrayList();
        if ((diff & 1) != 0) {
            arrayList.add("CONFIG_MCC");
        }
        if ((diff & 2) != 0) {
            arrayList.add("CONFIG_MNC");
        }
        if ((diff & 4) != 0) {
            arrayList.add("CONFIG_LOCALE");
        }
        if ((diff & 8) != 0) {
            arrayList.add("CONFIG_TOUCHSCREEN");
        }
        if ((diff & 16) != 0) {
            arrayList.add("CONFIG_KEYBOARD");
        }
        if ((diff & 32) != 0) {
            arrayList.add("CONFIG_KEYBOARD_HIDDEN");
        }
        if ((diff & 64) != 0) {
            arrayList.add("CONFIG_NAVIGATION");
        }
        if ((diff & 128) != 0) {
            arrayList.add("CONFIG_ORIENTATION");
        }
        if ((diff & 256) != 0) {
            arrayList.add("CONFIG_SCREEN_LAYOUT");
        }
        if ((diff & 16384) != 0) {
            arrayList.add("CONFIG_COLOR_MODE");
        }
        if ((diff & 512) != 0) {
            arrayList.add("CONFIG_UI_MODE");
        }
        if ((diff & 1024) != 0) {
            arrayList.add("CONFIG_SCREEN_SIZE");
        }
        if ((diff & 2048) != 0) {
            arrayList.add("CONFIG_SMALLEST_SCREEN_SIZE");
        }
        if ((diff & 4096) != 0) {
            arrayList.add("CONFIG_DENSITY");
        }
        if ((diff & 8192) != 0) {
            arrayList.add("CONFIG_LAYOUT_DIRECTION");
        }
        if ((diff & 1073741824) != 0) {
            arrayList.add("CONFIG_FONT_SCALE");
        }
        StringBuilder sb = new StringBuilder("{");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
