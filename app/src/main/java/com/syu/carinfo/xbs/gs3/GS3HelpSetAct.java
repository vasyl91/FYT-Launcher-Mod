package com.syu.carinfo.xbs.gs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3HelpSetAct extends BaseActivity implements View.OnClickListener {
    Button mDriverAwayTimeNext;
    Button mDriverAwayTimePre;
    TextView mDriverAwayTimeTV;
    Button mDriverStartTimeNext;
    Button mDriverStartTimePre;
    TextView mDriverStartTimeTV;
    Button mSpeedNext;
    Button mSpeedPre;
    TextView mSpeedTV;
    Button mTurnModeNext;
    Button mTurnModePre;
    TextView mTurnModeTV;
    Button mWarnSoundNext;
    Button mWarnSoundPre;
    TextView mWarnSoundTV;
    int mSpeedInt = -1;
    int mWarnSoundInt = -1;
    int mDriverAwayTimeInt = -1;
    int mDriverStartTimeInt = -1;
    int mTurnModeInt = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3HelpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    GS3HelpSetAct.this.updaterSpeed();
                    break;
                case 9:
                    GS3HelpSetAct.this.updaterWarnSound();
                    break;
                case 10:
                    GS3HelpSetAct.this.updaterAwayTime();
                    break;
                case 11:
                    GS3HelpSetAct.this.updaterStartTime();
                    break;
                case 12:
                    GS3HelpSetAct.this.updaterTurnMode();
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
        this.mSpeedTV = (TextView) findViewById(R.id.wc_gs4_warn_of_speed_TV);
        this.mWarnSoundTV = (TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV);
        this.mDriverAwayTimeTV = (TextView) findViewById(R.id.wc_gs4_driver_help_away_time_TV);
        this.mDriverStartTimeTV = (TextView) findViewById(R.id.wc_gs4_driver_help_start_time_TV);
        this.mTurnModeTV = (TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV);
        this.mSpeedPre = (Button) findViewById(R.id.wc_gs4_warn_of_speed_pre);
        this.mSpeedNext = (Button) findViewById(R.id.wc_gs4_warn_of_speed_next);
        this.mWarnSoundPre = (Button) findViewById(R.id.wc_gs4_driver_help_sound_pre);
        this.mWarnSoundNext = (Button) findViewById(R.id.wc_gs4_driver_help_sound_next);
        this.mDriverAwayTimePre = (Button) findViewById(R.id.wc_gs4_driver_help_away_time_pre);
        this.mDriverAwayTimeNext = (Button) findViewById(R.id.wc_gs4_driver_help_away_time_next);
        this.mDriverStartTimePre = (Button) findViewById(R.id.wc_gs4_driver_help_start_time_pre);
        this.mDriverStartTimeNext = (Button) findViewById(R.id.wc_gs4_driver_help_start_time_next);
        this.mTurnModePre = (Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_pre);
        this.mTurnModeNext = (Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_next);
        setSelfClick(this.mSpeedPre, this);
        setSelfClick(this.mSpeedNext, this);
        setSelfClick(this.mWarnSoundPre, this);
        setSelfClick(this.mWarnSoundNext, this);
        setSelfClick(this.mDriverAwayTimePre, this);
        setSelfClick(this.mDriverAwayTimeNext, this);
        setSelfClick(this.mDriverStartTimePre, this);
        setSelfClick(this.mDriverStartTimeNext, this);
        setSelfClick(this.mTurnModePre, this);
        setSelfClick(this.mTurnModeNext, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_warn_of_speed_pre /* 2131429067 */:
                int value1 = (this.mSpeedInt / 10) - 1;
                if (value1 >= 0 && value1 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{5, value1}, null, null);
                    break;
                }
            case R.id.wc_gs4_warn_of_speed_next /* 2131429069 */:
                int value2 = (this.mSpeedInt / 10) + 1;
                if (value2 >= 0 && value2 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{5, value2}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_sound_pre /* 2131429070 */:
                if (this.mWarnSoundInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (this.mWarnSoundInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                } else if (this.mWarnSoundInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_sound_next /* 2131429072 */:
                if (this.mWarnSoundInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                } else if (this.mWarnSoundInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (this.mWarnSoundInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_away_time_pre /* 2131429073 */:
                int value3 = this.mDriverAwayTimeInt - 1;
                if (value3 >= 0 && value3 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value3}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_away_time_next /* 2131429075 */:
                int value4 = this.mDriverAwayTimeInt + 1;
                if (value4 >= 0 && value4 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value4}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_start_time_pre /* 2131429076 */:
                int value5 = this.mDriverStartTimeInt - 1;
                if (value5 >= 0 && value5 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, value5}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_start_time_next /* 2131429078 */:
                int value6 = this.mDriverStartTimeInt + 1;
                if (value6 >= 0 && value6 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, value6}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_turn_mode_pre /* 2131429079 */:
                if (this.mTurnModeInt == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 2}, null, null);
                    break;
                } else if (this.mTurnModeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 3}, null, null);
                    break;
                } else if (this.mTurnModeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_driver_help_turn_mode_next /* 2131429081 */:
                if (this.mTurnModeInt == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                    break;
                } else if (this.mTurnModeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 2}, null, null);
                    break;
                } else if (this.mTurnModeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 3}, null, null);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{9}, null, null);
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
        this.mSpeedInt = DataCanbus.DATA[8];
        if (this.mSpeedInt > 200) {
            this.mSpeedInt = 200;
        } else if (this.mSpeedInt < 0) {
            this.mSpeedInt = 0;
        }
        this.mSpeedTV.setText(this.mSpeedInt + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnSound() {
        this.mWarnSoundInt = DataCanbus.DATA[9];
        if (this.mWarnSoundInt == 0) {
            this.mWarnSoundTV.setText(R.string.klc_air_low);
        } else if (this.mWarnSoundInt == 1) {
            this.mWarnSoundTV.setText(R.string.klc_air_middle);
        } else if (this.mWarnSoundInt == 2) {
            this.mWarnSoundTV.setText(R.string.klc_air_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAwayTime() {
        this.mDriverAwayTimeInt = DataCanbus.DATA[10];
        if (this.mDriverAwayTimeInt > 30) {
            this.mDriverAwayTimeInt = 30;
        } else if (this.mDriverAwayTimeInt < 0) {
            this.mDriverAwayTimeInt = 0;
        }
        this.mDriverAwayTimeTV.setText(new StringBuilder().append(this.mDriverAwayTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterStartTime() {
        this.mDriverStartTimeInt = DataCanbus.DATA[11];
        if (this.mDriverStartTimeInt > 30) {
            this.mDriverStartTimeInt = 30;
        } else if (this.mDriverStartTimeInt < 0) {
            this.mDriverStartTimeInt = 0;
        }
        this.mDriverStartTimeTV.setText(new StringBuilder().append(this.mDriverStartTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnMode() {
        this.mTurnModeInt = DataCanbus.DATA[12];
        if (this.mTurnModeInt == 3) {
            this.mTurnModeTV.setText(R.string.driver_system_sports);
        } else if (this.mTurnModeInt == 1) {
            this.mTurnModeTV.setText(R.string.driver_system_standard);
        } else if (this.mTurnModeInt == 2) {
            this.mTurnModeTV.setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
        }
    }
}
