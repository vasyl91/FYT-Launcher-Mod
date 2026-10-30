package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODDatongDanaM1CarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.zhongtai.ODDatongDanaM1CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 173:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 174:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 175:
                    switch (value) {
                        case 0:
                            ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 176:
                    switch (value) {
                        case 0:
                            ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                            break;
                        case 1:
                            ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                            break;
                    }
                    break;
                case 177:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 178:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 179:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 180:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 181:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 182:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 183:
                    ((TextView) ODDatongDanaM1CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value + 1).toString());
                    break;
                case 184:
                    ODDatongDanaM1CarSet.this.setCheck((CheckedTextView) ODDatongDanaM1CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0265_od_datong_danam1_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(5, new int[]{81, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[175] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(26, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[175] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(26, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[176] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(17, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[176] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(17, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[183] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(23, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[183] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(23, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(15, DataCanbus.DATA[173] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(19, DataCanbus.DATA[178] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(27, DataCanbus.DATA[179] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(16, DataCanbus.DATA[174] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(18, DataCanbus.DATA[177] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(20, DataCanbus.DATA[180] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(21, DataCanbus.DATA[181] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(22, DataCanbus.DATA[182] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(24, DataCanbus.DATA[184] != 0 ? 0 : 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
    }
}
