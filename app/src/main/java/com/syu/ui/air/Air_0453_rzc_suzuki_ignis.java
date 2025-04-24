package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0453_rzc_suzuki_ignis extends AirBase {
    public Air_0453_rzc_suzuki_ignis(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_hc_ford_explorer/xc_feiyate_feiyue.webp";
        this.mPathHighlight = "0439_hc_ford_explorer/xc_feiyate_feiyue_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(244.0f, 105.0f, 344.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(400.0f, 30.0f, 450.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(116.0f, 23.0f, 188.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(303.0f, 26.0f, 374.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(202.0f, 20.0f, 282.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(482.0f, 98.0f, 557.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(490.0f, 20.0f, 555.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(386.0f, 96.0f, 425.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(389.0f, 122.0f, 419.0f, 135.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(380.0f, 132.0f, 406.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[42] != 0) {
            c.clipRect(715.0f, 111.0f, 829.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[67] != 0) {
            c.clipRect(942.0f, 97.0f, 1015.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[43] != 0) {
            c.clipRect(845.0f, 110.0f, 928.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[46] != 0) {
            c.clipRect(861.0f, 29.0f, 892.0f, 47.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(850.0f, 47.0f, 877.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(66.0f, 41.0f, 101.0f, 85.0f, Region.Op.UNION);
            c.clipRect(643.0f, 32.0f, 678.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(126.0f, 94.0f, (value * 13) + 126, 157.0f, Region.Op.UNION);
        int value2 = this.DATA[44];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 7) {
            value2 = 7;
        }
        c.clipRect(729.0f, 28.0f, (value2 * 13) + 729, 79.0f, Region.Op.UNION);
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(47.0f, 136.0f, (value3 * 18) + 47, 160.0f, Region.Op.UNION);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(637 - (value4 * 18), 132.0f, 637.0f, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 39.0f, 73.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 39.0f, 73.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 73.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.valueOf(temp / 10), 39.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 39.0f, 73.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 614.0f, 73.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 614.0f, 73.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 614.0f, 73.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(String.valueOf(temp1 / 10), 614.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp1 / 10.0f), 614.0f, 73.0f, this.mPaint);
        }
        int temp2 = this.DATA[40];
        if (temp2 == -1) {
            c.drawText("NO", 974.0f, 73.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 974.0f, 73.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 974.0f, 73.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(temp2 / 10 + "℉", 974.0f, 73.0f, this.mPaint);
        } else {
            c.drawText(temp2 / 10.0f + "℃", 974.0f, 73.0f, this.mPaint);
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
