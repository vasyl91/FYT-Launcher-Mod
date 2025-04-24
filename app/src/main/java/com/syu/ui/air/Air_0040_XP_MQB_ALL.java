package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0040_XP_MQB_ALL extends AirBase {
    public Air_0040_XP_MQB_ALL(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0040_xp1_golf7/air_xp_mqb_all.webp";
        this.mPathHighlight = "0040_xp1_golf7/air_xp_mqb_all_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[87] != 0) {
            c.clipRect(new Rect(142, 24, 271, 69), Region.Op.UNION);
        }
        if (this.DATA[90] != 0) {
            c.clipRect(new Rect(122, 105, 199, 145), Region.Op.UNION);
        }
        if (this.DATA[103] != 0) {
            c.clipRect(new Rect(220, 97, 293, 153), Region.Op.UNION);
        }
        if (this.DATA[88] != 0) {
            c.clipRect(new Rect(228, 97, 282, 125), Region.Op.UNION);
        }
        if (this.DATA[94] != 0) {
            c.clipRect(new Rect(313, 18, 388, 70), Region.Op.UNION);
        }
        if (this.DATA[95] != 0) {
            c.clipRect(new Rect(324, 94, 368, 125), Region.Op.UNION);
        }
        if (this.DATA[96] != 0) {
            c.clipRect(new Rect(329, 122, 360, 135), Region.Op.UNION);
        }
        if (this.DATA[97] != 0) {
            c.clipRect(new Rect(325, 134, 348, 153), Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(new Rect(412, 20, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B10, 68), Region.Op.UNION);
        }
        if (this.DATA[101] != 0) {
            c.clipRect(new Rect(411, 101, Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3, 153), Region.Op.UNION);
        }
        if (this.DATA[93] != 0) {
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_ADD_START, 16, 583, 75), Region.Op.UNION);
        }
        if (this.DATA[92] != 0) {
            c.clipRect(new Rect(498, 107, 587, 149), Region.Op.UNION);
        }
        if (this.DATA[89] == 0) {
            c.clipRect(new Rect(594, 40, 680, 84), Region.Op.UNION);
        }
        if (this.DATA[102] != 0) {
            c.clipRect(new Rect(611, 18, 664, 40), Region.Op.UNION);
        }
        if (this.DATA[114] != 0) {
            c.clipRect(new Rect(815, 11, 853, 43), Region.Op.UNION);
        }
        if (this.DATA[115] != 0) {
            c.clipRect(new Rect(816, 39, 843, 53), Region.Op.UNION);
        }
        if (this.DATA[116] != 0) {
            c.clipRect(new Rect(814, 52, 836, 72), Region.Op.UNION);
        }
        if (this.DATA[111] != 0) {
            c.clipRect(new Rect(879, 36, 951, 66), Region.Op.UNION);
        }
        if (this.DATA[118] != 0) {
            c.clipRect(new Rect(959, 95, 1016, 118), Region.Op.UNION);
        }
        if (this.DATA[105] == 1) {
            c.clipRect(66.0f, 41.0f, 104.0f, 84.0f, Region.Op.UNION);
            c.clipRect(750.0f, 41.0f, 780.0f, 83.0f, Region.Op.UNION);
            c.clipRect(996.0f, 30.0f, 1018.0f, 57.0f, Region.Op.UNION);
        }
        int value = this.DATA[107];
        if (value == 1) {
            c.clipRect(new Rect(58, 137, 73, 156), Region.Op.UNION);
        } else if (value == 2) {
            c.clipRect(new Rect(58, 137, 85, 156), Region.Op.UNION);
        } else if (value == 3) {
            c.clipRect(new Rect(58, 137, 100, 156), Region.Op.UNION);
        }
        int value2 = this.DATA[109];
        if (value2 == 1) {
            c.clipRect(new Rect(724, 134, 736, 157), Region.Op.UNION);
        } else if (value2 == 2) {
            c.clipRect(new Rect(710, 134, 736, 157), Region.Op.UNION);
        } else if (value2 == 3) {
            c.clipRect(new Rect(696, 134, 736, 157), Region.Op.UNION);
        }
        int value3 = this.DATA[112];
        if (value3 == 1) {
            c.clipRect(new Rect(837, 135, 850, 153), Region.Op.UNION);
        } else if (value3 == 2) {
            c.clipRect(new Rect(837, 135, 863, 153), Region.Op.UNION);
        } else if (value3 == 3) {
            c.clipRect(new Rect(837, 135, 876, 153), Region.Op.UNION);
        }
        int value4 = this.DATA[113];
        if (value4 == 1) {
            c.clipRect(new Rect(906, 133, 919, 151), Region.Op.UNION);
        } else if (value4 == 2) {
            c.clipRect(new Rect(894, 133, 919, 151), Region.Op.UNION);
        } else if (value4 == 3) {
            c.clipRect(new Rect(880, 133, 919, 151), Region.Op.UNION);
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(18.0f);
        int temp = this.DATA[99];
        if (temp == 0) {
            c.drawText("LOW", 31.0f, 64.0f, this.mPaint);
        } else if (temp == 31) {
            c.drawText("HI", 31.0f, 64.0f, this.mPaint);
        } else if (this.DATA[105] == 1) {
            c.drawText(String.valueOf(temp + 59), 31.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp * 5) + 155) / 10.0f), 31.0f, 64.0f, this.mPaint);
        }
        int temp2 = this.DATA[100];
        if (temp2 == 0) {
            c.drawText("LOW", 717.0f, 64.0f, this.mPaint);
        } else if (temp2 == 31) {
            c.drawText("HI", 717.0f, 64.0f, this.mPaint);
        } else if (this.DATA[105] == 1) {
            c.drawText(String.valueOf(temp2 + 59), 717.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp2 * 5) + 155) / 10.0f), 717.0f, 64.0f, this.mPaint);
        }
        int temp3 = this.DATA[110];
        if (temp3 == 0) {
            c.drawText("LOW", 979.0f, 64.0f, this.mPaint);
        } else if (temp3 == 31) {
            c.drawText("HI", 979.0f, 64.0f, this.mPaint);
        } else if (this.DATA[105] == 1) {
            c.drawText(String.valueOf(temp3 + 59), 979.0f, 64.0f, this.mPaint);
        } else {
            c.drawText(String.valueOf(((temp3 * 5) + 155) / 10.0f), 979.0f, 64.0f, this.mPaint);
        }
        c.drawText(String.valueOf(this.DATA[98]), 649.0f, 142.0f, this.mPaint);
        c.drawText(String.valueOf(this.DATA[117]), 1005.0f, 154.0f, this.mPaint);
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
