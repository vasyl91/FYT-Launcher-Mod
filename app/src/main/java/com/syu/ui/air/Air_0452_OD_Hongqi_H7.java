package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0452_OD_Hongqi_H7 extends AirBase {
    public Air_0452_OD_Hongqi_H7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_od_hongqi/air_hongqi_h7.webp";
        this.mPathHighlight = "0452_od_hongqi/air_hongqi_h7_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(183.0f, 25.0f, 261.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(155.0f, 105.0f, 285.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(318.0f, 13.0f, 407.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(323.0f, 93.0f, 366.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(344.0f, 124.0f, 379.0f, 140.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(324.0f, 136.0f, 353.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 1) {
            c.clipRect(461.0f, 25.0f, 563.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[6] == 0) {
            c.clipRect(607.0f, 26.0f, 719.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(612.0f, 94.0f, 717.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(749.0f, 20.0f, 861.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(758.0f, 106.0f, 846.0f, 156.0f, Region.Op.UNION);
        }
        int value = this.DATA[12];
        c.clipRect(459.0f, 117.0f, (value * 16) + 459, 163.0f, Region.Op.UNION);
        int value2 = this.DATA[15];
        if (value2 <= 3) {
            c.clipRect(31.0f, 19.0f, 93.0f, 76.0f, Region.Op.UNION);
        }
        int value3 = this.DATA[16];
        if (value3 <= 3) {
            c.clipRect(929.0f, 24.0f, 998.0f, 77.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(20.0f);
        int value4 = this.DATA[15];
        if (value4 <= 3) {
            c.drawText(new StringBuilder().append(value4).toString(), 109.0f, 67.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value4 - 3).toString(), 109.0f, 67.0f, this.mPaint);
        }
        int value5 = this.DATA[16];
        if (value5 <= 3) {
            c.drawText(new StringBuilder().append(value5).toString(), 906.0f, 67.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value5 - 3).toString(), 906.0f, 67.0f, this.mPaint);
        }
        this.mPaint.setTextSize(25.0f);
        int left_temp = this.DATA[13];
        if (left_temp == -2) {
            c.drawText("LOW", 55.0f, 136.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 55.0f, 136.0f, this.mPaint);
        } else {
            int left_temp2 = (left_temp * 5) + 175;
            c.drawText(String.valueOf(left_temp2 / 10) + "." + (left_temp2 % 10), 55.0f, 136.0f, this.mPaint);
        }
        int right_temp = this.DATA[14];
        if (right_temp == -2) {
            c.drawText("LOW", 937.0f, 136.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 937.0f, 136.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 5) + 175;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 937.0f, 136.0f, this.mPaint);
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
