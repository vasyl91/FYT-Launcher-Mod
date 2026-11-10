package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0036_WC2_17_GL6 extends AirBase {
    public Air_0036_WC2_17_GL6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air_gm_all_wc.webp";
        this.mPathHighlight = "0036_wc2_gm/air_gm_all_wc_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(17.0f, 136.0f, 156.0f, 184.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(9.0f, 236.0f, 141.0f, 277.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(596.0f, 16.0f, 698.0f, 40.0f, Path.Direction.CW);
        }
        if (this.DATA[36] != 0) {
            this.srPath.addRect(612.0f, 65.0f, 702.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(320.0f, 15.0f, 404.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(467.0f, 211.0f, 561.0f, 283.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(320.0f, 15.0f, 404.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(727.0f, 149.0f, 822.0f, 180.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 2) {
            this.srPath.addRect(723.0f, 108.0f, 813.0f, 188.0f, Path.Direction.CW);
        }
        if (this.DATA[34] != 0) {
            this.srPath.addRect(463.0f, 16.0f, 553.0f, 88.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(525.0f, 105.0f, 587.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(559.0f, 147.0f, 599.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(529.0f, 163.0f, 573.0f, 194.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(596.0f, 104.0f, 673.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(604.0f, 205.0f, 678.0f, 235.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(636.0f, 236.0f, 680.0f, 254.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(612.0f, 253.0f, 648.0f, 285.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(319.0f, 67.0f, 406.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[95] != 0) {
            this.srPath.addRect(66.0f, 58.0f, 133.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[96] != 0) {
            this.srPath.addRect(890.0f, 60.0f, 958.0f, 79.0f, Path.Direction.CW);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1 || this.DATA[37] == 1) {
            this.srPath.addRect(290.0f, 150.0f, 329.0f, 189.0f, Path.Direction.CW);
            this.srPath.addRect(968.0f, 149.0f, 1005.0f, 186.0f, Path.Direction.CW);
            this.srPath.addRect(395.0f, 244.0f, 433.0f, 284.0f, Path.Direction.CW);
        }
        if (this.DATA[31] != 0) {
            this.srPath.addRect(162.0f, 21.0f, 218.0f, 59.0f, Path.Direction.CW);
        }
        if (this.DATA[32] != 0) {
            this.srPath.addRect(813.0f, 22.0f, 864.0f, 64.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value < 0 || value > 3) {
            value = 0;
        }
        this.srPath.addRect(209.0f, 57.0f, (value * 20) + 209, 84.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0 || value2 > 3) {
            value2 = 0;
        }
        this.srPath.addRect(750.0f, 59.0f, (value2 * 21) + 750, 86.0f, Path.Direction.CW);
        int value3 = this.DATA[88];
        if (value3 < 0 || value3 > 3) {
            value3 = 0;
        }
        this.srPath.addRect(214.0f, 252.0f, (value3 * 22) + 214, 278.0f, Path.Direction.CW);
        int value4 = this.DATA[89];
        if (value4 < 0 || value4 > 3) {
            value4 = 0;
        }
        this.srPath.addRect(903.0f, 252.0f, (value4 * 22) + 903, 278.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[62] != 0) {
            c.drawText("SYNC", 295.0f, 123.0f, this.mPaint);
            c.drawText("SYNC", 982.0f, 123.0f, this.mPaint);
        } else {
            c.drawText(" ", 295.0f, 123.0f, this.mPaint);
            c.drawText(" ", 982.0f, 123.0f, this.mPaint);
        }
        if (this.DATA[80] != 0) {
            c.drawText("SYNC", 366.0f, 222.0f, this.mPaint);
        } else {
            c.drawText(" ", 366.0f, 222.0f, this.mPaint);
        }
        if (this.DATA[67] != 0) {
            c.drawText("LOCK", 924.0f, 222.0f, this.mPaint);
        } else {
            c.drawText(" ", 924.0f, 222.0f, this.mPaint);
        }
        if (this.DATA[69] != 0) {
            c.drawText("auto", 703.0f, 121.0f, this.mPaint);
        } else {
            c.drawText(" ", 703.0f, 121.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int Rearlevel = this.DATA[44];
        if (Rearlevel == 32) {
            c.drawText("AUTO", 788.0f, 253.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(Rearlevel)).toString(), 788.0f, 253.0f, this.mPaint);
        }
        int frontLevel = this.DATA[21];
        if (frontLevel == 0) {
            c.drawText("OFF", 453.0f, 164.0f, this.mPaint);
        } else if (frontLevel == 19) {
            c.drawText("AUTO", 453.0f, 164.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 453.0f, 164.0f, this.mPaint);
        }
        int temp = this.DATA[27];
        if (temp == 254) {
            c.drawText("LO", 225.0f, 155.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 225.0f, 155.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp * 5) / 10)), 225.0f, 155.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder(String.valueOf(((temp * 9) / 10) + 32)).toString(), 225.0f, 155.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 225.0f, 155.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == 254) {
            c.drawText("LO", 915.0f, 155.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 915.0f, 155.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp3 * 5) / 10)), 915.0f, 155.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder(String.valueOf(((temp3 * 9) / 10) + 32)).toString(), 915.0f, 155.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 915.0f, 155.0f, this.mPaint);
        }
        int temp5 = this.DATA[40];
        if (temp5 == 254) {
            c.drawText("LO", 346.0f, 260.0f, this.mPaint);
        } else if (temp5 == 255) {
            c.drawText("HI", 346.0f, 260.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp5 * 5) / 10)), 346.0f, 260.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder(String.valueOf(((temp5 * 9) / 10) + 32)).toString(), 346.0f, 260.0f, this.mPaint);
        } else {
            int temp6 = temp5 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10)), 346.0f, 260.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
