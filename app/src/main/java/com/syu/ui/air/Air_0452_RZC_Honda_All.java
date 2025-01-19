package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0452_RZC_Honda_All extends AirBase {
    public Air_0452_RZC_Honda_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 260;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_bnr_2016siyu_crv_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_bnr_2016siyu_crv_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[57] != 0) {
            c.clipRect(17.0f, 27.0f, 155.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[49] != 0) {
            c.clipRect(213.0f, 23.0f, 291.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[46] == 0) {
            c.clipRect(528.0f, 13.0f, 678.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[61] != 0) {
            c.clipRect(23.0f, 192.0f, 142.0f, 234.0f, Region.Op.UNION);
        }
        if (this.DATA[45] != 0) {
            c.clipRect(886.0f, 27.0f, 1008.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(738.0f, 23.0f, 855.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[48] != 0) {
            c.clipRect(348.0f, 21.0f, 473.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(383.0f, 86.0f, 437.0f, 120.0f, Region.Op.UNION);
        }
        if (this.DATA[51] != 0) {
            c.clipRect(389.0f, 122.0f, 433.0f, 136.0f, Region.Op.UNION);
        }
        if (this.DATA[52] != 0) {
            c.clipRect(383.0f, 137.0f, 416.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[68] != 0) {
            c.clipRect(761.0f, 82.0f, 810.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[69] != 0) {
            c.clipRect(765.0f, 120.0f, 811.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[70] != 0) {
            c.clipRect(759.0f, 135.0f, 796.0f, 166.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(196.0f, 87.0f, 302.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[58] == 1) {
            c.clipRect(122.0f, 108.0f, 166.0f, 164.0f, Region.Op.UNION);
            c.clipRect(973.0f, 107.0f, 1015.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[54];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(548.0f, 91.0f, 548.0f + (value * 19.5f), 163.0f, Region.Op.UNION);
        if (this.DATA[59] != 0) {
            c.clipRect(204.0f, 172.0f, 313.0f, 246.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[71];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(603.0f, 212.0f, (value2 * 20) + 603, 240.0f, Region.Op.UNION);
        int value3 = this.DATA[72];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(405.0f, 212.0f, (value3 * 20) + 405, 240.0f, Region.Op.UNION);
        int value4 = this.DATA[73];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 3) {
            value4 = 3;
        }
        c.clipRect(741.0f, 212.0f, (value4 * 20) + 741, 240.0f, Region.Op.UNION);
        int value5 = this.DATA[74];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 3) {
            value5 = 3;
        }
        c.clipRect(899.0f, 212.0f, (value5 * 20) + 899, 240.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[50];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 65.0f, 135.0f, this.mPaint);
        } else if (this.DATA[58] == 1) {
            c.drawText(String.valueOf(temp), 65.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 2.0f), 65.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[56];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 930.0f, 135.0f, this.mPaint);
        } else if (this.DATA[58] == 1) {
            c.drawText(String.valueOf(temp2), 930.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 2.0f), 930.0f, 135.0f, this.mPaint);
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
