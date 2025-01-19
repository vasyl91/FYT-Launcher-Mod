package com.syu.carinfo.rzc.andra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GmAndraCarInfoTripA extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 180:
                case 185:
                    GmAndraCarInfoTripA.this.updateCarinfo1();
                    break;
                case 181:
                case 186:
                    GmAndraCarInfoTripA.this.updateCarinfo2();
                    break;
                case 182:
                case 187:
                    GmAndraCarInfoTripA.this.updateCarinfo3();
                    break;
                case 183:
                case 188:
                    GmAndraCarInfoTripA.this.updateCarinfo4();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_tripa_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{74, 3}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.str_trip_A);
                break;
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{96, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[188];
        int unit = DataCanbus.DATA[183];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " miles/gal");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " L/100km");
        }
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[187];
        int unit = DataCanbus.DATA[182];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " gal");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " L");
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[186];
        int unit = DataCanbus.DATA[181];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km/h");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[185];
        int unit = DataCanbus.DATA[180];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " mile");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " km");
        }
    }
}
