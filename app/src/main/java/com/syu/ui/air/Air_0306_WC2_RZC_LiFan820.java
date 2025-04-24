package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0306_WC2_RZC_LiFan820 extends AirBase {
    public Air_0306_WC2_RZC_LiFan820(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0306_rzc_lifan820/air_rzc_lifan820.webp";
        this.mPathHighlight = "0306_rzc_lifan820/air_rzc_lifan820_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[4] != 0) {
            c.clipRect(703.0f, 22.0f, 811.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(234.0f, 106.0f, 310.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(201.0f, 24.0f, 342.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[5] == 0) {
            c.clipRect(685.0f, 96.0f, 833.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(540.0f, 14.0f, 626.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(380.0f, 17.0f, 443.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(381.0f, 65.0f, 437.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(379.0f, 86.0f, 413.0f, 120.0f, Region.Op.UNION);
        }
        int value = this.DATA[13];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(515.0f, 98.0f, (value * 20) + ConstRzcAddData.U_CAR_SEAT_BELT_RIGHT, 160.0f, Region.Op.UNION);
        int value2 = this.DATA[14];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(84.0f, 131.0f, (value2 * 20) + 84, 151.0f, Region.Op.UNION);
        int value3 = this.DATA[15];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(884.0f, 133.0f, (value3 * 20) + 884, 151.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[9];
        if (temp == -2 || temp == 36) {
            c.drawText("LOW", 85.0f, 75.0f, this.mPaint);
        } else if (temp == -3 || temp == 65) {
            c.drawText("HIGH", 85.0f, 75.0f, this.mPaint);
        } else if (temp < 10 && temp > 0) {
            c.drawText(temp + "  D", 85.0f, 75.0f, this.mPaint);
        } else {
            c.drawText((temp / 2.0f) + "  °C", 85.0f, 75.0f, this.mPaint);
        }
        int temp2 = this.DATA[16];
        if (temp2 == -2 || temp2 == 36) {
            c.drawText("LOW", 934.0f, 75.0f, this.mPaint);
        } else if (temp2 == -3 || temp2 == 65) {
            c.drawText("HIGH", 934.0f, 75.0f, this.mPaint);
        } else if (temp2 < 10 && temp2 > 0) {
            c.drawText(temp2 + "  D", 934.0f, 75.0f, this.mPaint);
        } else {
            c.drawText((temp2 / 2.0f) + "  °C", 934.0f, 75.0f, this.mPaint);
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
