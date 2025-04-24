package com.syu.carinfo.honda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCCommpassActi extends BaseActivity {
    int iCompassArea = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    RZCCommpassActi.this.mUpdaterValue1();
                    break;
                case 150:
                    RZCCommpassActi.this.mUpdaterValue2();
                    break;
                case 232:
                    switch (value) {
                        case 0:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_no_delay);
                            break;
                        case 1:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay1);
                            break;
                        case 2:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay2);
                            break;
                        case 3:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay3);
                            break;
                    }
                case 264:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 265:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 266:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 267:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 268:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 325:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_xp_honda_compass);
        if (DataCanbus.DATA[1000] != 3014954 && DataCanbus.DATA[1000] != 3080490 && DataCanbus.DATA[1000] != 3932458 && DataCanbus.DATA[1000] != 4194602 && DataCanbus.DATA[1000] != 4784426 && DataCanbus.DATA[1000] != 4849962 && DataCanbus.DATA[1000] != 3997994) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view7).setVisibility(8);
                break;
        }
        if (DataCanbus.DATA[1000] == 4653354 || DataCanbus.DATA[1000] == 4718890 || DataCanbus.DATA[1000] == 5374250 || DataCanbus.DATA[1000] == 5505322) {
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_aodes_settings).setVisibility(8);
        }
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[232] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[232] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[264] & 255;
                int value1 = DataCanbus.DATA[265] & 255;
                int value2 = DataCanbus.DATA[266] & 255;
                int value3 = DataCanbus.DATA[267] & 255;
                int value4 = DataCanbus.DATA[268] & 255;
                if (value0 == 0) {
                    value0 = 1;
                } else if (value0 == 1) {
                    value0 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[264] & 255;
                int value1 = DataCanbus.DATA[265] & 255;
                int value2 = DataCanbus.DATA[266] & 255;
                int value3 = DataCanbus.DATA[267] & 255;
                int value4 = DataCanbus.DATA[268] & 255;
                if (value1 == 0) {
                    value1 = 1;
                } else if (value1 == 1) {
                    value1 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[264] & 255;
                int value1 = DataCanbus.DATA[265] & 255;
                int value2 = DataCanbus.DATA[266] & 255;
                int value3 = DataCanbus.DATA[267] & 255;
                int value4 = DataCanbus.DATA[268] & 255;
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[264] & 255;
                int value1 = DataCanbus.DATA[265] & 255;
                int value2 = DataCanbus.DATA[266] & 255;
                int value3 = DataCanbus.DATA[267] & 255;
                int value4 = DataCanbus.DATA[268] & 255;
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[264] & 255;
                int value1 = DataCanbus.DATA[265] & 255;
                int value2 = DataCanbus.DATA[266] & 255;
                int value3 = DataCanbus.DATA[267] & 255;
                int value4 = DataCanbus.DATA[268] & 255;
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(103, null, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[150] & 255;
                DataCanbus.PROXY.cmd(104, value == 0 ? 1 : 0);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[325] & 255;
                DataCanbus.PROXY.cmd(110, value == 0 ? 1 : 0);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int i = DataCanbus.DATA[116] & 255;
                if (RZCCommpassActi.this.iCompassArea <= 0) {
                    RZCCommpassActi.this.iCompassArea = 15;
                } else {
                    RZCCommpassActi rZCCommpassActi = RZCCommpassActi.this;
                    rZCCommpassActi.iCompassArea--;
                }
                if (((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)) != null) {
                    ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(RZCCommpassActi.this.iCompassArea).toString());
                }
                int value = RZCCommpassActi.this.iCompassArea;
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int i = DataCanbus.DATA[116] & 255;
                if (RZCCommpassActi.this.iCompassArea >= 15) {
                    RZCCommpassActi.this.iCompassArea = 0;
                } else {
                    RZCCommpassActi.this.iCompassArea++;
                }
                if (((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)) != null) {
                    ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(RZCCommpassActi.this.iCompassArea).toString());
                }
                int value = RZCCommpassActi.this.iCompassArea;
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_Aodes360Settings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_Yage23_AmbientSettings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_DashBord_Settings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_17CRVSettings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
    }

    @Override
    public void addNotify() {
        init();
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[325].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[325].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[116] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[150] & 255;
        if (((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)).setChecked(value == 1);
        }
    }
}
