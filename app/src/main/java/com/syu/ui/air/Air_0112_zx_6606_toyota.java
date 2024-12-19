package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        c.clipRect(this.mRectEmpty);
        if (this.DATA[65] != 0) {
            c.clipRect(1246.0f, 16.0f, 1348.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0 || this.DATA[63] != 0) {
            c.clipRect(570.0f, 21.0f, 675.0f, 55.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0 || this.DATA[66] != 0) {
            c.clipRect(1121.0f, 19.0f, 1207.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(412.0f, 55.0f, 466.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[68] != 0) {
            c.clipRect(442.0f, 85.0f, 483.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[69] != 0) {
            c.clipRect(436.0f, 107.0f, 489.0f, 129.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(701.0f, 23.0f, 841.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[62] == 0) {
            c.clipRect(1411.0f, 76.0f, 1546.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[149] == 1) {
            c.clipRect(592.0f, 55.0f, 613.0f, 69.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 2) {
            c.clipRect(592.0f, 55.0f, 633.0f, 69.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 3) {
            c.clipRect(592.0f, 55.0f, 654.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(871.0f, 18.0f, 946.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[152] != 0) {
            c.clipRect(999.0f, 14.0f, 1078.0f, 72.0f, Region.Op.UNION);
        }
        int value = this.DATA[70];
        if (value == 1) {
            c.clipRect(708.0f, 106.0f, 781.0f, 165.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(708.0f, 106.0f, 851.0f, 165.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(708.0f, 106.0f, 920.0f, 165.0f, Region.Op.UNION);
        } else if (value == 4) {
            c.clipRect(708.0f, 106.0f, 990.0f, 165.0f, Region.Op.UNION);
        } else if (value == 5) {
            c.clipRect(708.0f, 106.0f, 1061.0f, 165.0f, Region.Op.UNION);
        } else if (value == 6) {
            c.clipRect(708.0f, 106.0f, 1132.0f, 165.0f, Region.Op.UNION);
        } else if (value == 7) {
            c.clipRect(708.0f, 106.0f, 1216.0f, 165.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[200];
        if (value2 != 0) {
            c.clipRect(161.0f, 56.0f, 249.0f, 138.0f, Region.Op.UNION);
        }
        if (value2 == 1) {
            c.clipRect(178.0f, 137.0f, 196.0f, 150.0f, Region.Op.UNION);
        } else if (value2 == 2) {
            c.clipRect(178.0f, 137.0f, 213.0f, 150.0f, Region.Op.UNION);
        } else if (value2 == 3) {
            c.clipRect(178.0f, 137.0f, 232.0f, 150.0f, Region.Op.UNION);
        }
        int value3 = this.DATA[202];
        if (value3 != 0) {
            c.clipRect(26.0f, 58.0f, 140.0f, 137.0f, Region.Op.UNION);
        }
        if (value3 == 1) {
            c.clipRect(58.0f, 136.0f, 76.0f, 148.0f, Region.Op.UNION);
        } else if (value3 == 2) {
            c.clipRect(58.0f, 136.0f, 93.0f, 148.0f, Region.Op.UNION);
        } else if (value3 == 3) {
            c.clipRect(58.0f, 136.0f, 112.0f, 148.0f, Region.Op.UNION);
        }
        int value4 = this.DATA[201];
        if (value4 != 0) {
            c.clipRect(1786.0f, 55.0f, 1888.0f, 135.0f, Region.Op.UNION);
        }
        if (value4 == 1) {
            c.clipRect(1813.0f, 135.0f, 1830.0f, 150.0f, Region.Op.UNION);
        } else if (value4 == 2) {
            c.clipRect(1813.0f, 135.0f, 1846.0f, 150.0f, Region.Op.UNION);
        } else if (value4 == 3) {
            c.clipRect(1813.0f, 135.0f, 1865.0f, 150.0f, Region.Op.UNION);
        }
        int value5 = this.DATA[203];
        if (value5 != 0) {
            c.clipRect(1676.0f, 58.0f, 1758.0f, 134.0f, Region.Op.UNION);
        }
        if (value5 == 1) {
            c.clipRect(1693.0f, 134.0f, 1710.0f, 150.0f, Region.Op.UNION);
        } else if (value5 == 2) {
            c.clipRect(1693.0f, 134.0f, 1728.0f, 150.0f, Region.Op.UNION);
        } else if (value5 == 3) {
            c.clipRect(1693.0f, 134.0f, 1747.0f, 150.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[71];
        if (temp == -1) {
            c.drawText("NO", 635.0f, 143.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 635.0f, 143.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 635.0f, 143.0f, this.mPaint);
        } else if (this.DATA[181] != 0) {
            c.drawText(String.valueOf(temp / 10.0f) + " ℉", 635.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f) + " ℃", 635.0f, 143.0f, this.mPaint);
        }
        int temp2 = this.DATA[72];
        if (temp2 == -1) {
            c.drawText("NO", 1284.0f, 143.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 1284.0f, 143.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 1284.0f, 143.0f, this.mPaint);
        } else if (this.DATA[181] != 0) {
            c.drawText(String.valueOf(temp2 / 10.0f) + " ℉", 1284.0f, 143.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f) + " ℃", 1284.0f, 143.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(1.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
