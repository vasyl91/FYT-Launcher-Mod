package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ZH2PilotcarCarAirCtrlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateCycle();
                    break;
                case 13:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateAutoOn();
                    break;
                case 16:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateRearDefrost();
                    break;
                case 19:
                    ZH2PilotcarCarAirCtrlAct.this.updateBtnBodySource();
                    break;
                case 20:
                    ZH2PilotcarCarAirCtrlAct.this.updateBtnFootSource();
                    break;
                case 21:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateFrontDefrost();
                    break;
                case 80:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateAirTempOut();
                    break;
                case 127:
                case 128:
                    ZH2PilotcarCarAirCtrlAct.this.mUpdateAirTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0455_zh_pilotcar_air_ctrl_settings);
        findViewById(R.id.btn_minus1).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_foot).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = -1;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 9;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 8;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 10;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 4;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 1;
                break;
            case R.id.btn_minus1 /* 2131427455 */:
                finish();
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 3;
                break;
            case R.id.air_sp_mode_body /* 2131428558 */:
                data0 = 6;
                break;
            case R.id.air_sp_mode_foot /* 2131428560 */:
                data0 = 5;
                break;
        }
        if (data0 != -1) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(2, new int[]{172, data0}, null, null);
            } else {
                DataCanbus.PROXY.cmd(2, new int[]{172}, null, null);
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTime() {
        int hour = DataCanbus.DATA[127];
        int min = DataCanbus.DATA[128];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
        }
    }

    
    public void mUpdateAirTempOut() {
        int temp = DataCanbus.DATA[80];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if ((temp & 128) != 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText("-" + (256 - temp) + "℃");
                return;
            }
            ((TextView) findViewById(R.id.tv_text1)).setText(temp + "℃");
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_pilotcar_auto_n : R.drawable.ic_pilotcar_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 1 ? R.drawable.ic_pilotcar_ac_p : R.drawable.ic_pilotcar_ac_n);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_pilotcar_cycle_p);
        } else {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_pilotcar_cycle_n);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_pilotcar_front_n : R.drawable.ic_pilotcar_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_pilotcar_rear_n : R.drawable.ic_pilotcar_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder(String.valueOf(leave)).toString());
    }

    
    public void updateBtnBodySource() {
        int body = DataCanbus.DATA[19];
        findViewById(R.id.air_sp_mode_body).setBackgroundResource(body == 0 ? R.drawable.ic_pilotcar_blow_n : R.drawable.ic_pilotcar_blow_p);
    }

    
    public void updateBtnFootSource() {
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_sp_mode_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_pilotcar_blow_n : R.drawable.ic_pilotcar_blow_p);
    }
}
