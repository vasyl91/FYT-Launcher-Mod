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

public class WCYuncheNissanAirControlAct_HP extends Activity implements View.OnTouchListener {
    public static WCYuncheNissanAirControlAct_HP mInstance;
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
            WCYuncheNissanAirControlAct_HP wCYuncheNissanAirControlAct_HP = WCYuncheNissanAirControlAct_HP.this;
            wCYuncheNissanAirControlAct_HP.curscrollcnt--;
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
                    if (value > 13) {
                        value = 13;
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
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { 
        @Override
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.layout_view2 /* 2131427527 */:
                    WCYuncheNissanAirControlAct_HP.this.seekbartouch = false;
                    break;
            }
        }

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            switch (arg0.getId()) {
                case R.id.layout_view2 /* 2131427527 */:
                    if (WCYuncheNissanAirControlAct_HP.this.seekbartouch) {
                        DataCanbus.PROXY.cmd(1, new int[]{39, arg0.getProgress()}, null, null);
                        break;
                    }
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
            switch (arg0.getId()) {
                case R.id.layout_view2 /* 2131427527 */:
                    WCYuncheNissanAirControlAct_HP.this.seekbartouch = true;
                    break;
            }
        }
    };
    Runnable mShowWindowcnt = new Runnable() { 
        @Override
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                case 16:
                    WCYuncheNissanAirControlAct_HP.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    WCYuncheNissanAirControlAct_HP.this.updateBtnSource();
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
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
                //setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hp);
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
                //setContentView(R.layout.layout_0444_wc_yunche_nissan_air_hp2);
                break;
        }
        init();
        mInstance = this;
    }

    
    public void initmLauStylelist() {
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
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_mode) != null) {
            findViewById(R.id.air_mode).setOnTouchListener(this);
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
        if (findViewById(R.id.tv_text1) != null) {
            findViewById(R.id.tv_text1).setOnTouchListener(this);
        }
        this.mLauStylelist = new ArrayList<>();
        initmLauStylelist();
        ((LoopView) findViewById(R.id.layout_view1)).setNotLoop();
        ((LoopView) findViewById(R.id.layout_view1)).setListener(new OnItemSelectedListener() { 
            @Override
            public void onItemSelected(int index) {
                Log.v("zed", "onItemSelected = " + index);
                if (WCYuncheNissanAirControlAct_HP.this.curscrollState == 2) {
                    WCYuncheNissanAirControlAct_HP.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct_HP.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct_HP.this.recvflag);
                    switch (index) {
                        case 0:
                            DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                            break;
                        case 14:
                            DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                            break;
                        default:
                            int value = 64 - (index * 2);
                            DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
                            break;
                    }
                }
            }
        });
        ((LoopView) findViewById(R.id.layout_view1)).setOnItemScrollListener(new OnItemScrollListener() { 
            @Override
            public void onItemScrollStateChanged(LoopView loopView, int currentPassItem, int oldScrollState, int scrollState, int totalScrollY) {
                WCYuncheNissanAirControlAct_HP.this.curscrollState = scrollState;
                if (scrollState == 0) {
                    WCYuncheNissanAirControlAct_HP.this.curscrollcnt = 2;
                    WCYuncheNissanAirControlAct_HP.this.mUpdaterScrollcnt(WCYuncheNissanAirControlAct_HP.this.recvflag);
                    switch (currentPassItem) {
                        case 0:
                            DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                            break;
                        case 14:
                            DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                            break;
                        default:
                            int value = 64 - (currentPassItem * 2);
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
        seekbaronClick((SeekBar) findViewById(R.id.layout_view2));
    }

    
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

    @Override
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

    @Override
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
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.tv_text1 /* 2131427456 */:
                data0 = 254;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 42;
                break;
            case R.id.dj_xts_back /* 2131428554 */:
                finish();
                break;
            case R.id.air_mode /* 2131428555 */:
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
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_wc_nissan_front_hp_n : R.drawable.ic_air_wc_nissan_front_hp_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_wc_nissan_rear_hp_n : R.drawable.ic_air_wc_nissan_rear_hp_p);
        }
    }

    
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

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_wc_nissan_ac_hp_n : R.drawable.ic_air_wc_nissan_ac_hp_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_wc_nissan_power_hp_n : R.drawable.ic_air_wc_nissan_power_hp_p);
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        this.tempdata = temp;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
        if (((LoopView) findViewById(R.id.layout_view1)) != null) {
            initmLauStylelist();
            if (temp == -2) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(14);
            } else if (temp == -3) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(0);
            } else if (temp == 0) {
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(14);
            } else {
                int temp2 = (64 - temp) / 2;
                if (temp2 > 13) {
                    temp2 = 13;
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
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode0);
        if (front == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode4);
        }
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode3);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_wc_nissan_hp_mode5);
                break;
        }
    }
}
