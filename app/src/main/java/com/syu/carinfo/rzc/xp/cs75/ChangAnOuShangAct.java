package com.syu.carinfo.rzc.xp.cs75;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ChangAnOuShangAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnOuShangAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                    ChangAnOuShangAct.this.mUpdaterDrivingMileage();
                    break;
                case 3:
                    ChangAnOuShangAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 24:
                    ChangAnOuShangAct.this.mUpdaterValue8();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzcxp_oushang);
        setupView();
    }

    private void setupView() {
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnOuShangAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[24] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(3, iArr, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[24] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)) != null) {
            int value = DataCanbus.DATA[3];
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_normal);
            } else {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[2];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)).setText(String.valueOf(str) + " KM");
        }
    }
}
