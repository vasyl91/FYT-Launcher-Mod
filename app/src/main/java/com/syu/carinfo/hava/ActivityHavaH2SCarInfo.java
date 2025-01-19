package com.syu.carinfo.hava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityHavaH2SCarInfo extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + "V");
                        break;
                    }
                case 100:
                    if (((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + "℃");
                        break;
                    }
                case 101:
                    if (((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityHavaH2SCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_132_havah2s_info);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
