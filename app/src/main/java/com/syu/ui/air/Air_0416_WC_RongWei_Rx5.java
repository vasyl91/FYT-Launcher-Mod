package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0416_WC_RongWei_Rx5 extends AirBase {
    public Air_0416_WC_RongWei_Rx5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0416_wc_rongwei_rx5/air_wc_RX5.webp";
        this.mPathHighlight = "0416_wc_rongwei_rx5/air_wc_RX5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(14.0f, 20.0f, 150.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(911.0f, 98.0f, 990.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(894.0f, 17.0f, 997.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(174.0f, 34.0f, 293.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(338.0f, 10.0f, 434.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(350.0f, 88.0f, 405.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(336.0f, 109.0f, 390.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(693.0f, 53.0f, 851.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value >= 0 && value <= 6) {
            c.clipRect(499.0f, 64.0f, (value * 25) + 499, 146.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 60.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 60.0f, 140.0f, this.mPaint);
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
