package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0439_BNR_HavaH6 extends AirBase {
    public Air_0439_BNR_HavaH6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0131_xbs_havah6/air_xbs_xp1_havalh6.webp";
        this.mPathHighlight = "0131_xbs_havah6/air_xbs_xp1_havalh6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(31.0f, 29.0f, 144.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(54.0f, 102.0f, 122.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(186.0f, 31.0f, 328.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(698.0f, 34.0f, 841.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(884.0f, 22.0f, 997.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(366.0f, 23.0f, 447.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(396.0f, 90.0f, 446.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(368.0f, 110.0f, 410.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(871.0f, 93.0f, 1012.0f, 159.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(514.0f, 72.0f, (value * 20) + ConstRzcAddData.U_CAR_SEAT_BELT_LEFT, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
