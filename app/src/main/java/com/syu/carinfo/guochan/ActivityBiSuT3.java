package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityBiSuT3 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    ActivityBiSuT3.this.updateRadarSound(value);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_bisu_t3);
        setListener();
    }

    private void setListener() {
        if (((CheckedTextView) findViewById(R.id.t3_radar_warning_sound)) != null) {
            ((CheckedTextView) findViewById(R.id.t3_radar_warning_sound)).setOnClickListener(this);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t3_radar_warning_sound /* 2131428961 */:
                this.value = DataCanbus.DATA[135] & 255;
                sendCmd(this.value == 0 ? 1 : 0);
                break;
        }
    }

    private void sendCmd(int value) {
        DataCanbus.PROXY.cmd(2, value);
    }

    protected void updateRadarSound(int value) {
        if (((CheckedTextView) findViewById(R.id.t3_radar_warning_sound)) != null) {
            ((CheckedTextView) findViewById(R.id.t3_radar_warning_sound)).setChecked(value != 0);
        }
    }
}
