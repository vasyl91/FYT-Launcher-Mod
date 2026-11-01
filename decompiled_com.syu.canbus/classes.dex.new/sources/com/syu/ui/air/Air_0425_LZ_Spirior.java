package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(10.0f, 20.0f, 170.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(193.0f, 13.0f, 348.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(899.0f, 22.0f, 976.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(212.0f, 104.0f, 340.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(725.0f, 90.0f, 828.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(714.0f, 9.0f, 828.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(572.0f, 52.0f, 621.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(577.0f, 78.0f, 631.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(566.0f, 96.0f, 608.0f, 128.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(401.0f, 63.0f, (value * 18) + 401, 118.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        int unit = this.DATA[37] & 255;
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
        int temp4 = this.DATA[28];
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
