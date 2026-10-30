package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_OD_Captiva extends AirBase {
    public Air_0452_OD_Captiva(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0448_lz_bmw/air_lz_bmw_carui_n.webp";
        this.mPathHighlight = "0448_lz_bmw/air_lz_bmw_carui_p.webp";
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
            this.srPath.addRect(266.0f, 31.0f, 381.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(136.0f, 21.0f, 217.0f, 79.0f, Path.Direction.CW);
            this.srPath.addRect(783.0f, 21.0f, 852.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(164.0f, 131.0f, 227.0f, 152.0f, Path.Direction.CW);
            this.srPath.addRect(807.0f, 133.0f, 863.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(162.0f, 80.0f, 215.0f, 104.0f, Path.Direction.CW);
            this.srPath.addRect(807.0f, 84.0f, 847.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(153.0f, 101.0f, 190.0f, 129.0f, Path.Direction.CW);
            this.srPath.addRect(795.0f, 104.0f, 826.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(419.0f, 111.0f, 487.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(653.0f, 105.0f, 755.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(272.0f, 103.0f, 361.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(544.0f, 13.0f, 621.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(413.0f, 15.0f, 487.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0 && this.DATA[54] == 0) {
            this.srPath.addRect(646.0f, 15.0f, 766.0f, 79.0f, Path.Direction.CW);
        }
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
        int value1 = this.DATA[29];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 3) {
            value1 = 3;
        }
        c.drawText(new StringBuilder().append(value1).toString(), 86.0f, 62.0f, this.mPaint);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.drawText(new StringBuilder().append(value2).toString(), 931.0f, 62.0f, this.mPaint);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            if (left_temp >= 1 && left_temp <= 28) {
                left_temp = (left_temp * 5) + 165;
            } else if (left_temp == 29) {
                left_temp = 160;
            } else if (left_temp == 31) {
                left_temp = 165;
            } else if (left_temp == 32) {
                left_temp = 150;
            } else if (left_temp == 33) {
                left_temp = 155;
            } else if (left_temp == 34) {
                left_temp = 310;
            }
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            if (right_temp >= 1 && right_temp <= 28) {
                right_temp = (right_temp * 5) + 165;
            } else if (right_temp == 29) {
                right_temp = 160;
            } else if (right_temp == 31) {
                right_temp = 165;
            } else if (right_temp == 32) {
                right_temp = 150;
            } else if (right_temp == 33) {
                right_temp = 155;
            } else if (right_temp == 34) {
                right_temp = 310;
            }
            c.drawText(new StringBuilder().append(right_temp / 10.0f).toString(), 930.0f, 152.0f, this.mPaint);
        }
        if (this.DATA[33] != 0) {
            c.drawText("Auto", 580.0f, 144.0f, this.mPaint);
        } else {
            int value = this.DATA[21];
            c.drawText(new StringBuilder().append(value).toString(), 580.0f, 144.0f, this.mPaint);
        }
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[54] != 0) {
            c.drawText("AQS", 670.0f, 25.0f, this.mPaint);
        } else {
            c.drawText("", 670.0f, 25.0f, this.mPaint);
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
