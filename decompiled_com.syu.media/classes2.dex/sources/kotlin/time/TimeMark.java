package kotlin.time;

import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/time/TimeMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", XmlErrorCodes.DURATION, "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TimeMark {
    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    public abstract long mo1333elapsedNowUwyO8pc();

    /* JADX INFO: renamed from: plus-LRDsOJo */
    public TimeMark mo1334plusLRDsOJo(long duration) {
        return new AdjustedTimeMark(this, duration, null);
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public TimeMark m1469minusLRDsOJo(long duration) {
        return mo1334plusLRDsOJo(Duration.m1392unaryMinusUwyO8pc(duration));
    }

    public final boolean hasPassedNow() {
        return !Duration.m1373isNegativeimpl(mo1333elapsedNowUwyO8pc());
    }

    public final boolean hasNotPassedNow() {
        return Duration.m1373isNegativeimpl(mo1333elapsedNowUwyO8pc());
    }
}
