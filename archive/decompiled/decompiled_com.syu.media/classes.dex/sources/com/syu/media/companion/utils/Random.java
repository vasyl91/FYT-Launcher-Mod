package com.syu.media.companion.utils;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/syu/media/companion/utils/Random;", FinalChip.BSP_PLATFORM_Null, "()V", "random", FinalChip.BSP_PLATFORM_Null, "min", "max", "skip", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Random {
    public static final Random INSTANCE = new Random();

    private Random() {
    }

    public static /* synthetic */ int random$default(Random random, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return random.random(i, i2, i3);
    }

    public final int random(int min, int max, int skip) {
        int iRandom = RangesKt.random(new IntRange(min, max), kotlin.random.Random.Default);
        return iRandom == skip ? random(min, max, skip) : iRandom;
    }
}
