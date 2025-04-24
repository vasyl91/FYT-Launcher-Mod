package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0429_DJ_XP1_TOYOTA_12Crown_Low extends AirBase {
    public Air_0429_DJ_XP1_TOYOTA_12Crown_Low(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_low_n.webp";
        this.mPathHighlight = "0429_dj_xp1_toyota_12crown/air_dj_xp1_12crown_low_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(185.0f, 21.0f, 329.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(708.0f, 15.0f, 821.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(842.0f, 90.0f, 1011.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(353.0f, 14.0f, 501.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(539.0f, 23.0f, 664.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(15.0f, 99.0f, 187.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(685.0f, 91.0f, 725.0f, 121.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(689.0f, 121.0f, 722.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(683.0f, 130.0f, 710.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(89.0f, 97.0f, 175.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(251.0f, 90.0f, 382.0f, 169.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(249.0f, 216.0f, 363.0f, 269.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(121.0f, 32.0f, 169.0f, 84.0f, Region.Op.UNION);
            c.clipRect(973.0f, 32.0f, 1021.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(858.0f, 218.0f, 1002.0f, 282.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(677.0f, 220.0f, 759.0f, 269.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(457.0f, 97.0f, 457.0f + (value * 18.4f), 169.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 68.0f, 55.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 68.0f, 55.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 68.0f, 55.0f, this.mPaint);
        } else if (this.DATA[28] == 0) {
            c.drawText(String.valueOf(temp / 2.0f), 68.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 68.0f, 55.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NO", 922.0f, 55.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 922.0f, 55.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 922.0f, 55.0f, this.mPaint);
        } else if (this.DATA[28] == 0) {
            c.drawText(String.valueOf(temp2 / 2.0f), 922.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 922.0f, 55.0f, this.mPaint);
        }
        int temp3 = this.DATA[33];
        if (temp3 == -1) {
            c.drawText("NO", 494.0f, 262.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 494.0f, 262.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 494.0f, 262.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp3 / 2.0f), 494.0f, 262.0f, this.mPaint);
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
