package com.syu.manger.module.radio;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\u0007HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0007HÖ\u0001R\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/syu/manger/module/radio/Station;", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "toString", FinalChip.BSP_PLATFORM_Null, "component1", "component2", "component3", "index", "freq", "band", "copy", "hashCode", "a", "I", "getIndex", "()I", "setIndex", "(I)V", "b", "getFreq", "setFreq", "c", "getBand", "setBand", "d", "Z", "isFm", "()Z", "setFm", "(Z)V", "<init>", "(III)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class Station {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int index;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int freq;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int band;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean isFm;

    public Station(int i, int i2, int i3) {
        this.index = i;
        this.freq = i2;
        this.band = i3;
        this.isFm = i3 >= 65536 && i3 < 131072;
    }

    public static /* synthetic */ Station copy$default(Station station, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = station.index;
        }
        if ((i4 & 2) != 0) {
            i2 = station.freq;
        }
        if ((i4 & 4) != 0) {
            i3 = station.band;
        }
        return station.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFreq() {
        return this.freq;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBand() {
        return this.band;
    }

    public final Station copy(int index, int freq, int band) {
        return new Station(index, freq, band);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Station)) {
            return super.equals(other);
        }
        Station station = (Station) other;
        return station.index == this.index && station.band == this.band;
    }

    public final int getBand() {
        return this.band;
    }

    public final int getFreq() {
        return this.freq;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return Integer.hashCode(this.band) + ((Integer.hashCode(this.freq) + (Integer.hashCode(this.index) * 31)) * 31);
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

    public final void setIndex(int i) {
        this.index = i;
    }

    public String toString() {
        return "Station(index=" + this.index + ", freq=" + this.freq + ", band=" + this.band + ", isFm=" + this.isFm + ')';
    }

    public /* synthetic */ Station(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, i2, i3);
    }
}
