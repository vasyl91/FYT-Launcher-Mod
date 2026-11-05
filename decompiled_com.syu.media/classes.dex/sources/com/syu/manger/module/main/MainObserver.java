package com.syu.manger.module.main;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.manger.module.event.EventManager;
import com.syu.manger.module.video.VideoAdapter;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/main/MainObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/main/MainModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/main/MainModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MainObserver extends BaseModuleObserver<MainModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainObserver(ModuleManager moduleManager, final MainModel mainModel) {
        super(moduleManager, mainModel, 0, 0, 1, 50, 168, 43, 12, 133, 37, 74, 7, 28, 68, 69, 70, 39, 101, 2, 31, 26, 4, 178, 177, 138, 182, 179);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(mainModel, "model");
        MutableLiveData<Integer> screenOn = mainModel.getScreenOn();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.syu.manger.module.main.MainObserver.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0026  */
            public final void invoke(Integer num) {
                boolean z;
                Integer value;
                MutableLiveData<Boolean> mutableLiveDataIsRunning = mainModel.isRunning();
                if (num != null) {
                    z = num.intValue() == 1 && (value = mainModel.getMcuOn().getValue()) != null && value.intValue() == 1;
                }
                mutableLiveDataIsRunning.postValue(Boolean.valueOf(z));
            }
        };
        screenOn.observeForever(new Observer() { // from class: com.syu.manger.module.main.MainObserver$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainObserver.a(function1, obj);
            }
        });
        MutableLiveData<Integer> mcuOn = mainModel.getMcuOn();
        final Function1<Integer, Unit> function2 = new Function1<Integer, Unit>() { // from class: com.syu.manger.module.main.MainObserver.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0026  */
            public final void invoke(Integer num) {
                boolean z;
                Integer value;
                MutableLiveData<Boolean> mutableLiveDataIsRunning = mainModel.isRunning();
                if (num != null) {
                    z = num.intValue() == 1 && (value = mainModel.getScreenOn().getValue()) != null && value.intValue() == 1;
                }
                mutableLiveDataIsRunning.postValue(Boolean.valueOf(z));
            }
        };
        mcuOn.observeForever(new Observer() { // from class: com.syu.manger.module.main.MainObserver$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainObserver.b(function2, obj);
            }
        });
    }

    public static final void a(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void b(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x025b A[PHI: r0
  0x025b: PHI (r0v24 androidx.lifecycle.LiveData) = (r0v23 androidx.lifecycle.LiveData), (r0v40 androidx.lifecycle.LiveData), (r0v74 androidx.lifecycle.LiveData) binds: [B:80:0x0259, B:69:0x0202, B:46:0x0157] A[DONT_GENERATE, DONT_INLINE]] */
    public void onReceiver(Message msg) {
        LiveData appId;
        int iMake16Int;
        Object objValueOf;
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.e("main", new StringBuilder().append(msg).append(XmlConsts.CHAR_SPACE).append(getModel().isRunning().getValue()).toString());
        int i = msg.code;
        boolean z = false;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 178) {
                        if (i == 179) {
                            if (Utils.checkIndex(msg.flts, 2)) {
                                MutableLiveData<float[]> mLocation = getModel().getMLocation();
                                float[] fArr = msg.flts;
                                mLocation.postValue(new float[]{fArr[0], fArr[1], fArr[2]});
                                return;
                            }
                            return;
                        }
                        switch (i) {
                            case 4:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().isLampOn();
                                    if (msg.ints[0] == 1) {
                                        z = true;
                                    }
                                    objValueOf = Boolean.valueOf(z);
                                }
                                break;
                            case 12:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().getReversing();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 28:
                                if (Utils.checkIndex(msg.strs, 0)) {
                                    appId = getModel().getDefNavi();
                                    objValueOf = msg.strs[0];
                                }
                                break;
                            case 31:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().getMBrightness();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 37:
                                if (Utils.checkIndex(msg.ints, 1)) {
                                    EventManager me = EventManager.INSTANCE.getMe();
                                    int[] iArr = msg.ints;
                                    me.onPlayControl(iArr[0], iArr[1]);
                                }
                                break;
                            case 43:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().isWeak();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 50:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().getAccOn();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 74:
                                if (Utils.checkIndex(msg.ints, 1)) {
                                    appId = getModel().isHandbrakeOn();
                                    if (msg.ints[0] == 1) {
                                        z = true;
                                    }
                                    objValueOf = Boolean.valueOf(z);
                                }
                                break;
                            case 101:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().getSpeed();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 133:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    EventManager.INSTANCE.getMe().onClick(msg.ints[0]);
                                }
                                break;
                            case 138:
                                if (Utils.checkIndex(msg.strs, 0)) {
                                    appId = getModel().getTopApp();
                                    objValueOf = msg.strs[0];
                                }
                                break;
                            case 168:
                                if (Utils.checkIndex(msg.ints, 0)) {
                                    appId = getModel().getScreenOn();
                                    iMake16Int = msg.ints[0];
                                }
                                break;
                            case 182:
                                if (Utils.checkIndex(msg.ints, 1)) {
                                    appId = getModel().getMobileLink();
                                    int[] iArr2 = msg.ints;
                                    iMake16Int = Utils.make16Int(iArr2[0], iArr2[1]);
                                }
                                break;
                            default:
                                switch (i) {
                                    case 68:
                                        for (VideoAdapter videoAdapter : AutoManager.INSTANCE.requestInstance().getMVideoAdapters()) {
                                            int[] iArr3 = msg.ints;
                                            Intrinsics.checkNotNullExpressionValue(iArr3, "msg.ints");
                                            videoAdapter.responseVideoId(Arrays.copyOf(iArr3, iArr3.length));
                                        }
                                        break;
                                    case 69:
                                        for (VideoAdapter videoAdapter2 : AutoManager.INSTANCE.requestInstance().getMVideoAdapters()) {
                                            int[] iArr4 = msg.ints;
                                            Intrinsics.checkNotNullExpressionValue(iArr4, "msg.ints");
                                            videoAdapter2.responseSignal(Arrays.copyOf(iArr4, iArr4.length));
                                        }
                                        break;
                                    case 70:
                                        for (VideoAdapter videoAdapter3 : AutoManager.INSTANCE.requestInstance().getMVideoAdapters()) {
                                            int[] iArr5 = msg.ints;
                                            Intrinsics.checkNotNullExpressionValue(iArr5, "msg.ints");
                                            videoAdapter3.responseFormat(Arrays.copyOf(iArr5, iArr5.length));
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    if (!Utils.checkIndex(msg.ints, 0)) {
                        return;
                    }
                    appId = getModel().getUiMode();
                    iMake16Int = msg.ints[0];
                } else {
                    if (!Utils.checkIndex(msg.ints, 0)) {
                        return;
                    }
                    appId = getModel().isStandby();
                    if (msg.ints[0] == 1) {
                        z = true;
                    }
                    objValueOf = Boolean.valueOf(z);
                }
                appId.postValue(objValueOf);
            }
            if (!Utils.checkIndex(msg.ints, 0)) {
                return;
            }
            appId = getModel().getMcuOn();
            iMake16Int = msg.ints[0];
        } else {
            if (!Utils.checkIndex(msg.ints, 0)) {
                return;
            }
            appId = getModel().getAppId();
            iMake16Int = msg.ints[0];
        }
        objValueOf = Integer.valueOf(iMake16Int);
        appId.postValue(objValueOf);
    }
}
