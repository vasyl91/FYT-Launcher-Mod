package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0444_WC2_IKCO_All extends AirBase {
    public Air_0444_WC2_IKCO_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_wc_ikco_all.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_wc_ikco_all_p.webp";
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
            this.srPath.addRect(350.0f, 21.0f, 527.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(906.0f, 118.0f, 1006.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(776.0f, 111.0f, 844.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(16.0f, 109.0f, 133.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(159.0f, 10.0f, 277.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(185.0f, 28.0f, 262.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(174.0f, 90.0f, 272.0f, 165.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(594.0f, 10.0f, 674.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(610.0f, 130.0f, 686.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(614.0f, 67.0f, 661.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(600.0f, 92.0f, 639.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(744.0f, 13.0f, 871.0f, 76.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(366.0f, 97.0f, (value * 19) + 366, 157.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 57.0f, 59.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 57.0f, 59.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((left_temp * 5) / 10.0f).toString(), 57.0f, 59.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 921.0f, 59.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 921.0f, 59.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((right_temp * 5) / 10.0f).toString(), 921.0f, 59.0f, this.mPaint);
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
