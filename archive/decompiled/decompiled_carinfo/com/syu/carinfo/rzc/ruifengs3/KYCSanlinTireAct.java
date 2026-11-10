package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.text.DecimalFormat;

@SuppressWarnings({"deprecation", "unchecked"})
public class KYCSanlinTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    KYCSanlinTireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    KYCSanlinTireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    KYCSanlinTireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    KYCSanlinTireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    KYCSanlinTireAct.this.mUpdaterTireBack();
                    break;
                case 103:
                    KYCSanlinTireAct.this.mUpdaterTempFL();
                    break;
                case 104:
                    KYCSanlinTireAct.this.mUpdaterTempFR();
                    break;
                case 105:
                    KYCSanlinTireAct.this.mUpdaterTempRL();
                    break;
                case 106:
                    KYCSanlinTireAct.this.mUpdaterTempRR();
                    break;
                case 107:
                    KYCSanlinTireAct.this.mUpdaterTempBack();
                    break;
                case 108:
                    KYCSanlinTireAct.this.updaterFLWalm();
                    break;
                case 109:
                    KYCSanlinTireAct.this.updaterFRWalm();
                    break;
                case 110:
                    KYCSanlinTireAct.this.updaterRLWalm();
                    break;
                case 111:
                    KYCSanlinTireAct.this.updaterRRWalm();
                    break;
                case 112:
                    KYCSanlinTireAct.this.updaterBackWalm();
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
        DataCanbus.PROXY.cmd(1, new int[]{96}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[108];
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText("      " + system + "/4");
    }

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[109];
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText("              " + system + "/4");
    }

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[110];
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText("      " + system + "/4");
    }

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[111];
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText("              " + system + "/4");
    }

    
    public void updaterBackWalm() {
        int system = DataCanbus.DATA[112];
        ((TextView) findViewById(R.id.oudi_changan_tire5_warn)).setText(String.valueOf(system) + "/4");
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 50) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 50) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 50) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 50) + "℃");
        }
    }

    
    public void mUpdaterTempBack() {
        int value = DataCanbus.DATA[107];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire5_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire5_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire5_temp)).setText(String.valueOf(value - 50) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((int) ((value / 2.94f) * 100.0f)) / 100.0f)) + " Psi");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((int) ((value / 2.94f) * 100.0f)) / 100.0f)) + " Psi");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((int) ((value / 2.94f) * 100.0f)) / 100.0f)) + " Psi");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((int) ((value / 2.94f) * 100.0f)) / 100.0f)) + " Psi");
        }
    }

    
    public void mUpdaterTireBack() {
        int value = DataCanbus.DATA[102];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire5)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire5)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire5)).setText(String.valueOf(df.format(((int) ((value / 2.94f) * 100.0f)) / 100.0f)) + " Psi");
        }
    }
}
