package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0371_BG_XP1_ZiYouGuang extends AirBase {
    public Air_0371_BG_XP1_ZiYouGuang(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0371_bg_ziyouguang/bg_ziyouguang.webp";
        this.mPathHighlight = "0371_bg_ziyouguang/bg_ziyouguang_p.webp";
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
            this.srPath.addRect(164.0f, 24.0f, 283.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(167.0f, 103.0f, 272.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(317.0f, 104.0f, 404.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(304.0f, 15.0f, 415.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(469.0f, 95.0f, 563.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(458.0f, 17.0f, 568.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(615.0f, 17.0f, 717.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(779.0f, 147.0f, 834.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(772.0f, 89.0f, 810.0f, 110.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(779.0f, 108.0f, 815.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(762.0f, 122.0f, 801.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 1) {
            this.srPath.addRect(748.0f, 14.0f, 868.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 1) {
            this.srPath.addRect(95.0f, 109.0f, 142.0f, 163.0f, Path.Direction.CW);
            this.srPath.addRect(969.0f, 111.0f, 1014.0f, 161.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(625.0f, 108.0f, (value * 13) + 625, 162.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(80.0f, 33.0f, (value2 * 20) + 80, 73.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(915.0f, 46.0f, (value3 * 20) + 915, 80.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 140.0f, this.mPaint);
        } else if ((temp >= 13 && temp <= 30) || (temp >= 60 && temp <= 84)) {
            c.drawText(new StringBuilder().append(temp).toString(), 70.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 70.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 941.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 941.0f, 140.0f, this.mPaint);
        } else if ((temp2 >= 13 && temp2 <= 30) || (temp2 >= 60 && temp2 <= 84)) {
            c.drawText(new StringBuilder().append(temp2).toString(), 941.0f, 140.0f, this.mPaint);
        } else {
            c.drawText("NONE", 941.0f, 140.0f, this.mPaint);
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
