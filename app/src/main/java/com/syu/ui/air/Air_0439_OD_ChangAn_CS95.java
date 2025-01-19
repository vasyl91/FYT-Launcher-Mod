package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

public class Air_0439_OD_ChangAn_CS95 extends AirBase {
    public Air_0439_OD_ChangAn_CS95(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0132_wc2_havah2/air_wc1_hava_17h2s.webp";
        this.mPathHighlight = "0132_wc2_havah2/air_wc1_hava_17h2s_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] > 0) {
            c.clipRect(10.0f, 31.0f, 145.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(896.0f, 29.0f, 997.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] == 0) {
            c.clipRect(510.0f, 17.0f, 656.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(178.0f, 30.0f, 287.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(703.0f, 12.0f, 825.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(713.0f, 90.0f, 819.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(185.0f, 113.0f, 280.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(334.0f, 36.0f, 423.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(372.0f, 86.0f, 429.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(346.0f, 104.0f, 394.0f, 138.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(507.0f, 89.0f, (value * 21) + ConstRzcAddData.U_CAR_LIGHT_FRONT, 161.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[12];
        if (temp == 0) {
            c.drawText("LOW", 60.0f, 132.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 60.0f, 132.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 175;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 60.0f, 132.0f, this.mPaint);
        }
        int temp3 = this.DATA[13];
        if (temp3 == 0) {
            c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 920.0f, 132.0f, this.mPaint);
        } else {
            int temp4 = (temp3 * 5) + 175;
            c.drawText(temp4 / 10 + "." + (temp4 % 10), 920.0f, 132.0f, this.mPaint);
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
