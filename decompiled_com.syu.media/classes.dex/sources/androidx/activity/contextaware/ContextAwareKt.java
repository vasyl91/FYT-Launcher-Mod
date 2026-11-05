package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"withContextAvailable", "R", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuation, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        cancellableContinuation.invokeOnCancellation(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, function1));
        Object result = cancellableContinuationImpl.getResult();
        if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        DebugProbesKt.probeCoroutineSuspended(continuation);
        return result;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, Function1 function1, Continuation continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        InlineMarker.mark(0);
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuation, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        cancellableContinuation.invokeOnCancellation(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, function1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }
}
