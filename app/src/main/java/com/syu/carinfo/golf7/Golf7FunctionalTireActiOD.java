package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalTireActiOD extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 184:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fl)).setText(Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]));
                    break;
                case 185:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fr)).setText(Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]));
                    break;
                case 186:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rl)).setText(Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]));
                    break;
                case 187:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rr)).setText(Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]));
                    break;
                case 279:
                    int alarm0 = (DataCanbus.DATA[updateCode] >> 8) & 255;
                    int alarm1 = DataCanbus.DATA[updateCode] & 255;
                    String str = null;
                    if (alarm1 > 1 && alarm1 <= 4) {
                        if ((alarm0 & 1) == 1) {
                            str = Golf7FunctionalTireActiOD.this.getString(R.string.str_wc_rfs2_12);
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fl)).setTextColor(-65536);
                        } else if (((alarm0 >> 1) & 1) == 1) {
                            str = Golf7FunctionalTireActiOD.this.getString(R.string.str_wc_rfs2_13);
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fr)).setTextColor(-65536);
                        } else if (((alarm0 >> 2) & 1) == 1) {
                            str = Golf7FunctionalTireActiOD.this.getString(R.string.str_wc_rfs2_14);
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rl)).setTextColor(-65536);
                        } else if (((alarm0 >> 3) & 1) == 1) {
                            str = Golf7FunctionalTireActiOD.this.getString(R.string.str_wc_rfs2_15);
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rr)).setTextColor(-65536);
                        }
                        if (alarm1 == 2 && str != null) {
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiOD.this.getString(R.string.str_40_od_tire_2));
                            break;
                        } else if (alarm1 == 3 && str != null) {
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiOD.this.getString(R.string.str_40_od_tire_3));
                            break;
                        } else if (alarm1 == 4 && str != null) {
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiOD.this.getString(R.string.str_40_od_tire_4));
                            break;
                        } else {
                            ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_alarm)).setText(" ");
                            break;
                        }
                    } else {
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_alarm)).setText(Golf7FunctionalTireActiOD.this.getString(R.string.tireflnormal));
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fl)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_fr)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rl)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_rr)).setTextColor(-1);
                        break;
                    }
                case 280:
                    if (DataCanbus.DATA[updateCode] == 2) {
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_unit)).setText("kPa");
                        break;
                    } else if (DataCanbus.DATA[updateCode] == 1) {
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_unit)).setText("psi");
                        break;
                    } else {
                        ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_unit)).setText("bar");
                        break;
                    }
                case 281:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_ck_fl)).setText("(" + Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]) + ")");
                    break;
                case 282:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_ck_fr)).setText("(" + Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]) + ")");
                    break;
                case 283:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_ck_rl)).setText("(" + Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]) + ")");
                    break;
                case 284:
                    ((TextView) Golf7FunctionalTireActiOD.this.findViewById(R.id.tv_tire_ck_rr)).setText("(" + Golf7FunctionalTireActiOD.this.getPressureStr(DataCanbus.DATA[updateCode]) + ")");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_tire_od);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
    }

    
    public String getPressureStr(int value) {
        if (value % 10 == 0) {
            String str = new StringBuilder().append(value / 10).toString();
            return str;
        }
        String str2 = String.valueOf(value / 10) + "." + (value % 10);
        return str2;
    }

    private void mUpdaterEscSystem() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
