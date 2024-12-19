package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_HC_Volvo extends AirBase {
    public Air_0439_HC_Volvo(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_hechi_volvo/hc_volvo.webp";
        this.mPathHighlight = "0439_hechi_volvo/hc_volvo_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[1] != 0) {
            c.clipRect(149.0f, 101.0f, 277.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(165.0f, 22.0f, 261.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[3] == 0) {
            c.clipRect(759.0f, 11.0f, 884.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(773.0f, 106.0f, 879.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(458.0f, 22.0f, 561.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(303.0f, 18.0f, 386.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(304.0f, 95.0f, 381.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(641.0f, 26.0f, 710.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(654.0f, 88.0f, 704.0f, 112.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(642.0f, 108.0f, 678.0f, 147.0f, Region.Op.UNION);
        }
        int value2 = this.DATA[15];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(58.0f, 131.0f, (value2 * 21) + 58, 156.0f, Region.Op.UNION);
        int value3 = this.DATA[16];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        c.clipRect(904.0f, 130.0f, (value3 * 21) + 904, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[13];
        if (value < 0) {
            value = 0;
        } else if (value > 18) {
            value = 18;
        }
        c.drawText(new StringBuilder(String.valueOf(value)).toString(), 543.0f, 131.0f, this.mPaint);
        int temp = this.DATA[9];
        if (temp == -1) {
            c.drawText("NO", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 155;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + " ℃", 62.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[10];
        if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            int temp12 = (temp1 * 5) + 155;
            c.drawText(String.valueOf(temp12 / 10) + "." + (temp12 % 10) + " ℃", 930.0f, 60.0f, this.mPaint);
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
