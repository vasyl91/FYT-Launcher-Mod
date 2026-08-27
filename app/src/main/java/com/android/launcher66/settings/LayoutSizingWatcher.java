package com.android.launcher66.settings;

import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Leak-safe replacement for the "register an OnGlobalLayoutListener on the row view" pattern
 * used by the custom preferences.
 *
 * <p>Why the old pattern leaked:
 * <ul>
 *   <li>While a View is attached, {@code View#getViewTreeObserver()} returns the observer that
 *       belongs to the <b>window</b> ({@code View$AttachInfo#mTreeObserver}, owned by
 *       {@code ViewRootImpl}). Once the View is detached it returns a brand new, throw-away
 *       "floating" observer. Removing the listener through an already detached View therefore
 *       silently removes it from the wrong observer and the real registration survives inside
 *       ViewRootImpl for the whole lifetime of the Activity window.</li>
 *   <li>{@code PreferenceFragmentCompat} tears down in exactly that order: the fragment view is
 *       removed from its container first, and only afterwards {@code onDestroyView()} runs and
 *       calls {@code PreferenceScreen#onDetached()}. So cleanup inside
 *       {@code Preference#onDetached()} always hit the detached case.</li>
 *   <li>The leaked listener keeps its outer Preference alive, which keeps
 *       {@code Preference#mPreferenceManager} alive, which keeps
 *       {@code PreferenceManager#mOnNavigateToScreenListener} alive - i.e. the whole
 *       PreferenceFragmentCompat.</li>
 * </ul>
 *
 * <p>This class avoids all of that by keeping a hard reference to the <b>exact</b>
 * ViewTreeObserver instance it registered on, and by unregistering from
 * {@link View.OnAttachStateChangeListener#onViewDetachedFromWindow(View)} - so the window observer
 * is left clean no matter in which order the teardown happens.
 */
final class LayoutSizingWatcher
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    interface Callback {
        /**
         * Called on every global layout pass while the host is attached.
         *
         * @return {@code true} when the work is done and the watcher should detach itself.
         */
        boolean onHostLaidOut(View host);
    }

    private View mHost;
    /** The observer we actually registered on - never re-resolved from the view. */
    private ViewTreeObserver mObserver;
    private Callback mCallback;

    private LayoutSizingWatcher() { }

    /**
     * Starts watching {@code host}. If the host is not attached yet, registration is deferred
     * until it is attached, so we never touch the throw-away floating observer.
     */
    static LayoutSizingWatcher watch(View host, Callback callback) {
        if (host == null || callback == null) return null;
        LayoutSizingWatcher watcher = new LayoutSizingWatcher();
        watcher.mHost = host;
        watcher.mCallback = callback;
        host.addOnAttachStateChangeListener(watcher);
        watcher.register();
        return watcher;
    }

    /** Fully detaches the watcher. Safe to call repeatedly and from any state. */
    void cancel() {
        unregister();
        View host = mHost;
        mHost = null;
        mCallback = null;
        if (host != null) {
            host.removeOnAttachStateChangeListener(this);
        }
    }

    private void register() {
        if (mObserver != null || mHost == null) return;
        if (!mHost.isAttachedToWindow()) return;
        ViewTreeObserver vto = mHost.getViewTreeObserver();
        if (vto == null || !vto.isAlive()) return;
        mObserver = vto;
        vto.addOnGlobalLayoutListener(this);
    }

    private void unregister() {
        ViewTreeObserver vto = mObserver;
        mObserver = null;
        if (vto != null && vto.isAlive()) {
            vto.removeOnGlobalLayoutListener(this);
        }
    }

    @Override
    public void onGlobalLayout() {
        View host = mHost;
        Callback callback = mCallback;
        if (host == null || callback == null) {
            unregister();
            return;
        }
        if (callback.onHostLaidOut(host)) {
            cancel();
        }
    }

    @Override
    public void onViewAttachedToWindow(View v) {
        // The RecyclerView may re-attach a recycled row: re-register on the new window observer.
        register();
    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        // Critical: leave the window observer clean while we still know which one it was.
        unregister();
    }
}
