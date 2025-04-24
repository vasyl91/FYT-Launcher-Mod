package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0375_SBD_BenTengX80 extends AirBase {
    public Air_0375_SBD_BenTengX80(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0008_wc1_bentengx80/air_fyta_bentengx80.webp";
        this.mPathHighlight = "0008_wc1_bentengx80/air_fyta_bentengx80_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(19.0f, 16.0f, 161.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[0] != 0) {
            c.clipRect(862.0f, 18.0f, 994.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(520.0f, 10.0f, 679.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(199.0f, 15.0f, 336.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(201.0f, 93.0f, 335.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(707.0f, 18.0f, 826.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(380.0f, 24.0f, 415.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(402.0f, 59.0f, 439.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(388.0f, 76.0f, 411.0f, 107.0f, Region.Op.UNION);
        }
        int value = this.DATA[11];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(517.0f, 123.0f, (value * 39) + ConstRzcAddData.U_CAR_LIGHT, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[6];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp / 10.0f), 70.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[7];
        if (temp2 == -1) {
            c.drawText("NO", 915.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 915.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 915.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(temp2 / 10.0f), 915.0f, 135.0f, this.mPaint);
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
