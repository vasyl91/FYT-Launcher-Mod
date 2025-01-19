package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

public class Air_0443_WC2_Opel_Old extends AirBase {
    public Air_0443_WC2_Opel_Old(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air_wc_old_opel.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_wc_old_opel_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[62] != 0) {
            c.clipRect(161.0f, 23.0f, 260.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(430.0f, 22.0f, 523.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[69] == 1) {
            c.clipRect(529.0f, 27.0f, 555.0f, 61.0f, Region.Op.UNION);
        } else if (this.DATA[69] == 2) {
            c.clipRect(524.0f, 23.0f, 594.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(452.0f, 95.0f, 540.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(311.0f, 17.0f, 382.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(641.0f, 16.0f, 716.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(754.0f, 23.0f, 874.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(815.0f, 18.0f, 877.0f, 71.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        if (value == 1) {
            c.clipRect(55.0f, 129.0f, 78.0f, 152.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(57.0f, 130.0f, 102.0f, 152.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(57.0f, 122.0f, 125.0f, 155.0f, Region.Op.UNION);
        }
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        if (value2 == 1) {
            c.clipRect(941.0f, 126.0f, 965.0f, 154.0f, Region.Op.UNION);
        } else if (value2 == 2) {
            c.clipRect(941.0f, 126.0f, 986.0f, 154.0f, Region.Op.UNION);
        } else if (value2 == 3) {
            c.clipRect(941.0f, 126.0f, 1009.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(166.0f, 92.0f, 208.0f, 114.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(178.0f, 112.0f, 217.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(170.0f, 125.0f, 201.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[66] != 0) {
            c.clipRect(766.0f, 92.0f, 852.0f, 164.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        c.drawText(String.valueOf(this.DATA[21]), 358.0f, 139.0f, this.mPaint);
        c.drawText(String.valueOf(this.DATA[21]), 692.0f, 139.0f, this.mPaint);
        int value3 = this.DATA[27];
        switch (value3) {
            case -3:
                c.drawText("HI", 51.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 51.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 51.0f, 67.0f, this.mPaint);
                break;
            default:
                int value4 = value3 * 5;
                c.drawText(value4 / 10 + "." + (value4 % 10), 51.0f, 67.0f, this.mPaint);
                break;
        }
        int value5 = this.DATA[28];
        switch (value5) {
            case -3:
                c.drawText("HI", 940.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 940.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 940.0f, 67.0f, this.mPaint);
                break;
            default:
                int value6 = value5 * 5;
                c.drawText(value6 / 10 + "." + (value6 % 10), 940.0f, 67.0f, this.mPaint);
                break;
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
