package com.syu.carinfo.rzc.sanlin;

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
public class RZCMazdCX7CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCMazdCX7CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 15:
                    if (((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text2)).setText("F" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text2)).setText("R" + (16 - value));
                        } else {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 16:
                    if (((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text3)).setText("R" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text3)).setText("L" + (16 - value));
                        } else {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 17:
                    if (((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text4)).setText("-" + (16 - value));
                        } else {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 18:
                    if (((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text5)).setText("-" + (16 - value));
                        } else {
                            ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 19:
                    if (((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCMazdCX7CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 20:
                    RZCMazdCX7CarSet.this.setCheck((CheckedTextView) RZCMazdCX7CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0328_rzc_mzd_cx7_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[19];
                if (value > 0) {
                    value--;
                }
                setCarInfo(7, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[19];
                if (value2 < 63) {
                    value2++;
                }
                setCarInfo(7, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[15];
                if (value3 > 8) {
                    value3--;
                }
                if (value3 < 8) {
                    value3 = 8;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[15];
                if (value4 < 24) {
                    value4++;
                }
                if (value4 < 8) {
                    value4 = 8;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[16];
                if (value5 > 8) {
                    value5--;
                }
                if (value5 < 8) {
                    value5 = 8;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[16];
                if (value6 < 24) {
                    value6++;
                }
                if (value6 < 8) {
                    value6 = 8;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[17];
                if (value7 > 10) {
                    value7--;
                }
                if (value7 < 10) {
                    value7 = 10;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[17];
                if (value8 < 22) {
                    value8++;
                }
                if (value8 < 10) {
                    value8 = 10;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[18];
                if (value9 > 10) {
                    value9--;
                }
                if (value9 < 10) {
                    value9 = 10;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[18];
                if (value10 < 22) {
                    value10++;
                }
                if (value10 < 10) {
                    value10 = 10;
                }
                setCarInfo(5, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value11 = DataCanbus.DATA[20];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(11, value11);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
    }
}
