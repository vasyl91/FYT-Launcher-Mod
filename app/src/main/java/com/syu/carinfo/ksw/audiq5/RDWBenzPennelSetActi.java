package com.syu.carinfo.ksw.audiq5;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class RDWBenzPennelSetActi extends Activity implements View.OnTouchListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 32:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 99:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text2)).setText("驾驶模式：AUTO");
                                break;
                            case 1:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text2)).setText("驾驶模式：两驱");
                                break;
                            case 2:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text2)).setText("驾驶模式：四驱");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text1)).setText("底盘状态：0档");
                                break;
                            case 1:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text1)).setText("底盘状态：1档");
                                break;
                            case 2:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text1)).setText("底盘状态：2档");
                                break;
                            case 3:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text1)).setText("底盘状态：3档");
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text4)).setText("DSR：关");
                                break;
                            case 1:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text4)).setText("DSR：开");
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text3)).setText("运动模式：全关");
                                break;
                            case 1:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text3)).setText("运动模式：SPORT");
                                break;
                            case 2:
                                ((TextView) RDWBenzPennelSetActi.this.findViewById(R.id.tv_text3)).setText("运动模式：COMF");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rdw_benz_button);
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        finish();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int data0 = 255;
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 13;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 15;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 16;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 14;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 42;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 43;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                data0 = 44;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                data0 = 45;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    public void sendCmd(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mCanbusNotify);
    }
}
