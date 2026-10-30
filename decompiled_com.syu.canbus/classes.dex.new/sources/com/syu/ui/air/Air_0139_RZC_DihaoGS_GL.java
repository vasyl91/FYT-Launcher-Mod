package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0139_RZC_DihaoGS_GL extends AirBase {
    public Air_0139_RZC_DihaoGS_GL(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0139_jl_dihaoyuanjing/air_dihaoGSGL.webp";
        this.mPathHighlight = "0139_jl_dihaoyuanjing/air_dihaoGSGL_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int left_temp;
        int right_temp;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[11] != 0) {
            this.srPath.addRect(525.0f, 20.0f, 592.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(156.0f, 109.0f, 273.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(183.0f, 8.0f, 244.0f, 40.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(704.0f, 24.0f, 788.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(704.0f, 106.0f, 788.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(408.0f, 11.0f, 478.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(620.0f, 21.0f, 688.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(617.0f, 94.0f, 689.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(530.0f, 90.0f, 570.0f, 121.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(535.0f, 120.0f, 565.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(522.0f, 132.0f, 549.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(167.0f, 41.0f, 261.0f, 80.0f, Path.Direction.CW);
        }
        this.srPath.addRect(323.0f, 90.0f, (this.DATA[21] * 20) + 323, 158.0f, Path.Direction.CW);
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(60.0f, 126.0f, 60.0f + (value * 17.0f), 155.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(954.0f - (value2 * 17.0f), 128.0f, 954.0f, 156.0f, Path.Direction.CW);
        int value3 = this.DATA[58];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(311.0f, 47.0f, 311.0f + (value3 * 17.0f), 71.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int left_temp2 = this.DATA[27];
        if (left_temp2 == -2) {
            c.drawText("LOW", 61.0f, 54.0f, this.mPaint);
        } else if (left_temp2 == -3) {
            c.drawText("HI", 61.0f, 54.0f, this.mPaint);
        } else {
            if (left_temp2 >= 32 && left_temp2 <= 34) {
                left_temp = ((left_temp2 - 32) * 5) + 160;
            } else {
                left_temp = (left_temp2 * 5) + 170;
            }
            c.drawText(String.valueOf(left_temp / 10) + "." + (left_temp % 10), 61.0f, 54.0f, this.mPaint);
        }
        int right_temp2 = this.DATA[28];
        if (right_temp2 == -2) {
            c.drawText("LOW", 940.0f, 54.0f, this.mPaint);
        } else if (right_temp2 == -3) {
            c.drawText("HI", 940.0f, 54.0f, this.mPaint);
        } else {
            if (right_temp2 >= 32 && right_temp2 <= 34) {
                right_temp = ((right_temp2 - 32) * 5) + 160;
            } else {
                right_temp = (right_temp2 * 5) + 170;
            }
            c.drawText(String.valueOf(right_temp / 10) + "." + (right_temp % 10), 940.0f, 54.0f, this.mPaint);
        }
        int pm25inter = this.DATA[109];
        c.drawText(new StringBuilder(String.valueOf(pm25inter)).toString(), 838.0f, 157.0f, this.mPaint);
        int pm25out = this.DATA[110];
        c.drawText(new StringBuilder(String.valueOf(pm25out)).toString(), 838.0f, 73.0f, this.mPaint);
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
