package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_RZC_Changan_ZhongTai extends AirBase {
    public Air_0439_RZC_Changan_ZhongTai(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_rzc_zhongtai/rzc_zhongtai.webp";
        this.mPathHighlight = "0439_rzc_zhongtai/rzc_zhongtai_p.webp";
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
            this.srPath.addRect(799.0f, 106.0f, 894.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(151.0f, 29.0f, 213.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(443.0f, 36.0f, 580.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(803.0f, 30.0f, 892.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(705.0f, 28.0f, 795.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(336.0f, 29.0f, 431.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(136.0f, 94.0f, 240.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(592.0f, 111.0f, 700.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(345.0f, 86.0f, 393.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(351.0f, 124.0f, 395.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(339.0f, 138.0f, 372.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(251.0f, 25.0f, 327.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(255.0f, 97.0f, 322.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(444.0f, 7.0f, 492.0f, 32.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(709.0f, 109.0f, 791.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(604.0f, 16.0f, 693.0f, 81.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(449.0f, 96.0f, (value * 17) + 449, 153.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(58.0f, 132.0f, 58.0f + (value2 * 22.0f), 157.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(966.0f - (value3 * 22.0f), 129.0f, 966.0f, 159.0f, Path.Direction.CW);
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
        if (DataCanbus.DATA[1000] == 852420) {
            c.drawText("None", 63.0f, 57.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            if (temp == -1) {
                c.drawText("NO", 63.0f, 57.0f, this.mPaint);
            } else if (temp == -2) {
                c.drawText("LOW", 63.0f, 57.0f, this.mPaint);
            } else if (temp == -3) {
                c.drawText("HI", 63.0f, 57.0f, this.mPaint);
            } else {
                int value1 = (temp * 5) + 175;
                c.drawText(String.valueOf(value1 / 10.0f) + " ℃", 63.0f, 57.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp)).toString(), 63.0f, 57.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (DataCanbus.DATA[1000] == 852420) {
            c.drawText("None", 957.0f, 57.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            if (temp1 == -1) {
                c.drawText("NO", 957.0f, 57.0f, this.mPaint);
            } else if (temp1 == -2) {
                c.drawText("LOW", 957.0f, 57.0f, this.mPaint);
            } else if (temp1 == -3) {
                c.drawText("HI", 957.0f, 57.0f, this.mPaint);
            } else {
                int value4 = (temp1 * 5) + 175;
                c.drawText(String.valueOf(value4 / 10.0f) + " ℃", 957.0f, 57.0f, this.mPaint);
            }
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp1)).toString(), 957.0f, 57.0f, this.mPaint);
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
