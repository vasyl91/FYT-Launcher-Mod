package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0227_RZC_EC180 extends AirBase {
    public Air_0227_RZC_EC180(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0226_fyta_changanyuexiang7/air_rzc_ec180_n.webp";
        this.mPathHighlight = "0226_fyta_changanyuexiang7/air_rzc_ec180_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(868.0f, 58.0f, 1018.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(53.0f, 19.0f, 131.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(358.0f, 35.0f, 496.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(196.0f, 23.0f, 304.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(545.0f, 18.0f, 624.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(555.0f, 83.0f, 627.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(550.0f, 112.0f, 594.0f, 150.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(713.0f, 63.0f, 713.0f + (value * 16.0f), 146.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 86.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 86.0f, 142.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NONE", 86.0f, 142.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 196835 || DataCanbus.DATA[1000] == 1376483 || DataCanbus.DATA[1000] == 786659) {
            c.drawText(left_temp + 17 + " ℃", 86.0f, 142.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 458979) {
            if (left_temp >= 1 && left_temp <= 4) {
                c.drawText("冷风 " + (5 - left_temp), 86.0f, 142.0f, this.mPaint);
            } else if (left_temp == 5) {
                c.drawText("自然风", 86.0f, 142.0f, this.mPaint);
            } else if (left_temp > 5) {
                c.drawText("热风 " + (left_temp - 5), 86.0f, 142.0f, this.mPaint);
            }
        }
        int airlev = this.DATA[64];
        c.drawText(String.valueOf(airlev), 293.0f, 141.0f, this.mPaint);
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
