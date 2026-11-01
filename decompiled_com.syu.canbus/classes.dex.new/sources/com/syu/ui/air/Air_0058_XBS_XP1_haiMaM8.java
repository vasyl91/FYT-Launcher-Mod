package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0058_XBS_XP1_haiMaM8 extends AirBase {
    public Air_0058_XBS_XP1_haiMaM8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0058_xbs_xp1_haimam8/xinbasihaima_m8_n.webp";
        this.mPathHighlight = "0058_xbs_xp1_haimam8/xinbasihaima_m8_p.webp";
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
            this.srPath.addRect(15.0f, 26.0f, 161.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[55] != 0) {
            this.srPath.addRect(560.0f, 31.0f, 646.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(889.0f, 19.0f, 998.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(362.0f, 18.0f, 505.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(715.0f, 26.0f, 826.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(209.0f, 96.0f, 303.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(730.0f, 89.0f, 810.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(222.0f, 26.0f, 290.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(572.0f, 91.0f, 612.0f, 108.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(579.0f, 112.0f, 620.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(562.0f, 128.0f, 592.0f, 154.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(369.0f, 94.0f, (value * 21) + 369, 163.0f, Path.Direction.CW);
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
        if (temp == 0) {
            c.drawText("LO", 75.0f, 150.0f, this.mPaint);
        } else if (temp == 127) {
            c.drawText("HI", 75.0f, 150.0f, this.mPaint);
        } else if (temp > 31 && temp < 63) {
            if (temp % 2 != 0) {
                c.drawText(new StringBuilder().append((float) (((double) (temp / 2)) + 0.5d)).toString(), 75.0f, 150.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp / 2).toString(), 75.0f, 150.0f, this.mPaint);
            }
        }
        int temp2 = this.DATA[28];
        if (temp2 == 0) {
            c.drawText("LO", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == 127) {
            c.drawText("HI", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 > 31 && temp2 < 63) {
            if (temp2 % 2 != 0) {
                c.drawText(new StringBuilder().append((float) (((double) (temp2 / 2)) + 0.5d)).toString(), 930.0f, 150.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp2 / 2).toString(), 930.0f, 150.0f, this.mPaint);
            }
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
