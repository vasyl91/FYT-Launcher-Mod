package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0419_WC2_Jili_YuanJing extends AirBase {
    public Air_0419_WC2_Jili_YuanJing(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_jili_yuanjing.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_jili_yuanjing_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(888.0f, 62.0f, 1016.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(162.0f, 66.0f, 283.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(462.0f, 23.0f, 536.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(45.0f, 30.0f, 112.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(752.0f, 43.0f, 859.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(467.0f, 89.0f, 532.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(455.0f, 111.0f, 502.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(300.0f, 44.0f, 434.0f, 123.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 6) {
            value = 6;
        }
        c.clipRect(610.0f, 69.0f, 610.0f + (value * 17.5f), 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[21];
        if (left_temp == -2) {
            c.drawText("LOW", 60.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 60.0f, 142.0f, this.mPaint);
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
