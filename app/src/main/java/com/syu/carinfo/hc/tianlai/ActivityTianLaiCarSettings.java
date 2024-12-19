package com.syu.carinfo.hc.tianlai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityTianLaiCarSettings extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 31:
                    ActivityTianLaiCarSettings.this.mUpdaterCarVol();
                    break;
                case 32:
                    ActivityTianLaiCarSettings.this.mUpdaterCarEQBass();
                    break;
                case 33:
                    ActivityTianLaiCarSettings.this.mUpdaterCarEQTreble();
                    break;
                case 34:
                    ActivityTianLaiCarSettings.this.mUpdaterCarEQBal();
                    break;
                case 35:
                    ActivityTianLaiCarSettings.this.mUpdaterCarEQFad();
                    break;
                case 36:
                    ActivityTianLaiCarSettings.this.mUpdaterCarSurroundVol();
                    break;
                case 37:
                    ActivityTianLaiCarSettings.this.mUpdaterBoseCenterpoint();
                    break;
                case 38:
                    ActivityTianLaiCarSettings.this.mUpdaterSpeedVol();
                    break;
                case 41:
                    ActivityTianLaiCarSettings.this.mUpdaterInteriorIllumination();
                    break;
                case 42:
                    ActivityTianLaiCarSettings.this.mUpdaterHeadlightSensitivity();
                    break;
                case 43:
                    ActivityTianLaiCarSettings.this.mUpdaterSpeedSensingWiper();
                    break;
                case 44:
                    ActivityTianLaiCarSettings.this.mUpdaterIntelligentKey();
                    break;
                case 45:
                    ActivityTianLaiCarSettings.this.mUpdaterHeadlightsDelaytime();
                    break;
                case 46:
                    ActivityTianLaiCarSettings.this.mUpdaterSelecteUnlock();
                    break;
                case 48:
                    ActivityTianLaiCarSettings.this.mUpdaterDriveEnable();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hc_tianlaigongjue_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 7799223 || DataCanbus.DATA[1000] == 65988 || DataCanbus.DATA[1000] == 1442245) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{6}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{8}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{7}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{10}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{9}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{14}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{13}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{12}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{11}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[42] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[42] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[45] - 1;
                if (value < 0) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[45] + 1;
                if (value > 7) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{15}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[41];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[43];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[46];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriveEnable() {
        int value = DataCanbus.DATA[48];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightsDelaytime() {
        int value = DataCanbus.DATA[45];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text10)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text10)).setText("90s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text10)).setText("120s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text10)).setText("150s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text10)).setText("180s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterIntelligentKey() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSelecteUnlock() {
        int value = DataCanbus.DATA[46];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedSensingWiper() {
        int value = DataCanbus.DATA[43];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightSensitivity() {
        int value = DataCanbus.DATA[42];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorIllumination() {
        int value = DataCanbus.DATA[41];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedVol() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBoseCenterpoint() {
        int value = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarSurroundVol() {
        int value = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                return;
            }
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQFad() {
        int value = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tv_text6)).setText("R" + (256 - value));
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText("F" + value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQBal() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tv_text5)).setText("L" + (256 - value));
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("R" + value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQTreble() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                return;
            }
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQBass() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tv_text3)).setText("-" + (256 - value));
                return;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarVol() {
        int value = DataCanbus.DATA[31];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }
}
