package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0017_WC2_TuAng_Wc extends AirBase {
    public Air_0017_WC2_TuAng_Wc(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc_tuang.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc_tuang_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[190] != 0) {
            c.clipRect(447.0f, 227.0f, 576.0f, 291.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(305.0f, 125.0f, 431.0f, 185.0f, Region.Op.UNION);
        }
        if (this.DATA[91] != 0) {
            c.clipRect(464.0f, 128.0f, 551.0f, 177.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(598.0f, 30.0f, 724.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(159.0f, 25.0f, 281.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[152] != 0) {
            c.clipRect(159.0f, 110.0f, 272.0f, 193.0f, Region.Op.UNION);
        }
        if (this.DATA[90] != 0) {
            c.clipRect(465.0f, 27.0f, 562.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[157] == 0) {
            c.clipRect(897.0f, 113.0f, 1021.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[153] != 0) {
            c.clipRect(757.0f, 103.0f, 824.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(773.0f, 150.0f, 823.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(764.0f, 164.0f, 803.0f, 197.0f, Region.Op.UNION);
        }
        if (this.DATA[206] != 0) {
            c.clipRect(620.0f, 239.0f, 668.0f, 258.0f, Region.Op.UNION);
        }
        if (this.DATA[204] != 0) {
            c.clipRect(609.0f, 257.0f, 648.0f, 287.0f, Region.Op.UNION);
        }
        if (this.DATA[207] != 0) {
            c.clipRect(152.0f, 215.0f, 291.0f, 275.0f, Region.Op.UNION);
        }
        if (this.DATA[123] != 0) {
            c.clipRect(881.0f, 220.0f, 1022.0f, 277.0f, Region.Op.UNION);
        }
        if (this.DATA[156] != 0) {
            c.clipRect(104.0f, 50.0f, 140.0f, 100.0f, Region.Op.UNION);
            c.clipRect(980.0f, 50.0f, 1016.0f, 100.0f, Region.Op.UNION);
            c.clipRect(401.0f, 240.0f, 437.0f, 290.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(615.0f, 124.0f, 615.0f + (value * 15.7f), 196.0f, Region.Op.UNION);
        int value2 = this.DATA[205];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(761.0f, 217.0f, 761.0f + (value2 * 15.7f), 289.0f, Region.Op.UNION);
        int value3 = this.DATA[92];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(363.0f, 58.0f, 363.0f + (value3 * 19.0f), 78.0f, Region.Op.UNION);
        int value4 = this.DATA[93];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(809.0f - (value4 * 19.0f), 58.0f, 809.0f, 78.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (temp == 254) {
            c.drawText("LOW", 62.0f, 71.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 62.0f, 71.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp * 5) / 10.0f), 62.0f, 71.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 254) {
            c.drawText("LOW", 935.0f, 71.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 935.0f, 71.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp2 * 5) / 10.0f), 935.0f, 71.0f, this.mPaint);
        }
        int temp3 = this.DATA[154];
        if (temp3 == 254) {
            c.drawText("LOW", 353.0f, 264.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 353.0f, 264.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf((temp3 * 5) / 10.0f), 353.0f, 264.0f, this.mPaint);
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
