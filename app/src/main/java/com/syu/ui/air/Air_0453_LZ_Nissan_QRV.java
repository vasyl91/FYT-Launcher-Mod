package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_LZ_Nissan_QRV extends AirBase {
    public Air_0453_LZ_Nissan_QRV(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0453_lz_nissan_qrv/air_lz_nissan_qrv_n.webp";
        this.mPathHighlight = "0453_lz_nissan_qrv/air_lz_nissan_qrv_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(189.0f, 8.0f, 312.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(211.0f, 97.0f, 300.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(345.0f, 25.0f, 414.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(354.0f, 65.0f, 414.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(352.0f, 80.0f, 396.0f, 116.0f, Region.Op.UNION);
        }
        if (this.DATA[11] == 0) {
            c.clipRect(515.0f, 36.0f, 651.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(866.0f, 15.0f, 1000.0f, 71.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 4) {
            value = 4;
        }
        c.clipRect(726.0f, 22.0f, (value * 20) + 726, 66.0f, Region.Op.UNION);
        int flag = this.DATA[17];
        int value2 = this.DATA[19];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 4) {
            value2 = 4;
        }
        if (flag == 1) {
            c.clipRect(726.0f, 111.0f, (value2 * 20) + 726, 155.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        switch (this.DATA[7]) {
            case 1:
                c.drawText("AUTO", 88.0f, 51.0f, this.mPaint);
                break;
            case 2:
                c.drawText("MANU", 88.0f, 51.0f, this.mPaint);
                break;
            case 3:
                c.drawText("MANU-AC", 88.0f, 51.0f, this.mPaint);
                break;
            case 4:
                c.drawText("ECON", 88.0f, 51.0f, this.mPaint);
                break;
            default:
                c.drawText("OFF", 88.0f, 51.0f, this.mPaint);
                break;
        }
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[13];
        c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 56.0f, 132.0f, this.mPaint);
        int temp2 = this.DATA[14];
        c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 930.0f, 132.0f, this.mPaint);
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
