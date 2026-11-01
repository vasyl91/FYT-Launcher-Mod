package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_LZ_Nissan_Infeiniti extends AirBase {
    public Air_0453_LZ_Nissan_Infeiniti(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0443_wc_infeinidi/air_wc2_infeinidi_n.webp";
        this.mPathHighlight = "0443_wc_infeinidi/air_wc2_infeinidi_p.webp";
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
            this.srPath.addRect(110.0f, 29.0f, 207.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(116.0f, 108.0f, 196.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 1) {
            this.srPath.addRect(230.0f, 19.0f, 325.0f, 63.0f, Path.Direction.CW);
        } else if (this.DATA[12] == 2) {
            this.srPath.addRect(246.0f, 61.0f, 308.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(372.0f, 24.0f, 452.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[72] != 0) {
            this.srPath.addRect(367.0f, 92.0f, 448.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(493.0f, 29.0f, 545.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(596.0f, 19.0f, 669.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(599.0f, 111.0f, 667.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(600.0f, 93.0f, 668.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(24.0f, 97.0f, 63.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(28.0f, 123.0f, 61.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(18.0f, 134.0f, 46.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(711.0f, 96.0f, 746.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(709.0f, 123.0f, 742.0f, 134.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(703.0f, 134.0f, 727.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(834.0f, 59.0f, 888.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(834.0f, 24.0f, 870.0f, 37.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(824.0f, 37.0f, 852.0f, 58.0f, Path.Direction.CW);
        }
        int TempUnit = this.DATA[37];
        if (TempUnit != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(67.0f, 46.0f, 105.0f, 80.0f, Path.Direction.CW);
            this.srPath.addRect(747.0f, 46.0f, 781.0f, 82.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 43.0f, 1011.0f, 76.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(235.0f, 102.0f, (value * 15) + 235, 152.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 5) {
            value2 = 5;
        }
        this.srPath.addRect(892.0f, 113.0f, (value2 * 15) + 892, 155.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LO", 41.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 41.0f, 72.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("NO", 41.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(temp / 10).toString(), 41.0f, 72.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(temp / 10).toString(), 41.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 41.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 724.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 724.0f, 72.0f, this.mPaint);
        } else if (temp2 == -1) {
            c.drawText("NO", 724.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(temp2 / 10).toString(), 724.0f, 72.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(temp2 / 10).toString(), 724.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 724.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -2) {
            c.drawText("LO", 954.0f, 72.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 954.0f, 72.0f, this.mPaint);
        } else if (temp3 == -1) {
            c.drawText("NO", 954.0f, 72.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(temp3 + 59).toString(), 954.0f, 72.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append((((((temp3 * 5) + 175) * 9) / 5) + 320) / 10).toString(), 954.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp3 * 5) + 175) / 10.0f).toString(), 954.0f, 72.0f, this.mPaint);
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
