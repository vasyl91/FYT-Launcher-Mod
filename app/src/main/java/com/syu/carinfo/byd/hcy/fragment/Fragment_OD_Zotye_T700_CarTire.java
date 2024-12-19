package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_OD_Zotye_T700_CarTire extends BaseFragment implements View.OnClickListener {
    int[] ids = {27, 28, 29, 30, 31, 32, 33, 34, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_OD_Zotye_T700_CarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 27:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFL();
                    break;
                case 28:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFR();
                    break;
                case 29:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRL();
                    break;
                case 30:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRR();
                    break;
                case 31:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFL();
                    break;
                case 32:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFR();
                    break;
                case 33:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRL();
                    break;
                case 34:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRR();
                    break;
                case 44:
                case 45:
                case 46:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFLWalm();
                    break;
                case 47:
                case 48:
                case 49:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFRWalm();
                    break;
                case 50:
                case 51:
                case 52:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRLWalm();
                    break;
                case 53:
                case 54:
                case 55:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRRWalm();
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
        return LauncherApplication.getConfiguration() == 1 ? R.layout.layout_xbs_tule_tire : R.layout.layout_oudi_zt_t600_tire;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57}, null, null);
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[44];
        int value = DataCanbus.DATA[45];
        int value1 = DataCanbus.DATA[46];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[47];
        int value = DataCanbus.DATA[48];
        int value1 = DataCanbus.DATA[49];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[50];
        int value = DataCanbus.DATA[51];
        int value1 = DataCanbus.DATA[52];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[53];
        int value = DataCanbus.DATA[54];
        int value1 = DataCanbus.DATA[55];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[31];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[33];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[34];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[27];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[28];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[29];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[30];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
