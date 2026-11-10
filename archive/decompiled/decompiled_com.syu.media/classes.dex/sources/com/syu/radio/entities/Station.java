package com.syu.radio.entities;

import chip.FinalChip;
import com.syu.manger.module.radio.RadioUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/syu/radio/entities/Station;", FinalChip.BSP_PLATFORM_Null, "index", FinalChip.BSP_PLATFORM_Null, "id", "freq", "band", "(IIII)V", "getBand", "()I", "setBand", "(I)V", "getFreq", "setFreq", "getId", "setId", "getIndex", "setIndex", "isFm", FinalChip.BSP_PLATFORM_Null, "()Z", "setFm", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", FinalChip.BSP_PLATFORM_Null, "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class Station {
    private int band;
    private int freq;
    private int id;
    private int index;
    private boolean isFm;

    public Station(int i, int i2, int i3, int i4) {
        this.index = i;
        this.id = i2;
        this.freq = i3;
        this.band = i4;
        this.isFm = RadioUtils.INSTANCE.isFmFreq(i3);
    }

    public static /* synthetic */ Station copy$default(Station station, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = station.index;
        }
        if ((i5 & 2) != 0) {
            i2 = station.id;
        }
        if ((i5 & 4) != 0) {
            i3 = station.freq;
        }
        if ((i5 & 8) != 0) {
            i4 = station.band;
        }
        return station.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFreq() {
        return this.freq;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBand() {
        return this.band;
    }

    public final Station copy(int index, int id, int freq, int band) {
        return new Station(index, id, freq, band);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Station)) {
            return super.equals(other);
        }
        Station station = (Station) other;
        return station.id == this.id && station.band == this.band;
    }

    public final int getBand() {
        return this.band;
    }

    public final int getFreq() {
        return this.freq;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return Integer.hashCode(this.band) + ((Integer.hashCode(this.freq) + ((Integer.hashCode(this.id) + (Integer.hashCode(this.index) * 31)) * 31)) * 31);
    }

    /* JADX INFO: renamed from: isFm, reason: from getter */
    public final boolean getIsFm() {
        return this.isFm;
    }

    public final void setBand(int i) {
        this.band = i;
    }

    public final void setFm(boolean z) {
        this.isFm = z;
    }

    public final void setFreq(int i) {
        this.freq = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public String toString() {
        return "Station(index=" + this.index + ", id=" + this.id + ", freq=" + this.freq + ", band=" + this.band + ", isFm=" + this.isFm + ')';
    }
}
