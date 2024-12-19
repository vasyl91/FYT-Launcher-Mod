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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcDx7Settings extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyUI = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.RzcDx7Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 28:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_assest_camera_check));
                    break;
                case 29:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_assest_light_check));
                    break;
                case 30:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_blind_warn_check));
                    break;
                case 31:
                    int value = DataCanbus.DATA[updateCode];
                    if (value == 0) {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_tv_show)).setText(R.string.str_pack_backcart);
                        break;
                    } else {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_tv_show)).setText(R.string.str_boyue_str15);
                        break;
                    }
                case 34:
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
        setOnClick((CheckedTextView) findViewById(R.id.rzc_dx7_assest_camera_check));
        setOnClick((CheckedTextView) findViewById(R.id.rzc_dx7_assest_light_check));
        setOnClick((CheckedTextView) findViewById(R.id.rzc_dx7_blind_warn_check));
        setOnClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setOnClick((Button) findViewById(R.id.rzc_dx7_btn_show_left));
        setOnClick((Button) findViewById(R.id.rzc_dx7_btn_show_right));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                sendCommand(5, 34);
                break;
            case R.id.rzc_dx7_assest_camera_check /* 2131432827 */:
                sendCommand(1, 28);
                break;
            case R.id.rzc_dx7_assest_light_check /* 2131432829 */:
                sendCommand(2, 29);
                break;
            case R.id.rzc_dx7_blind_warn_check /* 2131432831 */:
                sendCommand(3, 30);
                break;
            case R.id.rzc_dx7_btn_show_left /* 2131432832 */:
            case R.id.rzc_dx7_btn_show_right /* 2131432834 */:
                sendCommand(4, 31);
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
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyUI, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyUI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateUI(int function, CheckedTextView view) {
        int value = DataCanbus.DATA[function];
        if (view != null) {
            view.setChecked(value != 0);
        }
    }
}
