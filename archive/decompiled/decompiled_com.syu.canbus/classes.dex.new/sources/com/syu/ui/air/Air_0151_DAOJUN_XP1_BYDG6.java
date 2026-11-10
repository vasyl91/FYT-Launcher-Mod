package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0151_DAOJUN_XP1_BYDG6 extends AirBase {
    public Air_0151_DAOJUN_XP1_BYDG6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0151_daojun_xp1_byds6/air_daojun_xp1_byds6_n.webp";
        this.mPathHighlight = "0151_daojun_xp1_byds6/air_daojun_xp1_byds6_p.webp";
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
        if (this.DATA[14] != 0) {
            this.srPath.addRect(22.0f, 15.0f, 138.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 2) {
            this.srPath.addRect(202.0f, 90.0f, 279.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 0) {
            this.srPath.addRect(204.0f, 133.0f, 264.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(343.0f, 100.0f, 388.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(367.0f, 68.0f, 424.0f, 101.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(337.0f, 11.0f, 427.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(364.0f, 138.0f, 435.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(174.0f, 14.0f, 291.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 2) {
            this.srPath.addRect(698.0f, 89.0f, 854.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[13] == 1) {
            this.srPath.addRect(903.0f, 18.0f, 1010.0f, 75.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0 || value > 8) {
            value = 0;
        }
        if (value == 8) {
            this.srPath.addRect(548.0f, 127.0f, 615.0f, 155.0f, Path.Direction.CW);
        } else {
            this.srPath.addRect(511.0f, 60.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D5_B70, 133.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        switch (temp) {
            case 1:
                c.drawText("LOW", 55.0f, 147.0f, this.mPaint);
                break;
            case 17:
                c.drawText("HI", 55.0f, 147.0f, this.mPaint);
                break;
            default:
                if (temp >= 2 && temp <= 16) {
                    int temp2 = (temp * 10) + 160;
                    c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 55.0f, 147.0f, this.mPaint);
                } else {
                    c.drawText("NO", 55.0f, 147.0f, this.mPaint);
                }
                break;
        }
        int temp3 = this.DATA[28];
        switch (temp3) {
            case 1:
                c.drawText("LOW", 927.0f, 147.0f, this.mPaint);
                break;
            case 17:
                c.drawText("HI", 927.0f, 147.0f, this.mPaint);
                break;
            default:
                if (temp3 >= 2 && temp3 <= 16) {
                    int temp4 = (temp3 * 10) + 160;
                    c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 927.0f, 147.0f, this.mPaint);
                } else {
                    c.drawText("NO", 927.0f, 147.0f, this.mPaint);
                }
                break;
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
