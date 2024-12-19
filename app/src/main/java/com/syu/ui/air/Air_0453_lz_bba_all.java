package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_lz_bba_all extends AirBase {
    public Air_0453_lz_bba_all(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1920;
        this.mContentHeight = 180;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_lz_bba_all_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_lz_bba_all_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[19] != 0) {
            c.clipRect(909.0f, 12.0f, 1013.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(881.0f, 107.0f, 968.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[47] != 0) {
            c.clipRect(661.0f, 22.0f, 756.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(1140.0f, 24.0f, 1262.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(573.0f, 107.0f, 649.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(729.0f, 104.0f, 803.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 0) {
            c.clipRect(1216.0f, 99.0f, 1324.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(414.0f, 54.0f, 465.0f, 87.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(438.0f, 86.0f, 488.0f, 108.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(436.0f, 110.0f, 488.0f, 125.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(1462.0f, 55.0f, 1515.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(1490.0f, 83.0f, 1530.0f, 107.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(1483.0f, 107.0f, 1538.0f, 126.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(178.0f, 64.0f, 250.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(1665.0f, 65.0f, 1732.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[39] == 1) {
            c.clipRect(118.0f, 94.0f, 168.0f, 142.0f, Region.Op.UNION);
            c.clipRect(1858.0f, 96.0f, 1898.0f, 140.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[35];
        if (this.DATA[36] == 1) {
            c.drawText("Auto", 1130.0f, 145.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 1130.0f, 145.0f, this.mPaint);
        }
        int temp2 = this.DATA[37];
        c.drawText(new StringBuilder().append(temp2).toString(), 270.0f, 125.0f, this.mPaint);
        int temp3 = this.DATA[38];
        c.drawText(new StringBuilder().append(temp3).toString(), 1638.0f, 125.0f, this.mPaint);
        this.mPaint.setTextSize(40.0f);
        int temp4 = this.DATA[33];
        if (temp4 == -2) {
            c.drawText("LO", 65.0f, 126.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 65.0f, 126.0f, this.mPaint);
        } else if (this.DATA[39] == 1) {
            c.drawText(new StringBuilder().append(((temp4 * 9) / 10) + 32).toString(), 65.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp4 / 2.0f).toString(), 65.0f, 126.0f, this.mPaint);
        }
        int temp5 = this.DATA[34];
        if (temp5 == -2) {
            c.drawText("LO", 1813.0f, 126.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 1813.0f, 126.0f, this.mPaint);
        } else if (this.DATA[39] == 1) {
            c.drawText(new StringBuilder().append(((temp5 * 9) / 10) + 32).toString(), 1813.0f, 126.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp5 / 2.0f).toString(), 1813.0f, 126.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(1.0f, 1.0f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
