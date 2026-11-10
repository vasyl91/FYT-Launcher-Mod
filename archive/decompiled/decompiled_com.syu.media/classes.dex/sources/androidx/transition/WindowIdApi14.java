package androidx.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
