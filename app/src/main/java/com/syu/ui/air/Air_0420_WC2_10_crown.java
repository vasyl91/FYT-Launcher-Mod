package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0420_WC2_10_crown extends AirBase {
    public Air_0420_WC2_10_crown(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0420_wc2_10_crown/air_wc2_crown.webp";
        this.mPathHighlight = "0420_wc2_10_crown/air_wc2_crown_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(917.0f, 19.0f, 1007.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(159.0f, 101.0f, 229.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(789.0f, 13.0f, 876.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(789.0f, 97.0f, 876.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(519.0f, 14.0f, 598.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(531.0f, 85.0f, 599.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(526.0f, 105.0f, 575.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(266.0f, 7.0f, 379.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(653.0f, 14.0f, 752.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(407.0f, 9.0f, 491.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(400.0f, 96.0f, 508.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(665.0f, 90.0f, 755.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(13.0f, 25.0f, 115.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(141.0f, 18.0f, 249.0f, 74.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value >= 0 && value <= 7) {
            c.clipRect(272.0f, 106.0f, (value * 15) + 272, 160.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("----", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -2) {
            c.drawText("LOW", 935.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 140.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("----", 935.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 935.0f, 140.0f, this.mPaint);
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
