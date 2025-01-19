package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XfyZhV3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 108:
                    XfyZhV3CarSet.this.updateDoorUnlock(val);
                    break;
                case 109:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 110:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 111:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 112:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 113:
                    XfyZhV3CarSet.this.updateBacklightMeter(val);
                    break;
                case 114:
                    XfyZhV3CarSet.this.updateTimeFormat(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0326_xfy_zhonghuav3_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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
                int value6 = DataCanbus.DATA[108] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value7 = DataCanbus.DATA[108] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value8 = DataCanbus.DATA[113] - 1;
                if (value8 < 0) {
                    value8 = 8;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value9 = DataCanbus.DATA[113] + 1;
                if (value9 > 8) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value10 = DataCanbus.DATA[114] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[114] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(9, value11);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[107] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[109] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[110] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(4, value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[111] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(5, value2);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[112] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(6, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateDoorUnlock(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                    break;
            }
        }
    }

    
    public void updateBacklightMeter(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateTimeFormat(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_0);
                    break;
            }
        }
    }
}
