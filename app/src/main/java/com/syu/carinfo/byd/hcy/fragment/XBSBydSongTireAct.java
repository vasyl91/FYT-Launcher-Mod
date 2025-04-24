package com.syu.carinfo.byd.hcy.fragment;

import android.widget.TextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBSBydSongTireAct extends BaseFragment {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_oudi_zt_t600_tire;
    }

    @Override
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

    @Override
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

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[125];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[126];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[127];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[128];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
        }
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[129];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[130];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[131];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[132];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
