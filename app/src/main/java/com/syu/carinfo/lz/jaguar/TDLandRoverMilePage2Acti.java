package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class TDLandRoverMilePage2Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 203:
                    TDLandRoverMilePage2Acti.this.mile_unit = value;
                    break;
                case 204:
                    TDLandRoverMilePage2Acti.this.speed_unit = value;
                    break;
                case 205:
                    TDLandRoverMilePage2Acti.this.fuel_unit = value;
                    break;
                case 206:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage2Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        }
                    }
                    break;
                case 207:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text9)).setText(value + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 208:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text7) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage2Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text7)).setText(value + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text7)).setText(value + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 209:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage2Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 210:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 211:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 212:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 213:
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text5)).setText("---");
                            break;
                        }
                    }
                    break;
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                    int year = DataCanbus.DATA[214] + 2011;
                    int month = DataCanbus.DATA[215];
                    int day = DataCanbus.DATA[216];
                    int hour2 = DataCanbus.DATA[217];
                    int min2 = DataCanbus.DATA[218];
                    if (TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) TDLandRoverMilePage2Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
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
        DataCanbus.PROXY.cmd(0, new int[]{104}, null, null);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
    }
}
