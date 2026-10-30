package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_RZC_Haval_H6_Top extends AirBase {
    public Air_0439_RZC_Haval_H6_Top(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_haval_h9/rzc_haval_h6.webp";
        this.mPathHighlight = "0439_oudi_haval_h9/rzc_haval_h6_p.webp";
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
            this.srPath.addRect(151.0f, 9.0f, 275.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(402.0f, 19.0f, 484.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(516.0f, 13.0f, 597.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(759.0f, 22.0f, 868.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(289.0f, 20.0f, 374.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(644.0f, 92.0f, 721.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(637.0f, 12.0f, 726.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(519.0f, 86.0f, 572.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(529.0f, 124.0f, 569.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(524.0f, 139.0f, 552.0f, 165.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(308.0f, 94.0f, (value * 20) + 308, 162.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(60.0f, 131.0f, (value2 * 14) + 60, 156.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(917.0f, 131.0f, (value3 * 14) + 917, 156.0f, Path.Direction.CW);
        int value4 = this.DATA[31];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(211.0f, 131.0f, (value4 * 14) + 211, 156.0f, Path.Direction.CW);
        int value5 = this.DATA[32];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(771.0f, 131.0f, (value5 * 14) + 771, 156.0f, Path.Direction.CW);
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
            c.drawText("NO", 58.0f, 55.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 58.0f, 55.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 58.0f, 55.0f, this.mPaint);
        } else {
            int temp2 = ((temp - 112) * 5) + 160;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 58.0f, 55.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 941.0f, 55.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 941.0f, 55.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 941.0f, 55.0f, this.mPaint);
        } else {
            int temp3 = ((temp1 - 112) * 5) + 160;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 941.0f, 55.0f, this.mPaint);
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
