package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_OD_Foton_Tunland extends AirBase {
    public Air_0439_OD_Foton_Tunland(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_foton_tunland/air_od_foton_tunland_n.webp";
        this.mPathHighlight = "0439_oudi_foton_tunland/air_od_foton_tunland_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(878.0f, 104.0f, 1006.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(45.0f, 106.0f, 120.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(380.0f, 86.0f, 431.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(345.0f, 34.0f, 416.0f, 89.0f, Region.Op.UNION);
            c.clipRect(506.0f, 41.0f, 632.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(354.0f, 106.0f, 392.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(172.0f, 50.0f, 297.0f, 118.0f, Region.Op.UNION);
        }
        int value = this.DATA[14];
        c.clipRect(680.0f, 52.0f, (value * 20) + 680, 134.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[15];
        if (temp == -1) {
            c.drawText("NO", 60.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 170;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 60.0f, 60.0f, this.mPaint);
        }
        int temp3 = this.DATA[16];
        if (temp3 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else {
            int temp4 = (temp3 * 5) + 170;
            c.drawText(temp4 / 10 + "." + (temp4 % 10), 920.0f, 60.0f, this.mPaint);
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
