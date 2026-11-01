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
public class Air_0443_WC2_Feiyate_All extends AirBase {
    public Air_0443_WC2_Feiyate_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air_wc_feiyate.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_wc_feiyate_p.webp";
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
        if (this.DATA[62] != 0) {
            this.srPath.addRect(142.0f, 20.0f, 233.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(253.0f, 104.0f, 346.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(658.0f, 102.0f, 752.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(527.0f, 55.0f, 611.0f, 87.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(260.0f, 21.0f, 337.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(667.0f, 15.0f, 749.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(831.0f, 22.0f, 892.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(768.0f, 25.0f, 891.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(387.0f, 88.0f, 471.0f, 162.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        if (value == 1) {
            this.srPath.addRect(48.0f, 127.0f, 72.0f, 151.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(46.0f, 128.0f, 94.0f, 154.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(45.0f, 127.0f, 117.0f, 152.0f, Path.Direction.CW);
        }
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        if (value2 == 1) {
            this.srPath.addRect(948.0f, 130.0f, 972.0f, 156.0f, Path.Direction.CW);
        } else if (value2 == 2) {
            this.srPath.addRect(948.0f, 130.0f, 995.0f, 156.0f, Path.Direction.CW);
        } else if (value2 == 3) {
            this.srPath.addRect(948.0f, 130.0f, 1019.0f, 156.0f, Path.Direction.CW);
        }
        int value3 = this.DATA[21];
        if (value3 == 1) {
            this.srPath.addRect(380.0f, 16.0f, 394.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 2) {
            this.srPath.addRect(380.0f, 16.0f, 407.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 3) {
            this.srPath.addRect(380.0f, 16.0f, 420.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 4) {
            this.srPath.addRect(380.0f, 16.0f, 433.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 5) {
            this.srPath.addRect(380.0f, 16.0f, 446.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 6) {
            this.srPath.addRect(380.0f, 16.0f, 459.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 7) {
            this.srPath.addRect(380.0f, 16.0f, 473.0f, 76.0f, Path.Direction.CW);
        } else if (value3 == 8) {
            this.srPath.addRect(380.0f, 16.0f, 489.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(140.0f, 92.0f, 179.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(152.0f, 114.0f, 192.0f, 126.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(145.0f, 126.0f, 178.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(838.0f, 91.0f, 870.0f, 114.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(825.0f, 113.0f, 861.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(837.0f, 126.0f, 871.0f, 143.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 0 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(81.0f, 34.0f, 116.0f, 78.0f, Path.Direction.CW);
            this.srPath.addRect(978.0f, 35.0f, 1016.0f, 73.0f, Path.Direction.CW);
        }
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
        this.mPaint.setTextSize(22.0f);
        if (this.DATA[54] != 0) {
            c.drawText("AQS", 543.0f, 32.0f, this.mPaint);
        }
        this.mPaint.setTextSize(28.0f);
        int value4 = this.DATA[27];
        switch (value4) {
            case -3:
                c.drawText("HI", 45.0f, 50.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 45.0f, 50.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 45.0f, 50.0f, this.mPaint);
                break;
            default:
                int value5 = value4 * 5;
                c.drawText(String.valueOf(value5 / 10) + "." + (value5 % 10), 45.0f, 50.0f, this.mPaint);
                break;
        }
        int value6 = this.DATA[28];
        switch (value6) {
            case -3:
                c.drawText("HI", 936.0f, 50.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 936.0f, 50.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 936.0f, 50.0f, this.mPaint);
                break;
            default:
                int value7 = value6 * 5;
                c.drawText(String.valueOf(value7 / 10) + "." + (value7 % 10), 936.0f, 50.0f, this.mPaint);
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
