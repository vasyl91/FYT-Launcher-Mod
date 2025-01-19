package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0443_WC2_Nazhijie_U6 extends AirBase {
    public Air_0443_WC2_Nazhijie_U6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0128_wc2_changancs75/air_wc2_changancs75_n.webp";
        this.mPathHighlight = "0128_wc2_changancs75/air_wc2_changancs75_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(853.0f, 50.0f, 1010.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(708.0f, 43.0f, 819.0f, 127.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(777.0f, 15.0f, 838.0f, 41.0f, Region.Op.UNION);
            c.clipRect(379.0f, 13.0f, 459.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(395.0f, 80.0f, 451.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(379.0f, 13.0f, 459.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(377.0f, 107.0f, 425.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(183.0f, 34.0f, 334.0f, 128.0f, Region.Op.UNION);
        }
        int value = this.DATA[16];
        if (value == 5) {
            value = 6;
        } else if (value == 6) {
            value = 8;
        }
        c.clipRect(525.0f, 65.0f, (value * 18) + ConstRzcAddData.U_CAR_VOLTAGE, 125.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[17];
        if (temp == -1) {
            c.drawText("NO", 100.0f, 110.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 100.0f, 110.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 100.0f, 110.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10) + " ℃", 100.0f, 110.0f, this.mPaint);
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
