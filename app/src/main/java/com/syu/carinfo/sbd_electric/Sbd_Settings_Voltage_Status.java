package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"deprecation", "unchecked"})
public class Sbd_Settings_Voltage_Status extends BaseActivity {
    List<TextView> list = new ArrayList();
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 178) {
                Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_high)) + (DataCanbus.DATA[updateCode] >> 16) + Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_jie);
                Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + String.format("%.3f", Float.valueOf((DataCanbus.DATA[updateCode] & 65535) / 1000.0f)) + "V";
                Sbd_Settings_Voltage_Status.this.list.get(0).setText(Sbd_Settings_Voltage_Status.this.str);
            } else {
                if (updateCode == 179) {
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_low)) + (DataCanbus.DATA[updateCode] >> 16) + Sbd_Settings_Voltage_Status.this.getString(R.string.Sbd_313_voltage_jie);
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + String.format("%.3f", Float.valueOf((DataCanbus.DATA[updateCode] & 65535) / 1000.0f)) + "V";
                    Sbd_Settings_Voltage_Status.this.list.get(1).setText(Sbd_Settings_Voltage_Status.this.str);
                    return;
                }
                int i = (updateCode - 138) + 2;
                if (i >= 2 && i < 42) {
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_monomer)) + (i - 1) + Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_monomer);
                    Sbd_Settings_Voltage_Status.this.str = String.valueOf(Sbd_Settings_Voltage_Status.this.str) + Sbd_Settings_Voltage_Status.this.getString(R.string.sbd_313_voltage) + DataCanbus.DATA[updateCode] + "mV";
                    Sbd_Settings_Voltage_Status.this.list.get(i).setText(Sbd_Settings_Voltage_Status.this.str);
                }
            }
        }
    };
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_voltage);
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
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }
}
