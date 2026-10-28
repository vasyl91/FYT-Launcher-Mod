package com.syu.carinfo.ky.escort;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Ky_439_Escort_CarSettingAct extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    Ky_439_Escort_CarSettingAct.this.updateEngineCoolTemp();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_ky_escort_carsetting);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateEngineCoolTemp() {
        int enginecooltemp = DataCanbus.DATA[7] & 255;
        if (findViewById(R.id.ky_escort_enginecootemp_text) != null) {
            if ((enginecooltemp & 128) == 128) {
                if (enginecooltemp >= 206 && enginecooltemp <= 255) {
                    ((TextView) findViewById(R.id.ky_escort_enginecootemp_text)).setText(String.format("-%d  ℃", Integer.valueOf(((enginecooltemp ^ (-1)) + 1) & 255)));
                    return;
                }
                return;
            }
            if (enginecooltemp > 127) {
                enginecooltemp = 127;
            }
            if (enginecooltemp < 0) {
                enginecooltemp = 0;
            }
            ((TextView) findViewById(R.id.ky_escort_enginecootemp_text)).setText(String.format("%d   ℃", Integer.valueOf(enginecooltemp)));
        }
    }
}
