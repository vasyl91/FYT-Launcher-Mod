package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_00345_WC2_GM2 extends AirBase {
    public Air_00345_WC2_GM2(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air.webp";
        this.mPathHighlight = "0036_wc2_gm/air_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[71] != 0) {
            c.clipRect(21.0f, 29.0f, 193.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[75] == 0) {
            c.clipRect(639.0f, 7.0f, 801.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(668.0f, 64.0f, 764.0f, 95.0f, Region.Op.UNION);
        }
        if (this.DATA[99] != 0) {
            c.clipRect(243.0f, 17.0f, 378.0f, 96.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 1) {
            c.clipRect(857.0f, 55.0f, 981.0f, 94.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 2) {
            c.clipRect(859.0f, 17.0f, 977.0f, 54.0f, Region.Op.UNION);
        }
        if (this.DATA[74] != 0) {
            c.clipRect(456.0f, 9.0f, 575.0f, 98.0f, Region.Op.UNION);
        }
        if (this.DATA[78] != 0) {
            c.clipRect(656.0f, 105.0f, 721.0f, 146.0f, Region.Op.UNION);
        }
        if (this.DATA[79] != 0) {
            c.clipRect(690.0f, 147.0f, 735.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[80] != 0) {
            c.clipRect(660.0f, 163.0f, 702.0f, 194.0f, Region.Op.UNION);
        }
        if (this.DATA[81] != 0) {
            c.clipRect(729.0f, 106.0f, 804.0f, 134.0f, Region.Op.UNION);
        }
        if (this.DATA[85] != 0) {
            c.clipRect(558.0f, 203.0f, 645.0f, 230.0f, Region.Op.UNION);
        }
        if (this.DATA[86] != 0) {
            c.clipRect(597.0f, 240.0f, 642.0f, 257.0f, Region.Op.UNION);
        }
        if (this.DATA[87] != 0) {
            c.clipRect(570.0f, 258.0f, 611.0f, 288.0f, Region.Op.UNION);
        }
        if (this.DATA[89] == 5) {
            c.clipRect(923.0f, 239.0f, 1000.0f, 274.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[89], 0, 4);
        if (value < 0) {
            value = 0;
        } else if (value > 4) {
            value = 0;
        }
        c.clipRect(830.0f, 219.0f, (value * 18) + 830, 286.0f, Region.Op.UNION);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (tempunit == 1) {
            c.clipRect(353.0f, 146.0f, 393.0f, 191.0f, Region.Op.UNION);
            c.clipRect(967.0f, 144.0f, 1009.0f, 194.0f, Region.Op.UNION);
            c.clipRect(408.0f, 242.0f, 448.0f, 284.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int frontLevel = this.DATA[82];
        if (frontLevel == 0) {
            c.drawText("OFF", 550.0f, 155.0f, this.mPaint);
        } else if (frontLevel == 19) {
            c.drawText("AUTO", 550.0f, 155.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 550.0f, 155.0f, this.mPaint);
        }
        int temp = this.DATA[83];
        if (temp == -2) {
            c.drawText("LOW", 295.0f, 155.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 295.0f, 155.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp * 9) + 320) / 10)), 295.0f, 155.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 295.0f, 155.0f, this.mPaint);
        }
        int temp3 = this.DATA[84];
        if (temp3 == -2) {
            c.drawText("LOW", 905.0f, 155.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 905.0f, 155.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp3 * 9) + 320) / 10)), 905.0f, 155.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp4 / 10), Integer.valueOf(temp4 % 10)), 905.0f, 155.0f, this.mPaint);
        }
        int temp5 = this.DATA[88];
        if (temp5 == -2) {
            c.drawText("LOW", 350.0f, 260.0f, this.mPaint);
        } else if (temp5 == -3) {
            c.drawText("HI", 350.0f, 260.0f, this.mPaint);
        } else if (temp5 == 0) {
            c.drawText("----", 350.0f, 260.0f, this.mPaint);
        } else if (tempunit == 1) {
            c.drawText(String.format("%d", Integer.valueOf(((temp5 * 9) + 320) / 10)), 350.0f, 260.0f, this.mPaint);
        } else {
            int temp6 = temp5 * 5;
            c.drawText(String.format("%d.%d", Integer.valueOf(temp6 / 10), Integer.valueOf(temp6 % 10)), 350.0f, 260.0f, this.mPaint);
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
