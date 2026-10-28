package com.syu.carinfo.rzc.beiqi;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity19EC5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (val == 1) {
                        Activity19EC5CarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        Activity19EC5CarSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        ((TextView) Activity19EC5CarSet.this.findViewById(R.id.tv_text1)).setText("踩下");
                        break;
                    } else {
                        Activity19EC5CarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        Activity19EC5CarSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        ((TextView) Activity19EC5CarSet.this.findViewById(R.id.tv_text1)).setText("松开");
                        break;
                    }
                case 115:
                    Activity19EC5CarSet.this.setCheck((CheckedTextView) Activity19EC5CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 116:
                    Activity19EC5CarSet.this.setCheck((CheckedTextView) Activity19EC5CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
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
                int value = DataCanbus.DATA[115];
                int value1 = DataCanbus.DATA[116];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{((value << 7) & 128) | ((value1 << 6) & 64)}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[115];
                int value12 = DataCanbus.DATA[116];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{((value2 << 7) & 128) | ((value12 << 6) & 64)}, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(6, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }
}
