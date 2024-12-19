package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0417_CYT_YaGe7_38400 extends AirBase {
    public Air_0417_CYT_YaGe7_38400(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0417_cyt_yage7/air_cyt_yage7_38400.webp";
        this.mPathHighlight = "0417_cyt_yage7/air_cyt_yage7_38400_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(35.0f, 102.0f, 149.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(480.0f, 26.0f, 536.0f, 67.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(340.0f, 12.0f, 435.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(883.0f, 100.0f, 997.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(199.0f, 10.0f, 292.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(199.0f, 94.0f, 286.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(731.0f, 107.0f, 833.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(591.0f, 20.0f, 658.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(599.0f, 86.0f, 653.0f, 111.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(587.0f, 107.0f, 626.0f, 142.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 1) {
            c.clipRect(721.0f, 19.0f, 839.0f, 87.0f, Region.Op.UNION);
        }
        int value = this.DATA[19];
        if (value >= 0 && value <= 7) {
            c.clipRect(393.0f, 92.0f, (value * 19) + 393, 158.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[20];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 66.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 66.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 70.0f, 66.0f, this.mPaint);
        }
        int temp2 = this.DATA[21];
        if (temp2 == -2) {
            c.drawText("LOW", 930.0f, 65.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 930.0f, 65.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 930.0f, 65.0f, this.mPaint);
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
