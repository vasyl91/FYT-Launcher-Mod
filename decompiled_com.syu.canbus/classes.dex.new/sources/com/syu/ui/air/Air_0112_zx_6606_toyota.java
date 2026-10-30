package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0112_zx_6606_toyota extends AirBase {
    public Air_0112_zx_6606_toyota(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 180;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_zx_6606_toyota_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_zx_6606_toyota_p.webp";
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
            this.srPath.addRect(1246.0f, 16.0f, 1348.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0 || this.DATA[26] != 0) {
            this.srPath.addRect(570.0f, 21.0f, 675.0f, 55.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(1121.0f, 19.0f, 1207.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(412.0f, 55.0f, 466.0f, 89.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(442.0f, 85.0f, 483.0f, 107.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(436.0f, 107.0f, 489.0f, 129.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(701.0f, 23.0f, 841.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(1411.0f, 76.0f, 1546.0f, 147.0f, Path.Direction.CW);
        }
        if (this.DATA[166] == 1) {
            this.srPath.addRect(592.0f, 55.0f, 613.0f, 69.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 2) {
            this.srPath.addRect(592.0f, 55.0f, 633.0f, 69.0f, Path.Direction.CW);
        } else if (this.DATA[166] == 3) {
            this.srPath.addRect(592.0f, 55.0f, 654.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(871.0f, 18.0f, 946.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(999.0f, 14.0f, 1078.0f, 72.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value == 1) {
            this.srPath.addRect(708.0f, 106.0f, 781.0f, 165.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(708.0f, 106.0f, 851.0f, 165.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(708.0f, 106.0f, 920.0f, 165.0f, Path.Direction.CW);
        } else if (value == 4) {
            this.srPath.addRect(708.0f, 106.0f, 990.0f, 165.0f, Path.Direction.CW);
        } else if (value == 5) {
            this.srPath.addRect(708.0f, 106.0f, 1061.0f, 165.0f, Path.Direction.CW);
        } else if (value == 6) {
            this.srPath.addRect(708.0f, 106.0f, 1132.0f, 165.0f, Path.Direction.CW);
        } else if (value == 7) {
            this.srPath.addRect(708.0f, 106.0f, 1216.0f, 165.0f, Path.Direction.CW);
        }
        int value2 = this.DATA[29];
        if (value2 != 0) {
            this.srPath.addRect(161.0f, 56.0f, 249.0f, 138.0f, Path.Direction.CW);
        }
        if (value2 == 1) {
            this.srPath.addRect(178.0f, 137.0f, 196.0f, 150.0f, Path.Direction.CW);
        } else if (value2 == 2) {
            this.srPath.addRect(178.0f, 137.0f, 213.0f, 150.0f, Path.Direction.CW);
        } else if (value2 == 3) {
            this.srPath.addRect(178.0f, 137.0f, 232.0f, 150.0f, Path.Direction.CW);
        }
        int value3 = this.DATA[31];
        if (value3 != 0) {
            this.srPath.addRect(26.0f, 58.0f, 140.0f, 137.0f, Path.Direction.CW);
        }
        if (value3 == 1) {
            this.srPath.addRect(58.0f, 136.0f, 76.0f, 148.0f, Path.Direction.CW);
        } else if (value3 == 2) {
            this.srPath.addRect(58.0f, 136.0f, 93.0f, 148.0f, Path.Direction.CW);
        } else if (value3 == 3) {
            this.srPath.addRect(58.0f, 136.0f, 112.0f, 148.0f, Path.Direction.CW);
        }
        int value4 = this.DATA[30];
        if (value4 != 0) {
            this.srPath.addRect(1786.0f, 55.0f, 1888.0f, 135.0f, Path.Direction.CW);
        }
        if (value4 == 1) {
            this.srPath.addRect(1813.0f, 135.0f, 1830.0f, 150.0f, Path.Direction.CW);
        } else if (value4 == 2) {
            this.srPath.addRect(1813.0f, 135.0f, 1846.0f, 150.0f, Path.Direction.CW);
        } else if (value4 == 3) {
            this.srPath.addRect(1813.0f, 135.0f, 1865.0f, 150.0f, Path.Direction.CW);
        }
        int value5 = this.DATA[32];
        if (value5 != 0) {
            this.srPath.addRect(1676.0f, 58.0f, 1758.0f, 134.0f, Path.Direction.CW);
        }
        if (value5 == 1) {
            this.srPath.addRect(1693.0f, 134.0f, 1710.0f, 150.0f, Path.Direction.CW);
        } else if (value5 == 2) {
            this.srPath.addRect(1693.0f, 134.0f, 1728.0f, 150.0f, Path.Direction.CW);
        } else if (value5 == 3) {
            this.srPath.addRect(1693.0f, 134.0f, 1747.0f, 150.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("NO", 635.0f, 143.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 635.0f, 143.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 635.0f, 143.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(String.valueOf(temp / 10.0f) + " ℉", 635.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f) + " ℃", 635.0f, 143.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 1284.0f, 143.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1284.0f, 143.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1284.0f, 143.0f, this.mPaint);
        } else if (this.DATA[37] != 0) {
            c.drawText(String.valueOf(temp2 / 10.0f) + " ℉", 1284.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f) + " ℃", 1284.0f, 143.0f, this.mPaint);
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
