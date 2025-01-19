package com.syu.carinfo.od.tusheng;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_NaZHijieU6_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    RZC_NaZHijieU6_CarSettingAct.this.updateGuijiOn();
                    break;
                case 8:
                    RZC_NaZHijieU6_CarSettingAct.this.updateRadarOn();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_nazhijieu6_carsetting);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[7];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[8];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = value2 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateRadarOn() {
        int value = DataCanbus.DATA[8];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    
    public void updateGuijiOn() {
        int value = DataCanbus.DATA[7];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
