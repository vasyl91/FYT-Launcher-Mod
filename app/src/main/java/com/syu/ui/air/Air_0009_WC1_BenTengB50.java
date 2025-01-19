package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0009_WC1_BenTengB50 extends AirBase {
    public Air_0009_WC1_BenTengB50(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0009_wc1_bentengb50/air_wc1_bentengb50_n.webp";
        this.mPathHighlight = "0009_wc1_bentengb50/air_wc1_bentengb50_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(885.0f, 26.0f, 1018.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(160.0f, 42.0f, 287.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(742.0f, 43.0f, 866.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[0] == 0) {
            c.clipRect(298.0f, 40.0f, 434.0f, 103.0f, Region.Op.UNION);
        }
        if (this.DATA[0] == 2) {
            c.clipRect(298.0f, 105.0f, 434.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(10.0f, 29.0f, 137.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(892.0f, 96.0f, 1011.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(459.0f, 15.0f, 533.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(482.0f, 79.0f, 538.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(452.0f, 100.0f, 501.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(597.0f, 71.0f, (value * 18) + 597, 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        byte temp = (byte) this.DATA[10];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 122.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 122.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 122.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp & 128) == 0 ? 0.0f : 0.5f) + (temp & Byte.MAX_VALUE)), 56.0f, 122.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenWidth() / this.mContentWidth);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
