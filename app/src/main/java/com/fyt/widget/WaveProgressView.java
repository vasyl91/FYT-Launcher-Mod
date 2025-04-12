package com.fyt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.android.launcher66.R;

public class WaveProgressView extends View {
    private static final float DEFAULT_SPACE_RADIO = 0.05f;
    private static final String DEFAULT_STROKE_COLOR = "#FF82BAF1";
    private static final float DEFAULT_STROKE_RADIO = 0.01f;
    private static final String DEFAULT_TEXT_COLOR = "#FFFFFF00";
    private static final String DEFAULT_TEXT_HINT_COLOR = "#FF878889";
    private static final String DEFAULT_WAVE_BG_COLOR = "#FFF1F7FF";
    private static final String DEFAULT_WAVE_COLOR = "#FFCDE5FD";
    private Bitmap mBackground;
    private float mDistance;
    private float mHalfWaveWidth;
    private int mHeight;
    private String mHint;
    private int mHintColor;
    private int mHintSize;
    private boolean mIsAutoBack;
    private float mMaxProgress;
    private Path mPath;
    private float mProgress;
    private float mSpeed;
    private int mStrokeColor;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private Rect mTextRect;
    private int mTextSize;
    private float mTextSpace;
    private Drawable mTmpBackground;
    private int mWaveBackgroundColor;
    private int mWaveColor;
    private int mWaveCount;
    private float mWaveHeight;
    private Paint mWavePaint;
    private float mWaveWidth;
    private int mWidth;

    public WaveProgressView(Context context) {
        this(context, null);
    }

    public WaveProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIsAutoBack = false;
        this.mWaveCount = 0;
        this.mHalfWaveWidth = this.mWaveWidth / 4.0f;
        this.mDistance = 0.0f;
        this.mHintColor = Color.parseColor(DEFAULT_TEXT_HINT_COLOR);
        this.mHint = "可用额度";
        this.mText = "￥80,000.00";
        this.mTextSpace = 10.0f;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WaveProgressView);
        this.mMaxProgress = ta.getInt(R.styleable.WaveProgressView_progress_max, 100);
        this.mProgress = ta.getInt(R.styleable.WaveProgressView_progress, 50);
        this.mWaveWidth = ta.getFloat(R.styleable.WaveProgressView_wave_width, 200.0f);
        this.mHalfWaveWidth = this.mWaveWidth / 4.0f;
        this.mWaveHeight = ta.getFloat(R.styleable.WaveProgressView_wave_height, 20.0f);
        this.mSpeed = ta.getFloat(R.styleable.WaveProgressView_speed, this.mWaveWidth / 70.0f);
        this.mWaveColor = ta.getColor(R.styleable.WaveProgressView_wave_color, Color.parseColor(DEFAULT_WAVE_COLOR));
        this.mWaveBackgroundColor = ta.getColor(R.styleable.WaveProgressView_wave_bg_color, Color.parseColor(DEFAULT_WAVE_BG_COLOR));
        this.mStrokeColor = ta.getColor(R.styleable.WaveProgressView_stroke_color, Color.parseColor(DEFAULT_STROKE_COLOR));
        this.mText = ta.getString(R.styleable.WaveProgressView_main_text);
        if (this.mText == null) {
            this.mText = "";
        }
        this.mTextColor = ta.getColor(R.styleable.WaveProgressView_main_text_color, Color.parseColor(DEFAULT_TEXT_COLOR));
        this.mTextSize = ta.getDimensionPixelSize(R.styleable.WaveProgressView_main_text_size, sp2px(16));
        this.mHint = ta.getString(R.styleable.WaveProgressView_hint_text);
        if (this.mHint == null) {
            this.mHint = "";
        }
        this.mHintColor = ta.getColor(R.styleable.WaveProgressView_hint_color, Color.parseColor(DEFAULT_TEXT_COLOR));
        this.mHintSize = ta.getDimensionPixelSize(R.styleable.WaveProgressView_hint_size, sp2px(14));
        this.mTextSpace = ta.getDimension(R.styleable.WaveProgressView_text_space, 10.0f);
        ta.recycle();
        this.mPath = new Path();
        this.mWavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mWavePaint.setStyle(Paint.Style.FILL);
        this.mWavePaint.setColor(this.mWaveColor);
        this.mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mTextRect = new Rect();
        this.mTmpBackground = getBackground();
        setBackgroundColor(0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = measureWidth(widthMeasureSpec);
        int measuredHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);
        if (this.mTmpBackground == null) {
            this.mIsAutoBack = true;
            int min = Math.min(measuredWidth, measuredHeight);
            this.mStrokeWidth = DEFAULT_STROKE_RADIO * min;
            float spaceWidth = DEFAULT_SPACE_RADIO * min;
            this.mWidth = (int) (min - ((this.mStrokeWidth + spaceWidth) * 2.0f));
            this.mHeight = (int) (min - ((this.mStrokeWidth + spaceWidth) * 2.0f));
            this.mBackground = autoCreateBitmap(this.mWidth / 2);
        } else {
            this.mIsAutoBack = false;
            this.mBackground = getBitmapFromDrawable(this.mTmpBackground);
            if (this.mBackground != null && !this.mBackground.isRecycled()) {
                this.mWidth = this.mBackground.getWidth();
                this.mHeight = this.mBackground.getHeight();
            }
        }
        this.mWaveCount = calWaveCount(this.mWidth, this.mWaveWidth);
    }

    private Bitmap autoCreateBitmap(int radius) {
        Bitmap bitmap = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(this.mWaveBackgroundColor);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(radius, radius, radius, p);
        return bitmap;
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private int measureHeight(int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return 0;
        }
        if (this.mTmpBackground != null) {
            int height = this.mTmpBackground.getMinimumHeight();
            return height;
        }
        return 400;
    }

    private int measureWidth(int widthMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return 0;
        }
        if (this.mTmpBackground != null) {
            int width = this.mTmpBackground.getMinimumWidth();
            return width;
        }
        return 400;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("hy", "onDraw");
        Bitmap bitmap = createWaveBitmap(this.mWidth, this.mHeight);
        if (this.mIsAutoBack) {
            if (this.mStrokePaint == null) {
                this.mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
                this.mStrokePaint.setColor(this.mStrokeColor);
                this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
                this.mStrokePaint.setStyle(Paint.Style.STROKE);
            }
            float radius = Math.min(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, radius - (this.mStrokeWidth / 2.0f), this.mStrokePaint);
            float left = (getMeasuredWidth() / 2) - (this.mWidth / 2);
            float top = (getMeasuredHeight() / 2) - (this.mHeight / 2);
            canvas.drawBitmap(bitmap, left, top, null);
        } else {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            this.mTextPaint.setColor(this.mTextColor);
            this.mTextPaint.setTextSize(this.mTextSize);
            this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length() - 1, this.mTextRect);
            float textLength = this.mTextPaint.measureText(this.mText);
            Paint.FontMetrics metrics = this.mTextPaint.getFontMetrics();
            float baseLine = ((this.mTextRect.height() / 2) + ((metrics.descent - metrics.ascent) / 2.0f)) - metrics.descent;
            canvas.drawText(this.mText, (getMeasuredWidth() / 2) - (textLength / 2.0f), (getMeasuredHeight() / 2) + baseLine, this.mTextPaint);
        }
        if (!TextUtils.isEmpty(this.mHint)) {
            this.mTextPaint.setColor(this.mHintColor);
            this.mTextPaint.setTextSize(this.mHintSize);
            float hintLength = this.mTextPaint.measureText(this.mHint);
            canvas.drawText(this.mHint, (getMeasuredWidth() / 2) - (hintLength / 2.0f), ((getMeasuredHeight() / 2) - this.mTextRect.height()) - this.mTextSpace, this.mTextPaint);
        }
    }

    private Bitmap createWaveBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        int mCurY = (int) ((height * (this.mMaxProgress - this.mProgress)) / this.mMaxProgress);
        Log.i("hy", "mCurY" + mCurY + "width" + width + "height" + height);
        this.mPath.reset();
        this.mPath.moveTo(-this.mDistance, mCurY);
        for (int i = 0; i < this.mWaveCount; i++) {
            this.mPath.quadTo(((i * this.mWaveWidth) + this.mHalfWaveWidth) - this.mDistance, mCurY - this.mWaveHeight, ((i * this.mWaveWidth) + (this.mHalfWaveWidth * 2.0f)) - this.mDistance, mCurY);
            this.mPath.quadTo(((i * this.mWaveWidth) + (this.mHalfWaveWidth * 3.0f)) - this.mDistance, mCurY + this.mWaveHeight, ((i * this.mWaveWidth) + (this.mHalfWaveWidth * 4.0f)) - this.mDistance, mCurY);
        }
        this.mPath.lineTo(width, height);
        this.mPath.lineTo(0.0f, height);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mWavePaint);
        this.mDistance += this.mSpeed;
        this.mDistance %= this.mWaveWidth;
        this.mWavePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        canvas.drawBitmap(this.mBackground, 0.0f, 0.0f, this.mWavePaint);
        return bitmap;
    }

    private int calWaveCount(int width, float waveWidth) {
        if (width % waveWidth == 0.0f) {
            int count = (int) ((width / waveWidth) + 1.0f);
            return count;
        }
        int count2 = (int) ((width / waveWidth) + 2.0f);
        return count2;
    }

    public void setMax(float max) {
        this.mMaxProgress = max;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setSpeed(float speed) {
        this.mSpeed = speed;
    }

    public void setWave(float waveWidth, float waveHeight) {
        this.mWaveWidth = waveWidth;
        this.mWaveHeight = waveHeight;
        this.mHalfWaveWidth = waveWidth / 4.0f;
        this.mWaveCount = calWaveCount(this.mWidth, this.mWaveWidth);
    }

    public void setWaveColor(int waveColor) {
        this.mWaveColor = waveColor;
        this.mWavePaint.setColor(this.mWaveColor);
    }

    public void setWaveBackgroundColor(int waveBackgroundColor) {
        this.mWaveBackgroundColor = waveBackgroundColor;
        if (this.mIsAutoBack) {
            this.mBackground = autoCreateBitmap(this.mWidth / 2);
        }
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeColor = strokeColor;
        if (this.mStrokePaint != null) {
            this.mStrokePaint.setColor(this.mStrokeColor);
        }
    }

    public void setTextSize(int textSize) {
        this.mTextSize = sp2px(textSize);
    }

    public void setTextColor(int textColor) {
        this.mTextColor = textColor;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public void setHintSize(int hintSize) {
        this.mHintSize = sp2px(hintSize);
    }

    public void setHintColor(int hintColor) {
        this.mHintColor = hintColor;
    }

    public void setHint(String hint) {
        this.mHint = hint;
    }

    public void setTextSpace(int textSpace) {
        this.mTextSpace = dp2px(textSpace);
    }

    public int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, getContext().getResources().getDisplayMetrics());
    }

    public int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, getContext().getResources().getDisplayMetrics());
    }
}
