package com.syu.carinfo.luz.binli;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BinliCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.binli.BinliCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (DataCanbus.DATA[123] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 119:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Rpm");
                    break;
                case 120:
                    if (DataCanbus.DATA[123] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 121:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 124:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else if (((DataCanbus.DATA[127] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 125:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else if (((DataCanbus.DATA[127] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[127] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[127] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 126:
                    if (((DataCanbus.DATA[127] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " MPH");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " Km/H");
                    }
                    break;
                case 128:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                    } else if (((DataCanbus.DATA[132] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 129:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 130:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[132] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 131:
                    if (((DataCanbus.DATA[132] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " MPH");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Km/H");
                    }
                    break;
                case 133:
                    int h = (value >> 8) & 255;
                    int m = value & 255;
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(h) + " H" + m + " M");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_binli_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{53, 0}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{59, 0}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{60, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }
}
