package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZRomeoCarInfo extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    if (LZRomeoCarInfo.this.unit == 1) {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 127:
                    if (LZRomeoCarInfo.this.unit == 1) {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 129:
                    LZRomeoCarInfo.this.unit = value;
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("N");
                            break;
                        case 1:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("D");
                            break;
                        case 2:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("A");
                            break;
                        case 3:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("RACE");
                            break;
                    }
                case 131:
                    switch (value) {
                        case 6:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("LO");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                            break;
                        case 7:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("HI");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                            break;
                        case 8:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("Warn");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-256);
                            break;
                        default:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value + 1)).toString());
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-16777216);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_romeo_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
