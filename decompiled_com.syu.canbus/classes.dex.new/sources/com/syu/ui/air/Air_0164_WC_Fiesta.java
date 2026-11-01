package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0164_WC_Fiesta extends AirBase {
    public Air_0164_WC_Fiesta(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0174_xp_mengdiou/xp_mengdiou.webp";
        this.mPathHighlight = "0174_xp_mengdiou/xp_mengdiou_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(152.0f, 24.0f, 288.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(748.0f, 10.0f, 873.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(4.0f, 93.0f, 143.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(909.0f, 93.0f, 988.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(458.0f, 18.0f, 555.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(471.0f, 88.0f, 536.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(458.0f, 110.0f, 506.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(299.0f, 62.0f, 432.0f, 129.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(613.0f, 77.0f, (value * 15) + 613, 137.0f, Path.Direction.CW);
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
                str = "HI";
                break;
            case -2:
                str = "LO";
                break;
            case -1:
                str = "NO";
                break;
            default:
                str = new StringBuilder(String.valueOf(value2 / 2.0f)).toString();
                break;
        }
        c.drawText(str, 60.0f, 60.0f, this.mPaint);
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                str2 = "HI";
                break;
            case -2:
                str2 = "LO";
                break;
            case -1:
                str2 = "NO";
                break;
            default:
                str2 = new StringBuilder(String.valueOf(value3 / 2.0f)).toString();
                break;
        }
        c.drawText(str2, 940.0f, 60.0f, this.mPaint);
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
