package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0444_WC2_Volvo_All extends AirBase {
    public Air_0444_WC2_Volvo_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0002_xp_dazhong/air_rzc_audi_q5.webp";
        this.mPathHighlight = "0002_xp_dazhong/air_rzc_audi_q5_p.webp";
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
            this.srPath.addRect(285.0f, 21.0f, 347.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(135.0f, 22.0f, 234.0f, 61.0f, Path.Direction.CW);
            this.srPath.addRect(817.0f, 143.0f, 867.0f, 162.0f, Path.Direction.CW);
            this.srPath.addRect(153.0f, 144.0f, 210.0f, 164.0f, Path.Direction.CW);
            this.srPath.addRect(797.0f, 22.0f, 893.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(163.0f, 86.0f, 195.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(162.0f, 110.0f, 191.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(154.0f, 121.0f, 177.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(820.0f, 86.0f, 855.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(820.0f, 110.0f, 851.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(811.0f, 121.0f, 837.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(406.0f, 114.0f, 515.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(434.0f, 89.0f, 488.0f, 114.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(400.0f, 22.0f, 530.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(565.0f, 18.0f, 631.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(563.0f, 95.0f, 629.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[62] == 0) {
            this.srPath.addRect(674.0f, 23.0f, 767.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(78.0f, 19.0f, 107.0f, 51.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 19.0f, 1006.0f, 50.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        this.mRectTmp.set(46.0f, 141.0f, (value * 17) + 46, 157.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(968 - (value2 * 17), 139.0f, 968.0f, 158.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
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
        int value3 = this.DATA[27];
        if (value3 == -2) {
            c.drawText("LO", 47.0f, 47.0f, this.mPaint);
        } else if (value3 == -3) {
            c.drawText("HI", 47.0f, 47.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value3 / 10.0f).toString(), 47.0f, 47.0f, this.mPaint);
        }
        int value4 = this.DATA[28];
        if (value4 == -2) {
            c.drawText("LO", 947.0f, 47.0f, this.mPaint);
        } else if (value4 == -3) {
            c.drawText("HI", 947.0f, 47.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value4 / 10.0f).toString(), 947.0f, 47.0f, this.mPaint);
        }
        int value5 = this.DATA[21];
        c.drawText(new StringBuilder(String.valueOf(value5)).toString(), 330.0f, 139.0f, this.mPaint);
        c.drawText(new StringBuilder(String.valueOf(value5)).toString(), 729.0f, 139.0f, this.mPaint);
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
