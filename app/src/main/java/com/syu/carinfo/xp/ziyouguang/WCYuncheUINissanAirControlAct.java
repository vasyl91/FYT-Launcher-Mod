package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.syu.canbus.R;
import com.syu.carinfo.air.ConstAllAirDara;
import com.syu.loopview.LoopView;
import com.syu.loopview.OnItemScrollListener;
import com.syu.loopview.OnItemSelectedListener;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

import java.util.ArrayList;

public class WCYuncheUINissanAirControlAct extends Activity implements View.OnTouchListener {
    public static WCYuncheUINissanAirControlAct mInstance;
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
            WCYuncheUINissanAirControlAct wCYuncheUINissanAirControlAct = WCYuncheUINissanAirControlAct.this;
            wCYuncheUINissanAirControlAct.curscrollcnt--;
            if (WCYuncheUINissanAirControlAct.this.curscrollcnt < 0) {
                WCYuncheUINissanAirControlAct.this.curscrollcnt = 0;
                WCYuncheUINissanAirControlAct.this.initmLauStylelist();
                ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                if (WCYuncheUINissanAirControlAct.this.tempdata == -2) {
                    ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                } else if (WCYuncheUINissanAirControlAct.this.tempdata == -3) {
                    ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(0);
                } else if (WCYuncheUINissanAirControlAct.this.tempdata == 0) {
                    ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(14);
                } else {
                    int value = (64 - WCYuncheUINissanAirControlAct.this.tempdata) / 2;
                    if (value > 13) {
                        value = 13;
                    }
                    WCYuncheUINissanAirControlAct.this.mLauStylelist.add(value, String.valueOf(WCYuncheUINissanAirControlAct.this.tempdata / 2.0f) + "℃");
                    WCYuncheUINissanAirControlAct.this.mLauStylelist.remove(value + 1);
                    ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setCurrentPosition(value);
                }
                ((LoopView) WCYuncheUINissanAirControlAct.this.findViewById(R.id.layout_view1)).setItems(WCYuncheUINissanAirControlAct.this.mLauStylelist);
                HandlerUI.getInstance().removeCallbacks(WCYuncheUINissanAirControlAct.this.mShowScrollcnt);
                return;
            }
            HandlerUI.getInstance().removeCallbacks(WCYuncheUINissanAirControlAct.this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(WCYuncheUINissanAirControlAct.this.mShowScrollcnt, 1000L);
        }
    };
    Runnable mShowWindowcnt = new Runnable() { 
        @Override
        public void run() {
            Log.v("zed", "ConstAllAirDara.JumpNewAircnt = " + ConstAllAirDara.JumpNewAircnt);
            ConstAllAirDara.JumpNewAircnt--;
            if (ConstAllAirDara.JumpNewAircnt == 0) {
                WCYuncheUINissanAirControlAct.this.finish();
                HandlerUI.getInstance().removeCallbacks(WCYuncheUINissanAirControlAct.this.mShowWindowcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(WCYuncheUINissanAirControlAct.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(WCYuncheUINissanAirControlAct.this.mShowWindowcnt, 1000L);
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
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    WCYuncheUINissanAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    WCYuncheUINissanAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    WCYuncheUINissanAirControlAct.this.mUpdateCycle();
                    break;
                case 16:
                    WCYuncheUINissanAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 17:
                    WCYuncheUINissanAirControlAct.this.mUpdateFrontHot();
                    WCYuncheUINissanAirControlAct.this.updateBtnSource();
                    break;
                case 18:
                case 19:
                case 20:
                    WCYuncheUINissanAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    WCYuncheUINissanAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    WCYuncheUINissanAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    WCYuncheUINissanAirControlAct.this.mUpdateFrontDefrost();
                    WCYuncheUINissanAirControlAct.this.updateBtnSource();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0444_wc_yunche_ui_air);
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
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setOnTouchListener(this);
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
        this.mLauStylelist = new ArrayList<>();
        initmLauStylelist();
        ((LoopView) findViewById(R.id.layout_view1)).setNotLoop();
        ((LoopView) findViewById(R.id.layout_view1)).setListener(new OnItemSelectedListener() { 
            @Override
            public void onItemSelected(int index) {
                Log.v("zed", "onItemSelected = " + index);
                if (WCYuncheUINissanAirControlAct.this.curscrollState == 2) {
                    WCYuncheUINissanAirControlAct.this.curscrollcnt = 2;
                    WCYuncheUINissanAirControlAct.this.mUpdaterScrollcnt(WCYuncheUINissanAirControlAct.this.recvflag);
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
                WCYuncheUINissanAirControlAct.this.curscrollState = scrollState;
                if (scrollState == 0) {
                    WCYuncheUINissanAirControlAct.this.curscrollcnt = 2;
                    WCYuncheUINissanAirControlAct.this.mUpdaterScrollcnt(WCYuncheUINissanAirControlAct.this.recvflag);
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
        ((LoopView) findViewById(R.id.layout_view1)).setOuterTextSize(30.0f);
    }

    
    public void mUpdaterScrollcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(this.mShowScrollcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
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
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_yunche_front_n : R.drawable.ic_air_yunche_front_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_yunche_rear_n : R.drawable.ic_air_yunche_rear_p);
        }
    }

    
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_fronthot) != null) {
            findViewById(R.id.air_xts_fronthot).setBackgroundResource(rear == 0 ? R.drawable.ic_air_yunche_fronthot_n : R.drawable.ic_air_yunche_fronthot_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_yunche_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_yunche_cycle_p);
            }
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_yunche_ac_n : R.drawable.ic_air_yunche_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_yunche_power_n : R.drawable.ic_air_yunche_power_p);
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
                this.mLauStylelist.add(temp2, String.valueOf(this.tempdata / 2.0f) + "°");
                this.mLauStylelist.remove(temp2 + 1);
                ((LoopView) findViewById(R.id.layout_view1)).setCurrentPosition(temp2);
            }
            ((LoopView) findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave > 7) {
            leave = 7;
        }
        switch (leave) {
            case 0:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev0);
                break;
            case 1:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev1);
                break;
            case 2:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev2);
                break;
            case 3:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev3);
                break;
            case 4:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev4);
                break;
            case 5:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev5);
                break;
            case 6:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev6);
                break;
            case 7:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_yunche_winlev7);
                break;
        }
    }

    
    public void updateBtnSource() {
        int body = DataCanbus.DATA[19];
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int front = DataCanbus.DATA[65];
        int fronthot = DataCanbus.DATA[17];
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
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_yunche_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_yunche_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_yunche_mode_winfoot_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_yunche_mode_bodyfoot_n);
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        if (fronthot == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode_fronthot);
        }
        if (front == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode4);
            return;
        }
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_air_yunche_mode_foot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_air_yunche_mode_body_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_air_yunche_mode_bodyfoot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode3);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_air_yunche_mode_winfoot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_yunche_mode5);
                break;
        }
    }
}
