package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODShanqiZHongkaLightSet extends Activity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ODShanqiZHongkaLightSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(val == 0 ? R.drawable.ic_zhongka_nearlight_n : R.drawable.ic_zhongka_nearlight_p);
                    break;
                case 100:
                    ODShanqiZHongkaLightSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(val == 0 ? R.drawable.ic_zhongka_foglight_n : R.drawable.ic_zhongka_foglight_p);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_shanqi_zhongka_lightsettings);
        init();
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_plus1 /* 2131427457 */:
                    int value = DataCanbus.DATA[99];
                    sendCmd(4, value == 1 ? 0 : 1);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value2 = DataCanbus.DATA[100];
                    sendCmd(5, value2 == 1 ? 0 : 1);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    sendCmd(2, 1);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    sendCmd(2, 0);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    sendCmd(3, 0);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    sendCmd(3, 1);
                    break;
            }
        }
        return false;
    }

    public void sendCmd(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }
}
