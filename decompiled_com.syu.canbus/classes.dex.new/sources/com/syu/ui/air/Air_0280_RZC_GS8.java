package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0280_RZC_GS8 extends AirBase {
    public Air_0280_RZC_GS8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        if (DataCanbus.DATA[1000] == 459032) {
            this.mPathNormal = "0280_rzc_xp1_chuangqigs4/rzc_gs3_air.webp";
            this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/rzc_gs3_air_p.webp";
        } else {
            this.mPathNormal = "0280_rzc_xp1_chuangqigs4/rzc_gs8_air.webp";
            this.mPathHighlight = "0280_rzc_xp1_chuangqigs4/rzc_gs8_air_p.webp";
        }
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
            this.srPath.addRect(304.0f, 32.0f, 434.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(603.0f, 30.0f, 713.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(743.0f, 26.0f, 874.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[57] != 0) {
            this.srPath.addRect(743.0f, 26.0f, 874.0f, 83.0f, Path.Direction.CW);
        }
        if (DataCanbus.DATA[1000] == 459032) {
            if (this.DATA[58] != 0) {
                this.srPath.addRect(452.0f, 31.0f, 572.0f, 85.0f, Path.Direction.CW);
            }
        } else if (this.DATA[38] != 0) {
            this.srPath.addRect(452.0f, 31.0f, 572.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(650.0f, 249.0f, 699.0f, 288.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(667.0f, 225.0f, 726.0f, 255.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(453.0f, 224.0f, 566.0f, 271.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(192.0f, 110.0f, 325.0f, 193.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(364.0f, 108.0f, 504.0f, 194.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(725.0f, 104.0f, 777.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(730.0f, 145.0f, 778.0f, 167.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(722.0f, 165.0f, 761.0f, 196.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(866.0f, 110.0f, 1013.0f, 186.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 60.0f, 66.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 100.0f).toString(), 60.0f, 66.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 936.0f, 66.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 936.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 100.0f).toString(), 936.0f, 66.0f, this.mPaint);
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == -2) {
            c.drawText("LOW", 291.0f, 256.0f, this.mPaint);
        } else if (rear_temp == -3) {
            c.drawText("HI", 291.0f, 256.0f, this.mPaint);
        } else if (rear_temp == -1) {
            c.drawText("NO", 291.0f, 256.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(rear_temp / 100.0f).toString(), 291.0f, 256.0f, this.mPaint);
        }
        int wind = this.DATA[21];
        c.drawText(new StringBuilder(String.valueOf(wind)).toString(), 608.0f, 156.0f, this.mPaint);
        int rearwind = this.DATA[44];
        c.drawText(new StringBuilder(String.valueOf(rearwind)).toString(), 924.0f, 256.0f, this.mPaint);
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
