package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Sbd_Settings_Battery_Status extends BaseActivity {
    public int[] lang_id = {R.string.str_313_single_voltage_difference, R.string.str_313_SOC_transition, R.string.str_313_SOC_too_high, R.string.str_313_temperature_difference_too_large, R.string.str_313_total_pressure_too_low, R.string.str_313_total_pressure_too_high, R.string.str_313_temperature_difference_alarm, R.string.str_313_battery_pack_high_temperature_alarm, R.string.str_313_energy_storage_device_overvoltage_alarm, R.string.str_313_energy_storage_devic_undervoltage_alarm, R.string.str_313_SOC_low_alarm, R.string.str_313_single_battery_overvoltage_alarm, R.string.str_313_single_battery_undervoltage_alarm, R.string.str_313_SOC_too_high_alarm, R.string.str_313_SOC_jump_alarm, R.string.str_313_rechargeable_energy_storage_not_match_alarm_level, R.string.str_313_poor_battery_uniformity_alarm, R.string.str_313_insulation_alarm, R.string.str_313_high_voltage_interlocking_state, R.string.str_313_rechargeable_energy_storage_not_match_alarm, R.string.str_313_battery_low_temperature_alarm, R.string.str_313_positive_to_ground_insulation_resistance, R.string.str_313_negative_end_to_ground_insulation_resistance, R.string.str_313Battery_charge_status};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Sbd_Settings_Battery_Status.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow1();
                    break;
                case 114:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow2();
                    break;
                case 115:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow3();
                    break;
                case 116:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow4();
                    break;
                case 117:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow5();
                    break;
                case 118:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow6();
                    break;
                case 119:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow7();
                    break;
                case 120:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow8();
                    break;
                case 121:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow9();
                    break;
                case 122:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow10();
                    break;
                case 123:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow11();
                    break;
                case 124:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow12();
                    break;
                case 125:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow13();
                    break;
                case 126:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow14();
                    break;
                case 127:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow15();
                    break;
                case 128:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow16();
                    break;
                case 129:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow17();
                    break;
                case 130:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow18();
                    break;
                case 131:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow19();
                    break;
                case 132:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow20();
                    break;
                case 133:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow21();
                    break;
                case 134:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow22();
                    break;
                case 135:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow23();
                    break;
                case 137:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow24();
                    break;
                case 182:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow25(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 183:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow26(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 184:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow27(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 185:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow28(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 186:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow29(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 187:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow30(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 188:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow31(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 189:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow32(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 190:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow33(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 191:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow34(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 192:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow35(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 193:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow36(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 194:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow37(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 195:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow38(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 196:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow39(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 197:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow40(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 198:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow41(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 199:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow42(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 200:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow43(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 201:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow44(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 202:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow45(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 203:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow46(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 204:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow47(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 205:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow48(Sbd_Settings_Battery_Status.this.val);
                    break;
            }
        }
    };
    int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_battery);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.Sbd_313_battery1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery1)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery1bstr)) + getString(R.string.setting_313_battery100bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery1)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery1bstr)) + getString(R.string.setting_313_battery110bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.Sbd_313_battery2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery2)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery2bstr)) + getString(R.string.setting_313_battery200bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery2)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery2bstr)) + getString(R.string.setting_313_battery210bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.Sbd_313_battery3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery3)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery3bstr)) + getString(R.string.setting_313_charge12bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery3)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery3bstr)) + getString(R.string.setting_313_battery31bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.Sbd_313_battery4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery4)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery4bstr)) + getString(R.string.setting_313_battery40bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery4)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery4bstr)) + getString(R.string.setting_313_battery41bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.Sbd_313_battery5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery5)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery5bstr)) + getString(R.string.setting_313_tv61str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery5)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery5bstr)) + getString(R.string.setting_313_tv62str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.Sbd_313_battery6)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery6)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery6bstr)) + (value / 10.0f) + "V", new Object[0]));
        }
    }

    
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.Sbd_313_battery7)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery7)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery7bstr)) + (value / 10.0f) + "A", new Object[0]));
        }
    }

    
    public void mUpdatersetshow8() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.Sbd_313_battery8)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery8)).setText(String.valueOf(getString(R.string.setting_313_battery8bstr)) + value + "%");
        }
    }

    
    public void mUpdatersetshow9() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.Sbd_313_battery9)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery9)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery9bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery9)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery9bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow10() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.Sbd_313_battery10)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery10)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery10bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery10)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery10bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow11() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.Sbd_313_battery11)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery11)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery11bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery11)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery11bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow12() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.Sbd_313_battery12)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery12)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery12bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery12)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery12bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow13() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.Sbd_313_battery13)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery13)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery13bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery13)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery13bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow14() {
        int value = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.Sbd_313_battery14)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery14)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery14bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery14)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery14bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow15() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.Sbd_313_battery15)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery15)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery15bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery15)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery15bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow16() {
        int value = DataCanbus.DATA[128];
        if (((TextView) findViewById(R.id.Sbd_313_battery16)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery16)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery16bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery16)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery16bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow17() {
        int value = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.Sbd_313_battery17)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery17)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery17bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery17)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery17bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow18() {
        int value = DataCanbus.DATA[130];
        if (((TextView) findViewById(R.id.Sbd_313_battery18)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery18)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery18bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery18)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery18bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow19() {
        int value = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.Sbd_313_battery19)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery19)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery19bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery19)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery19bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow20() {
        int value = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.Sbd_313_battery20)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery20)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery20bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery20)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery20bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow21() {
        int value = DataCanbus.DATA[133];
        if (((TextView) findViewById(R.id.Sbd_313_battery21)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery21)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery21bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery21)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery21bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow22() {
        int value = DataCanbus.DATA[134];
        if (((TextView) findViewById(R.id.Sbd_313_battery22)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery22)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery22bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery22)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery22bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow23() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.Sbd_313_battery23)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery23)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery23bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery23)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery23bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow24() {
        int value = DataCanbus.DATA[137];
        if (((TextView) findViewById(R.id.Sbd_313_battery24)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery24)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery24bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery24)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery24bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow25(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery25)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery25)).setText(String.format(String.valueOf(getString(this.lang_id[0])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery25)).setText(String.format(String.valueOf(getString(this.lang_id[0])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow26(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery26)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery26)).setText(String.format(String.valueOf(getString(this.lang_id[1])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery26)).setText(String.format(String.valueOf(getString(this.lang_id[1])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow27(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery27)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery27)).setText(String.format(String.valueOf(getString(this.lang_id[2])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery27)).setText(String.format(String.valueOf(getString(this.lang_id[2])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow28(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery28)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery28)).setText(String.format(String.valueOf(getString(this.lang_id[3])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery28)).setText(String.format(String.valueOf(getString(this.lang_id[3])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow29(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery29)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery29)).setText(String.format(String.valueOf(getString(this.lang_id[4])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery29)).setText(String.format(String.valueOf(getString(this.lang_id[4])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow30(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery30)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery30)).setText(String.format(String.valueOf(getString(this.lang_id[5])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery30)).setText(String.format(String.valueOf(getString(this.lang_id[5])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow31(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery31)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery31)).setText(String.format(String.valueOf(getString(this.lang_id[6])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery31)).setText(String.format(String.valueOf(getString(this.lang_id[6])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery31)).setText(String.format(String.valueOf(getString(this.lang_id[6])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery31)).setText(String.format(String.valueOf(getString(this.lang_id[6])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow32(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery32)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery32)).setText(String.format(String.valueOf(getString(this.lang_id[7])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery32)).setText(String.format(String.valueOf(getString(this.lang_id[7])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery32)).setText(String.format(String.valueOf(getString(this.lang_id[7])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery32)).setText(String.format(String.valueOf(getString(this.lang_id[7])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow33(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery33)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery33)).setText(String.format(String.valueOf(getString(this.lang_id[8])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery33)).setText(String.format(String.valueOf(getString(this.lang_id[8])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery33)).setText(String.format(String.valueOf(getString(this.lang_id[8])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery33)).setText(String.format(String.valueOf(getString(this.lang_id[8])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow34(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery34)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery34)).setText(String.format(String.valueOf(getString(this.lang_id[9])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery34)).setText(String.format(String.valueOf(getString(this.lang_id[9])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery34)).setText(String.format(String.valueOf(getString(this.lang_id[9])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery34)).setText(String.format(String.valueOf(getString(this.lang_id[9])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow35(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery35)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery35)).setText(String.format(String.valueOf(getString(this.lang_id[10])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery35)).setText(String.format(String.valueOf(getString(this.lang_id[10])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery35)).setText(String.format(String.valueOf(getString(this.lang_id[10])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery35)).setText(String.format(String.valueOf(getString(this.lang_id[10])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow36(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery36)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery36)).setText(String.format(String.valueOf(getString(this.lang_id[11])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery36)).setText(String.format(String.valueOf(getString(this.lang_id[11])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery36)).setText(String.format(String.valueOf(getString(this.lang_id[11])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery36)).setText(String.format(String.valueOf(getString(this.lang_id[11])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow37(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery37)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery37)).setText(String.format(String.valueOf(getString(this.lang_id[12])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery37)).setText(String.format(String.valueOf(getString(this.lang_id[12])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery37)).setText(String.format(String.valueOf(getString(this.lang_id[12])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery37)).setText(String.format(String.valueOf(getString(this.lang_id[12])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow38(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery38)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery38)).setText(String.format(String.valueOf(getString(this.lang_id[13])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery38)).setText(String.format(String.valueOf(getString(this.lang_id[13])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery38)).setText(String.format(String.valueOf(getString(this.lang_id[13])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery38)).setText(String.format(String.valueOf(getString(this.lang_id[13])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow39(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery39)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery39)).setText(String.format(String.valueOf(getString(this.lang_id[14])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery39)).setText(String.format(String.valueOf(getString(this.lang_id[14])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery39)).setText(String.format(String.valueOf(getString(this.lang_id[14])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery39)).setText(String.format(String.valueOf(getString(this.lang_id[14])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow40(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery40)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery40)).setText(String.format(String.valueOf(getString(this.lang_id[15])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery40)).setText(String.format(String.valueOf(getString(this.lang_id[15])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery40)).setText(String.format(String.valueOf(getString(this.lang_id[15])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery40)).setText(String.format(String.valueOf(getString(this.lang_id[15])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow41(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery41)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery41)).setText(String.format(String.valueOf(getString(this.lang_id[16])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery41)).setText(String.format(String.valueOf(getString(this.lang_id[16])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery41)).setText(String.format(String.valueOf(getString(this.lang_id[16])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery41)).setText(String.format(String.valueOf(getString(this.lang_id[16])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow42(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery42)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery42)).setText(String.format(String.valueOf(getString(this.lang_id[17])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery42)).setText(String.format(String.valueOf(getString(this.lang_id[17])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery42)).setText(String.format(String.valueOf(getString(this.lang_id[17])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery42)).setText(String.format(String.valueOf(getString(this.lang_id[17])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow43(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery43)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery43)).setText(String.format(String.valueOf(getString(this.lang_id[18])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery43)).setText(String.format(String.valueOf(getString(this.lang_id[18])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow44(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery44)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery44)).setText(String.format(String.valueOf(getString(this.lang_id[19])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery44)).setText(String.format(String.valueOf(getString(this.lang_id[19])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow45(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery45)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery45)).setText(String.format(String.valueOf(getString(this.lang_id[20])) + getString(R.string.normal), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery45)).setText(String.format(String.valueOf(getString(this.lang_id[20])) + getString(R.string.str_313_level_one), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery45)).setText(String.format(String.valueOf(getString(this.lang_id[20])) + getString(R.string.str_313_level_two), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery45)).setText(String.format(String.valueOf(getString(this.lang_id[20])) + getString(R.string.str_313_level_three), new Object[0]));
                    break;
            }
        }
    }

    
    public void mUpdatersetshow46(int val) {
        ((TextView) findViewById(R.id.Sbd_313_battery46)).setText(String.valueOf(getString(this.lang_id[21])) + val + "K/Bit");
    }

    
    public void mUpdatersetshow47(int val) {
        ((TextView) findViewById(R.id.Sbd_313_battery47)).setText(String.valueOf(getString(this.lang_id[22])) + val + "K/Bit");
    }

    
    public void mUpdatersetshow48(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery48)) != null) {
            switch (val) {
                case 0:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.str_313_not_charged), new Object[0]));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.str_313_parking_charge), new Object[0]));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.str_313_driving_charge), new Object[0]));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.jeep_playstate11), new Object[0]));
                    break;
                case 4:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.setting_313_tv51str), new Object[0]));
                    break;
                case 5:
                    ((TextView) findViewById(R.id.Sbd_313_battery48)).setText(String.format(String.valueOf(getString(this.lang_id[23])) + getString(R.string.str_313_finished_charging), new Object[0]));
                    break;
            }
        }
    }
}
