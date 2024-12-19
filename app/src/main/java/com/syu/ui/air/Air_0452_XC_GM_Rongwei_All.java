package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[45] != 0) {
            c.clipRect(170.0f, 11.0f, 205.0f, 37.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(168.0f, 39.0f, 203.0f, 53.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(161.0f, 56.0f, 188.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(274.0f, 27.0f, 352.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(365.0f, 28.0f, 466.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(273.0f, 107.0f, 350.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[38] == 0) {
            c.clipRect(569.0f, 31.0f, 676.0f, 75.0f, Region.Op.UNION);
        } else if (this.DATA[38] == 2) {
            c.clipRect(572.0f, 9.0f, 617.0f, 30.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(383.0f, 110.0f, 453.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(483.0f, 108.0f, 545.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(485.0f, 23.0f, 542.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[52] != 0) {
            c.clipRect(913.0f, 106.0f, 1013.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(698.0f, 106.0f, 775.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(811.0f, 11.0f, 843.0f, 35.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(813.0f, 37.0f, 844.0f, 52.0f, Region.Op.UNION);
        }
        if (this.DATA[56] != 0) {
            c.clipRect(801.0f, 55.0f, 831.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[50] & 7;
        int flag = (this.DATA[50] >> 3) & 1;
        if (flag == 1) {
            c.clipRect(79.0f, 98.0f, 134.0f, 159.0f, Region.Op.UNION);
        }
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(14.0f, 131.0f, (value * 22) + 14, 159.0f, Region.Op.UNION);
        int value2 = this.DATA[51] & 7;
        int flag2 = (this.DATA[51] >> 3) & 1;
        if (flag2 == 1) {
            c.clipRect(561.0f, 98.0f, 611.0f, 158.0f, Region.Op.UNION);
        }
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(616.0f, 129.0f, (value2 * 22) + 616, 158.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int value3 = this.DATA[43];
        if (this.DATA[42] == 1) {
            c.drawText("Auto", 202.0f, 139.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(value3)).toString(), 210.0f, 139.0f, this.mPaint);
        }
        c.drawText(new StringBuilder(String.valueOf(this.DATA[58])).toString(), 845.0f, 139.0f, this.mPaint);
        int temp = this.DATA[48];
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
        int temp1 = this.DATA[49];
        if (temp1 == -2) {
            c.drawText("LO", 715.0f, 63.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 715.0f, 63.0f, this.mPaint);
        } else if (temp1 >= 11 && temp1 <= 44) {
            int temp12 = ((temp1 - 11) * 5) + 150;
            c.drawText(String.valueOf(temp12 / 10) + "." + (temp12 % 10), 715.0f, 63.0f, this.mPaint);
        } else if (temp1 == -1) {
            c.drawText("NO", 715.0f, 63.0f, this.mPaint);
        }
        int temp22 = this.DATA[57];
        if (temp22 == -2) {
            c.drawText("LO", 945.0f, 63.0f, this.mPaint);
        } else if (temp22 == -3) {
            c.drawText("HI", 945.0f, 63.0f, this.mPaint);
        } else if (temp22 >= 11 && temp22 <= 44) {
            int temp23 = ((temp22 - 11) * 5) + 150;
            c.drawText(String.valueOf(temp23 / 10) + "." + (temp23 % 10), 945.0f, 63.0f, this.mPaint);
        } else if (temp22 == -1) {
            c.drawText("NO", 945.0f, 63.0f, this.mPaint);
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
