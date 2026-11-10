package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.air.ConstAllAirDara;
import com.syu.loopview.LoopView;
import com.syu.loopview.OnItemScrollListener;
import com.syu.loopview.OnItemSelectedListener;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCYuncheNissanAirControlAct_HP extends Activity implements View.OnTouchListener {
    public static WCYuncheNissanAirControlAct_HP mInstance;
    public static boolean mIsFront = false;
    public ArrayList<String> mLauStylelist;
    int curscrollState = -1;
    int curscrollcnt = 0;
    int tempdata = 0;
    int winlevdata = 0;
    boolean recvflag = false;
    Runnable mShowScrollcnt = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.1
        @Override // java.lang.Runnable
        public void run() {
            WCYuncheNissanAirControlAct_HP.this.curscrollcnt--;
            if (WCYuncheNissanAirControlAct_HP.this.curscrollcnt < 0) {
                WCYuncheNissanAirControlAct_HP.this.curscrollcnt = 0;
                WCYuncheNissanAirControlAct_HP.this.initmLauStylelist();
                ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                if (WCYuncheNissanAirControlAct_HP.this.tempdata == -2) {
                    ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                } else if (WCYuncheNissanAirControlAct_HP.this.tempdata == -3) {
                    ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setCurrentPosition(0);
                } else if (WCYuncheNissanAirControlAct_HP.this.tempdata == 0) {
                    ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                } else {
                    int value = (64 - WCYuncheNissanAirControlAct_HP.this.tempdata) / 2;
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                            value = 64 - WCYuncheNissanAirControlAct_HP.this.tempdata;
                            if (value > 27) {
                                value = 27;
                            }
                            break;
                        default:
                            if (value > 13) {
                                value = 13;
                            }
                            break;
                    }
                    WCYuncheNissanAirControlAct_HP.this.mLauStylelist.add(value, String.valueOf(WCYuncheNissanAirControlAct_HP.this.tempdata / 2.0f) + "℃");
                    WCYuncheNissanAirControlAct_HP.this.mLauStylelist.remove(value + 1);
                    ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setCurrentPosition(value);
                }
                ((LoopView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.layout_view1)).setItems(WCYuncheNissanAirControlAct_HP.this.mLauStylelist);
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct_HP.this.mShowScrollcnt);
                return;
            }
            HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct_HP.this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(WCYuncheNissanAirControlAct_HP.this.mShowScrollcnt, 1000L);
        }
    };
    boolean seekbartouch = false;
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.layout_view2 /* 2131427557 */:
                    WCYuncheNissanAirControlAct_HP.this.seekbartouch = false;
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            switch (arg0.getId()) {
                case R.id.layout_view2 /* 2131427557 */:
                    if (WCYuncheNissanAirControlAct_HP.this.seekbartouch) {
                        DataCanbus.PROXY.cmd(1, new int[]{39, arg0.getProgress()}, null, null);
                    }
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
            switch (arg0.getId()) {
                case R.id.layout_view2 /* 2131427557 */:
                    WCYuncheNissanAirControlAct_HP.this.seekbartouch = true;
                    break;
            }
        }
    };
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.3
        @Override // java.lang.Runnable
        public void run() {
            Log.v("zed", "ConstAllAirDara.JumpNewAircnt = " + ConstAllAirDara.JumpNewAircnt);
            ConstAllAirDara.JumpNewAircnt--;
            if (ConstAllAirDara.JumpNewAircnt == 0) {
                WCYuncheNissanAirControlAct_HP.this.finish();
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct_HP.this.mShowWindowcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct_HP.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(WCYuncheNissanAirControlAct_HP.this.mShowWindowcnt, 1000L);
            }
        }
    };
    int touchcnt = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.4
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (ConstAllAirDara.JumpNewAir) {
                ConstAllAirDara.JumpNewAircnt = 8;
            }
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    WCYuncheNissanAirControlAct_HP.this.mUpdatePowerOn();
                    break;
                case 11:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateAcOn();
                    break;
                case 12:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateCycle();
                    break;
                case 13:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateAuto();
                    break;
                case 16:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateRearDefrost();
                    break;
                case 17:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateFrontHot();
                    break;
                case 21:
                    WCYuncheNissanAirControlAct_HP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateFrontDefrost();
                    WCYuncheNissanAirControlAct_HP.this.updateBtnSource();
                    break;
                case 68:
                    WCYuncheNissanAirControlAct_HP.this.mUpdatePTC();
                    break;
                case 77:
                    WCYuncheNissanAirControlAct_HP.this.updateBtnSource();
                    break;
                case 124:
                    switch (value) {
                        case 0:
                            WCYuncheNissanAirControlAct_HP.this.touchcnt = 0;
                            ((TextView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.tv_text1)).setText("");
                            break;
                        case 1:
                            ((TextView) WCYuncheNissanAirControlAct_HP.this.findViewById(R.id.tv_text1)).setText("喇叭测试:开");
                            break;
                    }
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hpauto2);
                break;
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_S15_OFFRoad1 /* 393662 */:
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_Standard /* 917950 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hp);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hpauto);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hp2);
                break;
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hpauto3);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hpauto_norear);
                break;
        }
        init();
        mInstance = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLauStylelist() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
            case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                this.mLauStylelist.clear();
                this.mLauStylelist.add("HI");
                this.mLauStylelist.add("31.5");
                this.mLauStylelist.add("31.0");
                this.mLauStylelist.add("30.5");
                this.mLauStylelist.add("30.0");
                this.mLauStylelist.add("29.5");
                this.mLauStylelist.add("29.0");
                this.mLauStylelist.add("28.5");
                this.mLauStylelist.add("28.0");
                this.mLauStylelist.add("27.5");
                this.mLauStylelist.add("27.0");
                this.mLauStylelist.add("26.5");
                this.mLauStylelist.add("26.0");
                this.mLauStylelist.add("25.5");
                this.mLauStylelist.add("25.0");
                this.mLauStylelist.add("24.5");
                this.mLauStylelist.add("24.0");
                this.mLauStylelist.add("23.5");
                this.mLauStylelist.add("23.0");
                this.mLauStylelist.add("22.5");
                this.mLauStylelist.add("22.0");
                this.mLauStylelist.add("21.5");
                this.mLauStylelist.add("21.0");
                this.mLauStylelist.add("20.5");
                this.mLauStylelist.add("20.0");
                this.mLauStylelist.add("19.5");
                this.mLauStylelist.add("19.0");
                this.mLauStylelist.add("18.5");
                this.mLauStylelist.add("LO");
                break;
            default:
                this.mLauStylelist.clear();
                this.mLauStylelist.add("HI");
                this.mLauStylelist.add("31.0");
                this.mLauStylelist.add("30.0");
                this.mLauStylelist.add("29.0");
                this.mLauStylelist.add("28.0");
                this.mLauStylelist.add("27.0");
                this.mLauStylelist.add("26.0");
                this.mLauStylelist.add("25.0");
                this.mLauStylelist.add("24.0");
                this.mLauStylelist.add("23.0");
                this.mLauStylelist.add("22.0");
                this.mLauStylelist.add("21.0");
                this.mLauStylelist.add("20.0");
                this.mLauStylelist.add("19.0");
                this.mLauStylelist.add("LO");
                break;
        }
    }

    private void init() {
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_cycle) != null) {
            findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_mode) != null) {
            findViewById(R.id.air_mode).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footbody) != null) {
            findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_minuts_btn) != null) {
            findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_plus_btn) != null) {
            findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_back) != null) {
            findViewById(R.id.dj_xts_back).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ptc) != null) {
            findViewById(R.id.air_xts_ptc).setOnTouchListener(this);
        }
        if (findViewById(R.id.tv_text1) != null) {
            findViewById(R.id.tv_text1).setOnTouchListener(this);
        }
        this.mLauStylelist = new ArrayList<>();
        initmLauStylelist();
        ((LoopView) findViewById(R.id.layout_view1)).setNotLoop();
        ((LoopView) findViewById(R.id.layout_view1)).setListener(new OnItemSelectedListener() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.5
            @Override // com.syu.loopview.OnItemSelectedListener
            public void onItemSelected(int index) {
                Log.v("zed", "onItemSelected = " + index);
                if (WCYuncheNissanAirControlAct_HP.this.curscrollState == 2) {
                    WCYuncheNissanAirControlAct_HP.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct_HP.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct_HP.this.recvflag);
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                            switch (index) {
                                case 0:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                    break;
                                case 28:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                    break;
                                default:
                                    int value = 64 - index;
                                    DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
                                    break;
                            }
                            break;
                        default:
                            switch (index) {
                                case 0:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                    break;
                                case 14:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                    break;
                                default:
                                    int value2 = 64 - (index * 2);
                                    DataCanbus.PROXY.cmd(1, new int[]{37, value2}, null, null);
                                    break;
                            }
                            break;
                    }
                }
            }
        });
        ((LoopView) findViewById(R.id.layout_view1)).setOnItemScrollListener(new OnItemScrollListener() { // from class: com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP.6
            @Override // com.syu.loopview.OnItemScrollListener
            public void onItemScrollStateChanged(LoopView loopView, int currentPassItem, int oldScrollState, int scrollState, int totalScrollY) {
                WCYuncheNissanAirControlAct_HP.this.curscrollState = scrollState;
                if (scrollState == 0) {
                    WCYuncheNissanAirControlAct_HP.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct_HP.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct_HP.this.recvflag);
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
                        case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                        case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                            switch (currentPassItem) {
                                case 0:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                    break;
                                case 28:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                    break;
                                default:
                                    int value = 64 - currentPassItem;
                                    DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
                                    break;
                            }
                            break;
                        default:
                            switch (currentPassItem) {
                                case 0:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                    break;
                                case 14:
                                    DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                    break;
                                default:
                                    int value2 = 64 - (currentPassItem * 2);
                                    DataCanbus.PROXY.cmd(1, new int[]{37, value2}, null, null);
                                    break;
                            }
                            break;
                    }
                }
            }

            @Override // com.syu.loopview.OnItemScrollListener
            public void onItemScrolling(LoopView loopView, int currentPassItem, int scrollState, int totalScrollY) {
            }
        });
        ((LoopView) findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        ((LoopView) findViewById(R.id.layout_view1)).setCenterTextSize(37.0f);
        ((LoopView) findViewById(R.id.layout_view1)).setOuterTextSize(33.0f);
        seekbaronClick((SeekBar) findViewById(R.id.layout_view2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScrollcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(this.mShowScrollcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{49}, null, null);
        mIsFront = true;
        this.recvflag = false;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (ConstAllAirDara.JumpNewAir) {
            mUpdaterWindowShow(true);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
        mUpdaterWindowShow(false);
    }

    private void mUpdaterWindowShow(boolean flag) {
        if (flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
            HandlerUI.getInstance().postDelayed(this.mShowWindowcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427444 */:
                data0 = 29;
                break;
            case R.id.air_xts_mode_body /* 2131427445 */:
                data0 = 26;
                break;
            case R.id.tv_text1 /* 2131427457 */:
                data0 = 254;
                break;
            case R.id.air_xts_mode_footbody /* 2131427555 */:
                data0 = 27;
                break;
            case R.id.air_xts_rear /* 2131427643 */:
                data0 = 42;
                break;
            case R.id.air_xts_fronthot /* 2131427694 */:
                data0 = 44;
                break;
            case R.id.air_xts_mode_footwin /* 2131427735 */:
                data0 = 28;
                break;
            case R.id.air_xts_ptc /* 2131427969 */:
                data0 = 80;
                break;
            case R.id.dj_xts_back /* 2131428707 */:
                finish();
                break;
            case R.id.air_mode /* 2131428708 */:
                data0 = 21;
                break;
        }
        if (data0 != 0) {
            if (data0 == 254) {
                if (event.getAction() == 0) {
                    if (ConstAllAirDara.JumpNewAir) {
                        ConstAllAirDara.JumpNewAircnt = 8;
                    }
                    if (this.touchcnt < 7) {
                        this.touchcnt++;
                    } else if (this.touchcnt == 7) {
                        DataCanbus.PROXY.cmd(0, new int[]{10, 1}, null, null);
                        this.touchcnt = 0;
                    }
                }
            } else {
                if (ConstAllAirDara.JumpNewAir) {
                    ConstAllAirDara.JumpNewAircnt = 8;
                }
                this.touchcnt = 0;
                if (event.getAction() == 0) {
                    sendCmd(data0, 1);
                } else if (event.getAction() == 1) {
                    sendCmd(data0, 0);
                }
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePTC() {
        int front = DataCanbus.DATA[68];
        if (findViewById(R.id.air_xts_ptc) != null) {
            findViewById(R.id.air_xts_ptc).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_ptchp_n : R.drawable.ic_air_wc_nissan_ptchp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHot() {
        int front = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_fronthot_hp_n : R.drawable.ic_air_wc_nissan_fronthot_hp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int front = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_ac_auto_n : R.drawable.ic_air_wc_nissan_ac_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_front_hp_n : R.drawable.ic_air_wc_nissan_front_hp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_wc_nissan_rear_hp_n : R.drawable.ic_air_wc_nissan_rear_hp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_wc_nissan_cycle_hp_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_wc_nissan_cycle_hp_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_wc_nissan_ac_hp_n : R.drawable.ic_air_wc_nissan_ac_hp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_wc_nissan_power_hp_n : R.drawable.ic_air_wc_nissan_power_hp_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp;
        int temp2 = DataCanbus.DATA[27];
        this.tempdata = temp2;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
        if (((LoopView) findViewById(R.id.layout_view1)) != null) {
            initmLauStylelist();
            int max = 14;
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
                case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                    max = 28;
                    break;
            }
            if (temp2 == -2) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(max);
            } else if (temp2 == -3) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(0);
            } else if (temp2 == 0) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(max);
            } else {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                    case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K /* 1704382 */:
                    case FinalCanbus.CAR_446_WC2_Nissan_Yunche_Ruiqi6_Pro_A17K_V2L /* 1769918 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                        temp = 64 - temp2;
                        if (temp > 27) {
                            temp = 27;
                        }
                        break;
                    default:
                        temp = (64 - temp2) / 2;
                        if (temp > 13) {
                            temp = 13;
                        }
                        break;
                }
                this.mLauStylelist.add(temp, String.valueOf(this.tempdata / 2.0f) + "℃");
                this.mLauStylelist.remove(temp + 1);
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(temp);
            }
            ((LoopView) findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_wc_nissan_wind_hp7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int front = DataCanbus.DATA[65];
        int mode = DataCanbus.DATA[77];
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode0);
        if (front == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode4);
        } else {
            switch (mode) {
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode2);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode3);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode1);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode5);
                    break;
            }
        }
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_wc_nissan_foot_hp_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_wc_nissan_body_hp_n);
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_wc_nissan_upfoot_hp_n);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_wc_nissan_bodyfoot_hp_n);
            if (front != 1) {
                switch (mode) {
                    case 1:
                        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_wc_nissan_body_hp_p);
                        break;
                    case 2:
                        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_wc_nissan_bodyfoot_hp_p);
                        break;
                    case 3:
                        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_wc_nissan_foot_hp_p);
                        break;
                    case 4:
                        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_wc_nissan_upfoot_hp_p);
                        break;
                }
            }
        }
    }
}
