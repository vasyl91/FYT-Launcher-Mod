package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_RZC_Benz_S350 extends AirBase {
    public Air_0439_RZC_Benz_S350(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_benz_all/rzc_benz_s350_n.webp";
        this.mPathHighlight = "0439_rzc_benz_all/rzc_benz_s350_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(191.0f, 25.0f, 248.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(99.0f, 29.0f, 170.0f, 62.0f, Path.Direction.CW);
            this.srPath.addRect(497.0f, 28.0f, 567.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(117.0f, 93.0f, 149.0f, 115.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(104.0f, 115.0f, 137.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(98.0f, 125.0f, 121.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(108.0f, 145.0f, 164.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(265.0f, 118.0f, 338.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(279.0f, 96.0f, 322.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(262.0f, 28.0f, 342.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(353.0f, 107.0f, 406.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(352.0f, 19.0f, 405.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(420.0f, 32.0f, 486.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[50] != 0) {
            this.srPath.addRect(510.0f, 144.0f, 557.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(515.0f, 92.0f, 549.0f, 116.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(505.0f, 115.0f, 534.0f, 127.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(500.0f, 125.0f, 519.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(767.0f, 144.0f, 824.0f, 165.0f, Path.Direction.CW);
        }
        if (this.DATA[48] != 0) {
            this.srPath.addRect(779.0f, 92.0f, 810.0f, 116.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(765.0f, 115.0f, 796.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(760.0f, 125.0f, 783.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[81] != 0) {
            this.srPath.addRect(952.0f, 146.0f, 1005.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[84] != 0) {
            this.srPath.addRect(960.0f, 92.0f, 993.0f, 116.0f, Path.Direction.CW);
        }
        if (this.DATA[82] != 0) {
            this.srPath.addRect(950.0f, 115.0f, 981.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[83] != 0) {
            this.srPath.addRect(942.0f, 125.0f, 966.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(858.0f, 33.0f, 931.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(581.0f, 30.0f, 645.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(53.0f, 46.0f, 85.0f, 75.0f, Path.Direction.CW);
            this.srPath.addRect(695.0f, 44.0f, 725.0f, 75.0f, Path.Direction.CW);
            this.srPath.addRect(809.0f, 45.0f, 838.0f, 77.0f, Path.Direction.CW);
            this.srPath.addRect(984.0f, 45.0f, 1019.0f, 77.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        this.mRectTmp.set(39.0f, 132.0f, (value * 14) + 39, 151.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(686.0f, 132.0f, (value2 * 14) + 686, 151.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
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
        this.mPaint.setTextSize(12.0f);
        if (this.DATA[53] != 0) {
            c.drawText("MAX COOL", 217.0f, 20.0f, this.mPaint);
        } else {
            c.drawText("", 217.0f, 20.0f, this.mPaint);
        }
        this.mPaint.setTextSize(25.0f);
        int value3 = this.DATA[21];
        if (this.DATA[33] != 0) {
            this.mPaint.setTextSize(18.0f);
            c.drawText("auto", 223.0f, 142.0f, this.mPaint);
        } else if (value3 >= 0 && value3 <= 7) {
            this.mPaint.setTextSize(22.0f);
            if (this.DATA[56] != 0) {
                c.drawText(value3 + ".5", 223.0f, 142.0f, this.mPaint);
            } else {
                c.drawText(value3 + ".0", 223.0f, 142.0f, this.mPaint);
            }
        }
        int value4 = this.DATA[25];
        if (this.DATA[26] != 0) {
            this.mPaint.setTextSize(18.0f);
            c.drawText("auto", 454.0f, 142.0f, this.mPaint);
        } else if (value4 >= 0 && value4 <= 7) {
            this.mPaint.setTextSize(22.0f);
            if (this.DATA[56] != 0) {
                c.drawText(value4 + ".5", 454.0f, 142.0f, this.mPaint);
            } else {
                c.drawText(value4 + ".0", 454.0f, 142.0f, this.mPaint);
            }
        }
        if (this.DATA[55] != 0) {
            this.mPaint.setTextSize(18.0f);
            c.drawText("auto", 896.0f, 142.0f, this.mPaint);
        } else {
            int value5 = this.DATA[44];
            this.mPaint.setTextSize(25.0f);
            c.drawText(new StringBuilder().append(value5).toString(), 896.0f, 142.0f, this.mPaint);
        }
        this.mPaint.setTextSize(15.0f);
        int value6 = this.DATA[64];
        if (value6 == 1) {
            c.drawText("DIFFUSE", 613.0f, 138.0f, this.mPaint);
        } else if (value6 == 2) {
            c.drawText("MEDIUM", 613.0f, 138.0f, this.mPaint);
        } else if (value6 == 3) {
            c.drawText("FOCUS", 613.0f, 138.0f, this.mPaint);
        } else {
            c.drawText("----", 613.0f, 138.0f, this.mPaint);
        }
        this.mPaint.setTextSize(17.0f);
        int value7 = this.DATA[27];
        if (value7 == -2) {
            c.drawText("LO", 27.0f, 55.0f, this.mPaint);
        } else if (value7 == -3) {
            c.drawText("HI", 27.0f, 55.0f, this.mPaint);
        } else if (value7 == -1) {
            c.drawText("NO", 27.0f, 55.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder().append(((value7 * 9) / 10) + 32).toString(), 27.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value7 / 2.0f).toString(), 27.0f, 55.0f, this.mPaint);
        }
        int value8 = this.DATA[28];
        if (value8 == -2) {
            c.drawText("LO", 673.0f, 55.0f, this.mPaint);
        } else if (value8 == -3) {
            c.drawText("HI", 673.0f, 55.0f, this.mPaint);
        } else if (value8 == -1) {
            c.drawText("NO", 673.0f, 55.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder().append(((value8 * 9) / 10) + 32).toString(), 673.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value8 / 2.0f).toString(), 673.0f, 55.0f, this.mPaint);
        }
        int value9 = this.DATA[40];
        if (value9 == -2) {
            c.drawText("LO", 775.0f, 55.0f, this.mPaint);
        } else if (value9 == -3) {
            c.drawText("HI", 775.0f, 55.0f, this.mPaint);
        } else if (value9 == -1) {
            c.drawText("NO", 775.0f, 55.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder().append(((value9 * 9) / 10) + 32).toString(), 775.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value9 / 2.0f).toString(), 775.0f, 55.0f, this.mPaint);
        }
        int value10 = this.DATA[41];
        if (value10 == -2) {
            c.drawText("LO", 962.0f, 55.0f, this.mPaint);
        } else if (value10 == -3) {
            c.drawText("HI", 962.0f, 55.0f, this.mPaint);
        } else if (value10 == -1) {
            c.drawText("NO", 962.0f, 55.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder().append(((value10 * 9) / 10) + 32).toString(), 962.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value10 / 2.0f).toString(), 962.0f, 55.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
