package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0244_RZC_HavaH2S_HongBiao extends AirBase {
    public Air_0244_RZC_HavaH2S_HongBiao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0244_rzc_hava_h2s/air_rzc_hava_h2s_n.webp";
        this.mPathHighlight = "0244_rzc_hava_h2s/air_rzc_hava_h2s_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(4.0f, 23.0f, 136.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(903.0f, 27.0f, 1006.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(300.0f, 92.0f, 433.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(306.0f, 17.0f, 425.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(611.0f, 12.0f, 704.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(612.0f, 98.0f, 694.0f, 168.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(184.0f, 21.0f, 252.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(460.0f, 19.0f, 539.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(463.0f, 75.0f, 528.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(461.0f, 110.0f, 507.0f, 153.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(749.0f, 22.0f, 749.0f + (value * 14.75f), 83.0f, Region.Op.UNION);
        int value2 = this.DATA[27];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 17) {
            value2 = 17;
        }
        c.clipRect(49.0f, 87.0f, 49.0f + (value2 * 13.9f), 168.0f, Region.Op.UNION);
        int value3 = this.DATA[28];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 17) {
            value3 = 17;
        }
        c.clipRect(775.0f, 87.0f, 775.0f + (value3 * 13.9f), 168.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
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
