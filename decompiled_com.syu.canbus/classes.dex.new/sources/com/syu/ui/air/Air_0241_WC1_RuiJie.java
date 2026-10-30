package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0241_WC1_RuiJie extends AirBase {
    public Air_0241_WC1_RuiJie(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0241_wc1_ruijie/air_wc1_ford_ruijie_n.webp";
        this.mPathHighlight = "0241_wc1_ruijie/air_wc1_ford_ruijie_p.webp";
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
            this.srPath.addRect(273.0f, 105.0f, 368.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(659.0f, 108.0f, 743.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(271.0f, 25.0f, 375.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(13.0f, 25.0f, 123.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(403.0f, 19.0f, 491.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(399.0f, 94.0f, 489.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(655.0f, 22.0f, 751.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(534.0f, 7.0f, 583.0f, 40.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(909.0f, 17.0f, 1007.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(561.0f, 42.0f, 602.0f, 55.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(541.0f, 56.0f, 575.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(85.0f, 110.0f, 127.0f, 160.0f, Path.Direction.CW);
            this.srPath.addRect(971.0f, 107.0f, 1013.0f, 161.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(530.0f, 120.0f, (value * 14) + 530, 161.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        this.srPath.addRect(195.0f, 135.0f, 195.0f + (value2 * 23.0f), 156.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        this.srPath.addRect(834.0f - (value3 * 23.0f), 135.0f, 834.0f, 156.0f, Path.Direction.CW);
        int value4 = this.DATA[31];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 2) {
            value4 = 2;
        }
        this.srPath.addRect(196.0f, 57.0f, 196.0f + (value4 * 23.0f), 78.0f, Path.Direction.CW);
        int value5 = this.DATA[32];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 2) {
            value5 = 2;
        }
        this.srPath.addRect(833.0f - (value5 * 23.0f), 58.0f, 833.0f, 79.0f, Path.Direction.CW);
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
            c.drawText("NO", 52.0f, 137.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 52.0f, 137.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 52.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 52.0f, 137.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 940.0f, 137.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 137.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 137.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 940.0f, 137.0f, this.mPaint);
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
