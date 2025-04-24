package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0276_DJ_BYD_F6 extends AirBase {
    public Air_0276_DJ_BYD_F6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0276_dj_bydf6/air_0276_dj_bydf6_n.webp";
        this.mPathHighlight = "0276_dj_bydf6/air_0276_dj_bydf6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[25] != 0) {
            c.clipRect(21.0f, 18.0f, 160.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(199.0f, 92.0f, 317.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(870.0f, 17.0f, 1003.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(703.0f, 15.0f, 840.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(208.0f, 11.0f, 309.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(381.0f, 14.0f, 456.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(390.0f, 84.0f, 447.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(377.0f, 106.0f, 421.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[18] == 0) {
            c.clipRect(698.0f, 98.0f, 849.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        c.clipRect(535.0f, 65.0f, (value * 20) + 535, 122.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        String str = "";
        int left_temp = this.DATA[11];
        switch (left_temp) {
            case 0:
                str = "-- --";
                break;
            case 1:
                str = "LO";
                break;
            case 15:
                str = "HI";
                break;
            default:
                if (left_temp > 1 && left_temp < 15) {
                    str = String.valueOf(left_temp + 17);
                    break;
                }
        }
        c.drawText(str, 78.0f, 148.0f, this.mPaint);
        int right_temp = this.DATA[21];
        switch (right_temp) {
            case 0:
                str = "-- --";
                break;
            case 1:
                str = "LO";
                break;
            case 15:
                str = "HI";
                break;
            default:
                if (right_temp > 1 && right_temp < 15) {
                    str = String.valueOf(right_temp + 17);
                    break;
                }
        }
        c.drawText(str, 925.0f, 148.0f, this.mPaint);
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
