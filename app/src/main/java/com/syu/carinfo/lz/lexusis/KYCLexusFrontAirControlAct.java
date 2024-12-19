package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KYCLexusFrontAirControlAct extends Activity implements View.OnTouchListener {
    public static KYCLexusFrontAirControlAct mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.KYCLexusFrontAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    KYCLexusFrontAirControlAct.this.mUpdateAcOn();
                    break;
                case 13:
                    KYCLexusFrontAirControlAct.this.mUpdateAutoOn();
                    break;
                case 17:
                    KYCLexusFrontAirControlAct.this.mUpdateFrontHotOn();
                    break;
                case 18:
                case 19:
                case 20:
                    KYCLexusFrontAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    KYCLexusFrontAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                case 23:
                case 24:
                    KYCLexusFrontAirControlAct.this.updateBtnSourceRight();
                    break;
                case 27:
                    KYCLexusFrontAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    KYCLexusFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 33:
                    KYCLexusFrontAirControlAct.this.mUpdateClearOn();
                    break;
                case 37:
                    KYCLexusFrontAirControlAct.this.mUpdateAirTempLeft();
                    KYCLexusFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 62:
                    KYCLexusFrontAirControlAct.this.mUpdateDualOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(3, new int[]{data0}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_0452_kyc_lexus_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_back).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_change).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_flower).setOnTouchListener(this);
        findViewById(R.id.air_xts_nanoe).setOnTouchListener(this);
        findViewById(R.id.air_xts_list).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_change_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_zone).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontrear).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 9;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 10;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 20;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 35;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 16;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 11;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 12;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                data0 = 50;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 4;
                break;
            case R.id.air_xts_flower /* 2131428017 */:
                data0 = 15;
                break;
            case R.id.air_xts_zone /* 2131428027 */:
                data0 = 8;
                break;
            case R.id.air_xts_back /* 2131428559 */:
                finish();
                flag = true;
                break;
            case R.id.air_sp_mode_change /* 2131428560 */:
                data0 = 17;
                break;
            case R.id.air_xts_list /* 2131428569 */:
                if (event.getAction() == 0) {
                    if (this.pagenum == 0) {
                        this.pagenum = 1;
                        findViewById(R.id.layout_view1).setVisibility(0);
                    } else {
                        this.pagenum = 0;
                        findViewById(R.id.layout_view1).setVisibility(8);
                    }
                }
                flag = true;
                break;
            case R.id.air_sp_mode_change_right /* 2131428570 */:
                data0 = 42;
                break;
            case R.id.air_xts_frontrear /* 2131428575 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) KYCLexusRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_kyc_auto_n : R.drawable.ic_air_kyc_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[62];
        if (findViewById(R.id.air_xts_zone) != null) {
            findViewById(R.id.air_xts_zone).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_kyc_4zone_n : R.drawable.ic_air_kyc_4zone_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_kyc_ac_n : R.drawable.ic_air_kyc_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateClearOn() {
        if (findViewById(R.id.air_xts_flower) != null) {
            int power = DataCanbus.DATA[33];
            findViewById(R.id.air_xts_flower).setBackgroundResource(power == 0 ? R.drawable.ic_air_kyc_flower_blow_n : R.drawable.ic_air_kyc_flower_blow_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHotOn() {
        int power = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_air_kyc_swing_n : R.drawable.ic_air_kyc_swing_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
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
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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
