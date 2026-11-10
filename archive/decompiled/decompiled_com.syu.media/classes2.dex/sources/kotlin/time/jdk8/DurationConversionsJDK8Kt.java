package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: DurationConversions.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 6, 0}, pn = "kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return kotlin.time.Duration.m1376plusLRDsOJo(DurationKt.toDuration(duration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(duration.getNano(), DurationUnit.NANOSECONDS));
    }

    /* JADX INFO: renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m1474toJavaDurationLRDsOJo(long j) {
        Duration durationOfSeconds = Duration.ofSeconds(kotlin.time.Duration.m1361getInWholeSecondsimpl(j), kotlin.time.Duration.m1363getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toJavaDuration-LRDsOJo");
        return durationOfSeconds;
    }
}
