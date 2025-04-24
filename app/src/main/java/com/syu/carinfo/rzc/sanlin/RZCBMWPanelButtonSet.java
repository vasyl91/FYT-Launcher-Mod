package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCBMWPanelButtonSet extends Activity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    switch (value) {
                        case 0:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_bmw_button1_n);
                            break;
                        case 1:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_bmw_button1_p);
                            break;
                    }
                case 154:
                    switch (value) {
                        case 0:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_bmw_button2_n);
                            break;
                        case 1:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_bmw_button2_p);
                            break;
                    }
                case 155:
                    switch (value) {
                        case 0:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_bmw_button3_0);
                            break;
                        case 1:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_bmw_button3_1);
                            break;
                        case 2:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_bmw_button3_2);
                            break;
                        case 3:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_bmw_button3_3);
                            break;
                    }
                case 156:
                    switch (value) {
                        case 0:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_bmw_button5_0);
                            break;
                        case 1:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_bmw_button5_1);
                            break;
                        case 2:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_bmw_button5_2);
                            break;
                        case 3:
                            RZCBMWPanelButtonSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_bmw_button5_3);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0051_rzc_bmw_panel_settings);
        init();
    }

    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    setCarInfo(68, 1);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    setCarInfo(67, 1);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    setCarInfo(64, 1);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    setCarInfo(66, 1);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    setCarInfo(65, 1);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    setCarInfo(68, 0);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    setCarInfo(67, 0);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    setCarInfo(64, 0);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    setCarInfo(66, 0);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    setCarInfo(65, 0);
                    break;
            }
        }
        return false;
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(11, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65, 168}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
    }
}
