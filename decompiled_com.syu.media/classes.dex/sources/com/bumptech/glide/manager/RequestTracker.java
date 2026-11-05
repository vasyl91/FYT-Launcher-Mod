package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());
    private final Set<Request> pendingRequests = new HashSet();

    public void runRequest(Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
            return;
        }
        request.clear();
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Paused, delaying request");
        }
        this.pendingRequests.add(request);
    }

    void addRequest(Request request) {
        this.requests.add(request);
    }

    public boolean clearAndRemove(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean zRemove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !zRemove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.pendingRequests.add(request);
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void clearRequests() {
        Iterator it = Util.getSnapshot(this.requests).iterator();
        while (it.hasNext()) {
            clearAndRemove((Request) it.next());
        }
        this.pendingRequests.clear();
    }

    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.isPaused) {
                    request.begin();
                } else {
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }
}
