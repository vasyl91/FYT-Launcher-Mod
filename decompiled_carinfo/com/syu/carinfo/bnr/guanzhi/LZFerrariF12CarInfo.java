package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZFerrariF12CarInfo extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    if (LZFerrariF12CarInfo.this.unit == 1) {
                        ((TextView) LZFerrariF12CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZFerrariF12CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 8:
                    if (LZFerrariF12CarInfo.this.unit == 1) {
                        ((TextView) LZFerrariF12CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZFerrariF12CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 10:
                    LZFerrariF12CarInfo.this.unit = value;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_ferrari_f12_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
    }
}
