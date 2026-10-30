package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0248_RZC2_ZhonghuaV5 extends AirBase {
    public Air_0248_RZC2_ZhonghuaV5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0248_rzc2_zhonghuav5/air_rzc_dongnanv5_n.webp";
        this.mPathHighlight = "0248_rzc2_zhonghuav5/air_rzc_dongnanv5_p.webp";
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
            this.srPath.addRect(892.0f, 102.0f, 1012.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(19.0f, 17.0f, 137.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(543.0f, 13.0f, 650.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(894.0f, 19.0f, 991.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(392.0f, 62.0f, 452.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(375.0f, 93.0f, 420.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 1) {
            this.srPath.addRect(187.0f, 44.0f, 330.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(729.0f, 13.0f, 828.0f, 84.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(515.0f, 90.0f, (value * 22) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B6, 164.0f, Path.Direction.CW);
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
        int point = this.DATA[55];
        if (temp == 0) {
            c.drawText("LOW", 70.0f, 143.0f, this.mPaint);
        } else if (temp == 254) {
            c.drawText("NONE", 70.0f, 143.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText(String.valueOf(temp) + "HIGH", 70.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp + (point / 10.0f))).toString(), 70.0f, 143.0f, this.mPaint);
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
