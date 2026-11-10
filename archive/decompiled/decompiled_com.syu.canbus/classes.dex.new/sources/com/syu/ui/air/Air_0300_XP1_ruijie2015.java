package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0300_XP1_ruijie2015 extends AirBase {
    public Air_0300_XP1_ruijie2015(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0300_xp1_ruijie2015/air_xp1_0300_ruijie_n.webp";
        this.mPathHighlight = "0300_xp1_ruijie2015/air_xp1_0300_ruijie_p.webp";
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
            this.srPath.addRect(264.0f, 31.0f, 381.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(403.0f, 39.0f, 489.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(289.0f, 122.0f, 348.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(537.0f, 127.0f, 613.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(396.0f, 130.0f, 498.0f, 163.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(532.0f, 39.0f, 627.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(656.0f, 131.0f, 754.0f, 173.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(661.0f, 25.0f, 740.0f, 89.0f, Path.Direction.CW);
        }
        if (this.DATA[11] == 1) {
            this.srPath.addRect(289.0f, 122.0f, 348.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(28.0f, 119.0f, 66.0f, 142.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(45.0f, 144.0f, 88.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(24.0f, 160.0f, 59.0f, 188.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(86.0f, 41.0f, 123.0f, 93.0f, Path.Direction.CW);
            this.srPath.addRect(961.0f, 34.0f, 1012.0f, 94.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(789.0f, 139.0f, (value * 15) + 789, 181.0f, Path.Direction.CW);
        int value2 = this.DATA[25];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        this.srPath.addRect(554.0f, 239.0f, (value2 * 15) + 554, 279.0f, Path.Direction.CW);
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        this.srPath.addRect(202.0f, 70.0f, (value3 * 21) + 202, 86.0f, Path.Direction.CW);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 2) {
            value4 = 2;
        }
        this.srPath.addRect(789.0f, 70.0f, (value4 * 21) + 789, 85.0f, Path.Direction.CW);
        if (this.DATA[24] != 0) {
            this.srPath.addRect(707.0f, 228.0f, 824.0f, 263.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(354.0f, 232.0f, 503.0f, 263.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -2) {
            c.drawText("LOW", 40.0f, 81.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 40.0f, 81.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText(" ", 40.0f, 81.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 40.0f, 81.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 81.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 81.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 930.0f, 81.0f, this.mPaint);
        }
        int hotOrColdFront = this.DATA[25];
        if ((hotOrColdFront < 15) & (hotOrColdFront >= 0)) {
            int ColdFront = 15 - hotOrColdFront;
            c.drawText("LV" + ColdFront, 989.0f, 159.0f, this.mPaint);
            c.drawText("", 221.0f, 159.0f, this.mPaint);
        } else {
            if ((hotOrColdFront <= 30) & (hotOrColdFront > 15)) {
                int hotFront = hotOrColdFront - 15;
                c.drawText("", 989.0f, 159.0f, this.mPaint);
                c.drawText("LV" + hotFront, 221.0f, 159.0f, this.mPaint);
            } else if (hotOrColdFront == 15) {
                c.drawText("", 989.0f, 159.0f, this.mPaint);
                c.drawText("", 221.0f, 159.0f, this.mPaint);
            }
        }
        int hotOrColdRear = this.DATA[23];
        if ((hotOrColdRear < 4) & (hotOrColdRear >= 0)) {
            int ColdFront2 = 4 - hotOrColdRear;
            c.drawText("LV" + ColdFront2, 948.0f, 261.0f, this.mPaint);
            c.drawText("", 272.0f, 261.0f, this.mPaint);
        } else {
            if ((hotOrColdRear <= 8) & (hotOrColdRear > 4)) {
                int hotFront2 = hotOrColdRear - 4;
                c.drawText("", 989.0f, 159.0f, this.mPaint);
                c.drawText("LV" + hotFront2, 272.0f, 261.0f, this.mPaint);
            } else if (hotOrColdRear == 4) {
                c.drawText("", 948.0f, 261.0f, this.mPaint);
                c.drawText("", 272.0f, 261.0f, this.mPaint);
            }
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
