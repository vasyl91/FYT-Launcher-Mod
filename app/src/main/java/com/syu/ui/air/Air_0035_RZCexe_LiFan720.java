package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0035_RZCexe_LiFan720 extends AirBase {
    public Air_0035_RZCexe_LiFan720(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0035_rzcexe_lifan720/air_rzcexc_lifan720_n.webp";
        this.mPathHighlight = "0035_rzcexe_lifan720/air_rzcexc_lifan720_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[9] != 0) {
            c.clipRect(216.0f, 13.0f, 364.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(538.0f, 31.0f, 635.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(409.0f, 140.0f, 472.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(697.0f, 9.0f, 788.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(232.0f, 101.0f, 320.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(396.0f, 65.0f, 439.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(419.0f, 88.0f, 465.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(393.0f, 103.0f, 431.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(395.0f, 12.0f, 466.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(535.0f, 13.0f, 576.0f, 31.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(514.0f, 127.0f, (value * 35) + ConstRzcAddData.U_CAR_SEAT_BELT_LEFT, 155.0f, Region.Op.UNION);
        int value2 = this.DATA[16];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(98.0f, 135.0f, (value2 * 21) + 98, 161.0f, Region.Op.UNION);
        int value3 = this.DATA[17];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(923.0f, 140.0f, (value3 * 21) + 923, 159.0f, Region.Op.UNION);
        int tempValue = this.DATA[10];
        if (tempValue < 0) {
            tempValue = 0;
        } else if (tempValue > 9) {
            tempValue = 9;
        }
        c.clipRect(15.0f, 13.0f, (tempValue * 20) + 15, 84.0f, Region.Op.UNION);
        int tempValue2 = this.DATA[6];
        if (tempValue2 < 0) {
            tempValue2 = 0;
        } else if (tempValue2 > 9) {
            tempValue2 = 9;
        }
        c.clipRect(831.0f, 14.0f, (tempValue2 * 20) + 831, 84.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
