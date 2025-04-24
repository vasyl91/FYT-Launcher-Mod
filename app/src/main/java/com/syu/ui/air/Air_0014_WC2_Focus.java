package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0014_WC2_Focus extends AirBase {
    public Air_0014_WC2_Focus(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0014_wc2_focus/air.webp";
        this.mPathHighlight = "0014_wc2_focus/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(175.0f, 16.0f, 290.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(160.0f, 98.0f, 296.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(338.0f, 30.0f, 414.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(377.0f, 86.0f, 429.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(350.0f, 104.0f, 393.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(500.0f, 16.0f, 653.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(690.0f, 12.0f, 844.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[4] == 0) {
            c.clipRect(704.0f, 93.0f, 857.0f, 160.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(514.0f, 91.0f, (value * 20) + ConstRzcAddData.U_CAR_SEAT_BELT_LEFT, 162.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = ToolkitMath.clamp(this.DATA[10], 0, 255);
        switch (value2) {
            case 254:
                c.drawText("LOW", 51.0f, 67.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 51.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value2 / 2.0f)), 51.0f, 67.0f, this.mPaint);
                break;
        }
        int value3 = ToolkitMath.clamp(this.DATA[11], 0, 255);
        switch (value3) {
            case 254:
                c.drawText("LOW", 945.0f, 67.0f, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", 945.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value3 / 2.0f)), 945.0f, 67.0f, this.mPaint);
                break;
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenWidth() / this.mContentWidth);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / this.mContentWidth, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
