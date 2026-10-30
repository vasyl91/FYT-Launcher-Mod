package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0417_RZC_Benz_MLseries extends AirBase {
    public Air_0417_RZC_Benz_MLseries(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 768;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0417_rzc_benzmlseries/air_rzc_benz_mlseries.webp";
        this.mPathHighlight = "0417_rzc_benzmlseries/air_rzc_benz_mlseries_p.webp";
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
        int valueleft = this.DATA[29];
        if (valueleft >= 0 && valueleft <= 3) {
            this.srPath.addRect(42.0f, 44.0f, (valueleft * 14) + 42, 83.0f, Path.Direction.CW);
        }
        int valueright = this.DATA[30];
        if (valueright >= 0 && valueright <= 3) {
            this.srPath.addRect(681.0f, 46.0f, (valueright * 14) + 681, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(125.0f, 21.0f, 206.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(221.0f, 13.0f, 325.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(334.0f, 15.0f, 431.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(441.0f, 11.0f, 543.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(128.0f, 98.0f, 200.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(223.0f, 99.0f, 324.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(332.0f, 99.0f, 433.0f, 155.0f, Path.Direction.CW);
        }
        int valuelevel = this.DATA[21];
        if (valuelevel >= 0 && valuelevel <= 7) {
            this.srPath.addRect(465.0f, 89.0f, (valuelevel * 9) + 465, 166.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(547.0f, 36.0f, 601.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(550.0f, 78.0f, 611.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(550.0f, 94.0f, 589.0f, 129.0f, Path.Direction.CW);
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
        if (temp == -2) {
            c.drawText("LOW", 45.0f, 126.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 45.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 1.0f).toString(), 45.0f, 126.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 700.0f, 128.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 700.0f, 128.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 1.0f).toString(), 700.0f, 128.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / this.mContentWidth, TheApp.getScreenWidth() / this.mContentWidth);
        } else {
            canvas.scale(TheApp.getScreenWidth() / this.mContentWidth, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
