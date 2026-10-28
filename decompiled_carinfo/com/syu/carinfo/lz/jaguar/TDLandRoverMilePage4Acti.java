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
public class TDLandRoverMilePage4Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 235:
                    TDLandRoverMilePage4Acti.this.mile_unit = value;
                    break;
                case 236:
                    TDLandRoverMilePage4Acti.this.speed_unit = value;
                    break;
                case 237:
                    TDLandRoverMilePage4Acti.this.fuel_unit = value;
                    break;
                case 238:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage4Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        }
                    }
                    break;
                case 239:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text9)).setText(value + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 240:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage4Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7)).setText(value + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7)).setText(value + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 241:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage4Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 242:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 243:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 244:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 245:
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5)).setText("---");
                            break;
                        }
                    }
                    break;
                case 246:
                case 247:
                case 248:
                case 249:
                case 250:
                    int year = DataCanbus.DATA[246] + 2011;
                    int month = DataCanbus.DATA[247];
                    int day = DataCanbus.DATA[248];
                    int hour2 = DataCanbus.DATA[249];
                    int min2 = DataCanbus.DATA[250];
                    if (TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) TDLandRoverMilePage4Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
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
                data0 = 3;
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
        DataCanbus.PROXY.cmd(0, new int[]{106}, null, null);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
    }
}
