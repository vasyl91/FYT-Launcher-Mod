package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class YLAirControlAct_BNR extends Activity implements View.OnClickListener {
    public static YLAirControlAct_BNR mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    YLAirControlAct_BNR.this.mUpdateAcOn();
                    break;
                case 12:
                    YLAirControlAct_BNR.this.mUpdateCycle();
                    break;
                case 14:
                    YLAirControlAct_BNR.this.mUpdatesyncOn();
                    break;
                case 15:
                    YLAirControlAct_BNR.this.mUpdateFrontDefrog();
                    break;
                case 21:
                case 74:
                    YLAirControlAct_BNR.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    YLAirControlAct_BNR.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    YLAirControlAct_BNR.this.mUpdateAirTempRight();
                    break;
                case 49:
                    YLAirControlAct_BNR.this.mUpdateAirAutoOn();
                    break;
                case 77:
                    YLAirControlAct_BNR.this.mUpdatefrontblow();
                    break;
                case 80:
                    YLAirControlAct_BNR.this.uAcAuto(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    boolean acauto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0379_bnr_gm_all_airset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    private void sendCmd(final int cmd) {
        DataCanbus.PROXY.cmd(10, new int[]{cmd, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(10, new int[]{cmd}, null, null);
            }
        }, 100L);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int cmd = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmd = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmd = 2;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmd = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmd = 10;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmd = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 18;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 23;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmd = 11;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmd = 8;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmd = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmd = 4;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                cmd = 33;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                cmd = 16;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                cmd = 32;
                break;
        }
        sendCmd(cmd);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        String str;
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                str = "LOW";
            } else if (temp == -3) {
                str = "HI";
            } else if (temp == -1) {
                str = "NO";
            } else {
                str = (temp * 0.1f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    protected void mUpdateFrontDefrog() {
        int window = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front).setBackgroundResource(window != 0 ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
    }

    protected void uAcAuto(int i) {
        this.acauto = i != 0;
        mUpdateAcOn();
    }

    
    public void mUpdateAirTempRight() {
        String str;
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                str = "LOW";
            } else if (temp == -3) {
                str = "HI";
            } else if (temp == -1) {
                str = "NO";
            } else {
                str = (temp * 0.1f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (this.acauto) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(R.drawable.ic_xts_ac_auto_p);
        } else {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdatesyncOn() {
        int sync = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(sync == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAirAutoOn() {
        int auto = DataCanbus.DATA[49];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[21];
        int leaveAuto = DataCanbus.DATA[74];
        if (leaveAuto != 0) {
            str = "A";
        } else {
            str = " " + leave;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void mUpdatefrontblow() {
        int mode = DataCanbus.DATA[77];
        boolean auto = false;
        boolean window = false;
        boolean foot = false;
        boolean body = false;
        boolean bodyfoot = false;
        boolean upfoot = false;
        if (mode == 1) {
            auto = true;
        } else if (mode == 2) {
            window = true;
        } else if (mode == 3) {
            foot = true;
        } else if (mode == 4) {
            bodyfoot = true;
        } else if (mode == 5) {
            body = true;
        } else if (mode != 7 && mode == 8) {
            upfoot = true;
        }
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(body ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(foot ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_front).setBackgroundResource(window ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(upfoot ? R.drawable.ic_xts_mode_footwin_p : R.drawable.ic_xts_mode_footwin_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(bodyfoot ? R.drawable.ic_xts_mode_footbody_p : R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }
}
