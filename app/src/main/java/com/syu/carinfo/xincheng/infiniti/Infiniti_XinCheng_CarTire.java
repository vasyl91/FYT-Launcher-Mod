package com.syu.carinfo.xincheng.infiniti;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.Locale;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Infiniti_XinCheng_CarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 31:
                    Infiniti_XinCheng_CarTire.this.mUpdaterTireFL();
                    break;
                case 32:
                    Infiniti_XinCheng_CarTire.this.mUpdaterTireFR();
                    break;
                case 33:
                    Infiniti_XinCheng_CarTire.this.mUpdaterTireRL();
                    break;
                case 34:
                    Infiniti_XinCheng_CarTire.this.mUpdaterTireRR();
                    break;
                case 35:
                    Infiniti_XinCheng_CarTire.this.updaterFLWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{112}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[31];
        int sys = DataCanbus.DATA[36];
        if (((sys >> 6) & 1) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
            String language = locale.getCountry();
            if (language.endsWith("CN")) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
            } else {
                int value2 = (value * 145) / 100;
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[32];
        int sys = DataCanbus.DATA[36];
        if (((sys >> 7) & 1) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
            String language = locale.getCountry();
            if (language.endsWith("CN")) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
            } else {
                int value2 = (value * 145) / 100;
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[33];
        int sys = DataCanbus.DATA[36];
        if (((sys >> 4) & 1) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
            String language = locale.getCountry();
            if (language.endsWith("CN")) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
            } else {
                int value2 = (value * 145) / 100;
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[34];
        int sys = DataCanbus.DATA[36];
        if (((sys >> 5) & 1) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
            String language = locale.getCountry();
            if (language.endsWith("CN")) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "kPa");
            } else {
                int value2 = (value * 145) / 100;
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[35];
        if (((value >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (((value >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
        if (((value >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (((value >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
        if (((value >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (((value >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
        if (((value >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (((value >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }
}