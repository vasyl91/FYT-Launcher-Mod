package com.syu.carinfo.rzc.mingjueruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActRongwei550CarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    ActRongwei550CarSet.this.uSteerFeel(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzc_rongwei550_car_set);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.mingjue_steerfeel_m)).setOnClickListener(this);
        ((Button) findViewById(R.id.mingjue_steerfeel_p)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mingjue_steerfeel_m /* 2131432716 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                sendCmd(value);
                break;
            case R.id.mingjue_steerfeel_p /* 2131432718 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                sendCmd(value2);
                break;
        }
    }

    private void sendCmd(int value) {
        DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
    }

    protected void uSteerFeel(int value) {
        if (((TextView) findViewById(R.id.mingjue_steerfeel_txt)) != null) {
            int resId = R.string.crv_source_null;
            if (value == 1) {
                resId = R.string.str_wc_174008_str11;
            } else if (value == 2) {
                resId = R.string.str_background_red;
            } else if (value == 3) {
                resId = R.string.str_bright_gold;
            }
            ((TextView) findViewById(R.id.mingjue_steerfeel_txt)).setText(resId);
        }
    }
}
