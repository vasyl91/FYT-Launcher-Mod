package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0448_LZ_BMW extends AirBase {
    public Air_0448_LZ_BMW(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0448_lz_bmw/air_lz_bmw_carui_n.webp";
        this.mPathHighlight = "0448_lz_bmw/air_lz_bmw_carui_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[26] != 0) {
            c.clipRect(266.0f, 31.0f, 381.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(136.0f, 21.0f, 217.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(164.0f, 131.0f, 227.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(162.0f, 80.0f, 215.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(153.0f, 101.0f, 190.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(783.0f, 21.0f, 852.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(807.0f, 133.0f, 863.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(807.0f, 84.0f, 847.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(795.0f, 104.0f, 826.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(419.0f, 111.0f, 487.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(653.0f, 105.0f, 755.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(272.0f, 103.0f, 361.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(544.0f, 13.0f, 621.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(413.0f, 15.0f, 487.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 0) {
            c.clipRect(646.0f, 15.0f, 766.0f, 79.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value1 = this.DATA[44];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 6) {
            value1 = 6;
        }
        c.drawText(String.valueOf(value1), 86.0f, 62.0f, this.mPaint);
        int value2 = this.DATA[45];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 6) {
            value2 = 6;
        }
        c.drawText(String.valueOf(value2), 931.0f, 62.0f, this.mPaint);
        int value = this.DATA[42];
        c.drawText(String.valueOf(value), 580.0f, 144.0f, this.mPaint);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((left_temp * 5) + 150) / 10.0f), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[41];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((right_temp * 5) + 150) / 10.0f), 930.0f, 152.0f, this.mPaint);
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
