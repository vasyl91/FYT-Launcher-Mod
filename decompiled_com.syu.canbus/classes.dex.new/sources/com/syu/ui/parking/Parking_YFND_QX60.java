package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitRes;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Parking_YFND_QX60 extends ParkingBase {
    private final float X_TxtMsg;
    private final float Y_TxtMsg;
    private boolean b_msg;
    private RectF back;
    private RectF camera;
    int data0;
    private RectF down;
    public int iParkBtn;
    public int iParkCamer;
    public int iParkPage;
    public int iParkText;
    private RectF left;
    private RectF left_p;
    private RectF little;
    private RectF msg;
    private RectF pa_mod;
    private RectF pa_reset;
    private RectF pa_star;
    private RectF pa_stop;
    private RectF pa_stop_3;
    private RectF pa_stop_6;
    private RectF pa_switch;
    private RectF pa_switch_6;
    private RectF pa_tip;
    private RectF right;
    private RectF right_p;
    private RectF t_left;
    private RectF t_right;
    private int tempTextSize;
    private RectF up;
    private RectF z_left;
    private RectF z_right;

    public Parking_YFND_QX60(Context context) {
        super(context);
        this.b_msg = false;
        this.iParkPage = 0;
        this.iParkText = 0;
        this.iParkBtn = 0;
        this.iParkCamer = 0;
        this.msg = new RectF(0.0f, 0.0f, 50.0f, 50.0f);
        this.camera = new RectF(8.0f, 443.0f, 109.0f, 538.0f);
        this.pa_mod = new RectF(128.0f, 462.0f, 346.0f, 519.0f);
        this.pa_switch = new RectF(380.0f, 462.0f, 598.0f, 519.0f);
        this.pa_stop = new RectF(632.0f, 462.0f, 850.0f, 519.0f);
        this.back = new RectF(461.0f, 5.0f, 631.0f, 67.0f);
        this.up = new RectF(281.0f, 153.0f, 365.0f, 225.0f);
        this.left = new RectF(189.0f, 216.0f, 290.0f, 288.0f);
        this.right = new RectF(360.0f, 216.0f, 461.0f, 288.0f);
        this.down = new RectF(281.0f, 283.0f, 365.0f, 355.0f);
        this.left_p = new RectF(86.0f, 216.0f, 187.0f, 288.0f);
        this.right_p = new RectF(469.0f, 216.0f, 570.0f, 288.0f);
        this.little = new RectF(371.0f, 386.0f, 619.0f, 448.0f);
        this.pa_stop_3 = new RectF(34.0f, 466.0f, 174.0f, 526.0f);
        this.pa_star = new RectF(174.0f, 466.0f, 314.0f, 526.0f);
        this.pa_tip = new RectF(477.0f, 466.0f, 617.0f, 526.0f);
        this.t_left = new RectF(34.0f, 79.0f, 322.0f, 264.0f);
        this.t_right = new RectF(330.0f, 79.0f, 618.0f, 264.0f);
        this.z_left = new RectF(34.0f, 270.0f, 322.0f, 455.0f);
        this.z_right = new RectF(330.0f, 270.0f, 618.0f, 455.0f);
        this.pa_reset = new RectF(119.0f, 464.0f, 277.0f, 527.0f);
        this.pa_stop_6 = new RectF(279.0f, 464.0f, 437.0f, 527.0f);
        this.pa_switch_6 = new RectF(438.0f, 464.0f, 596.0f, 527.0f);
        this.X_TxtMsg = 260.0f;
        this.Y_TxtMsg = 45.0f;
        this.tempTextSize = 24;
        this.data0 = 0;
    }

    @Override // com.syu.ui.parking.ParkingBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
    }

    @Override // com.syu.ui.parking.ParkingBase
    protected void initDrawable() {
        this.mDrawableNull = ToolkitRes.loadDrawable("parking/parking_null.webp");
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (!language.endsWith("CN")) {
            this.mDrawableNormal_1 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_001_p.webp");
            this.mDrawableHighlight_1 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_001.webp");
            this.mDrawableNormal_2 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_fornt_001_p.webp");
            this.mDrawableHighlight_2 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_fornt_001.webp");
            this.mDrawableNormal_6 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_001_p.webp");
            this.mDrawableHighlight_6 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_001.webp");
            this.mDrawableNormal_7 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfornt_001_p.webp");
            this.mDrawableHighlight_7 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfornt_001.webp");
            this.mDrawableNormal_8 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_002_p.webp");
            this.mDrawableHighlight_8 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_002.webp");
            this.mDrawableNormal_9 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_fornt_002_p.webp");
            this.mDrawableHighlight_9 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_fornt_002.webp");
            this.mDrawableNormal_10 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_002_p.webp");
            this.mDrawableHighlight_10 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_002.webp");
            this.mDrawableNormal_11 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfornt_002_p.webp");
            this.mDrawableHighlight_11 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfornt_002.webp");
            this.mDrawableNormal_12 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_006_p.webp");
            this.mDrawableHighlight_12 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_rear_006.webp");
            this.mDrawableNormal_13 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_front_006_p.webp");
            this.mDrawableHighlight_13 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_front_006.webp");
            this.mDrawableNormal_14 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_006_p.webp");
            this.mDrawableHighlight_14 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wrear_006.webp");
            this.mDrawableNormal_15 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfront_006_p.webp");
            this.mDrawableHighlight_15 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_wfront_006.webp");
            this.mDrawableNormal_3 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_003.webp");
            this.mDrawableHighlight_3 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_003_p.webp");
            this.mDrawableNormal_4 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_004.webp");
            this.mDrawableHighlight_4 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_004_p.webp");
            this.mDrawableNormal_5 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_005.webp");
            this.mDrawableHighlight_5 = ToolkitRes.loadDrawable("parking/qx60/EN/parking_005_p.webp");
            return;
        }
        this.mDrawableNormal_1 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_001_p.webp");
        this.mDrawableHighlight_1 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_001.webp");
        this.mDrawableNormal_2 = ToolkitRes.loadDrawable("parking/qx60/parking_fornt_001_p.webp");
        this.mDrawableHighlight_2 = ToolkitRes.loadDrawable("parking/qx60/parking_fornt_001.webp");
        this.mDrawableNormal_6 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_001_p.webp");
        this.mDrawableHighlight_6 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_001.webp");
        this.mDrawableNormal_7 = ToolkitRes.loadDrawable("parking/qx60/parking_wfornt_001_p.webp");
        this.mDrawableHighlight_7 = ToolkitRes.loadDrawable("parking/qx60/parking_wfornt_001.webp");
        this.mDrawableNormal_8 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_002_p.webp");
        this.mDrawableHighlight_8 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_002.webp");
        this.mDrawableNormal_9 = ToolkitRes.loadDrawable("parking/qx60/parking_fornt_002_p.webp");
        this.mDrawableHighlight_9 = ToolkitRes.loadDrawable("parking/qx60/parking_fornt_002.webp");
        this.mDrawableNormal_10 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_002_p.webp");
        this.mDrawableHighlight_10 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_002.webp");
        this.mDrawableNormal_11 = ToolkitRes.loadDrawable("parking/qx60/parking_wfornt_002_p.webp");
        this.mDrawableHighlight_11 = ToolkitRes.loadDrawable("parking/qx60/parking_wfornt_002.webp");
        this.mDrawableNormal_12 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_006_p.webp");
        this.mDrawableHighlight_12 = ToolkitRes.loadDrawable("parking/qx60/parking_rear_006.webp");
        this.mDrawableNormal_13 = ToolkitRes.loadDrawable("parking/qx60/parking_front_006_p.webp");
        this.mDrawableHighlight_13 = ToolkitRes.loadDrawable("parking/qx60/parking_front_006.webp");
        this.mDrawableNormal_14 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_006_p.webp");
        this.mDrawableHighlight_14 = ToolkitRes.loadDrawable("parking/qx60/parking_wrear_006.webp");
        this.mDrawableNormal_15 = ToolkitRes.loadDrawable("parking/qx60/parking_wfront_006_p.webp");
        this.mDrawableHighlight_15 = ToolkitRes.loadDrawable("parking/qx60/parking_wfront_006.webp");
        this.mDrawableNormal_3 = ToolkitRes.loadDrawable("parking/qx60/parking_003.webp");
        this.mDrawableHighlight_3 = ToolkitRes.loadDrawable("parking/qx60/parking_003_p.webp");
        this.mDrawableNormal_4 = ToolkitRes.loadDrawable("parking/qx60/parking_004.webp");
        this.mDrawableHighlight_4 = ToolkitRes.loadDrawable("parking/qx60/parking_004_p.webp");
        this.mDrawableNormal_5 = ToolkitRes.loadDrawable("parking/qx60/parking_005.webp");
        this.mDrawableHighlight_5 = ToolkitRes.loadDrawable("parking/qx60/parking_005_p.webp");
    }

    public boolean TouchRect(int x, int y, RectF rect) {
        return ((float) x) >= rect.left && ((float) x) <= rect.right && ((float) y) >= rect.top && ((float) y) <= rect.bottom;
    }

    @Override // com.syu.ui.parking.ParkingBase, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.data0 = 0;
        int x = (int) (event.getX() / this.mScale);
        int y = (int) (event.getY() / this.mScale);
        if (this.iParkPage == 1 || this.iParkPage == 2) {
            if (TouchRect(x, y, this.camera)) {
                this.data0 = 1;
            } else if (TouchRect(x, y, this.pa_mod)) {
                this.data0 = 36;
            } else if (TouchRect(x, y, this.pa_switch)) {
                this.data0 = 30;
            } else if (TouchRect(x, y, this.pa_stop) && this.iParkPage != 2) {
                this.data0 = 17;
            }
        } else if (this.iParkPage == 3 || this.iParkPage == 4 || this.iParkPage == 5) {
            if (TouchRect(x, y, this.back)) {
                this.data0 = 22;
            } else if (TouchRect(x, y, this.pa_stop_3)) {
                this.data0 = 21;
            } else if (TouchRect(x, y, this.pa_star) && this.iParkPage != 3) {
                this.data0 = 20;
            } else if (TouchRect(x, y, this.up) && this.iParkPage != 3) {
                this.data0 = 24;
            } else if (TouchRect(x, y, this.down) && this.iParkPage != 3) {
                this.data0 = 25;
            } else if (TouchRect(x, y, this.left) && this.iParkPage != 3) {
                this.data0 = 26;
            } else if (TouchRect(x, y, this.right) && this.iParkPage != 3) {
                this.data0 = 27;
            } else if (TouchRect(x, y, this.left_p) && this.iParkPage != 3) {
                this.data0 = 29;
            } else if (TouchRect(x, y, this.right_p) && this.iParkPage != 3) {
                this.data0 = 28;
            } else if (TouchRect(x, y, this.little) && this.iParkPage == 5) {
                this.data0 = 37;
            } else if (TouchRect(x, y, this.t_left) && this.iParkPage == 3) {
                this.data0 = 32;
            } else if (TouchRect(x, y, this.t_right) && this.iParkPage == 3) {
                this.data0 = 33;
            } else if (TouchRect(x, y, this.z_left) && this.iParkPage == 3) {
                this.data0 = 34;
            } else if (TouchRect(x, y, this.z_right) && this.iParkPage == 3) {
                this.data0 = 35;
            }
        } else if (this.iParkPage == 6) {
            if (TouchRect(x, y, this.camera)) {
                this.data0 = 1;
            } else if (TouchRect(x, y, this.pa_reset)) {
                this.data0 = 31;
            } else if (TouchRect(x, y, this.pa_stop_6)) {
                this.data0 = 21;
            } else if (TouchRect(x, y, this.pa_switch_6)) {
                this.data0 = 30;
            }
        }
        if (this.data0 != 0) {
            DataCanbus.PROXY.cmd(1, new int[]{this.data0, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.ui.parking.Parking_YFND_QX60.1
                @Override // java.lang.Runnable
                public void run() {
                    DataCanbus.PROXY.cmd(1, new int[]{Parking_YFND_QX60.this.data0, 0}, null, null);
                }
            }, 200L);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.iParkPage = this.DATA[142];
        this.iParkText = this.DATA[141];
        this.iParkBtn = this.DATA[143] & 15;
        this.iParkCamer = this.DATA[144];
        if (this.iParkText == 129 || this.iParkText == 130) {
            this.b_msg = true;
        } else {
            this.b_msg = false;
        }
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        switch (this.iParkPage) {
            case 1:
                this.srPath.addRect(this.camera, Path.Direction.CW);
                if (this.iParkCamer == 1) {
                    this.mDrawableNormal_1.draw(c);
                } else if (this.iParkCamer == 2) {
                    this.mDrawableNormal_2.draw(c);
                } else if (this.iParkCamer == 3) {
                    this.mDrawableNormal_6.draw(c);
                } else if (this.iParkCamer == 4) {
                    this.mDrawableNormal_7.draw(c);
                }
                break;
            case 2:
                this.srPath.addRect(this.camera, Path.Direction.CW);
                if (this.iParkCamer == 1) {
                    this.mDrawableNormal_8.draw(c);
                } else if (this.iParkCamer == 2) {
                    this.mDrawableNormal_9.draw(c);
                } else if (this.iParkCamer == 3) {
                    this.mDrawableNormal_10.draw(c);
                } else if (this.iParkCamer == 4) {
                    this.mDrawableNormal_11.draw(c);
                }
                break;
            case 6:
                this.srPath.addRect(this.camera, Path.Direction.CW);
                if (this.iParkCamer == 1) {
                    this.mDrawableNormal_12.draw(c);
                } else if (this.iParkCamer == 2) {
                    this.mDrawableNormal_13.draw(c);
                } else if (this.iParkCamer == 3) {
                    this.mDrawableNormal_14.draw(c);
                } else if (this.iParkCamer == 4) {
                    this.mDrawableNormal_15.draw(c);
                }
                break;
        }
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.b_msg) {
            this.srPath.addRect(this.msg, Path.Direction.CW);
        }
        switch (this.iParkPage) {
            case 1:
                if (this.iParkBtn == 1) {
                    this.srPath.addRect(this.pa_mod, Path.Direction.CW);
                }
                if (this.iParkBtn == 2) {
                    this.srPath.addRect(this.pa_switch, Path.Direction.CW);
                }
                if (this.iParkBtn == 3) {
                    this.srPath.addRect(this.pa_stop, Path.Direction.CW);
                }
                this.srPath.addRect(this.camera, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                switch (this.iParkCamer) {
                    case 1:
                        this.mDrawableHighlight_1.draw(c);
                        break;
                    case 2:
                        this.mDrawableHighlight_2.draw(c);
                        break;
                    case 3:
                        this.mDrawableHighlight_6.draw(c);
                        break;
                    case 4:
                        this.mDrawableHighlight_7.draw(c);
                        break;
                }
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                break;
            case 2:
                if (this.iParkBtn == 1) {
                    this.srPath.addRect(this.pa_mod, Path.Direction.CW);
                }
                if (this.iParkBtn == 2) {
                    this.srPath.addRect(this.pa_switch, Path.Direction.CW);
                }
                this.srPath.addRect(this.camera, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                switch (this.iParkCamer) {
                    case 1:
                        this.mDrawableHighlight_8.draw(c);
                        break;
                    case 2:
                        this.mDrawableHighlight_9.draw(c);
                        break;
                    case 3:
                        this.mDrawableHighlight_10.draw(c);
                        break;
                    case 4:
                        this.mDrawableHighlight_11.draw(c);
                        break;
                }
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                break;
            case 3:
                if (this.iParkBtn == 4) {
                    this.srPath.addRect(this.back, Path.Direction.CW);
                }
                if (this.iParkBtn == 5) {
                    this.srPath.addRect(this.t_left, Path.Direction.CW);
                }
                if (this.iParkBtn == 6) {
                    this.srPath.addRect(this.t_right, Path.Direction.CW);
                }
                if (this.iParkBtn == 7) {
                    this.srPath.addRect(this.z_left, Path.Direction.CW);
                }
                if (this.iParkBtn == 8) {
                    this.srPath.addRect(this.z_right, Path.Direction.CW);
                }
                if (this.iParkBtn == 3) {
                    this.srPath.addRect(this.pa_stop_3, Path.Direction.CW);
                }
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_3.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_3.draw(c);
                break;
            case 4:
                if (this.iParkBtn == 10) {
                    this.srPath.addRect(this.pa_stop_3, Path.Direction.CW);
                }
                if (this.iParkBtn == 12) {
                    this.srPath.addRect(this.pa_star, Path.Direction.CW);
                }
                if (this.iParkBtn == 11) {
                    this.srPath.addRect(this.pa_reset, Path.Direction.CW);
                }
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_4.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_4.draw(c);
                break;
            case 5:
                if (this.iParkBtn == 10) {
                    this.srPath.addRect(this.pa_stop_3, Path.Direction.CW);
                }
                if (this.iParkBtn == 12) {
                    this.srPath.addRect(this.pa_star, Path.Direction.CW);
                }
                if (this.iParkBtn == 9) {
                    this.srPath.addRect(this.little, Path.Direction.CW);
                }
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_5.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_5.draw(c);
                break;
            case 6:
                if (this.iParkBtn == 11) {
                    this.srPath.addRect(this.pa_reset, Path.Direction.CW);
                }
                if (this.iParkBtn == 10) {
                    this.srPath.addRect(this.pa_stop_6, Path.Direction.CW);
                }
                if (this.iParkBtn == 2) {
                    this.srPath.addRect(this.pa_switch, Path.Direction.CW);
                }
                this.srPath.addRect(this.camera, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                switch (this.iParkCamer) {
                    case 1:
                        this.mDrawableHighlight_12.draw(c);
                        break;
                    case 2:
                        this.mDrawableHighlight_13.draw(c);
                        break;
                    case 3:
                        this.mDrawableHighlight_14.draw(c);
                        break;
                    case 4:
                        this.mDrawableHighlight_15.draw(c);
                        break;
                }
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                break;
            default:
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNull.draw(c);
                break;
        }
        this.mPaint.setTextSize(this.tempTextSize);
        String StrMsg = null;
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (!language.endsWith("CN")) {
            if (this.iParkText == 129) {
                StrMsg = "Please confirm the safety around the vehicle!";
            } else if (this.iParkText == 130) {
                StrMsg = "Don't move the vehicle when setting the parking space frame!";
            }
        } else if (this.iParkText == 129) {
            StrMsg = "请直接确认车辆周边的安全";
        } else if (this.iParkText == 130) {
            StrMsg = "设置目标车位线框时，请不要移动车辆";
        }
        if (StrMsg != null) {
            c.drawText(StrMsg, 260.0f, 45.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
