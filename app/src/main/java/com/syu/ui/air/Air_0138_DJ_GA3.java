package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0138_DJ_GA3 extends AirBase {
    public Air_0138_DJ_GA3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0138_dj_ga3/air_dj_ga3_n.webp";
        this.mPathHighlight = "0138_dj_ga3/air_dj_ga3_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(10.0f, 29.0f, 137.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(892.0f, 26.0f, 1011.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(160.0f, 42.0f, 287.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(459.0f, 15.0f, 533.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(482.0f, 79.0f, 538.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(452.0f, 100.0f, 501.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(298.0f, 55.0f, 434.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(742.0f, 43.0f, 866.0f, 144.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        c.clipRect(597.0f, 71.0f, (value * 18) + 597, 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == 0) {
            c.drawText("NO", 71.0f, 142.0f, this.mPaint);
        } else if (temp >= 1 && temp <= 9) {
            c.drawText(temp + "LEV", 71.0f, 142.0f, this.mPaint);
        } else if (temp >= 10 && temp <= 40) {
            c.drawText(temp + "℃", 71.0f, 142.0f, this.mPaint);
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
