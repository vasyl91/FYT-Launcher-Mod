package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[37] != 0) {
            c.clipRect(661.0f, 60.0f, 772.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[35] == 0) {
            c.clipRect(1164.0f, 64.0f, 1252.0f, 119.0f, Region.Op.UNION);
        }
        int value = this.DATA[33];
        if (value == 1) {
            c.clipRect(877.0f, 67.0f, 900.0f, 112.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(877.0f, 67.0f, 913.0f, 112.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(877.0f, 67.0f, 924.0f, 112.0f, Region.Op.UNION);
        } else if (value == 4) {
            c.clipRect(877.0f, 67.0f, 935.0f, 112.0f, Region.Op.UNION);
        } else if (value == 5) {
            c.clipRect(877.0f, 67.0f, 948.0f, 112.0f, Region.Op.UNION);
        } else if (value == 6) {
            c.clipRect(877.0f, 67.0f, 961.0f, 112.0f, Region.Op.UNION);
        } else if (value == 7) {
            c.clipRect(877.0f, 67.0f, 973.0f, 112.0f, Region.Op.UNION);
        } else if (value == 8) {
            c.clipRect(877.0f, 67.0f, 984.0f, 112.0f, Region.Op.UNION);
        } else if (value == 9) {
            c.clipRect(877.0f, 67.0f, 997.0f, 112.0f, Region.Op.UNION);
        } else if (value == 10) {
            c.clipRect(877.0f, 67.0f, 1008.0f, 112.0f, Region.Op.UNION);
        } else if (value == 11) {
            c.clipRect(877.0f, 67.0f, 1020.0f, 112.0f, Region.Op.UNION);
        } else if (value >= 12) {
            c.clipRect(877.0f, 67.0f, 1036.0f, 112.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        this.mPaint.setColor(-16777216);
        this.mPaint.setAntiAlias(true);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 555.0f, 104.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 555.0f, 104.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 555.0f, 104.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f) + "℃", 550.0f, 104.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NO", 1375.0f, 104.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1375.0f, 104.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1375.0f, 104.0f, this.mPaint);
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
