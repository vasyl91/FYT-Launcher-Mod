package com.syu.ui.door;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.SystemProperties;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Door_Default extends DoorBase {
    private RectF back;
    private RectF engine;
    private RectF fl;
    private RectF fr;
    private RectF rl;
    private RectF rr;

    public Door_Default(Context context) {
        super(context);
        this.engine = new RectF(50.0f, 31.0f, 197.0f, 108.0f);
        this.fl = new RectF(15.0f, 121.0f, 91.0f, 192.0f);
        this.fr = new RectF(176.0f, 119.0f, 248.0f, 192.0f);
        this.rl = new RectF(22.0f, 195.0f, 86.0f, 262.0f);
        this.rr = new RectF(173.0f, 195.0f, 237.0f, 262.0f);
        this.back = new RectF(70.0f, 282.0f, 181.0f, 331.0f);
    }

    @Override // com.syu.ui.door.DoorBase
    protected void initSize() {
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.mContentWidth = 1920;
            this.mContentHeight = 630;
            return;
        }
        if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 53 || SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 124) {
                this.mContentWidth = 308;
                this.mContentHeight = Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D1A_RDS4;
                return;
            } else {
                this.mContentWidth = 308;
                this.mContentHeight = 362;
                return;
            }
        }
        if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.mContentWidth = 308;
            this.mContentHeight = 362;
        } else {
            this.mContentWidth = 261;
            this.mContentHeight = 362;
        }
    }

    @Override // com.syu.ui.door.DoorBase
    protected void initDrawable() {
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_tzy.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_tzy_p.png");
            return;
        }
        if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 53 || SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 124) {
                this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_zh2_n.png");
                this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_zh2_p.png");
                return;
            } else {
                this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_tzy_ts.png");
                this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_tzy_ts_p.png");
                return;
            }
        }
        if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_tzy_ts.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_tzy_ts_p.png");
        } else if (DataCanbus.DATA[1000] == 5833078) {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door_zh2_ducato.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door_zh2_ducato_p.png");
        } else {
            this.mDrawableNormal = ToolkitRes.loadDrawable("door/door1.png");
            this.mDrawableHighlight = ToolkitRes.loadDrawable("door/door1_p.png");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 95 && DataCanbus.DATA[1000] == 393666) {
            this.engine = new RectF(836.0f, 91.0f, 1085.0f, 234.0f);
            this.fl = new RectF(770.0f, 233.0f, 885.0f, 318.0f);
            this.fr = new RectF(1031.0f, 233.0f, 1145.0f, 318.0f);
            this.rl = new RectF(787.0f, 337.0f, 901.0f, 425.0f);
            this.rr = new RectF(1020.0f, 337.0f, 1134.0f, 425.0f);
            this.back = new RectF(856.0f, 445.0f, 1063.0f, 547.0f);
        } else if (DataCanbus.DATA[1000] == 786856 || DataCanbus.DATA[1000] == 1049000 || DataCanbus.DATA[1000] == 1114536) {
            if (SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 53 || SystemProperties.getInt("ro.build.fytmanufacturer", 0) == 124) {
                this.engine = new RectF(61.0f, 8.0f, 245.0f, 95.0f);
                this.fl = new RectF(29.0f, 110.0f, 92.0f, 220.0f);
                this.fr = new RectF(221.0f, 101.0f, 287.0f, 217.0f);
                this.rl = new RectF(24.0f, 319.0f, 99.0f, 442.0f);
                this.rr = new RectF(219.0f, 324.0f, 287.0f, 440.0f);
                this.back = new RectF(64.0f, 446.0f, 250.0f, 493.0f);
            } else {
                this.engine = new RectF(66.0f, 8.0f, 234.0f, 101.0f);
                this.fl = new RectF(1.0f, 107.0f, 90.0f, 183.0f);
                this.fr = new RectF(214.0f, 107.0f, 303.0f, 183.0f);
                this.rl = new RectF(4.0f, 197.0f, 93.0f, 273.0f);
                this.rr = new RectF(214.0f, 197.0f, 303.0f, 273.0f);
                this.back = new RectF(75.0f, 304.0f, 230.0f, 360.0f);
            }
        } else if (DataCanbus.DATA[1000] == 459199 || DataCanbus.DATA[1000] == 524735) {
            this.engine = new RectF(66.0f, 8.0f, 234.0f, 101.0f);
            this.fl = new RectF(1.0f, 107.0f, 90.0f, 183.0f);
            this.fr = new RectF(214.0f, 107.0f, 303.0f, 183.0f);
            this.rl = new RectF(4.0f, 197.0f, 93.0f, 273.0f);
            this.rr = new RectF(214.0f, 197.0f, 303.0f, 273.0f);
            this.back = new RectF(75.0f, 304.0f, 230.0f, 360.0f);
        } else if (DataCanbus.DATA[1000] == 5833078) {
            this.engine = new RectF(57.0f, 0.0f, 202.0f, 37.0f);
            this.fl = new RectF(28.0f, 41.0f, 105.0f, 133.0f);
            this.fr = new RectF(172.0f, 48.0f, 228.0f, 133.0f);
            this.rl = new RectF(8.0f, 134.0f, 96.0f, 305.0f);
            this.rr = new RectF(171.0f, 134.0f, 259.0f, 305.0f);
            this.back = new RectF(68.0f, 313.0f, 202.0f, 360.0f);
        }
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        int value = DoorHelper.sUcDoorEngine;
        if (value >= 0 && value < 1200 && this.DATA[value] != 0) {
            this.srPath.addRect(this.engine, Path.Direction.CW);
        }
        int value2 = DoorHelper.sUcDoorFl;
        if (value2 >= 0 && value2 < 1200 && this.DATA[value2] != 0) {
            this.srPath.addRect(this.fl, Path.Direction.CW);
        }
        int value3 = DoorHelper.sUcDoorFr;
        if (value3 >= 0 && value3 < 1200 && this.DATA[value3] != 0) {
            this.srPath.addRect(this.fr, Path.Direction.CW);
        }
        boolean flag = SystemProperties.getBoolean("persist.syu.reversedoor", false);
        if (flag) {
            int value4 = DoorHelper.sUcDoorRl;
            if (value4 >= 0 && value4 < 1200 && this.DATA[value4] != 0) {
                this.srPath.addRect(this.rr, Path.Direction.CW);
            }
            int value5 = DoorHelper.sUcDoorRr;
            if (value5 >= 0 && value5 < 1200 && this.DATA[value5] != 0) {
                this.srPath.addRect(this.rl, Path.Direction.CW);
            }
        } else {
            int value6 = DoorHelper.sUcDoorRl;
            if (value6 >= 0 && value6 < 1200 && this.DATA[value6] != 0) {
                this.srPath.addRect(this.rl, Path.Direction.CW);
            }
            int value7 = DoorHelper.sUcDoorRr;
            if (value7 >= 0 && value7 < 1200 && this.DATA[value7] != 0) {
                this.srPath.addRect(this.rr, Path.Direction.CW);
            }
        }
        int value8 = DoorHelper.sUcDoorBack;
        if (value8 >= 0 && value8 < 1200 && this.DATA[value8] != 0) {
            this.srPath.addRect(this.back, Path.Direction.CW);
        }
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
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
