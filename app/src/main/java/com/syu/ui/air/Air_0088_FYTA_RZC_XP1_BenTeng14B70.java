package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0088_FYTA_RZC_XP1_BenTeng14B70 extends AirBase {
    public Air_0088_FYTA_RZC_XP1_BenTeng14B70(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0088_rzc_xp1_benteng14b70/air_rzc_xp1_benteng14b70.webp";
        this.mPathHighlight = "0088_rzc_xp1_benteng14b70/air_rzc_xp1_benteng14b70_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(148.0f, 98.0f, 283.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(459.0f, 18.0f, 562.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(609.0f, 13.0f, 708.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(614.0f, 90.0f, 708.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(167.0f, 18.0f, 261.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(301.0f, 35.0f, 357.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(332.0f, 75.0f, 385.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(301.0f, 97.0f, 349.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(21.0f, 11.0f, 121.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(912.0f, 24.0f, 992.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(743.0f, 18.0f, 860.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(755.0f, 103.0f, 851.0f, 147.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(459.0f, 119.0f, (value * 15) + 459, 162.0f, Region.Op.UNION);
        if (this.DATA[12] != 0) {
            c.clipRect(21.0f, 11.0f, 121.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(912.0f, 24.0f, 992.0f, 80.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 53.0f, 150.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 53.0f, 150.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 53.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 53.0f, 150.0f, this.mPaint);
        }
        int temp2 = this.DATA[7];
        if (temp2 == -1) {
            c.drawText("NO", 927.0f, 138.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 927.0f, 138.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 927.0f, 138.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 927.0f, 138.0f, this.mPaint);
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
