package com.syu.carinfo.byd.hcy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BYDAiyingDoorLockAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    BYDAiyingDoorLockAct.this.setCheck((CheckedTextView) BYDAiyingDoorLockAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 108:
                    BYDAiyingDoorLockAct.this.setCheck((CheckedTextView) BYDAiyingDoorLockAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 109:
                    BYDAiyingDoorLockAct.this.setCheck((CheckedTextView) BYDAiyingDoorLockAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 110:
                    BYDAiyingDoorLockAct.this.setCheck((CheckedTextView) BYDAiyingDoorLockAct.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_aiying_byd_doorlock_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
    }

    @Override
    public void onClick(View v) {
        int bit2;
        int bit3;
        int bit6;
        int bit7;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int bit72 = DataCanbus.DATA[107];
                int bit62 = DataCanbus.DATA[108];
                int bit32 = DataCanbus.DATA[109];
                int bit22 = DataCanbus.DATA[110];
                if (bit72 == 1) {
                    bit7 = 0;
                } else {
                    bit7 = 1;
                }
                int value = ((bit7 << 7) & 128) | ((bit62 << 6) & 64) | ((bit32 << 3) & 8) | ((bit22 << 2) & 4);
                setCarInfo(value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int bit73 = DataCanbus.DATA[107];
                int bit63 = DataCanbus.DATA[108];
                int bit33 = DataCanbus.DATA[109];
                int bit23 = DataCanbus.DATA[110];
                if (bit63 == 1) {
                    bit6 = 0;
                } else {
                    bit6 = 1;
                }
                int value2 = ((bit73 << 7) & 128) | ((bit6 << 6) & 64) | ((bit33 << 3) & 8) | ((bit23 << 2) & 4);
                setCarInfo(value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int bit74 = DataCanbus.DATA[107];
                int bit64 = DataCanbus.DATA[108];
                int bit34 = DataCanbus.DATA[109];
                int bit24 = DataCanbus.DATA[110];
                if (bit34 == 1) {
                    bit3 = 0;
                } else {
                    bit3 = 1;
                }
                int value3 = ((bit74 << 7) & 128) | ((bit64 << 6) & 64) | ((bit3 << 3) & 8) | ((bit24 << 2) & 4);
                setCarInfo(value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int bit75 = DataCanbus.DATA[107];
                int bit65 = DataCanbus.DATA[108];
                int bit35 = DataCanbus.DATA[109];
                int bit25 = DataCanbus.DATA[110];
                if (bit25 == 1) {
                    bit2 = 0;
                } else {
                    bit2 = 1;
                }
                int value4 = ((bit75 << 7) & 128) | ((bit65 << 6) & 64) | ((bit35 << 3) & 8) | ((bit2 << 2) & 4);
                setCarInfo(value4);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }
}
