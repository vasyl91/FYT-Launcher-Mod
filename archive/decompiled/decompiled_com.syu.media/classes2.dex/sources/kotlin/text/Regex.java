package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import module.canbus.FinalCanbus;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, INSTANCE.ensureUnicodeCase(option.getValue()));
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern, ensureUnicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, INSTANCE.ensureUnicodeCase(RegexKt.toInt(options)));
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern, ensureU…odeCase(options.toInt()))");
        this(patternCompile);
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNullExpressionValue(enumSetAllOf, "");
        CollectionsKt.retainAll(enumSetAllOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((iFlags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.findNext(matcher, startIndex, input);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0 || startIndex > input.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + startIndex + ", input length: " + input.length());
        }
        return SequencesKt.generateSequence((Function0) new Function0<MatchResult>() { // from class: kotlin.text.Regex.findAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MatchResult invoke() {
                return Regex.this.find(input, startIndex);
            }
        }, (Function1) AnonymousClass2.INSTANCE);
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MatchResult invoke(MatchResult p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.next();
        }
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.matchEntire(matcher, input);
    }

    public final MatchResult matchAt(CharSequence input, int index) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if (matcherRegion.lookingAt()) {
            Intrinsics.checkNotNullExpressionValue(matcherRegion, "this");
            matcherMatchResult = new MatcherMatchResult(matcherRegion, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final boolean matchesAt(CharSequence input, int index) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? RangesKt.coerceAtMost(limit, 10) : 10);
        int i = limit - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i >= 0 && arrayList.size() == i) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public final Sequence<String> splitToSequence(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        return SequencesKt.sequence(new C00531(input, limit, null));
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {FinalCanbus.CAR_DJ_XP1_BIYADI_F6, FinalCanbus.CAR_AY1_ATS_NOAIRKEYBOARD, FinalCanbus.CAR_KeYuan_FYTA_MingJueRuiTeng}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class C00531 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00531(CharSequence charSequence, int i, Continuation<? super C00531> continuation) {
            super(2, continuation);
            this.$input = charSequence;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00531 c00531 = Regex.this.new C00531(this.$input, this.$limit, continuation);
            c00531.L$0 = obj;
            return c00531;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00531) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0075 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0080  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a4 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0073 -> B:21:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int iEnd;
            C00531 c00531;
            SequenceScope sequenceScope;
            Matcher matcher;
            int i;
            CharSequence charSequence;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
                Matcher matcher2 = Regex.this.nativePattern.matcher(this.$input);
                if (this.$limit == 1 || !matcher2.find()) {
                    this.label = 1;
                    if (sequenceScope2.yield(this.$input.toString(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    iEnd = 0;
                    c00531 = this;
                    sequenceScope = sequenceScope2;
                    matcher = matcher2;
                    i = 0;
                    c00531.L$0 = sequenceScope;
                    c00531.L$1 = matcher;
                    c00531.I$0 = i;
                    c00531.label = 2;
                    if (sequenceScope.yield(c00531.$input.subSequence(iEnd, matcher.start()).toString(), c00531) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iEnd = matcher.end();
                    i++;
                    if (i != c00531.$limit - 1) {
                    }
                    charSequence = c00531.$input;
                    c00531.L$0 = null;
                    c00531.L$1 = null;
                    c00531.label = 3;
                    if (sequenceScope.yield(charSequence.subSequence(iEnd, charSequence.length()).toString(), c00531) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        i = this.I$0;
                        Matcher matcher3 = (Matcher) this.L$1;
                        sequenceScope = (SequenceScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        c00531 = this;
                        matcher = matcher3;
                        iEnd = matcher.end();
                        i++;
                        if (i != c00531.$limit - 1 || !matcher.find()) {
                            charSequence = c00531.$input;
                            c00531.L$0 = null;
                            c00531.L$1 = null;
                            c00531.label = 3;
                            if (sequenceScope.yield(charSequence.subSequence(iEnd, charSequence.length()).toString(), c00531) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        c00531.L$0 = sequenceScope;
                        c00531.L$1 = matcher;
                        c00531.I$0 = i;
                        c00531.label = 2;
                        if (sequenceScope.yield(c00531.$input.subSequence(iEnd, matcher.start()).toString(), c00531) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        iEnd = matcher.end();
                        i++;
                        if (i != c00531.$limit - 1) {
                        }
                        charSequence = c00531.$input;
                        c00531.L$0 = null;
                        c00531.L$1 = null;
                        c00531.label = 3;
                        if (sequenceScope.yield(charSequence.subSequence(iEnd, charSequence.length()).toString(), c00531) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public Serialized(String pattern, int i) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }

        private Companion() {
        }

        public final Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(strQuote, "quote(literal)");
            return strQuote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(strQuoteReplacement, "quoteReplacement(literal)");
            return strQuoteReplacement;
        }
    }
}
