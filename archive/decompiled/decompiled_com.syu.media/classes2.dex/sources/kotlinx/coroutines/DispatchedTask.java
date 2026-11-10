package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object state) {
        return state;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object state) {
        CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally) state : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objM56constructorimpl;
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion;
        Object objM56constructorimpl2;
        CancellationException cancellationExceptionRecoverFromStackFrame;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) getDelegate$kotlinx_coroutines_core();
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            if (objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                undispatchedCoroutineUpdateUndispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, objUpdateThreadContext);
            } else {
                undispatchedCoroutineUpdateUndispatchedCompletion = null;
            }
            try {
                CoroutineContext context2 = continuation.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                Job job = (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) ? (Job) context2.get(Job.INSTANCE) : null;
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    Result.Companion companion = Result.INSTANCE;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                        cancellationExceptionRecoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, (CoroutineStackFrame) continuation);
                    } else {
                        cancellationExceptionRecoverFromStackFrame = cancellationException;
                    }
                    continuation.resumeWith(Result.m56constructorimpl(ResultKt.createFailure(cancellationExceptionRecoverFromStackFrame)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m56constructorimpl(ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation.resumeWith(Result.m56constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core)));
                }
                Unit unit = Unit.INSTANCE;
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                try {
                    Result.Companion companion4 = Result.INSTANCE;
                    DispatchedTask<T> dispatchedTask = this;
                    taskContext.afterTask();
                    objM56constructorimpl2 = Result.m56constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM56constructorimpl2 = Result.m56constructorimpl(ResultKt.createFailure(th));
                }
                handleFatalException(null, Result.m59exceptionOrNullimpl(objM56constructorimpl2));
            } catch (Throwable th2) {
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.Companion companion6 = Result.INSTANCE;
                taskContext.afterTask();
                objM56constructorimpl = Result.m56constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion7 = Result.INSTANCE;
                objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th4));
            }
            handleFatalException(th3, Result.m59exceptionOrNullimpl(objM56constructorimpl));
        }
    }

    public final void handleFatalException(Throwable exception, Throwable finallyException) {
        if (exception == null && finallyException == null) {
            return;
        }
        if (exception != null && finallyException != null) {
            kotlin.ExceptionsKt.addSuppressed(exception, finallyException);
        }
        if (exception == null) {
            exception = finallyException;
        }
        Intrinsics.checkNotNull(exception);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", exception));
    }
}
