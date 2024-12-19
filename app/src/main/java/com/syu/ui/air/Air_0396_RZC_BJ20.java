package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0396_RZC_BJ20 extends AirBase {
    public Air_0396_RZC_BJ20(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0396_rzc_shenbao/air_shenbao_bj20.webp";
        this.mPathHighlight = "0396_rzc_shenbao/air_shenbao_bj20_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(155.0f, 23.0f, 281.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(165.0f, 104.0f, 252.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(290.0f, 107.0f, 375.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(312.0f, 25.0f, 430.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(375.0f, 32.0f, 430.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(740.0f, 10.0f, 781.0f, 29.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(740.0f, 28.0f, 869.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(502.0f, 21.0f, 572.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(446.0f, 17.0f, 577.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(537.0f, 98.0f, 610.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(395.0f, 92.0f, 507.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(651.0f, 107.0f, 739.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(781.0f, 90.0f, 831.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(798.0f, 126.0f, 832.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(783.0f, 142.0f, 814.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[34] == 1) {
            c.clipRect(641.0f, 11.0f, 695.0f, 34.0f, Region.Op.UNION);
        }
        if (this.DATA[28] == 1) {
            c.clipRect(977.0f, 108.0f, 1017.0f, 159.0f, Region.Op.UNION);
            c.clipRect(103.0f, 112.0f, 146.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[20];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(591.0f, 37.0f, 591.0f + (value * 15.0f), 82.0f, Region.Op.UNION);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(72.0f, 50.0f, 72.0f + (value2 * 19.0f), 71.0f, Region.Op.UNION);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(905.0f, 50.0f, 905.0f + (value3 * 19.0f), 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 56.0f, 152.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 152.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("No", 56.0f, 152.0f, this.mPaint);
        } else if (this.DATA[28] == 1) {
            c.drawText(new StringBuilder().append(temp + 59).toString(), 56.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 56.0f, 152.0f, this.mPaint);
        }
        int temp2 = this.DATA[25];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NO", 930.0f, 152.0f, this.mPaint);
        } else if (this.DATA[28] == 1) {
            c.drawText(new StringBuilder().append(temp2 + 59).toString(), 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 930.0f, 152.0f, this.mPaint);
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
