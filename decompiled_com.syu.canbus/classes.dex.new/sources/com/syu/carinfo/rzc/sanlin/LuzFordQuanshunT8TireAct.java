package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzFordQuanshunT8TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzFordQuanshunT8TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    LuzFordQuanshunT8TireAct.this.mUpdaterTireFL();
                    break;
                case 103:
                    LuzFordQuanshunT8TireAct.this.mUpdaterTireFR();
                    break;
                case 104:
                    LuzFordQuanshunT8TireAct.this.mUpdaterTireRL();
                    break;
                case 105:
                    LuzFordQuanshunT8TireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{41, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("----");
            } else {
                SystemProperties.getInt("persist.syu.reversetaiya", 0);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("----");
            } else {
                SystemProperties.getInt("persist.syu.reversetaiya", 0);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("----");
            } else {
                SystemProperties.getInt("persist.syu.reversetaiya", 0);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("----");
            } else {
                SystemProperties.getInt("persist.syu.reversetaiya", 0);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }
}
