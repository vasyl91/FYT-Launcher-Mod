package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

public class Air_0211_OuDi_ChangChengH3 extends AirBase {
    public Air_0211_OuDi_ChangChengH3(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0211_oudi_changchengh3/air_oudi_h3_n_proc.webp";
        this.mPathHighlight = "0211_oudi_changchengh3/air_oudi_h3_p_proc.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        Log.d("c30", "U_AIR_AC" + this.DATA[3]);
        if (this.DATA[7] != 0) {
            c.clipRect(736.0f, 14.0f, 870.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(157.0f, 15.0f, 286.0f, 81.0f, Region.Op.UNION);
        }
        switch (this.DATA[5]) {
            case 0:
                c.clipRect(462.0f, 66.0f, 523.0f, 105.0f, Region.Op.UNION);
                break;
            case 1:
                c.clipRect(462.0f, 66.0f, 523.0f, 105.0f, Region.Op.UNION);
                c.clipRect(449.0f, 108.0f, 505.0f, 152.0f, Region.Op.UNION);
                break;
            case 2:
                c.clipRect(449.0f, 108.0f, 505.0f, 152.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(449.0f, 108.0f, 505.0f, 152.0f, Region.Op.UNION);
                c.clipRect(452.0f, 10.0f, 541.0f, 67.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[2] != 0) {
            c.clipRect(315.0f, 94.0f, 427.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(154.0f, 95.0f, 285.0f, 155.0f, Region.Op.UNION);
        }
        int value = this.DATA[6];
        if (value < 0) {
            value = 0;
        } else if (value > 5) {
            value = 5;
        }
        c.clipRect(597.0f, 72.0f, (value * 25) + 597, 137.0f, Region.Op.UNION);
        if (this.DATA[8] != 0) {
            c.clipRect(743.0f, 99.0f, 868.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(310.0f, 17.0f, 432.0f, 82.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = ToolkitMath.clamp(this.DATA[4], 0, 255);
        Log.d("c30", "U_AIR_TEMP_LEFT" + value2);
        switch (value2) {
            case 0:
                c.drawText("LOW", 55.0f, 105.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 55.0f, 105.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((float) (17.0d + (value2 * 0.5d)))), 55.0f, 105.0f, this.mPaint);
                break;
        }
        int value3 = ToolkitMath.clamp(this.DATA[10], 0, 255);
        switch (value3) {
            case 0:
                c.drawText("LOW", 941.0f, 105.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 941.0f, 105.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((float) (17.0d + (value3 * 0.5d)))), 941.0f, 105.0f, this.mPaint);
                break;
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
