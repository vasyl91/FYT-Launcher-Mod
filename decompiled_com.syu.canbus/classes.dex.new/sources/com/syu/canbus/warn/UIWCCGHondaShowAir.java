package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCCGHondaShowAir {
    private static UIWCCGHondaShowAir mInstance;
    Context context;
    private View sWarnContent;
    int windowshownum = 0;
    boolean recvflag = false;
    int win = 0;
    int body = 0;
    int foot = 0;
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.1
        @Override // java.lang.Runnable
        public void run() {
            UIWCCGHondaShowAir.this.windowshownum--;
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
            this.context = TheApp.getInstance();
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0321_wc_cg_honda_airshow, (ViewGroup) null, false);
                    break;
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0321_wc_cg_honda_autoairshow, (ViewGroup) null, false);
                    break;
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{6, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{6, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{10, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{10, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus3).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.4
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{9, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{9, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus4) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus4).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{24, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{24, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus5).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.6
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{23, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{23, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus6).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.7
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{5, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{5, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus7) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus7).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.8
                    @Override // android.view.View.OnTouchListener
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
                this.sWarnContent.findViewById(R.id.btn_plus8).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.9
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{3, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{3, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus9) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus9).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.10
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{17, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{17, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus10) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus10).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCCGHondaShowAir.11
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIWCCGHondaShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(107, new int[]{18, 1}, null, null);
                        } else if (action == 1) {
                            DataCanbus.PROXY.cmd(107, new int[]{18, 0}, null, null);
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
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rear_n);
                    }
                }
                break;
            case 29:
                if (this.sWarnContent.findViewById(R.id.btn_plus9) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_left_1);
                    } else if (value == 2) {
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_left_2);
                    } else if (value == 3) {
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_left_3);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_left_0);
                    }
                }
                break;
            case 30:
                if (this.sWarnContent.findViewById(R.id.btn_plus10) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_right_1);
                    } else if (value == 2) {
                        this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_right_2);
                    } else if (value == 3) {
                        this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_right_3);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_toyota_seathot_right_0);
                    }
                }
                break;
            case 62:
                if (this.sWarnContent.findViewById(R.id.btn_plus8) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_n);
                    }
                }
                break;
            case 65:
                if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_n);
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
