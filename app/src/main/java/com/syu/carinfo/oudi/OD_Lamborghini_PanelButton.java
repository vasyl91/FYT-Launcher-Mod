package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class OD_Lamborghini_PanelButton extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.btn_plus10).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_big_light_p : R.drawable.ic_lamborghini_big_light_n);
                    break;
                case 100:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.btn_plus11).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_wulight_p : R.drawable.ic_lamborghini_wulight_n);
                    break;
                case 101:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.btn_plus9).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_esp_off_p : R.drawable.ic_lamborghini_esp_off_n);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_lamborghini_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
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
    public void onClick(View v) {
        int id = v.getId();
        int cmd = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                cmd = 65;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                cmd = 64;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                cmd = 63;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                cmd = 62;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                cmd = 69;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                cmd = 68;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                cmd = 67;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                cmd = 66;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                cmd = 58;
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                cmd = 70;
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                cmd = 71;
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                cmd = 72;
                break;
        }
        if (cmd != 0) {
            DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
