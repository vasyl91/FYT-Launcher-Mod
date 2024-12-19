package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7ConvenienceAct extends BaseActivity {
    private TextView[] mTvConv = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7ConvenienceAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 76:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setContentView(R.layout.layout_golf7_convenience_od);
        } else {
            setContentView(R.layout.layout_golf7_convenience);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvConv[0] = (TextView) findViewById(R.id.golf7_tv_conv_warning_0);
        this.mTvConv[1] = (TextView) findViewById(R.id.golf7_tv_conv_warning_1);
        this.mTvConv[2] = (TextView) findViewById(R.id.golf7_tv_conv_warning_2);
        this.mTvConv[3] = (TextView) findViewById(R.id.golf7_tv_conv_warning_3);
        this.mTvConv[4] = (TextView) findViewById(R.id.golf7_tv_conv_warning_4);
        this.mTvConv[5] = (TextView) findViewById(R.id.golf7_tv_conv_warning_5);
        this.mTvConv[6] = (TextView) findViewById(R.id.golf7_tv_conv_warning_6);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
