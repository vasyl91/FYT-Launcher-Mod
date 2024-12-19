package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityZhongHuaH3 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityZhongHuaH3.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 93:
                    ActivityZhongHuaH3.this.updateAutoLock(this.value);
                    break;
                case 94:
                    ActivityZhongHuaH3.this.updateAutoUnLock(this.value);
                    break;
                case 95:
                    ActivityZhongHuaH3.this.updateAutoReLock(this.value);
                    break;
                case 96:
                    ActivityZhongHuaH3.this.updateDoorUnLock(this.value);
                    break;
                case 97:
                    ActivityZhongHuaH3.this.updateLockDoubleLight(this.value);
                    break;
                case 98:
                    ActivityZhongHuaH3.this.updateUnLockDoubleLight(this.value);
                    break;
                case 99:
                    ActivityZhongHuaH3.this.updateRearViewAutoFold(this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_zhonghua_h3);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_419_auto_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_auto_relock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_door_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_lock_double_light)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_unlock_double_light)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_rear_view_auto_fold)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_419_auto_lock /* 2131430033 */:
                this.value = DataCanbus.DATA[93] & 255;
                setCarCmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.ctv_419_auto_unlock /* 2131430035 */:
                this.value = DataCanbus.DATA[94] & 255;
                setCarCmd(2, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_auto_relock /* 2131430037 */:
                this.value = DataCanbus.DATA[95] & 255;
                setCarCmd(3, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_door_unlock /* 2131430039 */:
                this.value = DataCanbus.DATA[96] & 255;
                setCarCmd(4, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_lock_double_light /* 2131430041 */:
                this.value = DataCanbus.DATA[97] & 255;
                setCarCmd(5, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_unlock_double_light /* 2131430043 */:
                this.value = DataCanbus.DATA[98] & 255;
                setCarCmd(6, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_rear_view_auto_fold /* 2131430045 */:
                this.value = DataCanbus.DATA[99] & 255;
                setCarCmd(7, this.value != 0 ? 0 : 1);
                break;
        }
    }

    private void setCarCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(3, cmd, value);
    }

    protected void updateAutoLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_auto_lock).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_auto_lock)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_auto_lock).setVisibility(8);
        }
    }

    protected void updateAutoUnLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_auto_unlock).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_auto_unlock)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_auto_unlock).setVisibility(8);
        }
    }

    protected void updateAutoReLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_auto_relock).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_auto_relock)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_auto_relock).setVisibility(8);
        }
    }

    protected void updateDoorUnLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_door_unlock).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_door_unlock)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_door_unlock).setVisibility(8);
        }
    }

    protected void updateLockDoubleLight(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_lock_double_light).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_lock_double_light)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_lock_double_light).setVisibility(8);
        }
    }

    protected void updateUnLockDoubleLight(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_unlock_double_light).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_unlock_double_light)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_unlock_double_light).setVisibility(8);
        }
    }

    protected void updateRearViewAutoFold(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_419_rear_view_auto_fold).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_rear_view_auto_fold)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_419_rear_view_auto_fold).setVisibility(8);
        }
    }
}
