package com.syu.manger.module.bt;

import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.module.JMutableLiveData;
import com.syu.media.provider.Media;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007R\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002010\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007¨\u00067"}, d2 = {"Lcom/syu/manger/module/bt/BluetoothModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/syu/manger/module/JMutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Lcom/syu/manger/module/JMutableLiveData;", "getBluetoothState", "()Lcom/syu/manger/module/JMutableLiveData;", "bluetoothState", FinalChip.BSP_PLATFORM_Null, "b", "getConnectedDevName", "connectedDevName", "c", "getConnectedDevMac", "connectedDevMac", "d", "getAlbum", Media.ALBUM, "e", "getArtist", Media.ARTIST, "f", "getIconPath", "iconPath", "g", "getTitle", "title", "h", "getPlayTime", "playTime", "i", "getTotalTime", "totalTime", "j", "getPlayTrack", "playTrack", "k", "getTotalTrack", "totalTrack", FinalChip.BSP_PLATFORM_Null, "l", "isBtAvPlaying", "m", "getPhoneSignal", "phoneSignal", "n", "getPhoneBattery", "phoneBattery", FinalChip.BSP_PLATFORM_Null, "o", "getTrackChanged", "trackChanged", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class BluetoothModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final JMutableLiveData bluetoothState = new JMutableLiveData();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final JMutableLiveData connectedDevName = new JMutableLiveData();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final JMutableLiveData connectedDevMac;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final JMutableLiveData album;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final JMutableLiveData artist;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final JMutableLiveData iconPath;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final JMutableLiveData title;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final JMutableLiveData playTime;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final JMutableLiveData totalTime;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final JMutableLiveData playTrack;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final JMutableLiveData totalTrack;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final JMutableLiveData isBtAvPlaying;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final JMutableLiveData phoneSignal;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final JMutableLiveData phoneBattery;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final JMutableLiveData trackChanged;

    public BluetoothModel() {
        JMutableLiveData jMutableLiveData = new JMutableLiveData();
        jMutableLiveData.setValue(FinalChip.BSP_PLATFORM_Null);
        this.connectedDevMac = jMutableLiveData;
        JMutableLiveData jMutableLiveData2 = new JMutableLiveData();
        jMutableLiveData2.setValue(FinalChip.BSP_PLATFORM_Null);
        this.album = jMutableLiveData2;
        JMutableLiveData jMutableLiveData3 = new JMutableLiveData();
        jMutableLiveData3.setValue(FinalChip.BSP_PLATFORM_Null);
        this.artist = jMutableLiveData3;
        JMutableLiveData jMutableLiveData4 = new JMutableLiveData();
        jMutableLiveData4.setValue(FinalChip.BSP_PLATFORM_Null);
        this.iconPath = jMutableLiveData4;
        JMutableLiveData jMutableLiveData5 = new JMutableLiveData();
        jMutableLiveData5.setValue(FinalChip.BSP_PLATFORM_Null);
        this.title = jMutableLiveData5;
        JMutableLiveData jMutableLiveData6 = new JMutableLiveData();
        jMutableLiveData6.setValue(-1);
        this.playTime = jMutableLiveData6;
        JMutableLiveData jMutableLiveData7 = new JMutableLiveData();
        jMutableLiveData7.setValue(-1);
        this.totalTime = jMutableLiveData7;
        JMutableLiveData jMutableLiveData8 = new JMutableLiveData();
        jMutableLiveData8.setValue(-1);
        this.playTrack = jMutableLiveData8;
        JMutableLiveData jMutableLiveData9 = new JMutableLiveData();
        jMutableLiveData9.setValue(-1);
        this.totalTrack = jMutableLiveData9;
        JMutableLiveData jMutableLiveData10 = new JMutableLiveData();
        jMutableLiveData10.setValue(Boolean.FALSE);
        this.isBtAvPlaying = jMutableLiveData10;
        JMutableLiveData jMutableLiveData11 = new JMutableLiveData();
        jMutableLiveData11.setValue(0);
        this.phoneSignal = jMutableLiveData11;
        JMutableLiveData jMutableLiveData12 = new JMutableLiveData();
        jMutableLiveData12.setValue(FinalChip.BSP_PLATFORM_Null);
        this.phoneBattery = jMutableLiveData12;
        JMutableLiveData jMutableLiveData13 = new JMutableLiveData();
        jMutableLiveData13.setValue(-1L);
        this.trackChanged = jMutableLiveData13;
    }

    public final JMutableLiveData<String> getAlbum() {
        return this.album;
    }

    public final JMutableLiveData<String> getArtist() {
        return this.artist;
    }

    public final JMutableLiveData<Integer> getBluetoothState() {
        return this.bluetoothState;
    }

    public final JMutableLiveData<String> getConnectedDevMac() {
        return this.connectedDevMac;
    }

    public final JMutableLiveData<String> getConnectedDevName() {
        return this.connectedDevName;
    }

    public final JMutableLiveData<String> getIconPath() {
        return this.iconPath;
    }

    public final JMutableLiveData<String> getPhoneBattery() {
        return this.phoneBattery;
    }

    public final JMutableLiveData<Integer> getPhoneSignal() {
        return this.phoneSignal;
    }

    public final JMutableLiveData<Integer> getPlayTime() {
        return this.playTime;
    }

    public final JMutableLiveData<Integer> getPlayTrack() {
        return this.playTrack;
    }

    public final JMutableLiveData<String> getTitle() {
        return this.title;
    }

    public final JMutableLiveData<Integer> getTotalTime() {
        return this.totalTime;
    }

    public final JMutableLiveData<Integer> getTotalTrack() {
        return this.totalTrack;
    }

    public final JMutableLiveData<Long> getTrackChanged() {
        return this.trackChanged;
    }

    public final JMutableLiveData<Boolean> isBtAvPlaying() {
        return this.isBtAvPlaying;
    }
}
