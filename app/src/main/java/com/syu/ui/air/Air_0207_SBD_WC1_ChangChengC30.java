package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0207_SBD_WC1_ChangChengC30 extends AirBase {
    public Air_0207_SBD_WC1_ChangChengC30(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0209_sbd_wc1_changchengc30/air_sbd_wc1_changchengc30.webp";
        this.mPathHighlight = "0209_sbd_wc1_changchengc30/air_sbd_wc1_changchengc30_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[2] != 0) {
            c.clipRect(225.0f, 90.0f, 343.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(689.0f, 88.0f, 802.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(384.0f, 18.0f, 481.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(512.0f, 19.0f, 650.0f, 70.0f, Region.Op.UNION);
        }
        switch (this.DATA[1]) {
            case 1:
                c.clipRect(425.0f, 92.0f, 567.0f, 161.0f, Region.Op.UNION);
                break;
            case 3:
                c.clipRect(427.0f, 90.0f, 614.0f, 157.0f, Region.Op.UNION);
                break;
        }
        if (this.DATA[8] != 0) {
            c.clipRect(250.0f, 6.0f, 298.0f, 33.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(265.0f, 32.0f, 310.0f, 54.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(236.0f, 50.0f, 281.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(742.0f, 8.0f, 795.0f, 32.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(733.0f, 30.0f, 777.0f, 55.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(764.0f, 49.0f, 800.0f, 79.0f, Region.Op.UNION);
        }
        int WindLevel = this.DATA[12];
        if (WindLevel < 0) {
            WindLevel = 0;
        } else if (WindLevel > 8) {
            WindLevel = 8;
        }
        c.clipRect(39.0f, 14.0f, (WindLevel * 17) + 39, 78.0f, Region.Op.UNION);
        int WindLevel2 = this.DATA[13];
        if (WindLevel2 < 0) {
            WindLevel2 = 0;
        } else if (WindLevel2 > 8) {
            WindLevel2 = 8;
        }
        c.clipRect(864.0f, 14.0f, (WindLevel2 * 17) + 864, 82.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[5];
        if (temp == -1) {
            c.drawText("No", 90.0f, 149.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("Low", 90.0f, 149.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 90.0f, 149.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp), 90.0f, 149.0f, this.mPaint);
        }
        int temp2 = this.DATA[14];
        if (temp2 == -1) {
            c.drawText("No", 915.0f, 149.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("Low", 915.0f, 149.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 915.0f, 149.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2), 915.0f, 149.0f, this.mPaint);
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
