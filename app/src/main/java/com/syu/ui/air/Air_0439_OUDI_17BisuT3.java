package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_OUDI_17BisuT3 extends AirBase {
    public Air_0439_OUDI_17BisuT3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_17bisut3/oudi_17bisut3.webp";
        this.mPathHighlight = "0439_oudi_17bisut3/oudi_17bisut3_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(17.0f, 100.0f, 162.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(363.0f, 29.0f, 490.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(893.0f, 100.0f, 984.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(706.0f, 15.0f, 837.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(196.0f, 15.0f, 297.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(201.0f, 92.0f, 295.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(713.0f, 130.0f, 764.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(556.0f, 23.0f, 624.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(565.0f, 88.0f, 615.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(551.0f, 106.0f, 592.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(372.0f, 97.0f, (value * 19) + 372, 152.0f, Region.Op.UNION);
        int value1 = this.DATA[14];
        if (value1 >= 0 && value1 > 3) {
        }
        c.clipRect(780.0f, 93.0f, (value * 20) + 780, 150.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(40.0f);
        int unit = this.DATA[13];
        int temp = this.DATA[9];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(temp + 60) + "℉", 70.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = ((temp * 5) + 160) & 65535;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + " ℃", 70.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[10];
        if (temp1 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(String.valueOf(temp1 + 60) + "℉", 920.0f, 60.0f, this.mPaint);
        } else {
            int temp12 = ((temp1 * 5) + 160) & 65535;
            c.drawText(String.valueOf(temp12 / 10) + "." + (temp12 % 10) + " ℃", 920.0f, 60.0f, this.mPaint);
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
