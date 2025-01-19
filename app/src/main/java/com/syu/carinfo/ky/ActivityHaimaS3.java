package com.syu.carinfo.ky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityHaimaS3 extends Activity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ActivityHaimaS3.this.uBigLight(this.value);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_258_haima_s3);
        findViewById(R.id.ky_haimas3_biglightcomehome).setOnClickListener(this);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void uBigLight(int value) {
        if (findViewById(R.id.ky_haimas3_biglightcomehome) != null) {
            ((CheckedTextView) findViewById(R.id.ky_haimas3_biglightcomehome)).setChecked(value != 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ky_haimas3_biglightcomehome /* 2131428960 */:
                this.value = DataCanbus.DATA[100];
                DataCanbus.PROXY.cmd(3, 18, this.value == 0 ? 1 : 0);
                break;
        }
    }
}
