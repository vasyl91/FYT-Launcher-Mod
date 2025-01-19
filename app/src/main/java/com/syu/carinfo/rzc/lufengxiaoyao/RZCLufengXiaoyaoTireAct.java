package com.syu.carinfo.rzc.lufengxiaoyao;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCLufengXiaoyaoTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0118  */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onNotify(int r8, int[] r9, float[] r10, java.lang.String[] r11) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoTireAct.AnonymousClass1.onNotify(int, int[], float[], java.lang.String[]):void");
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[98];
        int value1 = DataCanbus.DATA[110];
        int value2 = DataCanbus.DATA[111];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[99];
        int value1 = DataCanbus.DATA[118];
        int value2 = DataCanbus.DATA[119];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[100];
        int value1 = DataCanbus.DATA[134];
        int value2 = DataCanbus.DATA[135];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[101];
        int value1 = DataCanbus.DATA[126];
        int value2 = DataCanbus.DATA[127];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
        int value1 = DataCanbus.DATA[106];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[114];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
        int value1 = DataCanbus.DATA[130];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
        int value1 = DataCanbus.DATA[122];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[107];
        int value1 = DataCanbus.DATA[108];
        int value2 = DataCanbus.DATA[109];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[115];
        int value1 = DataCanbus.DATA[116];
        int value2 = DataCanbus.DATA[117];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[131];
        int value1 = DataCanbus.DATA[132];
        int value2 = DataCanbus.DATA[133];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[123];
        int value1 = DataCanbus.DATA[124];
        int value2 = DataCanbus.DATA[125];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
        }
    }
}
