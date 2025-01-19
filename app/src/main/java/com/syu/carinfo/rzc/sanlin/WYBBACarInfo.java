package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WYBBACarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 113:
                    switch (value) {
                        case 0:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                case 114:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wy_bba_all_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        findViewById(R.id.layout_view1).setVisibility(8);
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
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value5 = DataCanbus.DATA[112];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(value5);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value6 = DataCanbus.DATA[112];
                if (value6 < 15) {
                    value6++;
                }
                setCarInfo(value6);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[113];
                if (value7 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value8 = DataCanbus.DATA[114];
                if (value8 == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{2, value4}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value9 = DataCanbus.DATA[115];
                if (value9 == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value3}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[117];
                if (value10 == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value2}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }
}
