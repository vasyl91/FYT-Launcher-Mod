package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0453_OD_Beiqi_BJ30 extends AirBase {
    public Air_0453_OD_Beiqi_BJ30(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0396_rzc_shenbao/air_shenbao_bj20.webp";
        this.mPathHighlight = "0396_rzc_shenbao/air_shenbao_bj20_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp2;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(155.0f, 23.0f, 281.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(165.0f, 104.0f, 252.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(290.0f, 107.0f, 375.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(312.0f, 25.0f, 430.0f, 71.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(375.0f, 32.0f, 430.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[54] != 0) {
            this.srPath.addRect(740.0f, 10.0f, 781.0f, 29.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(740.0f, 28.0f, 869.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(502.0f, 21.0f, 572.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(446.0f, 17.0f, 577.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(537.0f, 98.0f, 610.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[67] != 0) {
            this.srPath.addRect(395.0f, 92.0f, 507.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[52] != 0) {
            this.srPath.addRect(651.0f, 107.0f, 739.0f, 144.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(781.0f, 90.0f, 831.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(798.0f, 126.0f, 832.0f, 145.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(783.0f, 142.0f, 814.0f, 166.0f, Path.Direction.CW);
        }
        if (this.DATA[58] == 1) {
            this.srPath.addRect(641.0f, 11.0f, 695.0f, 34.0f, Path.Direction.CW);
        }
        if (this.DATA[37] == 1) {
            this.srPath.addRect(977.0f, 108.0f, 1017.0f, 159.0f, Path.Direction.CW);
            this.srPath.addRect(103.0f, 112.0f, 146.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(591.0f, 37.0f, 591.0f + (value * 15.0f), 82.0f, Path.Direction.CW);
        int value2 = this.DATA[29];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(72.0f, 50.0f, 72.0f + (value2 * 19.0f), 71.0f, Path.Direction.CW);
        int value3 = this.DATA[30];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(905.0f, 50.0f, 905.0f + (value3 * 19.0f), 71.0f, Path.Direction.CW);
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
        int temp3 = this.DATA[27];
        if (temp3 == -2) {
            c.drawText("LOW", 56.0f, 152.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 56.0f, 152.0f, this.mPaint);
        } else if (temp3 == -1) {
            c.drawText("No", 56.0f, 152.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 15466951) {
                temp = temp3 * 10;
            } else {
                temp = temp3 * 5;
            }
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 56.0f, 152.0f, this.mPaint);
        }
        int temp4 = this.DATA[28];
        if (temp4 == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else if (temp4 == -1) {
            c.drawText("NO", 930.0f, 152.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 15466951) {
                temp2 = temp4 * 10;
            } else {
                temp2 = temp4 * 5;
            }
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 930.0f, 152.0f, this.mPaint);
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
