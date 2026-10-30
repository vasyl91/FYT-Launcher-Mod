package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0306_WC2_RZC_LiFan820 extends AirBase {
    public Air_0306_WC2_RZC_LiFan820(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0306_rzc_lifan820/air_rzc_lifan820.webp";
        this.mPathHighlight = "0306_rzc_lifan820/air_rzc_lifan820_p.webp";
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
        if (this.DATA[13] != 0) {
            this.srPath.addRect(703.0f, 22.0f, 811.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(234.0f, 106.0f, 310.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(201.0f, 24.0f, 342.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(685.0f, 96.0f, 833.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(540.0f, 14.0f, 626.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(380.0f, 17.0f, 443.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(381.0f, 65.0f, 437.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(379.0f, 86.0f, 413.0f, 120.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(515.0f, 98.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B6, 160.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(84.0f, 131.0f, (value2 * 20) + 84, 151.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(884.0f, 133.0f, (value3 * 20) + 884, 151.0f, Path.Direction.CW);
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
        if (temp == -2 || temp == 36) {
            c.drawText("LOW", 85.0f, 75.0f, this.mPaint);
        } else if (temp == -3 || temp == 65) {
            c.drawText("HIGH", 85.0f, 75.0f, this.mPaint);
        } else if (temp < 10 && temp > 0) {
            c.drawText(temp + "  D", 85.0f, 75.0f, this.mPaint);
        } else {
            c.drawText((temp / 2.0f) + "  °C", 85.0f, 75.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2 || temp2 == 36) {
            c.drawText("LOW", 934.0f, 75.0f, this.mPaint);
        } else if (temp2 == -3 || temp2 == 65) {
            c.drawText("HIGH", 934.0f, 75.0f, this.mPaint);
        } else if (temp2 < 10 && temp2 > 0) {
            c.drawText(temp2 + "  D", 934.0f, 75.0f, this.mPaint);
        } else {
            c.drawText((temp2 / 2.0f) + "  °C", 934.0f, 75.0f, this.mPaint);
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
