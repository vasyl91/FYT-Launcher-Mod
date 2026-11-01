package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Sbd_Settings extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    Sbd_Settings.this.mUpdaterDistance();
                    break;
                case 103:
                    Sbd_Settings.this.mUpdatersetshow1();
                    break;
                case 108:
                    Sbd_Settings.this.mUpdatersetshow2();
                    break;
                case 111:
                    Sbd_Settings.this.mUpdatersetshow3();
                    break;
                case 112:
                    Sbd_Settings.this.mUpdatersetshow4();
                    break;
                case 117:
                    Sbd_Settings.this.mUpdatersetshow6();
                    break;
                case 118:
                    Sbd_Settings.this.mUpdatersetshow7();
                    break;
                case 119:
                    Sbd_Settings.this.mUpdatersetshow8();
                    break;
                case 120:
                    Sbd_Settings.this.mUpdatersetshow9();
                    break;
                case 127:
                    Sbd_Settings.this.mUpdatersetshow5();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_carsetting);
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.setting_313_tv1)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv1)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.setting_313_tv2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv2)).setText(R.string.normal);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv2)).setText(R.string.setting_313_tv51str);
            }
        }
    }

    
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.setting_313_tv3)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv3)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.setting_313_tv4)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv4)).setText((value / 10) + "." + (value % 10) + "A");
        }
    }

    
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.setting_313_tv5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv5)).setText(R.string.normal);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv5)).setText(R.string.setting_313_tv51str);
            }
        }
    }

    
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.setting_313_tv6)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv6)).setText(R.string.setting_313_tv61str);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv6)).setText(R.string.setting_313_tv62str);
            }
        }
    }

    
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.setting_313_tv7)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv7)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    
    public void mUpdatersetshow8() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.setting_313_tv8)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv8)).setText((value / 10) + "." + (value % 10) + "A");
        }
    }

    
    public void mUpdatersetshow9() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.setting_313_tv9)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv9)).setText(value + "%");
        }
    }

    
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.setting_313_tv10)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv10)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv10str)) + value + " KM", new Object[0]));
        }
    }
}
