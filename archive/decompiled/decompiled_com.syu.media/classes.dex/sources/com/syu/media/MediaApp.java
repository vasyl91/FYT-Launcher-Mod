package com.syu.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.main.MainModel;
import com.syu.manger.module.radio.RadioModel;
import com.syu.media.companion.cache.CoverCache;
import com.syu.media.companion.cache.RadioIconCache;
import com.syu.media.companion.report.ReportError;
import com.syu.media.companion.resources.ResourcesLoader;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.music.MusicModel;
import com.syu.media.music.MusicService;
import com.syu.media.online.OnlineLoader;
import com.syu.media.online.viewmodel.OnlineViewModel;
import com.syu.media.provider.Media;
import com.syu.media.service.PlaybackService;
import com.syu.radio.RadioConst;
import com.syu.radio.RadioLoader;
import com.syu.radio.database.RadioDatabase;
import com.syu.radio.provider.RadioProvider;
import com.syu.radio.viewmodel.RadioDaoModel;
import com.syu.radio.viewmodel.RadioDaoModelFactory;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import syu.base.BaseApp;

/* JADX INFO: compiled from: MediaApp.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b*\u0001L\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020OH\u0016J\u000e\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020JJ \u0010R\u001a\u00020S2\u0018\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020W0V0UJ\b\u0010X\u001a\u00020SH\u0002J\u0010\u0010Y\u001a\u00020S2\u0006\u0010Z\u001a\u00020\u0006H\u0016J\b\u0010[\u001a\u00020SH\u0016J\b\u0010\\\u001a\u00020SH\u0002J\b\u0010]\u001a\u00020SH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001f\u001a\u0004\b7\u00108R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u001f\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020DX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010M¨\u0006_"}, d2 = {"Lcom/syu/media/MediaApp;", "Lcom/syu/media/BaseMediaApp;", "()V", "checkDevices", "Ljava/lang/Runnable;", "config", "Landroid/content/res/Configuration;", "getConfig", "()Landroid/content/res/Configuration;", "setConfig", "(Landroid/content/res/Configuration;)V", "freq", FinalChip.BSP_PLATFORM_Null, "getFreq", "()I", "setFreq", "(I)V", "iconCache", "Lcom/syu/media/companion/cache/CoverCache;", "getIconCache", "()Lcom/syu/media/companion/cache/CoverCache;", "isFirst", FinalChip.BSP_PLATFORM_Null, "()Z", "setFirst", "(Z)V", "mainModel", "Lcom/syu/manger/module/main/MainModel;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel$delegate", "Lkotlin/Lazy;", "musicModel", "Lcom/syu/media/music/MusicModel;", "getMusicModel", "()Lcom/syu/media/music/MusicModel;", "musicModel$delegate", "onlineLoader", "Lcom/syu/media/online/OnlineLoader;", "getOnlineLoader", "()Lcom/syu/media/online/OnlineLoader;", "setOnlineLoader", "(Lcom/syu/media/online/OnlineLoader;)V", "onlineModel", "Lcom/syu/media/online/viewmodel/OnlineViewModel;", "getOnlineModel", "()Lcom/syu/media/online/viewmodel/OnlineViewModel;", "onlineModel$delegate", "radioDaoModel", "Lcom/syu/radio/viewmodel/RadioDaoModel;", "getRadioDaoModel", "()Lcom/syu/radio/viewmodel/RadioDaoModel;", "radioDaoModel$delegate", "radioDatabase", "Lcom/syu/radio/database/RadioDatabase;", "getRadioDatabase", "()Lcom/syu/radio/database/RadioDatabase;", "radioDatabase$delegate", "radioIconCache", "Lcom/syu/media/companion/cache/RadioIconCache;", "getRadioIconCache", "()Lcom/syu/media/companion/cache/RadioIconCache;", "radioModel", "Lcom/syu/manger/module/radio/RadioModel;", "getRadioModel", "()Lcom/syu/manger/module/radio/RadioModel;", "radioModel$delegate", "resourcesLoader", "Lcom/syu/media/companion/resources/ResourcesLoader;", "getResourcesLoader", "()Lcom/syu/media/companion/resources/ResourcesLoader;", "setResourcesLoader", "(Lcom/syu/media/companion/resources/ResourcesLoader;)V", "resourcesPath", FinalChip.BSP_PLATFORM_Null, "scanDevices", "com/syu/media/MediaApp$scanDevices$1", "Lcom/syu/media/MediaApp$scanDevices$1;", "getResources", "Landroid/content/res/Resources;", "isMounted", Media.PATH, "localAssertNotifyChanged", FinalChip.BSP_PLATFORM_Null, Media.LIST_TABLE, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "mediaMoudule", "onConfigurationChanged", "newConfig", "onCreate", "onlineModule", "radioMoudule", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaApp extends BaseMediaApp {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "MediaApp";
    private static final String internalPath;
    public static MediaApp me;
    private int freq;
    public OnlineLoader onlineLoader;
    public ResourcesLoader resourcesLoader;
    private final String resourcesPath = "odm/app/cabinet.data";
    private boolean isFirst = true;
    private final CoverCache iconCache = new CoverCache((Context) this);
    private final RadioIconCache radioIconCache = new RadioIconCache(this);

    /* JADX INFO: renamed from: mainModel$delegate, reason: from kotlin metadata */
    private final Lazy mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.MediaApp$mainModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MainModel m89invoke() {
            ViewModel viewModel = BaseApp.getViewModelProvider$default(this.this$0, (ViewModelProvider.Factory) null, 1, (Object) null).get(MainModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider().get(VM::class.java)");
            return (MainModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: radioModel$delegate, reason: from kotlin metadata */
    private final Lazy radioModel = LazyKt.lazy(new Function0<RadioModel>() { // from class: com.syu.media.MediaApp$radioModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioModel m94invoke() {
            ViewModel viewModel = this.this$0.getViewModelProvider().get(RadioModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (RadioModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: musicModel$delegate, reason: from kotlin metadata */
    private final Lazy musicModel = LazyKt.lazy(new Function0<MusicModel>() { // from class: com.syu.media.MediaApp$musicModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MusicModel m90invoke() {
            ViewModel viewModel = this.this$0.getViewModelProvider().get(MusicModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (MusicModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: onlineModel$delegate, reason: from kotlin metadata */
    private final Lazy onlineModel = LazyKt.lazy(new Function0<OnlineViewModel>() { // from class: com.syu.media.MediaApp$onlineModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OnlineViewModel m91invoke() {
            ViewModel viewModel = this.this$0.getViewModelProvider().get(OnlineViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
            return (OnlineViewModel) viewModel;
        }
    });

    /* JADX INFO: renamed from: radioDatabase$delegate, reason: from kotlin metadata */
    private final Lazy radioDatabase = LazyKt.lazy(new Function0<RadioDatabase>() { // from class: com.syu.media.MediaApp$radioDatabase$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioDatabase m93invoke() {
            return RadioDatabase.INSTANCE.getDatabase((Context) this.this$0);
        }
    });

    /* JADX INFO: renamed from: radioDaoModel$delegate, reason: from kotlin metadata */
    private final Lazy radioDaoModel = LazyKt.lazy(new Function0<RadioDaoModel>() { // from class: com.syu.media.MediaApp$radioDaoModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioDaoModel m92invoke() {
            RadioDaoModel radioDaoModel = this.this$0.getViewModelProvider(new RadioDaoModelFactory(this.this$0.getRadioDatabase().radioDao())).get(RadioDaoModel.class);
            Intrinsics.checkNotNullExpressionValue(radioDaoModel, "getViewModelProvider(factory).get(VM::class.java)");
            return radioDaoModel;
        }
    });
    private final MediaApp$scanDevices$1 scanDevices = new Runnable() { // from class: com.syu.media.MediaApp$scanDevices$1
        @Override // java.lang.Runnable
        public void run() {
            MediaApp$scanDevices$1 mediaApp$scanDevices$1 = this;
            this.this$0.getMediaFiles().workHandler().removeCallbacks(mediaApp$scanDevices$1);
            if (ContextCompat.checkSelfPermission((Context) this.this$0, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                Log.e(MediaFiles.TAG, "==== >> scanDevices  start!! ");
                this.this$0.getMediaFiles().scanMounted((Context) this.this$0);
                this.this$0.setFirst(false);
                return;
            }
            this.this$0.getMediaFiles().workHandler().postDelayed(mediaApp$scanDevices$1, 1500L);
        }
    };
    private final Runnable checkDevices = new Runnable() { // from class: com.syu.media.MediaApp$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            MediaApp.m86checkDevices$lambda0(this.f$0);
        }
    };
    private Configuration config = new Configuration();

    /* JADX INFO: compiled from: MediaApp.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/syu/media/MediaApp$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "internalPath", "getInternalPath", "()Ljava/lang/String;", "me", "Lcom/syu/media/MediaApp;", "getMe", "()Lcom/syu/media/MediaApp;", "setMe", "(Lcom/syu/media/MediaApp;)V", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaApp getMe() {
            MediaApp mediaApp = MediaApp.me;
            if (mediaApp != null) {
                return mediaApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("me");
            return null;
        }

        public final void setMe(MediaApp mediaApp) {
            Intrinsics.checkNotNullParameter(mediaApp, "<set-?>");
            MediaApp.me = mediaApp;
        }

        public final String getInternalPath() {
            return MediaApp.internalPath;
        }
    }

    static {
        String path = Environment.getExternalStorageDirectory().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getExternalStorageDirectory().path");
        internalPath = path;
    }

    public final int getFreq() {
        return this.freq;
    }

    public final void setFreq(int i) {
        this.freq = i;
    }

    /* JADX INFO: renamed from: isFirst, reason: from getter */
    public final boolean getIsFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }

    public final CoverCache getIconCache() {
        return this.iconCache;
    }

    public final RadioIconCache getRadioIconCache() {
        return this.radioIconCache;
    }

    public final OnlineLoader getOnlineLoader() {
        OnlineLoader onlineLoader = this.onlineLoader;
        if (onlineLoader != null) {
            return onlineLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onlineLoader");
        return null;
    }

    public final void setOnlineLoader(OnlineLoader onlineLoader) {
        Intrinsics.checkNotNullParameter(onlineLoader, "<set-?>");
        this.onlineLoader = onlineLoader;
    }

    public final ResourcesLoader getResourcesLoader() {
        ResourcesLoader resourcesLoader = this.resourcesLoader;
        if (resourcesLoader != null) {
            return resourcesLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resourcesLoader");
        return null;
    }

    public final void setResourcesLoader(ResourcesLoader resourcesLoader) {
        Intrinsics.checkNotNullParameter(resourcesLoader, "<set-?>");
        this.resourcesLoader = resourcesLoader;
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    public final RadioModel getRadioModel() {
        return (RadioModel) this.radioModel.getValue();
    }

    public final MusicModel getMusicModel() {
        return (MusicModel) this.musicModel.getValue();
    }

    public final OnlineViewModel getOnlineModel() {
        return (OnlineViewModel) this.onlineModel.getValue();
    }

    public final RadioDatabase getRadioDatabase() {
        return (RadioDatabase) this.radioDatabase.getValue();
    }

    public final RadioDaoModel getRadioDaoModel() {
        return (RadioDaoModel) this.radioDaoModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: checkDevices$lambda-0, reason: not valid java name */
    public static final void m86checkDevices$lambda0(MediaApp mediaApp) {
        Intrinsics.checkNotNullParameter(mediaApp, "this$0");
        MediaFiles mediaFiles = mediaApp.getMediaFiles();
        Boolean value = mediaApp.getMainModel().isRunning().getValue();
        mediaFiles.setWaiting(value == null ? false : value.booleanValue());
        MediaFiles mediaFiles2 = mediaApp.getMediaFiles();
        Integer value2 = mediaApp.getMainModel().getAccOn().getValue();
        mediaFiles2.setWaiting(value2 == null || value2.intValue() != 1);
    }

    @Override // com.syu.media.BaseMediaApp
    public void onCreate() {
        super.onCreate();
        INSTANCE.setMe(this);
        ReportError.getInstance(getApplicationContext());
        mediaMoudule();
        radioMoudule();
        onlineModule();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void mediaMoudule() {
        MediaHelper helper = MediaHelper.INSTANCE.getHelper();
        Context context = (Context) this;
        MediaProxy mediaProxy = new MediaProxy(context, MusicService.class);
        AutoManager.INSTANCE.createAutoManager(this, (112 & 2) != 0 ? false : true, (112 & 4) != 0 ? false : true, (112 & 8) != 0 ? false : true, (112 & 16) != 0 ? false : false, (112 & 32) != 0 ? false : false, (112 & 64) == 0 ? false : false);
        mediaProxy.setMediaDao(getMediaModel().getMediaDao());
        helper.setAudioProxy(mediaProxy);
        getMediaFiles().setMCoverHandler(this.iconCache);
        String[] stringArray = getResources().getStringArray(R.array.audio_filter);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.audio_filter)");
        HiLog.INSTANCE.d("music", "audioFilter" + stringArray.length);
        getMediaFiles().setMediaFilter(new MediaFiles.MediaFilter(null, 512000, stringArray, new String[0], 1, null));
        HiLog.INSTANCE.d("music", "audioFilter" + getMediaFiles().getMediaFilter().getAudioSuffixes().length);
        getMediaFiles().monitorUDiskMount(context);
        Intent intent = new Intent(PlaybackService.class.getName());
        intent.setPackage(getPackageName());
        startService(intent);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(null), 3, (Object) null);
        getMainModel().isRunning().observeForever(new Observer() { // from class: com.syu.media.MediaApp$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaApp.m87mediaMoudule$lambda3(this.f$0, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.syu.media.MediaApp$mediaMoudule$3, reason: invalid class name */
    /* JADX INFO: compiled from: MediaApp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.MediaApp$mediaMoudule$3", f = "MediaApp.kt", i = {}, l = {AutoKeyEvent.KEYCODE_MEDIA_RECORD}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaApp.this.new AnonymousClass3(continuation);
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
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(MediaApp.this.getDatabase().mediaDao().getPlayListById(1)), new AnonymousClass1(MediaApp.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.syu.media.MediaApp$mediaMoudule$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: MediaApp.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "<anonymous parameter 0>", "Lcom/syu/media/entities/PlayListWithAudios;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.MediaApp$mediaMoudule$3$1", f = "MediaApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PlayListWithAudios, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MediaApp this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MediaApp mediaApp, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mediaApp;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                ContentResolver contentResolver = this.this$0.getContentResolver();
                Log.e("Data", "MediaProvider onCreate ---------------->> ");
                contentResolver.notifyChange(Uri.parse("content://com.syu.media/list/1"), null);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mediaMoudule$lambda-3, reason: not valid java name */
    public static final void m87mediaMoudule$lambda3(MediaApp mediaApp, Boolean bool) {
        Intrinsics.checkNotNullParameter(mediaApp, "this$0");
        mediaApp.getMediaFiles().workHandler().removeCallbacks(mediaApp.scanDevices);
        mediaApp.getMediaFiles().workHandler().removeCallbacks(mediaApp.checkDevices);
        if (!bool.booleanValue() && !mediaApp.isFirst) {
            mediaApp.getMediaFiles().setWaiting(true);
        }
        if (mediaApp.isFirst) {
            Intrinsics.checkNotNullExpressionValue(bool, "it");
            if (bool.booleanValue()) {
                Log.e(MediaFiles.TAG, "==== >> scanDevices delay 2000 isFirst!! ");
                mediaApp.getMediaFiles().workHandler().postDelayed(mediaApp.scanDevices, 2000L);
                return;
            }
        }
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            Log.e(MediaFiles.TAG, "==== >> checkDevices  delay 8000!! ");
            mediaApp.getMediaFiles().workHandler().postDelayed(mediaApp.checkDevices, 8000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void radioMoudule() {
        Context context = (Context) this;
        HiLog.INSTANCE.d(TAG, "loaded:" + ((Boolean) SharedPrefUtils.INSTANCE.getParam(context, "local_radio_loaded", false)).booleanValue());
        RadioLoader radioLoader = new RadioLoader(getRadioDaoModel().getRadioDao());
        InputStream inputStreamOpenRawResource = getResources().openRawResource(R.raw.radio_freqs);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "resources.openRawResource(R.raw.radio_freqs)");
        radioLoader.parse(context, inputStreamOpenRawResource);
        String str = (String) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.RADIO_CITY_NAME, FinalChip.BSP_PLATFORM_Null);
        HiLog.INSTANCE.d(TAG, "key:" + str);
        this.radioIconCache.coverSave(str);
        setResourcesLoader(new ResourcesLoader(context, this.resourcesPath));
        getRadioModel().getMFreq().observeForever(new Observer() { // from class: com.syu.media.MediaApp$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaApp.m88radioMoudule$lambda4(this.f$0, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: radioMoudule$lambda-4, reason: not valid java name */
    public static final void m88radioMoudule$lambda4(MediaApp mediaApp, Integer num) {
        Intrinsics.checkNotNullParameter(mediaApp, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        mediaApp.freq = num.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onlineModule() {
        setOnlineLoader(new OnlineLoader(getDatabase().mediaDao()));
        getOnlineLoader().loadOnline((Context) this, R.raw.online_radios);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public Resources getResources() {
        Resources resources = super.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (displayMetrics.densityDpi == 160) {
            if (displayMetrics.density == 1.0f) {
                if (!(displayMetrics.scaledDensity == 1.25f)) {
                    displayMetrics.densityDpi = 160;
                    displayMetrics.density = 1.0f;
                    displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
                }
            } else {
                displayMetrics.densityDpi = 160;
                displayMetrics.density = 1.0f;
                displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
            }
        } else {
            displayMetrics.densityDpi = 160;
            displayMetrics.density = 1.0f;
            displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
        }
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final void setConfig(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<set-?>");
        this.config = configuration;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        HiLog.INSTANCE.d(TAG, "compareTo:" + this.config.diff(newConfig));
        this.config.setTo(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    /* JADX INFO: renamed from: com.syu.media.MediaApp$localAssertNotifyChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaApp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.MediaApp$localAssertNotifyChanged$1", f = "MediaApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Map<String, Object>> $list;
        int label;
        final /* synthetic */ MediaApp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends Map<String, ? extends Object>> list, MediaApp mediaApp, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = mediaApp;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, continuation);
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
            RadioProvider.Companion.getMLocalAssertCursor().clear();
            RadioProvider.Companion.getMLocalAssertCursor().addAll(this.$list);
            this.this$0.getContentResolver().notifyChange(Uri.parse(RadioConst.ASSERT_URI), null);
            return Unit.INSTANCE;
        }
    }

    public final void localAssertNotifyChanged(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(list, this, null), 3, (Object) null);
    }

    public final boolean isMounted(String path) {
        boolean z;
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        List<String> value = getMediaModel().getStorageDevices().getValue();
        if (value == null) {
            return false;
        }
        List<String> list = value;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith$default(path, (String) it.next(), false, 2, (Object) null)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
