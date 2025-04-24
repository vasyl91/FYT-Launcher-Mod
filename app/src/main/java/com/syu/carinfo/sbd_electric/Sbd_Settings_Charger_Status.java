package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Sbd_Settings_Charger_Status extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow1();
                    break;
                case 107:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow2();
                    break;
                case 108:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow3();
                    break;
                case 109:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow4();
                    break;
                case 110:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow5();
                    break;
                case 111:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow6();
                    break;
                case 112:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow7();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_charge);
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
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.Sbd_313_charge1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge1)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge1bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge1)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge1bstr)) + getString(R.string.setting_313_charge12bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.Sbd_313_charge2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge2)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge2bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge2)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge2bstr)) + getString(R.string.setting_313_charge22bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.Sbd_313_charge3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge3)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv2str)) + "：   " + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge3)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv2str)) + "：   " + getString(R.string.setting_313_charge32bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.Sbd_313_charge4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge4)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge4bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge4)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge4bstr)) + getString(R.string.setting_313_charge42bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.Sbd_313_charge5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge5)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge5bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge5)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge5bstr)) + getString(R.string.setting_313_charge52bstr), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.Sbd_313_charge6)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_charge6)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv3str)) + "：   " + (value / 10.0f) + "V", new Object[0]));
        }
    }

    
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.Sbd_313_charge7)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_charge7)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv4str)) + "：   " + (value / 10.0f) + "A", new Object[0]));
        }
    }
}
