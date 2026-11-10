package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0374_XP_Keleiao extends AirBase {
    public Air_0374_XP_Keleiao(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0374_xp_keleiao/xp_keleiao.webp";
        this.mPathHighlight = "0374_xp_keleiao/xp_keleiao_p.webp";
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
        if (this.DATA[12] != 1) {
            this.srPath.addRect(850.0f, 15.0f, 1006.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(187.0f, 28.0f, 322.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(363.0f, 33.0f, 482.0f, 139.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(30.0f, 20.0f, 133.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(534.0f, 18.0f, 607.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(532.0f, 77.0f, 596.0f, 108.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(526.0f, 107.0f, 573.0f, 148.0f, Path.Direction.CW);
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            this.srPath.addRect(121.0f, 120.0f, 160.0f, 156.0f, Path.Direction.CW);
            this.srPath.addRect(979.0f, 120.0f, 1018.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(698.0f, 67.0f, (value * 16) + 698, 122.0f, Path.Direction.CW);
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
            c.drawText("NO", 74.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 74.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 74.0f, 140.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((temp * 9) + 320) / 10).toString(), 74.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 2.0f).toString(), 74.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 920.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 920.0f, 140.0f, this.mPaint);
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            c.drawText(new StringBuilder().append(((temp2 * 9) + 320) / 10).toString(), 920.0f, 140.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp2 / 2.0f).toString(), 920.0f, 140.0f, this.mPaint);
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
