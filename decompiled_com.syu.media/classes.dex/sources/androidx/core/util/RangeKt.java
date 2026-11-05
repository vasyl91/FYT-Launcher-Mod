package androidx.core.util;

import android.util.Range;
import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"and", "Landroid/util/Range;", ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class RangeKt {
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        Intrinsics.checkParameterIsNotNull(t, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(t2, "that");
        return new Range<>(t, t2);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Range<T> rangeExtend = range.extend(t);
        Intrinsics.checkExpressionValueIsNotNull(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        Intrinsics.checkExpressionValueIsNotNull(rangeExtend, "extend(other)");
        return rangeExtend;
    }

    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$and");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        Intrinsics.checkExpressionValueIsNotNull(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(final Range<T> range) {
        Intrinsics.checkParameterIsNotNull(range, "$this$toClosedRange");
        return new ClosedRange<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public boolean contains(Comparable comparable) {
                Intrinsics.checkParameterIsNotNull(comparable, "value");
                return ClosedRange.DefaultImpls.contains(this, comparable);
            }

            public boolean isEmpty() {
                return ClosedRange.DefaultImpls.isEmpty(this);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            public Comparable getStart() {
                return range.getLower();
            }
        };
    }

    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$this$toRange");
        return new Range<>(closedRange.getStart(), closedRange.getEndInclusive());
    }
}
