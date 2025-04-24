package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0241_WC1_RuiJie extends AirBase {
    public Air_0241_WC1_RuiJie(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0241_wc1_ruijie/air_wc1_ford_ruijie_n.webp";
        this.mPathHighlight = "0241_wc1_ruijie/air_wc1_ford_ruijie_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(273.0f, 105.0f, 368.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(659.0f, 108.0f, 743.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(271.0f, 25.0f, 375.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(13.0f, 25.0f, 123.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(403.0f, 19.0f, 491.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(399.0f, 94.0f, 489.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(655.0f, 22.0f, 751.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(534.0f, 7.0f, 583.0f, 40.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(909.0f, 17.0f, 1007.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(561.0f, 42.0f, 602.0f, 55.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(541.0f, 56.0f, 575.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 1) {
            c.clipRect(85.0f, 110.0f, 127.0f, 160.0f, Region.Op.UNION);
            c.clipRect(971.0f, 107.0f, 1013.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(530.0f, 120.0f, (value * 14) + 530, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[13];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(195.0f, 135.0f, 195.0f + (value2 * 23.0f), 156.0f, Region.Op.UNION);
        int value3 = this.DATA[14];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        c.clipRect(834.0f - (value3 * 23.0f), 135.0f, 834.0f, 156.0f, Region.Op.UNION);
        int value4 = this.DATA[15];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 2) {
            value4 = 2;
        }
        c.clipRect(196.0f, 57.0f, 196.0f + (value4 * 23.0f), 78.0f, Region.Op.UNION);
        int value5 = this.DATA[16];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 2) {
            value5 = 2;
        }
        c.clipRect(833.0f - (value5 * 23.0f), 58.0f, 833.0f, 79.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 52.0f, 137.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 52.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 52.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 52.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[18];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 137.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 137.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 940.0f, 137.0f, this.mPaint);
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
