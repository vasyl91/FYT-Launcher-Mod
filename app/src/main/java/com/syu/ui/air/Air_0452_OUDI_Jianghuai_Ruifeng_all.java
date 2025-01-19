package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_OUDI_Jianghuai_Ruifeng_all extends AirBase {
    public Air_0452_OUDI_Jianghuai_Ruifeng_all(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_oudi_jianghuai_ruifeng/air_0452_ruifengs7.webp";
        this.mPathHighlight = "0452_oudi_jianghuai_ruifeng/air_0452_ruifengs7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] == 0) {
            c.clipRect(664.0f, 18.0f, 764.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(527.0f, 23.0f, 628.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(132.0f, 24.0f, 227.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(817.0f, 24.0f, 875.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(273.0f, 98.0f, 353.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(399.0f, 38.0f, 460.0f, 90.0f, Region.Op.UNION);
            c.clipRect(273.0f, 16.0f, 352.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(402.0f, 92.0f, 452.0f, 105.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(396.0f, 105.0f, 432.0f, 138.0f, Region.Op.UNION);
        }
        int value = this.DATA[15];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(576.0f, 103.0f, (value * 20) + 576, 161.0f, Region.Op.UNION);
        switch (this.DATA[18]) {
            case 1:
                c.clipRect(58.0f, 134.0f, 73.0f, 154.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(58.0f, 134.0f, 86.0f, 154.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(58.0f, 134.0f, 101.0f, 154.0f, Region.Op.UNION);
                break;
        }
        switch (this.DATA[19]) {
            case 1:
                c.clipRect(958.0f, 137.0f, 972.0f, 155.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(945.0f, 136.0f, 972.0f, 156.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(932.0f, 136.0f, 973.0f, 154.0f, Region.Op.UNION);
                break;
        }
        switch (this.DATA[20]) {
            case 1:
                c.clipRect(177.0f, 135.0f, 191.0f, 154.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(177.0f, 135.0f, 205.0f, 154.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(177.0f, 135.0f, 220.0f, 154.0f, Region.Op.UNION);
                break;
        }
        switch (this.DATA[21]) {
            case 1:
                c.clipRect(832.0f, 136.0f, 849.0f, 154.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(819.0f, 136.0f, 846.0f, 157.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(805.0f, 134.0f, 846.0f, 156.0f, Region.Op.UNION);
                break;
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[16];
        if (temp == -2) {
            c.drawText("LOW", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NONE", 39.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 39.0f, 65.0f, this.mPaint);
        }
        int temp2 = this.DATA[17];
        if (temp2 == -2) {
            c.drawText("LOW", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NONE", 954.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 954.0f, 65.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
