package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0257_DJ_ChuangQiGa6_H extends AirBase {
    public Air_0257_DJ_ChuangQiGa6_H(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0257_dj_chuangqiga6/air_257_dj_ga6.webp";
        this.mPathHighlight = "0257_dj_chuangqiga6/air_257_dj_ga6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[36] != 0) {
            c.clipRect(155.0f, 33.0f, 281.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[23] == 0) {
            c.clipRect(306.0f, 18.0f, 428.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(172.0f, 110.0f, 267.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(757.0f, 30.0f, 849.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(463.0f, 14.0f, 524.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(333.0f, 92.0f, 404.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(778.0f, 105.0f, 829.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(462.0f, 64.0f, 505.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(489.0f, 88.0f, 534.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(461.0f, 108.0f, 497.0f, 139.0f, Region.Op.UNION);
        }
        int value = this.DATA[31];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(599.0f, 73.0f, (value * 18) + 599, 126.0f, Region.Op.UNION);
        int value2 = this.DATA[32];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(68.0f, 53.0f, (value2 * 21) + 68, 72.0f, Region.Op.UNION);
        int value3 = this.DATA[33];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(897.0f, 56.0f, (value3 * 21) + 897, 71.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NONE", 64.0f, 148.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 64.0f, 148.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 64.0f, 148.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 64.0f, 148.0f, this.mPaint);
        }
        int temp2 = this.DATA[35];
        if (temp2 == -1) {
            c.drawText("NONE", 926.0f, 148.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 926.0f, 148.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 926.0f, 148.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 926.0f, 148.0f, this.mPaint);
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
