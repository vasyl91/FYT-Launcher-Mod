package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0450_cm_bmw_all extends AirBase {
    public Air_0450_cm_bmw_all(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 182;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0450_benz_air/air_cm_bmw_n.webp";
        this.mPathHighlight = "0450_benz_air/air_cm_bmw_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(661.0f, 60.0f, 772.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(1164.0f, 64.0f, 1252.0f, 119.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(877.0f, 67.0f, 900.0f, 112.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(877.0f, 67.0f, 913.0f, 112.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(877.0f, 67.0f, 924.0f, 112.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(877.0f, 67.0f, 935.0f, 112.0f, Path.Direction.CW);
        } else if (value == 5) {
            this.srPath.addRect(877.0f, 67.0f, 948.0f, 112.0f, Path.Direction.CW);
        } else if (value == 6) {
            this.srPath.addRect(877.0f, 67.0f, 961.0f, 112.0f, Path.Direction.CW);
        } else if (value == 7) {
            this.srPath.addRect(877.0f, 67.0f, 973.0f, 112.0f, Path.Direction.CW);
        } else if (value == 8) {
            this.srPath.addRect(877.0f, 67.0f, 984.0f, 112.0f, Path.Direction.CW);
        } else if (value == 9) {
            this.srPath.addRect(877.0f, 67.0f, 997.0f, 112.0f, Path.Direction.CW);
        } else if (value == 10) {
            this.srPath.addRect(877.0f, 67.0f, 1008.0f, 112.0f, Path.Direction.CW);
        } else if (value == 11) {
            this.srPath.addRect(877.0f, 67.0f, 1020.0f, 112.0f, Path.Direction.CW);
        } else if (value >= 12) {
            this.srPath.addRect(877.0f, 67.0f, 1036.0f, 112.0f, Path.Direction.CW);
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
        this.mPaint.setColor(-16777216);
        this.mPaint.setAntiAlias(true);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 555.0f, 104.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 555.0f, 104.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 555.0f, 104.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.valueOf(((temp * 9) / 10) + 32) + "℉", 550.0f, 104.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f) + "℃", 550.0f, 104.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 1375.0f, 104.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1375.0f, 104.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1375.0f, 104.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.valueOf(((temp2 * 9) / 10) + 32) + "℉", 1370.0f, 104.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f) + "℃", 1370.0f, 104.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(1.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
