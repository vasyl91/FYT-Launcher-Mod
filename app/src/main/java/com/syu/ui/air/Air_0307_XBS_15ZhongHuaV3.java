package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0307_XBS_15ZhongHuaV3 extends AirBase {
    public Air_0307_XBS_15ZhongHuaV3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0307_xbs_xp1_15zhonghuav3/zhonghuav3.webp";
        this.mPathHighlight = "0307_xbs_xp1_15zhonghuav3/zhonghuav3_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(775.0f, 120.0f, 839.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[68] != 0) {
            c.clipRect(745.0f, 92.0f, 859.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[0] != 0) {
            c.clipRect(734.0f, 25.0f, 872.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(455.0f, 12.0f, 537.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(476.0f, 76.0f, 536.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(451.0f, 100.0f, 499.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(305.0f, 17.0f, 426.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(312.0f, 91.0f, 423.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(154.0f, 45.0f, 286.0f, 123.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(597.0f, 55.0f, (value * 18) + 597, 133.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value2 = this.DATA[5];
        switch (value2) {
            case -3:
                c.drawText("HIGH", 51.0f, 97.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 51.0f, 97.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 51.0f, 97.0f, this.mPaint);
                break;
            default:
                if (DataCanbus.DATA[1000] == 131379 || DataCanbus.DATA[1000] == 196915) {
                    int value3 = value2 * 5;
                    c.drawText(String.valueOf(value3 / 10) + "." + (value3 % 10), 51.0f, 97.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%d", Integer.valueOf(value2)), 51.0f, 97.0f, this.mPaint);
                    break;
                }
        }
        int value4 = this.DATA[6];
        switch (value4) {
            case -3:
                c.drawText("HIGH", 945.0f, 97.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 945.0f, 97.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NONE", 945.0f, 97.0f, this.mPaint);
                break;
            default:
                if (DataCanbus.DATA[1000] == 131379 || DataCanbus.DATA[1000] == 196915) {
                    int value5 = value4 * 5;
                    c.drawText(String.valueOf(value5 / 10) + "." + (value5 % 10), 945.0f, 97.0f, this.mPaint);
                    break;
                } else {
                    c.drawText(String.format("%d", Integer.valueOf(value4)), 945.0f, 97.0f, this.mPaint);
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
