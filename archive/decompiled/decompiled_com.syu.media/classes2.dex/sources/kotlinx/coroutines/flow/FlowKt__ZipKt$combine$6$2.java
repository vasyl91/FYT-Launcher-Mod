package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import module.canbus.FinalCanbus;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: compiled from: Zip.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {FinalCanbus.CAR_RZC_XP1_DongNanV6, FinalCanbus.CAR_RZC_XP1_DongNanV6}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$6$2<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$6$2> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, continuation);
        flowKt__ZipKt$combine$6$2.L$0 = flowCollector;
        flowKt__ZipKt$combine$6$2.L$1 = tArr;
        return flowKt__ZipKt$combine$6$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector3;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        flowCollector = (FlowCollector) this.L$0;
        Object[] objArr = (Object[]) this.L$1;
        Function2<T[], Continuation<? super R>, Object> function2 = this.$transform;
        this.L$0 = flowCollector;
        this.label = 1;
        obj = function2.invoke(objArr, this);
        if (obj == coroutine_suspended) {
            flowCollector2 = flowCollector;
            return coroutine_suspended;
        }
        flowCollector2 = flowCollector;
        this.L$0 = null;
        this.label = 2;
        if (flowCollector2.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend$$forInline(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object[] objArr = (Object[]) this.L$1;
        InlineMarker.mark(0);
        flowCollector.emit(this.$transform.invoke(objArr, this), this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
