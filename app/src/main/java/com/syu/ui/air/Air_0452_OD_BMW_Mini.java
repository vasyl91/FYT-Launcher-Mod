package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_OD_BMW_Mini extends AirBase {
    public Air_0452_OD_BMW_Mini(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_audia6/air_od_bmw_nbt_n.webp";
        this.mPathHighlight = "0439_oudi_audia6/air_od_bmw_nbt_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(442.0f, 105.0f, 564.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(914.0f, 94.0f, 999.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(154.0f, 22.0f, 244.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(307.0f, 82.0f, 347.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(304.0f, 35.0f, 361.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(308.0f, 96.0f, 335.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(46.0f, 139.0f, 97.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(447.0f, 17.0f, 553.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(628.0f, 104.0f, 715.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(628.0f, 12.0f, 711.0f, 72.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        c.clipRect(204.0f, 132.0f, (value * 14) + 204, 147.0f, Region.Op.UNION);
        int value2 = this.DATA[21];
        c.clipRect(821 - (value2 * 14), 135.0f, 821.0f, 151.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = this.DATA[17];
        c.drawText(String.valueOf(value3), 74.0f, 135.0f, this.mPaint);
        int temp = this.DATA[18];
        if (temp == -1) {
            c.drawText("NO", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 43.0f, 61.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 155;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 43.0f, 61.0f, this.mPaint);
        }
        int temp3 = this.DATA[19];
        if (temp3 == -1) {
            c.drawText("NO", 945.0f, 61.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 945.0f, 61.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 945.0f, 61.0f, this.mPaint);
        } else {
            int temp4 = (temp3 * 5) + 155;
            c.drawText(temp4 / 10 + "." + (temp4 % 10), 945.0f, 61.0f, this.mPaint);
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
