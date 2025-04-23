package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class SanlinCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (value == 0) {
                        ((TextView) SanlinCarInfo.this.findViewById(R.id.tv_text1)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                    } else if (value == 1) {
                        ((TextView) SanlinCarInfo.this.findViewById(R.id.tv_text1)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    } else if (value == 2) {
                        ((TextView) SanlinCarInfo.this.findViewById(R.id.tv_text1)).setText("MPG(us)");
                    } else if (value == 3) {
                        ((TextView) SanlinCarInfo.this.findViewById(R.id.tv_text1)).setText("MPG(uk)");
                    }
                    SanlinCarInfo.this.updateCarinfo1();
                    SanlinCarInfo.this.updateCarinfo2();
                    SanlinCarInfo.this.updateCarinfo3();
                    SanlinCarInfo.this.updateCarinfo4();
                    SanlinCarInfo.this.updateCarinfo5();
                    SanlinCarInfo.this.updateCarinfo6();
                    break;
                case 100:
                    SanlinCarInfo.this.updateCarinfo1();
                    break;
                case 101:
                    SanlinCarInfo.this.updateCarinfo2();
                    break;
                case 102:
                    SanlinCarInfo.this.updateCarinfo3();
                    break;
                case 103:
                    SanlinCarInfo.this.updateCarinfo4();
                    break;
                case 147:
                    int hour = value / 3600;
                    int min = (value % 3600) / 60;
                    ((TextView) SanlinCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                    break;
                case 148:
                    SanlinCarInfo.this.updateCarinfo5();
                    break;
                case 149:
                    SanlinCarInfo.this.updateCarinfo6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_sanlin_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_RZC_Sanlin_LancerEVO_08 /* 15991238 */:
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{64}, null, null);
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
                dialog(R.string.str_auto_avg_fuel, 29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.str_hand_avg_fuel, 30);
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
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[149];
        int unit = DataCanbus.DATA[99];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text8)).setText("----");
        }
        switch (unit) {
            case 0:
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                break;
            case 2:
            case 3:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " mph");
                break;
        }
    }

    
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[148];
        int unit = DataCanbus.DATA[99];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text7)).setText("----");
        }
        switch (unit) {
            case 0:
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                break;
            case 2:
            case 3:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                break;
        }
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[103];
        int unit = DataCanbus.DATA[99];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/L");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                break;
        }
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[102];
        int unit = DataCanbus.DATA[99];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/L");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[99];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/L");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                break;
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[100];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
        }
    }
}
