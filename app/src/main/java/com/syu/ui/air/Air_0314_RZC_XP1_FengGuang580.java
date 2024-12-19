package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0314_RZC_XP1_FengGuang580 extends AirBase {
    public Air_0314_RZC_XP1_FengGuang580(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0314_rzc_xp1_fengguang580/air_rzc_fengguang580.webp";
        this.mPathHighlight = "0314_rzc_xp1_fengguang580/air_rzc_fengguang580_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(195.0f, 22.0f, 320.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(373.0f, 23.0f, 480.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(883.0f, 22.0f, 994.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(205.0f, 93.0f, 305.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(45.0f, 101.0f, 132.0f, 153.0f, Region.Op.UNION);
        }
        if (DataCanbus.DATA[1000] == 2031930 && this.DATA[53] != 0) {
            c.clipRect(45.0f, 101.0f, 132.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(380.0f, 93.0f, 473.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(535.0f, 12.0f, 613.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(553.0f, 88.0f, 619.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(537.0f, 108.0f, 583.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(862.0f, 96.0f, 1013.0f, 160.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value >= 0 && value <= 8) {
            c.clipRect(689.0f, 39.0f, (value * 19) + 689, 132.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(20.0f);
        if (value == 255) {
            c.drawText("Auto", 690.0f, 35.0f, this.mPaint);
        } else {
            c.drawText(" ", 690.0f, 35.0f, this.mPaint);
        }
        if (DataCanbus.DATA[1000] == 2031930) {
            this.mPaint.setTextSize(15.0f);
            if (this.DATA[53] != 0) {
                c.drawText("MAX", 28.0f, 112.0f, this.mPaint);
            } else {
                c.drawText("", 28.0f, 112.0f, this.mPaint);
            }
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 65.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 58.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 524602 || DataCanbus.DATA[1000] == 852282 || DataCanbus.DATA[1000] == 1114426 || DataCanbus.DATA[1000] == 1179962 || DataCanbus.DATA[1000] == 1245498 || DataCanbus.DATA[1000] == 1311034 || DataCanbus.DATA[1000] == 1704250 || DataCanbus.DATA[1000] == 1769786 || DataCanbus.DATA[1000] == 1835322 || DataCanbus.DATA[1000] == 1900858 || DataCanbus.DATA[1000] == 393530 || DataCanbus.DATA[1000] == 459066 || DataCanbus.DATA[1000] == 2031930) {
            c.drawText(new StringBuilder().append((((temp - 124) * 5) + 160) / 10.0f).toString(), 65.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 65.0f, 58.0f, this.mPaint);
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
