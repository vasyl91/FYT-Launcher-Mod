package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_LZ_LandRover_All extends AirBase {
    public Air_0453_LZ_LandRover_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_lz_maserati/air_lz_romeo.webp";
        this.mPathHighlight = "0452_lz_maserati/air_lz_romeo_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[19] != 0) {
            c.clipRect(266.0f, 31.0f, 381.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(136.0f, 21.0f, 217.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(164.0f, 131.0f, 227.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(162.0f, 80.0f, 215.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(153.0f, 101.0f, 190.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(786.0f, 25.0f, 853.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(805.0f, 131.0f, 864.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(800.0f, 80.0f, 850.0f, 104.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(792.0f, 103.0f, 829.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(419.0f, 111.0f, 487.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(281.0f, 91.0f, 358.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(544.0f, 13.0f, 621.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(413.0f, 15.0f, 487.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 0) {
            c.clipRect(646.0f, 15.0f, 766.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(84.0f, 121.0f, 123.0f, 161.0f, Region.Op.UNION);
            c.clipRect(978.0f, 116.0f, 1019.0f, 157.0f, Region.Op.UNION);
        }
        int value1 = this.DATA[36];
        if ((value1 & 8) != 0) {
            value1 = 16 - value1;
            c.clipRect(9.0f, 13.0f, 53.0f, 56.0f, Region.Op.UNION);
        }
        if (value1 > 3) {
            value1 = 3;
        }
        c.clipRect(51.0f, 49.0f, (value1 * 21) + 51, 71.0f, Region.Op.UNION);
        int value2 = this.DATA[37];
        if ((value2 & 8) != 0) {
            value2 = 16 - value2;
            c.clipRect(981.0f, 8.0f, 1019.0f, 52.0f, Region.Op.UNION);
        }
        if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(911.0f, 50.0f, (value2 * 21) + 911, 73.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[30];
        c.drawText(new StringBuilder().append(value).toString(), 570.0f, 138.0f, this.mPaint);
        int left_temp = this.DATA[31];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((left_temp * 5) / 10.0f).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[32];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((right_temp * 5) / 10.0f).toString(), 930.0f, 152.0f, this.mPaint);
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
