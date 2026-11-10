package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0448_ZX_Ford_All extends AirBase {
    public Air_0448_ZX_Ford_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0448_lz_bmw/air_zx_ford_n.webp";
        this.mPathHighlight = "0448_lz_bmw/air_zx_ford_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int left_temp;
        int right_temp;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(474.0f, 13.0f, 548.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(288.0f, 103.0f, 342.0f, 121.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(290.0f, 120.0f, 331.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(308.0f, 132.0f, 335.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(611.0f, 110.0f, 666.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(633.0f, 18.0f, 719.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(705.0f, 93.0f, 766.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(794.0f, 97.0f, 867.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(288.0f, 14.0f, 410.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(370.0f, 108.0f, 441.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(150.0f, 105.0f, 236.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[29] != 0) {
            this.srPath.addRect(44.0f, 26.0f, 93.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[29] == 1) {
            this.srPath.addRect(45.0f, 63.0f, 60.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[29] == 2) {
            this.srPath.addRect(45.0f, 63.0f, 73.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[29] == 3) {
            this.srPath.addRect(45.0f, 63.0f, 88.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[30] != 0) {
            this.srPath.addRect(940.0f, 19.0f, 989.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[30] == 1) {
            this.srPath.addRect(940.0f, 63.0f, 956.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[30] == 2) {
            this.srPath.addRect(940.0f, 63.0f, 969.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[30] == 3) {
            this.srPath.addRect(940.0f, 63.0f, 983.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[31] != 0) {
            this.srPath.addRect(138.0f, 21.0f, 187.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[31] == 1) {
            this.srPath.addRect(144.0f, 64.0f, 156.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[31] == 2) {
            this.srPath.addRect(144.0f, 64.0f, 170.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[31] == 3) {
            this.srPath.addRect(144.0f, 64.0f, 185.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[32] != 0) {
            this.srPath.addRect(850.0f, 19.0f, 889.0f, 53.0f, Path.Direction.CW);
        }
        if (this.DATA[32] == 1) {
            this.srPath.addRect(847.0f, 64.0f, 860.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[32] == 2) {
            this.srPath.addRect(847.0f, 64.0f, 874.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[32] == 3) {
            this.srPath.addRect(847.0f, 64.0f, 889.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[21] == 1) {
            this.srPath.addRect(464.0f, 104.0f, 479.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 2) {
            this.srPath.addRect(464.0f, 104.0f, 493.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 3) {
            this.srPath.addRect(464.0f, 104.0f, 505.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 4) {
            this.srPath.addRect(464.0f, 104.0f, 519.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 5) {
            this.srPath.addRect(464.0f, 104.0f, 531.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 6) {
            this.srPath.addRect(464.0f, 104.0f, 544.0f, 152.0f, Path.Direction.CW);
        } else if (this.DATA[21] == 7) {
            this.srPath.addRect(464.0f, 104.0f, 559.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(77.0f, 127.0f, 103.0f, 159.0f, Path.Direction.CW);
            this.srPath.addRect(982.0f, 126.0f, 1015.0f, 160.0f, Path.Direction.CW);
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
        int left_temp2 = this.DATA[27];
        if (left_temp2 == -2) {
            c.drawText("LO", 42.0f, 147.0f, this.mPaint);
        } else if (left_temp2 == -3) {
            c.drawText("HI", 42.0f, 147.0f, this.mPaint);
        } else {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                left_temp = (left_temp2 * 9) + 590;
            } else {
                left_temp = (left_temp2 * 5) + 150;
            }
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || this.DATA[37] != 0) {
                c.drawText(new StringBuilder().append(left_temp / 10).toString(), 42.0f, 147.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 42.0f, 147.0f, this.mPaint);
            }
        }
        int right_temp2 = this.DATA[28];
        if (right_temp2 == -2) {
            c.drawText("LO", 947.0f, 147.0f, this.mPaint);
        } else if (right_temp2 == -3) {
            c.drawText("HI", 947.0f, 147.0f, this.mPaint);
        } else {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                right_temp = (right_temp2 * 9) + 590;
            } else {
                right_temp = (right_temp2 * 5) + 150;
            }
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || this.DATA[37] != 0) {
                c.drawText(new StringBuilder().append(right_temp / 10).toString(), 947.0f, 147.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(right_temp / 10.0f).toString(), 947.0f, 147.0f, this.mPaint);
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
