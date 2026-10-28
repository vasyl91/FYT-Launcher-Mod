package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Sbd_Settings_Basic_info extends BaseActivity {
    private static int[] WarID = {R.string.crv_source_null, R.string.setting_313_basic61str, R.string.setting_313_basic62str, R.string.setting_313_basic63str, R.string.setting_313_basic64str, R.string.setting_313_basic65str, R.string.setting_313_basic66str, R.string.crv_source_null, R.string.setting_313_basic67str, R.string.setting_313_basic68str, R.string.setting_313_basic69str, R.string.setting_313_basic6astr, R.string.crv_source_null, R.string.setting_313_basic6bstr};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow1();
                    break;
                case 99:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow3();
                    break;
                case 100:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow4();
                    break;
                case 101:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow5();
                    break;
                case 102:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow6();
                    break;
                case 136:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_basic_info);
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
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[97];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic1)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic1str)) + getString(R.string.setting_313_basic11str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic1)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic1str)) + getString(R.string.setting_313_basic12str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[136];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic2)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic2str)) + getString(R.string.setting_313_basic21str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic2)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic2str)) + getString(R.string.setting_313_basic22str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic32str), new Object[0]));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic33str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic31str), new Object[0]));
            }
        }
    }

    
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic4)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic4)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic4str)) + value + " RPM", new Object[0]));
        }
    }

    
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic5)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic5)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv10str)) + value + " KM", new Object[0]));
        }
    }

    
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic6)) != null && value <= 13) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic6)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic6str)) + getString(WarID[value]), new Object[0]));
        }
    }
}
