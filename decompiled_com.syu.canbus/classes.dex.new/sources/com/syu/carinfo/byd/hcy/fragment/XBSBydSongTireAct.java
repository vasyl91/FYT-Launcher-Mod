package com.syu.carinfo.byd.hcy.fragment;

import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XBSBydSongTireAct extends BaseFragment {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.XBSBydSongTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 125:
                    XBSBydSongTireAct.this.mUpdaterTireFL();
                    break;
                case 126:
                    XBSBydSongTireAct.this.mUpdaterTireFR();
                    break;
                case 127:
                    XBSBydSongTireAct.this.mUpdaterTireRL();
                    break;
                case 128:
                    XBSBydSongTireAct.this.mUpdaterTireRR();
                    break;
                case 129:
                    XBSBydSongTireAct.this.updaterFLWalm();
                    break;
                case 130:
                    XBSBydSongTireAct.this.updaterFRWalm();
                    break;
                case 131:
                    XBSBydSongTireAct.this.updaterRLWalm();
                    break;
                case 132:
                    XBSBydSongTireAct.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return TheApp.getConfiguration() == 1 ? R.layout.layout_xbs_tule_tire : R.layout.layout_oudi_zt_t600_tire;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[125];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        }
        int value2 = value * 10;
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                break;
            case 1:
                int value3 = (value2 * 1000) / 6895;
                ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                break;
            case 2:
                int value4 = value2 / 100;
                ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[126];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        }
        int value2 = value * 10;
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                break;
            case 1:
                int value3 = (value2 * 1000) / 6895;
                ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                break;
            case 2:
                int value4 = value2 / 100;
                ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[127];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        }
        int value2 = value * 10;
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                break;
            case 1:
                int value3 = (value2 * 1000) / 6895;
                ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                break;
            case 2:
                int value4 = value2 / 100;
                ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[128];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        }
        int value2 = value * 10;
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                break;
            case 1:
                int value3 = (value2 * 1000) / 6895;
                ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                break;
            case 2:
                int value4 = value2 / 100;
                ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[129];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[130];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[131];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[132];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
