package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_LZ_Maserati extends AirBase {
    public Air_0452_LZ_Maserati(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_lz_maserati/air.webp";
        this.mPathHighlight = "0452_lz_maserati/air_p.webp";
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
        if (this.DATA[60] != 0) {
            this.srPath.addRect(10.0f, 24.0f, 100.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(128.0f, 18.0f, 200.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(123.0f, 102.0f, 199.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(229.0f, 25.0f, 322.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(227.0f, 100.0f, 319.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(348.0f, 15.0f, 422.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(352.0f, 102.0f, 416.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(456.0f, 29.0f, 493.0f, 47.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(456.0f, 46.0f, 492.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(453.0f, 58.0f, 484.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(477.0f, 9.0f, 526.0f, 27.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(618.0f, 26.0f, 664.0f, 45.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(618.0f, 47.0f, 656.0f, 57.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(627.0f, 57.0f, 662.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[50] != 0) {
            this.srPath.addRect(586.0f, 9.0f, 633.0f, 29.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(690.0f, 17.0f, 785.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[55] != 0) {
            this.srPath.addRect(690.0f, 99.0f, 788.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(811.0f, 22.0f, 917.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[59] != 0) {
            this.srPath.addRect(815.0f, 97.0f, 910.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[61] != 0) {
            this.srPath.addRect(933.0f, 23.0f, 1017.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(66.0f, 121.0f, 100.0f, 153.0f, Path.Direction.CW);
            this.srPath.addRect(989.0f, 120.0f, 1020.0f, 154.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(476.0f, 98.0f, (value * 23) + 476, 155.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 39.0f, 134.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 39.0f, 134.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(left_temp / 2.0f)).toString(), 39.0f, 134.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 955.0f, 134.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 955.0f, 134.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(right_temp / 2.0f)).toString(), 955.0f, 134.0f, this.mPaint);
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
