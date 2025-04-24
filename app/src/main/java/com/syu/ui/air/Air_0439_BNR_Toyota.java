package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_BNR_Toyota extends AirBase {
    public Air_0439_BNR_Toyota(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0294_wc_toyota/vw_18prado_air.webp";
        this.mPathHighlight = "0294_wc_toyota/vw_18prado_air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[4] != 0) {
            c.clipRect(173.0f, 126.0f, 272.0f, 176.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(386.0f, 18.0f, 472.0f, 90.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(326.0f, 114.0f, 407.0f, 183.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(481.0f, 125.0f, 548.0f, 172.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(758.0f, 105.0f, 822.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(774.0f, 150.0f, 821.0f, 164.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(766.0f, 164.0f, 803.0f, 196.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(190.0f, 34.0f, 315.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(895.0f, 122.0f, 1016.0f, 181.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(549.0f, 34.0f, 644.0f, 77.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(612.0f, 136.0f, (value * 16) + 612, 186.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[11];
        if (temp == -1) {
            c.drawText("NONE", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else {
            if (temp >= 1 && temp <= 29) {
                temp = (temp + 35) * 5;
            } else if (temp >= 33 && temp <= 38) {
                temp = ((temp - 33) * 5) + 150;
            }
            c.drawText(String.valueOf(temp / 10.0f), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[12];
        if (temp2 == -1) {
            c.drawText("NONE", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 925.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 925.0f, 60.0f, this.mPaint);
        } else {
            if (temp2 >= 1 && temp2 <= 29) {
                temp2 = (temp2 + 35) * 5;
            } else if (temp2 >= 33 && temp2 <= 38) {
                temp2 = ((temp2 - 33) * 5) + 150;
            }
            c.drawText(String.valueOf(temp2 / 10.0f), 925.0f, 60.0f, this.mPaint);
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
