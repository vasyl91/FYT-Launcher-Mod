package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_HC_Rongwei950 extends AirBase {
    public Air_0439_HC_Rongwei950(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_hechi_Rongwei950/hc_rongwei950.webp";
        this.mPathHighlight = "0439_hechi_Rongwei950/hc_rongwei950_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(149.0f, 101.0f, 277.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(165.0f, 22.0f, 261.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(759.0f, 11.0f, 884.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[36] == 0) {
            this.srPath.addRect(784.0f, 15.0f, 857.0f, 42.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(773.0f, 106.0f, 879.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(458.0f, 22.0f, 561.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(303.0f, 18.0f, 386.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(304.0f, 95.0f, 381.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(646.0f, 19.0f, 709.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(655.0f, 72.0f, 703.0f, 89.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(645.0f, 91.0f, 679.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[49] != 0) {
            this.srPath.addRect(648.0f, 127.0f, 729.0f, 162.0f, Path.Direction.CW);
        }
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(58.0f, 131.0f, (value2 * 21) + 58, 156.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(904.0f, 130.0f, (value3 * 21) + 904, 156.0f, Path.Direction.CW);
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(452.0f, 91.0f, (value * 18) + 452, 156.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 62.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 62.0f, 60.0f, this.mPaint);
        } else {
            int temp2 = (temp * 5) + 160;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + " ℃", 62.0f, 60.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 930.0f, 60.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 930.0f, 60.0f, this.mPaint);
        } else {
            int temp3 = (temp1 * 5) + 160;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10) + " ℃", 930.0f, 60.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
