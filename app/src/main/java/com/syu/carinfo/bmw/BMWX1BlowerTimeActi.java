package com.syu.carinfo.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0230_WC1_BMWX1;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BMWX1BlowerTimeActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 3:
                    BMWX1BlowerTimeActi.this.mUpdaterBlowerShow();
                    break;
                case 4:
                    BMWX1BlowerTimeActi.this.mUpdaterBlowerOnOff();
                    break;
                case 5:
                    BMWX1BlowerTimeActi.bmw_time1set = DataCanbus.DATA[5];
                    BMWX1BlowerTimeActi.this.mUpdaterBlower();
                    break;
                case 6:
                    BMWX1BlowerTimeActi.bmw_time2set = DataCanbus.DATA[6];
                    BMWX1BlowerTimeActi.this.mUpdaterBlower();
                    break;
                case 7:
                    BMWX1BlowerTimeActi.bmw_time1hour = Callback_0230_WC1_BMWX1.mBlower_Time[0];
                    BMWX1BlowerTimeActi.bmw_time1min = Callback_0230_WC1_BMWX1.mBlower_Time[1];
                    BMWX1BlowerTimeActi.bmw_time2hour = Callback_0230_WC1_BMWX1.mBlower_Time[2];
                    BMWX1BlowerTimeActi.bmw_time2min = Callback_0230_WC1_BMWX1.mBlower_Time[3];
                    BMWX1BlowerTimeActi.this.mUpdaterBlower();
                    break;
            }
        }
    };
    public static int bmw_timemode = 0;
    public static int bmw_time1hour = 0;
    public static int bmw_time1min = 0;
    public static int bmw_time2hour = 0;
    public static int bmw_time2min = 0;
    public static int bmw_time1set = 0;
    public static int bmw_time2set = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bmwx1_blower);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.bmwx1_blower_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[4];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_time1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BMWX1BlowerTimeActi.bmw_timemode = 0;
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_time2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BMWX1BlowerTimeActi.bmw_timemode = 1;
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmw_btn_timeh_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    if (BMWX1BlowerTimeActi.bmw_time1hour > 0) {
                        BMWX1BlowerTimeActi.bmw_time1hour--;
                    } else {
                        BMWX1BlowerTimeActi.bmw_time1hour = 23;
                    }
                } else if (BMWX1BlowerTimeActi.bmw_time2hour > 0) {
                    BMWX1BlowerTimeActi.bmw_time2hour--;
                } else {
                    BMWX1BlowerTimeActi.bmw_time2hour = 23;
                }
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmw_btn_timeh_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    if (BMWX1BlowerTimeActi.bmw_time1hour < 23) {
                        BMWX1BlowerTimeActi.bmw_time1hour++;
                    } else {
                        BMWX1BlowerTimeActi.bmw_time1hour = 0;
                    }
                } else if (BMWX1BlowerTimeActi.bmw_time2hour < 23) {
                    BMWX1BlowerTimeActi.bmw_time2hour++;
                } else {
                    BMWX1BlowerTimeActi.bmw_time2hour = 0;
                }
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmw_btn_timem_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    if (BMWX1BlowerTimeActi.bmw_time1min > 0) {
                        BMWX1BlowerTimeActi.bmw_time1min--;
                    } else {
                        BMWX1BlowerTimeActi.bmw_time1min = 59;
                    }
                } else if (BMWX1BlowerTimeActi.bmw_time2min > 0) {
                    BMWX1BlowerTimeActi.bmw_time2min--;
                } else {
                    BMWX1BlowerTimeActi.bmw_time2min = 59;
                }
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmw_btn_timem_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    if (BMWX1BlowerTimeActi.bmw_time1min < 59) {
                        BMWX1BlowerTimeActi.bmw_time1min++;
                    } else {
                        BMWX1BlowerTimeActi.bmw_time1min = 0;
                    }
                } else if (BMWX1BlowerTimeActi.bmw_time2min < 59) {
                    BMWX1BlowerTimeActi.bmw_time2min++;
                } else {
                    BMWX1BlowerTimeActi.bmw_time2min = 0;
                }
                BMWX1BlowerTimeActi.this.mUpdaterBlower();
            }
        });
        ((Button) findViewById(R.id.bmw_btn_timeset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{4, BMWX1BlowerTimeActi.bmw_time1hour, BMWX1BlowerTimeActi.bmw_time1min}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[]{7, BMWX1BlowerTimeActi.bmw_time2hour, BMWX1BlowerTimeActi.bmw_time2min}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{5}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_recall)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1BlowerTimeActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BMWX1BlowerTimeActi.bmw_timemode == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mUpdaterBlower();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlower() {
        if (bmw_timemode == 0) {
            ((Button) findViewById(R.id.bmwx1_btn_time1)).setBackgroundResource(R.drawable.bmw_time_p);
            ((Button) findViewById(R.id.bmwx1_btn_time2)).setBackgroundResource(R.drawable.bmw_time_n);
            if (bmw_time1set == 1) {
                ((TextView) findViewById(R.id.bmw_timeh)).setText(String.format("%d", Integer.valueOf(bmw_time1hour)));
                ((TextView) findViewById(R.id.bmw_timem)).setText(String.format("%d", Integer.valueOf(bmw_time1min)));
                return;
            } else {
                ((TextView) findViewById(R.id.bmw_timeh)).setText("--");
                ((TextView) findViewById(R.id.bmw_timem)).setText("--");
                return;
            }
        }
        ((Button) findViewById(R.id.bmwx1_btn_time1)).setBackgroundResource(R.drawable.bmw_time_n);
        ((Button) findViewById(R.id.bmwx1_btn_time2)).setBackgroundResource(R.drawable.bmw_time_p);
        if (bmw_time2set == 1) {
            ((TextView) findViewById(R.id.bmw_timeh)).setText(String.format("%d", Integer.valueOf(bmw_time2hour)));
            ((TextView) findViewById(R.id.bmw_timem)).setText(String.format("%d", Integer.valueOf(bmw_time2min)));
        } else {
            ((TextView) findViewById(R.id.bmw_timeh)).setText("--");
            ((TextView) findViewById(R.id.bmw_timem)).setText("--");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowerShow() {
        int value = DataCanbus.DATA[3];
        if (value == 0) {
            ((Button) findViewById(R.id.bmwx1_blower_onoff)).setVisibility(8);
        } else {
            ((Button) findViewById(R.id.bmwx1_blower_onoff)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowerOnOff() {
        int bmw_blower_onoff = DataCanbus.DATA[4];
        ((Button) findViewById(R.id.bmwx1_blower_onoff)).setBackgroundResource(bmw_blower_onoff == 0 ? R.drawable.bmw_blower_off : R.drawable.bmw_blower_on);
    }
}
