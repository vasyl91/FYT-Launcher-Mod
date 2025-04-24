package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0394_WC2_18_Zhipao extends AirBase {
    public Air_0394_WC2_18_Zhipao(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0394_wc2_18_qiyazhipao/air_wc2_qiya_zhipao_n.webp";
        this.mPathHighlight = "0394_wc2_18_qiyazhipao/air_wc2_qiya_zhipao_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(16.0f, 102.0f, 155.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(189.0f, 105.0f, 310.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(719.0f, 11.0f, 840.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(196.0f, 16.0f, 306.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(391.0f, 10.0f, 498.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(738.0f, 108.0f, 813.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(879.0f, 103.0f, 986.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(619.0f, 12.0f, 679.0f, 51.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(592.0f, 55.0f, 641.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(602.0f, 76.0f, 648.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(589.0f, 92.0f, 629.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(601.0f, 127.0f, 685.0f, 157.0f, Region.Op.UNION);
        }
        int value = this.DATA[10];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(374.0f, 92.0f, (value * 19) + 374, 160.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 76.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[11];
        if (temp2 == -2) {
            c.drawText("LOW", 940.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 940.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 940.0f, 72.0f, this.mPaint);
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
