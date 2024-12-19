package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0452_OD_Porsche_All extends AirBase {
    public Air_0452_OD_Porsche_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_od_porsche/od_porsche.webp";
        this.mPathHighlight = "0452_od_porsche/od_porsche_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[7] != 0) {
            c.clipRect(303.0f, 22.0f, 433.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(602.0f, 10.0f, 717.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(184.0f, 28.0f, 269.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(5.0f, 20.0f, 137.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(896.0f, 23.0f, 1007.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(733.0f, 15.0f, 873.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(795.0f, 20.0f, 869.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(752.0f, 93.0f, 855.0f, 165.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(466.0f, 18.0f, 555.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(309.0f, 97.0f, 418.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(159.0f, 97.0f, 285.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(480.0f, 84.0f, 532.0f, 110.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(458.0f, 107.0f, 521.0f, 144.0f, Region.Op.UNION);
        }
        int value = this.DATA[17];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(613.0f, 91.0f, (value * 17) + 613, 161.0f, Region.Op.UNION);
        int unit = this.DATA[23];
        if (unit == 1) {
            c.clipRect(98.0f, 111.0f, 134.0f, 154.0f, Region.Op.UNION);
            c.clipRect(978.0f, 120.0f, 1014.0f, 157.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[18];
        if (temp == 0) {
            c.drawText("LOW", 65.0f, 140.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 65.0f, 140.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf((temp + 59) / 1.0f)).toString(), 65.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(((temp * 5) + 155) / 10.0f)).toString(), 65.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[19];
        if (temp2 == 0) {
            c.drawText("LOW", 930.0f, 140.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 930.0f, 140.0f, this.mPaint);
        } else if (unit == 1) {
            c.drawText(new StringBuilder(String.valueOf((temp2 + 59) / 1.0f)).toString(), 930.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(((temp2 * 5) + 155) / 10.0f)).toString(), 930.0f, 140.0f, this.mPaint);
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
