package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0298_XP1_2016SIYU extends AirBase {
    public Air_0298_XP1_2016SIYU(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 260;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0298_xp1_2015siyu_crv/air_xp1_2016siyu_crv_n.webp";
        this.mPathHighlight = "0298_xp1_2015siyu_crv/air_xp1_2016siyu_crv_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[30] != 0) {
            c.clipRect(739.0f, 20.0f, 847.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(202.0f, 21.0f, 300.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(195.0f, 91.0f, 320.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[21] == 0) {
            c.clipRect(531.0f, 16.0f, 677.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(892.0f, 18.0f, 1008.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(352.0f, 11.0f, 445.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(387.0f, 85.0f, 451.0f, 115.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(359.0f, 112.0f, 409.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(13.0f, 17.0f, 163.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(733.0f, 94.0f, 855.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[33] == 1) {
            c.clipRect(124.0f, 113.0f, 169.0f, 161.0f, Region.Op.UNION);
            c.clipRect(970.0f, 107.0f, 1017.0f, 161.0f, Region.Op.UNION);
            c.clipRect(360.0f, 203.0f, 400.0f, 250.0f, Region.Op.UNION);
        }
        int value = this.DATA[29];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(548.0f, 95.0f, (value * 20) + 548, 161.0f, Region.Op.UNION);
        if (this.DATA[34] != 0) {
            c.clipRect(47.0f, 175.0f, 168.0f, 250.0f, Region.Op.UNION);
        }
        if (this.DATA[53] != 0) {
            c.clipRect(472.0f, 169.0f, 524.0f, 208.0f, Region.Op.UNION);
        }
        if (this.DATA[54] != 0) {
            c.clipRect(486.0f, 208.0f, 533.0f, 226.0f, Region.Op.UNION);
        }
        if (this.DATA[55] != 0) {
            c.clipRect(472.0f, 224.0f, 506.0f, 253.0f, Region.Op.UNION);
        }
        if (this.DATA[57] != 0) {
            c.clipRect(870.0f, 184.0f, 986.0f, 241.0f, Region.Op.UNION);
        }
        int valueRear = this.DATA[56];
        if (valueRear < 0) {
            valueRear = 0;
        } else if (valueRear > 7) {
            valueRear = 7;
        }
        c.clipRect(660.0f, 182.0f, (valueRear * 20) + 660, 250.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[25];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HIGH", 65.0f, 135.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(new StringBuilder().append(temp).toString(), 65.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 65.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[31];
        if (temp2 == -1) {
            c.drawText("NO", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HIGH", 930.0f, 135.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(new StringBuilder().append(temp2).toString(), 930.0f, 135.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 930.0f, 135.0f, this.mPaint);
        }
        int temp3 = this.DATA[52];
        if (temp3 == -1) {
            c.drawText("NO", 304.0f, 230.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 304.0f, 230.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HIGH", 304.0f, 230.0f, this.mPaint);
        } else if (this.DATA[33] == 1) {
            c.drawText(new StringBuilder().append(temp3).toString(), 304.0f, 230.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp3 / 2.0f).toString(), 304.0f, 230.0f, this.mPaint);
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
