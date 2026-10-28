package com.syu.carinfo.xincheng.infiniti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Infiniti_XinCheng_IndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xincheng_infiniti_index);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        if (1835460 != DataCanbus.DATA[1000] && 4063684 != DataCanbus.DATA[1000]) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        if (5046724 == DataCanbus.DATA[1000] || 5112260 == DataCanbus.DATA[1000]) {
            findViewById(R.id.layout_view1).setVisibility(8);
            if (5112260 != DataCanbus.DATA[1000]) {
                findViewById(R.id.layout_view4).setVisibility(8);
            }
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Infiniti_XinCheng_CarTire.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                try {
                    Intent intent2 = new Intent();
                    if (5046724 == DataCanbus.DATA[1000] || 5112260 == DataCanbus.DATA[1000]) {
                        intent2.setClass(this, Xincheng_Nissan_TuleNewCarinfoAct.class);
                    } else {
                        intent2.setClass(this, Infiniti_XinCheng_CarInfo.class);
                    }
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Infiniti_XinCheng_CarSet.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, Infiniti_XinCheng_CarSet1.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, Infiniti_XinCheng_EQSet.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, Infiniti_XinCheng_AirSeatSet.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                try {
                    Intent intent7 = new Intent();
                    intent7.setClass(this, Infiniti_XinCheng_DirvmodeSet.class);
                    startActivity(intent7);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
