package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0244_RZC_HavaH2_LanBiao extends AirBase {
    public Air_0244_RZC_HavaH2_LanBiao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0132_wc2_havah2/air_wc1_hafo_h2.webp";
        this.mPathHighlight = "0132_wc2_havah2/air_wc1_hafo_h2_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(10.0f, 31.0f, 145.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(896.0f, 29.0f, 997.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(510.0f, 17.0f, 656.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(178.0f, 30.0f, 287.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(703.0f, 12.0f, 825.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(713.0f, 90.0f, 819.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(185.0f, 113.0f, 280.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(334.0f, 36.0f, 423.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(372.0f, 86.0f, 429.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(346.0f, 104.0f, 394.0f, 138.0f, Region.Op.UNION);
        }
        int tempValue = this.DATA[27];
        if (tempValue < 0) {
            tempValue = 0;
        } else if (tempValue > 7) {
            tempValue = 7;
        }
        c.clipRect(5.0f, 90.0f, (tempValue * 20) + 5, 163.0f, Region.Op.UNION);
        int tempValue2 = this.DATA[28];
        if (tempValue2 < 0) {
            tempValue2 = 0;
        } else if (tempValue2 > 7) {
            tempValue2 = 7;
        }
        c.clipRect(871.0f, 93.0f, (tempValue2 * 20) + 871, 164.0f, Region.Op.UNION);
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(507.0f, 89.0f, (value * 21) + ConstRzcAddData.U_CAR_LIGHT_FRONT, 161.0f, Region.Op.UNION);
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