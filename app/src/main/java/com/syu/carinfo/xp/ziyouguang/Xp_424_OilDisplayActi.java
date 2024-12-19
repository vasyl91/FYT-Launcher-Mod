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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xp_424_OilDisplayActi extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_424_OilDisplayActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    Xp_424_OilDisplayActi.this.updaterMileageUnit();
                    Xp_424_OilDisplayActi.this.updaterTotalMile();
                    break;
                case 88:
                    Xp_424_OilDisplayActi.this.updaterOilUnit();
                    Xp_424_OilDisplayActi.this.updaterOilAvg();
                    break;
                case 89:
                    Xp_424_OilDisplayActi.this.updaterOilAvg();
                    break;
                case 90:
                    Xp_424_OilDisplayActi.this.updaterTotalMile();
                    break;
                case 91:
                    Xp_424_OilDisplayActi.this.updaterTotalOil();
                    break;
                case 92:
                    Xp_424_OilDisplayActi.this.updaterAvgSpeed();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_424_renault_dacia_oildisplay);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_424_OilDisplayActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Xp_424_OilDisplayActi.this.dialog();
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_M /* 1049000 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_H /* 1114536 */:
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_424_OilDisplayActi.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_424_OilDisplayActi.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Xp_424_OilDisplayActi.this.sendCmd(2, 1, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_424_OilDisplayActi.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Xp_424_OilDisplayActi.this.sendCmd(2, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int type, int cmd, int i) {
        DataCanbus.PROXY.cmd(0, new int[]{type, cmd, i}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        DataCanbus.PROXY.cmd(1, new int[1], null, null);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAvgSpeed() {
        int value = DataCanbus.DATA[92];
        if (((TextView) findViewById(R.id.xp_renault_avg_speed_tv)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.xp_renault_avg_speed_tv)).setText("---");
            } else {
                ((TextView) findViewById(R.id.xp_renault_avg_speed_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Km/H");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTotalOil() {
        int value = DataCanbus.DATA[91];
        if (((TextView) findViewById(R.id.xp_renault_total_oil_tv)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.xp_renault_total_oil_tv)).setText("---");
            } else {
                ((TextView) findViewById(R.id.xp_renault_total_oil_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTotalMile() {
        int value = DataCanbus.DATA[90];
        int unit = DataCanbus.DATA[87];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOilAvg() {
        int value = DataCanbus.DATA[89];
        int unit = DataCanbus.DATA[88];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOilUnit() {
        int value = DataCanbus.DATA[88];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMileageUnit() {
        int value = DataCanbus.DATA[87];
        if (((TextView) findViewById(R.id.xp_renault_mile_unit_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xp_renault_mile_unit_tv)).setText("Mile");
            } else {
                ((TextView) findViewById(R.id.xp_renault_mile_unit_tv)).setText("Km");
            }
        }
    }
}
