package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCLeTinMangguoCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    switch (val) {
                        case 0:
                            ((TextView) RZCLeTinMangguoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.xp_accord9_auto_light_0lowest);
                            break;
                        case 1:
                            ((TextView) RZCLeTinMangguoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.xp_accord9_auto_light_1lower);
                            break;
                        case 2:
                            ((TextView) RZCLeTinMangguoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.xp_accord9_auto_light_3higher);
                            break;
                        case 3:
                            ((TextView) RZCLeTinMangguoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.xp_accord9_auto_light_4highest);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_letin_mangguo_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[169] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[169] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
    }
}
