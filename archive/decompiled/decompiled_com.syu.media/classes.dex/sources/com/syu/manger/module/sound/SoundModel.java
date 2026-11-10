package com.syu.manger.module.sound;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.module.main.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/syu/manger/module/sound/SoundModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Landroidx/lifecycle/MutableLiveData;", "getMCurrentVol", "()Landroidx/lifecycle/MutableLiveData;", "mCurrentVol", FinalChip.BSP_PLATFORM_Null, "b", "isSpectrumEnable", "c", "isMute", FinalChip.BSP_PLATFORM_Null, "d", "getSpectrumData", "spectrumData", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class SoundModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MutableLiveData mCurrentVol;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData isSpectrumEnable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData isMute;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MutableLiveData spectrumData;

    public SoundModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(0);
        this.mCurrentVol = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        Boolean bool = Boolean.FALSE;
        mutableLiveData2.setValue(bool);
        this.isSpectrumEnable = mutableLiveData2;
        this.isMute = a.a(bool);
        this.spectrumData = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getMCurrentVol() {
        return this.mCurrentVol;
    }

    public final MutableLiveData<int[]> getSpectrumData() {
        return this.spectrumData;
    }

    public final MutableLiveData<Boolean> isMute() {
        return this.isMute;
    }

    public final MutableLiveData<Boolean> isSpectrumEnable() {
        return this.isSpectrumEnable;
    }
}
