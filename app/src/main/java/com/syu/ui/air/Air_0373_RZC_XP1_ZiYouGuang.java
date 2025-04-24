package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0373_RZC_XP1_ZiYouGuang extends AirBase {
    public Air_0373_RZC_XP1_ZiYouGuang(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0373_rzc_ziyouguang/rzc_ziyouguang.webp";
        this.mPathHighlight = "0373_rzc_ziyouguang/rzc_ziyouguang_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[56] != 0) {
            c.clipRect(164.0f, 24.0f, 283.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(167.0f, 103.0f, 272.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(317.0f, 104.0f, 404.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[51] != 0) {
            c.clipRect(304.0f, 15.0f, 415.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(458.0f, 17.0f, 568.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(469.0f, 95.0f, 563.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[59] != 0) {
            c.clipRect(615.0f, 17.0f, 717.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[58] != 0) {
            c.clipRect(779.0f, 147.0f, 834.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[50] != 0) {
            c.clipRect(772.0f, 89.0f, 810.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(779.0f, 108.0f, 815.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(762.0f, 122.0f, 801.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[43] == 0) {
            c.clipRect(748.0f, 14.0f, 868.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[57] != 0) {
            c.clipRect(95.0f, 109.0f, 142.0f, 163.0f, Region.Op.UNION);
            c.clipRect(969.0f, 111.0f, 1014.0f, 161.0f, Region.Op.UNION);
        }
        int value = this.DATA[52];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(625.0f, 108.0f, (value * 13) + 625, 162.0f, Region.Op.UNION);
        int value2 = this.DATA[53];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(80.0f, 33.0f, (value2 * 20) + 80, 73.0f, Region.Op.UNION);
        int value3 = this.DATA[54];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(915.0f, 46.0f, (value3 * 20) + 915, 80.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[47];
        if (temp == -2) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else if ((temp >= 13 && temp <= 30) || (temp >= 60 && temp <= 84)) {
            c.drawText(String.valueOf(temp), 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 65.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[55];
        if (temp2 == -2) {
            c.drawText("LOW", 935.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 140.0f, this.mPaint);
        } else if ((temp2 >= 13 && temp2 <= 30) || (temp2 >= 60 && temp2 <= 84)) {
            c.drawText(String.valueOf(temp2), 935.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 935.0f, 140.0f, this.mPaint);
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
