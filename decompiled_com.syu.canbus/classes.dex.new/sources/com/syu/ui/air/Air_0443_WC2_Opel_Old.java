package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_Opel_Old extends AirBase {
    public Air_0443_WC2_Opel_Old(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air_wc_old_opel.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_wc_old_opel_p.webp";
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
            this.srPath.addRect(161.0f, 23.0f, 260.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(430.0f, 22.0f, 523.0f, 67.0f, Path.Direction.CW);
        }
        if (this.DATA[69] == 1) {
            this.srPath.addRect(529.0f, 27.0f, 555.0f, 61.0f, Path.Direction.CW);
        } else if (this.DATA[69] == 2) {
            this.srPath.addRect(524.0f, 23.0f, 594.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(452.0f, 95.0f, 540.0f, 130.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(311.0f, 17.0f, 382.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(641.0f, 16.0f, 716.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(754.0f, 23.0f, 874.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(815.0f, 18.0f, 877.0f, 71.0f, Path.Direction.CW);
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
        if (this.DATA[66] != 0) {
            this.srPath.addRect(766.0f, 92.0f, 852.0f, 164.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(30.0f);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[21])).toString(), 358.0f, 139.0f, this.mPaint);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[21])).toString(), 692.0f, 139.0f, this.mPaint);
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
                int value4 = value3 * 5;
                c.drawText(String.valueOf(value4 / 10) + "." + (value4 % 10), 51.0f, 67.0f, this.mPaint);
                break;
        }
        int value5 = this.DATA[28];
        switch (value5) {
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
                int value6 = value5 * 5;
                c.drawText(String.valueOf(value6 / 10) + "." + (value6 % 10), 940.0f, 67.0f, this.mPaint);
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
