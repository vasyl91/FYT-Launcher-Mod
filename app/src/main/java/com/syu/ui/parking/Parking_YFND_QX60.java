package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.MotionEvent;

import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitRes;

@SuppressWarnings({"deprecation", "unchecked"})
public class Parking_YFND_QX60 extends ParkingBase {
    private final float X_TxtMsg;
    private final float Y_TxtMsg;
    private boolean b_msg;
    private final Rect back;
    private final Rect camera;
    int data0;
    private final Rect down;
    public int iParkBtn;
    public int iParkCamer;
    public int iParkPage;
    public int iParkText;
    private final Rect left;
    private final Rect left_p;
    private final Rect little;
    private final Rect msg;
    private final Rect pa_mod;
    private final Rect pa_reset;
    private final Rect pa_star;
    private final Rect pa_stop;
    private final Rect pa_stop_3;
    private final Rect pa_stop_6;
    private final Rect pa_switch;
    private final Rect pa_switch_6;
    private final Rect pa_tip;
    private final Rect right;
    private final Rect right_p;
    private final Rect t_left;
    private final Rect t_right;
    private final int tempTextSize;
    private final Rect up;
    private final Rect z_left;
    private final Rect z_right;

    public Parking_YFND_QX60(Context context) {
        super(context);
        this.b_msg = false;
        this.iParkPage = 0;
        this.iParkText = 0;
        this.iParkBtn = 0;
        this.iParkCamer = 0;
        this.msg = new Rect(0, 0, 50, 50);
        this.camera = new Rect(8, 443, 109, 538);
        this.pa_mod = new Rect(128, 462, 346, ConstRzcAddData.U_CAR_HANDBRAKE);
        this.pa_switch = new Rect(380, 462, 598, ConstRzcAddData.U_CAR_HANDBRAKE);
        this.pa_stop = new Rect(632, 462, 850, ConstRzcAddData.U_CAR_HANDBRAKE);
        this.back = new Rect(461, 5, 631, 67);
        this.up = new Rect(281, 153, 365, 225);
        this.left = new Rect(189, 216, 290, 288);
        this.right = new Rect(360, 216, 461, 288);
        this.down = new Rect(281, 283, 365, 355);
        this.left_p = new Rect(86, 216, 187, 288);
        this.right_p = new Rect(469, 216, 570, 288);
        this.little = new Rect(371, 386, 619, 448);
        this.pa_stop_3 = new Rect(34, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74, 174, 526);
        this.pa_star = new Rect(174, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74, 314, 526);
        this.pa_tip = new Rect(Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B32, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74, 617, 526);
        this.t_left = new Rect(34, 79, 322, 264);
        this.t_right = new Rect(330, 79, 618, 264);
        this.z_left = new Rect(34, 270, 322, 455);
        this.z_right = new Rect(330, 270, 618, 455);
        this.pa_reset = new Rect(119, 464, 277, 527);
        this.pa_stop_6 = new Rect(279, 464, 437, 527);
        this.pa_switch_6 = new Rect(438, 464, 596, 527);
        this.X_TxtMsg = 260.0f;
        this.Y_TxtMsg = 45.0f;
        this.tempTextSize = 24;
        this.data0 = 0;
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
    }

    @Override
    protected void initDrawable() {
        this.mDrawableNull = ToolkitRes.loadDrawable("parking/parking_null.webp");
        this.mDrawableNormal_1 = ToolkitRes.loadDrawable("parking/qx60/parking_001.webp");
        this.mDrawableHighlight_1 = ToolkitRes.loadDrawable("parking/qx60/parking_001_p.webp");
        this.mDrawableNormal_2 = ToolkitRes.loadDrawable("parking/qx60/parking_002.webp");
        this.mDrawableHighlight_2 = ToolkitRes.loadDrawable("parking/qx60/parking_002_p.webp");
        this.mDrawableNormal_3 = ToolkitRes.loadDrawable("parking/qx60/parking_003.webp");
        this.mDrawableHighlight_3 = ToolkitRes.loadDrawable("parking/qx60/parking_003_p.webp");
        this.mDrawableNormal_4 = ToolkitRes.loadDrawable("parking/qx60/parking_004.webp");
        this.mDrawableHighlight_4 = ToolkitRes.loadDrawable("parking/qx60/parking_004_p.webp");
        this.mDrawableNormal_5 = ToolkitRes.loadDrawable("parking/qx60/parking_005.webp");
        this.mDrawableHighlight_5 = ToolkitRes.loadDrawable("parking/qx60/parking_005_p.webp");
        this.mDrawableNormal_6 = ToolkitRes.loadDrawable("parking/qx60/parking_006.webp");
        this.mDrawableHighlight_6 = ToolkitRes.loadDrawable("parking/qx60/parking_006_p.webp");
    }

    public boolean TouchRect(int x, int y, Rect rect) {
        return x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }

    @Override
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
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    DataCanbus.PROXY.cmd(1, new int[]{Parking_YFND_QX60.this.data0}, null, null);
                }
            }, 200L);
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.iParkPage = this.DATA[90];
        this.iParkText = this.DATA[89];
        this.iParkBtn = this.DATA[91] & 15;
        this.iParkCamer = this.DATA[92];
        this.b_msg = this.iParkText == 129 || this.iParkText == 130;
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.iParkPage == 1 || this.iParkPage == 2 || this.iParkPage == 6) {
            c.clipRect(this.camera, Region.Op.UNION);
            if (this.iParkCamer == 1) {
                this.mDrawableHighlight_1.draw(c);
            } else if (this.iParkCamer == 2) {
                this.mDrawableNormal_1.draw(c);
            } else if (this.iParkCamer == 3) {
                this.mDrawableHighlight_2.draw(c);
            } else if (this.iParkCamer == 4) {
                this.mDrawableNormal_2.draw(c);
            }
        }
        c.clipRect(this.mRectEmpty);
        if (this.b_msg) {
            c.clipRect(this.msg, Region.Op.UNION);
        }
        switch (this.iParkPage) {
            case 1:
                if (this.iParkBtn == 1) {
                    c.clipRect(this.pa_mod, Region.Op.UNION);
                }
                if (this.iParkBtn == 2) {
                    c.clipRect(this.pa_switch, Region.Op.UNION);
                }
                if (this.iParkBtn == 3) {
                    c.clipRect(this.pa_stop, Region.Op.UNION);
                }
                this.mDrawableHighlight_1.draw(c);
                c.clipRect(this.camera, Region.Op.UNION);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_1.draw(c);
                break;
            case 2:
                if (this.iParkBtn == 1) {
                    c.clipRect(this.pa_mod, Region.Op.UNION);
                }
                if (this.iParkBtn == 2) {
                    c.clipRect(this.pa_switch, Region.Op.UNION);
                }
                this.mDrawableHighlight_2.draw(c);
                c.clipRect(this.camera, Region.Op.UNION);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_2.draw(c);
                break;
            case 3:
                if (this.iParkBtn == 4) {
                    c.clipRect(this.back, Region.Op.UNION);
                }
                if (this.iParkBtn == 5) {
                    c.clipRect(this.t_left, Region.Op.UNION);
                }
                if (this.iParkBtn == 6) {
                    c.clipRect(this.t_right, Region.Op.UNION);
                }
                if (this.iParkBtn == 7) {
                    c.clipRect(this.z_left, Region.Op.UNION);
                }
                if (this.iParkBtn == 8) {
                    c.clipRect(this.z_right, Region.Op.UNION);
                }
                if (this.iParkBtn == 3) {
                    c.clipRect(this.pa_stop_3, Region.Op.UNION);
                }
                this.mDrawableHighlight_3.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_3.draw(c);
                break;
            case 4:
                if (this.iParkBtn == 10) {
                    c.clipRect(this.pa_stop_3, Region.Op.UNION);
                }
                if (this.iParkBtn == 12) {
                    c.clipRect(this.pa_star, Region.Op.UNION);
                }
                if (this.iParkBtn == 11) {
                    c.clipRect(this.pa_reset, Region.Op.UNION);
                }
                this.mDrawableHighlight_4.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_4.draw(c);
                break;
            case 5:
                if (this.iParkBtn == 10) {
                    c.clipRect(this.pa_stop_3, Region.Op.UNION);
                }
                if (this.iParkBtn == 12) {
                    c.clipRect(this.pa_star, Region.Op.UNION);
                }
                if (this.iParkBtn == 9) {
                    c.clipRect(this.little, Region.Op.UNION);
                }
                this.mDrawableHighlight_5.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_5.draw(c);
                break;
            case 6:
                if (this.iParkBtn == 11) {
                    c.clipRect(this.pa_reset, Region.Op.UNION);
                }
                if (this.iParkBtn == 10) {
                    c.clipRect(this.pa_stop_6, Region.Op.UNION);
                }
                if (this.iParkBtn == 2) {
                    c.clipRect(this.pa_switch, Region.Op.UNION);
                }
                this.mDrawableHighlight_6.draw(c);
                c.clipRect(this.camera, Region.Op.UNION);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_6.draw(c);
                break;
            default:
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNull.draw(c);
                break;
        }
        this.mPaint.setTextSize(this.tempTextSize);
        String StrMsg = null;
        if (this.iParkText == 129) {
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
