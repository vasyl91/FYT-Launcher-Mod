package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0374_XP_Ram1500 extends AirBase {
    public Air_0374_XP_Ram1500(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0374_xp_ram1500/air_xp_ram1500.webp";
        this.mPathHighlight = "0374_xp_ram1500/air_xp_ram1500_p.webp";
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
        if (this.DATA[10] != 0) {
            this.srPath.addRect(680.0f, 24.0f, 820.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(452.0f, 20.0f, 578.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(312.0f, 101.0f, 420.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(355.0f, 62.0f, 490.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(870.0f, 25.0f, 989.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(758.0f, 15.0f, 848.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(200.0f, 92.0f, 323.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(49.0f, 22.0f, 121.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(542.0f, 49.0f, 593.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(537.0f, 74.0f, 591.0f, 90.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(532.0f, 96.0f, 573.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[177] != 0) {
            this.srPath.addRect(174.0f, 17.0f, 340.0f, 75.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(697.0f, 114.0f, (value * 16) + 697, 160.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        this.srPath.addRect(76.0f, 51.0f, (value2 * 21) + 76, 77.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        this.srPath.addRect(911.0f, 51.0f, (value3 * 21) + 911, 77.0f, Path.Direction.CW);
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
        int temp_unit = this.DATA[37];
        int i = this.DATA[36];
        int temp_step = this.DATA[176];
        if (temp == -1) {
            c.drawText("NO", 85.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 85.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 85.0f, 140.0f, this.mPaint);
        } else if (temp_unit == 0) {
            int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
            if (tempunit == 1) {
                c.drawText((temp + 27) + " ℉", 85.0f, 140.0f, this.mPaint);
            } else if (temp_step == 1) {
                c.drawText((temp / 2.0f) + " ℃", 85.0f, 140.0f, this.mPaint);
            } else {
                c.drawText((temp / 2) + " ℃", 85.0f, 140.0f, this.mPaint);
            }
        } else {
            c.drawText(temp + " ℉", 85.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 925.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 925.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 925.0f, 140.0f, this.mPaint);
        } else if (temp_unit == 0) {
            int tempunit2 = SystemProperties.getInt("persist.fyt.temperature", 0);
            if (tempunit2 == 1) {
                c.drawText((temp2 + 27) + " ℉", 925.0f, 140.0f, this.mPaint);
            } else if (temp_step == 1) {
                c.drawText((temp2 / 2.0f) + " ℃", 925.0f, 140.0f, this.mPaint);
            } else {
                c.drawText((temp2 / 2) + " ℃", 925.0f, 140.0f, this.mPaint);
            }
        } else {
            c.drawText(temp2 + " ℉", 925.0f, 140.0f, this.mPaint);
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
