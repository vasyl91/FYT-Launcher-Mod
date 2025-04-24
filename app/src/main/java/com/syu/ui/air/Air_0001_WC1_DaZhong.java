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

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0001_WC1_DaZhong extends AirBase {
    private int nWindLevelLeft;
    private int nWindLevelRight;

    public Air_0001_WC1_DaZhong(Context context) {
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
        boolean invalidate = false;
        c.clipRect(this.mRectEmpty);
        if (this.DATA[21] != 0) {
            c.clipRect(new Rect(148, 30, 252, 68), Region.Op.UNION);
        }
        if (this.DATA[22] != 0) {
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_CUR_SPEED, 40, ConstRzcAddData.U_CAR_ADD_END, 70), Region.Op.UNION);
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_ADD_END, 40, 582, 70), Region.Op.UNION);
        }
        if (this.DATA[41] != 0) {
            c.clipRect(new Rect(ConstRzcAddData.U_CAR_CUR_SPEED, 40, ConstRzcAddData.U_CAR_ADD_END, 70), Region.Op.UNION);
            c.clipRect(new Rect(580, 40, 611, 70), Region.Op.UNION);
        }
        if (this.DATA[23] == 0) {
            c.clipRect(new Rect(410, 26, ConstRzcAddData.U_CAR_WIPER_LEV, 72), Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(new Rect(426, 104, ConstRzcAddData.U_CAR_LIGHT_NEAR, 151), Region.Op.UNION);
        }
        if (this.DATA[26] != 0) {
            c.clipRect(new Rect(537, 104, 608, 154), Region.Op.UNION);
        }
        if (this.DATA[27] != 0) {
            c.clipRect(new Rect(831, 35, 883, 70), Region.Op.UNION);
        }
        if (this.DATA[28] != 0) {
            c.clipRect(new Rect(765, 36, 827, 71), Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[29], 0, 3);
        this.mRectTmp.set(new Rect(52, 138, 115, 156).left, new Rect(52, 138, 115, 156).top, new Rect(52, 138, 115, 156).left + (((new Rect(52, 138, 115, 156).right - new Rect(52, 138, 115, 156).left) * value) / 3), new Rect(52, 138, 115, 156).bottom);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        int value2 = ToolkitMath.clamp(this.DATA[30], 0, 3);
        this.mRectTmp.set(new Rect(955, 138, 1019, 157).left, new Rect(955, 138, 1019, 157).top, new Rect(955, 138, 1019, 157).left + (((new Rect(955, 138, 1019, 157).right - new Rect(955, 138, 1019, 157).left) * value2) / 3), new Rect(955, 138, 1019, 157).bottom);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[33] != 0) {
            c.clipRect(new Rect(294, 9, 317, 32), Region.Op.UNION);
        }
        if (this.DATA[34] != 0) {
            c.clipRect(new Rect(314, 32, 346, 46), Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(new Rect(296, 45, Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30, 69), Region.Op.UNION);
        }
        int value3 = ToolkitMath.clamp(this.DATA[36], 0, 7);
        if (this.nWindLevelLeft != value3) {
            invalidate = true;
            if (this.nWindLevelLeft < value3) {
                this.nWindLevelLeft++;
            } else {
                this.nWindLevelLeft--;
            }
        }
        this.mRectTmp.set(new Rect(176, 134, 374, 154).left, new Rect(176, 134, 374, 154).top, new Rect(176, 134, 374, 154).left + (((new Rect(176, 134, 374, 154).right - new Rect(176, 134, 374, 154).left) * value3) / 7), new Rect(176, 134, 374, 154).bottom);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[37] != 0) {
            c.clipRect(new Rect(715, 10, 738, 31), Region.Op.UNION);
        }
        if (this.DATA[38] != 0) {
            c.clipRect(new Rect(687, 31, 714, 44), Region.Op.UNION);
        }
        if (this.DATA[39] != 0) {
            c.clipRect(new Rect(714, 48, 737, 65), Region.Op.UNION);
        }
        int value4 = ToolkitMath.clamp(this.DATA[40], 0, 7);
        if (this.nWindLevelRight != value4) {
            invalidate = true;
            if (this.nWindLevelRight < value4) {
                this.nWindLevelRight++;
            } else {
                this.nWindLevelRight--;
            }
        }
        this.mRectTmp.set(new Rect(657, 134, 855, 153).left, new Rect(657, 134, 855, 153).top, new Rect(657, 134, 855, 153).left + (((new Rect(657, 134, 855, 153).right - new Rect(657, 134, 855, 153).left) * value4) / 7), new Rect(657, 134, 855, 153).bottom);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int value5 = ToolkitMath.clamp(this.DATA[31], 0, 255);
        switch (value5) {
            case 0:
                c.drawText("NO", new Rect(51, 67, 51, 67).left, new Rect(51, 67, 51, 67).top, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", new Rect(51, 67, 51, 67).left, new Rect(51, 67, 51, 67).top, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", new Rect(51, 67, 51, 67).left, new Rect(51, 67, 51, 67).top, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value5)), new Rect(51, 67, 51, 67).left, new Rect(51, 67, 51, 67).top, this.mPaint);
                break;
        }
        int value6 = ToolkitMath.clamp(this.DATA[32], 0, 255);
        switch (value6) {
            case 0:
                c.drawText("NO", new Rect(945, 67, 949, 58).left, new Rect(945, 67, 949, 58).top, this.mPaint);
                break;
            case 1:
                c.drawText("LOW", new Rect(945, 67, 949, 58).left, new Rect(945, 67, 949, 58).top, this.mPaint);
                break;
            case 255:
                c.drawText("HIGH", new Rect(945, 67, 949, 58).left, new Rect(945, 67, 949, 58).top, this.mPaint);
                break;
            default:
                c.drawText(String.format("%.1f", Float.valueOf(value6)), new Rect(945, 67, 949, 58).left, new Rect(945, 67, 949, 58).top, this.mPaint);
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
        if (invalidate) {
            invalidate();
        }
    }
}
