package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0110_WC2_Camry extends AirBase {
    public Air_0110_WC2_Camry(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0110_wc2_camary/air_wc2_rav4_2013.webp";
        this.mPathHighlight = "0110_wc2_camary/air_wc2_rav4_2013_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[41] != 0) {
            c.clipRect(532.0f, 28.0f, 644.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(704.0f, 21.0f, 793.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(718.0f, 100.0f, 795.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(395.0f, 26.0f, 465.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(217.0f, 41.0f, 240.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(242.0f, 66.0f, 276.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(217.0f, 84.0f, 243.0f, 111.0f, Region.Op.UNION);
        }
        int value = this.DATA[48];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(383.0f, 132.0f, (value * 35) + 383, 150.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[49];
        if (temp == -2) {
            c.drawText("LOW", 62.0f, 110.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 110.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 62.0f, 110.0f, this.mPaint);
        }
        int temp2 = this.DATA[50];
        if (temp2 == -2) {
            c.drawText("LOW", 900.0f, 110.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 900.0f, 110.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 900.0f, 110.0f, this.mPaint);
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
