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

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJia_Set_MULTISet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 181:
                    if (((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text1)).setText("Regular");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text1)).setText("ECO");
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text2)).setText("Regular");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text2)).setText("Confort");
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text2)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 184:
                    ((CheckedTextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0402_rzc_meganeh_mutil_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(45, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[181] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(45, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[182] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(46, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[182] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(46, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(47, DataCanbus.DATA[184] == 1 ? 0 : 1);
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
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
    }
}
