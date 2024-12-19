package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0017_WC2_KeDiYaKe extends AirBase {
    public Air_0017_WC2_KeDiYaKe(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 260;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc2_kediyake_n.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc2_kediyake_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[190] != 0) {
            c.clipRect(new Rect(539, 183, 661, 250), Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(new Rect(733, 171, 836, 248), Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(new Rect(204, 19, 315, 72), Region.Op.UNION);
        }
        if (this.DATA[91] != 0) {
            c.clipRect(new Rect(261, 109, 316, 152), Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(new Rect(196, 108, 315, 154), Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(new Rect(190, 183, 330, 240), Region.Op.UNION);
        }
        if (this.DATA[152] != 0) {
            c.clipRect(new Rect(538, 90, 634, 162), Region.Op.UNION);
        }
        if (this.DATA[151] != 0) {
            c.clipRect(new Rect(531, 18, 675, 76), Region.Op.UNION);
        }
        if (this.DATA[90] != 0) {
            c.clipRect(new Rect(712, 23, 823, 74), Region.Op.UNION);
        }
        if (this.DATA[157] == 0) {
            c.clipRect(new Rect(355, 15, 489, 80), Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(new Rect(779, 139, 839, 164), Region.Op.UNION);
        }
        if (this.DATA[153] != 0) {
            c.clipRect(new Rect(710, 86, 759, 123), Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(new Rect(710, 125, 756, 140), Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(new Rect(700, 139, 733, 167), Region.Op.UNION);
        }
        if (this.DATA[156] != 0) {
            c.clipRect(new Rect(122, 35, 158, 85), Region.Op.UNION);
            c.clipRect(new Rect(976, 39, 1018, 86), Region.Op.UNION);
            c.clipRect(new Rect(461, 198, ConstRzcAddData.U_CAR_FRAME_NUM, 249), Region.Op.UNION);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(380.0f, 96.0f, 380.0f + (value * 15.7f), 168.0f, Region.Op.UNION);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(84.0f, 133.0f, 84.0f + (value2 * 19.0f), 153.0f, Region.Op.UNION);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(946.0f - (value3 * 19.0f), 131.0f, 946.0f, 153.0f, Region.Op.UNION);
        int value4 = this.DATA[192];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(84.0f, 216.0f, 84.0f + (value4 * 19.0f), 237.0f, Region.Op.UNION);
        int value5 = this.DATA[191];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(948.0f - (value5 * 19.0f), 217.0f, 948.0f, 239.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[98];
        if (temp == 254) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 254) {
            c.drawText("LOW", 930.0f, 72.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 930.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 930.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[154];
        if (temp3 == 254) {
            c.drawText("LOW", 416.0f, 236.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 416.0f, 236.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp3 * 5) / 10.0f).toString(), 416.0f, 236.0f, this.mPaint);
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
