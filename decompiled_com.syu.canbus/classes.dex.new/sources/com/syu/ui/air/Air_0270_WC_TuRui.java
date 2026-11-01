package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0270_WC_TuRui extends AirBase {
    public Air_0270_WC_TuRui(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0270_wc_turui/turui.webp";
        this.mPathHighlight = "0270_wc_turui/turui_p.webp";
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
        if (this.DATA[49] != 0) {
            this.srPath.addRect(177.0f, 50.0f, 288.0f, 95.0f, Path.Direction.CW);
            switch (this.DATA[13]) {
                case 1:
                    this.srPath.addRect(202.0f, 105.0f, 243.0f, 129.0f, Path.Direction.CW);
                    break;
                case 2:
                    this.srPath.addRect(199.0f, 106.0f, 267.0f, 130.0f, Path.Direction.CW);
                    break;
                default:
                    this.srPath.addRect(201.0f, 108.0f, 223.0f, 128.0f, Path.Direction.CW);
                    break;
            }
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(701.0f, 27.0f, 845.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(337.0f, 14.0f, 423.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(347.0f, 85.0f, 407.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(339.0f, 110.0f, 384.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[36] != 0) {
            this.srPath.addRect(483.0f, 33.0f, 657.0f, 136.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(703.0f, 103.0f, (value * 20) + 703, 166.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 >= 0 && value2 > 3) {
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
        int temp = this.DATA[27] & 255;
        if (temp == 254) {
            c.drawText("LOW", 64.0f, 80.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 64.0f, 80.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 64.0f, 80.0f, this.mPaint);
        }
        int temp2 = this.DATA[28] & 255;
        if (temp2 == 254) {
            c.drawText("LOW", 927.0f, 80.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 927.0f, 80.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 927.0f, 80.0f, this.mPaint);
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
