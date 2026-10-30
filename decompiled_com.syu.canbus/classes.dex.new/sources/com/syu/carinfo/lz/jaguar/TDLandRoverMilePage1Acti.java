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
public class TDLandRoverMilePage1Acti extends BaseActivity {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 189:
                    TDLandRoverMilePage1Acti.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 1 ? R.drawable.ic_btn_oil_on : R.drawable.ic_btn_oil_off);
                    break;
                case 190:
                    TDLandRoverMilePage1Acti.this.mile_unit = value;
                    break;
                case 191:
                    TDLandRoverMilePage1Acti.this.speed_unit = value;
                    break;
                case 192:
                    TDLandRoverMilePage1Acti.this.fuel_unit = value;
                    break;
                case 193:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)) != null) {
                        if (value >= 0 && value <= 262142) {
                            switch (TDLandRoverMilePage1Acti.this.mile_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        }
                    }
                    break;
                case 194:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText("----");
                        }
                    }
                    break;
                case 195:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)) != null) {
                        if (value >= 0 && value <= 509) {
                            switch (TDLandRoverMilePage1Acti.this.speed_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " mph");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                        }
                    }
                    break;
                case 196:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage1Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text5)).setText("----");
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)).setText("00 : 00 : 00");
                        }
                    }
                    break;
                case 198:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText("---");
                        }
                    }
                    break;
                case 199:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText("---");
                        }
                    }
                    break;
                case 200:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText("---");
                        }
                    }
                    break;
                case 201:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText("----");
                        }
                    }
                    break;
                case 202:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage1Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text3)).setText("----");
                            break;
                        }
                    }
                    break;
                case 207:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText("----");
                        }
                    }
                    break;
                case 209:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 999) {
                            switch (TDLandRoverMilePage1Acti.this.fuel_unit) {
                                case 0:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                    break;
                                case 1:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                    break;
                                case 2:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                    break;
                                case 3:
                                    ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                    break;
                            }
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_mile_page1);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage1Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[189] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage1Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TDLandRoverMilePage1Acti.this.findViewById(R.id.layout_view2).setVisibility(8);
                TDLandRoverMilePage1Acti.this.findViewById(R.id.layout_view1).setVisibility(0);
            }
        });
        findViewById(R.id.tv_text10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage1Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TDLandRoverMilePage1Acti.this.findViewById(R.id.layout_view1).setVisibility(8);
                TDLandRoverMilePage1Acti.this.findViewById(R.id.layout_view2).setVisibility(0);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{103}, null, null);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(0);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
    }
}
