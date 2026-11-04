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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class HondaWCHistoryBActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.HondaWCHistoryBActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                case 108:
                    HondaWCHistoryBActi.this.lastMile();
                    break;
                case 105:
                    HondaWCHistoryBActi.this.tripAOil1();
                    HondaWCHistoryBActi.this.tripAOil2();
                    HondaWCHistoryBActi.this.tripAOil3();
                    break;
                case 106:
                    HondaWCHistoryBActi.this.AveOil();
                    HondaWCHistoryBActi.this.tripAOil3();
                    break;
                case 107:
                    HondaWCHistoryBActi.this.tripA();
                    HondaWCHistoryBActi.this.tripA1();
                    HondaWCHistoryBActi.this.tripA2();
                    HondaWCHistoryBActi.this.tripA3();
                    break;
                case 109:
                    HondaWCHistoryBActi.this.oilRange();
                    HondaWCHistoryBActi.this.AveOil();
                    HondaWCHistoryBActi.this.tripAOil1();
                    HondaWCHistoryBActi.this.tripAOil2();
                    HondaWCHistoryBActi.this.tripAOil3();
                    break;
                case 214:
                    HondaWCHistoryBActi.this.AveOil();
                    break;
                case 215:
                    HondaWCHistoryBActi.this.tripA();
                    break;
                case 216:
                    HondaWCHistoryBActi.this.tripA1();
                    break;
                case 217:
                    HondaWCHistoryBActi.this.tripAOil1();
                    break;
                case 218:
                    HondaWCHistoryBActi.this.tripA2();
                    break;
                case 219:
                    HondaWCHistoryBActi.this.tripAOil2();
                    break;
                case 220:
                    HondaWCHistoryBActi.this.tripA3();
                    break;
                case 221:
                    HondaWCHistoryBActi.this.tripAOil3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jide_wccarinfo_b);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.HondaWCHistoryBActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(110, new int[]{22, 255}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tripA() {
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[215];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripA1() {
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[216];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripA2() {
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[218];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripA3() {
        int unit = DataCanbus.DATA[107];
        int value = DataCanbus.DATA[220];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void oilRange() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value / 20)).toString());
        }
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value / 10)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AveOil() {
        int value;
        int value2 = DataCanbus.DATA[214];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripAOil1() {
        int value;
        int value2 = DataCanbus.DATA[217];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripAOil2() {
        int value;
        int value2 = DataCanbus.DATA[219];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tripAOil3() {
        int value;
        int value2 = DataCanbus.DATA[221];
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

    /* JADX INFO: Access modifiers changed from: private */
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
