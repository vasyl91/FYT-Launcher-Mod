package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0061_RZC_XP1_GM extends AirBase {
    public Air_0061_RZC_XP1_GM(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0061_rzc_xp1_gm/air.webp";
        this.mPathHighlight = "0061_rzc_xp1_gm/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[43] != 0) {
            c.clipRect(165.0f, 23.0f, 305.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[32] == 0) {
            c.clipRect(513.0f, 31.0f, 610.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[34] == 1) {
            c.clipRect(183.0f, 103.0f, 271.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[33] == 1) {
            c.clipRect(732.0f, 14.0f, 829.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(348.0f, 143.0f, 412.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(325.0f, 12.0f, 415.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(332.0f, 63.0f, 377.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(354.0f, 89.0f, 404.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(333.0f, 106.0f, 370.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[44] != 0) {
            c.clipRect(507.0f, 12.0f, 552.0f, 31.0f, Region.Op.UNION);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1) {
            c.clipRect(112.0f, 40.0f, 159.0f, 82.0f, Region.Op.UNION);
            c.clipRect(977.0f, 36.0f, 1017.0f, 78.0f, Region.Op.UNION);
        }
        int value = this.DATA[35];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(83.0f, 133.0f, (value * 21) + 83, 163.0f, Region.Op.UNION);
        int value2 = this.DATA[36];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(938.0f, 134.0f, (value2 * 21) + 938, 161.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[37];
        if (temp == 0) {
            c.drawText("LOW", 70.0f, 70.0f, this.mPaint);
        } else if (temp == 30) {
            c.drawText("HI", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("No", 70.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) / 50) + 32)), 70.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 70.0f, 70.0f, this.mPaint);
        }
        int temp2 = this.DATA[38];
        if (temp2 == 0) {
            c.drawText("LOW", 938.0f, 70.0f, this.mPaint);
        } else if (temp2 == 30) {
            c.drawText("HI", 938.0f, 70.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("No", 938.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp2 * 9) / 50) + 32)), 938.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 938.0f, 70.0f, this.mPaint);
        }
        int wind = this.DATA[42];
        c.drawText(String.format("%d", Integer.valueOf(wind)), 737.0f, 142.0f, this.mPaint);
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
