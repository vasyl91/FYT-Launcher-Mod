package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcDx7Settings extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyUI = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.RzcDx7Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.ctv_checkedtext2));
                    break;
                case 107:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.ctv_checkedtext3));
                    break;
                case 108:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.ctv_checkedtext4));
                    break;
                case 109:
                    int value = DataCanbus.DATA[updateCode];
                    if (value == 0) {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_pack_backcart);
                    } else {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_boyue_str15);
                    }
                    break;
                case 112:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.ctv_checkedtext1));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_setting_trip_info);
        initClick();
    }

    private void setOnClick(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    private void initClick() {
        setOnClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setOnClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setOnClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        setOnClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setOnClick((Button) findViewById(R.id.btn_minus1));
        setOnClick((Button) findViewById(R.id.btn_plus1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
            case R.id.btn_plus1 /* 2131427458 */:
                sendCommand(4, 109);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                sendCommand(5, 112);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                sendCommand(3, 108);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                sendCommand(1, 106);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                sendCommand(2, 107);
                break;
        }
    }

    private void sendCommand(int function, int id) {
        int value = DataCanbus.DATA[id];
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[1];
        iArr[0] = value == 1 ? 0 : 1;
        remoteModuleProxy.cmd(function, iArr, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyUI, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyUI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateUI(int function, CheckedTextView view) {
        int value = DataCanbus.DATA[function];
        if (view != null) {
            view.setChecked(value != 0);
        }
    }
}
