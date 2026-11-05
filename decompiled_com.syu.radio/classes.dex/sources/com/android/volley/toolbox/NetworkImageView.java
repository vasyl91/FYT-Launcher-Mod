package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NetworkImageView extends ImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImageUrl(String url, ImageLoader imageLoader) {
        this.mUrl = url;
        this.mImageLoader = imageLoader;
        loadImageIfNecessary(false);
    }

    public String getImageURL() {
        return this.mUrl;
    }

    public void setDefaultImageResId(int defaultImage) {
        this.mDefaultImageId = defaultImage;
    }

    public void setErrorImageResId(int errorImage) {
        this.mErrorImageId = errorImage;
    }

    void loadImageIfNecessary(boolean isInLayoutPass) {
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        boolean wrapWidth = false;
        boolean wrapHeight = false;
        if (getLayoutParams() != null) {
            wrapWidth = getLayoutParams().width == -2;
            wrapHeight = getLayoutParams().height == -2;
        }
        boolean isFullyWrapContent = wrapWidth && wrapHeight;
        if (width != 0 || height != 0 || isFullyWrapContent) {
            if (TextUtils.isEmpty(this.mUrl)) {
                if (this.mImageContainer != null) {
                    this.mImageContainer.cancelRequest();
                    this.mImageContainer = null;
                }
                setDefaultImageOrNull();
                return;
            }
            if (this.mImageContainer != null && this.mImageContainer.getRequestUrl() != null) {
                if (!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
                    this.mImageContainer.cancelRequest();
                    setDefaultImageOrNull();
                } else {
                    return;
                }
            }
            int maxWidth = wrapWidth ? 0 : width;
            int maxHeight = wrapHeight ? 0 : height;
            ImageLoader.ImageContainer newContainer = this.mImageLoader.get(this.mUrl, new AnonymousClass1(isInLayoutPass), maxWidth, maxHeight, scaleType);
            this.mImageContainer = newContainer;
        }
    }

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    class AnonymousClass1 implements ImageLoader.ImageListener {
        private final /* synthetic */ boolean val$isInLayoutPass;

        AnonymousClass1(boolean z) {
            this.val$isInLayoutPass = z;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError error) {
            if (NetworkImageView.this.mErrorImageId != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.mErrorImageId);
            }
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer response, boolean isImmediate) {
            if (isImmediate && this.val$isInLayoutPass) {
                NetworkImageView.this.post(new Runnable() { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(response, false);
                    }
                });
            } else {
                if (response.getBitmap() == null) {
                    if (NetworkImageView.this.mDefaultImageId != 0) {
                        NetworkImageView.this.setImageResource(NetworkImageView.this.mDefaultImageId);
                        return;
                    }
                    return;
                }
                NetworkImageView.this.setImageBitmap(response.getBitmap());
            }
        }
    }

    private void setDefaultImageOrNull() {
        if (this.mDefaultImageId != 0) {
            setImageResource(this.mDefaultImageId);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        loadImageIfNecessary(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.mImageContainer != null) {
            this.mImageContainer.cancelRequest();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
