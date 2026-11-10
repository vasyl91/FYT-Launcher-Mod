package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\fR\u0018\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T affected, Object failure);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public AtomicOp<?> getAtomicOp() {
        return this;
    }

    public long getOpSequence() {
        return 0L;
    }

    public abstract Object prepare(T affected);

    /* JADX INFO: renamed from: getConsensus, reason: from getter */
    public final Object get_consensus() {
        return this._consensus;
    }

    public final boolean isDecided() {
        return this._consensus != AtomicKt.NO_DECISION;
    }

    public final Object decide(Object decision) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(decision != AtomicKt.NO_DECISION)) {
                throw new AssertionError();
            }
        }
        Object obj = this._consensus;
        if (obj != AtomicKt.NO_DECISION) {
            return obj;
        }
        return AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_consensus$FU, this, AtomicKt.NO_DECISION, decision) ? decision : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object affected) {
        Object objDecide = this._consensus;
        if (objDecide == AtomicKt.NO_DECISION) {
            objDecide = decide(prepare(affected));
        }
        complete(affected, objDecide);
        return objDecide;
    }
}
