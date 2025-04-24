package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Xp_374_OilDisplayActi extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 156:
                    Xp_374_OilDisplayActi.this.updaterDrivingMileage();
                    break;
                case 157:
                    Xp_374_OilDisplayActi.this.updaterOilConsumption();
                    break;
                case 158:
                    Xp_374_OilDisplayActi.this.updaterTripaAveOil();
                    break;
                case 159:
                    Xp_374_OilDisplayActi.this.updaterTripaAveSpeed();
                    break;
                case 160:
                    Xp_374_OilDisplayActi.this.updaterTripaTravelDis();
                    break;
                case 161:
                    Xp_374_OilDisplayActi.this.updaterTripaTravelTime();
                    break;
                case 162:
                    Xp_374_OilDisplayActi.this.updaterTripbAveOil();
                    break;
                case 163:
                    Xp_374_OilDisplayActi.this.updaterTripbAveSpeed();
                    break;
                case 164:
                    Xp_374_OilDisplayActi.this.updaterTripbTravelDis();
                    break;
                case 165:
                    Xp_374_OilDisplayActi.this.updaterTripbTravelTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_374_aegea_oildisplay);
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    protected void onResume() {
        DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
        super.onResume();
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
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterDrivingMileage() {
        int distanceunit = DataCanbus.DATA[99];
        int drivingmileage = DataCanbus.DATA[156];
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

    
    public void updaterOilConsumption() {
        int fuelunit = DataCanbus.DATA[98];
        int drivingmileage = DataCanbus.DATA[157];
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

    
    public void updaterTripaAveOil() {
        int fuelunit = DataCanbus.DATA[98];
        int drivingmileage = DataCanbus.DATA[158];
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

    
    public void updaterTripaAveSpeed() {
        int distanceunit = DataCanbus.DATA[99];
        int drivingmileage = DataCanbus.DATA[159];
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

    
    public void updaterTripaTravelDis() {
        int distanceunit = DataCanbus.DATA[99];
        int drivingmileage = DataCanbus.DATA[160];
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

    
    public void updaterTripaTravelTime() {
        int time = DataCanbus.DATA[161];
        if (time > -1) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(String.format("%d%d", Integer.valueOf((time >> 16) & 255), Integer.valueOf((time >> 8) & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            sb.append(String.valueOf(String.format("%d", Integer.valueOf(time & 255))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            if (((TextView) findViewById(R.id.xp_aegea_tripa_traveltime_tv)) != null) {
                ((TextView) findViewById(R.id.xp_aegea_tripa_traveltime_tv)).setText(sb.toString());
            }
        }
    }

    
    public void updaterTripbAveOil() {
        int fuelunit = DataCanbus.DATA[98];
        int drivingmileage = DataCanbus.DATA[162];
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

    
    public void updaterTripbAveSpeed() {
        int distanceunit = DataCanbus.DATA[99];
        int drivingmileage = DataCanbus.DATA[163];
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

    
    public void updaterTripbTravelDis() {
        int distanceunit = DataCanbus.DATA[99];
        int drivingmileage = DataCanbus.DATA[164];
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

    
    public void updaterTripbTravelTime() {
        int time = DataCanbus.DATA[165];
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
