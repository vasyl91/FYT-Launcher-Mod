package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_LZ_Binli extends AirBase {
    public Air_0439_LZ_Binli(Context context) {
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(3.0f, 23.0f, 121.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(145.0f, 29.0f, 234.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(156.0f, 103.0f, 226.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(274.0f, 28.0f, 334.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(260.0f, 106.0f, 345.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(373.0f, 17.0f, 462.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(686.0f, 12.0f, 766.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(374.0f, 90.0f, 417.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(379.0f, 113.0f, 419.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(378.0f, 123.0f, 406.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(499.0f, 94.0f, 643.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(794.0f, 106.0f, 888.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(910.0f, 19.0f, 1010.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(791.0f, 24.0f, 888.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(684.0f, 90.0f, 719.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(686.0f, 113.0f, 722.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(685.0f, 123.0f, 713.0f, 147.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(502.0f, 18.0f, (value * 18) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B10, 78.0f, Path.Direction.CW);
        int TempUnit = this.DATA[37];
        if (TempUnit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(980.0f, 120.0f, 1014.0f, 153.0f, Path.Direction.CW);
            this.srPath.addRect(86.0f, 117.0f, 118.0f, 155.0f, Path.Direction.CW);
        }
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NONE", 40.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 40.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 40.0f, 132.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(((temp * 10) + 280) / 10).toString(), 40.0f, 132.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((temp * 9) + 320) / 10.0f).toString(), 40.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 40.0f, 132.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NONE", 932.0f, 132.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 932.0f, 132.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 932.0f, 132.0f, this.mPaint);
        } else if (TempUnit == 1) {
            c.drawText(new StringBuilder().append(((temp2 * 10) + 280) / 10).toString(), 932.0f, 132.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((temp2 * 9) + 320) / 10.0f).toString(), 932.0f, 132.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 932.0f, 132.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
