package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_OUDI_Dongnan_all extends AirBase {
    public Air_0452_OUDI_Dongnan_all(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_oudi_dongnan/air_0452_dongnan.webp";
        this.mPathHighlight = "0452_oudi_dongnan/air_0452_dongnan_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(126.0f, 104.0f, 260.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(607.0f, 11.0f, 726.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(474.0f, 27.0f, 548.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(157.0f, 13.0f, 223.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(318.0f, 20.0f, 388.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(315.0f, 97.0f, 386.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(786.0f, 33.0f, 851.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(794.0f, 84.0f, 839.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(788.0f, 98.0f, 822.0f, 133.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 0;
        }
        c.clipRect(521.0f, 103.0f, (value * 20) + ConstRzcAddData.U_CAR_AVG_FUEL, 162.0f, Region.Op.UNION);
        c.clipRect(59.0f, 136.0f, (this.DATA[13] * 13) + 59, 155.0f, Region.Op.UNION);
        c.clipRect(971 - (this.DATA[14] * 13), 136.0f, 971.0f, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(26.0f);
        int temp = this.DATA[11];
        if (temp == -2) {
            c.drawText("LOW", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 65.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NONE", 39.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 39.0f, 65.0f, this.mPaint);
        }
        int temp2 = this.DATA[12];
        if (temp2 == -2) {
            c.drawText("LOW", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 954.0f, 65.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NONE", 954.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 954.0f, 65.0f, this.mPaint);
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
