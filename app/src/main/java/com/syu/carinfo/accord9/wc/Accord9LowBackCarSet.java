package com.syu.carinfo.accord9.wc;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Accord9LowBackCarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9LowBackCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 32:
                    Accord9LowBackCarSet.this.mUpdateCarBright();
                    break;
                case 33:
                    Accord9LowBackCarSet.this.mUpdateCarColor();
                    break;
                case 34:
                    Accord9LowBackCarSet.this.mUpdateCarContrast();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_low_backcar);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.accord9_low_backcar_brightness_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_brightness_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_color_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_color_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_contrast_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_contrast_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_trajectory)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_radar)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_backcar_sound_noise)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 42 || DataCanbus.DATA[1000] == 65578 || DataCanbus.DATA[1000] == 131114) {
            ((ViewGroup) findViewById(R.id.layout_button)).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 59) {
            ((TextView) findViewById(R.id.accord9_low_backcar_tv_bright)).setVisibility(8);
            ((TextView) findViewById(R.id.accord9_low_backcar_tv_contrast)).setVisibility(8);
            ((TextView) findViewById(R.id.accord9_low_backcar_tv_color)).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accord9_low_backcar_brightness_add /* 2131430168 */:
                setBright(-1);
                break;
            case R.id.accord9_low_backcar_brightness_sub /* 2131430170 */:
                setBright(-2);
                break;
            case R.id.accord9_low_backcar_contrast_add /* 2131430171 */:
                setConstrast(-1);
                break;
            case R.id.accord9_low_backcar_contrast_sub /* 2131430173 */:
                setConstrast(-2);
                break;
            case R.id.accord9_low_backcar_color_add /* 2131430174 */:
                setColor(-1);
                break;
            case R.id.accord9_low_backcar_color_sub /* 2131430176 */:
                setColor(-2);
                break;
        }
    }

    private void setBright(int value) {
    }

    private void setColor(int value) {
        DataCanbus.PROXY.cmd(12, value);
    }

    private void setConstrast(int value) {
        DataCanbus.PROXY.cmd(13, value);
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
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarBright() {
        int value = DataCanbus.DATA[32];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_bright)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarColor() {
        int value = DataCanbus.DATA[33];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_color)).setText(new StringBuilder().append(value - 5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarContrast() {
        int value = DataCanbus.DATA[34];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_contrast)).setText(new StringBuilder().append(value - 5).toString());
    }
}
