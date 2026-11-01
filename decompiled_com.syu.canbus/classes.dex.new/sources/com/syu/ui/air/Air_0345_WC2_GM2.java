package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0345_WC2_GM2 extends AirBase {
    public Air_0345_WC2_GM2(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air.webp";
        this.mPathHighlight = "0036_wc2_gm/air_p.webp";
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
            this.srPath.addRect(21.0f, 29.0f, 193.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(639.0f, 7.0f, 801.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[36] != 0) {
            this.srPath.addRect(668.0f, 64.0f, 764.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(243.0f, 17.0f, 378.0f, 96.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(857.0f, 55.0f, 981.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 2) {
            this.srPath.addRect(859.0f, 17.0f, 977.0f, 54.0f, Path.Direction.CW);
        }
        if (this.DATA[80] != 0) {
            this.srPath.addRect(456.0f, 9.0f, 575.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(656.0f, 105.0f, 721.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(690.0f, 147.0f, 735.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(660.0f, 163.0f, 702.0f, 194.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(729.0f, 106.0f, 804.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(558.0f, 203.0f, 645.0f, 230.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(597.0f, 240.0f, 642.0f, 257.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(570.0f, 258.0f, 611.0f, 288.0f, Path.Direction.CW);
        }
        if (this.DATA[44] == 5) {
            this.srPath.addRect(923.0f, 239.0f, 1000.0f, 274.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[44], 0, 4);
        if (value < 0 || value > 4) {
            value = 0;
        }
        this.srPath.addRect(830.0f, 219.0f, (value * 18) + 830, 286.0f, Path.Direction.CW);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit == 1 || this.DATA[37] == 1) {
            this.srPath.addRect(353.0f, 146.0f, 393.0f, 191.0f, Path.Direction.CW);
            this.srPath.addRect(967.0f, 144.0f, 1009.0f, 194.0f, Path.Direction.CW);
            this.srPath.addRect(408.0f, 242.0f, 448.0f, 284.0f, Path.Direction.CW);
        }
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
        this.mPaint.setTextSize(30.0f);
        int frontLevel = this.DATA[21];
        if (frontLevel == 0) {
            c.drawText("OFF", 550.0f, 155.0f, this.mPaint);
        } else if (frontLevel == 19) {
            c.drawText("AUTO", 550.0f, 155.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 550.0f, 155.0f, this.mPaint);
        }
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 295.0f, 155.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 295.0f, 155.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp * 5) / 10)), 295.0f, 155.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) + 320) / 10)), 295.0f, 155.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 295.0f, 155.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -2) {
            c.drawText("LO", 905.0f, 155.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 905.0f, 155.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp3 * 5) / 10)), 905.0f, 155.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp3 * 9) + 320) / 10)), 905.0f, 155.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 905.0f, 155.0f, this.mPaint);
        }
        int temp5 = this.DATA[40];
        if (temp5 == -2) {
            c.drawText("LO", 350.0f, 260.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 350.0f, 260.0f, this.mPaint);
        } else if (temp5 == 0) {
            c.drawText("----", 350.0f, 260.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.format("%d", Integer.valueOf((temp5 * 5) / 10)), 350.0f, 260.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp5 * 9) + 320) / 10)), 350.0f, 260.0f, this.mPaint);
        } else {
            int temp6 = temp5 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10)), 350.0f, 260.0f, this.mPaint);
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
