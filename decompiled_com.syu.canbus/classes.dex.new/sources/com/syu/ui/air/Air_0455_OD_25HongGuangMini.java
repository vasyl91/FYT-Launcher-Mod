package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_OD_25HongGuangMini extends AirBase {
    public Air_0455_OD_25HongGuangMini(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0020_xp1_camry2013/air_od_25mini_n.webp";
        this.mPathHighlight = "0020_xp1_camry2013/air_od_25mini_p.webp";
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
        if (this.DATA[62] != 0) {
            this.srPath.addRect(206.0f, 24.0f, 311.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(208.0f, 105.0f, 311.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(53.0f, 26.0f, 128.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(527.0f, 20.0f, 607.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(536.0f, 81.0f, 598.0f, 106.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(528.0f, 110.0f, 573.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(860.0f, 25.0f, 1004.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(681.0f, 17.0f, 820.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(372.0f, 16.0f, 471.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(378.0f, 92.0f, 474.0f, 162.0f, Path.Direction.CW);
        }
        int tempunit = this.DATA[37];
        if (tempunit != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(119.0f, 119.0f, 155.0f, 158.0f, Path.Direction.CW);
            this.srPath.addRect(976.0f, 120.0f, 1015.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(706.0f, 98.0f, 729.0f, 160.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(706.0f, 98.0f, 751.0f, 160.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(706.0f, 98.0f, 773.0f, 160.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(706.0f, 98.0f, 798.0f, 160.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(40.0f);
        int temp = this.DATA[27];
        if (temp == 1 || temp == 0) {
            c.drawText("LO", 70.0f, 140.0f, this.mPaint);
            c.drawText("LO", 920.0f, 140.0f, this.mPaint);
        } else if (temp == 6) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
            c.drawText("HI", 920.0f, 140.0f, this.mPaint);
        } else {
            int temp2 = (temp * 2) + 18;
            c.drawText(new StringBuilder().append(temp2 / 1.0f).toString(), 70.0f, 140.0f, this.mPaint);
            c.drawText(new StringBuilder().append(temp2 / 1.0f).toString(), 920.0f, 140.0f, this.mPaint);
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
