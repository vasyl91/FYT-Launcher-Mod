package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0300_DJ_MengdiOu extends AirBase {
    public Air_0300_DJ_MengdiOu(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0300_dj_mengdiou/air_dj_0300_mengdiou_n.webp";
        this.mPathHighlight = "0300_dj_mengdiou/air_dj_0300_mengdiou_p.webp";
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
            this.srPath.addRect(738.0f, 60.0f, 881.0f, 108.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(180.0f, 29.0f, 253.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(911.0f, 99.0f, 1005.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(161.0f, 102.0f, 285.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(10.0f, 99.0f, 136.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(297.0f, 56.0f, 435.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(180.0f, 29.0f, 253.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(465.0f, 43.0f, 518.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(474.0f, 75.0f, 533.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(463.0f, 92.0f, 507.0f, 128.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(611.0f, 79.0f, (value * 16) + 611, 132.0f, Path.Direction.CW);
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
            c.drawText("LOW", 50.0f, 70.0f, this.mPaint);
        } else if (temp == 127) {
            c.drawText("HI", 50.0f, 70.0f, this.mPaint);
        } else if (temp >= 31 && temp <= 59) {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 50.0f, 70.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == 0) {
            c.drawText("LOW", 930.0f, 70.0f, this.mPaint);
        } else if (temp3 == 127) {
            c.drawText("HI", 930.0f, 70.0f, this.mPaint);
        } else if (temp3 >= 31 && temp3 <= 59) {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 930.0f, 70.0f, this.mPaint);
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
