package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_XC_BBA_All extends AirBase {
    public Air_0455_XC_BBA_All(Context context) {
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
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[14] != 0) {
            this.srPath.addRect(162.0f, 26.0f, 268.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(537.0f, 45.0f, 584.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(537.0f, 45.0f, 584.0f, 66.0f, Path.Direction.CW);
            this.srPath.addRect(586.0f, 42.0f, 606.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(537.0f, 45.0f, 584.0f, 66.0f, Path.Direction.CW);
            this.srPath.addRect(586.0f, 42.0f, 606.0f, 66.0f, Path.Direction.CW);
            this.srPath.addRect(607.0f, 40.0f, 634.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(434.0f, 31.0f, 536.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(686.0f, 27.0f, 744.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(437.0f, 16.0f, 472.0f, 31.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(154.0f, 106.0f, 281.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(788.0f, 100.0f, 855.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(643.0f, 37.0f, 681.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(785.0f, 17.0f, 860.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[38] != 0) {
            this.srPath.addRect(328.0f, 126.0f, 388.0f, 155.0f, Path.Direction.CW);
        }
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        if (this.DATA[18] != 0) {
            this.srPath.addRect(319.0f, 25.0f, 336.0f, 49.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(340.0f, 49.0f, 367.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(320.0f, 64.0f, 340.0f, 88.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[21], 0, 7);
        this.mRectTmp.set(433.0f, 110.0f, (value * 39) + 433, 154.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        this.mPaint.setTextSize(25.0f);
        int value2 = this.DATA[29];
        c.drawText(new StringBuilder().append(value2).toString(), 98.0f, 148.0f, this.mPaint);
        int value3 = this.DATA[30];
        c.drawText(new StringBuilder().append(value3).toString(), 986.0f, 148.0f, this.mPaint);
        this.mPaint.setTextSize(30.0f);
        int value4 = this.DATA[27];
        if (value4 == -2) {
            c.drawText("LO", 71.0f, 60.0f, this.mPaint);
        } else if (value4 == -3) {
            c.drawText("HI", 71.0f, 60.0f, this.mPaint);
        } else if (value4 >= 1 && value4 <= 35) {
            if (tempunit == 1) {
                c.drawText(new StringBuilder().append(((value4 * 9) + 581) / 10).append(" ℉").toString(), 71.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value4 * 5) + 145) / 10.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NO", 71.0f, 60.0f, this.mPaint);
        }
        int value5 = this.DATA[28];
        if (value5 == 0) {
            c.drawText("LO", 960.0f, 60.0f, this.mPaint);
        } else if (value5 == 254) {
            c.drawText("HI", 960.0f, 60.0f, this.mPaint);
        } else if (value5 >= 1 && value5 <= 35) {
            if (tempunit == 1) {
                c.drawText(new StringBuilder().append(((value5 * 9) + 581) / 10).append(" ℉").toString(), 960.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value5 * 5) + 145) / 10.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NO", 960.0f, 60.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
