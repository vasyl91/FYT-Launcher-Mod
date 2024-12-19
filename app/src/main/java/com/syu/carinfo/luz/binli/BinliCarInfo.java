package com.syu.carinfo.luz.binli;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BinliCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.binli.BinliCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 52:
                    if (DataCanbus.DATA[57] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Mil");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 53:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Rpm");
                    break;
                case 54:
                    if (DataCanbus.DATA[57] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 55:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 58:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else if (((DataCanbus.DATA[61] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Mil");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 59:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else if (((DataCanbus.DATA[61] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    } else if (((DataCanbus.DATA[61] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                        break;
                    } else if (((DataCanbus.DATA[61] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                        break;
                    }
                case 60:
                    if (((DataCanbus.DATA[61] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " MPH");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " Km/H");
                        break;
                    }
                case 62:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Mil");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 63:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                        break;
                    }
                case 64:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                        break;
                    } else if (((DataCanbus.DATA[66] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                        break;
                    }
                case 65:
                    if (((DataCanbus.DATA[66] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " MPH");
                        break;
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Km/H");
                        break;
                    }
                case 67:
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
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
    }
}
