package com.syu.carinfo.mzd.cx5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HaiMaV70AirControl extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.mzd.cx5.HaiMaV70AirControl.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    this.value = DataCanbus.DATA[updateCode];
                    if (this.value == 0) {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
                        break;
                    } else {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
                        break;
                    }
                case 1:
                    this.value = DataCanbus.DATA[updateCode];
                    if (this.value == 0) {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                        break;
                    } else {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 2:
                    this.value = DataCanbus.DATA[updateCode];
                    if (this.value == 0) {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                        break;
                    } else {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        break;
                    }
                case 4:
                case 5:
                case 6:
                    HaiMaV70AirControl.this.UpdateBlowMode();
                    break;
                case 7:
                    HaiMaV70AirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 8:
                case 9:
                case 10:
                    this.value = DataCanbus.DATA[8];
                    if (this.value == -2) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    } else if (this.value == -3) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                    } else if (DataCanbus.DATA[10] == 0) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(this.value / 2.0f) + "℃");
                    } else {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(this.value) + "℉");
                    }
                    this.value = DataCanbus.DATA[9];
                    if (this.value == -2) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                        break;
                    } else if (this.value == -3) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                        break;
                    } else if (DataCanbus.DATA[10] == 0) {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(this.value / 2.0f) + " ℃");
                        break;
                    } else {
                        ((TextView) HaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(this.value) + " ℉");
                        break;
                    }
                case 13:
                    this.value = DataCanbus.DATA[updateCode];
                    if (this.value == 0) {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_n);
                        break;
                    } else {
                        ((Button) HaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_p);
                        break;
                    }
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_air_control);
        initListener();
    }

    private void initListener() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_real)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                setAirControl(161, 1);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                setAirControl(161, 0);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.value = DataCanbus.DATA[0];
                setAirControl(168, this.value != 0 ? 0 : 1);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                setAirControl(160, 0);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                setAirControl(160, 1);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                this.value = DataCanbus.DATA[2];
                setAirControl(165, this.value != 0 ? 0 : 1);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                setAirControl(163, 4);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.value = DataCanbus.DATA[1];
                setAirControl(164, this.value != 0 ? 0 : 1);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                setAirControl(163, 3);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                setAirControl(163, 0);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                setAirControl(162, 1);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                setAirControl(162, 0);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                setAirControl(163, 1);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                setAirControl(163, 2);
                break;
            case R.id.air_xts_real /* 2131428967 */:
                this.value = DataCanbus.DATA[13];
                setAirControl(166, this.value != 0 ? 0 : 1);
                break;
        }
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[7];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateBlowMode() {
        int body = DataCanbus.DATA[5];
        int win = DataCanbus.DATA[4];
        int foot = DataCanbus.DATA[6];
        ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_n);
        if (foot == 1 && body == 1 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
            return;
        }
        if (foot == 0 && body == 1 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
            return;
        }
        if (foot == 1 && body == 0 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            return;
        }
        if (foot == 1 && body == 0 && win == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        } else if (foot == 0 && body == 0 && win == 1) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_p);
        }
    }
}
