package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0321_WC2_17_guandao extends AirBase {
    public Air_0321_WC2_17_guandao(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0321_wc2_16civic/wc_17_guandao_n.webp";
        this.mPathHighlight = "0321_wc2_16civic/wc_17_guandao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[38] != 0) {
            c.clipRect(7.0f, 36.0f, 126.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[27] == 0) {
            c.clipRect(267.0f, 14.0f, 377.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(399.0f, 25.0f, 504.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(786.0f, 14.0f, 876.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(465.0f, 90.0f, 560.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(539.0f, 21.0f, 611.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(646.0f, 20.0f, 765.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(184.0f, 90.0f, 230.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(187.0f, 121.0f, 233.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(180.0f, 137.0f, 216.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[82] != 0) {
            c.clipRect(767.0f, 86.0f, 820.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[80] != 0) {
            c.clipRect(771.0f, 123.0f, 819.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[81] != 0) {
            c.clipRect(765.0f, 137.0f, 798.0f, 166.0f, Region.Op.UNION);
        }
        int value = this.DATA[35];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(316.0f, 107.0f, (value * 17) + 316, 160.0f, Region.Op.UNION);
        int value2 = this.DATA[84];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 5) {
            value2 = 5;
        }
        c.clipRect(628.0f, 115.0f, (value2 * 17) + 628, 156.0f, Region.Op.UNION);
        int value3 = this.DATA[78];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(187.0f, 47.0f, (value3 * 22) + 187, 71.0f, Region.Op.UNION);
        int value4 = this.DATA[79];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(907.0f, 47.0f, (value4 * 22) + 907, 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[31];
        if (temp == -1) {
            c.drawText("NO", 46.0f, 152.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 46.0f, 152.0f, this.mPaint);
        }
        int temp2 = this.DATA[37];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 152.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 930.0f, 152.0f, this.mPaint);
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
