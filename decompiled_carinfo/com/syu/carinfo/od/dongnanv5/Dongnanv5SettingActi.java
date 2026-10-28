package com.syu.carinfo.od.dongnanv5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dongnanv5SettingActi extends BaseActivity {
    private Button mBtnBackshowMinus;
    private Button mBtnBackshowPlus;
    private CheckedTextView mCtvBlindwarnOnChoose;
    private CheckedTextView mCtvLightOnChoose;
    private CheckedTextView mCtvPhotoOnChoose;
    private TextView mTvBackshowInfo;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 18:
                    Dongnanv5SettingActi.this.mUpdatePhotoOn(value);
                    break;
                case 19:
                    Dongnanv5SettingActi.this.mUpdaterLightOn(value);
                    break;
                case 20:
                    Dongnanv5SettingActi.this.mUpdaterBlindwarnOn(value);
                    break;
                case 21:
                    Dongnanv5SettingActi.this.updateBackshowInfo(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_dongnanv5_functional_state);
        this.mTvBackshowInfo = (TextView) findViewById(R.id.tv_dongnanv5_back_show);
        this.mBtnBackshowMinus = (Button) findViewById(R.id.dongnanv5_btn_backshow_minus);
        this.mBtnBackshowMinus.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[21] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        this.mBtnBackshowPlus = (Button) findViewById(R.id.dongnanv5_btn_backshow_plus);
        this.mBtnBackshowPlus.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[21] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        this.mCtvPhotoOnChoose = (CheckedTextView) findViewById(R.id.ctv_dongnanv5_set_photo_onoff);
        this.mCtvPhotoOnChoose.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[18];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        this.mCtvLightOnChoose = (CheckedTextView) findViewById(R.id.ctv_dongnanv5_set_light_onoff);
        this.mCtvLightOnChoose.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[19];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        this.mCtvBlindwarnOnChoose = (CheckedTextView) findViewById(R.id.ctv_dongnanv5_set_blind_onoff);
        this.mCtvBlindwarnOnChoose.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
    }

    
    public void updateBackshowInfo(int value) {
        switch (value) {
            case 0:
                this.mTvBackshowInfo.setText(R.string.str_pack_backcart);
                break;
            case 1:
                this.mTvBackshowInfo.setText(R.string.str_boyue_str15);
                break;
        }
    }

    
    public void mUpdatePhotoOn(int value) {
        if (this.mCtvPhotoOnChoose != null) {
            this.mCtvPhotoOnChoose.setChecked(value == 1);
        }
    }

    
    public void mUpdaterLightOn(int value) {
        if (this.mCtvLightOnChoose != null) {
            this.mCtvLightOnChoose.setChecked(value == 1);
        }
    }

    
    public void mUpdaterBlindwarnOn(int value) {
        if (this.mCtvBlindwarnOnChoose != null) {
            this.mCtvBlindwarnOnChoose.setChecked(value == 1);
        }
    }
}
