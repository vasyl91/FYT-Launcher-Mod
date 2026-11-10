package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0274_DJ_XP1_ACCORD7 extends AirBase {
    public Air_0274_DJ_XP1_ACCORD7(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0274_dj_xp1_accord7/air_0274_dj_xp1_accord7_n.webp";
        this.mPathHighlight = "0274_dj_xp1_accord7/air_0274_dj_xp1_accord7_p.webp";
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
            this.srPath.addRect(166.0f, 20.0f, 276.0f, 74.0f, Path.Direction.CW);
        }
        switch (this.DATA[11]) {
            case 2:
                this.srPath.addRect(190.0f, 98.0f, 265.0f, 138.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(190.0f, 98.0f, 265.0f, 138.0f, Path.Direction.CW);
                this.srPath.addRect(191.0f, 140.0f, 254.0f, 160.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(9.0f, 24.0f, 133.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(896.0f, 13.0f, 1005.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(602.0f, 40.0f, 720.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(741.0f, 11.0f, 817.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(766.0f, 131.0f, 830.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(759.0f, 69.0f, 818.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(743.0f, 95.0f, 785.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(457.0f, 47.0f, 583.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(337.0f, 123.0f, 417.0f, 149.0f, Path.Direction.CW);
        }
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit == 1) {
            this.srPath.addRect(105.0f, 115.0f, 140.0f, 155.0f, Path.Direction.CW);
            this.srPath.addRect(976.0f, 116.0f, 1014.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(310.0f, 55.0f, (value * 18) + 310, 122.0f, Path.Direction.CW);
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
            c.drawText("LO", 60.0f, 136.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 60.0f, 136.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(new StringBuilder().append(((left_temp * 9) / 5) + 32).toString(), 60.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 60.0f, 136.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 930.0f, 136.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 136.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(new StringBuilder().append(((right_temp * 9) / 5) + 32).toString(), 930.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp).toString(), 930.0f, 136.0f, this.mPaint);
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
