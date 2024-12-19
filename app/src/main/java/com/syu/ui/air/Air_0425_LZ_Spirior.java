package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0425_LZ_Spirior extends AirBase {
    public Air_0425_LZ_Spirior(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0425_lz_spirior/luzhen_spirior.webp";
        this.mPathHighlight = "0425_lz_spirior/luzhen_spirior_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[21] != 0) {
            c.clipRect(10.0f, 20.0f, 170.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 1) {
            c.clipRect(193.0f, 13.0f, 348.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(899.0f, 22.0f, 976.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(212.0f, 104.0f, 340.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(725.0f, 90.0f, 828.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(714.0f, 9.0f, 828.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(572.0f, 52.0f, 621.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(577.0f, 78.0f, 631.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(566.0f, 96.0f, 608.0f, 128.0f, Region.Op.UNION);
        }
        int value = this.DATA[32];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(401.0f, 63.0f, (value * 18) + 401, 118.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[28];
        int unit = this.DATA[33] & 255;
        String str = "";
        if (temp == -1) {
            str = "NO";
        } else if (temp == -3) {
            str = "HI";
        } else if (temp == -2) {
            str = "LOW";
        } else {
            int temp2 = temp - 30;
            if (temp2 >= 0 && temp2 <= 34) {
                int temp3 = (temp2 * 5) + 150;
                str = unit == 1 ? String.format("%d.%d    ℉", Integer.valueOf(temp3 / 10), Integer.valueOf(temp3 % 10)) : String.format("%d.%d    ℃", Integer.valueOf(temp3 / 10), Integer.valueOf(temp3 % 10));
            }
        }
        c.drawText(str, 80.0f, 145.0f, this.mPaint);
        int temp4 = this.DATA[27];
        if (temp4 == -1) {
            str = "NO";
        } else if (temp4 == -3) {
            str = "HI";
        } else if (temp4 == -2) {
            str = "LOW";
        } else {
            int temp5 = temp4 - 30;
            if (temp5 >= 0 && temp5 <= 34) {
                int temp6 = (temp5 * 5) + 150;
                if (unit == 1) {
                    str = String.format("%d.%d    ℉", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10));
                } else {
                    str = String.format("%d.%d    ℃", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10));
                }
            }
        }
        c.drawText(str, 940.0f, 145.0f, this.mPaint);
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
