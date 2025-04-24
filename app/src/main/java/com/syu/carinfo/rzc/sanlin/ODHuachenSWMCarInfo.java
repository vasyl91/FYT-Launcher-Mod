package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
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
public class ODHuachenSWMCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 99:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 100:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 101:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + "km/h");
                        break;
                    }
                case 102:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + "rpm");
                        break;
                    }
                case 103:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val) + "km");
                        break;
                    }
                case 104:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 106:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("45S");
                                break;
                            case 4:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_huachen_swm_settings);
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 14614982) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(11, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[106] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(6, DataCanbus.DATA[98] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(7, DataCanbus.DATA[99] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(8, DataCanbus.DATA[100] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(9, DataCanbus.DATA[104] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(10, DataCanbus.DATA[105] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODHuachenSWMChargeCarInfo.class);
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
        DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }
}
