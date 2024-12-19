package com.syu.carinfo.zx6606;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class InfoZX6606ViewSteer extends View {
    private float angle;
    private int autoStep;
    Bitmap bg;
    Bitmap bg_digit;
    Bitmap bg_indicate;
    private int currenSpeed;
    int height;
    private Path mPath;
    private Paint paint;
    private Handler speedH;
    private int step;
    private int targetSpeed;
    private Paint textPain;
    int width;

    public InfoZX6606ViewSteer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currenSpeed = 0;
        this.targetSpeed = 0;
        this.step = 1;
        this.autoStep = 0;
        this.mPath = new Path();
        this.speedH = new Handler() { // from class: com.syu.carinfo.zx6606.InfoZX6606ViewSteer.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (msg.what != 1) {
                    if (InfoZX6606ViewSteer.this.currenSpeed != InfoZX6606ViewSteer.this.targetSpeed) {
                        InfoZX6606ViewSteer.this.step = (int) (InfoZX6606ViewSteer.this.step / 1.5d);
                        if (InfoZX6606ViewSteer.this.step < 1) {
                            InfoZX6606ViewSteer.this.step = 1;
                        }
                        if (InfoZX6606ViewSteer.this.currenSpeed < InfoZX6606ViewSteer.this.targetSpeed) {
                            InfoZX6606ViewSteer.this.currenSpeed = InfoZX6606ViewSteer.this.step + InfoZX6606ViewSteer.this.currenSpeed;
                        } else {
                            InfoZX6606ViewSteer.this.currenSpeed -= InfoZX6606ViewSteer.this.step;
                        }
                        InfoZX6606ViewSteer.this.speedanim();
                        if (InfoZX6606ViewSteer.this.step > 6) {
                            sendEmptyMessageDelayed(0, 20L);
                            return;
                        } else {
                            sendEmptyMessageDelayed(0, 30L);
                            return;
                        }
                    }
                    return;
                }
                InfoZX6606ViewSteer.this.targetSpeed += InfoZX6606ViewSteer.this.autoStep;
                if (InfoZX6606ViewSteer.this.targetSpeed > 64) {
                    InfoZX6606ViewSteer.this.targetSpeed = 0;
                }
                InfoZX6606ViewSteer.this.setSpeed(InfoZX6606ViewSteer.this.targetSpeed);
                sendEmptyMessageDelayed(1, 3000L);
            }
        };
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        getWidth();
        getHeight();
        this.bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_zx6606_dashboard_steer);
        this.bg_indicate = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_zx6606_dashboard_steer_p);
        this.mPath.moveTo(-10.0f, 0.0f);
        this.mPath.lineTo(0.0f, 60.0f);
        this.mPath.lineTo(10.0f, 60.0f);
        this.mPath.moveTo(-10.0f, 0.0f);
        this.mPath.addCircle(0.0f, 0.0f, 10.0f, Path.Direction.CW);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = w;
        setMax_mini(64, 0);
        setxy();
    }

    public void setMax_mini(int max, int mini) {
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
        int step = (int) Math.ceil((max - mini) / 10.0f);
        this.autoStep = step / 2;
        setSpeed(this.targetSpeed);
    }

    @Override // android.view.View
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

    void setxy() {
        this.angle = (this.currenSpeed / 64.0f) * 280.0f;
        this.angle -= 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void speedanim() {
        if (this.currenSpeed >= 10) {
        }
        setxy();
        invalidate();
    }

    public void setSpeed(int s) {
        this.step = Math.abs(s - this.currenSpeed) / 8;
        this.targetSpeed = s;
        this.speedH.removeMessages(0);
        this.speedH.sendEmptyMessage(0);
    }
}
