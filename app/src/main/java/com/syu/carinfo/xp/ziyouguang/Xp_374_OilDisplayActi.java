package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xp_374_OilDisplayActi extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_374_OilDisplayActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 144:
                    Xp_374_OilDisplayActi.this.updaterDrivingMileage();
                    break;
                case 145:
                    Xp_374_OilDisplayActi.this.updaterOilConsumption();
                    break;
                case 146:
                    Xp_374_OilDisplayActi.this.updaterTripaAveOil();
                    break;
                case 147:
                    Xp_374_OilDisplayActi.this.updaterTripaAveSpeed();
                    break;
                case 148:
                    Xp_374_OilDisplayActi.this.updaterTripaTravelDis();
                    break;
                case 149:
                    Xp_374_OilDisplayActi.this.updaterTripaTravelTime();
                    break;
                case 150:
                    Xp_374_OilDisplayActi.this.updaterTripbAveOil();
                    break;
                case 151:
                    Xp_374_OilDisplayActi.this.updaterTripbAveSpeed();
                    break;
                case 152:
                    Xp_374_OilDisplayActi.this.updaterTripbTravelDis();
                    break;
                case 153:
                    Xp_374_OilDisplayActi.this.updaterTripbTravelTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_374_aegea_oildisplay);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // android.app.Activity
    protected void onResume() {
        DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDrivingMileage() {
        int distanceunit = DataCanbus.DATA[87];
        int drivingmileage = DataCanbus.DATA[144];
        if (((TextView) findViewById(R.id.xp_aegea_drivingmileage_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_drivingmileage_tv)).setText("---");
            } else if (distanceunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_drivingmileage_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " MI");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_drivingmileage_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOilConsumption() {
        int fuelunit = DataCanbus.DATA[86];
        int drivingmileage = DataCanbus.DATA[145];
        if (((TextView) findViewById(R.id.xp_aegea_currentoil_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_currentoil_tv)).setText("--.-");
                return;
            }
            if (fuelunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_currentoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " KM/L");
            }
            if (fuelunit == 2) {
                ((TextView) findViewById(R.id.xp_aegea_currentoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/US");
            }
            if (fuelunit == 3) {
                ((TextView) findViewById(R.id.xp_aegea_currentoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/UK");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_currentoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripaAveOil() {
        int fuelunit = DataCanbus.DATA[86];
        int drivingmileage = DataCanbus.DATA[146];
        if (((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)).setText("--.-");
                return;
            }
            if (fuelunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " KM/L");
            }
            if (fuelunit == 2) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/US");
            }
            if (fuelunit == 3) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/UK");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripa_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripaAveSpeed() {
        int distanceunit = DataCanbus.DATA[87];
        int drivingmileage = DataCanbus.DATA[147];
        if (((TextView) findViewById(R.id.xp_aegea_tripa_avespeed_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_avespeed_tv)).setText("---");
            } else if (distanceunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_avespeed_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " MP/H");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripa_avespeed_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " KM/H");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripaTravelDis() {
        int distanceunit = DataCanbus.DATA[87];
        int drivingmileage = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.xp_aegea_tripa_traveldis_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_traveldis_tv)).setText("---");
            } else if (distanceunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_traveldis_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(drivingmileage / 10), Integer.valueOf(drivingmileage % 10))) + " MP");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripa_traveldis_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(drivingmileage / 10), Integer.valueOf(drivingmileage % 10))) + " KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripaTravelTime() {
        int time = DataCanbus.DATA[149];
        if (time > -1) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(String.format("%d%d", Integer.valueOf((time >> 16) & 255), Integer.valueOf((time >> 8) & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            sb.append(String.valueOf(String.format("%d", Integer.valueOf(time & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            if (((TextView) findViewById(R.id.xp_aegea_tripa_traveltime_tv)) != null) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_traveltime_tv)).setText(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripbAveOil() {
        int fuelunit = DataCanbus.DATA[86];
        int drivingmileage = DataCanbus.DATA[150];
        if (((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)).setText("--.-");
                return;
            }
            if (fuelunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " KM/L");
            }
            if (fuelunit == 2) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/US");
            }
            if (fuelunit == 3) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " MPG/UK");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripb_aveoil_tv)).setText(String.valueOf(String.format("%02x.%02x", Integer.valueOf((drivingmileage >> 8) & 255), Integer.valueOf(drivingmileage & 255))) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripbAveSpeed() {
        int distanceunit = DataCanbus.DATA[87];
        int drivingmileage = DataCanbus.DATA[151];
        if (((TextView) findViewById(R.id.xp_aegea_tripb_avespeed_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_avespeed_tv)).setText("---");
            } else if (distanceunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_avespeed_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " MP/H");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripb_avespeed_tv)).setText(String.valueOf(String.format("%d", Integer.valueOf(drivingmileage))) + " KM/H");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripbTravelDis() {
        int distanceunit = DataCanbus.DATA[87];
        int drivingmileage = DataCanbus.DATA[152];
        if (((TextView) findViewById(R.id.xp_aegea_tripb_traveldis_tv)) != null) {
            if (drivingmileage == 65535) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_traveldis_tv)).setText("---");
            } else if (distanceunit == 1) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_traveldis_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(drivingmileage / 10), Integer.valueOf(drivingmileage % 10))) + " MP");
            } else {
                ((TextView) findViewById(R.id.xp_aegea_tripb_traveldis_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(drivingmileage / 10), Integer.valueOf(drivingmileage % 10))) + " KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTripbTravelTime() {
        int time = DataCanbus.DATA[153];
        if (time > -1) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(String.format("%d%d", Integer.valueOf((time >> 16) & 255), Integer.valueOf((time >> 8) & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            sb.append(String.valueOf(String.format("%d", Integer.valueOf(time & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            if (((TextView) findViewById(R.id.xp_aegea_tripb_traveltime_tv)) != null) {
                ((TextView) findViewById(R.id.xp_aegea_tripb_traveltime_tv)).setText(sb.toString());
            }
        }
    }
}
