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
public class RZCLandRoverMilePage7Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 118:
                    RZCLandRoverMilePage7Acti.this.fuel_unit = value;
                    break;
                case 170:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                break;
                        }
                    }
                    break;
                case 171:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                                break;
                        }
                    }
                    break;
                case 172:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 173:
                case 174:
                case 175:
                    if (RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = DataCanbus.DATA[173];
                            int min = DataCanbus.DATA[174];
                            int sec = DataCanbus.DATA[175];
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1)).setText(hour + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 176:
                case 177:
                case 178:
                case 179:
                case 180:
                    int year = DataCanbus.DATA[176] + 2011;
                    int month = DataCanbus.DATA[177];
                    int day = DataCanbus.DATA[178];
                    int hour2 = DataCanbus.DATA[179];
                    int min2 = DataCanbus.DATA[180];
                    if (RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text2)).setText(month + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                        break;
                    }
                case 181:
                    if (RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        }
                    }
                    break;
                case 182:
                    if (RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4)).setText("---");
                            break;
                        }
                    }
                    break;
                case 183:
                    if (RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5)).setText("---");
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
                data0 = 3;
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
        DataCanbus.PROXY.cmd(2, new int[]{86, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }
}
