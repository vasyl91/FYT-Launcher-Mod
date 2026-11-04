package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0298_XP1_2015SIYU_CRV;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityAirControl extends Activity implements View.OnClickListener {
    public static ActivityAirControl mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.ActivityAirControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if ((DataCanbus.DATA[1000] & 65535) == 321) {
                switch (updateCode) {
                    case 11:
                        if (DataCanbus.DATA[11] == 0) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_298_air_ac_off_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_298_air_ac_on_n);
                        } else {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_298_air_ac_off_n);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_298_air_ac_on_p);
                        }
                        break;
                    case 21:
                        ActivityAirControl.this.clearWindBack();
                        switch (DataCanbus.DATA[21]) {
                            case 1:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                break;
                            case 2:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                break;
                            case 3:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                break;
                            case 4:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                break;
                            case 5:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                break;
                            case 6:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus12)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                                break;
                            case 7:
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus12)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus13)).setBackgroundResource(R.drawable.ic_298_air_wind_7_p);
                                break;
                        }
                        break;
                    case 77:
                        ActivityAirControl.this.clearModeBack();
                        if (DataCanbus.DATA[77] == 4) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus6)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_p);
                        } else if (DataCanbus.DATA[77] == 5) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_p);
                        } else if (DataCanbus.DATA[77] == 3) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_p);
                        } else if (DataCanbus.DATA[77] == 6) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_p);
                        }
                        break;
                }
            }
            switch (updateCode) {
                case 11:
                    if (DataCanbus.DATA[11] == 0) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_298_air_ac_off_p);
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_298_air_ac_on_n);
                    } else {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_298_air_ac_off_n);
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_298_air_ac_on_p);
                    }
                    break;
                case 18:
                case 19:
                case 20:
                    ActivityAirControl.this.clearModeBack();
                    int value1 = DataCanbus.DATA[18];
                    int value2 = DataCanbus.DATA[19];
                    int value3 = DataCanbus.DATA[20];
                    if (value3 == 1 && value1 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus6)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_p);
                    } else if (value3 == 1 && value2 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_p);
                    } else if (value3 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_p);
                    } else if (value2 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_p);
                    }
                    break;
                case 21:
                    ActivityAirControl.this.clearWindBack();
                    switch (DataCanbus.DATA[21]) {
                        case 1:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            break;
                        case 2:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            break;
                        case 3:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            break;
                        case 4:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            break;
                        case 5:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            break;
                        case 6:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus12)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                            break;
                        case 7:
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus12)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.btn_plus13)).setBackgroundResource(R.drawable.ic_298_air_wind_7_p);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_298_air_control);
        mInstance = this;
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
    }

    private void addNotify() {
        if ((DataCanbus.DATA[1000] & 65535) == 321) {
            DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeNotify() {
        if ((DataCanbus.DATA[1000] & 65535) == 321) {
            DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        } else {
            DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if ((DataCanbus.DATA[1000] & 65535) == 321) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427419 */:
                    DataCanbus.PROXY.cmd(107, new int[]{2, 1}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427423 */:
                    DataCanbus.PROXY.cmd(107, new int[]{2, 0}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427427 */:
                    DataCanbus.PROXY.cmd(107, new int[]{9, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{9, 0}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427428 */:
                    DataCanbus.PROXY.cmd(107, new int[]{24, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{24, 0}, null, null);
                    break;
                case R.id.btn_plus5 /* 2131427429 */:
                    DataCanbus.PROXY.cmd(107, new int[]{10, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{10, 0}, null, null);
                    break;
                case R.id.btn_plus6 /* 2131427430 */:
                    DataCanbus.PROXY.cmd(107, new int[]{23, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{23, 0}, null, null);
                    break;
                case R.id.btn_plus7 /* 2131427431 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 1}, null, null);
                    break;
                case R.id.btn_plus8 /* 2131427432 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 2}, null, null);
                    break;
                case R.id.btn_plus9 /* 2131427433 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 3}, null, null);
                    break;
                case R.id.btn_plus10 /* 2131427434 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 4}, null, null);
                    break;
                case R.id.btn_plus11 /* 2131427435 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 5}, null, null);
                    break;
                case R.id.btn_plus12 /* 2131427436 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 6}, null, null);
                    break;
                case R.id.btn_plus13 /* 2131427437 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 7}, null, null);
                    break;
            }
        }
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 1);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 2);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 3);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 4);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 5);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 6);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 1);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 2);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 3);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 4);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 5);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 6);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModeBack() {
        ((Button) findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_n);
        ((Button) findViewById(R.id.btn_plus6)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_n);
        ((Button) findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_n);
        ((Button) findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWindBack() {
        ((Button) findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_298_air_wind_1_n);
        ((Button) findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_298_air_wind_2_n);
        ((Button) findViewById(R.id.btn_plus9)).setBackgroundResource(R.drawable.ic_298_air_wind_3_n);
        ((Button) findViewById(R.id.btn_plus10)).setBackgroundResource(R.drawable.ic_298_air_wind_4_n);
        ((Button) findViewById(R.id.btn_plus11)).setBackgroundResource(R.drawable.ic_298_air_wind_5_n);
        ((Button) findViewById(R.id.btn_plus12)).setBackgroundResource(R.drawable.ic_298_air_wind_6_n);
        ((Button) findViewById(R.id.btn_plus13)).setBackgroundResource(R.drawable.ic_298_air_wind_7_n);
    }
}
