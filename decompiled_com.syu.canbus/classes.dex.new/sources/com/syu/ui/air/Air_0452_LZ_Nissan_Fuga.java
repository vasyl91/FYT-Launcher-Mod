package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_LZ_Nissan_Fuga extends AirBase {
    public Air_0452_LZ_Nissan_Fuga(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0008_wc1_bentengx80/air_nissan_fuga.webp";
        this.mPathHighlight = "0008_wc1_bentengx80/air_nissan_fuga_p.webp";
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
            this.srPath.addRect(274.0f, 111.0f, 373.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(390.0f, 25.0f, 486.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(292.0f, 22.0f, 361.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(627.0f, 19.0f, 737.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(393.0f, 102.0f, 482.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[72] != 0) {
            this.srPath.addRect(787.0f, 27.0f, 875.0f, 59.0f, Path.Direction.CW);
            this.srPath.addRect(153.0f, 25.0f, 237.0f, 59.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(508.0f, 9.0f, 591.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(517.0f, 101.0f, 585.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(141.0f, 70.0f, 197.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(142.0f, 104.0f, 183.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(782.0f, 60.0f, 829.0f, 103.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(776.0f, 104.0f, 819.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(81.0f, 118.0f, 112.0f, 155.0f, Path.Direction.CW);
            this.srPath.addRect(981.0f, 121.0f, 1018.0f, 154.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(630.0f, 96.0f, (value * 15) + 630, 154.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 52.0f, 91.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 52.0f, 91.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 52.0f, 91.0f, this.mPaint);
        } else if (unit == 1) {
            if (temp >= 1 && temp <= 31) {
                c.drawText(new StringBuilder().append((temp + 59) / 1.0f).toString(), 52.0f, 91.0f, this.mPaint);
            } else {
                c.drawText("NO", 52.0f, 91.0f, this.mPaint);
            }
        } else if (temp >= 1 && temp <= 29) {
            c.drawText(new StringBuilder().append(((temp * 5) + 175) / 10.0f).toString(), 52.0f, 91.0f, this.mPaint);
        } else {
            c.drawText("NO", 52.0f, 91.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 958.0f, 91.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 958.0f, 91.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 958.0f, 91.0f, this.mPaint);
        } else if (unit == 1) {
            if (temp2 >= 1 && temp2 <= 31) {
                c.drawText(new StringBuilder().append((temp2 + 59) / 1.0f).toString(), 958.0f, 91.0f, this.mPaint);
            } else {
                c.drawText("NO", 958.0f, 91.0f, this.mPaint);
            }
        } else if (temp2 >= 1 && temp2 <= 29) {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 175) / 10.0f).toString(), 958.0f, 91.0f, this.mPaint);
        } else {
            c.drawText("NO", 958.0f, 91.0f, this.mPaint);
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
