package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WCUAZPatriotCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    WCUAZPatriotCarSet.this.setCheck((CheckedTextView) WCUAZPatriotCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    WCUAZPatriotCarSet.this.setCheck((CheckedTextView) WCUAZPatriotCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_uaz_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[99];
                setCarInfo(17, value == 1 ? 0 : 1, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[100];
                setCarInfo(18, value2 == 1 ? 0 : 1, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
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
}
