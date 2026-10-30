package com.syu.canbus.warn;

import android.content.Context;
import android.content.Intent;
import android.os.SystemProperties;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIKYCYichangShowAir {
    private static UIKYCYichangShowAir mInstance;
    Context context;
    private View sWarnContent;
    int windowshownum = 0;
    boolean recvflag = false;
    int win = 0;
    int body = 0;
    int foot = 0;
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.1
        @Override // java.lang.Runnable
        public void run() {
            UIKYCYichangShowAir.this.windowshownum--;
            if (UIKYCYichangShowAir.this.windowshownum == 0) {
                HandlerUI.getInstance().removeCallbacks(UIKYCYichangShowAir.this.mShowWindowcnt);
                DataCanbus.PROXY.cmd(30, new int[1], null, null);
                WarnUtils.postDimiss(50);
            } else {
                HandlerUI.getInstance().removeCallbacks(UIKYCYichangShowAir.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(UIKYCYichangShowAir.this.mShowWindowcnt, 1000L);
            }
        }
    };

    public static UIKYCYichangShowAir getInstance() {
        if (mInstance == null) {
            mInstance = new UIKYCYichangShowAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[171] != 0) {
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
            SystemProperties.get("ro.fyt.realplatform", "");
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_kyc_yc_highlander_airshow_7862, (ViewGroup) null, false);
            if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            if (!Air_Activity_All_Toyota_prado_HP.mIsFront) {
                                try {
                                    Intent intent = new Intent("com.syu.canbus.enter.air");
                                    intent.setPackage(TheApp.getInstance().getPackageName());
                                    TheApp.getInstance().sendBroadcast(intent);
                                } catch (Exception e) {
                                }
                            }
                            DataCanbus.PROXY.cmd(3, new int[]{37}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(3, new int[]{8}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus3).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.4
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(3, new int[]{17}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus4) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus4).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(3, new int[]{4}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus5).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.6
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(3, new int[]{38}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus6).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.7
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UIKYCYichangShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        if (action == 0) {
                            DataCanbus.PROXY.cmd(3, new int[]{15}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus7) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus7).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIKYCYichangShowAir.8
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
        }
        switch (updateCode) {
            case 10:
            case 42:
            case 67:
                if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                    this.windowshownum = 6;
                    if (DataCanbus.DATA[67] == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_n);
                    }
                }
                break;
            case 16:
                if (this.sWarnContent.findViewById(R.id.btn_plus4) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rear_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rear_n);
                    }
                }
                break;
            case 18:
            case 19:
            case 20:
                if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                    this.windowshownum = 6;
                    this.win = DataCanbus.DATA[18];
                    this.body = DataCanbus.DATA[19];
                    this.foot = DataCanbus.DATA[20];
                    mUpdaterBlowMode(this.win, this.body, this.foot);
                }
                break;
            case 33:
                if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_flowauto_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_flowauto_n);
                    }
                }
                break;
            case 62:
                if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_lz_toyota_fj_sync_n);
                    }
                }
                break;
            case 65:
                if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_n);
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

    private void mUpdaterBlowMode(int winflag, int bodyflag, int footflag) {
        int mode;
        int mode2;
        int mode3;
        if (footflag == 1) {
            mode = 0 | 1;
        } else {
            mode = 0 & 254;
        }
        if (bodyflag == 1) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (winflag == 1) {
            mode3 = mode2 | 4;
        } else {
            mode3 = mode2 & 251;
        }
        switch (mode3) {
            case 0:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode0);
                break;
            case 1:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode1);
                break;
            case 2:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode2);
                break;
            case 3:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode3);
                break;
            case 4:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode4);
                break;
            case 5:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode5);
                break;
            case 6:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode6);
                break;
            case 7:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_mode7);
                break;
        }
    }
}
