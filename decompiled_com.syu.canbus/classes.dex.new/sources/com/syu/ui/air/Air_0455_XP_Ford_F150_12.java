package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_XP_Ford_F150_12 extends AirBase {
    public Air_0455_XP_Ford_F150_12(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0022_XP1_Focus2012/air.webp";
        this.mPathHighlight = "0022_XP1_Focus2012/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(745.0f, 18.0f, 862.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(160.0f, 20.0f, 272.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(304.0f, 50.0f, 358.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(334.0f, 72.0f, 388.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(303.0f, 98.0f, 350.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(150.0f, 96.0f, 284.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(602.0f, 96.0f, 715.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(446.0f, 16.0f, 573.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(610.0f, 14.0f, 714.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(742.0f, 95.0f, 856.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(85.0f, 115.0f, 127.0f, 164.0f, Path.Direction.CW);
            this.srPath.addRect(970.0f, 118.0f, 1018.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(460.0f, 117.0f, (value * 16) + 460, 163.0f, Path.Direction.CW);
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
        int value2 = this.DATA[27];
        switch (value2) {
            case -3:
                c.drawText("HIGH", 60.0f, 92.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 60.0f, 92.0f, this.mPaint);
                break;
            default:
                if (this.DATA[37] != 0) {
                    c.drawText(new StringBuilder().append(value2 / 10).toString(), 60.0f, 92.0f, this.mPaint);
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 60.0f, 92.0f, this.mPaint);
                }
                break;
        }
        int value3 = this.DATA[28];
        switch (value3) {
            case -3:
                c.drawText("HIGH", 945.0f, 92.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 945.0f, 92.0f, this.mPaint);
                break;
            default:
                if (this.DATA[37] != 0) {
                    c.drawText(new StringBuilder().append(value3 / 10).toString(), 945.0f, 92.0f, this.mPaint);
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 945.0f, 92.0f, this.mPaint);
                }
                break;
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
