package com.syu.carinfo.wc.ruiteng;

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
public class MingjueZS_Wc extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.MingjueZS_Wc.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mingjue_steerfeel_m /* 2131431813 */:
                    int val = DataCanbus.DATA[167] & 15;
                    MingjueZS_Wc.this.sendCmd(3, val == 0 ? 2 : val - 1);
                    break;
                case R.id.mingjue_steerfeel_p /* 2131431815 */:
                    MingjueZS_Wc.this.sendCmd(3, ((DataCanbus.DATA[167] & 15) + 1) % 3);
                    break;
                case R.id.mingjue_searchcar_indicator /* 2131431817 */:
                    MingjueZS_Wc.this.sendCmd(2, (DataCanbus.DATA[168] & 15) != 1 ? 1 : 0);
                    break;
                case R.id.mingjue_comehomewithme /* 2131431820 */:
                    MingjueZS_Wc.this.sendCmd(1, (DataCanbus.DATA[169] & 15) != 1 ? 1 : 0);
                    break;
                case R.id.mingjue_home_light_time_m /* 2131432066 */:
                    int val2 = (DataCanbus.DATA[182] & 15) - 1;
                    if (val2 < 0) {
                        val2 = 2;
                    }
                    MingjueZS_Wc.this.sendCmd(7, val2);
                    break;
                case R.id.mingjue_home_light_time_p /* 2131432068 */:
                    int val3 = (DataCanbus.DATA[182] & 15) + 1;
                    if (val3 > 2) {
                        val3 = 0;
                    }
                    MingjueZS_Wc.this.sendCmd(7, val3);
                    break;
                case R.id.mingjue_stop_auto_unlock /* 2131432070 */:
                    MingjueZS_Wc.this.sendCmd(6, (DataCanbus.DATA[183] & 15) != 1 ? 1 : 0);
                    break;
                case R.id.mingjue_start_auto_lock /* 2131432072 */:
                    MingjueZS_Wc.this.sendCmd(5, (DataCanbus.DATA[184] & 15) != 1 ? 1 : 0);
                    break;
                case R.id.mingjue_beep_onoff /* 2131432073 */:
                    MingjueZS_Wc.this.sendCmd(4, (DataCanbus.DATA[185] & 15) != 1 ? 1 : 0);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.MingjueZS_Wc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 167:
                    MingjueZS_Wc.this.uSteerFeel(DataCanbus.DATA[updateCode]);
                    break;
                case 168:
                    MingjueZS_Wc.this.uSearchCar(DataCanbus.DATA[updateCode]);
                    break;
                case 169:
                    MingjueZS_Wc.this.uComeHome(DataCanbus.DATA[updateCode]);
                    break;
                case 182:
                    MingjueZS_Wc.this.uHomeLightTime(DataCanbus.DATA[updateCode]);
                    break;
                case 183:
                    MingjueZS_Wc.this.uStopAutoUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 184:
                    MingjueZS_Wc.this.uStartAutoLock(DataCanbus.DATA[updateCode]);
                    break;
                case 185:
                    MingjueZS_Wc.this.uBeepOnoff(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_mingjuezs_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setClick((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator));
        setClick((CheckedTextView) findViewById(R.id.mingjue_comehomewithme));
        setClick((Button) findViewById(R.id.mingjue_steerfeel_m));
        setClick((Button) findViewById(R.id.mingjue_steerfeel_p));
        setClick((CheckedTextView) findViewById(R.id.mingjue_stop_auto_unlock));
        setClick((CheckedTextView) findViewById(R.id.mingjue_start_auto_lock));
        setClick((Button) findViewById(R.id.mingjue_home_light_time_m));
        setClick((Button) findViewById(R.id.mingjue_home_light_time_p));
        setClick((CheckedTextView) findViewById(R.id.mingjue_beep_onoff));
    }

    @Override // com.syu.canbus.BaseActivity
    public void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int cmd, int para) {
        DataCanbus.PROXY.cmd(22, new int[]{126, cmd, para}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }

    protected void uBeepOnoff(int i) {
        int val = i & 1;
        if (((CheckedTextView) findViewById(R.id.mingjue_beep_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_beep_onoff)).setChecked(val == 1);
        }
    }

    protected void uStartAutoLock(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_start_auto_lock_view) != null) {
            findViewById(R.id.mingjue_start_auto_lock_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 1;
        if (((CheckedTextView) findViewById(R.id.mingjue_start_auto_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_start_auto_lock)).setChecked(val == 1);
        }
    }

    protected void uStopAutoUnlock(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_stop_auto_unlock_view) != null) {
            findViewById(R.id.mingjue_stop_auto_unlock_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 1;
        if (((CheckedTextView) findViewById(R.id.mingjue_stop_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_stop_auto_unlock)).setChecked(val == 1);
        }
    }

    protected void uHomeLightTime(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_home_light_time_view) != null) {
            findViewById(R.id.mingjue_home_light_time_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 3;
        if (((TextView) findViewById(R.id.mingjue_home_light_time_txt)) != null) {
            int resId = R.string.klc_light_Lasuo_headlight_delay_1;
            if (val == 1) {
                resId = R.string.klc_light_Lasuo_headlight_delay_2;
            } else if (val == 2) {
                resId = R.string.str_xp_mzd_cx5_auto_relock_time_0;
            }
            ((TextView) findViewById(R.id.mingjue_home_light_time_txt)).setText(resId);
        }
    }

    protected void uSteerFeel(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_steerfeel_view) != null) {
            findViewById(R.id.mingjue_steerfeel_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 3;
        if (((TextView) findViewById(R.id.mingjue_steerfeel_txt)) != null) {
            int resId = R.string.rzc_klc_nomal;
            if (val == 1) {
                resId = R.string.str_driving_comfort;
            } else if (val == 2) {
                resId = R.string.str_driving_sport;
            }
            ((TextView) findViewById(R.id.mingjue_steerfeel_txt)).setText(resId);
        }
    }

    protected void uComeHome(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_comehomewithme_view) != null) {
            findViewById(R.id.mingjue_comehomewithme_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 3;
        if (((CheckedTextView) findViewById(R.id.mingjue_comehomewithme)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_comehomewithme)).setChecked(val == 1);
        }
    }

    protected void uSearchCar(int i) {
        int enable = (i >> 8) & 15;
        if (findViewById(R.id.mingjue_searchcar_indicator_view) != null) {
            findViewById(R.id.mingjue_searchcar_indicator_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val = i & 3;
        if (((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator)).setChecked(val == 1);
            if (((TextView) findViewById(R.id.mingjue_searchcar_indicator_txt)) != null) {
                int resId = R.string.klc_remote_Remote_control_latch_only_light;
                if (val == 1) {
                    resId = R.string.klc_remote_Remote_control_latch_light_Speaker;
                }
                ((TextView) findViewById(R.id.mingjue_searchcar_indicator_txt)).setText(resId);
            }
        }
    }
}
