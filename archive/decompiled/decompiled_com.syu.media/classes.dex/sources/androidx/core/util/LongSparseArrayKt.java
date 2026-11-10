package androidx.core.util;

import android.util.LongSparseArray;
import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: LongSparseArray.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0018\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0002\u001a&\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010$\u001a\u001e\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, d2 = {"size", FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", FinalChip.BSP_PLATFORM_Null, "key", FinalChip.BSP_PLATFORM_Null, "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", FinalChip.BSP_PLATFORM_Null, "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class LongSparseArrayKt {
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$size");
        return longSparseArray.size();
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$contains");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$set");
        longSparseArray.put(j, t);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$containsKey");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$containsValue");
        return longSparseArray.indexOfValue(t) != -1;
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$getOrDefault");
        T t2 = longSparseArray.get(j);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : (T) function0.invoke();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$isEmpty");
        return longSparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$isNotEmpty");
        return longSparseArray.size() != 0;
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$remove");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey == -1 || !Intrinsics.areEqual(t, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$keyIterator");
        return new LongIterator() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            public final void setIndex(int i) {
                this.index = i;
            }

            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            public long nextLong() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LongSparseArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"androidx/core/util/LongSparseArrayKt$valueIterator$1", FinalChip.BSP_PLATFORM_Null, "index", FinalChip.BSP_PLATFORM_Null, "getIndex", "()I", "setIndex", "(I)V", "hasNext", FinalChip.BSP_PLATFORM_Null, "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class C00311<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C00311(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) longSparseArray.valueAt(i);
        }
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$valueIterator");
        return new C00311(longSparseArray);
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }
}
