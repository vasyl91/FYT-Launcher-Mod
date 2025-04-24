package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class HondaHistoryBActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                case 258:
                    HondaHistoryBActi.this.lastMile();
                    break;
                case 250:
                    HondaHistoryBActi.this.tripA();
                    break;
                case 251:
                    HondaHistoryBActi.this.AveOil();
                    break;
                case 252:
                    HondaHistoryBActi.this.tripA1();
                    break;
                case 253:
                    HondaHistoryBActi.this.tripAOil1();
                    break;
                case 254:
                    HondaHistoryBActi.this.tripA2();
                    break;
                case 255:
                    HondaHistoryBActi.this.tripAOil2();
                    break;
                case 256:
                    HondaHistoryBActi.this.tripA3();
                    break;
                case 257:
                    HondaHistoryBActi.this.tripAOil3();
                    break;
                case 259:
                    HondaHistoryBActi.this.tripA();
                    HondaHistoryBActi.this.tripA1();
                    HondaHistoryBActi.this.tripA2();
                    HondaHistoryBActi.this.tripA3();
                    break;
                case 260:
                    HondaHistoryBActi.this.AveOil();
                    HondaHistoryBActi.this.tripAOil3();
                    break;
                case 261:
                    HondaHistoryBActi.this.tripAOil1();
                    HondaHistoryBActi.this.tripAOil2();
                    HondaHistoryBActi.this.tripAOil3();
                    break;
                case 263:
                    HondaHistoryBActi.this.oilRange();
                    HondaHistoryBActi.this.AveOil();
                    HondaHistoryBActi.this.tripAOil1();
                    HondaHistoryBActi.this.tripAOil2();
                    HondaHistoryBActi.this.tripAOil3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jide_carinfo_b);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(105, new int[]{98, 2}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(100, 4);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.notifyCanbus);
    }

    
    public void tripA() {
        int unit = DataCanbus.DATA[259];
        int value = DataCanbus.DATA[250];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 16777215 || value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " M");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }

    
    public void tripA1() {
        int unit = DataCanbus.DATA[259];
        int value = DataCanbus.DATA[252];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 16777215 || value == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " M");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }

    
    public void tripA2() {
        int unit = DataCanbus.DATA[259];
        int value = DataCanbus.DATA[254];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 16777215 || value == 65535) {
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " M");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }

    
    public void tripA3() {
        int unit = DataCanbus.DATA[259];
        int value = DataCanbus.DATA[256];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 16777215 || value == 65535) {
                ((TextView) findViewById(R.id.tv_text4)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " M");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }

    
    public void oilRange() {
        int value = DataCanbus.DATA[263];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value / 20)).toString());
        }
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value / 10)).toString());
        }
    }

    
    public void AveOil() {
        int value;
        int value2 = DataCanbus.DATA[251];
        int unit = DataCanbus.DATA[260];
        int max = DataCanbus.DATA[263];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.tv_text7)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.layout_view1)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.layout_view1)).setProgress(value);
        }
    }

    
    public void tripAOil1() {
        int value;
        int value2 = DataCanbus.DATA[253];
        int unit = DataCanbus.DATA[260];
        int max = DataCanbus.DATA[263];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.tv_text8)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.layout_view2)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.layout_view2)).setProgress(value);
        }
    }

    
    public void tripAOil2() {
        int value;
        int value2 = DataCanbus.DATA[255];
        int unit = DataCanbus.DATA[260];
        int max = DataCanbus.DATA[263];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.tv_text9)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.layout_view3)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.layout_view3)).setProgress(value);
        }
    }

    
    public void tripAOil3() {
        int value;
        int value2 = DataCanbus.DATA[257];
        int unit = DataCanbus.DATA[260];
        int max = DataCanbus.DATA[263];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value2 == 65535) {
                ((TextView) findViewById(R.id.tv_text10)).setText("--.-");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " KM/L");
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
            }
        }
        if (((ProgressBar) findViewById(R.id.layout_view4)) != null && max > 0) {
            if (value2 < 0 || value2 == 65535) {
                value = 0;
            } else {
                value = (value2 * 21) / max;
            }
            ((ProgressBar) findViewById(R.id.layout_view4)).setProgress(value);
        }
        tripAOil1();
        tripAOil2();
    }

    
    public void lastMile() {
        int value = DataCanbus.DATA[103];
        int unit = DataCanbus.DATA[258];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text11)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value) + " M");
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }
}
