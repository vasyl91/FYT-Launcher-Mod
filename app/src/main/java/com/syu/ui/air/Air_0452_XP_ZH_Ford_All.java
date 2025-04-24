package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_XP_ZH_Ford_All extends AirBase {
    public Air_0452_XP_ZH_Ford_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0293_wc3_15ruijie/rzc_15ruijie.webp";
        this.mPathHighlight = "0293_wc3_15ruijie/rzc_15ruijie_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(154.0f, 28.0f, 283.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(446.0f, 116.0f, 578.0f, 184.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(304.0f, 127.0f, 430.0f, 174.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(892.0f, 27.0f, 1009.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 1) {
            c.clipRect(299.0f, 19.0f, 434.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(603.0f, 16.0f, 712.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(608.0f, 110.0f, 711.0f, 192.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 1) {
            c.clipRect(18.0f, 113.0f, 132.0f, 188.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(911.0f, 103.0f, 965.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(923.0f, 137.0f, 959.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(915.0f, 149.0f, 947.0f, 173.0f, Region.Op.UNION);
        }
        if (this.DATA[37] == 1) {
            c.clipRect(100.0f, 54.0f, 143.0f, 98.0f, Region.Op.UNION);
            c.clipRect(830.0f, 54.0f, 874.0f, 101.0f, Region.Op.UNION);
            c.clipRect(968.0f, 238.0f, 1020.0f, 290.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(451.0f, 36.0f, (value * 18) + 451, 98.0f, Region.Op.UNION);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 -= 3;
        }
        c.clipRect(205.0f, 155.0f, (value2 * 24) + 205, 178.0f, Region.Op.UNION);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 -= 3;
        }
        c.clipRect(749.0f, 155.0f, (value3 * 24) + 749, 178.0f, Region.Op.UNION);
        if (this.DATA[42] != 0) {
            c.clipRect(224.0f, 221.0f, 381.0f, 270.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(435.0f, 223.0f, 599.0f, 271.0f, Region.Op.UNION);
        }
        int value4 = this.DATA[44];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 7) {
            value4 = 7;
        }
        c.clipRect(661.0f, 229.0f, (value4 * 21) + 661, 293.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int type = this.DATA[75];
        if (type == 1) {
            int temp = this.DATA[27];
            if (temp == -2) {
                c.drawText("LOW", 51.0f, 78.0f, this.mPaint);
            } else if (temp == -3) {
                c.drawText("HI", 51.0f, 78.0f, this.mPaint);
            } else if (temp == -1) {
                c.drawText("NO", 51.0f, 78.0f, this.mPaint);
            } else if (this.DATA[37] == 1) {
                c.drawText(String.valueOf(temp / 2), 51.0f, 78.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(temp * 0.5f), 51.0f, 78.0f, this.mPaint);
            }
            int temp2 = this.DATA[28];
            if (temp2 == -2) {
                c.drawText("LOW", 780.0f, 78.0f, this.mPaint);
            } else if (temp2 == -3) {
                c.drawText("HI", 780.0f, 78.0f, this.mPaint);
            } else if (temp2 == -1) {
                c.drawText("NO", 780.0f, 78.0f, this.mPaint);
            } else if (this.DATA[37] == 1) {
                c.drawText(String.valueOf(temp2 / 2), 780.0f, 78.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(temp2 * 0.5f), 780.0f, 78.0f, this.mPaint);
            }
        } else {
            int temp3 = this.DATA[27];
            if (temp3 == 0) {
                c.drawText("LOW", 51.0f, 78.0f, this.mPaint);
            } else if (temp3 == 30) {
                c.drawText("HI", 51.0f, 78.0f, this.mPaint);
            } else if (temp3 > 0 && temp3 < 30) {
                c.drawText(String.valueOf(((temp3 * 5) + 160) * 0.1f), 51.0f, 78.0f, this.mPaint);
            } else {
                c.drawText("NO", 51.0f, 78.0f, this.mPaint);
            }
            int temp4 = this.DATA[28];
            if (temp4 == 0) {
                c.drawText("LOW", 780.0f, 78.0f, this.mPaint);
            } else if (temp4 == 30) {
                c.drawText("HI", 780.0f, 78.0f, this.mPaint);
            } else if (temp4 > 0 && temp4 < 30) {
                c.drawText(String.valueOf(((temp4 * 5) + 160) * 0.1f), 780.0f, 78.0f, this.mPaint);
            } else {
                c.drawText("NO", 780.0f, 78.0f, this.mPaint);
            }
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == 0) {
            c.drawText("LOW", 895.0f, 257.0f, this.mPaint);
        } else if (rear_temp == 9) {
            c.drawText("HI", 895.0f, 257.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(rear_temp), 895.0f, 257.0f, this.mPaint);
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
