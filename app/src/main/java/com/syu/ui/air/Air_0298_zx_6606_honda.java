package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0298_zx_6606_honda extends AirBase {
    public Air_0298_zx_6606_honda(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 164;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_zx_6606_honda_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_zx_6606_honda_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(1074.0f, 96.0f, 1177.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(725.0f, 98.0f, 823.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(710.0f, 11.0f, 832.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 0) {
            c.clipRect(1078.0f, 19.0f, 1183.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(17.0f, 41.0f, 131.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(513.0f, 37.0f, 543.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(530.0f, 25.0f, 562.0f, 37.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(504.0f, 57.0f, 519.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(911.0f, 12.0f, 988.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(898.0f, 98.0f, 1006.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[33] == 1) {
            c.clipRect(95.0f, 101.0f, 142.0f, 141.0f, Region.Op.UNION);
            c.clipRect(538.0f, 101.0f, 585.0f, 141.0f, Region.Op.UNION);
            c.clipRect(1839.0f, 101.0f, 1888.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(168.0f, 109.0f, (value * 39) + 168, 138.0f, Region.Op.UNION);
        if (this.DATA[34] != 0) {
            c.clipRect(1282.0f, 104.0f, 1441.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(1342.0f, 36.0f, 1378.0f, 57.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(1365.0f, 23.0f, 1391.0f, 37.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(1331.0f, 55.0f, 1350.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[57] != 0) {
            c.clipRect(1781.0f, 35.0f, 1891.0f, 99.0f, Region.Op.UNION);
        }
        int valueRear = this.DATA[56];
        if (valueRear < 0) {
            valueRear = 0;
        } else if (valueRear > 7) {
            valueRear = 7;
        }
        c.clipRect(1466.0f, 109.0f, (valueRear * 39) + 1466, 138.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[25];
        if (temp == -1) {
            c.drawText("NO", 54.0f, 127.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 54.0f, 127.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 54.0f, 127.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(String.valueOf(temp), 54.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 54.0f, 127.0f, this.mPaint);
        }
        int temp2 = this.DATA[31];
        if (temp2 == -1) {
            c.drawText("NO", 502.0f, 127.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 502.0f, 127.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 502.0f, 127.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(String.valueOf(temp2), 502.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 502.0f, 127.0f, this.mPaint);
        }
        int temp3 = this.DATA[52];
        if (temp3 == -1) {
            c.drawText("NO", 1798.0f, 127.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LO", 1798.0f, 127.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 1798.0f, 127.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(String.valueOf(temp3), 1798.0f, 127.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp3 / 2.0f), 1798.0f, 127.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(LauncherApplication.getScreenWidth() / 1920.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
