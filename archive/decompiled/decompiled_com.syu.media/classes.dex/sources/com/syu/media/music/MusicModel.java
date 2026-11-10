package com.syu.media.music;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.RadioSource;
import kotlin.Metadata;

/* JADX INFO: compiled from: MusicModel.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/syu/media/music/MusicModel;", "Landroidx/lifecycle/ViewModel;", "()V", "musicFavorite", "Landroidx/lifecycle/MutableLiveData;", "Lcom/syu/media/entities/AudioSource;", "getMusicFavorite", "()Landroidx/lifecycle/MutableLiveData;", "onlineFavorite", "Lcom/syu/media/entities/RadioSource;", "getOnlineFavorite", "radioFavorite", FinalChip.BSP_PLATFORM_Null, "getRadioFavorite", "radioFavoriteStation", "getRadioFavoriteStation", "radioName", FinalChip.BSP_PLATFORM_Null, "getRadioName", "radioReset", "getRadioReset", "uriPath", "getUriPath", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicModel extends ViewModel {
    private final MutableLiveData<AudioSource> musicFavorite;
    private final MutableLiveData<RadioSource> onlineFavorite;
    private final MutableLiveData<Boolean> radioFavorite;
    private final MutableLiveData<Boolean> radioFavoriteStation;
    private final MutableLiveData<String> radioName;
    private final MutableLiveData<Boolean> radioReset;
    private final MutableLiveData<String> uriPath;

    public MusicModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(FinalChip.BSP_PLATFORM_Null);
        this.uriPath = mutableLiveData;
        this.onlineFavorite = new MutableLiveData<>();
        this.musicFavorite = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(false);
        this.radioFavorite = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(false);
        this.radioFavoriteStation = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue(false);
        this.radioReset = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue(FinalChip.BSP_PLATFORM_Null);
        this.radioName = mutableLiveData5;
    }

    public final MutableLiveData<String> getUriPath() {
        return this.uriPath;
    }

    public final MutableLiveData<RadioSource> getOnlineFavorite() {
        return this.onlineFavorite;
    }

    public final MutableLiveData<AudioSource> getMusicFavorite() {
        return this.musicFavorite;
    }

    public final MutableLiveData<Boolean> getRadioFavorite() {
        return this.radioFavorite;
    }

    public final MutableLiveData<Boolean> getRadioFavoriteStation() {
        return this.radioFavoriteStation;
    }

    public final MutableLiveData<Boolean> getRadioReset() {
        return this.radioReset;
    }

    public final MutableLiveData<String> getRadioName() {
        return this.radioName;
    }
}
