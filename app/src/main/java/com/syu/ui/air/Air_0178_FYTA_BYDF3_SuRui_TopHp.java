package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0178_FYTA_BYDF3_SuRui_TopHp extends AirBase {
    public Air_0178_FYTA_BYDF3_SuRui_TopHp(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0178_fyta_bydf3_surui/air_fyta_bydf3_suruitop.webp";
        this.mPathHighlight = "0178_fyta_bydf3_surui/air_fyta_bydf3_suruitop_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(786.0f, 28.0f, 884.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(23.0f, 104.0f, 120.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(833.0f, 108.0f, 973.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(162.0f, 16.0f, 232.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(281.0f, 95.0f, 366.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(156.0f, 109.0f, 231.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(275.0f, 17.0f, 367.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(434.0f, 29.0f, 505.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(447.0f, 85.0f, 494.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(433.0f, 108.0f, 471.0f, 139.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(597.0f, 16.0f, 747.0f, 79.0f, Region.Op.UNION);
        }
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(609.0f, 89.0f, (value * 19) + 609, 157.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[24];
        if (temp == -1) {
            c.drawText("NO", 51.0f, 51.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 51.0f, 51.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 51.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 51.0f, 51.0f, this.mPaint);
        }
        int temp2 = this.DATA[25];
        if (temp2 == -1) {
            c.drawText("NO", 947.0f, 51.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 947.0f, 51.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 947.0f, 51.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 947.0f, 51.0f, this.mPaint);
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
