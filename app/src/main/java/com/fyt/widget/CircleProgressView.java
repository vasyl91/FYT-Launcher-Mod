package com.fyt.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.StyleableRes;

import com.android.launcher66.R;
import com.syu.ipc.data.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class CircleProgressView extends View {
    private int locationStart;
    private ValueAnimator mAnimator;
    private Paint mBgPaint;
    private int mCurrent;
    private OnAnimProgressListener mOnAnimProgressListener;
    private int mProgressColor;
    private Paint mProgressPaint;
    private float mProgressWidth;
    private float startAngle;
    private int tCurrent;

    public interface OnAnimProgressListener {
        void valueUpdate(int i);
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mProgressColor = -1;
        this.tCurrent = -1;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        this.locationStart = typedArray.getInt(R.styleable.CircleProgressView_location_start, 2);
        this.mProgressWidth = typedArray.getDimension(R.styleable.CircleProgressView_progress_width, dp2px(context, 8.0f));
        this.mProgressColor = typedArray.getColor(R.styleable.CircleProgressView_progress_color, this.mProgressColor);
        typedArray.recycle();
        this.mBgPaint = new Paint();
        this.mBgPaint.setAntiAlias(true);
        this.mBgPaint.setStrokeWidth(this.mProgressWidth);
        this.mBgPaint.setStyle(Paint.Style.STROKE);
        this.mBgPaint.setColor(Color.parseColor("#00000000"));
        this.mBgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint = new Paint();
        this.mProgressPaint.setAntiAlias(true);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth(this.mProgressWidth);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        if (this.locationStart == 1) {
            this.startAngle = -180.0f;
            return;
        }
        if (this.locationStart == 2) {
            this.startAngle = -90.0f;
        } else if (this.locationStart == 3) {
            this.startAngle = 0.0f;
        } else if (this.locationStart == 4) {
            this.startAngle = 90.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        int size = width < height ? width : height;
        setMeasuredDimension(size, size);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Log.d("LZP", "onDraw");
        RectF rectF = new RectF(this.mProgressWidth / 2.0f, this.mProgressWidth / 2.0f, getWidth() - (this.mProgressWidth / 2.0f), getHeight() - (this.mProgressWidth / 2.0f));
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.mBgPaint);
        float sweepAngle = (this.mCurrent * FinalCanbus.CAR_0360) / 100;
        canvas.drawArc(rectF, this.startAngle, sweepAngle, false, this.mProgressPaint);
    }

    public int getCurrent() {
        return this.mCurrent;
    }

    public void setCurrent(int current) {
        this.mCurrent = current;
        invalidate();
    }

    public void startAnimProgress(int current, int duration) {
        this.mAnimator = ValueAnimator.ofInt(0, current);
        this.mAnimator.setDuration(duration);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fyt.widget.CircleProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int current2 = ((Integer) animation.getAnimatedValue()).intValue();
                if (CircleProgressView.this.tCurrent != current2) {
                    CircleProgressView.this.tCurrent = current2;
                    CircleProgressView.this.setCurrent(current2);
                    if (CircleProgressView.this.mOnAnimProgressListener == null) {
                        return;
                    }
                    CircleProgressView.this.mOnAnimProgressListener.valueUpdate(current2);
                }
            }
        });
        this.mAnimator.start();
    }

    public void setOnAnimProgressListener(OnAnimProgressListener onAnimProgressListener) {
        this.mOnAnimProgressListener = onAnimProgressListener;
    }

    public void destroy() {
        if (this.mAnimator != null) {
            this.mAnimator.cancel();
        }
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue * scale) + 0.5f);
    }
}
