package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_XC_GM_Rongwei_All extends AirBase {
    public Air_0452_XC_GM_Rongwei_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_xc_gm_rongwei/air.webp";
        this.mPathHighlight = "0452_xc_gm_rongwei/air_p.webp";
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
        if (this.DATA[18] != 0) {
            this.srPath.addRect(170.0f, 11.0f, 205.0f, 37.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(168.0f, 39.0f, 203.0f, 53.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(161.0f, 56.0f, 188.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[57] != 0) {
            this.srPath.addRect(274.0f, 27.0f, 352.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(365.0f, 28.0f, 466.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(273.0f, 107.0f, 350.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(569.0f, 31.0f, 676.0f, 75.0f, Path.Direction.CW);
        } else if (this.DATA[12] == 2) {
            this.srPath.addRect(572.0f, 9.0f, 617.0f, 30.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(383.0f, 110.0f, 453.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(483.0f, 108.0f, 545.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(485.0f, 23.0f, 542.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(913.0f, 106.0f, 1013.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(698.0f, 106.0f, 775.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[48] != 0) {
            this.srPath.addRect(811.0f, 11.0f, 843.0f, 35.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(813.0f, 37.0f, 844.0f, 52.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(801.0f, 55.0f, 831.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[29] & 7;
        int flag = (this.DATA[29] >> 3) & 1;
        if (flag == 1) {
            this.srPath.addRect(79.0f, 98.0f, 134.0f, 159.0f, Path.Direction.CW);
        }
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(14.0f, 131.0f, (value * 22) + 14, 159.0f, Path.Direction.CW);
        int value2 = this.DATA[30] & 7;
        int flag2 = (this.DATA[30] >> 3) & 1;
        if (flag2 == 1) {
            this.srPath.addRect(561.0f, 98.0f, 611.0f, 158.0f, Path.Direction.CW);
        }
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(616.0f, 129.0f, (value2 * 22) + 616, 158.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int value3 = this.DATA[21];
        if (this.DATA[49] == 1) {
            c.drawText("Auto", 202.0f, 139.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(value3)).toString(), 210.0f, 139.0f, this.mPaint);
        }
        c.drawText(new StringBuilder(String.valueOf(this.DATA[44])).toString(), 845.0f, 139.0f, this.mPaint);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 50.0f, 63.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 63.0f, this.mPaint);
        } else if (temp >= 11 && temp <= 44) {
            int temp2 = ((temp - 11) * 5) + 150;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 50.0f, 63.0f, this.mPaint);
        } else {
            c.drawText("NO", 50.0f, 63.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -2) {
            c.drawText("LO", 715.0f, 63.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 715.0f, 63.0f, this.mPaint);
        } else if (temp1 >= 11 && temp1 <= 44) {
            int temp3 = ((temp1 - 11) * 5) + 150;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 715.0f, 63.0f, this.mPaint);
        } else if (temp1 == -1) {
            c.drawText("NO", 715.0f, 63.0f, this.mPaint);
        }
        int temp4 = this.DATA[40];
        if (temp4 == -2) {
            c.drawText("LO", 945.0f, 63.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 945.0f, 63.0f, this.mPaint);
        } else if (temp4 >= 11 && temp4 <= 44) {
            int temp5 = ((temp4 - 11) * 5) + 150;
            c.drawText(String.valueOf(temp5 / 10) + "." + (temp5 % 10), 945.0f, 63.0f, this.mPaint);
        } else if (temp4 == -1) {
            c.drawText("NO", 945.0f, 63.0f, this.mPaint);
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
