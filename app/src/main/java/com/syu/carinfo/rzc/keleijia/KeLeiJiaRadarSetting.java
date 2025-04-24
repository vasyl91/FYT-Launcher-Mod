package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJiaRadarSetting extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    ((CheckedTextView) KeLeiJiaRadarSetting.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 189:
                    if (((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)).setText(R.string.str_388_sound_beep);
                            break;
                        } else {
                            ((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)).setText(R.string.str_boyue_str13);
                            break;
                        }
                    }
                    break;
                case 190:
                    ((CheckedTextView) KeLeiJiaRadarSetting.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_keleijia_radar_setting);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[189] - 1;
                if (value < 0) {
                    value = 1;
                }
                int onoff = DataCanbus.DATA[190];
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[189] + 1;
                if (value > 1) {
                    value = 0;
                }
                int onoff = DataCanbus.DATA[190];
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int onoff;
                int value = DataCanbus.DATA[189];
                int onoff2 = DataCanbus.DATA[190];
                if (onoff2 == 1) {
                    onoff = 0;
                } else {
                    onoff = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[144];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }
}
