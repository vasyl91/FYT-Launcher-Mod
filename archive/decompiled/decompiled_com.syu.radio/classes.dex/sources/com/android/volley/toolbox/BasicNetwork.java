package com.android.volley.toolbox;

import android.net.http.Headers;
import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BasicNetwork implements Network {
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private static int DEFAULT_POOL_SIZE = 4096;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool pool) {
        this.mHttpStack = httpStack;
        this.mPool = pool;
    }

    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        byte[] responseContents;
        long requestStart = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> responseHeaders = Collections.emptyMap();
            try {
                Map<String, String> headers = new HashMap<>();
                addCacheHeaders(headers, request.getCacheEntry());
                httpResponse = this.mHttpStack.performRequest(request, headers);
                StatusLine statusLine = httpResponse.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                responseHeaders = convertHeaders(httpResponse.getAllHeaders());
                if (statusCode == 304) {
                    Cache.Entry entry = request.getCacheEntry();
                    if (entry == null) {
                        return new NetworkResponse(304, null, responseHeaders, true, SystemClock.elapsedRealtime() - requestStart);
                    }
                    entry.responseHeaders.putAll(responseHeaders);
                    return new NetworkResponse(304, entry.data, entry.responseHeaders, true, SystemClock.elapsedRealtime() - requestStart);
                }
                if (statusCode == 301 || statusCode == 302) {
                    String newUrl = responseHeaders.get("Location");
                    request.setRedirectUrl(newUrl);
                }
                if (httpResponse.getEntity() != null) {
                    responseContents = entityToBytes(httpResponse.getEntity());
                } else {
                    responseContents = new byte[0];
                }
                try {
                    long requestLifetime = SystemClock.elapsedRealtime() - requestStart;
                    logSlowRequests(requestLifetime, request, responseContents, statusLine);
                    if (statusCode < 200 || statusCode > 299) {
                        throw new IOException();
                    }
                    return new NetworkResponse(statusCode, responseContents, responseHeaders, false, SystemClock.elapsedRealtime() - requestStart);
                } catch (MalformedURLException e) {
                    e = e;
                    throw new RuntimeException("Bad URL " + request.getUrl(), e);
                } catch (SocketTimeoutException e2) {
                    attemptRetryOnException("socket", request, new TimeoutError());
                } catch (ConnectTimeoutException e3) {
                    attemptRetryOnException(Headers.CONN_DIRECTIVE, request, new TimeoutError());
                } catch (IOException e4) {
                    e = e4;
                    if (httpResponse != null) {
                        int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                        if (statusCode2 == 301 || statusCode2 == 302) {
                            VolleyLog.e("Request at %s has been redirected to %s", request.getOriginUrl(), request.getUrl());
                        } else {
                            VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                        }
                        if (responseContents != null) {
                            NetworkResponse networkResponse = new NetworkResponse(statusCode2, responseContents, responseHeaders, false, SystemClock.elapsedRealtime() - requestStart);
                            if (statusCode2 == 401 || statusCode2 == 403) {
                                attemptRetryOnException("auth", request, new AuthFailureError(networkResponse));
                            } else if (statusCode2 == 301 || statusCode2 == 302) {
                                attemptRetryOnException("redirect", request, new AuthFailureError(networkResponse));
                            } else {
                                throw new ServerError(networkResponse);
                            }
                        } else {
                            throw new NetworkError((NetworkResponse) null);
                        }
                    } else {
                        throw new NoConnectionError(e);
                    }
                }
            } catch (MalformedURLException e5) {
                e = e5;
            } catch (SocketTimeoutException e6) {
            } catch (ConnectTimeoutException e7) {
            } catch (IOException e8) {
                e = e8;
                responseContents = null;
            }
        }
    }

    private void logSlowRequests(long requestLifetime, Request<?> request, byte[] responseContents, StatusLine statusLine) {
        if (DEBUG || requestLifetime > SLOW_REQUEST_THRESHOLD_MS) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(requestLifetime);
            objArr[2] = responseContents != null ? Integer.valueOf(responseContents.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void attemptRetryOnException(String logPrefix, Request<?> request, VolleyError exception) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int oldTimeout = request.getTimeoutMs();
        try {
            retryPolicy.retry(exception);
            request.addMarker(String.format("%s-retry [timeout=%s]", logPrefix, Integer.valueOf(oldTimeout)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", logPrefix, Integer.valueOf(oldTimeout)));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> headers, Cache.Entry entry) {
        if (entry != null) {
            if (entry.etag != null) {
                headers.put("If-None-Match", entry.etag);
            }
            if (entry.lastModified > 0) {
                Date refTime = new Date(entry.lastModified);
                headers.put("If-Modified-Since", DateUtils.formatDate(refTime));
            }
        }
    }

    protected void logError(String what, String url, long start) {
        long now = SystemClock.elapsedRealtime();
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", what, Long.valueOf(now - start), url);
    }

    private byte[] entityToBytes(HttpEntity entity) throws ServerError, IOException {
        PoolingByteArrayOutputStream bytes = new PoolingByteArrayOutputStream(this.mPool, (int) entity.getContentLength());
        try {
            InputStream in = entity.getContent();
            if (in == null) {
                throw new ServerError();
            }
            byte[] buffer = this.mPool.getBuf(1024);
            while (true) {
                int count = in.read(buffer);
                if (count == -1) {
                    break;
                }
                bytes.write(buffer, 0, count);
            }
            byte[] byteArray = bytes.toByteArray();
            try {
                entity.consumeContent();
            } catch (IOException e) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(buffer);
            bytes.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                entity.consumeContent();
            } catch (IOException e2) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(null);
            bytes.close();
            throw th;
        }
    }

    protected static Map<String, String> convertHeaders(Header[] headers) {
        Map<String, String> result = new TreeMap<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headers.length; i++) {
            result.put(headers[i].getName(), headers[i].getValue());
        }
        return result;
    }
}
