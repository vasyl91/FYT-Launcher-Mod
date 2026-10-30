package com.syu.carinfo.rzc.klc;

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
public class RZC_GMChargeSet4InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZC_GMChargeSet4InfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 239:
                    RZC_GMChargeSet4InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 240:
                    if (((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text1)).setText("6A");
                                break;
                            case 1:
                                ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text1)).setText("8A");
                                break;
                        }
                    }
                    break;
                case 241:
                    if (((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text2)).setText("是");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text2)).setText("否");
                                break;
                        }
                    }
                    break;
                case 242:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    if (((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour) + ":" + (min / 10) + (min % 10));
                    }
                    break;
                case 243:
                    int hour2 = (value >> 8) & 255;
                    int min2 = value & 255;
                    if (((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZC_GMChargeSet4InfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(hour2) + ":" + (min2 / 10) + (min2 % 10));
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_charge_setinf4);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[240];
                if (value == 1) {
                    value = 1;
                } else if (value == 0) {
                    value = 2;
                }
                setCarInfo(18, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[240];
                if (value2 == 1) {
                    value2 = 1;
                } else if (value2 == 0) {
                    value2 = 2;
                }
                setCarInfo(18, value2, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[239] == 0) {
                    setCarInfo(17, 1, 0, 0);
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(12, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{81, 2}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
    }
}
