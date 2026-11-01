package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_HC_Ford_Explorer extends AirBase {
    public Air_0439_HC_Ford_Explorer(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_hc_ford_explorer/hc_ford_explorer.webp";
        this.mPathHighlight = "0439_hc_ford_explorer/hc_ford_explorer_p.webp";
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
            this.srPath.addRect(113.0f, 26.0f, 205.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(454.0f, 43.0f, 502.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(357.0f, 27.0f, 436.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(602.0f, 30.0f, 679.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(227.0f, 19.0f, 324.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(526.0f, 94.0f, 590.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(524.0f, 40.0f, 593.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(524.0f, 13.0f, 593.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(447.0f, 14.0f, 510.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(450.0f, 98.0f, 508.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(244.0f, 90.0f, 300.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(374.0f, 90.0f, 410.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(372.0f, 112.0f, 403.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(367.0f, 124.0f, 391.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(367.0f, 144.0f, 425.0f, 166.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(876.0f, 112.0f, 947.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(811.0f, 107.0f, 872.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(961.0f, 116.0f, 992.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(956.0f, 130.0f, 977.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(68.0f, 42.0f, 100.0f, 83.0f, Path.Direction.CW);
            this.srPath.addRect(747.0f, 42.0f, 779.0f, 83.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(234.0f, 114.0f, (value * 13) + 234, 156.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        this.srPath.addRect(814.0f, 30.0f, (value2 * 13) + 814, 75.0f, Path.Direction.CW);
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(46.0f, 138.0f, (value3 * 19) + 46, 159.0f, Path.Direction.CW);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        this.srPath.addRect(746 - (value4 * 19), 138.0f, 746.0f, 159.0f, Path.Direction.CW);
        int value5 = this.DATA[31];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        this.srPath.addRect(153.0f, 138.0f, (value5 * 19) + 153, 159.0f, Path.Direction.CW);
        int value6 = this.DATA[32];
        if (value6 < 0) {
            value6 = 0;
        } else if (value6 > 3) {
            value6 = 3;
        }
        this.srPath.addRect(649 - (value6 * 19), 138.0f, 649.0f, 159.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int unit = this.DATA[37];
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 39.0f, 73.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 39.0f, 73.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 73.0f, this.mPaint);
        } else if (temp == 254) {
            c.drawText("OFF", 39.0f, 73.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder().append(temp).toString(), 39.0f, 73.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            temp = (temp * 9) + 320;
            c.drawText(new StringBuilder().append(temp * 0.1f).toString(), 39.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.5f).toString(), 39.0f, 73.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 722.0f, 73.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 722.0f, 73.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 722.0f, 73.0f, this.mPaint);
        } else if (temp1 == 254) {
            c.drawText("OFF", 722.0f, 73.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder().append(temp1).toString(), 722.0f, 73.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((temp * 9) + 320) * 0.1f).toString(), 722.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp1 * 0.5f).toString(), 722.0f, 73.0f, this.mPaint);
        }
        int temp2 = this.DATA[40];
        if (temp2 == -1) {
            c.drawText("NO", 974.0f, 73.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 974.0f, 73.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 974.0f, 73.0f, this.mPaint);
        } else if (temp2 == 0) {
            c.drawText("OFF", 974.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2).toString(), 974.0f, 73.0f, this.mPaint);
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
