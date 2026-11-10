package androidx.room;

import chip.FinalChip;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RoomDatabase.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/room/TransactionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "transactionThreadControlJob", "Lkotlinx/coroutines/Job;", "transactionDispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/ContinuationInterceptor;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getTransactionDispatcher$room_ktx_release", "()Lkotlin/coroutines/ContinuationInterceptor;", "acquire", FinalChip.BSP_PLATFORM_Null, "release", "Key", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
public final class TransactionElement implements CoroutineContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AtomicInteger referenceCount;
    private final ContinuationInterceptor transactionDispatcher;
    private final Job transactionThreadControlJob;

    public TransactionElement(Job job, ContinuationInterceptor continuationInterceptor) {
        Intrinsics.checkNotNullParameter(job, "transactionThreadControlJob");
        Intrinsics.checkNotNullParameter(continuationInterceptor, "transactionDispatcher");
        this.transactionThreadControlJob = job;
        this.transactionDispatcher = continuationInterceptor;
        this.referenceCount = new AtomicInteger(0);
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX INFO: renamed from: getTransactionDispatcher$room_ktx_release, reason: from getter */
    public final ContinuationInterceptor getTransactionDispatcher() {
        return this.transactionDispatcher;
    }

    /* JADX INFO: renamed from: androidx.room.TransactionElement$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/room/TransactionElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/room/TransactionElement;", "()V", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion implements CoroutineContext.Key<TransactionElement> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineContext.Key<TransactionElement> getKey() {
        return INSTANCE;
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    public final void release() {
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (iDecrementAndGet == 0) {
            Job.DefaultImpls.cancel$default(this.transactionThreadControlJob, (CancellationException) null, 1, (Object) null);
        }
    }
}
