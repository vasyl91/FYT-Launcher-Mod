package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAToyotaLexusLS460AirControlAct_SP extends Activity implements View.OnTouchListener {
    public static PAToyotaLexusLS460AirControlAct_SP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAToyotaLexusLS460AirControlAct_SP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 60:
                case 111:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdatePowerOn();
                    break;
                case 61:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 62:
                case 231:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateCycle();
                    break;
                case 64:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 65:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateSyncOn();
                    break;
                case 66:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
                case 70:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 71:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 72:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 73:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 74:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempLeft();
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRight();
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRear();
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRearRight();
                    break;
                case 108:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateFlowerOn();
                    break;
                case 110:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRear();
                    break;
                case 113:
                case 114:
                    PAToyotaLexusLS460AirControlAct_SP.this.updateBtnSourceRear();
                    break;
                case 115:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateRearAutoOn();
                    break;
                case 116:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterAirWindLevelRear();
                    break;
                case 117:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateRearLockOn();
                    break;
                case 118:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 119:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 153:
                case 154:
                case 155:
                    PAToyotaLexusLS460AirControlAct_SP.this.updateBtnSource();
                    break;
                case 156:
                case 157:
                case 158:
                    PAToyotaLexusLS460AirControlAct_SP.this.updateBtnSourceRight();
                    break;
                case 161:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterSeatBlowLeft();
                    break;
                case 162:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdaterSeatBlowRight();
                    break;
                case 177:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateMaxAcOn();
                    break;
                case 214:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirTempRearRight();
                    break;
                case 232:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirBlowAutoLeft();
                    break;
                case 233:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdateAirBlowAutoRight();
                    break;
                case 234:
                    PAToyotaLexusLS460AirControlAct_SP.this.mUpdatePurifierOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_toyota_lexusls460_air_sp);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_flower).setOnTouchListener(this);
        findViewById(R.id.air_xts_purifier).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_auto_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_left_plus_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_left_munits_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_right_plus_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_right_munits_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_mode_rear_plus).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_wind_minuts_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_wind_plus_rear).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                if (this.pagenum == 1) {
                    data0 = 44;
                    break;
                } else {
                    data0 = 1;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 13;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 19;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 12;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 14;
                break;
            case R.id.air_xts_mode_munits /* 2131427455 */:
                data0 = 69;
                break;
            case R.id.air_xts_mode_plus /* 2131427456 */:
                data0 = 67;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 16;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 68;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 20;
                break;
            case R.id.tv_sp_front /* 2131427929 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#666666"));
                mUpdatePowerOn();
                break;
            case R.id.tv_sp_rear /* 2131427930 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#666666"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                mUpdatePowerOn();
                break;
            case R.id.air_pa_jeep_auto_rear /* 2131427937 */:
                data0 = 45;
                break;
            case R.id.air_pa_jeep_temp_left_plus_rear /* 2131427938 */:
                data0 = 39;
                break;
            case R.id.air_pa_jeep_temp_left_munits_rear /* 2131427940 */:
                data0 = 38;
                break;
            case R.id.air_pa_jeep_temp_right_plus_rear /* 2131427942 */:
                data0 = 66;
                break;
            case R.id.air_pa_jeep_temp_right_munits_rear /* 2131427944 */:
                data0 = 65;
                break;
            case R.id.air_pa_jeep_wind_minuts_rear /* 2131427948 */:
                data0 = 40;
                break;
            case R.id.air_pa_jeep_wind_plus_rear /* 2131427950 */:
                data0 = 41;
                break;
            case R.id.air_pa_jeep_mode_rear_plus /* 2131428016 */:
                data0 = 43;
                break;
            case R.id.air_xts_flower /* 2131428017 */:
                data0 = 32;
                break;
            case R.id.air_xts_purifier /* 2131428018 */:
                data0 = 80;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_pa_jeep_front_n : R.drawable.ic_air_pa_jeep_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[73];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_pa_jeep_rear_n : R.drawable.ic_air_pa_jeep_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatBlowRight() {
        int value = DataCanbus.DATA[162];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[119];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[118];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatBlowLeft() {
        int value = DataCanbus.DATA[161];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[177];
        findViewById(R.id.air_xts_purifier).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_purifier_n : R.drawable.ic_air_pa_jeep_purifier_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[62];
        int auto = DataCanbus.DATA[231];
        if (auto == 1) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_lexus_cycle2);
                return;
            } else {
                if (cycle == 1) {
                    findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_lexus_cycle3);
                    return;
                }
                return;
            }
        }
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_lexus_cycle0);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_lexus_cycle1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_4zone_n : R.drawable.ic_air_pa_jeep_4zone_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[64];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_auto_n : R.drawable.ic_air_pa_jeep_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearLockOn() {
        int acOn = DataCanbus.DATA[117];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_rearlock_n : R.drawable.ic_air_pa_jeep_rearlock_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearAutoOn() {
        int acOn = DataCanbus.DATA[115];
        findViewById(R.id.air_pa_jeep_auto_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_rearauto_n : R.drawable.ic_air_pa_jeep_rearauto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePurifierOn() {
        int acOn = DataCanbus.DATA[234];
        findViewById(R.id.air_xts_purifier).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_purifier_n : R.drawable.ic_air_pa_jeep_purifier_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFlowerOn() {
        int acOn = DataCanbus.DATA[108];
        findViewById(R.id.air_xts_flower).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_flower_n : R.drawable.ic_air_pa_jeep_flower_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[61];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_ac_n : R.drawable.ic_air_pa_jeep_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[60];
        if (this.pagenum == 1) {
            power = DataCanbus.DATA[111];
        }
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_power_n : R.drawable.ic_air_pa_jeep_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRear() {
        int unit = DataCanbus.DATA[74];
        int temp = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText(temp + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRearRight() {
        int unit = DataCanbus.DATA[74];
        int temp = DataCanbus.DATA[214];
        if (((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText(temp + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowAutoLeft() {
        int auto = DataCanbus.DATA[232];
        if (((TextView) findViewById(R.id.tv_air_mode_auto_left)) != null) {
            if (auto == 1) {
                ((TextView) findViewById(R.id.tv_air_mode_auto_left)).setText("AUTO");
            } else {
                ((TextView) findViewById(R.id.tv_air_mode_auto_left)).setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowAutoRight() {
        int auto = DataCanbus.DATA[233];
        if (((TextView) findViewById(R.id.tv_air_mode_auto_right)) != null) {
            if (auto == 1) {
                ((TextView) findViewById(R.id.tv_air_mode_auto_right)).setText("AUTO");
            } else {
                ((TextView) findViewById(R.id.tv_air_mode_auto_right)).setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[74];
        int temp = DataCanbus.DATA[71];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[74];
        int temp = DataCanbus.DATA[72];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRear() {
        int leave = DataCanbus.DATA[116];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[70];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind7);
                break;
            default:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int body = DataCanbus.DATA[154];
        int window = DataCanbus.DATA[153];
        int foot = DataCanbus.DATA[155];
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
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode0);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSourceRight() {
        int body = DataCanbus.DATA[157];
        int window = DataCanbus.DATA[156];
        int foot = DataCanbus.DATA[158];
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
        findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode0);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_right_mode7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSourceRear() {
        int foot_rear = DataCanbus.DATA[114];
        int body_rear = DataCanbus.DATA[113];
        int mode_rear = 0;
        if (foot_rear == 1) {
            mode_rear = 0 | 1;
        } else if (foot_rear == 0) {
            mode_rear = 0 & 254;
        }
        if (body_rear == 1) {
            mode_rear |= 2;
        } else if (body_rear == 0) {
            mode_rear &= 253;
        }
        findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode0);
        switch (mode_rear) {
            case 1:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode3);
                break;
        }
    }
}
