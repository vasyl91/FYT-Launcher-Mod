package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0151_DAOJUN_XP1_BYDG6 extends AirBase {
    public Air_0151_DAOJUN_XP1_BYDG6(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0151_daojun_xp1_byds6/air_daojun_xp1_byds6_n.webp";
        this.mPathHighlight = "0151_daojun_xp1_byds6/air_daojun_xp1_byds6_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(22.0f, 15.0f, 138.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[24] == 2) {
            c.clipRect(202.0f, 90.0f, 279.0f, 132.0f, Region.Op.UNION);
        }
        if (this.DATA[24] == 0) {
            c.clipRect(204.0f, 133.0f, 264.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(343.0f, 100.0f, 388.0f, 138.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(367.0f, 68.0f, 424.0f, 101.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(337.0f, 11.0f, 427.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(364.0f, 138.0f, 435.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(174.0f, 14.0f, 291.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 2) {
            c.clipRect(698.0f, 89.0f, 854.0f, 144.0f, Region.Op.UNION);
        }
        if (this.DATA[20] == 1) {
            c.clipRect(903.0f, 18.0f, 1010.0f, 75.0f, Region.Op.UNION);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 0;
        }
        if (value == 8) {
            c.clipRect(548.0f, 127.0f, 615.0f, 155.0f, Region.Op.UNION);
        } else {
            c.clipRect(511.0f, 60.0f, (value * 20) + ConstRzcAddData.U_CAR_AVG_SPEED, 133.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[25];
        switch (temp) {
            case 1:
                c.drawText("LOW", 55.0f, 147.0f, this.mPaint);
                break;
            case 17:
                c.drawText("HI", 55.0f, 147.0f, this.mPaint);
                break;
            default:
                if (temp >= 2 && temp <= 16) {
                    int temp2 = (temp * 10) + 160;
                    c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 55.0f, 147.0f, this.mPaint);
                    break;
                } else {
                    c.drawText("NO", 55.0f, 147.0f, this.mPaint);
                    break;
                }
        }
        int temp3 = this.DATA[31];
        switch (temp3) {
            case 1:
                c.drawText("LOW", 927.0f, 147.0f, this.mPaint);
                break;
            case 17:
                c.drawText("HI", 927.0f, 147.0f, this.mPaint);
                break;
            default:
                if (temp3 >= 2 && temp3 <= 16) {
                    int temp4 = (temp3 * 10) + 160;
                    c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 927.0f, 147.0f, this.mPaint);
                    break;
                } else {
                    c.drawText("NO", 927.0f, 147.0f, this.mPaint);
                    break;
                }
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
