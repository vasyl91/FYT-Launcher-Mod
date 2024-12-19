package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.util.Print;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0206_WC1_Benz extends AirBase {
    public Air_0206_WC1_Benz(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0206_wc1_benz/air_wc1_benz_n.webp";
        this.mPathHighlight = "0206_wc1_benz/air_wc1_benz_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[20] != 0) {
            c.clipRect(162.0f, 22.0f, 273.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(447.0f, 47.0f, 577.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(901.0f, 25.0f, 1006.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(606.0f, 14.0f, 704.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(606.0f, 92.0f, 704.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(318.0f, 93.0f, 416.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(8.0f, 27.0f, 139.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(318.0f, 93.0f, 416.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(325.0f, 35.0f, 374.0f, 50.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(317.0f, 50.0f, 356.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(797.0f, 10.0f, 845.0f, 34.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(793.0f, 35.0f, 842.0f, 50.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(811.0f, 50.0f, 850.0f, 82.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int value = this.DATA[19];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        if (this.DATA[24] == 1) {
            c.drawText(value + ".5", 240.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value).toString(), 240.0f, 140.0f, this.mPaint);
        }
        Print.screenMsg("CanBus Callback_0206_WC1_Benz**********  U_AIR_WIND_LEVEL_LEFT= " + value);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 8) {
            value2 = 8;
        }
        if (this.DATA[30] == 1) {
            c.drawText(value2 + ".5", 820.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value2).toString(), 820.0f, 140.0f, this.mPaint);
        }
        Print.screenMsg("CanBus Callback_0206_WC1_Benz**********  U_AIR_WIND_LEVEL_RIGHT= " + value2);
        int temp = this.DATA[15];
        if (temp == -1) {
            c.drawText("NO", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 50.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 50.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10) + "." + (temp % 10), 50.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 930.0f, 140.0f, this.mPaint);
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
