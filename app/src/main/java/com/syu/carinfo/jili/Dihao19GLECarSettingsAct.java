package com.syu.carinfo.jili;

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
public class Dihao19GLECarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 146:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.guandao_lock2);
                            break;
                        case 3:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                            break;
                    }
                case 147:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 148:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                    }
                case 149:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 150:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 151:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 152:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 153:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 154:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 155:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 156:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 157:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    if (((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text4)).setText(value == 1 ? R.string.jeep_forwardcollisionwarn_1 : R.string.jeep_forwardcollisionwarn_0);
                        break;
                    }
                case 158:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 159:
                    ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_139_rzc_dihao_gle);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 5;
                if (value < 20) {
                    value = 20;
                }
                DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 5;
                if (value > 80) {
                    value = 80;
                }
                DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[146] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[146] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 29, 149);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 30, 150);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 31, 151);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 32, 152);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 20, 153);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 33, 154);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 10, 155);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 34, 156);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 36, 158);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), 35, 157);
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.Dihao19GLECarSettingsAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    Dihao19GLECarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, value}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
