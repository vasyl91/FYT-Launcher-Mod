package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0442_CHEKU_ATS extends AirBase {
    public Air_0442_CHEKU_ATS(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0442_cheku_ats/air_0442_ats.webp";
        this.mPathHighlight = "0442_cheku_ats/air_0442_ats_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(203.0f, 13.0f, 316.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(208.0f, 88.0f, 313.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(710.0f, 71.0f, 842.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 2) {
            c.clipRect(722.0f, 29.0f, 819.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(579.0f, 20.0f, 645.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(587.0f, 84.0f, 637.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(574.0f, 107.0f, 613.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(393.0f, 57.0f, (value * 19) + 393, 120.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(50.0f);
        int temp = this.DATA[9];
        if (temp == -1) {
            c.drawText("NO", 75.0f, 83.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 75.0f, 83.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 75.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp * 1.0f), 75.0f, 83.0f, this.mPaint);
        }
        int temp1 = this.DATA[10];
        if (temp1 == -1) {
            c.drawText("NO", 927.0f, 83.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 927.0f, 83.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 927.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp1 * 1.0f), 927.0f, 83.0f, this.mPaint);
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
