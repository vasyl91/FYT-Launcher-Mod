package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCLandRoverMilePage1Acti extends BaseActivity {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)) != null) {
                        switch (RZCLandRoverMilePage1Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText("----");
                        }
                    }
                    break;
                case 100:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)) != null) {
                        switch (RZCLandRoverMilePage1Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText("----");
                        }
                    }
                    break;
                case 102:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)) != null) {
                        switch (RZCLandRoverMilePage1Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText("----");
                        }
                    }
                    break;
                case 118:
                    RZCLandRoverMilePage1Acti.this.fuel_unit = value;
                    break;
                case 212:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)) != null) {
                        switch (RZCLandRoverMilePage1Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                break;
                        }
                    }
                    break;
                case 213:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)) != null) {
                        switch (RZCLandRoverMilePage1Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " mph");
                                break;
                        }
                    }
                    break;
                case 215:
                case 216:
                case 217:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)) != null) {
                        int hour = DataCanbus.DATA[215];
                        int min = DataCanbus.DATA[216];
                        int sec = DataCanbus.DATA[217];
                        ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                    }
                    break;
                case 223:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText("---");
                        }
                    }
                    break;
                case 224:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText("---");
                        }
                    }
                    break;
                case 225:
                    if (((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText("---");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_landrover_mile_page1);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage1Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage1Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RZCLandRoverMilePage1Acti.this.findViewById(R.id.layout_view2).setVisibility(8);
                RZCLandRoverMilePage1Acti.this.findViewById(R.id.layout_view1).setVisibility(0);
                DataCanbus.PROXY.cmd(1, new int[]{1, 6}, null, null);
            }
        });
        findViewById(R.id.tv_text10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage1Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RZCLandRoverMilePage1Acti.this.findViewById(R.id.layout_view1).setVisibility(8);
                RZCLandRoverMilePage1Acti.this.findViewById(R.id.layout_view2).setVisibility(0);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{82, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{86, 6}, null, null);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(0);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
