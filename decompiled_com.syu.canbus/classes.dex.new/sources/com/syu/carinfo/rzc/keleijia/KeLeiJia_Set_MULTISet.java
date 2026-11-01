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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJia_Set_MULTISet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_MULTISet.1
        @Override // com.syu.module.IUiNotify
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
                case 205:
                    if (((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text3)).setText("km/h");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.tv_text3)).setText("mph");
                                break;
                        }
                    }
                    break;
                case 215:
                    ((CheckedTextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val != 0);
                    break;
                case 216:
                    ((CheckedTextView) KeLeiJia_Set_MULTISet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0402_rzc_meganeh_mutil_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(45, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[181] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(45, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[182] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(46, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[182] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(46, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[205] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(58, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[205] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(58, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(47, DataCanbus.DATA[184] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(61, DataCanbus.DATA[215] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(62, DataCanbus.DATA[216] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
    }
}
