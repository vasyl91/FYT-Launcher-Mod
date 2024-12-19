package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4HelpSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4HelpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    GS4HelpSetAct.this.updaterSpeed();
                    break;
                case 9:
                    GS4HelpSetAct.this.updaterWarnSound();
                    break;
                case 10:
                    GS4HelpSetAct.this.updaterAwayTime();
                    break;
                case 11:
                    GS4HelpSetAct.this.updaterStartTime();
                    break;
                case 12:
                    GS4HelpSetAct.this.updaterTurnMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_help_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.wc_gs4_warn_of_speed_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_warn_of_speed_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_sound_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_sound_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_away_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_away_time_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_start_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_start_time_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_next)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_warn_of_speed_pre /* 2131429067 */:
                int value = (DataCanbus.DATA[8] / 10) - 1;
                if (value >= 0 && value <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
                    break;
                }
            case R.id.wc_gs4_warn_of_speed_next /* 2131429069 */:
                int value2 = (DataCanbus.DATA[8] / 10) + 1;
                if (value2 >= 0 && value2 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value2}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_sound_pre /* 2131429070 */:
                int value3 = DataCanbus.DATA[9];
                if (value3 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 2}, null, null);
                    break;
                } else if (value3 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{8}, null, null);
                    break;
                } else if (value3 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_sound_next /* 2131429072 */:
                int value4 = DataCanbus.DATA[9];
                if (value4 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
                    break;
                } else if (value4 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 2}, null, null);
                    break;
                } else if (value4 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{8}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_away_time_pre /* 2131429073 */:
                int value5 = DataCanbus.DATA[10] - 1;
                if (value5 >= 0 && value5 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, value5}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_away_time_next /* 2131429075 */:
                int value6 = DataCanbus.DATA[10] + 1;
                if (value6 >= 0 && value6 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, value6}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_start_time_pre /* 2131429076 */:
                int value7 = DataCanbus.DATA[11] - 1;
                if (value7 >= 0 && value7 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{10, value7}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_start_time_next /* 2131429078 */:
                int value8 = DataCanbus.DATA[11] + 1;
                if (value8 >= 0 && value8 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{10, value8}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_turn_mode_pre /* 2131429079 */:
                int value9 = DataCanbus.DATA[12];
                if (value9 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                    break;
                } else if (value9 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{11}, null, null);
                    break;
                } else if (value9 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_turn_mode_next /* 2131429081 */:
                int value10 = DataCanbus.DATA[12];
                if (value10 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                    break;
                } else if (value10 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                    break;
                } else if (value10 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int mSpeedInt = DataCanbus.DATA[8];
        if (mSpeedInt > 200) {
            mSpeedInt = 200;
        } else if (mSpeedInt < 0) {
            mSpeedInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_warn_of_speed_TV)).setText(mSpeedInt + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnSound() {
        int mWarnSoundInt = DataCanbus.DATA[9];
        if (mWarnSoundInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_low);
        } else if (mWarnSoundInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_middle);
        } else if (mWarnSoundInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAwayTime() {
        int mDriverAwayTimeInt = DataCanbus.DATA[10];
        if (mDriverAwayTimeInt > 30) {
            mDriverAwayTimeInt = 30;
        } else if (mDriverAwayTimeInt < 0) {
            mDriverAwayTimeInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_driver_help_away_time_TV)).setText(new StringBuilder().append(mDriverAwayTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterStartTime() {
        int mDriverStartTimeInt = DataCanbus.DATA[11];
        if (mDriverStartTimeInt > 30) {
            mDriverStartTimeInt = 30;
        } else if (mDriverStartTimeInt < 0) {
            mDriverStartTimeInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_driver_help_start_time_TV)).setText(new StringBuilder().append(mDriverStartTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnMode() {
        int mTurnModeInt = DataCanbus.DATA[12];
        if (mTurnModeInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.driver_system_sports);
        } else if (mTurnModeInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.driver_system_standard);
        } else if (mTurnModeInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
        }
    }
}
