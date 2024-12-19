package com.syu.carinfo.wc.ruijie15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZBinliTianyueCarAirSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.LZBinliTianyueCarAirSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 17:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 18:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 20:
                    ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    break;
                case 29:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 30:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 31:
                    LZBinliTianyueCarAirSet.this.setCheck((CheckedTextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 33:
                    ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                    break;
                case 35:
                    if (val == 1) {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text3)).setText("Left Fan");
                        break;
                    } else {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    }
                case 36:
                    if (val == 1) {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text3)).setText("Right Fan");
                        break;
                    } else {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        break;
                    }
                case 37:
                    if (val == 1) {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view3).setVisibility(0);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                        ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text3)).setText("Left Mode");
                        break;
                    } else {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view3).setVisibility(8);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                        break;
                    }
                case 38:
                    if (val == 1) {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view6).setVisibility(0);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view7).setVisibility(0);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view8).setVisibility(0);
                        ((TextView) LZBinliTianyueCarAirSet.this.findViewById(R.id.tv_text3)).setText("Right Mode");
                        break;
                    } else {
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view6).setVisibility(8);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view7).setVisibility(8);
                        LZBinliTianyueCarAirSet.this.findViewById(R.id.layout_view8).setVisibility(8);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_binli_tianyue_airset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(17);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(15);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(14);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(22);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfo(25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfo(26);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{20, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }
}
