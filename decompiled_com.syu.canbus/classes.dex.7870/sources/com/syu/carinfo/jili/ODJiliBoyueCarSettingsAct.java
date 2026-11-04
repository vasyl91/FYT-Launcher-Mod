package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODJiliBoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliBoyueCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 320:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("舒适");
                            break;
                        case 1:
                            ((TextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("运动");
                            break;
                    }
                    break;
                case 321:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("灯光");
                            break;
                        case 1:
                            ((TextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("灯关与声音");
                            break;
                    }
                    break;
                case 322:
                    ODJiliBoyueCarSettingsAct.this.setCheck((CheckedTextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 323:
                    ODJiliBoyueCarSettingsAct.this.setCheck((CheckedTextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 324:
                    ODJiliBoyueCarSettingsAct.this.setCheck((CheckedTextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 325:
                    ODJiliBoyueCarSettingsAct.this.setCheck((CheckedTextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 326:
                    ((TextView) ODJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_jili_boyue_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[320] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[320] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[321] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[321] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[326] - 1;
                if (value5 < 1) {
                    value5 = 10;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[326] + 1;
                if (value6 > 10) {
                    value6 = 1;
                }
                setCarInfo(6, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(2, DataCanbus.DATA[322] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(5, DataCanbus.DATA[325] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(3, DataCanbus.DATA[323] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(4, DataCanbus.DATA[324] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[323].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[325].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[326].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[323].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[325].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[326].removeNotify(this.mNotifyCanbus);
    }
}
