package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0276_DJ_BYD_F6 extends AirBase {
    public Air_0276_DJ_BYD_F6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0276_dj_bydf6/air_0276_dj_bydf6_n.webp";
        this.mPathHighlight = "0276_dj_bydf6/air_0276_dj_bydf6_p.webp";
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
        if (this.DATA[62] != 0) {
            this.srPath.addRect(21.0f, 18.0f, 160.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(199.0f, 92.0f, 317.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(870.0f, 17.0f, 1003.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(703.0f, 15.0f, 840.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(208.0f, 11.0f, 309.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(381.0f, 14.0f, 456.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(390.0f, 84.0f, 447.0f, 111.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(377.0f, 106.0f, 421.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(698.0f, 98.0f, 849.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(535.0f, 65.0f, (value * 20) + 535, 122.0f, Path.Direction.CW);
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
        String str = "";
        int left_temp = this.DATA[27];
        switch (left_temp) {
            case 0:
                str = "-- --";
                break;
            case 1:
                str = "LO";
                break;
            case 15:
                str = "HI";
                break;
            default:
                if (left_temp > 1 && left_temp < 15) {
                    str = new StringBuilder().append(left_temp + 17).toString();
                }
                break;
        }
        c.drawText(str, 78.0f, 148.0f, this.mPaint);
        int right_temp = this.DATA[28];
        switch (right_temp) {
            case 0:
                str = "-- --";
                break;
            case 1:
                str = "LO";
                break;
            case 15:
                str = "HI";
                break;
            default:
                if (right_temp > 1 && right_temp < 15) {
                    str = new StringBuilder().append(right_temp + 17).toString();
                }
                break;
        }
        c.drawText(str, 925.0f, 148.0f, this.mPaint);
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
