package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: ULongRange.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002ø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\b\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j;
        this.last = UProgressionUtilKt.m1246getProgressionLastElement7ftBX0g(j, j2, j3);
        this.step = j3;
    }

    /* JADX INFO: renamed from: getFirst-s-VKNKU, reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-s-VKNKU, reason: not valid java name and from getter */
    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(getFirst(), getLast(), this.step, null);
    }

    public boolean isEmpty() {
        long j = this.step;
        long first = getFirst();
        long last = getLast();
        if (j > 0) {
            if (UnsignedKt.ulongCompare(first, last) > 0) {
                return true;
            }
        } else if (UnsignedKt.ulongCompare(first, last) < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        if (other instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) other).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) other;
                if (getFirst() != uLongProgression.getFirst() || getLast() != uLongProgression.getLast() || this.step != uLongProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        int iM228constructorimpl = ((((int) ULong.m228constructorimpl(getFirst() ^ ULong.m228constructorimpl(getFirst() >>> 32))) * 31) + ((int) ULong.m228constructorimpl(getLast() ^ ULong.m228constructorimpl(getLast() >>> 32)))) * 31;
        long j = this.step;
        return iM228constructorimpl + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbAppend;
        long j;
        if (this.step > 0) {
            sbAppend = new StringBuilder().append((Object) ULong.m273toStringimpl(getFirst())).append("..").append((Object) ULong.m273toStringimpl(getLast())).append(" step ");
            j = this.step;
        } else {
            sbAppend = new StringBuilder().append((Object) ULong.m273toStringimpl(getFirst())).append(" downTo ").append((Object) ULong.m273toStringimpl(getLast())).append(" step ");
            j = -this.step;
        }
        return sbAppend.append(j).toString();
    }

    /* JADX INFO: compiled from: ULongRange.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m1269fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
