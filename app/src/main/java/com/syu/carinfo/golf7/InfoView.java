package com.syu.carinfo.golf7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class InfoView extends View {
    private float angle;
    private int autoStep;
    Bitmap bg;
    Bitmap bg_digit;
    Bitmap bg_indicate;
    private int currenSpeed;
    int height;
    private Path mPath;
    private int max;
    private int mini;
    private Paint paint;
    private Handler speedH;
    private int step;
    private int targetSpeed;
    private Paint textPain;
    int width;

    public InfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currenSpeed = 0;
        this.targetSpeed = 0;
        this.step = 1;
        this.max = 8000;
        this.mini = 0;
        this.autoStep = 0;
        this.mPath = new Path();
        this.speedH = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what != 1) {
                    if (InfoView.this.currenSpeed != InfoView.this.targetSpeed) {
                        InfoView.this.step = (int) (InfoView.this.step / 1.5d);
                        if (InfoView.this.step < 1) {
                            InfoView.this.step = 1;
                        }
                        if (InfoView.this.currenSpeed < InfoView.this.targetSpeed) {
                            InfoView.this.currenSpeed = InfoView.this.step + InfoView.this.currenSpeed;
                        } else {
                            InfoView.this.currenSpeed -= InfoView.this.step;
                        }
                        InfoView.this.speedanim();
                        if (InfoView.this.step > 6) {
                            sendEmptyMessageDelayed(0, 20L);
                            return;
                        } else {
                            sendEmptyMessageDelayed(0, 30L);
                            return;
                        }
                    }
                    return;
                }
                InfoView.this.targetSpeed += InfoView.this.autoStep;
                if (InfoView.this.targetSpeed > InfoView.this.max) {
                    InfoView.this.targetSpeed = InfoView.this.mini;
                }
                InfoView.this.setSpeed(InfoView.this.targetSpeed);
                sendEmptyMessageDelayed(1, 3000L);
            }
        };
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        getWidth();
        getHeight();
        this.bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_dashboard1_dzsj);
        this.bg_indicate = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_dashboard_indicator);
        this.mPath.moveTo(-10.0f, 0.0f);
        this.mPath.lineTo(0.0f, 60.0f);
        this.mPath.lineTo(10.0f, 60.0f);
        this.mPath.moveTo(-10.0f, 0.0f);
        this.mPath.addCircle(0.0f, 0.0f, 10.0f, Path.Direction.CW);
        this.mPath.close();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = w;
        setMax_mini(this.max, this.mini);
        setxy();
    }

    public void setMax_mini(int max, int mini) {
        this.max = max;
        this.mini = mini;
        this.currenSpeed = mini;
        this.height = (int) ((this.width / this.bg.getWidth()) * this.bg.getHeight());
        if (this.bg_digit == null) {
            this.bg_digit = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.bg_digit);
        Matrix mt = new Matrix();
        mt.setScale(this.width / this.bg.getWidth(), this.height / this.bg.getHeight());
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        canvas.drawBitmap(this.bg, mt, p);
        canvas.save();
        int[] steps = new int[5];
        steps[0] = mini;
        steps[4] = max;
        int step = (int) Math.ceil((this.max - this.mini) / 4.0f);
        this.autoStep = step / 2;
        for (int i = 1; i < 5; i++) {
            steps[i] = steps[i - 1] + step;
        }
        setSpeed(this.targetSpeed);
    }

    protected void onDrawText() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bg_digit != null) {
            canvas.drawBitmap(this.bg_digit, 0.0f, 0.0f, (Paint) null);
            canvas.save();
            canvas.translate(this.width / 2, this.width / 2);
            canvas.rotate(this.angle);
            canvas.drawBitmap(this.bg_indicate, (-this.bg_indicate.getWidth()) / 2, (-this.bg_indicate.getHeight()) / 2, this.textPain);
            canvas.restore();
        }
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.mini;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.mini = min;
    }

    void setxy() {
        this.angle = (this.currenSpeed / 8000) * 244.0f;
        this.angle -= 122;
    }

    
    public void speedanim() {
        setxy();
        invalidate();
    }

    public void setSpeed(int s) {
        this.step = Math.abs(s - this.currenSpeed) / 2;
        this.targetSpeed = s;
        this.speedH.removeMessages(0);
        this.speedH.sendEmptyMessage(0);
    }
}
