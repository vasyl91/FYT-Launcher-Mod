package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0258_KeYuan_FYTA_ChuanQiGA6 extends AirBase {
    public Air_0258_KeYuan_FYTA_ChuanQiGA6(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0258_fyt_keyuan/air_fyt_keyuan_ga6_n.webp";
        this.mPathHighlight = "0258_fyt_keyuan/air_fyt_keyuan_ga6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[5] != 0) {
            c.clipRect(16.0f, 106.0f, 159.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(375.0f, 94.0f, 437.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(365.0f, 114.0f, 414.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(366.0f, 23.0f, 449.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(227.0f, 104.0f, 298.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(539.0f, 105.0f, 650.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(185.0f, 14.0f, 330.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(523.0f, 23.0f, 673.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(891.0f, 105.0f, 996.0f, 150.0f, Region.Op.UNION);
        }
        int value = this.DATA[1];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(716.0f, 50.0f, (value * 18) + 716, 113.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[11];
        if (left_temp == 0) {
            c.drawText("----", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 2.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int right_temp = this.DATA[12];
        if (right_temp == 0) {
            c.drawText("----", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 2.0f).toString(), 940.0f, 72.0f, this.mPaint);
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
