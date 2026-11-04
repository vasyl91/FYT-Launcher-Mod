package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RzcGolfPressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.RzcGolfPressureTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 184:
                    RzcGolfPressureTireAct.this.mUpdaterTireFL();
                    break;
                case 185:
                    RzcGolfPressureTireAct.this.mUpdaterTireFR();
                    break;
                case 186:
                    RzcGolfPressureTireAct.this.mUpdaterTireRL();
                    break;
                case 187:
                    RzcGolfPressureTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_golf_tire);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        String str = "";
        int value = DataCanbus.DATA[184];
        if (DataCanbus.DATA[252] == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 2) {
            str = String.valueOf(value * 10) + getTireUnit(DataCanbus.DATA[252]);
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(str);
    }

    private String getTireUnit(int i) {
        if (i == 0) {
            return "bar";
        }
        if (i == 1) {
            return "psi";
        }
        if (i != 2) {
            return "";
        }
        return "kpa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        String str = "";
        int value = DataCanbus.DATA[185];
        if (DataCanbus.DATA[252] == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 2) {
            str = String.valueOf(value * 10) + getTireUnit(DataCanbus.DATA[252]);
        }
        ((TextView) findViewById(R.id.tv_text2)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        String str = "";
        int value = DataCanbus.DATA[186];
        if (DataCanbus.DATA[252] == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 2) {
            str = String.valueOf(value * 10) + getTireUnit(DataCanbus.DATA[252]);
        }
        ((TextView) findViewById(R.id.tv_text3)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        String str = "";
        int value = DataCanbus.DATA[187];
        if (DataCanbus.DATA[252] == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(DataCanbus.DATA[252]);
        } else if (DataCanbus.DATA[252] == 2) {
            str = String.valueOf(value * 10) + getTireUnit(DataCanbus.DATA[252]);
        }
        ((TextView) findViewById(R.id.tv_text4)).setText(str);
    }
}
