package com.syu.carinfo.oudi.bisu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityBiSuT3AndM3 extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode != 98) {
                return;
            }
            ActivityBiSuT3AndM3.this.setRadarMuteState(DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_216_oudi_bisut3);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, DataCanbus.DATA[98] == 0 ? 1 : 0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
    }

    
    public void setRadarMuteState(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }
}
