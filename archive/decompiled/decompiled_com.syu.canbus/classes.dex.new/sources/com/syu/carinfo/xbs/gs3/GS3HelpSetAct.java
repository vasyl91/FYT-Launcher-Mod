package com.syu.carinfo.xbs.gs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS3HelpSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3HelpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    GS3HelpSetAct.this.updaterSpeed();
                    break;
                case 107:
                    GS3HelpSetAct.this.updaterWarnSound();
                    break;
                case 108:
                    GS3HelpSetAct.this.updaterAwayTime();
                    break;
                case 109:
                    GS3HelpSetAct.this.updaterStartTime();
                    break;
                case 110:
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value1 = (DataCanbus.DATA[106] / 10) - 1;
                if (value1 >= 0 && value1 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{5, value1}, null, null);
                    break;
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[106] / 10) + 1;
                if (value2 >= 0 && value2 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{5, value2}, null, null);
                    break;
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                } else if (DataCanbus.DATA[107] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 0}, null, null);
                } else if (DataCanbus.DATA[107] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                } else if (DataCanbus.DATA[107] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                } else if (DataCanbus.DATA[107] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 0}, null, null);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 >= 0 && value3 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value3}, null, null);
                    break;
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 >= 0 && value4 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value4}, null, null);
                    break;
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = DataCanbus.DATA[109] - 1;
                if (value5 >= 0 && value5 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, value5}, null, null);
                    break;
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = DataCanbus.DATA[109] + 1;
                if (value6 >= 0 && value6 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, value6}, null, null);
                    break;
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                if (DataCanbus.DATA[110] == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 2}, null, null);
                } else if (DataCanbus.DATA[110] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 3}, null, null);
                } else if (DataCanbus.DATA[110] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                if (DataCanbus.DATA[110] == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                } else if (DataCanbus.DATA[110] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 2}, null, null);
                } else if (DataCanbus.DATA[110] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, 3}, null, null);
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{9}, null, null);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int mSpeedInt = DataCanbus.DATA[106];
        if (mSpeedInt > 200) {
            mSpeedInt = 200;
        } else if (mSpeedInt < 0) {
            mSpeedInt = 0;
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(mSpeedInt + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnSound() {
        int mWarnSoundInt = DataCanbus.DATA[107];
        if (mWarnSoundInt == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
        } else if (mWarnSoundInt == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
        } else if (mWarnSoundInt == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAwayTime() {
        int mDriverAwayTimeInt = DataCanbus.DATA[108];
        if (mDriverAwayTimeInt > 30) {
            mDriverAwayTimeInt = 30;
        } else if (mDriverAwayTimeInt < 0) {
            mDriverAwayTimeInt = 0;
        }
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(mDriverAwayTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterStartTime() {
        int mDriverStartTimeInt = DataCanbus.DATA[109];
        if (mDriverStartTimeInt > 30) {
            mDriverStartTimeInt = 30;
        } else if (mDriverStartTimeInt < 0) {
            mDriverStartTimeInt = 0;
        }
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(mDriverStartTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnMode() {
        int mTurnModeInt = DataCanbus.DATA[110];
        if (mTurnModeInt == 3) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.driver_system_sports);
        } else if (mTurnModeInt == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
        } else if (mTurnModeInt == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
        }
    }
}
