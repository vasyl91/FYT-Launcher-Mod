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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalCarTange extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalCarTange.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    DataCanbus.PROXY.cmd(160, new int[]{163, 1}, null, null);
                    break;
                case R.id.btn_minus1 /* 2131427480 */:
                    int data = DataCanbus.DATA[353];
                    if (data == 1) {
                        data = 0;
                    } else if (data == 0) {
                        data = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{160, data}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int data2 = DataCanbus.DATA[353];
                    if (data2 == 1) {
                        data2 = 0;
                    } else if (data2 == 0) {
                        data2 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{160, data2}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int data3 = (DataCanbus.DATA[354] + 1) - 1;
                    if (data3 < 1) {
                        data3 = 4;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{161, data3}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int data4 = DataCanbus.DATA[354] + 1 + 1;
                    if (data4 > 4) {
                        data4 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{161, data4}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int data5 = DataCanbus.DATA[355];
                    if (data5 == 1) {
                        data5 = 0;
                    } else if (data5 == 0) {
                        data5 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{162, data5}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int data6 = DataCanbus.DATA[355];
                    if (data6 == 1) {
                        data6 = 0;
                    } else if (data6 == 0) {
                        data6 = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{162, data6}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalCarTange.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 353:
                    Golf7FunctionalCarTange.this.uTangeSet1(val);
                    break;
                case 354:
                    Golf7FunctionalCarTange.this.uTangeSet2(val);
                    break;
                case 355:
                    Golf7FunctionalCarTange.this.uTangeSet3(val);
                    break;
                case 356:
                    Golf7FunctionalCarTange.this.uTangeSet4(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_cartange_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
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
