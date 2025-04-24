package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7ConvenienceAct extends BaseActivity {
    private TextView[] mTvConv = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 173:
                    if (ints == null) {
                        for (int i = 0; i < 7; i++) {
                            int[] ints2 = ConstGolf.mConvConsumer[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Golf7ConvenienceAct.this.convConsumer(ints2);
                        }
                        break;
                    } else {
                        Golf7ConvenienceAct.this.convConsumer(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            //setContentView(R.layout.layout_golf7_convenience_od);
        } else {
            //setContentView(R.layout.layout_golf7_convenience);
        }
        init();
    }

    @Override
    public void init() {
        this.mTvConv[0] = (TextView) findViewById(R.id.golf7_tv_conv_warning_0);
        this.mTvConv[1] = (TextView) findViewById(R.id.golf7_tv_conv_warning_1);
        this.mTvConv[2] = (TextView) findViewById(R.id.golf7_tv_conv_warning_2);
        this.mTvConv[3] = (TextView) findViewById(R.id.golf7_tv_conv_warning_3);
        this.mTvConv[4] = (TextView) findViewById(R.id.golf7_tv_conv_warning_4);
        this.mTvConv[5] = (TextView) findViewById(R.id.golf7_tv_conv_warning_5);
        this.mTvConv[6] = (TextView) findViewById(R.id.golf7_tv_conv_warning_6);
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
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
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
