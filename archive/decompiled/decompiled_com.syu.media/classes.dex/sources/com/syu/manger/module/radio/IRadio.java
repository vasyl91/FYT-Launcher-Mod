package com.syu.manger.module.radio;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\tH&¨\u0006%"}, d2 = {"Lcom/syu/manger/module/radio/IRadio;", FinalChip.BSP_PLATFORM_Null, "adaptiveSensitivity", FinalChip.BSP_PLATFORM_Null, "enable", FinalChip.BSP_PLATFORM_Null, "band", "configAmSensitivity", "value", FinalChip.BSP_PLATFORM_Null, "configFmSensitivity", "default", "freqDown", "freqUp", Media.LOCAL, "nextStation", "prevStation", "ptySeekStation", "ptyId", "rdsAfEanble", "rdsEnable", "rdsTaEanble", "save", "saveChannel", "channel", "scanStation", "searchStation", "seekNextStation", "seekPrevStation", "selectArea", "area", "stereo", "switchFmOrAm", "toBand", "toChannel", "toFreq", "freq", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IRadio {
    void adaptiveSensitivity(boolean enable);

    void band();

    void configAmSensitivity(int value);

    void configFmSensitivity(int value);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    void mo73default();

    void freqDown();

    void freqUp();

    void local(boolean enable);

    void nextStation();

    void prevStation();

    void ptySeekStation(int ptyId);

    void rdsAfEanble(boolean enable);

    void rdsEnable(boolean enable);

    void rdsTaEanble(boolean enable);

    void save();

    void saveChannel(int channel);

    void scanStation();

    void searchStation();

    void seekNextStation();

    void seekPrevStation();

    void selectArea(int area);

    void stereo(boolean enable);

    void switchFmOrAm();

    void toBand(int band);

    void toChannel(int channel);

    void toFreq(int freq);
}
