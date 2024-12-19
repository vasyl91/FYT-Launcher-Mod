package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Psa2008SpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 23:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue7();
                    break;
                case 24:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue8();
                    break;
                case 25:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue9();
                    break;
                case 26:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue10();
                    break;
                case 27:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue11();
                    break;
                case 28:
                    Psa2008SpeedLimitSetActi.this.mUpdaterValue12();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa2008_speed_limit_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_1_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_1_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_2_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_2_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_3_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_3_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_4_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_4_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_5_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_5_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_6_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_limit_speed_6_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008SpeedLimitSetActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_1_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_1_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_2_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_2_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_3_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_3_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_4_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_4_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_5_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_5_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.psa2008_tv_limit_speed_6_set)) != null) {
            ((TextView) findViewById(R.id.psa2008_tv_limit_speed_6_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
