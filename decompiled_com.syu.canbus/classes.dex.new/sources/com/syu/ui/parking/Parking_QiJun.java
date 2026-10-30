package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import android.view.MotionEvent;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Parking_QiJun extends ParkingBase {
    private String[] StrMsg;
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
    private RectF back;
    private RectF camera;
    private RectF cancle;
    int data0;
    private RectF down;
    public int iParkBtn;
    public int iParkCamer;
    public int iParkPage;
    public int iParkText;
    private RectF left;
    private RectF left_p;
    private RectF msg;
    private RectF right;
    private RectF right_p;
    private RectF star;
    private int tempTextSize;
    private RectF up;
    private RectF up_down;

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
        this.msg = new RectF(0.0f, 0.0f, 50.0f, 50.0f);
        this.camera = new RectF(18.0f, 445.0f, 154.0f, 525.0f);
        this.cancle = new RectF(178.0f, 445.0f, 314.0f, 525.0f);
        this.star = new RectF(332.0f, 445.0f, 468.0f, 525.0f);
        this.back = new RectF(488.0f, 445.0f, 624.0f, 525.0f);
        this.up_down = new RectF(778.0f, 445.0f, 914.0f, 525.0f);
        this.up = new RectF(286.0f, 141.0f, 387.0f, 208.0f);
        this.left = new RectF(182.0f, 226.0f, 283.0f, 293.0f);
        this.right = new RectF(388.0f, 226.0f, 489.0f, 293.0f);
        this.down = new RectF(286.0f, 313.0f, 387.0f, 380.0f);
        this.left_p = new RectF(63.0f, 171.0f, 156.0f, 337.0f);
        this.right_p = new RectF(517.0f, 171.0f, 610.0f, 337.0f);
        this.X_TxtMsg = 280.0f;
        this.Y_TxtMsg = 35.0f;
        this.tempTextSize = 30;
        this.StrMsg = new String[]{"", "Ensure it is safe before manoeuvring", "Stop beside park slot to start assist", "Stop and select reverse gear", "Stop and select forward gear", "Stop next to empty parking space", "Check surroudings", "Drive forward", "Drive backwards", "Drive Forward with care", "Drive backward with care", "Reduce speed", "Press ↑↓ to set parking position", "Adjust park position", "[STOP]Steering rotating", "[STOP]Check obstacle", "", "Select forward gear", "Remove trailer", "System Fault", "Park Assist fault", "Steering Intervened", "Centre steering whell", "VDC must be ON", "Over Speed", "Time Out", "", "Close door to start", "Trailer ON", "VDC Active", "Door Open/Belt OFF", "", "Park assist finished", "Park Assist not availble", "EPS not active", "Space found,drive forward", "Stop", "", "Engine not active", "Fwd gear outside of park slot", "Select reverse gear", "", "", "Resume not possible", "", "", "Park Assist Canceled", "", "Use turn signal to change side"};
        this.data0 = 0;
    }

    @Override // com.syu.ui.parking.ParkingBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
    }

    @Override // com.syu.ui.parking.ParkingBase
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

    public boolean TouchRect(int x, int y, RectF rect) {
        Log.v("zed", "rect.left == " + rect.left + "---rect.right == " + rect.right + "---rect.top == " + rect.top + "---rect.bottom == " + rect.bottom + "---mScale == " + this.mScale + "---mYScale == " + this.mYScale);
        float xbig = TheApp.getScreenWidth() / 1024.0f;
        return ((float) x) >= rect.left * xbig && ((float) x) <= rect.right * xbig && ((float) y) >= rect.top * this.mYScale && ((float) y) <= rect.bottom * this.mYScale;
    }

    @Override // com.syu.ui.parking.ParkingBase, android.view.View
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
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.ui.parking.Parking_QiJun.1
                @Override // java.lang.Runnable
                public void run() {
                    DataCanbus.PROXY.cmd(1, new int[]{Parking_QiJun.this.data0, 0}, null, null);
                }
            }, 200L);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.iParkPage = this.DATA[99];
        this.iParkText = this.DATA[98];
        this.iParkBtn = this.DATA[100];
        this.iParkCamer = this.DATA[101];
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
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.b_msg) {
            this.srPath.addRect(this.msg, Path.Direction.CW);
        }
        switch (this.iParkPage) {
            case 1:
                if (this.iParkCamer == 1) {
                    this.srPath.addRect(this.camera, Path.Direction.CW);
                }
                if (this.b_pa) {
                    this.srPath.addRect(this.back, Path.Direction.CW);
                }
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_1.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_1.draw(c);
                break;
            case 2:
                if (this.iParkCamer == 1) {
                    this.srPath.addRect(this.camera, Path.Direction.CW);
                }
                if (this.b_cancle) {
                    this.srPath.addRect(this.cancle, Path.Direction.CW);
                }
                if (this.b_star) {
                    this.srPath.addRect(this.star, Path.Direction.CW);
                }
                if (this.b_up_down) {
                    this.srPath.addRect(this.up_down, Path.Direction.CW);
                }
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_2.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_2.draw(c);
                break;
            case 3:
                if (this.iParkCamer == 1) {
                    this.srPath.addRect(this.camera, Path.Direction.CW);
                }
                if (this.b_cancle) {
                    this.srPath.addRect(this.cancle, Path.Direction.CW);
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
                if (this.iParkCamer == 1) {
                    this.srPath.addRect(this.camera, Path.Direction.CW);
                }
                if (this.b_cancle) {
                    this.srPath.addRect(this.cancle, Path.Direction.CW);
                }
                if (this.b_star) {
                    this.srPath.addRect(this.star, Path.Direction.CW);
                }
                if (this.b_up) {
                    this.srPath.addRect(this.up, Path.Direction.CW);
                }
                if (this.b_left) {
                    this.srPath.addRect(this.left, Path.Direction.CW);
                }
                if (this.b_right) {
                    this.srPath.addRect(this.right, Path.Direction.CW);
                }
                if (this.b_down) {
                    this.srPath.addRect(this.down, Path.Direction.CW);
                }
                if (this.b_left_p) {
                    this.srPath.addRect(this.left_p, Path.Direction.CW);
                }
                if (this.b_right_p) {
                    this.srPath.addRect(this.right_p, Path.Direction.CW);
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
                if (this.iParkCamer == 1) {
                    this.srPath.addRect(this.camera, Path.Direction.CW);
                }
                if (this.b_cancle) {
                    this.srPath.addRect(this.cancle, Path.Direction.CW);
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
                this.mPath.op(this.srPath, Path.Op.UNION);
                c.clipPath(this.mPath);
                this.mDrawableHighlight_6.draw(c);
                c.restore();
                this.srPath.reset();
                this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
                this.mPath.op(this.srPath, Path.Op.XOR);
                c.clipRect(this.mRectDrawable);
                c.clipPath(this.mPath);
                this.mDrawableNormal_6.draw(c);
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
        this.mPaint.setTextSize((this.tempTextSize * TheApp.getScreenWidth()) / 1024.0f);
        if (this.StrMsg[this.iParkText] != null) {
            c.drawText(this.StrMsg[this.iParkText], (280.0f * TheApp.getScreenWidth()) / 1024.0f, (35.0f * TheApp.getScreenHeight()) / 540.0f, this.mPaint);
        }
        canvas.save();
        canvas.scale(this.mScale, 1.1111112f);
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
