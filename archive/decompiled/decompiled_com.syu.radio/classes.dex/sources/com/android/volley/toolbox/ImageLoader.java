package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ImageLoader {
    private final ImageCache mCache;
    private final RequestQueue mRequestQueue;
    private Runnable mRunnable;
    private int mBatchResponseDelayMs = 100;
    private final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap<>();
    private final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap<>();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public ImageLoader(RequestQueue queue, ImageCache imageCache) {
        this.mRequestQueue = queue;
        this.mCache = imageCache;
    }

    public static ImageListener getImageListener(final ImageView view, final int defaultImageResId, final int errorImageResId) {
        return new ImageListener() { // from class: com.android.volley.toolbox.ImageLoader.1
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                if (errorImageResId != 0) {
                    view.setImageResource(errorImageResId);
                }
            }

            @Override // com.android.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null) {
                    view.setImageBitmap(response.getBitmap());
                } else if (defaultImageResId != 0) {
                    view.setImageResource(defaultImageResId);
                }
            }
        };
    }

    public boolean isCached(String requestUrl, int maxWidth, int maxHeight) {
        throwIfNotOnMainThread();
        String cacheKey = getCacheKey(requestUrl, maxWidth, maxHeight);
        return this.mCache.getBitmap(cacheKey) != null;
    }

    public ImageContainer get(String requestUrl, ImageListener listener) {
        return get(requestUrl, listener, 0, 0);
    }

    public ImageContainer get(String requestUrl, ImageListener imageListener, int maxWidth, int maxHeight) {
        return get(requestUrl, imageListener, maxWidth, maxHeight, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String requestUrl, ImageListener imageListener, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        throwIfNotOnMainThread();
        String cacheKey = getCacheKey(requestUrl, maxWidth, maxHeight);
        Bitmap cachedBitmap = this.mCache.getBitmap(cacheKey);
        if (cachedBitmap != null) {
            ImageContainer container = new ImageContainer(cachedBitmap, requestUrl, null, null);
            imageListener.onResponse(container, true);
            return container;
        }
        ImageContainer imageContainer = new ImageContainer(null, requestUrl, cacheKey, imageListener);
        imageListener.onResponse(imageContainer, true);
        BatchedImageRequest request = this.mInFlightRequests.get(cacheKey);
        if (request != null) {
            request.addContainer(imageContainer);
            return imageContainer;
        }
        Request<Bitmap> newRequest = makeImageRequest(requestUrl, maxWidth, maxHeight, scaleType, cacheKey);
        this.mRequestQueue.add(newRequest);
        this.mInFlightRequests.put(cacheKey, new BatchedImageRequest(newRequest, imageContainer));
        return imageContainer;
    }

    protected Request<Bitmap> makeImageRequest(String requestUrl, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, final String cacheKey) {
        return new ImageRequest(requestUrl, new Response.Listener<Bitmap>() { // from class: com.android.volley.toolbox.ImageLoader.2
            @Override // com.android.volley.Response.Listener
            public void onResponse(Bitmap response) {
                ImageLoader.this.onGetImageSuccess(cacheKey, response);
            }
        }, maxWidth, maxHeight, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener() { // from class: com.android.volley.toolbox.ImageLoader.3
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                ImageLoader.this.onGetImageError(cacheKey, error);
            }
        });
    }

    public void setBatchedResponseDelay(int newBatchedResponseDelayMs) {
        this.mBatchResponseDelayMs = newBatchedResponseDelayMs;
    }

    protected void onGetImageSuccess(String cacheKey, Bitmap response) {
        this.mCache.putBitmap(cacheKey, response);
        BatchedImageRequest request = this.mInFlightRequests.remove(cacheKey);
        if (request == null) {
            return;
        }
        request.mResponseBitmap = response;
        batchResponse(cacheKey, request);
    }

    protected void onGetImageError(String cacheKey, VolleyError error) {
        BatchedImageRequest request = this.mInFlightRequests.remove(cacheKey);
        if (request != null) {
            request.setError(error);
            batchResponse(cacheKey, request);
        }
    }

    public class ImageContainer {
        private Bitmap mBitmap;
        private final String mCacheKey;
        private final ImageListener mListener;
        private final String mRequestUrl;

        public ImageContainer(Bitmap bitmap, String requestUrl, String cacheKey, ImageListener listener) {
            this.mBitmap = bitmap;
            this.mRequestUrl = requestUrl;
            this.mCacheKey = cacheKey;
            this.mListener = listener;
        }

        public void cancelRequest() {
            if (this.mListener != null) {
                BatchedImageRequest request = (BatchedImageRequest) ImageLoader.this.mInFlightRequests.get(this.mCacheKey);
                if (request == null) {
                    BatchedImageRequest request2 = (BatchedImageRequest) ImageLoader.this.mBatchedResponses.get(this.mCacheKey);
                    if (request2 != null) {
                        request2.removeContainerAndCancelIfNecessary(this);
                        if (request2.mContainers.size() == 0) {
                            ImageLoader.this.mBatchedResponses.remove(this.mCacheKey);
                            return;
                        }
                        return;
                    }
                    return;
                }
                boolean canceled = request.removeContainerAndCancelIfNecessary(this);
                if (canceled) {
                    ImageLoader.this.mInFlightRequests.remove(this.mCacheKey);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    private class BatchedImageRequest {
        private final LinkedList<ImageContainer> mContainers = new LinkedList<>();
        private VolleyError mError;
        private final Request<?> mRequest;
        private Bitmap mResponseBitmap;

        public BatchedImageRequest(Request<?> request, ImageContainer container) {
            this.mRequest = request;
            this.mContainers.add(container);
        }

        public void setError(VolleyError error) {
            this.mError = error;
        }

        public VolleyError getError() {
            return this.mError;
        }

        public void addContainer(ImageContainer container) {
            this.mContainers.add(container);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer container) {
            this.mContainers.remove(container);
            if (this.mContainers.size() != 0) {
                return false;
            }
            this.mRequest.cancel();
            return true;
        }
    }

    private void batchResponse(String cacheKey, BatchedImageRequest request) {
        this.mBatchedResponses.put(cacheKey, request);
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable() { // from class: com.android.volley.toolbox.ImageLoader.4
                @Override // java.lang.Runnable
                public void run() {
                    for (BatchedImageRequest bir : ImageLoader.this.mBatchedResponses.values()) {
                        for (ImageContainer container : bir.mContainers) {
                            if (container.mListener != null) {
                                if (bir.getError() == null) {
                                    container.mBitmap = bir.mResponseBitmap;
                                    container.mListener.onResponse(container, false);
                                } else {
                                    container.mListener.onErrorResponse(bir.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.mBatchedResponses.clear();
                    ImageLoader.this.mRunnable = null;
                }
            };
            this.mHandler.postDelayed(this.mRunnable, this.mBatchResponseDelayMs);
        }
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String getCacheKey(String url, int maxWidth, int maxHeight) {
        return new StringBuilder(url.length() + 12).append("#W").append(maxWidth).append("#H").append(maxHeight).append(url).toString();
    }
}
