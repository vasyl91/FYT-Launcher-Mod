package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_LZ_Juguar extends AirBase {
    public Air_0452_LZ_Juguar(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_lz_jaguar/air.webp";
        this.mPathHighlight = "0452_lz_jaguar/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(130.0f, 22.0f, 226.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(266.0f, 18.0f, 351.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(274.0f, 99.0f, 351.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(408.0f, 26.0f, 473.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(419.0f, 91.0f, 458.0f, 118.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(430.0f, 117.0f, 449.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(421.0f, 126.0f, 442.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(424.0f, 143.0f, 466.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(530.0f, 25.0f, 632.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(675.0f, 98.0f, 745.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(560.0f, 101.0f, 616.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(661.0f, 18.0f, 759.0f, 53.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(787.0f, 13.0f, 899.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value >= 7) {
            value = 7;
        }
        c.clipRect(538.0f, 125.0f, (value * 14) + 538, 162.0f, Region.Op.UNION);
        int value2 = this.DATA[24];
        if ((value2 & 8) != 0) {
            c.clipRect(179.0f, 135.0f, ((16 - value2) * 13) + 179, 156.0f, Region.Op.UNION);
        } else {
            c.clipRect(60.0f, 135.0f, (value2 * 13) + 60, 156.0f, Region.Op.UNION);
        }
        int value3 = this.DATA[25];
        if ((value3 & 8) != 0) {
            c.clipRect(845 - ((16 - value3) * 13), 134.0f, 845.0f, 156.0f, Region.Op.UNION);
        } else {
            c.clipRect(971 - (value3 * 13), 134.0f, 971.0f, 157.0f, Region.Op.UNION);
        }
        c.clipRect(669.0f, 54.0f, (this.DATA[21] * 17) + 669, 71.0f, Region.Op.UNION);
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1) {
            c.clipRect(68.0f, 27.0f, 106.0f, 74.0f, Region.Op.UNION);
            c.clipRect(980.0f, 30.0f, 1019.0f, 70.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[19];
        if (temp == -1) {
            c.drawText("NO", 38.0f, 64.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 38.0f, 64.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 38.0f, 64.0f, this.mPaint);
        } else if (TempUnit == 0) {
            c.drawText(String.valueOf(temp / 2.0f), 38.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 9) + 320) / 10.0f), 38.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[20];
        if (temp2 == -1) {
            c.drawText("NO", 953.0f, 64.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 953.0f, 64.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 953.0f, 64.0f, this.mPaint);
        } else if (TempUnit == 0) {
            c.drawText(String.valueOf(temp2 / 2.0f), 953.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 9) + 320) / 10.0f), 953.0f, 64.0f, this.mPaint);
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
