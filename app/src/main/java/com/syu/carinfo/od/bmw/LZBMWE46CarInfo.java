package com.syu.carinfo.od.bmw;

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

public class LZBMWE46CarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 8:
                    LZBMWE46CarInfo.this.updateCarinfo1();
                    break;
                case 9:
                    LZBMWE46CarInfo.this.updateCarinfo1();
                    break;
                case 10:
                case 11:
                    LZBMWE46CarInfo.this.updateCarinfo3();
                    break;
                case 12:
                    LZBMWE46CarInfo.this.updateCarinfo1();
                    LZBMWE46CarInfo.this.updateCarinfo2();
                    break;
                case 34:
                case 40:
                    int value = DataCanbus.DATA[34];
                    int unit = DataCanbus.DATA[40];
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        switch (unit) {
                            case 0:
                                ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text4)).setText("-" + value2 + "℃");
                                break;
                            case 1:
                                ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text4)).setText("-" + value2 + "℉");
                                break;
                        }
                    } else {
                        switch (unit) {
                            case 0:
                                ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text4)).setText(value + "℃");
                                break;
                            case 1:
                                ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text4)).setText(value + "℉");
                                break;
                        }
                    }
                case 35:
                    ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text5)).setText(DataCanbus.DATA[35] + " km/h");
                    break;
                case 36:
                    LZBMWE46CarInfo.this.updateCarinfo4();
                    break;
                case 39:
                    LZBMWE46CarInfo.this.updateCarinfo5();
                    break;
                case 41:
                    LZBMWE46CarInfo.this.updateCarinfo4();
                    LZBMWE46CarInfo.this.updateCarinfo5();
                    break;
                case 57:
                    if (val == 255) {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text8)).setText(val + " L");
                        break;
                    }
                case 58:
                    if (val == 255) {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text9)).setText(val / 10 + "." + (val % 10) + " V");
                        break;
                    }
                case 59:
                    if (val == 65535) {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWE46CarInfo.this.findViewById(R.id.tv_text10)).setText(val + " ℃");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_bmw_e46_carinfo);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
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
                dialog(9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(10);
                break;
        }
    }

    protected void dialog(final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (cmd == 9) {
            builder.setMessage(getResources().getString(R.string.confirm_reset) + " Oil consumption1 " + getResources().getString(R.string.data));
        } else {
            builder.setMessage(getResources().getString(R.string.confirm_reset) + " Oil consumption2 " + getResources().getString(R.string.data));
        }
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[39];
        int unit = DataCanbus.DATA[41];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(value + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(value + " mil");
                break;
        }
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[36];
        int unit = DataCanbus.DATA[41];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(value + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(value + " mil");
                break;
        }
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[10];
        int unit = DataCanbus.DATA[11];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " km/h");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " mph");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[9];
        int unit = DataCanbus.DATA[12];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " Km/L");
                break;
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[8];
        int unit = DataCanbus.DATA[12];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " Km/L");
                break;
        }
    }
}
