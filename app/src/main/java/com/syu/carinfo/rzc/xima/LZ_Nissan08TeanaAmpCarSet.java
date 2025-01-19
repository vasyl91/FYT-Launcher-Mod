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

public class LZ_Nissan08TeanaAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 112:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 116:
                    LZ_Nissan08TeanaAmpCarSet.this.setCheck((CheckedTextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 118:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 164:
                    if (((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) LZ_Nissan08TeanaAmpCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_nissan_teana_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(0, 1);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(1, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(3, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarInfo(4, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(8, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(8, 1);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value = DataCanbus.DATA[164] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{24, value}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value2 = DataCanbus.DATA[164] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{24, value2}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(7, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{59}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }
}
