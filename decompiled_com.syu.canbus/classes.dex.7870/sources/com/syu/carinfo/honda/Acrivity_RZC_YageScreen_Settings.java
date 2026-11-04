package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Acrivity_RZC_YageScreen_Settings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_YageScreen_Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 418:
                    if (((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text5)).setText(R.string.str_day1);
                                break;
                            case 2:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text5)).setText(R.string.str_night);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text5)).setText(R.string.xp_accord9_car_screen_display_quanmie);
                                break;
                        }
                    }
                    break;
                case 419:
                    if (((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_background_amber);
                                break;
                            case 2:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                                break;
                            case 3:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_4);
                                break;
                            case 4:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_background_violet);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                        }
                    }
                    break;
                case 420:
                    if (value > 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text2)).setText("+" + (value - 5));
                    } else if (value < 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text2)).setText("-" + (5 - value));
                    } else {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text2)).setText("0");
                    }
                    break;
                case 421:
                    if (value > 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text3)).setText("+" + (value - 5));
                    } else if (value < 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text3)).setText("-" + (5 - value));
                    } else {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text3)).setText("0");
                    }
                    break;
                case 422:
                    if (value > 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text4)).setText("+" + (value - 5));
                    } else if (value < 5) {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text4)).setText("-" + (5 - value));
                    } else {
                        ((TextView) Acrivity_RZC_YageScreen_Settings.this.findViewById(R.id.tv_text4)).setText("0");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0298_rzc_yagescreen_settings);
        setListener();
    }

    private void setListener() {
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[419] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(105, new int[]{65, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[419] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{65, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[420];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(105, new int[]{67, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[420];
                if (value4 < 10) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(105, new int[]{67, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[421];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(105, new int[]{68, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[421];
                if (value6 < 10) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(105, new int[]{68, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[422];
                if (value7 < 10) {
                    value7++;
                }
                DataCanbus.PROXY.cmd(105, new int[]{69, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[418] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{66, value8}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value9 = DataCanbus.DATA[422];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(105, new int[]{69, value9}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value10 = DataCanbus.DATA[418] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                DataCanbus.PROXY.cmd(105, new int[]{66, value10}, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[418].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[419].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[420].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[421].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[422].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[418].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[419].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[420].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[421].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[422].removeNotify(this.mNotifyCanbus);
    }
}
