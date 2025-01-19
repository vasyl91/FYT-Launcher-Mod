package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

public class AIR_0453_LZ_Honda_06Civic extends AirBase {
    public AIR_0453_LZ_Honda_06Civic(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/lz_06civic_air_n.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/lz_06civic_air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(206.0f, 105.0f, 286.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[79] != 0) {
            c.clipRect(198.0f, 19.0f, 297.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(341.0f, 48.0f, 474.0f, 124.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(537.0f, 31.0f, 600.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(528.0f, 75.0f, 586.0f, 99.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(516.0f, 96.0f, 563.0f, 133.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(102.0f, 102.0f, 159.0f, 154.0f, Region.Op.UNION);
            c.clipRect(960.0f, 101.0f, 1018.0f, 154.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value == 1) {
            c.clipRect(690.0f, 26.0f, 718.0f, 134.0f, Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(690.0f, 26.0f, 736.0f, 134.0f, Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(690.0f, 26.0f, 754.0f, 134.0f, Region.Op.UNION);
        } else if (value == 4) {
            c.clipRect(690.0f, 26.0f, 772.0f, 134.0f, Region.Op.UNION);
        } else if (value == 5) {
            c.clipRect(690.0f, 26.0f, 790.0f, 134.0f, Region.Op.UNION);
        } else if (value == 6) {
            c.clipRect(690.0f, 26.0f, 808.0f, 134.0f, Region.Op.UNION);
        } else if (value == 7) {
            c.clipRect(690.0f, 26.0f, 828.0f, 134.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 58.0f, 74.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 58.0f, 74.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NO", 58.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(left_temp / 10 + "." + (left_temp % 10), 58.0f, 74.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 915.0f, 74.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 915.0f, 74.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NO", 915.0f, 74.0f, this.mPaint);
        } else {
            c.drawText(right_temp / 10 + "." + (right_temp % 10), 915.0f, 74.0f, this.mPaint);
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
