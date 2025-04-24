package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_RZC_LeTin_Mangguo extends AirBase {
    public Air_0452_RZC_LeTin_Mangguo(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_od_letin/air_od_letin_mangguo_n.webp";
        this.mPathHighlight = "0452_od_letin/air_od_letin_mangguo_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(910.0f, 51.0f, 997.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[103] != 0) {
            c.clipRect(758.0f, 58.0f, 855.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(460.0f, 15.0f, 535.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(486.0f, 82.0f, 534.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(459.0f, 102.0f, 500.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(298.0f, 49.0f, 435.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(8.0f, 22.0f, 138.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(165.0f, 43.0f, 278.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(596.0f, 60.0f, (value * 18) + 596, 128.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[20];
        if (value2 == -2) {
            c.drawText("LOW", 47.0f, 130.0f, this.mPaint);
        } else if (value2 == -3) {
            c.drawText("HIGH", 47.0f, 130.0f, this.mPaint);
        } else if (value2 >= 1 && value2 <= 29) {
            c.drawText(String.valueOf(((value2 * 5) + 175) / 10.0f), 47.0f, 130.0f, this.mPaint);
        } else {
            c.drawText("NONE", 47.0f, 130.0f, this.mPaint);
        }
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
