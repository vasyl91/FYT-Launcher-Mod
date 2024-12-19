package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0439_OD_Ford_Falcon extends AirBase {
    public Air_0439_OD_Ford_Falcon(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_od_ford_falcon/air_od_ford_falcon.webp";
        this.mPathHighlight = "0439_od_ford_falcon/air_od_ford_falcon_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(10.0f, 31.0f, 145.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(870.0f, 20.0f, 1016.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(510.0f, 17.0f, 656.0f, 80.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(178.0f, 30.0f, 287.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(703.0f, 12.0f, 825.0f, 83.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(713.0f, 90.0f, 819.0f, 162.0f, Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(185.0f, 113.0f, 280.0f, 149.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(334.0f, 36.0f, 423.0f, 85.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(372.0f, 86.0f, 429.0f, 106.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(346.0f, 104.0f, 394.0f, 138.0f, Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value = this.DATA[18];
        if (value < 0) {
            value = 0;
        }
        c.drawText(new StringBuilder().append(value).toString(), 607.0f, 134.0f, this.mPaint);
        int temp = this.DATA[19];
        if (temp == -1) {
            c.drawText("NO", 60.0f, 132.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 60.0f, 132.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 60.0f, 132.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 60.0f, 132.0f, this.mPaint);
        }
        int temp3 = this.DATA[20];
        if (temp3 == -1) {
            c.drawText("NO", 920.0f, 132.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 920.0f, 132.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 920.0f, 132.0f, this.mPaint);
        } else {
            int temp4 = temp3 * 5;
            c.drawText(String.valueOf(temp4 / 10) + "." + (temp4 % 10), 920.0f, 132.0f, this.mPaint);
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
