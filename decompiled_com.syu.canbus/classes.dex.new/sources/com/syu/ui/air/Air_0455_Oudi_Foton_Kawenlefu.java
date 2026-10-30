package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_Oudi_Foton_Kawenlefu extends AirBase {
    public Air_0455_Oudi_Foton_Kawenlefu(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_beiqi_ec/air_oudi_foton_kawenlefu_n.webp";
        this.mPathHighlight = "0439_oudi_beiqi_ec/air_oudi_foton_kawenlefu_p.webp";
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
            this.srPath.addRect(859.0f, 26.0f, 1007.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(47.0f, 20.0f, 131.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(689.0f, 9.0f, 831.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[63] != 0) {
            this.srPath.addRect(199.0f, 17.0f, 332.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(695.0f, 105.0f, 825.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(222.0f, 94.0f, 315.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(383.0f, 21.0f, 460.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(391.0f, 83.0f, 443.0f, 107.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(385.0f, 105.0f, 423.0f, 140.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(530.0f, 64.0f, 530.0f + (value * 16.0f), 121.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 70.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 70.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(left_temp + 16)).toString(), 70.0f, 140.0f, this.mPaint);
        }
        int left_temp2 = this.DATA[28];
        if (left_temp2 == -2) {
            c.drawText("LO", 919.0f, 140.0f, this.mPaint);
        } else if (left_temp2 == -3) {
            c.drawText("HI", 919.0f, 140.0f, this.mPaint);
        } else if (left_temp2 == -1) {
            c.drawText("NO", 919.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(left_temp2 + 16)).toString(), 919.0f, 140.0f, this.mPaint);
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
