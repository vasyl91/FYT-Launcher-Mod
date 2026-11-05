package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", FinalChip.BSP_PLATFORM_Null, "Landroid/text/Spannable;", "set", "start", FinalChip.BSP_PLATFORM_Null, "end", "span", FinalChip.BSP_PLATFORM_Null, "range", "Lkotlin/ranges/IntRange;", "toSpannable", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$toSpannable");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(spannableStringValueOf, "SpannableString.valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void clearSpans(Spannable spannable) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$clearSpans");
        Spannable spannable2 = spannable;
        Object[] spans = spannable2.getSpans(0, spannable2.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$set");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$set");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }
}
