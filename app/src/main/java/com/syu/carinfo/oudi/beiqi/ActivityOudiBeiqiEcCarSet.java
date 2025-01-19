package com.syu.carinfo.oudi.beiqi;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityOudiBeiqiEcCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    ActivityOudiBeiqiEcCarSet.this.setCheck((CheckedTextView) ActivityOudiBeiqiEcCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 104:
                    ActivityOudiBeiqiEcCarSet.this.setCheck((CheckedTextView) ActivityOudiBeiqiEcCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0227_rzc_19ec5_settings);
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
                int value = DataCanbus.DATA[103];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[104];
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value2}, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.layout_view3).setVisibility(8);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
