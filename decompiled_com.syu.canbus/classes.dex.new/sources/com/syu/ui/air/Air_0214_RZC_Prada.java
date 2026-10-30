package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0214_RZC_Prada extends AirBase {
    public Air_0214_RZC_Prada(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0112_rzc_camry/air_rzc_camry.webp";
        this.mPathHighlight = "0112_rzc_camry/air_rzc_camry_p.webp";
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
            this.srPath.addRect(269.0f, 21.0f, 359.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0 || this.DATA[26] != 0) {
            this.srPath.addRect(265.0f, 97.0f, 359.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(20.0f, 15.0f, 104.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(493.0f, 19.0f, 566.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(488.0f, 80.0f, 541.0f, 100.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(484.0f, 103.0f, 523.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(905.0f, 26.0f, 1013.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(613.0f, 19.0f, 744.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[166] == 1) {
            this.srPath.addRect(268.0f, 134.0f, 295.0f, 157.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 2) {
            this.srPath.addRect(269.0f, 137.0f, 325.0f, 156.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 3) {
            this.srPath.addRect(269.0f, 133.0f, 354.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(83.0f, 117.0f, 122.0f, 154.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 115.0f, 1020.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(385.0f, 16.0f, 465.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(390.0f, 96.0f, 460.0f, 158.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(617.0f, 93.0f, (value * 19) + 617, 160.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(24.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 43.0f, 142.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 43.0f, 142.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 43.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 43.0f, 142.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 142.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 940.0f, 142.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 940.0f, 142.0f, this.mPaint);
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
