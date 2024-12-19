package com.syu.carinfo.accord9.xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XPAccord9SettingsActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 18:
                    XPAccord9SettingsActi.this.mUpdaterTripbResetTiming();
                    break;
                case 19:
                    XPAccord9SettingsActi.this.mUpdaterTripaResetTiming();
                    break;
                case 20:
                    XPAccord9SettingsActi.this.mUpdaterAdjustOutsideTempDisplay();
                    break;
                case 21:
                    XPAccord9SettingsActi.this.mUpdaterFuelEfficiencyBacklight();
                    break;
                case 22:
                    XPAccord9SettingsActi.this.mUpdaterAutoLightSensitivity();
                    break;
                case 23:
                    XPAccord9SettingsActi.this.mUpdaterHeadlightAutOffTimer();
                    break;
                case 24:
                    XPAccord9SettingsActi.this.mUpdaterInteriorLightDimmingTime();
                    break;
                case 25:
                    XPAccord9SettingsActi.this.mUpdaterKeylessLockAnswerBack();
                    break;
                case 26:
                    XPAccord9SettingsActi.this.mUpdaterSecurityRelockTimer();
                    break;
                case 27:
                    XPAccord9SettingsActi.this.mUpdaterKeylessAccessBeepVolume();
                    break;
                case 28:
                    XPAccord9SettingsActi.this.mUpdaterKeylessAccessBeep();
                    break;
                case 60:
                    if (((CheckedTextView) XPAccord9SettingsActi.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) XPAccord9SettingsActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xp_setting);
        ((Button) findViewById(R.id.xp_accord9_btn_adjust_outside_temp_display_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[20] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_adjust_outside_temp_display_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[20] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_fuel_efficiency_backlight)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[21] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_tripa_reset_timing_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_tripa_reset_timing_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_tripb_reset_timing_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[18];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_tripb_reset_timing_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[18];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_interior_light_dimming_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_interior_light_dimming_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_headlight_aut_off_timer_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_headlight_aut_off_timer_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_auto_light_sensitivity_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_auto_light_sensitivity_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_lock_answer_back)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(10, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_security_relock_timer_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_security_relock_timer_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_keyless_access_beep_volume_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_keyless_access_beep_volume_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_access_beep)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(13, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[60] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_reset_maintenance_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XPAccord9SettingsActi.this.dialog(R.string.xp_accord9_reset_maintenance_info, 14);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_default_all)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XPAccord9SettingsActi.this.dialog(R.string.xp_accord9_default_all, 15);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_accord9_btn_deflation_warning_system)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XPAccord9SettingsActi.this.dialog(R.string.xp_accord9_deflation_warning_system, 17);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(100, new int[]{50}, null, null);
        if (DataCanbus.DATA[1000] == 41 || DataCanbus.DATA[1000] == 65577) {
            findViewById(R.id.xp_accord9_view_1).setVisibility(8);
            findViewById(R.id.xp_accord9_view_2).setVisibility(8);
            findViewById(R.id.xp_accord9_view_3).setVisibility(8);
            findViewById(R.id.xp_accord9_view_4).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 77 || DataCanbus.DATA[1000] == 131149 || DataCanbus.DATA[1000] == 65613 || DataCanbus.DATA[1000] == 196685 || DataCanbus.DATA[1000] == 262221) {
            findViewById(R.id.xp_accord9_view_1).setVisibility(0);
            findViewById(R.id.xp_accord9_view_2).setVisibility(0);
            findViewById(R.id.xp_accord9_view_3).setVisibility(0);
        }
        findViewById(R.id.xp_accord9_view_5).setVisibility(0);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAdjustOutsideTempDisplay() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.xp_accord9_tv_adjust_outside_temp_display)) != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_adjust_outside_temp_display)).setText("+" + value2);
            } else if (value2 == 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_adjust_outside_temp_display)).setText("0" + value2);
            } else {
                ((TextView) findViewById(R.id.xp_accord9_tv_adjust_outside_temp_display)).setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFuelEfficiencyBacklight() {
        int value = DataCanbus.DATA[21];
        if (((CheckedTextView) findViewById(R.id.xp_accord9_btn_fuel_efficiency_backlight)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_accord9_btn_fuel_efficiency_backlight)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripaResetTiming() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing)).setText(R.string.xp_accord9_ign_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing)).setText(R.string.xp_accord9_manually_reset);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing)).setText(R.string.xp_accord9_with_refuel);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripbResetTiming() {
        int value = DataCanbus.DATA[18];
        if (((TextView) findViewById(R.id.xp_accord9_tv_tripb_reset_timing)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripb_reset_timing)).setText(R.string.xp_accord9_ign_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripb_reset_timing)).setText(R.string.xp_accord9_manually_reset);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_tripb_reset_timing)).setText(R.string.xp_accord9_with_refuel);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightDimmingTime() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.xp_accord9_tv_interior_light_dimming_time)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_interior_light_dimming_time)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_interior_light_dimming_time)).setText("60s");
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_interior_light_dimming_time)).setText("15s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightAutOffTimer() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer)).setText("15s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer)).setText("60s");
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer)).setText("0s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoLightSensitivity() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)).setText(R.string.xp_accord9_auto_light_1lower);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)).setText(R.string.xp_accord9_auto_light_2middle);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)).setText(R.string.xp_accord9_auto_light_3higher);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)).setText(R.string.xp_accord9_auto_light_4highest);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity)).setText(R.string.xp_accord9_auto_light_0lowest);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessLockAnswerBack() {
        int value = DataCanbus.DATA[25];
        if (((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_lock_answer_back)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_lock_answer_back)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSecurityRelockTimer() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.xp_accord9_tv_security_relock_timer)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_security_relock_timer)).setText("60s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_security_relock_timer)).setText("90s");
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_security_relock_timer)).setText("30s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessAccessBeepVolume() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.xp_accord9_tv_keyless_access_beep_volume)) != null) {
            ((TextView) findViewById(R.id.xp_accord9_tv_keyless_access_beep_volume)).setText(value == 0 ? R.string.xp_accord9_keyless_access_beep_volume_low : R.string.xp_accord9_keyless_access_beep_volume_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessAccessBeep() {
        int value = DataCanbus.DATA[28];
        if (((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_access_beep)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_access_beep)).setChecked(value != 0);
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.25
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9SettingsActi.26
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
