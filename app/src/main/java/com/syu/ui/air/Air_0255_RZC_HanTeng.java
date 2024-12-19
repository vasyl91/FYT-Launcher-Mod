package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0255_RZC_HanTeng extends AirBase {
    public Air_0255_RZC_HanTeng(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0255_rzc_fengshenax7/air_rzc_hanteng.webp";
        this.mPathHighlight = "0255_rzc_fengshenax7/air_rzc_hanteng_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        String str2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(150.0f, 11.0f, 290.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(151.0f, 93.0f, 291.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(296.0f, 11.0f, 436.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(296.0f, 93.0f, 436.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(453.0f, 17.0f, 539.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(460.0f, 88.0f, 529.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(451.0f, 112.0f, 498.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(588.0f, 11.0f, 728.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(734.0f, 11.0f, 874.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(734.0f, 93.0f, 874.0f, 165.0f, Region.Op.UNION);
        }
        int value = this.DATA[22];
        if (value > 7) {
            value = 7;
        }
        c.clipRect(609.0f, 114.0f, (value * 16) + 609, 160.0f, Region.Op.UNION);
        int value2 = this.DATA[25];
        if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(66.0f, 50.0f, (value2 * 20) + 66, 75.0f, Region.Op.UNION);
        int value3 = this.DATA[26];
        if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(896.0f, 50.0f, (value3 * 20) + 896, 75.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[23];
        if (temp < 16) {
            str = new StringBuilder(String.valueOf(temp + 16)).toString();
            if (temp <= 1) {
                str = "LO";
            } else if (temp >= 15) {
                str = "HI";
            }
        } else {
            str = new StringBuilder(String.valueOf(temp * 0.5f)).toString();
            if (temp <= 36) {
                str = "LO";
            } else if (temp >= 64) {
                str = "HI";
            }
        }
        c.drawText(str, 62.0f, 138.0f, this.mPaint);
        int temp2 = this.DATA[24];
        if (temp2 < 16) {
            str2 = new StringBuilder(String.valueOf(temp2 + 16)).toString();
            if (temp2 <= 1) {
                str2 = "LO";
            } else if (temp2 >= 15) {
                str2 = "HI";
            }
        } else {
            str2 = new StringBuilder(String.valueOf(temp2 * 0.5f)).toString();
            if (temp2 <= 36) {
                str2 = "LO";
            } else if (temp2 >= 64) {
                str2 = "HI";
            }
        }
        c.drawText(str2, 936.0f, 138.0f, this.mPaint);
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
