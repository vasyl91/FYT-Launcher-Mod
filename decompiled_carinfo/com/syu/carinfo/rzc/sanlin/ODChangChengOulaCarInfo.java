package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODChangChengOulaCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("3s");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("10s");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("20s");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("30s");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("3s");
                            break;
                    }
                case 100:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("60s");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("120s");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("180s");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                    }
                case 101:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("10min");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("20min");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("30min");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("10min");
                            break;
                    }
                case 102:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf((value * 100) / 250) + "%");
                    break;
                case 103:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量正常");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量充足");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量低");
                            break;
                    }
                case 104:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 64) + "km");
                    break;
                case 105:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_normal);
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                            break;
                    }
                case 106:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + "km/kWh");
                    break;
                case 107:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + "km/kWh");
                    break;
                case 108:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "kW");
                    break;
                case 109:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆预充电加热");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆边充电边加热");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆正常充电");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("能量回收");
                            break;
                        case 5:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("就绪");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("正常行驶");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_changcheng_oula_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 1) {
                    value = 4;
                }
                setCarInfo(4, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                setCarInfo(4, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarInfo(5, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarInfo(5, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 1) {
                    value5 = 3;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 3) {
                    value6 = 1;
                }
                setCarInfo(6, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[105] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(48, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[105] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(48, value8, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
