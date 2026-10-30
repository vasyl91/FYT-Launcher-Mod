package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0006_RZC1_BydF3 extends AirBase {
    public Air_0006_RZC1_BydF3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0006_rzc1_bydf3/air_rzc1_bydf3.webp";
        this.mPathHighlight = "0006_rzc1_bydf3/air_rzc1_bydf3_p.webp";
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
        if (this.DATA[12] == 0) {
            this.srPath.addRect(400.0f, 28.0f, 497.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(500.0f, 40.0f, 600.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(704.0f, 25.0f, 793.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(718.0f, 100.0f, 795.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(899.0f, 33.0f, 965.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(242.0f, 66.0f, 276.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(217.0f, 84.0f, 243.0f, 111.0f, Path.Direction.CW);
        }
        if (this.DATA[55] != 0) {
            this.srPath.addRect(887.0f, 110.0f, 987.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(43.0f, 107.0f, 134.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 0) {
            this.srPath.addRect(119.0f, 31.0f, 163.0f, 78.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(383.0f, 132.0f, (value * 35) + 383, 150.0f, Path.Direction.CW);
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
            c.drawText("NO", 67.0f, 62.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 67.0f, 62.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 67.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 67.0f, 62.0f, this.mPaint);
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
