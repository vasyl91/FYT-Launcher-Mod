package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityQiYaKaiShenSet extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    ActivityQiYaKaiShenSet.this.updateBlindSpots(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_393_qiya_kaishen_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.rzc_qiya_blind_spots)).setOnClickListener(this);
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rzc_qiya_blind_spots /* 2131429655 */:
                int value = DataCanbus.DATA[104] == 1 ? 2 : 1;
                setCmd(1, value);
                break;
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(1, type, value);
    }

    protected void updateBlindSpots(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_qiya_blind_spots)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_qiya_blind_spots)).setChecked(value == 1);
        }
    }
}
