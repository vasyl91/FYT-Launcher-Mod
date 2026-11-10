package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0003*)\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsJvmKt {
    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(completion);
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, completion);
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function3, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(continuationProbeCoroutineCreated);
        }
        final CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuationProbeCoroutineCreated) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object result) throws Throwable {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        ResultKt.throwOnFailure(result);
                        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(this);
                    }
                    if (i == 1) {
                        this.label = 2;
                        ResultKt.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            };
        }
        return new ContinuationImpl(continuationProbeCoroutineCreated, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    ResultKt.throwOnFailure(result);
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(this);
                }
                if (i == 1) {
                    this.label = 2;
                    ResultKt.throwOnFailure(result);
                    return result;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, continuationProbeCoroutineCreated);
        }
        final CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuationProbeCoroutineCreated) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object result) throws Throwable {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(result);
                    return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, this);
                }
            };
        }
        return new ContinuationImpl(continuationProbeCoroutineCreated, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object result) throws Throwable {
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        this.label = 2;
                        ResultKt.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                ResultKt.throwOnFailure(result);
                return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuation2 = (Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }

    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final Function1<? super Continuation<? super T>, ? extends Object> function1) {
        final CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                private int label;

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 for r2v1 'this'  java.lang.Object
                    	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                    	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                    	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected java.lang.Object invokeSuspend(java.lang.Object r3) {
                    /*
                        r2 = this;
                        int r0 = r2.label
                        r1 = 1
                        if (r0 == 0) goto L1a
                        if (r0 != r1) goto Le
                        r0 = 2
                        r2.label = r0
                        kotlin.ResultKt.throwOnFailure(r3)
                        goto L25
                    Le:
                        java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                        java.lang.String r0 = "This coroutine had already completed"
                        java.lang.String r0 = r0.toString()
                        r3.<init>(r0)
                        throw r3
                    L1a:
                        r2.label = r1
                        kotlin.ResultKt.throwOnFailure(r3)
                        kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r3 = r2
                        java.lang.Object r3 = r3.invoke(r2)
                    L25:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            };
        }
        return new ContinuationImpl(continuation, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            private int label;

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 for r2v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected java.lang.Object invokeSuspend(java.lang.Object r3) {
                /*
                    r2 = this;
                    int r0 = r2.label
                    r1 = 1
                    if (r0 == 0) goto L1a
                    if (r0 != r1) goto Le
                    r0 = 2
                    r2.label = r0
                    kotlin.ResultKt.throwOnFailure(r3)
                    goto L25
                Le:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r0 = "This coroutine had already completed"
                    java.lang.String r0 = r0.toString()
                    r3.<init>(r0)
                    throw r3
                L1a:
                    r2.label = r1
                    kotlin.ResultKt.throwOnFailure(r3)
                    kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r3 = r3
                    java.lang.Object r3 = r3.invoke(r2)
                L25:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        };
    }
}
