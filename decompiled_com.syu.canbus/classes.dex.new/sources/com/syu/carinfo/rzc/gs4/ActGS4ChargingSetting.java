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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActGS4ChargingSetting extends BaseActivity implements View.OnClickListener {
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.gs4.ActGS4ChargingSetting.1
        @Override // com.syu.module.IUiNotify
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
                    break;
                case 178:
                case 208:
                    ActGS4ChargingSetting.this.updateDianchibaowen();
                    break;
                case 204:
                case 211:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 205:
                case 209:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 206:
                case 210:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 212:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 213:
                    switch (value) {
                        case 0:
                            ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text11)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text11)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text11)).setText("Sport");
                            break;
                    }
                    break;
                case 214:
                    ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "%");
                    break;
                case 215:
                    ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text14)).setText(String.valueOf((value * 5) + 45) + "%");
                    break;
                case 216:
                    ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "%");
                    break;
                case 217:
                    ((TextView) ActGS4ChargingSetting.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value * 25) + "km");
                    break;
                case 220:
                    ((CheckedTextView) ActGS4ChargingSetting.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_gs4_charging_setting);
        setListener();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(48);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
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
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2359576 || DataCanbus.DATA[1000] == 2490648) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 2556184) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 2425112) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 2359576 || DataCanbus.DATA[1000] == 2490648) {
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
        } else {
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 2425112) {
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
            return;
        }
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
    }

    public static void C_CHARGING_CMD(int data1, int data2, int data3, int data4, int data5) {
        int cmd = (((data2 & 31) << 6) | (data1 & 63)) & 32767;
        int cmd2 = (((data4 & 31) << 6) | (data3 & 63)) & 32767;
        DataCanbus.PROXY.cmd(4, new int[]{2, (cmd >> 8) & 255, cmd & 255, (cmd2 >> 8) & 255, cmd2 & 255, data5}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                if (this.value1 > 0) {
                    this.value1--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                if (this.value1 < 59) {
                    this.value1++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                if (this.value2 > 0) {
                    this.value2--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                if (this.value2 < 23) {
                    this.value2++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                if (this.value3 > 0) {
                    this.value3--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                if (this.value3 < 59) {
                    this.value3++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                if (this.value4 > 0) {
                    this.value4--;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                if (this.value4 < 23) {
                    this.value4++;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value12 = DataCanbus.DATA[149];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    value12 = DataCanbus.DATA[207];
                }
                if (value12 > 0) {
                    value12--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value13 = DataCanbus.DATA[149];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    value13 = DataCanbus.DATA[207];
                    if (value13 < 3) {
                        value13++;
                    }
                } else if (DataCanbus.DATA[1000] == 2359576 || DataCanbus.DATA[1000] == 2490648) {
                    if (value13 < 3) {
                        value13++;
                    }
                } else if (value13 < 2) {
                    value13++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value13}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value14 = DataCanbus.DATA[177];
                if (value14 == 0) {
                    value11 = 2;
                } else {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value11}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value15 = DataCanbus.DATA[177];
                if (value15 == 0) {
                    value10 = 2;
                } else {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value10}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value16 = DataCanbus.DATA[178];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    int value17 = DataCanbus.DATA[208];
                    if (value17 > 0) {
                        value17--;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{8, value17}, null, null);
                } else {
                    int value18 = value16 - 1;
                    if (value18 < 1) {
                        value18 = 15;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{6, value18}, null, null);
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value19 = DataCanbus.DATA[178];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    int value20 = DataCanbus.DATA[208];
                    if (value20 < 12) {
                        value20++;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{8, value20}, null, null);
                } else {
                    int value21 = value19 + 1;
                    if (value21 > 15) {
                        value21 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{6, value21}, null, null);
                }
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value22 = DataCanbus.DATA[213] + 1;
                int value23 = value22 - 1;
                if (value23 < 1) {
                    value23 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value23}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value24 = DataCanbus.DATA[213] + 1;
                int value25 = value24 + 1;
                if (value25 > 3) {
                    value25 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value25}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value26 = DataCanbus.DATA[215];
                int value27 = value26 - 1;
                if (value27 < 1) {
                    value27 = 11;
                }
                DataCanbus.PROXY.cmd(4, new int[]{9, value27}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value28 = DataCanbus.DATA[215];
                int value29 = value28 + 1;
                if (value29 > 11) {
                    value29 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{9, value29}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value30 = DataCanbus.DATA[216];
                int value31 = value30 - 5;
                if (value31 < 20) {
                    value31 = 20;
                }
                DataCanbus.PROXY.cmd(4, new int[]{10, value31}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value32 = DataCanbus.DATA[216];
                int value33 = value32 + 5;
                if (value33 > 100) {
                    value33 = 100;
                }
                DataCanbus.PROXY.cmd(4, new int[]{10, value33}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (((this.value5 >> 0) & 1) == 1) {
                    this.value5 &= 254;
                } else if (((this.value5 >> 0) & 1) == 0) {
                    this.value5 |= 1;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (((this.value5 >> 3) & 1) == 1) {
                    this.value5 &= 247;
                } else if (((this.value5 >> 3) & 1) == 0) {
                    this.value5 |= 8;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (((this.value5 >> 4) & 1) == 1) {
                    this.value5 &= 239;
                } else if (((this.value5 >> 4) & 1) == 0) {
                    this.value5 |= 16;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (((this.value5 >> 1) & 1) == 1) {
                    this.value5 &= 253;
                } else if (((this.value5 >> 1) & 1) == 0) {
                    this.value5 |= 2;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (((this.value5 >> 2) & 1) == 1) {
                    this.value5 &= 251;
                } else if (((this.value5 >> 2) & 1) == 0) {
                    this.value5 |= 4;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (((this.value5 >> 5) & 1) == 1) {
                    this.value5 &= 223;
                } else if (((this.value5 >> 5) & 1) == 0) {
                    this.value5 |= 32;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (((this.value5 >> 6) & 1) == 1) {
                    this.value5 &= 191;
                } else if (((this.value5 >> 6) & 1) == 0) {
                    this.value5 |= 64;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                if (((this.value5 >> 7) & 1) == 1) {
                    this.value5 &= 127;
                } else if (((this.value5 >> 7) & 1) == 0) {
                    this.value5 |= 128;
                }
                C_CHARGING_CMD(this.value1, this.value2, this.value3, this.value4, this.value5);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(4, new int[]{1, 1}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value34 = DataCanbus.DATA[150];
                if (value34 == 1) {
                    value9 = 2;
                } else {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value9}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value35 = DataCanbus.DATA[211];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    int value36 = DataCanbus.DATA[204];
                    if (value36 == 1) {
                        value7 = 2;
                    } else {
                        value7 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{5, value7}, null, null);
                } else {
                    if (value35 == 1) {
                        value8 = 2;
                    } else {
                        value8 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{11, value8}, null, null);
                }
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value37 = DataCanbus.DATA[209];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    int value38 = DataCanbus.DATA[205];
                    if (value38 == 1) {
                        value5 = 2;
                    } else {
                        value5 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{6, value5}, null, null);
                } else {
                    if (value37 == 1) {
                        value6 = 2;
                    } else {
                        value6 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{7, value6}, null, null);
                }
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value39 = DataCanbus.DATA[210];
                if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
                    int value40 = DataCanbus.DATA[206];
                    if (value40 == 1) {
                        value3 = 2;
                    } else {
                        value3 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{7, value3}, null, null);
                } else {
                    if (value39 == 1) {
                        value4 = 2;
                    } else {
                        value4 = 1;
                    }
                    DataCanbus.PROXY.cmd(4, new int[]{8, value4}, null, null);
                }
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value41 = DataCanbus.DATA[212];
                if (value41 == 1) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{12, value2}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value42 = DataCanbus.DATA[220];
                if (value42 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{9, value}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDianchibaowen() {
        int value = DataCanbus.DATA[178];
        if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergyLevel() {
        int value = DataCanbus.DATA[149];
        if (DataCanbus.DATA[1000] == 2228504 || DataCanbus.DATA[1000] == 2556184) {
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
            case 3:
                str2 = getString(R.string.klc_air_middle);
                break;
        }
        ((TextView) findViewById(R.id.tv_text8)).setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergylow() {
        int value = DataCanbus.DATA[148];
        ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateElectricitylow() {
        int value = DataCanbus.DATA[147];
        ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat1() {
        int value = DataCanbus.DATA[139];
        this.value5 |= (value & 1) << 1;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat2() {
        int value = DataCanbus.DATA[140];
        this.value5 |= (value & 1) << 2;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat3() {
        int value = DataCanbus.DATA[141];
        this.value5 |= (value & 1) << 3;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat4() {
        int value = DataCanbus.DATA[142];
        this.value5 |= (value & 1) << 4;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat5() {
        int value = DataCanbus.DATA[143];
        this.value5 |= (value & 1) << 5;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat6() {
        int value = DataCanbus.DATA[144];
        this.value5 |= (value & 1) << 6;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingRepeat7() {
        int value = DataCanbus.DATA[145];
        this.value5 |= (value & 1) << 7;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingTimeStartMinute() {
        int value = DataCanbus.DATA[136] & 63;
        this.value1 = value;
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingTimeStartHour() {
        int value = (DataCanbus.DATA[136] >> 6) & 31;
        this.value2 = value;
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingTimeEndMinute() {
        int value = DataCanbus.DATA[137] & 63;
        this.value3 = value;
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingTimeEndHour() {
        int value = (DataCanbus.DATA[137] >> 6) & 31;
        this.value4 = value;
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
    }
}
