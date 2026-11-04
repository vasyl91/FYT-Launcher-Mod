package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RzcJianghuaiChargingTime extends BaseActivity {
    int mode = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    RzcJianghuaiChargingTime.this.UpdateCharingTimeValue1(value);
                    break;
                case 127:
                    RzcJianghuaiChargingTime.this.UpdateCharingTimeValue1(value);
                    break;
                case 128:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 129:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 130:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 132:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 134:
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 135:
                    RzcJianghuaiChargingTime.this.mode = value;
                    RzcJianghuaiChargingTime.this.UpdateModeSet(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_jianghuai_chargingtime);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value1_1 = DataCanbus.DATA[126];
                    if (value1_1 - 1 < 1) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value1_2 = DataCanbus.DATA[127];
                    if (value1_2 - 1 < 1) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value1_1 = DataCanbus.DATA[126];
                    if (value1_1 + 1 > 7) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value1_2 = DataCanbus.DATA[127];
                    if (value1_2 + 1 > 7) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value2_1 = DataCanbus.DATA[128];
                    if (value2_1 - 1 < 0) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value2_2 = DataCanbus.DATA[129];
                    if (value2_2 - 1 < 0) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value2_1 = DataCanbus.DATA[128];
                    if (value2_1 + 1 > 23) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value2_2 = DataCanbus.DATA[129];
                    if (value2_2 + 1 > 23) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value3_1 = DataCanbus.DATA[130];
                    if (value3_1 - 1 < 0) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value3_2 = DataCanbus.DATA[131];
                    if (value3_2 - 1 < 0) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value3_1 = DataCanbus.DATA[130];
                    if (value3_1 + 1 > 59) {
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value3_2 = DataCanbus.DATA[131];
                    if (value3_2 + 1 > 59) {
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value4_1 = DataCanbus.DATA[132];
                    if (value4_1 + 5 > 100) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                } else {
                    int value4_2 = DataCanbus.DATA[133];
                    if (value4_2 + 1 > 23) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    int value4_1 = DataCanbus.DATA[132];
                    if (value4_1 + 5 > 100) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                } else {
                    int value4_2 = DataCanbus.DATA[133];
                    if (value4_2 + 1 > 23) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value5 = DataCanbus.DATA[134];
                    if (value5 - 1 < 0) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 2) {
                    int value5 = DataCanbus.DATA[134];
                    if (value5 + 1 > 50) {
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RzcJianghuaiChargingTime.this.mode = 1;
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RzcJianghuaiChargingTime.this.mode = 2;
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateCharingTimeValue1(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week4);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week5);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week6);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_week7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateModeSet(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_percentage);
                ((TextView) findViewById(R.id.tv_text2)).setText("---");
                UpdateCharingTimeValue1(DataCanbus.DATA[126]);
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(DataCanbus.DATA[128]).toString());
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(DataCanbus.DATA[130]).toString());
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(DataCanbus.DATA[132]).toString());
                ((TextView) findViewById(R.id.tv_text7)).setText("---");
                ((Button) findViewById(R.id.btn_plus1)).setSelected(true);
                ((Button) findViewById(R.id.btn_plus2)).setSelected(false);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_end_hour);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_end_munite);
                UpdateCharingTimeValue1(DataCanbus.DATA[127]);
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(DataCanbus.DATA[129]).toString());
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(DataCanbus.DATA[131]).toString());
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(DataCanbus.DATA[133]).toString());
                ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(DataCanbus.DATA[134]).toString());
                ((Button) findViewById(R.id.btn_plus1)).setSelected(false);
                ((Button) findViewById(R.id.btn_plus2)).setSelected(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendChargingData() {
        if (this.mode == 1) {
            int value1_1 = DataCanbus.DATA[126];
            int value2_1 = DataCanbus.DATA[128];
            int value3_1 = DataCanbus.DATA[130];
            int value4_1 = DataCanbus.DATA[132];
            DataCanbus.PROXY.cmd(2, new int[]{this.mode, value1_1, value2_1, value3_1, value4_1}, null, null);
            return;
        }
        if (this.mode == 2) {
            int value1_2 = DataCanbus.DATA[127];
            int value2_2 = DataCanbus.DATA[129];
            int value3_2 = DataCanbus.DATA[131];
            int value4_2 = DataCanbus.DATA[133];
            int value5 = DataCanbus.DATA[134];
            DataCanbus.PROXY.cmd(2, new int[]{this.mode, value1_2, value2_2, value3_2, value4_2, value5}, null, null);
        }
    }
}
