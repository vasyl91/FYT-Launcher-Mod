package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0372_WC_Jeep_All extends AirBase {
    public Air_0372_WC_Jeep_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0372_wc1_jeep_ziyouguang/wc_jeep_all.webp";
        this.mPathHighlight = "0372_wc1_jeep_ziyouguang/wc_jeep_all_p.webp";
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
            this.srPath.addRect(130.0f, 22.0f, 226.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(266.0f, 18.0f, 351.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(274.0f, 99.0f, 351.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(418.0f, 30.0f, 466.0f, 60.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(419.0f, 91.0f, 458.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(430.0f, 117.0f, 449.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(421.0f, 126.0f, 442.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(424.0f, 143.0f, 466.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(536.0f, 11.0f, 621.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(675.0f, 98.0f, 745.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[21] == 19) {
            this.srPath.addRect(560.0f, 101.0f, 616.0f, 119.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(671.0f, 15.0f, 760.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(787.0f, 13.0f, 899.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value >= 7) {
            value = 7;
        }
        this.srPath.addRect(538.0f, 125.0f, (value * 14) + 538, 162.0f, Path.Direction.CW);
        this.srPath.addRect(60.0f, 135.0f, (this.DATA[29] * 13) + 60, 156.0f, Path.Direction.CW);
        this.srPath.addRect(183.0f, 135.0f, (this.DATA[31] * 17) + 183, 156.0f, Path.Direction.CW);
        this.srPath.addRect(971 - (this.DATA[30] * 13), 134.0f, 971.0f, 157.0f, Path.Direction.CW);
        this.srPath.addRect(841 - (this.DATA[32] * 13), 134.0f, 841.0f, 157.0f, Path.Direction.CW);
        this.srPath.addRect(669.0f, 54.0f, (this.DATA[73] * 17) + 669, 71.0f, Path.Direction.CW);
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit == 1 || this.DATA[37] == 2) {
            this.srPath.addRect(68.0f, 27.0f, 106.0f, 74.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 30.0f, 1019.0f, 70.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(15.0f);
        if (this.DATA[53] == 1) {
            c.drawText("MAX", 406.0f, 25.0f, this.mPaint);
        } else {
            c.drawText("", 406.0f, 25.0f, this.mPaint);
        }
        if (this.DATA[62] == 1) {
            c.drawText("SYNC", 24.0f, 20.0f, this.mPaint);
        } else {
            c.drawText("", 24.0f, 20.0f, this.mPaint);
        }
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 38.0f, 64.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 38.0f, 64.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 38.0f, 64.0f, this.mPaint);
        } else if (this.DATA[37] == 1 || TempUnit == 0) {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 38.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((((temp * 9) / 5) + 320) / 10.0f).toString(), 38.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 953.0f, 64.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 953.0f, 64.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 953.0f, 64.0f, this.mPaint);
        } else if (this.DATA[37] == 1 || TempUnit == 0) {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 953.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((((temp2 * 9) / 5) + 320) / 10.0f).toString(), 953.0f, 64.0f, this.mPaint);
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
