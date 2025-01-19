package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class Xp_424_OilDisplayActi extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    Xp_424_OilDisplayActi.this.updaterMileageUnit();
                    Xp_424_OilDisplayActi.this.updaterTotalMile();
                    break;
                case 100:
                    Xp_424_OilDisplayActi.this.updaterOilUnit();
                    Xp_424_OilDisplayActi.this.updaterOilAvg();
                    break;
                case 101:
                    Xp_424_OilDisplayActi.this.updaterOilAvg();
                    break;
                case 102:
                    Xp_424_OilDisplayActi.this.updaterTotalMile();
                    break;
                case 103:
                    Xp_424_OilDisplayActi.this.updaterTotalOil();
                    break;
                case 104:
                    Xp_424_OilDisplayActi.this.updaterAvgSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_424_renault_dacia_oildisplay);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Xp_424_OilDisplayActi.this.dialog();
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_M /* 1049000 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_H /* 1114536 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        Xp_424_OilDisplayActi.this.sendCmd(2, 1, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Xp_424_OilDisplayActi.this.sendCmd(2, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void sendCmd(int type, int cmd, int i) {
        DataCanbus.PROXY.cmd(0, new int[]{type, cmd, i}, null, null);
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
        DataCanbus.PROXY.cmd(1, new int[1], null, null);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAvgSpeed() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.xp_renault_avg_speed_tv)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.xp_renault_avg_speed_tv)).setText("---");
            } else {
                ((TextView) findViewById(R.id.xp_renault_avg_speed_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Km/H");
            }
        }
    }

    
    public void updaterTotalOil() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.xp_renault_total_oil_tv)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.xp_renault_total_oil_tv)).setText("---");
            } else {
                ((TextView) findViewById(R.id.xp_renault_total_oil_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L");
            }
        }
    }

    
    public void updaterTotalMile() {
        int value = DataCanbus.DATA[102];
        int unit = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.xp_renault_total_mile_tv)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.xp_renault_total_mile_tv)).setText("---");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.xp_renault_total_mile_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Mile");
            } else {
                ((TextView) findViewById(R.id.xp_renault_total_mile_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Km");
            }
        }
    }

    
    public void updaterOilAvg() {
        int value = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.xp_renault_oil_avage_tv)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.xp_renault_oil_avage_tv)).setText("---");
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.xp_renault_oil_avage_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Km/L");
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.xp_renault_oil_avage_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " MPG");
            } else if (unit == 3) {
                ((TextView) findViewById(R.id.xp_renault_oil_avage_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " MGP");
            } else {
                ((TextView) findViewById(R.id.xp_renault_oil_avage_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100Km");
            }
        }
    }

    
    public void updaterOilUnit() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.xp_renault_oil_unit_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_renault_oil_unit_tv)).setText("Km/L");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xp_renault_oil_unit_tv)).setText("MPG(US)");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xp_renault_oil_unit_tv)).setText("MGP(UK)");
            } else {
                ((TextView) findViewById(R.id.xp_renault_oil_unit_tv)).setText("L/100Km");
            }
        }
    }

    
    public void updaterMileageUnit() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.xp_renault_mile_unit_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_renault_mile_unit_tv)).setText("Mile");
            } else {
                ((TextView) findViewById(R.id.xp_renault_mile_unit_tv)).setText("Km");
            }
        }
    }
}
