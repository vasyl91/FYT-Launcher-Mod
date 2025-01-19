package com.syu.carinfo.wc.ruijie15;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RJCarSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    RJCarSetAct.this.updaterCameraDelay();
                    break;
                case 100:
                    RJCarSetAct.this.updaterTempUnit();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc3_15ruijie_car_set);
        setUI();
    }

    private void setUI() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                RJFunc.SET_TIPS_CMD(4, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                RJFunc.SET_CAR_CMD(5, DataCanbus.DATA[99] != 0 ? 0 : 1);
                break;
        }
    }

    
    public void updaterTempUnit() {
        int value = DataCanbus.DATA[100];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    
    public void updaterCameraDelay() {
        int value = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }
}
