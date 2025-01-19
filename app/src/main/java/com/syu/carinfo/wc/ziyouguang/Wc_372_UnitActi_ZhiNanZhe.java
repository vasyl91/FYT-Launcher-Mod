package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Wc_372_UnitActi_ZhiNanZhe extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 37:
                    Wc_372_UnitActi_ZhiNanZhe.this.mtemp();
                    break;
                case 131:
                    Wc_372_UnitActi_ZhiNanZhe.this.mc1d3();
                    break;
                case 141:
                    Wc_372_UnitActi_ZhiNanZhe.this.mc1d0();
                    break;
                case 161:
                    Wc_372_UnitActi_ZhiNanZhe.this.moil();
                    break;
                case 164:
                    Wc_372_UnitActi_ZhiNanZhe.this.miles();
                    break;
            }
        }
    };
    boolean isCustomSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_unit_zhinanzhe);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.wc_372_unit_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[164] & 255;
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_unit_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[164] & 255;
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_pressure_unit_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141] & 255;
                if (value2 == 0) {
                    value = 2;
                } else if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_pressure_unit_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141] & 255;
                if (value2 == 0) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_temp_unit_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_temp_unit_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_oil_unit_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[161] & 255) - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_oil_unit_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[161] & 255) + 1;
                if (value > 4) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_unitformat_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[131] & 255;
                if (DataCanbus.DATA[1000] == 262516 || DataCanbus.DATA[1000] == 328052) {
                    value = value2 + 1;
                    if (value > 3) {
                        value = 1;
                    }
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_unitformat_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[131] & 255;
                if (DataCanbus.DATA[1000] == 262516 || DataCanbus.DATA[1000] == 328052) {
                    value = value2 - 1;
                    if (value < 1) {
                        value = 3;
                    }
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{7, value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }

    
    public void mtemp() {
        int temp = DataCanbus.DATA[37] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_temp_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℃");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℉");
            } else {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℃");
            }
        }
    }

    protected void miles() {
        int temp = DataCanbus.DATA[164] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText("km");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText("mi");
            } else {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText("km");
            }
        }
    }

    
    public void moil() {
        int temp = DataCanbus.DATA[161] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_oil_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("L/100KM");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("KM/L");
            } else if (value == 3 || value == 4) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            } else {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("L/100KM");
            }
        }
    }

    
    public void mc1d3() {
        int temp = DataCanbus.DATA[131] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_unitformat_text)) != null) {
            this.isCustomSet = false;
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_unitformat_text)).setText(R.string.str_unit_metric);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_unitformat_text)).setText(R.string.str_unit_us_imperial);
            } else if (value == 3) {
                this.isCustomSet = true;
                ((TextView) findViewById(R.id.wc_372_unitformat_text)).setText(R.string.wc_17zhinanzhe_str1);
            } else {
                ((TextView) findViewById(R.id.wc_372_unitformat_text)).setText(R.string.str_unit_metric);
            }
        }
        updateUnitLayout();
    }

    private void updateUnitLayout() {
        findViewById(R.id.wc_372_view_unit).setVisibility(this.isCustomSet ? 0 : 8);
        findViewById(R.id.wc_372_view_pressure_unit).setVisibility(this.isCustomSet ? 0 : 8);
        findViewById(R.id.wc_372_view_temp_unit).setVisibility(this.isCustomSet ? 0 : 8);
        findViewById(R.id.wc_372_view_oil_unit).setVisibility(this.isCustomSet ? 0 : 8);
    }

    
    public void mc1d0() {
        int temp = DataCanbus.DATA[141] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("psi");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("kpa");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("bar");
            } else {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("kpa");
            }
        }
    }
}
