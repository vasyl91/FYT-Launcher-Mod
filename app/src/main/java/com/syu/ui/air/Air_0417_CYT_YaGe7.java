package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0417_CYT_YaGe7 extends AirBase {
    public Air_0417_CYT_YaGe7(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0417_cyt_yage7/air_cyt_yage7.webp";
        this.mPathHighlight = "0417_cyt_yage7/air_cyt_yage7_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(23.0f, 22.0f, 136.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(179.0f, 108.0f, 279.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(903.0f, 18.0f, 999.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(621.0f, 27.0f, 728.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(167.0f, 22.0f, 276.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(752.0f, 14.0f, 839.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(773.0f, 86.0f, 826.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(758.0f, 107.0f, 813.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 2) {
            c.clipRect(467.0f, 46.0f, 594.0f, 128.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value >= 0 && value <= 7) {
            c.clipRect(319.0f, 67.0f, (value * 18) + 319, 139.0f, Region.Op.UNION);
        }
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit != 0) {
            c.clipRect(105.0f, 117.0f, 141.0f, 154.0f, Region.Op.UNION);
            c.clipRect(978.0f, 118.0f, 1013.0f, 154.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) + 320) / 10)), 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 941.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 941.0f, 140.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp2 * 9) + 320) / 10)), 941.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 941.0f, 140.0f, this.mPaint);
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
