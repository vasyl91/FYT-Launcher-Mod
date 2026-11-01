package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0439_BNR_Haval_H9 extends AirBase {
    public Air_0439_BNR_Haval_H9(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0439_oudi_haval_h9/oudi_haval_h9.webp";
        this.mPathHighlight = "0439_oudi_haval_h9/oudi_haval_h9_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int temp;
        int temp1;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(359.0f, 24.0f, 454.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(146.0f, 19.0f, 225.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(464.0f, 21.0f, 566.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(269.0f, 111.0f, 350.0f, 148.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(115.0f, 30.0f, 190.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(501.0f, 101.0f, 566.0f, 150.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(433.0f, 99.0f, 497.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(360.0f, 91.0f, 406.0f, 124.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(367.0f, 125.0f, 399.0f, 137.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(359.0f, 136.0f, 385.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[42] != 0) {
            this.srPath.addRect(704.0f, 34.0f, 809.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[43] != 0) {
            this.srPath.addRect(822.0f, 33.0f, 911.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[46] != 0) {
            this.srPath.addRect(732.0f, 102.0f, 769.0f, 122.0f, Path.Direction.CW);
        }
        if (this.DATA[47] != 0) {
            this.srPath.addRect(720.0f, 121.0f, 750.0f, 149.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(125.0f, 93.0f, (value * 15) + 125, 155.0f, Path.Direction.CW);
        int value1 = this.DATA[44];
        if (value1 < 0) {
            value1 = 0;
        } else if (value1 > 8) {
            value1 = 8;
        }
        this.srPath.addRect(852.0f, 90.0f, (value1 * 17) + 852, 156.0f, Path.Direction.CW);
        int value2 = this.DATA[127];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 2) {
            value2 = 2;
        }
        this.srPath.addRect(58.0f, 126.0f, (value2 * 20) + 58, 162.0f, Path.Direction.CW);
        int value3 = this.DATA[131];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 2) {
            value3 = 2;
        }
        this.srPath.addRect(593.0f, 129.0f, (value3 * 20) + 593, 159.0f, Path.Direction.CW);
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
        int temp2 = this.DATA[27];
        if (temp2 == -1) {
            c.drawText("NO", 45.0f, 63.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 45.0f, 63.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 45.0f, 63.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
                temp = (temp2 * 5) + 160;
            } else {
                temp = ((temp2 - 116) * 5) + 160;
            }
            c.drawText(String.valueOf(temp / 10) + "." + (temp % 10), 45.0f, 63.0f, this.mPaint);
        }
        int temp3 = this.DATA[28];
        if (temp3 == -1) {
            c.drawText("NO", 623.0f, 63.0f, this.mPaint);
        } else if (temp3 == -2) {
            c.drawText("LOW", 623.0f, 63.0f, this.mPaint);
        } else if (temp3 == -3) {
            c.drawText("HI", 623.0f, 63.0f, this.mPaint);
        } else {
            if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
                temp1 = (temp3 * 5) + 160;
            } else {
                temp1 = ((temp3 - 116) * 5) + 160;
            }
            c.drawText(String.valueOf(temp1 / 10) + "." + (temp1 % 10), 623.0f, 63.0f, this.mPaint);
        }
        int temp4 = this.DATA[40];
        if (temp4 == -1) {
            c.drawText("NO", 961.0f, 63.0f, this.mPaint);
        } else if (temp4 == -2) {
            c.drawText("LOW", 961.0f, 63.0f, this.mPaint);
        } else if (temp4 == -3) {
            c.drawText("HI", 961.0f, 63.0f, this.mPaint);
        } else if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
            int temp5 = (temp4 * 5) + 160;
            c.drawText(String.valueOf(temp5 / 10) + "." + (temp5 % 10), 961.0f, 63.0f, this.mPaint);
        } else if (temp4 == 0) {
            c.drawText("--.-", 961.0f, 63.0f, this.mPaint);
        } else {
            int temp6 = ((temp4 - 116) * 5) + 160;
            c.drawText(String.valueOf(temp6 / 10) + "." + (temp6 % 10), 961.0f, 63.0f, this.mPaint);
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
