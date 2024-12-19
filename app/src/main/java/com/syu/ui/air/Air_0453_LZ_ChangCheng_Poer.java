package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0453_LZ_ChangCheng_Poer extends AirBase {
    public Air_0453_LZ_ChangCheng_Poer(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0177_rzc_changchengfengjun6/air_rzc_changchengfengjun6_n.webp";
        this.mPathHighlight = "0177_rzc_changchengfengjun6/air_rzc_changchengfengjun6_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[8] != 0) {
            c.clipRect(34.0f, 102.0f, 129.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(342.0f, 37.0f, 415.0f, 88.0f, Region.Op.UNION);
        }
        if (this.DATA[12] != 0) {
            c.clipRect(376.0f, 87.0f, 430.0f, 109.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(353.0f, 107.0f, 393.0f, 143.0f, Region.Op.UNION);
        }
        if (this.DATA[9] == 0) {
            c.clipRect(165.0f, 93.0f, 306.0f, 157.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(163.0f, 24.0f, 305.0f, 78.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(501.0f, 42.0f, 629.0f, 141.0f, Region.Op.UNION);
        }
        int value = this.DATA[14];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(693.0f, 73.0f, (value * 20) + 693, 133.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[15];
        if (temp == -1) {
            c.drawText("NO", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 70.0f, 60.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp + 15).toString(), 70.0f, 60.0f, this.mPaint);
        }
        int temp2 = this.DATA[16];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 60.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 + 15).toString(), 920.0f, 60.0f, this.mPaint);
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
