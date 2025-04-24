package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0300_DJ_MengdiOu extends AirBase {
    public Air_0300_DJ_MengdiOu(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0300_dj_mengdiou/air_dj_0300_mengdiou_n.webp";
        this.mPathHighlight = "0300_dj_mengdiou/air_dj_0300_mengdiou_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(738.0f, 60.0f, 881.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(180.0f, 29.0f, 253.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[50] != 0) {
            c.clipRect(911.0f, 99.0f, 1005.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(161.0f, 102.0f, 285.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(10.0f, 99.0f, 136.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[18] == 0) {
            c.clipRect(297.0f, 56.0f, 435.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[16] == 1) {
            c.clipRect(180.0f, 29.0f, 253.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(465.0f, 43.0f, 518.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(474.0f, 75.0f, 533.0f, 93.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(463.0f, 92.0f, 507.0f, 128.0f, Region.Op.UNION);
        }
        int value = this.DATA[23];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(611.0f, 79.0f, (value * 16) + 611, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[24];
        if (temp == 0) {
            c.drawText("LOW", 50.0f, 70.0f, this.mPaint);
        } else if (temp == 127) {
            c.drawText("HI", 50.0f, 70.0f, this.mPaint);
        } else if (temp >= 31 && temp <= 59) {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 50.0f, 70.0f, this.mPaint);
        }
        int temp3 = this.DATA[25];
        if (temp3 == 0) {
            c.drawText("LOW", 930.0f, 70.0f, this.mPaint);
        } else if (temp3 == 127) {
            c.drawText("HI", 930.0f, 70.0f, this.mPaint);
        } else if (temp3 >= 31 && temp3 <= 59) {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 930.0f, 70.0f, this.mPaint);
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
