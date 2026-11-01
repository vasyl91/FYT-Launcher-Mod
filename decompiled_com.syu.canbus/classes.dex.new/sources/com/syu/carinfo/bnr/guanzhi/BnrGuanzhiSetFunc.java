package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BnrGuanzhiSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    BnrGuanzhiSetFunc.this.mUpdaterRearVilewAutoOn(value);
                    break;
                case 100:
                    BnrGuanzhiSetFunc.this.mUpdaterWelcomeLightOn(value);
                    break;
                case 101:
                    BnrGuanzhiSetFunc.this.updateHomelightLev(value);
                    break;
                case 102:
                    BnrGuanzhiSetFunc.this.updateMeterlightLev(value);
                    break;
                case 103:
                    BnrGuanzhiSetFunc.this.updateDistanceUnitLev(value);
                    break;
                case 104:
                    BnrGuanzhiSetFunc.this.updateTimeFormatLev(value);
                    break;
                case 105:
                    BnrGuanzhiSetFunc.this.updateTempUnitLev(value);
                    break;
                case 106:
                    BnrGuanzhiSetFunc.this.updateOilUnitLev(value);
                    break;
                case 108:
                    BnrGuanzhiSetFunc.this.updateTrunkangleLev(value);
                    break;
                case 118:
                    ((TextView) BnrGuanzhiSetFunc.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                    break;
                case 119:
                    ((TextView) BnrGuanzhiSetFunc.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    break;
                case 120:
                    ((TextView) BnrGuanzhiSetFunc.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "km");
                    break;
                case 121:
                    ((TextView) BnrGuanzhiSetFunc.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnrguanzhi_setfunc);
        if (DataCanbus.DATA[1000] == 524741) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[99];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 12;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] + 1;
                if (value > 12) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] + 1;
                if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[103] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[103] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[105] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[105] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[104] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] - 5;
                if (value < 0) {
                    value = 100;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiSetFunc.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] + 5;
                if (value > 100) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrunkangleLev(int value) {
        ((TextView) findViewById(R.id.tv_text7)).setText(String.format("%d", Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOilUnitLev(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText("L/100Km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText("mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText("Km/L");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnitLev(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("℃");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("℉");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeFormatLev(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_bogoo_bmw_time_format_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_bogoo_bmw_time_format_1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDistanceUnitLev(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMeterlightLev(int value) {
        ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomelightLev(int value) {
        ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%ds", Integer.valueOf(value * 5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearVilewAutoOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWelcomeLightOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }
}
