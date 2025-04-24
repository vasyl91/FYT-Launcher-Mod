package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0282_WC2_MingJueRuiTeng extends AirBase {
    public Air_0282_WC2_MingJueRuiTeng(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0282_wc2_mingjueruiteng/air_wc_ruiteng_n.webp";
        this.mPathHighlight = "0282_wc2_mingjueruiteng/air_wc_ruiteng_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(870.0f, 21.0f, 995.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(37.0f, 19.0f, 142.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(510.0f, 103.0f, 663.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(196.0f, 16.0f, 308.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(204.0f, 93.0f, 305.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(379.0f, 11.0f, 457.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(389.0f, 76.0f, 452.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(376.0f, 101.0f, 418.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(397.0f, 139.0f, 457.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(517.0f, 12.0f, 660.0f, 82.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(708.0f, 73.0f, (value * 18) + 708, 131.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[16];
        if (DataCanbus.sCanbusId == 65818) {
            if (left_temp == 1) {
                c.drawText("LOW", 76.0f, 142.0f, this.mPaint);
            } else if (left_temp == 15) {
                c.drawText("HI", 76.0f, 142.0f, this.mPaint);
            } else if (left_temp <= 8) {
                c.drawText("Cold " + (9 - left_temp), 76.0f, 142.0f, this.mPaint);
            } else if (left_temp >= 9) {
                c.drawText("Hot " + (left_temp - 8), 76.0f, 142.0f, this.mPaint);
            }
        } else if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 142.0f, this.mPaint);
        } else {
            c.drawText((left_temp / 10.0f) + "℃", 76.0f, 142.0f, this.mPaint);
        }
        if (DataCanbus.sCanbusId != 65818) {
            int right_temp = this.DATA[22];
            if (right_temp == -1) {
                c.drawText("--.-", 930.0f, 152.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(right_temp / 10.0f), 930.0f, 152.0f, this.mPaint);
            }
        } else {
            c.drawText("--.-", 930.0f, 152.0f, this.mPaint);
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
