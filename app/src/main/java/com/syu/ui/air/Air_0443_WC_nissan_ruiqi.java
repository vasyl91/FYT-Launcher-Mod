package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0443_WC_nissan_ruiqi extends AirBase {
    public Air_0443_WC_nissan_ruiqi(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0172_xbs_xp1_changchengfengjun6/air_wc2_nissan_ruiqi_n.webp";
        this.mPathHighlight = "0172_xbs_xp1_changchengfengjun6/air_wc2_nissan_ruiqi_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] == 0) {
            c.clipRect(165.0f, 53.0f, 305.0f, 130.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(32.0f, 106.0f, 129.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(881.0f, 36.0f, 1010.0f, 86.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(915.0f, 86.0f, 1010.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(887.0f, 108.0f, 1010.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(320.0f, 54.0f, 472.0f, 119.0f, Region.Op.UNION);
        }
        if (this.DATA[65] != 0) {
            c.clipRect(506.0f, 36.0f, 629.0f, 146.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(690.0f, 75.0f, (value * 20) + 690, 145.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 65.0f, 58.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 65.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 65.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.5f).toString(), 65.0f, 58.0f, this.mPaint);
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
