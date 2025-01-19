package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0160_RZC_DaZhong_All extends AirBase {
    public Air_0160_RZC_DaZhong_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc_all.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc_all_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[190] != 0) {
            c.clipRect(414.0f, 242.0f, 507.0f, 270.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(629.0f, 20.0f, 696.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[366] != 0) {
            c.clipRect(737.0f, 19.0f, 792.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(221.0f, 131.0f, 297.0f, 179.0f, Region.Op.UNION);
        }
        if (this.DATA[91] != 0) {
            c.clipRect(323.0f, 135.0f, 392.0f, 178.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(428.0f, 18.0f, 492.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(206.0f, 33.0f, 306.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[106] != 0) {
            c.clipRect(412.0f, 119.0f, 506.0f, 183.0f, Region.Op.UNION);
        }
        if (this.DATA[151] != 0) {
            c.clipRect(520.0f, 23.0f, 604.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(317.0f, 36.0f, 394.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[157] == 0) {
            c.clipRect(826.0f, 112.0f, 911.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(523.0f, 110.0f, 577.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(534.0f, 150.0f, 573.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(532.0f, 162.0f, 560.0f, 192.0f, Region.Op.UNION);
        }
        if (this.DATA[206] != 0) {
            c.clipRect(535.0f, 232.0f, 578.0f, 251.0f, Region.Op.UNION);
        }
        if (this.DATA[204] != 0) {
            c.clipRect(529.0f, 250.0f, 557.0f, 280.0f, Region.Op.UNION);
        }
        if (this.DATA[207] != 0) {
            c.clipRect(216.0f, 237.0f, 300.0f, 277.0f, Region.Op.UNION);
        }
        if (this.DATA[123] != 0) {
            c.clipRect(823.0f, 232.0f, 917.0f, 274.0f, Region.Op.UNION);
        }
        if (this.DATA[156] != 0) {
            c.clipRect(69.0f, 36.0f, 99.0f, 80.0f, Region.Op.UNION);
            c.clipRect(990.0f, 36.0f, 1021.0f, 83.0f, Region.Op.UNION);
            c.clipRect(380.0f, 230.0f, 409.0f, 273.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(676.0f, 133.0f, 676.0f + (value * 16.0f), 178.0f, Region.Op.UNION);
        int value2 = this.DATA[205];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(677.0f, 231.0f, 677.0f + (value2 * 16.0f), 277.0f, Region.Op.UNION);
        int value3 = this.DATA[92];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(161.0f, 53.0f, 161.0f + (value3 * 14.0f), 83.0f, Region.Op.UNION);
        int value4 = this.DATA[93];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(866.0f - (value4 * 14.0f), 56.0f, 866.0f, 79.0f, Region.Op.UNION);
        int value5 = this.DATA[192];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(156.0f, 156.0f, 156.0f + (value5 * 14.0f), 176.0f, Region.Op.UNION);
        int value6 = this.DATA[191];
        if (value6 < 0) {
            value6 = 0;
        } else if (value6 > 3) {
            value6 = 3;
        }
        c.clipRect(929.0f, 152.0f, 929.0f + (value6 * 14.0f), 180.0f, Region.Op.UNION);
        int value7 = this.DATA[220];
        if (value7 < 0) {
            value7 = 0;
        } else if (value7 > 3) {
            value7 = 3;
        }
        c.clipRect(155.0f, 248.0f, 155.0f + (value7 * 14.0f), 274.0f, Region.Op.UNION);
        int value8 = this.DATA[221];
        if (value8 < 0) {
            value8 = 0;
        } else if (value8 > 3) {
            value8 = 3;
        }
        c.clipRect(932.0f, 245.0f, 932.0f + (value8 * 14.0f), 273.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (temp == 0) {
            c.drawText("LOW", 45.0f, 64.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 45.0f, 64.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp + 59), 45.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 45.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 0) {
            c.drawText("LOW", 960.0f, 64.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 960.0f, 64.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp2 + 59), 960.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 960.0f, 64.0f, this.mPaint);
        }
        int temp3 = this.DATA[154];
        if (temp3 == 0) {
            c.drawText("LOW", 352.0f, 259.0f, this.mPaint);
        } else if (temp3 == 31) {
            c.drawText("HI", 352.0f, 259.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp3 + 59), 352.0f, 259.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp3 * 5) + 155) / 10.0f), 352.0f, 259.0f, this.mPaint);
        }
        int temp4 = this.DATA[226];
        if (temp4 == 15) {
            c.drawText("--", 460.0f, 236.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp4), 460.0f, 236.0f, this.mPaint);
        }
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
