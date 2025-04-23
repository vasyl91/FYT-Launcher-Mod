package com.syu.carinfo.rzc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActGS4ChargingSetting extends BaseActivity implements View.OnClickListener {
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    ActGS4ChargingSetting.this.updateChargingTimeStartMinute();
                    ActGS4ChargingSetting.this.updateChargingTimeStartHour();
                    break;
                case 137:
                    ActGS4ChargingSetting.this.updateChargingTimeEndMinute();
                    ActGS4ChargingSetting.this.updateChargingTimeEndHour();
                    break;
                case 138:
                    ActGS4ChargingSetting.this.updateChargingRepeat();
                    break;
                case 139:
                    ActGS4ChargingSetting.this.updateChargingRepeat1();
                    break;
                case 140:
                    ActGS4ChargingSetting.this.updateChargingRepeat2();
                    break;
                case 141:
                    ActGS4ChargingSetting.this.updateChargingRepeat3();
                    break;
                case 142:
                    ActGS4ChargingSetting.this.updateChargingRepeat4();
                    break;
                case 143:
                    ActGS4ChargingSetting.this.updateChargingRepeat5();
                    break;
                case 144:
                    ActGS4ChargingSetting.this.updateChargingRepeat6();
                    break;
                case 145:
                    ActGS4ChargingSetting.this.updateChargingRepeat7();
                    break;
                case 147:
                    ActGS4ChargingSetting.this.updateElectricitylow();
                    break;
                case 148:
                    ActGS4ChargingSetting.this.updateEnergylow();
                    break;
                case 149:
                case 207:
                    ActGS4ChargingSetting.this.updateEnergyLevel();
                    break;
                case 150:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 177:
                    switch (value) {
                        case 0:
                            ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text9)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text9)).setText("Normal");
                            break;
                    }
                case 178:
                case 208:
                    ActGS4ChargingSetting.this.updateDianchibaowen();
                    break;
                case 204:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 205:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 206:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzc_gs4_charging_setting);
        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(48);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 2228504) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(8);
            return;
        }
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(0);
    }

    public static void C_CHARGING_CMD(int data1, int data2, int data3, int data4, int data5) {
        int cmd = (((data2 & 31) << 6) | (data1 & 63)) & 32767;
        int cmd2 = (((data4 & 31) << 6) | (data3 & 63)) & 32767;
        DataCanbus.PROXY.cmd(4, new int[]{2, (cmd >> 8) & 255, cmd & 255, (cmd2 >> 8) & 255, cmd2 & 255, data5}, null, null);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (this.value1 > 0) {
                    this.value1--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                if (this.value1 < 59) {
                    this.value1++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                if (this.value2 > 0) {
                    this.value2--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                if (this.value2 < 23) {
                    this.value2++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (this.value3 > 0) {
                    this.value3--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (this.value3 < 59) {
                    this.value3++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                if (this.value4 > 0) {
                    this.value4--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                if (this.value4 < 23) {
                    this.value4++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[149];
                if (DataCanbus.DATA[1000] == 2228504) {
                    value7 = DataCanbus.DATA[207];
                }
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[149];
                if (DataCanbus.DATA[1000] == 2228504) {
                    value8 = DataCanbus.DATA[207];
                    if (value8 < 3) {
                        value8++;
                    }
                } else if (value8 < 2) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value8}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[177];
                if (value9 == 0) {
                    value6 = 2;
                } else {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value6}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[177];
                if (value10 == 0) {
                    value5 = 2;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value5}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[178];
                if (DataCanbus.DATA[1000] == 2228504) {
                    int value12 = DataCanbus.DATA[208];
                    if (value12 > 0) {
                        value12--;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{8, value12}, null, null);
                    break;
                } else {
                    int value13 = value11 - 1;
                    if (value13 < 1) {
                        value13 = 15;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{6, value13}, null, null);
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[178];
                if (DataCanbus.DATA[1000] == 2228504) {
                    int value15 = DataCanbus.DATA[208];
                    if (value15 < 12) {
                        value15++;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{8, value15}, null, null);
                    break;
                } else {
                    int value16 = value14 + 1;
                    if (value16 > 15) {
                        value16 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{6, value16}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (((this.value5 >> 0) & 1) == 1) {
                    this.value5 &= 254;
                } else if (((this.value5 >> 0) & 1) == 0) {
                    this.value5 |= 1;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (((this.value5 >> 1) & 1) == 1) {
                    this.value5 &= 253;
                } else if (((this.value5 >> 1) & 1) == 0) {
                    this.value5 |= 2;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (((this.value5 >> 2) & 1) == 1) {
                    this.value5 &= 251;
                } else if (((this.value5 >> 2) & 1) == 0) {
                    this.value5 |= 4;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (((this.value5 >> 3) & 1) == 1) {
                    this.value5 &= 247;
                } else if (((this.value5 >> 3) & 1) == 0) {
                    this.value5 |= 8;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (((this.value5 >> 4) & 1) == 1) {
                    this.value5 &= 239;
                } else if (((this.value5 >> 4) & 1) == 0) {
                    this.value5 |= 16;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (((this.value5 >> 5) & 1) == 1) {
                    this.value5 &= 223;
                } else if (((this.value5 >> 5) & 1) == 0) {
                    this.value5 |= 32;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (((this.value5 >> 6) & 1) == 1) {
                    this.value5 &= 191;
                } else if (((this.value5 >> 6) & 1) == 0) {
                    this.value5 |= 64;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (((this.value5 >> 7) & 1) == 1) {
                    this.value5 &= 127;
                } else if (((this.value5 >> 7) & 1) == 0) {
                    this.value5 |= 128;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                DataCanbus.PROXY.cmd(4, new int[]{1, 1}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value17 = DataCanbus.DATA[150];
                if (value17 == 1) {
                    value4 = 2;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value4}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value18 = DataCanbus.DATA[204];
                if (value18 == 1) {
                    value3 = 2;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value3}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value19 = DataCanbus.DATA[205];
                if (value19 == 1) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value2}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value20 = DataCanbus.DATA[206];
                if (value20 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{7, value}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.notifyCanbus);
    }

    
    public void updateDianchibaowen() {
        int value = DataCanbus.DATA[178];
        if (DataCanbus.DATA[1000] == 2228504) {
            int value2 = DataCanbus.DATA[208];
            switch (value2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.off);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value2) + "H");
                    break;
            }
        }
        switch (value) {
            case 0:
            case 15:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.off);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "H");
                break;
        }
    }

    
    public void updateEnergyLevel() {
        int value = DataCanbus.DATA[149];
        if (DataCanbus.DATA[1000] == 2228504) {
            int value2 = DataCanbus.DATA[207];
            String str = getString(R.string.off);
            switch (value2) {
                case 0:
                    str = getString(R.string.off);
                    break;
                case 1:
                    str = getString(R.string.klc_air_low);
                    break;
                case 2:
                    str = getString(R.string.klc_air_middle);
                    break;
                case 3:
                    str = getString(R.string.klc_air_high);
                    break;
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(str);
            return;
        }
        String str2 = getString(R.string.off);
        switch (value) {
            case 0:
                str2 = getString(R.string.off);
                break;
            case 1:
                str2 = getString(R.string.klc_air_low);
                break;
            case 2:
                str2 = getString(R.string.klc_air_high);
                break;
        }
        ((TextView) findViewById(R.id.tv_text8)).setText(str2);
    }

    
    public void updateEnergylow() {
        int value = DataCanbus.DATA[148];
        ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateElectricitylow() {
        int value = DataCanbus.DATA[147];
        ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateChargingRepeat1() {
        int value = DataCanbus.DATA[139];
        this.value5 |= (value & 1) << 1;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat2() {
        int value = DataCanbus.DATA[140];
        this.value5 |= (value & 1) << 2;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat3() {
        int value = DataCanbus.DATA[141];
        this.value5 |= (value & 1) << 3;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat4() {
        int value = DataCanbus.DATA[142];
        this.value5 |= (value & 1) << 4;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat5() {
        int value = DataCanbus.DATA[143];
        this.value5 |= (value & 1) << 5;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat6() {
        int value = DataCanbus.DATA[144];
        this.value5 |= (value & 1) << 6;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat7() {
        int value = DataCanbus.DATA[145];
        this.value5 |= (value & 1) << 7;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
    }

    
    public void updateChargingRepeat() {
        int value = DataCanbus.DATA[138];
        String str = getString(R.string.str_car_cd_repeat);
        switch (value) {
            case 0:
                str = getString(R.string.str_car_cd_repeat);
                break;
            case 1:
                str = getString(R.string.str_165_cycle_one);
                break;
        }
        this.value5 |= (value & 1) << 0;
        ((TextView) findViewById(R.id.tv_text5)).setText(str);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    
    public void updateChargingTimeStartMinute() {
        int value = DataCanbus.DATA[136] & 63;
        this.value1 = value;
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateChargingTimeStartHour() {
        int value = (DataCanbus.DATA[136] >> 6) & 31;
        this.value2 = value;
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateChargingTimeEndMinute() {
        int value = DataCanbus.DATA[137] & 63;
        this.value3 = value;
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateChargingTimeEndHour() {
        int value = (DataCanbus.DATA[137] >> 6) & 31;
        this.value4 = value;
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
    }
}
