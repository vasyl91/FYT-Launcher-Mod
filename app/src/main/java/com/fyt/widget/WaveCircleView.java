package com.fyt.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;

public class WaveCircleView extends View {
    Bitmap mBg;
    private int mCenterPoint;
    Bitmap mCircleBitmap;
    private int mCircleHeight;
    private Paint mCirclePaint;
    private int mCircleWidth;
    private int mDeltaX;
    private int mDeltaY;
    private Paint mPaint;
    private int mPercent;
    private int mViewHeight;
    private int mViewWidth;
    Canvas mWaveCanvas;
    private int mWaveHeight;
    private Paint mWavePaint;
    private Path mWavePath;
    private int mWaveWidth;

    public WaveCircleView(Context context) {
        this(context, null);
    }

    public WaveCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mViewWidth = 104;
        this.mViewHeight = 104;
        this.mCircleWidth = 80;
        this.mCircleHeight = 80;
        this.mWaveHeight = 95;
        this.mCenterPoint = this.mCircleWidth / 2;
        this.mWavePaint = new Paint();
        this.mWavePaint.setAntiAlias(true);
        this.mWavePaint.setFilterBitmap(true);
        this.mWavePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mWavePaint.setDither(true);
        this.mWavePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float[] position = {0.0f, 0.8f};
        Shader shader = new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.mCircleHeight, new int[]{Color.parseColor("#F81758"), Color.parseColor("#F6188C")}, position, Shader.TileMode.REPEAT);
        this.mWavePaint.setShader(shader);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCirclePaint.setFilterBitmap(true);
        this.mCirclePaint.setAntiAlias(true);
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setFlags(Paint.FILTER_BITMAP_FLAG | Paint.ANTI_ALIAS_FLAG);
        this.mBg = Helpers.glideLoader(R.drawable.ic_flow_ring);
        this.mCircleBitmap = Bitmap.createBitmap(this.mCircleWidth, this.mCircleHeight, Bitmap.Config.ARGB_8888);
        this.mWavePath = new Path();
        this.mWaveCanvas = new Canvas(this.mCircleBitmap);
        setPercent(0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mWaveCanvas.drawCircle(this.mCenterPoint, this.mCenterPoint, this.mCenterPoint, this.mCirclePaint);
        this.mWaveCanvas.drawPath(drawPath(), this.mWavePaint);
        canvas.drawBitmap(this.mCircleBitmap, (this.mViewWidth - this.mCircleWidth) / 2.0f, (this.mViewHeight - this.mCircleHeight) / 2.0f, this.mPaint);
        canvas.drawBitmap(this.mBg, 0.0f, 0.0f, this.mPaint);
    }

    private Path drawPath() {
        this.mWavePath.reset();
        this.mWavePath.moveTo(this.mCircleWidth, this.mDeltaY);
        this.mWavePath.lineTo(this.mCircleWidth, this.mCircleHeight);
        this.mWavePath.lineTo(this.mDeltaX, this.mCircleHeight);
        this.mWavePath.lineTo(this.mDeltaX, this.mDeltaY);
        this.mWavePath.rQuadTo((float) this.mCircleWidth / 2, -(this.mViewHeight - this.mCircleHeight), this.mCircleWidth, 0.0f);
        this.mWavePath.close();
        return this.mWavePath;
    }

    public int getPercent() {
        return this.mPercent;
    }

    public void updateCrystal(int percnet) {
        ObjectAnimator mAlbumRotate = ObjectAnimator.ofInt(this, "percent", 0, percnet);
        mAlbumRotate.setDuration(2000L);
        mAlbumRotate.setInterpolator(new LinearInterpolator());
        mAlbumRotate.start();
    }

    private void setPercent(int percent) {
        this.mPercent = percent;
        this.mDeltaY = (int) (this.mWaveHeight - ((this.mWaveHeight / 100.0f) * this.mPercent));
        invalidate();
    }
}
