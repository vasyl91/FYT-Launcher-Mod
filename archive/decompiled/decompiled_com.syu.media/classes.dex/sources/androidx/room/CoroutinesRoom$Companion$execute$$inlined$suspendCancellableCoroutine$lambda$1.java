package androidx.room;

import android.os.CancellationSignal;
import chip.FinalChip;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/CoroutinesRoom$Companion$execute$4$job$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable $callable$inlined;
    final /* synthetic */ CancellationSignal $cancellationSignal$inlined;
    final /* synthetic */ ContinuationInterceptor $context$inlined;
    final /* synthetic */ CancellableContinuation $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, Continuation continuation, ContinuationInterceptor continuationInterceptor, Callable callable, CancellationSignal cancellationSignal) {
        super(2, continuation);
        this.$continuation = cancellableContinuation;
        this.$context$inlined = continuationInterceptor;
        this.$callable$inlined = callable;
        this.$cancellationSignal$inlined = cancellationSignal;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(this.$continuation, continuation, this.$context$inlined, this.$callable$inlined, this.$cancellationSignal$inlined);
    }

    public final Object invoke(Object obj, Object obj2) {
        return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Object objCall = this.$callable$inlined.call();
            Continuation continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(objCall));
        } catch (Throwable th) {
            Continuation continuation2 = this.$continuation;
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        }
        return Unit.INSTANCE;
    }
}
