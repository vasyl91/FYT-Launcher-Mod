package com.fyt.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.syu.ipc.data.FinalCanbus;

public class TurntableView3 extends View {
    public boolean checked;
    int current;
    float endAngle;
    boolean mChanged;
    float mCurrAngle;
    Drawable mDial;
    int mDialHeight;
    int mDialWidth;
    Bitmap mDialbg;
    long mDrawTime;
    int max;
    int min;
    Drawable pointer;
    Bitmap pointerbg;
    float snap;
    float startAngle;
    float target;
    int temp;
    Runnable update;

    public TurntableView3(Context context, AttributeSet arg1, int arg2) {
        super(context, arg1, arg2);
        this.min = 0;
        this.max = 8000;
        this.current = 0;
        this.temp = 0;
        this.snap = 0.0f;
        this.startAngle = -95.0f;
        this.endAngle = 96.0f;
        this.mCurrAngle = -95.0f;
        this.checked = false;
        this.update = new Runnable() { 
            @Override
            public void run() {
                if (Math.abs(TurntableView3.this.current - TurntableView3.this.temp) <= Math.abs(TurntableView3.this.snap)) {
                    TurntableView3.this.snap = TurntableView3.this.temp - TurntableView3.this.current;
                }
                TurntableView3.this.current = (int) (TurntableView3.this.current + TurntableView3.this.snap);
                TurntableView3.this.setTarget(TurntableView3.this.current);
                if (TurntableView3.this.current != TurntableView3.this.temp) {
                    TurntableView3.this.postDelayed(TurntableView3.this.update, 16L);
                    return;
                }
                TurntableView3.this.removeCallbacks(TurntableView3.this.update);
                if (TurntableView3.this.checked) {
                    if (TurntableView3.this.current == 0 && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checked = true;
                    } else if (TurntableView3.this.current == TurntableView3.this.max && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checkedWithAnim(TurntableView3.this.min);
                    }
                }
            }
        };
        init(context);
    }

    public TurntableView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.min = 0;
        this.max = 8000;
        this.current = 0;
        this.temp = 0;
        this.snap = 0.0f;
        this.startAngle = -95.0f;
        this.endAngle = 96.0f;
        this.mCurrAngle = -95.0f;
        this.checked = false;
        this.update = new Runnable() { 
            @Override
            public void run() {
                if (Math.abs(TurntableView3.this.current - TurntableView3.this.temp) <= Math.abs(TurntableView3.this.snap)) {
                    TurntableView3.this.snap = TurntableView3.this.temp - TurntableView3.this.current;
                }
                TurntableView3.this.current = (int) (TurntableView3.this.current + TurntableView3.this.snap);
                TurntableView3.this.setTarget(TurntableView3.this.current);
                if (TurntableView3.this.current != TurntableView3.this.temp) {
                    TurntableView3.this.postDelayed(TurntableView3.this.update, 16L);
                    return;
                }
                TurntableView3.this.removeCallbacks(TurntableView3.this.update);
                if (TurntableView3.this.checked) {
                    if (TurntableView3.this.current == 0 && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checked = true;
                    } else if (TurntableView3.this.current == TurntableView3.this.max && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checkedWithAnim(TurntableView3.this.min);
                    }
                }
            }
        };
        init(context);
    }

    public TurntableView3(Context context) {
        super(context);
        this.min = 0;
        this.max = 8000;
        this.current = 0;
        this.temp = 0;
        this.snap = 0.0f;
        this.startAngle = -95.0f;
        this.endAngle = 96.0f;
        this.mCurrAngle = -95.0f;
        this.checked = false;
        this.update = new Runnable() { 
            @Override
            public void run() {
                if (Math.abs(TurntableView3.this.current - TurntableView3.this.temp) <= Math.abs(TurntableView3.this.snap)) {
                    TurntableView3.this.snap = TurntableView3.this.temp - TurntableView3.this.current;
                }
                TurntableView3.this.current = (int) (TurntableView3.this.current + TurntableView3.this.snap);
                TurntableView3.this.setTarget(TurntableView3.this.current);
                if (TurntableView3.this.current != TurntableView3.this.temp) {
                    TurntableView3.this.postDelayed(TurntableView3.this.update, 16L);
                    return;
                }
                TurntableView3.this.removeCallbacks(TurntableView3.this.update);
                if (TurntableView3.this.checked) {
                    if (TurntableView3.this.current == 0 && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checked = true;
                    } else if (TurntableView3.this.current == TurntableView3.this.max && TurntableView3.this.current == TurntableView3.this.temp) {
                        TurntableView3.this.checkedWithAnim(TurntableView3.this.min);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mDialbg = Helpers.glideLoader(R.drawable.rate_dial_speed);
        this.mDial = new BitmapDrawable(getResources(), this.mDialbg);
        this.pointerbg = Helpers.glideLoader(R.drawable.rotate_pionter);
        this.pointer = new BitmapDrawable(getResources(), this.pointerbg);
        setRange(0, 24000);
        setAngleRange(-120, FinalCanbus.CAR_FYT_XP1_14Prado_L);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mChanged = true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        float hScale = 1.0f;
        float vScale = 1.0f;
        if (widthMode != 0 && widthSize < this.mDialWidth) {
            hScale = widthSize / this.mDialWidth;
        }
        if (heightMode != 0 && heightSize < this.mDialHeight) {
            vScale = heightSize / this.mDialHeight;
        }
        float scale = Math.min(hScale, vScale);
        setMeasuredDimension(resolveSizeAndState((int) (this.mDialWidth * scale), widthMeasureSpec, 0), resolveSizeAndState((int) (this.mDialHeight * scale), heightMeasureSpec, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean changed = this.mChanged;
        if (changed) {
            this.mChanged = false;
        }
        boolean inva = false;
        long currDrawTime = getDrawingTime();
        if (this.mCurrAngle != this.target) {
            if (this.mDrawTime == 0) {
                this.mDrawTime = currDrawTime - 17;
            }
            inva = true;
        }
        float dx = ((this.endAngle - this.startAngle) * ((float) (currDrawTime - this.mDrawTime))) / (this.checked ? 8000.0f : 1000.0f);
        this.mDrawTime = currDrawTime;
        this.target = Math.max(this.startAngle, Math.min(this.target, this.endAngle));
        if (Math.abs(this.mCurrAngle - this.target) <= Math.abs(dx)) {
            this.mCurrAngle = this.target;
            inva = false;
        } else {
            this.mCurrAngle += (Math.abs(this.mCurrAngle - this.target) / (this.target - this.mCurrAngle)) * dx;
        }
        int availableWidth = getRight() - getLeft();
        int availableHeight = getBottom() - getTop();
        int x = availableWidth / 2;
        int y = availableHeight / 2;
        Drawable dial = this.mDial;
        int w = dial.getIntrinsicWidth();
        int h = dial.getIntrinsicHeight();
        boolean scaled = false;
        if (availableWidth < w || availableHeight < h) {
            scaled = true;
            float scale = Math.min(availableWidth / w, availableHeight / h);
            canvas.save();
            canvas.scale(scale, scale, x, y);
        }
        if (changed) {
            dial.setBounds(x - (w / 2), y - (h / 2), (w / 2) + x, (h / 2) + y);
        }
        dial.draw(canvas);
        canvas.save();
        Drawable pointer = this.pointer;
        int pWidth = pointer.getIntrinsicWidth();
        int pHeight = pointer.getIntrinsicHeight();
        canvas.rotate(this.mCurrAngle, x, y);
        pointer.setBounds(x - (pWidth / 2), y - (pHeight / 2), (pWidth / 2) + x, (pHeight / 2) + y);
        pointer.draw(canvas);
        canvas.restore();
        if (scaled) {
            canvas.restore();
        }
        if (inva) {
            invalidate();
        } else {
            this.mDrawTime = 0L;
        }
    }

    void checkedWithAnim(int target) {
        this.temp = target;
        this.snap = (this.temp - this.current) / 60.0f;
        removeCallbacks(this.update);
        post(this.update);
    }

    public float getTarget() {
        return this.target;
    }

    
    public void setTarget(float target) {
        this.target = this.startAngle + (((this.endAngle - this.startAngle) / (this.max - this.min)) * (target - this.min));
        invalidate();
    }

    public void setTargetWithAnim(int target) {
        if (!this.checked) {
            setTarget(target);
        }
    }

    public void setRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setAngleRange(int min, int max) {
        this.startAngle = min;
        this.endAngle = max;
        this.target = this.endAngle;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.checked) {
            checkedWithAnim(this.max);
        }
    }

    Path getSectorClip(float centerX, float centerY, float r, float startAngle, float endAngle) {
        Path path = new Path();
        path.moveTo(centerX, centerY);
        path.lineTo((float) (centerX + (r * Math.cos((startAngle * 3.141592653589793d) / 180.0d))), (float) (centerY + (r * Math.sin((startAngle * 3.141592653589793d) / 180.0d))));
        path.lineTo((float) (centerX + (r * Math.cos((endAngle * 3.141592653589793d) / 180.0d))), (float) (centerY + (r * Math.sin((endAngle * 3.141592653589793d) / 180.0d))));
        path.close();
        RectF rectF = new RectF(centerX - r, centerY - r, centerX + r, centerY + r);
        path.addArc(rectF, startAngle, endAngle - startAngle);
        return path;
    }
}
