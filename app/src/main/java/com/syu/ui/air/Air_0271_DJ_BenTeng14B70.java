package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0271_DJ_BenTeng14B70 extends AirBase {
    public Air_0271_DJ_BenTeng14B70(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0271_dongjian_benteng14B70/dongjian14B70.webp";
        this.mPathHighlight = "0271_dongjian_benteng14B70/dongjian14B70_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[10] != 0) {
            c.clipRect(15.0f, 22.0f, 168.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(200.0f, 26.0f, 310.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(878.0f, 29.0f, 994.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(191.0f, 92.0f, 308.0f, 163.0f, Region.Op.UNION);
        }
        if (this.DATA[2] != 0) {
            c.clipRect(358.0f, 41.0f, 438.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(346.0f, 74.0f, 425.0f, 100.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(335.0f, 99.0f, 415.0f, 141.0f, Region.Op.UNION);
        }
        if (this.DATA[0] == 0) {
            c.clipRect(699.0f, 39.0f, 834.0f, 126.0f, Region.Op.UNION);
        }
        int value = this.DATA[7];
        if (value == 15) {
            c.clipRect(529.0f, 50.0f, 666.0f, 139.0f, Region.Op.UNION);
        } else {
            c.clipRect(529.0f, 50.0f, (value * 20) + 529, 139.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[8];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -1) {
            c.drawText("NONE", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 2.0f).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[9];
        if (right_temp == -2) {
            c.drawText("LOW", 906.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 906.0f, 152.0f, this.mPaint);
        } else if (right_temp == -1) {
            c.drawText("NONE", 906.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp / 2.0f).toString(), 906.0f, 152.0f, this.mPaint);
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
