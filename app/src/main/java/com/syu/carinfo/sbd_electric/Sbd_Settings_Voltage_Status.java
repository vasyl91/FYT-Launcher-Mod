package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings_Voltage_Status extends BaseActivity {
    List<TextView> list = new ArrayList();
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings_Voltage_Status.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 81) {
                Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_high)) + (DataCanbus.DATA[updateCode] >> 16) + Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_jie);
                Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + String.format("%.3f", Float.valueOf((DataCanbus.DATA[updateCode] & 65535) / 1000.0f)) + "V";
                Sbd_Settings_Voltage_Status.this.list.get(0).setText(Sbd_Settings_Voltage_Status.this.str);
            } else {
                if (updateCode == 82) {
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_low)) + (DataCanbus.DATA[updateCode] >> 16) + Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_jie);
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + String.format("%.3f", Float.valueOf((DataCanbus.DATA[updateCode] & 65535) / 1000.0f)) + "V";
                    Sbd_Settings_Voltage_Status.this.list.get(1).setText(Sbd_Settings_Voltage_Status.this.str);
                    return;
                }
                int i = (updateCode - 41) + 2;
                if (i >= 2 && i < 42) {
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_monomer)) + (i - 1) + Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_monomer);
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_voltage) + DataCanbus.DATA[updateCode] + "mV";
                    Sbd_Settings_Voltage_Status.this.list.get(i).setText(Sbd_Settings_Voltage_Status.this.str);
                }
            }
        }
    };
    String str;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_electric_voltage);
        initView();
    }

    private void initView() {
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage1));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage2));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage3));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage4));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage5));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage6));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage7));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage8));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage9));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage10));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage11));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage12));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage13));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage14));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage15));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage16));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage17));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage18));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage19));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage20));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage21));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage22));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage23));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage24));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage25));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage26));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage27));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage28));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage29));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage30));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage31));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage32));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage33));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage34));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage35));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage36));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage37));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage38));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage39));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage40));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage41));
        this.list.add((TextView) findViewById(R.id.Sbd_313_voltage42));
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
    }
}
