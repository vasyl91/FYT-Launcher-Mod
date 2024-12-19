package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0432_HC_B200 extends AirBase {
    public Air_0432_HC_B200(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_benz_all/od_benz_all.webp";
        this.mPathHighlight = "0439_oudi_benz_all/od_benz_all_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[11] != 0) {
            c.clipRect(14.0f, 107.0f, 162.0f, 155.0f, Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(179.0f, 23.0f, 274.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(181.0f, 103.0f, 278.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(873.0f, 103.0f, 990.0f, 150.0f, Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(735.0f, 105.0f, 836.0f, 153.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(305.0f, 110.0f, 376.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[13] == 0) {
            c.clipRect(721.0f, 17.0f, 844.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(306.0f, 12.0f, 380.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(440.0f, 21.0f, 526.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(595.0f, 17.0f, 663.0f, 77.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(604.0f, 81.0f, 656.0f, 102.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(594.0f, 100.0f, 632.0f, 131.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[20];
        c.drawText(new StringBuilder().append(value).toString(), 494.0f, 145.0f, this.mPaint);
        int temp = this.DATA[21];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 58.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 58.0f, this.mPaint);
        } else if (temp == -1) {
            c.drawText("--", 70.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp * 0.1f).toString(), 70.0f, 58.0f, this.mPaint);
        }
        int temp1 = this.DATA[24];
        if (temp1 == -2) {
            c.drawText("LOW", 921.0f, 58.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 921.0f, 58.0f, this.mPaint);
        } else if (temp1 == -1) {
            c.drawText("--", 921.0f, 58.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp1 * 0.1f).toString(), 921.0f, 58.0f, this.mPaint);
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
