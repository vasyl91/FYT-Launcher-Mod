package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalEscSystemActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalEscSystemActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 162:
                    Golf7_XP_FunctionalEscSystemActi.this.mUpdaterEscSystem();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_esc_system_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_esc_system_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalEscSystemActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[162] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{16, switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalEscSystemActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[162] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{16, switchOn}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEscSystem() {
        int switchOn = DataCanbus.DATA[162] & 255;
        if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
        }
    }
}
