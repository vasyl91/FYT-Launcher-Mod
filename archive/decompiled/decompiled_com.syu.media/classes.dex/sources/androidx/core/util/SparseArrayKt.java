package androidx.core.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, d2 = {"size", FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", FinalChip.BSP_PLATFORM_Null, "key", "containsKey", "containsValue", "value", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", FinalChip.BSP_PLATFORM_Null, "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class SparseArrayKt {
    public static final <T> int getSize(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$size");
        return sparseArray.size();
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$contains");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$set");
        sparseArray.put(i, t);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$containsKey");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$containsValue");
        return sparseArray.indexOfValue(t) != -1;
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$getOrDefault");
        T t2 = sparseArray.get(i);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = sparseArray.get(i);
        return t != null ? t : (T) function0.invoke();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$isEmpty");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$isNotEmpty");
        return sparseArray.size() != 0;
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$remove");
        int iIndexOfKey = sparseArray.indexOfKey(i);
        if (iIndexOfKey == -1 || !Intrinsics.areEqual(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> IntIterator keyIterator(final SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$keyIterator");
        return new IntIterator() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            public final void setIndex(int i) {
                this.index = i;
            }

            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            public int nextInt() {
                SparseArray sparseArray2 = sparseArray;
                int i = this.index;
                this.index = i + 1;
                return sparseArray2.keyAt(i);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SparseArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"androidx/core/util/SparseArrayKt$valueIterator$1", FinalChip.BSP_PLATFORM_Null, "index", FinalChip.BSP_PLATFORM_Null, "getIndex", "()I", "setIndex", "(I)V", "hasNext", FinalChip.BSP_PLATFORM_Null, "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class C00321<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArray $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C00321(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
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
            SparseArray sparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) sparseArray.valueAt(i);
        }
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$valueIterator");
        return new C00321(sparseArray);
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }
}
