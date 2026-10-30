package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_AY_BYD_Surui extends AirBase {
    public Air_0439_AY_BYD_Surui(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_ay_byd_surui/ay_byd_surui.webp";
        this.mPathHighlight = "0439_ay_byd_surui/ay_byd_surui_p.webp";
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
            this.srPath.addRect(3.0f, 99.0f, 144.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(776.0f, 104.0f, 841.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(290.0f, 22.0f, 390.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(748.0f, 11.0f, 872.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(897.0f, 105.0f, 1008.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(166.0f, 12.0f, 260.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(170.0f, 92.0f, 256.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(622.0f, 24.0f, 689.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(630.0f, 84.0f, 679.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(618.0f, 106.0f, 656.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(291.0f, 96.0f, 391.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[80] != 0) {
            this.srPath.addRect(444.0f, 21.0f, 552.0f, 67.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 9) {
            value = 9;
        }
        this.srPath.addRect(423.0f, 86.0f, (value * 19) + 423, 157.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("NO", 63.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 63.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 63.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = ((temp - 30) * 5) + 150;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 63.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            int temp3 = ((temp1 - 30) * 5) + 150;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 930.0f, 60.0f, this.mPaint);
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
