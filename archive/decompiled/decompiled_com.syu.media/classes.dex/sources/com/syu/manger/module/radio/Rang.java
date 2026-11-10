package com.syu.manger.module.radio;

import base.event.AutoKeyEvent;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/syu/manger/module/radio/Rang;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "component1", "component2", "component3", "component4", "min", "max", "step", "stepCnt", "copy", FinalChip.BSP_PLATFORM_Null, "toString", "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", "a", "I", "getMin", "()I", "b", "getMax", "c", "getStep", "d", "getStepCnt", "<init>", "(IIII)V", "Companion", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class Rang {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Rang e = new Rang(8750, 10800, 20, 0, 8, null);
    public static final Rang f = new Rang(8750, 10800, 5, 0, 8, null);
    public static final Rang g;
    public static final Rang h;
    public static final Rang i;
    public static final Rang j;
    public static final Rang k;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int min;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int max;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int step;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int stepCnt;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/syu/manger/module/radio/Rang$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/manger/module/radio/Rang;", "USA", "Lcom/syu/manger/module/radio/Rang;", "getUSA", "()Lcom/syu/manger/module/radio/Rang;", "CHINA", "getCHINA", "OIRT", "getOIRT", "RUSSIA", "getRUSSIA", "JAPAN", "getJAPAN", "LATIN", "getLATIN", "AM", "getAM", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Rang getAM() {
            return Rang.k;
        }

        public final Rang getCHINA() {
            return Rang.f;
        }

        public final Rang getJAPAN() {
            return Rang.i;
        }

        public final Rang getLATIN() {
            return Rang.j;
        }

        public final Rang getOIRT() {
            return Rang.g;
        }

        public final Rang getRUSSIA() {
            return Rang.h;
        }

        public final Rang getUSA() {
            return Rang.e;
        }
    }

    static {
        int i2 = 0;
        int i3 = 8;
        DefaultConstructorMarker defaultConstructorMarker = null;
        g = new Rang(6500, 7400, 3, i2, i3, defaultConstructorMarker);
        int i4 = 10;
        int i5 = 0;
        int i6 = 8;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        h = new Rang(8750, 10800, i4, i5, i6, defaultConstructorMarker2);
        i = new Rang(8750, 10800, 10, i2, i3, defaultConstructorMarker);
        j = new Rang(AutoKeyEvent.KEYCODE_DVR, 1620, i4, i5, i6, defaultConstructorMarker2);
        k = new Rang(AutoKeyEvent.KEYCODE_DVR, 1620, 9, i2, i3, defaultConstructorMarker);
    }

    public Rang(int i2, int i3, int i4, int i5) {
        this.min = i2;
        this.max = i3;
        this.step = i4;
        this.stepCnt = i5;
    }

    public static /* synthetic */ Rang copy$default(Rang rang, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = rang.min;
        }
        if ((i6 & 2) != 0) {
            i3 = rang.max;
        }
        if ((i6 & 4) != 0) {
            i4 = rang.step;
        }
        if ((i6 & 8) != 0) {
            i5 = rang.stepCnt;
        }
        return rang.copy(i2, i3, i4, i5);
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

    public /* synthetic */ Rang(int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, (i6 & 8) != 0 ? (i3 - i2) / Math.max(i4, 1) : i5);
    }
}
