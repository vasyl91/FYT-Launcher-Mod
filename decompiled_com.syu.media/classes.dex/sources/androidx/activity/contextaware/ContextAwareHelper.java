package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ContextAwareHelper {
    private volatile Context mContext;
    private final Set<OnContextAvailableListener> mListeners = new CopyOnWriteArraySet();

    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        if (this.mContext != null) {
            onContextAvailableListener.onContextAvailable(this.mContext);
        }
        this.mListeners.add(onContextAvailableListener);
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mListeners.remove(onContextAvailableListener);
    }

    public void dispatchOnContextAvailable(Context context) {
        this.mContext = context;
        Iterator<OnContextAvailableListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onContextAvailable(context);
        }
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }
}
