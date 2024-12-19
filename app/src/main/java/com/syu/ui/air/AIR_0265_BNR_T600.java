package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[31] != 0) {
            c.clipRect(195.0f, 24.0f, 319.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(47.0f, 99.0f, 128.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(191.0f, 97.0f, 325.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(893.0f, 89.0f, 989.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[40] != 0) {
            c.clipRect(553.0f, 15.0f, 649.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(562.0f, 93.0f, 647.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(380.0f, 22.0f, 454.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(391.0f, 90.0f, 449.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(376.0f, 113.0f, 421.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(123.0f, 38.0f, 165.0f, 82.0f, Region.Op.UNION);
            c.clipRect(977.0f, 38.0f, 1019.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 1) {
            c.clipRect(699.0f, 12.0f, 836.0f, 83.0f, Region.Op.UNION);
        }
        int value = this.DATA[37];
        c.clipRect(724.0f, 115.0f, (value * 15) + 724, 162.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int val = this.DATA[42];
        int unit = this.DATA[38];
        String str = "";
        int airtype = this.DATA[85];
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
                        if (unit == 1) {
                            str = String.valueOf(((val - 3) / 2) + 65) + " ℉";
                            break;
                        } else {
                            str = String.valueOf(m) + " ℃";
                            break;
                        }
                    } else {
                        str = "NONE";
                        break;
                    }
            }
        }
        c.drawText(str, 68.0f, 55.0f, this.mPaint);
        int val2 = this.DATA[39];
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
                        if (unit == 1) {
                            str2 = String.valueOf(((val2 - 3) / 2) + 65) + " ℉";
                            break;
                        } else {
                            str2 = String.valueOf(m2) + " ℃";
                            break;
                        }
                    } else {
                        str2 = "NONE";
                        break;
                    }
            }
        }
        c.drawText(str2, 926.0f, 55.0f, this.mPaint);
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
