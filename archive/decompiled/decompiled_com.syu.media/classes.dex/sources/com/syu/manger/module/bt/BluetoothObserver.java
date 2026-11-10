package com.syu.manger.module.bt;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.manger.module.JMutableLiveData;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/syu/manger/module/bt/BluetoothObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/bt/BluetoothModel;", "Lcom/syu/remote/Message;", NotificationCompat.CATEGORY_MESSAGE, FinalChip.BSP_PLATFORM_Null, "onReceiver", "Lcom/syu/remote/ModuleManager;", "manager", "model", "<init>", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/bt/BluetoothModel;)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class BluetoothObserver extends BaseModuleObserver<BluetoothModel> {
    public int b;
    public final BluetoothObserver$updateIcon$1 c;
    public final Runnable d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothObserver(final ModuleManager moduleManager, BluetoothModel bluetoothModel) {
        super(moduleManager, bluetoothModel, 2, 7, 6, 9, 51, 26, 1, 0, 13, 28, 2, 3, 44, 45);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(bluetoothModel, "model");
        this.c = new BluetoothObserver$updateIcon$1(bluetoothModel, this, moduleManager);
        this.d = new Runnable() { // from class: com.syu.manger.module.bt.BluetoothObserver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothObserver.a(this.f$0);
            }
        };
        JMutableLiveData<String> artist = bluetoothModel.getArtist();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.syu.manger.module.bt.BluetoothObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (str != null) {
                    if ((str.length() == 0) || BluetoothObserver.this.b >= 3) {
                        return;
                    }
                    if (BluetoothObserver.this.b > 0) {
                        BluetoothObserver.this.b--;
                    } else {
                        BluetoothObserver.this.b = 2;
                        moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.d);
                        moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.c);
                        moduleManager.mHandler.postDelayed(BluetoothObserver.this.c, 1500L);
                    }
                }
            }
        };
        artist.observeForever(new Observer() { // from class: com.syu.manger.module.bt.BluetoothObserver$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BluetoothObserver.a(function1, obj);
            }
        });
        JMutableLiveData<Integer> totalTime = bluetoothModel.getTotalTime();
        final Function1<Integer, Unit> function2 = new Function1<Integer, Unit>() { // from class: com.syu.manger.module.bt.BluetoothObserver.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                Intrinsics.checkNotNullExpressionValue(num, "it");
                if (num.intValue() <= 0 || BluetoothObserver.this.b < 4) {
                    BluetoothObserver.this.b = 3;
                    moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.d);
                    moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.c);
                    moduleManager.mHandler.postDelayed(BluetoothObserver.this.c, 1500L);
                }
            }
        };
        totalTime.observeForever(new Observer() { // from class: com.syu.manger.module.bt.BluetoothObserver$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BluetoothObserver.b(function2, obj);
            }
        });
        JMutableLiveData<String> iconPath = bluetoothModel.getIconPath();
        final Function1<String, Unit> function3 = new Function1<String, Unit>() { // from class: com.syu.manger.module.bt.BluetoothObserver.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullExpressionValue(str, "it");
                if (str.length() > 0) {
                    BluetoothObserver.this.b = 4;
                    moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.d);
                    moduleManager.mHandler.removeCallbacks(BluetoothObserver.this.c);
                    BluetoothObserver.this.c.run();
                }
            }
        };
        iconPath.observeForever(new Observer() { // from class: com.syu.manger.module.bt.BluetoothObserver$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BluetoothObserver.c(function3, obj);
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

    public static final void c(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public void onReceiver(Message msg) {
        LiveData connectedDevMac;
        Object objValueOf;
        int i;
        JMutableLiveData<String> album;
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        int i2 = msg.code;
        if (i2 != 6) {
            if (i2 != 7) {
                if (i2 != 9) {
                    if (i2 != 13) {
                        if (i2 != 26) {
                            if (i2 != 28) {
                                if (i2 != 51) {
                                    if (i2 != 44) {
                                        if (i2 != 45) {
                                            if (i2 != 0) {
                                                if (i2 != 1) {
                                                    if (i2 != 2) {
                                                        if (i2 != 3) {
                                                            if (i2 != 4 || !Utils.checkIndex(msg.ints, 0)) {
                                                                return;
                                                            }
                                                            connectedDevMac = getModel().getTotalTrack();
                                                            i = msg.ints[0];
                                                        } else {
                                                            if (!Utils.checkIndex(msg.ints, 0)) {
                                                                return;
                                                            }
                                                            connectedDevMac = getModel().getPlayTrack();
                                                            i = msg.ints[0];
                                                        }
                                                    } else {
                                                        if (!Utils.checkIndex(msg.ints, 0)) {
                                                            return;
                                                        }
                                                        connectedDevMac = getModel().getTotalTime();
                                                        i = msg.ints[0];
                                                    }
                                                } else if (!Utils.checkIndex(msg.strs, 0)) {
                                                    album = getModel().getArtist();
                                                    album.postValue(FinalChip.BSP_PLATFORM_Null);
                                                    return;
                                                } else {
                                                    connectedDevMac = getModel().getArtist();
                                                    objValueOf = msg.strs[0];
                                                }
                                            } else if (!Utils.checkIndex(msg.strs, 0)) {
                                                album = getModel().getTitle();
                                                album.postValue(FinalChip.BSP_PLATFORM_Null);
                                                return;
                                            } else {
                                                connectedDevMac = getModel().getTitle();
                                                objValueOf = msg.strs[0];
                                            }
                                        } else {
                                            if (!Utils.checkIndex(msg.ints, 0)) {
                                                return;
                                            }
                                            connectedDevMac = getModel().getPhoneSignal();
                                            i = msg.ints[0];
                                        }
                                    } else {
                                        if (!Utils.checkIndex(msg.strs, 0)) {
                                            return;
                                        }
                                        connectedDevMac = getModel().getPhoneBattery();
                                        objValueOf = msg.strs[0];
                                    }
                                } else {
                                    if (!Utils.checkIndex(msg.strs, 0)) {
                                        return;
                                    }
                                    connectedDevMac = getModel().getIconPath();
                                    objValueOf = msg.strs[0];
                                }
                            } else {
                                if (!Utils.checkIndex(msg.ints, 0)) {
                                    return;
                                }
                                connectedDevMac = getModel().getPlayTime();
                                i = msg.ints[0];
                            }
                        } else if (!Utils.checkIndex(msg.strs, 0)) {
                            album = getModel().getAlbum();
                            album.postValue(FinalChip.BSP_PLATFORM_Null);
                            return;
                        } else {
                            connectedDevMac = getModel().getAlbum();
                            objValueOf = msg.strs[0];
                        }
                    } else {
                        if (!Utils.checkIndex(msg.ints, 0)) {
                            return;
                        }
                        connectedDevMac = getModel().isBtAvPlaying();
                        objValueOf = Boolean.valueOf(msg.ints[0] == 1);
                    }
                } else {
                    if (!Utils.checkIndex(msg.ints, 0)) {
                        return;
                    }
                    connectedDevMac = getModel().getBluetoothState();
                    i = msg.ints[0];
                }
                objValueOf = Integer.valueOf(i);
            } else {
                if (!Utils.checkIndex(msg.strs, 0)) {
                    return;
                }
                connectedDevMac = getModel().getConnectedDevName();
                objValueOf = msg.strs[0];
            }
        } else {
            if (!Utils.checkIndex(msg.strs, 0)) {
                return;
            }
            connectedDevMac = getModel().getConnectedDevMac();
            objValueOf = msg.strs[0];
        }
        connectedDevMac.postValue(objValueOf);
    }

    public static final void a(BluetoothObserver bluetoothObserver) {
        Intrinsics.checkNotNullParameter(bluetoothObserver, "this$0");
        bluetoothObserver.b = 0;
    }
}
