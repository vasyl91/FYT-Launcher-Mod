package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0455_Xincheng_Infeinidi_QX50 extends AirBase {
    public Air_0455_Xincheng_Infeinidi_QX50(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_xbs_tule/xc_infinit_qx50.webp";
        this.mPathHighlight = "0439_xbs_tule/xc_infinit_qx50_p.webp";
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
            this.srPath.addRect(447.0f, 23.0f, 526.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(728.0f, 10.0f, 811.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(712.0f, 104.0f, 827.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(199.0f, 13.0f, 280.0f, 80.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(190.0f, 101.0f, 287.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[72] != 0) {
            this.srPath.addRect(337.0f, 19.0f, 396.0f, 68.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(566.0f, 24.0f, 647.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(582.0f, 80.0f, 636.0f, 99.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(576.0f, 103.0f, 610.0f, 134.0f, Path.Direction.CW);
        }
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (TempUnit != 0 || this.DATA[37] == 1) {
            this.srPath.addRect(121.0f, 40.0f, 166.0f, 78.0f, Path.Direction.CW);
            this.srPath.addRect(974.0f, 42.0f, 1013.0f, 77.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(364.0f, 97.0f, (value * 19) + 364, 159.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 76.0f, 98.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 76.0f, 98.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(((temp * 10) - 160) / 10).toString(), 76.0f, 98.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(((temp * 9) + 320) / 10).toString(), 76.0f, 98.0f, this.mPaint);
        } else {
            int temp2 = temp * 5;
            c.drawText(String.valueOf(temp2 / 10) + "." + (temp2 % 10), 76.0f, 98.0f, this.mPaint);
        }
        int temp1 = this.DATA[28];
        if (temp1 == -1) {
            c.drawText("NO", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -2) {
            c.drawText("LOW", 923.0f, 98.0f, this.mPaint);
        } else if (temp1 == -3) {
            c.drawText("HI", 923.0f, 98.0f, this.mPaint);
        } else if (this.DATA[37] == 1) {
            c.drawText(new StringBuilder().append(((temp1 * 10) - 160) / 10).toString(), 923.0f, 98.0f, this.mPaint);
        } else if (TempUnit != 0) {
            c.drawText(new StringBuilder().append(((temp1 * 9) + 320) / 10).toString(), 923.0f, 98.0f, this.mPaint);
        } else {
            int temp3 = temp1 * 5;
            c.drawText(String.valueOf(temp3 / 10) + "." + (temp3 % 10), 923.0f, 98.0f, this.mPaint);
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
