package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCXiandaiRohensCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCXiandaiRohensCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText("车辆变数");
                                break;
                            case 3:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text1)).setText("变速档位");
                                break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText("取出钥匙");
                                break;
                            case 3:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText("变速档位");
                                break;
                            case 4:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text2)).setText("驾驶员车门开启");
                                break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 35:
                    if (((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 2:
                                ((TextView) RZCXiandaiRohensCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_ON);
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
        setContentView(R.layout.layout_0362_rzc_rohens_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[31] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(16, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[31] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(16, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[32] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(17, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[32] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(17, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[33] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(18, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[33] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(18, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[34] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[34] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[35] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[35] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(20, value10);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
    }
}
