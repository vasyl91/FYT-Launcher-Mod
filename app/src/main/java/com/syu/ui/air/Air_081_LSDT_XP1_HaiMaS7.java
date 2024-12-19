package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_081_LSDT_XP1_HaiMaS7 extends AirBase {
    public Air_081_LSDT_XP1_HaiMaS7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0157_daojun_xp1_haimam8s7/air_daojun_haimam8_n.webp";
        this.mPathHighlight = "0157_daojun_xp1_haimam8s7/air_daojun_haimam8_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[3] != 0) {
            c.clipRect(28.0f, 25.0f, 148.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(890.0f, 16.0f, 996.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(413.0f, 82.0f, 463.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(385.0f, 16.0f, 464.0f, 78.0f, Region.Op.UNION);
            c.clipRect(204.0f, 94.0f, 310.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(381.0f, 106.0f, 426.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[1] == 0) {
            c.clipRect(704.0f, 13.0f, 841.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(727.0f, 92.0f, 824.0f, 163.0f, Region.Op.UNION);
        }
        int value = this.DATA[5];
        c.clipRect(536.0f, 64.0f, (value * 18) + 536, 130.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int lef_temp = this.DATA[7];
        if (lef_temp == 0) {
            c.drawText("LO", 71.0f, 142.0f, this.mPaint);
        } else if (lef_temp == 28) {
            c.drawText("HI", 71.0f, 142.0f, this.mPaint);
        } else {
            int lef_temp2 = (lef_temp * 5) + 180;
            c.drawText(String.valueOf(lef_temp2 / 10) + "." + (lef_temp2 % 10), 71.0f, 142.0f, this.mPaint);
        }
        int right_temp = this.DATA[7];
        if (right_temp == 0) {
            c.drawText("LO", 915.0f, 142.0f, this.mPaint);
        } else if (right_temp == 28) {
            c.drawText("HI", 915.0f, 142.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 5) + 180;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 915.0f, 142.0f, this.mPaint);
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
