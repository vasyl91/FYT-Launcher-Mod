package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.R;
import com.syu.carinfo.rzc.andra.GmAndraTireAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcKlcIndex extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    int value = DataCanbus.DATA[132];
                    if (value == 1) {
                        RzcKlcIndex.this.findViewById(R.id.layout_view1).setVisibility(0);
                        break;
                    } else {
                        RzcKlcIndex.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_klc_index);
        setUI();
    }

    private void setUI() {
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_EV /* 7274557 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_PHEV /* 7340093 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view7).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_HUMMER_09_H2 /* 5308477 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban /* 7471165 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban_H /* 7536701 */:
                findViewById(R.id.layout_view9).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view9).setVisibility(8);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCKlcEVCarInfo.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, RZCKlcCarSet2.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, RzcKlcCarSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, RzcKlcAirAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, RzcKlcComfortAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, RzcKlcOnStarAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                try {
                    Intent intent7 = new Intent();
                    intent7.setClass(this, RZCChargeIndexAct.class);
                    startActivity(intent7);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                try {
                    Intent intent8 = new Intent();
                    intent8.setClass(this, GmAndraTireAct.class);
                    startActivity(intent8);
                    break;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                try {
                    Intent intent9 = new Intent();
                    intent9.setClass(this, RZCKlcCarAmpSet.class);
                    startActivity(intent9);
                    break;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{67}, null, null);
        DataCanbus.PROXY.cmd(8, new int[]{6}, null, null);
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }
}
