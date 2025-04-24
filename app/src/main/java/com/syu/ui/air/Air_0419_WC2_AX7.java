package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0419_WC2_AX7 extends AirBase {
    public Air_0419_WC2_AX7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_fengshenax7.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_fengshenax7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(6.0f, 24.0f, 148.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(334.0f, 13.0f, 423.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(911.0f, 95.0f, 995.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(892.0f, 11.0f, 988.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(174.0f, 37.0f, 296.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(340.0f, 85.0f, 419.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(338.0f, 112.0f, 385.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(692.0f, 41.0f, 846.0f, 143.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 8) {
            value = 8;
        }
        c.clipRect(499.0f, 56.0f, (value * 19) + 499, 133.0f, Region.Op.UNION);
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
