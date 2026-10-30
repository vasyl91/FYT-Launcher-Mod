package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0017_WC2_TuAng_Wc extends AirBase {
    public Air_0017_WC2_TuAng_Wc(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc_tuang.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc_tuang_p.webp";
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
        if (this.DATA[76] != 0) {
            this.srPath.addRect(447.0f, 227.0f, 576.0f, 291.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(305.0f, 125.0f, 431.0f, 185.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(464.0f, 128.0f, 551.0f, 177.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(598.0f, 30.0f, 724.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(159.0f, 25.0f, 281.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(159.0f, 110.0f, 272.0f, 193.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(465.0f, 27.0f, 562.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(897.0f, 113.0f, 1021.0f, 166.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(757.0f, 103.0f, 824.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(773.0f, 150.0f, 823.0f, 165.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(764.0f, 164.0f, 803.0f, 197.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(620.0f, 239.0f, 668.0f, 258.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(609.0f, 257.0f, 648.0f, 287.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(152.0f, 215.0f, 291.0f, 275.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(881.0f, 220.0f, 1022.0f, 277.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(104.0f, 50.0f, 140.0f, 100.0f, Path.Direction.CW);
            this.srPath.addRect(980.0f, 50.0f, 1016.0f, 100.0f, Path.Direction.CW);
            this.srPath.addRect(401.0f, 240.0f, 437.0f, 290.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(615.0f, 124.0f, 615.0f + (value * 15.7f), 196.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        this.srPath.addRect(761.0f, 217.0f, 761.0f + (value2 * 15.7f), 289.0f, Path.Direction.CW);
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(363.0f, 58.0f, 363.0f + (value3 * 19.0f), 78.0f, Path.Direction.CW);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(809.0f - (value4 * 19.0f), 58.0f, 809.0f, 78.0f, Path.Direction.CW);
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
            c.drawText("LO", 62.0f, 71.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 71.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 62.0f, 71.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -2) {
            c.drawText("LO", 935.0f, 71.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 71.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 935.0f, 71.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -2) {
            c.drawText("LO", 353.0f, 264.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 353.0f, 264.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 10.0f).toString(), 353.0f, 264.0f, this.mPaint);
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
