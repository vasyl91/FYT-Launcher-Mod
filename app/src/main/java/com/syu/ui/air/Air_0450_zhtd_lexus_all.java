package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0450_zhtd_lexus_all extends AirBase {
    public Air_0450_zhtd_lexus_all(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 120;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0450_benz_air/air_zhtd_lexus_n.webp";
        this.mPathHighlight = "0450_benz_air/air_zhtd_lexus_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[37] != 0) {
            c.clipRect(1025.0f, 15.0f, 1200.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(1042.0f, 67.0f, 1188.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(703.0f, 17.0f, 871.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(1404.0f, 26.0f, 1440.0f, 54.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(1440.0f, 39.0f, 1464.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(1404.0f, 57.0f, 1432.0f, 87.0f, Region.Op.UNION);
        }
        int value = this.DATA[33];
        if (value == 1) {
            c.clipRect(397.0f, 28.0f, 423.0f, 107.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(397.0f, 28.0f, 440.0f, 107.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(397.0f, 28.0f, 455.0f, 107.0f, Region.Op.UNION);
        } else if (value == 4) {
            c.clipRect(397.0f, 28.0f, 472.0f, 107.0f, Region.Op.UNION);
        } else if (value == 5) {
            c.clipRect(397.0f, 28.0f, 489.0f, 107.0f, Region.Op.UNION);
        } else if (value == 6) {
            c.clipRect(397.0f, 28.0f, 504.0f, 107.0f, Region.Op.UNION);
        } else if (value == 7) {
            c.clipRect(397.0f, 28.0f, 523.0f, 107.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[23];
        if (temp == -1) {
            c.drawText("NO", 67.0f, 83.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 67.0f, 83.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 67.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 67.0f, 83.0f, this.mPaint);
        }
        int temp2 = this.DATA[24];
        if (temp2 == -1) {
            c.drawText("NO", 1760.0f, 83.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1760.0f, 83.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1760.0f, 83.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 1760.0f, 83.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(LauncherApplication.getScreenWidth() / 1920.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
