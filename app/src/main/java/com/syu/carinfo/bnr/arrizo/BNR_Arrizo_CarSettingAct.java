package com.syu.carinfo.bnr.arrizo;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BNR_Arrizo_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    BNR_Arrizo_CarSettingAct.this.updateCarTishi();
                    break;
                case 9:
                    BNR_Arrizo_CarSettingAct.this.updateCarStop();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_arrizo_carsetting);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[8] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[8] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value2}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value3 = DataCanbus.DATA[9];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value3}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    protected void updateCarStop() {
        int value = DataCanbus.DATA[9];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), value != 0);
    }

    protected void updateCarTishi() {
        int value = DataCanbus.DATA[8];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_light);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_lightsounds);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_sounds);
                break;
        }
    }
}
