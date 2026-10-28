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

@SuppressWarnings({"deprecation", "unchecked"})
public class GmAndraCarInfoTripB extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 180:
                case 189:
                    GmAndraCarInfoTripB.this.updateCarinfo1();
                    break;
                case 181:
                case 190:
                    GmAndraCarInfoTripB.this.updateCarinfo2();
                    break;
                case 182:
                case 191:
                    GmAndraCarInfoTripB.this.updateCarinfo3();
                    break;
                case 183:
                case 192:
                    GmAndraCarInfoTripB.this.updateCarinfo4();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_tripb_carinfo);
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
                dialog(R.string.str_trip_B);
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
                        DataCanbus.PROXY.cmd(3, new int[]{96, 2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[192];
        int unit = DataCanbus.DATA[183];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " miles/gal");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " L/100km");
        }
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[191];
        int unit = DataCanbus.DATA[182];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " gal");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " L");
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[190];
        int unit = DataCanbus.DATA[181];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km/h");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[189];
        int unit = DataCanbus.DATA[180];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " mile");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " km");
        }
    }
}
