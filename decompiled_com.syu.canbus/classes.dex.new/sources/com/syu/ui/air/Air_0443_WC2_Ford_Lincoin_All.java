package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_Ford_Lincoin_All extends AirBase {
    public Air_0443_WC2_Ford_Lincoin_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_ford_linken/air_wc2_ford_linken.webp";
        this.mPathHighlight = "0443_wc2_ford_linken/air_wc2_ford_linken_p.webp";
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
        if (this.DATA[14] != 0) {
            this.srPath.addRect(593.0f, 108.0f, 673.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(366.0f, 20.0f, 464.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(587.0f, 18.0f, 675.0f, 52.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(487.0f, 22.0f, 562.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(487.0f, 99.0f, 562.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[17] != 0) {
            this.srPath.addRect(111.0f, 86.0f, 205.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(283.0f, 6.0f, 354.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(114.0f, 31.0f, 205.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(809.0f, 27.0f, 909.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(207.0f, 6.0f, 284.0f, 86.0f, Path.Direction.CW);
        }
        switch (this.DATA[77]) {
            case 1:
                this.srPath.addRect(392.0f, 147.0f, 443.0f, 162.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(385.0f, 122.0f, 408.0f, 142.0f, Path.Direction.CW);
                break;
            case 5:
                this.srPath.addRect(393.0f, 114.0f, 422.0f, 124.0f, Path.Direction.CW);
                this.srPath.addRect(385.0f, 122.0f, 408.0f, 142.0f, Path.Direction.CW);
                break;
            case 6:
                this.srPath.addRect(393.0f, 114.0f, 422.0f, 124.0f, Path.Direction.CW);
                break;
            case 11:
                this.srPath.addRect(390.0f, 88.0f, 429.0f, 113.0f, Path.Direction.CW);
                break;
            case 12:
                this.srPath.addRect(390.0f, 88.0f, 429.0f, 113.0f, Path.Direction.CW);
                this.srPath.addRect(385.0f, 122.0f, 408.0f, 142.0f, Path.Direction.CW);
                break;
            case 13:
                this.srPath.addRect(390.0f, 88.0f, 429.0f, 113.0f, Path.Direction.CW);
                this.srPath.addRect(393.0f, 114.0f, 422.0f, 124.0f, Path.Direction.CW);
                break;
            case 14:
                this.srPath.addRect(390.0f, 88.0f, 429.0f, 113.0f, Path.Direction.CW);
                this.srPath.addRect(393.0f, 114.0f, 422.0f, 124.0f, Path.Direction.CW);
                this.srPath.addRect(385.0f, 122.0f, 408.0f, 142.0f, Path.Direction.CW);
                break;
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(234.0f, 96.0f, (value * 15) + 234, 152.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        this.srPath.addRect(870.0f, 101.0f, (value2 * 15) + 870, 158.0f, Path.Direction.CW);
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(56.0f, 129.0f, (value3 * 17) + 56, 155.0f, Path.Direction.CW);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(693.0f, 130.0f, (value4 * 17) + 693, 153.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(26.0f);
        int temp = this.DATA[27];
        int unit = this.DATA[37];
        if (temp == -1) {
            c.drawText("NO", 51.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 51.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 58.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(temp / 10) + "." + (temp % 10) + "℃", 51.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10) + "℉", 51.0f, 58.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 738.0f, 58.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 738.0f, 58.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 738.0f, 58.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "℃", 738.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10) + "℉", 738.0f, 58.0f, this.mPaint);
        }
        c.drawText(new StringBuilder().append(this.DATA[40]).toString(), 968.0f, 58.0f, this.mPaint);
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
