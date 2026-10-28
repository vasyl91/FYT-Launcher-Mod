package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalCarTange extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int data = DataCanbus.DATA[345];
                    if (data == 1) {
                        data = 0;
                    } else if (data == 0) {
                        data = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{160, data}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int data2 = DataCanbus.DATA[345];
                    if (data2 == 1) {
                        data2 = 0;
                    } else if (data2 == 0) {
                        data2 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{160, data2}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int data3 = (DataCanbus.DATA[346] + 1) - 1;
                    if (data3 < 1) {
                        data3 = 4;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{161, data3}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int data4 = DataCanbus.DATA[346] + 1 + 1;
                    if (data4 > 4) {
                        data4 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{161, data4}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int data5 = DataCanbus.DATA[347];
                    if (data5 == 1) {
                        data5 = 0;
                    } else if (data5 == 0) {
                        data5 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{162, data5}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int data6 = DataCanbus.DATA[347];
                    if (data6 == 1) {
                        data6 = 0;
                    } else if (data6 == 0) {
                        data6 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{162, data6}, null, null);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    DataCanbus.PROXY.cmd(160, new int[]{163, 1}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 345:
                    Golf7FunctionalCarTange.this.uTangeSet1(val);
                    break;
                case 346:
                    Golf7FunctionalCarTange.this.uTangeSet2(val);
                    break;
                case 347:
                    Golf7FunctionalCarTange.this.uTangeSet3(val);
                    break;
                case 348:
                    Golf7FunctionalCarTange.this.uTangeSet4(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_cartange_set);
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
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
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
        DataCanbus.NOTIFY_EVENTS[345].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[346].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[348].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[345].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[346].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[348].removeNotify(this.mNotifyCanbus);
    }

    protected void uTangeSet4(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("成功");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_327_wait_disc);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("失败");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate11);
                    break;
            }
        }
    }

    protected void uTangeSet3(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Manual);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    protected void uTangeSet2(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("驾驶员2");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("驾驶员3");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("访客");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText("驾驶员1");
                    break;
            }
        }
    }

    protected void uTangeSet1(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (val) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.activate_maticlly);
                    setViewVisible(findViewById(R.id.layout_view1), true);
                    setViewVisible(findViewById(R.id.layout_view2), true);
                    setViewVisible(findViewById(R.id.layout_view3), true);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_others_fresh_device_afrer_rain_0);
                    setViewVisible(findViewById(R.id.layout_view1), false);
                    setViewVisible(findViewById(R.id.layout_view2), false);
                    setViewVisible(findViewById(R.id.layout_view3), false);
                    break;
            }
        }
    }
}
