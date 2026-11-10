package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AIR_0265_BNR_T600 extends AirBase {
    public AIR_0265_BNR_T600(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/bnt_t600.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/bnt_t600_p.webp";
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
            this.srPath.addRect(195.0f, 24.0f, 319.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(47.0f, 99.0f, 128.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(191.0f, 97.0f, 325.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[58] != 0) {
            this.srPath.addRect(893.0f, 89.0f, 989.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(553.0f, 15.0f, 649.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(562.0f, 93.0f, 647.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(380.0f, 22.0f, 454.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(391.0f, 90.0f, 449.0f, 115.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(376.0f, 113.0f, 421.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(123.0f, 38.0f, 165.0f, 82.0f, Path.Direction.CW);
            this.srPath.addRect(977.0f, 38.0f, 1019.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(699.0f, 12.0f, 836.0f, 83.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(724.0f, 115.0f, (value * 15) + 724, 162.0f, Path.Direction.CW);
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
        int val = this.DATA[27];
        int unit = this.DATA[37];
        String str = "";
        int airtype = this.DATA[151];
        if (airtype != 2) {
            if (val == 0) {
                str = "NONE";
            } else if (val > 0 && val < 16) {
                str = "Lv " + val;
            }
        } else {
            switch (val) {
                case 1:
                    str = "LO";
                    break;
                case 57:
                    str = "HI";
                    break;
                default:
                    if (val < 56 && val > 2) {
                        float m = 18.0f + (((val - 1) / 2) * 0.5f);
                        str = unit == 1 ? String.valueOf(((val - 3) / 2) + 65) + " ℉" : String.valueOf(m) + " ℃";
                    } else {
                        str = "NONE";
                    }
                    break;
            }
        }
        c.drawText(str, 68.0f, 55.0f, this.mPaint);
        int val2 = this.DATA[28];
        String str2 = "";
        if (airtype != 2) {
            if (val2 == 0) {
                str2 = "NONE";
            } else if (val2 > 0 && val2 < 16) {
                str2 = "Lv " + val2;
            }
        } else {
            switch (val2) {
                case 1:
                    str2 = "LO";
                    break;
                case 57:
                    str2 = "HI";
                    break;
                default:
                    if (val2 < 56 && val2 > 2) {
                        float m2 = 18.0f + (((val2 - 1) / 2) * 0.5f);
                        str2 = unit == 1 ? String.valueOf(((val2 - 3) / 2) + 65) + " ℉" : String.valueOf(m2) + " ℃";
                    } else {
                        str2 = "NONE";
                    }
                    break;
            }
        }
        c.drawText(str2, 926.0f, 55.0f, this.mPaint);
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
