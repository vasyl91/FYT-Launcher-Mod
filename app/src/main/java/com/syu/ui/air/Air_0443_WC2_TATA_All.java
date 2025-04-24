package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0443_WC2_TATA_All extends AirBase {
    public Air_0443_WC2_TATA_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0443_wc2_tata/air_wc2_tata.webp";
        this.mPathHighlight = "0443_wc2_tata/air_wc2_tata_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] == 0) {
            c.clipRect(343.0f, 33.0f, 455.0f, 77.0f, Region.Op.UNION);
        } else if (this.DATA[12] == 2) {
            c.clipRect(340.0f, 17.0f, 465.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(165.0f, 102.0f, 261.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[52] != 0) {
            c.clipRect(715.0f, 22.0f, 830.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(551.0f, 24.0f, 620.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(551.0f, 101.0f, 624.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(738.0f, 102.0f, 806.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(150.0f, 21.0f, 282.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(899.0f, 103.0f, 932.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(909.0f, 89.0f, 949.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(899.0f, 44.0f, 960.0f, 89.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(352.0f, 99.0f, (value * 16) + 352, 153.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == 254) {
            c.drawText("LOW", 52.0f, 117.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 52.0f, 117.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 52.0f, 117.0f, this.mPaint);
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
