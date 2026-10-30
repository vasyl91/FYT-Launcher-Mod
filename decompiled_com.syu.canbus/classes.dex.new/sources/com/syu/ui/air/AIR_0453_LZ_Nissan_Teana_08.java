package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AIR_0453_LZ_Nissan_Teana_08 extends AirBase {
    public AIR_0453_LZ_Nissan_Teana_08(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/lz_nissan_08teana.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/lz_nissan_08teana_p.webp";
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
            this.srPath.addRect(753.0f, 100.0f, 854.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(10.0f, 26.0f, 140.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(308.0f, 102.0f, 425.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(596.0f, 102.0f, 715.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(602.0f, 22.0f, 713.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[34] != 0) {
            this.srPath.addRect(891.0f, 15.0f, 1015.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(171.0f, 12.0f, 271.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(178.0f, 94.0f, 269.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(458.0f, 10.0f, 538.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(465.0f, 91.0f, 520.0f, 119.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(454.0f, 118.0f, 501.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(296.0f, 11.0f, 436.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(106.0f, 118.0f, 142.0f, 157.0f, Path.Direction.CW);
            this.srPath.addRect(970.0f, 115.0f, 1016.0f, 157.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(753.0f, 38.0f, (value * 15) + 753, 83.0f, Path.Direction.CW);
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
        int unit = this.DATA[37];
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LOW", 56.0f, 138.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 56.0f, 138.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 56.0f, 138.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf(left_temp / 10)).toString(), 56.0f, 138.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 10) + "." + (left_temp % 10), 56.0f, 138.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LOW", 935.0f, 138.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 935.0f, 138.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 935.0f, 138.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf(right_temp / 10)).toString(), 935.0f, 138.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 10) + "." + (right_temp % 10), 935.0f, 138.0f, this.mPaint);
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
