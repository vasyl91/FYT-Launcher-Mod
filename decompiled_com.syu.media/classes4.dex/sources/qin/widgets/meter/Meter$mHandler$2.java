package qin.widgets.meter;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Meter$mHandler$2 extends Lambda implements Function0<Handler> {
    public static final Meter$mHandler$2 INSTANCE = new Meter$mHandler$2();

    public Meter$mHandler$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Handler m2invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
