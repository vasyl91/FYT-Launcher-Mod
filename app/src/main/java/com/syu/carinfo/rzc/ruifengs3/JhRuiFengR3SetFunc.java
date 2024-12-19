package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JhRuiFengR3SetFunc extends BaseActivity {
    private Button mBtnAutoLockMinus;
    private Button mBtnAutoLockPlus;
    private Button mBtnInterLightMinus;
    private Button mBtnInterLightPlus;
    private Button mBtnOutLightMinus;
    private Button mBtnOutLightPlus;
    private Button mBtnTishiVolMinus;
    private Button mBtnTishiVolPlus;
    private CheckedTextView mCtvLocaLightChoose;
    private CheckedTextView mCtvShefTishiChoose;
    private TextView mTvAutoLockSet;
    private TextView mTvInterLightSet;
    private TextView mTvOutLightSet;
    private TextView mTvTishiVolSet;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 32:
                    JhRuiFengR3SetFunc.this.updateTishiVol(value);
                    break;
                case 33:
                    JhRuiFengR3SetFunc.this.updateOutLightOffTime(value);
                    break;
                case 34:
                    JhRuiFengR3SetFunc.this.updateInterLightOffTime(value);
                    break;
                case 35:
                    JhRuiFengR3SetFunc.this.updateAutoLock(value);
                    break;
                case 36:
                    JhRuiFengR3SetFunc.this.mUpdaterPromptll(value);
                    break;
                case 37:
                    JhRuiFengR3SetFunc.this.mUpdaterLocaLight(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ruifengr3_setfunc);
        this.mTvTishiVolSet = (TextView) findViewById(R.id.tv_ruifengr3_tishivol);
        this.mBtnTishiVolMinus = (Button) findViewById(R.id.ruifengr3_btn_tishivol_minus);
        this.mBtnTishiVolMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        this.mBtnTishiVolPlus = (Button) findViewById(R.id.ruifengr3_btn_tishivol_plus);
        this.mBtnTishiVolPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        this.mTvOutLightSet = (TextView) findViewById(R.id.tv_ruifengr3_outlight);
        this.mBtnOutLightMinus = (Button) findViewById(R.id.ruifengr3_btn_outlight_minus);
        this.mBtnOutLightMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        this.mBtnOutLightPlus = (Button) findViewById(R.id.ruifengr3_btn_outlight_plus);
        this.mBtnOutLightPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        this.mTvInterLightSet = (TextView) findViewById(R.id.tv_ruifengr3_interlight);
        this.mBtnInterLightMinus = (Button) findViewById(R.id.ruifengr3_btn_interlight_minus);
        this.mBtnInterLightMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        this.mBtnInterLightPlus = (Button) findViewById(R.id.ruifengr3_btn_interlight_plus);
        this.mBtnInterLightPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        this.mTvAutoLockSet = (TextView) findViewById(R.id.tv_ruifengr3_autolock);
        this.mBtnAutoLockMinus = (Button) findViewById(R.id.ruifengr3_btn_auolock_minus);
        this.mBtnAutoLockMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        this.mBtnAutoLockPlus = (Button) findViewById(R.id.ruifengr3_btn_autolock_plus);
        this.mBtnAutoLockPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        this.mCtvShefTishiChoose = (CheckedTextView) findViewById(R.id.ctv_ruifengr3_shefangtishi);
        this.mCtvShefTishiChoose.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[36];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        this.mCtvLocaLightChoose = (CheckedTextView) findViewById(R.id.ctv_ruifengr3_dingwlight);
        this.mCtvLocaLightChoose.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3SetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTishiVol(int value) {
        switch (value) {
            case 0:
                this.mTvTishiVolSet.setText(R.string.klc_air_low);
                break;
            case 1:
                this.mTvTishiVolSet.setText(R.string.klc_air_middle);
                break;
            case 2:
                this.mTvTishiVolSet.setText(R.string.klc_air_high);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutLightOffTime(int value) {
        switch (value) {
            case 0:
                this.mTvOutLightSet.setText("0");
                break;
            case 1:
                this.mTvOutLightSet.setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 2:
                this.mTvOutLightSet.setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 3:
                this.mTvOutLightSet.setText(R.string.wc_ruiteng_string_time_2);
                break;
            case 4:
                this.mTvOutLightSet.setText(R.string.wc_ruiteng_string_time_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterLightOffTime(int value) {
        switch (value) {
            case 0:
                this.mTvInterLightSet.setText("0");
                break;
            case 1:
                this.mTvInterLightSet.setText(R.string.wc_ruiteng_string_time_10);
                break;
            case 2:
                this.mTvInterLightSet.setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 3:
                this.mTvInterLightSet.setText(R.string.wc_ruiteng_string_time_11);
                break;
            case 4:
                this.mTvInterLightSet.setText(R.string.wc_ruiteng_string_time_1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLock(int value) {
        switch (value) {
            case 0:
                this.mTvAutoLockSet.setText(R.string.jeep_comfortsystems_0);
                break;
            case 1:
                this.mTvAutoLockSet.setText(R.string.str_419_auto_lock_when_15);
                break;
            case 2:
                this.mTvAutoLockSet.setText(R.string.str_419_auto_lock_when_40);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPromptll(int value) {
        if (this.mCtvShefTishiChoose != null) {
            this.mCtvShefTishiChoose.setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLocaLight(int value) {
        if (this.mCtvLocaLightChoose != null) {
            this.mCtvLocaLightChoose.setChecked(value == 1);
        }
    }
}
