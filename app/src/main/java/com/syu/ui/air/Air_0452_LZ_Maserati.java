package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0452_LZ_Maserati extends AirBase {
    public Air_0452_LZ_Maserati(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_lz_maserati/air.webp";
        this.mPathHighlight = "0452_lz_maserati/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[60] != 0) {
            c.clipRect(10.0f, 24.0f, 100.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(128.0f, 18.0f, 200.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(123.0f, 102.0f, 199.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(229.0f, 25.0f, 322.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(227.0f, 100.0f, 319.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(348.0f, 15.0f, 422.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(352.0f, 102.0f, 416.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(456.0f, 29.0f, 493.0f, 47.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(456.0f, 46.0f, 492.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(453.0f, 58.0f, 484.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(477.0f, 9.0f, 526.0f, 27.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(618.0f, 26.0f, 664.0f, 45.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(618.0f, 47.0f, 656.0f, 57.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(627.0f, 57.0f, 662.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[50] != 0) {
            c.clipRect(586.0f, 9.0f, 633.0f, 29.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 1) {
            c.clipRect(690.0f, 17.0f, 785.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(690.0f, 99.0f, 788.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(811.0f, 22.0f, 917.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[59] != 0) {
            c.clipRect(815.0f, 97.0f, 910.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0) {
            c.clipRect(933.0f, 23.0f, 1017.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(66.0f, 121.0f, 100.0f, 153.0f, Region.Op.UNION);
            c.clipRect(989.0f, 120.0f, 1020.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        c.clipRect(476.0f, 98.0f, (value * 23) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B10, 155.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 39.0f, 134.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 39.0f, 134.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(left_temp / 2.0f)).toString(), 39.0f, 134.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 955.0f, 134.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 955.0f, 134.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(right_temp / 2.0f)).toString(), 955.0f, 134.0f, this.mPaint);
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
