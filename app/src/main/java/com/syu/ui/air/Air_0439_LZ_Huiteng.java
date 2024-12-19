package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_LZ_Huiteng extends AirBase {
    public Air_0439_LZ_Huiteng(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_lz_binli/air_lz_binli_n.webp";
        this.mPathHighlight = "0439_lz_binli/air_lz_binli_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(3.0f, 23.0f, 121.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(145.0f, 29.0f, 234.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(156.0f, 103.0f, 226.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(274.0f, 28.0f, 334.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(260.0f, 106.0f, 345.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(373.0f, 17.0f, 462.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(686.0f, 12.0f, 766.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(374.0f, 90.0f, 417.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(379.0f, 113.0f, 419.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(378.0f, 123.0f, 406.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[5] == 0) {
            c.clipRect(499.0f, 94.0f, 643.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(794.0f, 106.0f, 888.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(910.0f, 19.0f, 1010.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(791.0f, 24.0f, 888.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(684.0f, 90.0f, 719.0f, 113.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(686.0f, 113.0f, 722.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(685.0f, 123.0f, 713.0f, 147.0f, Region.Op.UNION);
        }
        int value = this.DATA[14];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(502.0f, 18.0f, (value * 18) + ConstRzcAddData.U_CAR_LIGHT_WIDTH, 78.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[15];
        if (temp == -1) {
            c.drawText("NONE", 40.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 40.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 40.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 40.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[16];
        if (temp2 == -1) {
            c.drawText("NONE", 932.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 932.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 932.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 932.0f, 132.0f, this.mPaint);
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
