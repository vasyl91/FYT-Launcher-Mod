package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PsaC4L_MemSpeedSetActi extends BaseActivity implements View.OnClickListener {
    public static PsaC4L_MemSpeedSetActi mInstance;
    public static boolean mIsFront;
    private int i1;
    private int i2;
    private int i3;
    private int i4;
    private int i5;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            PsaC4L_MemSpeedSetActi.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    PsaC4L_MemSpeedSetActi.this.uSpeedSelect(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 117:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue1(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 118:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue2(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 119:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue3(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 120:
                    PsaC4L_MemSpeedSetActi.this.mUpdaterValue4(PsaC4L_MemSpeedSetActi.this.val);
                    break;
                case 121:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_psa_mem_speed_set);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bz408_cruising_speed_speed_1 /* 2131433419 */:
                this.i1 = this.i1 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_1_set_minus /* 2131433421 */:
                this.speed1 = setSpeedDown(this.speed1);
                break;
            case R.id.bz408_btn_cruising_speed_1_set_plus /* 2131433423 */:
                this.speed1 = setSpeedUp(this.speed1);
                break;
            case R.id.bz408_cruising_speed_speed_2 /* 2131433425 */:
                this.i2 = this.i2 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_2_set_minus /* 2131433427 */:
                this.speed2 = setSpeedDown(this.speed2);
                break;
            case R.id.bz408_btn_cruising_speed_2_set_plus /* 2131433429 */:
                this.speed2 = setSpeedUp(this.speed2);
                break;
            case R.id.bz408_cruising_speed_speed_3 /* 2131433431 */:
                this.i3 = this.i3 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_3_set_minus /* 2131433433 */:
                this.speed3 = setSpeedDown(this.speed3);
                break;
            case R.id.bz408_btn_cruising_speed_3_set_plus /* 2131433435 */:
                this.speed3 = setSpeedUp(this.speed3);
                break;
            case R.id.bz408_cruising_speed_speed_4 /* 2131433437 */:
                this.i4 = this.i4 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_4_set_minus /* 2131433439 */:
                this.speed4 = setSpeedDown(this.speed4);
                break;
            case R.id.bz408_btn_cruising_speed_4_set_plus /* 2131433441 */:
                this.speed4 = setSpeedUp(this.speed4);
                break;
            case R.id.bz408_cruising_speed_speed_5 /* 2131433443 */:
                this.i5 = this.i5 != 1 ? 1 : 0;
                setState();
                break;
            case R.id.bz408_btn_cruising_speed_5_set_minus /* 2131433445 */:
                this.speed5 = setSpeedDown(this.speed5);
                break;
            case R.id.bz408_btn_cruising_speed_5_set_plus /* 2131433447 */:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        mIsFront = false;
        super.onPause();
    }

    private void cmd() {
        int[] data = new int[6];
        if (DataCanbus.DATA[114] == 1) {
            data[0] = ((this.state & 31) << 1) | 64;
            data[1] = this.speed1;
            data[2] = this.speed2;
            data[3] = this.speed3;
            data[4] = this.speed4;
            data[5] = this.speed5;
            DataCanbus.PROXY.cmd(56, data, null, null);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1(int value) {
        this.speed1 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_1_set), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2(int value) {
        this.speed2 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_2_set), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3(int value) {
        this.speed3 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_3_set), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4(int value) {
        this.speed4 = value;
        uText((TextView) findViewById(R.id.bz408_tv_cruising_speed_4_set), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
