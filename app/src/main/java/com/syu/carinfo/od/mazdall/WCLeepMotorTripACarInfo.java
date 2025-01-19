package com.syu.carinfo.od.mazdall;

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

public class WCLeepMotorTripACarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 106:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 107:
                    if (value == 16777215) {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_leepmotor_tripa_carinfo);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.jiede_trip_a, 82);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.clear) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCLeepMotorTripACarInfo.this.setCarInfo(i, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCLeepMotorTripACarInfo.this.setCarInfo(i, 0, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }
}
