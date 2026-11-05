package com.syu.radio.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.entities.RadioStation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/syu/radio/viewmodel/RadioDaoModel;", "Landroidx/lifecycle/ViewModel;", "", "freq", "", "city", "Lcom/syu/radio/entities/RadioStation;", "findStationByFreqAndCity", "findStationByFreq", "Lcom/syu/radio/dao/RadioDao;", "a", "Lcom/syu/radio/dao/RadioDao;", "getRadioDao", "()Lcom/syu/radio/dao/RadioDao;", "radioDao", "<init>", "(Lcom/syu/radio/dao/RadioDao;)V", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioDaoModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final RadioDao radioDao;

    public RadioDaoModel(RadioDao radioDao) {
        Intrinsics.checkNotNullParameter(radioDao, "radioDao");
        this.radioDao = radioDao;
    }

    public final RadioStation findStationByFreq(int freq) {
        return this.radioDao.findStationByFreq(freq);
    }

    public final RadioStation findStationByFreqAndCity(int freq, String city) {
        Intrinsics.checkNotNullParameter(city, "city");
        Log.e("radio", "--------------- findStationByFreqAndCity : " + freq + " -- " + city);
        return this.radioDao.findStationByFreqAndCity(freq, city);
    }

    public final RadioDao getRadioDao() {
        return this.radioDao;
    }
}
