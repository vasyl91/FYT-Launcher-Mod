package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings_Battery_Status extends BaseActivity {
    public int[] lang_id = {R.string.str_313_single_voltage_difference, R.string.str_313_SOC_transition, R.string.str_313_SOC_too_high, R.string.str_313_temperature_difference_too_large, R.string.str_313_total_pressure_too_low, R.string.str_313_total_pressure_too_high, R.string.str_313_temperature_difference_alarm, R.string.str_313_battery_pack_high_temperature_alarm, R.string.str_313_energy_storage_device_overvoltage_alarm, R.string.str_313_energy_storage_devic_undervoltage_alarm, R.string.str_313_SOC_low_alarm, R.string.str_313_single_battery_overvoltage_alarm, R.string.str_313_single_battery_undervoltage_alarm, R.string.str_313_SOC_too_high_alarm, R.string.str_313_SOC_jump_alarm, R.string.str_313_rechargeable_energy_storage_not_match_alarm_level, R.string.str_313_poor_battery_uniformity_alarm, R.string.str_313_insulation_alarm, R.string.str_313_high_voltage_interlocking_state, R.string.str_313_rechargeable_energy_storage_not_match_alarm, R.string.str_313_battery_low_temperature_alarm, R.string.str_313_positive_to_ground_insulation_resistance, R.string.str_313_negative_end_to_ground_insulation_resistance, R.string.str_313Battery_charge_status};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings_Battery_Status.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Sbd_Settings_Battery_Status.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow1();
                    break;
                case 17:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow2();
                    break;
                case 18:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow3();
                    break;
                case 19:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow4();
                    break;
                case 20:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow5();
                    break;
                case 21:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow6();
                    break;
                case 22:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow7();
                    break;
                case 23:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow8();
                    break;
                case 24:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow9();
                    break;
                case 25:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow10();
                    break;
                case 26:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow11();
                    break;
                case 27:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow12();
                    break;
                case 28:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow13();
                    break;
                case 29:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow14();
                    break;
                case 30:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow15();
                    break;
                case 31:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow16();
                    break;
                case 32:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow17();
                    break;
                case 33:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow18();
                    break;
                case 34:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow19();
                    break;
                case 35:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow20();
                    break;
                case 36:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow21();
                    break;
                case 37:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow22();
                    break;
                case 38:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow23();
                    break;
                case 40:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow24();
                    break;
                case 85:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow25(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 86:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow26(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 87:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow27(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 88:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow28(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 89:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow29(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 90:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow30(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 91:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow31(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 92:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow32(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 93:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow33(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 94:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow34(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 95:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow35(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 96:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow36(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 97:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow37(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 98:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow38(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 99:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow39(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 100:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow40(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 101:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow41(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 102:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow42(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 103:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow43(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 104:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow44(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 105:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow45(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 106:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow46(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 107:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow47(Sbd_Settings_Battery_Status.this.val);
                    break;
                case 108:
                    Sbd_Settings_Battery_Status.this.mUpdatersetshow48(Sbd_Settings_Battery_Status.this.val);
                    break;
            }
        }
    };
    int val;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_electric_battery);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.Sbd_313_battery1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery1)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery1bstr)) + getString(R.string.setting_313_battery100bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery1)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery1bstr)) + getString(R.string.setting_313_battery110bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[17];
        if (((TextView) findViewById(R.id.Sbd_313_battery2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery2)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery2bstr)) + getString(R.string.setting_313_battery200bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery2)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery2bstr)) + getString(R.string.setting_313_battery210bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[18];
        if (((TextView) findViewById(R.id.Sbd_313_battery3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery3)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery3bstr)) + getString(R.string.setting_313_charge12bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery3)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery3bstr)) + getString(R.string.setting_313_battery31bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.Sbd_313_battery4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery4)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery4bstr)) + getString(R.string.setting_313_battery40bstr), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery4)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery4bstr)) + getString(R.string.setting_313_battery41bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.Sbd_313_battery5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery5)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery5bstr)) + getString(R.string.setting_313_tv61str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery5)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery5bstr)) + getString(R.string.setting_313_tv62str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.Sbd_313_battery6)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery6)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery6bstr)) + (value / 10.0f) + "V", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.Sbd_313_battery7)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery7)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery7bstr)) + (value / 10.0f) + "A", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow8() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.Sbd_313_battery8)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_battery8)).setText(String.valueOf(getString(R.string.setting_313_battery8bstr)) + value + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow9() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.Sbd_313_battery9)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery9)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery9bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery9)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery9bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow10() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.Sbd_313_battery10)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery10)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery10bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery10)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery10bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow11() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.Sbd_313_battery11)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery11)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery11bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery11)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery11bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow12() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.Sbd_313_battery12)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery12)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery12bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery12)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery12bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow13() {
        int value = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.Sbd_313_battery13)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery13)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery13bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery13)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery13bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow14() {
        int value = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.Sbd_313_battery14)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery14)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery14bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery14)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery14bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow15() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.Sbd_313_battery15)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery15)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery15bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery15)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery15bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow16() {
        int value = DataCanbus.DATA[31];
        if (((TextView) findViewById(R.id.Sbd_313_battery16)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery16)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery16bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery16)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery16bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow17() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.Sbd_313_battery17)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery17)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery17bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery17)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery17bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow18() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.Sbd_313_battery18)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery18)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery18bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery18)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery18bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow19() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.Sbd_313_battery19)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery19)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery19bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery19)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery19bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow20() {
        int value = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.Sbd_313_battery20)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery20)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery20bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery20)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery20bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow21() {
        int value = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.Sbd_313_battery21)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery21)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery21bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery21)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery21bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow22() {
        int value = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.Sbd_313_battery22)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery22)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery22bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery22)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery22bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow23() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.Sbd_313_battery23)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery23)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery23bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery23)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery23bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow24() {
        int value = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.Sbd_313_battery24)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery24)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery24bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery24)).setText(String.format(String.valueOf(getString(R.string.setting_313_battery24bstr)) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow25(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery25)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery25)).setText(String.format(String.valueOf(getString(this.lang_id[0])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery25)).setText(String.format(String.valueOf(getString(this.lang_id[0])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow26(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery26)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery26)).setText(String.format(String.valueOf(getString(this.lang_id[1])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery26)).setText(String.format(String.valueOf(getString(this.lang_id[1])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow27(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery27)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery27)).setText(String.format(String.valueOf(getString(this.lang_id[2])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery27)).setText(String.format(String.valueOf(getString(this.lang_id[2])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow28(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery28)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery28)).setText(String.format(String.valueOf(getString(this.lang_id[3])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery28)).setText(String.format(String.valueOf(getString(this.lang_id[3])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow29(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery29)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery29)).setText(String.format(String.valueOf(getString(this.lang_id[4])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery29)).setText(String.format(String.valueOf(getString(this.lang_id[4])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow30(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery30)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery30)).setText(String.format(String.valueOf(getString(this.lang_id[5])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery30)).setText(String.format(String.valueOf(getString(this.lang_id[5])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow43(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery43)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery43)).setText(String.format(String.valueOf(getString(this.lang_id[18])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery43)).setText(String.format(String.valueOf(getString(this.lang_id[18])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow44(int val) {
        if (((TextView) findViewById(R.id.Sbd_313_battery44)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.Sbd_313_battery44)).setText(String.format(String.valueOf(getString(this.lang_id[19])) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_battery44)).setText(String.format(String.valueOf(getString(this.lang_id[19])) + getString(R.string.setting_313_tv51str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow46(int val) {
        ((TextView) findViewById(R.id.Sbd_313_battery46)).setText(String.valueOf(getString(this.lang_id[21])) + val + "K/Bit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow47(int val) {
        ((TextView) findViewById(R.id.Sbd_313_battery47)).setText(String.valueOf(getString(this.lang_id[22])) + val + "K/Bit");
    }

    /* JADX INFO: Access modifiers changed from: private */
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
