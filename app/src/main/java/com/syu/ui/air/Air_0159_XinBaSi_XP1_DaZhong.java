package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class Air_0159_XinBaSi_XP1_DaZhong extends AirBase {
    public Air_0159_XinBaSi_XP1_DaZhong(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0159_xbs_xp1_dazhong/air_xbs_xp1_dazhong.webp";
        this.mPathHighlight = "0159_xbs_xp1_dazhong/air_xbs_xp1_dazhong_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(162.0f, 26.0f, 268.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0 || this.DATA[16] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
            if (this.DATA[17] != 0) {
                c.clipRect(586.0f, 42.0f, 606.0f, 66.0f, Region.Op.UNION);
            }
            if (this.DATA[16] != 0) {
                c.clipRect(607.0f, 40.0f, 634.0f, 68.0f, Region.Op.UNION);
            }
        }
        if (this.DATA[3] != 0) {
            c.clipRect(686.0f, 27.0f, 744.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(643.0f, 37.0f, 681.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(319.0f, 25.0f, 336.0f, 49.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(340.0f, 49.0f, 367.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(320.0f, 64.0f, 340.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(788.0f, 100.0f, 855.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(785.0f, 17.0f, 860.0f, 73.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(430.0f, 127.0f, (value * 39) + 430, 154.0f, Region.Op.UNION);
        if (this.DATA[2] == 0) {
            c.clipRect(434.0f, 31.0f, 536.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 2) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[10];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(57.0f, 138.0f, (value2 * 21) + 57, 160.0f, Region.Op.UNION);
        int value3 = this.DATA[11];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(953.0f, 138.0f, (value3 * 21) + 953, 161.0f, Region.Op.UNION);
        if (this.DATA[14] != 0) {
            c.clipRect(154.0f, 106.0f, 281.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(328.0f, 126.0f, 388.0f, 155.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[4];
        if (temp == -1) {
            c.drawText("NONE", 45.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 45.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 45.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 45.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[13];
        if (temp2 == -1) {
            c.drawText("NONE", 940.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 940.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 940.0f, 60.0f, this.mPaint);
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
