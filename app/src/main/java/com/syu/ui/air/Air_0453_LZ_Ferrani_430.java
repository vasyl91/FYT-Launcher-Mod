package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0453_LZ_Ferrani_430 extends AirBase {
    public Air_0453_LZ_Ferrani_430(Context context) {
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
        if (this.DATA[8] != 0) {
            c.clipRect(165.0f, 23.0f, 305.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(513.0f, 31.0f, 610.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(348.0f, 143.0f, 412.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(325.0f, 12.0f, 415.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(332.0f, 63.0f, 377.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(354.0f, 89.0f, 404.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(333.0f, 106.0f, 370.0f, 140.0f, Region.Op.UNION);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1) {
            c.clipRect(112.0f, 40.0f, 159.0f, 82.0f, Region.Op.UNION);
            c.clipRect(977.0f, 36.0f, 1017.0f, 78.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[16];
        if (temp == -2) {
            c.drawText("LO", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 70.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("No", 70.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) / 10) + 32)), 70.0f, 70.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 70.0f, 70.0f, this.mPaint);
        }
        int temp3 = this.DATA[16];
        if (temp3 == -2) {
            c.drawText("LO", 938.0f, 70.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 938.0f, 70.0f, this.mPaint);
        } else if (temp3 == -1) {
            c.drawText("No", 938.0f, 70.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp3 * 9) / 10) + 32)), 938.0f, 70.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 938.0f, 70.0f, this.mPaint);
        }
        int wind = this.DATA[15];
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
