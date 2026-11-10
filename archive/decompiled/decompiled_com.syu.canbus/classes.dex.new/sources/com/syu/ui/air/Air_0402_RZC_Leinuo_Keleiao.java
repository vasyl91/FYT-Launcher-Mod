package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0402_RZC_Leinuo_Keleiao extends AirBase {
    public Air_0402_RZC_Leinuo_Keleiao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0402_rzc_leinuo/leinuo_keleiao.webp";
        this.mPathHighlight = "0402_rzc_leinuo/leinuo_keleiao_p.webp";
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
        if (this.DATA[54] != 0) {
            this.srPath.addRect(352.0f, 9.0f, 406.0f, 31.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(27.0f, 23.0f, 133.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(369.0f, 32.0f, 459.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(882.0f, 16.0f, 975.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(685.0f, 109.0f, 815.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(205.0f, 92.0f, 311.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(209.0f, 18.0f, 308.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(369.0f, 98.0f, 476.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(526.0f, 118.0f, 570.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(538.0f, 94.0f, 601.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(525.0f, 18.0f, 612.0f, 75.0f, Path.Direction.CW);
        }
        this.srPath.addRect(678.0f, 16.0f, (this.DATA[21] * 18) + 678, 85.0f, Path.Direction.CW);
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
        int value = this.DATA[27];
        if (value == -2) {
            c.drawText("LO", 69.0f, 142.0f, this.mPaint);
        } else if (value == -3) {
            c.drawText("HI", 69.0f, 142.0f, this.mPaint);
        } else if (value == -1) {
            c.drawText("NO", 69.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value / 2.0f).toString(), 69.0f, 142.0f, this.mPaint);
        }
        int value2 = this.DATA[28];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_L /* 7012754 */:
            case FinalCanbus.CAR_RZC_HY_17_18KeleiAo /* 8847762 */:
                value2 = this.DATA[27];
                break;
        }
        if (value2 == -2) {
            c.drawText("LO", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == -3) {
            c.drawText("HI", 916.0f, 142.0f, this.mPaint);
        } else if (value2 == -1) {
            c.drawText("NO", 916.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value2 / 2.0f).toString(), 916.0f, 142.0f, this.mPaint);
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
