package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0446_HCX_BYD_Tang extends AirBase {
    public Air_0446_HCX_BYD_Tang(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0374_xp_zhinanzhe/air_n.webp";
        this.mPathHighlight = "0374_xp_zhinanzhe/air_p.webp";
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
            this.srPath.addRect(219.0f, 28.0f, 319.0f, 64.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(340.0f, 23.0f, 434.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[62] != 0) {
            this.srPath.addRect(225.0f, 106.0f, 313.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(461.0f, 13.0f, 586.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(337.0f, 108.0f, 445.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(727.0f, 17.0f, 805.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(728.0f, 93.0f, 808.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(835.0f, 106.0f, 905.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(121.0f, 91.0f, 171.0f, 127.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(133.0f, 126.0f, 165.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(117.0f, 138.0f, 144.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[66] != 0) {
            this.srPath.addRect(607.0f, 32.0f, 700.0f, 136.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value % 2 == 0) {
            this.srPath.addRect(466.0f, 107.0f, ((value / 2) * 17) + 466, 161.0f, Path.Direction.CW);
        } else {
            int value2 = value / 2;
            this.srPath.addRect(466.0f, 107.0f, (value2 * 17) + 466, 161.0f, Path.Direction.CW);
            if (value2 == 0) {
                this.srPath.addRect(466.0f, 150.0f, 483.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 1) {
                this.srPath.addRect(484.0f, 146.0f, 501.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 2) {
                this.srPath.addRect(500.0f, 143.0f, 517.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 3) {
                this.srPath.addRect(517.0f, 140.0f, 534.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 4) {
                this.srPath.addRect(534.0f, 137.0f, 551.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 5) {
                this.srPath.addRect(551.0f, 134.0f, 568.0f, 161.0f, Path.Direction.CW);
            } else if (value2 == 6) {
                this.srPath.addRect(568.0f, 131.0f, 585.0f, 161.0f, Path.Direction.CW);
            }
        }
        int value3 = this.DATA[29];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        this.srPath.addRect(48.0f, 49.0f, (value3 * 21) + 48, 80.0f, Path.Direction.CW);
        int value4 = this.DATA[30];
        if (value4 < 0) {
            value4 = 0;
        } else if (value4 > 2) {
            value4 = 2;
        }
        this.srPath.addRect(970 - (value4 * 21), 49.0f, 970.0f, 80.0f, Path.Direction.CW);
        int value5 = this.DATA[31];
        if (value5 < 0) {
            value5 = 0;
        } else if (value5 > 2) {
            value5 = 2;
        }
        this.srPath.addRect(158.0f, 49.0f, (value5 * 21) + 158, 80.0f, Path.Direction.CW);
        int value6 = this.DATA[32];
        if (value6 < 0) {
            value6 = 0;
        } else if (value6 > 2) {
            value6 = 2;
        }
        this.srPath.addRect(878 - (value6 * 21), 49.0f, 878.0f, 80.0f, Path.Direction.CW);
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
        this.mPaint.setTextSize(25.0f);
        int temp = this.DATA[27];
        int temp_unit = this.DATA[37];
        if (temp == -1) {
            c.drawText("NO", 48.0f, 140.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LO", 48.0f, 140.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 48.0f, 140.0f, this.mPaint);
        } else if (temp_unit == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText((((temp * 9) + 320) / 10) + " ℉", 48.0f, 140.0f, this.mPaint);
            } else {
                c.drawText((temp / 2.0f) + " ℃", 48.0f, 140.0f, this.mPaint);
            }
        } else {
            c.drawText(temp + " ℉", 48.0f, 140.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 964.0f, 140.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LO", 964.0f, 140.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 964.0f, 140.0f, this.mPaint);
        } else if (temp_unit == 0) {
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                c.drawText((((temp2 * 9) + 320) / 10) + " ℉", 964.0f, 140.0f, this.mPaint);
            } else {
                c.drawText((temp2 / 2.0f) + " ℃", 964.0f, 140.0f, this.mPaint);
            }
        } else {
            c.drawText(temp2 + " ℉", 964.0f, 140.0f, this.mPaint);
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
