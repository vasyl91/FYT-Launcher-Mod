package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0196_XBS_OD_Changcheng_C30 extends AirBase {
    public Air_0196_XBS_OD_Changcheng_C30(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0132_wc2_havah2/air_wc1_hava_17h2s.webp";
        this.mPathHighlight = "0132_wc2_havah2/air_wc1_hava_17h2s_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(10.0f, 31.0f, 145.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(510.0f, 17.0f, 656.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(178.0f, 30.0f, 287.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(703.0f, 12.0f, 825.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(713.0f, 90.0f, 819.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(185.0f, 113.0f, 280.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(334.0f, 36.0f, 423.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(372.0f, 86.0f, 429.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(346.0f, 104.0f, 394.0f, 138.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
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
        int temp = this.DATA[10];
        if (temp == -1) {
            c.drawText("NO", 60.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 132.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 65732) {
                temp += 30;
            }
            c.drawText(new StringBuilder().append(temp * 0.5f).toString(), 60.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 132.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 65732) {
                temp2 += 30;
            }
            c.drawText(new StringBuilder().append(temp2 * 0.5f).toString(), 920.0f, 132.0f, this.mPaint);
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