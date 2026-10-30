package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0206_WC1_Benz extends AirBase {
    public Air_0206_WC1_Benz(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0206_wc1_benz/air_wc1_benz_n.webp";
        this.mPathHighlight = "0206_wc1_benz/air_wc1_benz_p.webp";
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
            this.srPath.addRect(162.0f, 22.0f, 273.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(447.0f, 47.0f, 577.0f, 119.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(901.0f, 25.0f, 1006.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(606.0f, 14.0f, 704.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(606.0f, 92.0f, 704.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(318.0f, 93.0f, 416.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(8.0f, 27.0f, 139.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(318.0f, 93.0f, 416.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(325.0f, 35.0f, 374.0f, 50.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(317.0f, 50.0f, 356.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(797.0f, 10.0f, 845.0f, 34.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(793.0f, 35.0f, 842.0f, 50.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(811.0f, 50.0f, 850.0f, 82.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(40.0f);
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.drawText(new StringBuilder().append(value).toString(), 240.0f, 140.0f, this.mPaint);
        int value2 = this.DATA[25];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 8) {
            value2 = 8;
        }
        c.drawText(new StringBuilder().append(value2).toString(), 820.0f, 140.0f, this.mPaint);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10) + "." + (temp % 10), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 930.0f, 140.0f, this.mPaint);
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
