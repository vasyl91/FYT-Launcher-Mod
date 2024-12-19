package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0058_XBS_XP1_haiMaM8 extends AirBase {
    public Air_0058_XBS_XP1_haiMaM8(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0058_xbs_xp1_haimam8/xinbasihaima_m8_n.webp";
        this.mPathHighlight = "0058_xbs_xp1_haimam8/xinbasihaima_m8_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[15] != 0) {
            c.clipRect(15.0f, 26.0f, 161.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(560.0f, 31.0f, 646.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(889.0f, 19.0f, 998.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(362.0f, 18.0f, 505.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(715.0f, 26.0f, 826.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(209.0f, 96.0f, 303.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(730.0f, 89.0f, 810.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(222.0f, 26.0f, 290.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(572.0f, 91.0f, 612.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(579.0f, 112.0f, 620.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(562.0f, 128.0f, 592.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(369.0f, 94.0f, (value * 21) + 369, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[9];
        if (temp == 0) {
            c.drawText("LO", 75.0f, 150.0f, this.mPaint);
        } else if (temp == 127) {
            c.drawText("HI", 75.0f, 150.0f, this.mPaint);
        } else if (temp > 31 && temp < 63) {
            if (temp % 2 != 0) {
                c.drawText(new StringBuilder().append((float) ((temp / 2) + 0.5d)).toString(), 75.0f, 150.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp / 2).toString(), 75.0f, 150.0f, this.mPaint);
            }
        }
        int temp2 = this.DATA[5];
        if (temp2 == 0) {
            c.drawText("LO", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 == 127) {
            c.drawText("HI", 930.0f, 150.0f, this.mPaint);
        } else if (temp2 > 31 && temp2 < 63) {
            if (temp2 % 2 != 0) {
                c.drawText(new StringBuilder().append((float) ((temp2 / 2) + 0.5d)).toString(), 930.0f, 150.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(temp2 / 2).toString(), 930.0f, 150.0f, this.mPaint);
            }
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
