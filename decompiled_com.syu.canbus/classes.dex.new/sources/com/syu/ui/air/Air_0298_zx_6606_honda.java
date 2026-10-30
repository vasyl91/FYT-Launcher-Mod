package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0298_zx_6606_honda extends AirBase {
    public Air_0298_zx_6606_honda(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 164;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_zx_6606_honda_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_zx_6606_honda_p.webp";
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
            this.srPath.addRect(1074.0f, 96.0f, 1177.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(725.0f, 98.0f, 823.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(710.0f, 11.0f, 832.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(1078.0f, 19.0f, 1183.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(17.0f, 41.0f, 131.0f, 94.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(513.0f, 37.0f, 543.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(530.0f, 25.0f, 562.0f, 37.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(504.0f, 57.0f, 519.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(911.0f, 12.0f, 988.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(898.0f, 98.0f, 1006.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(95.0f, 101.0f, 142.0f, 141.0f, Path.Direction.CW);
            this.srPath.addRect(538.0f, 101.0f, 585.0f, 141.0f, Path.Direction.CW);
            this.srPath.addRect(1839.0f, 101.0f, 1888.0f, 141.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(168.0f, 109.0f, (value * 39) + 168, 138.0f, Path.Direction.CW);
        if (this.DATA[67] != 0) {
            this.srPath.addRect(1282.0f, 104.0f, 1441.0f, 138.0f, Path.Direction.CW);
        }
        if (this.DATA[48] != 0) {
            this.srPath.addRect(1342.0f, 36.0f, 1378.0f, 57.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(1365.0f, 23.0f, 1391.0f, 37.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(1331.0f, 55.0f, 1350.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(1781.0f, 35.0f, 1891.0f, 99.0f, Path.Direction.CW);
        }
        int valueRear = this.DATA[44];
        if (valueRear < 0) {
            valueRear = 0;
        } else if (valueRear > 7) {
            valueRear = 7;
        }
        this.srPath.addRect(1466.0f, 109.0f, (valueRear * 39) + 1466, 138.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("NO", 54.0f, 127.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 54.0f, 127.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 54.0f, 127.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp).toString(), 54.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 54.0f, 127.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 502.0f, 127.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 502.0f, 127.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 502.0f, 127.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp2).toString(), 502.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 502.0f, 127.0f, this.mPaint);
        }
        int temp3 = this.DATA[40];
        if (temp3 == -1) {
            c.drawText("NO", 1798.0f, 127.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LO", 1798.0f, 127.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 1798.0f, 127.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(temp3).toString(), 1798.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 2.0f).toString(), 1798.0f, 127.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(TheApp.getScreenWidth() / 1920.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
