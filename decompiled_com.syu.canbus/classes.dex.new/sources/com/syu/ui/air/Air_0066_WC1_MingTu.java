package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0066_WC1_MingTu extends AirBase {
    public Air_0066_WC1_MingTu(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0066_wc1_mingtu/air_wc1_mingtu_n.webp";
        this.mPathHighlight = "0066_wc1_mingtu/air_wc1_mingtu_p.webp";
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
            this.srPath.addRect(688.0f, 96.0f, 859.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(169.0f, 22.0f, 293.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(178.0f, 104.0f, 288.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(337.0f, 23.0f, 408.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(703.0f, 23.0f, 840.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(376.0f, 81.0f, 422.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(344.0f, 101.0f, 387.0f, 137.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(500.0f, 72.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B54, 132.0f, Path.Direction.CW);
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
        if (temp == 254) {
            c.drawText("LOW", 55.0f, 100.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 55.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 55.0f, 100.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == 254) {
            c.drawText("LOW", 930.0f, 100.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 930.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 930.0f, 100.0f, this.mPaint);
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
