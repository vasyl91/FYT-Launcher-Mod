package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0419_WC2_HuanSu extends AirBase {
    public Air_0419_WC2_HuanSu(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_huansu_hs6.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_huansu_hs6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(738.0f, 16.0f, 872.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(337.0f, 7.0f, 385.0f, 44.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(191.0f, 97.0f, 279.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(765.0f, 95.0f, 853.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(320.0f, 89.0f, 417.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(339.0f, 42.0f, 371.0f, 60.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(328.0f, 60.0f, 366.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(444.0f, 21.0f, 580.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(163.0f, 25.0f, 288.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(475.0f, 90.0f, 559.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(602.0f, 18.0f, 719.0f, 80.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 7) {
            value = 7;
        }
        c.clipRect(606.0f, 103.0f, (value * 16) + 606, 163.0f, Region.Op.UNION);
        int value1 = this.DATA[28];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 2) {
            value1 = 2;
        }
        c.clipRect(68.0f, 117.0f, (value1 * 18) + 68, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(921.0f, 130.0f, (value2 * 18) + 921, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 60.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 60.0f, this.mPaint);
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
