package com.syu.carinfo.oudi.changan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

public class OdChanganTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:102:0x01fb  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x02b2  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x02dc  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x022d  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0306  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01b0  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0276  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0288  */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onNotify(int r8, int[] r9, float[] r10, java.lang.String[] r11) {
            /*
                Method dump skipped, instructions count: 948
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.oudi.changan.OdChanganTireAct.AnonymousClass1.onNotify(int, int[], float[], java.lang.String[]):void");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            //setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            //setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterFLWalm2() {
        int system = DataCanbus.DATA[118];
        int system1 = DataCanbus.DATA[119];
        int system2 = DataCanbus.DATA[120];
        int value = DataCanbus.DATA[125];
        int value1 = DataCanbus.DATA[126];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFRWalm2() {
        int system = DataCanbus.DATA[129];
        int system1 = DataCanbus.DATA[130];
        int system2 = DataCanbus.DATA[131];
        int value = DataCanbus.DATA[136];
        int value1 = DataCanbus.DATA[137];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRLWalm2() {
        int system = DataCanbus.DATA[140];
        int system1 = DataCanbus.DATA[141];
        int system2 = DataCanbus.DATA[142];
        int value = DataCanbus.DATA[147];
        int value1 = DataCanbus.DATA[148];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRRWalm2() {
        int system = DataCanbus.DATA[151];
        int system1 = DataCanbus.DATA[152];
        int system2 = DataCanbus.DATA[153];
        int value = DataCanbus.DATA[158];
        int value1 = DataCanbus.DATA[159];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[101];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (value * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (value * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (value * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (value * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[106];
        int value = DataCanbus.DATA[107];
        int value1 = DataCanbus.DATA[108];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[109];
        int value = DataCanbus.DATA[110];
        int value1 = DataCanbus.DATA[111];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[112];
        int value = DataCanbus.DATA[113];
        int value1 = DataCanbus.DATA[114];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[115];
        int value = DataCanbus.DATA[116];
        int value1 = DataCanbus.DATA[117];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }
}
