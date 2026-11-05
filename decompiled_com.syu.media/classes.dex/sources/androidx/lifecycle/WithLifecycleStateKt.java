package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", FinalChip.BSP_PLATFORM_Null, "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class WithLifecycleStateKt {
    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withCreated$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStarted$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withResumed$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0 function0, Continuation continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        final /* synthetic */ Function0 $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(0);
            this.$block = function0;
        }

        public final R invoke() {
            return (R) this.$block.invoke();
        }
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, final boolean z, final CoroutineDispatcher coroutineDispatcher, final Function0<? extends R> function0, Continuation<? super R> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        final ?? r10 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object obj;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                if (event == Lifecycle.Event.upTo(state)) {
                    lifecycle.removeObserver(this);
                    CancellableContinuation cancellableContinuation2 = cancellableContinuation;
                    Function0 function1 = function0;
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(function1.invoke());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    cancellableContinuation2.resumeWith(obj);
                    return;
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    Continuation continuation2 = cancellableContinuation;
                    LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                    Result.Companion companion3 = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(lifecycleDestroyedException)));
                }
            }
        };
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r10);
                }
            });
        } else {
            lifecycle.addObserver((LifecycleObserver) r10);
        }
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                if (coroutineDispatcher.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
                    coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            lifecycle.removeObserver(r10);
                        }
                    });
                } else {
                    lifecycle.removeObserver(r10);
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
