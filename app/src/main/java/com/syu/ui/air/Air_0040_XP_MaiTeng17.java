package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0040_XP_MaiTeng17 extends AirBase {
    public Air_0040_XP_MaiTeng17(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp1_17maiteng.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp1_17maiteng_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[89] != 0) {
            c.clipRect(689.0f, 14.0f, 788.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[102] != 0) {
            c.clipRect(236.0f, 15.0f, 333.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(129.0f, 24.0f, 209.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(234.0f, 104.0f, 338.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(809.0f, 20.0f, 900.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(584.0f, 14.0f, 663.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[106] != 0) {
            c.clipRect(699.0f, 103.0f, 784.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[151] != 0) {
            c.clipRect(346.0f, 104.0f, 452.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(467.0f, 18.0f, 537.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(468.0f, 92.0f, 522.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(459.0f, 110.0f, 511.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[103] == 1) {
            c.clipRect(77.0f, 112.0f, 106.0f, 164.0f, Region.Op.UNION);
            c.clipRect(977.0f, 112.0f, 1011.0f, 159.0f, Region.Op.UNION);
            c.clipRect(420.0f, 35.0f, 452.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(582.0f, 110.0f, 582.0f + (value * 13.5f), 165.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(50.0f, 19.0f, (value2 * 19.0f) + 50.0f, 79.0f, Region.Op.UNION);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(963.0f, 34.0f, 963.0f + (value3 * 19.0f), 76.0f, Region.Op.UNION);
        int value4 = this.DATA[150];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(169.0f, 111.0f, 169.0f + (value4 * 19.0f), 159.0f, Region.Op.UNION);
        int value5 = this.DATA[123];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(847.0f, 122.0f, 847.0f + (value5 * 19.0f), 169.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[98];
        if (temp == 0) {
            c.drawText("LOW", 40.0f, 137.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 40.0f, 137.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp + 59), 40.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 40.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 0) {
            c.drawText("LOW", 945.0f, 137.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 945.0f, 137.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp2 + 59), 945.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 945.0f, 137.0f, this.mPaint);
        }
        int temp3 = this.DATA[154];
        if (temp3 == 0) {
            c.drawText("LOW", 385.0f, 70.0f, this.mPaint);
        } else if (temp3 == 31) {
            c.drawText("HI", 385.0f, 70.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp3 + 59), 385.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp3 * 5) + 155) / 10.0f), 385.0f, 70.0f, this.mPaint);
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
