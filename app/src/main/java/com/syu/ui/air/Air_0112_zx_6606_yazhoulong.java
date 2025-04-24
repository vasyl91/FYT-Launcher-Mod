package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0112_zx_6606_yazhoulong extends AirBase {
    public Air_0112_zx_6606_yazhoulong(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1280;
        this.mContentHeight = 132;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_zx_6606_yazhoulong_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_zx_6606_yazhoulong_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[65] != 0) {
            c.clipRect(832.0f, 8.0f, 913.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[64] != 0 || this.DATA[63] != 0) {
            c.clipRect(365.0f, 11.0f, 447.0f, 38.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0 || this.DATA[66] != 0) {
            c.clipRect(756.0f, 9.0f, 808.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(268.0f, 22.0f, 297.0f, 52.0f, Region.Op.UNION);
        }
        if (this.DATA[68] != 0) {
            c.clipRect(278.0f, 49.0f, 316.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[69] != 0) {
            c.clipRect(277.0f, 68.0f, 315.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[60] != 0) {
            c.clipRect(463.0f, 10.0f, 553.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[62] == 0) {
            c.clipRect(955.0f, 37.0f, 1042.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[149] == 1) {
            c.clipRect(388.0f, 37.0f, 403.0f, 48.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 2) {
            c.clipRect(388.0f, 37.0f, 413.0f, 48.0f, Region.Op.UNION);
        } else if (this.DATA[149] == 3) {
            c.clipRect(388.0f, 37.0f, 431.0f, 48.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(581.0f, 10.0f, 635.0f, 53.0f, Region.Op.UNION);
        }
        if (this.DATA[152] != 0) {
            c.clipRect(667.0f, 11.0f, 716.0f, 51.0f, Region.Op.UNION);
        }
        int value = this.DATA[70];
        if (value == 1) {
            c.clipRect(460.0f, 70.0f, 513.0f, 124.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(460.0f, 70.0f, 565.0f, 124.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(460.0f, 70.0f, 615.0f, 124.0f, Region.Op.UNION);
        } else if (value == 4) {
            c.clipRect(460.0f, 70.0f, 663.0f, 124.0f, Region.Op.UNION);
        } else if (value == 5) {
            c.clipRect(460.0f, 70.0f, 715.0f, 124.0f, Region.Op.UNION);
        } else if (value == 6) {
            c.clipRect(460.0f, 70.0f, 763.0f, 124.0f, Region.Op.UNION);
        } else if (value == 7) {
            c.clipRect(460.0f, 70.0f, 820.0f, 124.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[200];
        if (value2 == 1) {
            c.clipRect(128.0f, 99.0f, 148.0f, 109.0f, Region.Op.UNION);
        } else if (value2 == 2) {
            c.clipRect(128.0f, 99.0f, 161.0f, 109.0f, Region.Op.UNION);
        } else if (value2 == 3) {
            c.clipRect(128.0f, 99.0f, 177.0f, 109.0f, Region.Op.UNION);
        }
        int value3 = this.DATA[202];
        if (value3 == 1) {
            c.clipRect(40.0f, 100.0f, 56.0f, 111.0f, Region.Op.UNION);
        } else if (value3 == 2) {
            c.clipRect(40.0f, 100.0f, 68.0f, 111.0f, Region.Op.UNION);
        } else if (value3 == 3) {
            c.clipRect(40.0f, 100.0f, 82.0f, 111.0f, Region.Op.UNION);
        }
        int value4 = this.DATA[201];
        if (value4 == 1) {
            c.clipRect(1101.0f, 100.0f, 1123.0f, 109.0f, Region.Op.UNION);
        } else if (value4 == 2) {
            c.clipRect(1101.0f, 100.0f, 1135.0f, 109.0f, Region.Op.UNION);
        } else if (value4 == 3) {
            c.clipRect(1101.0f, 100.0f, 1151.0f, 109.0f, Region.Op.UNION);
        }
        int value5 = this.DATA[203];
        if (value5 == 1) {
            c.clipRect(1195.0f, 100.0f, 1215.0f, 108.0f, Region.Op.UNION);
        } else if (value5 == 2) {
            c.clipRect(1195.0f, 100.0f, 1227.0f, 108.0f, Region.Op.UNION);
        } else if (value5 == 3) {
            c.clipRect(1195.0f, 100.0f, 1243.0f, 108.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[71];
        if (temp == -1) {
            c.drawText("NO", 371.0f, 111.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 371.0f, 111.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 371.0f, 111.0f, this.mPaint);
        } else if (this.DATA[181] != 0) {
            c.drawText(String.valueOf(temp / 10.0f), 371.0f, 111.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 371.0f, 111.0f, this.mPaint);
        }
        int temp2 = this.DATA[72];
        if (temp2 == -1) {
            c.drawText("NO", 852.0f, 111.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 852.0f, 111.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 852.0f, 111.0f, this.mPaint);
        } else if (this.DATA[181] != 0) {
            c.drawText(String.valueOf(temp2 / 10.0f), 852.0f, 111.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 852.0f, 111.0f, this.mPaint);
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
