package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0443_WC2_KangDI extends AirBase {
    public Air_0443_WC2_KangDI(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0433_wc2_kangdi/air_0433_Kangdi.webp";
        this.mPathHighlight = "0433_wc2_kangdi/air_0433_Kangdi_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(865.0f, 25.0f, 1007.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 0) {
            c.clipRect(187.0f, 92.0f, 334.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(38.0f, 22.0f, 127.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(875.0f, 100.0f, 991.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(200.0f, 14.0f, 301.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(404.0f, 18.0f, 480.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(401.0f, 81.0f, 468.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(401.0f, 111.0f, 442.0f, 149.0f, Region.Op.UNION);
        }
        int value = this.DATA[31];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(636.0f, 40.0f, (value * 19) + 636, 120.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[19];
        if (temp == -2) {
            c.drawText("LOW", 87.0f, 134.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 87.0f, 134.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 87.0f, 134.0f, this.mPaint);
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
