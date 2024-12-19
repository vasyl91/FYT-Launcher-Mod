package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0006_RZC1_BydF3 extends AirBase {
    public Air_0006_RZC1_BydF3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0006_rzc1_bydf3/air_rzc1_bydf3.webp";
        this.mPathHighlight = "0006_rzc1_bydf3/air_rzc1_bydf3_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] == 0) {
            c.clipRect(400.0f, 28.0f, 497.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(500.0f, 40.0f, 600.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(704.0f, 25.0f, 793.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(718.0f, 100.0f, 795.0f, 158.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(899.0f, 33.0f, 965.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(242.0f, 66.0f, 276.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(217.0f, 84.0f, 243.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(887.0f, 110.0f, 987.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(43.0f, 107.0f, 134.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(119.0f, 31.0f, 163.0f, 78.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(383.0f, 132.0f, (value * 35) + 383, 150.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[11];
        if (temp == -1) {
            c.drawText("NO", 67.0f, 62.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 67.0f, 62.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 67.0f, 62.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 67.0f, 62.0f, this.mPaint);
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
