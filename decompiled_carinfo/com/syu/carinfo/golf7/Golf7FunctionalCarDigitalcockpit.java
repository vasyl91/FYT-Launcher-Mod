package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalCarDigitalcockpit extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int data = DataCanbus.DATA[353] - 1;
                    if (data < 2) {
                        data = 5;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{233, data}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int data2 = DataCanbus.DATA[353] + 1;
                    if (data2 > 5) {
                        data2 = 2;
                    } else if (data2 < 2) {
                        data2 = 2;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{233, data2}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int data3 = DataCanbus.DATA[354] - 1;
                    if (data3 < 0) {
                        data3 = 8;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{234, data3}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int data4 = DataCanbus.DATA[354] + 1;
                    if (data4 > 8) {
                        data4 = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{234, data4}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int data5 = DataCanbus.DATA[355] - 1;
                    if (data5 < 0) {
                        data5 = 8;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{235, data5}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int data6 = DataCanbus.DATA[355] + 1;
                    if (data6 > 8) {
                        data6 = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{235, data6}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 353:
                    Golf7FunctionalCarDigitalcockpit.this.uTangeSet1(val);
                    break;
                case 354:
                    Golf7FunctionalCarDigitalcockpit.this.uTangeSet2(val);
                    break;
                case 355:
                    Golf7FunctionalCarDigitalcockpit.this.uTangeSet3(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_digitalcockpit_set);
        init();
    }

    @Override
    public void init() {
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
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
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
    }

    protected void uTangeSet3(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_destination_information);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_372_luopanstr);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_388_sound_set);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_4008_pannel_str3);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text3)).setText("消耗量");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.mileage);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.travelling_time);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_4008_pannel_str5);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.driving_mileage);
                    break;
            }
        }
    }

    protected void uTangeSet2(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_destination_information);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_luopanstr);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_388_sound_set);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_4008_pannel_str3);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text2)).setText("消耗量");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.mileage);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.travelling_time);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_4008_pannel_str5);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.driving_mileage);
                    break;
            }
        }
    }

    protected void uTangeSet1(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (val) {
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Type1");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Type2");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Type3");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection5);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection5);
                    break;
            }
        }
    }
}
