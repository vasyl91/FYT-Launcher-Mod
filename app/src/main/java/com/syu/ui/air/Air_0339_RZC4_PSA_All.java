package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0339_RZC4_PSA_All extends AirBase {
    public Air_0339_RZC4_PSA_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0163_rzc_psa14_408/air_rzc_psa_n.webp";
        this.mPathHighlight = "0163_rzc_psa14_408/air_rzc_psa_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(5.0f, 25.0f, 131.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(305.0f, 23.0f, 419.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(746.0f, 101.0f, 862.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(323.0f, 102.0f, 406.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(603.0f, 96.0f, 713.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(158.0f, 102.0f, 272.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(608.0f, 15.0f, 710.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(891.0f, 19.0f, 1012.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(174.0f, 7.0f, 214.0f, 29.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(195.0f, 24.0f, 229.0f, 41.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(176.0f, 39.0f, 203.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[49] == 0) {
            c.clipRect(189.0f, 66.0f, 243.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(767.0f, 9.0f, 799.0f, 27.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(785.0f, 23.0f, 819.0f, 41.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(764.0f, 39.0f, 794.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[50] == 0) {
            c.clipRect(780.0f, 64.0f, 832.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(92.0f, 113.0f, 129.0f, 154.0f, Region.Op.UNION);
            c.clipRect(977.0f, 120.0f, 1019.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[52] == 0) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 1) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
            c.clipRect(476.0f, 21.0f, 513.0f, 58.0f, Region.Op.UNION);
        } else if (this.DATA[52] == 2) {
            c.clipRect(514.0f, 20.0f, 551.0f, 55.0f, Region.Op.UNION);
            c.clipRect(476.0f, 21.0f, 513.0f, 58.0f, Region.Op.UNION);
            c.clipRect(499.0f, 57.0f, 536.0f, 76.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value == 1) {
            c.clipRect(446.0f, 92.0f, 503.0f, 122.0f, Region.Op.UNION);
        }
        int value2 = value - 1;
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 8) {
            value2 = 8;
        }
        c.clipRect(451.0f, 116.0f, (value2 * 16) + 451, 164.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int tempvalue = this.DATA[56];
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 56.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 56.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 56.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp / 2.0f) + tempvalue).toString(), 56.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 / 2.0f) + tempvalue).toString(), 930.0f, 132.0f, this.mPaint);
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
