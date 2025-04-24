package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0051_RZC_Audi_Q5 extends AirBase {
    public Air_0051_RZC_Audi_Q5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0002_xp_dazhong/air_rzc_audi_q5.webp";
        this.mPathHighlight = "0002_xp_dazhong/air_rzc_audi_q5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[16] != 0) {
            c.clipRect(135.0f, 22.0f, 234.0f, 61.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(285.0f, 21.0f, 347.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(153.0f, 144.0f, 210.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(163.0f, 86.0f, 195.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(162.0f, 110.0f, 191.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(154.0f, 121.0f, 177.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[19] == 0) {
            c.clipRect(406.0f, 114.0f, 515.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(434.0f, 89.0f, 488.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(400.0f, 22.0f, 530.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(565.0f, 18.0f, 631.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(563.0f, 95.0f, 629.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(674.0f, 23.0f, 767.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[50] != 0) {
            c.clipRect(817.0f, 143.0f, 867.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(820.0f, 86.0f, 855.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(820.0f, 110.0f, 851.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(811.0f, 121.0f, 837.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(797.0f, 22.0f, 893.0f, 62.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(46, 141, (value * 17) + 46, 157);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = ToolkitMath.clamp(this.DATA[33], 0, 3);
        this.mRectTmp.set(968 - (value2 * 17), 139, 968, 158);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = ToolkitMath.clamp(this.DATA[27], 0, 255);
        if (value3 == 0) {
            c.drawText("LOW", 47.0f, 47.0f, this.mPaint);
        } else if (value3 == 254) {
            c.drawText("HIGH", 47.0f, 47.0f, this.mPaint);
        } else if (value3 >= 30 && value3 <= 64) {
            c.drawText(String.valueOf(value3 / 2.0f), 47.0f, 47.0f, this.mPaint);
        } else {
            c.drawText("NONE", 47.0f, 47.0f, this.mPaint);
        }
        int value4 = ToolkitMath.clamp(this.DATA[28], 0, 255);
        if (value4 == 0) {
            c.drawText("LOW", 947.0f, 47.0f, this.mPaint);
        } else if (value4 == 254) {
            c.drawText("HIGH", 947.0f, 47.0f, this.mPaint);
        } else if (value4 >= 30 && value4 <= 64) {
            c.drawText(String.valueOf(value4 / 2.0f), 947.0f, 47.0f, this.mPaint);
        } else {
            c.drawText("NONE", 947.0f, 47.0f, this.mPaint);
        }
        int value5 = this.DATA[26];
        c.drawText(String.valueOf(value5), 330.0f, 139.0f, this.mPaint);
        int value6 = this.DATA[51];
        c.drawText(String.valueOf(value6), 729.0f, 139.0f, this.mPaint);
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
