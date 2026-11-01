package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_OD_Opel_Adan extends AirBase {
    public Air_0439_OD_Opel_Adan(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0151_daojun_xp1_byds6/ansheng_byd_yuan.webp";
        this.mPathHighlight = "0151_daojun_xp1_byds6/ansheng_byd_yuan_p.webp";
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
        if (this.DATA[21] != 0) {
            this.srPath.addRect(18.0f, 21.0f, 159.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(218.0f, 100.0f, 307.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(380.0f, 91.0f, 420.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(389.0f, 68.0f, 445.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(381.0f, 8.0f, 456.0f, 59.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(722.0f, 18.0f, 827.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(208.0f, 12.0f, 314.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(711.0f, 98.0f, 842.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(884.0f, 22.0f, 995.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(539.0f, 61.0f, (value * 20) + 539, 124.0f, Path.Direction.CW);
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
        switch (temp) {
            case -3:
                c.drawText("HI", 70.0f, 132.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 70.0f, 132.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 70.0f, 132.0f, this.mPaint);
                break;
            default:
                c.drawText(new StringBuilder().append(((temp * 5) + 170) / 10.0f).toString(), 70.0f, 132.0f, this.mPaint);
                break;
        }
        int temp2 = this.DATA[28];
        switch (temp2) {
            case -3:
                c.drawText("HI", 920.0f, 132.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 920.0f, 132.0f, this.mPaint);
                break;
            default:
                c.drawText(new StringBuilder().append(((temp2 * 5) + 170) / 10.0f).toString(), 920.0f, 132.0f, this.mPaint);
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
