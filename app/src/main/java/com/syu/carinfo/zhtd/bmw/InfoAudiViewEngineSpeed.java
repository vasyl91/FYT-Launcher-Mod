package com.syu.carinfo.zhtd.bmw;

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
public class InfoAudiViewEngineSpeed extends View {
    private float angle;
    private int autoStep;
    Bitmap bg;
    Bitmap bg_digit;
    Bitmap bg_indicate;
    private boolean changeflag;
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

    public InfoAudiViewEngineSpeed(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currenSpeed = 0;
        this.targetSpeed = 0;
        this.step = 1;
        this.max = 260;
        this.mini = 0;
        this.autoStep = 0;
        this.mPath = new Path();
        this.changeflag = false;
        this.speedH = new Handler() { // from class: com.syu.carinfo.zhtd.bmw.InfoAudiViewEngineSpeed.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (msg.what != 1) {
                    if (InfoAudiViewEngineSpeed.this.currenSpeed == InfoAudiViewEngineSpeed.this.targetSpeed) {
                        if (InfoAudiViewEngineSpeed.this.changeflag) {
                            InfoAudiViewEngineSpeed.this.changeflag = false;
                            InfoAudiViewEngineSpeed.this.speedanim();
                            return;
                        }
                        return;
                    }
                    InfoAudiViewEngineSpeed.this.step = (int) (InfoAudiViewEngineSpeed.this.step / 1.5d);
                    if (InfoAudiViewEngineSpeed.this.step < 1) {
                        InfoAudiViewEngineSpeed.this.step = 1;
                    }
                    if (InfoAudiViewEngineSpeed.this.currenSpeed < InfoAudiViewEngineSpeed.this.targetSpeed) {
                        InfoAudiViewEngineSpeed.this.currenSpeed = InfoAudiViewEngineSpeed.this.step + InfoAudiViewEngineSpeed.this.currenSpeed;
                    } else {
                        InfoAudiViewEngineSpeed.this.currenSpeed -= InfoAudiViewEngineSpeed.this.step;
                    }
                    InfoAudiViewEngineSpeed.this.speedanim();
                    if (InfoAudiViewEngineSpeed.this.step > 6) {
                        sendEmptyMessageDelayed(0, 20L);
                    } else {
                        sendEmptyMessageDelayed(0, 30L);
                    }
                    InfoAudiViewEngineSpeed.this.changeflag = true;
                    return;
                }
                InfoAudiViewEngineSpeed.this.targetSpeed += InfoAudiViewEngineSpeed.this.autoStep;
                if (InfoAudiViewEngineSpeed.this.targetSpeed > InfoAudiViewEngineSpeed.this.max) {
                    InfoAudiViewEngineSpeed.this.targetSpeed = InfoAudiViewEngineSpeed.this.mini;
                }
                InfoAudiViewEngineSpeed.this.setSpeed(InfoAudiViewEngineSpeed.this.targetSpeed);
                sendEmptyMessageDelayed(1, 3000L);
            }
        };
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        getWidth();
        getHeight();
        this.bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_audinew_dashboard_engine_speed);
        this.bg_indicate = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_audinew_dashboard_indicator);
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
        int step = (int) Math.ceil((this.max - this.mini) / 10.0f);
        this.autoStep = step / 2;
        setSpeed(this.targetSpeed);
    }

    protected void onDrawText() {
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
        this.angle = (this.currenSpeed / 240.0f) * 276.0f;
        this.angle -= 138;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void speedanim() {
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
