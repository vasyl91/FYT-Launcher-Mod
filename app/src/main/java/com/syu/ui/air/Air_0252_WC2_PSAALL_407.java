package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0252_WC2_PSAALL_407 extends AirBase {
    public Air_0252_WC2_PSAALL_407(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0252_wc2_psaall/air_wc_psa_407_n.webp";
        this.mPathHighlight = "0252_wc2_psaall/air_wc_psa_407_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[13] != 0) {
            c.clipRect(14.0f, 20.0f, 142.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(171.0f, 23.0f, 291.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(188.0f, 99.0f, 282.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(896.0f, 21.0f, 1012.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(324.0f, 17.0f, 455.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(635.0f, 13.0f, 731.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(638.0f, 96.0f, 726.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(343.0f, 88.0f, 390.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(376.0f, 114.0f, 416.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(348.0f, 131.0f, 383.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(771.0f, 86.0f, 819.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(806.0f, 115.0f, 844.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(779.0f, 131.0f, 812.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[52] == 0) {
            c.clipRect(820.0f, 10.0f, 847.0f, 51.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 1) {
            c.clipRect(820.0f, 10.0f, 847.0f, 51.0f, Region.Op.UNION);
            c.clipRect(803.0f, 49.0f, 840.0f, 73.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 2) {
            c.clipRect(820.0f, 10.0f, 847.0f, 51.0f, Region.Op.UNION);
            c.clipRect(803.0f, 49.0f, 840.0f, 73.0f, Region.Op.UNION);
            c.clipRect(789.0f, 9.0f, 814.0f, 54.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(476.0f, 66.0f, (value * 16) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B10, 118.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        int tempvalue = this.DATA[230];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 150.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 150.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp + (tempvalue * 10)) / 10.0f).toString(), 56.0f, 150.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 928.0f, 150.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 928.0f, 150.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 928.0f, 150.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 + (tempvalue * 10)) / 10.0f).toString(), 928.0f, 150.0f, this.mPaint);
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
