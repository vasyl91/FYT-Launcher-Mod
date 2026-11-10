package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", XmlErrorCodes.DURATION, "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1468plusAssignLRDsOJo(long duration) {
        long j;
        long jM1386toLongimpl = Duration.m1386toLongimpl(duration, getUnit());
        if (jM1386toLongimpl != Long.MIN_VALUE && jM1386toLongimpl != LongCompanionObject.MAX_VALUE) {
            long j2 = this.reading;
            j = j2 + jM1386toLongimpl;
            if ((jM1386toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                m1467overflowLRDsOJo(duration);
            }
        } else {
            double dM1383toDoubleimpl = this.reading + Duration.m1383toDoubleimpl(duration, getUnit());
            if (dM1383toDoubleimpl > 9.223372036854776E18d || dM1383toDoubleimpl < -9.223372036854776E18d) {
                m1467overflowLRDsOJo(duration);
            }
            j = (long) dM1383toDoubleimpl;
        }
        this.reading = j;
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1467overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + ((Object) Duration.m1389toStringimpl(duration)) + '.');
    }
}
