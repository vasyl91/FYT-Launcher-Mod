package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_LZ_Kayan extends AirBase {
    public Air_0439_LZ_Kayan(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0448_lz_bmw/air_lz_bmw_carui_n.webp";
        this.mPathHighlight = "0448_lz_bmw/air_lz_bmw_carui_p.webp";
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
            this.srPath.addRect(266.0f, 31.0f, 381.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(136.0f, 21.0f, 217.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(164.0f, 131.0f, 227.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(162.0f, 80.0f, 215.0f, 104.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(153.0f, 101.0f, 190.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(783.0f, 21.0f, 852.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[50] != 0) {
            this.srPath.addRect(807.0f, 133.0f, 863.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(807.0f, 84.0f, 847.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(795.0f, 104.0f, 826.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(419.0f, 111.0f, 487.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(653.0f, 105.0f, 755.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(272.0f, 103.0f, 361.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(544.0f, 13.0f, 621.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(413.0f, 15.0f, 487.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(646.0f, 15.0f, 766.0f, 79.0f, Path.Direction.CW);
        }
        int lefthot = this.DATA[29];
        int leftwin = this.DATA[31];
        if (leftwin != 0) {
            this.srPath.addRect(8.0f, 12.0f, 54.0f, 58.0f, Path.Direction.CW);
        }
        int righthot = this.DATA[30];
        int rightwin = this.DATA[32];
        if (rightwin != 0) {
            this.srPath.addRect(974.0f, 19.0f, 1017.0f, 70.0f, Path.Direction.CW);
        }
        int unit = this.DATA[37];
        if (unit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(84.0f, 116.0f, 123.0f, 161.0f, Path.Direction.CW);
            this.srPath.addRect(981.0f, 119.0f, 1018.0f, 157.0f, Path.Direction.CW);
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
        if (leftwin != 0) {
            c.drawText(new StringBuilder().append(leftwin).toString(), 86.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(lefthot).toString(), 86.0f, 62.0f, this.mPaint);
        }
        if (rightwin != 0) {
            c.drawText(new StringBuilder().append(rightwin).toString(), 931.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(righthot).toString(), 931.0f, 62.0f, this.mPaint);
        }
        int value = this.DATA[21];
        c.drawText(new StringBuilder().append(value).toString(), 580.0f, 144.0f, this.mPaint);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText(new StringBuilder().append(((left_temp * 9) / 10) + 32).toString(), 46.0f, 152.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append((left_temp * 5) / 10.0f).toString(), 46.0f, 152.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder().append(((left_temp * 9) / 10) + 32).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else if (unit == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText(new StringBuilder().append(((right_temp * 9) / 10) + 32).toString(), 930.0f, 152.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append((right_temp * 5) / 10.0f).toString(), 930.0f, 152.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder().append(((right_temp * 9) / 10) + 32).toString(), 930.0f, 152.0f, this.mPaint);
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
