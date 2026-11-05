package com.syu.manger;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import chip.FinalChip;
import com.syu.manger.module.bt.BluetoothController;
import com.syu.manger.module.bt.BluetoothModel;
import com.syu.manger.module.bt.BluetoothObserver;
import com.syu.manger.module.main.MainController;
import com.syu.manger.module.main.MainModel;
import com.syu.manger.module.main.MainObserver;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.manger.module.radio.RadioObserver;
import com.syu.manger.module.sound.SoundController;
import com.syu.manger.module.sound.SoundModel;
import com.syu.manger.module.sound.SoundObserver;
import com.syu.manger.module.ss.SubServerObserver;
import com.syu.manger.module.vehicle.SensorObserver;
import com.syu.manger.module.vehicle.VehicleModel;
import com.syu.manger.module.vehicle.VehicleObserver;
import com.syu.manger.module.video.VideoAdapter;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import syu.base.BaseApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u0001:\u0002GHJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006JC\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\u0016\u001a\u00020\f\"\u00020\u0002R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/syu/manger/AutoManager;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "appId", FinalChip.BSP_PLATFORM_Null, "openAppId", "Lcom/syu/manger/module/video/VideoAdapter;", "adapter", "addVideoAdapter", "removeAdapter", "module", "cmdid", FinalChip.BSP_PLATFORM_Null, "ints", FinalChip.BSP_PLATFORM_Null, "flts", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "strs", FinalChip.BSP_PLATFORM_Null, "command", "(II[I[F[Ljava/lang/String;)Z", "params", FinalChip.BSP_PLATFORM_Null, "b", "Ljava/util/List;", "getMVideoAdapters", "()Ljava/util/List;", "mVideoAdapters", "Lcom/syu/remote/ModuleManager;", "c", "Lcom/syu/remote/ModuleManager;", "getModuleManager", "()Lcom/syu/remote/ModuleManager;", "moduleManager", "Lcom/syu/manger/module/main/MainModel;", "d", "Lkotlin/Lazy;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel", "Lcom/syu/manger/module/main/MainController;", "e", "Lcom/syu/manger/module/main/MainController;", "getMainController", "()Lcom/syu/manger/module/main/MainController;", "mainController", "Lcom/syu/manger/module/radio/RadioController;", "g", "Lcom/syu/manger/module/radio/RadioController;", "getRadioController", "()Lcom/syu/manger/module/radio/RadioController;", "setRadioController", "(Lcom/syu/manger/module/radio/RadioController;)V", "radioController", "Lcom/syu/manger/module/sound/SoundController;", "i", "Lcom/syu/manger/module/sound/SoundController;", "getSoundController", "()Lcom/syu/manger/module/sound/SoundController;", "setSoundController", "(Lcom/syu/manger/module/sound/SoundController;)V", "soundController", "Lcom/syu/manger/module/bt/BluetoothController;", "k", "Lcom/syu/manger/module/bt/BluetoothController;", "getBtController", "()Lcom/syu/manger/module/bt/BluetoothController;", "setBtController", "(Lcom/syu/manger/module/bt/BluetoothController;)V", "btController", "Companion", "OnEventListener", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class AutoManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static AutoManager n;
    public final BaseApp a;
    public final ArrayList b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final ModuleManager moduleManager;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy mainModel;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final MainController mainController;
    public final Lazy f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public RadioController radioController;
    public final Lazy h;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public SoundController soundController;
    public final Lazy j;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public BluetoothController btController;
    public final Lazy l;
    public int m;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002JJ\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/syu/manger/AutoManager$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/manger/AutoManager;", "requestInstance", "Lsyu/base/BaseApp;", "context", FinalChip.BSP_PLATFORM_Null, "subServer", "enableRadio", "enableBt", "enableSound", "enableVehicle", "enableSensor", "createAutoManager", "manager", "Lcom/syu/manger/AutoManager;", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AutoManager createAutoManager(BaseApp context, boolean subServer, boolean enableRadio, boolean enableBt, boolean enableSound, boolean enableVehicle, boolean enableSensor) {
            Intrinsics.checkNotNullParameter(context, "context");
            AutoManager autoManager = AutoManager.n;
            if (autoManager == null) {
                synchronized (this) {
                    AutoManager.n = new AutoManager(context, subServer, enableRadio, enableBt, enableSound, enableVehicle, enableSensor, null);
                    autoManager = AutoManager.n;
                    Intrinsics.checkNotNull(autoManager);
                }
            }
            return autoManager;
        }

        public final AutoManager requestInstance() {
            AutoManager autoManager = AutoManager.n;
            if (autoManager != null) {
                return autoManager;
            }
            throw new RuntimeException("manager is not initialized!!");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/syu/manger/AutoManager$OnEventListener;", FinalChip.BSP_PLATFORM_Null, "onMessage", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnEventListener {
        void onMessage(Message msg);
    }

    public AutoManager(BaseApp baseApp, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = baseApp;
        this.b = new ArrayList();
        ModuleManager moduleManager = new ModuleManager(baseApp);
        this.moduleManager = moduleManager;
        this.mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.manger.AutoManager$mainModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MainModel m62invoke() {
                ViewModel viewModel = BaseApp.getViewModelProvider$default(this.a.a, (ViewModelProvider.Factory) null, 1, (Object) null).get(MainModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider().get(VM::class.java)");
                return (MainModel) viewModel;
            }
        });
        this.f = LazyKt.lazy(new Function0<RadioModel>() { // from class: com.syu.manger.AutoManager$radioModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioModel m63invoke() {
                ViewModel viewModel = this.a.a.getViewModelProvider().get(RadioModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
                return (RadioModel) viewModel;
            }
        });
        this.h = LazyKt.lazy(new Function0<SoundModel>() { // from class: com.syu.manger.AutoManager$soundModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SoundModel m64invoke() {
                ViewModel viewModel = this.a.a.getViewModelProvider().get(SoundModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
                return (SoundModel) viewModel;
            }
        });
        this.j = LazyKt.lazy(new Function0<BluetoothModel>() { // from class: com.syu.manger.AutoManager$btModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BluetoothModel m61invoke() {
                ViewModel viewModel = this.a.a.getViewModelProvider().get(BluetoothModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(VM::class.java)");
                return (BluetoothModel) viewModel;
            }
        });
        this.l = LazyKt.lazy(new Function0<VehicleModel>() { // from class: com.syu.manger.AutoManager$vehicleModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final VehicleModel m65invoke() {
                ViewModel viewModel = BaseApp.getViewModelProvider$default(this.a.a, (ViewModelProvider.Factory) null, 1, (Object) null).get(VehicleModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider().get(VM::class.java)");
                return (VehicleModel) viewModel;
            }
        });
        new MainObserver(moduleManager, getMainModel());
        this.mainController = new MainController(moduleManager);
        if (z) {
            new SubServerObserver(new ModuleManager(baseApp, "com.syu.ss", "com.syu.ss.toolkit"), getMainModel());
        }
        if (z2) {
            new RadioObserver(moduleManager, b());
            this.radioController = new RadioController(moduleManager);
        }
        if (z4) {
            new SoundObserver(moduleManager, c());
            this.soundController = new SoundController(moduleManager);
        }
        if (z3) {
            new BluetoothObserver(moduleManager, a());
            this.btController = new BluetoothController(moduleManager);
        }
        if (z5) {
            new VehicleObserver(moduleManager, d());
        }
        if (z6) {
            new SensorObserver(moduleManager, d());
        }
        getMainModel().getAppId().observeForever(new Observer() { // from class: com.syu.manger.AutoManager$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AutoManager.a(this.f$0, (Integer) obj);
            }
        });
    }

    public static final void a(AutoManager autoManager, Integer num) {
        Intrinsics.checkNotNullParameter(autoManager, "this$0");
        int i = autoManager.m;
        if (num != null && num.intValue() == i) {
            autoManager.m = 0;
            return;
        }
        int i2 = autoManager.m;
        if (i2 > 0) {
            if (num != null && i2 == num.intValue()) {
                return;
            }
            autoManager.mainController.openAppId(autoManager.m);
        }
    }

    public final void addVideoAdapter(VideoAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (this.b.contains(adapter)) {
            return;
        }
        this.b.add(adapter);
    }

    public final RadioModel b() {
        return (RadioModel) this.f.getValue();
    }

    public final SoundModel c() {
        return (SoundModel) this.h.getValue();
    }

    public final boolean command(int module, int cmdid, int... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return this.moduleManager.remote.command(module, cmdid, Arrays.copyOf(params, params.length));
    }

    public final VehicleModel d() {
        return (VehicleModel) this.l.getValue();
    }

    public final BluetoothController getBtController() {
        return this.btController;
    }

    public final List<VideoAdapter> getMVideoAdapters() {
        return this.b;
    }

    public final MainController getMainController() {
        return this.mainController;
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    public final ModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public final RadioController getRadioController() {
        return this.radioController;
    }

    public final SoundController getSoundController() {
        return this.soundController;
    }

    public final void openAppId(int appId) {
        Integer value = getMainModel().getAppId().getValue();
        if (value != null && value.intValue() == appId) {
            return;
        }
        this.m = appId;
        this.mainController.openAppId(appId);
    }

    public final void removeAdapter(VideoAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (this.b.contains(adapter)) {
            this.b.remove(adapter);
        }
    }

    public final void setBtController(BluetoothController bluetoothController) {
        this.btController = bluetoothController;
    }

    public final void setRadioController(RadioController radioController) {
        this.radioController = radioController;
    }

    public final void setSoundController(SoundController soundController) {
        this.soundController = soundController;
    }

    public /* synthetic */ AutoManager(BaseApp baseApp, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseApp, z, z2, z3, z4, z5, z6);
    }

    public final BluetoothModel a() {
        return (BluetoothModel) this.j.getValue();
    }

    public final boolean command(int module, int cmdid, int[] ints, float[] flts, String[] strs) {
        return this.moduleManager.remote.command(module, cmdid, ints, flts, strs);
    }
}
