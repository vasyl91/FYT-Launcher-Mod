package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0454_LZ_Bentley_MS extends AirBase {
    public Air_0454_LZ_Bentley_MS(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_audia6/air_od_audi_a6_n.webp";
        this.mPathHighlight = "0439_oudi_audia6/air_od_audi_a6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(358.0f, 103.0f, 477.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(134.0f, 26.0f, 226.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(509.0f, 105.0f, 555.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(265.0f, 73.0f, 297.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(261.0f, 36.0f, 306.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(258.0f, 84.0f, 285.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(264.0f, 110.0f, 322.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(706.0f, 71.0f, 742.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(702.0f, 38.0f, 748.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(701.0f, 85.0f, 728.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(708.0f, 111.0f, 766.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(38.0f, 142.0f, 91.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(940.0f, 143.0f, 992.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(398.0f, 17.0f, 506.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(591.0f, 103.0f, 665.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(587.0f, 18.0f, 674.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(809.0f, 27.0f, 887.0f, 65.0f, Region.Op.UNION);
        }
        int value = this.DATA[26];
        c.clipRect(184.0f, 132.0f, (value * 14) + 184, 147.0f, Region.Op.UNION);
        int value2 = this.DATA[27];
        c.clipRect(845 - (value2 * 14), 135.0f, 845.0f, 151.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value3 = this.DATA[19];
        c.drawText(String.valueOf(value3), 64.0f, 135.0f, this.mPaint);
        int value4 = this.DATA[32];
        c.drawText(String.valueOf(value4), 962.0f, 135.0f, this.mPaint);
        int temp = this.DATA[20];
        if (temp == -1) {
            c.drawText("NO", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 43.0f, 61.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 43.0f, 61.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(temp2 / 10 + "." + (temp2 % 10), 43.0f, 61.0f, this.mPaint);
        }
        int temp3 = this.DATA[21];
        if (temp3 == -1) {
            c.drawText("NO", 945.0f, 61.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 945.0f, 61.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 945.0f, 61.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
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
