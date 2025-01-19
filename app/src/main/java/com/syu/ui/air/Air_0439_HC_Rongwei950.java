package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0439_HC_Rongwei950 extends AirBase {
    public Air_0439_HC_Rongwei950(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hechi_Rongwei950/hc_rongwei950.webp";
        this.mPathHighlight = "0439_hechi_Rongwei950/hc_rongwei950_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(149.0f, 101.0f, 277.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(165.0f, 22.0f, 261.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(759.0f, 11.0f, 884.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[36] == 0) {
            c.clipRect(784.0f, 15.0f, 857.0f, 42.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(773.0f, 106.0f, 879.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(458.0f, 22.0f, 561.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(303.0f, 18.0f, 386.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(304.0f, 95.0f, 381.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(646.0f, 19.0f, 709.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(655.0f, 72.0f, 703.0f, 89.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(645.0f, 91.0f, 679.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(648.0f, 127.0f, 729.0f, 162.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(58.0f, 131.0f, (value2 * 21) + 58, 156.0f, Region.Op.UNION);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(904.0f, 130.0f, (value3 * 21) + 904, 156.0f, Region.Op.UNION);
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(452.0f, 91.0f, (value * 18) + 452, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 160;
            c.drawText(temp2 / 10 + "." + (temp2 % 10) + " ℃", 62.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            int temp12 = (temp1 * 5) + 160;
            c.drawText(temp12 / 10 + "." + (temp12 % 10) + " ℃", 930.0f, 60.0f, this.mPaint);
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
