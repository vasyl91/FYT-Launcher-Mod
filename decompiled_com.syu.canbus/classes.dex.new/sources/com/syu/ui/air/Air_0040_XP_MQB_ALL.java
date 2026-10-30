package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0040_XP_MQB_ALL extends AirBase {
    public Air_0040_XP_MQB_ALL(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp_mqb_all.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp_mqb_all_p.webp";
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
            this.srPath.addRect(142.0f, 24.0f, 271.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(122.0f, 105.0f, 199.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(220.0f, 97.0f, 293.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(228.0f, 97.0f, 282.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(313.0f, 18.0f, 388.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(324.0f, 94.0f, 368.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(329.0f, 122.0f, 360.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(325.0f, 134.0f, 348.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(412.0f, 20.0f, 476.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(411.0f, 101.0f, 479.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(500.0f, 16.0f, 583.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(498.0f, 107.0f, 587.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(594.0f, 40.0f, 680.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(611.0f, 18.0f, 664.0f, 40.0f, Path.Direction.CW);
        }
        if (this.DATA[48] != 0) {
            this.srPath.addRect(815.0f, 11.0f, 853.0f, 43.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(816.0f, 39.0f, 843.0f, 53.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(814.0f, 52.0f, 836.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(879.0f, 36.0f, 951.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(959.0f, 95.0f, 1016.0f, 118.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(66.0f, 41.0f, 104.0f, 84.0f, Path.Direction.CW);
            this.srPath.addRect(750.0f, 41.0f, 780.0f, 83.0f, Path.Direction.CW);
            this.srPath.addRect(996.0f, 30.0f, 1018.0f, 57.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if (value == 1) {
            this.srPath.addRect(58.0f, 137.0f, 73.0f, 156.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(58.0f, 137.0f, 85.0f, 156.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(58.0f, 137.0f, 100.0f, 156.0f, Path.Direction.CW);
        }
        int value2 = this.DATA[30];
        if (value2 == 1) {
            this.srPath.addRect(724.0f, 134.0f, 736.0f, 157.0f, Path.Direction.CW);
        } else if (value2 == 2) {
            this.srPath.addRect(710.0f, 134.0f, 736.0f, 157.0f, Path.Direction.CW);
        } else if (value2 == 3) {
            this.srPath.addRect(696.0f, 134.0f, 736.0f, 157.0f, Path.Direction.CW);
        }
        int value3 = this.DATA[88];
        if (value3 == 1) {
            this.srPath.addRect(837.0f, 135.0f, 850.0f, 153.0f, Path.Direction.CW);
        } else if (value3 == 2) {
            this.srPath.addRect(837.0f, 135.0f, 863.0f, 153.0f, Path.Direction.CW);
        } else if (value3 == 3) {
            this.srPath.addRect(837.0f, 135.0f, 876.0f, 153.0f, Path.Direction.CW);
        }
        int value4 = this.DATA[89];
        if (value4 == 1) {
            this.srPath.addRect(906.0f, 133.0f, 919.0f, 151.0f, Path.Direction.CW);
        } else if (value4 == 2) {
            this.srPath.addRect(894.0f, 133.0f, 919.0f, 151.0f, Path.Direction.CW);
        } else if (value4 == 3) {
            this.srPath.addRect(880.0f, 133.0f, 919.0f, 151.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(18.0f);
        int temp = this.DATA[27];
        if (temp == 0) {
            c.drawText("LOW", 31.0f, 64.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 31.0f, 64.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp + 59).toString(), 31.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp * 5) + 155) / 10.0f).toString(), 31.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == 0) {
            c.drawText("LOW", 717.0f, 64.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 717.0f, 64.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp2 + 59).toString(), 717.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp2 * 5) + 155) / 10.0f).toString(), 717.0f, 64.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == 0) {
            c.drawText("LOW", 979.0f, 64.0f, this.mPaint);
        } else if (temp3 == 31) {
            c.drawText("HI", 979.0f, 64.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp3 + 59).toString(), 979.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(((temp3 * 5) + 155) / 10.0f).toString(), 979.0f, 64.0f, this.mPaint);
        }
        c.drawText(new StringBuilder().append(this.DATA[21]).toString(), 649.0f, 142.0f, this.mPaint);
        c.drawText(new StringBuilder().append(this.DATA[44]).toString(), 1005.0f, 154.0f, this.mPaint);
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
