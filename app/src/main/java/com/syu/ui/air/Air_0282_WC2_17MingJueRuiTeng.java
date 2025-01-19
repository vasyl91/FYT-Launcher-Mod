package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0282_WC2_17MingJueRuiTeng extends AirBase {
    public Air_0282_WC2_17MingJueRuiTeng(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0282_wc2_mingjueruiteng/air_wc_17ruiteng_n.webp";
        this.mPathHighlight = "0282_wc2_mingjueruiteng/air_wc_17ruiteng_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(868.0f, 11.0f, 1012.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(49.0f, 18.0f, 158.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(358.0f, 99.0f, 489.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(195.0f, 16.0f, 319.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(214.0f, 92.0f, 313.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(374.0f, 8.0f, 424.0f, 39.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(375.0f, 41.0f, 414.0f, 57.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(370.0f, 59.0f, 398.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(439.0f, 58.0f, 495.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(509.0f, 9.0f, 655.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(512.0f, 91.0f, (value * 18) + ConstRzcAddData.U_CAR_TOTAL_MILEAGE, 168.0f, Region.Op.UNION);
        if (this.DATA[99] != 0) {
            c.clipRect(692.0f, 14.0f, 810.0f, 66.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[16];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10.0f), 76.0f, 142.0f, this.mPaint);
        }
        int left_temp_real = this.DATA[100];
        if (left_temp_real == -2) {
            c.drawText("LOW", 935.0f, 142.0f, this.mPaint);
        } else if (left_temp_real == -3) {
            c.drawText("HI", 935.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp_real / 10.0f), 935.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[22];
        if (right_temp == -2 || right_temp == -3) {
            c.drawText("--.-", 750.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10.0f), 750.0f, 142.0f, this.mPaint);
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
