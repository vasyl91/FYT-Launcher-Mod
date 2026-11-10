package com.syu.carinfo.wc2.tata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2MHDCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    WC2MHDCarSet.this.setCheck((CheckedTextView) WC2MHDCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    WC2MHDCarSet.this.setCheck((CheckedTextView) WC2MHDCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
                    if (value == 65535) {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 101:
                    if (value == 65535) {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 102:
                    if (value == 65535) {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                        break;
                    }
                case 103:
                    if (value == 65535) {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 60) + ":" + (value % 60));
                        break;
                    }
                case 104:
                    if (value == 255) {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) WC2MHDCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_mhd_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[98];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[99];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WC2MHDTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
