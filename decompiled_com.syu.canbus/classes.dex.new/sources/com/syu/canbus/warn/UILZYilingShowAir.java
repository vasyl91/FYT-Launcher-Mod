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
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.air.ConstAllAirDara;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UILZYilingShowAir {
    private static UILZYilingShowAir mInstance;
    Context context;
    private View sWarnContent;
    int windowshownum = 0;
    boolean recvflag = false;
    boolean haverearlock = false;
    int rearlock = 0;
    int win = 0;
    int rear_body = 0;
    int rear_foot = 0;
    int body = 0;
    int foot = 0;
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.canbus.warn.UILZYilingShowAir.1
        @Override // java.lang.Runnable
        public void run() {
            UILZYilingShowAir.this.windowshownum--;
            if (UILZYilingShowAir.this.windowshownum == 0) {
                HandlerUI.getInstance().removeCallbacks(UILZYilingShowAir.this.mShowWindowcnt);
                DataCanbus.PROXY.cmd(30, new int[1], null, null);
                WarnUtils.postDimiss(50);
            } else {
                HandlerUI.getInstance().removeCallbacks(UILZYilingShowAir.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(UILZYilingShowAir.this.mShowWindowcnt, 1000L);
            }
        }
    };

    public static UILZYilingShowAir getInstance() {
        if (mInstance == null) {
            mInstance = new UILZYilingShowAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[158] != 0) {
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
            String platform = SystemProperties.get("ro.fyt.realplatform", "");
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                    if ("6318".equals(platform) || "6321".equals(platform)) {
                        this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_4runner_airshow, (ViewGroup) null, false);
                    } else {
                        this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_4runner_airshow_7862, (ViewGroup) null, false);
                    }
                    break;
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                    if ("6318".equals(platform) || "6321".equals(platform)) {
                        this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_alpha_airshow, (ViewGroup) null, false);
                    } else {
                        this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_alpha_airshow_7862, (ViewGroup) null, false);
                    }
                    break;
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_gx_airshow_7862, (ViewGroup) null, false);
                    break;
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                case FinalCanbus.CAR_455_LZ_DH_Toyota_Prado_14 /* 10551751 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_yl_14prado_airshow, (ViewGroup) null, false);
                    break;
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_lz_yl_gx_airshow_7862, (ViewGroup) null, false);
                    break;
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_yl_alpha_airshow_7862, (ViewGroup) null, false);
                    break;
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_cg_rx300_airshow, (ViewGroup) null, false);
                    break;
                default:
                    this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_lz_yiling_airshow_7862, (ViewGroup) null, false);
                    break;
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                                if (action == 0) {
                                    switch (DataCanbus.DATA[1000]) {
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                                        case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                                        case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                                            if (DataCanbus.DATA[38] == 0) {
                                                if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                                                    ConstAllAirDara.JumpNewRearAir = true;
                                                    try {
                                                        Intent intent = new Intent("com.syu.canbus.enter.air");
                                                        intent.setPackage(TheApp.getInstance().getPackageName());
                                                        TheApp.getInstance().sendBroadcast(intent);
                                                    } catch (Exception e) {
                                                    }
                                                }
                                            } else if (Air_Activity_All_NewAdd_HP.mIsFront) {
                                                try {
                                                    Intent intent2 = new Intent("com.syu.canbus.enter.air");
                                                    intent2.setPackage(TheApp.getInstance().getPackageName());
                                                    TheApp.getInstance().sendBroadcast(intent2);
                                                } catch (Exception e2) {
                                                }
                                            }
                                            break;
                                    }
                                    DataCanbus.PROXY.cmd(0, new int[]{57, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{57, 0}, null, null);
                                }
                                return true;
                            default:
                                if (action == 0) {
                                    switch (DataCanbus.DATA[1000]) {
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                                        case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                                        case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                                        case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                                        case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                                            if (DataCanbus.DATA[67] == 0) {
                                                if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                                                    ConstAllAirDara.JumpNewRearAir = true;
                                                    try {
                                                        Intent intent3 = new Intent("com.syu.canbus.enter.air");
                                                        intent3.setPackage(TheApp.getInstance().getPackageName());
                                                        TheApp.getInstance().sendBroadcast(intent3);
                                                    } catch (Exception e3) {
                                                    }
                                                }
                                            } else if (Air_Activity_All_NewAdd_HP.mIsFront) {
                                                try {
                                                    Intent intent4 = new Intent("com.syu.canbus.enter.air");
                                                    intent4.setPackage(TheApp.getInstance().getPackageName());
                                                    TheApp.getInstance().sendBroadcast(intent4);
                                                } catch (Exception e4) {
                                                }
                                            }
                                            break;
                                    }
                                    DataCanbus.PROXY.cmd(22, new int[]{42, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{42, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{16, 0}, null, null);
                                }
                                return true;
                            default:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{16, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{16, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus3).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.4
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(0, new int[]{36, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{36, 0}, null, null);
                                }
                                return true;
                            default:
                                if (UILZYilingShowAir.this.rearlock == 1) {
                                    if (action == 0) {
                                        DataCanbus.PROXY.cmd(22, new int[]{43, 1}, null, null);
                                    } else if (action == 1) {
                                        DataCanbus.PROXY.cmd(22, new int[]{43, 0}, null, null);
                                    }
                                } else if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{36, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{36, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus4) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus4).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{20, 0}, null, null);
                                }
                                return true;
                            default:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{20, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{20, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus5).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.6
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{18, 0}, null, null);
                                }
                                return true;
                            default:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{18, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{18, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus6).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.7
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        UILZYilingShowAir.this.windowshownum = 6;
                        int action = event.getAction();
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{50, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{50, 0}, null, null);
                                }
                                return true;
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(0, new int[]{40, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(0, new int[]{40, 0}, null, null);
                                }
                                return true;
                            default:
                                if (action == 0) {
                                    DataCanbus.PROXY.cmd(22, new int[]{32, 1}, null, null);
                                } else if (action == 1) {
                                    DataCanbus.PROXY.cmd(22, new int[]{32, 0}, null, null);
                                }
                                return true;
                        }
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus7) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus7).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILZYilingShowAir.8
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
                int rearpower = DataCanbus.DATA[42];
                int power = DataCanbus.DATA[10];
                if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                    this.windowshownum = 6;
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                        case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                        case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                        case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                            break;
                        case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                        case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                        case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                            this.rearlock = DataCanbus.DATA[67];
                            if (this.rearlock == 1) {
                                mUpdaterBlowRearMode(this.rear_body, this.rear_foot);
                                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                            } else {
                                mUpdaterBlowMode(this.win, this.body, this.foot);
                                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontlight_);
                            }
                            break;
                        case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
                        case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER_3 /* 16253382 */:
                        case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER_3 /* 16384454 */:
                            this.rearlock = DataCanbus.DATA[67];
                            if (this.rearlock == 1) {
                                this.haverearlock = true;
                                mUpdaterBlowMode(this.win, this.rear_body, this.rear_foot);
                                if (rearpower == 1) {
                                    this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                                } else {
                                    this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_n);
                                }
                            } else {
                                if (this.haverearlock) {
                                    if (power == 1) {
                                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontlight_);
                                    } else {
                                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontlight_n);
                                    }
                                } else if (rearpower == 1) {
                                    this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                                } else if (power == 1) {
                                    this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontlight_);
                                } else {
                                    this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontlight_n);
                                }
                                mUpdaterBlowMode(this.win, this.body, this.foot);
                            }
                            break;
                        default:
                            if (DataCanbus.DATA[67] == 1) {
                                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                            } else {
                                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_n);
                            }
                            break;
                    }
                }
                break;
            case 14:
                if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_lz_toyota_fj_dual_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_lz_toyota_fj_dual_n);
                    }
                }
                break;
            case 15:
                if (this.sWarnContent.findViewById(R.id.btn_plus5) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_lz_toyota_rx300_front_n);
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
            case 46:
            case 47:
                if (this.sWarnContent.findViewById(R.id.btn_plus3) != null) {
                    this.windowshownum = 6;
                    this.win = DataCanbus.DATA[18];
                    this.body = DataCanbus.DATA[19];
                    this.foot = DataCanbus.DATA[20];
                    this.rear_body = DataCanbus.DATA[46];
                    this.rear_foot = DataCanbus.DATA[47];
                    if (this.rearlock == 1) {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                            case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                                mUpdaterBlowRearMode(this.rear_body, this.rear_foot);
                                break;
                            default:
                                mUpdaterBlowMode(this.win, this.rear_body, this.rear_foot);
                                break;
                        }
                    } else {
                        mUpdaterBlowMode(this.win, this.body, this.foot);
                        break;
                    }
                }
                break;
            case 33:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                    case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
                    case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                    case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER /* 14942662 */:
                    case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER_3 /* 16253382 */:
                    case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER /* 16318918 */:
                    case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER_3 /* 16384454 */:
                        if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                            this.windowshownum = 6;
                            if (value == 1) {
                                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_flowauto_p);
                            } else {
                                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_flowauto_n);
                            }
                        }
                        break;
                }
                break;
            case 34:
                if (this.sWarnContent.findViewById(R.id.btn_plus8) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_nanoe_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_lz_toyota_fj_nanoe_n);
                    }
                }
                break;
            case 38:
                if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                    this.windowshownum = 6;
                    if (value == 1) {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_p);
                    } else {
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearlight_n);
                    }
                }
                break;
            case 92:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                        if (this.sWarnContent.findViewById(R.id.btn_plus6) != null) {
                            this.windowshownum = 6;
                            if (value == 1) {
                                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontonly_p);
                            } else {
                                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_lz_toyota_fj_frontonly_n);
                            }
                        }
                        break;
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

    private void mUpdaterBlowRearMode(int bodyflag, int footflag) {
        int mode;
        int mode2;
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
        switch (mode2) {
            case 0:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearmode0);
                break;
            case 1:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearmode1);
                break;
            case 2:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearmode2);
                break;
            case 3:
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_lz_toyota_fj_rearmode3);
                break;
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
