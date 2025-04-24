package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcKlcComfortAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    RzcKlcComfortAct.this.updaterRearWiperAuto();
                    break;
                case 129:
                    ((TextView) RzcKlcComfortAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    RzcKlcComfortAct.this.updaterWarnVol();
                    break;
                case 172:
                    ((CheckedTextView) RzcKlcComfortAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_klc_comfort_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[129];
                if (value > 0) {
                    value--;
                }
                RzcKlcFunc.CAR_WARNN_VOL(value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[129];
                if (value2 < 15) {
                    value2++;
                }
                RzcKlcFunc.CAR_WARNN_VOL(value2, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = DataCanbus.DATA[172] != 0 ? 0 : 1;
                remoteModuleProxy.cmd(97, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[129] == 6) {
                    RzcKlcFunc.CAR_WARNN_VOL(12, 0);
                    break;
                } else {
                    RzcKlcFunc.CAR_WARNN_VOL(6, 0);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                RzcKlcFunc.CAR_COMM_CONTROL(9, DataCanbus.DATA[114] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    
    public void updaterWarnVol() {
        int WarnVolState = DataCanbus.DATA[129];
        if (WarnVolState == 6) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_klc_nomal);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
        } else if (WarnVolState == 12) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(true);
        }
    }

    
    public void updaterRearWiperAuto() {
        int RearWiperAutoState = DataCanbus.DATA[114];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RearWiperAutoState != 0);
    }
}
