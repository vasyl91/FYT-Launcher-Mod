package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KeLeiJia_Set_HandupSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 168:
                    KeLeiJia_Set_HandupSet.this.setCheck((CheckedTextView) KeLeiJia_Set_HandupSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 169:
                    KeLeiJia_Set_HandupSet.this.setCheck((CheckedTextView) KeLeiJia_Set_HandupSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 170:
                    KeLeiJia_Set_HandupSet.this.updateText1(val);
                    break;
                case 171:
                    KeLeiJia_Set_HandupSet.this.updateText2(val);
                    break;
                case 172:
                    KeLeiJia_Set_HandupSet.this.updateText3(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0402_rzc_meganeh_handup_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[170];
                if (value > 0) {
                    value -= 5;
                }
                if (value < 0) {
                    value = 0;
                }
                setCarInfo(162, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[170];
                if (value2 < 100) {
                    value2 += 5;
                }
                if (value2 > 100) {
                    value2 = 100;
                }
                setCarInfo(162, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[171];
                if (value3 > 0) {
                    value3 -= 5;
                }
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfo(163, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[171];
                if (value4 < 100) {
                    value4 += 5;
                }
                if (value4 > 100) {
                    value4 = 100;
                }
                setCarInfo(163, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[172];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(164, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[172];
                if (value6 < 50) {
                    value6++;
                }
                setCarInfo(164, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[168];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(160, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[169];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(161, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(128, 7);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
        }
    }
}
