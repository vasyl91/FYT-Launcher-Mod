package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0443_WC2_19Sprinter extends AirBase {
    public Air_0443_WC2_19Sprinter(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_19focus/air_wc2_19focus_n.webp";
        this.mPathHighlight = "0443_wc2_19focus/air_wc2_19focus_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(593.0f, 108.0f, 673.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(366.0f, 20.0f, 464.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(587.0f, 18.0f, 675.0f, 52.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(487.0f, 22.0f, 562.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(487.0f, 99.0f, 562.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(132.0f, 102.0f, 186.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(114.0f, 31.0f, 205.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(809.0f, 27.0f, 909.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(390.0f, 88.0f, 429.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(393.0f, 114.0f, 422.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(385.0f, 122.0f, 408.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(591.0f, 20.0f, 674.0f, 74.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(234.0f, 96.0f, (value * 15) + 234, 152.0f, Region.Op.UNION);
        int value2 = this.DATA[23];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(870.0f, 101.0f, (value2 * 15) + 870, 158.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -1) {
            c.drawText("NO", 51.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 51.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 58.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10) + "℃", 51.0f, 58.0f, this.mPaint);
        }
        int temp3 = this.DATA[22];
        if (temp3 == -1) {
            c.drawText("NO", 738.0f, 58.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 738.0f, 58.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 738.0f, 58.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(temp4 / 10 + "." + (temp4 % 10) + "℃", 738.0f, 58.0f, this.mPaint);
        }
        int temp5 = this.DATA[24];
        if (temp5 == -1) {
            c.drawText("NO", 968.0f, 58.0f, this.mPaint);
        } else if (temp5 == -2) {
            c.drawText("LOW", 968.0f, 58.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 968.0f, 58.0f, this.mPaint);
        } else {
            int temp6 = temp5 * 5;
            c.drawText(temp6 / 10 + "." + (temp6 % 10) + "℃", 968.0f, 58.0f, this.mPaint);
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
