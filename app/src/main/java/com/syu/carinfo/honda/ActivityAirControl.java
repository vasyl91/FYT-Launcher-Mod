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

public class ActivityAirControl extends Activity implements View.OnClickListener {
    public static ActivityAirControl mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 262465) {
                switch (updateCode) {
                    case 11:
                        if (DataCanbus.DATA[11] == 0) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.ac_off)).setBackgroundResource(R.drawable.ic_298_air_ac_off_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.ac_on)).setBackgroundResource(R.drawable.ic_298_air_ac_on_n);
                            break;
                        } else {
                            ((Button) ActivityAirControl.this.findViewById(R.id.ac_off)).setBackgroundResource(R.drawable.ic_298_air_ac_off_n);
                            ((Button) ActivityAirControl.this.findViewById(R.id.ac_on)).setBackgroundResource(R.drawable.ic_298_air_ac_on_p);
                            break;
                        }
                    case 21:
                        ActivityAirControl.this.clearWindBack();
                        switch (DataCanbus.DATA[21]) {
                            case 1:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                break;
                            case 2:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                break;
                            case 3:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                break;
                            case 4:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                break;
                            case 5:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                break;
                            case 6:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_6)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                                break;
                            case 7:
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_6)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                                ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_7)).setBackgroundResource(R.drawable.ic_298_air_wind_7_p);
                                break;
                        }
                    case 77:
                        ActivityAirControl.this.clearModeBack();
                        if (DataCanbus.DATA[77] == 4) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_up_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_p);
                            break;
                        } else if (DataCanbus.DATA[77] == 5) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_body_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_p);
                            break;
                        } else if (DataCanbus.DATA[77] == 3) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_p);
                            break;
                        } else if (DataCanbus.DATA[77] == 6) {
                            ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_body)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_p);
                            break;
                        }
                }
            }
            switch (updateCode) {
                case 11:
                    if (DataCanbus.DATA[11] == 0) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.ac_off)).setBackgroundResource(R.drawable.ic_298_air_ac_off_p);
                        ((Button) ActivityAirControl.this.findViewById(R.id.ac_on)).setBackgroundResource(R.drawable.ic_298_air_ac_on_n);
                        break;
                    } else {
                        ((Button) ActivityAirControl.this.findViewById(R.id.ac_off)).setBackgroundResource(R.drawable.ic_298_air_ac_off_n);
                        ((Button) ActivityAirControl.this.findViewById(R.id.ac_on)).setBackgroundResource(R.drawable.ic_298_air_ac_on_p);
                        break;
                    }
                case 18:
                case 19:
                case 20:
                    ActivityAirControl.this.clearModeBack();
                    int value1 = DataCanbus.DATA[18];
                    int value2 = DataCanbus.DATA[19];
                    int value3 = DataCanbus.DATA[20];
                    if (value3 == 1 && value1 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_up_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_p);
                        break;
                    } else if (value3 == 1 && value2 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_body_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_p);
                        break;
                    } else if (value3 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_p);
                        break;
                    } else if (value2 == 1) {
                        ((Button) ActivityAirControl.this.findViewById(R.id.blow_mode_body)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_p);
                        break;
                    }
                case 21:
                    ActivityAirControl.this.clearWindBack();
                    switch (DataCanbus.DATA[21]) {
                        case 1:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            break;
                        case 2:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            break;
                        case 3:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            break;
                        case 4:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            break;
                        case 5:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            break;
                        case 6:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_6)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                            break;
                        case 7:
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_6)).setBackgroundResource(R.drawable.ic_298_air_wind_6_p);
                            ((Button) ActivityAirControl.this.findViewById(R.id.wind_modle_7)).setBackgroundResource(R.drawable.ic_298_air_wind_7_p);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_298_air_control);
        mInstance = this;
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.ac_on)).setOnClickListener(this);
        ((Button) findViewById(R.id.ac_off)).setOnClickListener(this);
        ((Button) findViewById(R.id.blow_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.blow_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.blow_mode_body_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.blow_mode_up_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_1)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_2)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_3)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_4)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_5)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_6)).setOnClickListener(this);
        ((Button) findViewById(R.id.wind_modle_7)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
    }

    @Override
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

    @Override
    public void onClick(View v) {
        if ((DataCanbus.DATA[1000] & 65535) == 321) {
            switch (v.getId()) {
                case R.id.ac_on /* 2131429130 */:
                    DataCanbus.PROXY.cmd(107, new int[]{2, 1}, null, null);
                    break;
                case R.id.ac_off /* 2131429131 */:
                    DataCanbus.PROXY.cmd(107, new int[]{2}, null, null);
                    break;
                case R.id.blow_mode_body /* 2131429132 */:
                    DataCanbus.PROXY.cmd(107, new int[]{9, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{9}, null, null);
                    break;
                case R.id.blow_mode_body_foot /* 2131429133 */:
                    DataCanbus.PROXY.cmd(107, new int[]{24, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{24}, null, null);
                    break;
                case R.id.blow_mode_foot /* 2131429134 */:
                    DataCanbus.PROXY.cmd(107, new int[]{10, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{10}, null, null);
                    break;
                case R.id.blow_mode_up_foot /* 2131429135 */:
                    DataCanbus.PROXY.cmd(107, new int[]{23, 1}, null, null);
                    DataCanbus.PROXY.cmd(107, new int[]{23}, null, null);
                    break;
                case R.id.wind_modle_1 /* 2131429136 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 1}, null, null);
                    break;
                case R.id.wind_modle_2 /* 2131429137 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 2}, null, null);
                    break;
                case R.id.wind_modle_3 /* 2131429138 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 3}, null, null);
                    break;
                case R.id.wind_modle_4 /* 2131429139 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 4}, null, null);
                    break;
                case R.id.wind_modle_5 /* 2131429140 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 5}, null, null);
                    break;
                case R.id.wind_modle_6 /* 2131429141 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 6}, null, null);
                    break;
                case R.id.wind_modle_7 /* 2131429142 */:
                    DataCanbus.PROXY.cmd(107, new int[]{25, 7}, null, null);
                    break;
            }
        }
        switch (v.getId()) {
            case R.id.ac_on /* 2131429130 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 1);
                break;
            case R.id.ac_off /* 2131429131 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 2);
                break;
            case R.id.blow_mode_body /* 2131429132 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 3);
                break;
            case R.id.blow_mode_body_foot /* 2131429133 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 4);
                break;
            case R.id.blow_mode_foot /* 2131429134 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 5);
                break;
            case R.id.blow_mode_up_foot /* 2131429135 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(172, 6);
                break;
            case R.id.wind_modle_1 /* 2131429136 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 1);
                break;
            case R.id.wind_modle_2 /* 2131429137 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 2);
                break;
            case R.id.wind_modle_3 /* 2131429138 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 3);
                break;
            case R.id.wind_modle_4 /* 2131429139 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 4);
                break;
            case R.id.wind_modle_5 /* 2131429140 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 5);
                break;
            case R.id.wind_modle_6 /* 2131429141 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 6);
                break;
            case R.id.wind_modle_7 /* 2131429142 */:
                Callback_0298_XP1_2015SIYU_CRV.setCarInfo(173, 7);
                break;
        }
    }

    
    public void clearModeBack() {
        ((Button) findViewById(R.id.blow_mode_body)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_n);
        ((Button) findViewById(R.id.blow_mode_up_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_up_foot_n);
        ((Button) findViewById(R.id.blow_mode_body_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_body_foot_n);
        ((Button) findViewById(R.id.blow_mode_foot)).setBackgroundResource(R.drawable.ic_298_air_blow_mode_foot_n);
    }

    
    public void clearWindBack() {
        ((Button) findViewById(R.id.wind_modle_1)).setBackgroundResource(R.drawable.ic_298_air_wind_1_n);
        ((Button) findViewById(R.id.wind_modle_2)).setBackgroundResource(R.drawable.ic_298_air_wind_2_n);
        ((Button) findViewById(R.id.wind_modle_3)).setBackgroundResource(R.drawable.ic_298_air_wind_3_n);
        ((Button) findViewById(R.id.wind_modle_4)).setBackgroundResource(R.drawable.ic_298_air_wind_4_n);
        ((Button) findViewById(R.id.wind_modle_5)).setBackgroundResource(R.drawable.ic_298_air_wind_5_n);
        ((Button) findViewById(R.id.wind_modle_6)).setBackgroundResource(R.drawable.ic_298_air_wind_6_n);
        ((Button) findViewById(R.id.wind_modle_7)).setBackgroundResource(R.drawable.ic_298_air_wind_7_n);
    }
}
