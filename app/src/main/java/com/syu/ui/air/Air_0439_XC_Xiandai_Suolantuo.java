package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0439_XC_Xiandai_Suolantuo extends AirBase {
    public Air_0439_XC_Xiandai_Suolantuo(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0355_xp_qiyak5/air_xp_qiya_k5_n.webp";
        this.mPathHighlight = "0355_xp_qiyak5/air_xp_qiya_k5_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(190.0f, 18.0f, 341.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(212.0f, 109.0f, 303.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(25.0f, 106.0f, 146.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(895.0f, 106.0f, 1006.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(536.0f, 32.0f, 661.0f, 137.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(384.0f, 52.0f, 432.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(398.0f, 76.0f, 447.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(387.0f, 92.0f, 423.0f, 123.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(701.0f, 95.0f, 842.0f, 159.0f, Region.Op.UNION);
        }
        int value = this.DATA[8];
        c.clipRect(712.0f, 19.0f, (value * 18) + 712, 79.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[12];
        if (left_temp == -2) {
            c.drawText("LO", 70.0f, 55.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 70.0f, 55.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("No", 70.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(left_temp / 2.0f), 70.0f, 55.0f, this.mPaint);
        }
        int right_temp = this.DATA[13];
        if (right_temp == -2) {
            c.drawText("LO", 930.0f, 55.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 55.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("No", 930.0f, 55.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(right_temp / 2.0f), 930.0f, 55.0f, this.mPaint);
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
