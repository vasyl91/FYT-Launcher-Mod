package com.syu.carinfo.sos;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivitySos extends Activity {
    int Old_App_Id;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 101) {
                if (DataCanbus.DATA[101] == 1) {
                    if (DataMain.DATA[0] != 12) {
                        ActivitySos.this.Old_App_Id = DataMain.DATA[0];
                        DataMain.PROXY.cmd(0, 12);
                        return;
                    }
                    return;
                }
                DataMain.PROXY.cmd(0, ActivitySos.this.Old_App_Id);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_280_sos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
