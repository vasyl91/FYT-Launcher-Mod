package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RequestQueue {
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final Cache mCache;
    private CacheDispatcher mCacheDispatcher;
    private final PriorityBlockingQueue<Request<?>> mCacheQueue;
    private final Set<Request<?>> mCurrentRequests;
    private final ResponseDelivery mDelivery;
    private NetworkDispatcher[] mDispatchers;
    private List<RequestFinishedListener> mFinishedListeners;
    private final Network mNetwork;
    private final PriorityBlockingQueue<Request<?>> mNetworkQueue;
    private AtomicInteger mSequenceGenerator;
    private final Map<String, Queue<Request<?>>> mWaitingRequests;

    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mWaitingRequests = new HashMap();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue<>();
        this.mNetworkQueue = new PriorityBlockingQueue<>();
        this.mFinishedListeners = new ArrayList();
        this.mCache = cache;
        this.mNetwork = network;
        this.mDispatchers = new NetworkDispatcher[threadPoolSize];
        this.mDelivery = delivery;
    }

    public RequestQueue(Cache cache, Network network, int threadPoolSize) {
        this(cache, network, threadPoolSize, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public void start() {
        stop();
        this.mCacheDispatcher = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher.start();
        for (int i = 0; i < this.mDispatchers.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
            this.mDispatchers[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        if (this.mCacheDispatcher != null) {
            this.mCacheDispatcher.quit();
        }
        for (int i = 0; i < this.mDispatchers.length; i++) {
            if (this.mDispatchers[i] != null) {
                this.mDispatchers[i].quit();
            }
        }
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void cancelAll(RequestFilter filter) {
        synchronized (this.mCurrentRequests) {
            for (Request<?> request : this.mCurrentRequests) {
                if (filter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(final Object tag) {
        if (tag == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll(new RequestFilter() { // from class: com.android.volley.RequestQueue.1
            @Override // com.android.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == tag;
            }
        });
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.mNetworkQueue.add(request);
        } else {
            synchronized (this.mWaitingRequests) {
                String cacheKey = request.getCacheKey();
                if (this.mWaitingRequests.containsKey(cacheKey)) {
                    Queue<Request<?>> stagedRequests = this.mWaitingRequests.get(cacheKey);
                    if (stagedRequests == null) {
                        stagedRequests = new LinkedList<>();
                    }
                    stagedRequests.add(request);
                    this.mWaitingRequests.put(cacheKey, stagedRequests);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                } else {
                    this.mWaitingRequests.put(cacheKey, null);
                    this.mCacheQueue.add(request);
                }
            }
        }
        return request;
    }

    <T> void finish(Request<T> request) {
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.remove(request);
        }
        synchronized (this.mFinishedListeners) {
            for (RequestFinishedListener<T> listener : this.mFinishedListeners) {
                listener.onRequestFinished(request);
            }
        }
        if (request.shouldCache()) {
            synchronized (this.mWaitingRequests) {
                String cacheKey = request.getCacheKey();
                Queue<Request<?>> waitingRequests = this.mWaitingRequests.remove(cacheKey);
                if (waitingRequests != null) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(waitingRequests.size()), cacheKey);
                    }
                    this.mCacheQueue.addAll(waitingRequests);
                }
            }
        }
    }

    public <T> void addRequestFinishedListener(RequestFinishedListener<T> listener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.add(listener);
        }
    }

    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> listener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.remove(listener);
        }
    }
}
