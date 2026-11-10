package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ Ref.ObjectRef $result$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: Limit.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {142}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$first$$inlined$collectWhile$2.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 function2, Ref.ObjectRef objectRef) {
        this.$predicate$inlined = function2;
        this.$result$inlined = objectRef;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> flowKt__ReduceKt$first$$inlined$collectWhile$2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function2 function2 = this.$predicate$inlined;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = t;
            anonymousClass1.label = 1;
            InlineMarker.mark(6);
            objInvoke = function2.invoke(t, anonymousClass1);
            InlineMarker.mark(7);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) anonymousClass1.L$1;
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objInvoke);
        }
        if (((Boolean) objInvoke).booleanValue()) {
            flowKt__ReduceKt$first$$inlined$collectWhile$2.$result$inlined.element = t;
            z = false;
        }
        if (z) {
            return Unit.INSTANCE;
        }
        throw new AbortFlowException(flowKt__ReduceKt$first$$inlined$collectWhile$2);
    }
}
