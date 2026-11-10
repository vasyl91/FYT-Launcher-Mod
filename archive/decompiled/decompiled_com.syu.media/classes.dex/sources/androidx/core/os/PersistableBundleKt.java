package androidx.core.os;

import android.os.PersistableBundle;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistableBundle.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", FinalChip.BSP_PLATFORM_Null, "Lkotlin/Pair;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class PersistableBundleKt {
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairArr) throws TypeCastException {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object objComponent2 = pair.component2();
            if (objComponent2 == null) {
                persistableBundle.putString(str, null);
            } else if (objComponent2 instanceof Boolean) {
                persistableBundle.putBoolean(str, ((Boolean) objComponent2).booleanValue());
            } else if (objComponent2 instanceof Double) {
                persistableBundle.putDouble(str, ((Number) objComponent2).doubleValue());
            } else if (objComponent2 instanceof Integer) {
                persistableBundle.putInt(str, ((Number) objComponent2).intValue());
            } else if (objComponent2 instanceof Long) {
                persistableBundle.putLong(str, ((Number) objComponent2).longValue());
            } else if (objComponent2 instanceof String) {
                persistableBundle.putString(str, (String) objComponent2);
            } else if (objComponent2 instanceof boolean[]) {
                persistableBundle.putBooleanArray(str, (boolean[]) objComponent2);
            } else if (objComponent2 instanceof double[]) {
                persistableBundle.putDoubleArray(str, (double[]) objComponent2);
            } else if (objComponent2 instanceof int[]) {
                persistableBundle.putIntArray(str, (int[]) objComponent2);
            } else if (objComponent2 instanceof long[]) {
                persistableBundle.putLongArray(str, (long[]) objComponent2);
            } else if (objComponent2 instanceof Object[]) {
                Class<?> componentType = objComponent2.getClass().getComponentType();
                if (componentType == null) {
                    Intrinsics.throwNpe();
                }
                if (!String.class.isAssignableFrom(componentType)) {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                }
                if (objComponent2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                persistableBundle.putStringArray(str, (String[]) objComponent2);
            } else {
                throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return persistableBundle;
    }
}
