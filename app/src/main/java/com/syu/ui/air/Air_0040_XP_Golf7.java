package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0040_XP_Golf7 extends AirBase {
    public Air_0040_XP_Golf7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp1_gaoerfu7.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp1_gaoerfu7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[89] != 0) {
            c.clipRect(746.0f, 15.0f, 868.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[122] == 0) {
            c.clipRect(440.0f, 11.0f, 581.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(154.0f, 19.0f, 277.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(150.0f, 96.0f, 283.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[100] != 0) {
            c.clipRect(746.0f, 96.0f, 860.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(609.0f, 11.0f, 716.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[106] != 0) {
            c.clipRect(609.0f, 97.0f, 706.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(304.0f, 43.0f, 356.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(336.0f, 74.0f, 388.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(302.0f, 99.0f, 348.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[103] == 1) {
            c.clipRect(89.0f, 112.0f, 125.0f, 164.0f, Region.Op.UNION);
            c.clipRect(977.0f, 101.0f, 1013.0f, 164.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(459.0f, 117.0f, (value * 15) + 459, 164.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(63.0f, 43.0f, 63.0f + (value2 * 20.0f), 71.0f, Region.Op.UNION);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(942.0f, 48.0f, 942.0f + (value3 * 20.0f), 72.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (DataCanbus.DATA[1000] == 458912 || DataCanbus.DATA[1000] == 524448) {
            if (temp == 0) {
                c.drawText("NONE", 42.0f, 137.0f, this.mPaint);
            } else if (temp <= 15 && temp >= 1) {
                c.drawText("LOW", 42.0f, 137.0f, this.mPaint);
            } else if (temp <= 63 && temp >= 49) {
                c.drawText("HIGH", 42.0f, 137.0f, this.mPaint);
            } else if (temp >= 16 && temp <= 48) {
                c.drawText(((((temp - 16) * 5) + 160) / 10.0f) + " ℃", 42.0f, 137.0f, this.mPaint);
            }
        } else if (temp == 0) {
            c.drawText("LOW", 42.0f, 137.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 42.0f, 137.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp + 59), 42.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 42.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (DataCanbus.DATA[1000] == 196659 || DataCanbus.DATA[1000] == 262195) {
            if (temp2 == 0) {
                c.drawText("NONE", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 <= 15 && temp2 >= 1) {
                c.drawText("LOW", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 <= 63 && temp2 >= 49) {
                c.drawText("HIGH", 920.0f, 137.0f, this.mPaint);
            } else if (temp2 >= 16 && temp2 <= 48) {
                c.drawText(((((temp2 - 16) * 5) + 160) / 10.0f) + " ℃", 920.0f, 137.0f, this.mPaint);
            }
        } else if (temp2 == 0) {
            c.drawText("LOW", 920.0f, 137.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 920.0f, 137.0f, this.mPaint);
        } else if (this.DATA[103] == 1) {
            c.drawText(String.valueOf(temp2 + 59), 920.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 920.0f, 137.0f, this.mPaint);
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
