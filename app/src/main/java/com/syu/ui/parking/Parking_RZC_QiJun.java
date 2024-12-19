package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;
import android.view.MotionEvent;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitRes;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Parking_RZC_QiJun extends ParkingBase {
    private final float X_TxtMsg;
    private final float Y_TxtMsg;
    private boolean b_cancle;
    private boolean b_down;
    private boolean b_left;
    private boolean b_left_p;
    private boolean b_msg;
    private boolean b_pa;
    private boolean b_right;
    private boolean b_right_p;
    private boolean b_star;
    private boolean b_up;
    private boolean b_up_down;
    private Rect back;
    private Rect camera;
    private Rect cancle;
    int data0;
    private Rect down;
    public int iParkBtn;
    public int iParkCamer;
    public int iParkPage;
    public int iParkText;
    private Rect left;
    private Rect left_p;
    private Rect msg;
    private Rect right;
    private Rect right_p;
    private Rect star;
    private int tempTextSize;
    private Rect up;
    private Rect up_down;

    public Parking_RZC_QiJun(Context context) {
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
        this.data0 = 0;
    }

    @Override // com.syu.ui.parking.ParkingBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
    }

    @Override // com.syu.ui.parking.ParkingBase
    protected void initDrawable() {
        Log.d("gandy", "  CanBus initDrawable iParkPage = " + this.DATA[87]);
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

    @Override // com.syu.ui.parking.ParkingBase, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.data0 = 0;
        int x = (int) (event.getX() / this.mScale);
        int y = (int) (event.getY() / this.mScale);
        Log.d("touch", " onTouchEvent ** x = " + x + "  y = " + y);
        if (TouchRect(x, y, this.cancle) && this.iParkPage != 6) {
            this.data0 = 68;
        } else if (TouchRect(x, y, this.star) && ((this.iParkPage == 2 || this.iParkPage == 4) && !this.b_star)) {
            this.data0 = 69;
        } else if (TouchRect(x, y, this.back)) {
            if (this.iParkPage == 1 && !this.b_pa) {
                this.data0 = 65;
            } else if (this.iParkPage == 2) {
                this.data0 = 67;
            } else if (this.iParkPage == 3) {
                this.data0 = 66;
            } else if (this.iParkPage == 4) {
                this.data0 = 70;
            }
        } else if (TouchRect(x, y, this.up_down) && this.iParkPage == 2) {
            this.data0 = 71;
        } else if (TouchRect(x, y, this.up) && this.iParkPage == 4 && !this.b_up) {
            this.data0 = 72;
        } else if (TouchRect(x, y, this.down) && this.iParkPage == 4 && !this.b_down) {
            this.data0 = 73;
        } else if (TouchRect(x, y, this.left) && this.iParkPage == 4 && !this.b_left) {
            this.data0 = 74;
        } else if (TouchRect(x, y, this.right) && this.iParkPage == 4 && !this.b_right) {
            this.data0 = 75;
        } else if (TouchRect(x, y, this.left_p) && this.iParkPage == 4 && !this.b_left_p) {
            this.data0 = 79;
        } else if (TouchRect(x, y, this.right_p) && this.iParkPage == 4 && !this.b_right_p) {
            this.data0 = 78;
        }
        if (this.data0 != 0) {
            DataCanbus.PROXY.cmd(0, new int[]{this.data0, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.ui.parking.Parking_RZC_QiJun.1
                @Override // java.lang.Runnable
                public void run() {
                    DataCanbus.PROXY.cmd(0, new int[]{Parking_RZC_QiJun.this.data0}, null, null);
                }
            }, 200L);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.iParkPage = this.DATA[87];
        this.iParkText = this.DATA[86];
        this.iParkBtn = this.DATA[88];
        this.iParkCamer = this.DATA[89];
        if (this.iParkText == 18 || this.iParkText == 19 || this.iParkText == 20 || this.iParkText == 21 || this.iParkText == 23 || this.iParkText == 24 || this.iParkText == 25 || this.iParkText == 27 || this.iParkText == 28 || this.iParkText == 29 || this.iParkText == 30 || this.iParkText == 33 || this.iParkText == 34 || this.iParkText == 38 || this.iParkText == 39 || this.iParkText == 43 || this.iParkText == 48) {
            this.b_msg = true;
        } else {
            this.b_msg = false;
        }
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
        String StrMsg = "";
        switch (this.iParkText) {
            case 1:
                StrMsg = "Ensure it is safe before manoeuvring";
                break;
            case 2:
                StrMsg = "Park Assist not available";
                break;
            case 3:
                StrMsg = "Use turn signal to change side";
                break;
            case 4:
                StrMsg = "Select forward gear";
                break;
            case 5:
                StrMsg = "Space found,drive forward";
                break;
            case 6:
                StrMsg = "Stop next to empty parking space";
                break;
            case 7:
                StrMsg = "Press △▽to set parking position";
                break;
            case 8:
                StrMsg = "Adjust park position";
                break;
            case 9:
                StrMsg = "Park Assist Cancelled";
                break;
            case 10:
                StrMsg = "Drive backwards";
                break;
            case 11:
                StrMsg = "Stop and select reverse gear";
                break;
            case 12:
                StrMsg = "Drive forwards";
                break;
            case 13:
                StrMsg = "Stop and select forward gear";
                break;
            case 14:
                StrMsg = "Park assist finished";
                break;
            case 18:
                StrMsg = "Centre steering wheel";
                break;
            case 19:
                StrMsg = "Remove trailer";
                break;
            case 20:
                StrMsg = "VDC must be ON";
                break;
            case 21:
                StrMsg = "Close door to start";
                break;
            case 22:
                StrMsg = "System Fault";
                break;
            case 23:
                StrMsg = "Park Assist fault";
                break;
            case 24:
                StrMsg = "Over Speed";
                break;
            case 25:
                StrMsg = "Steering Intervened";
                break;
            case 26:
                StrMsg = "Trailer ON";
                break;
            case 27:
                StrMsg = "VDC Active";
                break;
            case 28:
                StrMsg = "Door Open/Belt OFF";
                break;
            case 29:
                StrMsg = "Time Out";
                break;
            case 34:
                StrMsg = "Engine not active";
                break;
            case 35:
                StrMsg = "Esp not ative";
                break;
            case 36:
                StrMsg = "Fwd gear outside of park slot";
                break;
            case 37:
                StrMsg = "Resume not possible";
                break;
            case 39:
                StrMsg = "Stop";
                break;
            case 40:
                StrMsg = "Select reverse gear";
                break;
            case 66:
                StrMsg = "Check surroundings";
                break;
            case 67:
                StrMsg = "Stop beside park slot to start park assist";
                break;
            case 69:
                StrMsg = "Reduce speed";
                break;
            case 76:
                StrMsg = "Steering rotating";
                break;
            case 77:
                StrMsg = "Drive forward with care";
                break;
            case 78:
                StrMsg = "Drive backward with care";
                break;
            case 79:
                StrMsg = "Check obstacle";
                break;
        }
        if (StrMsg != null) {
            c.drawText(StrMsg, 280.0f, 35.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(this.mScale, this.mScale);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
