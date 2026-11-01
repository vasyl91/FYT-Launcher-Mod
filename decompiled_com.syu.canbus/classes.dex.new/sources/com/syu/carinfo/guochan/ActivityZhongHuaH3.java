package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityZhongHuaH3 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityZhongHuaH3.1
        int value;

        @Override // com.syu.module.IUiNotify
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_zhonghua_h3);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                this.value = DataCanbus.DATA[142] & 255;
                setCarCmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                this.value = DataCanbus.DATA[145] & 255;
                setCarCmd(4, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                this.value = DataCanbus.DATA[146] & 255;
                setCarCmd(5, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                this.value = DataCanbus.DATA[143] & 255;
                setCarCmd(2, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                this.value = DataCanbus.DATA[144] & 255;
                setCarCmd(3, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                this.value = DataCanbus.DATA[147] & 255;
                setCarCmd(6, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
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
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    protected void updateAutoUnLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }

    protected void updateAutoReLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
    }

    protected void updateDoorUnLock(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
    }

    protected void updateLockDoubleLight(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view5).setVisibility(8);
        }
    }

    protected void updateUnLockDoubleLight(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
    }

    protected void updateRearViewAutoFold(int value) {
        if (((value >> 8) & 1) == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked((value & 255) != 0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
        }
    }
}
