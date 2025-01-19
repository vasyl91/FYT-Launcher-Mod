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

public class HondaHistoryActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    HondaHistoryActi.this.AveOil();
                    break;
                case 102:
                    HondaHistoryActi.this.tripA();
                    break;
                case 103:
                case 108:
                    HondaHistoryActi.this.lastMile();
                    break;
                case 105:
                    HondaHistoryActi.this.tripAOil1();
                    HondaHistoryActi.this.tripAOil2();
                    HondaHistoryActi.this.tripAOil3();
                    break;
                case 106:
                    HondaHistoryActi.this.AveOil();
                    HondaHistoryActi.this.tripAOil3();
                    break;
                case 107:
                    HondaHistoryActi.this.tripA();
                    HondaHistoryActi.this.tripA1();
                    HondaHistoryActi.this.tripA2();
                    HondaHistoryActi.this.tripA3();
                    break;
                case 109:
                    HondaHistoryActi.this.oilRange();
                    HondaHistoryActi.this.AveOil();
                    HondaHistoryActi.this.tripAOil1();
                    HondaHistoryActi.this.tripAOil2();
                    HondaHistoryActi.this.tripAOil3();
                    break;
                case 110:
                    HondaHistoryActi.this.tripA1();
                    break;
                case 111:
                    HondaHistoryActi.this.tripAOil1();
                    break;
                case 112:
                    HondaHistoryActi.this.tripA2();
                    break;
                case 113:
                    HondaHistoryActi.this.tripAOil2();
                    break;
                case 114:
                    HondaHistoryActi.this.tripA3();
                    break;
                case 115:
                    HondaHistoryActi.this.tripAOil3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jide_carinfo);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (HondaHistoryActi.this.showWCCarInfo()) {
                    DataCanbus.PROXY.cmd(110, new int[]{6, 255}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(105, new int[]{98, 1}, null, null);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(100, 2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    
    public boolean showWCCarInfo() {
        int canbusId = DataCanbus.DATA[1000];
        if ((65535 & canbusId) != 321) {
            return false;
        }
        return true;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
    }

    
    public void tripA() {
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[102];
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
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[110];
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
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[112];
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
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[114];
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
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value / 20)).toString());
        }
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value / 10)).toString());
        }
    }

    
    public void AveOil() {
        int value;
        int value2 = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[106];
        int max = DataCanbus.DATA[109];
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
        int value2 = DataCanbus.DATA[111];
        int unit = DataCanbus.DATA[106];
        int max = DataCanbus.DATA[109];
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
        int value2 = DataCanbus.DATA[113];
        int unit = DataCanbus.DATA[106];
        int max = DataCanbus.DATA[109];
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
        int value2 = DataCanbus.DATA[115];
        int unit = DataCanbus.DATA[106];
        int max = DataCanbus.DATA[109];
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
        int unit = DataCanbus.DATA[108];
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
