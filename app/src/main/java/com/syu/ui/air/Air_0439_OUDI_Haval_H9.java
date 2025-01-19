package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class Air_0439_OUDI_Haval_H9 extends AirBase {
    public Air_0439_OUDI_Haval_H9(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_haval_h9/oudi_haval_h9.webp";
        this.mPathHighlight = "0439_oudi_haval_h9/oudi_haval_h9_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp1;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(359.0f, 24.0f, 454.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(368.0f, 109.0f, 412.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(266.0f, 26.0f, 351.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(464.0f, 21.0f, 566.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(269.0f, 111.0f, 350.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(501.0f, 101.0f, 566.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(433.0f, 99.0f, 497.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(153.0f, 9.0f, 205.0f, 45.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(161.0f, 44.0f, 198.0f, 59.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(152.0f, 57.0f, 182.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(704.0f, 34.0f, 809.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(822.0f, 33.0f, 911.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(732.0f, 102.0f, 769.0f, 122.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(720.0f, 121.0f, 750.0f, 149.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(125.0f, 93.0f, (value * 15) + 125, 155.0f, Region.Op.UNION);
        int value1 = this.DATA[28];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 8) {
            value1 = 8;
        }
        c.clipRect(852.0f, 90.0f, (value1 * 17) + 852, 156.0f, Region.Op.UNION);
        int value2 = this.DATA[30];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(58.0f, 126.0f, (value2 * 20) + 58, 162.0f, Region.Op.UNION);
        int value3 = this.DATA[31];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        c.clipRect(593.0f, 129.0f, (value3 * 20) + 593, 159.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp2 = this.DATA[22];
        if (temp2 == -1) {
            c.drawText("NO", 45.0f, 63.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 45.0f, 63.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 45.0f, 63.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
                temp = (temp2 * 5) + 160;
            } else if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 8651204) {
                temp = ((temp2 - 112) * 5) + 160;
            } else {
                temp = ((temp2 - 116) * 5) + 160;
            }
            c.drawText(temp / 10 + "." + (temp % 10), 45.0f, 63.0f, this.mPaint);
        }
        int temp12 = this.DATA[23];
        if (temp12 == -1) {
            c.drawText("NO", 623.0f, 63.0f, this.mPaint);
        } else if (temp12 == -2) {
            c.drawText("LO", 623.0f, 63.0f, this.mPaint);
        } else if (temp12 == -3) {
            c.drawText("HI", 623.0f, 63.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
                temp1 = (temp12 * 5) + 160;
            } else if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                temp1 = ((temp12 - 112) * 5) + 160;
            } else {
                temp1 = ((temp12 - 116) * 5) + 160;
            }
            c.drawText(temp1 / 10 + "." + (temp1 % 10), 623.0f, 63.0f, this.mPaint);
        }
        int temp22 = this.DATA[29];
        if (temp22 == -1) {
            c.drawText("NO", 955.0f, 63.0f, this.mPaint);
        } else if (temp22 == -2) {
            c.drawText("LO", 955.0f, 63.0f, this.mPaint);
        } else if (temp22 == -3) {
            c.drawText("HI", 955.0f, 63.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
            int temp23 = (temp22 * 5) + 160;
            c.drawText(temp23 / 10 + "." + (temp23 % 10), 955.0f, 63.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
            if (temp22 == 0) {
                c.drawText("--.-", 955.0f, 63.0f, this.mPaint);
            } else {
                int temp24 = ((temp22 - 112) * 5) + 160;
                c.drawText(temp24 / 10 + "." + (temp24 % 10), 955.0f, 63.0f, this.mPaint);
            }
        } else if (temp22 == 0) {
            c.drawText("--.-", 955.0f, 63.0f, this.mPaint);
        } else {
            int temp25 = ((temp22 - 116) * 5) + 160;
            c.drawText(temp25 / 10 + "." + (temp25 % 10), 955.0f, 63.0f, this.mPaint);
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
