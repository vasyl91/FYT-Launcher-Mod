package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.MotionEvent;

import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitRes;

public class Parking_QiJun extends ParkingBase {
    private final String[] StrMsg;
    private final float X_TxtMsg;
    private final float Y_TxtMsg;
    private final boolean b_cancle;
    private boolean b_down;
    private boolean b_left;
    private boolean b_left_p;
    private boolean b_msg;
    private boolean b_pa;
    private boolean b_right;
    private boolean b_right_p;
    private boolean b_star;
    private boolean b_up;
    private final boolean b_up_down;
    private final Rect back;
    private final Rect camera;
    private final Rect cancle;
    int data0;
    private final Rect down;
    public int iParkBtn;
    public int iParkCamer;
    public int iParkPage;
    public int iParkText;
    private final Rect left;
    private final Rect left_p;
    private final Rect msg;
    private final Rect right;
    private final Rect right_p;
    private final Rect star;
    private final int tempTextSize;
    private final Rect up;
    private final Rect up_down;

    public Parking_QiJun(Context context) {
        super(context);
        this.b_msg = false;
        this.b_cancle = false;
        this.b_star = false;
        this.b_pa = false;
        this.b_up_down = false;
        this.b_up = false;
        this.b_left = false;
        this.b_right = false;
        this.b_down = false;
        this.b_left_p = false;
        this.b_right_p = false;
        this.iParkPage = 0;
        this.iParkText = 0;
        this.iParkBtn = 0;
        this.iParkCamer = 0;
        this.msg = new Rect(0, 0, 50, 50);
        this.camera = new Rect(18, 445, 154, ConstRzcAddData.U_CAR_VOLTAGE);
        this.cancle = new Rect(178, 445, 314, ConstRzcAddData.U_CAR_VOLTAGE);
        this.star = new Rect(332, 445, 468, ConstRzcAddData.U_CAR_VOLTAGE);
        this.back = new Rect(488, 445, 624, ConstRzcAddData.U_CAR_VOLTAGE);
        this.up_down = new Rect(778, 445, 914, ConstRzcAddData.U_CAR_VOLTAGE);
        this.up = new Rect(286, 141, 387, 208);
        this.left = new Rect(182, 226, 283, 293);
        this.right = new Rect(388, 226, 489, 293);
        this.down = new Rect(286, 313, 387, 380);
        this.left_p = new Rect(63, 171, 156, 337);
        this.right_p = new Rect(ConstRzcAddData.U_CAR_LIGHT, 171, 610, 337);
        this.X_TxtMsg = 280.0f;
        this.Y_TxtMsg = 35.0f;
        this.tempTextSize = 30;
        this.StrMsg = new String[]{"", "Ensure it is safe before manoeuvring", "Stop beside park slot to start assist", "Stop and select reverse gear", "Stop and select forward gear", "Stop next to empty parking space", "Check surroudings", "Drive forward", "Drive backwards", "Drive Forward with care", "Drive backward with care", "Reduce speed", "Press ↑↓ to set parking position", "Adjust park position", "[STOP]Steering rotating", "[STOP]Check obstacle", "", "Select forward gear", "Remove trailer", "System Fault", "Park Assist fault", "Steering Intervened", "Centre steering whell", "VDC must be ON", "Over Speed", "Time Out", "", "Close door to start", "Trailer ON", "VDC Active", "Door Open/Belt OFF", "", "Park assist finished", "Park Assist not availble", "EPS not active", "Space found,drive forward", "Stop", "", "Engine not active", "Fwd gear outside of park slot", "Select reverse gear", "", "", "Resume not possible", "", "", "Park Assist Canceled", "", "Use turn signal to change side"};
        this.data0 = 0;
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
    }

    @Override
    protected void initDrawable() {
        this.mDrawableNull = ToolkitRes.loadDrawable("parking/parking_null.png");
        this.mDrawableNormal_1 = ToolkitRes.loadDrawable("parking/qijun/parking_001.webp");
        this.mDrawableHighlight_1 = ToolkitRes.loadDrawable("parking/qijun/parking_001_p.webp");
        this.mDrawableNormal_2 = ToolkitRes.loadDrawable("parking/qijun/parking_002.webp");
        this.mDrawableHighlight_2 = ToolkitRes.loadDrawable("parking/qijun/parking_002_p.webp");
        this.mDrawableNormal_3 = ToolkitRes.loadDrawable("parking/qijun/parking_003.webp");
        this.mDrawableHighlight_3 = ToolkitRes.loadDrawable("parking/qijun/parking_003_p.webp");
        this.mDrawableNormal_4 = ToolkitRes.loadDrawable("parking/qijun/parking_004.webp");
        this.mDrawableHighlight_4 = ToolkitRes.loadDrawable("parking/qijun/parking_004_p.webp");
        this.mDrawableNormal_5 = ToolkitRes.loadDrawable("parking/qijun/parking_005.webp");
        this.mDrawableHighlight_5 = ToolkitRes.loadDrawable("parking/qijun/parking_005_p.webp");
        this.mDrawableNormal_6 = ToolkitRes.loadDrawable("parking/qijun/parking_006.webp");
        this.mDrawableHighlight_6 = ToolkitRes.loadDrawable("parking/qijun/parking_006_p.webp");
    }

    public boolean TouchRect(int x, int y, Rect rect) {
        return x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.data0 = 0;
        int x = (int) (event.getX() / this.mScale);
        int y = (int) (event.getY() / this.mScale);
        if (TouchRect(x, y, this.cancle) && this.iParkPage != 6) {
            this.data0 = 21;
        } else if (TouchRect(x, y, this.star) && ((this.iParkPage == 2 || this.iParkPage == 4) && !this.b_star)) {
            this.data0 = 20;
        } else if (TouchRect(x, y, this.back)) {
            if (this.iParkPage == 1 && !this.b_pa) {
                this.data0 = 17;
            } else if (this.iParkPage == 2) {
                this.data0 = 19;
            } else if (this.iParkPage == 3) {
                this.data0 = 18;
            } else if (this.iParkPage == 4) {
                this.data0 = 22;
            }
        } else if (TouchRect(x, y, this.up_down) && this.iParkPage == 2) {
            this.data0 = 23;
        } else if (TouchRect(x, y, this.up) && this.iParkPage == 4 && !this.b_up) {
            this.data0 = 24;
        } else if (TouchRect(x, y, this.down) && this.iParkPage == 4 && !this.b_down) {
            this.data0 = 25;
        } else if (TouchRect(x, y, this.left) && this.iParkPage == 4 && !this.b_left) {
            this.data0 = 26;
        } else if (TouchRect(x, y, this.right) && this.iParkPage == 4 && !this.b_right) {
            this.data0 = 27;
        } else if (TouchRect(x, y, this.left_p) && this.iParkPage == 4 && !this.b_left_p) {
            this.data0 = 29;
        } else if (TouchRect(x, y, this.right_p) && this.iParkPage == 4 && !this.b_right_p) {
            this.data0 = 28;
        }
        if (this.data0 != 0) {
            DataCanbus.PROXY.cmd(1, new int[]{this.data0, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    DataCanbus.PROXY.cmd(1, new int[]{Parking_QiJun.this.data0}, null, null);
                }
            }, 200L);
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.iParkPage = this.DATA[87];
        this.iParkText = this.DATA[86];
        this.iParkBtn = this.DATA[88];
        this.iParkCamer = this.DATA[89];
        this.b_msg = this.iParkText == 18 || this.iParkText == 19 || this.iParkText == 20 || this.iParkText == 21 || this.iParkText == 23 || this.iParkText == 24 || this.iParkText == 25 || this.iParkText == 27 || this.iParkText == 28 || this.iParkText == 29 || this.iParkText == 30 || this.iParkText == 33 || this.iParkText == 34 || this.iParkText == 38 || this.iParkText == 39 || this.iParkText == 43 || this.iParkText == 48;
        if (458832 == DataCanbus.sCanbusId) {
            if (this.iParkPage == 4) {
                this.b_left_p = ((this.iParkBtn >> 2) & 1) == 1;
                this.b_right_p = ((this.iParkBtn >> 3) & 1) == 1;
                this.b_left = ((this.iParkBtn >> 5) & 1) == 1;
                this.b_right = ((this.iParkBtn >> 4) & 1) == 1;
                this.b_up = ((this.iParkBtn >> 7) & 1) == 1;
                this.b_down = ((this.iParkBtn >> 6) & 1) == 1;
            }
        } else {
            this.b_star = ((this.iParkBtn >> 7) & 1) == 1;
            this.b_pa = ((this.iParkBtn >> 6) & 1) == 1;
            if (this.iParkPage == 4) {
                this.b_left_p = ((this.iParkBtn >> 5) & 1) == 1;
                this.b_right_p = ((this.iParkBtn >> 4) & 1) == 1;
                this.b_left = ((this.iParkBtn >> 2) & 1) == 1;
                this.b_right = ((this.iParkBtn >> 3) & 1) == 1;
                this.b_up = (this.iParkBtn & 1) == 1;
                this.b_down = ((this.iParkBtn >> 1) & 1) == 1;
            }
        }
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.b_msg) {
            c.clipRect(this.msg, Region.Op.UNION);
        }
        switch (this.iParkPage) {
            case 1:
                if (this.iParkCamer == 2) {
                    c.clipRect(this.camera, Region.Op.UNION);
                }
                if (this.b_pa) {
                    c.clipRect(this.back, Region.Op.UNION);
                }
                this.mDrawableHighlight_1.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_1.draw(c);
                break;
            case 2:
                if (this.iParkCamer == 2) {
                    c.clipRect(this.camera, Region.Op.UNION);
                }
                if (this.b_cancle) {
                    c.clipRect(this.cancle, Region.Op.UNION);
                }
                if (this.b_star) {
                    c.clipRect(this.star, Region.Op.UNION);
                }
                if (this.b_up_down) {
                    c.clipRect(this.up_down, Region.Op.UNION);
                }
                this.mDrawableHighlight_2.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_2.draw(c);
                break;
            case 3:
                if (this.iParkCamer == 2) {
                    c.clipRect(this.camera, Region.Op.UNION);
                }
                if (this.b_cancle) {
                    c.clipRect(this.cancle, Region.Op.UNION);
                }
                this.mDrawableHighlight_3.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_3.draw(c);
                break;
            case 4:
                if (this.iParkCamer == 2) {
                    c.clipRect(this.camera, Region.Op.UNION);
                }
                if (this.b_cancle) {
                    c.clipRect(this.cancle, Region.Op.UNION);
                }
                if (this.b_star) {
                    c.clipRect(this.star, Region.Op.UNION);
                }
                if (this.b_up) {
                    c.clipRect(this.up, Region.Op.UNION);
                }
                if (this.b_left) {
                    c.clipRect(this.left, Region.Op.UNION);
                }
                if (this.b_right) {
                    c.clipRect(this.right, Region.Op.UNION);
                }
                if (this.b_down) {
                    c.clipRect(this.down, Region.Op.UNION);
                }
                if (this.b_left_p) {
                    c.clipRect(this.left_p, Region.Op.UNION);
                }
                if (this.b_right_p) {
                    c.clipRect(this.right_p, Region.Op.UNION);
                }
                this.mDrawableHighlight_4.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_4.draw(c);
                break;
            case 5:
                if (this.iParkCamer == 2) {
                    c.clipRect(this.camera, Region.Op.UNION);
                }
                if (this.b_cancle) {
                    c.clipRect(this.cancle, Region.Op.UNION);
                }
                this.mDrawableHighlight_5.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_5.draw(c);
                break;
            case 6:
                this.mDrawableHighlight_6.draw(c);
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNormal_6.draw(c);
                break;
            default:
                c.clipRect(this.mRectDrawable, Region.Op.XOR);
                this.mDrawableNull.draw(c);
                break;
        }
        this.mPaint.setTextSize(this.tempTextSize);
        if (this.StrMsg[this.iParkText] != null) {
            c.drawText(this.StrMsg[this.iParkText], 280.0f, 35.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
