package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODHongqiH5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODHongqiH5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 150:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection1);
                                break;
                            case 1:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_science);
                                break;
                            case 2:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 151:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("经济模式");
                                break;
                            case 2:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("运动模式");
                                break;
                            default:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("舒适模式");
                                break;
                        }
                    }
                    break;
                case 152:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 153:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 154:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 155:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 156:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("关闭模式");
                                break;
                            case 1:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("开门模式");
                                break;
                            case 2:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("启动模式");
                                break;
                            case 3:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("小灯模式");
                                break;
                        }
                    }
                    break;
                case 157:
                    if (((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text7)).setText("白色");
                                break;
                            default:
                                ((TextView) ODHongqiH5CarSet.this.findViewById(R.id.tv_text7)).setText("浅蓝色");
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
        setContentView(R.layout.layout_0453_rzc_hongqi_h5_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[150] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[150] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[152];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[152];
                if (value4 < 255) {
                    value4++;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[153];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[153];
                if (value6 < 255) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[154];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[154];
                if (value8 < 255) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[155];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[155];
                if (value10 < 7) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[156] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[156] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[157] - 1;
                if (value13 < 1) {
                    value13 = 2;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[157] + 1;
                if (value14 > 2) {
                    value14 = 1;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[151] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(2, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[151] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(2, value16);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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
        DataCanbus.PROXY.cmd(2, new int[]{67}, null, null);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }
}
