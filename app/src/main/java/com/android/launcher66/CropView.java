package com.android.launcher66;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import com.android.photos.views.TiledImageRenderer;
import com.android.photos.views.TiledImageView;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class CropView extends TiledImageView implements ScaleGestureDetector.OnScaleGestureListener {
    private float mCenterX;
    private float mCenterY;
    private float mFirstX;
    private float mFirstY;
    Matrix mInverseRotateMatrix;
    private float mLastX;
    private float mLastY;
    private float mMinScale;
    Matrix mRotateMatrix;
    private ScaleGestureDetector mScaleGestureDetector;
    private float[] mTempAdjustment;
    private float[] mTempCoef;
    private RectF mTempEdges;
    private float[] mTempImageDims;
    private float[] mTempPoint;
    private float[] mTempRendererCenter;
    TouchCallback mTouchCallback;
    private long mTouchDownTime;
    private boolean mTouchEnabled;

    public interface TouchCallback {
        void onTap();

        void onTouchDown();

        void onTouchUp();
    }

    public CropView(Context context) {
        this(context, null);
    }

    public CropView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchEnabled = true;
        this.mTempEdges = new RectF();
        this.mTempPoint = new float[]{0.0f, 0.0f};
        this.mTempCoef = new float[]{0.0f, 0.0f};
        this.mTempAdjustment = new float[]{0.0f, 0.0f};
        this.mTempImageDims = new float[]{0.0f, 0.0f};
        this.mTempRendererCenter = new float[]{0.0f, 0.0f};
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mRotateMatrix = new Matrix();
        this.mInverseRotateMatrix = new Matrix();
    }

    private float[] getImageDims() {
        float imageWidth = this.mRenderer.source.getImageWidth();
        float imageHeight = this.mRenderer.source.getImageHeight();
        float[] imageDims = this.mTempImageDims;
        imageDims[0] = imageWidth;
        imageDims[1] = imageHeight;
        this.mRotateMatrix.mapPoints(imageDims);
        imageDims[0] = Math.abs(imageDims[0]);
        imageDims[1] = Math.abs(imageDims[1]);
        return imageDims;
    }

    private void getEdgesHelper(RectF edgesOut) {
        float width = getWidth();
        float height = getHeight();
        float[] imageDims = getImageDims();
        float imageWidth = imageDims[0];
        float imageHeight = imageDims[1];
        float initialCenterX = this.mRenderer.source.getImageWidth() / 2.0f;
        float initialCenterY = this.mRenderer.source.getImageHeight() / 2.0f;
        float[] rendererCenter = this.mTempRendererCenter;
        rendererCenter[0] = this.mCenterX - initialCenterX;
        rendererCenter[1] = this.mCenterY - initialCenterY;
        this.mRotateMatrix.mapPoints(rendererCenter);
        rendererCenter[0] = rendererCenter[0] + (imageWidth / 2.0f);
        rendererCenter[1] = rendererCenter[1] + (imageHeight / 2.0f);
        float scale = this.mRenderer.scale;
        float centerX = ((((width / 2.0f) - rendererCenter[0]) + ((imageWidth - width) / 2.0f)) * scale) + (width / 2.0f);
        float centerY = ((((height / 2.0f) - rendererCenter[1]) + ((imageHeight - height) / 2.0f)) * scale) + (height / 2.0f);
        float leftEdge = centerX - ((imageWidth / 2.0f) * scale);
        float rightEdge = centerX + ((imageWidth / 2.0f) * scale);
        float topEdge = centerY - ((imageHeight / 2.0f) * scale);
        float bottomEdge = centerY + ((imageHeight / 2.0f) * scale);
        edgesOut.left = leftEdge;
        edgesOut.right = rightEdge;
        edgesOut.top = topEdge;
        edgesOut.bottom = bottomEdge;
    }

    public int getImageRotation() {
        return this.mRenderer.rotation;
    }

    public RectF getCrop() {
        RectF edges = this.mTempEdges;
        getEdgesHelper(edges);
        float scale = this.mRenderer.scale;
        float cropLeft = (-edges.left) / scale;
        float cropTop = (-edges.top) / scale;
        float cropRight = cropLeft + (getWidth() / scale);
        float cropBottom = cropTop + (getHeight() / scale);
        return new RectF(cropLeft, cropTop, cropRight, cropBottom);
    }

    public Point getSourceDimensions() {
        return new Point(this.mRenderer.source.getImageWidth(), this.mRenderer.source.getImageHeight());
    }

    @Override // com.android.photos.views.TiledImageView
    public void setTileSource(TiledImageRenderer.TileSource source, Runnable isReadyCallback) {
        super.setTileSource(source, isReadyCallback);
        this.mCenterX = this.mRenderer.centerX;
        this.mCenterY = this.mRenderer.centerY;
        this.mRotateMatrix.reset();
        this.mRotateMatrix.setRotate(this.mRenderer.rotation);
        this.mInverseRotateMatrix.reset();
        this.mInverseRotateMatrix.setRotate(-this.mRenderer.rotation);
        updateMinScale(getWidth(), getHeight(), source, true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateMinScale(w, h, this.mRenderer.source, false);
    }

    public void setScale(float scale) {
        synchronized (this.mLock) {
            this.mRenderer.scale = scale;
        }
    }

    private void updateMinScale(int w, int h, TiledImageRenderer.TileSource source, boolean resetScale) {
        synchronized (this.mLock) {
            if (resetScale) {
                this.mRenderer.scale = 1.0f;
            }
            if (source != null) {
                float[] imageDims = getImageDims();
                float imageWidth = imageDims[0];
                float imageHeight = imageDims[1];
                this.mMinScale = Math.max(w / imageWidth, h / imageHeight);
                this.mRenderer.scale = Math.max(this.mMinScale, this.mRenderer.scale);
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        this.mRenderer.scale *= detector.getScaleFactor();
        this.mRenderer.scale = Math.max(this.mMinScale, this.mRenderer.scale);
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
    }

    public void moveToLeft() {
        if (getWidth() == 0 || getHeight() == 0) {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.android.launcher66.CropView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    CropView.this.moveToLeft();
                    CropView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        RectF edges = this.mTempEdges;
        getEdgesHelper(edges);
        float scale = this.mRenderer.scale;
        this.mCenterX = (float) (this.mCenterX + Math.ceil(edges.left / scale));
        updateCenter();
    }

    private void updateCenter() {
        this.mRenderer.centerX = Math.round(this.mCenterX);
        this.mRenderer.centerY = Math.round(this.mCenterY);
    }

    public void setTouchEnabled(boolean enabled) {
        this.mTouchEnabled = enabled;
    }

    public void setTouchCallback(TouchCallback cb) {
        this.mTouchCallback = cb;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        boolean pointerUp = action == 6;
        int skipIndex = pointerUp ? event.getActionIndex() : -1;
        float sumX = 0.0f;
        float sumY = 0.0f;
        int count = event.getPointerCount();
        for (int i = 0; i < count; i++) {
            if (skipIndex != i) {
                sumX += event.getX(i);
                sumY += event.getY(i);
            }
        }
        int div = pointerUp ? count - 1 : count;
        float x = sumX / div;
        float y = sumY / div;
        if (action == 0) {
            this.mFirstX = x;
            this.mFirstY = y;
            this.mTouchDownTime = System.currentTimeMillis();
            if (this.mTouchCallback != null) {
                this.mTouchCallback.onTouchDown();
            }
        } else if (action == 1) {
            ViewConfiguration config = ViewConfiguration.get(getContext());
            float squaredDist = ((this.mFirstX - x) * (this.mFirstX - x)) + ((this.mFirstY - y) * (this.mFirstY - y));
            float slop = config.getScaledTouchSlop() * config.getScaledTouchSlop();
            long now = System.currentTimeMillis();
            if (this.mTouchCallback != null) {
                if (squaredDist < slop && now < this.mTouchDownTime + ViewConfiguration.getTapTimeout()) {
                    this.mTouchCallback.onTap();
                }
                this.mTouchCallback.onTouchUp();
            }
        }
        if (!this.mTouchEnabled) {
            return true;
        }
        synchronized (this.mLock) {
            this.mScaleGestureDetector.onTouchEvent(event);
            switch (action) {
                case 2:
                    float[] point = this.mTempPoint;
                    point[0] = (this.mLastX - x) / this.mRenderer.scale;
                    point[1] = (this.mLastY - y) / this.mRenderer.scale;
                    this.mInverseRotateMatrix.mapPoints(point);
                    this.mCenterX += point[0];
                    this.mCenterY += point[1];
                    updateCenter();
                    invalidate();
                    break;
            }
            if (this.mRenderer.source != null) {
                RectF edges = this.mTempEdges;
                getEdgesHelper(edges);
                float scale = this.mRenderer.scale;
                float[] coef = this.mTempCoef;
                coef[0] = 1.0f;
                coef[1] = 1.0f;
                this.mRotateMatrix.mapPoints(coef);
                float[] adjustment = this.mTempAdjustment;
                this.mTempAdjustment[0] = 0.0f;
                this.mTempAdjustment[1] = 0.0f;
                if (edges.left > 0.0f) {
                    adjustment[0] = edges.left / scale;
                } else if (edges.right < getWidth()) {
                    adjustment[0] = (edges.right - getWidth()) / scale;
                }
                if (edges.top > 0.0f) {
                    adjustment[1] = (float) Math.ceil(edges.top / scale);
                } else if (edges.bottom < getHeight()) {
                    adjustment[1] = (edges.bottom - getHeight()) / scale;
                }
                for (int dim = 0; dim <= 1; dim++) {
                    if (coef[dim] > 0.0f) {
                        adjustment[dim] = (float) Math.ceil(adjustment[dim]);
                    }
                }
                this.mInverseRotateMatrix.mapPoints(adjustment);
                this.mCenterX += adjustment[0];
                this.mCenterY += adjustment[1];
                updateCenter();
            }
        }
        this.mLastX = x;
        this.mLastY = y;
        return true;
    }
}
