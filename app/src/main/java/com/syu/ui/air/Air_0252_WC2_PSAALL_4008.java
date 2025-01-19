package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0252_WC2_PSAALL_4008 extends AirBase {
    public Air_0252_WC2_PSAALL_4008(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0252_wc2_psaall/air_wc_psa_all_4008_n.webp";
        this.mPathHighlight = "0252_wc2_psaall/air_wc_psa_all_4008_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(12.0f, 22.0f, 139.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(162.0f, 21.0f, 280.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(167.0f, 97.0f, 271.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(882.0f, 17.0f, 1015.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(300.0f, 107.0f, 436.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(744.0f, 14.0f, 859.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(762.0f, 92.0f, 856.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(460.0f, 29.0f, 531.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(470.0f, 85.0f, 530.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(460.0f, 108.0f, 504.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[52] == 0) {
            c.clipRect(623.0f, 14.0f, 660.0f, 55.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 1) {
            c.clipRect(623.0f, 14.0f, 660.0f, 55.0f, Region.Op.UNION);
            c.clipRect(639.0f, 54.0f, 677.0f, 73.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 2) {
            c.clipRect(623.0f, 14.0f, 660.0f, 55.0f, Region.Op.UNION);
            c.clipRect(639.0f, 54.0f, 677.0f, 73.0f, Region.Op.UNION);
            c.clipRect(660.0f, 14.0f, 689.0f, 52.0f, Region.Op.UNION);
        }
        if (DataCanbus.carId == 11 && this.DATA[54] != 0) {
            c.clipRect(305.0f, 87.0f, 349.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(298.0f, 27.0f, 438.0f, 75.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(601.0f, 114.0f, (value * 15) + 601, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 54.0f, 131.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 54.0f, 131.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 54.0f, 131.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 54.0f, 131.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 131.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 131.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 131.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 930.0f, 131.0f, this.mPaint);
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
