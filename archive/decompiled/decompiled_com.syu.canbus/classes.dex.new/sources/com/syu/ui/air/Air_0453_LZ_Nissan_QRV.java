package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[65] != 0) {
            this.srPath.addRect(189.0f, 8.0f, 312.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(211.0f, 97.0f, 300.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(345.0f, 25.0f, 414.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(354.0f, 65.0f, 414.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(352.0f, 80.0f, 396.0f, 116.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(515.0f, 36.0f, 651.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(866.0f, 15.0f, 1000.0f, 71.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 4) {
            value = 4;
        }
        this.srPath.addRect(726.0f, 22.0f, (value * 20) + 726, 66.0f, Path.Direction.CW);
        int flag = this.DATA[67];
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 4) {
            value2 = 4;
        }
        if (flag == 1) {
            this.srPath.addRect(726.0f, 111.0f, (value2 * 20) + 726, 155.0f, Path.Direction.CW);
        }
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        switch (this.DATA[55]) {
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
        int temp = this.DATA[27];
        c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 56.0f, 132.0f, this.mPaint);
        int temp2 = this.DATA[28];
        c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 930.0f, 132.0f, this.mPaint);
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
