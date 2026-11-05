package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean mayInterruptIfRunning) {
        boolean z = false;
        synchronized (this) {
            if (this.mRequest != null && !isDone()) {
                this.mRequest.cancel();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(timeout, unit)));
    }

    private synchronized T doGet(Long timeoutMs) throws ExecutionException, InterruptedException, TimeoutException {
        T t;
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        if (this.mResultReceived) {
            t = this.mResult;
        } else {
            if (timeoutMs == null) {
                wait(0L);
            } else if (timeoutMs.longValue() > 0) {
                wait(timeoutMs.longValue());
            }
            if (this.mException != null) {
                throw new ExecutionException(this.mException);
            }
            if (!this.mResultReceived) {
                throw new TimeoutException();
            }
            t = this.mResult;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.mRequest == null) {
            return false;
        }
        return this.mRequest.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.mResultReceived || this.mException != null || isCancelled();
    }

    @Override // com.android.volley.Response.Listener
    public synchronized void onResponse(T response) {
        this.mResultReceived = true;
        this.mResult = response;
        notifyAll();
    }

    @Override // com.android.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError error) {
        this.mException = error;
        notifyAll();
    }
}
