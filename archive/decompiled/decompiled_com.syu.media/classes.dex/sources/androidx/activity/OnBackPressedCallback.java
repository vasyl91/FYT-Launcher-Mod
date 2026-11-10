package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean z) {
        this.mEnabled = z;
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator<Cancellable> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }
}
