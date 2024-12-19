package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCBoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {100, 101, 102, 103, 104, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    if (((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(value == 1 ? R.string.driver_system_sports : R.string.wc_gs4_driver_help_turn_mode_comfort);
                    }
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_remotelock_recall), value == 1);
                    break;
                case 102:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_lockautoclosewindow), value == 1);
                    break;
                case 103:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 104:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 126:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 127:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 128:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 129:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                        case 1:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_lanesensewarn_1);
                            break;
                        case 2:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                    }
                case 131:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_shutdown_unlock), value == 1);
                    break;
                case 132:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_lock_turnoff_positionstate), value == 1);
                    break;
                case 133:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_static_railline), value == 1);
                    break;
                case 134:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_dynamic_railline), value == 1);
                    break;
                case 135:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_fisheye), value == 1);
                    break;
                case 136:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_rmode_5sdelay), value == 1);
                    break;
                case 137:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_singlebackcar_video), value == 1);
                    break;
                case 138:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.boyue_turnbymove), value == 1);
                    break;
            }
        }
    };

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_139_rzc_boyue);
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
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 6, 100);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 21, 126);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 22, 127);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 23, 128);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 24, 129);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 10, 104);
        sendClick((CheckedTextView) findViewById(R.id.boyue_remotelock_recall), 7, 101);
        sendClick((CheckedTextView) findViewById(R.id.boyue_lockautoclosewindow), 8, 102);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 9, 103);
        sendClick((CheckedTextView) findViewById(R.id.boyue_lock_turnoff_positionstate), 4, 132);
        sendClick((CheckedTextView) findViewById(R.id.boyue_shutdown_unlock), 1, 131);
        ((CheckedTextView) findViewById(R.id.boyue_static_railline)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{12}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.boyue_dynamic_railline)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[134];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.boyue_fisheye)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[135];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{17}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{16}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.boyue_rmode_5sdelay)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[136];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{19}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.boyue_singlebackcar_video)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[137];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{20}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.boyue_turnbymove)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[138];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{23}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{22}, null, null);
                }
            }
        });
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jili.RZCBoyueCarSettingsAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = cmd;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
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
}
