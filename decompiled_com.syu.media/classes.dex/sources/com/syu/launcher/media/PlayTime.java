package com.syu.launcher.media;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0005J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\nHÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001R\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/syu/launcher/media/PlayTime;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "toString", "isValid", FinalChip.BSP_PLATFORM_Null, "component1", "component2", Media.DURATION, "currentTimeMs", "copy", "a", "J", "getDuration", "()J", "setDuration", "(J)V", "b", "getCurrentTimeMs", "setCurrentTimeMs", "<init>", "(JJ)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PlayTime {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public long duration;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public long currentTimeMs;

    public PlayTime() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ PlayTime copy$default(PlayTime playTime, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = playTime.duration;
        }
        if ((i & 2) != 0) {
            j2 = playTime.currentTimeMs;
        }
        return playTime.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCurrentTimeMs() {
        return this.currentTimeMs;
    }

    public final PlayTime copy(long duration, long currentTimeMs) {
        return new PlayTime(duration, currentTimeMs);
    }

    public boolean equals(Object other) {
        if (!(other instanceof PlayTime)) {
            return super.equals(other);
        }
        PlayTime playTime = (PlayTime) other;
        return this.duration == playTime.duration && this.currentTimeMs == playTime.currentTimeMs;
    }

    public final long getCurrentTimeMs() {
        return this.currentTimeMs;
    }

    public final long getDuration() {
        return this.duration;
    }

    public int hashCode() {
        return new StringBuilder().append(this.duration).append('-').append(this.currentTimeMs).toString().hashCode();
    }

    public final boolean isValid() {
        long j = this.duration;
        long j2 = this.currentTimeMs;
        return 0 <= j2 && j2 <= j;
    }

    public final void setCurrentTimeMs(long j) {
        this.currentTimeMs = j;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public String toString() {
        return "PlayTime: " + this.duration + " - " + this.currentTimeMs + "  ";
    }

    public PlayTime(long j, long j2) {
        this.duration = j;
        this.currentTimeMs = j2;
    }

    public /* synthetic */ PlayTime(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? -1L : j2);
    }
}
