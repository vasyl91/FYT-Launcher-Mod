package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0443_WC2_18FENGGUANG_S560 extends AirBase {
    public Air_0443_WC2_18FENGGUANG_S560(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_Jili_GC7/air_0443_Jili_GC7.webp";
        this.mPathHighlight = "0443_wc2_Jili_GC7/air_0443_Jili_GC7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(26.0f, 104.0f, 164.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(201.0f, 92.0f, 293.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(197.0f, 15.0f, 299.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(868.0f, 38.0f, 1004.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(559.0f, 19.0f, 639.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(574.0f, 86.0f, 625.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(560.0f, 106.0f, 602.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(702.0f, 9.0f, 842.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(737.0f, 104.0f, 814.0f, 154.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[7];
        if (temp == -2) {
            c.drawText("LOW", 73.0f, 54.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NO", 73.0f, 54.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 73.0f, 54.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) - 400;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 73.0f, 54.0f, this.mPaint);
        }
        this.mPaint.setTextSize(40.0f);
        int value = this.DATA[11];
        c.drawText(value + " ", 463.0f, 100.0f, this.mPaint);
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
