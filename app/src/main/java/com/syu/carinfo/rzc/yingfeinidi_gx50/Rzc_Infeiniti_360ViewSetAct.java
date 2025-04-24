package com.syu.carinfo.rzc.yingfeinidi_gx50;

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
public class Rzc_Infeiniti_360ViewSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 134:
                    Rzc_Infeiniti_360ViewSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 2);
                    break;
                case 135:
                    Rzc_Infeiniti_360ViewSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.ctv_checkedtext2), value == 2);
                    break;
                case 136:
                    Rzc_Infeiniti_360ViewSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.ctv_checkedtext3), value == 2);
                    break;
                case 137:
                    Rzc_Infeiniti_360ViewSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.ctv_checkedtext4), value == 2);
                    break;
                case 138:
                    if (((TextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.tv_text1)).setText("LV 3");
                                break;
                            case 2:
                                ((TextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.tv_text1)).setText("LV 2");
                                break;
                            case 3:
                                ((TextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.tv_text1)).setText("LV 1");
                                break;
                            default:
                                ((TextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.tv_text1)).setText("LV 4");
                                break;
                        }
                    }
                    break;
                case 139:
                    Rzc_Infeiniti_360ViewSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_360ViewSetAct.this.findViewById(R.id.ctv_checkedtext5), value == 2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_infiniti_360view_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value6 = DataCanbus.DATA[138] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(149, value6);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value7 = DataCanbus.DATA[138] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(149, value7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[134] == 2) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                setCarInfo(145, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[135] == 2) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                setCarInfo(146, value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[136] == 2) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                setCarInfo(147, value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[137] == 2) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                setCarInfo(148, value2);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[139] == 2) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(150, value);
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
        DataCanbus.PROXY.cmd(1, new int[]{144, 1}, null, null);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }
}
