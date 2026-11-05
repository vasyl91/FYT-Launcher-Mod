package com.syu.manger.module.sound;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import chip.FinalChip;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/sound/SoundObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/sound/SoundModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/sound/SoundModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SoundObserver extends BaseModuleObserver<SoundModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoundObserver(ModuleManager moduleManager, SoundModel soundModel) {
        super(moduleManager, soundModel, 4, 2, 3, 24, 0);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(soundModel, "model");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070 A[PHI: r0
  0x0070: PHI (r0v11 androidx.lifecycle.MutableLiveData<java.lang.Boolean>) = 
  (r0v9 androidx.lifecycle.MutableLiveData<java.lang.Boolean>)
  (r0v21 androidx.lifecycle.MutableLiveData<java.lang.Boolean>)
 binds: [B:22:0x006d, B:14:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    public void onReceiver(Message msg) {
        MutableLiveData<Boolean> mutableLiveDataIsSpectrumEnable;
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        int i = msg.code;
        if (i == 0) {
            getModel().getSpectrumData().postValue(msg.ints);
            return;
        }
        boolean z = true;
        if (i != 24) {
            if (i == 2) {
                if (Utils.checkIndex(msg.ints, 0)) {
                    MutableLiveData<Integer> mCurrentVol = getModel().getMCurrentVol();
                    int[] iArr = msg.ints;
                    Intrinsics.checkNotNull(iArr);
                    mCurrentVol.postValue(Integer.valueOf(iArr[0]));
                    return;
                }
                return;
            }
            if (i != 3 || !Utils.checkIndex(msg.ints, 0)) {
                return;
            }
            mutableLiveDataIsSpectrumEnable = getModel().isMute();
            int[] iArr2 = msg.ints;
            Intrinsics.checkNotNull(iArr2);
            if (iArr2[0] != 1) {
                z = false;
            }
        } else {
            if (!Utils.checkIndex(msg.ints, 0)) {
                return;
            }
            mutableLiveDataIsSpectrumEnable = getModel().isSpectrumEnable();
            int[] iArr3 = msg.ints;
            Intrinsics.checkNotNull(iArr3);
            if (iArr3[0] != 1) {
                z = false;
            }
        }
        mutableLiveDataIsSpectrumEnable.postValue(Boolean.valueOf(z));
    }
}
