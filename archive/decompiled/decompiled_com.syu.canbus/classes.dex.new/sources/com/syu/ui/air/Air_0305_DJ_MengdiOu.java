package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0305_DJ_MengdiOu extends AirBase {
    public Air_0305_DJ_MengdiOu(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0305_dj_mengdiou/dj_mengdiou.webp";
        this.mPathHighlight = "0305_dj_mengdiou/dj_mengdiou_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(190.0f, 130.0f, 330.0f, 175.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(467.0f, 225.0f, 582.0f, 275.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(275.0f, 230.0f, 360.0f, 280.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(695.0f, 110.0f, 845.0f, 190.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(700.0f, 20.0f, 840.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(535.0f, 120.0f, 660.0f, 180.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(185.0f, 20.0f, 330.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(383.0f, 114.0f, 478.0f, 184.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(275.0f, 230.0f, 360.0f, 280.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(552.0f, 21.0f, 600.0f, 45.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(558.0f, 45.0f, 608.0f, 59.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(549.0f, 60.0f, 588.0f, 91.0f, Path.Direction.CW);
        }
        if (this.DATA[17] != 0) {
            this.srPath.addRect(383.0f, 20.0f, 478.0f, 90.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(658.0f, 218.0f, (value * 20) + 658, 283.0f, Path.Direction.CW);
        int leftSeatHeat = this.DATA[29];
        if (leftSeatHeat < 0) {
            leftSeatHeat = 0;
        } else if (leftSeatHeat > 3) {
            leftSeatHeat = 3;
        }
        this.srPath.addRect(75.0f, 54.0f, (leftSeatHeat * 23) + 75, 80.0f, Path.Direction.CW);
        int rightSeatHeat = this.DATA[30];
        if (rightSeatHeat < 0) {
            rightSeatHeat = 0;
        } else if (rightSeatHeat > 3) {
            rightSeatHeat = 3;
        }
        this.srPath.addRect(892.0f, 54.0f, (rightSeatHeat * 23) + 892, 80.0f, Path.Direction.CW);
        int leftSeatCold = this.DATA[31];
        if (leftSeatCold < 0) {
            leftSeatCold = 0;
        } else if (leftSeatCold > 3) {
            leftSeatCold = 3;
        }
        this.srPath.addRect(80.0f, 152.0f, (leftSeatCold * 23) + 80, 178.0f, Path.Direction.CW);
        int rightSeatCold = this.DATA[32];
        if (rightSeatCold < 0) {
            rightSeatCold = 0;
        } else if (rightSeatCold > 3) {
            rightSeatCold = 3;
        }
        this.srPath.addRect(887.0f, 149.0f, (rightSeatCold * 23) + 887, 175.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        int i = this.DATA[37];
        if (temp == 0) {
            c.drawText("LOW", 100.0f, 255.0f, this.mPaint);
        } else if (temp == 127) {
            c.drawText("HI", 100.0f, 255.0f, this.mPaint);
        } else if (temp >= 31 && temp <= 59) {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d   ℃", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 100.0f, 255.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == 0) {
            c.drawText("LOW", 930.0f, 255.0f, this.mPaint);
        } else if (temp3 == 127) {
            c.drawText("HI", 930.0f, 255.0f, this.mPaint);
        } else if (temp3 >= 31 && temp3 <= 59) {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d   ℃", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 930.0f, 255.0f, this.mPaint);
        }
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
