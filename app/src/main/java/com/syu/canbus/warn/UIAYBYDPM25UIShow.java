package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIAYBYDPM25UIShow {
    private static UIAYBYDPM25UIShow mInstance;
    Context context;
    private View sWarnContent;

    public static UIAYBYDPM25UIShow getInstance() {
        if (mInstance == null) {
            mInstance = new UIAYBYDPM25UIShow();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[175] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            DataCanbus.PROXY.cmd(7, new int[1], null, null);
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_ay_byd_pm25show, null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(7, new int[1], null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(7, new int[1], null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(7, new int[1], null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(7, new int[1], null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext1).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(6, new int[]{3}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext2).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    event.getAction();
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext3).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(6, new int[]{4}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext4).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(6, new int[]{5}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext5).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.ctv_checkedtext6).setOnTouchListener(new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(6, new int[]{2}, null, null);
                    }
                    return true;
                }
            });
        }
        switch (updateCode) {
            case 105:
                if (((value >> 7) & 1) == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                }
                if (((value >> 6) & 1) == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                }
                if (((value >> 5) & 1) == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext3).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext3).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                }
                if (((value >> 4) & 1) == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext4).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                    break;
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext4).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                    break;
                }
            case 113:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext5).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                    break;
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext5).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                    break;
                }
            case 114:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext6).setBackgroundResource(R.drawable.ic_ay_byd_open_p);
                    break;
                } else {
                    this.sWarnContent.findViewById(R.id.ctv_checkedtext6).setBackgroundResource(R.drawable.ic_ay_byd_close_n);
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
