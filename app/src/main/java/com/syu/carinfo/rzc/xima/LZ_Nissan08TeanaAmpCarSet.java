package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZ_Nissan08TeanaAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 100:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 101:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 102:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 103:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 104:
                    LZ_Nissan08TeanaAmpCarSet.this.setCheck((CheckedTextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 106:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 107:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 152:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_nissan_teana_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                break;
        }
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(7, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(0, 1);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(1, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(3, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarInfo(4, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(8, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(8, 1);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value = DataCanbus.DATA[152] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{24, value}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value2 = DataCanbus.DATA[152] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{24, value2}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{59}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
