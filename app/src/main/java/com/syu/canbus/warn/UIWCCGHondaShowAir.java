package com.syu.canbus.warn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

public class UIWCCGHondaShowAir {
    private static UIWCCGHondaShowAir mInstance;
    Context context;
    private View sWarnContent;
    int windowshownum = 0;
    boolean recvflag = false;
    int win = 0;
    int body = 0;
    int foot = 0;
    Runnable mShowWindowcnt = new Runnable() { 
        @Override
        public void run() {
            Log.v("zed", "windowshownum = " + UIWCCGHondaShowAir.this.windowshownum);
            UIWCCGHondaShowAir uIWCCGHondaShowAir = UIWCCGHondaShowAir.this;
            uIWCCGHondaShowAir.windowshownum--;
            if (UIWCCGHondaShowAir.this.windowshownum == 0) {
                HandlerUI.getInstance().removeCallbacks(UIWCCGHondaShowAir.this.mShowWindowcnt);
                DataCanbus.PROXY.cmd(30, new int[1], null, null);
                WarnUtils.postDimiss(50);
            } else {
                HandlerUI.getInstance().removeCallbacks(UIWCCGHondaShowAir.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(UIWCCGHondaShowAir.this.mShowWindowcnt, 1000L);
            }
        }
    };

    public static UIWCCGHondaShowAir getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCCGHondaShowAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[212] != 0) {
            WarnUtils.showWindow();
            this.recvflag = false;
            this.windowshownum = 6;
            mUpdaterWindowShow(true);
            return;
        }
        if (window.isShowing()) {
            this.windowshownum = 0;
            mUpdaterWindowShow(false);
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0321_wc_cg_honda_airshow, null, false);
                    break;
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0321_wc_cg_honda_autoairshow, null, false);
                    break;
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{6, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{6}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{10, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{10}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus3).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{9, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{9}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus4) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus4).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{24, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{24}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus5).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{23, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{23}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus6).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{5, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{5}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus7) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus7).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(30, new int[1], null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus8) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus8).setOnTouchListener(new View.OnTouchListener() { 
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{3, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{3}, null, null);
                        }
                        return true;
                    }
                });
            }
        }
        switch (updateCode) {
            case 16:
                if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rear_p);
                        break;
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rear_n);
                        break;
                    }
                }
                break;
            case 62:
                if (this.sWarnContent.findViewById(R.id.btn_plus8) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_p);
                        break;
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_n);
                        break;
                    }
                }
                break;
            case 65:
                if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_p);
                        break;
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_n);
                        break;
                    }
                }
                break;
            case 77:
                if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                    this.windowshownum = 6;
                    this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_wc_honda_mode_foot_n);
                    this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_wc_honda_mode_body_n);
                    this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_wc_honda_mode_bodyfoot_n);
                    this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_wc_honda_mode_winfoot_n);
                    switch (value) {
                        case 3:
                            this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_wc_honda_mode_foot_p);
                            break;
                        case 4:
                            this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_wc_honda_mode_winfoot_p);
                            break;
                        case 5:
                            this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_wc_honda_mode_bodyfoot_p);
                            break;
                        case 6:
                            this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_wc_honda_mode_body_p);
                            break;
                    }
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }

    private void mUpdaterWindowShow(boolean flag) {
        if (flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
            HandlerUI.getInstance().postDelayed(this.mShowWindowcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
        }
    }
}
