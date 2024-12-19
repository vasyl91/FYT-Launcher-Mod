package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLTireAct extends Activity {
    public static YLTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 41:
                case 120:
                    YLTireAct.this.mUpdaterTireFL();
                    break;
                case 42:
                case 121:
                    YLTireAct.this.mUpdaterTireFR();
                    break;
                case 43:
                case 122:
                    YLTireAct.this.mUpdaterTireRL();
                    break;
                case 44:
                case 123:
                    YLTireAct.this.mUpdaterTireRR();
                    break;
                case 45:
                case 46:
                case 47:
                case 124:
                case 125:
                case 126:
                    YLTireAct.this.updaterFlHighWalm();
                    break;
                case 48:
                case 49:
                case 50:
                case 127:
                case 128:
                case 129:
                    YLTireAct.this.updaterFRHighWalm();
                    break;
                case 51:
                case 52:
                case 53:
                case 130:
                case 131:
                case 132:
                    YLTireAct.this.updaterRLHighWalm();
                    break;
                case 54:
                case 55:
                case 56:
                case 133:
                case 134:
                case 135:
                    YLTireAct.this.updaterRRHighWalm();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_tire);
        init();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        DataCanbus.PROXY.cmd(8, new int[]{74}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        if (Return_Wc_Canbus()) {
            DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        if (Return_Wc_Canbus()) {
            DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
    }

    private void init() {
        mInit = this;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[120];
        } else {
            value = DataCanbus.DATA[41];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[124];
            value2 = DataCanbus.DATA[125];
            value3 = DataCanbus.DATA[126];
        } else {
            value1 = DataCanbus.DATA[45];
            value2 = DataCanbus.DATA[46];
            value3 = DataCanbus.DATA[47];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[121];
        } else {
            value = DataCanbus.DATA[42];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[127];
            value2 = DataCanbus.DATA[128];
            value3 = DataCanbus.DATA[129];
        } else {
            value1 = DataCanbus.DATA[48];
            value2 = DataCanbus.DATA[49];
            value3 = DataCanbus.DATA[50];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[122];
        } else {
            value = DataCanbus.DATA[43];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[130];
            value2 = DataCanbus.DATA[131];
            value3 = DataCanbus.DATA[132];
        } else {
            value1 = DataCanbus.DATA[51];
            value2 = DataCanbus.DATA[52];
            value3 = DataCanbus.DATA[53];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[123];
        } else {
            value = DataCanbus.DATA[44];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[133];
            value2 = DataCanbus.DATA[134];
            value3 = DataCanbus.DATA[135];
        } else {
            value1 = DataCanbus.DATA[54];
            value2 = DataCanbus.DATA[55];
            value3 = DataCanbus.DATA[56];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    private boolean Return_Wc_Canbus() {
        return (DataCanbus.DATA[1000] & 65535) == 36 || DataCanbus.DATA[1000] == 655396 || DataCanbus.DATA[1000] == 524324 || DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 254 || DataCanbus.DATA[1000] == 357 || DataCanbus.DATA[1000] == 345 || DataCanbus.DATA[1000] == 459097 || DataCanbus.DATA[1000] == 65881 || DataCanbus.DATA[1000] == 131417 || DataCanbus.DATA[1000] == 524633 || DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 262489 || DataCanbus.DATA[1000] == 393252 || DataCanbus.DATA[1000] == 458788;
    }
}
