package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0025_DJ_ParkAvenue extends AirBase {
    public Air_0025_DJ_ParkAvenue(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0025_dj_parkavenue/dj_parkavenue.webp";
        this.mPathHighlight = "0025_dj_parkavenue/dj_parkavenue_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[125] != 0) {
            c.clipRect(796.0f, 51.0f, 1010.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[128] != 0) {
            c.clipRect(309.0f, 50.0f, 477.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[127] != 0) {
            c.clipRect(584.0f, 69.0f, 643.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[126] != 0) {
            c.clipRect(570.0f, 98.0f, 616.0f, 135.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[129];
        switch (value) {
            case 0:
                c.drawText("LOW", 109.0f, 82.0f, this.mPaint);
                break;
            case 31:
                c.drawText("HIGH", 109.0f, 82.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value / 10.0f)), 109.0f, 82.0f, this.mPaint);
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
