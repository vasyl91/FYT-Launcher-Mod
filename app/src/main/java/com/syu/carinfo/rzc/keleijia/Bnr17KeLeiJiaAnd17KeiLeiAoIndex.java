package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Bnr17KeLeiJiaAnd17KeiLeiAoIndex extends BaseActivity {
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 185:
                    if (((CheckedTextView) Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val != 0);
                        break;
                    }
                case 204:
                    Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.uAirMode(val);
                    break;
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    int value = DataCanbus.DATA[185] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 50;
                    iArr[1] = value == 1 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.bnr_air_soft /* 2131430603 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(25, DataCanbus.DATA[204] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(50, DataCanbus.DATA[204] & 32);
                        break;
                    }
                case R.id.bnr_air_normal /* 2131430604 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(27, DataCanbus.DATA[204] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(51, DataCanbus.DATA[204] & 16);
                        break;
                    }
                case R.id.bnr_air_fast /* 2131430605 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(26, DataCanbus.DATA[204] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(52, DataCanbus.DATA[204] & 8);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bnr_17keleijiaand17keileiao_airset);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this.mClickListener);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }

    
    public void setCarCMD(final int cmd, int id) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    protected void uAirMode(int val) {
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
            int status = (val >> 6) & 1;
            if (status == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(false);
            }
            int status2 = (val >> 4) & 1;
            if (status2 == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(false);
            }
            int status3 = (val >> 5) & 1;
            if (status3 == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(true);
                return;
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(false);
                return;
            }
        }
        int status4 = val & 32;
        if (status4 == 32) {
            ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(false);
        }
        int status5 = val & 16;
        if (status5 == 16) {
            ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(false);
        }
        int status6 = val & 8;
        if (status6 == 8) {
            ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(false);
        }
    }
}
