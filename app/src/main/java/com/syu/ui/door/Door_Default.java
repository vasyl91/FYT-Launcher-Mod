package com.syu.ui.door;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.SystemProperties;

import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

public class Door_Default extends DoorBase {
    private Rect back;
    private Rect engine;
    private Rect fl;
    private Rect fr;
    private Rect rl;
    private Rect rr;

    public Door_Default(Context context) {
        super(context);
        this.engine = new Rect(50, 31, 197, 108);
        this.fl = new Rect(15, 121, 91, 192);
        this.fr = new Rect(176, 119, 248, 192);
        this.rl = new Rect(22, 195, 86, 262);
        this.rr = new Rect(173, 195, 237, 262);
        this.back = new Rect(70, 282, 181, 331);
    }

    @Override
    protected void initSize() {
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.mContentWidth = 1920;
            this.mContentHeight = 630;
            return;
        }
        if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            this.mContentWidth = 308;
            this.mContentHeight = 496;
        } else if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.mContentWidth = 308;
            this.mContentHeight = 362;
        } else {
            this.mContentWidth = 261;
            this.mContentHeight = 362;
        }
    }

    @Override
    protected void initDrawable() {
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_tzy.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_tzy_p.png");
            return;
        }
        if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_zh2_n.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_zh2_p.png");
        } else if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_tzy_ts.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_tzy_ts_p.png");
        } else {
            //this.mDrawableNormal = ToolkitRes.loadDrawable("door/door1.png");
            //this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door1_p.png");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.engine = new Rect(836, 91, 1085, 234);
            this.fl = new Rect(770, 233, 885, Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30);
            this.fr = new Rect(1031, 233, 1145, Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30);
            this.rl = new Rect(787, 337, 901, 425);
            this.rr = new Rect(1020, 337, 1134, 425);
            this.back = new Rect(856, 445, 1063, 547);
        } else if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            this.engine = new Rect(61, 8, 245, 95);
            this.fl = new Rect(29, 110, 92, 220);
            this.fr = new Rect(221, 101, 287, 217);
            this.rl = new Rect(24, 319, 99, 442);
            this.rr = new Rect(219, 324, 287, 440);
            this.back = new Rect(64, 446, 250, 493);
        } else if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.engine = new Rect(66, 8, 234, 101);
            this.fl = new Rect(1, 107, 90, 183);
            this.fr = new Rect(214, 107, 303, 183);
            this.rl = new Rect(4, 197, 93, 273);
            this.rr = new Rect(214, 197, 303, 273);
            this.back = new Rect(75, 304, 230, 360);
        }
        c.clipRect(this.mRectEmpty);
        int value = DoorHelper.sUcDoorEngine;
        int door = 0;
        if (value >= 0 && value < 1200 && this.DATA[value] != 0) {
            c.clipRect(this.engine, Region.Op.UNION);
            door = 0 | 1;
        }
        int value2 = DoorHelper.sUcDoorFl;
        if (value2 >= 0 && value2 < 1200 && this.DATA[value2] != 0) {
            c.clipRect(this.fl, Region.Op.UNION);
            door |= 4;
        }
        int value3 = DoorHelper.sUcDoorFr;
        if (value3 >= 0 && value3 < 1200 && this.DATA[value3] != 0) {
            c.clipRect(this.fr, Region.Op.UNION);
            door |= 8;
        }
        boolean flag = SystemProperties.getBoolean("persist.syu.reversedoor", false);
        if (flag) {
            int value4 = DoorHelper.sUcDoorRl;
            if (value4 >= 0 && value4 < 1200 && this.DATA[value4] != 0) {
                c.clipRect(this.rr, Region.Op.UNION);
                door |= 32;
            }
            int value5 = DoorHelper.sUcDoorRr;
            if (value5 >= 0 && value5 < 1200 && this.DATA[value5] != 0) {
                c.clipRect(this.rl, Region.Op.UNION);
                door |= 16;
            }
        } else {
            int value6 = DoorHelper.sUcDoorRl;
            if (value6 >= 0 && value6 < 1200 && this.DATA[value6] != 0) {
                c.clipRect(this.rl, Region.Op.UNION);
                door |= 16;
            }
            int value7 = DoorHelper.sUcDoorRr;
            if (value7 >= 0 && value7 < 1200 && this.DATA[value7] != 0) {
                c.clipRect(this.rr, Region.Op.UNION);
                door |= 32;
            }
        }
        int value8 = DoorHelper.sUcDoorBack;
        if (value8 >= 0 && value8 < 1200 && this.DATA[value8] != 0) {
            c.clipRect(this.back, Region.Op.UNION);
            int i = door | 2;
        }
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
