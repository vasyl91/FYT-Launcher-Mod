package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0352_WC2_RENAULT_KaBin extends AirBase {
    public Air_0352_WC2_RENAULT_KaBin(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0352_wc2_renault_kabin/renault.webp";
        this.mPathHighlight = "0352_wc2_renault_kabin/renault_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(181.0f, 20.0f, 262.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(597.0f, 26.0f, 715.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(745.0f, 99.0f, 863.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(753.0f, 26.0f, 852.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(640.0f, 90.0f, 678.0f, 116.0f, Region.Op.UNION);
            c.clipRect(321.0f, 93.0f, 412.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(317.0f, 9.0f, 409.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(608.0f, 91.0f, 639.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(621.0f, 114.0f, 649.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(617.0f, 125.0f, 638.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(628.0f, 145.0f, 688.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[52] != 0) {
            c.clipRect(463.0f, 16.0f, 567.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[70] != 0) {
            c.clipRect(169.0f, 103.0f, 271.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[71] != 0) {
            c.clipRect(22.0f, 103.0f, 125.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(892.0f, 98.0f, 1011.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(464.0f, 91.0f, (value * 13) + 464, 154.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(18.0f);
        if (this.DATA[36] != 0) {
            c.drawText("Auto", 758.0f, 26.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 53.0f, 66.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 53.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 53.0f, 66.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 66.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 930.0f, 66.0f, this.mPaint);
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
