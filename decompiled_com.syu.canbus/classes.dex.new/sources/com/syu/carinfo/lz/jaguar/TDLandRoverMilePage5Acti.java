package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TDLandRoverMilePage5Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage5Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 251:
                    TDLandRoverMilePage5Acti.this.mile_unit = value;
                    break;
                case 252:
                    TDLandRoverMilePage5Acti.this.speed_unit = value;
                    break;
                case 253:
                    TDLandRoverMilePage5Acti.this.fuel_unit = value;
                    break;
                case 254:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage5Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        }
                    }
                    break;
                case 255:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text9)).setText("----");
                        }
                    }
                    break;
                case 256:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage5Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 257:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage5Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 258:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                        }
                    }
                    break;
                case 259:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)).setText("---");
                        }
                    }
                    break;
                case 260:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)).setText("---");
                        }
                    }
                    break;
                case 261:
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)).setText("---");
                        }
                    }
                    break;
                case 262:
                case 263:
                case 264:
                case 265:
                case 266:
                    int year = DataCanbus.DATA[262] + 2011;
                    int month = DataCanbus.DATA[263];
                    int day = DataCanbus.DATA[264];
                    int hour2 = DataCanbus.DATA[265];
                    int min2 = DataCanbus.DATA[266];
                    if (((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) TDLandRoverMilePage5Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(month) + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_mile_page2);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427458 */:
                data0 = 4;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(2, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(2, new int[]{data0, 0}, null, null);
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{107}, null, null);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
    }
}
