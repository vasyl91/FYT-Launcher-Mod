package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_RZC_BisuT5 extends AirBase {
    public Air_0452_RZC_BisuT5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_rzc_bisu_t5/air.webp";
        this.mPathHighlight = "0452_rzc_bisu_t5/air_p.webp";
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
            this.srPath.addRect(454.0f, 28.0f, 544.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(123.0f, 93.0f, 248.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(846.0f, 28.0f, 968.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(565.0f, 31.0f, 647.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(141.0f, 15.0f, 239.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(323.0f, 34.0f, 386.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(311.0f, 14.0f, 389.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(321.0f, 100.0f, 386.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(21.0f, 99.0f, 83.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(698.0f, 97.0f, 746.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(704.0f, 125.0f, 738.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(702.0f, 137.0f, 726.0f, 160.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        }
        this.srPath.addRect(489.0f, 100.0f, (value * 20) + 489, 159.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        }
        this.srPath.addRect(892.0f, 123.0f, (value2 * 20) + 892, 157.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        if (temp == 0) {
            c.drawText("", 42.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.5d + ((double) (temp / 2.0f))).toString(), 42.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == 0) {
            c.drawText("", 711.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.5d + ((double) (temp2 / 2.0f))).toString(), 711.0f, 64.0f, this.mPaint);
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
