package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCLandRoverMilePage4Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text9) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text9)).setText(value + "%");
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 118:
                    RZCLandRoverMilePage4Acti.this.fuel_unit = value;
                    break;
                case 156:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6) != null) {
                        switch (RZCLandRoverMilePage4Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text6)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mile");
                                break;
                        }
                    }
                    break;
                case 157:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7) != null) {
                        switch (RZCLandRoverMilePage4Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7)).setText(value + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text7)).setText(value + " mph");
                                break;
                        }
                    }
                    break;
                case 158:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8) != null) {
                        switch (RZCLandRoverMilePage4Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 159:
                case 160:
                case 161:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = DataCanbus.DATA[159];
                            int min = DataCanbus.DATA[160];
                            int sec = DataCanbus.DATA[161];
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                    int year = DataCanbus.DATA[162] + 2011;
                    int month = DataCanbus.DATA[163];
                    int day = DataCanbus.DATA[164];
                    int hour2 = DataCanbus.DATA[165];
                    int min2 = DataCanbus.DATA[166];
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                        break;
                    }
                case 167:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 168:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 169:
                    if (RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage4Acti.this.findViewById(R.id.tv_text5)).setText("---");
                            break;
                        }
                    }
                    break;
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
            DataCanbus.PROXY.cmd(1, new int[]{1, data0}, null, null);
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{86, 2}, null, null);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
    }
}
