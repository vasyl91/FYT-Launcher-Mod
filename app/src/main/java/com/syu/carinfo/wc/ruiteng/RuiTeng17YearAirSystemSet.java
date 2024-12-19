package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTeng17YearAirSystemSet extends BaseActivity {
    int autoblowvalue;
    int dualvlaue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTeng17YearAirSystemSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    RuiTeng17YearAirSystemSet.this.autoblowvalue = DataCanbus.DATA[103];
                    if (((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_automode_blow_show)) != null) {
                        if (RuiTeng17YearAirSystemSet.this.autoblowvalue == 0) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_automode_blow_show)).setText(R.string.lingdu_air_con_profile_0);
                            break;
                        } else if (RuiTeng17YearAirSystemSet.this.autoblowvalue == 1) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_automode_blow_show)).setText(R.string.lingdu_air_con_profile_1);
                            break;
                        } else if (RuiTeng17YearAirSystemSet.this.autoblowvalue == 2) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_automode_blow_show)).setText(R.string.lingdu_air_con_profile_2);
                            break;
                        }
                    }
                    break;
                case 104:
                    RuiTeng17YearAirSystemSet.this.dualvlaue = DataCanbus.DATA[104];
                    if (((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_air_dual_show)) != null) {
                        if (RuiTeng17YearAirSystemSet.this.dualvlaue == 0) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_air_dual_show)).setText(R.string.wc_weilang_danqu);
                            break;
                        } else if (RuiTeng17YearAirSystemSet.this.dualvlaue == 1) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_air_dual_show)).setText(R.string.wc_weilang_shuangqu);
                            break;
                        } else if (RuiTeng17YearAirSystemSet.this.dualvlaue == 2) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_air_dual_show)).setText(R.string.wc_weilang_last_set);
                            break;
                        }
                    }
                    break;
                case 105:
                    RuiTeng17YearAirSystemSet.this.reardefrostfogvalue = DataCanbus.DATA[105];
                    if (((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_reardefrost_fog_show)) != null) {
                        if (RuiTeng17YearAirSystemSet.this.reardefrostfogvalue == 0) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_reardefrost_fog_show)).setText(R.string.rzc_c4l_close);
                            break;
                        } else if (RuiTeng17YearAirSystemSet.this.reardefrostfogvalue == 1) {
                            ((TextView) RuiTeng17YearAirSystemSet.this.findViewById(R.id.wc_reardefrost_fog_show)).setText(R.string.rzc_c4l_open);
                            break;
                        }
                    }
                    break;
            }
        }
    };
    int reardefrostfogvalue;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_17mingjue_airsystem_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTeng17YearAirSystemSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.wc_automode_blow_set_minus /* 2131433063 */:
                        if (RuiTeng17YearAirSystemSet.this.autoblowvalue >= 1) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(1, RuiTeng17YearAirSystemSet.this.autoblowvalue - 1);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(1, 0);
                            break;
                        }
                    case R.id.wc_automode_blow_set_plus /* 2131433065 */:
                        if (RuiTeng17YearAirSystemSet.this.autoblowvalue < 2) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(1, RuiTeng17YearAirSystemSet.this.autoblowvalue + 1);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(1, 2);
                            break;
                        }
                    case R.id.wc_air_dual_set_minus /* 2131433066 */:
                        if (RuiTeng17YearAirSystemSet.this.dualvlaue >= 1) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(4, RuiTeng17YearAirSystemSet.this.dualvlaue - 1);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(4, 0);
                            break;
                        }
                    case R.id.wc_air_dual_set_plus /* 2131433068 */:
                        if (RuiTeng17YearAirSystemSet.this.dualvlaue < 2) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(4, RuiTeng17YearAirSystemSet.this.dualvlaue + 1);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(4, 2);
                            break;
                        }
                    case R.id.wc_reardefrost_fog_set_minus /* 2131433069 */:
                        if (RuiTeng17YearAirSystemSet.this.reardefrostfogvalue == 1) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(16, 0);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(16, 1);
                            break;
                        }
                    case R.id.wc_reardefrost_fog_set_plus /* 2131433071 */:
                        if (RuiTeng17YearAirSystemSet.this.reardefrostfogvalue == 1) {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(16, 0);
                            break;
                        } else {
                            RuiTeng17YearAirSystemSet.this.CarSetControl(16, 1);
                            break;
                        }
                }
            }
        };
        setClick((Button) findViewById(R.id.wc_automode_blow_set_minus));
        setClick((Button) findViewById(R.id.wc_automode_blow_set_plus));
        setClick((Button) findViewById(R.id.wc_air_dual_set_minus));
        setClick((Button) findViewById(R.id.wc_air_dual_set_plus));
        setClick((Button) findViewById(R.id.wc_reardefrost_fog_set_minus));
        setClick((Button) findViewById(R.id.wc_reardefrost_fog_set_plus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CarSetControl(int cmd1, int cmd2) {
        DataCanbus.PROXY.cmd(25, cmd1, cmd2);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }
}
