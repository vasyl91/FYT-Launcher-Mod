package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0454_OD_YutongQingka extends AirBase {
    public Air_0454_OD_YutongQingka(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0015_31_xp2_xiandai_ix3545/air_od_yutong_qingka_p.webp";
        this.mPathHighlight = "0015_31_xp2_xiandai_ix3545/air_od_yutong_qingka_n.webp";
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
            this.srPath.addRect(5.0f, 12.0f, 152.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(167.0f, 17.0f, 301.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(202.0f, 114.0f, 267.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(687.0f, 9.0f, 866.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(336.0f, 39.0f, 387.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[68] != 0) {
            this.srPath.addRect(899.0f, 18.0f, 1005.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(364.0f, 71.0f, 415.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(332.0f, 92.0f, 379.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(679.0f, 91.0f, 868.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(498.0f, 71.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D5_B70, 132.0f, Path.Direction.CW);
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
        if (this.DATA[11] != 0) {
            c.drawText("MAX", 187.0f, 109.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 10) + 160) / 10.0f).toString(), 50.0f, 130.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 10) + 160) / 10.0f).toString(), 930.0f, 130.0f, this.mPaint);
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
