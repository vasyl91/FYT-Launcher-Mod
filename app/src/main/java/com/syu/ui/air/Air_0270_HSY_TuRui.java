package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0270_HSY_TuRui extends AirBase {
    public Air_0270_HSY_TuRui(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0270_wc_turui/hsy_turui.webp";
        this.mPathHighlight = "0270_wc_turui/hsy_turui_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        switch (this.DATA[89]) {
            case 1:
                c.clipRect(202.0f, 105.0f, 243.0f, 129.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(199.0f, 106.0f, 267.0f, 130.0f, Region.Op.UNION);
                break;
            default:
                c.clipRect(201.0f, 108.0f, 223.0f, 128.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[87] != 0) {
            c.clipRect(701.0f, 27.0f, 845.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[120] != 0) {
            c.clipRect(337.0f, 14.0f, 423.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(347.0f, 85.0f, 407.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(339.0f, 110.0f, 384.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[149] != 0) {
            c.clipRect(483.0f, 33.0f, 657.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[234] != 0) {
            c.clipRect(38.0f, 92.0f, 114.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[235] != 0) {
            c.clipRect(897.0f, 101.0f, 983.0f, 152.0f, Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(703.0f, 103.0f, (value * 20) + 703, 166.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 >= 0 && value2 > 3) {
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98] & 255;
        int uint = this.DATA[179] & 255;
        if (temp == 254) {
            c.drawText("LOW", 64.0f, 45.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 64.0f, 45.0f, this.mPaint);
        } else if (uint == 1) {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d    ℃", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 64.0f, 45.0f, this.mPaint);
        } else {
            String tempStr = temp - 60 + "  ℉";
            c.drawText(tempStr, 64.0f, 45.0f, this.mPaint);
        }
        int temp3 = this.DATA[99] & 255;
        if (temp3 == 254) {
            c.drawText("LOW", 927.0f, 45.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 927.0f, 45.0f, this.mPaint);
        } else if (uint == 1) {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d    ℃", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 927.0f, 45.0f, this.mPaint);
        } else {
            String tempStr2 = temp3 - 60 + "  ℉";
            c.drawText(tempStr2, 927.0f, 45.0f, this.mPaint);
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
