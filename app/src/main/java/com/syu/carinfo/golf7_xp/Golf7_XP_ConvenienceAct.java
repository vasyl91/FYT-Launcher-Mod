package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_ConvenienceAct extends BaseActivity {
    private TextView[] mTvConv = new TextView[3];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 173:
                    if (ints == null) {
                        for (int i = 0; i < 3; i++) {
                            int[] ints2 = ConstGolf.mConvConsumer[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Golf7_XP_ConvenienceAct.this.convConsumer(ints2);
                        }
                        break;
                    } else {
                        Golf7_XP_ConvenienceAct.this.convConsumer(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_convenience_xp);
        init();
    }

    @Override
    public void init() {
        this.mTvConv[0] = (TextView) findViewById(R.id.golf7_tv_conv_warning_0);
        this.mTvConv[1] = (TextView) findViewById(R.id.golf7_tv_conv_warning_1);
        this.mTvConv[2] = (TextView) findViewById(R.id.golf7_tv_conv_warning_2);
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
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
    }

    
    public void convConsumer(int[] ints) {
        String str = "";
        int index = 0;
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 3) {
            index = ints[0];
            int value = ints[1];
            if (value > 0 && value < Golf7Data.mStrConvWarning.length) {
                str = Golf7Data.mStrConvWarning[value - 1];
            }
        } else {
            str = "";
        }
        this.mTvConv[index].setText(String.valueOf(index + 1) + "." + str);
    }
}
