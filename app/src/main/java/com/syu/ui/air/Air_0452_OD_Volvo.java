package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.util.ToolkitMath;

public class Air_0452_OD_Volvo extends AirBase {
    public Air_0452_OD_Volvo(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0001_wc1_dazhong/air.webp";
        this.mPathHighlight = "0001_wc1_dazhong/air_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[12] != 0) {
            c.clipRect(new Rect(148, 30, 252, 68), Region.Op.UNION);
        }
        if (this.DATA[11] != 0) {
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_CUR_SPEED, 40, ConstRzcAddData.U_CAR_ADD_END, 70), Region.Op.UNION);
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_ADD_END, 40, 582, 70), Region.Op.UNION);
            c.clipRect(new Rect(580, 40, 611, 70), Region.Op.UNION);
        }
        if (this.DATA[10] == 0) {
            c.clipRect(new Rect(410, 26, ConstRzcAddData.U_CAR_WIPER_LEV, 72), Region.Op.UNION);
        }
        if (this.DATA[13] != 0) {
            c.clipRect(new Rect(426, 104, ConstRzcAddData.U_CAR_LIGHT_NEAR, 151), Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(new Rect(537, 104, 608, 154), Region.Op.UNION);
        }
        if (this.DATA[9] != 0) {
            c.clipRect(new Rect(831, 35, 883, 70), Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(new Rect(765, 36, 827, 71), Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[22], 0, 3);
        this.mRectTmp.set(52, 138, (value * 21) + 52, 156);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = ToolkitMath.clamp(this.DATA[23], 0, 3);
        this.mRectTmp.set(955, 138, (value2 * 21) + 955, 157);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[15] != 0) {
            c.clipRect(new Rect(294, 9, 317, 32), Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(new Rect(314, 32, 346, 46), Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(new Rect(296, 45, Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30, 69), Region.Op.UNION);
        }
        int value3 = ToolkitMath.clamp(this.DATA[18], 0, 7);
        this.mRectTmp.set(176, 134, (value3 * 28) + 176, 154);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[15] != 0) {
            c.clipRect(new Rect(715, 10, 738, 31), Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(new Rect(687, 31, 714, 44), Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(new Rect(714, 48, 737, 65), Region.Op.UNION);
        }
        int value4 = ToolkitMath.clamp(this.DATA[18], 0, 7);
        this.mRectTmp.set(657, 134, (value4 * 28) + 657, 153);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value5 = this.DATA[19];
        switch (value5) {
            case -3:
                c.drawText("HIGH", 51.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 51.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 51.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.valueOf((value5 * 5) / 10.0f), 51.0f, 67.0f, this.mPaint);
                break;
        }
        int value6 = this.DATA[20];
        switch (value6) {
            case -3:
                c.drawText("HIGH", 945.0f, 67.0f, this.mPaint);
                break;
            case -2:
                c.drawText("LOW", 945.0f, 67.0f, this.mPaint);
                break;
            case -1:
                c.drawText("NO", 945.0f, 67.0f, this.mPaint);
                break;
            default:
                c.drawText(String.valueOf((value6 * 5) / 10.0f), 945.0f, 67.0f, this.mPaint);
                break;
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
