package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0443_WC2_Proton_X90 extends AirBase {
    public Air_0443_WC2_Proton_X90(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0139_jl_dihaoyuanjing/air_proton_x90_n.webp";
        this.mPathHighlight = "0139_jl_dihaoyuanjing/air_proton_x90_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(602.0f, 23.0f, 669.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(389.0f, 16.0f, 465.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(127.0f, 103.0f, 242.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(151.0f, 10.0f, 218.0f, 39.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(491.0f, 27.0f, 576.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(486.0f, 105.0f, 579.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(698.0f, 18.0f, 776.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(700.0f, 96.0f, 771.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(610.0f, 94.0f, 652.0f, 120.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(613.0f, 120.0f, 648.0f, 136.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(607.0f, 133.0f, 631.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(140.0f, 39.0f, 226.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[58] != 0) {
            this.srPath.addRect(272.0f, 20.0f, 353.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(390.0f, 105.0f, 464.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(795.0f, 28.0f, 893.0f, 64.0f, Path.Direction.CW);
        }
        int value = this.DATA[29];
        if ((value & 16) != 0) {
            this.srPath.addRect(14.0f, 98.0f, 50.0f, 142.0f, Path.Direction.CW);
        }
        this.srPath.addRect(53.0f, 132.0f, 53.0f + ((value & 15) * 17.0f), 153.0f, Path.Direction.CW);
        int value2 = this.DATA[30];
        if ((value2 & 16) != 0) {
            this.srPath.addRect(972.0f, 100.0f, 1016.0f, 147.0f, Path.Direction.CW);
        }
        this.srPath.addRect(920.0f, 132.0f, 920.0f + ((value2 & 15) * 17.0f), 153.0f, Path.Direction.CW);
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
        c.drawText(new StringBuilder(String.valueOf(this.DATA[21])).toString(), 323.0f, 145.0f, this.mPaint);
        c.drawText(new StringBuilder(String.valueOf(this.DATA[44])).toString(), 860.0f, 145.0f, this.mPaint);
        int left_temp = this.DATA[27];
        if (left_temp == -2) {
            c.drawText("LO", 46.0f, 54.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 54.0f, this.mPaint);
        } else {
            int left_temp2 = left_temp * 5;
            c.drawText(String.valueOf(left_temp2 / 10) + "." + (left_temp2 % 10), 46.0f, 54.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == -2) {
            c.drawText("LO", 944.0f, 54.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 944.0f, 54.0f, this.mPaint);
        } else {
            int right_temp2 = right_temp * 5;
            c.drawText(String.valueOf(right_temp2 / 10) + "." + (right_temp2 % 10), 944.0f, 54.0f, this.mPaint);
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
