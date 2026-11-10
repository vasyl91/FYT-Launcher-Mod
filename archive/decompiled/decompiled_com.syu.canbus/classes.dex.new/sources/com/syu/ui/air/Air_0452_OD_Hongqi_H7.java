package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[11] != 0) {
            this.srPath.addRect(183.0f, 25.0f, 261.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(155.0f, 105.0f, 285.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[63] != 0) {
            this.srPath.addRect(318.0f, 13.0f, 407.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(323.0f, 93.0f, 366.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(344.0f, 124.0f, 379.0f, 140.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(324.0f, 136.0f, 353.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(461.0f, 25.0f, 563.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(607.0f, 26.0f, 719.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(612.0f, 94.0f, 717.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(749.0f, 20.0f, 861.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(758.0f, 106.0f, 846.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(459.0f, 117.0f, (value * 16) + 459, 163.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 <= 3) {
            this.srPath.addRect(31.0f, 19.0f, 93.0f, 76.0f, Path.Direction.CW);
        }
        int value3 = this.DATA[30];
        if (value3 <= 3) {
            this.srPath.addRect(929.0f, 24.0f, 998.0f, 77.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(20.0f);
        int value4 = this.DATA[29];
        if (value4 <= 3) {
            c.drawText(new StringBuilder().append(value4).toString(), 109.0f, 67.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value4 - 3).toString(), 109.0f, 67.0f, this.mPaint);
        }
        int value5 = this.DATA[30];
        if (value5 <= 3) {
            c.drawText(new StringBuilder().append(value5).toString(), 906.0f, 67.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(value5 - 3).toString(), 906.0f, 67.0f, this.mPaint);
        }
        this.mPaint.setTextSize(25.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 55.0f, 136.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 55.0f, 136.0f, this.mPaint);
        } else {
            int left_temp2 = (left_temp * 5) + 175;
            c.drawText(String.valueOf(left_temp2 / 10) + "." + (left_temp2 % 10), 55.0f, 136.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 937.0f, 136.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 937.0f, 136.0f, this.mPaint);
        } else {
            int right_temp2 = (right_temp * 5) + 175;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 937.0f, 136.0f, this.mPaint);
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
