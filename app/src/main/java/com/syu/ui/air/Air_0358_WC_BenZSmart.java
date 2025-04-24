package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0358_WC_BenZSmart extends AirBase {
    public Air_0358_WC_BenZSmart(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0358_wc_benzsmart/air_wc_benzsmart_n.webp";
        this.mPathHighlight = "0358_wc_benzsmart/air_wc_benzsmart_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(32.0f, 25.0f, 145.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(46.0f, 99.0f, 130.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(885.0f, 25.0f, 998.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(519.0f, 95.0f, 667.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(188.0f, 30.0f, 335.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(701.0f, 30.0f, 848.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(371.0f, 19.0f, 446.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(393.0f, 85.0f, 449.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(370.0f, 111.0f, 410.0f, 147.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value > 4) {
            value = 0;
        }
        c.clipRect(545.0f, 20.0f, (value * 30) + 545, 80.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[11];
        if (left_temp == -2) {
            c.drawText("LOW", 940.0f, 130.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 940.0f, 130.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 940.0f, 130.0f, this.mPaint);
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
