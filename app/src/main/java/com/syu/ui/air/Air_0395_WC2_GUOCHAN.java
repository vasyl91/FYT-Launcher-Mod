package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0395_WC2_GUOCHAN extends AirBase {
    public Air_0395_WC2_GUOCHAN(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_jianrong.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_jianrong_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[23] != 0) {
            c.clipRect(152.0f, 28.0f, 287.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[24] != 0) {
            c.clipRect(306.0f, 25.0f, 431.0f, 72.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(471.0f, 20.0f, 530.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(484.0f, 132.0f, 543.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(177.0f, 103.0f, 259.0f, 147.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(312.0f, 102.0f, 429.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(899.0f, 21.0f, 1011.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[30] != 0) {
            c.clipRect(617.0f, 11.0f, 710.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(761.0f, 13.0f, 846.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[36] != 0) {
            c.clipRect(488.0f, 77.0f, 531.0f, 96.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(467.0f, 95.0f, 504.0f, 128.0f, Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(744.0f, 93.0f, 871.0f, 157.0f, Region.Op.UNION);
        }
        c.clipRect(602.0f, 101.0f, (this.DATA[39] * 15) + 602, 163.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
        }
        int value = this.DATA[31];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        c.clipRect(82.0f, 134.0f, (value * 19) + 82, 152.0f, Region.Op.UNION);
        int value2 = this.DATA[32];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        c.clipRect(897.0f, 139.0f, (value2 * 19) + 897, 157.0f, Region.Op.UNION);
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
