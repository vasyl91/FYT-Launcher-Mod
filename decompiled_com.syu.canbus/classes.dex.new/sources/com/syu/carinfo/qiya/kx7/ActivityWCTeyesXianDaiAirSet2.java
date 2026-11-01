package com.syu.carinfo.qiya.kx7;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCTeyesXianDaiAirSet2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiAirSet2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    switch (value) {
                        case 1:
                            ActivityWCTeyesXianDaiAirSet2.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_airico1_p);
                            ActivityWCTeyesXianDaiAirSet2.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_teyes_elantra_sel_p);
                            break;
                        default:
                            ActivityWCTeyesXianDaiAirSet2.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_airico1_n);
                            ActivityWCTeyesXianDaiAirSet2.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_teyes_elantra_sel_n);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_teyes_xiandai_air_settings2);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427458 */:
                finish();
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[4];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                iArr[2] = 255;
                iArr[3] = 255;
                remoteModuleProxy.cmd(4, iArr, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }
}
