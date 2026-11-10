package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_Bagoo_Vinfast_All extends AirBase {
    public Air_0455_Bagoo_Vinfast_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 94;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_benz_all/air_bagoo_vinfast_n.webp";
        this.mPathHighlight = "0439_rzc_benz_all/air_bagoo_vinfast_p.webp";
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
            this.srPath.addRect(193.0f, 10.0f, 246.0f, 38.0f, Path.Direction.CW);
        }
        if (this.DATA[34] != 0) {
            this.srPath.addRect(336.0f, 21.0f, 423.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(472.0f, 20.0f, 544.0f, 56.0f, Path.Direction.CW);
        }
        if (this.DATA[80] != 0) {
            this.srPath.addRect(486.0f, 57.0f, 541.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(604.0f, 18.0f, 658.0f, 49.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(605.0f, 50.0f, 657.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(815.0f, 16.0f, 878.0f, 49.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(811.0f, 49.0f, 886.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(712.0f, 12.0f, 748.0f, 39.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(713.0f, 41.0f, 748.0f, 51.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(705.0f, 52.0f, 722.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[21] == 1) {
            this.srPath.addRect(160.0f, 37.0f, 178.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 2) {
            this.srPath.addRect(160.0f, 37.0f, 193.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 3) {
            this.srPath.addRect(160.0f, 37.0f, 209.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 4) {
            this.srPath.addRect(160.0f, 37.0f, 224.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 5) {
            this.srPath.addRect(160.0f, 37.0f, 240.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 6) {
            this.srPath.addRect(160.0f, 37.0f, 255.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 7) {
            this.srPath.addRect(160.0f, 37.0f, 270.0f, 86.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 8) {
            this.srPath.addRect(160.0f, 37.0f, 292.0f, 86.0f, Path.Direction.CW);
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
        int value = this.DATA[27];
        if (value == -2) {
            c.drawText("LO", 59.0f, 55.0f, this.mPaint);
        } else if (value == -3) {
            c.drawText("HI", 59.0f, 55.0f, this.mPaint);
        } else if (value == -1) {
            c.drawText("NO", 59.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value / 10.0f).toString(), 37.0f, 55.0f, this.mPaint);
        }
        int value2 = this.DATA[28];
        if (value2 == -2) {
            c.drawText("LO", 965.0f, 55.0f, this.mPaint);
        } else if (value2 == -3) {
            c.drawText("HI", 965.0f, 55.0f, this.mPaint);
        } else if (value2 == -1) {
            c.drawText("NO", 965.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value2 / 10.0f).toString(), 955.0f, 55.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
