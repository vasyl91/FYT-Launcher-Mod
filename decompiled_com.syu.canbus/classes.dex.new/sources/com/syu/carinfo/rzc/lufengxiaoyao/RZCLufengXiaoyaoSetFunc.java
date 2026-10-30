package com.syu.carinfo.rzc.lufengxiaoyao;

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
public class RZCLufengXiaoyaoSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 139:
                    RZCLufengXiaoyaoSetFunc.this.updateRemoteUnlock();
                    break;
                case 140:
                    RZCLufengXiaoyaoSetFunc.this.updateAVMOn();
                    break;
                case 141:
                    RZCLufengXiaoyaoSetFunc.this.updateRemoteAutoWinOn();
                    break;
                case 142:
                    RZCLufengXiaoyaoSetFunc.this.updateDayLightOn();
                    break;
                case 143:
                    RZCLufengXiaoyaoSetFunc.this.updateAutoMirrotOn();
                    break;
                case 144:
                    RZCLufengXiaoyaoSetFunc.this.updateLightWelcomeOn();
                    break;
                case 145:
                    RZCLufengXiaoyaoSetFunc.this.updateHomeLight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_lufengxiaoyao_setfunc);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[139] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[139] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[140];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[143];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[144];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[145] - 1;
                if (value < 1) {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[145] + 1;
                if (value > 5) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomeLight() {
        int value = DataCanbus.DATA[145];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_5);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_9);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLightWelcomeOn() {
        int value = DataCanbus.DATA[144];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoMirrotOn() {
        int value = DataCanbus.DATA[143];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDayLightOn() {
        int value = DataCanbus.DATA[142];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteAutoWinOn() {
        int value = DataCanbus.DATA[141];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAVMOn() {
        int value = DataCanbus.DATA[140];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteUnlock() {
        int value = DataCanbus.DATA[139];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_remote_unlock1);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_remote_unlock0);
                break;
        }
    }
}
