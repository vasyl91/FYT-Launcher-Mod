package com.syu.carinfo.rzc.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_0255_FengShenAx7_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.hantengx5.RZC_0255_FengShenAx7_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 23:
                    RZC_0255_FengShenAx7_CarSettingAct.this.updateTurnRightSwitch();
                    break;
                case 24:
                    RZC_0255_FengShenAx7_CarSettingAct.this.updateBlindMonitorSwitch();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_rzc_fengshenax7_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.hantengx5.RZC_0255_FengShenAx7_CarSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[25];
                int value = DataCanbus.DATA[23];
                if (value == 1) {
                    switchOn = switchOn2 & 1;
                } else {
                    switchOn = switchOn2 | 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.hantengx5.RZC_0255_FengShenAx7_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[25] & 255;
                int value = DataCanbus.DATA[24];
                if (value == 1) {
                    switchOn = switchOn2 & 2;
                } else {
                    switchOn = switchOn2 | 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{switchOn}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTurnRightSwitch() {
        int ambientlight = DataCanbus.DATA[23];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), ambientlight != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindMonitorSwitch() {
        int seatcourtesy = DataCanbus.DATA[24];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), seatcourtesy != 0);
    }
}
