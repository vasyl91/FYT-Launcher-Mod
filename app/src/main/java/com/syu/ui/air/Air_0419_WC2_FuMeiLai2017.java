package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0419_WC2_FuMeiLai2017 extends AirBase {
    public Air_0419_WC2_FuMeiLai2017(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0419_wc2_guochan2/air_wc2_fumeilai.webp";
        this.mPathHighlight = "0419_wc2_guochan2/air_wc2_fumeilai_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(859.0f, 16.0f, 1005.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(881.0f, 100.0f, 984.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(206.0f, 101.0f, 314.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(535.0f, 20.0f, 609.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(42.0f, 15.0f, 121.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(382.0f, 15.0f, 466.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(385.0f, 95.0f, 469.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(532.0f, 77.0f, 596.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(531.0f, 108.0f, 578.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(186.0f, 15.0f, 327.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value > 8) {
            value = 8;
        }
        c.clipRect(682.0f, 66.0f, (value * 20) + 682, 141.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[21];
        if (left_temp == -2) {
            c.drawText("LOW", 70.0f, 142.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 70.0f, 142.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 70.0f, 142.0f, this.mPaint);
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
