package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Sbd_Settings_Motor_Status extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow1();
                    break;
                case 104:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow2();
                    break;
                case 105:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_motor_status);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.Sbd_313_motor1)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor1)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv1str)) + "：   " + (value / 10.0f) + "V", new Object[0]));
        }
    }

    
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.Sbd_313_motor2)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor2)).setText(String.format(String.valueOf(getString(R.string.setting_313_motor2bstr)) + "：   " + (value / 10.0f) + "A", new Object[0]));
        }
    }

    
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.Sbd_313_motor3)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor3)).setText(String.format(String.valueOf(getString(R.string.setting_313_motor3bstr)) + "：   " + (value / 10.0f) + "℃", new Object[0]));
        }
    }
}
