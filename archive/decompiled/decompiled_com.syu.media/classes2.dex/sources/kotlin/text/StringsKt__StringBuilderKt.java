package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "this.append(obj)");
        return sbAppend;
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final String buildString(int i, Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i);
        builderAction.invoke(sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final StringBuilder append(StringBuilder sb, String... value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, Object... value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append('\\n')");
        return sbAppend;
    }

    private static final StringBuilder appendLine(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }

    private static final StringBuilder appendLine(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }

    private static final StringBuilder appendLine(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }

    private static final StringBuilder appendLine(StringBuilder sb, char[] value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = sb.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }

    private static final StringBuilder appendLine(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(c);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }

    private static final StringBuilder appendLine(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder sbAppend = sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringBuilder sbAppend2 = sbAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append('\\n')");
        return sbAppend2;
    }
}
