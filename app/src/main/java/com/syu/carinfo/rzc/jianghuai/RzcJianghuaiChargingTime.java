package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcJianghuaiChargingTime extends BaseActivity {
    int mode = 0;
    int value1_1 = 0;
    int value1_2 = 0;
    int value2_1 = 0;
    int value2_2 = 0;
    int value3_1 = 0;
    int value3_2 = 0;
    int value4_1 = 0;
    int value4_2 = 0;
    int value5 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 48:
                    RzcJianghuaiChargingTime.this.value1_1 = value;
                    RzcJianghuaiChargingTime.this.UpdateCharingTimeValue1(value);
                    break;
                case 49:
                    RzcJianghuaiChargingTime.this.value1_2 = value;
                    RzcJianghuaiChargingTime.this.UpdateCharingTimeValue1(value);
                    break;
                case 50:
                    RzcJianghuaiChargingTime.this.value2_1 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 51:
                    RzcJianghuaiChargingTime.this.value2_2 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 52:
                    RzcJianghuaiChargingTime.this.value3_1 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 53:
                    RzcJianghuaiChargingTime.this.value3_2 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 54:
                    RzcJianghuaiChargingTime.this.value4_1 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 55:
                    RzcJianghuaiChargingTime.this.value4_2 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 56:
                    RzcJianghuaiChargingTime.this.value5 = value;
                    ((TextView) RzcJianghuaiChargingTime.this.findViewById(R.id.rzc_jianghuai_chargingtime_value5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 57:
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
        ((Button) findViewById(R.id.jianghuai_chargingmode_value1_m)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime.value1_1--;
                    if (RzcJianghuaiChargingTime.this.value1_1 < 1) {
                        RzcJianghuaiChargingTime.this.value1_1 = 7;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime2 = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime2.value1_2--;
                    if (RzcJianghuaiChargingTime.this.value1_2 < 1) {
                        RzcJianghuaiChargingTime.this.value1_2 = 7;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value1_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime.this.value1_1++;
                    if (RzcJianghuaiChargingTime.this.value1_1 > 7) {
                        RzcJianghuaiChargingTime.this.value1_1 = 1;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime.this.value1_2++;
                    if (RzcJianghuaiChargingTime.this.value1_2 > 7) {
                        RzcJianghuaiChargingTime.this.value1_2 = 1;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value2_m)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime.value2_1--;
                    if (RzcJianghuaiChargingTime.this.value2_1 < 0) {
                        RzcJianghuaiChargingTime.this.value2_1 = 23;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime2 = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime2.value2_2--;
                    if (RzcJianghuaiChargingTime.this.value2_2 < 0) {
                        RzcJianghuaiChargingTime.this.value2_2 = 23;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value2_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime.this.value2_1++;
                    if (RzcJianghuaiChargingTime.this.value2_1 > 23) {
                        RzcJianghuaiChargingTime.this.value2_1 = 0;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime.this.value2_2++;
                    if (RzcJianghuaiChargingTime.this.value2_2 > 23) {
                        RzcJianghuaiChargingTime.this.value2_2 = 0;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value3_m)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime.value3_1--;
                    if (RzcJianghuaiChargingTime.this.value3_1 < 0) {
                        RzcJianghuaiChargingTime.this.value3_1 = 59;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime2 = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime2.value3_2--;
                    if (RzcJianghuaiChargingTime.this.value3_2 < 0) {
                        RzcJianghuaiChargingTime.this.value3_2 = 59;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value3_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime.this.value3_1++;
                    if (RzcJianghuaiChargingTime.this.value3_1 > 59) {
                        RzcJianghuaiChargingTime.this.value3_1 = 0;
                    }
                } else if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime.this.value3_2++;
                    if (RzcJianghuaiChargingTime.this.value3_2 > 59) {
                        RzcJianghuaiChargingTime.this.value3_2 = 0;
                    }
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value4_m)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime.this.value4_1 += 5;
                    if (RzcJianghuaiChargingTime.this.value4_1 > 100) {
                        RzcJianghuaiChargingTime.this.value4_1 = 0;
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                    return;
                }
                RzcJianghuaiChargingTime.this.value4_2++;
                if (RzcJianghuaiChargingTime.this.value4_2 > 23) {
                    RzcJianghuaiChargingTime.this.value4_2 = 0;
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value4_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 1) {
                    RzcJianghuaiChargingTime.this.value4_1 += 5;
                    if (RzcJianghuaiChargingTime.this.value4_1 > 100) {
                        RzcJianghuaiChargingTime.this.value4_1 = 0;
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                    return;
                }
                RzcJianghuaiChargingTime.this.value4_2++;
                if (RzcJianghuaiChargingTime.this.value4_2 > 23) {
                    RzcJianghuaiChargingTime.this.value4_2 = 0;
                }
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value5_m)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime rzcJianghuaiChargingTime = RzcJianghuaiChargingTime.this;
                    rzcJianghuaiChargingTime.value5--;
                    if (RzcJianghuaiChargingTime.this.value5 < 0) {
                        RzcJianghuaiChargingTime.this.value5 = 59;
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_value5_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcJianghuaiChargingTime.this.mode == 2) {
                    RzcJianghuaiChargingTime.this.value5++;
                    if (RzcJianghuaiChargingTime.this.value5 > 50) {
                        RzcJianghuaiChargingTime.this.value5 = 0;
                    }
                    RzcJianghuaiChargingTime.this.SendChargingData();
                }
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_set1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RzcJianghuaiChargingTime.this.mode = 1;
                RzcJianghuaiChargingTime.this.SendChargingData();
            }
        });
        ((Button) findViewById(R.id.jianghuai_chargingmode_set2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiChargingTime.13
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
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateCharingTimeValue1(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week1);
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week2);
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week3);
                break;
            case 4:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week4);
                break;
            case 5:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week5);
                break;
            case 6:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week6);
                break;
            case 7:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value1)).setText(R.string.str_week7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateModeSet(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_set1)).setText(R.string.str_percentage);
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_set2)).setText("---");
                UpdateCharingTimeValue1(this.value1_1);
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value2)).setText(new StringBuilder().append(this.value2_1).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value3)).setText(new StringBuilder().append(this.value3_1).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value4)).setText(new StringBuilder().append(this.value4_1).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value5)).setText("---");
                ((Button) findViewById(R.id.jianghuai_chargingmode_set1)).setSelected(true);
                ((Button) findViewById(R.id.jianghuai_chargingmode_set2)).setSelected(false);
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_set1)).setText(R.string.str_end_hour);
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_set2)).setText(R.string.str_end_munite);
                UpdateCharingTimeValue1(this.value1_2);
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value2)).setText(new StringBuilder().append(this.value2_2).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value3)).setText(new StringBuilder().append(this.value3_2).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value4)).setText(new StringBuilder().append(this.value4_2).toString());
                ((TextView) findViewById(R.id.rzc_jianghuai_chargingtime_value5)).setText(new StringBuilder().append(this.value5).toString());
                ((Button) findViewById(R.id.jianghuai_chargingmode_set1)).setSelected(false);
                ((Button) findViewById(R.id.jianghuai_chargingmode_set2)).setSelected(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendChargingData() {
        if (this.mode == 1) {
            DataCanbus.PROXY.cmd(2, new int[]{this.mode, this.value1_1, this.value2_1, this.value3_1, this.value4_1}, null, null);
        } else if (this.mode == 2) {
            DataCanbus.PROXY.cmd(2, new int[]{this.mode, this.value1_2, this.value2_2, this.value3_2, this.value4_2, this.value5}, null, null);
        }
    }
}