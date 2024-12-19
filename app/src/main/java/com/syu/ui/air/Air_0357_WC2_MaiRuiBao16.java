package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0357_WC2_MaiRuiBao16 extends AirBase {
    public Air_0357_WC2_MaiRuiBao16(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0357_wc2_mairuibao16/air_wc2_gm_mairuibao_n.webp";
        this.mPathHighlight = "0357_wc2_mairuibao16/air_wc2_gm_mairuibao_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[71] != 0) {
            c.clipRect(152.0f, 17.0f, 284.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[92] == 1) {
            c.clipRect(311.0f, 24.0f, 419.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 1) {
            c.clipRect(771.0f, 127.0f, 838.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[72] == 2) {
            c.clipRect(756.0f, 94.0f, 843.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[73] != 0) {
            c.clipRect(329.0f, 95.0f, 398.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[74] == 0) {
            c.clipRect(740.0f, 8.0f, 862.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(765.0f, 61.0f, 839.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(480.0f, 65.0f, 544.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[75] != 0) {
            c.clipRect(464.0f, 10.0f, 551.0f, 65.0f, Region.Op.UNION);
        }
        if (this.DATA[89] != 0) {
            c.clipRect(465.0f, 96.0f, 554.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[79] != 0) {
            c.clipRect(624.0f, 135.0f, 689.0f, 161.0f, Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(619.0f, 14.0f, 686.0f, 58.0f, Region.Op.UNION);
        }
        if (this.DATA[76] != 0) {
            c.clipRect(616.0f, 60.0f, 659.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[77] != 0) {
            c.clipRect(622.0f, 82.0f, 667.0f, 97.0f, Region.Op.UNION);
        }
        if (this.DATA[78] != 0) {
            c.clipRect(612.0f, 98.0f, 646.0f, 127.0f, Region.Op.UNION);
        }
        int value = this.DATA[90];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(66.0f, 135.0f, (value * 19) + 66, 151.0f, Region.Op.UNION);
        int value2 = this.DATA[91];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(894.0f, 132.0f, (value2 * 19) + 894, 151.0f, Region.Op.UNION);
        int value3 = this.DATA[80];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 >= 8) {
            value3 = 8;
        }
        c.clipRect(163.0f, 115.0f, (value3 * 15) + 163, 166.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[81];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 70.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[82];
        if (temp2 == -2) {
            c.drawText("LOW", 935.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 935.0f, 72.0f, this.mPaint);
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
