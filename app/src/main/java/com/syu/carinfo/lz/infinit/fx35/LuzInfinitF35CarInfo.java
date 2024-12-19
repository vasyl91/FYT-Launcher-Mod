package com.syu.carinfo.lz.infinit.fx35;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzInfinitF35CarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                case 28:
                    LuzInfinitF35CarInfo.this.mUpdateWaterTemp();
                    break;
                case 25:
                    LuzInfinitF35CarInfo.this.mUpdateSpeed();
                    break;
                case 26:
                    LuzInfinitF35CarInfo.this.mUpdateMile();
                    break;
                case 27:
                    ((TextView) LuzInfinitF35CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Rpm");
                    break;
                case 29:
                    LuzInfinitF35CarInfo.this.mUpdateSpeed();
                    LuzInfinitF35CarInfo.this.mUpdateMile();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_infinit_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaterTemp() {
        int value = DataCanbus.DATA[24];
        if (value >= 40) {
            int value2 = value - 40;
            if (DataCanbus.DATA[28] == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value2) + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value2) + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (DataCanbus.DATA[28] == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSpeed() {
        int value = DataCanbus.DATA[25];
        if (DataCanbus.DATA[29] == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mil/h");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMile() {
        int value = DataCanbus.DATA[26];
        if (DataCanbus.DATA[29] == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " Km");
        }
    }
}
