package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0374_XP_ZhiNanZhe extends AirBase {
    public Air_0374_XP_ZhiNanZhe(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0374_xp_zhinanzhe/air_n.webp";
        this.mPathHighlight = "0374_xp_zhinanzhe/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(219.0f, 28.0f, 319.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(340.0f, 23.0f, 434.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[62] != 0) {
            c.clipRect(225.0f, 106.0f, 313.0f, 145.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 1) {
            c.clipRect(461.0f, 13.0f, 586.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(337.0f, 108.0f, 445.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(727.0f, 17.0f, 805.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(728.0f, 93.0f, 808.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(835.0f, 106.0f, 905.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(121.0f, 91.0f, 171.0f, 127.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(133.0f, 126.0f, 165.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(117.0f, 138.0f, 144.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(607.0f, 32.0f, 700.0f, 136.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(466.0f, 107.0f, (value * 17) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74, 161.0f, Region.Op.UNION);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        c.clipRect(48.0f, 49.0f, (value2 * 21) + 48, 80.0f, Region.Op.UNION);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        c.clipRect(970 - (value3 * 21), 49.0f, 970.0f, 80.0f, Region.Op.UNION);
        int value4 = this.DATA[31];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 2) {
            value4 = 2;
        }
        c.clipRect(158.0f, 49.0f, (value4 * 21) + 158, 80.0f, Region.Op.UNION);
        int value5 = this.DATA[32];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 2) {
            value5 = 2;
        }
        c.clipRect(878 - (value5 * 21), 49.0f, 878.0f, 80.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        int temp_unit = this.DATA[37];
        int temp_auto = this.DATA[36];
        if (temp == -1) {
            c.drawText("NO", 48.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 48.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 48.0f, 140.0f, this.mPaint);
        } else if (temp_auto == 1) {
            String str = "";
            int temp_type = (temp >> 6) & 3;
            int temp_data = temp & 31;
            if (temp_type == 1) {
                str = "COOL ";
            } else if (temp_type == 2) {
                str = "HOT ";
            }
            if (temp_data >= 8 && temp_data <= 24) {
                c.drawText(str + temp_data, 48.0f, 140.0f, this.mPaint);
            } else {
                c.drawText("---", 48.0f, 140.0f, this.mPaint);
            }
        } else if (temp_unit == 0) {
            c.drawText((temp / 2.0f) + " ℃", 48.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(temp + " ℉", 48.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 964.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 964.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 964.0f, 140.0f, this.mPaint);
        } else if (temp_auto == 1) {
            String str2 = "";
            int temp_type2 = (temp2 >> 6) & 3;
            int temp_data2 = temp2 & 31;
            if (temp_type2 == 1) {
                str2 = "COOL ";
            } else if (temp_type2 == 2) {
                str2 = "HOT ";
            }
            if (temp_data2 >= 8 && temp_data2 <= 24) {
                c.drawText(str2 + temp_data2, 964.0f, 140.0f, this.mPaint);
            } else {
                c.drawText("---", 964.0f, 140.0f, this.mPaint);
            }
        } else if (temp_unit == 0) {
            c.drawText((temp2 / 2.0f) + " ℃", 964.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(temp2 + " ℉", 964.0f, 140.0f, this.mPaint);
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
