package com.syu.radio.dao;

import chip.FinalChip;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H'¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH'J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u0010H'J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u0010H'J\u001e\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eH'J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eH'J\u001e\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eH'J!\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H'¢\u0006\u0002\u0010\bJ\u001f\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H'¢\u0006\u0002\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/syu/radio/dao/RadioDao;", FinalChip.BSP_PLATFORM_Null, "()V", "delete", FinalChip.BSP_PLATFORM_Null, "stations", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/entities/RadioStation;", "([Lcom/syu/radio/entities/RadioStation;)V", "findStationByFreq", "freq", FinalChip.BSP_PLATFORM_Null, "findStationByFreqAndCity", Radio.CITY, FinalChip.BSP_PLATFORM_Null, "getAllStations", "Lkotlinx/coroutines/flow/Flow;", FinalChip.BSP_PLATFORM_Null, "getExistsRadioStation", "getFavorites", "getFavoritesWithCity", "getStationsByCity", "getStationsByCityFlow", "insert", "insertNoExists", "update", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class RadioDao {
    public abstract void delete(RadioStation... stations);

    public abstract RadioStation findStationByFreq(int freq);

    public abstract RadioStation findStationByFreqAndCity(int freq, String city);

    public abstract Flow<List<RadioStation>> getAllStations();

    public abstract RadioStation getExistsRadioStation(int freq, String city);

    public abstract Flow<List<RadioStation>> getFavorites();

    public abstract Flow<List<RadioStation>> getFavoritesWithCity(String city);

    public abstract List<RadioStation> getStationsByCity(String city);

    public abstract Flow<List<RadioStation>> getStationsByCityFlow(String city);

    public abstract void insert(RadioStation... stations);

    public final void insertNoExists(RadioStation... stations) {
        Intrinsics.checkNotNullParameter(stations, "stations");
        if (!(stations.length == 0)) {
            for (RadioStation radioStation : stations) {
                Integer freq = radioStation.getFreq();
                Intrinsics.checkNotNull(freq);
                int iIntValue = freq.intValue();
                String city = radioStation.getCity();
                Intrinsics.checkNotNull(city);
                if (getExistsRadioStation(iIntValue, city) == null) {
                    insert(radioStation);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public abstract void update(RadioStation... stations);
}
