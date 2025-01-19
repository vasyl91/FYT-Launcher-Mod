package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.content.Intent;
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

public class WCYuncheNissanAirControlAct extends Activity implements View.OnTouchListener {
    public static WCYuncheNissanAirControlAct mInstance;
    public static boolean mIsFront = false;
    public ArrayList<String> mLauStylelist;
    int curscrollState = -1;
    int curscrollcnt = 0;
    int tempdata = 0;
    int winlevdata = 0;
    boolean recvflag = false;
    Runnable mShowScrollcnt = new Runnable() { 
        @Override
        public void run() {
            WCYuncheNissanAirControlAct wCYuncheNissanAirControlAct = WCYuncheNissanAirControlAct.this;
            wCYuncheNissanAirControlAct.curscrollcnt--;
            if (WCYuncheNissanAirControlAct.this.curscrollcnt < 0) {
                WCYuncheNissanAirControlAct.this.curscrollcnt = 0;
                WCYuncheNissanAirControlAct.this.initmLauStylelist();
                ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                if (WCYuncheNissanAirControlAct.this.tempdata == -2) {
                    ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                } else if (WCYuncheNissanAirControlAct.this.tempdata == -3) {
                    ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(0);
                } else if (WCYuncheNissanAirControlAct.this.tempdata == 0) {
                    ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                } else {
                    int value = 64 - WCYuncheNissanAirControlAct.this.tempdata;
                    if (value > 27) {
                        value = 27;
                    }
                    WCYuncheNissanAirControlAct.this.mLauStylelist.add(value, String.valueOf(WCYuncheNissanAirControlAct.this.tempdata / 2.0f) + "℃");
                    WCYuncheNissanAirControlAct.this.mLauStylelist.remove(value + 1);
                    ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(value);
                }
                ((LoopView) WCYuncheNissanAirControlAct.this.findViewById(R.id.layout_view1)).setItems(WCYuncheNissanAirControlAct.this.mLauStylelist);
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowScrollcnt);
                return;
            }
            HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(WCYuncheNissanAirControlAct.this.mShowScrollcnt, 1000L);
        }
    };
    Runnable mShowSeekbarcnt = new Runnable() { 
        @Override
        public void run() {
            WCYuncheNissanAirControlAct wCYuncheNissanAirControlAct = WCYuncheNissanAirControlAct.this;
            wCYuncheNissanAirControlAct.curscrollcnt--;
            if (WCYuncheNissanAirControlAct.this.curscrollcnt < 0) {
                WCYuncheNissanAirControlAct.this.curscrollcnt = 0;
                ((SeekBar) WCYuncheNissanAirControlAct.this.findViewById(R.id.air_pa_jeep_wind_lev)).setProgress(WCYuncheNissanAirControlAct.this.winlevdata);
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowSeekbarcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowSeekbarcnt);
                HandlerUI.getInstance().postDelayed(WCYuncheNissanAirControlAct.this.mShowSeekbarcnt, 1000L);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { 
        @Override
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.air_pa_jeep_wind_lev /* 2131427938 */:
                    WCYuncheNissanAirControlAct.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct.this.mUpdaterSeekbarcnt(WCYuncheNissanAirControlAct.this.recvflag);
                    DataCanbus.PROXY.cmd(1, new int[]{39, v.getProgress()}, null, null);
                    break;
            }
        }

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            arg0.getId();
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    Runnable mShowWindowcnt = new Runnable() { 
        @Override
        public void run() {
            Log.v("zed", "ConstAllAirDara.JumpNewAircnt = " + ConstAllAirDara.JumpNewAircnt);
            ConstAllAirDara.JumpNewAircnt--;
            if (ConstAllAirDara.JumpNewAircnt == 0) {
                WCYuncheNissanAirControlAct.this.finish();
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowWindowcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(WCYuncheNissanAirControlAct.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(WCYuncheNissanAirControlAct.this.mShowWindowcnt, 1000L);
            }
        }
    };
    int touchcnt = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (ConstAllAirDara.JumpNewAir) {
                ConstAllAirDara.JumpNewAircnt = 8;
            }
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    WCYuncheNissanAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    WCYuncheNissanAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    WCYuncheNissanAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    WCYuncheNissanAirControlAct.this.mUpdateAutoOn();
                    break;
                case 16:
                    WCYuncheNissanAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 17:
                    WCYuncheNissanAirControlAct.this.mUpdateFrontHot();
                    break;
                case 18:
                case 19:
                case 20:
                    WCYuncheNissanAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    WCYuncheNissanAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    WCYuncheNissanAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    WCYuncheNissanAirControlAct.this.mUpdateFrontDefrost();
                    WCYuncheNissanAirControlAct.this.updateBtnSource();
                    break;
                case 68:
                    WCYuncheNissanAirControlAct.this.mUpdatePTC();
                    break;
                case 124:
                    switch (value) {
                        case 0:
                            WCYuncheNissanAirControlAct.this.touchcnt = 0;
                            ((TextView) WCYuncheNissanAirControlAct.this.findViewById(R.id.tv_text1)).setText("");
                            break;
                        case 1:
                            ((TextView) WCYuncheNissanAirControlAct.this.findViewById(R.id.tv_text1)).setText("喇叭测试:开");
                            break;
                    }
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                //setContentView(R.layout.layout_0444_wc_yunche_nissan_rich7gcc_air);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                //setContentView(R.layout.layout_0444_wc_yunche_nissan_rich7gcc_norear_air);
                break;
            default:
                //setContentView(R.layout.layout_0444_wc_yunche_nissan_air);
                break;
        }
        init();
        mInstance = this;
    }

    
    public void initmLauStylelist() {
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
    }

    private void init() {
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_cycle) != null) {
            findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
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
        if (findViewById(R.id.air_xts_ptc) != null) {
            findViewById(R.id.air_xts_ptc).setOnTouchListener(this);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                findViewById(R.id.air_xts_ptc).setVisibility(8);
                findViewById(R.id.air_xts_fronthot).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                findViewById(R.id.air_xts_ptc).setVisibility(0);
                findViewById(R.id.air_xts_fronthot).setVisibility(8);
                break;
        }
        findViewById(R.id.tv_text1).setOnTouchListener(this);
        this.mLauStylelist = new ArrayList<>();
        initmLauStylelist();
        ((LoopView) findViewById(R.id.layout_view1)).setNotLoop();
        ((LoopView) findViewById(R.id.layout_view1)).setListener(new OnItemSelectedListener() { 
            @Override
            public void onItemSelected(int index) {
                Log.v("zed", "onItemSelected = " + index);
                if (WCYuncheNissanAirControlAct.this.curscrollState == 2) {
                    WCYuncheNissanAirControlAct.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct.this.recvflag);
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
                }
            }
        });
        ((LoopView) findViewById(R.id.layout_view1)).setOnItemScrollListener(new OnItemScrollListener() { 
            @Override
            public void onItemScrollStateChanged(LoopView loopView, int currentPassItem, int oldScrollState, int scrollState, int totalScrollY) {
                WCYuncheNissanAirControlAct.this.curscrollState = scrollState;
                if (scrollState == 0) {
                    WCYuncheNissanAirControlAct.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct.this.recvflag);
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
                }
            }

            @Override
            public void onItemScrolling(LoopView loopView, int currentPassItem, int scrollState, int totalScrollY) {
            }
        });
        ((LoopView) findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        ((LoopView) findViewById(R.id.layout_view1)).setCenterTextSize(37.0f);
        ((LoopView) findViewById(R.id.layout_view1)).setOuterTextSize(33.0f);
        seekbaronClick((SeekBar) findViewById(R.id.air_pa_jeep_wind_lev));
    }

    
    public void mUpdaterScrollcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(this.mShowScrollcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
    }

    
    public void mUpdaterSeekbarcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
            HandlerUI.getInstance().postDelayed(this.mShowSeekbarcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
        }
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        this.recvflag = false;
        addUpdater();
        DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
        AirHelper.disableAirWindowLocal(true);
        startService(new Intent("android.fyt.action.HIDE"));
        if (ConstAllAirDara.JumpNewAir) {
            mUpdaterWindowShow(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        DataCanbus.PROXY.cmd(7, new int[1], null, null);
        startService(new Intent("android.fyt.action.SHOW"));
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

    @Override
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
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 29;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 26;
                break;
            case R.id.tv_text1 /* 2131427456 */:
                data0 = 254;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                data0 = 27;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 42;
                break;
            case R.id.air_xts_fronthot /* 2131427591 */:
                data0 = 44;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                data0 = 28;
                break;
            case R.id.air_xts_ptc /* 2131427768 */:
                data0 = 80;
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatePTC() {
        int front = DataCanbus.DATA[68];
        if (findViewById(R.id.air_xts_ptc) != null) {
            findViewById(R.id.air_xts_ptc).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_ptc_n : R.drawable.ic_air_wc_nissan_ptc_p);
        }
    }

    
    public void mUpdateFrontHot() {
        int front = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_fronthot_n : R.drawable.ic_air_wc_nissan_fronthot_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_front_n : R.drawable.ic_air_wc_nissan_front_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_wc_nissan_rear_n : R.drawable.ic_air_wc_nissan_rear_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_wc_nissan_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_wc_nissan_cycle_p);
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_wc_nissan_auto_n : R.drawable.ic_air_wc_nissan_auto_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_wc_nissan_ac_n : R.drawable.ic_air_wc_nissan_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_wc_nissan_power_n : R.drawable.ic_air_wc_nissan_power_p);
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        this.tempdata = temp;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
        }
        if (((LoopView) findViewById(R.id.layout_view1)) != null) {
            initmLauStylelist();
            if (temp == -2) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(28);
            } else if (temp == -3) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(0);
            } else if (temp == 0) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(28);
            } else {
                int temp2 = 64 - temp;
                if (temp2 > 27) {
                    temp2 = 27;
                }
                this.mLauStylelist.add(temp2, String.valueOf(this.tempdata / 2.0f) + "℃");
                this.mLauStylelist.remove(temp2 + 1);
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(temp2);
            }
            ((LoopView) findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        this.winlevdata = leave;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
        }
        ((SeekBar) findViewById(R.id.air_pa_jeep_wind_lev)).setProgress(leave);
        ((SeekBar) findViewById(R.id.air_pa_jeep_wind_lev)).invalidate();
    }

    
    public void updateBtnSource() {
        int body = DataCanbus.DATA[19];
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int front = DataCanbus.DATA[65];
        int mode = 0;
        if (foot == 1) {
            mode = 0 | 1;
        } else if (foot == 0) {
            mode = 0 & 254;
        }
        if (body == 1) {
            mode |= 2;
        } else if (body == 0) {
            mode &= 253;
        }
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_footwin_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_footbody_n);
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode0);
        if (front == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode4);
        }
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_foot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_body_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_footbody_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode3);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode_footwin_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_mode5);
                break;
        }
    }
}
