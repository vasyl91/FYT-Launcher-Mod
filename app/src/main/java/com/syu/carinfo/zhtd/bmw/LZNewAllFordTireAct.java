package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewAllFordTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    LZNewAllFordTireAct.this.mUpdaterTireFL();
                    break;
                case 107:
                    LZNewAllFordTireAct.this.mUpdaterTireFR();
                    break;
                case 108:
                    LZNewAllFordTireAct.this.mUpdaterTireRL();
                    break;
                case 109:
                    LZNewAllFordTireAct.this.mUpdaterTireRR();
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
    public void addNotify() {
        DataCanbus.PROXY.cmd(7, new int[]{41, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
            }
        }
    }
}
