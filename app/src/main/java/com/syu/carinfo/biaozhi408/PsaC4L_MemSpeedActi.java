package com.syu.carinfo.biaozhi408;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PsaC4L_MemSpeedActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedActi.1
        private int val;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    PsaC4L_MemSpeedActi.this.mUpdaterOnOff();
                    break;
                case 115:
                    PsaC4L_MemSpeedActi.this.uSpeedSelect(this.val);
                    break;
                case 117:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue1(this.val);
                    break;
                case 118:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue2(this.val);
                    break;
                case 119:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue3(this.val);
                    break;
                case 120:
                    PsaC4L_MemSpeedActi.this.mUpdaterValue4(this.val);
                    break;
                case 121:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_psa_mem_speed);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[114];
                int[] data = new int[6];
                data[0] = value == 0 ? 64 : 0;
                DataCanbus.PROXY.cmd(56, data, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedActi.3
            @Override // android.view.View.OnClickListener
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
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_factory_data_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PsaC4L_MemSpeedActi.this.dialog();
            }
        });
    }

    private void cmd() {
        int[] data = new int[6];
        data[0] = (DataCanbus.DATA[114] == 1 ? 64 : 0) | ((this.state & 31) << 1);
        data[1] = this.speed1;
        data[2] = this.speed2;
        data[3] = this.speed3;
        data[4] = this.speed4;
        data[5] = this.speed5;
        DataCanbus.PROXY.cmd(56, data, null, null);
    }

    protected void dialog() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(53, new int[]{59}, null, null);
            findViewById(R.id.bz408_cruising_speed_view_cruising_speed).setVisibility(0);
            findViewById(R.id.bz408_cruising_speed_view_factory_data_reset).setVisibility(8);
        } else {
            findViewById(R.id.bz408_cruising_speed_view_cruising_speed).setVisibility(8);
            findViewById(R.id.bz408_cruising_speed_view_factory_data_reset).setVisibility(0);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1(int value) {
        this.speed1 = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2(int value) {
        this.speed2 = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3(int value) {
        this.speed3 = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4(int value) {
        this.speed4 = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5(int value) {
        this.speed5 = value;
    }

    protected void uSpeedSelect(int val) {
        this.state = val;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOnOff() {
        int value = DataCanbus.DATA[114];
        if (((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_btn_cruising_speed)).setChecked(value != 0);
        }
    }
}
