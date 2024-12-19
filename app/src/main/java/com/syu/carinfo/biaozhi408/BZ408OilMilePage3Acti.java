package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BZ408OilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.BZ408OilMilePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    BZ408OilMilePage3Acti.this.mUpdaterValue1();
                    break;
                case 8:
                    BZ408OilMilePage3Acti.this.mUpdaterValue2();
                    break;
                case 9:
                    BZ408OilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_biaozhi408_oil_page3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.bz408_btn_oil_page3_btn).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408OilMilePage3Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(24, new int[]{3}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(57, new int[]{3}, null, null);
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
            DataCanbus.PROXY.cmd(49, new int[]{2}, null, null);
            DataCanbus.PROXY.cmd(53, new int[]{53}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.PROXY.cmd(57, new int[1], null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        String str;
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)) != null) {
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                if (DataCanbus.DATA[34] == 2) {
                    str = "MPG";
                } else if (DataCanbus.DATA[34] != 0) {
                    str = "L/100KM-KM";
                } else {
                    str = "KM/L-KM";
                }
                if (value > -1 && value < 3001) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + str);
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText("--.--");
                    return;
                }
            }
            if (DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText("--.--");
                    return;
                }
                if (value < 0) {
                    value = 0;
                } else if (value > 3000) {
                    value = 3000;
                }
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
                return;
            }
            if (value == 65535) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)) != null) {
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                if (value > -1 && value < 251) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText(String.valueOf(value) + " Km/h");
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText("--.--");
                    return;
                }
            }
            if (DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText("--.--");
                    return;
                }
                if (value < 0) {
                    value = 0;
                } else if (value > 250) {
                    value = 250;
                }
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText(String.valueOf(value) + " Km/h");
                return;
            }
            if (value == 255) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv2)).setText(String.valueOf(value) + " Km/h");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.bz408_tv_oil_page3_tv3)) != null) {
            if (DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv3)).setText("--.--");
                    return;
                }
                if (value < 0) {
                    value = 0;
                } else if (value > 9999) {
                    value = 9999;
                }
                ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv3)).setText(String.valueOf(value) + " KM");
                return;
            }
            if (value > 9999) {
                value = 9999;
            }
            ((TextView) findViewById(R.id.bz408_tv_oil_page3_tv3)).setText(String.valueOf(value) + " KM");
        }
    }
}
