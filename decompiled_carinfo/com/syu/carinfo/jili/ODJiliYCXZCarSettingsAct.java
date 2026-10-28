package com.syu.carinfo.jili;

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
public class ODJiliYCXZCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 179:
                    ODJiliYCXZCarSettingsAct.this.setCheck((CheckedTextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 180:
                    ODJiliYCXZCarSettingsAct.this.setCheck((CheckedTextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 181:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("30s");
                            break;
                        case 2:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("60s");
                            break;
                        case 3:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("90s");
                            break;
                    }
                case 182:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                            break;
                        case 1:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_comfort);
                            break;
                    }
                case 183:
                    ODJiliYCXZCarSettingsAct.this.setCheck((CheckedTextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 184:
                    ODJiliYCXZCarSettingsAct.this.setCheck((CheckedTextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 185:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        case 2:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                            break;
                        case 3:
                            ((TextView) ODJiliYCXZCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_jili_ycxz_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[181] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[182] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[182] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[185] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[185] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(1, DataCanbus.DATA[179] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(2, DataCanbus.DATA[180] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(5, DataCanbus.DATA[183] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(6, DataCanbus.DATA[184] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{77}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }
}
