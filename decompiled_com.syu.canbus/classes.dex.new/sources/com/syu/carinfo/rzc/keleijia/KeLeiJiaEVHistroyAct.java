package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJiaEVHistroyAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaEVHistroyAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 217:
                    KeLeiJiaEVHistroyAct.this.updateCarinfo1();
                    break;
                case 218:
                    KeLeiJiaEVHistroyAct.this.updateCarinfo2();
                    break;
                case 219:
                    KeLeiJiaEVHistroyAct.this.updateCarinfo3();
                    break;
                case 220:
                    KeLeiJiaEVHistroyAct.this.updateCarinfo4();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0402_rzc_renault_ev_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{130, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[219];
        if (value >= 4095) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[219];
        if (value >= 4095) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[218];
        if (value >= 4095) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[217];
        if (value >= 1023) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100Km");
        }
    }
}
