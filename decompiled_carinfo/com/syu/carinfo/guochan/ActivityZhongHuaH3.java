package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityZhongHuaH3 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    ActivityZhongHuaH3.this.updateAutoLock(this.value);
                    break;
                case 143:
                    ActivityZhongHuaH3.this.updateAutoUnLock(this.value);
                    break;
                case 144:
                    ActivityZhongHuaH3.this.updateAutoReLock(this.value);
                    break;
                case 145:
                    ActivityZhongHuaH3.this.updateDoorUnLock(this.value);
                    break;
                case 146:
                    ActivityZhongHuaH3.this.updateLockDoubleLight(this.value);
                    break;
                case 147:
                    ActivityZhongHuaH3.this.updateUnLockDoubleLight(this.value);
                    break;
                case 148:
                    ActivityZhongHuaH3.this.updateRearViewAutoFold(this.value);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_419_zhonghua_h3);
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_419_auto_lock /* 2131429985 */:
                this.value = DataCanbus.DATA[142] & 255;
                setCarCmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.ctv_419_auto_unlock /* 2131429987 */:
                this.value = DataCanbus.DATA[143] & 255;
                setCarCmd(2, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_auto_relock /* 2131429989 */:
                this.value = DataCanbus.DATA[144] & 255;
                setCarCmd(3, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_door_unlock /* 2131429991 */:
                this.value = DataCanbus.DATA[145] & 255;
                setCarCmd(4, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_lock_double_light /* 2131429993 */:
                this.value = DataCanbus.DATA[146] & 255;
                setCarCmd(5, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_unlock_double_light /* 2131429995 */:
                this.value = DataCanbus.DATA[147] & 255;
                setCarCmd(6, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_rear_view_auto_fold /* 2131429997 */:
                this.value = DataCanbus.DATA[148] & 255;
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
