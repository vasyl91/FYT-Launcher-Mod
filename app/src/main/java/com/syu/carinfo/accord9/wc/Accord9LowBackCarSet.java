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

@SuppressWarnings({"deprecation", "unchecked"})
public class Accord9LowBackCarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 130:
                    Accord9LowBackCarSet.this.mUpdateCarBright();
                    break;
                case 131:
                    Accord9LowBackCarSet.this.mUpdateCarColor();
                    break;
                case 132:
                    Accord9LowBackCarSet.this.mUpdateCarContrast();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_accord9_low_backcar);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accord9_low_backcar_brightness_add /* 2131430110 */:
                setBright(-1);
                break;
            case R.id.accord9_low_backcar_brightness_sub /* 2131430112 */:
                setBright(-2);
                break;
            case R.id.accord9_low_backcar_contrast_add /* 2131430113 */:
                setConstrast(-1);
                break;
            case R.id.accord9_low_backcar_contrast_sub /* 2131430115 */:
                setConstrast(-2);
                break;
            case R.id.accord9_low_backcar_color_add /* 2131430116 */:
                setColor(-1);
                break;
            case R.id.accord9_low_backcar_color_sub /* 2131430118 */:
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
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCarBright() {
        int value = DataCanbus.DATA[130];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_bright)).setText(new StringBuilder().append(value).toString());
    }

    
    public void mUpdateCarColor() {
        int value = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_color)).setText(new StringBuilder().append(value - 5).toString());
    }

    
    public void mUpdateCarContrast() {
        int value = DataCanbus.DATA[132];
        ((TextView) findViewById(R.id.accord9_low_backcar_tv_contrast)).setText(new StringBuilder().append(value - 5).toString());
    }
}
