package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TDLandRoverMilePage1Acti extends BaseActivity {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 177:
                    TDLandRoverMilePage1Acti.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 1 ? R.drawable.ic_btn_oil_on : R.drawable.ic_btn_oil_off);
                    break;
                case 178:
                    TDLandRoverMilePage1Acti.this.mile_unit = value;
                    break;
                case 179:
                    TDLandRoverMilePage1Acti.this.speed_unit = value;
                    break;
                case 180:
                    TDLandRoverMilePage1Acti.this.fuel_unit = value;
                    break;
                case 181:
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
                case 182:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text6)).setText("----");
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text16)).setText("----");
                            break;
                        }
                    }
                    break;
                case 183:
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
                case 184:
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
                case 185:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = value / 3600;
                            int min = (value % 3600) / 60;
                            int sec = value % 60;
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text11)).setText("00 : 00 : 00");
                            break;
                        }
                    }
                    break;
                case 186:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text13)).setText("---");
                            break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text14)).setText("---");
                            break;
                        }
                    }
                    break;
                case 188:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text15)).setText("---");
                            break;
                        }
                    }
                    break;
                case 189:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text4)).setText("----");
                            break;
                        }
                    }
                    break;
                case 190:
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
                case 195:
                    if (((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                            break;
                        } else {
                            ((TextView) TDLandRoverMilePage1Acti.this.findViewById(R.id.tv_text2)).setText("----");
                            break;
                        }
                    }
                    break;
                case 197:
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
                if (DataCanbus.DATA[177] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }
}
