package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class TDLandRoverMilePage6Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 267:
                    TDLandRoverMilePage6Acti.this.mile_unit = value;
                    break;
                case 268:
                    TDLandRoverMilePage6Acti.this.speed_unit = value;
                    break;
                case 269:
                    TDLandRoverMilePage6Acti.this.fuel_unit = value;
                    break;
                case 270:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage6Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        }
                    }
                    break;
                case 271:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text9)).setText(value + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 272:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage6Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)).setText(value + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)).setText(value + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 273:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage6Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 274:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 275:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 276:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 277:
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5)).setText("---");
                            break;
                        }
                    }
                    break;
                case 278:
                case 279:
                case 280:
                case 281:
                case 282:
                    int year = DataCanbus.DATA[278] + 2011;
                    int month = DataCanbus.DATA[279];
                    int day = DataCanbus.DATA[280];
                    int hour2 = DataCanbus.DATA[281];
                    int min2 = DataCanbus.DATA[282];
                    if (TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) TDLandRoverMilePage6Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_mile_page2);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 4;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(2, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(2, new int[]{data0}, null, null);
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{108}, null, null);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
    }
}
