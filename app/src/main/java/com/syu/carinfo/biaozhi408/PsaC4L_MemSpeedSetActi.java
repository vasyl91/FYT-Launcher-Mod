package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaC4L_MemSpeedSetActi extends BaseActivity implements View.OnClickListener {
    public static PsaC4L_MemSpeedSetActi mInstance;
    public static boolean mIsFront;
    private int i1;
    private int i2;
    private int i3;
    private int i4;
    private int i5;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            PsaC4L_MemSpeedSetActi.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 181:
                    PsaC4L_MemSpeedSetActi.this.uSpeedSelect(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 183:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue1(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 184:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue2(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 185:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue3(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 186:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue4(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 187:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue5(PsaC4L_MemSpeedSetActi.this.val);
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
    private int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_psa_mem_speed_set);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        findViewById(R.id.bz408_cruising_speed_speed_1).setOnClickListener(this);
        findViewById(R.id.bz408_cruising_speed_speed_2).setOnClickListener(this);
        findViewById(R.id.bz408_cruising_speed_speed_3).setOnClickListener(this);
        findViewById(R.id.bz408_cruising_speed_speed_4).setOnClickListener(this);
        findViewById(R.id.bz408_cruising_speed_speed_5).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_1_set_minus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_1_set_plus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_2_set_minus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_2_set_plus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_3_set_minus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_3_set_plus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_4_set_minus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_4_set_plus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_5_set_minus).setOnClickListener(this);
        findViewById(R.id.bz408_btn_cruising_speed_5_set_plus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bz408_cruising_speed_speed_1 /* 2131433341 */:
                this.i1 = this.i1 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_1_set_minus /* 2131433343 */:
                this.speed1 = setSpeedDown(this.speed1);
                break;
            case R.id.bz408_btn_cruising_speed_1_set_plus /* 2131433345 */:
                this.speed1 = setSpeedUp(this.speed1);
                break;
            case R.id.bz408_cruising_speed_speed_2 /* 2131433347 */:
                this.i2 = this.i2 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_2_set_minus /* 2131433349 */:
                this.speed2 = setSpeedDown(this.speed2);
                break;
            case R.id.bz408_btn_cruising_speed_2_set_plus /* 2131433351 */:
                this.speed2 = setSpeedUp(this.speed2);
                break;
            case R.id.bz408_cruising_speed_speed_3 /* 2131433353 */:
                this.i3 = this.i3 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_3_set_minus /* 2131433355 */:
                this.speed3 = setSpeedDown(this.speed3);
                break;
            case R.id.bz408_btn_cruising_speed_3_set_plus /* 2131433357 */:
                this.speed3 = setSpeedUp(this.speed3);
                break;
            case R.id.bz408_cruising_speed_speed_4 /* 2131433359 */:
                this.i4 = this.i4 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_4_set_minus /* 2131433361 */:
                this.speed4 = setSpeedDown(this.speed4);
                break;
            case R.id.bz408_btn_cruising_speed_4_set_plus /* 2131433363 */:
                this.speed4 = setSpeedUp(this.speed4);
                break;
            case R.id.bz408_cruising_speed_speed_5 /* 2131433365 */:
                this.i5 = this.i5 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_5_set_minus /* 2131433367 */:
                this.speed5 = setSpeedDown(this.speed5);
                break;
            case R.id.bz408_btn_cruising_speed_5_set_plus /* 2131433369 */:
                this.speed5 = setSpeedUp(this.speed5);
                break;
        }
    }

    protected int setSpeedDown(int val) {
        int val2 = val - 10;
        if (val2 < 0) {
            val2 = 0;
        }
        cmd();
        return val2;
    }

    protected int setSpeedUp(int val) {
        int val2 = val + 10;
        if (val2 > 400) {
            val2 = 400;
        }
        cmd();
        return val2;
    }

    protected void setState() {
        this.state = this.i5;
        this.state = (this.i4 == 1 ? 2 : 0) | this.state;
        this.state = (this.i3 == 1 ? 4 : 0) | this.state;
        this.state = (this.i2 == 1 ? 8 : 0) | this.state;
        this.state |= this.i1 == 1 ? 16 : 0;
        cmd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        mIsFront = false;
        super.onPause();
    }

    private void cmd() {
        int[] data = new int[6];
        if (DataCanbus.DATA[180] == 1) {
            data[0] = ((this.state & 31) << 1) | 64;
            data[1] = this.speed1;
            data[2] = this.speed2;
            data[3] = this.speed3;
            data[4] = this.speed4;
            data[5] = this.speed5;
            DataCanbus.PROXY.cmd(56, data, null, null);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1(int value) {
        this.speed1 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_1_set), value);
    }

    
    public void mUpdaterValue2(int value) {
        this.speed2 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_2_set), value);
    }

    
    public void mUpdaterValue3(int value) {
        this.speed3 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_3_set), value);
    }

    
    public void mUpdaterValue4(int value) {
        this.speed4 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_4_set), value);
    }

    
    public void mUpdaterValue5(int value) {
        this.speed5 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_5_set), value);
    }

    protected void uSpeedSelect(int val) {
        this.state = val;
        this.i5 = this.state & 1;
        this.i4 = (this.state >> 1) & 1;
        this.i3 = (this.state >> 2) & 1;
        this.i2 = (this.state >> 3) & 1;
        this.i1 = (this.state >> 4) & 1;
        updateCheckView();
    }

    private void updateCheckView() {
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_speed_1)).setChecked(this.i1 == 1);
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_speed_2)).setChecked(this.i2 == 1);
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_speed_3)).setChecked(this.i3 == 1);
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_speed_4)).setChecked(this.i4 == 1);
        ((CheckedTextView) findViewById(R.id.bz408_cruising_speed_speed_5)).setChecked(this.i5 == 1);
    }

    private void uCheck(CheckedTextView btn, boolean b) {
        if (btn != null) {
            btn.setChecked(b);
        }
    }

    private void uText(TextView tv, int val) {
        if (tv != null) {
            tv.setText(String.valueOf(val) + "km/h");
        }
    }
}
