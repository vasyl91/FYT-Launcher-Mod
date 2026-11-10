package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0282_WC2_17MingJueRuiTeng extends AirBase {
    public Air_0282_WC2_17MingJueRuiTeng(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0282_wc2_mingjueruiteng/air_wc_17ruiteng_n.webp";
        this.mPathHighlight = "0282_wc2_mingjueruiteng/air_wc_17ruiteng_p.webp";
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
            this.srPath.addRect(868.0f, 11.0f, 1012.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(49.0f, 18.0f, 158.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(358.0f, 99.0f, 489.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(195.0f, 16.0f, 319.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(214.0f, 92.0f, 313.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(374.0f, 8.0f, 424.0f, 39.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(375.0f, 41.0f, 414.0f, 57.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(370.0f, 59.0f, 398.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(439.0f, 58.0f, 495.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(509.0f, 9.0f, 655.0f, 76.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(512.0f, 91.0f, (value * 18) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D6_B70, 168.0f, Path.Direction.CW);
        if (this.DATA[14] != 0) {
            this.srPath.addRect(692.0f, 14.0f, 810.0f, 66.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 76.0f, 142.0f, this.mPaint);
        }
        int left_temp_real = this.DATA[28];
        if (left_temp_real == -2) {
            c.drawText("LOW", 935.0f, 142.0f, this.mPaint);
        } else if (left_temp_real == -3) {
            c.drawText("HI", 935.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp_real / 10.0f).toString(), 935.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[186];
        if (right_temp == -2 || right_temp == -3) {
            c.drawText("--.-", 750.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 10.0f).toString(), 750.0f, 142.0f, this.mPaint);
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
