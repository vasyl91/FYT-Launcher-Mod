package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class KYCLexusRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int pagenum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                case 19:
                case 20:
                    KYCLexusRearAirControlAct.this.updateBtnSource();
                    break;
                case 22:
                case 23:
                case 24:
                    KYCLexusRearAirControlAct.this.updateBtnSourceRight();
                    break;
                case 37:
                    KYCLexusRearAirControlAct.this.mUpdateAirTempLeft();
                    KYCLexusRearAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 40:
                    KYCLexusRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 41:
                    KYCLexusRearAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 43:
                    KYCLexusRearAirControlAct.this.mUpdateAutoOn();
                    break;
                case 44:
                    KYCLexusRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(3, new int[]{data0}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0452_kyc_lexus_rear_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_back).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 43;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 44;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 48;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 46;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 45;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 49;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 51;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 52;
                break;
            case R.id.air_xts_back /* 2131428556 */:
                finish();
                flag = true;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 5 * 0.1f) + "℃");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 31) + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[41];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 5 * 0.1f) + "℃");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp + 31) + "℉");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[43];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_kyc_rearauto_p : R.drawable.ic_air_kyc_rearauto_n);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[44];
        switch (leave) {
            case 0:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_0);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 1:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_1);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 2:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_2);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 3:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_3);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 4:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_4);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 5:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_5);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 6:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_6);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 7:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_7);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(8);
                break;
            case 15:
                findViewById(R.id.dj_xts_air_winlevel).setBackgroundResource(R.drawable.ic_air_kyc_winlev_0);
                findViewById(R.id.dj_xts_air_winauto).setVisibility(0);
                break;
        }
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_air_kyc_rearpower_n : R.drawable.ic_air_kyc_rearpower_p);
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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
        findViewById(R.id.air_sp_mode_body).setVisibility(8);
        findViewById(R.id.air_sp_mode_bodyfoot).setVisibility(8);
        findViewById(R.id.air_sp_mode_foot).setVisibility(8);
        findViewById(R.id.air_sp_mode_winfoot).setVisibility(8);
        findViewById(R.id.air_sp_mode_auto).setVisibility(8);
        switch (mode) {
            case 0:
                findViewById(R.id.air_sp_mode_auto).setVisibility(0);
                break;
            case 1:
                findViewById(R.id.air_sp_mode_foot).setVisibility(0);
                break;
            case 2:
                findViewById(R.id.air_sp_mode_body).setVisibility(0);
                break;
            case 3:
                findViewById(R.id.air_sp_mode_bodyfoot).setVisibility(0);
                break;
            case 5:
                findViewById(R.id.air_sp_mode_winfoot).setVisibility(0);
                break;
        }
    }

    
    public void updateBtnSourceRight() {
        int window = DataCanbus.DATA[22];
        int foot = DataCanbus.DATA[24];
        int body = DataCanbus.DATA[23];
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
        findViewById(R.id.air_sp_mode_body_right).setVisibility(8);
        findViewById(R.id.air_sp_mode_bodyfoot_right).setVisibility(8);
        findViewById(R.id.air_sp_mode_foot_right).setVisibility(8);
        findViewById(R.id.air_sp_mode_auto_right).setVisibility(8);
        switch (mode) {
            case 0:
                findViewById(R.id.air_sp_mode_auto_right).setVisibility(0);
                break;
            case 1:
                findViewById(R.id.air_sp_mode_foot_right).setVisibility(0);
                break;
            case 2:
                findViewById(R.id.air_sp_mode_body_right).setVisibility(0);
                break;
            case 3:
                findViewById(R.id.air_sp_mode_bodyfoot_right).setVisibility(0);
                break;
        }
    }
}
