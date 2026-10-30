package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0294_WC2_Toyota_All extends AirBase {
    public Air_0294_WC2_Toyota_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0020_xp1_camry2013/air_bnr_camry2013.webp";
        this.mPathHighlight = "0020_xp1_camry2013/air_bnr_camry2013_p.webp";
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
        if (this.DATA[14] != 0) {
            this.srPath.addRect(192.0f, 24.0f, 317.0f, 73.0f, Path.Direction.CW);
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
        if (this.DATA[21] != 0) {
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
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit != 0 || this.DATA[37] == 1) {
            this.srPath.addRect(119.0f, 119.0f, 155.0f, 158.0f, Path.Direction.CW);
            this.srPath.addRect(976.0f, 120.0f, 1015.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(682.0f, 90.0f, 682.0f + (value * 19.4f), 156.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("NO", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 70.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 70.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 920.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 920.0f, 140.0f, this.mPaint);
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
