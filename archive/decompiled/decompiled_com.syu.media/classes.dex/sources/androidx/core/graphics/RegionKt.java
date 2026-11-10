package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import chip.FinalChip;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: Region.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", FinalChip.BSP_PLATFORM_Null, "p", "Landroid/graphics/Point;", "forEach", FinalChip.BSP_PLATFORM_Null, "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", FinalChip.BSP_PLATFORM_Null, "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class RegionKt {
    public static final boolean contains(Region region, Point point) {
        Intrinsics.checkParameterIsNotNull(region, "$this$contains");
        Intrinsics.checkParameterIsNotNull(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final Region plus(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$plus");
        Intrinsics.checkParameterIsNotNull(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$plus");
        Intrinsics.checkParameterIsNotNull(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region minus(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$minus");
        Intrinsics.checkParameterIsNotNull(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region minus(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$minus");
        Intrinsics.checkParameterIsNotNull(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    public static final Region unaryMinus(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$unaryMinus");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region and(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$and");
        Intrinsics.checkParameterIsNotNull(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$and");
        Intrinsics.checkParameterIsNotNull(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final Region xor(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$xor");
        Intrinsics.checkParameterIsNotNull(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final Region xor(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$xor");
        Intrinsics.checkParameterIsNotNull(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(region, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                function1.invoke(rect);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Region.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", FinalChip.BSP_PLATFORM_Null, "Landroid/graphics/Rect;", "hasMore", FinalChip.BSP_PLATFORM_Null, "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class AnonymousClass1 implements Iterator<Rect>, KMappedMarker {
        final /* synthetic */ Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(Region region) {
            this.$this_iterator = region;
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (this.hasMore) {
                Rect rect = new Rect(this.rect);
                this.hasMore = this.iterator.next(this.rect);
                return rect;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$iterator");
        return new AnonymousClass1(region);
    }

    public static final Region not(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$not");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$or");
        Intrinsics.checkParameterIsNotNull(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region or(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$or");
        Intrinsics.checkParameterIsNotNull(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }
}
