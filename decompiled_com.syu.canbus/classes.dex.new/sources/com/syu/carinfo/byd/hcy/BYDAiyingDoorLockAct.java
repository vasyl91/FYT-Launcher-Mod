package com.syu.carinfo.byd.hcy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BYDAiyingDoorLockAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.BYDAiyingDoorLockAct.1
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_aiying_byd_doorlock_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int bit2;
        int bit3;
        int bit6;
        int bit7;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int bit8 = DataCanbus.DATA[107];
                int bit9 = DataCanbus.DATA[108];
                int bit4 = DataCanbus.DATA[109];
                int bit5 = DataCanbus.DATA[110];
                if (bit8 == 1) {
                    bit7 = 0;
                } else {
                    bit7 = 1;
                }
                int value = ((bit7 << 7) & 128) | ((bit9 << 6) & 64) | ((bit4 << 3) & 8) | ((bit5 << 2) & 4);
                setCarInfo(value);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int bit10 = DataCanbus.DATA[107];
                int bit11 = DataCanbus.DATA[108];
                int bit12 = DataCanbus.DATA[109];
                int bit13 = DataCanbus.DATA[110];
                if (bit13 == 1) {
                    bit2 = 0;
                } else {
                    bit2 = 1;
                }
                int value2 = ((bit10 << 7) & 128) | ((bit11 << 6) & 64) | ((bit12 << 3) & 8) | ((bit2 << 2) & 4);
                setCarInfo(value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int bit14 = DataCanbus.DATA[107];
                int bit15 = DataCanbus.DATA[108];
                int bit16 = DataCanbus.DATA[109];
                int bit17 = DataCanbus.DATA[110];
                if (bit15 == 1) {
                    bit6 = 0;
                } else {
                    bit6 = 1;
                }
                int value3 = ((bit14 << 7) & 128) | ((bit6 << 6) & 64) | ((bit16 << 3) & 8) | ((bit17 << 2) & 4);
                setCarInfo(value3);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int bit18 = DataCanbus.DATA[107];
                int bit19 = DataCanbus.DATA[108];
                int bit20 = DataCanbus.DATA[109];
                int bit21 = DataCanbus.DATA[110];
                if (bit20 == 1) {
                    bit3 = 0;
                } else {
                    bit3 = 1;
                }
                int value4 = ((bit18 << 7) & 128) | ((bit19 << 6) & 64) | ((bit3 << 3) & 8) | ((bit21 << 2) & 4);
                setCarInfo(value4);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }
}
