package com.syu.carinfo.rzc.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_0255_HanTengX5_CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.hantengx5.RZC_0255_HanTengX5_CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 141:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 142:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)).setText("℃");
                        } else {
                            ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)).setText("℉");
                        }
                    }
                    break;
                case 143:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_255_hantengx5_11);
                                break;
                            case 2:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_255_hantengx5_12);
                                break;
                            default:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_255_hantengx5_14);
                                break;
                            case 2:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_255_hantengx5_15);
                                break;
                            case 3:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_395_dynamic_state);
                                break;
                            default:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_255_hantengx5_13);
                                break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_16);
                                break;
                            case 2:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_17);
                                break;
                            default:
                                ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 147:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 148:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_rzc_hantengx5_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[140];
                if (value > 0) {
                    value--;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[140];
                if (value2 < 15) {
                    value2++;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[141];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[141];
                if (value4 < 15) {
                    value4++;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
            case R.id.btn_plus3 /* 2131427464 */:
                int value5 = DataCanbus.DATA[142];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(0, value5);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value6 = DataCanbus.DATA[143] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value7 = DataCanbus.DATA[143] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value8 = DataCanbus.DATA[144] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value9 = DataCanbus.DATA[144] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value10 = DataCanbus.DATA[145] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value11 = DataCanbus.DATA[145] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value12 = DataCanbus.DATA[146] - 1;
                if (value12 < 1) {
                    value12 = 5;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value13 = DataCanbus.DATA[146] + 1;
                if (value13 > 5) {
                    value13 = 1;
                }
                setCarInfo(6, value13);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value14 = DataCanbus.DATA[147];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(7, value14);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value15 = DataCanbus.DATA[147];
                if (value15 < 255) {
                    value15++;
                }
                setCarInfo(7, value15);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value16 = DataCanbus.DATA[148];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value17 = DataCanbus.DATA[148];
                if (value17 < 255) {
                    value17++;
                }
                setCarInfo(8, value17);
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
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }
}
