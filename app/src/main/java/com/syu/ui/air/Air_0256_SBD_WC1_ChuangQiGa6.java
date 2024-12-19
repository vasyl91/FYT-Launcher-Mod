package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0256_SBD_WC1_ChuangQiGa6 extends AirBase {
    public Air_0256_SBD_WC1_ChuangQiGa6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0256_sbd_wc1_chuangqiga6/air_256_chuangqi_ga6_n.webp";
        this.mPathHighlight = "0256_sbd_wc1_chuangqiga6/air_256_chuangqi_ga6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(870.0f, 28.0f, 1011.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(356.0f, 41.0f, 485.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 3) {
            c.clipRect(382.0f, 108.0f, 456.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(546.0f, 16.0f, 628.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(536.0f, 93.0f, 637.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(45.0f, 21.0f, 122.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(207.0f, 13.0f, 244.0f, 36.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(228.0f, 35.0f, 270.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(205.0f, 52.0f, 239.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(722.0f, 14.0f, 761.0f, 36.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(741.0f, 36.0f, 784.0f, 50.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(720.0f, 52.0f, 754.0f, 80.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(196.0f, 112.0f, (value * 18) + 196, 162.0f, Region.Op.UNION);
        int value2 = this.DATA[13];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(712.0f, 111.0f, (value2 * 18) + 712, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[5];
        if (temp == -2) {
            c.drawText("LOW", 64.0f, 152.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 64.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 64.0f, 152.0f, this.mPaint);
        }
        int temp2 = this.DATA[14];
        if (temp2 == -2) {
            c.drawText("LOW", 926.0f, 152.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 926.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 926.0f, 152.0f, this.mPaint);
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
