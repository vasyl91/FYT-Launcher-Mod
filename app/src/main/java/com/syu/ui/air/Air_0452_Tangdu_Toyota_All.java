package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0452_Tangdu_Toyota_All extends AirBase {
    public Air_0452_Tangdu_Toyota_All(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0452_tangdu_toyota/air_toyota_tangdu.webp";
        this.mPathHighlight = "0452_tangdu_toyota/air_toyota_tangdu_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[38] != 0) {
            c.clipRect(9.0f, 24.0f, 106.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(144.0f, 25.0f, 212.0f, 63.0f, Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(253.0f, 26.0f, 343.0f, 69.0f, Region.Op.UNION);
        }
        if (this.DATA[10] != 0) {
            c.clipRect(125.0f, 101.0f, 229.0f, 152.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(245.0f, 100.0f, 341.0f, 154.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(382.0f, 11.0f, 456.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(386.0f, 104.0f, 451.0f, 160.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(518.0f, 13.0f, 556.0f, 38.0f, Region.Op.UNION);
        }
        if (this.DATA[19] != 0) {
            c.clipRect(520.0f, 38.0f, 556.0f, 50.0f, Region.Op.UNION);
        }
        if (this.DATA[20] != 0) {
            c.clipRect(517.0f, 48.0f, 547.0f, 74.0f, Region.Op.UNION);
        }
        if (this.DATA[12] == 0) {
            c.clipRect(650.0f, 16.0f, 751.0f, 75.0f, Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(785.0f, 13.0f, 885.0f, 79.0f, Region.Op.UNION);
        }
        if (this.DATA[33] != 0) {
            c.clipRect(661.0f, 93.0f, 742.0f, 159.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(790.0f, 104.0f, 877.0f, 156.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(928.0f, 15.0f, 1012.0f, 76.0f, Region.Op.UNION);
        }
        if (this.DATA[37] != 0) {
            c.clipRect(74.0f, 118.0f, 107.0f, 158.0f, Region.Op.UNION);
            c.clipRect(983.0f, 121.0f, 1016.0f, 155.0f, Region.Op.UNION);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        c.clipRect(504.0f, 104.0f, (value * 16) + ConstRzcAddData.U_CAR_LIGHT_FAR, 156.0f, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int temp = this.DATA[27];
        if (temp == -1) {
            c.drawText("NO", 39.0f, 135.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("LOW", 39.0f, 135.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 39.0f, 135.0f, this.mPaint);
        } else if (this.DATA[37] == 0) {
            if (temp >= 1 && temp <= 29) {
                temp = (temp * 5) + 175;
            } else if (temp >= 33 && temp <= 38) {
                temp = ((temp - 33) * 5) + 150;
            }
            c.drawText(String.valueOf(temp / 10.0f), 39.0f, 135.0f, this.mPaint);
        } else {
            if (temp >= 1 && temp <= 29) {
                temp += 63;
            } else if (temp >= 33 && temp <= 38) {
                temp = (temp - 33) + 59;
            }
            c.drawText(String.valueOf(temp), 39.0f, 135.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("NO", 943.0f, 135.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("LOW", 943.0f, 135.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 943.0f, 135.0f, this.mPaint);
        } else if (this.DATA[37] == 0) {
            if (temp2 >= 1 && temp2 <= 29) {
                temp2 = (temp2 * 5) + 175;
            } else if (temp2 >= 33 && temp2 <= 38) {
                temp2 = ((temp2 - 33) * 5) + 150;
            }
            c.drawText(String.valueOf(temp2 / 10.0f), 943.0f, 135.0f, this.mPaint);
        } else {
            if (temp2 >= 1 && temp2 <= 29) {
                temp2 += 63;
            } else if (temp2 >= 33 && temp2 <= 38) {
                temp2 = (temp2 - 33) + 59;
            }
            c.drawText(String.valueOf(temp2), 943.0f, 135.0f, this.mPaint);
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
