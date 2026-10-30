package com.syu.carinfo.lz.infinit.fx35;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzInfinitF35CarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    LuzInfinitF35CarTire.this.mUpdaterTireFL();
                    break;
                case 107:
                    LuzInfinitF35CarTire.this.mUpdaterTireFR();
                    break;
                case 108:
                    LuzInfinitF35CarTire.this.mUpdaterTireRL();
                    break;
                case 109:
                    LuzInfinitF35CarTire.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_infinit_cartire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{54, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value2 / 100) + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 100) + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value2 / 100) + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value2 / 100) + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }
}
