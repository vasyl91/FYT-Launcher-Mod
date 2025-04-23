package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DJGMKopachBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    DJGMKopachBasicInfoAct.this.updaterOutTemp();
                    break;
                case 137:
                    DJGMKopachBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 187:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km/h");
                        break;
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText("--. km/h");
                        break;
                    }
                case 188:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                        break;
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                        break;
                    }
                case 189:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                        break;
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText("--.- l/100km");
                        break;
                    }
                case 190:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + ":" + min);
                        break;
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText("--:--");
                        break;
                    }
                case 191:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                        break;
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0025_dj_gm_kopach_basic_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{104}, null, null);
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[133];
        int flag = 0;
        if ((value & 128) != 0) {
            value = 256 - value;
            flag = 1;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (flag == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf((320 - (value * 18)) / 10) + "℉");
                return;
            }
        }
        if (flag == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "℃");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText("-" + value + "℃");
        }
    }

    
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
