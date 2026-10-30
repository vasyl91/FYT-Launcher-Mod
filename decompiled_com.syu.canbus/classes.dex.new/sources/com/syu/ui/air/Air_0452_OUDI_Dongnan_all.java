package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_OUDI_Dongnan_all extends AirBase {
    public Air_0452_OUDI_Dongnan_all(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_oudi_dongnan/air_0452_dongnan.webp";
        this.mPathHighlight = "0452_oudi_dongnan/air_0452_dongnan_p.webp";
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
            this.srPath.addRect(126.0f, 104.0f, 260.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(607.0f, 11.0f, 726.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(474.0f, 27.0f, 548.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(157.0f, 13.0f, 223.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(318.0f, 20.0f, 388.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(315.0f, 97.0f, 386.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(786.0f, 33.0f, 851.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(794.0f, 84.0f, 839.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(788.0f, 98.0f, 822.0f, 133.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0 || value > 8) {
            value = 0;
        }
        this.srPath.addRect(521.0f, 103.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B0, 162.0f, Path.Direction.CW);
        this.srPath.addRect(59.0f, 136.0f, (this.DATA[29] * 13) + 59, 155.0f, Path.Direction.CW);
        this.srPath.addRect(971 - (this.DATA[30] * 13), 136.0f, 971.0f, 155.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(26.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NONE", 39.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 39.0f, 65.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NONE", 954.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 954.0f, 65.0f, this.mPaint);
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
