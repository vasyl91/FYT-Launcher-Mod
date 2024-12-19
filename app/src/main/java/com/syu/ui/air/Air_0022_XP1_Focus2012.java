package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.util.Log;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0022_XP1_Focus2012 extends AirBase {
    public Air_0022_XP1_Focus2012(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0022_XP1_Focus2012/air.webp";
        this.mPathHighlight = "0022_XP1_Focus2012/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(745.0f, 18.0f, 862.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(160.0f, 20.0f, 272.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(304.0f, 50.0f, 358.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(334.0f, 72.0f, 388.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(303.0f, 98.0f, 350.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(150.0f, 96.0f, 284.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(602.0f, 96.0f, 715.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(446.0f, 16.0f, 573.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(610.0f, 14.0f, 714.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(742.0f, 95.0f, 856.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(85.0f, 115.0f, 127.0f, 164.0f, Region.Op.UNION);
            c.clipRect(970.0f, 118.0f, 1018.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(460.0f, 117.0f, (value * 16) + 460, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[27];
        switch (value2) {
            case 1048576:
                c.drawText("LOW", 60.0f, 92.0f, this.mPaint);
                break;
            case FinalCanbus.CAR_WC1_VW_Polo_08_18 /* 1048577 */:
                c.drawText("HIGH", 60.0f, 92.0f, this.mPaint);
                break;
            default:
                if (this.DATA[37] != 0) {
                    c.drawText(String.format("%.1f", Float.valueOf(value2)), 60.0f, 92.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value2 / 10.0f)), 60.0f, 92.0f, this.mPaint);
                    break;
                }
        }
        int value3 = this.DATA[28];
        Log.d("focus", "右边空调温度 :" + value3);
        switch (value3) {
            case 1048576:
                c.drawText("LOW", 945.0f, 92.0f, this.mPaint);
                break;
            case FinalCanbus.CAR_WC1_VW_Polo_08_18 /* 1048577 */:
                c.drawText("HIGH", 945.0f, 92.0f, this.mPaint);
                break;
            default:
                if (this.DATA[37] != 0) {
                    c.drawText(String.format("%.1f", Float.valueOf(value3)), 945.0f, 92.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%.1f", Float.valueOf(value3 / 10.0f)), 945.0f, 92.0f, this.mPaint);
                    break;
                }
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
