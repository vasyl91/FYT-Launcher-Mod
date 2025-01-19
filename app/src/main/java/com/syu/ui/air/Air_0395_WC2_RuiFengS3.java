package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.FinalCanbus;

public class Air_0395_WC2_RuiFengS3 extends AirBase {
    public Air_0395_WC2_RuiFengS3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = FinalCanbus.U_CAR_BT_ON;
        this.mContentHeight = 171;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_ruifeng_s3.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_ruifeng_s3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(306.0f, 28.0f, 425.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(166.0f, 19.0f, 245.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(185.0f, 129.0f, 248.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(188.0f, 84.0f, 250.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(178.0f, 101.0f, 211.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(479.0f, 96.0f, 543.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(743.0f, 105.0f, 847.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(319.0f, 110.0f, 416.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(619.0f, 16.0f, 709.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(472.0f, 13.0f, 556.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(749.0f, 14.0f, 865.0f, 78.0f, Region.Op.UNION);
        }
        int value = this.DATA[39];
        c.clipRect(613.0f, 103.0f, (value * 14) + 613, 163.0f, Region.Op.UNION);
        int value1 = this.DATA[31];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 3) {
            value1 = 3;
        }
        c.clipRect(68.0f, 49.0f, (value1 * 20) + 68, 70.0f, Region.Op.UNION);
        int value2 = this.DATA[32];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(896.0f, 50.0f, (value2 * 20) + 896, 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 60.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 60.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[68];
        if (right_temp == -2) {
            c.drawText("LOW", 920.0f, 142.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 920.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 920.0f, 142.0f, this.mPaint);
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
