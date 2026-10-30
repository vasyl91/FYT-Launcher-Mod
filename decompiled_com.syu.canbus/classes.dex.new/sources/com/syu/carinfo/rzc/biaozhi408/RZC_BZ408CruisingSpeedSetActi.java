package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408CruisingSpeedSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue4();
                    break;
                case 149:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue6();
                    break;
                case 150:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue5();
                    break;
                case 169:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue1();
                    break;
                case 170:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue2();
                    break;
                case 178:
                    RZC_BZ408CruisingSpeedSetActi.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_cruising_speed_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(52, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[178] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[178] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(54, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(54, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[150] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(55, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[150] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(55, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[149] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(56, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedSetActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[149] + 1;
                if (value > 255) {
                    value = 255;
                }
                DataCanbus.PROXY.cmd(56, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[169];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[170];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[178];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[150];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[149];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
