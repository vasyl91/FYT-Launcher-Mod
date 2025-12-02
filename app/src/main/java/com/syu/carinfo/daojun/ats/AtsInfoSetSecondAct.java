package com.syu.carinfo.daojun.ats;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class AtsInfoSetSecondAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 120:
                    AtsInfoSetSecondAct.this.updaternearCarUnlock();
                    break;
                case 121:
                    AtsInfoSetSecondAct.this.updaterForgotKey();
                    break;
                case 122:
                    AtsInfoSetSecondAct.this.updaterDriverStyle();
                    break;
                case 123:
                    AtsInfoSetSecondAct.this.updaterRelockDoor();
                    break;
                case 127:
                    AtsInfoSetSecondAct.this.updaterhandTraffic();
                    break;
                case 128:
                    AtsInfoSetSecondAct.this.updateradaptiveForwardLight();
                    break;
                case 129:
                    AtsInfoSetSecondAct.this.updaterMirrorAutoFold();
                    break;
                case 130:
                    AtsInfoSetSecondAct.this.updaterReverTiltMirror();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_daojun_ats_info_second_set);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value1 = DataCanbus.DATA[120];
                AtsFunc.CAR_COMM_CONTROL(12, value1 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[121];
                AtsFunc.CAR_COMM_CONTROL(13, value2 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value3 = DataCanbus.DATA[122];
                AtsFunc.CAR_COMM_CONTROL(14, value3 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                AtsFunc.CAR_COMM_CONTROL(15, DataCanbus.DATA[123] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value7 = DataCanbus.DATA[127];
                AtsFunc.CAR_COMM_CONTROL(16, value7 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value8 = DataCanbus.DATA[128];
                AtsFunc.CAR_COMM_CONTROL(17, value8 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value9 = DataCanbus.DATA[129];
                AtsFunc.CAR_COMM_CONTROL(18, value9 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value10 = DataCanbus.DATA[130];
                AtsFunc.CAR_COMM_CONTROL(19, value10 != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
    }

    
    public void updaternearCarUnlock() {
        int switchOn = DataCanbus.DATA[120];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    
    public void updaterForgotKey() {
        int switchOn = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    
    public void updaterDriverStyle() {
        int switchOn = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    
    public void updaterRelockDoor() {
        int reLockOpenDoorvalue = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(reLockOpenDoorvalue != 0);
    }

    
    public void updaterhandTraffic() {
        int switchOn = DataCanbus.DATA[127];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_yinglang_car_set_Second_str2);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_yinglang_car_set_Second_str3);
        }
    }

    
    public void updateradaptiveForwardLight() {
        int switchOn = DataCanbus.DATA[128];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str5);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str6);
        }
    }

    
    public void updaterMirrorAutoFold() {
        int switchOn = DataCanbus.DATA[129];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    
    public void updaterReverTiltMirror() {
        int switchOn = DataCanbus.DATA[130];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
    }
}
