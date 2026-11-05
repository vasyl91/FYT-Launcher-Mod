package com.syu.radio.entities;

import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/syu/radio/entities/Channel;", FinalChip.BSP_PLATFORM_Null, "id", FinalChip.BSP_PLATFORM_Null, "freq", "(II)V", "getFreq", "()I", "setFreq", "(I)V", "getId", "setId", "component1", "component2", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", FinalChip.BSP_PLATFORM_Null, "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class Channel {
    private int freq;
    private int id;

    public Channel(int i, int i2) {
        this.id = i;
        this.freq = i2;
    }

    public static /* synthetic */ Channel copy$default(Channel channel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = channel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = channel.freq;
        }
        return channel.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFreq() {
        return this.freq;
    }

    public final Channel copy(int id, int freq) {
        return new Channel(id, freq);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Station)) {
            return super.equals(other);
        }
        Station station = (Station) other;
        return station.getFreq() == station.getFreq();
    }

    public final int getFreq() {
        return this.freq;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return Integer.hashCode(this.freq) + (Integer.hashCode(this.id) * 31);
    }

    public final void setFreq(int i) {
        this.freq = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public String toString() {
        return "Channel(id=" + this.id + ", freq=" + this.freq + ')';
    }
}
