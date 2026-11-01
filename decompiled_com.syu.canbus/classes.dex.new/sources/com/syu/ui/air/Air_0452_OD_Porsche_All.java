package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_OD_Porsche_All extends AirBase {
    public Air_0452_OD_Porsche_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_od_porsche/od_porsche.webp";
        this.mPathHighlight = "0452_od_porsche/od_porsche_p.webp";
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
            this.srPath.addRect(303.0f, 22.0f, 433.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(602.0f, 10.0f, 717.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(184.0f, 28.0f, 269.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(5.0f, 20.0f, 137.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(896.0f, 23.0f, 1007.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(733.0f, 15.0f, 873.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(795.0f, 20.0f, 869.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(752.0f, 93.0f, 855.0f, 165.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(466.0f, 18.0f, 555.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(309.0f, 97.0f, 418.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(159.0f, 97.0f, 285.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(480.0f, 84.0f, 532.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(458.0f, 107.0f, 521.0f, 144.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(613.0f, 91.0f, (value * 17) + 613, 161.0f, Path.Direction.CW);
        int unit = this.DATA[37];
        if (unit == 1) {
            this.srPath.addRect(98.0f, 111.0f, 134.0f, 154.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 120.0f, 1014.0f, 157.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (temp == 0) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf((temp + 59) / 1.0f)).toString(), 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(((temp * 5) + 155) / 10.0f)).toString(), 65.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == 0) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf((temp2 + 59) / 1.0f)).toString(), 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(((temp2 * 5) + 155) / 10.0f)).toString(), 930.0f, 140.0f, this.mPaint);
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
