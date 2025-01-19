package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0452_OD_Weima_E5 extends AirBase {
    public Air_0452_OD_Weima_E5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0118_xp1_biaozhi2008/air_xp1_408_14_n.webp";
        this.mPathHighlight = "0118_xp1_biaozhi2008/air_xp1_408_14_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(5.0f, 16.0f, 132.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(750.0f, 19.0f, 862.0f, 75.0f, Region.Op.UNION);
            c.clipRect(322.0f, 122.0f, 407.0f, 148.0f, Region.Op.UNION);
            c.clipRect(446.0f, 92.0f, 503.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(747.0f, 98.0f, 859.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(610.0f, 98.0f, 721.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(174.0f, 19.0f, 266.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(153.0f, 100.0f, 281.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(607.0f, 15.0f, 714.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(891.0f, 19.0f, 1012.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(306.0f, 20.0f, 358.0f, 54.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(334.0f, 48.0f, 386.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(303.0f, 72.0f, 350.0f, 113.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(451.0f, 116.0f, (value * 16) + 451, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp3 = this.DATA[27];
        if (temp3 == -1) {
            c.drawText("NO", 56.0f, 132.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 56.0f, 132.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 56.0f, 132.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 15663556) {
                temp = (temp3 * 5) + 160;
            } else {
                temp = (temp3 * 5) + 175;
            }
            c.drawText(String.valueOf(temp / 10.0f), 56.0f, 132.0f, this.mPaint);
        }
        int temp4 = this.DATA[28];
        if (temp4 == -1) {
            c.drawText("NO", 930.0f, 132.0f, this.mPaint);
        } else if (temp4 == -2) {
            c.drawText("LOW", 930.0f, 132.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 930.0f, 132.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 15663556) {
                temp2 = (temp4 * 5) + 160;
            } else {
                temp2 = (temp4 * 5) + 175;
            }
            c.drawText(String.valueOf(temp2 / 10.0f), 930.0f, 132.0f, this.mPaint);
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
