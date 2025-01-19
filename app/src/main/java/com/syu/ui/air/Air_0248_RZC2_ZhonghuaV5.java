package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0248_RZC2_ZhonghuaV5 extends AirBase {
    public Air_0248_RZC2_ZhonghuaV5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0248_rzc2_zhonghuav5/air_rzc_dongnanv5_n.webp";
        this.mPathHighlight = "0248_rzc2_zhonghuav5/air_rzc_dongnanv5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(892.0f, 102.0f, 1012.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(19.0f, 17.0f, 137.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(543.0f, 13.0f, 650.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(894.0f, 19.0f, 991.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(392.0f, 62.0f, 452.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(375.0f, 93.0f, 420.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 1) {
            c.clipRect(187.0f, 44.0f, 330.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(729.0f, 13.0f, 828.0f, 84.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        c.clipRect(515.0f, 90.0f, (value * 22) + ConstRzcAddData.U_CAR_SEAT_BELT_RIGHT, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        int point = this.DATA[11];
        if (temp == 0) {
            c.drawText("LOW", 70.0f, 143.0f, this.mPaint);
        } else if (temp == 254) {
            c.drawText("NONE", 70.0f, 143.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText(temp + "HIGH", 70.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp + (point / 10.0f)), 70.0f, 143.0f, this.mPaint);
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
