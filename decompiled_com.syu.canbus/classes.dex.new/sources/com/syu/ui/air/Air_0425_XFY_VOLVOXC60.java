package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0425_XFY_VOLVOXC60 extends AirBase {
    public Air_0425_XFY_VOLVOXC60(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0425_xfy_volvoxc60/xc60_air.webp";
        this.mPathHighlight = "0425_xfy_volvoxc60/xc60_air_p.webp";
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
            this.srPath.addRect(717.0f, 104.0f, 823.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(227.0f, 106.0f, 323.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(722.0f, 11.0f, 821.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(564.0f, 47.0f, 621.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(201.0f, 14.0f, 345.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(570.0f, 79.0f, 629.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(560.0f, 97.0f, 606.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(127.0f, 117.0f, 169.0f, 161.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 117.0f, 1015.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(80.0f, 51.0f, (value * 20) + 80, 75.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(891.0f, 51.0f, (value2 * 20) + 891, 75.0f, Path.Direction.CW);
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
        int value3 = this.DATA[21];
        if (value3 == 31) {
            c.drawText("AUTO", 490.0f, 100.0f, this.mPaint);
        } else if (value3 >= 0 && value3 <= 18) {
            c.drawText(new StringBuilder(String.valueOf(value3)).toString(), 490.0f, 100.0f, this.mPaint);
        } else {
            c.drawText("ERROR", 490.0f, 100.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == 16) {
            c.drawText("LOW", 70.0f, 135.0f, this.mPaint);
        } else if (temp == 80) {
            c.drawText("HI", 70.0f, 135.0f, this.mPaint);
        } else if (this.DATA[37] == 0) {
            c.drawText(new StringBuilder(String.valueOf(temp / 2.0f)).toString(), 70.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp + 28)).toString(), 70.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == 16) {
            c.drawText("LOW", 914.0f, 135.0f, this.mPaint);
        } else if (temp2 == 80) {
            c.drawText("HI", 914.0f, 135.0f, this.mPaint);
        } else if (this.DATA[37] == 0) {
            c.drawText(new StringBuilder(String.valueOf(temp2 / 2.0f)).toString(), 914.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2 + 28)).toString(), 914.0f, 135.0f, this.mPaint);
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
