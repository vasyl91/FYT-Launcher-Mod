package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
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
public class WC2BeiqiZhixingCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2BeiqiZhixingCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (value == 0) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text1)).setText("电量充足");
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text1)).setText("电量不足");
                    }
                    break;
                case 99:
                    if (value == 65535) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 100:
                    if (value == 65535) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    }
                    break;
                case 101:
                    if (value == 16777215) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    }
                    break;
                case 102:
                    if (value == 255) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 111:
                    WC2BeiqiZhixingCarInfo.this.setCheck((CheckedTextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 112:
                    WC2BeiqiZhixingCarInfo.this.setCheck((CheckedTextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 113:
                    if (value == 1) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_parksense_1);
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_parksense_2);
                    }
                    break;
                case 114:
                    if (value == 1) {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
                    } else {
                        ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                    }
                    break;
                case 115:
                    WC2BeiqiZhixingCarInfo.this.setCheck((CheckedTextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 116:
                    WC2BeiqiZhixingCarInfo.this.setCheck((CheckedTextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 117:
                    switch (value) {
                        case 1:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText("10s");
                            break;
                        case 2:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText("20s");
                            break;
                        case 3:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText("30s");
                            break;
                        case 4:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText("60s");
                            break;
                        case 5:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText("120s");
                            break;
                        default:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                    }
                    break;
                case 118:
                    switch (value) {
                        case 1:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text9)).setText("5km/h");
                            break;
                        case 2:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text9)).setText("10km/h");
                            break;
                        case 3:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text9)).setText("15km/h");
                            break;
                        case 4:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text9)).setText("20km/h");
                            break;
                        default:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                            break;
                    }
                    break;
                case 119:
                    switch (value) {
                        case 1:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                        default:
                            ((TextView) WC2BeiqiZhixingCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_beiqi_zhixing_carinfo);
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
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(3, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[113] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(3, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[114] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[114] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(4, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[117] - 1;
                if (value5 < 0) {
                    value5 = 5;
                }
                setCarInfo(7, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[117] + 1;
                if (value6 > 5) {
                    value6 = 0;
                }
                setCarInfo(7, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[118] - 1;
                if (value7 < 0) {
                    value7 = 4;
                }
                setCarInfo(8, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[118] + 1;
                if (value8 > 4) {
                    value8 = 0;
                }
                setCarInfo(8, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[119] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(9, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[119] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(9, value10, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WC2BeiqiZHixingTireAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(5, DataCanbus.DATA[115] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(6, DataCanbus.DATA[116] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(1, DataCanbus.DATA[111] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(2, DataCanbus.DATA[112] != 1 ? 1 : 0, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
