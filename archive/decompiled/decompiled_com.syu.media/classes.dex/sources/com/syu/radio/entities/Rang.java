package com.syu.radio.entities;

import base.event.AutoKeyEvent;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/syu/radio/entities/Rang;", FinalChip.BSP_PLATFORM_Null, "min", FinalChip.BSP_PLATFORM_Null, "max", "step", "stepCnt", "(IIII)V", "getMax", "()I", "getMin", "getStep", "getStepCnt", "component1", "component2", "component3", "component4", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", FinalChip.BSP_PLATFORM_Null, "Companion", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class Rang {
    private static final Rang AM;
    private static final Rang JAPAN;
    private static final Rang LATIN;
    private static final Rang OIRT;
    private static final Rang RUSSIA;
    private final int max;
    private final int min;
    private final int step;
    private final int stepCnt;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Rang USA = new Rang(8750, 10800, 20, 0, 8, null);
    private static final Rang CHINA = new Rang(8750, 10800, 5, 0, 8, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/syu/radio/entities/Rang$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "AM", "Lcom/syu/radio/entities/Rang;", "getAM", "()Lcom/syu/radio/entities/Rang;", "CHINA", "getCHINA", "JAPAN", "getJAPAN", "LATIN", "getLATIN", "OIRT", "getOIRT", "RUSSIA", "getRUSSIA", "USA", "getUSA", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Rang getAM() {
            return Rang.AM;
        }

        public final Rang getCHINA() {
            return Rang.CHINA;
        }

        public final Rang getJAPAN() {
            return Rang.JAPAN;
        }

        public final Rang getLATIN() {
            return Rang.LATIN;
        }

        public final Rang getOIRT() {
            return Rang.OIRT;
        }

        public final Rang getRUSSIA() {
            return Rang.RUSSIA;
        }

        public final Rang getUSA() {
            return Rang.USA;
        }
    }

    static {
        int i = 0;
        int i2 = 8;
        DefaultConstructorMarker defaultConstructorMarker = null;
        OIRT = new Rang(6500, 7400, 3, i, i2, defaultConstructorMarker);
        int i3 = 10;
        int i4 = 0;
        int i5 = 8;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        RUSSIA = new Rang(8750, 10800, i3, i4, i5, defaultConstructorMarker2);
        JAPAN = new Rang(8750, 10800, 10, i, i2, defaultConstructorMarker);
        LATIN = new Rang(AutoKeyEvent.KEYCODE_DVR, 1620, i3, i4, i5, defaultConstructorMarker2);
        AM = new Rang(AutoKeyEvent.KEYCODE_DVR, 1620, 9, i, i2, defaultConstructorMarker);
    }

    public Rang(int i, int i2, int i3, int i4) {
        this.min = i;
        this.max = i2;
        this.step = i3;
        this.stepCnt = i4;
    }

    public static /* synthetic */ Rang copy$default(Rang rang, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = rang.min;
        }
        if ((i5 & 2) != 0) {
            i2 = rang.max;
        }
        if ((i5 & 4) != 0) {
            i3 = rang.step;
        }
        if ((i5 & 8) != 0) {
            i4 = rang.stepCnt;
        }
        return rang.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStep() {
        return this.step;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getStepCnt() {
        return this.stepCnt;
    }

    public final Rang copy(int min, int max, int step, int stepCnt) {
        return new Rang(min, max, step, stepCnt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rang)) {
            return false;
        }
        Rang rang = (Rang) other;
        return this.min == rang.min && this.max == rang.max && this.step == rang.step && this.stepCnt == rang.stepCnt;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getStep() {
        return this.step;
    }

    public final int getStepCnt() {
        return this.stepCnt;
    }

    public int hashCode() {
        return Integer.hashCode(this.stepCnt) + ((Integer.hashCode(this.step) + ((Integer.hashCode(this.max) + (Integer.hashCode(this.min) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "Rang(min=" + this.min + ", max=" + this.max + ", step=" + this.step + ", stepCnt=" + this.stepCnt + ')';
    }

    public /* synthetic */ Rang(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? (i2 - i) / i3 : i4);
    }
}
