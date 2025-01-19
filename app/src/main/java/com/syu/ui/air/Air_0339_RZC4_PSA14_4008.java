package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0339_RZC4_PSA14_4008 extends AirBase {
    public Air_0339_RZC4_PSA14_4008(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0163_rzc_psa14_408/air_xp1_4008_14_n.webp";
        this.mPathHighlight = "0163_rzc_psa14_408/air_xp1_4008_14_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(5.0f, 16.0f, 132.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(750.0f, 19.0f, 862.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(747.0f, 98.0f, 859.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(157.0f, 13.0f, 277.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(610.0f, 98.0f, 721.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(153.0f, 100.0f, 281.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(607.0f, 15.0f, 714.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(304.0f, 101.0f, 422.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(320.0f, 6.0f, 356.0f, 29.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(339.0f, 26.0f, 375.0f, 39.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(323.0f, 40.0f, 352.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[49] == 0) {
            c.clipRect(335.0f, 65.0f, 387.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(93.0f, 111.0f, 137.0f, 165.0f, Region.Op.UNION);
            c.clipRect(972.0f, 111.0f, 1016.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(902.0f, 24.0f, 995.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[52] == 0) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 1) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
            c.clipRect(476.0f, 21.0f, 513.0f, 58.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 2) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
            c.clipRect(476.0f, 21.0f, 513.0f, 58.0f, Region.Op.UNION);
            c.clipRect(499.0f, 57.0f, 536.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value == 0) {
            c.clipRect(446.0f, 92.0f, 503.0f, 122.0f, Region.Op.UNION);
        }
        int value2 = value - 1;
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 8) {
            value2 = 8;
        }
        c.clipRect(451.0f, 116.0f, (value2 * 16) + 451, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 132.0f, this.mPaint);
        } else if (this.DATA[38] != 0) {
            c.drawText(String.valueOf(temp), 56.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 56.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 132.0f, this.mPaint);
        } else if (this.DATA[38] != 0) {
            c.drawText(String.valueOf(temp2), 930.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 132.0f, this.mPaint);
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
