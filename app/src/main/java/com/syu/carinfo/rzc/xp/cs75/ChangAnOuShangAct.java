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

public class ChangAnOuShangAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    ChangAnOuShangAct.this.mUpdaterDrivingMileage();
                    break;
                case 101:
                    ChangAnOuShangAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 103:
                    ChangAnOuShangAct.this.mUpdaterValue8();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzcxp_oushang);
        setupView();
    }

    private void setupView() {
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[103] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(3, iArr, null, null);
                }
            });
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[103] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)) != null) {
            int value = DataCanbus.DATA[101];
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_normal);
            } else {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_low);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[100];
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
