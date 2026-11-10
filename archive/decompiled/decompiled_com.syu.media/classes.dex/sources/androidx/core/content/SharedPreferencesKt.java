package androidx.core.content;

import android.content.SharedPreferences;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferences.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {"edit", FinalChip.BSP_PLATFORM_Null, "Landroid/content/SharedPreferences;", "commit", FinalChip.BSP_PLATFORM_Null, "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class SharedPreferencesKt {
    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "$this$edit");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(editorEdit, "editor");
        function1.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static final void edit(SharedPreferences sharedPreferences, boolean z, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "$this$edit");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(editorEdit, "editor");
        function1.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
