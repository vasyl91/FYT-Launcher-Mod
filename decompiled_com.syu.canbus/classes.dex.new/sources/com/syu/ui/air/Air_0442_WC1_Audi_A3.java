package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0442_WC1_Audi_A3 extends AirBase {
    public Air_0442_WC1_Audi_A3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0442_wc1_audi_a3/air_wc_audi_a3.webp";
        this.mPathHighlight = "0442_wc1_audi_a3/air_wc_audi_a3_p.webp";
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
        if (this.DATA[13] != 0) {
            this.srPath.addRect(400.0f, 104.0f, 504.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(519.0f, 98.0f, 633.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(656.0f, 23.0f, 745.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(406.0f, 25.0f, 495.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(650.0f, 116.0f, 746.0f, 155.0f, Path.Direction.CW);
        } else if (this.DATA[12] == 3) {
            this.srPath.addRect(660.0f, 91.0f, 738.0f, 116.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(282.0f, 15.0f, 382.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(282.0f, 94.0f, 368.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(543.0f, 25.0f, 613.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(172.0f, 91.0f, 218.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(182.0f, 123.0f, 211.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(170.0f, 135.0f, 196.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(801.0f, 93.0f, 846.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(808.0f, 123.0f, 840.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(800.0f, 136.0f, 825.0f, 158.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(197.0f, 50.0f, (value * 14) + 197, 71.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(785.0f, 49.0f, (value2 * 14) + 785, 69.0f, Path.Direction.CW);
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
        c.drawText(new StringBuilder().append(this.DATA[21]).toString(), 90.0f, 134.0f, this.mPaint);
        c.drawText(new StringBuilder().append(this.DATA[25]).toString(), 972.0f, 134.0f, this.mPaint);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 55.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 55.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 55.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 55.0f, 58.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 932.0f, 58.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 932.0f, 58.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 932.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 932.0f, 58.0f, this.mPaint);
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
