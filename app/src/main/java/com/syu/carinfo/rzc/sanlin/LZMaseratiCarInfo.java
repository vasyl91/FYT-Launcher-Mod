package com.syu.carinfo.rzc.sanlin;

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

public class LZMaseratiCarInfo extends BaseActivity implements View.OnClickListener {
    int oil_unit = 0;
    int distance_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km/h");
                    break;
                case 101:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mil");
                        break;
                    }
                case 102:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " rpm");
                    break;
                case 103:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                        break;
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " mil");
                        break;
                    }
                case 104:
                case 105:
                    int hour = DataCanbus.DATA[104];
                    int min = DataCanbus.DATA[105];
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + "H" + min + "M");
                    break;
                case 106:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km/h");
                    break;
                case 107:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " km");
                        break;
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " mil");
                        break;
                    }
                case 108:
                    if (LZMaseratiCarInfo.this.oil_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " l/100km");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 1) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " mpg(uk)");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 2) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " km/l");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 3) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " mpg(us)");
                        break;
                    }
                case 109:
                case 110:
                    int hour2 = DataCanbus.DATA[109];
                    int min2 = DataCanbus.DATA[110];
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(hour2) + "H" + min2 + "M");
                    break;
                case 111:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " km/h");
                    break;
                case 112:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " km");
                        break;
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " mil");
                        break;
                    }
                case 113:
                    if (LZMaseratiCarInfo.this.oil_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " l/100km");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 1) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " mpg(uk)");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 2) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " km/l");
                        break;
                    } else if (LZMaseratiCarInfo.this.oil_unit == 3) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " mpg(us)");
                        break;
                    }
                case 117:
                    LZMaseratiCarInfo.this.oil_unit = value;
                    break;
                case 125:
                    LZMaseratiCarInfo.this.distance_unit = value;
                    break;
                case 128:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " km");
                        break;
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " mil");
                        break;
                    }
                case 129:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " Day");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_maserati_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{57}, null, null);
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
                dialog(R.string.jiede_trip_a, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.str_trip_b, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{13, i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }
}
