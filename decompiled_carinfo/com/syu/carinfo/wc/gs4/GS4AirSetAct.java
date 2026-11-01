package com.syu.carinfo.wc.gs4;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class GS4AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    GS4AirSetAct.this.updaterAutoCompressor();
                    break;
                case 99:
                    GS4AirSetAct.this.updaterAutoCycleState();
                    break;
                case 100:
                    GS4AirSetAct.this.updaterComfort();
                    break;
                case 101:
                    GS4AirSetAct.this.updaterNegativeIonMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_289_wc_gs4_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_air_set_auto_compressor_check /* 2131429024 */:
                int mAutoCompre = DataCanbus.DATA[98];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = mAutoCompre == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_auto_cycle_state_check /* 2131429025 */:
                int mAutoCycle = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 3;
                iArr2[1] = mAutoCycle == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_air_set_comfort_curve_pre /* 2131429027 */:
                int mAirComfort = DataCanbus.DATA[100];
                if (mAirComfort == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (mAirComfort == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                } else if (mAirComfort == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_air_set_comfort_curve_next /* 2131429029 */:
                int mAirComfort2 = DataCanbus.DATA[100];
                if (mAirComfort2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                } else if (mAirComfort2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (mAirComfort2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                }
            case R.id.wc_chga6_negativeioc_modeengineer /* 2131429088 */:
                int mNegativeIonMode = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 22;
                iArr3[1] = mNegativeIonMode == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check)).setChecked(mAutoCompre != 0);
    }

    
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check)).setChecked(mAutoCycle != 0);
    }

    
    public void updaterNegativeIonMode() {
        int mNegativeIonMode = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer)).setChecked(mNegativeIonMode != 0);
    }

    
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[100];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
