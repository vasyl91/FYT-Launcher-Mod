package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_XC_Ruijie extends AirBase {
    public Air_0439_XC_Ruijie(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0293_wc3_15ruijie/rzc_15ruijie.webp";
        this.mPathHighlight = "0293_wc3_15ruijie/rzc_15ruijie_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(154.0f, 28.0f, 283.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(446.0f, 116.0f, 578.0f, 184.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(304.0f, 127.0f, 430.0f, 174.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(892.0f, 27.0f, 1009.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 1) {
            c.clipRect(299.0f, 19.0f, 434.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(603.0f, 16.0f, 712.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(608.0f, 110.0f, 711.0f, 192.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 1) {
            c.clipRect(18.0f, 113.0f, 132.0f, 188.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(911.0f, 103.0f, 965.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(923.0f, 137.0f, 959.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(915.0f, 149.0f, 947.0f, 173.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 1) {
            c.clipRect(100.0f, 54.0f, 143.0f, 98.0f, Region.Op.UNION);
            c.clipRect(830.0f, 54.0f, 874.0f, 101.0f, Region.Op.UNION);
            c.clipRect(968.0f, 238.0f, 1020.0f, 290.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(451.0f, 36.0f, (value * 18) + 451, 98.0f, Region.Op.UNION);
        int value2 = this.DATA[24];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 -= 3;
        }
        c.clipRect(205.0f, 155.0f, (value2 * 26) + 205, 178.0f, Region.Op.UNION);
        int value3 = this.DATA[25];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 -= 3;
        }
        c.clipRect(749.0f, 155.0f, (value3 * 26) + 749, 178.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[22];
        if (temp == 1048576) {
            c.drawText("LOW", 51.0f, 78.0f, this.mPaint);
        } else if (temp == 1048577) {
            c.drawText("HI", 51.0f, 78.0f, this.mPaint);
        } else if (temp == 1048578) {
            c.drawText("NO", 51.0f, 78.0f, this.mPaint);
        } else if (this.DATA[28] == 1) {
            c.drawText(String.valueOf(temp / 2), 51.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp * 0.1f), 51.0f, 78.0f, this.mPaint);
        }
        int temp2 = this.DATA[23];
        if (temp2 == 1048576) {
            c.drawText("LOW", 780.0f, 78.0f, this.mPaint);
        } else if (temp2 == 1048577) {
            c.drawText("HI", 780.0f, 78.0f, this.mPaint);
        } else if (temp2 == 1048578) {
            c.drawText("NO", 780.0f, 78.0f, this.mPaint);
        } else if (this.DATA[28] == 1) {
            c.drawText(String.valueOf(temp2 / 2), 780.0f, 78.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 * 0.1f), 780.0f, 78.0f, this.mPaint);
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
