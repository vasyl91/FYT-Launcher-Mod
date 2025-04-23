package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RuiTengOilAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    RuiTengOilAct.this.mUpdateOilUnit();
                    RuiTengOilAct.this.mUpdaterValue4();
                    RuiTengOilAct.this.mUpdateAverageOil3();
                    RuiTengOilAct.this.mUpdateAverageOil2();
                    RuiTengOilAct.this.mUpdateAverageOil1();
                    break;
                case 149:
                    RuiTengOilAct.this.mUpdaterValue3();
                    RuiTengOilAct.this.mUpdateTravelUnit();
                    RuiTengOilAct.this.mUpdateSumTravel();
                    break;
                case 153:
                    RuiTengOilAct.this.mUpdateTravelUnit();
                    RuiTengOilAct.this.mUpdateSumTravel();
                    break;
                case 154:
                    RuiTengOilAct.this.mUpdateOilUnit();
                    RuiTengOilAct.this.mUpdateAverageOil1();
                    break;
                case 155:
                    RuiTengOilAct.this.mUpdateOilUnit();
                    RuiTengOilAct.this.mUpdateAverageOil2();
                    break;
                case 156:
                    RuiTengOilAct.this.mUpdaterValue4();
                    RuiTengOilAct.this.mUpdateOilUnit();
                    RuiTengOilAct.this.mUpdateAverageOil3();
                    break;
                case 157:
                    RuiTengOilAct.this.mUpdateTravelUnit();
                    RuiTengOilAct.this.mUpdateSumTravel();
                    break;
                case 158:
                    RuiTengOilAct.this.mUpdateOilUnit();
                    RuiTengOilAct.this.mUpdateAverageOil3();
                    RuiTengOilAct.this.mUpdateAverageOil2();
                    RuiTengOilAct.this.mUpdateAverageOil1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_oil_page);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue3() {
        int value1 = DataCanbus.DATA[149];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)) != null) {
            if (value1 == 1) {
                int value = DataCanbus.DATA[153];
                int unit = DataCanbus.DATA[157];
                if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)) != null) {
                    if (value == 65535) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText("--.--");
                        return;
                    } else if (unit == 1) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                        return;
                    } else {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                        return;
                    }
                }
                return;
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    
    public void mUpdaterValue4() {
        int value2 = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)) != null) {
            if (value2 == 1) {
                int valueOil1 = DataCanbus.DATA[154];
                int unit = DataCanbus.DATA[158];
                if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)) != null) {
                    if (valueOil1 == 65535) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText("--.--");
                    } else if (unit == 1) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " km/L");
                    } else if (unit == 2) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " L/100km");
                    } else {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " mpg");
                    }
                }
                int valueOil2 = DataCanbus.DATA[155];
                if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)) != null) {
                    if (valueOil2 == 65535) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText("--.--");
                    } else if (unit == 1) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " km/L");
                    } else if (unit == 2) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " L/100km");
                    } else {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " mpg");
                    }
                }
                int valueOil3 = DataCanbus.DATA[156];
                if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)) != null) {
                    if (valueOil3 == 65535) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText("--.--");
                        return;
                    }
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " km/L");
                        return;
                    } else if (unit == 2) {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " L/100km");
                        return;
                    } else {
                        ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " mpg");
                        return;
                    }
                }
                return;
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateSumTravel() {
        int value = DataCanbus.DATA[153];
        int unit = DataCanbus.DATA[157];
        int value1 = DataCanbus.DATA[149];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)) != null) {
            if (value1 == 1) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText("--.--");
                    return;
                } else if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateAverageOil1() {
        int value = DataCanbus.DATA[154];
        int unit = DataCanbus.DATA[158];
        int value2 = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)) != null) {
            if (value2 == 1) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText("--.--");
                    return;
                }
                if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/L");
                    return;
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateAverageOil2() {
        int value = DataCanbus.DATA[155];
        int unit = DataCanbus.DATA[158];
        int value2 = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)) != null) {
            if (value2 == 1) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText("--.--");
                    return;
                }
                if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/L");
                    return;
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateAverageOil3() {
        int value = DataCanbus.DATA[156];
        int unit = DataCanbus.DATA[158];
        int value2 = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)) != null) {
            if (value2 == 1) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText("--.--");
                    return;
                }
                if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/L");
                    return;
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateTravelUnit() {
        int value = DataCanbus.DATA[153];
        int unit = DataCanbus.DATA[157];
        int value1 = DataCanbus.DATA[149];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)) != null) {
            if (value1 == 1) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText("--.--");
                    return;
                } else if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_sum_travel_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }

    void mUpdateOilUnit() {
        int valueOil1 = DataCanbus.DATA[154];
        int valueOil2 = DataCanbus.DATA[155];
        int valueOil3 = DataCanbus.DATA[156];
        int unit = DataCanbus.DATA[158];
        int value2 = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)) != null) {
            if (value2 == 1) {
                if (valueOil1 == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText("--.--");
                } else if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " km/L");
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " L/100km");
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil1 / 10), Integer.valueOf(valueOil1 % 10))) + " mpg");
                }
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil1_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)) != null) {
            if (value2 == 1) {
                if (valueOil2 == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText("--.--");
                } else if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " km/L");
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " L/100km");
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil2 / 10), Integer.valueOf(valueOil2 % 10))) + " mpg");
                }
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil2_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)) != null) {
            if (value2 == 1) {
                if (valueOil3 == 65535) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText("--.--");
                    return;
                }
                if (unit == 1) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " km/L");
                    return;
                } else if (unit == 2) {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " L/100km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(valueOil3 / 10), Integer.valueOf(valueOil3 % 10))) + " mpg");
                    return;
                }
            }
            ((TextView) findViewById(R.id.wc_ruiteng_tv_oil_average_oil3_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
        }
    }
}
