package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_LZ_Ford_QuanshunT8_all extends AirBase {
    public Air_0455_LZ_Ford_QuanshunT8_all(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_oudi_jianghuai_ruifeng/air_0452_ruifengs7.webp";
        this.mPathHighlight = "0452_oudi_jianghuai_ruifeng/air_0452_ruifengs7_p.webp";
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
        if (this.DATA[12] == 0) {
            this.srPath.addRect(664.0f, 18.0f, 764.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(527.0f, 23.0f, 628.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(132.0f, 24.0f, 227.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(817.0f, 24.0f, 875.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(273.0f, 98.0f, 353.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(399.0f, 38.0f, 460.0f, 90.0f, Path.Direction.CW);
            this.srPath.addRect(273.0f, 16.0f, 352.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(402.0f, 92.0f, 452.0f, 105.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(396.0f, 105.0f, 432.0f, 138.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(576.0f, 103.0f, (value * 20) + 576, 161.0f, Path.Direction.CW);
        switch (this.DATA[29]) {
            case 1:
                this.srPath.addRect(58.0f, 134.0f, 73.0f, 154.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(58.0f, 134.0f, 86.0f, 154.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(58.0f, 134.0f, 101.0f, 154.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[30]) {
            case 1:
                this.srPath.addRect(958.0f, 137.0f, 972.0f, 155.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(945.0f, 136.0f, 972.0f, 156.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(932.0f, 136.0f, 973.0f, 154.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[31]) {
            case 1:
                this.srPath.addRect(177.0f, 135.0f, 191.0f, 154.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(177.0f, 135.0f, 205.0f, 154.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(177.0f, 135.0f, 220.0f, 154.0f, Path.Direction.CW);
                break;
        }
        switch (this.DATA[32]) {
            case 1:
                this.srPath.addRect(832.0f, 136.0f, 849.0f, 154.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(819.0f, 136.0f, 846.0f, 157.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(805.0f, 134.0f, 846.0f, 156.0f, Path.Direction.CW);
                break;
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
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NO", 39.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 39.0f, 65.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NO", 954.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 954.0f, 65.0f, this.mPaint);
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
