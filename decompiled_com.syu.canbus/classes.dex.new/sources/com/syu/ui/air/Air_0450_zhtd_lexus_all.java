package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0450_zhtd_lexus_all extends AirBase {
    public Air_0450_zhtd_lexus_all(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 120;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0450_benz_air/air_zhtd_lexus_n.webp";
        this.mPathHighlight = "0450_benz_air/air_zhtd_lexus_p.webp";
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
            this.srPath.addRect(1025.0f, 15.0f, 1200.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(1042.0f, 67.0f, 1188.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(703.0f, 17.0f, 871.0f, 102.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(1404.0f, 26.0f, 1440.0f, 54.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(1440.0f, 39.0f, 1464.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(1404.0f, 57.0f, 1432.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(125.0f, 44.0f, 183.0f, 94.0f, Path.Direction.CW);
            this.srPath.addRect(1815.0f, 42.0f, 1875.0f, 94.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(397.0f, 28.0f, 423.0f, 107.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(397.0f, 28.0f, 440.0f, 107.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(397.0f, 28.0f, 455.0f, 107.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(397.0f, 28.0f, 472.0f, 107.0f, Path.Direction.CW);
        } else if (value == 5) {
            this.srPath.addRect(397.0f, 28.0f, 489.0f, 107.0f, Path.Direction.CW);
        } else if (value == 6) {
            this.srPath.addRect(397.0f, 28.0f, 504.0f, 107.0f, Path.Direction.CW);
        } else if (value == 7) {
            this.srPath.addRect(397.0f, 28.0f, 523.0f, 107.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 67.0f, 83.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 67.0f, 83.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 67.0f, 83.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder(String.valueOf(temp)).toString(), 67.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp / 2.0f)).toString(), 67.0f, 83.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 1760.0f, 83.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1760.0f, 83.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1760.0f, 83.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(new StringBuilder(String.valueOf(temp2)).toString(), 1760.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2 / 2.0f)).toString(), 1760.0f, 83.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(TheApp.getScreenWidth() / 1920.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
