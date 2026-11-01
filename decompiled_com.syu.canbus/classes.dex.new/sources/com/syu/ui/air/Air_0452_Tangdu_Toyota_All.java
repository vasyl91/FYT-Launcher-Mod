package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_0452_Tangdu_Toyota_All extends AirBase {
    public Air_0452_Tangdu_Toyota_All(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0452_tangdu_toyota/air_toyota_tangdu.webp";
        this.mPathHighlight = "0452_tangdu_toyota/air_toyota_tangdu_p.webp";
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
        if (this.DATA[38] != 0) {
            this.srPath.addRect(9.0f, 24.0f, 106.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(144.0f, 25.0f, 212.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(253.0f, 26.0f, 343.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(125.0f, 101.0f, 229.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[14] != 0) {
            this.srPath.addRect(245.0f, 100.0f, 341.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[15] != 0) {
            this.srPath.addRect(382.0f, 11.0f, 456.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(386.0f, 104.0f, 451.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(518.0f, 13.0f, 556.0f, 38.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(520.0f, 38.0f, 556.0f, 50.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(517.0f, 48.0f, 547.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(650.0f, 16.0f, 751.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[34] != 0) {
            this.srPath.addRect(785.0f, 13.0f, 885.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(661.0f, 93.0f, 742.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[17] != 0) {
            this.srPath.addRect(790.0f, 104.0f, 877.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[35] != 0) {
            this.srPath.addRect(928.0f, 15.0f, 1012.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(74.0f, 118.0f, 107.0f, 158.0f, Path.Direction.CW);
            this.srPath.addRect(983.0f, 121.0f, 1016.0f, 155.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(504.0f, 104.0f, (value * 16) + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B5, 156.0f, Path.Direction.CW);
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
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 39.0f, 135.0f, this.mPaint);
        } else {
            if (temp >= 1 && temp <= 29) {
                temp += 63;
            } else if (temp >= 33 && temp <= 38) {
                temp = (temp - 33) + 59;
            }
            c.drawText(new StringBuilder().append(temp / 1.0f).toString(), 39.0f, 135.0f, this.mPaint);
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
            c.drawText(new StringBuilder().append(temp2 / 10.0f).toString(), 943.0f, 135.0f, this.mPaint);
        } else {
            if (temp2 >= 1 && temp2 <= 29) {
                temp2 += 63;
            } else if (temp2 >= 33 && temp2 <= 38) {
                temp2 = (temp2 - 33) + 59;
            }
            c.drawText(new StringBuilder().append(temp2 / 1.0f).toString(), 943.0f, 135.0f, this.mPaint);
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
