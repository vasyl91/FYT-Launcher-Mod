package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap$Core$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class SemaphoreImpl implements Semaphore {
    volatile /* synthetic */ int _availablePermits;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    private volatile /* synthetic */ Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        if (!(i > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        }
        if (!(i2 >= 0 && i2 <= i)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = i - i2;
        this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.release();
            }
        };
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object objAcquireSlowPath = acquireSlowPath(continuation);
        return objAcquireSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAcquireSlowPath : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addAcquireToQueue(CancellableContinuation<? super Unit> cont) {
        Object objM1542constructorimpl;
        boolean z;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) this.tail;
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        do {
            SemaphoreSegment semaphoreSegment2 = semaphoreSegment;
            while (true) {
                if (semaphoreSegment2.getId() < j || semaphoreSegment2.getRemoved()) {
                    Object obj = semaphoreSegment2.get_next();
                    if (obj == ConcurrentLinkedListKt.CLOSED) {
                        objM1542constructorimpl = SegmentOrClosed.m1542constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    SemaphoreSegment semaphoreSegmentCreateSegment = (Segment) ((ConcurrentLinkedListNode) obj);
                    if (semaphoreSegmentCreateSegment == null) {
                        semaphoreSegmentCreateSegment = SemaphoreKt.createSegment(semaphoreSegment2.getId() + 1, (SemaphoreSegment) semaphoreSegment2);
                        if (semaphoreSegment2.trySetNext(semaphoreSegmentCreateSegment)) {
                            if (semaphoreSegment2.getRemoved()) {
                                semaphoreSegment2.remove();
                            }
                        }
                    }
                    semaphoreSegment2 = semaphoreSegmentCreateSegment;
                } else {
                    objM1542constructorimpl = SegmentOrClosed.m1542constructorimpl(semaphoreSegment2);
                    break;
                }
            }
            if (!SegmentOrClosed.m1547isClosedimpl(objM1542constructorimpl)) {
                Segment segmentM1545getSegmentimpl = SegmentOrClosed.m1545getSegmentimpl(objM1542constructorimpl);
                while (true) {
                    Segment segment = (Segment) this.tail;
                    if (segment.getId() < segmentM1545getSegmentimpl.getId()) {
                        if (!segmentM1545getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                            z = false;
                            break;
                        }
                        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(tail$FU, this, segment, segmentM1545getSegmentimpl)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                            }
                        } else if (segmentM1545getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            segmentM1545getSegmentimpl.remove();
                        }
                    }
                    z = true;
                    break;
                }
            } else {
                break;
            }
        } while (!z);
        SemaphoreSegment semaphoreSegment3 = (SemaphoreSegment) SegmentOrClosed.m1545getSegmentimpl(objM1542constructorimpl);
        int i = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        if (ConcurrentWeakMap$Core$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment3.acquirers, i, null, cont)) {
            cont.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(semaphoreSegment3, i));
            return true;
        }
        if (ConcurrentWeakMap$Core$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment3.acquirers, i, SemaphoreKt.PERMIT, SemaphoreKt.TAKEN)) {
            cont.resume(Unit.INSTANCE, this.onCancellationRelease);
            return true;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(semaphoreSegment3.acquirers.get(i) == SemaphoreKt.BROKEN)) {
                throw new AssertionError();
            }
        }
        return false;
    }

    private final boolean tryResumeNextFromQueue() {
        Object objM1542constructorimpl;
        int i;
        boolean z;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) this.head;
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        do {
            SemaphoreSegment semaphoreSegment2 = semaphoreSegment;
            while (true) {
                if (semaphoreSegment2.getId() < j || semaphoreSegment2.getRemoved()) {
                    Object obj = semaphoreSegment2.get_next();
                    if (obj == ConcurrentLinkedListKt.CLOSED) {
                        objM1542constructorimpl = SegmentOrClosed.m1542constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    SemaphoreSegment semaphoreSegmentCreateSegment = (Segment) ((ConcurrentLinkedListNode) obj);
                    if (semaphoreSegmentCreateSegment == null) {
                        semaphoreSegmentCreateSegment = SemaphoreKt.createSegment(semaphoreSegment2.getId() + 1, (SemaphoreSegment) semaphoreSegment2);
                        if (semaphoreSegment2.trySetNext(semaphoreSegmentCreateSegment)) {
                            if (semaphoreSegment2.getRemoved()) {
                                semaphoreSegment2.remove();
                            }
                        }
                    }
                    semaphoreSegment2 = semaphoreSegmentCreateSegment;
                } else {
                    objM1542constructorimpl = SegmentOrClosed.m1542constructorimpl(semaphoreSegment2);
                    break;
                }
            }
            if (SegmentOrClosed.m1547isClosedimpl(objM1542constructorimpl)) {
                break;
            }
            Segment segmentM1545getSegmentimpl = SegmentOrClosed.m1545getSegmentimpl(objM1542constructorimpl);
            while (true) {
                Segment segment = (Segment) this.head;
                if (segment.getId() < segmentM1545getSegmentimpl.getId()) {
                    if (!segmentM1545getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    }
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(head$FU, this, segment, segmentM1545getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (segmentM1545getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM1545getSegmentimpl.remove();
                    }
                }
                z = true;
                break;
            }
        } while (!z);
        SemaphoreSegment semaphoreSegment3 = (SemaphoreSegment) SegmentOrClosed.m1545getSegmentimpl(objM1542constructorimpl);
        semaphoreSegment3.cleanPrev();
        if (semaphoreSegment3.getId() > j) {
            return false;
        }
        int i2 = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        Object andSet = semaphoreSegment3.acquirers.getAndSet(i2, SemaphoreKt.PERMIT);
        if (andSet == null) {
            int i3 = SemaphoreKt.MAX_SPIN_CYCLES;
            for (i = 0; i < i3; i++) {
                if (semaphoreSegment3.acquirers.get(i2) == SemaphoreKt.TAKEN) {
                    return true;
                }
            }
            return !ConcurrentWeakMap$Core$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment3.acquirers, i2, SemaphoreKt.PERMIT, SemaphoreKt.BROKEN);
        }
        if (andSet == SemaphoreKt.CANCELLED) {
            return false;
        }
        return tryResumeAcquire((CancellableContinuation) andSet);
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object objTryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i - 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        while (!addAcquireToQueue(cancellableContinuationImpl)) {
            if (_availablePermits$FU.getAndDecrement(this) > 0) {
                cancellableContinuationImpl.resume(Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        while (true) {
            int i = this._availablePermits;
            if (!(i < this.permits)) {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (_availablePermits$FU.compareAndSet(this, i, i + 1) && (i >= 0 || tryResumeNextFromQueue())) {
                return;
            }
        }
    }
}
