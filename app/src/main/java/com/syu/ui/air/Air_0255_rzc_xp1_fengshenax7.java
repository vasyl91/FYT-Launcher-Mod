package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0255_rzc_xp1_fengshenax7 extends AirBase {
    public Air_0255_rzc_xp1_fengshenax7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0255_rzc_fengshenax7/RZC_ax7.webp";
        this.mPathHighlight = "0255_rzc_fengshenax7/RZC_ax7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(867.0f, 22.0f, 1002.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(888.0f, 104.0f, 981.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(23.0f, 21.0f, 186.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(221.0f, 25.0f, 304.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(715.0f, 35.0f, 818.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(236.0f, 81.0f, 303.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(222.0f, 106.0f, 274.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(360.0f, 46.0f, 499.0f, 125.0f, Region.Op.UNION);
        }
        int value = this.DATA[15];
        c.clipRect(538.0f, 59.0f, (value * 18) + 538, 126.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[16];
        if (left_temp == -2) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 65.0f, 140.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 917759 || DataCanbus.DATA[1000] == 983295 || DataCanbus.DATA[1000] == 1442047 || DataCanbus.DATA[1000] == 1638655 || DataCanbus.DATA[1000] == 1704191 || DataCanbus.DATA[1000] == 1769727) {
            c.drawText(String.valueOf(left_temp / 10) + "." + (left_temp % 10), 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 65.0f, 140.0f, this.mPaint);
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
