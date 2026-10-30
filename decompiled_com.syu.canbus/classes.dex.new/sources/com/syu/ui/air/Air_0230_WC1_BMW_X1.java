package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0230_WC1_BMW_X1 extends AirBase {
    public Air_0230_WC1_BMW_X1(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air_wc_bmw.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_wc_bmw_p.webp";
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
            this.srPath.addRect(161.0f, 23.0f, 260.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(437.0f, 19.0f, 526.0f, 66.0f, Path.Direction.CW);
            this.srPath.addRect(525.0f, 30.0f, 554.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[26] != 0) {
            this.srPath.addRect(437.0f, 19.0f, 526.0f, 66.0f, Path.Direction.CW);
            this.srPath.addRect(554.0f, 22.0f, 589.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(460.0f, 93.0f, 543.0f, 131.0f, Path.Direction.CW);
        } else if (this.DATA[12] == 3) {
            this.srPath.addRect(548.0f, 90.0f, 595.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(311.0f, 17.0f, 382.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(641.0f, 16.0f, 716.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(818.0f, 26.0f, 873.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(754.0f, 23.0f, 874.0f, 73.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        if (value == 1) {
            this.srPath.addRect(55.0f, 129.0f, 78.0f, 152.0f, Path.Direction.CW);
        } else if (value == 2) {
            this.srPath.addRect(57.0f, 130.0f, 102.0f, 152.0f, Path.Direction.CW);
        } else if (value == 3) {
            this.srPath.addRect(57.0f, 122.0f, 125.0f, 155.0f, Path.Direction.CW);
        }
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        if (value2 == 1) {
            this.srPath.addRect(941.0f, 126.0f, 965.0f, 154.0f, Path.Direction.CW);
        } else if (value2 == 2) {
            this.srPath.addRect(941.0f, 126.0f, 986.0f, 154.0f, Path.Direction.CW);
        } else if (value2 == 3) {
            this.srPath.addRect(941.0f, 126.0f, 1009.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(166.0f, 92.0f, 208.0f, 114.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(178.0f, 112.0f, 217.0f, 125.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(170.0f, 125.0f, 201.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(821.0f, 91.0f, 852.0f, 114.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(811.0f, 113.0f, 844.0f, 128.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(822.0f, 126.0f, 854.0f, 144.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(18.0f);
        if (this.DATA[38] == 1) {
            c.drawText("Rear", 440.0f, 110.0f, this.mPaint);
        }
        this.mPaint.setTextSize(30.0f);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[21])).toString(), 358.0f, 139.0f, this.mPaint);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[25])).toString(), 692.0f, 139.0f, this.mPaint);
        int value3 = this.DATA[27];
        switch (value3) {
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
                c.drawText(String.format("%.1f", Float.valueOf((value3 - 80) * 0.5f)), 51.0f, 67.0f, this.mPaint);
                break;
        }
        int value4 = this.DATA[28];
        switch (value4) {
            case -3:
                c.drawText("HI", 940.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LO", 940.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 940.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf((value4 - 80) * 0.5f)), 945.0f, 67.0f, this.mPaint);
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
