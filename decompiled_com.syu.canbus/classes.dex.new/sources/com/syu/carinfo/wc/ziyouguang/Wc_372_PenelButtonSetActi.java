package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_PenelButtonSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_PenelButtonSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 264:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 265:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 266:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 267:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 268:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 269:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 270:
                    Wc_372_PenelButtonSetActi.this.setCheck((CheckedTextView) Wc_372_PenelButtonSetActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_penelbutton_set);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int vlaue = DataCanbus.DATA[264];
                setCarInfo(38, vlaue != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int vlaue2 = DataCanbus.DATA[267];
                setCarInfo(36, vlaue2 != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int vlaue3 = DataCanbus.DATA[268];
                setCarInfo(35, vlaue3 != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int vlaue4 = DataCanbus.DATA[265];
                setCarInfo(37, vlaue4 != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int vlaue5 = DataCanbus.DATA[266];
                setCarInfo(30, vlaue5 != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int vlaue6 = DataCanbus.DATA[269];
                setCarInfo(34, vlaue6 != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int vlaue7 = DataCanbus.DATA[270];
                setCarInfo(33, vlaue7 != 1 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
    }
}
