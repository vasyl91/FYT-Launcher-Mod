package com.syu.media.online.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.media.entities.RadioSource;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnlineViewModel.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/syu/media/online/viewmodel/OnlineViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "countryName", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "getCountryName", "()Landroidx/lifecycle/MutableLiveData;", "onlineDataChange", "Lcom/syu/media/entities/RadioSource;", "getOnlineDataChange", "radioCityName", "getRadioCityName", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineViewModel extends ViewModel {
    private final MutableLiveData<String> countryName;
    private final MutableLiveData<RadioSource> onlineDataChange;
    private final MutableLiveData<String> radioCityName;

    public OnlineViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(FinalChip.BSP_PLATFORM_Null);
        this.countryName = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(FinalChip.BSP_PLATFORM_Null);
        this.radioCityName = mutableLiveData2;
        this.onlineDataChange = new MutableLiveData<>();
    }

    public final MutableLiveData<String> getCountryName() {
        return this.countryName;
    }

    public final MutableLiveData<String> getRadioCityName() {
        return this.radioCityName;
    }

    public final MutableLiveData<RadioSource> getOnlineDataChange() {
        return this.onlineDataChange;
    }
}
