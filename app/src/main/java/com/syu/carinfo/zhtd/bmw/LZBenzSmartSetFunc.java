package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LZBenzSmartSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((CheckedTextView) LZBenzSmartSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 99:
                    ((CheckedTextView) LZBenzSmartSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_benz_smart_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value3 = DataCanbus.DATA[98];
                if (value3 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value4 = DataCanbus.DATA[99];
                if (value4 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(1, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
    }
}
