package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_DJ_Rongwei_I5 extends AirBase {
    public Air_0439_DJ_Rongwei_I5(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_dj_rongwei_i5/air_0439_rongwei_i5.webp";
        this.mPathHighlight = "0439_dj_rongwei_i5/air_0439_rongwei_i5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(698.0f, 66.0f, 847.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(199.0f, 24.0f, 304.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(202.0f, 93.0f, 309.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(872.0f, 43.0f, 996.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(554.0f, 20.0f, 639.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(567.0f, 88.0f, 627.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(565.0f, 105.0f, 602.0f, 140.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 6) {
            value = 6;
        }
        c.clipRect(393.0f, 46.0f, (value * 19) + 393, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -2) {
            c.drawText("LOW", 78.0f, 94.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 78.0f, 94.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp + 15), 78.0f, 94.0f, this.mPaint);
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
