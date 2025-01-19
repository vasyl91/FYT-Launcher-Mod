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

public class RzcDx7Settings extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyUI = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_assest_camera_check));
                    break;
                case 107:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_assest_light_check));
                    break;
                case 108:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_blind_warn_check));
                    break;
                case 109:
                    int value = DataCanbus.DATA[updateCode];
                    if (value == 0) {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_tv_show)).setText(R.string.str_pack_backcart);
                        break;
                    } else {
                        ((TextView) RzcDx7Settings.this.findViewById(R.id.rzc_dx7_tv_show)).setText(R.string.str_boyue_str15);
                        break;
                    }
                case 112:
                    RzcDx7Settings.this.UpdateUI(updateCode, (CheckedTextView) RzcDx7Settings.this.findViewById(R.id.ctv_checkedtext1));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_setting_trip_info);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                sendCommand(5, 112);
                break;
            case R.id.rzc_dx7_assest_camera_check /* 2131432753 */:
                sendCommand(1, 106);
                break;
            case R.id.rzc_dx7_assest_light_check /* 2131432755 */:
                sendCommand(2, 107);
                break;
            case R.id.rzc_dx7_blind_warn_check /* 2131432757 */:
                sendCommand(3, 108);
                break;
            case R.id.rzc_dx7_btn_show_left /* 2131432758 */:
            case R.id.rzc_dx7_btn_show_right /* 2131432760 */:
                sendCommand(4, 109);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyUI, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyUI, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyUI);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyUI);
    }

    
    public void UpdateUI(int function, CheckedTextView view) {
        int value = DataCanbus.DATA[function];
        if (view != null) {
            view.setChecked(value != 0);
        }
    }
}
