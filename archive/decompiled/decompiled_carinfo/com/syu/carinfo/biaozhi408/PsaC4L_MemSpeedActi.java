package com.syu.carinfo.biaozhi408;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PsaC4L_MemSpeedActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        private int val;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 180:
                    PsaC4L_MemSpeedActi.this.mUpdaterOnOff();
                    break;
                case 181:
                    PsaC4L_MemSpeedActi.this.uSpeedSelect(this.val);
                    break;
                case 183:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue1(this.val);
                    break;
                case 184:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue2(this.val);
                    break;
                case 185:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue3(this.val);
                    break;
                case 186:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue4(this.val);
                    break;
                case 187:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue5(this.val);
                    break;
            }
        }
    };
    private int speed1;
    private int speed2;
    private int speed3;
    private int speed4;
    private int speed5;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_psa_mem_speed);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[180];
                int[] data = new int[6];
                data[0] = value == 0 ? 64 : 0;
                DataCanbus.PROXY.cmd(56, data, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PsaC4L_MemSpeedActi.this, PsaC4L_MemSpeedSetActi.class);
                    PsaC4L_MemSpeedActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_factory_data_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                PsaC4L_MemSpeedActi.this.dialog();
            }
        });
    }

    private void cmd() {
        int[] data = new int[6];
        data[0] = (DataCanbus.DATA[180] == 1 ? 64 : 0) | ((this.state & 31) << 1);
        data[1] = this.speed1;
        data[2] = this.speed2;
        data[3] = this.speed3;
        data[4] = this.speed4;
        data[5] = this.speed5;
        DataCanbus.PROXY.cmd(56, data, null, null);
    }

    protected void dialog() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(53, new int[]{59}, null, null);
            findViewById(R.id.bz408_cruising_speed_view_cruising_speed).setVisibility(0);
            findViewById(R.id.bz408_cruising_speed_view_factory_data_reset).setVisibility(8);
        } else {
            findViewById(R.id.bz408_cruising_speed_view_cruising_speed).setVisibility(8);
            findViewById(R.id.bz408_cruising_speed_view_factory_data_reset).setVisibility(0);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1(int value) {
        this.speed1 = value;
    }

    
    public void mUpdaterValue2(int value) {
        this.speed2 = value;
    }

    
    public void mUpdaterValue3(int value) {
        this.speed3 = value;
    }

    
    public void mUpdaterValue4(int value) {
        this.speed4 = value;
    }

    
    public void mUpdaterValue5(int value) {
        this.speed5 = value;
    }

    protected void uSpeedSelect(int val) {
        this.state = val;
    }

    
    public void mUpdaterOnOff() {
        int value = DataCanbus.DATA[180];
        if (((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)).setChecked(value != 0);
        }
    }
}
