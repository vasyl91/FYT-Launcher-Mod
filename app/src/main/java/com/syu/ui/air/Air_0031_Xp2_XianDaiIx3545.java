package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;

import java.util.Locale;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0031_Xp2_XianDaiIx3545 extends AirBase {
    public Air_0031_Xp2_XianDaiIx3545(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45.webp";
        this.mPathHighlight = "0015_31_xp2_xiandai_ix3545/air_xp1_xiandaiix45_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[0] != 0) {
            c.clipRect(5.0f, 12.0f, 152.0f, 82.0f, Region.Op.UNION);
        }
        if (this.DATA[3] != 0) {
            c.clipRect(167.0f, 17.0f, 301.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[1] != 0) {
            c.clipRect(167.0f, 94.0f, 305.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[5] != 0) {
            c.clipRect(687.0f, 9.0f, 866.0f, 84.0f, Region.Op.UNION);
        }
        if (this.DATA[6] != 0) {
            c.clipRect(336.0f, 39.0f, 387.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[4] != 0) {
            c.clipRect(875.0f, 13.0f, 1017.0f, 81.0f, Region.Op.UNION);
        }
        if (this.DATA[7] != 0) {
            c.clipRect(364.0f, 71.0f, 415.0f, 92.0f, Region.Op.UNION);
        }
        if (this.DATA[8] != 0) {
            c.clipRect(332.0f, 92.0f, 379.0f, 131.0f, Region.Op.UNION);
        }
        if (this.DATA[2] == 0) {
            c.clipRect(679.0f, 91.0f, 868.0f, 162.0f, Region.Op.UNION);
        }
        int value = this.DATA[9];
        if (value < 0) {
            value = 0;
        } else if (value > 8) {
            value = 8;
        }
        c.clipRect(498.0f, 71.0f, (value * 20) + 498, 132.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("CN")) {
            int temp = this.DATA[10];
            if (temp == 0) {
                c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
            } else if (temp == 30) {
                c.drawText("HI", 50.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(((temp * 5) + 170) / 10.0f), 50.0f, 130.0f, this.mPaint);
            }
            int temp2 = this.DATA[11];
            if (temp2 == 0) {
                c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
            } else if (temp2 == 30) {
                c.drawText("HI", 930.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(((temp2 * 5) + 170) / 10.0f), 930.0f, 130.0f, this.mPaint);
            }
        } else {
            int temp3 = this.DATA[10];
            if (temp3 > 34) {
                if (temp3 == 124) {
                    c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
                } else if (temp3 == 152) {
                    c.drawText("HI", 50.0f, 130.0f, this.mPaint);
                } else if (temp3 > 124 && temp3 < 152) {
                    c.drawText(String.valueOf((((temp3 - 124) * 5) + 170) / 10.0f), 50.0f, 130.0f, this.mPaint);
                } else {
                    c.drawText("NO", 50.0f, 130.0f, this.mPaint);
                }
            } else if (temp3 == 0) {
                c.drawText("LOW", 50.0f, 130.0f, this.mPaint);
            } else if (temp3 == 34) {
                c.drawText("HI", 50.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(((temp3 * 5) + 150) / 10.0f), 50.0f, 130.0f, this.mPaint);
            }
            int temp4 = this.DATA[11];
            if (temp4 > 34) {
                if (temp4 == 124) {
                    c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
                } else if (temp4 == 152) {
                    c.drawText("HI", 930.0f, 130.0f, this.mPaint);
                } else if (temp4 > 124 && temp4 < 152) {
                    c.drawText(String.valueOf((((temp4 - 124) * 5) + 170) / 10.0f), 930.0f, 130.0f, this.mPaint);
                } else {
                    c.drawText("NO", 930.0f, 130.0f, this.mPaint);
                }
            } else if (temp4 == 0) {
                c.drawText("LOW", 930.0f, 130.0f, this.mPaint);
            } else if (temp4 == 34) {
                c.drawText("HI", 930.0f, 130.0f, this.mPaint);
            } else {
                c.drawText(String.valueOf(((temp4 * 5) + 150) / 10.0f), 930.0f, 130.0f, this.mPaint);
            }
        }
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
