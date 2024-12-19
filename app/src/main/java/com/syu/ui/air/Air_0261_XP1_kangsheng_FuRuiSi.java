package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.android.launcher66.LauncherApplication;
import com.syu.util.ToolkitMath;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_0261_XP1_kangsheng_FuRuiSi extends AirBase {
    public Air_0261_XP1_kangsheng_FuRuiSi(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0002_xp_dazhong/air_xp1_dazhong.webp";
        this.mPathHighlight = "0002_xp_dazhong/air_xp1_dazhong_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[20] != 0) {
            c.clipRect(162.0f, 26.0f, 268.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(586.0f, 42.0f, 606.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(607.0f, 40.0f, 634.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[19] == 0) {
            c.clipRect(434.0f, 31.0f, 536.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(686.0f, 27.0f, 744.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(437.0f, 16.0f, 472.0f, 31.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(154.0f, 106.0f, 281.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(788.0f, 100.0f, 855.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(643.0f, 37.0f, 681.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(785.0f, 17.0f, 860.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(328.0f, 126.0f, 388.0f, 155.0f, Region.Op.UNION);
        }
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[22] != 0) {
            c.clipRect(319.0f, 25.0f, 336.0f, 49.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(340.0f, 49.0f, 367.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(320.0f, 64.0f, 340.0f, 88.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[26], 0, 7);
        this.mRectTmp.set(433, 110, (value * 38) + 433, 154);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(25.0f);
        int value2 = this.DATA[30];
        c.drawText(new StringBuilder().append(value2).toString(), 98.0f, 148.0f, this.mPaint);
        int value3 = this.DATA[33];
        c.drawText(new StringBuilder().append(value3).toString(), 986.0f, 148.0f, this.mPaint);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[27], 0, 255);
        if (value4 == 0) {
            c.drawText("LOW", 51.0f, 67.0f, this.mPaint);
        } else if (value4 == 31) {
            c.drawText("HIGH", 51.0f, 67.0f, this.mPaint);
        } else if (value4 >= 1 && value4 <= 17) {
            c.drawText(new StringBuilder().append(((value4 * 5) + 175) / 10.0f).toString(), 51.0f, 67.0f, this.mPaint);
        } else {
            c.drawText("NONE", 51.0f, 67.0f, this.mPaint);
        }
        int value5 = ToolkitMath.clamp(this.DATA[28], 0, 255);
        if (value5 == 0) {
            c.drawText("LOW", 945.0f, 67.0f, this.mPaint);
        } else if (value5 == 31) {
            c.drawText("HIGH", 945.0f, 67.0f, this.mPaint);
        } else if (value5 >= 1 && value5 <= 17) {
            c.drawText(new StringBuilder().append(((value5 * 5) + 175) / 10.0f).toString(), 945.0f, 67.0f, this.mPaint);
        } else {
            c.drawText("NONE", 945.0f, 67.0f, this.mPaint);
        }
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
