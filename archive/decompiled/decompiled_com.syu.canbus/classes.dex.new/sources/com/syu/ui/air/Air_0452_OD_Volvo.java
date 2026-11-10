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
public class Air_0452_OD_Volvo extends AirBase {
    public Air_0452_OD_Volvo(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_p.webp";
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
            this.srPath.addRect(148.0f, 30.0f, 252.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(510.0f, 40.0f, 560.0f, 70.0f, Path.Direction.CW);
            this.srPath.addRect(560.0f, 40.0f, 582.0f, 70.0f, Path.Direction.CW);
            this.srPath.addRect(580.0f, 40.0f, 611.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(410.0f, 26.0f, 509.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(426.0f, 104.0f, 503.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(537.0f, 104.0f, 608.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(831.0f, 35.0f, 883.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(765.0f, 36.0f, 827.0f, 71.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        this.mRectTmp.set(52.0f, 138.0f, (value * 21) + 52, 156.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(955.0f, 138.0f, (value2 * 21) + 955, 157.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        if (this.DATA[18] != 0) {
            this.srPath.addRect(294.0f, 9.0f, 317.0f, 32.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(314.0f, 32.0f, 346.0f, 46.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(296.0f, 45.0f, 318.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(68.0f, 23.0f, 111.0f, 64.0f, Path.Direction.CW);
            this.srPath.addRect(963.0f, 23.0f, 1003.0f, 62.0f, Path.Direction.CW);
        }
        int value3 = ToolkitMath.clamp(this.DATA[21], 0, 7);
        this.mRectTmp.set(176.0f, 134.0f, (value3 * 28) + 176, 154.0f);
        this.srPath.addRect(this.mRectTmp, Path.Direction.CW);
        if (this.DATA[18] != 0) {
            this.srPath.addRect(715.0f, 10.0f, 738.0f, 31.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(687.0f, 31.0f, 714.0f, 44.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(714.0f, 48.0f, 737.0f, 65.0f, Path.Direction.CW);
        }
        int value4 = ToolkitMath.clamp(this.DATA[21], 0, 7);
        this.mRectTmp.set(657.0f, 134.0f, (value4 * 28) + 657, 153.0f);
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
        this.mPaint.setTextSize(30.0f);
        int value5 = this.DATA[27];
        switch (value5) {
            case -3:
                c.drawText("HI", 51.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 51.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 51.0f, 67.0f, this.mPaint);
                break;
            default:
                if (value5 >= 31 && value5 <= 59) {
                    c.drawText(new StringBuilder().append((value5 * 5) / 10.0f).toString(), 51.0f, 67.0f, this.mPaint);
                } else if (value5 >= 88 && value5 <= 108) {
                    c.drawText(new StringBuilder().append(value5 - 26).toString(), 51.0f, 67.0f, this.mPaint);
                } else {
                    c.drawText("NO", 51.0f, 67.0f, this.mPaint);
                }
                break;
        }
        int value6 = this.DATA[28];
        switch (value6) {
            case -3:
                c.drawText("HI", 945.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 945.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 945.0f, 67.0f, this.mPaint);
                break;
            default:
                if (value6 >= 31 && value6 <= 59) {
                    c.drawText(new StringBuilder().append((value6 * 5) / 10.0f).toString(), 945.0f, 67.0f, this.mPaint);
                } else if (value6 >= 88 && value6 <= 108) {
                    c.drawText(new StringBuilder().append(value6 - 26).toString(), 945.0f, 67.0f, this.mPaint);
                } else {
                    c.drawText("NO", 945.0f, 67.0f, this.mPaint);
                }
                break;
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
