package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(593.0f, 108.0f, 673.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(366.0f, 20.0f, 464.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(587.0f, 18.0f, 675.0f, 52.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(487.0f, 22.0f, 562.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(487.0f, 99.0f, 562.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(111.0f, 86.0f, 205.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(283.0f, 6.0f, 354.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[0] != 0) {
            c.clipRect(114.0f, 31.0f, 205.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(809.0f, 27.0f, 909.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(207.0f, 6.0f, 284.0f, 86.0f, Region.Op.UNION);
        }
        switch (this.DATA[22]) {
            case 1:
                c.clipRect(392.0f, 147.0f, 443.0f, 162.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(385.0f, 122.0f, 408.0f, 142.0f, Region.Op.UNION);
                break;
            case 5:
                c.clipRect(393.0f, 114.0f, 422.0f, 124.0f, Region.Op.UNION);
                c.clipRect(385.0f, 122.0f, 408.0f, 142.0f, Region.Op.UNION);
                break;
            case 6:
                c.clipRect(393.0f, 114.0f, 422.0f, 124.0f, Region.Op.UNION);
                break;
            case 11:
                c.clipRect(390.0f, 88.0f, 429.0f, 113.0f, Region.Op.UNION);
                break;
            case 12:
                c.clipRect(390.0f, 88.0f, 429.0f, 113.0f, Region.Op.UNION);
                c.clipRect(385.0f, 122.0f, 408.0f, 142.0f, Region.Op.UNION);
                break;
            case 13:
                c.clipRect(390.0f, 88.0f, 429.0f, 113.0f, Region.Op.UNION);
                c.clipRect(393.0f, 114.0f, 422.0f, 124.0f, Region.Op.UNION);
                break;
            case 14:
                c.clipRect(390.0f, 88.0f, 429.0f, 113.0f, Region.Op.UNION);
                c.clipRect(393.0f, 114.0f, 422.0f, 124.0f, Region.Op.UNION);
                c.clipRect(385.0f, 122.0f, 408.0f, 142.0f, Region.Op.UNION);
                break;
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(234.0f, 96.0f, (value * 15) + 234, 152.0f, Region.Op.UNION);
        int value2 = this.DATA[10];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(870.0f, 101.0f, (value2 * 15) + 870, 158.0f, Region.Op.UNION);
        int value3 = this.DATA[18];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(56.0f, 129.0f, (value3 * 17) + 56, 155.0f, Region.Op.UNION);
        int value4 = this.DATA[19];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(693.0f, 130.0f, (value4 * 17) + 693, 153.0f, Region.Op.UNION);
        int value5 = this.DATA[7];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(608.0f, 51.0f, (value5 * 20) + 603, 72.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[24];
        int unit = temp >= 60 ? 0 : 1;
        if (temp == -1) {
            c.drawText("NO", 51.0f, 58.0f, this.mPaint);
        } else if (temp == 254) {
            c.drawText("LOW", 51.0f, 58.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 51.0f, 58.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            if (unit == 1) {
                c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "℃", 51.0f, 58.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "℉", 51.0f, 58.0f, this.mPaint);
            }
        }
        int temp3 = this.DATA[25];
        int unit2 = temp3 >= 60 ? 0 : 1;
        if (temp3 == -1) {
            c.drawText("NO", 738.0f, 58.0f, this.mPaint);
        } else if (temp3 == 254) {
            c.drawText("LOW", 738.0f, 58.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 738.0f, 58.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            if (unit2 == 1) {
                c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10) + "℃", 738.0f, 58.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10) + "℉", 738.0f, 58.0f, this.mPaint);
            }
        }
        c.drawText(new StringBuilder().append(this.DATA[8]).toString(), 968.0f, 58.0f, this.mPaint);
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}