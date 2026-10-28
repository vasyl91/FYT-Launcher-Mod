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
public class TDLandRoverMilePage3Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 219:
                    TDLandRoverMilePage3Acti.this.mile_unit = value;
                    break;
                case 220:
                    TDLandRoverMilePage3Acti.this.speed_unit = value;
                    break;
                case 221:
                    TDLandRoverMilePage3Acti.this.fuel_unit = value;
                    break;
                case 222:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage3Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        }
                    }
                    break;
                case 223:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text6) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text9)).setText(value + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 224:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text7) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage3Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text7)).setText(value + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text7)).setText(value + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 225:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage3Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 226:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 227:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 228:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 229:
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text5)).setText("---");
                            break;
                        }
                    }
                    break;
                case 230:
                case 231:
                case 232:
                case 233:
                case 234:
                    int year = DataCanbus.DATA[230] + 2011;
                    int month = DataCanbus.DATA[231];
                    int day = DataCanbus.DATA[232];
                    int hour2 = DataCanbus.DATA[233];
                    int min2 = DataCanbus.DATA[234];
                    if (TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) TDLandRoverMilePage3Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
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
                data0 = 2;
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
        DataCanbus.PROXY.cmd(0, new int[]{105}, null, null);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
    }
}
