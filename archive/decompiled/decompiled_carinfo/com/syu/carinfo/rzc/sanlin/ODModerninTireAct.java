package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODModerninTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 140:
                    ODModerninTireAct.this.mUpdaterTireFL();
                    break;
                case 141:
                    ODModerninTireAct.this.mUpdaterTireFR();
                    break;
                case 142:
                    ODModerninTireAct.this.mUpdaterTireRL();
                    break;
                case 143:
                    ODModerninTireAct.this.mUpdaterTireRR();
                    break;
                case 144:
                    ODModerninTireAct.this.mUpdaterTempFL();
                    break;
                case 145:
                    ODModerninTireAct.this.mUpdaterTempFR();
                    break;
                case 146:
                    ODModerninTireAct.this.mUpdaterTempRL();
                    break;
                case 147:
                    ODModerninTireAct.this.mUpdaterTempRR();
                    break;
                case 148:
                    ODModerninTireAct.this.updaterFLWalm();
                    break;
                case 149:
                    ODModerninTireAct.this.updaterFRWalm();
                    break;
                case 150:
                    ODModerninTireAct.this.updaterRRWalm();
                    break;
                case 151:
                    ODModerninTireAct.this.updaterRLWalm();
                    break;
            }
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
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[148];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        }
    }

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[149];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        }
    }

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[151];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        }
    }

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[150];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
        }
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[144];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[145];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[146];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[147];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[140];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value2 = value * 275;
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10000) + "." + ((value2 % 10000) / 1000) + "bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[141];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value2 = value * 275;
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10000) + "." + ((value2 % 10000) / 1000) + "bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[142];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value2 = value * 275;
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10000) + "." + ((value2 % 10000) / 1000) + "bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[143];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value2 = value * 275;
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10000) + "." + ((value2 % 10000) / 1000) + "bar");
        }
    }
}
