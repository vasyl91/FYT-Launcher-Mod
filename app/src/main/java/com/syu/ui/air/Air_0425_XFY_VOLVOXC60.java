package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0425_XFY_VOLVOXC60 extends AirBase {
    public Air_0425_XFY_VOLVOXC60(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "00425_xfy_volvoxc60/xc60_air.webp";
        this.mPathHighlight = "00425_xfy_volvoxc60/xc60_air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[24] != 0) {
            c.clipRect(717.0f, 104.0f, 823.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[58] != 0) {
            c.clipRect(227.0f, 106.0f, 323.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(722.0f, 11.0f, 821.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(564.0f, 47.0f, 621.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(717.0f, 104.0f, 823.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(201.0f, 14.0f, 345.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(570.0f, 79.0f, 629.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(560.0f, 97.0f, 606.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[57] != 0) {
            c.clipRect(127.0f, 117.0f, 169.0f, 161.0f, Region.Op.UNION);
            c.clipRect(978.0f, 117.0f, 1015.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(80.0f, 51.0f, (value * 20) + 80, 75.0f, Region.Op.UNION);
        int value2 = this.DATA[23];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(891.0f, 51.0f, (value2 * 20) + 891, 75.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int value3 = this.DATA[12];
        if (value3 == 31) {
            c.drawText("AUTO", 490.0f, 100.0f, this.mPaint);
        } else if (value3 >= 0 && value3 <= 18) {
            c.drawText(String.valueOf(value3), 490.0f, 100.0f, this.mPaint);
        } else {
            c.drawText("ERROR", 490.0f, 100.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[11];
        if (temp == 16) {
            c.drawText("LOW", 70.0f, 135.0f, this.mPaint);
        } else if (temp == 80) {
            c.drawText("HI", 70.0f, 135.0f, this.mPaint);
        } else if (this.DATA[57] == 0) {
            c.drawText(String.valueOf(temp / 2.0f), 70.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp + 28), 70.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == 16) {
            c.drawText("LOW", 914.0f, 135.0f, this.mPaint);
        } else if (temp2 == 80) {
            c.drawText("HI", 914.0f, 135.0f, this.mPaint);
        } else if (this.DATA[57] == 0) {
            c.drawText(String.valueOf(temp2 / 2.0f), 914.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 + 28), 914.0f, 135.0f, this.mPaint);
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
