package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_OD_Foton_Tunland extends AirBase {
    public Air_0439_OD_Foton_Tunland(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_foton_tunland/air_od_foton_tunland_n.webp";
        this.mPathHighlight = "0439_oudi_foton_tunland/air_od_foton_tunland_p.webp";
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
            this.srPath.addRect(878.0f, 104.0f, 1006.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(45.0f, 106.0f, 120.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(380.0f, 86.0f, 431.0f, 109.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(345.0f, 34.0f, 416.0f, 89.0f, Path.Direction.CW);
            this.srPath.addRect(506.0f, 41.0f, 632.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(354.0f, 106.0f, 392.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(172.0f, 50.0f, 297.0f, 118.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(680.0f, 52.0f, (value * 20) + 680, 134.0f, Path.Direction.CW);
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
            c.drawText("NO", 60.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 170;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 60.0f, 60.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else {
            int temp4 = (temp3 * 5) + 170;
            c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10), 920.0f, 60.0f, this.mPaint);
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
