package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0251_Xp1_Qiya_SoLanTuo extends AirBase {
    public Air_0251_Xp1_Qiya_SoLanTuo(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45.webp";
        this.mPathHighlight = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45_p.webp";
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
            this.srPath.addRect(5.0f, 12.0f, 152.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(167.0f, 17.0f, 301.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[53] != 0) {
            this.srPath.addRect(167.0f, 94.0f, 305.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(687.0f, 9.0f, 866.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(336.0f, 39.0f, 387.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(875.0f, 13.0f, 1017.0f, 81.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(364.0f, 71.0f, 415.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(332.0f, 92.0f, 379.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(679.0f, 91.0f, 868.0f, 162.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        this.srPath.addRect(498.0f, 71.0f, (value * 20) + Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D5_B70, 132.0f, Path.Direction.CW);
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
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("CN")) {
            int temp = this.DATA[27];
            if (temp == 0) {
                c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
            } else if (temp == 30) {
                c.drawText("HI", 50.0f, 130.0f, this.mPaint);
            } else if (temp == 255) {
                c.drawText("NO", 50.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(((temp * 5) + 170) / 10.0f).toString(), 50.0f, 130.0f, this.mPaint);
            }
            int temp2 = this.DATA[28];
            if (temp2 == 0) {
                c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
            } else if (temp2 == 30) {
                c.drawText("HI", 930.0f, 130.0f, this.mPaint);
            } else if (temp2 == 255) {
                c.drawText("NO", 930.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(((temp2 * 5) + 170) / 10.0f).toString(), 930.0f, 130.0f, this.mPaint);
            }
        } else {
            int temp3 = this.DATA[27];
            if (temp3 == 0) {
                c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
            } else if (temp3 == 34) {
                c.drawText("HI", 50.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(((temp3 * 5) + 150) / 10.0f).toString(), 50.0f, 130.0f, this.mPaint);
            }
            int temp4 = this.DATA[28];
            if (temp4 == 0) {
                c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
            } else if (temp4 == 34) {
                c.drawText("HI", 930.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(new StringBuilder().append(((temp4 * 5) + 150) / 10.0f).toString(), 930.0f, 130.0f, this.mPaint);
            }
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
