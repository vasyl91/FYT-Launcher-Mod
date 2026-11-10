package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.util.Log;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0211_OuDi_ChangChengH3 extends AirBase {
    public Air_0211_OuDi_ChangChengH3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0211_oudi_changchengh3/air_oudi_h3_n_proc.webp";
        this.mPathHighlight = "0211_oudi_changchengh3/air_oudi_h3_p_proc.webp";
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
        Log.d("c30", "U_AIR_AC" + this.DATA[11]);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(736.0f, 14.0f, 870.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(157.0f, 15.0f, 286.0f, 81.0f, Path.Direction.CW);
        }
        switch (this.DATA[19]) {
            case 0:
                this.srPath.addRect(462.0f, 66.0f, 523.0f, 105.0f, Path.Direction.CW);
                break;
            case 1:
                this.srPath.addRect(462.0f, 66.0f, 523.0f, 105.0f, Path.Direction.CW);
                this.srPath.addRect(449.0f, 108.0f, 505.0f, 152.0f, Path.Direction.CW);
                break;
            case 2:
                this.srPath.addRect(449.0f, 108.0f, 505.0f, 152.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(449.0f, 108.0f, 505.0f, 152.0f, Path.Direction.CW);
                this.srPath.addRect(452.0f, 10.0f, 541.0f, 67.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(315.0f, 94.0f, 427.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(154.0f, 95.0f, 285.0f, 155.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 5) {
            value = 5;
        }
        this.srPath.addRect(597.0f, 72.0f, (value * 25) + 597, 137.0f, Path.Direction.CW);
        if (this.DATA[13] != 0) {
            this.srPath.addRect(743.0f, 99.0f, 868.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(310.0f, 17.0f, 432.0f, 82.0f, Path.Direction.CW);
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
        int value2 = ToolkitMath.clamp(this.DATA[27], 0, 255);
        switch (value2) {
            case -3:
                c.drawText("HI", 55.0f, 105.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 55.0f, 105.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((float) (17.0d + (((double) value2) * 0.5d)))), 55.0f, 105.0f, this.mPaint);
                break;
        }
        int value3 = ToolkitMath.clamp(this.DATA[28], 0, 255);
        switch (value3) {
            case -3:
                c.drawText("HI", 941.0f, 105.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 941.0f, 105.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((float) (17.0d + (((double) value3) * 0.5d)))), 941.0f, 105.0f, this.mPaint);
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
