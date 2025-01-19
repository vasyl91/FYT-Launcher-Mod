package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

public class Fragment_OD_Zotye_T700_CarTire extends BaseFragment implements View.OnClickListener {
    int[] ids = {98, 99, 100, 101, 102, 103, 104, 105, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFL();
                    break;
                case 99:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFR();
                    break;
                case 100:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRL();
                    break;
                case 101:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRR();
                    break;
                case 102:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFL();
                    break;
                case 103:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFR();
                    break;
                case 104:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRL();
                    break;
                case 105:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRR();
                    break;
                case 114:
                case 115:
                case 116:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFLWalm();
                    break;
                case 117:
                case 118:
                case 119:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFRWalm();
                    break;
                case 120:
                case 121:
                case 122:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRLWalm();
                    break;
                case 123:
                case 124:
                case 125:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return LauncherApplication.getConfiguration() == 1 ? R.layout.layout_xbs_tule_tire : R.layout.layout_oudi_zt_t600_tire;
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57}, null, null);
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[114];
        int value = DataCanbus.DATA[115];
        int value1 = DataCanbus.DATA[116];
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

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[117];
        int value = DataCanbus.DATA[118];
        int value1 = DataCanbus.DATA[119];
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

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[120];
        int value = DataCanbus.DATA[121];
        int value1 = DataCanbus.DATA[122];
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

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[123];
        int value = DataCanbus.DATA[124];
        int value1 = DataCanbus.DATA[125];
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

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    @Override
    public void onClick(View v) {
    }
}
