package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0106_RZC4_BydS6 extends AirBase {
    public Air_0106_RZC4_BydS6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0106_rzc4_byds6/air_rzc1_byds6_n.webp";
        this.mPathHighlight = "0106_rzc4_byds6/air_rzc1_byds6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(745.0f, 22.0f, 861.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(894.0f, 16.0f, 1006.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(457.0f, 91.0f, 573.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(468.0f, 14.0f, 572.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(178.0f, 24.0f, 265.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(304.0f, 97.0f, 347.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(299.0f, 45.0f, 364.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(768.0f, 91.0f, 846.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(162.0f, 100.0f, 272.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(12.0f, 27.0f, 146.0f, 73.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(605.0f, 80.0f, (value * 17) + 605, 136.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("", 55.0f, 152.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("L", 55.0f, 152.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("H", 55.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 55.0f, 152.0f, this.mPaint);
        }
        int temp2 = this.DATA[13];
        if (temp2 == -1) {
            c.drawText("", 937.0f, 152.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("L", 937.0f, 152.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("H", 937.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 937.0f, 152.0f, this.mPaint);
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
