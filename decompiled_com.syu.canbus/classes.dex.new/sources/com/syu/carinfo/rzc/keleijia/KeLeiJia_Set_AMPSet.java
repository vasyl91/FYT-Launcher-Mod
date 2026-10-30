package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJia_Set_AMPSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_AMPSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 191:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 192:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text2)) != null) {
                        if ((val & 128) != 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text2)).setText("-" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text2)).setText("0");
                        } else {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text2)).setText("+" + val);
                        }
                    }
                    break;
                case 193:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text3)) != null) {
                        if ((val & 128) != 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text3)).setText("-" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text3)).setText("0");
                        } else {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text3)).setText("+" + val);
                        }
                    }
                    break;
                case 194:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text4)) != null) {
                        if ((val & 128) != 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text4)).setText("L" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text4)).setText("0");
                        } else {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text4)).setText("R" + val);
                        }
                    }
                    break;
                case 195:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text5)) != null) {
                        if ((val & 128) != 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text5)).setText("R" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text5)).setText("0");
                        } else {
                            ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text5)).setText("F" + val);
                        }
                    }
                    break;
                case 221:
                    if (((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text6)).setText("Balance");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text6)).setText("Driver");
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text6)).setText("Vehicel");
                                break;
                            case 4:
                                ((TextView) KeLeiJia_Set_AMPSet.this.findViewById(R.id.tv_text6)).setText("Rear Off");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0402_rzc_meganeh_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                setCarInfo(225, 49);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setCarInfo(225, 33);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                setCarInfo(226, 49);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                setCarInfo(226, 33);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                setCarInfo(227, 49);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                setCarInfo(227, 33);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                setCarInfo(228, 49);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                setCarInfo(228, 33);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarInfo(229, 49);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarInfo(229, 33);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value3 = DataCanbus.DATA[221];
                if (value3 == 4) {
                    value2 = 2;
                } else {
                    value2 = value3 - 1;
                    if (value2 < 0) {
                        value2 = 4;
                    }
                }
                setCarInfo(230, value2);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value4 = DataCanbus.DATA[221];
                if (value4 == 2) {
                    value = 4;
                } else {
                    value = value4 + 1;
                    if (value > 4) {
                        value = 0;
                    }
                }
                setCarInfo(230, value);
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
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
    }
}
